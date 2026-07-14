package com.a.a.h.a;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class a<T extends Drawable> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<T> f2418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b<T> f2420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b<T> f2421d;

    /* JADX INFO: renamed from: com.a.a.h.a.a$a, reason: collision with other inner class name */
    private static class C0045a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2422a;

        C0045a(int i) {
            this.f2422a = i;
        }

        @Override // com.a.a.h.a.f.a
        public Animation a() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(BitmapDescriptorFactory.HUE_RED, 1.0f);
            alphaAnimation.setDuration(this.f2422a);
            return alphaAnimation;
        }
    }

    public a() {
        this(300);
    }

    public a(int i) {
        this(new g(new C0045a(i)), i);
    }

    a(g<T> gVar, int i) {
        this.f2418a = gVar;
        this.f2419b = i;
    }

    private c<T> a() {
        if (this.f2420c == null) {
            this.f2420c = new b<>(this.f2418a.a(false, true), this.f2419b);
        }
        return this.f2420c;
    }

    private c<T> b() {
        if (this.f2421d == null) {
            this.f2421d = new b<>(this.f2418a.a(false, false), this.f2419b);
        }
        return this.f2421d;
    }

    @Override // com.a.a.h.a.d
    public c<T> a(boolean z, boolean z2) {
        if (z) {
            return e.b();
        }
        return z2 ? a() : b();
    }
}
