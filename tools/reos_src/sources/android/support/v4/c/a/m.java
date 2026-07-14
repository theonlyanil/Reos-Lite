package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class m extends l {

    private static class a extends j.a {
        a(j.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.c.a.j.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new m(this, resources);
        }
    }

    m(Drawable drawable) {
        super(drawable);
    }

    m(j.a aVar, Resources resources) {
        super(aVar, resources);
    }

    @Override // android.support.v4.c.a.l, android.support.v4.c.a.j
    j.a b() {
        return new a(this.f754b, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f755c.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f755c.setAutoMirrored(z);
    }
}
