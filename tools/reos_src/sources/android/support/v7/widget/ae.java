package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
class ae extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final double f1700a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static a f1701c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f1702b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Paint f1704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Paint f1705f;
    final RectF g;
    float h;
    Path i;
    float j;
    float k;
    float l;
    float m;
    private final int o;
    private final int p;
    private boolean n = true;
    private boolean q = true;
    private boolean r = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Paint f1703d = new Paint(5);

    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    ae(Resources resources, int i, float f2, float f3, float f4) {
        this.o = resources.getColor(android.support.v7.c.a.C0030a.cardview_shadow_start_color);
        this.p = resources.getColor(android.support.v7.c.a.C0030a.cardview_shadow_end_color);
        this.f1702b = resources.getDimensionPixelSize(android.support.v7.c.a.b.cardview_compat_inset_shadow);
        this.f1703d.setColor(i);
        this.f1704e = new Paint(5);
        this.f1704e.setStyle(Paint.Style.FILL);
        this.h = (int) (0.5f + f2);
        this.g = new RectF();
        this.f1705f = new Paint(this.f1704e);
        this.f1705f.setAntiAlias(false);
        a(f3, f4);
    }

    static float a(float f2, float f3, boolean z) {
        return z ? (float) (((double) (1.5f * f2)) + ((1.0d - f1700a) * ((double) f3))) : 1.5f * f2;
    }

    private void a(Canvas canvas) {
        float f2 = (-this.h) - this.l;
        float f3 = this.h + this.f1702b + (this.m / 2.0f);
        boolean z = this.g.width() - (2.0f * f3) > BitmapDescriptorFactory.HUE_RED;
        boolean z2 = this.g.height() - (2.0f * f3) > BitmapDescriptorFactory.HUE_RED;
        int iSave = canvas.save();
        canvas.translate(this.g.left + f3, this.g.top + f3);
        canvas.drawPath(this.i, this.f1704e);
        if (z) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f2, this.g.width() - (2.0f * f3), -this.h, this.f1705f);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        canvas.translate(this.g.right - f3, this.g.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.f1704e);
        if (z) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f2, this.g.width() - (2.0f * f3), this.l + (-this.h), this.f1705f);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.g.left + f3, this.g.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.f1704e);
        if (z2) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f2, this.g.height() - (2.0f * f3), -this.h, this.f1705f);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.g.right - f3, this.g.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.f1704e);
        if (z2) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f2, this.g.height() - (2.0f * f3), -this.h, this.f1705f);
        }
        canvas.restoreToCount(iSave4);
    }

    static float b(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - f1700a) * ((double) f3))) : f2;
    }

    private void b(Rect rect) {
        float f2 = this.k * 1.5f;
        this.g.set(rect.left + this.k, rect.top + f2, rect.right - this.k, rect.bottom - f2);
        f();
    }

    private int d(float f2) {
        int i = (int) (0.5f + f2);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void f() {
        RectF rectF = new RectF(-this.h, -this.h, this.h, this.h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.l, -this.l);
        if (this.i == null) {
            this.i = new Path();
        } else {
            this.i.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(-this.h, BitmapDescriptorFactory.HUE_RED);
        this.i.rLineTo(-this.l, BitmapDescriptorFactory.HUE_RED);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        this.f1704e.setShader(new RadialGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.h + this.l, new int[]{this.o, this.o, this.p}, new float[]{BitmapDescriptorFactory.HUE_RED, this.h / (this.h + this.l), 1.0f}, Shader.TileMode.CLAMP));
        this.f1705f.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, (-this.h) + this.l, BitmapDescriptorFactory.HUE_RED, (-this.h) - this.l, new int[]{this.o, this.o, this.p}, new float[]{BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1705f.setAntiAlias(false);
    }

    float a() {
        return this.h;
    }

    void a(float f2) {
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
        }
        float f3 = (int) (0.5f + f2);
        if (this.h == f3) {
            return;
        }
        this.h = f3;
        this.n = true;
        invalidateSelf();
    }

    void a(float f2, float f3) {
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        }
        if (f3 < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
        float fD = d(f2);
        float fD2 = d(f3);
        if (fD > fD2) {
            if (!this.r) {
                this.r = true;
            }
            fD = fD2;
        }
        if (this.m == fD && this.k == fD2) {
            return;
        }
        this.m = fD;
        this.k = fD2;
        this.l = (int) ((fD * 1.5f) + this.f1702b + 0.5f);
        this.j = this.f1702b + fD2;
        this.n = true;
        invalidateSelf();
    }

    public void a(int i) {
        this.f1703d.setColor(i);
        invalidateSelf();
    }

    void a(Rect rect) {
        getPadding(rect);
    }

    public void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    float b() {
        return this.m;
    }

    void b(float f2) {
        a(f2, this.k);
    }

    float c() {
        return this.k;
    }

    void c(float f2) {
        a(this.m, f2);
    }

    float d() {
        return (Math.max(this.k, this.h + this.f1702b + (this.k / 2.0f)) * 2.0f) + ((this.k + this.f1702b) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            b(getBounds());
            this.n = false;
        }
        canvas.translate(BitmapDescriptorFactory.HUE_RED, this.m / 2.0f);
        a(canvas);
        canvas.translate(BitmapDescriptorFactory.HUE_RED, (-this.m) / 2.0f);
        f1701c.a(canvas, this.g, this.h, this.f1703d);
    }

    float e() {
        return (Math.max(this.k, this.h + this.f1702b + ((this.k * 1.5f) / 2.0f)) * 2.0f) + (((this.k * 1.5f) + this.f1702b) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(a(this.k, this.h, this.q));
        int iCeil2 = (int) Math.ceil(b(this.k, this.h, this.q));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1703d.setAlpha(i);
        this.f1704e.setAlpha(i);
        this.f1705f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1703d.setColorFilter(colorFilter);
    }
}
