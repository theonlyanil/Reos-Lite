package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class lh implements ll.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static lh f4690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4691b = lh.class.getSimpleName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4695f;
    private long g;
    private lf h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Context, lf> f4692c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final li f4693d = new li();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f4694e = new Object();
    private kb<lj> i = new kb<lj>() { // from class: com.flurry.sdk.lh.1
        @Override // com.flurry.sdk.kb
        public void a(lj ljVar) {
            lh.this.i();
        }
    };
    private kb<jv> j = new kb<jv>() { // from class: com.flurry.sdk.lh.2
        @Override // com.flurry.sdk.kb
        public void a(jv jvVar) {
            switch (AnonymousClass5.f4701a[jvVar.f4527b.ordinal()]) {
                case 1:
                    kg.a(3, lh.f4691b, "Automatic onStartSession for context:" + jvVar.f4526a);
                    lh.this.e(jvVar.f4526a);
                    break;
                case 2:
                    kg.a(3, lh.f4691b, "Automatic onEndSession for context:" + jvVar.f4526a);
                    lh.this.d(jvVar.f4526a);
                    break;
                case 3:
                    kg.a(3, lh.f4691b, "Automatic onEndSession (destroyed) for context:" + jvVar.f4526a);
                    lh.this.d(jvVar.f4526a);
                    break;
            }
        }
    };

    /* JADX INFO: renamed from: com.flurry.sdk.lh$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4701a = new int[jv.a.values().length];

        static {
            try {
                f4701a[jv.a.kStarted.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4701a[jv.a.kStopped.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4701a[jv.a.kDestroyed.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private lh() {
        lk lkVarA = lk.a();
        this.f4695f = 0L;
        this.g = ((Long) lkVarA.a("ContinueSessionMillis")).longValue();
        lkVarA.a("ContinueSessionMillis", (ll.a) this);
        kg.a(4, f4691b, "initSettings, ContinueSessionMillis = " + this.g);
        kc.a().a("com.flurry.android.sdk.ActivityLifecycleEvent", this.j);
        kc.a().a("com.flurry.android.sdk.FlurrySessionTimerEvent", this.i);
    }

    public static synchronized lh a() {
        if (f4690a == null) {
            f4690a = new lh();
        }
        return f4690a;
    }

    private void a(lf lfVar) {
        synchronized (this.f4694e) {
            this.h = lfVar;
        }
    }

    public static synchronized void b() {
        if (f4690a != null) {
            kc.a().a(f4690a.i);
            kc.a().a(f4690a.j);
            lk.a().b("ContinueSessionMillis", (ll.a) f4690a);
        }
        f4690a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(lf lfVar) {
        synchronized (this.f4694e) {
            if (this.h == lfVar) {
                this.h = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(Context context) {
        if (this.f4692c.get(context) == null) {
            this.f4693d.a();
            lf lfVarE = e();
            if (lfVarE == null) {
                lfVarE = new lf();
                kg.e(f4691b, "Flurry session started for context:" + context);
                lg lgVar = new lg();
                lgVar.f4680a = new WeakReference<>(context);
                lgVar.f4681b = lfVarE;
                lgVar.f4682c = lg.a.CREATE;
                lgVar.b();
            }
            this.f4692c.put(context, lfVarE);
            a(lfVarE);
            kg.e(f4691b, "Flurry session resumed for context:" + context);
            lg lgVar2 = new lg();
            lgVar2.f4680a = new WeakReference<>(context);
            lgVar2.f4681b = lfVarE;
            lgVar2.f4682c = lg.a.START;
            lgVar2.b();
            this.f4695f = 0L;
        } else if (jw.a().c()) {
            kg.a(3, f4691b, "Session already started with context:" + context);
        } else {
            kg.e(f4691b, "Session already started with context:" + context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        int iD = d();
        if (iD > 0) {
            kg.a(5, f4691b, "Session cannot be finalized, sessionContextCount:" + iD);
        } else {
            final lf lfVarE = e();
            if (lfVarE == null) {
                kg.a(5, f4691b, "Session cannot be finalized, current session not found");
            } else {
                kg.e(f4691b, "Flurry session ended");
                lg lgVar = new lg();
                lgVar.f4681b = lfVarE;
                lgVar.f4682c = lg.a.FINALIZE;
                lgVar.f4683d = je.a().d();
                lgVar.b();
                js.a().b(new ly() { // from class: com.flurry.sdk.lh.4
                    @Override // com.flurry.sdk.ly
                    public void a() {
                        lh.this.b(lfVarE);
                    }
                });
            }
        }
    }

    public synchronized void a(Context context) {
        if ((context instanceof Activity) && jw.a().c()) {
            kg.a(3, f4691b, "bootstrap for context:" + context);
            e(context);
        }
    }

    @Override // com.flurry.sdk.ll.a
    public void a(String str, Object obj) {
        if (!str.equals("ContinueSessionMillis")) {
            kg.a(6, f4691b, "onSettingUpdate internal error!");
        } else {
            this.g = ((Long) obj).longValue();
            kg.a(4, f4691b, "onSettingUpdate, ContinueSessionMillis = " + this.g);
        }
    }

    public synchronized void b(Context context) {
        if (!jw.a().c() || !(context instanceof Activity)) {
            kg.a(3, f4691b, "Manual onStartSession for context:" + context);
            e(context);
        }
    }

    public long c() {
        return this.f4695f;
    }

    public synchronized void c(Context context) {
        if (!jw.a().c() || !(context instanceof Activity)) {
            kg.a(3, f4691b, "Manual onEndSession for context:" + context);
            d(context);
        }
    }

    public synchronized int d() {
        return this.f4692c.size();
    }

    synchronized void d(Context context) {
        lf lfVarRemove = this.f4692c.remove(context);
        if (lfVarRemove != null) {
            kg.e(f4691b, "Flurry session paused for context:" + context);
            lg lgVar = new lg();
            lgVar.f4680a = new WeakReference<>(context);
            lgVar.f4681b = lfVarRemove;
            lgVar.f4683d = je.a().d();
            lgVar.f4682c = lg.a.END;
            lgVar.b();
            if (d() == 0) {
                this.f4693d.a(this.g);
                this.f4695f = System.currentTimeMillis();
            } else {
                this.f4695f = 0L;
            }
        } else if (jw.a().c()) {
            kg.a(3, f4691b, "Session cannot be ended, session not found for context:" + context);
        } else {
            kg.e(f4691b, "Session cannot be ended, session not found for context:" + context);
        }
    }

    public lf e() {
        lf lfVar;
        synchronized (this.f4694e) {
            lfVar = this.h;
        }
        return lfVar;
    }

    public synchronized boolean f() {
        boolean z;
        if (e() == null) {
            kg.a(2, f4691b, "Session not found. No active session");
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public synchronized void g() {
        for (Map.Entry<Context, lf> entry : this.f4692c.entrySet()) {
            lg lgVar = new lg();
            lgVar.f4680a = new WeakReference<>(entry.getKey());
            lgVar.f4681b = entry.getValue();
            lgVar.f4682c = lg.a.END;
            lgVar.f4683d = je.a().d();
            lgVar.b();
        }
        this.f4692c.clear();
        js.a().b(new ly() { // from class: com.flurry.sdk.lh.3
            @Override // com.flurry.sdk.ly
            public void a() {
                lh.this.i();
            }
        });
    }
}
