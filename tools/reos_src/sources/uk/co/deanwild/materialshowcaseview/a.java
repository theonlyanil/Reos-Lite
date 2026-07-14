package uk.co.deanwild.materialshowcaseview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccelerateDecelerateInterpolator f6621a = new AccelerateDecelerateInterpolator();

    public void a(View view, long j, final b.a aVar) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", BitmapDescriptorFactory.HUE_RED);
        objectAnimatorOfFloat.setDuration(j).addListener(new Animator.AnimatorListener() { // from class: uk.co.deanwild.materialshowcaseview.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                aVar.a();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void a(View view, long j, final b.InterfaceC0214b interfaceC0214b) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f);
        objectAnimatorOfFloat.setDuration(j).addListener(new Animator.AnimatorListener() { // from class: uk.co.deanwild.materialshowcaseview.a.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                interfaceC0214b.a();
            }
        });
        objectAnimatorOfFloat.start();
    }
}
