package com.a.a.h.a;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public class f<R> implements c<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f2427a;

    interface a {
        Animation a();
    }

    f(a aVar) {
        this.f2427a = aVar;
    }

    @Override // com.a.a.h.a.c
    public boolean a(R r, c.a aVar) {
        View viewC_ = aVar.c_();
        if (viewC_ == null) {
            return false;
        }
        viewC_.clearAnimation();
        viewC_.startAnimation(this.f2427a.a());
        return false;
    }
}
