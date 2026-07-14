package com.facebook.a;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.b.ad;
import com.facebook.b.ae;
import com.facebook.b.v;
import com.facebook.m;
import com.facebook.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f3582d;
    private static String g;
    private static boolean h;
    private static String i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.facebook.a.a f3586c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3581a = f.class.getCanonicalName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f3583e = a.AUTO;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Object f3584f = new Object();

    public enum a {
        AUTO,
        EXPLICIT_ONLY
    }

    private f(Context context, String str, AccessToken accessToken) {
        this(ad.c(context), str, accessToken);
    }

    protected f(String str, String str2, AccessToken accessToken) {
        ae.a();
        this.f3585b = str;
        accessToken = accessToken == null ? AccessToken.a() : accessToken;
        if (accessToken == null || !(str2 == null || str2.equals(accessToken.h()))) {
            this.f3586c = new com.facebook.a.a(null, str2 == null ? ad.a(m.f()) : str2);
        } else {
            this.f3586c = new com.facebook.a.a(accessToken);
        }
        d();
    }

    public static a a() {
        a aVar;
        synchronized (f3584f) {
            aVar = f3583e;
        }
        return aVar;
    }

    public static f a(Context context) {
        return new f(context, (String) null, (AccessToken) null);
    }

    public static f a(Context context, String str) {
        return new f(context, str, (AccessToken) null);
    }

    private static void a(Context context, b bVar, com.facebook.a.a aVar) {
        d.a(aVar, bVar);
        if (bVar.b() || h) {
            return;
        }
        if (bVar.a() == "fb_mobile_activate_app") {
            h = true;
        } else {
            v.a(u.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
        }
    }

    private void a(String str, Double d2, Bundle bundle, boolean z, UUID uuid) {
        try {
            a(m.f(), new b(this.f3585b, str, d2, bundle, z, uuid), this.f3586c);
        } catch (com.facebook.k e2) {
            v.a(u.APP_EVENTS, "AppEvents", "Invalid app event: %s", e2.toString());
        } catch (JSONException e3) {
            v.a(u.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e3.toString());
        }
    }

    public static String b(Context context) {
        if (g == null) {
            synchronized (f3584f) {
                if (g == null) {
                    g = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    if (g == null) {
                        g = "XZ" + UUID.randomUUID().toString();
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", g).apply();
                    }
                }
            }
        }
        return g;
    }

    static String c() {
        String str;
        synchronized (f3584f) {
            str = i;
        }
        return str;
    }

    private static void d() {
        synchronized (f3584f) {
            if (f3582d != null) {
                return;
            }
            f3582d = new ScheduledThreadPoolExecutor(1);
            f3582d.scheduleAtFixedRate(new Runnable() { // from class: com.facebook.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    HashSet hashSet = new HashSet();
                    Iterator<com.facebook.a.a> it = d.a().iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().b());
                    }
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        ad.a((String) it2.next(), true);
                    }
                }
            }, 0L, 86400L, TimeUnit.SECONDS);
        }
    }

    public void a(String str, Bundle bundle) {
        a(str, null, bundle, false, com.facebook.a.a.a.a());
    }

    public void a(String str, Double d2, Bundle bundle) {
        a(str, d2, bundle, true, com.facebook.a.a.a.a());
    }

    public void b() {
        d.a(g.EXPLICIT);
    }
}
