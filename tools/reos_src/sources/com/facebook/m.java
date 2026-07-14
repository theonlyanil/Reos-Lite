package com.facebook;

import android.R;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.facebook.b.ad;
import com.facebook.b.ae;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Executor f4014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f4015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f4016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile String f4017f;
    private static volatile int g;
    private static com.facebook.b.u<File> l;
    private static Context m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4012a = m.class.getCanonicalName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashSet<u> f4013b = new HashSet<>(Arrays.asList(u.DEVELOPER_ERRORS));
    private static volatile String h = "facebook.com";
    private static AtomicLong i = new AtomicLong(65536);
    private static volatile boolean j = false;
    private static boolean k = false;
    private static int n = 64206;
    private static final Object o = new Object();
    private static final BlockingQueue<Runnable> p = new LinkedBlockingQueue(10);
    private static final ThreadFactory q = new ThreadFactory() { // from class: com.facebook.m.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4018a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FacebookSdk #" + this.f4018a.incrementAndGet());
        }
    };
    private static Boolean r = false;

    public interface a {
        void a();
    }

    public static void a(int i2) {
        if (i2 == 0) {
            i2 = R.style.Theme.Translucent.NoTitleBar;
        }
        g = i2;
    }

    public static synchronized void a(Context context) {
        a(context, null);
    }

    public static synchronized void a(final Context context, final a aVar) {
        if (!r.booleanValue()) {
            ae.a(context, "applicationContext");
            ae.b(context, false);
            ae.a(context, false);
            m = context.getApplicationContext();
            c(m);
            r = true;
            ad.a(m, f4015d);
            com.facebook.b.y.b();
            com.facebook.b.d.a(m);
            l = new com.facebook.b.u<>(new Callable<File>() { // from class: com.facebook.m.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public File call() throws Exception {
                    return m.m.getCacheDir();
                }
            });
            d().execute(new FutureTask(new Callable<Void>() { // from class: com.facebook.m.3
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void call() throws Exception {
                    b.a().c();
                    w.a().c();
                    if (AccessToken.a() != null && Profile.a() == null) {
                        Profile.b();
                    }
                    if (aVar != null) {
                        aVar.a();
                    }
                    com.facebook.a.f.a(context.getApplicationContext()).b();
                    return null;
                }
            }));
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static synchronized boolean a() {
        return r.booleanValue();
    }

    public static boolean a(u uVar) {
        boolean z;
        synchronized (f4013b) {
            z = b() && f4013b.contains(uVar);
        }
        return z;
    }

    public static boolean b() {
        return j;
    }

    public static boolean b(int i2) {
        return i2 >= n && i2 < n + 100;
    }

    public static boolean b(Context context) {
        ae.a();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return;
            }
            if (f4015d == null) {
                Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                        f4015d = str.substring(2);
                    } else {
                        f4015d = str;
                    }
                } else if (obj instanceof Integer) {
                    throw new k("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (f4016e == null) {
                f4016e = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
            }
            if (f4017f == null) {
                f4017f = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
            }
            if (g == 0) {
                a(applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
            }
        } catch (PackageManager.NameNotFoundException e2) {
        }
    }

    public static boolean c() {
        return k;
    }

    public static Executor d() {
        synchronized (o) {
            if (f4014c == null) {
                f4014c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return f4014c;
    }

    public static String e() {
        return h;
    }

    public static Context f() {
        ae.a();
        return m;
    }

    public static String g() {
        return "4.15.0";
    }

    public static long h() {
        ae.a();
        return i.get();
    }

    public static String i() {
        ae.a();
        return f4015d;
    }

    public static String j() {
        ae.a();
        return f4016e;
    }

    public static String k() {
        ae.a();
        return f4017f;
    }

    public static int l() {
        ae.a();
        return g;
    }

    public static File m() {
        ae.a();
        return l.a();
    }

    public static int n() {
        ae.a();
        return n;
    }
}
