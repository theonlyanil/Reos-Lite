package android.support.v4.g;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Locale f783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f786d;

    private static class a {
        private a() {
        }

        private static int b(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case 1:
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }

        public int a(Locale locale) {
            if (locale != null && !locale.equals(f.f783a)) {
                String strA = android.support.v4.g.a.a(locale);
                if (strA == null) {
                    return b(locale);
                }
                if (strA.equalsIgnoreCase(f.f785c) || strA.equalsIgnoreCase(f.f786d)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    private static class b extends a {
        private b() {
            super();
        }

        @Override // android.support.v4.g.f.a
        public int a(Locale locale) {
            return g.a(locale);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f784b = new b();
        } else {
            f784b = new a();
        }
        f783a = new Locale("", "");
        f785c = "Arab";
        f786d = "Hebr";
    }

    public static int a(Locale locale) {
        return f784b.a(locale);
    }
}
