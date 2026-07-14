package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f1875a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f1876b;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1876b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e2) {
            }
        }
    }

    static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return Build.VERSION.SDK_INT >= 11 ? PorterDuff.Mode.valueOf("ADD") : mode;
        }
    }

    public static Rect a(Drawable drawable) {
        if (f1876b != null) {
            try {
                Drawable drawableG = android.support.v4.c.a.a.g(drawable);
                Object objInvoke = drawableG.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(drawableG, new Object[0]);
                if (objInvoke != null) {
                    Rect rect = new Rect();
                    for (Field field : f1876b.getFields()) {
                        switch (field.getName()) {
                            case "left":
                                rect.left = field.getInt(objInvoke);
                                break;
                            case "top":
                                rect.top = field.getInt(objInvoke);
                                break;
                            case "right":
                                rect.right = field.getInt(objInvoke);
                                break;
                            case "bottom":
                                rect.bottom = field.getInt(objInvoke);
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f1875a;
    }

    static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            d(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(Drawable drawable) {
        if (drawable instanceof LayerDrawable) {
            return Build.VERSION.SDK_INT >= 16;
        }
        if (drawable instanceof InsetDrawable) {
            return Build.VERSION.SDK_INT >= 14;
        }
        if (drawable instanceof StateListDrawable) {
            return Build.VERSION.SDK_INT >= 8;
        }
        if (drawable instanceof GradientDrawable) {
            return Build.VERSION.SDK_INT >= 14;
        }
        if (!(drawable instanceof DrawableContainer)) {
            if (drawable instanceof android.support.v4.c.a.i) {
                return c(((android.support.v4.c.a.i) drawable).a());
            }
            if (drawable instanceof android.support.v7.d.a.a) {
                return c(((android.support.v7.d.a.a) drawable).b());
            }
            if (drawable instanceof ScaleDrawable) {
                return c(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return true;
        }
        Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
        for (Drawable drawable2 : children) {
            if (!c(drawable2)) {
                return false;
            }
        }
        return true;
    }

    private static void d(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(ak.f1738e);
        } else {
            drawable.setState(ak.h);
        }
        drawable.setState(state);
    }
}
