package android.support.v4.app;

import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class ar extends at.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final at.a.InterfaceC0012a f617a;
    private static final a g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CharSequence[] f620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Bundle f622f;

    interface a {
    }

    static class b implements a {
        b() {
        }
    }

    static class c implements a {
        c() {
        }
    }

    static class d implements a {
        d() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            g = new b();
        } else if (Build.VERSION.SDK_INT >= 16) {
            g = new d();
        } else {
            g = new c();
        }
        f617a = new at.a.InterfaceC0012a() { // from class: android.support.v4.app.ar.1
        };
    }

    @Override // android.support.v4.app.at.a
    public String a() {
        return this.f618b;
    }

    @Override // android.support.v4.app.at.a
    public CharSequence b() {
        return this.f619c;
    }

    @Override // android.support.v4.app.at.a
    public CharSequence[] c() {
        return this.f620d;
    }

    @Override // android.support.v4.app.at.a
    public boolean d() {
        return this.f621e;
    }

    @Override // android.support.v4.app.at.a
    public Bundle e() {
        return this.f622f;
    }
}
