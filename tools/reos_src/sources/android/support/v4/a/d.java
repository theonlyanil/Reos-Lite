package android.support.v4.a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TimeInterpolator f521a;

    d() {
    }

    @Override // android.support.v4.a.b
    public void a(View view) {
        if (this.f521a == null) {
            this.f521a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f521a);
    }
}
