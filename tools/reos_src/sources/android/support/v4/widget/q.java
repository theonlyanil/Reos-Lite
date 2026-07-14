package android.support.v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final f f1031a;

    static class a extends e {
        a() {
        }

        @Override // android.support.v4.widget.q.c, android.support.v4.widget.q.f
        public void a(PopupWindow popupWindow, boolean z) {
            r.a(popupWindow, z);
        }
    }

    static class b extends a {
        b() {
        }

        @Override // android.support.v4.widget.q.d, android.support.v4.widget.q.c, android.support.v4.widget.q.f
        public void a(PopupWindow popupWindow, int i) {
            s.a(popupWindow, i);
        }

        @Override // android.support.v4.widget.q.a, android.support.v4.widget.q.c, android.support.v4.widget.q.f
        public void a(PopupWindow popupWindow, boolean z) {
            s.a(popupWindow, z);
        }
    }

    static class c implements f {
        c() {
        }

        @Override // android.support.v4.widget.q.f
        public void a(PopupWindow popupWindow, int i) {
        }

        @Override // android.support.v4.widget.q.f
        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }

        @Override // android.support.v4.widget.q.f
        public void a(PopupWindow popupWindow, boolean z) {
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.widget.q.c, android.support.v4.widget.q.f
        public void a(PopupWindow popupWindow, int i) {
            t.a(popupWindow, i);
        }
    }

    static class e extends d {
        e() {
        }

        @Override // android.support.v4.widget.q.c, android.support.v4.widget.q.f
        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            u.a(popupWindow, view, i, i2, i3);
        }
    }

    interface f {
        void a(PopupWindow popupWindow, int i);

        void a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void a(PopupWindow popupWindow, boolean z);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f1031a = new b();
            return;
        }
        if (i >= 21) {
            f1031a = new a();
            return;
        }
        if (i >= 19) {
            f1031a = new e();
        } else if (i >= 9) {
            f1031a = new d();
        } else {
            f1031a = new c();
        }
    }

    public static void a(PopupWindow popupWindow, int i) {
        f1031a.a(popupWindow, i);
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1031a.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        f1031a.a(popupWindow, z);
    }
}
