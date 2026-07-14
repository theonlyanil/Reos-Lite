package com.a.a.d.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public class j extends com.a.a.d.d.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f2231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f2236f;

    static class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Paint f2237d = new Paint(6);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bitmap f2238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Paint f2240c;

        public a(Bitmap bitmap) {
            this.f2240c = f2237d;
            this.f2238a = bitmap;
        }

        a(a aVar) {
            this(aVar.f2238a);
            this.f2239b = aVar.f2239b;
        }

        void a() {
            if (f2237d == this.f2240c) {
                this.f2240c = new Paint(6);
            }
        }

        void a(int i) {
            a();
            this.f2240c.setAlpha(i);
        }

        void a(ColorFilter colorFilter) {
            a();
            this.f2240c.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new j((Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new j(resources, this);
        }
    }

    public j(Resources resources, Bitmap bitmap) {
        this(resources, new a(bitmap));
    }

    j(Resources resources, a aVar) {
        int i;
        this.f2231a = new Rect();
        if (aVar == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        this.f2236f = aVar;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            i = i == 0 ? 160 : i;
            aVar.f2239b = i;
        } else {
            i = aVar.f2239b;
        }
        this.f2232b = aVar.f2238a.getScaledWidth(i);
        this.f2233c = aVar.f2238a.getScaledHeight(i);
    }

    @Override // com.a.a.d.d.b.b
    public void a(int i) {
    }

    @Override // com.a.a.d.d.b.b
    public boolean a() {
        return false;
    }

    public Bitmap b() {
        return this.f2236f.f2238a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2234d) {
            Gravity.apply(119, this.f2232b, this.f2233c, getBounds(), this.f2231a);
            this.f2234d = false;
        }
        canvas.drawBitmap(this.f2236f.f2238a, (Rect) null, this.f2231a, this.f2236f.f2240c);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f2236f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2233c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2232b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f2236f.f2238a;
        return (bitmap == null || bitmap.hasAlpha() || this.f2236f.f2240c.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2235e && super.mutate() == this) {
            this.f2236f = new a(this.f2236f);
            this.f2235e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2234d = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f2236f.f2240c.getAlpha() != i) {
            this.f2236f.a(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2236f.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }
}
