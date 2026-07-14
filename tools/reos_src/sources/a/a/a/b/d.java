package a.a.a.b;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f58a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f59b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f60c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f61d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f62e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f63f;
    private final float[] g;
    private final a.a.a.c.a.a h;

    public d(float f2, int i) {
        this(f2, i, 0.2d);
    }

    public d(float f2, int i, double d2) {
        this.f59b = f2;
        this.f58a = d2;
        this.f60c = new float[i / 2];
        this.f62e = new float[i * 2];
        this.f63f = new float[i * 2];
        this.g = new float[i * 2];
        this.h = new a.a.a.c.a.a(i);
        this.f61d = new g();
    }

    private float a(int i) {
        int i2 = i < 1 ? i : i - 1;
        int i3 = i + 1 < this.f60c.length ? i + 1 : i;
        if (i2 == i) {
            return this.f60c[i] <= this.f60c[i3] ? i : i3;
        }
        if (i3 == i) {
            return this.f60c[i] <= this.f60c[i2] ? i : i2;
        }
        float f2 = this.f60c[i2];
        float f3 = this.f60c[i];
        float f4 = this.f60c[i3];
        return ((f4 - f2) / ((((f3 * 2.0f) - f4) - f2) * 2.0f)) + i;
    }

    private void a() {
        this.f60c[0] = 1.0f;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        for (int i = 1; i < this.f60c.length; i++) {
            f2 += this.f60c[i];
            float[] fArr = this.f60c;
            fArr[i] = fArr[i] * (i / f2);
        }
    }

    private int b() {
        int i = 2;
        while (i < this.f60c.length) {
            if (this.f60c[i] < this.f58a) {
                while (i + 1 < this.f60c.length && this.f60c[i + 1] < this.f60c[i]) {
                    i++;
                }
                this.f61d.b(1.0f - this.f60c[i]);
                break;
            }
            i++;
        }
        if (i != this.f60c.length && this.f60c[i] < this.f58a && this.f61d.c() <= 1.0d) {
            this.f61d.a(true);
            return i;
        }
        this.f61d.b(BitmapDescriptorFactory.HUE_RED);
        this.f61d.a(false);
        return -1;
    }

    private void b(float[] fArr) {
        float[] fArr2 = new float[this.f60c.length];
        for (int i = 0; i < this.f60c.length; i++) {
            fArr2[0] = fArr2[0] + (fArr[i] * fArr[i]);
        }
        for (int i2 = 1; i2 < this.f60c.length; i2++) {
            fArr2[i2] = (fArr2[i2 - 1] - (fArr[i2 - 1] * fArr[i2 - 1])) + (fArr[this.f60c.length + i2] * fArr[this.f60c.length + i2]);
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            this.f62e[i3 * 2] = fArr[i3];
            this.f62e[(i3 * 2) + 1] = 0.0f;
        }
        this.h.a(this.f62e);
        for (int i4 = 0; i4 < this.f60c.length; i4++) {
            this.f63f[i4 * 2] = fArr[(this.f60c.length - 1) - i4];
            this.f63f[(i4 * 2) + 1] = 0.0f;
            this.f63f[(i4 * 2) + fArr.length] = 0.0f;
            this.f63f[(i4 * 2) + fArr.length + 1] = 0.0f;
        }
        this.h.a(this.f63f);
        for (int i5 = 0; i5 < fArr.length; i5++) {
            this.g[i5 * 2] = (this.f62e[i5 * 2] * this.f63f[i5 * 2]) - (this.f62e[(i5 * 2) + 1] * this.f63f[(i5 * 2) + 1]);
            this.g[(i5 * 2) + 1] = (this.f62e[(i5 * 2) + 1] * this.f63f[i5 * 2]) + (this.f62e[i5 * 2] * this.f63f[(i5 * 2) + 1]);
        }
        this.h.a(this.g, true);
        for (int i6 = 0; i6 < this.f60c.length; i6++) {
            this.f60c[i6] = (fArr2[0] + fArr2[i6]) - (2.0f * this.g[((this.f60c.length - 1) + i6) * 2]);
        }
    }

    @Override // a.a.a.b.h
    public g a(float[] fArr) {
        float fA;
        b(fArr);
        a();
        int iB = b();
        if (iB != -1) {
            fA = this.f59b / a(iB);
        } else {
            fA = -1.0f;
        }
        this.f61d.a(fA);
        return this.f61d;
    }
}
