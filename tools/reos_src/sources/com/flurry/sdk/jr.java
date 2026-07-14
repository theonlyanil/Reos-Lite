package com.flurry.sdk;

import android.content.Context;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class jr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4506a = jr.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<lf> f4508c;
    private String i;
    private String j;
    private Map<String, String> k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kb<lg> f4507b = new kb<lg>() { // from class: com.flurry.sdk.jr.1
        @Override // com.flurry.sdk.kb
        public void a(lg lgVar) {
            if (jr.this.f4508c == null || lgVar.f4681b == jr.this.f4508c.get()) {
                switch (AnonymousClass4.f4515a[lgVar.f4682c.ordinal()]) {
                    case 1:
                        jr.this.a(lgVar.f4681b, lgVar.f4680a.get());
                        break;
                    case 2:
                        jr.this.a(lgVar.f4680a.get());
                        break;
                    case 3:
                        jr.this.b(lgVar.f4680a.get());
                        break;
                    case 4:
                        kc.a().b("com.flurry.android.sdk.FlurrySessionEvent", jr.this.f4507b);
                        jr.this.a();
                        break;
                }
            }
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f4509d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f4510e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f4511f = -1;
    private volatile long g = 0;
    private volatile long h = 0;

    /* JADX INFO: renamed from: com.flurry.sdk.jr$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4515a = new int[lg.a.values().length];

        static {
            try {
                f4515a[lg.a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4515a[lg.a.START.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4515a[lg.a.END.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4515a[lg.a.FINALIZE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public jr() {
        kc.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.f4507b);
        this.k = new LinkedHashMap<String, String>() { // from class: com.flurry.sdk.jr.2
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
                return size() > 10;
            }
        };
    }

    private void b(lf lfVar, Context context) {
        if (lfVar == null || context == null) {
            kg.a(3, f4506a, "Flurry session id cannot be created.");
            return;
        }
        kg.a(3, f4506a, "Flurry session id started:" + this.f4509d);
        lg lgVar = new lg();
        lgVar.f4680a = new WeakReference<>(context);
        lgVar.f4681b = lfVar;
        lgVar.f4682c = lg.a.SESSION_ID_CREATED;
        lgVar.b();
    }

    public void a() {
    }

    public void a(Context context) {
        long jC = lh.a().c();
        if (jC > 0) {
            this.g = (System.currentTimeMillis() - jC) + this.g;
        }
    }

    public void a(lf lfVar, Context context) {
        this.f4508c = new WeakReference<>(lfVar);
        this.f4509d = System.currentTimeMillis();
        this.f4510e = SystemClock.elapsedRealtime();
        b(lfVar, context);
        js.a().b(new ly() { // from class: com.flurry.sdk.jr.3
            @Override // com.flurry.sdk.ly
            public void a() {
                jj.a().c();
            }
        });
    }

    public synchronized void a(String str) {
        this.i = str;
    }

    public synchronized void a(String str, String str2) {
        this.k.put(str, str2);
    }

    public String b() {
        return Long.toString(this.f4509d);
    }

    public void b(Context context) {
        this.f4511f = SystemClock.elapsedRealtime() - this.f4510e;
    }

    public synchronized void b(String str) {
        this.j = str;
    }

    public long c() {
        return this.f4509d;
    }

    public long d() {
        return this.f4510e;
    }

    public long e() {
        return this.f4511f;
    }

    public long f() {
        return this.g;
    }

    public synchronized long g() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f4510e;
        if (jElapsedRealtime <= this.h) {
            jElapsedRealtime = this.h + 1;
            this.h = jElapsedRealtime;
        }
        this.h = jElapsedRealtime;
        return this.h;
    }

    public synchronized String h() {
        return this.i;
    }

    public synchronized String i() {
        return this.j;
    }

    public synchronized Map<String, String> j() {
        return this.k;
    }
}
