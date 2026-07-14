package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Interpolator f404a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Interpolator f405b = new android.support.v4.view.b.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Interpolator f406c = new android.support.v4.view.b.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Interpolator f407d = new android.support.v4.view.b.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Interpolator f408e = new DecelerateInterpolator();

    /* JADX INFO: renamed from: android.support.design.widget.a$a, reason: collision with other inner class name */
    static class AnimationAnimationListenerC0009a implements Animation.AnimationListener {
        AnimationAnimationListenerC0009a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    static float a(float f2, float f3, float f4) {
        return ((f3 - f2) * f4) + f2;
    }

    static int a(int i, int i2, float f2) {
        return Math.round((i2 - i) * f2) + i;
    }
}
