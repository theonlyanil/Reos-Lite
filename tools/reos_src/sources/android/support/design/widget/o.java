package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
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
class o extends android.support.v7.d.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final double f470a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Paint f471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Paint f472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RectF f473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Path f475f;
    float g;
    float h;
    float i;
    float j;
    private boolean k;
    private final int l;
    private final int m;
    private final int n;
    private boolean o;
    private float p;
    private boolean q;

    public o(Resources resources, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.k = true;
        this.o = true;
        this.q = false;
        this.l = resources.getColor(android.support.design.a.c.design_fab_shadow_start_color);
        this.m = resources.getColor(android.support.design.a.c.design_fab_shadow_mid_color);
        this.n = resources.getColor(android.support.design.a.c.design_fab_shadow_end_color);
        this.f471b = new Paint(5);
        this.f471b.setStyle(Paint.Style.FILL);
        this.f474e = Math.round(f2);
        this.f473d = new RectF();
        this.f472c = new Paint(this.f471b);
        this.f472c.setAntiAlias(false);
        a(f3, f4);
    }

    public static float a(float f2, float f3, boolean z) {
        return z ? (float) (((double) (1.5f * f2)) + ((1.0d - f470a) * ((double) f3))) : 1.5f * f2;
    }

    private void a(Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(this.p, this.f473d.centerX(), this.f473d.centerY());
        float f2 = (-this.f474e) - this.i;
        float f3 = this.f474e;
        boolean z = this.f473d.width() - (2.0f * f3) > BitmapDescriptorFactory.HUE_RED;
        boolean z2 = this.f473d.height() - (2.0f * f3) > BitmapDescriptorFactory.HUE_RED;
        float f4 = this.j - (this.j * 0.25f);
        float f5 = f3 / ((this.j - (this.j * 0.5f)) + f3);
        float f6 = f3 / (f4 + f3);
        float f7 = f3 / (f3 + (this.j - (this.j * 1.0f)));
        int iSave2 = canvas.save();
        canvas.translate(this.f473d.left + f3, this.f473d.top + f3);
        canvas.scale(f5, f6);
        canvas.drawPath(this.f475f, this.f471b);
        if (z) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f2, this.f473d.width() - (2.0f * f3), -this.f474e, this.f472c);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.f473d.right - f3, this.f473d.bottom - f3);
        canvas.scale(f5, f7);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f475f, this.f471b);
        if (z) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f2, this.f473d.width() - (2.0f * f3), this.i + (-this.f474e), this.f472c);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.f473d.left + f3, this.f473d.bottom - f3);
        canvas.scale(f5, f7);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f475f, this.f471b);
        if (z2) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f2, this.f473d.height() - (2.0f * f3), -this.f474e, this.f472c);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        canvas.translate(this.f473d.right - f3, this.f473d.top + f3);
        canvas.scale(f5, f6);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f475f, this.f471b);
        if (z2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f2, this.f473d.height() - (2.0f * f3), -this.f474e, this.f472c);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(iSave);
    }

    private void a(Rect rect) {
        float f2 = this.h * 1.5f;
        this.f473d.set(rect.left + this.h, rect.top + f2, rect.right - this.h, rect.bottom - f2);
        b().setBounds((int) this.f473d.left, (int) this.f473d.top, (int) this.f473d.right, (int) this.f473d.bottom);
        c();
    }

    public static float b(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - f470a) * ((double) f3))) : f2;
    }

    private void c() {
        RectF rectF = new RectF(-this.f474e, -this.f474e, this.f474e, this.f474e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.i, -this.i);
        if (this.f475f == null) {
            this.f475f = new Path();
        } else {
            this.f475f.reset();
        }
        this.f475f.setFillType(Path.FillType.EVEN_ODD);
        this.f475f.moveTo(-this.f474e, BitmapDescriptorFactory.HUE_RED);
        this.f475f.rLineTo(-this.i, BitmapDescriptorFactory.HUE_RED);
        this.f475f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f475f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f475f.close();
        float f2 = -rectF2.top;
        if (f2 > BitmapDescriptorFactory.HUE_RED) {
            float f3 = this.f474e / f2;
            this.f471b.setShader(new RadialGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f2, new int[]{0, this.l, this.m, this.n}, new float[]{BitmapDescriptorFactory.HUE_RED, f3, f3 + ((1.0f - f3) / 2.0f), 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f472c.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, rectF.top, BitmapDescriptorFactory.HUE_RED, rectF2.top, new int[]{this.l, this.m, this.n}, new float[]{BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f472c.setAntiAlias(false);
    }

    private static int d(float f2) {
        int iRound = Math.round(f2);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    public float a() {
        return this.j;
    }

    final void a(float f2) {
        if (this.p != f2) {
            this.p = f2;
            invalidateSelf();
        }
    }

    void a(float f2, float f3) {
        if (f2 < BitmapDescriptorFactory.HUE_RED || f3 < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float fD = d(f2);
        float fD2 = d(f3);
        if (fD > fD2) {
            if (!this.q) {
                this.q = true;
            }
            fD = fD2;
        }
        if (this.j == fD && this.h == fD2) {
            return;
        }
        this.j = fD;
        this.h = fD2;
        this.i = Math.round(fD * 1.5f);
        this.g = fD2;
        this.k = true;
        invalidateSelf();
    }

    public void a(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    public void b(float f2) {
        a(f2, this.h);
    }

    public void c(float f2) {
        a(this.j, f2);
    }

    @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.k) {
            a(getBounds());
            this.k = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(a(this.h, this.f474e, this.o));
        int iCeil2 = (int) Math.ceil(b(this.h, this.f474e, this.o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f471b.setAlpha(i);
        this.f472c.setAlpha(i);
    }
}
