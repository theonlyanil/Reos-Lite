package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class ad extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1694a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f1696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f1697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1698e;
    private PorterDuffColorFilter h;
    private ColorStateList i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1699f = false;
    private boolean g = true;
    private PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f1695b = new Paint(5);

    public ad(int i, float f2) {
        this.f1694a = f2;
        this.f1695b.setColor(i);
        this.f1696c = new RectF();
        this.f1697d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1696c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1697d.set(rect);
        if (this.f1699f) {
            this.f1697d.inset((int) Math.ceil(ae.b(this.f1698e, this.f1694a, this.g)), (int) Math.ceil(ae.a(this.f1698e, this.f1694a, this.g)));
            this.f1696c.set(this.f1697d);
        }
    }

    float a() {
        return this.f1698e;
    }

    void a(float f2) {
        if (f2 == this.f1694a) {
            return;
        }
        this.f1694a = f2;
        a((Rect) null);
        invalidateSelf();
    }

    void a(float f2, boolean z, boolean z2) {
        if (f2 == this.f1698e && this.f1699f == z && this.g == z2) {
            return;
        }
        this.f1698e = f2;
        this.f1699f = z;
        this.g = z2;
        a((Rect) null);
        invalidateSelf();
    }

    public void a(int i) {
        this.f1695b.setColor(i);
        invalidateSelf();
    }

    public float b() {
        return this.f1694a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1695b;
        if (this.h == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.h);
            z = true;
        }
        canvas.drawRoundRect(this.f1696c, this.f1694a, this.f1694a, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1697d, this.f1694a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.i != null && this.i.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.i == null || this.j == null) {
            return false;
        }
        this.h = a(this.i, this.j);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1695b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1695b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.i = colorStateList;
        this.h = a(this.i, this.j);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.j = mode;
        this.h = a(this.i, this.j);
        invalidateSelf();
    }
}
