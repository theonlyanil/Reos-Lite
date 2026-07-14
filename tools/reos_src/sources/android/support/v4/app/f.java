package android.support.v4.app;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f629a;

    private static class a extends b {
        private a() {
            super();
        }

        @Override // android.support.v4.app.f.b
        public int a(Context context, String str, String str2) {
            return g.a(context, str, str2);
        }

        @Override // android.support.v4.app.f.b
        public String a(String str) {
            return g.a(str);
        }
    }

    private static class b {
        private b() {
        }

        public int a(Context context, String str, String str2) {
            return 1;
        }

        public String a(String str) {
            return null;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f629a = new a();
        } else {
            f629a = new b();
        }
    }

    public static int a(Context context, String str, String str2) {
        return f629a.a(context, str, str2);
    }

    public static String a(String str) {
        return f629a.a(str);
    }
}
