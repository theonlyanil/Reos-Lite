package a.a.a.b;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f51a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f52b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int[] f53c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f54d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f55e = 3000.0d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f56f = 3;
    private final double g = 0.75d;
    private final g h = new g();
    private final float i;

    public b(float f2, int i) {
        this.i = f2;
        this.f51a = new int[i];
        this.f52b = new int[i];
        this.f53c = new int[i];
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0264  */
    @Override // a.a.a.b.h
    public g a(float[] fArr) {
        float fPow;
        int i;
        int i2;
        int length = fArr.length;
        if (this.f51a.length == fArr.length) {
            Arrays.fill(this.f51a, 0);
            Arrays.fill(this.f52b, 0);
            Arrays.fill(this.f53c, 0);
        } else {
            this.f51a = new int[fArr.length];
            this.f52b = new int[fArr.length];
            this.f53c = new int[fArr.length];
        }
        double d2 = 0.0d;
        double dMax = 0.0d;
        double dMin = 0.0d;
        for (double d3 : fArr) {
            d2 += d3;
            dMax = Math.max(dMax, d3);
            dMin = Math.min(d3, dMin);
        }
        double length2 = d2 / ((double) fArr.length);
        double d4 = dMax - length2;
        double d5 = dMin - length2;
        if (d4 <= (-d5)) {
            d4 = -d5;
        }
        double d6 = d4 * 0.75d;
        double d7 = -1.0d;
        int i3 = 0;
        int i4 = length;
        while (true) {
            int iPow = (int) (((double) this.i) / (Math.pow(2.0d, i3) * 3000.0d));
            if (i4 < 2) {
                fPow = -1.0f;
                break;
            }
            double d8 = -1000.0d;
            int i5 = 0;
            int i6 = -1000000;
            int i7 = -1000000;
            boolean z = false;
            boolean z2 = false;
            int i8 = 2;
            int i9 = 0;
            while (i8 < i4) {
                double d9 = ((double) fArr[i8]) - length2;
                double d10 = ((double) fArr[i8 - 1]) - length2;
                if (d10 <= 0.0d && d9 > 0.0d) {
                    z = true;
                }
                if (d10 >= 0.0d && d9 < 0.0d) {
                    z2 = true;
                }
                double d11 = d9 - d10;
                if (d8 > -1000.0d) {
                    if (z2 && d8 < 0.0d && d11 >= 0.0d && Math.abs(d9) >= d6 && i8 > i6 + iPow) {
                        this.f52b[i9] = i8;
                        z2 = false;
                        i9++;
                        i6 = i8;
                    }
                    if (z && d8 > 0.0d && d11 <= 0.0d && Math.abs(d9) >= d6 && i8 > i7 + iPow) {
                        this.f53c[i5] = i8;
                        z = false;
                        i5++;
                        i7 = i8;
                    }
                }
                i8++;
                d8 = d11;
            }
            if (i9 == 0 && i5 == 0) {
                fPow = -1.0f;
                break;
            }
            Arrays.fill(this.f51a, 0);
            for (int i10 = 0; i10 < i9; i10++) {
                for (int i11 = 1; i11 < 3; i11++) {
                    if (i10 + i11 < i9) {
                        int iAbs = Math.abs(this.f52b[i10] - this.f52b[i10 + i11]);
                        this.f51a[iAbs] = this.f51a[iAbs] + 1;
                    }
                }
            }
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            while (i14 < i4) {
                int i15 = 0;
                for (int i16 = -iPow; i16 <= iPow; i16++) {
                    if (i14 + i16 >= 0 && i14 + i16 < i4) {
                        i15 += this.f51a[i14 + i16];
                    }
                }
                if (i15 == i13) {
                    if (i14 == i12 * 2) {
                        i15 = i13;
                        i2 = i14;
                    } else {
                        i15 = i13;
                        i2 = i12;
                    }
                } else if (i15 > i13) {
                    i2 = i14;
                } else {
                    i15 = i13;
                    i2 = i12;
                }
                i14++;
                i12 = i2;
                i13 = i15;
            }
            double d12 = 0.0d;
            double d13 = 0.0d;
            for (int i17 = -iPow; i17 <= iPow; i17++) {
                if (i12 + i17 >= 0 && i12 + i17 < fArr.length && (i = this.f51a[i12 + i17]) > 0) {
                    d12 += (double) i;
                    d13 += (double) (i * (i12 + i17));
                }
            }
            double d14 = d13 / d12;
            if (d7 > -1.0d && Math.abs((2.0d * d14) - d7) <= iPow * 2) {
                fPow = (float) (((double) this.i) / (d7 * Math.pow(2.0d, i3 - 1)));
                break;
            }
            int i18 = i3 + 1;
            if (i18 >= 6) {
                fPow = -1.0f;
                break;
            }
            if (i4 < 2) {
                fPow = -1.0f;
                break;
            }
            float[] fArr2 = i4 == this.f51a.length ? new float[i4 / 2] : fArr;
            for (int i19 = 0; i19 < i4 / 2; i19++) {
                fArr2[i19] = (fArr[i19 * 2] + fArr[(i19 * 2) + 1]) / 2.0f;
            }
            i4 /= 2;
            fArr = fArr2;
            i3 = i18;
            d7 = d14;
        }
        this.h.a(fPow);
        this.h.a(-1.0f != fPow);
        this.h.b(-1.0f);
        return this.h;
    }
}
