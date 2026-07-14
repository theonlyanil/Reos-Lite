package com.a.a.d.d.b;

import android.graphics.drawable.Drawable;
import com.a.a.d.b.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends Drawable> implements k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f2276a;

    public a(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.f2276a = t;
    }

    @Override // com.a.a.d.b.k
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T b() {
        return (T) this.f2276a.getConstantState().newDrawable();
    }
}
