package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
class b extends Drawable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f421f;
    private int g;
    private int h;
    private ColorStateList i;
    private int j;
    private float l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Rect f417b = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final RectF f418c = new RectF();
    private boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Paint f416a = new Paint(1);

    public b() {
        this.f416a.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        Rect rect = this.f417b;
        copyBounds(rect);
        float fHeight = this.f419d / rect.height();
        return new LinearGradient(BitmapDescriptorFactory.HUE_RED, rect.top, BitmapDescriptorFactory.HUE_RED, rect.bottom, new int[]{android.support.v4.c.a.a(this.f420e, this.j), android.support.v4.c.a.a(this.f421f, this.j), android.support.v4.c.a.a(android.support.v4.c.a.b(this.f421f, 0), this.j), android.support.v4.c.a.a(android.support.v4.c.a.b(this.h, 0), this.j), android.support.v4.c.a.a(this.h, this.j), android.support.v4.c.a.a(this.g, this.j)}, new float[]{BitmapDescriptorFactory.HUE_RED, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    void a(float f2) {
        if (this.f419d != f2) {
            this.f419d = f2;
            this.f416a.setStrokeWidth(1.3333f * f2);
            this.k = true;
            invalidateSelf();
        }
    }

    void a(int i, int i2, int i3, int i4) {
        this.f420e = i;
        this.f421f = i2;
        this.g = i3;
        this.h = i4;
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.j = colorStateList.getColorForState(getState(), this.j);
        }
        this.i = colorStateList;
        this.k = true;
        invalidateSelf();
    }

    final void b(float f2) {
        if (f2 != this.l) {
            this.l = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.k) {
            this.f416a.setShader(a());
            this.k = false;
        }
        float strokeWidth = this.f416a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f418c;
        copyBounds(this.f417b);
        rectF.set(this.f417b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f416a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f419d > BitmapDescriptorFactory.HUE_RED ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iRound = Math.round(this.f419d);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.i != null && this.i.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        if (this.i != null && (colorForState = this.i.getColorForState(iArr, this.j)) != this.j) {
            this.k = true;
            this.j = colorForState;
        }
        if (this.k) {
            invalidateSelf();
        }
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f416a.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f416a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
