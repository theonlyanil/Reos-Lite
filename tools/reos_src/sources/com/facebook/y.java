package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class y extends OutputStream implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<GraphRequest, ac> f4169a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f4170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GraphRequest f4171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ac f4172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4173e;

    y(Handler handler) {
        this.f4170b = handler;
    }

    int a() {
        return this.f4173e;
    }

    void a(long j) {
        if (this.f4172d == null) {
            this.f4172d = new ac(this.f4170b, this.f4171c);
            this.f4169a.put(this.f4171c, this.f4172d);
        }
        this.f4172d.b(j);
        this.f4173e = (int) (((long) this.f4173e) + j);
    }

    @Override // com.facebook.ab
    public void a(GraphRequest graphRequest) {
        this.f4171c = graphRequest;
        this.f4172d = graphRequest != null ? this.f4169a.get(graphRequest) : null;
    }

    Map<GraphRequest, ac> b() {
        return this.f4169a;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        a(1L);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        a(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        a(i2);
    }
}
