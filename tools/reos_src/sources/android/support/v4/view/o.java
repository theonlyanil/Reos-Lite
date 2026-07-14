package android.support.v4.view;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f935a;

    interface a {
        int a(ViewGroup.MarginLayoutParams marginLayoutParams);

        int b(ViewGroup.MarginLayoutParams marginLayoutParams);
    }

    static class b implements a {
        b() {
        }

        @Override // android.support.v4.view.o.a
        public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        @Override // android.support.v4.view.o.a
        public int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    static class c implements a {
        c() {
        }

        @Override // android.support.v4.view.o.a
        public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return p.a(marginLayoutParams);
        }

        @Override // android.support.v4.view.o.a
        public int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return p.b(marginLayoutParams);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f935a = new c();
        } else {
            f935a = new b();
        }
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f935a.a(marginLayoutParams);
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f935a.b(marginLayoutParams);
    }
}
