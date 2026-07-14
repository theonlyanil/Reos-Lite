package a.a.a.b;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f81a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f82b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f83c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f84d;

    public j(float f2, int i) {
        this(f2, i, 0.2d);
    }

    public j(float f2, int i, double d2) {
        this.f82b = f2;
        this.f81a = d2;
        this.f83c = new float[i / 2];
        this.f84d = new g();
    }

    private float a(int i) {
        int i2 = i < 1 ? i : i - 1;
        int i3 = i + 1 < this.f83c.length ? i + 1 : i;
        if (i2 == i) {
            return this.f83c[i] <= this.f83c[i3] ? i : i3;
        }
        if (i3 == i) {
            return this.f83c[i] <= this.f83c[i2] ? i : i2;
        }
        float f2 = this.f83c[i2];
        float f3 = this.f83c[i];
        float f4 = this.f83c[i3];
        return ((f4 - f2) / ((((f3 * 2.0f) - f4) - f2) * 2.0f)) + i;
    }

    private void a() {
        this.f83c[0] = 1.0f;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        for (int i = 1; i < this.f83c.length; i++) {
            f2 += this.f83c[i];
            float[] fArr = this.f83c;
            fArr[i] = fArr[i] * (i / f2);
        }
    }

    private int b() {
        int i = 2;
        while (i < this.f83c.length) {
            if (this.f83c[i] < this.f81a) {
                while (i + 1 < this.f83c.length && this.f83c[i + 1] < this.f83c[i]) {
                    i++;
                }
                this.f84d.b(1.0f - this.f83c[i]);
                break;
            }
            i++;
        }
        if (i != this.f83c.length && this.f83c[i] < this.f81a) {
            this.f84d.a(true);
            return i;
        }
        this.f84d.b(BitmapDescriptorFactory.HUE_RED);
        this.f84d.a(false);
        return -1;
    }

    private void b(float[] fArr) {
        for (int i = 0; i < this.f83c.length; i++) {
            this.f83c[i] = 0.0f;
        }
        for (int i2 = 1; i2 < this.f83c.length; i2++) {
            for (int i3 = 0; i3 < this.f83c.length; i3++) {
                float f2 = fArr[i3] - fArr[i3 + i2];
                float[] fArr2 = this.f83c;
                fArr2[i2] = (f2 * f2) + fArr2[i2];
            }
        }
    }

    @Override // a.a.a.b.h
    public g a(float[] fArr) {
        float fA;
        b(fArr);
        a();
        int iB = b();
        if (iB != -1) {
            fA = this.f82b / a(iB);
        } else {
            fA = -1.0f;
        }
        this.f84d.a(fA);
        return this.f84d;
    }
}
