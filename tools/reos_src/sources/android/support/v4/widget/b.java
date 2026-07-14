package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f1015a;

    static class a extends d {
        a() {
        }

        @Override // android.support.v4.widget.b.C0025b, android.support.v4.widget.b.c
        public Drawable a(CompoundButton compoundButton) {
            return android.support.v4.widget.c.a(compoundButton);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.b$b, reason: collision with other inner class name */
    static class C0025b implements c {
        C0025b() {
        }

        @Override // android.support.v4.widget.b.c
        public Drawable a(CompoundButton compoundButton) {
            return android.support.v4.widget.d.a(compoundButton);
        }

        @Override // android.support.v4.widget.b.c
        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            android.support.v4.widget.d.a(compoundButton, colorStateList);
        }

        @Override // android.support.v4.widget.b.c
        public void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            android.support.v4.widget.d.a(compoundButton, mode);
        }
    }

    interface c {
        Drawable a(CompoundButton compoundButton);

        void a(CompoundButton compoundButton, ColorStateList colorStateList);

        void a(CompoundButton compoundButton, PorterDuff.Mode mode);
    }

    static class d extends C0025b {
        d() {
        }

        @Override // android.support.v4.widget.b.C0025b, android.support.v4.widget.b.c
        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            e.a(compoundButton, colorStateList);
        }

        @Override // android.support.v4.widget.b.C0025b, android.support.v4.widget.b.c
        public void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            e.a(compoundButton, mode);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f1015a = new a();
        } else if (i >= 21) {
            f1015a = new d();
        } else {
            f1015a = new C0025b();
        }
    }

    public static Drawable a(CompoundButton compoundButton) {
        return f1015a.a(compoundButton);
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1015a.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        f1015a.a(compoundButton, mode);
    }
}
