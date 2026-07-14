package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompoundButton f1798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f1799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f1800c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f1801d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1802e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1803f = false;
    private boolean g;

    g(CompoundButton compoundButton, h hVar) {
        this.f1798a = compoundButton;
        this.f1799b = hVar;
    }

    int a(int i) {
        Drawable drawableA;
        return (Build.VERSION.SDK_INT >= 17 || (drawableA = android.support.v4.widget.b.a(this.f1798a)) == null) ? i : i + drawableA.getIntrinsicWidth();
    }

    ColorStateList a() {
        return this.f1800c;
    }

    void a(ColorStateList colorStateList) {
        this.f1800c = colorStateList;
        this.f1802e = true;
        d();
    }

    void a(PorterDuff.Mode mode) {
        this.f1801d = mode;
        this.f1803f = true;
        d();
    }

    void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f1798a.getContext().obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.CompoundButton, i, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.CompoundButton_android_button, 0)) != 0) {
                this.f1798a.setButtonDrawable(this.f1799b.a(this.f1798a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.CompoundButton_buttonTint)) {
                android.support.v4.widget.b.a(this.f1798a, typedArrayObtainStyledAttributes.getColorStateList(android.support.v7.b.a.k.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.CompoundButton_buttonTintMode)) {
                android.support.v4.widget.b.a(this.f1798a, w.a(typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    PorterDuff.Mode b() {
        return this.f1801d;
    }

    void c() {
        if (this.g) {
            this.g = false;
        } else {
            this.g = true;
            d();
        }
    }

    void d() {
        Drawable drawableA = android.support.v4.widget.b.a(this.f1798a);
        if (drawableA != null) {
            if (this.f1802e || this.f1803f) {
                Drawable drawableMutate = android.support.v4.c.a.a.f(drawableA).mutate();
                if (this.f1802e) {
                    android.support.v4.c.a.a.a(drawableMutate, this.f1800c);
                }
                if (this.f1803f) {
                    android.support.v4.c.a.a.a(drawableMutate, this.f1801d);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1798a.getDrawableState());
                }
                this.f1798a.setButtonDrawable(drawableMutate);
            }
        }
    }
}
