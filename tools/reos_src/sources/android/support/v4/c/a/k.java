package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class k extends j {

    private static class a extends j.a {
        a(j.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.c.a.j.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new k(this, resources);
        }
    }

    k(Drawable drawable) {
        super(drawable);
    }

    k(j.a aVar, Resources resources) {
        super(aVar, resources);
    }

    @Override // android.support.v4.c.a.j
    protected Drawable a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    @Override // android.support.v4.c.a.j
    j.a b() {
        return new a(this.f754b, null);
    }
}
