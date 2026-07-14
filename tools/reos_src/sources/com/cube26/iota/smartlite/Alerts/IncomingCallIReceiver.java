package com.cube26.iota.smartlite.Alerts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.a.a;
import com.cube26.iota.smartlite.c.c;
import com.cube26.iota.smartlite.c.d;
import com.cube26.iota.smartlite.util.h;

/* JADX INFO: loaded from: classes.dex */
public class IncomingCallIReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f2952a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f2955d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2953b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2954c = false;

    private String a(String str, Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, null, null, null);
        if (cursorQuery.getCount() <= 0) {
            return null;
        }
        cursorQuery.moveToFirst();
        return cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
    }

    private void a(Cursor cursor) {
        if (d.f3309f != null) {
            if (d.f3309f.isChecked()) {
                d.f3309f.setChecked(false);
                f2953b = true;
            } else {
                f2953b = false;
            }
        }
        if (h.N) {
            f2954c = true;
        } else {
            f2954c = false;
        }
        boolean z = false;
        if (d.k != null && d.k.isChecked()) {
            z = true;
        }
        boolean z2 = (d.i == null || !d.i.isChecked()) ? z : true;
        h.b();
        h.a(0, 0, 0);
        CLog.b("IOTA", "cursor count in execute" + cursor.getCount());
        String string = cursor.getString(cursor.getColumnIndex("alert_transition"));
        int i = cursor.getInt(cursor.getColumnIndex("alert_color"));
        int[] iArrA = h.a(i);
        CLog.a("IOTA", "alert color " + i);
        CLog.a("IOTA", "alert_transition " + string + "contact" + cursor.getString(cursor.getColumnIndex("alert_contact_number")));
        for (int i2 = 0; i2 < h.v.size(); i2++) {
            CLog.a("IOTA", " index : " + i2);
            if (h.v.get(i2).o() == null || !h.v.get(i2).o().equals("1.04") || !string.equals("Strobe")) {
                if (z2) {
                    h.b(0, 0, 0, 200, i2, "on");
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                if (string.equalsIgnoreCase("strobe")) {
                    CLog.a("IOTA", "red : " + h.J[0] + " " + h.J[1] + " " + h.J[2]);
                    h.a(h.J[0], h.J[1], h.J[2], h.H, i2, "wheel");
                } else {
                    CLog.a("IOTA", "red : " + h.K[0] + " " + h.K[1] + " " + h.K[2]);
                    h.a(iArrA[0], iArrA[1], iArrA[2], h.H, i2, "Phone", string);
                }
            } else if (z2) {
                h.b(0, 0, 0, 200, i2, "on");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                h.a(255, 255, 255, h.H, i2, "wheel");
            } else {
                CLog.a("IOTA", "red : " + h.J[0] + " " + h.J[1] + " " + h.J[2]);
                h.a(h.J[0], h.J[1], h.J[2], h.H, i2, "wheel");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Cursor cursorA = null;
        if (Build.VERSION.SDK_INT <= 22) {
            f2952a = intent.getStringExtra("state");
            CLog.a("IOTA", "state" + f2952a);
            a aVar = new a(context);
            if (TelephonyManager.EXTRA_STATE_RINGING.equals(f2952a)) {
                f2955d++;
                if (f2955d == 1) {
                    String str = ". Incoming number is " + intent.getStringExtra("incoming_number");
                    CLog.a("IOTA", "Incoming Number is" + str);
                    String strA = a(str, context);
                    if (strA != null) {
                        cursorA = aVar.a(strA, 1);
                        CLog.a("IOTA", "alerts count " + cursorA.getCount());
                    }
                    if (cursorA == null || cursorA.getCount() <= 0) {
                        Cursor cursorA2 = aVar.a("Anyone", 1);
                        if (cursorA2.getCount() > 0) {
                            cursorA2.moveToFirst();
                            if (cursorA2.getInt(cursorA2.getColumnIndex("alert_status")) == 1) {
                                CLog.a("IOTA", "alert ON");
                                a(cursorA2);
                            }
                        }
                    } else {
                        cursorA.moveToFirst();
                        while (!cursorA.isAfterLast()) {
                            String string = cursorA.getString(cursorA.getColumnIndex("alert_contact_number"));
                            CLog.a("IOTA", "alerts count " + string);
                            if (PhoneNumberUtils.compare(str, string)) {
                                CLog.a("IOTA", "alert match found");
                                if (cursorA.getInt(cursorA.getColumnIndex("alert_status")) == 1) {
                                    CLog.a("IOTA", "alert ON");
                                    a(cursorA);
                                    break;
                                }
                                CLog.a("IOTA", "alert OFF");
                                Cursor cursorA3 = aVar.a("Anyone", 1);
                                if (cursorA3.getCount() > 0) {
                                    cursorA3.moveToFirst();
                                    if (cursorA3.getInt(cursorA3.getColumnIndex("alert_status")) == 1) {
                                        CLog.a("IOTA", "alert ON");
                                        a(cursorA3);
                                    }
                                }
                            }
                            cursorA.moveToNext();
                        }
                    }
                }
            } else if (f2952a.equalsIgnoreCase("idle")) {
                if (f2953b && d.f3309f != null) {
                    d.f3309f.setChecked(true);
                }
                h.L = false;
                CLog.a("IOTA", "idle state" + c.f3274e);
                f2955d = 0;
                for (int i = 0; i < h.v.size(); i++) {
                    h.b(h.E.nextInt(255), h.E.nextInt(255), h.E.nextInt(255), 200, i, "PhoneCancelWait");
                }
            }
            if (f2952a.equalsIgnoreCase("offhook")) {
                if (f2953b && d.f3309f != null) {
                    d.f3309f.setChecked(true);
                }
                h.L = false;
                CLog.a("IOTA", "offhook state");
                f2955d = 0;
                for (int i2 = 0; i2 < h.v.size(); i2++) {
                    h.b(h.E.nextInt(255), h.E.nextInt(255), h.E.nextInt(255), 200, i2, "PhoneCancelWait");
                }
                return;
            }
            return;
        }
        if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            CLog.a("IOTA", "receiver ::: phone state permission already granted ");
            f2952a = intent.getStringExtra("state");
            CLog.a("IOTA", "state" + f2952a);
            a aVar2 = new a(context);
            if (TelephonyManager.EXTRA_STATE_RINGING.equals(f2952a)) {
                f2955d++;
                if (f2955d == 1) {
                    if (context.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
                        String stringExtra = intent.getStringExtra("incoming_number");
                        CLog.a("IOTA", "Incoming Number is" + stringExtra);
                        String strA2 = a(stringExtra, context);
                        if (strA2 != null) {
                            cursorA = aVar2.a(strA2, 1);
                            CLog.a("IOTA", "alerts count " + cursorA.getCount());
                        }
                        if (cursorA == null || cursorA.getCount() <= 0) {
                            Cursor cursorA4 = aVar2.a("Anyone", 1);
                            if (cursorA4.getCount() > 0) {
                                cursorA4.moveToFirst();
                                if (cursorA4.getInt(cursorA4.getColumnIndex("alert_status")) == 1) {
                                    CLog.a("IOTA", "alert ON");
                                    a(cursorA4);
                                }
                            }
                        } else {
                            cursorA.moveToFirst();
                            while (!cursorA.isAfterLast()) {
                                String string2 = cursorA.getString(cursorA.getColumnIndex("alert_contact_number"));
                                CLog.a("IOTA", "alerts count " + string2);
                                if (PhoneNumberUtils.compare(stringExtra, string2)) {
                                    CLog.a("IOTA", "alert match found");
                                    if (cursorA.getInt(cursorA.getColumnIndex("alert_status")) == 1) {
                                        CLog.a("IOTA", "alert ON");
                                        a(cursorA);
                                        break;
                                    }
                                    CLog.a("IOTA", "alert OFF");
                                    Cursor cursorA5 = aVar2.a("Anyone", 1);
                                    if (cursorA5.getCount() > 0) {
                                        cursorA5.moveToFirst();
                                        if (cursorA5.getInt(cursorA5.getColumnIndex("alert_status")) == 1) {
                                            CLog.a("IOTA", "alert ON");
                                            a(cursorA5);
                                        }
                                    }
                                }
                                cursorA.moveToNext();
                            }
                        }
                    } else {
                        CLog.a("IOTA", "alert OFF");
                        Cursor cursorA6 = aVar2.a("Anyone", 1);
                        if (cursorA6.getCount() > 0) {
                            cursorA6.moveToFirst();
                            if (cursorA6.getInt(cursorA6.getColumnIndex("alert_status")) == 1) {
                                CLog.a("IOTA", "alert ON");
                                a(cursorA6);
                            }
                        }
                    }
                }
            } else if (f2952a.equalsIgnoreCase("idle")) {
                if (f2953b && d.f3309f != null) {
                    d.f3309f.setChecked(true);
                }
                h.L = false;
                CLog.a("IOTA", "idle state" + c.f3274e);
                f2955d = 0;
                for (int i3 = 0; i3 < h.v.size(); i3++) {
                    h.b(h.E.nextInt(255), h.E.nextInt(255), h.E.nextInt(255), 200, i3, "PhoneCancelWait");
                }
            }
            if (f2952a.equalsIgnoreCase("offhook")) {
                if (f2953b && d.f3309f != null) {
                    d.f3309f.setChecked(true);
                }
                h.L = false;
                CLog.a("IOTA", "offhook state");
                f2955d = 0;
                for (int i4 = 0; i4 < h.v.size(); i4++) {
                    h.b(h.E.nextInt(255), h.E.nextInt(255), h.E.nextInt(255), 200, i4, "PhoneCancelWait");
                }
            }
        }
    }
}
