package android.support.design.widget;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final u.d f414a = new u.d() { // from class: android.support.design.widget.ab.1
        @Override // android.support.design.widget.u.d
        public u a() {
            return new u(Build.VERSION.SDK_INT >= 12 ? new w() : new v());
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f415b;

    private interface a {
    }

    private static class b implements a {
        private b() {
        }
    }

    private static class c implements a {
        private c() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f415b = new c();
        } else {
            f415b = new b();
        }
    }

    static u a() {
        return f414a.a();
    }
}
