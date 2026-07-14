package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f894d;

    /* JADX WARN: Multi-variable type inference failed */
    static ColorStateList a(View view) {
        if (view instanceof ae) {
            return ((ae) view).getSupportBackgroundTintList();
        }
        return null;
    }

    static void a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                view.invalidate();
            } else {
                int iAbs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - iAbs, view.getRight(), top + view.getHeight() + iAbs);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(View view, ColorStateList colorStateList) {
        if (view instanceof ae) {
            ((ae) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(View view, PorterDuff.Mode mode) {
        if (view instanceof ae) {
            ((ae) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static PorterDuff.Mode b(View view) {
        if (view instanceof ae) {
            return ((ae) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    static void b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                view.invalidate();
            } else {
                int iAbs = Math.abs(i);
                ((View) parent).invalidate(left - iAbs, view.getTop(), left + view.getWidth() + iAbs, view.getBottom());
            }
        }
    }

    static boolean c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int d(View view) {
        if (!f892b) {
            try {
                f891a = View.class.getDeclaredField("mMinWidth");
                f891a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            f892b = true;
        }
        if (f891a != null) {
            try {
                return ((Integer) f891a.get(view)).intValue();
            } catch (Exception e3) {
            }
        }
        return 0;
    }

    static int e(View view) {
        if (!f894d) {
            try {
                f893c = View.class.getDeclaredField("mMinHeight");
                f893c.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            f894d = true;
        }
        if (f893c != null) {
            try {
                return ((Integer) f893c.get(view)).intValue();
            } catch (Exception e3) {
            }
        }
        return 0;
    }

    static boolean f(View view) {
        return view.getWindowToken() != null;
    }
}
