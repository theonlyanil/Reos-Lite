package android.support.v4.view;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c f898a;

    static class a extends f {
        a() {
        }

        @Override // android.support.v4.view.aw.f, android.support.v4.view.aw.c
        public void a(ViewGroup viewGroup, boolean z) {
            ax.a(viewGroup, z);
        }
    }

    static class b extends a {
        b() {
        }
    }

    interface c {
        void a(ViewGroup viewGroup, boolean z);
    }

    static class d extends b {
        d() {
        }
    }

    static class e extends d {
        e() {
        }
    }

    static class f implements c {
        f() {
        }

        @Override // android.support.v4.view.aw.c
        public void a(ViewGroup viewGroup, boolean z) {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f898a = new e();
            return;
        }
        if (i >= 18) {
            f898a = new d();
            return;
        }
        if (i >= 14) {
            f898a = new b();
        } else if (i >= 11) {
            f898a = new a();
        } else {
            f898a = new f();
        }
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        f898a.a(viewGroup, z);
    }
}
