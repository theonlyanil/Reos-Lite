package com.a.a.h.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: loaded from: classes.dex */
public class b<T extends Drawable> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c<T> f2423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2424b;

    public b(c<T> cVar, int i) {
        this.f2423a = cVar;
        this.f2424b = i;
    }

    @Override // com.a.a.h.a.c
    public boolean a(T t, c.a aVar) {
        Drawable drawableB = aVar.b();
        if (drawableB == null) {
            this.f2423a.a(t, aVar);
            return false;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableB, t});
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(this.f2424b);
        aVar.c(transitionDrawable);
        return true;
    }
}
