package android.support.design.widget;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes.dex */
class h extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    o f432a;
    private int m;
    private r n;
    private boolean o;

    private abstract class a extends Animation {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f440c;

        private a() {
        }

        protected abstract float a();

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            h.this.f432a.b(this.f439b + (this.f440c * f2));
        }

        @Override // android.view.animation.Animation
        public void reset() {
            super.reset();
            this.f439b = h.this.f432a.a();
            this.f440c = a() - this.f439b;
        }
    }

    private class b extends a {
        private b() {
            super();
        }

        @Override // android.support.design.widget.h.a
        protected float a() {
            return h.this.f455f + h.this.g;
        }
    }

    private class c extends a {
        private c() {
            super();
        }

        @Override // android.support.design.widget.h.a
        protected float a() {
            return h.this.f455f;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.m = visibilityAwareImageButton.getResources().getInteger(R.integer.config_shortAnimTime);
        this.n = new r();
        this.n.a(visibilityAwareImageButton);
        this.n.a(h, a(new b()));
        this.n.a(i, a(new b()));
        this.n.a(j, a(new c()));
    }

    private Animation a(Animation animation) {
        animation.setInterpolator(android.support.design.widget.a.f405b);
        animation.setDuration(this.m);
        return animation;
    }

    private static ColorStateList b(int i) {
        return new ColorStateList(new int[][]{i, h, new int[0]}, new int[]{i, i, 0});
    }

    @Override // android.support.design.widget.j
    float a() {
        return this.f455f;
    }

    @Override // android.support.design.widget.j
    void a(float f2) {
        if (this.f432a != null) {
            this.f432a.a(f2, this.g + f2);
            g();
        }
    }

    @Override // android.support.design.widget.j
    void a(int i) {
        if (this.f452c != null) {
            android.support.v4.c.a.a.a(this.f452c, b(i));
        }
    }

    @Override // android.support.design.widget.j
    void a(ColorStateList colorStateList) {
        if (this.f451b != null) {
            android.support.v4.c.a.a.a(this.f451b, colorStateList);
        }
        if (this.f453d != null) {
            this.f453d.a(colorStateList);
        }
    }

    @Override // android.support.design.widget.j
    void a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.f451b = android.support.v4.c.a.a.f(k());
        android.support.v4.c.a.a.a(this.f451b, colorStateList);
        if (mode != null) {
            android.support.v4.c.a.a.a(this.f451b, mode);
        }
        this.f452c = android.support.v4.c.a.a.f(k());
        android.support.v4.c.a.a.a(this.f452c, b(i));
        if (i2 > 0) {
            this.f453d = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.f453d, this.f451b, this.f452c};
        } else {
            this.f453d = null;
            drawableArr = new Drawable[]{this.f451b, this.f452c};
        }
        this.f454e = new LayerDrawable(drawableArr);
        this.f432a = new o(this.k.getResources(), this.f454e, this.l.a(), this.f455f, this.f455f + this.g);
        this.f432a.a(false);
        this.l.a(this.f432a);
    }

    @Override // android.support.design.widget.j
    void a(PorterDuff.Mode mode) {
        if (this.f451b != null) {
            android.support.v4.c.a.a.a(this.f451b, mode);
        }
    }

    @Override // android.support.design.widget.j
    void a(Rect rect) {
        this.f432a.getPadding(rect);
    }

    @Override // android.support.design.widget.j
    void a(final j.a aVar, final boolean z) {
        if (this.o || this.k.getVisibility() != 0) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), android.support.design.a.C0007a.design_fab_out);
            animationLoadAnimation.setInterpolator(android.support.design.widget.a.f406c);
            animationLoadAnimation.setDuration(200L);
            animationLoadAnimation.setAnimationListener(new android.support.design.widget.a.AnimationAnimationListenerC0009a() { // from class: android.support.design.widget.h.1
                @Override // android.support.design.widget.a.AnimationAnimationListenerC0009a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    h.this.o = false;
                    h.this.k.a(8, z);
                    if (aVar != null) {
                        aVar.b();
                    }
                }

                @Override // android.support.design.widget.a.AnimationAnimationListenerC0009a, android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    h.this.o = true;
                }
            });
            this.k.startAnimation(animationLoadAnimation);
        }
    }

    @Override // android.support.design.widget.j
    void a(int[] iArr) {
        this.n.a(iArr);
    }

    @Override // android.support.design.widget.j
    void b() {
        this.n.b();
    }

    @Override // android.support.design.widget.j
    void b(float f2) {
        if (this.f432a != null) {
            this.f432a.c(this.f455f + f2);
            g();
        }
    }

    @Override // android.support.design.widget.j
    void b(final j.a aVar, boolean z) {
        if (this.k.getVisibility() == 0 && !this.o) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        this.k.clearAnimation();
        this.k.a(0, z);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), android.support.design.a.C0007a.design_fab_in);
        animationLoadAnimation.setDuration(200L);
        animationLoadAnimation.setInterpolator(android.support.design.widget.a.f407d);
        animationLoadAnimation.setAnimationListener(new android.support.design.widget.a.AnimationAnimationListenerC0009a() { // from class: android.support.design.widget.h.2
            @Override // android.support.design.widget.a.AnimationAnimationListenerC0009a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        this.k.startAnimation(animationLoadAnimation);
    }

    @Override // android.support.design.widget.j
    void c() {
    }
}
