package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadLocal<Rect> f895a;

    private static Rect a() {
        if (f895a == null) {
            f895a = new ThreadLocal<>();
        }
        Rect rect = f895a.get();
        if (rect == null) {
            rect = new Rect();
            f895a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static bh a(View view, bh bhVar) {
        WindowInsets windowInsetsG;
        WindowInsets windowInsetsOnApplyWindowInsets;
        return (!(bhVar instanceof bi) || (windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets((windowInsetsG = ((bi) bhVar).g()))) == windowInsetsG) ? bhVar : new bi(windowInsetsOnApplyWindowInsets);
    }

    public static void a(View view) {
        view.requestApplyInsets();
    }

    public static void a(View view, float f2) {
        view.setElevation(f2);
    }

    static void a(View view, int i) {
        boolean z;
        Rect rectA = a();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectA.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectA.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        al.a(view, i);
        if (z && rectA.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectA);
        }
    }

    static void a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    static void a(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void a(View view, final ab abVar) {
        if (abVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ar.1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return ((bi) abVar.a(view2, new bi(windowInsets))).g();
                }
            });
        }
    }

    public static float b(View view) {
        return view.getElevation();
    }

    public static bh b(View view, bh bhVar) {
        WindowInsets windowInsetsG;
        WindowInsets windowInsetsDispatchApplyWindowInsets;
        return (!(bhVar instanceof bi) || (windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets((windowInsetsG = ((bi) bhVar).g()))) == windowInsetsG) ? bhVar : new bi(windowInsetsDispatchApplyWindowInsets);
    }

    static void b(View view, int i) {
        boolean z;
        Rect rectA = a();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectA.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectA.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        al.b(view, i);
        if (z && rectA.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectA);
        }
    }

    public static float c(View view) {
        return view.getTranslationZ();
    }

    static ColorStateList d(View view) {
        return view.getBackgroundTintList();
    }

    static PorterDuff.Mode e(View view) {
        return view.getBackgroundTintMode();
    }

    public static void f(View view) {
        view.stopNestedScroll();
    }

    public static float g(View view) {
        return view.getZ();
    }
}
