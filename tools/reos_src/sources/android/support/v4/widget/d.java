package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f1016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1017b;

    static Drawable a(CompoundButton compoundButton) {
        if (!f1017b) {
            try {
                f1016a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1016a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e2);
            }
            f1017b = true;
        }
        if (f1016a != null) {
            try {
                return (Drawable) f1016a.get(compoundButton);
            } catch (IllegalAccessException e3) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e3);
                f1016a = null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof ae) {
            ((ae) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (compoundButton instanceof ae) {
            ((ae) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
