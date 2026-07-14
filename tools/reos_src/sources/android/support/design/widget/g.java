package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f431d;

    static boolean a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return Build.VERSION.SDK_INT >= 9 ? b(drawableContainer, constantState) : c(drawableContainer, constantState);
    }

    private static boolean b(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!f429b) {
            try {
                f428a = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                f428a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f429b = true;
        }
        if (f428a != null) {
            try {
                f428a.invoke(drawableContainer, constantState);
                return true;
            } catch (Exception e3) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }

    private static boolean c(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!f431d) {
            try {
                f430c = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
                f430c.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("DrawableUtils", "Could not fetch mDrawableContainerStateField. Oh well.");
            }
            f431d = true;
        }
        if (f430c != null) {
            try {
                f430c.set(drawableContainer, constantState);
                return true;
            } catch (Exception e3) {
                Log.e("DrawableUtils", "Could not set mDrawableContainerStateField. Oh well.");
            }
        }
        return false;
    }
}
