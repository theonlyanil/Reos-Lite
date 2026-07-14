package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
class n extends m {

    private static class a extends j.a {
        a(j.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.c.a.j.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new n(this, resources);
        }
    }

    n(Drawable drawable) {
        super(drawable);
    }

    n(j.a aVar, Resources resources) {
        super(aVar, resources);
    }

    @Override // android.support.v4.c.a.m, android.support.v4.c.a.l, android.support.v4.c.a.j
    j.a b() {
        return new a(this.f754b, null);
    }

    @Override // android.support.v4.c.a.j
    protected boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f755c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f755c.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f755c.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        this.f755c.setHotspot(f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f755c.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.v4.c.a.j, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.support.v4.c.a.j, android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTint(int i) {
        if (c()) {
            super.setTint(i);
        } else {
            this.f755c.setTint(i);
        }
    }

    @Override // android.support.v4.c.a.j, android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f755c.setTintList(colorStateList);
        }
    }

    @Override // android.support.v4.c.a.j, android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f755c.setTintMode(mode);
        }
    }
}
