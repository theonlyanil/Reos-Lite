package android.support.v4.view;

import android.os.Build;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f931a;

    interface a {
        n a(LayoutInflater layoutInflater);

        void a(LayoutInflater layoutInflater, n nVar);
    }

    static class b implements a {
        b() {
        }

        @Override // android.support.v4.view.j.a
        public n a(LayoutInflater layoutInflater) {
            return k.a(layoutInflater);
        }

        @Override // android.support.v4.view.j.a
        public void a(LayoutInflater layoutInflater, n nVar) {
            k.a(layoutInflater, nVar);
        }
    }

    static class c extends b {
        c() {
        }

        @Override // android.support.v4.view.j.b, android.support.v4.view.j.a
        public void a(LayoutInflater layoutInflater, n nVar) {
            l.a(layoutInflater, nVar);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.view.j.c, android.support.v4.view.j.b, android.support.v4.view.j.a
        public void a(LayoutInflater layoutInflater, n nVar) {
            m.a(layoutInflater, nVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f931a = new d();
        } else if (i >= 11) {
            f931a = new c();
        } else {
            f931a = new b();
        }
    }

    public static n a(LayoutInflater layoutInflater) {
        return f931a.a(layoutInflater);
    }

    public static void a(LayoutInflater layoutInflater, n nVar) {
        f931a.a(layoutInflater, nVar);
    }
}
