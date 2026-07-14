package android.support.design.widget;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class k extends i {
    private final Interpolator m;
    private InsetDrawable n;

    k(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.m = visibilityAwareImageButton.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.k.getContext(), R.interpolator.fast_out_slow_in);
    }

    private Animator a(Animator animator) {
        animator.setInterpolator(this.m);
        return animator;
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    public float a() {
        return this.k.getElevation();
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    public void a(float f2) {
        this.k.setElevation(f2);
        if (this.l.b()) {
            g();
        }
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void a(int i) {
        if (this.f452c instanceof RippleDrawable) {
            ((RippleDrawable) this.f452c).setColor(ColorStateList.valueOf(i));
        } else {
            super.a(i);
        }
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.f451b = android.support.v4.c.a.a.f(k());
        android.support.v4.c.a.a.a(this.f451b, colorStateList);
        if (mode != null) {
            android.support.v4.c.a.a.a(this.f451b, mode);
        }
        if (i2 > 0) {
            this.f453d = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.f453d, this.f451b});
        } else {
            this.f453d = null;
            layerDrawable = this.f451b;
        }
        this.f452c = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.f454e = this.f452c;
        this.l.a(this.f452c);
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void a(Rect rect) {
        if (!this.l.b()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        float fA = this.l.a();
        float fA2 = a() + this.g;
        int iCeil = (int) Math.ceil(o.b(fA2, fA, false));
        int iCeil2 = (int) Math.ceil(o.a(fA2, fA, false));
        rect.set(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void a(int[] iArr) {
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void b() {
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void b(float f2) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(h, a(ObjectAnimator.ofFloat(this.k, "translationZ", f2)));
        stateListAnimator.addState(i, a(ObjectAnimator.ofFloat(this.k, "translationZ", f2)));
        stateListAnimator.addState(j, a(ObjectAnimator.ofFloat(this.k, "translationZ", BitmapDescriptorFactory.HUE_RED)));
        this.k.setStateListAnimator(stateListAnimator);
        if (this.l.b()) {
            g();
        }
    }

    @Override // android.support.design.widget.j
    void b(Rect rect) {
        if (!this.l.b()) {
            this.l.a(this.f452c);
        } else {
            this.n = new InsetDrawable(this.f452c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.a(this.n);
        }
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void c() {
        g();
    }

    @Override // android.support.design.widget.i, android.support.design.widget.j
    boolean d() {
        return false;
    }

    @Override // android.support.design.widget.j
    b j() {
        return new c();
    }
}
