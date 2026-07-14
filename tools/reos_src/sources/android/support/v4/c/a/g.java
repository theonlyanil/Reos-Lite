package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class g {
    public static void a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable b(Drawable drawable) {
        return !(drawable instanceof o) ? new m(drawable) : drawable;
    }

    public static int c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
