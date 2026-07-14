package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.ah;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
class i extends h {
    private boolean m;

    i(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
    }

    private void e(float f2) {
        if (this.f432a != null) {
            this.f432a.a(-f2);
        }
        if (this.f453d != null) {
            this.f453d.b(-f2);
        }
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void a(final j.a aVar, final boolean z) {
        if (this.m || this.k.getVisibility() != 0) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (ah.D(this.k) && !this.k.isInEditMode()) {
            this.k.animate().cancel();
            this.k.animate().scaleX(BitmapDescriptorFactory.HUE_RED).scaleY(BitmapDescriptorFactory.HUE_RED).alpha(BitmapDescriptorFactory.HUE_RED).setDuration(200L).setInterpolator(a.f406c).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.i.1

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private boolean f446d;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    i.this.m = false;
                    this.f446d = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.m = false;
                    if (this.f446d) {
                        return;
                    }
                    i.this.k.a(8, z);
                    if (aVar != null) {
                        aVar.b();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    i.this.m = true;
                    this.f446d = false;
                    i.this.k.a(0, z);
                }
            });
        } else {
            this.k.a(8, z);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // android.support.design.widget.h, android.support.design.widget.j
    void b(final j.a aVar, final boolean z) {
        if (this.m || this.k.getVisibility() != 0) {
            if (ah.D(this.k) && !this.k.isInEditMode()) {
                this.k.animate().cancel();
                if (this.k.getVisibility() != 0) {
                    this.k.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    this.k.setScaleY(BitmapDescriptorFactory.HUE_RED);
                    this.k.setScaleX(BitmapDescriptorFactory.HUE_RED);
                }
                this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(a.f407d).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.i.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (aVar != null) {
                            aVar.a();
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        i.this.k.a(0, z);
                    }
                });
                return;
            }
            this.k.a(0, z);
            this.k.setAlpha(1.0f);
            this.k.setScaleY(1.0f);
            this.k.setScaleX(1.0f);
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // android.support.design.widget.j
    boolean d() {
        return true;
    }

    @Override // android.support.design.widget.j
    void e() {
        e(this.k.getRotation());
    }
}
