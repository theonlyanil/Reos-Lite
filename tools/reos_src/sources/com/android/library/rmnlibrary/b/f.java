package com.android.library.rmnlibrary.b;

import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.android.apps.config.util.CLog;
import com.android.library.rmnlibrary.AbstractNotification;
import com.android.library.rmnlibrary.RMNRegistrationService;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f2768a;

    public static long a(long j) {
        try {
            return a(j, System.currentTimeMillis());
        } catch (NumberFormatException e2) {
            CLog.d("RMNLibrary", e2.getMessage());
            return 0L;
        }
    }

    public static long a(long j, long j2) {
        return TimeUnit.MILLISECONDS.toSeconds(j2) - TimeUnit.MILLISECONDS.toSeconds(j);
    }

    public static final long a(String str) {
        return Long.parseLong(str);
    }

    public static Intent a(Context context, RMNRegistrationService.a aVar) {
        int iA = g.a("sharedprefs.key.drawableid", 0, context);
        int iA2 = g.a("sharedprefs.key.keynotidefaulticon", 0, context);
        String strA = g.a("sharedprefs.key.packagename", (String) null, context);
        String strA2 = g.a("sharedprefs.key.senderid", (String) null, context);
        String strA3 = g.a("sharedprefs.key.gcmappend", (String) null, context);
        String strA4 = g.a("sharedprefs.key.youtubekey", (String) null, context);
        Intent intent = new Intent(context, (Class<?>) RMNRegistrationService.class);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_EXTRA_SENDER_ID, strA2);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_EXTRA_DRAWABLE_ID, iA);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_EXTRA_NOTI_DEFAULT_ICON, iA2);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_EXTRA_PACKAGE_NAME, strA);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_GCM_APPEND_URL, strA3);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_YOUTUBE_API_KEY, strA4);
        intent.putExtra(RMNRegistrationService.RMN_REGISTRATION_SERVICE_INTENT_RMNALARMDURATION, aVar);
        return intent;
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static <T> T a(String str, Class<T> cls) {
        com.google.a.g gVar = new com.google.a.g();
        gVar.a();
        return (T) gVar.c().a(str, (Class) cls);
    }

    public static String a(int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date(i));
    }

    public static String a(Context context, AbstractNotification abstractNotification) {
        return new com.google.a.f().a(abstractNotification);
    }

    public static final HashMap<String, String> a(Context context, String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("gcm_reg_id", str2);
        map.put("android_id", b.c(context));
        map.put("model", b.a());
        map.put("imei1", b.a(context));
        map.put("imei2", b.b(context));
        map.put("mcc1", b.d(context));
        map.put("mnc1", b.e(context));
        map.put("country_code", b.f(context));
        map.put("app_version", b.g(context));
        map.put("packagename", str);
        CLog.b("RMNLibrary", map.toString());
        return map;
    }

    public static void a(Context context) {
        context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    public static void a(Context context, String str, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, AbstractNotification abstractNotification) {
        String strA = com.android.library.http.d.c.a(context, actionEntity.getApp_url());
        if (!strA.equals("")) {
            Intent intent = e(context) ? new Intent("android.intent.action.VIEW", b(strA)) : new Intent("android.intent.action.VIEW", Uri.parse(strA));
            intent.setFlags(268435456);
            try {
                context.startActivity(intent);
            } catch (Exception e2) {
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(strA));
                    intent2.setFlags(268435456);
                    context.startActivity(intent2);
                } catch (Exception e3) {
                }
            }
        }
        com.android.library.rmnlibrary.b.a(context, str, "browser_opened", actionEntity.getPackage_name(), abstractNotification);
    }

    public static void a(Context context, String str, String str2, AbstractNotification abstractNotification) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str2);
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
            try {
                context.startActivity(launchIntentForPackage);
                CLog.a("RMNLibrary", "Starting app :: " + str2);
            } catch (Exception e2) {
                CLog.a("RMNLibrary", "Error in opening app" + e2.getMessage());
            }
            f(context);
            if (c(str)) {
                com.android.library.rmnlibrary.b.a(context, str, "engaged", str2, abstractNotification);
            } else {
                d(str);
                com.android.library.rmnlibrary.b.a(context, str, "activated", str2, abstractNotification);
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public static boolean a(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            return responseCode != 200 && (responseCode == 302 || responseCode == 301 || responseCode == 303);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static Uri b(String str) {
        return Uri.parse("googlechrome://navigate?url=" + str);
    }

    public static void b(Context context) {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.item/event");
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar.getTimeInMillis() + 3600000;
        intent.putExtra("beginTime", timeInMillis);
        intent.putExtra("endTime", timeInMillis2);
        intent.putExtra("allDay", true);
        intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "RMN Meeting");
        intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "This is a sample description");
        intent.putExtra("eventLocation", "Deathstar");
        intent.putExtra("rrule", "FREQ=YEARLY");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void b(Context context, String str, String str2, AbstractNotification abstractNotification) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str2));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str2));
            intent2.setFlags(268435456);
            context.startActivity(intent2);
        }
        com.android.library.rmnlibrary.b.a(context, str, "play_store_opened", str2, abstractNotification);
    }

    public static boolean b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            switch (str) {
                case "on":
                    return true;
                case "3g+":
                    return !h(context) && (i(context) || j(context) || k(context));
                case "4g+":
                    return (h(context) || i(context) || (!j(context) && !k(context))) ? false : true;
                case "wifi":
                    return (h(context) || j(context) || i(context) || !k(context)) ? false : true;
                case "off":
                    return false;
            }
        }
        return false;
    }

    public static boolean b(Context context, String str, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, AbstractNotification abstractNotification) {
        String strA = com.android.library.http.d.c.a(context, actionEntity.getDeep_link());
        CLog.b("RMNLibrary", actionEntity.getPackage_name());
        if (!a(context, actionEntity.getPackage_name())) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strA));
            intent.setPackage(actionEntity.getPackage_name());
            intent.addFlags(268435456);
            context.startActivity(intent);
            com.android.library.rmnlibrary.b.b(context, str, "pass", actionEntity.getPackage_name(), abstractNotification);
            return true;
        } catch (Exception e2) {
            com.android.library.rmnlibrary.b.b(context, str, "fail", actionEntity.getPackage_name(), abstractNotification);
            return false;
        }
    }

    public static boolean c(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return false;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return false;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private static boolean c(String str) {
        Set<String> stringSet = f2768a.getStringSet("deals_activated_set", null);
        if (stringSet == null || !stringSet.contains(str)) {
            return false;
        }
        CLog.b("RMNLibrary", "activated deal already exists");
        return true;
    }

    public static String d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "No internet";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() != 0) {
            return "No internet";
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "No internet";
        }
    }

    private static boolean d(String str) {
        Set<String> stringSet = f2768a.getStringSet("deals_activated_set", null);
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
        if (stringSet.contains(str)) {
            return false;
        }
        stringSet.add(str);
        f2768a.edit().putStringSet("deals_activated_set", stringSet).commit();
        return true;
    }

    private static boolean e(Context context) {
        return a(context, "com.android.chrome");
    }

    private static void f(Context context) {
        f2768a = context.getSharedPreferences("com.cube26.lavanextapp.sharedprefs.filename", 0);
    }

    private static String g(Context context) {
        return d(context);
    }

    private static boolean h(Context context) {
        return g(context).equalsIgnoreCase("2G");
    }

    private static boolean i(Context context) {
        return g(context).equalsIgnoreCase("3G");
    }

    private static boolean j(Context context) {
        return g(context).equalsIgnoreCase("4G");
    }

    private static boolean k(Context context) {
        return g(context).equalsIgnoreCase("wifi");
    }
}
