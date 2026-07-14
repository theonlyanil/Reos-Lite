package com.cube26.iota.smartlite.Alerts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsMessage;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.a.a;
import com.cube26.iota.smartlite.util.h;

/* JADX INFO: loaded from: classes.dex */
public class IncomingSmsReceiver extends BroadcastReceiver {
    private String a(String str, Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, null, null, null);
        if (cursorQuery.getCount() <= 0) {
            return null;
        }
        cursorQuery.moveToFirst();
        return cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
    }

    private void a(Cursor cursor) {
        CLog.b("IOTA", "cursor count in execute" + cursor.getCount());
        String string = cursor.getString(cursor.getColumnIndex("alert_transition"));
        int[] iArrA = h.a(cursor.getInt(cursor.getColumnIndex("alert_color")));
        for (int i = 0; i < h.v.size(); i++) {
            h.a(iArrA[0], iArrA[1], iArrA[2], h.H, i, "Phone", string);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Cursor cursorA = null;
        Bundle extras = intent.getExtras();
        String str = "";
        if (extras != null) {
            Object[] objArr = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
            int i = 0;
            String str2 = null;
            while (i < smsMessageArr.length) {
                smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                String originatingAddress = smsMessageArr[i].getOriginatingAddress();
                String displayOriginatingAddress = smsMessageArr[i].getDisplayOriginatingAddress();
                i++;
                str = originatingAddress;
                str2 = displayOriginatingAddress;
            }
            CLog.a("IOTA", " message content :: " + SmsMessage.createFromPdu((byte[]) objArr[0]).getMessageBody());
            CLog.a("IOTA", "Message Received from " + str);
            CLog.a("IOTA", " sender :: " + str2);
            a aVar = new a(context);
            if (str2.contains("OLACAB")) {
                CLog.a("IOTA", " executing ola alert");
                Cursor cursorD = aVar.d(7);
                cursorD.moveToFirst();
                if (cursorD.getCount() > 0) {
                    a(cursorD);
                    return;
                }
                return;
            }
            if (Build.VERSION.SDK_INT <= 22) {
                CLog.a("IOTA", "Incoming Number is" + str);
                String strA = a(str, context);
                if (strA != null) {
                    cursorA = aVar.a(strA, 2);
                    CLog.a("IOTA", "alerts count " + cursorA.getCount());
                }
                if (cursorA == null || cursorA.getCount() <= 0) {
                    Cursor cursorA2 = aVar.a("Anyone", 2);
                    if (cursorA2 == null || cursorA2.getCount() <= 0) {
                        return;
                    }
                    cursorA2.moveToFirst();
                    if (cursorA2.getInt(cursorA2.getColumnIndex("alert_status")) == 1) {
                        CLog.a("IOTA", "alert ON");
                        a(cursorA2);
                        return;
                    }
                    return;
                }
                cursorA.moveToFirst();
                while (!cursorA.isAfterLast()) {
                    String string = cursorA.getString(cursorA.getColumnIndex("alert_contact_number"));
                    CLog.a("IOTA", "alerts count " + string);
                    if (PhoneNumberUtils.compare(str, string)) {
                        CLog.a("IOTA", "alert match found");
                        if (cursorA.getInt(cursorA.getColumnIndex("alert_status")) == 1) {
                            CLog.a("IOTA", "alert ON");
                            a(cursorA);
                            return;
                        }
                        CLog.a("IOTA", "alert OFF");
                        Cursor cursorA3 = aVar.a("Anyone", 2);
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
                return;
            }
            if (context.checkSelfPermission("android.permission.READ_CONTACTS") != 0) {
                Cursor cursorA4 = aVar.a("Anyone", 2);
                if (cursorA4.getCount() > 0) {
                    cursorA4.moveToFirst();
                    if (cursorA4.getInt(cursorA4.getColumnIndex("alert_status")) == 1) {
                        CLog.a("IOTA", "alert ON");
                        a(cursorA4);
                        return;
                    }
                    return;
                }
                return;
            }
            CLog.a("IOTA", "Incoming Number is" + str);
            String strA2 = a(str, context);
            if (strA2 != null) {
                cursorA = aVar.a(strA2, 2);
                CLog.a("IOTA", "alerts count " + cursorA.getCount());
            }
            if (cursorA == null || cursorA.getCount() <= 0) {
                Cursor cursorA5 = aVar.a("Anyone", 2);
                if (cursorA5.getCount() > 0) {
                    cursorA5.moveToFirst();
                    if (cursorA5.getInt(cursorA5.getColumnIndex("alert_status")) == 1) {
                        CLog.a("IOTA", "alert ON");
                        a(cursorA5);
                        return;
                    }
                    return;
                }
                return;
            }
            cursorA.moveToFirst();
            while (!cursorA.isAfterLast()) {
                String string2 = cursorA.getString(cursorA.getColumnIndex("alert_contact_number"));
                CLog.a("IOTA", "alerts count " + string2);
                if (PhoneNumberUtils.compare(str, string2)) {
                    CLog.a("IOTA", "alert match found");
                    if (cursorA.getInt(cursorA.getColumnIndex("alert_status")) == 1) {
                        CLog.a("IOTA", "alert ON");
                        a(cursorA);
                        return;
                    }
                    CLog.a("IOTA", "alert OFF");
                    Cursor cursorA6 = aVar.a("Anyone", 2);
                    if (cursorA6.getCount() > 0) {
                        cursorA6.moveToFirst();
                        if (cursorA6.getInt(cursorA6.getColumnIndex("alert_status")) == 1) {
                            CLog.a("IOTA", "alert ON");
                            a(cursorA6);
                        }
                    }
                }
                cursorA.moveToNext();
            }
        }
    }
}
