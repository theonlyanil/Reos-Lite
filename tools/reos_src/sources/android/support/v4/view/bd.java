package android.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class bd {
    public static void a(final View view, final bg bgVar) {
        view.animate().setUpdateListener(bgVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.view.bd.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                bgVar.a(view);
            }
        } : null);
    }
}
