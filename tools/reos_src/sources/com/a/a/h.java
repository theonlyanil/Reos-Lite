package com.a.a;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.a.a.d.b.c f2413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.a.d.b.a.c f2414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.a.a.d.b.b.h f2415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExecutorService f2416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ExecutorService f2417f;
    private com.a.a.d.a g;
    private com.a.a.d.b.b.a.InterfaceC0040a h;

    public h(Context context) {
        this.f2412a = context.getApplicationContext();
    }

    g a() {
        if (this.f2416e == null) {
            this.f2416e = new com.a.a.d.b.c.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f2417f == null) {
            this.f2417f = new com.a.a.d.b.c.a(1);
        }
        com.a.a.d.b.b.i iVar = new com.a.a.d.b.b.i(this.f2412a);
        if (this.f2414c == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f2414c = new com.a.a.d.b.a.f(iVar.b());
            } else {
                this.f2414c = new com.a.a.d.b.a.d();
            }
        }
        if (this.f2415d == null) {
            this.f2415d = new com.a.a.d.b.b.g(iVar.a());
        }
        if (this.h == null) {
            this.h = new com.a.a.d.b.b.f(this.f2412a);
        }
        if (this.f2413b == null) {
            this.f2413b = new com.a.a.d.b.c(this.f2415d, this.h, this.f2417f, this.f2416e);
        }
        if (this.g == null) {
            this.g = com.a.a.d.a.f2024d;
        }
        return new g(this.f2413b, this.f2415d, this.f2414c, this.f2412a, this.g);
    }
}
