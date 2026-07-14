package com.android.library.rmnlibrary;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ag;
import android.support.v4.app.ap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import com.android.library.rmnlibrary.b.c;
import com.android.library.rmnlibrary.b.e;
import com.android.library.rmnlibrary.b.f;
import com.android.library.rmnlibrary.b.g;
import com.google.android.gms.location.places.Place;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NotificationManager f2757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Notification f2758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f2759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ag.d f2760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ag.b f2761e;

    public static long a(String str, int i, String str2, Context context, long j, AbstractNotification abstractNotification) {
        if (f.b(context, abstractNotification.getResponse().getMode())) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - j <= 3000) {
            return j;
        }
        ag.d dVar = new ag.d(context);
        dVar.a(str);
        f2757a = (NotificationManager) context.getSystemService("notification");
        if (i >= 0) {
            dVar.a(R.drawable.stat_sys_download);
            dVar.a(100, i, false);
            dVar.a(true);
            dVar.c(true);
            f2758b = dVar.a();
            f2757a.notify(str2, Place.TYPE_NATURAL_FEATURE, f2758b);
        }
        return jCurrentTimeMillis;
    }

    public static <T> PendingIntent a(Context context, String str, Class<T> cls) {
        return PendingIntent.getService(context, 0, c(context, str, cls), 0);
    }

    public static <T> PendingIntent a(Context context, String str, Class<T> cls, int i) {
        return PendingIntent.getService(context, 0, b(context, str, cls, i), 0);
    }

    public static <T> AbstractNotification a(Context context, String str, AbstractNotification abstractNotification, Class<T> cls) {
        return abstractNotification == null ? (AbstractNotification) f.a(g.a(str, (String) null, context), cls) : abstractNotification;
    }

    public static b a() {
        return new b();
    }

    public static void a(int i, NotificationManager notificationManager, Notification notification) {
        notificationManager.notify(i, notification);
    }

    public static void a(Context context, int i) {
        ap.a(context).a(i);
    }

    private static void a(Context context, int i, Notification notification) {
        ap.a(context).a(i, notification);
    }

    public static void a(Context context, Notification notification, int i) {
        if (notification != null) {
            a(context, i);
        }
    }

    public static void a(Context context, RemoteViews remoteViews, int i, int i2, int i3, String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (zIsEmpty) {
            remoteViews.setViewVisibility(i, 8);
        } else {
            remoteViews.setTextViewText(i, str);
        }
        if (zIsEmpty2) {
            remoteViews.setViewVisibility(i2, 8);
        } else {
            remoteViews.setTextViewText(i2, str2);
        }
        remoteViews.setViewVisibility(i3, 8);
    }

    public static void a(Context context, RemoteViews remoteViews, int i, int i2, int i3, String str, String str2, String str3) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        boolean zIsEmpty3 = TextUtils.isEmpty(str3);
        if (zIsEmpty) {
            remoteViews.setViewVisibility(i, 8);
        } else {
            remoteViews.setTextViewText(i, str);
        }
        if (zIsEmpty2) {
            remoteViews.setViewVisibility(i2, 8);
        } else {
            remoteViews.setTextViewText(i2, str2);
        }
        if (zIsEmpty3) {
            remoteViews.setViewVisibility(i3, 8);
        } else {
            remoteViews.setTextViewText(i3, str3);
        }
    }

    public static void a(Context context, RemoteViews remoteViews, int i, int i2, String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (zIsEmpty) {
            remoteViews.setViewVisibility(i, 8);
        } else {
            remoteViews.setTextViewText(i, str);
        }
        if (zIsEmpty2) {
            remoteViews.setViewVisibility(i2, 8);
        } else {
            remoteViews.setTextViewText(i2, str2);
        }
    }

    public static void a(Context context, AbstractNotification abstractNotification, String str) {
        long jA = f.a(f.a(abstractNotification.getResponse().getNotification_validity()));
        if (TextUtils.isEmpty(str) || jA >= 1) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) RichMediaNotificationService.class);
        intent.putExtra(str, abstractNotification);
        intent.setAction(str);
        context.startService(intent);
    }

    public static <T> void a(Context context, Class<T> cls, String str, AbstractNotification abstractNotification) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.addFlags(268435456);
        intent.putExtra(str, abstractNotification);
        context.startActivity(intent);
    }

    public static void a(Context context, String str) {
        String str2 = Config.getInstance(context).get("httpLib.postBaseUrl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", g.a("sharedprefs.key.packagename", b(context), context));
            jSONObject.put("subCategory", "playservices");
            jSONObject.put("identifier", b(context));
            jSONObject.put("version", "1.0");
            jSONObject.put("actionId", "gps_version");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", str);
            jSONObject2.put("eventTime", System.currentTimeMillis());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("values", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HTTPLibrary.postAnalyticsEvents(context, str2, jSONObject, 2, 10);
    }

    public static void a(Context context, String str, RemoteViews remoteViews, int i, Notification notification, int i2) {
        com.a.a.h.b.g gVar = new com.a.a.h.b.g(context, remoteViews, i, notification, i2);
        if (TextUtils.isEmpty(str)) {
            com.a.a.g.b(context).a(Integer.valueOf(a.C0050a.ic_placeholder_notification)).h().d(a.C0050a.ic_placeholder_notification).b().b(com.a.a.d.b.b.ALL).a(gVar);
        } else {
            com.a.a.g.b(context).a(str).h().d(a.C0050a.ic_placeholder_notification).b().b(com.a.a.d.b.b.ALL).a(gVar);
        }
    }

    private static void a(Context context, String str, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, AbstractNotification abstractNotification, int i) {
        String open_in_playsore = actionEntity.getOpen_in_playsore();
        String package_name = actionEntity.getPackage_name();
        if (a(actionEntity.getAdd_snooze_time())) {
            return;
        }
        if (c(open_in_playsore)) {
            f.b(context, str, package_name, abstractNotification);
        } else {
            f.a(context, str, actionEntity, abstractNotification);
        }
    }

    public static void a(Context context, String str, AbstractNotification abstractNotification) {
        if (f.b(context, abstractNotification.getResponse().getMode()) || f2758b == null) {
            return;
        }
        f2757a.cancel(str, Place.TYPE_NATURAL_FEATURE);
    }

    private static void a(Context context, String str, AbstractNotification abstractNotification, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, int i) {
        String open_in_playsore = actionEntity.getOpen_in_playsore();
        String package_name = actionEntity.getPackage_name();
        String app_url = actionEntity.getApp_url();
        String deep_link = actionEntity.getDeep_link();
        String add_snooze_time = actionEntity.getAdd_snooze_time();
        boolean zC = c(open_in_playsore);
        boolean zD = d(app_url);
        boolean zE = e(deep_link);
        if (a(add_snooze_time)) {
            return;
        }
        if (zD && zC && zE) {
            b(context, str, abstractNotification, package_name);
            return;
        }
        if (!zD && !zC && zE) {
            e(context, str, abstractNotification, actionEntity, package_name);
            return;
        }
        if (zD) {
            if ((!zC) & zE) {
                a(context, str, abstractNotification, package_name);
                return;
            }
        }
        if (zD && !zE && !zC) {
            d(context, str, abstractNotification, actionEntity, package_name);
            return;
        }
        if (!zE && !zD && !zC) {
            c(context, str, abstractNotification, actionEntity, package_name);
            return;
        }
        if (!zE && zC && zD) {
            b(context, str, abstractNotification, actionEntity, package_name);
        } else {
            if (zE || zC || !zD) {
                return;
            }
            a(context, str, abstractNotification, actionEntity, package_name);
        }
    }

    public static void a(Context context, String str, AbstractNotification abstractNotification, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, int i, boolean z) {
        if (z) {
            f.a(context);
        }
        switch (abstractNotification.getResponse().getDeal_type()) {
            case "1":
                if (abstractNotification != null) {
                    a(context, str, actionEntity, abstractNotification, i);
                    break;
                }
                break;
            case "2":
                if (abstractNotification != null) {
                    b(context, str, actionEntity, abstractNotification, i);
                    break;
                }
                break;
            case "3":
                if (abstractNotification != null) {
                    a(context, str, abstractNotification, actionEntity, i);
                    break;
                }
                break;
        }
    }

    private static void a(Context context, String str, AbstractNotification abstractNotification, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, String str2) {
        if (f.a(context, str2)) {
            f.b(context, str, actionEntity, abstractNotification);
        } else {
            f.a(context, str, str2, abstractNotification);
        }
    }

    private static void a(Context context, String str, AbstractNotification abstractNotification, String str2) {
        if (f.a(context, str2)) {
            f.a(context, str, str2, abstractNotification);
        }
    }

    public static void a(Context context, String str, String str2, String str3, AbstractNotification abstractNotification) {
        String str4 = Config.getInstance(context).get("httpLib.postBaseUrl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", g.a("sharedprefs.key.packagename", b(context), context));
            jSONObject.put("subCategory", "deal");
            jSONObject.put("identifier", b(context));
            jSONObject.put("version", "1.0");
            jSONObject.put("actionId", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject2.put("notification_id", abstractNotification.getResponse().getNotification_id());
            jSONObject2.put("packageName", str3);
            jSONObject2.put("eventTime", System.currentTimeMillis());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("values", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        CLog.b("RMNLibrary", jSONObject.toString());
        CLog.b("RMNLibrary", jSONObject.toString());
        HTTPLibrary.postAnalyticsEvents(context, str4, jSONObject, 2, 10);
    }

    public static void a(RemoteViews remoteViews, int i, int i2, String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (zIsEmpty) {
            remoteViews.setViewVisibility(i, 8);
        } else {
            remoteViews.setTextViewText(i, str);
        }
        if (zIsEmpty2) {
            remoteViews.setViewVisibility(i2, 8);
        } else {
            remoteViews.setTextViewText(i2, str2);
        }
    }

    public static boolean a(Context context, AbstractNotification abstractNotification) {
        String package_name = abstractNotification.getResponse().getNotifications().get(0).getAction1().getPackage_name();
        switch (abstractNotification.getResponse().getDeal_type()) {
            case "1":
                boolean z = (f(package_name) || f.a(context, package_name)) ? false : true;
                return z;
            case "2":
                if (f(package_name)) {
                    return false;
                }
                return f.a(context, package_name);
            case "3":
                return true;
            default:
                return false;
        }
    }

    private static boolean a(AbstractNotification.ResponseEntity.NotificationsEntity.Facebook facebook) {
        return (facebook == null || facebook.equals("")) ? false : true;
    }

    private static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("true");
    }

    public static <T> PendingIntent b(Context context, String str, Class<T> cls) {
        return PendingIntent.getBroadcast(context, 0, c(context, str, cls), 0);
    }

    private static <T> Intent b(Context context, String str, Class<T> cls, int i) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.setAction(str);
        intent.putExtra("com.android.library.rmnlibrary.CLICKED_POSITION", i);
        intent.setData(Uri.parse(intent.toUri(1)));
        return intent;
    }

    public static Bitmap b(Context context, String str) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            bitmap = null;
        } else {
            try {
                bitmap = com.a.a.g.b(context).a(str).h().c(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
            } catch (InterruptedException | ExecutionException e2) {
                e2.printStackTrace();
                bitmap = null;
            }
        }
        if (bitmap == null) {
            return Build.VERSION.SDK_INT >= 21 ? f.a(context.getResources().getDrawable(a.C0050a.ic_placeholder_notification, context.getTheme())) : f.a(context.getResources().getDrawable(a.C0050a.ic_placeholder_notification));
        }
        return bitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static AbstractNotification b(Context context, AbstractNotification abstractNotification) {
        new AbstractNotification();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(abstractNotification.getResponse().getNotifications());
        switch (abstractNotification.getResponse().getDeal_type()) {
            case "1":
                Iterator<AbstractNotification.ResponseEntity.NotificationsEntity> it = arrayList.iterator();
                while (it.hasNext()) {
                    String package_name = it.next().getAction1().getPackage_name();
                    if (!f(package_name) && f.a(context, package_name)) {
                        it.remove();
                        abstractNotification.getResponse().setNotifications(arrayList);
                    }
                }
                return abstractNotification;
            case "2":
                Iterator<AbstractNotification.ResponseEntity.NotificationsEntity> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String package_name2 = it2.next().getAction1().getPackage_name();
                    if (!f(package_name2) && !f.a(context, package_name2)) {
                        it2.remove();
                        abstractNotification.getResponse().setNotifications(arrayList);
                    }
                }
                return abstractNotification;
            case "3":
                abstractNotification.getResponse().setNotifications(arrayList);
                return abstractNotification;
            default:
                return abstractNotification;
        }
    }

    public static String b(Context context) {
        return Config.getInstance(context).get("configLib.idPrefix") + ".library.rmn";
    }

    public static void b(Context context, String str, RemoteViews remoteViews, int i, Notification notification, int i2) {
        int iA = g.a("sharedprefs.key.keynotidefaulticon", 0, context);
        com.a.a.h.b.g gVar = new com.a.a.h.b.g(context, remoteViews, i, notification, i2);
        if (TextUtils.isEmpty(str)) {
            com.a.a.g.b(context).a(Integer.valueOf(iA)).h().d(iA).b().b(com.a.a.d.b.b.ALL).a(gVar);
        } else {
            com.a.a.g.b(context).a(str).h().d(iA).b().b(com.a.a.d.b.b.ALL).a(gVar);
        }
    }

    private static void b(Context context, String str, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, AbstractNotification abstractNotification, int i) {
        String package_name = actionEntity.getPackage_name();
        String deep_link = actionEntity.getDeep_link();
        String add_calendar_events = actionEntity.getAdd_calendar_events();
        String add_snooze_time = actionEntity.getAdd_snooze_time();
        AbstractNotification.ResponseEntity.NotificationsEntity.Facebook twitter = actionEntity.getTwitter();
        AbstractNotification.ResponseEntity.NotificationsEntity.Facebook facebook = actionEntity.getFacebook();
        if (a(add_snooze_time) || a(facebook) || b(twitter)) {
            return;
        }
        if (b(add_calendar_events)) {
            f.b(context);
        } else if (e(deep_link)) {
            f.a(context, str, package_name, abstractNotification);
        } else {
            f.b(context, str, actionEntity, abstractNotification);
        }
    }

    /* JADX WARN: Code duplicated, block: B:87:0x0237  */
    public static void b(Context context, String str, AbstractNotification abstractNotification) {
        String str2;
        List<AbstractNotification.ResponseEntity.NotificationsEntity> notifications = abstractNotification.getResponse().getNotifications();
        switch (str) {
            case "Single":
                String banner = abstractNotification.getResponse().getBanner();
                if (!a(context, abstractNotification) || notifications.size() != 1) {
                    str2 = null;
                    break;
                } else {
                    if (TextUtils.isEmpty(banner)) {
                        str2 = "Basic";
                    } else {
                        str2 = "Single";
                    }
                    break;
                }
                break;
            case "Carousel":
                List<AbstractNotification.ResponseEntity.NotificationsEntity> notifications2 = b(context, abstractNotification).getResponse().getNotifications();
                int size = notifications2.size();
                if (size <= 0) {
                    str2 = null;
                    break;
                } else {
                    if (size > 1) {
                        e.a().b();
                        for (int i = 0; i < size; i++) {
                            try {
                                e.a().put("com.android.library.rmnlibrary.CACHE_BANNER_CAROUSEL" + i, b(context, notifications2.get(i).getBanner()));
                                e.a().put("com.android.library.rmnlibrary.CACHE_ICON_CAROUSEL" + i, b(context, notifications2.get(i).getIcon1()));
                            } catch (Exception e2) {
                                CLog.d("RMNLibrary", "Null pointer exception in bitmap");
                            }
                        }
                        CLog.b("RMNLibrary", "NOTIFICATION SIZE FOR CAROUSSEL IS == " + size + " SO SHOWING CAROUSSEL");
                        str2 = "Carousel";
                    } else {
                        CLog.b("RMNLibrary", "NOTIFICATION SIZE FOR CAROUSSEL IS == " + size + " SO SHOWING SINGLE");
                        str2 = "Single";
                    }
                    break;
                }
                break;
            case "Multiple":
                int size2 = b(context, abstractNotification).getResponse().getNotifications().size();
                if (size2 <= 0) {
                    str2 = null;
                    break;
                } else {
                    if (size2 > 1) {
                        str2 = "Multiple";
                    } else {
                        str2 = "Single";
                    }
                    break;
                }
                break;
            case "Audio":
                if (!a(context, abstractNotification)) {
                    str2 = null;
                    break;
                } else {
                    str2 = "Audio";
                    break;
                }
                break;
            case "Video":
                if (!a(context, abstractNotification)) {
                    str2 = null;
                    break;
                } else {
                    str2 = "Video";
                    break;
                }
                break;
            case "UA":
                String package_name = abstractNotification.getResponse().getNotifications().get(0).getAction1().getPackage_name();
                String md5 = abstractNotification.getResponse().getNotifications().get(0).getMd5();
                String strReplaceAll = abstractNotification.getResponse().getNotifications().get(0).getAction1().getApp_url().replaceAll(" ", "%20");
                if (!a(context, abstractNotification)) {
                    str2 = null;
                    break;
                } else {
                    if (f.b(context, abstractNotification.getResponse().getMode())) {
                        c.a(context, package_name, md5, strReplaceAll, abstractNotification, false);
                        str2 = null;
                    } else {
                        str2 = "UA";
                    }
                    break;
                }
                break;
            case "MULTIPLE_UA":
                AbstractNotification abstractNotificationC = c(context, abstractNotification);
                if (abstractNotificationC != null && abstractNotificationC.getResponse().getNotifications().get(0).getApk_download().size() > 0) {
                    if (f.b(context, abstractNotification.getResponse().getMode())) {
                        c.a(context, abstractNotification);
                        str2 = null;
                    } else {
                        str2 = "MULTIPLE_UA";
                    }
                    break;
                } else {
                    str2 = null;
                    break;
                }
                break;
            case "GIF":
                if (Build.VERSION.SDK_INT < 23) {
                    if (a(context, abstractNotification)) {
                        str2 = "GIF";
                    } else {
                        str2 = null;
                    }
                    break;
                } else {
                    if (Settings.canDrawOverlays(context) && a(context, abstractNotification)) {
                        str2 = "GIF";
                    } else {
                        str2 = null;
                    }
                    break;
                }
                break;
            default:
                str2 = null;
                break;
        }
        a(context, abstractNotification, str2);
    }

    private static void b(Context context, String str, AbstractNotification abstractNotification, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, String str2) {
        if (f.a(context, str2)) {
            f.b(context, str, actionEntity, abstractNotification);
        } else {
            f.b(context, str, str2, abstractNotification);
        }
    }

    private static void b(Context context, String str, AbstractNotification abstractNotification, String str2) {
        if (f.a(context, str2)) {
            f.a(context, str, str2, abstractNotification);
        } else {
            f.b(context, str, str2, abstractNotification);
        }
    }

    public static void b(Context context, String str, String str2, String str3, AbstractNotification abstractNotification) {
        String str4 = Config.getInstance(context).get("httpLib.postBaseUrl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", g.a("sharedprefs.key.packagename", b(context), context));
            jSONObject.put("subCategory", "deal");
            jSONObject.put("identifier", b(context));
            jSONObject.put("version", "1.0");
            jSONObject.put("actionId", "engaged_deep");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject2.put("notification_id", abstractNotification.getResponse().getNotification_id());
            jSONObject2.put("packageName", str3);
            jSONObject2.put("eventTime", System.currentTimeMillis());
            jSONObject2.put("deep_link_status", str2);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("values", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        CLog.b("RMNLibrary", str4);
        CLog.b("RMNLibrary", jSONObject.toString());
        HTTPLibrary.postAnalyticsEvents(context, str4, jSONObject, 2, 10);
    }

    private static boolean b(AbstractNotification.ResponseEntity.NotificationsEntity.Facebook facebook) {
        return (facebook == null || facebook.equals("")) ? false : true;
    }

    private static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("true");
    }

    private static <T> Intent c(Context context, String str, Class<T> cls) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.setAction(str);
        return intent;
    }

    public static AbstractNotification c(Context context, AbstractNotification abstractNotification) {
        new AbstractNotification();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(abstractNotification.getResponse().getNotifications().get(0).getApk_download());
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        switch (abstractNotification.getResponse().getDeal_type()) {
            case "1":
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String package_name = ((AbstractNotification.ResponseEntity.NotificationsEntity.APK_DOWNLOAD) it.next()).getPackage_name();
                    if (!f(package_name) && f.a(context, package_name)) {
                        it.remove();
                        abstractNotification.getResponse().getNotifications().get(0).setApk_download(arrayList);
                    }
                }
                return abstractNotification;
            case "2":
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String package_name2 = ((AbstractNotification.ResponseEntity.NotificationsEntity.APK_DOWNLOAD) it2.next()).getPackage_name();
                    if (!f(package_name2) && !f.a(context, package_name2)) {
                        it2.remove();
                        abstractNotification.getResponse().getNotifications().get(0).setApk_download(arrayList);
                    }
                }
                return abstractNotification;
            case "3":
                abstractNotification.getResponse().getNotifications().get(0).setApk_download(arrayList);
                return abstractNotification;
            default:
                return abstractNotification;
        }
    }

    private b c(Context context) {
        this.f2759c = context;
        this.f2760d = new ag.d(this.f2759c);
        this.f2760d.b(11);
        this.f2760d.b(true);
        return this;
    }

    private static void c(Context context, String str, AbstractNotification abstractNotification, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, String str2) {
        if (f.a(context, str2)) {
            f.b(context, str, actionEntity, abstractNotification);
        } else {
            f.a(context, str, actionEntity, abstractNotification);
        }
    }

    private static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("true");
    }

    private static void d(Context context, String str, AbstractNotification abstractNotification, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, String str2) {
        if (f.a(context, str2)) {
            f.b(context, str, actionEntity, abstractNotification);
        }
    }

    private static boolean d(String str) {
        return TextUtils.isEmpty(str);
    }

    private static void e(Context context, String str, AbstractNotification abstractNotification, AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity actionEntity, String str2) {
        if (f.a(context, str2)) {
            f.a(context, str, str2, abstractNotification);
        } else {
            f.a(context, str, actionEntity, abstractNotification);
        }
    }

    private static boolean e(String str) {
        return TextUtils.isEmpty(str);
    }

    private static boolean f(String str) {
        return TextUtils.isEmpty(str);
    }

    public Notification a(RemoteViews remoteViews, int i, boolean z) {
        Notification notificationA = this.f2760d.a();
        notificationA.contentView = remoteViews;
        if (!z) {
            notificationA.flags = 10;
        }
        a(this.f2759c, i, notificationA);
        return notificationA;
    }

    public Notification a(RemoteViews remoteViews, RemoteViews remoteViews2, int i, boolean z) {
        Notification notificationA = this.f2760d.a();
        notificationA.bigContentView = remoteViews2;
        notificationA.contentView = remoteViews;
        if (!z) {
            notificationA.flags = 10;
        }
        a(this.f2759c, i, notificationA);
        return notificationA;
    }

    public b a(int i) {
        this.f2760d.a(i);
        return this;
    }

    public b a(PendingIntent pendingIntent) {
        this.f2760d.b(pendingIntent);
        return this;
    }

    public b a(Context context) {
        c(context);
        this.f2761e = new ag.b();
        return this;
    }
}
