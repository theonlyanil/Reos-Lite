package android.support.v4.view;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class am {
    public static void a(View view, Object obj) {
        view.setAccessibilityDelegate((View.AccessibilityDelegate) obj);
    }

    public static void a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean b(View view, int i) {
        return view.canScrollVertically(i);
    }
}
