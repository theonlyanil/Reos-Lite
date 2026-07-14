package android.support.design.widget;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.view.ah;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f423b;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private boolean H;
    private Interpolator J;
    private Interpolator K;
    private float L;
    private float M;
    private float N;
    private int O;
    private float P;
    private float Q;
    private float R;
    private int S;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f426e;
    private int m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private final TextPaint I = new TextPaint(129);
    private final Rect g = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f427f = new Rect();
    private final RectF h = new RectF();

    static {
        f422a = Build.VERSION.SDK_INT < 18;
        f423b = null;
        if (f423b != null) {
            f423b.setAntiAlias(true);
            f423b.setColor(-65281);
        }
    }

    public d(View view) {
        this.f424c = view;
    }

    private static float a(float f2, float f3, float f4, Interpolator interpolator) {
        if (interpolator != null) {
            f4 = interpolator.getInterpolation(f4);
        }
        return a.a(f2, f3, f4);
    }

    private static int a(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i) * f3) + (Color.alpha(i2) * f2)), (int) ((Color.red(i) * f3) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f3) + (Color.green(i2) * f2)), (int) ((f3 * Color.blue(i)) + (Color.blue(i2) * f2)));
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private boolean b(CharSequence charSequence) {
        return (ah.h(this.f424c) == 1 ? android.support.v4.g.e.f773d : android.support.v4.g.e.f772c).a(charSequence, 0, charSequence.length());
    }

    private void c(float f2) {
        d(f2);
        this.s = a(this.q, this.r, f2, this.J);
        this.t = a(this.o, this.p, f2, this.J);
        e(a(this.k, this.l, f2, this.K));
        if (this.n != this.m) {
            this.I.setColor(a(this.m, this.n, f2));
        } else {
            this.I.setColor(this.n);
        }
        this.I.setShadowLayer(a(this.P, this.L, f2, (Interpolator) null), a(this.Q, this.M, f2, (Interpolator) null), a(this.R, this.N, f2, (Interpolator) null), a(this.S, this.O, f2));
        ah.d(this.f424c);
    }

    private void d(float f2) {
        this.h.left = a(this.f427f.left, this.g.left, f2, this.J);
        this.h.top = a(this.o, this.p, f2, this.J);
        this.h.right = a(this.f427f.right, this.g.right, f2, this.J);
        this.h.bottom = a(this.f427f.bottom, this.g.bottom, f2, this.J);
    }

    private void e(float f2) {
        f(f2);
        this.A = f422a && this.F != 1.0f;
        if (this.A) {
            m();
        }
        ah.d(this.f424c);
    }

    private void f(float f2) {
        float fWidth;
        float f3;
        boolean z;
        if (this.x == null) {
            return;
        }
        if (a(f2, this.l)) {
            float fWidth2 = this.g.width();
            float f4 = this.l;
            this.F = 1.0f;
            if (this.w != this.u) {
                this.w = this.u;
                fWidth = fWidth2;
                f3 = f4;
                z = true;
            } else {
                fWidth = fWidth2;
                f3 = f4;
                z = false;
            }
        } else {
            fWidth = this.f427f.width();
            f3 = this.k;
            if (this.w != this.v) {
                this.w = this.v;
                z = true;
            } else {
                z = false;
            }
            if (a(f2, this.k)) {
                this.F = 1.0f;
            } else {
                this.F = f2 / this.k;
            }
        }
        if (fWidth > BitmapDescriptorFactory.HUE_RED) {
            z = this.G != f3 || this.H || z;
            this.G = f3;
            this.H = false;
        }
        if (this.y == null || z) {
            this.I.setTextSize(this.G);
            this.I.setTypeface(this.w);
            this.I.setLinearText(this.F != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.x, this.I, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.y)) {
                return;
            }
            this.y = charSequenceEllipsize;
            this.z = b(this.y);
        }
    }

    private Typeface g(int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f424c.getContext().obtainStyledAttributes(i, new int[]{R.attr.fontFamily});
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            return null;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void k() {
        c(this.f426e);
    }

    private void l() {
        float fMeasureText = BitmapDescriptorFactory.HUE_RED;
        float f2 = this.G;
        f(this.l);
        float fMeasureText2 = this.y != null ? this.I.measureText(this.y, 0, this.y.length()) : 0.0f;
        int iA = android.support.v4.view.e.a(this.j, this.z ? 1 : 0);
        switch (iA & 112) {
            case 48:
                this.p = this.g.top - this.I.ascent();
                break;
            case 80:
                this.p = this.g.bottom;
                break;
            default:
                this.p = (((this.I.descent() - this.I.ascent()) / 2.0f) - this.I.descent()) + this.g.centerY();
                break;
        }
        switch (iA & 8388615) {
            case 1:
                this.r = this.g.centerX() - (fMeasureText2 / 2.0f);
                break;
            case 5:
                this.r = this.g.right - fMeasureText2;
                break;
            default:
                this.r = this.g.left;
                break;
        }
        f(this.k);
        if (this.y != null) {
            fMeasureText = this.I.measureText(this.y, 0, this.y.length());
        }
        int iA2 = android.support.v4.view.e.a(this.i, this.z ? 1 : 0);
        switch (iA2 & 112) {
            case 48:
                this.o = this.f427f.top - this.I.ascent();
                break;
            case 80:
                this.o = this.f427f.bottom;
                break;
            default:
                this.o = (((this.I.descent() - this.I.ascent()) / 2.0f) - this.I.descent()) + this.f427f.centerY();
                break;
        }
        switch (iA2 & 8388615) {
            case 1:
                this.q = this.f427f.centerX() - (fMeasureText / 2.0f);
                break;
            case 5:
                this.q = this.f427f.right - fMeasureText;
                break;
            default:
                this.q = this.f427f.left;
                break;
        }
        n();
        e(f2);
    }

    private void m() {
        if (this.B != null || this.f427f.isEmpty() || TextUtils.isEmpty(this.y)) {
            return;
        }
        c(BitmapDescriptorFactory.HUE_RED);
        this.D = this.I.ascent();
        this.E = this.I.descent();
        int iRound = Math.round(this.I.measureText(this.y, 0, this.y.length()));
        int iRound2 = Math.round(this.E - this.D);
        if (iRound <= 0 || iRound2 <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
        new Canvas(this.B).drawText(this.y, 0, this.y.length(), BitmapDescriptorFactory.HUE_RED, iRound2 - this.I.descent(), this.I);
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    private void n() {
        if (this.B != null) {
            this.B.recycle();
            this.B = null;
        }
    }

    void a() {
        this.f425d = this.g.width() > 0 && this.g.height() > 0 && this.f427f.width() > 0 && this.f427f.height() > 0;
    }

    void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            h();
        }
    }

    void a(int i) {
        if (this.n != i) {
            this.n = i;
            h();
        }
    }

    void a(int i, int i2, int i3, int i4) {
        if (a(this.f427f, i, i2, i3, i4)) {
            return;
        }
        this.f427f.set(i, i2, i3, i4);
        this.H = true;
        a();
    }

    public void a(Canvas canvas) {
        float fAscent;
        int iSave = canvas.save();
        if (this.y != null && this.f425d) {
            float f2 = this.s;
            float f3 = this.t;
            boolean z = this.A && this.B != null;
            if (z) {
                fAscent = this.D * this.F;
                float f4 = this.E * this.F;
            } else {
                fAscent = this.I.ascent() * this.F;
                float fDescent = this.I.descent() * this.F;
            }
            if (z) {
                f3 += fAscent;
            }
            if (this.F != 1.0f) {
                canvas.scale(this.F, this.F, f2, f3);
            }
            if (z) {
                canvas.drawBitmap(this.B, f2, f3, this.C);
            } else {
                canvas.drawText(this.y, 0, this.y.length(), f2, f3, this.I);
            }
        }
        canvas.restoreToCount(iSave);
    }

    void a(Typeface typeface) {
        if (this.u != typeface) {
            this.u = typeface;
            h();
        }
    }

    void a(Interpolator interpolator) {
        this.K = interpolator;
        h();
    }

    void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.x)) {
            this.x = charSequence;
            this.y = null;
            n();
            h();
        }
    }

    int b() {
        return this.i;
    }

    void b(float f2) {
        float fA = n.a(f2, BitmapDescriptorFactory.HUE_RED, 1.0f);
        if (fA != this.f426e) {
            this.f426e = fA;
            k();
        }
    }

    void b(int i) {
        if (this.m != i) {
            this.m = i;
            h();
        }
    }

    void b(int i, int i2, int i3, int i4) {
        if (a(this.g, i, i2, i3, i4)) {
            return;
        }
        this.g.set(i, i2, i3, i4);
        this.H = true;
        a();
    }

    void b(Typeface typeface) {
        if (this.v != typeface) {
            this.v = typeface;
            h();
        }
    }

    void b(Interpolator interpolator) {
        this.J = interpolator;
        h();
    }

    int c() {
        return this.j;
    }

    void c(int i) {
        if (this.i != i) {
            this.i = i;
            h();
        }
    }

    void c(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        h();
    }

    Typeface d() {
        return this.u != null ? this.u : Typeface.DEFAULT;
    }

    void d(int i) {
        if (this.j != i) {
            this.j = i;
            h();
        }
    }

    Typeface e() {
        return this.v != null ? this.v : Typeface.DEFAULT;
    }

    void e(int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f424c.getContext().obtainStyledAttributes(i, android.support.design.a.i.TextAppearance);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.TextAppearance_android_textColor)) {
            this.n = typedArrayObtainStyledAttributes.getColor(android.support.design.a.i.TextAppearance_android_textColor, this.n);
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.TextAppearance_android_textSize)) {
            this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TextAppearance_android_textSize, (int) this.l);
        }
        this.O = typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.TextAppearance_android_shadowColor, 0);
        this.M = typedArrayObtainStyledAttributes.getFloat(android.support.design.a.i.TextAppearance_android_shadowDx, BitmapDescriptorFactory.HUE_RED);
        this.N = typedArrayObtainStyledAttributes.getFloat(android.support.design.a.i.TextAppearance_android_shadowDy, BitmapDescriptorFactory.HUE_RED);
        this.L = typedArrayObtainStyledAttributes.getFloat(android.support.design.a.i.TextAppearance_android_shadowRadius, BitmapDescriptorFactory.HUE_RED);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.u = g(i);
        }
        h();
    }

    float f() {
        return this.f426e;
    }

    void f(int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f424c.getContext().obtainStyledAttributes(i, android.support.design.a.i.TextAppearance);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.TextAppearance_android_textColor)) {
            this.m = typedArrayObtainStyledAttributes.getColor(android.support.design.a.i.TextAppearance_android_textColor, this.m);
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.TextAppearance_android_textSize)) {
            this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TextAppearance_android_textSize, (int) this.k);
        }
        this.S = typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.TextAppearance_android_shadowColor, 0);
        this.Q = typedArrayObtainStyledAttributes.getFloat(android.support.design.a.i.TextAppearance_android_shadowDx, BitmapDescriptorFactory.HUE_RED);
        this.R = typedArrayObtainStyledAttributes.getFloat(android.support.design.a.i.TextAppearance_android_shadowDy, BitmapDescriptorFactory.HUE_RED);
        this.P = typedArrayObtainStyledAttributes.getFloat(android.support.design.a.i.TextAppearance_android_shadowRadius, BitmapDescriptorFactory.HUE_RED);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.v = g(i);
        }
        h();
    }

    float g() {
        return this.l;
    }

    public void h() {
        if (this.f424c.getHeight() <= 0 || this.f424c.getWidth() <= 0) {
            return;
        }
        l();
        k();
    }

    CharSequence i() {
        return this.x;
    }

    int j() {
        return this.n;
    }
}
