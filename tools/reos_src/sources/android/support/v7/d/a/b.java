package android.support.v7.d.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class b extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f1182b = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f1184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f1185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f1187f;
    private boolean g;
    private final int i;
    private float k;
    private float l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f1183a = new Paint();
    private final Path h = new Path();
    private boolean j = false;
    private int m = 2;

    public b(Context context) {
        this.f1183a.setStyle(Paint.Style.STROKE);
        this.f1183a.setStrokeJoin(Paint.Join.MITER);
        this.f1183a.setStrokeCap(Paint.Cap.BUTT);
        this.f1183a.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, android.support.v7.b.a.k.DrawerArrowToggle, android.support.v7.b.a.C0029a.drawerArrowStyle, android.support.v7.b.a.j.Base_Widget_AppCompat_DrawerArrowToggle);
        a(typedArrayObtainStyledAttributes.getColor(android.support.v7.b.a.k.DrawerArrowToggle_color, 0));
        b(typedArrayObtainStyledAttributes.getDimension(android.support.v7.b.a.k.DrawerArrowToggle_thickness, BitmapDescriptorFactory.HUE_RED));
        a(typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.DrawerArrowToggle_spinBars, true));
        c(Math.round(typedArrayObtainStyledAttributes.getDimension(android.support.v7.b.a.k.DrawerArrowToggle_gapBetweenBars, BitmapDescriptorFactory.HUE_RED)));
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.b.a.k.DrawerArrowToggle_drawableSize, 0);
        this.f1185d = Math.round(typedArrayObtainStyledAttributes.getDimension(android.support.v7.b.a.k.DrawerArrowToggle_barLength, BitmapDescriptorFactory.HUE_RED));
        this.f1184c = Math.round(typedArrayObtainStyledAttributes.getDimension(android.support.v7.b.a.k.DrawerArrowToggle_arrowHeadLength, BitmapDescriptorFactory.HUE_RED));
        this.f1186e = typedArrayObtainStyledAttributes.getDimension(android.support.v7.b.a.k.DrawerArrowToggle_arrowShaftLength, BitmapDescriptorFactory.HUE_RED);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static float a(float f2, float f3, float f4) {
        return ((f3 - f2) * f4) + f2;
    }

    public void a(int i) {
        if (i != this.f1183a.getColor()) {
            this.f1183a.setColor(i);
            invalidateSelf();
        }
    }

    public void a(boolean z) {
        if (this.g != z) {
            this.g = z;
            invalidateSelf();
        }
    }

    public void b(float f2) {
        if (this.f1183a.getStrokeWidth() != f2) {
            this.f1183a.setStrokeWidth(f2);
            this.l = (float) (((double) (f2 / 2.0f)) * Math.cos(f1182b));
            invalidateSelf();
        }
    }

    public void b(boolean z) {
        if (this.j != z) {
            this.j = z;
            invalidateSelf();
        }
    }

    public void c(float f2) {
        if (f2 != this.f1187f) {
            this.f1187f = f2;
            invalidateSelf();
        }
    }

    public void d(float f2) {
        if (this.k != f2) {
            this.k = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Rect bounds = getBounds();
        switch (this.m) {
            case 0:
                z = false;
                break;
            case 1:
                z = true;
                break;
            case 2:
            default:
                z = android.support.v4.c.a.a.h(this) == 1;
                break;
            case 3:
                z = android.support.v4.c.a.a.h(this) == 0;
                break;
        }
        float fA = a(this.f1185d, (float) Math.sqrt(this.f1184c * this.f1184c * 2.0f), this.k);
        float fA2 = a(this.f1185d, this.f1186e, this.k);
        float fRound = Math.round(a(BitmapDescriptorFactory.HUE_RED, this.l, this.k));
        float fA3 = a(BitmapDescriptorFactory.HUE_RED, f1182b, this.k);
        float fA4 = a(z ? 0.0f : -180.0f, z ? 180.0f : BitmapDescriptorFactory.HUE_RED, this.k);
        float fRound2 = Math.round(((double) fA) * Math.cos(fA3));
        float fRound3 = Math.round(((double) fA) * Math.sin(fA3));
        this.h.rewind();
        float fA5 = a(this.f1187f + this.f1183a.getStrokeWidth(), -this.l, this.k);
        float f2 = (-fA2) / 2.0f;
        this.h.moveTo(f2 + fRound, BitmapDescriptorFactory.HUE_RED);
        this.h.rLineTo(fA2 - (fRound * 2.0f), BitmapDescriptorFactory.HUE_RED);
        this.h.moveTo(f2, fA5);
        this.h.rLineTo(fRound2, fRound3);
        this.h.moveTo(f2, -fA5);
        this.h.rLineTo(fRound2, -fRound3);
        this.h.close();
        canvas.save();
        float strokeWidth = this.f1183a.getStrokeWidth();
        canvas.translate(bounds.centerX(), (float) (((double) ((((int) ((bounds.height() - (3.0f * strokeWidth)) - (this.f1187f * 2.0f))) / 4) * 2)) + (((double) strokeWidth) * 1.5d) + ((double) this.f1187f)));
        if (this.g) {
            canvas.rotate((z ^ this.j ? -1 : 1) * fA4);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.h, this.f1183a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f1183a.getAlpha()) {
            this.f1183a.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1183a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
