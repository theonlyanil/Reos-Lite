package android.support.v4.b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f717a;

    interface a {
        Intent a(ComponentName componentName);
    }

    static class b implements a {
        b() {
        }

        @Override // android.support.v4.b.g.a
        public Intent a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    static class c extends b {
        c() {
        }

        @Override // android.support.v4.b.g.b, android.support.v4.b.g.a
        public Intent a(ComponentName componentName) {
            return h.a(componentName);
        }
    }

    static class d extends c {
        d() {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 15) {
            f717a = new d();
        } else if (i >= 11) {
            f717a = new c();
        } else {
            f717a = new b();
        }
    }

    public static Intent a(ComponentName componentName) {
        return f717a.a(componentName);
    }
}
