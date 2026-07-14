package com.a.a.d.d.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.a.a.d.d.b.b implements f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f2286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f2287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.b.a f2289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f2290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2291f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private boolean l;

    static class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.a.a.b.c f2292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte[] f2293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Context f2294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.a.a.d.g<Bitmap> f2295d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2296e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2297f;
        com.a.a.b.a.InterfaceC0037a g;
        com.a.a.d.b.a.c h;
        Bitmap i;

        public a(com.a.a.b.c cVar, byte[] bArr, Context context, com.a.a.d.g<Bitmap> gVar, int i, int i2, com.a.a.b.a.InterfaceC0037a interfaceC0037a, com.a.a.d.b.a.c cVar2, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.f2292a = cVar;
            this.f2293b = bArr;
            this.h = cVar2;
            this.i = bitmap;
            this.f2294c = context.getApplicationContext();
            this.f2295d = gVar;
            this.f2296e = i;
            this.f2297f = i2;
            this.g = interfaceC0037a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public b(Context context, com.a.a.b.a.InterfaceC0037a interfaceC0037a, com.a.a.d.b.a.c cVar, com.a.a.d.g<Bitmap> gVar, int i, int i2, com.a.a.b.c cVar2, byte[] bArr, Bitmap bitmap) {
        this(new a(cVar2, bArr, context, gVar, i, i2, interfaceC0037a, cVar, bitmap));
    }

    b(a aVar) {
        this.f2287b = new Rect();
        this.i = true;
        this.k = -1;
        if (aVar == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.f2288c = aVar;
        this.f2289d = new com.a.a.b.a(aVar.g);
        this.f2286a = new Paint();
        this.f2289d.a(aVar.f2292a, aVar.f2293b);
        this.f2290e = new f(aVar.f2294c, this, this.f2289d, aVar.f2296e, aVar.f2297f);
        this.f2290e.a(aVar.f2295d);
    }

    public b(b bVar, Bitmap bitmap, com.a.a.d.g<Bitmap> gVar) {
        this(new a(bVar.f2288c.f2292a, bVar.f2288c.f2293b, bVar.f2288c.f2294c, gVar, bVar.f2288c.f2296e, bVar.f2288c.f2297f, bVar.f2288c.g, bVar.f2288c.h, bitmap));
    }

    private void g() {
        this.j = 0;
    }

    private void h() {
        this.f2290e.c();
        invalidateSelf();
    }

    private void i() {
        if (this.f2289d.c() == 1) {
            invalidateSelf();
        } else {
            if (this.f2291f) {
                return;
            }
            this.f2291f = true;
            this.f2290e.a();
            invalidateSelf();
        }
    }

    private void j() {
        this.f2291f = false;
        this.f2290e.b();
    }

    @Override // com.a.a.d.d.b.b
    public void a(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0) {
            this.k = this.f2289d.e();
        } else {
            this.k = i;
        }
    }

    @Override // com.a.a.d.d.b.b
    public boolean a() {
        return true;
    }

    public Bitmap b() {
        return this.f2288c.i;
    }

    @Override // com.a.a.d.d.d.f.b
    @TargetApi(11)
    public void b(int i) {
        if (Build.VERSION.SDK_INT >= 11 && getCallback() == null) {
            stop();
            h();
            return;
        }
        invalidateSelf();
        if (i == this.f2289d.c() - 1) {
            this.j++;
        }
        if (this.k == -1 || this.j < this.k) {
            return;
        }
        stop();
    }

    public com.a.a.d.g<Bitmap> c() {
        return this.f2288c.f2295d;
    }

    public byte[] d() {
        return this.f2288c.f2293b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.h) {
            return;
        }
        if (this.l) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f2287b);
            this.l = false;
        }
        Bitmap bitmapD = this.f2290e.d();
        if (bitmapD == null) {
            bitmapD = this.f2288c.i;
        }
        canvas.drawBitmap(bitmapD, (Rect) null, this.f2287b, this.f2286a);
    }

    public int e() {
        return this.f2289d.c();
    }

    public void f() {
        this.h = true;
        this.f2288c.h.a(this.f2288c.i);
        this.f2290e.c();
        this.f2290e.b();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f2288c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2288c.i.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2288c.i.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f2291f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2286a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2286a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.i = z;
        if (!z) {
            j();
        } else if (this.g) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.g = true;
        g();
        if (this.i) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.g = false;
        j();
        if (Build.VERSION.SDK_INT < 11) {
            h();
        }
    }
}
