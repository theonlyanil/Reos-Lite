package android.support.v4.g;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final InterfaceC0018a f766a;

    /* JADX INFO: renamed from: android.support.v4.g.a$a, reason: collision with other inner class name */
    interface InterfaceC0018a {
        String a(Locale locale);
    }

    static class b implements InterfaceC0018a {
        b() {
        }

        @Override // android.support.v4.g.a.InterfaceC0018a
        public String a(Locale locale) {
            return null;
        }
    }

    static class c implements InterfaceC0018a {
        c() {
        }

        @Override // android.support.v4.g.a.InterfaceC0018a
        public String a(Locale locale) {
            return android.support.v4.g.c.a(locale);
        }
    }

    static class d implements InterfaceC0018a {
        d() {
        }

        @Override // android.support.v4.g.a.InterfaceC0018a
        public String a(Locale locale) {
            return android.support.v4.g.b.a(locale);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f766a = new d();
        } else if (i >= 14) {
            f766a = new c();
        } else {
            f766a = new b();
        }
    }

    public static String a(Locale locale) {
        return f766a.a(locale);
    }
}
