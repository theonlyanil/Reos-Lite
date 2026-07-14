package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class w extends u.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ValueAnimator f508a = new ValueAnimator();

    w() {
    }

    @Override // android.support.design.widget.u.e
    public void a() {
        this.f508a.start();
    }

    @Override // android.support.design.widget.u.e
    public void a(float f2, float f3) {
        this.f508a.setFloatValues(f2, f3);
    }

    @Override // android.support.design.widget.u.e
    public void a(int i) {
        this.f508a.setDuration(i);
    }

    @Override // android.support.design.widget.u.e
    public void a(int i, int i2) {
        this.f508a.setIntValues(i, i2);
    }

    @Override // android.support.design.widget.u.e
    public void a(final u.e.a aVar) {
        this.f508a.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.w.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                aVar.c();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                aVar.b();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                aVar.a();
            }
        });
    }

    @Override // android.support.design.widget.u.e
    public void a(final u.e.b bVar) {
        this.f508a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.w.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                bVar.a();
            }
        });
    }

    @Override // android.support.design.widget.u.e
    public void a(Interpolator interpolator) {
        this.f508a.setInterpolator(interpolator);
    }

    @Override // android.support.design.widget.u.e
    public boolean b() {
        return this.f508a.isRunning();
    }

    @Override // android.support.design.widget.u.e
    public int c() {
        return ((Integer) this.f508a.getAnimatedValue()).intValue();
    }

    @Override // android.support.design.widget.u.e
    public float d() {
        return ((Float) this.f508a.getAnimatedValue()).floatValue();
    }

    @Override // android.support.design.widget.u.e
    public void e() {
        this.f508a.cancel();
    }

    @Override // android.support.design.widget.u.e
    public float f() {
        return this.f508a.getAnimatedFraction();
    }

    @Override // android.support.design.widget.u.e
    public long g() {
        return this.f508a.getDuration();
    }
}
