package android.support.v4.c.a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f752d;

    public static int a(Drawable drawable) {
        if (!f752d) {
            try {
                f751c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f751c.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e2);
            }
            f752d = true;
        }
        if (f751c != null) {
            try {
                return ((Integer) f751c.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e3) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e3);
                f751c = null;
            }
        }
        return -1;
    }

    public static void a(Drawable drawable, int i) {
        if (!f750b) {
            try {
                f749a = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f749a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e2);
            }
            f750b = true;
        }
        if (f749a != null) {
            try {
                f749a.invoke(drawable, Integer.valueOf(i));
            } catch (Exception e3) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e3);
                f749a = null;
            }
        }
    }
}
