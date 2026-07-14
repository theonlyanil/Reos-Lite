package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public final class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f899a;

    static class a extends e {
        a() {
        }
    }

    interface b {
        void a(ViewParent viewParent, View view);

        void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean a(ViewParent viewParent, View view, float f2, float f3);

        boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z);

        boolean a(ViewParent viewParent, View view, View view2, int i);

        void b(ViewParent viewParent, View view, View view2, int i);
    }

    static class c extends a {
        c() {
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.view.ay.e, android.support.v4.view.ay.b
        public void a(ViewParent viewParent, View view) {
            az.a(viewParent, view);
        }

        @Override // android.support.v4.view.ay.e, android.support.v4.view.ay.b
        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            az.a(viewParent, view, i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ay.e, android.support.v4.view.ay.b
        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            az.a(viewParent, view, i, i2, iArr);
        }

        @Override // android.support.v4.view.ay.e, android.support.v4.view.ay.b
        public boolean a(ViewParent viewParent, View view, float f2, float f3) {
            return az.a(viewParent, view, f2, f3);
        }

        @Override // android.support.v4.view.ay.e, android.support.v4.view.ay.b
        public boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z) {
            return az.a(viewParent, view, f2, f3, z);
        }

        @Override // android.support.v4.view.ay.e, android.support.v4.view.ay.b
        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            return az.a(viewParent, view, view2, i);
        }

        @Override // android.support.v4.view.ay.e, android.support.v4.view.ay.b
        public void b(ViewParent viewParent, View view, View view2, int i) {
            az.b(viewParent, view, view2, i);
        }
    }

    static class e implements b {
        e() {
        }

        @Override // android.support.v4.view.ay.b
        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof z) {
                ((z) viewParent).onStopNestedScroll(view);
            }
        }

        @Override // android.support.v4.view.ay.b
        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof z) {
                ((z) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        @Override // android.support.v4.view.ay.b
        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof z) {
                ((z) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        @Override // android.support.v4.view.ay.b
        public boolean a(ViewParent viewParent, View view, float f2, float f3) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onNestedPreFling(view, f2, f3);
            }
            return false;
        }

        @Override // android.support.v4.view.ay.b
        public boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onNestedFling(view, f2, f3, z);
            }
            return false;
        }

        @Override // android.support.v4.view.ay.b
        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        @Override // android.support.v4.view.ay.b
        public void b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof z) {
                ((z) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f899a = new d();
            return;
        }
        if (i >= 19) {
            f899a = new c();
        } else if (i >= 14) {
            f899a = new a();
        } else {
            f899a = new e();
        }
    }

    public static void a(ViewParent viewParent, View view) {
        f899a.a(viewParent, view);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f899a.a(viewParent, view, i, i2, i3, i4);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f899a.a(viewParent, view, i, i2, iArr);
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        return f899a.a(viewParent, view, f2, f3);
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        return f899a.a(viewParent, view, f2, f3, z);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i) {
        return f899a.a(viewParent, view, view2, i);
    }

    public static void b(ViewParent viewParent, View view, View view2, int i) {
        f899a.b(viewParent, view, view2, i);
    }
}
