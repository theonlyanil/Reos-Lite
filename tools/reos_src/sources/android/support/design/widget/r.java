package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<View> f487d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<a> f484a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f485b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Animation f486c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Animation.AnimationListener f488e = new Animation.AnimationListener() { // from class: android.support.design.widget.r.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (r.this.f486c == animation) {
                r.this.f486c = null;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    };

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Animation f491b;

        private a(int[] iArr, Animation animation) {
            this.f490a = iArr;
            this.f491b = animation;
        }
    }

    r() {
    }

    private void a(a aVar) {
        this.f486c = aVar.f491b;
        View viewA = a();
        if (viewA != null) {
            viewA.startAnimation(this.f486c);
        }
    }

    private void c() {
        View viewA = a();
        int size = this.f484a.size();
        for (int i = 0; i < size; i++) {
            if (viewA.getAnimation() == this.f484a.get(i).f491b) {
                viewA.clearAnimation();
            }
        }
        this.f487d = null;
        this.f485b = null;
        this.f486c = null;
    }

    private void d() {
        if (this.f486c != null) {
            View viewA = a();
            if (viewA != null && viewA.getAnimation() == this.f486c) {
                viewA.clearAnimation();
            }
            this.f486c = null;
        }
    }

    View a() {
        if (this.f487d == null) {
            return null;
        }
        return this.f487d.get();
    }

    void a(View view) {
        View viewA = a();
        if (viewA == view) {
            return;
        }
        if (viewA != null) {
            c();
        }
        if (view != null) {
            this.f487d = new WeakReference<>(view);
        }
    }

    void a(int[] iArr) {
        a aVar = null;
        int size = this.f484a.size();
        for (int i = 0; i < size; i++) {
            a aVar2 = this.f484a.get(i);
            if (StateSet.stateSetMatches(aVar2.f490a, iArr)) {
                aVar = aVar2;
                break;
            }
        }
        if (aVar == this.f485b) {
            return;
        }
        if (this.f485b != null) {
            d();
        }
        this.f485b = aVar;
        View view = this.f487d.get();
        if (aVar == null || view == null || view.getVisibility() != 0) {
            return;
        }
        a(aVar);
    }

    public void a(int[] iArr, Animation animation) {
        a aVar = new a(iArr, animation);
        animation.setAnimationListener(this.f488e);
        this.f484a.add(aVar);
    }

    public void b() {
        View viewA;
        if (this.f486c == null || (viewA = a()) == null || viewA.getAnimation() != this.f486c) {
            return;
        }
        viewA.clearAnimation();
    }
}
