package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f748a;

    /* JADX INFO: renamed from: android.support.v4.c.a.a$a, reason: collision with other inner class name */
    static class C0016a implements b {
        C0016a() {
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable) {
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable, float f2, float f3) {
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable, int i) {
            android.support.v4.c.a.c.a(drawable, i);
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable, ColorStateList colorStateList) {
            android.support.v4.c.a.c.a(drawable, colorStateList);
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable, Resources.Theme theme) {
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            android.support.v4.c.a.c.a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable, PorterDuff.Mode mode) {
            android.support.v4.c.a.c.a(drawable, mode);
        }

        @Override // android.support.v4.c.a.a.b
        public void a(Drawable drawable, boolean z) {
        }

        @Override // android.support.v4.c.a.a.b
        public void b(Drawable drawable, int i) {
        }

        @Override // android.support.v4.c.a.a.b
        public boolean b(Drawable drawable) {
            return false;
        }

        @Override // android.support.v4.c.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.c.a.c.a(drawable);
        }

        @Override // android.support.v4.c.a.a.b
        public int d(Drawable drawable) {
            return 0;
        }

        @Override // android.support.v4.c.a.a.b
        public int e(Drawable drawable) {
            return 0;
        }

        @Override // android.support.v4.c.a.a.b
        public boolean f(Drawable drawable) {
            return false;
        }

        @Override // android.support.v4.c.a.a.b
        public ColorFilter g(Drawable drawable) {
            return null;
        }
    }

    interface b {
        void a(Drawable drawable);

        void a(Drawable drawable, float f2, float f3);

        void a(Drawable drawable, int i);

        void a(Drawable drawable, int i, int i2, int i3, int i4);

        void a(Drawable drawable, ColorStateList colorStateList);

        void a(Drawable drawable, Resources.Theme theme);

        void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException;

        void a(Drawable drawable, PorterDuff.Mode mode);

        void a(Drawable drawable, boolean z);

        void b(Drawable drawable, int i);

        boolean b(Drawable drawable);

        Drawable c(Drawable drawable);

        int d(Drawable drawable);

        int e(Drawable drawable);

        boolean f(Drawable drawable);

        ColorFilter g(Drawable drawable);
    }

    static class c extends C0016a {
        c() {
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.c.a.d.a(drawable);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable) {
            android.support.v4.c.a.e.a(drawable);
        }

        @Override // android.support.v4.c.a.a.c, android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.c.a.e.b(drawable);
        }
    }

    static class e extends d {
        e() {
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void b(Drawable drawable, int i) {
            android.support.v4.c.a.f.a(drawable, i);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public int d(Drawable drawable) {
            int iA = android.support.v4.c.a.f.a(drawable);
            if (iA >= 0) {
                return iA;
            }
            return 0;
        }
    }

    static class f extends e {
        f() {
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable, boolean z) {
            android.support.v4.c.a.g.a(drawable, z);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public boolean b(Drawable drawable) {
            return android.support.v4.c.a.g.a(drawable);
        }

        @Override // android.support.v4.c.a.a.d, android.support.v4.c.a.a.c, android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.c.a.g.b(drawable);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public int e(Drawable drawable) {
            return android.support.v4.c.a.g.c(drawable);
        }
    }

    static class g extends f {
        g() {
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable, float f2, float f3) {
            android.support.v4.c.a.h.a(drawable, f2, f3);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable, int i) {
            android.support.v4.c.a.h.a(drawable, i);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
            android.support.v4.c.a.h.a(drawable, i, i2, i3, i4);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable, ColorStateList colorStateList) {
            android.support.v4.c.a.h.a(drawable, colorStateList);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable, Resources.Theme theme) {
            android.support.v4.c.a.h.a(drawable, theme);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            android.support.v4.c.a.h.a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void a(Drawable drawable, PorterDuff.Mode mode) {
            android.support.v4.c.a.h.a(drawable, mode);
        }

        @Override // android.support.v4.c.a.a.f, android.support.v4.c.a.a.d, android.support.v4.c.a.a.c, android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public Drawable c(Drawable drawable) {
            return android.support.v4.c.a.h.a(drawable);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public boolean f(Drawable drawable) {
            return android.support.v4.c.a.h.b(drawable);
        }

        @Override // android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public ColorFilter g(Drawable drawable) {
            return android.support.v4.c.a.h.c(drawable);
        }
    }

    static class h extends g {
        h() {
        }

        @Override // android.support.v4.c.a.a.e, android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public void b(Drawable drawable, int i) {
            android.support.v4.c.a.b.a(drawable, i);
        }

        @Override // android.support.v4.c.a.a.g, android.support.v4.c.a.a.f, android.support.v4.c.a.a.d, android.support.v4.c.a.a.c, android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public Drawable c(Drawable drawable) {
            return drawable;
        }

        @Override // android.support.v4.c.a.a.e, android.support.v4.c.a.a.C0016a, android.support.v4.c.a.a.b
        public int d(Drawable drawable) {
            return android.support.v4.c.a.b.a(drawable);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f748a = new h();
            return;
        }
        if (i >= 21) {
            f748a = new g();
            return;
        }
        if (i >= 19) {
            f748a = new f();
            return;
        }
        if (i >= 17) {
            f748a = new e();
            return;
        }
        if (i >= 11) {
            f748a = new d();
        } else if (i >= 5) {
            f748a = new c();
        } else {
            f748a = new C0016a();
        }
    }

    public static void a(Drawable drawable) {
        f748a.a(drawable);
    }

    public static void a(Drawable drawable, float f2, float f3) {
        f748a.a(drawable, f2, f3);
    }

    public static void a(Drawable drawable, int i) {
        f748a.a(drawable, i);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        f748a.a(drawable, i, i2, i3, i4);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        f748a.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        f748a.a(drawable, theme);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        f748a.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        f748a.a(drawable, mode);
    }

    public static void a(Drawable drawable, boolean z) {
        f748a.a(drawable, z);
    }

    public static void b(Drawable drawable, int i) {
        f748a.b(drawable, i);
    }

    public static boolean b(Drawable drawable) {
        return f748a.b(drawable);
    }

    public static int c(Drawable drawable) {
        return f748a.e(drawable);
    }

    public static boolean d(Drawable drawable) {
        return f748a.f(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return f748a.g(drawable);
    }

    public static Drawable f(Drawable drawable) {
        return f748a.c(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T g(Drawable drawable) {
        return drawable instanceof i ? (T) ((i) drawable).a() : drawable;
    }

    public static int h(Drawable drawable) {
        return f748a.d(drawable);
    }
}
