package com.facebook.b;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f3695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f3697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f3699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f3700f;
    private int g;

    public interface a {
        boolean a();

        void b();
    }

    private class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f3703a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f3705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private b f3706d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b f3707e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f3708f;

        static {
            f3703a = !ag.class.desiredAssertionStatus();
        }

        b(Runnable runnable) {
            this.f3705c = runnable;
        }

        b a(b bVar) {
            if (!f3703a && this.f3706d == null) {
                throw new AssertionError();
            }
            if (!f3703a && this.f3707e == null) {
                throw new AssertionError();
            }
            if (bVar == this) {
                bVar = this.f3706d == this ? null : this.f3706d;
            }
            this.f3706d.f3707e = this.f3707e;
            this.f3707e.f3706d = this.f3706d;
            this.f3707e = null;
            this.f3706d = null;
            return bVar;
        }

        b a(b bVar, boolean z) {
            b bVar2;
            if (!f3703a && this.f3706d != null) {
                throw new AssertionError();
            }
            if (!f3703a && this.f3707e != null) {
                throw new AssertionError();
            }
            if (bVar == null) {
                this.f3707e = this;
                this.f3706d = this;
                bVar2 = this;
            } else {
                this.f3706d = bVar;
                this.f3707e = bVar.f3707e;
                b bVar3 = this.f3706d;
                this.f3707e.f3706d = this;
                bVar3.f3707e = this;
                bVar2 = bVar;
            }
            return z ? this : bVar2;
        }

        void a(boolean z) {
            this.f3708f = z;
        }

        @Override // com.facebook.b.ag.a
        public boolean a() {
            synchronized (ag.this.f3696b) {
                if (c()) {
                    return false;
                }
                ag.this.f3697c = a(ag.this.f3697c);
                return true;
            }
        }

        @Override // com.facebook.b.ag.a
        public void b() {
            synchronized (ag.this.f3696b) {
                if (!c()) {
                    ag.this.f3697c = a(ag.this.f3697c);
                    ag.this.f3697c = a(ag.this.f3697c, true);
                }
            }
        }

        public boolean c() {
            return this.f3708f;
        }

        Runnable d() {
            return this.f3705c;
        }
    }

    static {
        f3695a = !ag.class.desiredAssertionStatus();
    }

    public ag() {
        this(8);
    }

    public ag(int i) {
        this(i, com.facebook.m.d());
    }

    public ag(int i, Executor executor) {
        this.f3696b = new Object();
        this.f3700f = null;
        this.g = 0;
        this.f3698d = i;
        this.f3699e = executor;
    }

    private void a() {
        a((b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        b bVar2 = null;
        synchronized (this.f3696b) {
            if (bVar != null) {
                this.f3700f = bVar.a(this.f3700f);
                this.g--;
                if (this.g < this.f3698d && (bVar2 = this.f3697c) != null) {
                    this.f3697c = bVar2.a(this.f3697c);
                    this.f3700f = bVar2.a(this.f3700f, false);
                    this.g++;
                    bVar2.a(true);
                }
            } else if (this.g < this.f3698d) {
                this.f3697c = bVar2.a(this.f3697c);
                this.f3700f = bVar2.a(this.f3700f, false);
                this.g++;
                bVar2.a(true);
            }
            throw th;
        }
        if (bVar2 != null) {
            b(bVar2);
        }
    }

    private void b(final b bVar) {
        this.f3699e.execute(new Runnable() { // from class: com.facebook.b.ag.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    bVar.d().run();
                } finally {
                    ag.this.a(bVar);
                }
            }
        });
    }

    public a a(Runnable runnable) {
        return a(runnable, true);
    }

    public a a(Runnable runnable, boolean z) {
        b bVar = new b(runnable);
        synchronized (this.f3696b) {
            this.f3697c = bVar.a(this.f3697c, z);
        }
        a();
        return bVar;
    }
}
