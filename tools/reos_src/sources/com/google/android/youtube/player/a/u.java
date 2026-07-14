package com.google.android.youtube.player.a;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class u implements com.google.android.youtube.player.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f5345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f5346b;

    public u(e eVar, g gVar) {
        this.f5345a = (e) c.a(eVar, "connectionClient cannot be null");
        this.f5346b = (g) c.a(gVar, "embeddedPlayer cannot be null");
    }

    @Override // com.google.android.youtube.player.d
    public final int a() {
        try {
            return this.f5346b.h();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void a(Configuration configuration) {
        try {
            this.f5346b.a(configuration);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    @Override // com.google.android.youtube.player.d
    public final void a(String str) {
        a(str, 0);
    }

    public final void a(String str, int i) {
        try {
            this.f5346b.b(str, i);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void a(boolean z) {
        try {
            this.f5346b.a(z);
            this.f5345a.a(z);
            this.f5345a.d();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final boolean a(int i, KeyEvent keyEvent) {
        try {
            return this.f5346b.a(i, keyEvent);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final boolean a(Bundle bundle) {
        try {
            return this.f5346b.a(bundle);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    @Override // com.google.android.youtube.player.d
    public final int b() {
        try {
            return this.f5346b.i();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void b(boolean z) {
        try {
            this.f5346b.e(z);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final boolean b(int i, KeyEvent keyEvent) {
        try {
            return this.f5346b.b(i, keyEvent);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final View c() {
        try {
            return (View) x.a(this.f5346b.s());
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void d() {
        try {
            this.f5346b.m();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void e() {
        try {
            this.f5346b.n();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void f() {
        try {
            this.f5346b.o();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void g() {
        try {
            this.f5346b.p();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void h() {
        try {
            this.f5346b.q();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void i() {
        try {
            this.f5346b.l();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final Bundle j() {
        try {
            return this.f5346b.r();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }
}
