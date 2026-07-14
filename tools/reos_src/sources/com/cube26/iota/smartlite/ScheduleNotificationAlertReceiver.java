package com.cube26.iota.smartlite;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.app.ag;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.util.e;
import com.cube26.iota.smartlite.util.h;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class ScheduleNotificationAlertReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f3130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.cube26.iota.smartlite.a.a f3131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3132c = R.drawable.lite;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3133d;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        CLog.a("IOTA", " on receive schedule notification");
        this.f3131b = new com.cube26.iota.smartlite.a.a(context);
        String string = context.getString(R.string.app_name);
        CLog.a("IOTA", " on boot");
        if (intent.getAction() != null) {
            CLog.a("IOTA", " intent action " + intent.getAction());
            if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                e.b(context);
                CLog.a("IOTA", " on reboot :: reset all alarms ");
                Cursor cursorA = this.f3131b.a("schedule", new String[]{Constants.SMS_COLUMN_ID, "schedule_time", "schedule_notification_mins", "schedule_repeat"}, "schedule_notification_type != ? ", new String[]{"Alert never"}, null, null, null);
                cursorA.moveToFirst();
                while (!cursorA.isAfterLast()) {
                    String string2 = cursorA.getString(cursorA.getColumnIndex("schedule_repeat"));
                    long j = Long.parseLong(cursorA.getString(cursorA.getColumnIndex("schedule_time")));
                    int i = cursorA.getInt(cursorA.getColumnIndex("schedule_notification_mins"));
                    this.f3133d = cursorA.getInt(cursorA.getColumnIndex(Constants.SMS_COLUMN_ID));
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(j);
                    long jB = h.b(string2, calendar.get(11), calendar.get(12), i);
                    CLog.a("IOTA", "nextSetDayTime " + jB);
                    h.a(context, this.f3133d, jB - ((long) ((i * 60) * 1000)));
                    cursorA.moveToNext();
                }
                return;
            }
            this.f3130a = (NotificationManager) context.getSystemService("notification");
            this.f3131b = new com.cube26.iota.smartlite.a.a(context);
            this.f3133d = intent.getIntExtra("scheduleNotificationId", -1);
            CLog.a("IOTA", " scheduleNotificationId " + this.f3133d);
            if (this.f3133d == -1) {
                return;
            }
            Cursor cursorA2 = this.f3131b.a("schedule", new String[]{"schedule_lite_address", "schedule_mode", "schedule_notification_mins", "schedule_repeat", "schedule_time"}, "_id = ?", new String[]{String.valueOf(this.f3133d)}, null, null, null);
            if (cursorA2.getCount() == 0) {
                h.a(context, this.f3133d);
                return;
            }
            cursorA2.moveToFirst();
            String string3 = cursorA2.getString(cursorA2.getColumnIndex("schedule_lite_address"));
            String str = cursorA2.getInt(cursorA2.getColumnIndex("schedule_mode")) == 1 ? "ON" : "OFF";
            int i2 = cursorA2.getInt(cursorA2.getColumnIndex("schedule_notification_mins"));
            String string4 = cursorA2.getString(cursorA2.getColumnIndex("schedule_repeat"));
            String strB = this.f3131b.b(string3);
            long j2 = Long.parseLong(cursorA2.getString(cursorA2.getColumnIndex("schedule_time")));
            String str2 = strB + " will turn " + str + " in " + i2 + " mins ";
            CLog.a("IOTA", " schedule notification message  :: " + str2);
            Notification notificationA = new ag.d(context).a(R.drawable.lite).a(string).b(str2).c(Color.parseColor("#F5B700")).a();
            Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
            intent2.setFlags(603979776);
            PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent2, 0);
            notificationA.flags |= 16;
            notificationA.defaults |= 1;
            notificationA.defaults |= 2;
            this.f3130a.notify((int) (Math.random() * 10.0d), notificationA);
            CLog.a("IOTA", "notified");
            if (Integer.parseInt(string4) == 0) {
                CLog.a("IOTA", "canceling current intent");
                h.a(context, this.f3133d);
                return;
            }
            CLog.a("IOTA", "updating current intent");
            CLog.a("IOTA", " current pending intent update :: " + string4);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            long jB2 = h.b(string4, calendar2.get(11), calendar2.get(12), i2) - ((long) ((i2 * 60) * 1000));
            CLog.a("IOTA", "nextSetDayTime " + jB2);
            Intent intent3 = new Intent(context, (Class<?>) ScheduleNotificationAlertReceiver.class);
            intent.putExtra("scheduleNotificationId", String.valueOf(this.f3133d));
            ((AlarmManager) context.getSystemService("alarm")).set(0, jB2, PendingIntent.getBroadcast(context, this.f3133d, intent3, 134217728));
        }
    }
}
