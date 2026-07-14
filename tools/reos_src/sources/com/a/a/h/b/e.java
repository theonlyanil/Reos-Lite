package com.a.a.h.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class e<Z> extends l<ImageView, Z> implements com.a.a.h.a.c.a {
    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.k
    public void a(Drawable drawable) {
        ((ImageView) this.f2459a).setImageDrawable(drawable);
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.k
    public void a(Exception exc, Drawable drawable) {
        ((ImageView) this.f2459a).setImageDrawable(drawable);
    }

    protected abstract void a(Z z);

    @Override // com.a.a.h.b.k
    public void a(Z z, com.a.a.h.a.c<? super Z> cVar) {
        if (cVar == null || !cVar.a(z, this)) {
            a(z);
        }
    }

    @Override // com.a.a.h.a.c.a
    public Drawable b() {
        return ((ImageView) this.f2459a).getDrawable();
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.k
    public void b(Drawable drawable) {
        ((ImageView) this.f2459a).setImageDrawable(drawable);
    }

    @Override // com.a.a.h.a.c.a
    public void c(Drawable drawable) {
        ((ImageView) this.f2459a).setImageDrawable(drawable);
    }
}
