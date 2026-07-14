package e;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class j extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f6454a;

    public j(u uVar) {
        if (uVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f6454a = uVar;
    }

    public final j a(u uVar) {
        if (uVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f6454a = uVar;
        return this;
    }

    public final u a() {
        return this.f6454a;
    }

    @Override // e.u
    public u a(long j) {
        return this.f6454a.a(j);
    }

    @Override // e.u
    public u a(long j, TimeUnit timeUnit) {
        return this.f6454a.a(j, timeUnit);
    }

    @Override // e.u
    public long d() {
        return this.f6454a.d();
    }

    @Override // e.u
    public u f() {
        return this.f6454a.f();
    }

    @Override // e.u
    public void g() throws IOException {
        this.f6454a.g();
    }

    @Override // e.u
    public long g_() {
        return this.f6454a.g_();
    }

    @Override // e.u
    public boolean h_() {
        return this.f6454a.h_();
    }

    @Override // e.u
    public u i_() {
        return this.f6454a.i_();
    }
}
