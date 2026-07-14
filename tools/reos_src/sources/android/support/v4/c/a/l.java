package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class l extends j {

    private static class a extends j.a {
        a(j.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.c.a.j.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new l(this, resources);
        }
    }

    l(Drawable drawable) {
        super(drawable);
    }

    l(j.a aVar, Resources resources) {
        super(aVar, resources);
    }

    @Override // android.support.v4.c.a.j
    j.a b() {
        return new a(this.f754b, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f755c.jumpToCurrentState();
    }
}
