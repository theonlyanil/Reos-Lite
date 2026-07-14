package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1034b;

    static void a(PopupWindow popupWindow, int i) {
        if (!f1034b) {
            try {
                f1033a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f1033a.setAccessible(true);
            } catch (Exception e2) {
            }
            f1034b = true;
        }
        if (f1033a != null) {
            try {
                f1033a.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception e3) {
            }
        }
    }
}
