package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class al {
    public static float a(View view) {
        return view.getAlpha();
    }

    public static int a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static int a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    static long a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View view, float f2) {
        view.setTranslationX(f2);
    }

    static void a(View view, int i) {
        view.offsetTopAndBottom(i);
        h(view);
        Object parent = view.getParent();
        if (parent instanceof View) {
            h((View) parent);
        }
    }

    public static void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static int b(View view) {
        return view.getLayerType();
    }

    public static void b(View view, float f2) {
        view.setTranslationY(f2);
    }

    static void b(View view, int i) {
        view.offsetLeftAndRight(i);
        h(view);
        Object parent = view.getParent();
        if (parent instanceof View) {
            h((View) parent);
        }
    }

    public static void b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static void c(View view, float f2) {
        view.setAlpha(f2);
    }

    public static int d(View view) {
        return view.getMeasuredState();
    }

    public static float e(View view) {
        return view.getTranslationX();
    }

    public static float f(View view) {
        return view.getTranslationY();
    }

    public static void g(View view) {
        view.jumpDrawablesToCurrentState();
    }

    private static void h(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
