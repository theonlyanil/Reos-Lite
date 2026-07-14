package com.cube26.iota.smartlite;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.AlertViews.FacebookAlertActivity;
import com.cube26.iota.smartlite.util.h;

/* JADX INFO: loaded from: classes.dex */
public class NotificationListener extends NotificationListenerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3120a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3121b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.cube26.iota.smartlite.a.a f3122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f3123d = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Cursor cursor) {
        CLog.b("IOTA", "cursor count in execute" + cursor.getCount());
        String string = cursor.getString(cursor.getColumnIndex("alert_transition"));
        int i = cursor.getInt(cursor.getColumnIndex("alert_color"));
        int[] iArrA = h.a(i);
        CLog.a("IOTA", "alert color " + i);
        CLog.a("IOTA", "alert_transition " + string + "contact" + cursor.getString(cursor.getColumnIndex("alert_contact_number")));
        for (int i2 = 0; i2 < h.v.size(); i2++) {
            h.a(iArrA[0], iArrA[1], iArrA[2], 200, i2, "Phone", string);
        }
    }

    private void a(String str, int i) {
        final Cursor cursorD = (i == 8 || i == 7 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15) ? this.f3122c.d(i) : this.f3122c.a(str, i);
        CLog.a("IOTA", " fetch alert cursor :: " + cursorD.getCount());
        if (cursorD == null || cursorD.getCount() <= 0) {
            CLog.a("IOTA", "checking alert for anyone");
            final Cursor cursorA = this.f3122c.a("Anyone", i);
            if (cursorA.getCount() > 0) {
                cursorA.moveToFirst();
                if (cursorA.getInt(cursorA.getColumnIndex("alert_status")) == 1) {
                    CLog.a("IOTA", "alert ON");
                    this.f3123d.postDelayed(new Runnable() { // from class: com.cube26.iota.smartlite.NotificationListener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NotificationListener.this.a(cursorA);
                        }
                    }, 2000L);
                    return;
                }
                return;
            }
            return;
        }
        cursorD.moveToFirst();
        while (!cursorD.isAfterLast()) {
            if (cursorD.getInt(cursorD.getColumnIndex("alert_status")) == 1) {
                CLog.a("IOTA", "alert ON");
                this.f3123d.postDelayed(new Runnable() { // from class: com.cube26.iota.smartlite.NotificationListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NotificationListener.this.a(cursorD);
                    }
                }, 2000L);
                return;
            }
            CLog.a("IOTA", "alert OFF");
            final Cursor cursorA2 = this.f3122c.a("Anyone", i);
            if (cursorA2.getCount() > 0) {
                cursorA2.moveToFirst();
                if (cursorA2.getInt(cursorA2.getColumnIndex("alert_status")) == 1) {
                    CLog.a("IOTA", "alert ON");
                    this.f3123d.postDelayed(new Runnable() { // from class: com.cube26.iota.smartlite.NotificationListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            NotificationListener.this.a(cursorA2);
                        }
                    }, 2000L);
                }
            }
            cursorD.moveToNext();
        }
    }

    private void a(String str, String str2) {
        CLog.a("IOTA", "execute fb alert");
        Cursor cursorA = this.f3122c.a(str, str2, 9);
        CLog.a("IOTA", " fb cursor count :: " + cursorA.getCount());
        cursorA.moveToFirst();
        while (!cursorA.isAfterLast()) {
            a(cursorA);
            cursorA.moveToNext();
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        CLog.a("IOTA", "listener connected");
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0334 A[PHI: r2
      0x0334: PHI (r2v5 java.lang.String) = (r2v3 java.lang.String), (r2v4 java.lang.String), (r2v6 java.lang.String) binds: [B:75:0x0328, B:69:0x0307, B:59:0x02d5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        String str;
        String str2;
        CLog.a("IOTA", " notification posted");
        this.f3122c = new com.cube26.iota.smartlite.a.a(getApplicationContext());
        String packageName = statusBarNotification.getPackageName();
        CLog.a("IOTA", " package name :: " + packageName);
        String string = statusBarNotification.getNotification().tickerText.toString();
        CLog.a("IOTA", " package name :: " + packageName + " tickerText :: " + string);
        String str3 = "";
        switch (h.i.get(packageName).intValue()) {
            case 5:
                String strSubstring = string.substring("Message from ".length(), string.length());
                CLog.a("IOTA", " contact name :: " + strSubstring);
                if (!string.contains("Missed call")) {
                    a(strSubstring, 5);
                }
                break;
            case 6:
                String strSubstring2 = string.substring(0, string.indexOf("-") - 1);
                CLog.a("IOTA", "contact name :: " + strSubstring2);
                a(strSubstring2, 6);
                break;
            case 7:
                a((String) null, 7);
                break;
            case 8:
                CLog.a("IOTA", "uber alert");
                if (string.contains("Your Uber is arriving")) {
                    a((String) null, 8);
                }
                break;
            case 9:
                CLog.a("IOTA", " fb notification ::" + string);
                if (string.contains("sent you a friend request")) {
                    str = FacebookAlertActivity.f2906b[4];
                    str2 = "null";
                } else if (string.contains("tagged you in")) {
                    str = FacebookAlertActivity.f2906b[1];
                    str2 = "null";
                    if (string.contains("post")) {
                        str2 = FacebookAlertActivity.f2905a[2];
                    }
                } else if (string.contains("accepted your friend request")) {
                    str = FacebookAlertActivity.f2906b[5];
                    str2 = "null";
                } else if (string.contains("posted on your Timeline")) {
                    str = FacebookAlertActivity.f2906b[7];
                    str2 = "null";
                } else if (string.contains("poked you")) {
                    str = FacebookAlertActivity.f2906b[6];
                    str2 = "null";
                } else if (string.contains("sent you a message")) {
                    str = FacebookAlertActivity.f2906b[3];
                    str2 = "null";
                } else if (string.contains("commented")) {
                    str3 = FacebookAlertActivity.f2906b[0];
                    if (string.contains("on your photo")) {
                        str2 = FacebookAlertActivity.f2905a[0];
                        str = str3;
                    } else if (string.contains("on your video")) {
                        str2 = FacebookAlertActivity.f2905a[1];
                        str = str3;
                    } else if (string.contains("on your post")) {
                        str2 = FacebookAlertActivity.f2905a[2];
                        str = str3;
                    } else if (string.contains("on your link")) {
                        str2 = FacebookAlertActivity.f2905a[4];
                        str = str3;
                    } else {
                        str2 = "";
                        str = str3;
                    }
                } else if (string.contains("shared")) {
                    str3 = FacebookAlertActivity.f2906b[2];
                    if (string.contains("links on your") || string.contains("link on your")) {
                        str2 = FacebookAlertActivity.f2905a[4];
                        str = str3;
                    } else if (string.contains("post")) {
                        str2 = FacebookAlertActivity.f2905a[2];
                        str = str3;
                    } else {
                        str2 = "";
                        str = str3;
                    }
                } else if (string.contains("was with you")) {
                    str = FacebookAlertActivity.f2906b[1];
                    str2 = FacebookAlertActivity.f2905a[0];
                } else if (string.contains("mentioned you in a comment")) {
                    str = FacebookAlertActivity.f2906b[1];
                    str2 = FacebookAlertActivity.f2905a[3];
                } else {
                    str2 = "";
                    str = str3;
                }
                CLog.a("IOTA", " fb alert action  :: " + str + " fb alert attribute :: " + str2);
                if (!str.equals("") && !str.equals("")) {
                    a(str, str2);
                }
                break;
            case 10:
                a(FacebookAlertActivity.f2906b[3], "null");
                break;
            case 11:
                CLog.a("IOTA", " tinder alert");
                if (string.contains("You have a new Tinder Match")) {
                    a((String) null, 11);
                }
                break;
            case 12:
                String strSubstring3 = string.substring(0, string.indexOf("-") - 1);
                CLog.a("IOTA", "contact name :: " + strSubstring3);
                a(strSubstring3, 12);
                break;
            case 13:
                String strSubstring4 = string.substring(0, string.indexOf("-") - 1);
                CLog.a("IOTA", "contact name :: " + strSubstring4);
                a(strSubstring4, 13);
                break;
            case 14:
                String strSubstring5 = string.substring(0, string.indexOf("-") - 1);
                CLog.a("IOTA", "contact name :: " + strSubstring5);
                a(strSubstring5, 14);
                break;
            case 15:
                String strSubstring6 = string.substring(0, string.indexOf("-") - 1);
                CLog.a("IOTA", "contact name :: " + strSubstring6);
                a(strSubstring6, 15);
                break;
        }
        CLog.a("IOTA", " package name :: " + packageName + " tickerText :: " + string);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        super.onNotificationRemoved(statusBarNotification);
        CLog.a("IOTA", " notification removed");
    }
}
