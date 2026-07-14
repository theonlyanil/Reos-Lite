package com.facebook;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GraphRequest f3611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f3613c = m.h();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3616f;

    ac(Handler handler, GraphRequest graphRequest) {
        this.f3611a = graphRequest;
        this.f3612b = handler;
    }

    void a() {
        if (this.f3614d > this.f3615e) {
            GraphRequest.b bVarG = this.f3611a.g();
            if (this.f3616f <= 0 || !(bVarG instanceof GraphRequest.e)) {
                return;
            }
            final long j = this.f3614d;
            final long j2 = this.f3616f;
            final GraphRequest.e eVar = (GraphRequest.e) bVarG;
            if (this.f3612b == null) {
                eVar.a(j, j2);
            } else {
                this.f3612b.post(new Runnable() { // from class: com.facebook.ac.1
                    @Override // java.lang.Runnable
                    public void run() {
                        eVar.a(j, j2);
                    }
                });
            }
            this.f3615e = this.f3614d;
        }
    }

    void a(long j) {
        this.f3614d += j;
        if (this.f3614d >= this.f3615e + this.f3613c || this.f3614d >= this.f3616f) {
            a();
        }
    }

    void b(long j) {
        this.f3616f += j;
    }
}
