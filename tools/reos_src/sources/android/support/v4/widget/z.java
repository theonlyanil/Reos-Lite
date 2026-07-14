package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final f f1037a;

    static class a extends d {
        a() {
        }
    }

    static class b implements f {
        b() {
        }

        @Override // android.support.v4.widget.z.f
        public int a(TextView textView) {
            return aa.a(textView);
        }

        @Override // android.support.v4.widget.z.f
        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    static class c extends e {
        c() {
        }

        @Override // android.support.v4.widget.z.b, android.support.v4.widget.z.f
        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            ac.a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.widget.z.c, android.support.v4.widget.z.b, android.support.v4.widget.z.f
        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            ad.a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    static class e extends b {
        e() {
        }

        @Override // android.support.v4.widget.z.b, android.support.v4.widget.z.f
        public int a(TextView textView) {
            return ab.a(textView);
        }
    }

    interface f {
        int a(TextView textView);

        void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f1037a = new a();
            return;
        }
        if (i >= 18) {
            f1037a = new d();
            return;
        }
        if (i >= 17) {
            f1037a = new c();
        } else if (i >= 16) {
            f1037a = new e();
        } else {
            f1037a = new b();
        }
    }

    public static int a(TextView textView) {
        return f1037a.a(textView);
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1037a.a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
