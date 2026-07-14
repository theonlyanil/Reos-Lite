package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class e {
    public static void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable) {
        return !(drawable instanceof o) ? new l(drawable) : drawable;
    }
}
