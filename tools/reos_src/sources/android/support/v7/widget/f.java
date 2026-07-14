package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f1793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f1794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private an f1795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private an f1796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private an f1797e;

    f(View view, h hVar) {
        this.f1793a = view;
        this.f1794b = hVar;
    }

    private boolean b(Drawable drawable) {
        if (this.f1797e == null) {
            this.f1797e = new an();
        }
        an anVar = this.f1797e;
        anVar.a();
        ColorStateList colorStateListA = android.support.v4.view.ah.A(this.f1793a);
        if (colorStateListA != null) {
            anVar.f1746d = true;
            anVar.f1743a = colorStateListA;
        }
        PorterDuff.Mode modeB = android.support.v4.view.ah.B(this.f1793a);
        if (modeB != null) {
            anVar.f1745c = true;
            anVar.f1744b = modeB;
        }
        if (!anVar.f1746d && !anVar.f1745c) {
            return false;
        }
        h.a(drawable, anVar, this.f1793a.getDrawableState());
        return true;
    }

    ColorStateList a() {
        if (this.f1796d != null) {
            return this.f1796d.f1743a;
        }
        return null;
    }

    void a(int i) {
        b(this.f1794b != null ? this.f1794b.b(this.f1793a.getContext(), i) : null);
    }

    void a(ColorStateList colorStateList) {
        if (this.f1796d == null) {
            this.f1796d = new an();
        }
        this.f1796d.f1743a = colorStateList;
        this.f1796d.f1746d = true;
        c();
    }

    void a(PorterDuff.Mode mode) {
        if (this.f1796d == null) {
            this.f1796d = new an();
        }
        this.f1796d.f1744b = mode;
        this.f1796d.f1745c = true;
        c();
    }

    void a(Drawable drawable) {
        b((ColorStateList) null);
    }

    void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListB;
        TypedArray typedArrayObtainStyledAttributes = this.f1793a.getContext().obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.ViewBackgroundHelper, i, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.ViewBackgroundHelper_android_background) && (colorStateListB = this.f1794b.b(this.f1793a.getContext(), typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.ViewBackgroundHelper_android_background, -1))) != null) {
                b(colorStateListB);
            }
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.ViewBackgroundHelper_backgroundTint)) {
                android.support.v4.view.ah.a(this.f1793a, typedArrayObtainStyledAttributes.getColorStateList(android.support.v7.b.a.k.ViewBackgroundHelper_backgroundTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.ViewBackgroundHelper_backgroundTintMode)) {
                android.support.v4.view.ah.a(this.f1793a, w.a(typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    PorterDuff.Mode b() {
        if (this.f1796d != null) {
            return this.f1796d.f1744b;
        }
        return null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1795c == null) {
                this.f1795c = new an();
            }
            this.f1795c.f1743a = colorStateList;
            this.f1795c.f1746d = true;
        } else {
            this.f1795c = null;
        }
        c();
    }

    void c() {
        Drawable background = this.f1793a.getBackground();
        if (background != null) {
            if (Build.VERSION.SDK_INT == 21 && b(background)) {
                return;
            }
            if (this.f1796d != null) {
                h.a(background, this.f1796d, this.f1793a.getDrawableState());
            } else if (this.f1795c != null) {
                h.a(background, this.f1795c, this.f1793a.getDrawableState());
            }
        }
    }
}
