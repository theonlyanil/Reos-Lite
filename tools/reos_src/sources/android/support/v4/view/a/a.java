package android.support.v4.view.a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f861a;

    /* JADX INFO: renamed from: android.support.v4.view.a.a$a, reason: collision with other inner class name */
    static class C0021a extends c {
        C0021a() {
        }
    }

    static class b extends C0021a {
        b() {
        }

        @Override // android.support.v4.view.a.a.c, android.support.v4.view.a.a.d
        public int a(AccessibilityEvent accessibilityEvent) {
            return android.support.v4.view.a.b.a(accessibilityEvent);
        }

        @Override // android.support.v4.view.a.a.c, android.support.v4.view.a.a.d
        public void a(AccessibilityEvent accessibilityEvent, int i) {
            android.support.v4.view.a.b.a(accessibilityEvent, i);
        }
    }

    static class c implements d {
        c() {
        }

        @Override // android.support.v4.view.a.a.d
        public int a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        @Override // android.support.v4.view.a.a.d
        public void a(AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    interface d {
        int a(AccessibilityEvent accessibilityEvent);

        void a(AccessibilityEvent accessibilityEvent, int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f861a = new b();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f861a = new C0021a();
        } else {
            f861a = new c();
        }
    }

    public static m a(AccessibilityEvent accessibilityEvent) {
        return new m(accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        f861a.a(accessibilityEvent, i);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return f861a.a(accessibilityEvent);
    }
}
