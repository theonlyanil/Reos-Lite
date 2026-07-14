package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f1032a;

    static {
        try {
            f1032a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1032a.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
        }
    }

    static void a(PopupWindow popupWindow, boolean z) {
        if (f1032a != null) {
            try {
                f1032a.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
            }
        }
    }
}
