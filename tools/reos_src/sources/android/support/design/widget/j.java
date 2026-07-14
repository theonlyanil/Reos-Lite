package android.support.design.widget;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
abstract class j {
    static final int[] h = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] i = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] j = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f450a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable f451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Drawable f452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b f453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Drawable f454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f455f;
    float g;
    final VisibilityAwareImageButton k;
    final p l;
    private ViewTreeObserver.OnPreDrawListener m;

    interface a {
        void a();

        void b();
    }

    j(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        this.k = visibilityAwareImageButton;
        this.l = pVar;
    }

    private void l() {
        if (this.m == null) {
            this.m = new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.design.widget.j.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    j.this.e();
                    return true;
                }
            };
        }
    }

    abstract float a();

    b a(int i2, ColorStateList colorStateList) {
        Resources resources = this.k.getResources();
        b bVarJ = j();
        bVarJ.a(resources.getColor(android.support.design.a.c.design_fab_stroke_top_outer_color), resources.getColor(android.support.design.a.c.design_fab_stroke_top_inner_color), resources.getColor(android.support.design.a.c.design_fab_stroke_end_inner_color), resources.getColor(android.support.design.a.c.design_fab_stroke_end_outer_color));
        bVarJ.a(i2);
        bVarJ.a(colorStateList);
        return bVarJ;
    }

    abstract void a(float f2);

    abstract void a(int i2);

    abstract void a(ColorStateList colorStateList);

    abstract void a(ColorStateList colorStateList, PorterDuff.Mode mode, int i2, int i3);

    abstract void a(PorterDuff.Mode mode);

    abstract void a(Rect rect);

    abstract void a(a aVar, boolean z);

    abstract void a(int[] iArr);

    abstract void b();

    abstract void b(float f2);

    void b(Rect rect) {
    }

    abstract void b(a aVar, boolean z);

    abstract void c();

    final void c(float f2) {
        if (this.f455f != f2) {
            this.f455f = f2;
            a(f2);
        }
    }

    final void d(float f2) {
        if (this.g != f2) {
            this.g = f2;
            b(f2);
        }
    }

    boolean d() {
        return false;
    }

    void e() {
    }

    final Drawable f() {
        return this.f454e;
    }

    final void g() {
        Rect rect = this.f450a;
        a(rect);
        b(rect);
        this.l.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void h() {
        if (d()) {
            l();
            this.k.getViewTreeObserver().addOnPreDrawListener(this.m);
        }
    }

    void i() {
        if (this.m != null) {
            this.k.getViewTreeObserver().removeOnPreDrawListener(this.m);
            this.m = null;
        }
    }

    b j() {
        return new b();
    }

    GradientDrawable k() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
