package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class bb {
    public static long a(View view) {
        return view.animate().getDuration();
    }

    public static void a(View view, float f2) {
        view.animate().alpha(f2);
    }

    public static void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void a(final View view, final be beVar) {
        if (beVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.view.bb.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    beVar.c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    beVar.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    beVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public static void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void b(View view) {
        view.animate().cancel();
    }

    public static void b(View view, float f2) {
        view.animate().translationX(f2);
    }

    public static void b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void c(View view) {
        view.animate().start();
    }

    public static void c(View view, float f2) {
        view.animate().translationY(f2);
    }
}
