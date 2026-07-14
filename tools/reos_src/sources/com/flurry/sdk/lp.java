package com.flurry.sdk;

/* JADX INFO: loaded from: classes.dex */
public class lp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4718a = lp.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4719b = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4720c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4721d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ly f4722e = new ly() { // from class: com.flurry.sdk.lp.1
        @Override // com.flurry.sdk.ly
        public void a() {
            new ln().b();
            if (lp.this.f4720c && lp.this.f4721d) {
                js.a().b(lp.this.f4722e, lp.this.f4719b);
            }
        }
    };

    public synchronized void a() {
        if (!this.f4721d) {
            js.a().b(this.f4722e, this.f4719b);
            this.f4721d = true;
        }
    }

    public void a(long j) {
        this.f4719b = j;
    }

    public void a(boolean z) {
        this.f4720c = z;
    }

    public synchronized void b() {
        if (this.f4721d) {
            js.a().c(this.f4722e);
            this.f4721d = false;
        }
    }
}
