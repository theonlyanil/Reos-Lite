package android.support.v4.g;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f767a;

    static {
        try {
            f767a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String a(Locale locale) {
        try {
            return ((Locale) f767a.invoke(null, locale)).getScript();
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompatIcs", e3);
            return locale.getScript();
        }
    }
}
