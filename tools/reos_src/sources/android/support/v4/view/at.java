package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final e f897a;

    static class a implements e {
        a() {
        }

        @Override // android.support.v4.view.at.e
        public int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        @Override // android.support.v4.view.at.e
        public boolean b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class b extends a {
        b() {
        }

        @Override // android.support.v4.view.at.a, android.support.v4.view.at.e
        public int a(ViewConfiguration viewConfiguration) {
            return au.a(viewConfiguration);
        }
    }

    static class c extends b {
        c() {
        }

        @Override // android.support.v4.view.at.a, android.support.v4.view.at.e
        public boolean b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.view.at.c, android.support.v4.view.at.a, android.support.v4.view.at.e
        public boolean b(ViewConfiguration viewConfiguration) {
            return av.a(viewConfiguration);
        }
    }

    interface e {
        int a(ViewConfiguration viewConfiguration);

        boolean b(ViewConfiguration viewConfiguration);
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f897a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            f897a = new c();
        } else if (Build.VERSION.SDK_INT >= 8) {
            f897a = new b();
        } else {
            f897a = new a();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return f897a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return f897a.b(viewConfiguration);
    }
}
