package android.support.v4.g;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f769b;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f768a = cls.getMethod("getScript", String.class);
                f769b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e2) {
            f768a = null;
            f769b = null;
            Log.w("ICUCompatIcs", e2);
        }
    }

    private static String a(String str) {
        try {
            if (f768a != null) {
                return (String) f768a.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompatIcs", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompatIcs", e3);
        }
        return null;
    }

    public static String a(Locale locale) {
        String strB = b(locale);
        if (strB != null) {
            return a(strB);
        }
        return null;
    }

    private static String b(Locale locale) {
        String string = locale.toString();
        try {
            if (f769b != null) {
                return (String) f769b.invoke(null, string);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompatIcs", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompatIcs", e3);
        }
        return string;
    }
}
