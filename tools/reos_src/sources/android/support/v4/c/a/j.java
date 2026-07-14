package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class j extends Drawable implements Drawable.Callback, i, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final PorterDuff.Mode f753a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Drawable f755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PorterDuff.Mode f757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f758f;
    private boolean g;

    protected static abstract class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Drawable.ConstantState f760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorStateList f761c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f762d;

        a(a aVar, Resources resources) {
            this.f761c = null;
            this.f762d = j.f753a;
            if (aVar != null) {
                this.f759a = aVar.f759a;
                this.f760b = aVar.f760b;
                this.f761c = aVar.f761c;
                this.f762d = aVar.f762d;
            }
        }

        boolean a() {
            return this.f760b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return (this.f760b != null ? this.f760b.getChangingConfigurations() : 0) | this.f759a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    private static class b extends a {
        b(a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.c.a.j.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new j(this, resources);
        }
    }

    j(Drawable drawable) {
        this.f754b = b();
        a(drawable);
    }

    j(a aVar, Resources resources) {
        this.f754b = aVar;
        a(resources);
    }

    private void a(Resources resources) {
        if (this.f754b == null || this.f754b.f760b == null) {
            return;
        }
        a(a(this.f754b.f760b, resources));
    }

    private boolean a(int[] iArr) {
        if (!c()) {
            return false;
        }
        ColorStateList colorStateList = this.f754b.f761c;
        PorterDuff.Mode mode = this.f754b.f762d;
        if (colorStateList == null || mode == null) {
            this.f758f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f758f && colorForState == this.f756d && mode == this.f757e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f756d = colorForState;
        this.f757e = mode;
        this.f758f = true;
        return true;
    }

    @Override // android.support.v4.c.a.i
    public final Drawable a() {
        return this.f755c;
    }

    protected Drawable a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    @Override // android.support.v4.c.a.i
    public final void a(Drawable drawable) {
        if (this.f755c != null) {
            this.f755c.setCallback(null);
        }
        this.f755c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.f754b != null) {
                this.f754b.f760b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    a b() {
        return new b(this.f754b, null);
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f755c.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return (this.f754b != null ? this.f754b.getChangingConfigurations() : 0) | super.getChangingConfigurations() | this.f755c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f754b == null || !this.f754b.a()) {
            return null;
        }
        this.f754b.f759a = getChangingConfigurations();
        return this.f754b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f755c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f755c.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f755c.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f755c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f755c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f755c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f755c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f755c.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f755c.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = (!c() || this.f754b == null) ? null : this.f754b.f761c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f755c.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            this.f754b = b();
            if (this.f755c != null) {
                this.f755c.mutate();
            }
            if (this.f754b != null) {
                this.f754b.f760b = this.f755c != null ? this.f755c.getConstantState() : null;
            }
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f755c != null) {
            this.f755c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f755c.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f755c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f755c.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f755c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f755c.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f755c.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.f755c.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTintList(ColorStateList colorStateList) {
        this.f754b.f761c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.c.a.o
    public void setTintMode(PorterDuff.Mode mode) {
        this.f754b.f762d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f755c.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
