package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f1004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f1006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1007d;

    static int a(TextView textView) {
        if (!f1007d) {
            f1006c = a("mMaxMode");
            f1007d = true;
        }
        if (f1006c != null && a(f1006c, textView) == 1) {
            if (!f1005b) {
                f1004a = a("mMaximum");
                f1005b = true;
            }
            if (f1004a != null) {
                return a(f1004a, textView);
            }
        }
        return -1;
    }

    private static int a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e2) {
            Log.d("TextViewCompatDonut", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    private static Field a(String str) {
        Field declaredField = null;
        try {
            declaredField = TextView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e2) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + str + " field.");
            return declaredField;
        }
    }
}
