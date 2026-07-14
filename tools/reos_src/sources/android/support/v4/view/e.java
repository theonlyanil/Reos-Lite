package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f929a;

    interface a {
        int a(int i, int i2);

        void a(int i, int i2, int i3, Rect rect, Rect rect2, int i4);
    }

    static class b implements a {
        b() {
        }

        @Override // android.support.v4.view.e.a
        public int a(int i, int i2) {
            return (-8388609) & i;
        }

        @Override // android.support.v4.view.e.a
        public void a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    static class c implements a {
        c() {
        }

        @Override // android.support.v4.view.e.a
        public int a(int i, int i2) {
            return f.a(i, i2);
        }

        @Override // android.support.v4.view.e.a
        public void a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            f.a(i, i2, i3, rect, rect2, i4);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f929a = new c();
        } else {
            f929a = new b();
        }
    }

    public static int a(int i, int i2) {
        return f929a.a(i, i2);
    }

    public static void a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f929a.a(i, i2, i3, rect, rect2, i4);
    }
}
