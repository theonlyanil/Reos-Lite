package com.android.library.appusage.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.appusage.receivers.AppUsageAlarmReceiver;
import com.android.library.appusage.receivers.UsageTrackReceiver;
import com.android.library.userprofile.util.UtilFunctions;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2592a = "DAILY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2593b = "WEEKLY";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f2594c = UtilFunctions.MONTHLY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f2595d = "YEARLY";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f2596e = 1234;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f2597f = 4321;

    public static void a(long j, Context context, int i) {
        if (i == f2596e) {
            Intent intent = new Intent(context, (Class<?>) UsageTrackReceiver.class);
            intent.putExtra("com.android.appusage.intentextra.usage", "com.android.appusage.usagetrack.start");
            ((AlarmManager) context.getSystemService("alarm")).set(0, j, PendingIntent.getBroadcast(context, 9877, intent, 134217728));
            return;
        }
        if (i == f2597f) {
            Intent intent2 = new Intent(context, (Class<?>) UsageTrackReceiver.class);
            intent2.putExtra("com.android.appusage.intentextra.usage", "com.android.appusage.usagetrack.stop");
            ((AlarmManager) context.getSystemService("alarm")).set(0, j, PendingIntent.getBroadcast(context, 9877, intent2, 134217728));
        }
    }

    public static void a(Context context) {
        if (i(context)) {
            CLog.a(a.f2571a, "alarm already set for applist alarm ");
            return;
        }
        String str = Config.getInstance(context).get("appUsageLib.appListFrequency");
        CLog.a(a.f2571a, "init applist alarm type : " + str);
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeInstalledApps");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 9875, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        if (str.equals(f2594c)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 2592000000L, broadcast);
            return;
        }
        if (str.equals(f2592a)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 86400000L, broadcast);
            return;
        }
        if (str.equals(f2593b)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 604800000L, broadcast);
        } else if (str.equals(f2595d)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 31536000000L, broadcast);
        } else {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 2592000000L, broadcast);
        }
    }

    public static void a(Context context, int i, int i2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context, (Class<?>) UsageTrackReceiver.class);
        intent.putExtra("com.android.appusage.intentextra.usage", i2);
        alarmManager.cancel(PendingIntent.getBroadcast(context, i, intent, 134217728));
    }

    public static void a(ArrayList<com.android.library.appusage.a.d> arrayList, Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HHmm");
        for (com.android.library.appusage.a.d dVar : arrayList) {
            String strA = dVar.a();
            String strB = dVar.b();
            String strC = dVar.c();
            try {
                String str = strC + " " + strA;
                Date date = simpleDateFormat.parse(str);
                Date date2 = simpleDateFormat.parse(strC + " " + strB);
                long time = date.getTime();
                long time2 = date2.getTime();
                if (time2 > time) {
                    if (time > jCurrentTimeMillis) {
                        a(time, context, f2596e);
                        a(time2, context, f2597f);
                    } else if (time < jCurrentTimeMillis && time2 > jCurrentTimeMillis) {
                        a(System.currentTimeMillis(), context, f2596e);
                        a(time2, context, f2597f);
                    }
                }
            } catch (Exception e2) {
                CLog.d(a.f2572b, "Exception caught while parsing date string");
            }
        }
    }

    public static void b(long j, Context context, int i) {
        int iD = d.d(context);
        if (i == f2596e) {
            Intent intent = new Intent(context, (Class<?>) UsageTrackReceiver.class);
            intent.putExtra("com.android.appusage.intentextra.usage", "com.android.appusage.usagetrack.start");
            ((AlarmManager) context.getSystemService("alarm")).setRepeating(0, j, ((long) iD) * 86400000, PendingIntent.getBroadcast(context, d.a(context, f2596e), intent, 134217728));
            return;
        }
        if (i == f2597f) {
            Intent intent2 = new Intent(context, (Class<?>) UsageTrackReceiver.class);
            intent2.putExtra("com.android.appusage.intentextra.usage", "com.android.appusage.usagetrack.stop");
            ((AlarmManager) context.getSystemService("alarm")).setRepeating(0, j, ((long) iD) * 86400000, PendingIntent.getBroadcast(context, d.a(context, f2597f), intent2, 134217728));
        }
    }

    public static void b(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (j(context)) {
            CLog.a(a.f2571a, "alarm already set for applist alarm ");
            return;
        }
        String str = Config.getInstance(context).get("appUsageLib.ucsFrequency");
        CLog.a(a.f2571a, "init applist alarm type : " + str);
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeTrackApps");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 9877, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        if (str.equals(f2594c)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 2592000000L, broadcast);
            return;
        }
        if (str.equals(f2592a)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 86400000L, broadcast);
            return;
        }
        if (str.equals(f2593b)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 604800000L, broadcast);
        } else if (str.equals(f2595d)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 31536000000L, broadcast);
        } else {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 2592000000L, broadcast);
        }
    }

    public static void b(ArrayList<com.android.library.appusage.a.d> arrayList, Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HHmm");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, 1);
        Date time = calendar.getTime();
        String str = simpleDateFormat2.format(date);
        String str2 = simpleDateFormat2.format(time);
        for (com.android.library.appusage.a.d dVar : arrayList) {
            String strA = dVar.a();
            String strB = dVar.b();
            try {
                Date date2 = simpleDateFormat.parse(str + " " + strA);
                Date date3 = simpleDateFormat.parse(str + " " + strB);
                long time2 = date2.getTime();
                long time3 = date3.getTime();
                if (time3 > time2) {
                    if (time2 > jCurrentTimeMillis) {
                        b(time2, context, f2596e);
                        b(time3, context, f2597f);
                    } else if (time2 >= jCurrentTimeMillis || time3 <= jCurrentTimeMillis) {
                        Date date4 = simpleDateFormat.parse(str2 + " " + strA);
                        Date date5 = simpleDateFormat.parse(str2 + " " + strB);
                        long time4 = date4.getTime();
                        long time5 = date5.getTime();
                        b(time4, context, f2596e);
                        b(time5, context, f2597f);
                    } else {
                        b(System.currentTimeMillis(), context, f2596e);
                        b(time3, context, f2597f);
                    }
                }
            } catch (Exception e2) {
                CLog.d(a.f2572b, "Exception caught while parsing date string");
            }
        }
    }

    public static void c(Context context) {
        if (h(context)) {
            CLog.a(a.f2571a, "alarm already set for sessionlength alarm ");
            return;
        }
        String str = Config.getInstance(context).get("appUsageLib.usageFrequency");
        CLog.a(a.f2571a, "init session alarm type : " + str);
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeSessionLength");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 9876, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        if (str.equals(f2592a)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 86400000L, broadcast);
            return;
        }
        if (str.equals(f2593b)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 604800000L, broadcast);
            return;
        }
        if (str.equals(f2594c)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 2592000000L, broadcast);
        } else if (str.equals(f2595d)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 31536000000L, broadcast);
        } else {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis(), 604800000L, broadcast);
        }
    }

    public static void d(Context context) {
        f(context);
        String str = Config.getInstance(context).get("appUsageLib.appListFrequency");
        CLog.a(a.f2571a, "on boot applist alarm type : " + str);
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeInstalledApps");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 9875, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        if (str.equals(f2594c)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 2592000000L, 2592000000L, broadcast);
            return;
        }
        if (str.equals(f2592a)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 86400000, 86400000L, broadcast);
            return;
        }
        if (str.equals(f2593b)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 604800000, 604800000L, broadcast);
        } else if (str.equals(f2595d)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 31536000000L, 31536000000L, broadcast);
        } else {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 2592000000L, 2592000000L, broadcast);
        }
    }

    public static void e(Context context) {
        g(context);
        String str = Config.getInstance(context).get("appUsageLib.usageFrequency");
        CLog.a(a.f2571a, "on boot session alarm type : " + str);
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeSessionLength");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 9876, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        if (str.equals(f2592a)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 86400000, 86400000L, broadcast);
            return;
        }
        if (str.equals(f2593b)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 604800000, 604800000L, broadcast);
            return;
        }
        if (str.equals(f2594c)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 2592000000L, 2592000000L, broadcast);
        } else if (str.equals(f2595d)) {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 31536000000L, 31536000000L, broadcast);
        } else {
            alarmManager.setInexactRepeating(0, calendar.getTimeInMillis() + 604800000, 604800000L, broadcast);
        }
    }

    public static void f(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeInstalledApps");
        alarmManager.cancel(PendingIntent.getBroadcast(context, 9875, intent, 134217728));
    }

    public static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeSessionLength");
        alarmManager.cancel(PendingIntent.getBroadcast(context, 9876, intent, 134217728));
    }

    public static boolean h(Context context) {
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeSessionLength");
        return PendingIntent.getBroadcast(context, 9876, intent, 536870912) != null;
    }

    public static boolean i(Context context) {
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeInstalledApps");
        return PendingIntent.getBroadcast(context, 9875, intent, 536870912) != null;
    }

    public static boolean j(Context context) {
        Intent intent = new Intent(context, (Class<?>) AppUsageAlarmReceiver.class);
        intent.putExtra("AlarmType", "AlarmTypeTrackApps");
        return PendingIntent.getBroadcast(context, 9877, intent, 536870912) != null;
    }

    public static boolean k(Context context) {
        Intent intent = new Intent(context, (Class<?>) UsageTrackReceiver.class);
        intent.putExtra("com.android.appusage.intentextra.usage", "com.android.appusage.usagetrack.start");
        return PendingIntent.getBroadcast(context, 2345, intent, 536870912) != null;
    }

    public static void l(Context context) {
        if (k(context)) {
            m(context);
        }
        ArrayList<com.android.library.appusage.a.d> arrayListB = d.b(context);
        if (arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.android.library.appusage.a.d dVar : arrayListB) {
            if (dVar.c() != null && !dVar.c().equals("")) {
                arrayList.add(Integer.valueOf(arrayListB.indexOf(dVar)));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            arrayList2.add(arrayListB.get(iIntValue));
            arrayListB.remove(iIntValue);
        }
        a(arrayList2, context);
        b(arrayListB, context);
    }

    public static void m(Context context) {
        for (com.android.library.appusage.a.a aVar : d.f(context)) {
            a(context, aVar.a(), aVar.b());
        }
    }

    public static boolean n(Context context) {
        return !Config.getInstance(context).get("appUsageLib.mode").equals("OFF");
    }

    public static int o(Context context) {
        String str = Config.getInstance(context).get("appUsageLib.mode");
        if (str.equals("OFF")) {
            return 101;
        }
        return str.equals("NOW") ? 102 : 103;
    }
}
