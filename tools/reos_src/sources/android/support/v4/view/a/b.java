package android.support.v4.view.a;

import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
class b {
    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }
}
