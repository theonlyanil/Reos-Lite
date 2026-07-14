package android.support.v4.view;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class aq {
    public static void a(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public static boolean a(View view) {
        return view.isLaidOut();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }
}
