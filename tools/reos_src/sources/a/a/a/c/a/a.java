package a.a.a.c.a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final int[] l = {4, 2, 3, 5};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f93a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f94b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f95c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f96d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f97e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f98f;
    private float[] g;
    private float[] h;
    private float[] i;
    private float[] j;
    private EnumC0002a k;

    /* JADX INFO: renamed from: a.a.a.c.a.a$a, reason: collision with other inner class name */
    private enum EnumC0002a {
        SPLIT_RADIX,
        MIXED_RADIX,
        BLUESTEIN
    }

    public a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        this.f93a = i;
        if (a.a.a.c.a.c(i)) {
            this.k = EnumC0002a.SPLIT_RADIX;
            this.f95c = new int[((int) Math.ceil((1 << (((int) (Math.log(((double) i) + 0.5d) / Math.log(2.0d))) / 2)) + 2)) + 2];
            this.f96d = new float[i];
            int i2 = i * 2;
            this.f97e = this.f95c[0];
            if (i2 > (this.f97e << 2)) {
                this.f97e = i2 >> 2;
                a(this.f97e);
            }
            this.f98f = this.f95c[1];
            if (i > (this.f98f << 2)) {
                this.f98f = i >> 2;
                a(this.f98f, this.f96d, this.f97e);
                return;
            }
            return;
        }
        if (a(i, l) < 211) {
            this.k = EnumC0002a.MIXED_RADIX;
            this.g = new float[(i * 4) + 15];
            this.h = new float[(i * 2) + 15];
            a();
            b();
            return;
        }
        this.k = EnumC0002a.BLUESTEIN;
        this.f94b = a.a.a.c.a.a((i * 2) - 1);
        this.i = new float[this.f94b * 2];
        this.j = new float[this.f94b * 2];
        this.f95c = new int[((int) Math.ceil((1 << (((int) (Math.log(((double) this.f94b) + 0.5d) / Math.log(2.0d))) / 2)) + 2)) + 2];
        this.f96d = new float[this.f94b];
        int i3 = this.f94b * 2;
        this.f97e = this.f95c[0];
        if (i3 > (this.f97e << 2)) {
            this.f97e = i3 >> 2;
            a(this.f97e);
        }
        this.f98f = this.f95c[1];
        if (this.f94b > (this.f98f << 2)) {
            this.f98f = this.f94b >> 2;
            a(this.f98f, this.f96d, this.f97e);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, int i2, int i3, float[] fArr, int i4, int i5, float[] fArr2) {
        int i6 = i4 - i;
        if ((i3 & 3) != 0) {
            int i7 = i3 & 1;
            if (i7 != 0) {
                c(i, fArr, i6 + i2, fArr2, i5 - (i >> 1));
                return i7;
            }
            d(i, fArr, i6 + i2, fArr2, i5 - i);
            return i7;
        }
        int i8 = i;
        while ((i3 & 3) == 0) {
            i8 <<= 2;
            i3 >>= 2;
        }
        int i9 = i3 & 1;
        int i10 = i4 + i2;
        if (i9 != 0) {
            while (i8 > 128) {
                c(i8, fArr, i10 - i8, fArr2, i5 - (i8 >> 1));
                i8 >>= 2;
            }
        } else {
            while (i8 > 128) {
                d(i8, fArr, i10 - i8, fArr2, i5 - i8);
                i8 >>= 2;
            }
        }
        return i9;
    }

    private static int a(int i, int[] iArr) {
        if (i <= 0) {
            throw new IllegalArgumentException("n must be positive integer");
        }
        for (int i2 = 0; i2 < iArr.length && i != 1; i2++) {
            int i3 = iArr[i2];
            while (i % i3 == 0) {
                i /= i3;
            }
        }
        return i;
    }

    private void a(float f2, final float[] fArr, int i, boolean z) {
        final float f3 = (float) (1.0d / ((double) f2));
        int i2 = z ? this.f93a * 2 : this.f93a;
        int iB = a.a.a.c.a.b();
        if (iB <= 1 || i2 < a.a.a.c.a.c()) {
            for (int i3 = i; i3 < i + i2; i3++) {
                fArr[i3] = fArr[i3] * f3;
            }
            return;
        }
        int i4 = i2 / iB;
        Future[] futureArr = new Future[iB];
        int i5 = 0;
        while (i5 < iB) {
            final int i6 = i + (i5 * i4);
            final int i7 = i5 == iB + (-1) ? i + i2 : i6 + i4;
            futureArr[i5] = a.a.a.c.a.a(new Runnable() { // from class: a.a.a.c.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    for (int i8 = i6; i8 < i7; i8++) {
                        float[] fArr2 = fArr;
                        fArr2[i8] = fArr2[i8] * f3;
                    }
                }
            });
            i5++;
        }
        a.a.a.c.a.a((Future<?>[]) futureArr);
    }

    private void a(int i) {
        this.f95c[0] = i;
        this.f95c[1] = 1;
        if (i > 2) {
            int i2 = i >> 1;
            float f2 = (float) (0.7853981633974483d / ((double) i2));
            float f3 = 2.0f * f2;
            float fCos = (float) Math.cos(i2 * f2);
            this.f96d[0] = 1.0f;
            this.f96d[1] = fCos;
            if (i2 == 4) {
                this.f96d[2] = (float) Math.cos(f3);
                this.f96d[3] = (float) Math.sin(f3);
            } else if (i2 > 4) {
                b(i);
                this.f96d[2] = (float) (0.5d / Math.cos(f3));
                this.f96d[3] = (float) (0.5d / Math.cos(6.0f * f2));
                for (int i3 = 4; i3 < i2; i3 += 4) {
                    float f4 = i3 * f2;
                    float f5 = 3.0f * f4;
                    this.f96d[i3] = (float) Math.cos(f4);
                    this.f96d[i3 + 1] = (float) Math.sin(f4);
                    this.f96d[i3 + 2] = (float) Math.cos(f5);
                    this.f96d[i3 + 3] = (float) (-Math.sin(f5));
                }
            }
            int i4 = i2;
            int i5 = 0;
            while (i4 > 2) {
                int i6 = i5 + i4;
                int i7 = i4 >> 1;
                this.f96d[i6] = 1.0f;
                this.f96d[i6 + 1] = fCos;
                if (i7 == 4) {
                    float f6 = this.f96d[i5 + 4];
                    float f7 = this.f96d[i5 + 5];
                    this.f96d[i6 + 2] = f6;
                    this.f96d[i6 + 3] = f7;
                } else if (i7 > 4) {
                    float f8 = this.f96d[i5 + 4];
                    float f9 = this.f96d[i5 + 6];
                    this.f96d[i6 + 2] = (float) (0.5d / ((double) f8));
                    this.f96d[i6 + 3] = (float) (0.5d / ((double) f9));
                    for (int i8 = 4; i8 < i7; i8 += 4) {
                        int i9 = (i8 * 2) + i5;
                        int i10 = i6 + i8;
                        float f10 = this.f96d[i9];
                        float f11 = this.f96d[i9 + 1];
                        float f12 = this.f96d[i9 + 2];
                        float f13 = this.f96d[i9 + 3];
                        this.f96d[i10] = f10;
                        this.f96d[i10 + 1] = f11;
                        this.f96d[i10 + 2] = f12;
                        this.f96d[i10 + 3] = f13;
                    }
                }
                i5 = i6;
                i4 = i7;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, float[] fArr, int i3, int i4, float[] fArr2) {
        if (i == 512) {
            c(128, fArr, i3, fArr2, i4 - 64);
            a(fArr, i3, fArr2, i4 - 8);
            b(fArr, i3 + 32, fArr2, i4 - 32);
            a(fArr, i3 + 64, fArr2, i4 - 8);
            a(fArr, i3 + 96, fArr2, i4 - 8);
            d(128, fArr, i3 + 128, fArr2, i4 - 128);
            a(fArr, i3 + 128, fArr2, i4 - 8);
            b(fArr, i3 + 160, fArr2, i4 - 32);
            a(fArr, i3 + 192, fArr2, i4 - 8);
            b(fArr, i3 + 224, fArr2, i4 - 32);
            c(128, fArr, i3 + 256, fArr2, i4 - 64);
            a(fArr, i3 + 256, fArr2, i4 - 8);
            b(fArr, i3 + 288, fArr2, i4 - 32);
            a(fArr, i3 + 320, fArr2, i4 - 8);
            a(fArr, i3 + 352, fArr2, i4 - 8);
            if (i2 != 0) {
                c(128, fArr, i3 + 384, fArr2, i4 - 64);
                a(fArr, i3 + 480, fArr2, i4 - 8);
            } else {
                d(128, fArr, i3 + 384, fArr2, i4 - 128);
                b(fArr, i3 + 480, fArr2, i4 - 32);
            }
            a(fArr, i3 + 384, fArr2, i4 - 8);
            b(fArr, i3 + 416, fArr2, i4 - 32);
            a(fArr, i3 + 448, fArr2, i4 - 8);
            return;
        }
        c(64, fArr, i3, fArr2, i4 - 32);
        c(fArr, i3, fArr2, i4 - 8);
        d(fArr, i3 + 16, fArr2, i4 - 8);
        c(fArr, i3 + 32, fArr2, i4 - 8);
        c(fArr, i3 + 48, fArr2, i4 - 8);
        d(64, fArr, i3 + 64, fArr2, i4 - 64);
        c(fArr, i3 + 64, fArr2, i4 - 8);
        d(fArr, i3 + 80, fArr2, i4 - 8);
        c(fArr, i3 + 96, fArr2, i4 - 8);
        d(fArr, i3 + 112, fArr2, i4 - 8);
        c(64, fArr, i3 + 128, fArr2, i4 - 32);
        c(fArr, i3 + 128, fArr2, i4 - 8);
        d(fArr, i3 + 144, fArr2, i4 - 8);
        c(fArr, i3 + 160, fArr2, i4 - 8);
        c(fArr, i3 + 176, fArr2, i4 - 8);
        if (i2 != 0) {
            c(64, fArr, i3 + 192, fArr2, i4 - 32);
            c(fArr, i3 + 240, fArr2, i4 - 8);
        } else {
            d(64, fArr, i3 + 192, fArr2, i4 - 64);
            d(fArr, i3 + 240, fArr2, i4 - 8);
        }
        c(fArr, i3 + 192, fArr2, i4 - 8);
        d(fArr, i3 + 208, fArr2, i4 - 8);
        c(fArr, i3 + 224, fArr2, i4 - 8);
    }

    private void a(int i, float[] fArr, int i2) {
        this.f95c[1] = i;
        if (i > 1) {
            int i3 = i >> 1;
            float f2 = (float) (0.7853981633974483d / ((double) i3));
            fArr[i2] = (float) Math.cos(i3 * f2);
            fArr[i2 + i3] = (float) (((double) fArr[i2]) * 0.5d);
            for (int i4 = 1; i4 < i3; i4++) {
                float f3 = i4 * f2;
                fArr[i2 + i4] = (float) (Math.cos(f3) * 0.5d);
                fArr[(i2 + i) - i4] = (float) (Math.sin(f3) * 0.5d);
            }
        }
    }

    private void a(final int i, final float[] fArr, int i2, final int i3, final float[] fArr2) {
        int i4;
        int i5;
        int i6;
        final int i7 = i >> 1;
        if (i > a.a.a.c.a.d()) {
            i7 >>= 1;
            i4 = 4;
            i5 = 1;
        } else {
            i4 = 2;
            i5 = 0;
        }
        Future[] futureArr = new Future[i4];
        int i8 = 0;
        for (int i9 = 0; i9 < i4; i9++) {
            final int i10 = i2 + (i9 * i7);
            if (i9 != i5) {
                i6 = i8 + 1;
                futureArr[i8] = a.a.a.c.a.a(new Runnable() { // from class: a.a.a.c.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i11 = i10 + i7;
                        int i12 = i;
                        while (i12 > 512) {
                            i12 >>= 2;
                            a.this.c(i12, fArr, i11 - i12, fArr2, i3 - (i12 >> 1));
                        }
                        a.this.a(i12, 1, fArr, i11 - i12, i3, fArr2);
                        int i13 = 0;
                        int i14 = i10 - i12;
                        for (int i15 = i7 - i12; i15 > 0; i15 -= i12) {
                            i13++;
                            int i16 = i12;
                            a.this.a(i16, a.this.a(i12, i15, i13, fArr, i10, i3, fArr2), fArr, i14 + i15, i3, fArr2);
                        }
                    }
                });
            } else {
                i6 = i8 + 1;
                futureArr[i8] = a.a.a.c.a.a(new Runnable() { // from class: a.a.a.c.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i11 = i10 + i7;
                        int i12 = i;
                        int i13 = 1;
                        while (i12 > 512) {
                            i12 >>= 2;
                            a.this.d(i12, fArr, i11 - i12, fArr2, i3 - i12);
                            i13 <<= 2;
                        }
                        a.this.a(i12, 0, fArr, i11 - i12, i3, fArr2);
                        int i14 = i13 >> 1;
                        int i15 = i10 - i12;
                        for (int i16 = i7 - i12; i16 > 0; i16 -= i12) {
                            i14++;
                            a.this.a(i12, a.this.a(i12, i16, i14, fArr, i10, i3, fArr2), fArr, i15 + i16, i3, fArr2);
                        }
                    }
                });
            }
            i8 = i6;
        }
        a.a.a.c.a.a((Future<?>[]) futureArr);
    }

    private void a(int i, float[] fArr, int i2, float[] fArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = i2 + i5;
        int i9 = i6 + i2;
        int i10 = i7 + i2;
        float f2 = fArr[i2] + fArr[i9];
        float f3 = fArr[i2 + 1] + fArr[i9 + 1];
        float f4 = fArr[i2] - fArr[i9];
        float f5 = fArr[i2 + 1] - fArr[i9 + 1];
        float f6 = fArr[i8] + fArr[i10];
        float f7 = fArr[i8 + 1] + fArr[i10 + 1];
        float f8 = fArr[i8] - fArr[i10];
        float f9 = fArr[i8 + 1] - fArr[i10 + 1];
        fArr[i2] = f2 + f6;
        fArr[i2 + 1] = f3 + f7;
        fArr[i8] = f2 - f6;
        fArr[i8 + 1] = f3 - f7;
        fArr[i9] = f4 - f9;
        fArr[i9 + 1] = f5 + f8;
        fArr[i10] = f4 + f9;
        fArr[i10 + 1] = f5 - f8;
        float f10 = fArr2[i3 + 1];
        float f11 = fArr2[i3 + 2];
        float f12 = fArr2[i3 + 3];
        float f13 = 1.0f;
        float f14 = BitmapDescriptorFactory.HUE_RED;
        float f15 = 1.0f;
        float f16 = BitmapDescriptorFactory.HUE_RED;
        int i11 = 0;
        for (int i12 = 2; i12 < i4 - 2; i12 += 4) {
            i11 += 4;
            int i13 = i3 + i11;
            float f17 = f11 * (f13 + fArr2[i13]);
            float f18 = f11 * (f14 + fArr2[i13 + 1]);
            float f19 = f12 * (f15 + fArr2[i13 + 2]);
            float f20 = f12 * (f16 + fArr2[i13 + 3]);
            f13 = fArr2[i13];
            f14 = fArr2[i13 + 1];
            f15 = fArr2[i13 + 2];
            f16 = fArr2[i13 + 3];
            int i14 = i12 + i5;
            int i15 = i14 + i5;
            int i16 = i15 + i5;
            int i17 = i14 + i2;
            int i18 = i15 + i2;
            int i19 = i16 + i2;
            int i20 = i2 + i12;
            float f21 = fArr[i20] + fArr[i18];
            float f22 = fArr[i20 + 1] + fArr[i18 + 1];
            float f23 = fArr[i20] - fArr[i18];
            float f24 = fArr[i20 + 1] - fArr[i18 + 1];
            float f25 = fArr[i20 + 2] + fArr[i18 + 2];
            float f26 = fArr[i20 + 3] + fArr[i18 + 3];
            float f27 = fArr[i20 + 2] - fArr[i18 + 2];
            float f28 = fArr[i20 + 3] - fArr[i18 + 3];
            float f29 = fArr[i17] + fArr[i19];
            float f30 = fArr[i17 + 1] + fArr[i19 + 1];
            float f31 = fArr[i17] - fArr[i19];
            float f32 = fArr[i17 + 1] - fArr[i19 + 1];
            float f33 = fArr[i17 + 2] + fArr[i19 + 2];
            float f34 = fArr[i17 + 3] + fArr[i19 + 3];
            float f35 = fArr[i17 + 2] - fArr[i19 + 2];
            float f36 = fArr[i17 + 3] - fArr[i19 + 3];
            fArr[i20] = f21 + f29;
            fArr[i20 + 1] = f22 + f30;
            fArr[i20 + 2] = f25 + f33;
            fArr[i20 + 3] = f26 + f34;
            fArr[i17] = f21 - f29;
            fArr[i17 + 1] = f22 - f30;
            fArr[i17 + 2] = f25 - f33;
            fArr[i17 + 3] = f26 - f34;
            float f37 = f23 - f32;
            float f38 = f24 + f31;
            fArr[i18] = (f17 * f37) - (f18 * f38);
            fArr[i18 + 1] = (f37 * f18) + (f38 * f17);
            float f39 = f27 - f36;
            float f40 = f28 + f35;
            fArr[i18 + 2] = (f13 * f39) - (f14 * f40);
            fArr[i18 + 3] = (f39 * f14) + (f40 * f13);
            float f41 = f23 + f32;
            float f42 = f24 - f31;
            fArr[i19] = (f19 * f41) + (f20 * f42);
            fArr[i19 + 1] = (f42 * f19) - (f41 * f20);
            float f43 = f27 + f36;
            float f44 = f28 - f35;
            fArr[i19 + 2] = (f15 * f43) + (f16 * f44);
            fArr[i19 + 3] = (f44 * f15) - (f43 * f16);
            int i21 = i5 - i12;
            int i22 = i21 + i5;
            int i23 = i22 + i5;
            int i24 = i23 + i5;
            int i25 = i21 + i2;
            int i26 = i22 + i2;
            int i27 = i23 + i2;
            int i28 = i2 + i24;
            float f45 = fArr[i25] + fArr[i27];
            float f46 = fArr[i25 + 1] + fArr[i27 + 1];
            float f47 = fArr[i25] - fArr[i27];
            float f48 = fArr[i25 + 1] - fArr[i27 + 1];
            float f49 = fArr[i25 - 2] + fArr[i27 - 2];
            float f50 = fArr[i25 - 1] + fArr[i27 - 1];
            float f51 = fArr[i25 - 2] - fArr[i27 - 2];
            float f52 = fArr[i25 - 1] - fArr[i27 - 1];
            float f53 = fArr[i26] + fArr[i28];
            float f54 = fArr[i26 + 1] + fArr[i28 + 1];
            float f55 = fArr[i26] - fArr[i28];
            float f56 = fArr[i26 + 1] - fArr[i28 + 1];
            float f57 = fArr[i26 - 2] + fArr[i28 - 2];
            float f58 = fArr[i26 - 1] + fArr[i28 - 1];
            float f59 = fArr[i26 - 2] - fArr[i28 - 2];
            float f60 = fArr[i26 - 1] - fArr[i28 - 1];
            fArr[i25] = f45 + f53;
            fArr[i25 + 1] = f46 + f54;
            fArr[i25 - 2] = f49 + f57;
            fArr[i25 - 1] = f50 + f58;
            fArr[i26] = f45 - f53;
            fArr[i26 + 1] = f46 - f54;
            fArr[i26 - 2] = f49 - f57;
            fArr[i26 - 1] = f50 - f58;
            float f61 = f47 - f56;
            float f62 = f48 + f55;
            fArr[i27] = (f18 * f61) - (f17 * f62);
            fArr[i27 + 1] = (f61 * f17) + (f18 * f62);
            float f63 = f51 - f60;
            float f64 = f52 + f59;
            fArr[i27 - 2] = (f14 * f63) - (f13 * f64);
            fArr[i27 - 1] = (f63 * f13) + (f64 * f14);
            float f65 = f47 + f56;
            float f66 = f48 - f55;
            fArr[i28] = (f20 * f65) + (f19 * f66);
            fArr[i28 + 1] = (f66 * f20) - (f65 * f19);
            float f67 = f51 + f60;
            float f68 = f52 - f59;
            fArr[(i2 + i24) - 2] = (f16 * f67) + (f15 * f68);
            fArr[(i2 + i24) - 1] = (f68 * f16) - (f67 * f15);
        }
        float f69 = (f13 + f10) * f11;
        float f70 = (f14 + f10) * f11;
        float f71 = (f15 - f10) * f12;
        float f72 = (f16 - f10) * f12;
        int i29 = i4 + i5;
        int i30 = i29 + i5;
        int i31 = i5 + i30;
        int i32 = i4 + i2;
        int i33 = i29 + i2;
        int i34 = i30 + i2;
        int i35 = i31 + i2;
        float f73 = fArr[i32 - 2] + fArr[i34 - 2];
        float f74 = fArr[i32 - 1] + fArr[i34 - 1];
        float f75 = fArr[i32 - 2] - fArr[i34 - 2];
        float f76 = fArr[i32 - 1] - fArr[i34 - 1];
        float f77 = fArr[i33 - 2] + fArr[i35 - 2];
        float f78 = fArr[i33 - 1] + fArr[i35 - 1];
        float f79 = fArr[i33 - 2] - fArr[i35 - 2];
        float f80 = fArr[i33 - 1] - fArr[i35 - 1];
        fArr[i32 - 2] = f73 + f77;
        fArr[i32 - 1] = f74 + f78;
        fArr[i33 - 2] = f73 - f77;
        fArr[i33 - 1] = f74 - f78;
        float f81 = f75 - f80;
        float f82 = f76 + f79;
        fArr[i34 - 2] = (f69 * f81) - (f70 * f82);
        fArr[i34 - 1] = (f81 * f70) + (f82 * f69);
        float f83 = f75 + f80;
        float f84 = f76 - f79;
        fArr[i35 - 2] = (f71 * f83) + (f72 * f84);
        fArr[i35 - 1] = (f84 * f71) - (f83 * f72);
        float f85 = fArr[i32] + fArr[i34];
        float f86 = fArr[i32 + 1] + fArr[i34 + 1];
        float f87 = fArr[i32] - fArr[i34];
        float f88 = fArr[i32 + 1] - fArr[i34 + 1];
        float f89 = fArr[i33] + fArr[i35];
        float f90 = fArr[i33 + 1] + fArr[i35 + 1];
        float f91 = fArr[i33] - fArr[i35];
        float f92 = fArr[i33 + 1] - fArr[i35 + 1];
        fArr[i32] = f85 + f89;
        fArr[i32 + 1] = f86 + f90;
        fArr[i33] = f85 - f89;
        fArr[i33 + 1] = f86 - f90;
        float f93 = f87 - f92;
        float f94 = f88 + f91;
        fArr[i34] = (f93 - f94) * f10;
        fArr[i34 + 1] = (f93 + f94) * f10;
        float f95 = f87 + f92;
        float f96 = f88 - f91;
        fArr[i35] = (-f10) * (f95 + f96);
        fArr[i35 + 1] = (-f10) * (f96 - f95);
        float f97 = fArr[i32 + 2] + fArr[i34 + 2];
        float f98 = fArr[i32 + 3] + fArr[i34 + 3];
        float f99 = fArr[i32 + 2] - fArr[i34 + 2];
        float f100 = fArr[i32 + 3] - fArr[i34 + 3];
        float f101 = fArr[i33 + 2] + fArr[i35 + 2];
        float f102 = fArr[i33 + 3] + fArr[i35 + 3];
        float f103 = fArr[i33 + 2] - fArr[i35 + 2];
        float f104 = fArr[i33 + 3] - fArr[i35 + 3];
        fArr[i32 + 2] = f97 + f101;
        fArr[i32 + 3] = f98 + f102;
        fArr[i33 + 2] = f97 - f101;
        fArr[i33 + 3] = f98 - f102;
        float f105 = f99 - f104;
        float f106 = f100 + f103;
        fArr[i34 + 2] = (f70 * f105) - (f69 * f106);
        fArr[i34 + 3] = (f69 * f105) + (f70 * f106);
        float f107 = f99 + f104;
        float f108 = f100 - f103;
        fArr[i35 + 2] = (f72 * f107) + (f71 * f108);
        fArr[i35 + 3] = (f72 * f108) - (f107 * f71);
    }

    private void a(int i, float[] fArr, int i2, int[] iArr, int i3, float[] fArr2) {
        if (i <= 8) {
            if (i == 8) {
                f(fArr, i2);
                return;
            } else {
                if (i == 4) {
                    h(fArr, i2);
                    return;
                }
                return;
            }
        }
        if (i <= 32) {
            if (i == 32) {
                a(fArr, i2, fArr2, i3 - 8);
                b(fArr, i2);
                return;
            } else {
                c(fArr, i2, fArr2, 0);
                d(fArr, i2);
                return;
            }
        }
        a(i, fArr, i2, fArr2, i3 - (i >> 2));
        if (a.a.a.c.a.b() > 1 && i > a.a.a.c.a.c()) {
            a(i, fArr, i2, i3, fArr2);
        } else if (i > 512) {
            b(i, fArr, i2, i3, fArr2);
        } else if (i > 128) {
            a(i, 1, fArr, i2, i3, fArr2);
        } else {
            c(i, fArr, i2, i3, fArr2);
        }
        a(i, iArr, fArr, i2);
    }

    private void a(int i, int[] iArr, float[] fArr, int i2) {
        int i3;
        int i4 = 1;
        int i5 = i >> 2;
        while (true) {
            i3 = i4;
            if (i5 <= 8) {
                break;
            }
            i4 = i3 << 1;
            i5 >>= 2;
        }
        int i6 = i >> 1;
        int i7 = i3 * 4;
        if (i5 != 8) {
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = i8 * 4;
                for (int i10 = 0; i10 < i8; i10++) {
                    int i11 = (i10 * 4) + iArr[i3 + i8];
                    int i12 = iArr[i3 + i10] + i9;
                    int i13 = i2 + i11;
                    int i14 = i2 + i12;
                    float f2 = fArr[i13];
                    float f3 = fArr[i13 + 1];
                    float f4 = fArr[i14];
                    float f5 = fArr[i14 + 1];
                    fArr[i13] = f4;
                    fArr[i13 + 1] = f5;
                    fArr[i14] = f2;
                    fArr[i14 + 1] = f3;
                    int i15 = i11 + i7;
                    int i16 = i12 + i7;
                    int i17 = i2 + i15;
                    int i18 = i2 + i16;
                    float f6 = fArr[i17];
                    float f7 = fArr[i17 + 1];
                    float f8 = fArr[i18];
                    float f9 = fArr[i18 + 1];
                    fArr[i17] = f8;
                    fArr[i17 + 1] = f9;
                    fArr[i18] = f6;
                    fArr[i18 + 1] = f7;
                    int i19 = i15 + i6;
                    int i20 = i16 + 2;
                    int i21 = i2 + i19;
                    int i22 = i2 + i20;
                    float f10 = fArr[i21];
                    float f11 = fArr[i21 + 1];
                    float f12 = fArr[i22];
                    float f13 = fArr[i22 + 1];
                    fArr[i21] = f12;
                    fArr[i21 + 1] = f13;
                    fArr[i22] = f10;
                    fArr[i22 + 1] = f11;
                    int i23 = i19 - i7;
                    int i24 = i20 - i7;
                    int i25 = i2 + i23;
                    int i26 = i2 + i24;
                    float f14 = fArr[i25];
                    float f15 = fArr[i25 + 1];
                    float f16 = fArr[i26];
                    float f17 = fArr[i26 + 1];
                    fArr[i25] = f16;
                    fArr[i25 + 1] = f17;
                    fArr[i26] = f14;
                    fArr[i26 + 1] = f15;
                    int i27 = i23 + 2;
                    int i28 = i24 + i6;
                    int i29 = i2 + i27;
                    int i30 = i2 + i28;
                    float f18 = fArr[i29];
                    float f19 = fArr[i29 + 1];
                    float f20 = fArr[i30];
                    float f21 = fArr[i30 + 1];
                    fArr[i29] = f20;
                    fArr[i29 + 1] = f21;
                    fArr[i30] = f18;
                    fArr[i30 + 1] = f19;
                    int i31 = i27 + i7;
                    int i32 = i28 + i7;
                    int i33 = i2 + i31;
                    int i34 = i2 + i32;
                    float f22 = fArr[i33];
                    float f23 = fArr[i33 + 1];
                    float f24 = fArr[i34];
                    float f25 = fArr[i34 + 1];
                    fArr[i33] = f24;
                    fArr[i33 + 1] = f25;
                    fArr[i34] = f22;
                    fArr[i34 + 1] = f23;
                    int i35 = i31 - i6;
                    int i36 = i32 - 2;
                    int i37 = i2 + i35;
                    int i38 = i2 + i36;
                    float f26 = fArr[i37];
                    float f27 = fArr[i37 + 1];
                    float f28 = fArr[i38];
                    float f29 = fArr[i38 + 1];
                    fArr[i37] = f28;
                    fArr[i37 + 1] = f29;
                    fArr[i38] = f26;
                    fArr[i38 + 1] = f27;
                    int i39 = (i35 - i7) + i2;
                    int i40 = (i36 - i7) + i2;
                    float f30 = fArr[i39];
                    float f31 = fArr[i39 + 1];
                    float f32 = fArr[i40];
                    float f33 = fArr[i40 + 1];
                    fArr[i39] = f32;
                    fArr[i39 + 1] = f33;
                    fArr[i40] = f30;
                    fArr[i40 + 1] = f31;
                }
                int i41 = iArr[i3 + i8] + i9;
                int i42 = i41 + 2;
                int i43 = i41 + i6;
                int i44 = i2 + i42;
                int i45 = i2 + i43;
                float f34 = fArr[i44];
                float f35 = fArr[i44 + 1];
                float f36 = fArr[i45];
                float f37 = fArr[i45 + 1];
                fArr[i44] = f36;
                fArr[i44 + 1] = f37;
                fArr[i45] = f34;
                fArr[i45 + 1] = f35;
                int i46 = i42 + i7 + i2;
                int i47 = i43 + i7 + i2;
                float f38 = fArr[i46];
                float f39 = fArr[i46 + 1];
                float f40 = fArr[i47];
                float f41 = fArr[i47 + 1];
                fArr[i46] = f40;
                fArr[i46 + 1] = f41;
                fArr[i47] = f38;
                fArr[i47 + 1] = f39;
            }
            return;
        }
        for (int i48 = 0; i48 < i3; i48++) {
            int i49 = i48 * 4;
            for (int i50 = 0; i50 < i48; i50++) {
                int i51 = (i50 * 4) + (iArr[i3 + i48] * 2);
                int i52 = (iArr[i3 + i50] * 2) + i49;
                int i53 = i2 + i51;
                int i54 = i2 + i52;
                float f42 = fArr[i53];
                float f43 = fArr[i53 + 1];
                float f44 = fArr[i54];
                float f45 = fArr[i54 + 1];
                fArr[i53] = f44;
                fArr[i53 + 1] = f45;
                fArr[i54] = f42;
                fArr[i54 + 1] = f43;
                int i55 = i51 + i7;
                int i56 = i52 + (i7 * 2);
                int i57 = i2 + i55;
                int i58 = i2 + i56;
                float f46 = fArr[i57];
                float f47 = fArr[i57 + 1];
                float f48 = fArr[i58];
                float f49 = fArr[i58 + 1];
                fArr[i57] = f48;
                fArr[i57 + 1] = f49;
                fArr[i58] = f46;
                fArr[i58 + 1] = f47;
                int i59 = i55 + i7;
                int i60 = i56 - i7;
                int i61 = i2 + i59;
                int i62 = i2 + i60;
                float f50 = fArr[i61];
                float f51 = fArr[i61 + 1];
                float f52 = fArr[i62];
                float f53 = fArr[i62 + 1];
                fArr[i61] = f52;
                fArr[i61 + 1] = f53;
                fArr[i62] = f50;
                fArr[i62 + 1] = f51;
                int i63 = i59 + i7;
                int i64 = i60 + (i7 * 2);
                int i65 = i2 + i63;
                int i66 = i2 + i64;
                float f54 = fArr[i65];
                float f55 = fArr[i65 + 1];
                float f56 = fArr[i66];
                float f57 = fArr[i66 + 1];
                fArr[i65] = f56;
                fArr[i65 + 1] = f57;
                fArr[i66] = f54;
                fArr[i66 + 1] = f55;
                int i67 = i63 + i6;
                int i68 = i64 + 2;
                int i69 = i2 + i67;
                int i70 = i2 + i68;
                float f58 = fArr[i69];
                float f59 = fArr[i69 + 1];
                float f60 = fArr[i70];
                float f61 = fArr[i70 + 1];
                fArr[i69] = f60;
                fArr[i69 + 1] = f61;
                fArr[i70] = f58;
                fArr[i70 + 1] = f59;
                int i71 = i67 - i7;
                int i72 = i68 - (i7 * 2);
                int i73 = i2 + i71;
                int i74 = i2 + i72;
                float f62 = fArr[i73];
                float f63 = fArr[i73 + 1];
                float f64 = fArr[i74];
                float f65 = fArr[i74 + 1];
                fArr[i73] = f64;
                fArr[i73 + 1] = f65;
                fArr[i74] = f62;
                fArr[i74 + 1] = f63;
                int i75 = i71 - i7;
                int i76 = i72 + i7;
                int i77 = i2 + i75;
                int i78 = i2 + i76;
                float f66 = fArr[i77];
                float f67 = fArr[i77 + 1];
                float f68 = fArr[i78];
                float f69 = fArr[i78 + 1];
                fArr[i77] = f68;
                fArr[i77 + 1] = f69;
                fArr[i78] = f66;
                fArr[i78 + 1] = f67;
                int i79 = i75 - i7;
                int i80 = i76 - (i7 * 2);
                int i81 = i2 + i79;
                int i82 = i2 + i80;
                float f70 = fArr[i81];
                float f71 = fArr[i81 + 1];
                float f72 = fArr[i82];
                float f73 = fArr[i82 + 1];
                fArr[i81] = f72;
                fArr[i81 + 1] = f73;
                fArr[i82] = f70;
                fArr[i82 + 1] = f71;
                int i83 = i79 + 2;
                int i84 = i80 + i6;
                int i85 = i2 + i83;
                int i86 = i2 + i84;
                float f74 = fArr[i85];
                float f75 = fArr[i85 + 1];
                float f76 = fArr[i86];
                float f77 = fArr[i86 + 1];
                fArr[i85] = f76;
                fArr[i85 + 1] = f77;
                fArr[i86] = f74;
                fArr[i86 + 1] = f75;
                int i87 = i83 + i7;
                int i88 = i84 + (i7 * 2);
                int i89 = i2 + i87;
                int i90 = i2 + i88;
                float f78 = fArr[i89];
                float f79 = fArr[i89 + 1];
                float f80 = fArr[i90];
                float f81 = fArr[i90 + 1];
                fArr[i89] = f80;
                fArr[i89 + 1] = f81;
                fArr[i90] = f78;
                fArr[i90 + 1] = f79;
                int i91 = i87 + i7;
                int i92 = i88 - i7;
                int i93 = i2 + i91;
                int i94 = i2 + i92;
                float f82 = fArr[i93];
                float f83 = fArr[i93 + 1];
                float f84 = fArr[i94];
                float f85 = fArr[i94 + 1];
                fArr[i93] = f84;
                fArr[i93 + 1] = f85;
                fArr[i94] = f82;
                fArr[i94 + 1] = f83;
                int i95 = i91 + i7;
                int i96 = i92 + (i7 * 2);
                int i97 = i2 + i95;
                int i98 = i2 + i96;
                float f86 = fArr[i97];
                float f87 = fArr[i97 + 1];
                float f88 = fArr[i98];
                float f89 = fArr[i98 + 1];
                fArr[i97] = f88;
                fArr[i97 + 1] = f89;
                fArr[i98] = f86;
                fArr[i98 + 1] = f87;
                int i99 = i95 - i6;
                int i100 = i96 - 2;
                int i101 = i2 + i99;
                int i102 = i2 + i100;
                float f90 = fArr[i101];
                float f91 = fArr[i101 + 1];
                float f92 = fArr[i102];
                float f93 = fArr[i102 + 1];
                fArr[i101] = f92;
                fArr[i101 + 1] = f93;
                fArr[i102] = f90;
                fArr[i102 + 1] = f91;
                int i103 = i99 - i7;
                int i104 = i100 - (i7 * 2);
                int i105 = i2 + i103;
                int i106 = i2 + i104;
                float f94 = fArr[i105];
                float f95 = fArr[i105 + 1];
                float f96 = fArr[i106];
                float f97 = fArr[i106 + 1];
                fArr[i105] = f96;
                fArr[i105 + 1] = f97;
                fArr[i106] = f94;
                fArr[i106 + 1] = f95;
                int i107 = i103 - i7;
                int i108 = i104 + i7;
                int i109 = i2 + i107;
                int i110 = i2 + i108;
                float f98 = fArr[i109];
                float f99 = fArr[i109 + 1];
                float f100 = fArr[i110];
                float f101 = fArr[i110 + 1];
                fArr[i109] = f100;
                fArr[i109 + 1] = f101;
                fArr[i110] = f98;
                fArr[i110 + 1] = f99;
                int i111 = (i107 - i7) + i2;
                int i112 = (i108 - (i7 * 2)) + i2;
                float f102 = fArr[i111];
                float f103 = fArr[i111 + 1];
                float f104 = fArr[i112];
                float f105 = fArr[i112 + 1];
                fArr[i111] = f104;
                fArr[i111 + 1] = f105;
                fArr[i112] = f102;
                fArr[i112 + 1] = f103;
            }
            int i113 = (iArr[i3 + i48] * 2) + i49;
            int i114 = i113 + 2;
            int i115 = i113 + i6;
            int i116 = i2 + i114;
            int i117 = i2 + i115;
            float f106 = fArr[i116];
            float f107 = fArr[i116 + 1];
            float f108 = fArr[i117];
            float f109 = fArr[i117 + 1];
            fArr[i116] = f108;
            fArr[i116 + 1] = f109;
            fArr[i117] = f106;
            fArr[i117 + 1] = f107;
            int i118 = i114 + i7;
            int i119 = i115 + (i7 * 2);
            int i120 = i2 + i118;
            int i121 = i2 + i119;
            float f110 = fArr[i120];
            float f111 = fArr[i120 + 1];
            float f112 = fArr[i121];
            float f113 = fArr[i121 + 1];
            fArr[i120] = f112;
            fArr[i120 + 1] = f113;
            fArr[i121] = f110;
            fArr[i121 + 1] = f111;
            int i122 = i118 + i7;
            int i123 = i119 - i7;
            int i124 = i2 + i122;
            int i125 = i2 + i123;
            float f114 = fArr[i124];
            float f115 = fArr[i124 + 1];
            float f116 = fArr[i125];
            float f117 = fArr[i125 + 1];
            fArr[i124] = f116;
            fArr[i124 + 1] = f117;
            fArr[i125] = f114;
            fArr[i125 + 1] = f115;
            int i126 = i122 - 2;
            int i127 = i123 - i6;
            int i128 = i2 + i126;
            int i129 = i2 + i127;
            float f118 = fArr[i128];
            float f119 = fArr[i128 + 1];
            float f120 = fArr[i129];
            float f121 = fArr[i129 + 1];
            fArr[i128] = f120;
            fArr[i128 + 1] = f121;
            fArr[i129] = f118;
            fArr[i129 + 1] = f119;
            int i130 = i126 + i6 + 2;
            int i131 = i127 + i6 + 2;
            int i132 = i2 + i130;
            int i133 = i2 + i131;
            float f122 = fArr[i132];
            float f123 = fArr[i132 + 1];
            float f124 = fArr[i133];
            float f125 = fArr[i133 + 1];
            fArr[i132] = f124;
            fArr[i132 + 1] = f125;
            fArr[i133] = f122;
            fArr[i133 + 1] = f123;
            int i134 = (i130 - (i6 - i7)) + i2;
            int i135 = i131 + ((i7 * 2) - 2) + i2;
            float f126 = fArr[i134];
            float f127 = fArr[i134 + 1];
            float f128 = fArr[i135];
            float f129 = fArr[i135 + 1];
            fArr[i134] = f128;
            fArr[i134 + 1] = f129;
            fArr[i135] = f126;
            fArr[i135 + 1] = f127;
        }
    }

    private void a(float[] fArr, int i, float[] fArr2, int i2) {
        float f2 = fArr2[i2 + 1];
        float f3 = fArr2[i2 + 2];
        float f4 = fArr2[i2 + 3];
        float f5 = fArr[i] + fArr[i + 16];
        float f6 = fArr[i + 1] + fArr[i + 17];
        float f7 = fArr[i] - fArr[i + 16];
        float f8 = fArr[i + 1] - fArr[i + 17];
        float f9 = fArr[i + 8] + fArr[i + 24];
        float f10 = fArr[i + 9] + fArr[i + 25];
        float f11 = fArr[i + 8] - fArr[i + 24];
        float f12 = fArr[i + 9] - fArr[i + 25];
        float f13 = f5 + f9;
        float f14 = f6 + f10;
        float f15 = f5 - f9;
        float f16 = f6 - f10;
        float f17 = f7 - f12;
        float f18 = f8 + f11;
        float f19 = f7 + f12;
        float f20 = f8 - f11;
        float f21 = fArr[i + 2] + fArr[i + 18];
        float f22 = fArr[i + 3] + fArr[i + 19];
        float f23 = fArr[i + 2] - fArr[i + 18];
        float f24 = fArr[i + 3] - fArr[i + 19];
        float f25 = fArr[i + 10] + fArr[i + 26];
        float f26 = fArr[i + 11] + fArr[i + 27];
        float f27 = fArr[i + 10] - fArr[i + 26];
        float f28 = fArr[i + 11] - fArr[i + 27];
        float f29 = f21 + f25;
        float f30 = f22 + f26;
        float f31 = f21 - f25;
        float f32 = f22 - f26;
        float f33 = f23 - f28;
        float f34 = f24 + f27;
        float f35 = (f3 * f33) - (f4 * f34);
        float f36 = (f33 * f4) + (f34 * f3);
        float f37 = f23 + f28;
        float f38 = f24 - f27;
        float f39 = (f4 * f37) - (f3 * f38);
        float f40 = (f37 * f3) + (f38 * f4);
        float f41 = fArr[i + 4] + fArr[i + 20];
        float f42 = fArr[i + 5] + fArr[i + 21];
        float f43 = fArr[i + 4] - fArr[i + 20];
        float f44 = fArr[i + 5] - fArr[i + 21];
        float f45 = fArr[i + 12] + fArr[i + 28];
        float f46 = fArr[i + 13] + fArr[i + 29];
        float f47 = fArr[i + 12] - fArr[i + 28];
        float f48 = fArr[i + 13] - fArr[i + 29];
        float f49 = f41 + f45;
        float f50 = f42 + f46;
        float f51 = f41 - f45;
        float f52 = f42 - f46;
        float f53 = f43 - f48;
        float f54 = f44 + f47;
        float f55 = (f53 - f54) * f2;
        float f56 = (f53 + f54) * f2;
        float f57 = f43 + f48;
        float f58 = f44 - f47;
        float f59 = (f57 + f58) * f2;
        float f60 = (f58 - f57) * f2;
        float f61 = fArr[i + 6] + fArr[i + 22];
        float f62 = fArr[i + 7] + fArr[i + 23];
        float f63 = fArr[i + 6] - fArr[i + 22];
        float f64 = fArr[i + 7] - fArr[i + 23];
        float f65 = fArr[i + 14] + fArr[i + 30];
        float f66 = fArr[i + 15] + fArr[i + 31];
        float f67 = fArr[i + 14] - fArr[i + 30];
        float f68 = fArr[i + 15] - fArr[i + 31];
        float f69 = f61 + f65;
        float f70 = f62 + f66;
        float f71 = f61 - f65;
        float f72 = f62 - f66;
        float f73 = f63 - f68;
        float f74 = f64 + f67;
        float f75 = (f4 * f73) - (f3 * f74);
        float f76 = (f73 * f3) + (f74 * f4);
        float f77 = f63 + f68;
        float f78 = f64 - f67;
        float f79 = (f3 * f77) - (f4 * f78);
        float f80 = (f3 * f78) + (f4 * f77);
        float f81 = f19 - f59;
        float f82 = f20 - f60;
        float f83 = f19 + f59;
        float f84 = f20 + f60;
        float f85 = f39 - f79;
        float f86 = f40 - f80;
        float f87 = f39 + f79;
        float f88 = f80 + f40;
        fArr[i + 24] = f81 + f85;
        fArr[i + 25] = f82 + f86;
        fArr[i + 26] = f81 - f85;
        fArr[i + 27] = f82 - f86;
        fArr[i + 28] = f83 - f88;
        fArr[i + 29] = f84 + f87;
        fArr[i + 30] = f88 + f83;
        fArr[i + 31] = f84 - f87;
        float f89 = f17 + f55;
        float f90 = f18 + f56;
        float f91 = f17 - f55;
        float f92 = f18 - f56;
        float f93 = f35 + f75;
        float f94 = f36 + f76;
        float f95 = f35 - f75;
        float f96 = f36 - f76;
        fArr[i + 16] = f89 + f93;
        fArr[i + 17] = f90 + f94;
        fArr[i + 18] = f89 - f93;
        fArr[i + 19] = f90 - f94;
        fArr[i + 20] = f91 - f96;
        fArr[i + 21] = f92 + f95;
        fArr[i + 22] = f91 + f96;
        fArr[i + 23] = f92 - f95;
        float f97 = f31 - f72;
        float f98 = f32 + f71;
        float f99 = (f97 - f98) * f2;
        float f100 = (f97 + f98) * f2;
        float f101 = f31 + f72;
        float f102 = f32 - f71;
        float f103 = (f101 - f102) * f2;
        float f104 = f2 * (f101 + f102);
        float f105 = f15 - f52;
        float f106 = f16 + f51;
        float f107 = f15 + f52;
        float f108 = f16 - f51;
        fArr[i + 8] = f105 + f99;
        fArr[i + 9] = f106 + f100;
        fArr[i + 10] = f105 - f99;
        fArr[i + 11] = f106 - f100;
        fArr[i + 12] = f107 - f104;
        fArr[i + 13] = f108 + f103;
        fArr[i + 14] = f104 + f107;
        fArr[i + 15] = f108 - f103;
        float f109 = f13 + f49;
        float f110 = f14 + f50;
        float f111 = f13 - f49;
        float f112 = f14 - f50;
        float f113 = f29 + f69;
        float f114 = f30 + f70;
        float f115 = f29 - f69;
        float f116 = f30 - f70;
        fArr[i] = f109 + f113;
        fArr[i + 1] = f110 + f114;
        fArr[i + 2] = f109 - f113;
        fArr[i + 3] = f110 - f114;
        fArr[i + 4] = f111 - f116;
        fArr[i + 5] = f112 + f115;
        fArr[i + 6] = f111 + f116;
        fArr[i + 7] = f112 - f115;
    }

    private void b(int i) {
        int i2 = 2;
        this.f95c[2] = 0;
        this.f95c[3] = 16;
        while (i > 32) {
            int i3 = i2 << 1;
            int i4 = i3 << 3;
            for (int i5 = i2; i5 < i3; i5++) {
                int i6 = this.f95c[i5] << 2;
                this.f95c[i2 + i5] = i6;
                this.f95c[i3 + i5] = i6 + i4;
            }
            i >>= 2;
            i2 = i3;
        }
    }

    private void b(int i, float[] fArr, int i2, int i3, float[] fArr2) {
        int i4 = i2 + i;
        int i5 = i;
        while (i5 > 512) {
            i5 >>= 2;
            c(i5, fArr, i4 - i5, fArr2, i3 - (i5 >> 1));
        }
        a(i5, 1, fArr, i4 - i5, i3, fArr2);
        int i6 = 0;
        int i7 = i2 - i5;
        for (int i8 = i - i5; i8 > 0; i8 -= i5) {
            i6++;
            a(i5, a(i5, i8, i6, fArr, i2, i3, fArr2), fArr, i7 + i8, i3, fArr2);
        }
    }

    private void b(int i, float[] fArr, int i2, float[] fArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = i2 + i5;
        int i9 = i6 + i2;
        int i10 = i7 + i2;
        float f2 = fArr[i2] + fArr[i9];
        float f3 = (-fArr[i2 + 1]) - fArr[i9 + 1];
        float f4 = fArr[i2] - fArr[i9];
        float f5 = (-fArr[i2 + 1]) + fArr[i9 + 1];
        float f6 = fArr[i8] + fArr[i10];
        float f7 = fArr[i8 + 1] + fArr[i10 + 1];
        float f8 = fArr[i8] - fArr[i10];
        float f9 = fArr[i8 + 1] - fArr[i10 + 1];
        fArr[i2] = f2 + f6;
        fArr[i2 + 1] = f3 - f7;
        fArr[i8] = f2 - f6;
        fArr[i8 + 1] = f3 + f7;
        fArr[i9] = f4 + f9;
        fArr[i9 + 1] = f5 + f8;
        fArr[i10] = f4 - f9;
        fArr[i10 + 1] = f5 - f8;
        float f10 = fArr2[i3 + 1];
        float f11 = fArr2[i3 + 2];
        float f12 = fArr2[i3 + 3];
        float f13 = 1.0f;
        float f14 = BitmapDescriptorFactory.HUE_RED;
        float f15 = 1.0f;
        float f16 = BitmapDescriptorFactory.HUE_RED;
        int i11 = 0;
        for (int i12 = 2; i12 < i4 - 2; i12 += 4) {
            i11 += 4;
            int i13 = i3 + i11;
            float f17 = f11 * (f13 + fArr2[i13]);
            float f18 = f11 * (f14 + fArr2[i13 + 1]);
            float f19 = f12 * (f15 + fArr2[i13 + 2]);
            float f20 = f12 * (f16 + fArr2[i13 + 3]);
            f13 = fArr2[i13];
            f14 = fArr2[i13 + 1];
            f15 = fArr2[i13 + 2];
            f16 = fArr2[i13 + 3];
            int i14 = i12 + i5;
            int i15 = i14 + i5;
            int i16 = i14 + i2;
            int i17 = i2 + i15;
            int i18 = i15 + i5 + i2;
            int i19 = i2 + i12;
            float f21 = fArr[i19] + fArr[i17];
            float f22 = (-fArr[i19 + 1]) - fArr[i17 + 1];
            float f23 = fArr[i19] - fArr[i15 + i2];
            float f24 = (-fArr[i19 + 1]) + fArr[i17 + 1];
            float f25 = fArr[i19 + 2] + fArr[i17 + 2];
            float f26 = (-fArr[i19 + 3]) - fArr[i17 + 3];
            float f27 = fArr[i19 + 2] - fArr[i17 + 2];
            float f28 = (-fArr[i19 + 3]) + fArr[i17 + 3];
            float f29 = fArr[i16] + fArr[i18];
            float f30 = fArr[i16 + 1] + fArr[i18 + 1];
            float f31 = fArr[i16] - fArr[i18];
            float f32 = fArr[i16 + 1] - fArr[i18 + 1];
            float f33 = fArr[i16 + 2] + fArr[i18 + 2];
            float f34 = fArr[i16 + 3] + fArr[i18 + 3];
            float f35 = fArr[i16 + 2] - fArr[i18 + 2];
            float f36 = fArr[i16 + 3] - fArr[i18 + 3];
            fArr[i19] = f21 + f29;
            fArr[i19 + 1] = f22 - f30;
            fArr[i19 + 2] = f25 + f33;
            fArr[i19 + 3] = f26 - f34;
            fArr[i16] = f21 - f29;
            fArr[i16 + 1] = f22 + f30;
            fArr[i16 + 2] = f25 - f33;
            fArr[i16 + 3] = f26 + f34;
            float f37 = f23 + f32;
            float f38 = f24 + f31;
            fArr[i17] = (f17 * f37) - (f18 * f38);
            fArr[i17 + 1] = (f37 * f18) + (f38 * f17);
            float f39 = f27 + f36;
            float f40 = f28 + f35;
            fArr[i17 + 2] = (f13 * f39) - (f14 * f40);
            fArr[i17 + 3] = (f39 * f14) + (f40 * f13);
            float f41 = f23 - f32;
            float f42 = f24 - f31;
            fArr[i18] = (f19 * f41) + (f20 * f42);
            fArr[i18 + 1] = (f42 * f19) - (f41 * f20);
            float f43 = f27 - f36;
            float f44 = f28 - f35;
            fArr[i18 + 2] = (f15 * f43) + (f16 * f44);
            fArr[i18 + 3] = (f44 * f15) - (f43 * f16);
            int i20 = i5 - i12;
            int i21 = i20 + i5;
            int i22 = i21 + i5;
            int i23 = i22 + i5;
            int i24 = i20 + i2;
            int i25 = i21 + i2;
            int i26 = i22 + i2;
            int i27 = i23 + i2;
            float f45 = fArr[i24] + fArr[i26];
            float f46 = (-fArr[i24 + 1]) - fArr[i26 + 1];
            float f47 = fArr[i24] - fArr[i26];
            float f48 = (-fArr[i24 + 1]) + fArr[i26 + 1];
            float f49 = fArr[i24 - 2] + fArr[i26 - 2];
            float f50 = (-fArr[i24 - 1]) - fArr[i26 - 1];
            float f51 = fArr[i24 - 2] - fArr[i26 - 2];
            float f52 = (-fArr[i24 - 1]) + fArr[i26 - 1];
            float f53 = fArr[i25] + fArr[i27];
            float f54 = fArr[i25 + 1] + fArr[i27 + 1];
            float f55 = fArr[i25] - fArr[i27];
            float f56 = fArr[i25 + 1] - fArr[i27 + 1];
            float f57 = fArr[i25 - 2] + fArr[i27 - 2];
            float f58 = fArr[i25 - 1] + fArr[i27 - 1];
            float f59 = fArr[i25 - 2] - fArr[i27 - 2];
            float f60 = fArr[i25 - 1] - fArr[i27 - 1];
            fArr[i24] = f45 + f53;
            fArr[i24 + 1] = f46 - f54;
            fArr[i24 - 2] = f49 + f57;
            fArr[i24 - 1] = f50 - f58;
            fArr[i25] = f45 - f53;
            fArr[i25 + 1] = f46 + f54;
            fArr[i25 - 2] = f49 - f57;
            fArr[i25 - 1] = f50 + f58;
            float f61 = f47 + f56;
            float f62 = f48 + f55;
            fArr[i26] = (f18 * f61) - (f17 * f62);
            fArr[i26 + 1] = (f61 * f17) + (f18 * f62);
            float f63 = f51 + f60;
            float f64 = f52 + f59;
            fArr[i26 - 2] = (f14 * f63) - (f13 * f64);
            fArr[i26 - 1] = (f63 * f13) + (f64 * f14);
            float f65 = f47 - f56;
            float f66 = f48 - f55;
            fArr[i27] = (f20 * f65) + (f19 * f66);
            fArr[i27 + 1] = (f66 * f20) - (f65 * f19);
            float f67 = f51 - f60;
            float f68 = f52 - f59;
            fArr[i27 - 2] = (f16 * f67) + (f15 * f68);
            fArr[i27 - 1] = (f68 * f16) - (f67 * f15);
        }
        float f69 = (f13 + f10) * f11;
        float f70 = (f14 + f10) * f11;
        float f71 = (f15 - f10) * f12;
        float f72 = (f16 - f10) * f12;
        int i28 = i4 + i5;
        int i29 = i28 + i5;
        int i30 = i5 + i29;
        int i31 = i4 + i2;
        int i32 = i28 + i2;
        int i33 = i29 + i2;
        int i34 = i30 + i2;
        float f73 = fArr[i31 - 2] + fArr[i33 - 2];
        float f74 = (-fArr[i31 - 1]) - fArr[i33 - 1];
        float f75 = fArr[i31 - 2] - fArr[i33 - 2];
        float f76 = (-fArr[i31 - 1]) + fArr[i33 - 1];
        float f77 = fArr[i32 - 2] + fArr[i34 - 2];
        float f78 = fArr[i32 - 1] + fArr[i34 - 1];
        float f79 = fArr[i32 - 2] - fArr[i34 - 2];
        float f80 = fArr[i32 - 1] - fArr[i34 - 1];
        fArr[i31 - 2] = f73 + f77;
        fArr[i31 - 1] = f74 - f78;
        fArr[i32 - 2] = f73 - f77;
        fArr[i32 - 1] = f74 + f78;
        float f81 = f75 + f80;
        float f82 = f76 + f79;
        fArr[i33 - 2] = (f69 * f81) - (f70 * f82);
        fArr[i33 - 1] = (f81 * f70) + (f82 * f69);
        float f83 = f75 - f80;
        float f84 = f76 - f79;
        fArr[i34 - 2] = (f71 * f83) + (f72 * f84);
        fArr[i34 - 1] = (f84 * f71) - (f83 * f72);
        float f85 = fArr[i31] + fArr[i33];
        float f86 = (-fArr[i31 + 1]) - fArr[i33 + 1];
        float f87 = fArr[i31] - fArr[i33];
        float f88 = (-fArr[i31 + 1]) + fArr[i33 + 1];
        float f89 = fArr[i32] + fArr[i34];
        float f90 = fArr[i32 + 1] + fArr[i34 + 1];
        float f91 = fArr[i32] - fArr[i34];
        float f92 = fArr[i32 + 1] - fArr[i34 + 1];
        fArr[i31] = f85 + f89;
        fArr[i31 + 1] = f86 - f90;
        fArr[i32] = f85 - f89;
        fArr[i32 + 1] = f86 + f90;
        float f93 = f87 + f92;
        float f94 = f88 + f91;
        fArr[i33] = (f93 - f94) * f10;
        fArr[i33 + 1] = (f93 + f94) * f10;
        float f95 = f87 - f92;
        float f96 = f88 - f91;
        fArr[i34] = (-f10) * (f95 + f96);
        fArr[i34 + 1] = (-f10) * (f96 - f95);
        float f97 = fArr[i31 + 2] + fArr[i33 + 2];
        float f98 = (-fArr[i31 + 3]) - fArr[i33 + 3];
        float f99 = fArr[i31 + 2] - fArr[i33 + 2];
        float f100 = (-fArr[i31 + 3]) + fArr[i33 + 3];
        float f101 = fArr[i32 + 2] + fArr[i34 + 2];
        float f102 = fArr[i32 + 3] + fArr[i34 + 3];
        float f103 = fArr[i32 + 2] - fArr[i34 + 2];
        float f104 = fArr[i32 + 3] - fArr[i34 + 3];
        fArr[i31 + 2] = f97 + f101;
        fArr[i31 + 3] = f98 - f102;
        fArr[i32 + 2] = f97 - f101;
        fArr[i32 + 3] = f98 + f102;
        float f105 = f99 + f104;
        float f106 = f100 + f103;
        fArr[i33 + 2] = (f70 * f105) - (f69 * f106);
        fArr[i33 + 3] = (f69 * f105) + (f70 * f106);
        float f107 = f99 - f104;
        float f108 = f100 - f103;
        fArr[i34 + 2] = (f72 * f107) + (f71 * f108);
        fArr[i34 + 3] = (f72 * f108) - (f107 * f71);
    }

    private void b(int i, float[] fArr, int i2, int[] iArr, int i3, float[] fArr2) {
        if (i <= 8) {
            if (i == 8) {
                g(fArr, i2);
                return;
            } else {
                if (i == 4) {
                    h(fArr, i2);
                    return;
                }
                return;
            }
        }
        if (i <= 32) {
            if (i == 32) {
                a(fArr, i2, fArr2, i3 - 8);
                c(fArr, i2);
                return;
            } else {
                c(fArr, i2, fArr2, 0);
                e(fArr, i2);
                return;
            }
        }
        b(i, fArr, i2, fArr2, i3 - (i >> 2));
        if (a.a.a.c.a.b() > 1 && i > a.a.a.c.a.c()) {
            a(i, fArr, i2, i3, fArr2);
        } else if (i > 512) {
            b(i, fArr, i2, i3, fArr2);
        } else if (i > 128) {
            a(i, 1, fArr, i2, i3, fArr2);
        } else {
            c(i, fArr, i2, i3, fArr2);
        }
        b(i, iArr, fArr, i2);
    }

    private void b(int i, int[] iArr, float[] fArr, int i2) {
        int i3;
        int i4 = 1;
        int i5 = i >> 2;
        while (true) {
            i3 = i4;
            if (i5 <= 8) {
                break;
            }
            i4 = i3 << 1;
            i5 >>= 2;
        }
        int i6 = i >> 1;
        int i7 = i3 * 4;
        if (i5 != 8) {
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = i8 * 4;
                for (int i10 = 0; i10 < i8; i10++) {
                    int i11 = (i10 * 4) + iArr[i3 + i8];
                    int i12 = iArr[i3 + i10] + i9;
                    int i13 = i2 + i11;
                    int i14 = i2 + i12;
                    float f2 = fArr[i13];
                    float f3 = -fArr[i13 + 1];
                    float f4 = fArr[i14];
                    float f5 = -fArr[i14 + 1];
                    fArr[i13] = f4;
                    fArr[i13 + 1] = f5;
                    fArr[i14] = f2;
                    fArr[i14 + 1] = f3;
                    int i15 = i11 + i7;
                    int i16 = i12 + i7;
                    int i17 = i2 + i15;
                    int i18 = i2 + i16;
                    float f6 = fArr[i17];
                    float f7 = -fArr[i17 + 1];
                    float f8 = fArr[i18];
                    float f9 = -fArr[i18 + 1];
                    fArr[i17] = f8;
                    fArr[i17 + 1] = f9;
                    fArr[i18] = f6;
                    fArr[i18 + 1] = f7;
                    int i19 = i15 + i6;
                    int i20 = i16 + 2;
                    int i21 = i2 + i19;
                    int i22 = i2 + i20;
                    float f10 = fArr[i21];
                    float f11 = -fArr[i21 + 1];
                    float f12 = fArr[i22];
                    float f13 = -fArr[i22 + 1];
                    fArr[i21] = f12;
                    fArr[i21 + 1] = f13;
                    fArr[i22] = f10;
                    fArr[i22 + 1] = f11;
                    int i23 = i19 - i7;
                    int i24 = i20 - i7;
                    int i25 = i2 + i23;
                    int i26 = i2 + i24;
                    float f14 = fArr[i25];
                    float f15 = -fArr[i25 + 1];
                    float f16 = fArr[i26];
                    float f17 = -fArr[i26 + 1];
                    fArr[i25] = f16;
                    fArr[i25 + 1] = f17;
                    fArr[i26] = f14;
                    fArr[i26 + 1] = f15;
                    int i27 = i23 + 2;
                    int i28 = i24 + i6;
                    int i29 = i2 + i27;
                    int i30 = i2 + i28;
                    float f18 = fArr[i29];
                    float f19 = -fArr[i29 + 1];
                    float f20 = fArr[i30];
                    float f21 = -fArr[i30 + 1];
                    fArr[i29] = f20;
                    fArr[i29 + 1] = f21;
                    fArr[i30] = f18;
                    fArr[i30 + 1] = f19;
                    int i31 = i27 + i7;
                    int i32 = i28 + i7;
                    int i33 = i2 + i31;
                    int i34 = i2 + i32;
                    float f22 = fArr[i33];
                    float f23 = -fArr[i33 + 1];
                    float f24 = fArr[i34];
                    float f25 = -fArr[i34 + 1];
                    fArr[i33] = f24;
                    fArr[i33 + 1] = f25;
                    fArr[i34] = f22;
                    fArr[i34 + 1] = f23;
                    int i35 = i31 - i6;
                    int i36 = i32 - 2;
                    int i37 = i2 + i35;
                    int i38 = i2 + i36;
                    float f26 = fArr[i37];
                    float f27 = -fArr[i37 + 1];
                    float f28 = fArr[i38];
                    float f29 = -fArr[i38 + 1];
                    fArr[i37] = f28;
                    fArr[i37 + 1] = f29;
                    fArr[i38] = f26;
                    fArr[i38 + 1] = f27;
                    int i39 = (i35 - i7) + i2;
                    int i40 = (i36 - i7) + i2;
                    float f30 = fArr[i39];
                    float f31 = -fArr[i39 + 1];
                    float f32 = fArr[i40];
                    float f33 = -fArr[i40 + 1];
                    fArr[i39] = f32;
                    fArr[i39 + 1] = f33;
                    fArr[i40] = f30;
                    fArr[i40 + 1] = f31;
                }
                int i41 = iArr[i3 + i8] + i9;
                int i42 = i41 + 2;
                int i43 = i41 + i6;
                int i44 = i2 + i42;
                int i45 = i2 + i43;
                fArr[i44 - 1] = -fArr[i44 - 1];
                float f34 = fArr[i44];
                float f35 = -fArr[i44 + 1];
                float f36 = fArr[i45];
                float f37 = -fArr[i45 + 1];
                fArr[i44] = f36;
                fArr[i44 + 1] = f37;
                fArr[i45] = f34;
                fArr[i45 + 1] = f35;
                fArr[i45 + 3] = -fArr[i45 + 3];
                int i46 = i42 + i7 + i2;
                int i47 = i43 + i7 + i2;
                fArr[i46 - 1] = -fArr[i46 - 1];
                float f38 = fArr[i46];
                float f39 = -fArr[i46 + 1];
                float f40 = fArr[i47];
                float f41 = -fArr[i47 + 1];
                fArr[i46] = f40;
                fArr[i46 + 1] = f41;
                fArr[i47] = f38;
                fArr[i47 + 1] = f39;
                fArr[i47 + 3] = -fArr[i47 + 3];
            }
            return;
        }
        for (int i48 = 0; i48 < i3; i48++) {
            int i49 = i48 * 4;
            for (int i50 = 0; i50 < i48; i50++) {
                int i51 = (i50 * 4) + (iArr[i3 + i48] * 2);
                int i52 = (iArr[i3 + i50] * 2) + i49;
                int i53 = i2 + i51;
                int i54 = i2 + i52;
                float f42 = fArr[i53];
                float f43 = -fArr[i53 + 1];
                float f44 = fArr[i54];
                float f45 = -fArr[i54 + 1];
                fArr[i53] = f44;
                fArr[i53 + 1] = f45;
                fArr[i54] = f42;
                fArr[i54 + 1] = f43;
                int i55 = i51 + i7;
                int i56 = i52 + (i7 * 2);
                int i57 = i2 + i55;
                int i58 = i2 + i56;
                float f46 = fArr[i57];
                float f47 = -fArr[i57 + 1];
                float f48 = fArr[i58];
                float f49 = -fArr[i58 + 1];
                fArr[i57] = f48;
                fArr[i57 + 1] = f49;
                fArr[i58] = f46;
                fArr[i58 + 1] = f47;
                int i59 = i55 + i7;
                int i60 = i56 - i7;
                int i61 = i2 + i59;
                int i62 = i2 + i60;
                float f50 = fArr[i61];
                float f51 = -fArr[i61 + 1];
                float f52 = fArr[i62];
                float f53 = -fArr[i62 + 1];
                fArr[i61] = f52;
                fArr[i61 + 1] = f53;
                fArr[i62] = f50;
                fArr[i62 + 1] = f51;
                int i63 = i59 + i7;
                int i64 = i60 + (i7 * 2);
                int i65 = i2 + i63;
                int i66 = i2 + i64;
                float f54 = fArr[i65];
                float f55 = -fArr[i65 + 1];
                float f56 = fArr[i66];
                float f57 = -fArr[i66 + 1];
                fArr[i65] = f56;
                fArr[i65 + 1] = f57;
                fArr[i66] = f54;
                fArr[i66 + 1] = f55;
                int i67 = i63 + i6;
                int i68 = i64 + 2;
                int i69 = i2 + i67;
                int i70 = i2 + i68;
                float f58 = fArr[i69];
                float f59 = -fArr[i69 + 1];
                float f60 = fArr[i70];
                float f61 = -fArr[i70 + 1];
                fArr[i69] = f60;
                fArr[i69 + 1] = f61;
                fArr[i70] = f58;
                fArr[i70 + 1] = f59;
                int i71 = i67 - i7;
                int i72 = i68 - (i7 * 2);
                int i73 = i2 + i71;
                int i74 = i2 + i72;
                float f62 = fArr[i73];
                float f63 = -fArr[i73 + 1];
                float f64 = fArr[i74];
                float f65 = -fArr[i74 + 1];
                fArr[i73] = f64;
                fArr[i73 + 1] = f65;
                fArr[i74] = f62;
                fArr[i74 + 1] = f63;
                int i75 = i71 - i7;
                int i76 = i72 + i7;
                int i77 = i2 + i75;
                int i78 = i2 + i76;
                float f66 = fArr[i77];
                float f67 = -fArr[i77 + 1];
                float f68 = fArr[i78];
                float f69 = -fArr[i78 + 1];
                fArr[i77] = f68;
                fArr[i77 + 1] = f69;
                fArr[i78] = f66;
                fArr[i78 + 1] = f67;
                int i79 = i75 - i7;
                int i80 = i76 - (i7 * 2);
                int i81 = i2 + i79;
                int i82 = i2 + i80;
                float f70 = fArr[i81];
                float f71 = -fArr[i81 + 1];
                float f72 = fArr[i82];
                float f73 = -fArr[i82 + 1];
                fArr[i81] = f72;
                fArr[i81 + 1] = f73;
                fArr[i82] = f70;
                fArr[i82 + 1] = f71;
                int i83 = i79 + 2;
                int i84 = i80 + i6;
                int i85 = i2 + i83;
                int i86 = i2 + i84;
                float f74 = fArr[i85];
                float f75 = -fArr[i85 + 1];
                float f76 = fArr[i86];
                float f77 = -fArr[i86 + 1];
                fArr[i85] = f76;
                fArr[i85 + 1] = f77;
                fArr[i86] = f74;
                fArr[i86 + 1] = f75;
                int i87 = i83 + i7;
                int i88 = i84 + (i7 * 2);
                int i89 = i2 + i87;
                int i90 = i2 + i88;
                float f78 = fArr[i89];
                float f79 = -fArr[i89 + 1];
                float f80 = fArr[i90];
                float f81 = -fArr[i90 + 1];
                fArr[i89] = f80;
                fArr[i89 + 1] = f81;
                fArr[i90] = f78;
                fArr[i90 + 1] = f79;
                int i91 = i87 + i7;
                int i92 = i88 - i7;
                int i93 = i2 + i91;
                int i94 = i2 + i92;
                float f82 = fArr[i93];
                float f83 = -fArr[i93 + 1];
                float f84 = fArr[i94];
                float f85 = -fArr[i94 + 1];
                fArr[i93] = f84;
                fArr[i93 + 1] = f85;
                fArr[i94] = f82;
                fArr[i94 + 1] = f83;
                int i95 = i91 + i7;
                int i96 = i92 + (i7 * 2);
                int i97 = i2 + i95;
                int i98 = i2 + i96;
                float f86 = fArr[i97];
                float f87 = -fArr[i97 + 1];
                float f88 = fArr[i98];
                float f89 = -fArr[i98 + 1];
                fArr[i97] = f88;
                fArr[i97 + 1] = f89;
                fArr[i98] = f86;
                fArr[i98 + 1] = f87;
                int i99 = i95 - i6;
                int i100 = i96 - 2;
                int i101 = i2 + i99;
                int i102 = i2 + i100;
                float f90 = fArr[i101];
                float f91 = -fArr[i101 + 1];
                float f92 = fArr[i102];
                float f93 = -fArr[i102 + 1];
                fArr[i101] = f92;
                fArr[i101 + 1] = f93;
                fArr[i102] = f90;
                fArr[i102 + 1] = f91;
                int i103 = i99 - i7;
                int i104 = i100 - (i7 * 2);
                int i105 = i2 + i103;
                int i106 = i2 + i104;
                float f94 = fArr[i105];
                float f95 = -fArr[i105 + 1];
                float f96 = fArr[i106];
                float f97 = -fArr[i106 + 1];
                fArr[i105] = f96;
                fArr[i105 + 1] = f97;
                fArr[i106] = f94;
                fArr[i106 + 1] = f95;
                int i107 = i103 - i7;
                int i108 = i104 + i7;
                int i109 = i2 + i107;
                int i110 = i2 + i108;
                float f98 = fArr[i109];
                float f99 = -fArr[i109 + 1];
                float f100 = fArr[i110];
                float f101 = -fArr[i110 + 1];
                fArr[i109] = f100;
                fArr[i109 + 1] = f101;
                fArr[i110] = f98;
                fArr[i110 + 1] = f99;
                int i111 = (i107 - i7) + i2;
                int i112 = (i108 - (i7 * 2)) + i2;
                float f102 = fArr[i111];
                float f103 = -fArr[i111 + 1];
                float f104 = fArr[i112];
                float f105 = -fArr[i112 + 1];
                fArr[i111] = f104;
                fArr[i111 + 1] = f105;
                fArr[i112] = f102;
                fArr[i112 + 1] = f103;
            }
            int i113 = (iArr[i3 + i48] * 2) + i49;
            int i114 = i113 + 2;
            int i115 = i113 + i6;
            int i116 = i2 + i114;
            int i117 = i2 + i115;
            fArr[i116 - 1] = -fArr[i116 - 1];
            float f106 = fArr[i116];
            float f107 = -fArr[i116 + 1];
            float f108 = fArr[i117];
            float f109 = -fArr[i117 + 1];
            fArr[i116] = f108;
            fArr[i116 + 1] = f109;
            fArr[i117] = f106;
            fArr[i117 + 1] = f107;
            fArr[i117 + 3] = -fArr[i117 + 3];
            int i118 = i114 + i7;
            int i119 = i115 + (i7 * 2);
            int i120 = i2 + i118;
            int i121 = i2 + i119;
            float f110 = fArr[i120];
            float f111 = -fArr[i120 + 1];
            float f112 = fArr[i121];
            float f113 = -fArr[i121 + 1];
            fArr[i120] = f112;
            fArr[i120 + 1] = f113;
            fArr[i121] = f110;
            fArr[i121 + 1] = f111;
            int i122 = i118 + i7;
            int i123 = i119 - i7;
            int i124 = i2 + i122;
            int i125 = i2 + i123;
            float f114 = fArr[i124];
            float f115 = -fArr[i124 + 1];
            float f116 = fArr[i125];
            float f117 = -fArr[i125 + 1];
            fArr[i124] = f116;
            fArr[i124 + 1] = f117;
            fArr[i125] = f114;
            fArr[i125 + 1] = f115;
            int i126 = i122 - 2;
            int i127 = i123 - i6;
            int i128 = i2 + i126;
            int i129 = i2 + i127;
            float f118 = fArr[i128];
            float f119 = -fArr[i128 + 1];
            float f120 = fArr[i129];
            float f121 = -fArr[i129 + 1];
            fArr[i128] = f120;
            fArr[i128 + 1] = f121;
            fArr[i129] = f118;
            fArr[i129 + 1] = f119;
            int i130 = i126 + i6 + 2;
            int i131 = i127 + i6 + 2;
            int i132 = i2 + i130;
            int i133 = i2 + i131;
            float f122 = fArr[i132];
            float f123 = -fArr[i132 + 1];
            float f124 = fArr[i133];
            float f125 = -fArr[i133 + 1];
            fArr[i132] = f124;
            fArr[i132 + 1] = f125;
            fArr[i133] = f122;
            fArr[i133 + 1] = f123;
            int i134 = (i130 - (i6 - i7)) + i2;
            int i135 = i131 + ((i7 * 2) - 2) + i2;
            fArr[i134 - 1] = -fArr[i134 - 1];
            float f126 = fArr[i134];
            float f127 = -fArr[i134 + 1];
            float f128 = fArr[i135];
            float f129 = -fArr[i135 + 1];
            fArr[i134] = f128;
            fArr[i134 + 1] = f129;
            fArr[i135] = f126;
            fArr[i135 + 1] = f127;
            fArr[i135 + 3] = -fArr[i135 + 3];
        }
    }

    private void b(float[] fArr, int i) {
        float f2 = fArr[i + 2];
        float f3 = fArr[i + 3];
        float f4 = fArr[i + 4];
        float f5 = fArr[i + 5];
        float f6 = fArr[i + 6];
        float f7 = fArr[i + 7];
        float f8 = fArr[i + 8];
        float f9 = fArr[i + 9];
        float f10 = fArr[i + 10];
        float f11 = fArr[i + 11];
        float f12 = fArr[i + 14];
        float f13 = fArr[i + 15];
        float f14 = fArr[i + 16];
        float f15 = fArr[i + 17];
        float f16 = fArr[i + 20];
        float f17 = fArr[i + 21];
        float f18 = fArr[i + 22];
        float f19 = fArr[i + 23];
        float f20 = fArr[i + 24];
        float f21 = fArr[i + 25];
        float f22 = fArr[i + 26];
        float f23 = fArr[i + 27];
        float f24 = fArr[i + 28];
        float f25 = fArr[i + 29];
        fArr[i + 2] = f14;
        fArr[i + 3] = f15;
        fArr[i + 4] = f8;
        fArr[i + 5] = f9;
        fArr[i + 6] = f20;
        fArr[i + 7] = f21;
        fArr[i + 8] = f4;
        fArr[i + 9] = f5;
        fArr[i + 10] = f16;
        fArr[i + 11] = f17;
        fArr[i + 14] = f24;
        fArr[i + 15] = f25;
        fArr[i + 16] = f2;
        fArr[i + 17] = f3;
        fArr[i + 20] = f10;
        fArr[i + 21] = f11;
        fArr[i + 22] = f22;
        fArr[i + 23] = f23;
        fArr[i + 24] = f6;
        fArr[i + 25] = f7;
        fArr[i + 26] = f18;
        fArr[i + 27] = f19;
        fArr[i + 28] = f12;
        fArr[i + 29] = f13;
    }

    private void b(final float[] fArr, final int i, final int i2) {
        final float[] fArr2 = new float[this.f94b * 2];
        if (a.a.a.c.a.b() > 1 && this.f93a > a.a.a.c.a.c()) {
            Future[] futureArr = new Future[2];
            int i3 = this.f93a / 2;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 2) {
                    break;
                }
                final int i6 = i5 * i3;
                final int i7 = i5 == 1 ? this.f93a : i6 + i3;
                futureArr[i5] = a.a.a.c.a.a(new Runnable() { // from class: a.a.a.c.a.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i2 > 0) {
                            for (int i8 = i6; i8 < i7; i8++) {
                                int i9 = i8 * 2;
                                int i10 = i9 + 1;
                                int i11 = i + i9;
                                int i12 = i + i10;
                                fArr2[i9] = (fArr[i11] * a.this.i[i9]) - (fArr[i12] * a.this.i[i10]);
                                fArr2[i10] = (a.this.i[i9] * fArr[i12]) + (fArr[i11] * a.this.i[i10]);
                            }
                            return;
                        }
                        for (int i13 = i6; i13 < i7; i13++) {
                            int i14 = i13 * 2;
                            int i15 = i14 + 1;
                            int i16 = i + i14;
                            int i17 = i + i15;
                            fArr2[i14] = (fArr[i16] * a.this.i[i14]) + (fArr[i17] * a.this.i[i15]);
                            fArr2[i15] = (a.this.i[i14] * fArr[i17]) + ((-fArr[i16]) * a.this.i[i15]);
                        }
                    }
                });
                i4 = i5 + 1;
            }
            a.a.a.c.a.a((Future<?>[]) futureArr);
            b(this.f94b * 2, fArr2, 0, this.f95c, this.f97e, this.f96d);
            int i8 = this.f94b / 2;
            int i9 = 0;
            while (i9 < 2) {
                final int i10 = i9 * i8;
                final int i11 = i9 == 1 ? this.f94b : i10 + i8;
                futureArr[i9] = a.a.a.c.a.a(new Runnable() { // from class: a.a.a.c.a.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i2 > 0) {
                            for (int i12 = i10; i12 < i11; i12++) {
                                int i13 = i12 * 2;
                                int i14 = i13 + 1;
                                float f2 = ((-fArr2[i13]) * a.this.j[i14]) + (fArr2[i14] * a.this.j[i13]);
                                fArr2[i13] = (fArr2[i13] * a.this.j[i13]) + (fArr2[i14] * a.this.j[i14]);
                                fArr2[i14] = f2;
                            }
                            return;
                        }
                        for (int i15 = i10; i15 < i11; i15++) {
                            int i16 = i15 * 2;
                            int i17 = i16 + 1;
                            float f3 = (fArr2[i16] * a.this.j[i17]) + (fArr2[i17] * a.this.j[i16]);
                            fArr2[i16] = (fArr2[i16] * a.this.j[i16]) - (fArr2[i17] * a.this.j[i17]);
                            fArr2[i17] = f3;
                        }
                    }
                });
                i9++;
            }
            a.a.a.c.a.a((Future<?>[]) futureArr);
            a(this.f94b * 2, fArr2, 0, this.f95c, this.f97e, this.f96d);
            int i12 = this.f93a / 2;
            int i13 = 0;
            while (i13 < 2) {
                final int i14 = i13 * i12;
                final int i15 = i13 == 1 ? this.f93a : i14 + i12;
                futureArr[i13] = a.a.a.c.a.a(new Runnable() { // from class: a.a.a.c.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i2 > 0) {
                            for (int i16 = i14; i16 < i15; i16++) {
                                int i17 = i16 * 2;
                                int i18 = i17 + 1;
                                int i19 = i + i17;
                                int i20 = i + i18;
                                fArr[i19] = (a.this.i[i17] * fArr2[i17]) - (a.this.i[i18] * fArr2[i18]);
                                fArr[i20] = (a.this.i[i17] * fArr2[i18]) + (a.this.i[i18] * fArr2[i17]);
                            }
                            return;
                        }
                        for (int i21 = i14; i21 < i15; i21++) {
                            int i22 = i21 * 2;
                            int i23 = i22 + 1;
                            int i24 = i + i22;
                            int i25 = i + i23;
                            fArr[i24] = (a.this.i[i22] * fArr2[i22]) + (a.this.i[i23] * fArr2[i23]);
                            fArr[i25] = (a.this.i[i22] * fArr2[i23]) + ((-a.this.i[i23]) * fArr2[i22]);
                        }
                    }
                });
                i13++;
            }
            a.a.a.c.a.a((Future<?>[]) futureArr);
            return;
        }
        if (i2 > 0) {
            for (int i16 = 0; i16 < this.f93a; i16++) {
                int i17 = i16 * 2;
                int i18 = i17 + 1;
                int i19 = i + i17;
                int i20 = i + i18;
                fArr2[i17] = (fArr[i19] * this.i[i17]) - (fArr[i20] * this.i[i18]);
                fArr2[i18] = (this.i[i17] * fArr[i20]) + (fArr[i19] * this.i[i18]);
            }
        } else {
            for (int i21 = 0; i21 < this.f93a; i21++) {
                int i22 = i21 * 2;
                int i23 = i22 + 1;
                int i24 = i + i22;
                int i25 = i + i23;
                fArr2[i22] = (fArr[i24] * this.i[i22]) + (fArr[i25] * this.i[i23]);
                fArr2[i23] = (this.i[i22] * fArr[i25]) + ((-fArr[i24]) * this.i[i23]);
            }
        }
        b(this.f94b * 2, fArr2, 0, this.f95c, this.f97e, this.f96d);
        if (i2 > 0) {
            for (int i26 = 0; i26 < this.f94b; i26++) {
                int i27 = i26 * 2;
                int i28 = i27 + 1;
                float f2 = ((-fArr2[i27]) * this.j[i28]) + (fArr2[i28] * this.j[i27]);
                fArr2[i27] = (fArr2[i27] * this.j[i27]) + (fArr2[i28] * this.j[i28]);
                fArr2[i28] = f2;
            }
        } else {
            for (int i29 = 0; i29 < this.f94b; i29++) {
                int i30 = i29 * 2;
                int i31 = i30 + 1;
                float f3 = (fArr2[i30] * this.j[i31]) + (fArr2[i31] * this.j[i30]);
                fArr2[i30] = (fArr2[i30] * this.j[i30]) - (fArr2[i31] * this.j[i31]);
                fArr2[i31] = f3;
            }
        }
        a(this.f94b * 2, fArr2, 0, this.f95c, this.f97e, this.f96d);
        if (i2 > 0) {
            for (int i32 = 0; i32 < this.f93a; i32++) {
                int i33 = i32 * 2;
                int i34 = i33 + 1;
                fArr[i + i33] = (this.i[i33] * fArr2[i33]) - (this.i[i34] * fArr2[i34]);
                fArr[i + i34] = (this.i[i33] * fArr2[i34]) + (this.i[i34] * fArr2[i33]);
            }
            return;
        }
        for (int i35 = 0; i35 < this.f93a; i35++) {
            int i36 = i35 * 2;
            int i37 = i36 + 1;
            fArr[i + i36] = (this.i[i36] * fArr2[i36]) + (this.i[i37] * fArr2[i37]);
            fArr[i + i37] = (this.i[i36] * fArr2[i37]) + ((-this.i[i37]) * fArr2[i36]);
        }
    }

    private void b(float[] fArr, int i, float[] fArr2, int i2) {
        float f2 = fArr2[i2 + 1];
        float f3 = fArr2[i2 + 4];
        float f4 = fArr2[i2 + 5];
        float f5 = fArr2[i2 + 6];
        float f6 = -fArr2[i2 + 7];
        float f7 = fArr2[i2 + 8];
        float f8 = fArr2[i2 + 9];
        float f9 = fArr[i] - fArr[i + 17];
        float f10 = fArr[i + 1] + fArr[i + 16];
        float f11 = fArr[i + 8] - fArr[i + 25];
        float f12 = fArr[i + 9] + fArr[i + 24];
        float f13 = (f11 - f12) * f2;
        float f14 = (f11 + f12) * f2;
        float f15 = f9 + f13;
        float f16 = f10 + f14;
        float f17 = f9 - f13;
        float f18 = f10 - f14;
        float f19 = fArr[i] + fArr[i + 17];
        float f20 = fArr[i + 1] - fArr[i + 16];
        float f21 = fArr[i + 8] + fArr[i + 25];
        float f22 = fArr[i + 9] - fArr[i + 24];
        float f23 = (f21 - f22) * f2;
        float f24 = (f21 + f22) * f2;
        float f25 = f19 - f24;
        float f26 = f20 + f23;
        float f27 = f19 + f24;
        float f28 = f20 - f23;
        float f29 = fArr[i + 2] - fArr[i + 19];
        float f30 = fArr[i + 3] + fArr[i + 18];
        float f31 = (f3 * f29) - (f4 * f30);
        float f32 = (f29 * f4) + (f30 * f3);
        float f33 = fArr[i + 10] - fArr[i + 27];
        float f34 = fArr[i + 11] + fArr[i + 26];
        float f35 = (f6 * f33) - (f5 * f34);
        float f36 = (f33 * f5) + (f34 * f6);
        float f37 = f31 + f35;
        float f38 = f32 + f36;
        float f39 = f31 - f35;
        float f40 = f32 - f36;
        float f41 = fArr[i + 2] + fArr[i + 19];
        float f42 = fArr[i + 3] - fArr[i + 18];
        float f43 = (f5 * f41) - (f6 * f42);
        float f44 = (f41 * f6) + (f42 * f5);
        float f45 = fArr[i + 10] + fArr[i + 27];
        float f46 = fArr[i + 11] - fArr[i + 26];
        float f47 = (f3 * f45) + (f4 * f46);
        float f48 = (f46 * f3) - (f45 * f4);
        float f49 = f43 - f47;
        float f50 = f44 - f48;
        float f51 = f43 + f47;
        float f52 = f44 + f48;
        float f53 = fArr[i + 4] - fArr[i + 21];
        float f54 = fArr[i + 5] + fArr[i + 20];
        float f55 = (f7 * f53) - (f8 * f54);
        float f56 = (f53 * f8) + (f54 * f7);
        float f57 = fArr[i + 12] - fArr[i + 29];
        float f58 = fArr[i + 13] + fArr[i + 28];
        float f59 = (f8 * f57) - (f7 * f58);
        float f60 = (f57 * f7) + (f58 * f8);
        float f61 = f55 + f59;
        float f62 = f56 + f60;
        float f63 = f55 - f59;
        float f64 = f56 - f60;
        float f65 = fArr[i + 4] + fArr[i + 21];
        float f66 = fArr[i + 5] - fArr[i + 20];
        float f67 = (f8 * f65) - (f7 * f66);
        float f68 = (f65 * f7) + (f66 * f8);
        float f69 = fArr[i + 12] + fArr[i + 29];
        float f70 = fArr[i + 13] - fArr[i + 28];
        float f71 = (f7 * f69) - (f8 * f70);
        float f72 = (f7 * f70) + (f8 * f69);
        float f73 = f67 - f71;
        float f74 = f68 - f72;
        float f75 = f67 + f71;
        float f76 = f72 + f68;
        float f77 = fArr[i + 6] - fArr[i + 23];
        float f78 = fArr[i + 7] + fArr[i + 22];
        float f79 = (f5 * f77) - (f6 * f78);
        float f80 = (f77 * f6) + (f78 * f5);
        float f81 = fArr[i + 14] - fArr[i + 31];
        float f82 = fArr[i + 15] + fArr[i + 30];
        float f83 = (f4 * f81) - (f3 * f82);
        float f84 = (f81 * f3) + (f82 * f4);
        float f85 = f79 + f83;
        float f86 = f80 + f84;
        float f87 = f79 - f83;
        float f88 = f80 - f84;
        float f89 = fArr[i + 6] + fArr[i + 23];
        float f90 = fArr[i + 7] - fArr[i + 22];
        float f91 = (f4 * f89) + (f3 * f90);
        float f92 = (f4 * f90) - (f3 * f89);
        float f93 = fArr[i + 14] + fArr[i + 31];
        float f94 = fArr[i + 15] - fArr[i + 30];
        float f95 = (f6 * f93) - (f5 * f94);
        float f96 = (f93 * f5) + (f6 * f94);
        float f97 = f91 + f95;
        float f98 = f92 + f96;
        float f99 = f91 - f95;
        float f100 = f92 - f96;
        float f101 = f15 + f61;
        float f102 = f16 + f62;
        float f103 = f37 + f85;
        float f104 = f38 + f86;
        fArr[i] = f101 + f103;
        fArr[i + 1] = f102 + f104;
        fArr[i + 2] = f101 - f103;
        fArr[i + 3] = f102 - f104;
        float f105 = f15 - f61;
        float f106 = f16 - f62;
        float f107 = f37 - f85;
        float f108 = f38 - f86;
        fArr[i + 4] = f105 - f108;
        fArr[i + 5] = f106 + f107;
        fArr[i + 6] = f105 + f108;
        fArr[i + 7] = f106 - f107;
        float f109 = f17 - f64;
        float f110 = f18 + f63;
        float f111 = f39 - f88;
        float f112 = f40 + f87;
        float f113 = (f111 - f112) * f2;
        float f114 = (f111 + f112) * f2;
        fArr[i + 8] = f109 + f113;
        fArr[i + 9] = f110 + f114;
        fArr[i + 10] = f109 - f113;
        fArr[i + 11] = f110 - f114;
        float f115 = f17 + f64;
        float f116 = f18 - f63;
        float f117 = f39 + f88;
        float f118 = f40 - f87;
        float f119 = (f117 - f118) * f2;
        float f120 = (f117 + f118) * f2;
        fArr[i + 12] = f115 - f120;
        fArr[i + 13] = f116 + f119;
        fArr[i + 14] = f115 + f120;
        fArr[i + 15] = f116 - f119;
        float f121 = f25 + f73;
        float f122 = f26 + f74;
        float f123 = f49 - f97;
        float f124 = f50 - f98;
        fArr[i + 16] = f121 + f123;
        fArr[i + 17] = f122 + f124;
        fArr[i + 18] = f121 - f123;
        fArr[i + 19] = f122 - f124;
        float f125 = f25 - f73;
        float f126 = f26 - f74;
        float f127 = f97 + f49;
        float f128 = f98 + f50;
        fArr[i + 20] = f125 - f128;
        fArr[i + 21] = f126 + f127;
        fArr[i + 22] = f125 + f128;
        fArr[i + 23] = f126 - f127;
        float f129 = f27 - f76;
        float f130 = f28 + f75;
        float f131 = f51 + f100;
        float f132 = f52 - f99;
        float f133 = (f131 - f132) * f2;
        float f134 = (f131 + f132) * f2;
        fArr[i + 24] = f129 + f133;
        fArr[i + 25] = f130 + f134;
        fArr[i + 26] = f129 - f133;
        fArr[i + 27] = f130 - f134;
        float f135 = f27 + f76;
        float f136 = f28 - f75;
        float f137 = f51 - f100;
        float f138 = f52 + f99;
        float f139 = (f137 - f138) * f2;
        float f140 = f2 * (f137 + f138);
        fArr[i + 28] = f135 - f140;
        fArr[i + 29] = f136 + f139;
        fArr[i + 30] = f140 + f135;
        fArr[i + 31] = f136 - f139;
    }

    private void c() {
        float f2 = 3.1415927f / this.f93a;
        this.i[0] = 1.0f;
        this.i[1] = 0.0f;
        int i = 0;
        for (int i2 = 1; i2 < this.f93a; i2++) {
            i += (i2 * 2) - 1;
            if (i >= this.f93a * 2) {
                i -= this.f93a * 2;
            }
            float f3 = i * f2;
            this.i[i2 * 2] = (float) Math.cos(f3);
            this.i[(i2 * 2) + 1] = (float) Math.sin(f3);
        }
        float f4 = (float) (1.0d / ((double) this.f94b));
        this.j[0] = this.i[0] * f4;
        this.j[1] = this.i[1] * f4;
        for (int i3 = 2; i3 < this.f93a * 2; i3 += 2) {
            this.j[i3] = this.i[i3] * f4;
            this.j[i3 + 1] = this.i[i3 + 1] * f4;
            this.j[(this.f94b * 2) - i3] = this.j[i3];
            this.j[((this.f94b * 2) - i3) + 1] = this.j[i3 + 1];
        }
        b(this.f94b * 2, this.j, 0, this.f95c, this.f97e, this.f96d);
    }

    private void c(int i, float[] fArr, int i2, int i3, float[] fArr2) {
        if (i == 128) {
            a(fArr, i2, fArr2, i3 - 8);
            b(fArr, i2 + 32, fArr2, i3 - 32);
            a(fArr, i2 + 64, fArr2, i3 - 8);
            a(fArr, i2 + 96, fArr2, i3 - 8);
            return;
        }
        c(fArr, i2, fArr2, i3 - 8);
        d(fArr, i2 + 16, fArr2, i3 - 8);
        c(fArr, i2 + 32, fArr2, i3 - 8);
        c(fArr, i2 + 48, fArr2, i3 - 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, float[] fArr, int i2, float[] fArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = i2 + i5;
        int i9 = i6 + i2;
        int i10 = i7 + i2;
        float f2 = fArr[i2] + fArr[i9];
        float f3 = fArr[i2 + 1] + fArr[i9 + 1];
        float f4 = fArr[i2] - fArr[i9];
        float f5 = fArr[i2 + 1] - fArr[i9 + 1];
        float f6 = fArr[i8] + fArr[i10];
        float f7 = fArr[i8 + 1] + fArr[i10 + 1];
        float f8 = fArr[i8] - fArr[i10];
        float f9 = fArr[i8 + 1] - fArr[i10 + 1];
        fArr[i2] = f2 + f6;
        fArr[i2 + 1] = f3 + f7;
        fArr[i8] = f2 - f6;
        fArr[i8 + 1] = f3 - f7;
        fArr[i9] = f4 - f9;
        fArr[i9 + 1] = f5 + f8;
        fArr[i10] = f4 + f9;
        fArr[i10 + 1] = f5 - f8;
        float f10 = fArr2[i3 + 1];
        int i11 = 0;
        for (int i12 = 2; i12 < i4; i12 += 2) {
            i11 += 4;
            int i13 = i3 + i11;
            float f11 = fArr2[i13];
            float f12 = fArr2[i13 + 1];
            float f13 = fArr2[i13 + 2];
            float f14 = fArr2[i13 + 3];
            int i14 = i12 + i5;
            int i15 = i14 + i5;
            int i16 = i15 + i5;
            int i17 = i14 + i2;
            int i18 = i15 + i2;
            int i19 = i16 + i2;
            int i20 = i2 + i12;
            float f15 = fArr[i20] + fArr[i18];
            float f16 = fArr[i20 + 1] + fArr[i18 + 1];
            float f17 = fArr[i20] - fArr[i18];
            float f18 = fArr[i20 + 1] - fArr[i18 + 1];
            float f19 = fArr[i17] + fArr[i19];
            float f20 = fArr[i17 + 1] + fArr[i19 + 1];
            float f21 = fArr[i17] - fArr[i19];
            float f22 = fArr[i17 + 1] - fArr[i19 + 1];
            fArr[i20] = f15 + f19;
            fArr[i20 + 1] = f16 + f20;
            fArr[i17] = f15 - f19;
            fArr[i17 + 1] = f16 - f20;
            float f23 = f17 - f22;
            float f24 = f18 + f21;
            fArr[i18] = (f11 * f23) - (f12 * f24);
            fArr[i18 + 1] = (f23 * f12) + (f24 * f11);
            float f25 = f17 + f22;
            float f26 = f18 - f21;
            fArr[i19] = (f13 * f25) + (f14 * f26);
            fArr[i19 + 1] = (f26 * f13) - (f25 * f14);
            int i21 = i5 - i12;
            int i22 = i21 + i5;
            int i23 = i22 + i5;
            int i24 = i23 + i5;
            int i25 = i21 + i2;
            int i26 = i22 + i2;
            int i27 = i23 + i2;
            int i28 = i24 + i2;
            float f27 = fArr[i25] + fArr[i27];
            float f28 = fArr[i25 + 1] + fArr[i27 + 1];
            float f29 = fArr[i25] - fArr[i27];
            float f30 = fArr[i25 + 1] - fArr[i27 + 1];
            float f31 = fArr[i26] + fArr[i28];
            float f32 = fArr[i26 + 1] + fArr[i28 + 1];
            float f33 = fArr[i26] - fArr[i28];
            float f34 = fArr[i26 + 1] - fArr[i28 + 1];
            fArr[i25] = f27 + f31;
            fArr[i25 + 1] = f28 + f32;
            fArr[i26] = f27 - f31;
            fArr[i26 + 1] = f28 - f32;
            float f35 = f29 - f34;
            float f36 = f30 + f33;
            fArr[i27] = (f12 * f35) - (f11 * f36);
            fArr[i27 + 1] = (f11 * f35) + (f12 * f36);
            float f37 = f29 + f34;
            float f38 = f30 - f33;
            fArr[i28] = (f14 * f37) + (f13 * f38);
            fArr[i28 + 1] = (f14 * f38) - (f37 * f13);
        }
        int i29 = i4 + i5;
        int i30 = i29 + i5;
        int i31 = i5 + i30;
        int i32 = i4 + i2;
        int i33 = i29 + i2;
        int i34 = i30 + i2;
        int i35 = i31 + i2;
        float f39 = fArr[i32] + fArr[i34];
        float f40 = fArr[i32 + 1] + fArr[i34 + 1];
        float f41 = fArr[i32] - fArr[i34];
        float f42 = fArr[i32 + 1] - fArr[i34 + 1];
        float f43 = fArr[i33] + fArr[i35];
        float f44 = fArr[i33 + 1] + fArr[i35 + 1];
        float f45 = fArr[i33] - fArr[i35];
        float f46 = fArr[i33 + 1] - fArr[i35 + 1];
        fArr[i32] = f39 + f43;
        fArr[i32 + 1] = f40 + f44;
        fArr[i33] = f39 - f43;
        fArr[i33 + 1] = f40 - f44;
        float f47 = f41 - f46;
        float f48 = f42 + f45;
        fArr[i34] = (f47 - f48) * f10;
        fArr[i34 + 1] = (f47 + f48) * f10;
        float f49 = f41 + f46;
        float f50 = f42 - f45;
        fArr[i35] = (-f10) * (f49 + f50);
        fArr[i35 + 1] = (f50 - f49) * (-f10);
    }

    private void c(float[] fArr, int i) {
        float f2 = fArr[i + 2];
        float f3 = fArr[i + 3];
        float f4 = fArr[i + 4];
        float f5 = fArr[i + 5];
        float f6 = fArr[i + 6];
        float f7 = fArr[i + 7];
        float f8 = fArr[i + 8];
        float f9 = fArr[i + 9];
        float f10 = fArr[i + 10];
        float f11 = fArr[i + 11];
        float f12 = fArr[i + 12];
        float f13 = fArr[i + 13];
        float f14 = fArr[i + 14];
        float f15 = fArr[i + 15];
        float f16 = fArr[i + 16];
        float f17 = fArr[i + 17];
        float f18 = fArr[i + 18];
        float f19 = fArr[i + 19];
        float f20 = fArr[i + 20];
        float f21 = fArr[i + 21];
        float f22 = fArr[i + 22];
        float f23 = fArr[i + 23];
        float f24 = fArr[i + 24];
        float f25 = fArr[i + 25];
        float f26 = fArr[i + 26];
        float f27 = fArr[i + 27];
        float f28 = fArr[i + 28];
        float f29 = fArr[i + 29];
        float f30 = fArr[i + 30];
        float f31 = fArr[i + 31];
        fArr[i + 2] = f30;
        fArr[i + 3] = f31;
        fArr[i + 4] = f14;
        fArr[i + 5] = f15;
        fArr[i + 6] = f22;
        fArr[i + 7] = f23;
        fArr[i + 8] = f6;
        fArr[i + 9] = f7;
        fArr[i + 10] = f26;
        fArr[i + 11] = f27;
        fArr[i + 12] = f10;
        fArr[i + 13] = f11;
        fArr[i + 14] = f18;
        fArr[i + 15] = f19;
        fArr[i + 16] = f2;
        fArr[i + 17] = f3;
        fArr[i + 18] = f28;
        fArr[i + 19] = f29;
        fArr[i + 20] = f12;
        fArr[i + 21] = f13;
        fArr[i + 22] = f20;
        fArr[i + 23] = f21;
        fArr[i + 24] = f4;
        fArr[i + 25] = f5;
        fArr[i + 26] = f24;
        fArr[i + 27] = f25;
        fArr[i + 28] = f8;
        fArr[i + 29] = f9;
        fArr[i + 30] = f16;
        fArr[i + 31] = f17;
    }

    private void c(float[] fArr, int i, float[] fArr2, int i2) {
        float f2 = fArr2[i2 + 1];
        float f3 = fArr[i] + fArr[i + 8];
        float f4 = fArr[i + 1] + fArr[i + 9];
        float f5 = fArr[i] - fArr[i + 8];
        float f6 = fArr[i + 1] - fArr[i + 9];
        float f7 = fArr[i + 4] + fArr[i + 12];
        float f8 = fArr[i + 5] + fArr[i + 13];
        float f9 = fArr[i + 4] - fArr[i + 12];
        float f10 = fArr[i + 5] - fArr[i + 13];
        float f11 = f3 + f7;
        float f12 = f4 + f8;
        float f13 = f3 - f7;
        float f14 = f4 - f8;
        float f15 = f5 - f10;
        float f16 = f6 + f9;
        float f17 = f5 + f10;
        float f18 = f6 - f9;
        float f19 = fArr[i + 2] + fArr[i + 10];
        float f20 = fArr[i + 3] + fArr[i + 11];
        float f21 = fArr[i + 2] - fArr[i + 10];
        float f22 = fArr[i + 3] - fArr[i + 11];
        float f23 = fArr[i + 6] + fArr[i + 14];
        float f24 = fArr[i + 7] + fArr[i + 15];
        float f25 = fArr[i + 6] - fArr[i + 14];
        float f26 = fArr[i + 7] - fArr[i + 15];
        float f27 = f19 + f23;
        float f28 = f20 + f24;
        float f29 = f19 - f23;
        float f30 = f20 - f24;
        float f31 = f21 - f26;
        float f32 = f22 + f25;
        float f33 = f21 + f26;
        float f34 = f22 - f25;
        float f35 = (f31 - f32) * f2;
        float f36 = (f31 + f32) * f2;
        float f37 = (f33 - f34) * f2;
        float f38 = f2 * (f33 + f34);
        fArr[i + 8] = f15 + f35;
        fArr[i + 9] = f16 + f36;
        fArr[i + 10] = f15 - f35;
        fArr[i + 11] = f16 - f36;
        fArr[i + 12] = f17 - f38;
        fArr[i + 13] = f18 + f37;
        fArr[i + 14] = f38 + f17;
        fArr[i + 15] = f18 - f37;
        fArr[i] = f11 + f27;
        fArr[i + 1] = f12 + f28;
        fArr[i + 2] = f11 - f27;
        fArr[i + 3] = f12 - f28;
        fArr[i + 4] = f13 - f30;
        fArr[i + 5] = f14 + f29;
        fArr[i + 6] = f13 + f30;
        fArr[i + 7] = f14 - f29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, float[] fArr, int i2, float[] fArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        float f2 = fArr2[i3 + 1];
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = i2 + i5;
        int i9 = i6 + i2;
        int i10 = i7 + i2;
        float f3 = fArr[i2] - fArr[i9 + 1];
        float f4 = fArr[i2 + 1] + fArr[i9];
        float f5 = fArr[i2] + fArr[i9 + 1];
        float f6 = fArr[i2 + 1] - fArr[i9];
        float f7 = fArr[i8] - fArr[i10 + 1];
        float f8 = fArr[i8 + 1] + fArr[i10];
        float f9 = fArr[i8] + fArr[i10 + 1];
        float f10 = fArr[i8 + 1] - fArr[i10];
        float f11 = (f7 - f8) * f2;
        float f12 = (f7 + f8) * f2;
        fArr[i2] = f3 + f11;
        fArr[i2 + 1] = f4 + f12;
        fArr[i8] = f3 - f11;
        fArr[i8 + 1] = f4 - f12;
        float f13 = (f9 - f10) * f2;
        float f14 = f2 * (f10 + f9);
        fArr[i9] = f5 - f14;
        fArr[i9 + 1] = f6 + f13;
        fArr[i10] = f14 + f5;
        fArr[i10 + 1] = f6 - f13;
        int i11 = 0;
        int i12 = i5 * 2;
        for (int i13 = 2; i13 < i4; i13 += 2) {
            i11 += 4;
            int i14 = i3 + i11;
            float f15 = fArr2[i14];
            float f16 = fArr2[i14 + 1];
            float f17 = fArr2[i14 + 2];
            float f18 = fArr2[i14 + 3];
            i12 -= 4;
            int i15 = i3 + i12;
            float f19 = fArr2[i15];
            float f20 = fArr2[i15 + 1];
            float f21 = fArr2[i15 + 2];
            float f22 = fArr2[i15 + 3];
            int i16 = i13 + i5;
            int i17 = i16 + i5;
            int i18 = i17 + i5;
            int i19 = i16 + i2;
            int i20 = i17 + i2;
            int i21 = i18 + i2;
            int i22 = i2 + i13;
            float f23 = fArr[i22] - fArr[i20 + 1];
            float f24 = fArr[i22 + 1] + fArr[i20];
            float f25 = fArr[i22] + fArr[i20 + 1];
            float f26 = fArr[i22 + 1] - fArr[i20];
            float f27 = fArr[i19] - fArr[i21 + 1];
            float f28 = fArr[i19 + 1] + fArr[i21];
            float f29 = fArr[i19] + fArr[i21 + 1];
            float f30 = fArr[i19 + 1] - fArr[i21];
            float f31 = (f15 * f23) - (f16 * f24);
            float f32 = (f23 * f16) + (f24 * f15);
            float f33 = (f20 * f27) - (f19 * f28);
            float f34 = (f27 * f19) + (f28 * f20);
            fArr[i22] = f31 + f33;
            fArr[i22 + 1] = f32 + f34;
            fArr[i19] = f31 - f33;
            fArr[i19 + 1] = f32 - f34;
            float f35 = (f17 * f25) + (f18 * f26);
            float f36 = (f17 * f26) - (f18 * f25);
            float f37 = (f22 * f29) + (f21 * f30);
            float f38 = (f22 * f30) - (f21 * f29);
            fArr[i20] = f35 + f37;
            fArr[i20 + 1] = f36 + f38;
            fArr[i21] = f35 - f37;
            fArr[i21 + 1] = f36 - f38;
            int i23 = i5 - i13;
            int i24 = i23 + i5;
            int i25 = i24 + i5;
            int i26 = i25 + i5;
            int i27 = i23 + i2;
            int i28 = i24 + i2;
            int i29 = i25 + i2;
            int i30 = i26 + i2;
            float f39 = fArr[i27] - fArr[i29 + 1];
            float f40 = fArr[i27 + 1] + fArr[i29];
            float f41 = fArr[i27] + fArr[i29 + 1];
            float f42 = fArr[i27 + 1] - fArr[i29];
            float f43 = fArr[i28] - fArr[i30 + 1];
            float f44 = fArr[i28 + 1] + fArr[i30];
            float f45 = fArr[i28] + fArr[i30 + 1];
            float f46 = fArr[i28 + 1] - fArr[i30];
            float f47 = (f19 * f39) - (f20 * f40);
            float f48 = (f19 * f40) + (f20 * f39);
            float f49 = (f16 * f43) - (f15 * f44);
            float f50 = (f15 * f43) + (f16 * f44);
            fArr[i27] = f47 + f49;
            fArr[i27 + 1] = f48 + f50;
            fArr[i28] = f47 - f49;
            fArr[i28 + 1] = f48 - f50;
            float f51 = (f21 * f41) + (f22 * f42);
            float f52 = (f21 * f42) - (f22 * f41);
            float f53 = (f18 * f45) + (f17 * f46);
            float f54 = (f18 * f46) - (f17 * f45);
            fArr[i29] = f51 + f53;
            fArr[i29 + 1] = f52 + f54;
            fArr[i30] = f51 - f53;
            fArr[i30 + 1] = f52 - f54;
        }
        float f55 = fArr2[i3 + i5];
        float f56 = fArr2[i3 + i5 + 1];
        int i31 = i4 + i5;
        int i32 = i31 + i5;
        int i33 = i5 + i32;
        int i34 = i4 + i2;
        int i35 = i31 + i2;
        int i36 = i32 + i2;
        int i37 = i33 + i2;
        float f57 = fArr[i34] - fArr[i36 + 1];
        float f58 = fArr[i34 + 1] + fArr[i36];
        float f59 = fArr[i34] + fArr[i36 + 1];
        float f60 = fArr[i34 + 1] - fArr[i36];
        float f61 = fArr[i35] - fArr[i37 + 1];
        float f62 = fArr[i35 + 1] + fArr[i37];
        float f63 = fArr[i35] + fArr[i37 + 1];
        float f64 = fArr[i35 + 1] - fArr[i37];
        float f65 = (f55 * f57) - (f56 * f58);
        float f66 = (f57 * f56) + (f58 * f55);
        float f67 = (f56 * f61) - (f55 * f62);
        float f68 = (f61 * f55) + (f62 * f56);
        fArr[i34] = f65 + f67;
        fArr[i34 + 1] = f66 + f68;
        fArr[i35] = f65 - f67;
        fArr[i35 + 1] = f66 - f68;
        float f69 = (f56 * f59) - (f55 * f60);
        float f70 = (f56 * f60) + (f55 * f59);
        float f71 = (f55 * f63) - (f56 * f64);
        float f72 = (f55 * f64) + (f56 * f63);
        fArr[i36] = f69 - f71;
        fArr[i36 + 1] = f70 - f72;
        fArr[i37] = f69 + f71;
        fArr[i37 + 1] = f72 + f70;
    }

    private void d(float[] fArr, int i) {
        float f2 = fArr[i + 2];
        float f3 = fArr[i + 3];
        float f4 = fArr[i + 6];
        float f5 = fArr[i + 7];
        float f6 = fArr[i + 8];
        float f7 = fArr[i + 9];
        float f8 = fArr[i + 12];
        float f9 = fArr[i + 13];
        fArr[i + 2] = f6;
        fArr[i + 3] = f7;
        fArr[i + 6] = f8;
        fArr[i + 7] = f9;
        fArr[i + 8] = f2;
        fArr[i + 9] = f3;
        fArr[i + 12] = f4;
        fArr[i + 13] = f5;
    }

    private void d(float[] fArr, int i, float[] fArr2, int i2) {
        float f2 = fArr2[i2 + 1];
        float f3 = fArr2[i2 + 2];
        float f4 = fArr2[i2 + 3];
        float f5 = fArr[i] - fArr[i + 9];
        float f6 = fArr[i + 1] + fArr[i + 8];
        float f7 = fArr[i] + fArr[i + 9];
        float f8 = fArr[i + 1] - fArr[i + 8];
        float f9 = fArr[i + 4] - fArr[i + 13];
        float f10 = fArr[i + 5] + fArr[i + 12];
        float f11 = (f9 - f10) * f2;
        float f12 = (f9 + f10) * f2;
        float f13 = fArr[i + 4] + fArr[i + 13];
        float f14 = fArr[i + 5] - fArr[i + 12];
        float f15 = (f13 - f14) * f2;
        float f16 = f2 * (f13 + f14);
        float f17 = fArr[i + 2] - fArr[i + 11];
        float f18 = fArr[i + 3] + fArr[i + 10];
        float f19 = (f3 * f17) - (f4 * f18);
        float f20 = (f17 * f4) + (f18 * f3);
        float f21 = fArr[i + 2] + fArr[i + 11];
        float f22 = fArr[i + 3] - fArr[i + 10];
        float f23 = (f4 * f21) - (f3 * f22);
        float f24 = (f21 * f3) + (f22 * f4);
        float f25 = fArr[i + 6] - fArr[i + 15];
        float f26 = fArr[i + 7] + fArr[i + 14];
        float f27 = (f4 * f25) - (f3 * f26);
        float f28 = (f25 * f3) + (f26 * f4);
        float f29 = fArr[i + 6] + fArr[i + 15];
        float f30 = fArr[i + 7] - fArr[i + 14];
        float f31 = (f3 * f29) - (f4 * f30);
        float f32 = (f3 * f30) + (f4 * f29);
        float f33 = f5 + f11;
        float f34 = f6 + f12;
        float f35 = f19 + f27;
        float f36 = f20 + f28;
        fArr[i] = f33 + f35;
        fArr[i + 1] = f34 + f36;
        fArr[i + 2] = f33 - f35;
        fArr[i + 3] = f34 - f36;
        float f37 = f5 - f11;
        float f38 = f6 - f12;
        float f39 = f19 - f27;
        float f40 = f20 - f28;
        fArr[i + 4] = f37 - f40;
        fArr[i + 5] = f38 + f39;
        fArr[i + 6] = f37 + f40;
        fArr[i + 7] = f38 - f39;
        float f41 = f7 - f16;
        float f42 = f8 + f15;
        float f43 = f23 - f31;
        float f44 = f24 - f32;
        fArr[i + 8] = f41 + f43;
        fArr[i + 9] = f42 + f44;
        fArr[i + 10] = f41 - f43;
        fArr[i + 11] = f42 - f44;
        float f45 = f16 + f7;
        float f46 = f8 - f15;
        float f47 = f23 + f31;
        float f48 = f32 + f24;
        fArr[i + 12] = f45 - f48;
        fArr[i + 13] = f46 + f47;
        fArr[i + 14] = f45 + f48;
        fArr[i + 15] = f46 - f47;
    }

    private void e(float[] fArr, int i) {
        float f2 = fArr[i + 2];
        float f3 = fArr[i + 3];
        float f4 = fArr[i + 4];
        float f5 = fArr[i + 5];
        float f6 = fArr[i + 6];
        float f7 = fArr[i + 7];
        float f8 = fArr[i + 8];
        float f9 = fArr[i + 9];
        float f10 = fArr[i + 10];
        float f11 = fArr[i + 11];
        float f12 = fArr[i + 12];
        float f13 = fArr[i + 13];
        float f14 = fArr[i + 14];
        float f15 = fArr[i + 15];
        fArr[i + 2] = f14;
        fArr[i + 3] = f15;
        fArr[i + 4] = f6;
        fArr[i + 5] = f7;
        fArr[i + 6] = f10;
        fArr[i + 7] = f11;
        fArr[i + 8] = f2;
        fArr[i + 9] = f3;
        fArr[i + 10] = f12;
        fArr[i + 11] = f13;
        fArr[i + 12] = f4;
        fArr[i + 13] = f5;
        fArr[i + 14] = f8;
        fArr[i + 15] = f9;
    }

    private void f(float[] fArr, int i) {
        float f2 = fArr[i] + fArr[i + 4];
        float f3 = fArr[i + 1] + fArr[i + 5];
        float f4 = fArr[i] - fArr[i + 4];
        float f5 = fArr[i + 1] - fArr[i + 5];
        float f6 = fArr[i + 2] + fArr[i + 6];
        float f7 = fArr[i + 3] + fArr[i + 7];
        float f8 = fArr[i + 2] - fArr[i + 6];
        float f9 = fArr[i + 3] - fArr[i + 7];
        fArr[i] = f2 + f6;
        fArr[i + 1] = f3 + f7;
        fArr[i + 2] = f4 - f9;
        fArr[i + 3] = f5 + f8;
        fArr[i + 4] = f2 - f6;
        fArr[i + 5] = f3 - f7;
        fArr[i + 6] = f4 + f9;
        fArr[i + 7] = f5 - f8;
    }

    private void g(float[] fArr, int i) {
        float f2 = fArr[i] + fArr[i + 4];
        float f3 = fArr[i + 1] + fArr[i + 5];
        float f4 = fArr[i] - fArr[i + 4];
        float f5 = fArr[i + 1] - fArr[i + 5];
        float f6 = fArr[i + 2] + fArr[i + 6];
        float f7 = fArr[i + 3] + fArr[i + 7];
        float f8 = fArr[i + 2] - fArr[i + 6];
        float f9 = fArr[i + 3] - fArr[i + 7];
        fArr[i] = f2 + f6;
        fArr[i + 1] = f3 + f7;
        fArr[i + 2] = f4 + f9;
        fArr[i + 3] = f5 - f8;
        fArr[i + 4] = f2 - f6;
        fArr[i + 5] = f3 - f7;
        fArr[i + 6] = f4 - f9;
        fArr[i + 7] = f5 + f8;
    }

    private void h(float[] fArr, int i) {
        float f2 = fArr[i] - fArr[i + 2];
        float f3 = fArr[i + 1] - fArr[i + 3];
        fArr[i] = fArr[i] + fArr[i + 2];
        int i2 = i + 1;
        fArr[i2] = fArr[i2] + fArr[i + 3];
        fArr[i + 2] = f2;
        fArr[i + 3] = f3;
    }

    void a() {
        int i;
        if (this.f93a == 1) {
            return;
        }
        int i2 = this.f93a * 2;
        int i3 = this.f93a * 4;
        int i4 = 0;
        int i5 = this.f93a;
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            int i8 = i7 + 1;
            i4 = i8 <= 4 ? l[i8 - 1] : i4 + 2;
            while (true) {
                int i9 = i5 / i4;
                if (i5 - (i4 * i9) != 0) {
                    break;
                }
                i = i6 + 1;
                this.g[i + 1 + i3] = i4;
                if (i4 == 2 && i != 1) {
                    for (int i10 = 2; i10 <= i; i10++) {
                        int i11 = (i - i10) + 2 + i3;
                        this.g[i11 + 1] = this.g[i11];
                    }
                    this.g[i3 + 2] = 2.0f;
                }
                if (i9 == 1) {
                    break loop0;
                }
                i6 = i;
                i5 = i9;
            }
            i6 = i6;
            i7 = i8;
        }
        this.g[i3] = this.f93a;
        this.g[i3 + 1] = i;
        float f2 = 6.2831855f / this.f93a;
        int i12 = 1;
        int i13 = 1;
        for (int i14 = 1; i14 <= i; i14++) {
            int i15 = (int) this.g[i14 + 1 + i3];
            int i16 = 0;
            int i17 = i13 * i15;
            int i18 = this.f93a / i17;
            int i19 = i18 + i18 + 2;
            int i20 = i15 - 1;
            int i21 = 1;
            while (i21 <= i20) {
                this.g[(i12 - 1) + i2] = 1.0f;
                this.g[i12 + i2] = 0.0f;
                int i22 = i16 + i13;
                float f3 = BitmapDescriptorFactory.HUE_RED;
                float f4 = i22 * f2;
                int i23 = i12;
                for (int i24 = 4; i24 <= i19; i24 += 2) {
                    i23 += 2;
                    f3 += 1.0f;
                    float f5 = f3 * f4;
                    int i25 = i23 + i2;
                    this.g[i25 - 1] = (float) Math.cos(f5);
                    this.g[i25] = (float) Math.sin(f5);
                }
                if (i15 > 5) {
                    int i26 = i12 + i2;
                    int i27 = i23 + i2;
                    this.g[i26 - 1] = this.g[i27 - 1];
                    this.g[i26] = this.g[i27];
                }
                i21++;
                i12 = i23;
                i16 = i22;
            }
            i13 = i17;
        }
    }

    void a(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int i5, int i6) {
        int i7 = i * i2;
        if (i <= 2) {
            for (int i8 = 0; i8 < i2; i8++) {
                int i9 = i8 * i;
                int i10 = (i9 * 2) + i3;
                int i11 = i10 + i;
                float f2 = fArr[i10];
                float f3 = fArr[i10 + 1];
                float f4 = fArr[i11];
                float f5 = fArr[i11 + 1];
                int i12 = i9 + i4;
                int i13 = i12 + i7;
                fArr2[i12] = f2 + f4;
                fArr2[i12 + 1] = f3 + f5;
                fArr2[i13] = f2 - f4;
                fArr2[i13 + 1] = f3 - f5;
            }
            return;
        }
        int i14 = 0;
        while (true) {
            int i15 = i14;
            if (i15 >= i2) {
                return;
            }
            for (int i16 = 0; i16 < i - 1; i16 += 2) {
                int i17 = i15 * i;
                int i18 = i3 + i16 + (i17 * 2);
                int i19 = i18 + i;
                float f6 = fArr[i18];
                float f7 = fArr[i18 + 1];
                float f8 = fArr[i19];
                float f9 = fArr[i19 + 1];
                int i20 = i16 + i5;
                float f10 = this.g[i20];
                float f11 = this.g[i20 + 1] * i6;
                float f12 = f6 - f8;
                float f13 = f7 - f9;
                int i21 = i17 + i4 + i16;
                int i22 = i21 + i7;
                fArr2[i21] = f6 + f8;
                fArr2[i21 + 1] = f7 + f9;
                fArr2[i22] = (f10 * f12) - (f11 * f13);
                fArr2[i22 + 1] = (f10 * f13) + (f11 * f12);
            }
            i14 = i15 + 1;
        }
    }

    public void a(float[] fArr) {
        a(fArr, 0);
    }

    public void a(float[] fArr, int i) {
        if (this.f93a == 1) {
        }
        switch (this.k) {
            case SPLIT_RADIX:
                b(this.f93a * 2, fArr, i, this.f95c, this.f97e, this.f96d);
                break;
            case MIXED_RADIX:
                a(fArr, i, -1);
                break;
            case BLUESTEIN:
                b(fArr, i, -1);
                break;
        }
    }

    void a(float[] fArr, int i, int i2) {
        int i3;
        int i4 = this.f93a * 2;
        float[] fArr2 = new float[i4];
        int i5 = this.f93a * 4;
        int[] iArr = {0};
        int i6 = (int) this.g[i5 + 1];
        int i7 = 0;
        int i8 = 1;
        int i9 = 2;
        int i10 = i4;
        while (i9 <= i6 + 1) {
            int i11 = (int) this.g[i9 + i5];
            int i12 = i11 * i8;
            int i13 = this.f93a / i12;
            int i14 = i13 + i13;
            int i15 = i14 * i8;
            switch (i11) {
                case 2:
                    if (i7 == 0) {
                        a(i14, i8, fArr, i, fArr2, 0, i10, i2);
                    } else {
                        a(i14, i8, fArr2, 0, fArr, i, i10, i2);
                    }
                    i3 = 1 - i7;
                    break;
                case 3:
                    if (i7 == 0) {
                        b(i14, i8, fArr, i, fArr2, 0, i10, i2);
                    } else {
                        b(i14, i8, fArr2, 0, fArr, i, i10, i2);
                    }
                    i3 = 1 - i7;
                    break;
                case 4:
                    if (i7 == 0) {
                        c(i14, i8, fArr, i, fArr2, 0, i10, i2);
                    } else {
                        c(i14, i8, fArr2, 0, fArr, i, i10, i2);
                    }
                    i3 = 1 - i7;
                    break;
                case 5:
                    if (i7 == 0) {
                        d(i14, i8, fArr, i, fArr2, 0, i10, i2);
                    } else {
                        d(i14, i8, fArr2, 0, fArr, i, i10, i2);
                    }
                    i3 = 1 - i7;
                    break;
                default:
                    if (i7 == 0) {
                        a(iArr, i14, i11, i8, i15, fArr, i, fArr2, 0, i10, i2);
                    } else {
                        a(iArr, i14, i11, i8, i15, fArr2, 0, fArr, i, i10, i2);
                    }
                    i3 = iArr[0] == 0 ? i7 : 1 - i7;
                    break;
            }
            i10 += i14 * (i11 - 1);
            i9++;
            i7 = i3;
            i8 = i12;
        }
        if (i7 == 0) {
            return;
        }
        System.arraycopy(fArr2, 0, fArr, i, i4);
    }

    public void a(float[] fArr, int i, boolean z) {
        if (this.f93a == 1) {
            return;
        }
        switch (this.k) {
            case SPLIT_RADIX:
                a(this.f93a * 2, fArr, i, this.f95c, this.f97e, this.f96d);
                break;
            case MIXED_RADIX:
                a(fArr, i, 1);
                break;
            case BLUESTEIN:
                b(fArr, i, 1);
                break;
        }
        if (z) {
            a(this.f93a, fArr, i, true);
        }
    }

    public void a(float[] fArr, boolean z) {
        a(fArr, 0, z);
    }

    void a(int[] iArr, int i, int i2, int i3, int i4, float[] fArr, int i5, float[] fArr2, int i6, int i7, int i8) {
        int i9 = i / 2;
        int i10 = (i2 + 1) / 2;
        int i11 = i2 * i;
        if (i < i3) {
            for (int i12 = 1; i12 < i10; i12++) {
                int i13 = i2 - i12;
                int i14 = i12 * i3 * i;
                int i15 = i13 * i3 * i;
                int i16 = i12 * i;
                int i17 = i13 * i;
                int i18 = 0;
                while (true) {
                    int i19 = i18;
                    if (i19 < i) {
                        for (int i20 = 0; i20 < i3; i20++) {
                            int i21 = i20 * i;
                            int i22 = i21 * i2;
                            int i23 = i6 + i19;
                            int i24 = i5 + i19;
                            float f2 = fArr[i24 + i16 + i22];
                            float f3 = fArr[i22 + i24 + i17];
                            fArr2[i23 + i21 + i14] = f2 + f3;
                            fArr2[i21 + i23 + i15] = f2 - f3;
                        }
                        i18 = i19 + 1;
                    }
                }
            }
            int i25 = 0;
            while (true) {
                int i26 = i25;
                if (i26 >= i) {
                    break;
                }
                for (int i27 = 0; i27 < i3; i27++) {
                    int i28 = i27 * i;
                    fArr2[i6 + i26 + i28] = fArr[(i28 * i2) + i5 + i26];
                }
                i25 = i26 + 1;
            }
        } else {
            for (int i29 = 1; i29 < i10; i29++) {
                int i30 = i29 * i;
                int i31 = (i2 - i29) * i;
                int i32 = 0;
                while (true) {
                    int i33 = i32;
                    if (i33 < i3) {
                        int i34 = i33 * i;
                        int i35 = (i30 * i3) + i34;
                        int i36 = (i31 * i3) + i34;
                        int i37 = i34 * i2;
                        for (int i38 = 0; i38 < i; i38++) {
                            int i39 = i6 + i38;
                            float f4 = fArr[i5 + i38 + i30 + i37];
                            float f5 = fArr[i5 + i38 + i31 + i37];
                            fArr2[i39 + i35] = f4 + f5;
                            fArr2[i39 + i36] = f4 - f5;
                        }
                        i32 = i33 + 1;
                    }
                }
            }
            int i40 = 0;
            while (true) {
                int i41 = i40;
                if (i41 >= i3) {
                    break;
                }
                int i42 = i41 * i;
                int i43 = i42 * i2;
                for (int i44 = 0; i44 < i; i44++) {
                    fArr2[i6 + i44 + i42] = fArr[i5 + i44 + i43];
                }
                i40 = i41 + 1;
            }
        }
        int i45 = 2 - i;
        int i46 = (i2 - 1) * i4;
        int i47 = 0;
        for (int i48 = 1; i48 < i10; i48++) {
            i45 += i;
            int i49 = i48 * i4;
            int i50 = (i2 - i48) * i4;
            int i51 = i45 + i7;
            float f6 = this.g[i51 - 2];
            float f7 = i8 * this.g[i51 - 1];
            for (int i52 = 0; i52 < i4; i52++) {
                int i53 = i5 + i52;
                int i54 = i6 + i52;
                fArr[i53 + i49] = fArr2[i54] + (fArr2[i54 + i4] * f6);
                fArr[i53 + i50] = fArr2[i54 + i46] * f7;
            }
            int i55 = i47 + i;
            int i56 = i45;
            for (int i57 = 2; i57 < i10; i57++) {
                int i58 = i2 - i57;
                i56 += i55;
                if (i56 > i11) {
                    i56 -= i11;
                }
                int i59 = i56 + i7;
                float f8 = this.g[i59 - 2];
                float f9 = this.g[i59 - 1] * i8;
                int i60 = i57 * i4;
                int i61 = i58 * i4;
                for (int i62 = 0; i62 < i4; i62++) {
                    int i63 = i5 + i62;
                    int i64 = i6 + i62;
                    int i65 = i63 + i49;
                    fArr[i65] = fArr[i65] + (fArr2[i64 + i60] * f8);
                    int i66 = i63 + i50;
                    fArr[i66] = (fArr2[i64 + i61] * f9) + fArr[i66];
                }
            }
            i47 = i55;
        }
        for (int i67 = 1; i67 < i10; i67++) {
            int i68 = i67 * i4;
            for (int i69 = 0; i69 < i4; i69++) {
                int i70 = i6 + i69;
                fArr2[i70] = fArr2[i70] + fArr2[i70 + i68];
            }
        }
        for (int i71 = 1; i71 < i10; i71++) {
            int i72 = i71 * i4;
            int i73 = (i2 - i71) * i4;
            for (int i74 = 1; i74 < i4; i74 += 2) {
                int i75 = i6 + i74;
                int i76 = i5 + i74;
                int i77 = i76 + i72;
                int i78 = i76 + i73;
                float f10 = fArr[i77 - 1];
                float f11 = fArr[i77];
                float f12 = fArr[i78 - 1];
                float f13 = fArr[i78];
                int i79 = i75 + i72;
                int i80 = i75 + i73;
                fArr2[i79 - 1] = f10 - f13;
                fArr2[i80 - 1] = f13 + f10;
                fArr2[i79] = f11 + f12;
                fArr2[i80] = f11 - f12;
            }
        }
        iArr[0] = 1;
        if (i == 2) {
            return;
        }
        iArr[0] = 0;
        System.arraycopy(fArr2, i6, fArr, i5, i4);
        int i81 = i3 * i;
        int i82 = 1;
        while (true) {
            int i83 = i82;
            if (i83 >= i2) {
                break;
            }
            int i84 = i83 * i81;
            for (int i85 = 0; i85 < i3; i85++) {
                int i86 = i85 * i;
                int i87 = i6 + i86 + i84;
                int i88 = i86 + i5 + i84;
                fArr[i88] = fArr2[i87];
                fArr[i88 + 1] = fArr2[i87 + 1];
            }
            i82 = i83 + 1;
        }
        if (i9 <= i3) {
            int i89 = 0;
            for (int i90 = 1; i90 < i2; i90++) {
                int i91 = i90 * i3 * i;
                i89 += 2;
                int i92 = 3;
                while (i92 < i) {
                    int i93 = i89 + 2;
                    int i94 = (i93 + i7) - 1;
                    float f14 = this.g[i94 - 1];
                    float f15 = i8 * this.g[i94];
                    int i95 = i5 + i92;
                    int i96 = i6 + i92;
                    for (int i97 = 0; i97 < i3; i97++) {
                        int i98 = (i97 * i) + i91;
                        int i99 = i95 + i98;
                        int i100 = i98 + i96;
                        float f16 = fArr2[i100 - 1];
                        float f17 = fArr2[i100];
                        fArr[i99 - 1] = (f14 * f16) - (f15 * f17);
                        fArr[i99] = (f17 * f14) + (f16 * f15);
                    }
                    i92 += 2;
                    i89 = i93;
                }
            }
            return;
        }
        int i101 = 2 - i;
        int i102 = 1;
        while (true) {
            int i103 = i102;
            if (i103 >= i2) {
                return;
            }
            i101 += i;
            int i104 = i103 * i3 * i;
            int i105 = 0;
            while (true) {
                int i106 = i105;
                if (i106 < i3) {
                    int i107 = (i106 * i) + i104;
                    int i108 = i101;
                    for (int i109 = 3; i109 < i; i109 += 2) {
                        i108 += 2;
                        int i110 = (i108 - 1) + i7;
                        float f18 = this.g[i110 - 1];
                        float f19 = this.g[i110] * i8;
                        int i111 = i5 + i109 + i107;
                        int i112 = i6 + i109 + i107;
                        float f20 = fArr2[i112 - 1];
                        float f21 = fArr2[i112];
                        fArr[i111 - 1] = (f18 * f20) - (f19 * f21);
                        fArr[i111] = (f19 * f20) + (f18 * f21);
                    }
                    i105 = i106 + 1;
                }
            }
            i102 = i103 + 1;
        }
    }

    void b() {
        int i;
        if (this.f93a == 1) {
            return;
        }
        int i2 = this.f93a * 2;
        int i3 = 0;
        int i4 = this.f93a;
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            int i7 = i6 + 1;
            i3 = i7 <= 4 ? l[i7 - 1] : i3 + 2;
            while (true) {
                int i8 = i4 / i3;
                if (i4 - (i3 * i8) != 0) {
                    break;
                }
                i = i5 + 1;
                this.h[i + 1 + i2] = i3;
                if (i3 == 2 && i != 1) {
                    for (int i9 = 2; i9 <= i; i9++) {
                        int i10 = (i - i9) + 2 + i2;
                        this.h[i10 + 1] = this.h[i10];
                    }
                    this.h[i2 + 2] = 2.0f;
                }
                if (i8 == 1) {
                    break loop0;
                }
                i5 = i;
                i4 = i8;
            }
            i5 = i5;
            i6 = i7;
        }
        this.h[i2] = this.f93a;
        this.h[i2 + 1] = i;
        float f2 = 6.2831855f / this.f93a;
        int i11 = 0;
        int i12 = i - 1;
        if (i12 != 0) {
            int i13 = 1;
            for (int i14 = 1; i14 <= i12; i14++) {
                int i15 = (int) this.h[i14 + 1 + i2];
                int i16 = 0;
                int i17 = i13 * i15;
                int i18 = this.f93a / i17;
                int i19 = i15 - 1;
                int i20 = 1;
                while (i20 <= i19) {
                    int i21 = i16 + i13;
                    float f3 = i21 * f2;
                    float f4 = BitmapDescriptorFactory.HUE_RED;
                    int i22 = i11;
                    for (int i23 = 3; i23 <= i18; i23 += 2) {
                        i22 += 2;
                        f4 += 1.0f;
                        float f5 = f4 * f3;
                        int i24 = this.f93a + i22;
                        this.h[i24 - 2] = (float) Math.cos(f5);
                        this.h[i24 - 1] = (float) Math.sin(f5);
                    }
                    i11 += i18;
                    i20++;
                    i16 = i21;
                }
                i13 = i17;
            }
        }
    }

    void b(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int i5, int i6) {
        int i7 = i5 + i;
        int i8 = i2 * i;
        if (i == 2) {
            for (int i9 = 1; i9 <= i2; i9++) {
                int i10 = (((i9 * 3) - 2) * i) + i3;
                int i11 = i10 + i;
                int i12 = i10 - i;
                float f2 = fArr[i10];
                float f3 = fArr[i10 + 1];
                float f4 = fArr[i11];
                float f5 = fArr[i11 + 1];
                float f6 = fArr[i12];
                float f7 = fArr[i12 + 1];
                float f8 = f2 + f4;
                float f9 = f6 + ((-0.5f) * f8);
                float f10 = f3 + f5;
                float f11 = ((-0.5f) * f10) + f7;
                float f12 = (f2 - f4) * i6 * 0.8660254f;
                float f13 = (f3 - f5) * i6 * 0.8660254f;
                int i13 = ((i9 - 1) * i) + i4;
                int i14 = i13 + i8;
                int i15 = i14 + i8;
                fArr2[i13] = fArr[i12] + f8;
                fArr2[i13 + 1] = f7 + f10;
                fArr2[i14] = f9 - f13;
                fArr2[i14 + 1] = f11 + f12;
                fArr2[i15] = f13 + f9;
                fArr2[i15 + 1] = f11 - f12;
            }
            return;
        }
        int i16 = 1;
        while (true) {
            int i17 = i16;
            if (i17 > i2) {
                return;
            }
            int i18 = i3 + (((i17 * 3) - 2) * i);
            int i19 = i4 + ((i17 - 1) * i);
            for (int i20 = 0; i20 < i - 1; i20 += 2) {
                int i21 = i20 + i18;
                int i22 = i21 + i;
                int i23 = i21 - i;
                float f14 = fArr[i21];
                float f15 = fArr[i21 + 1];
                float f16 = fArr[i22];
                float f17 = fArr[i22 + 1];
                float f18 = fArr[i23];
                float f19 = fArr[i23 + 1];
                float f20 = f14 + f16;
                float f21 = ((-0.5f) * f20) + f18;
                float f22 = f15 + f17;
                float f23 = ((-0.5f) * f22) + f19;
                float f24 = (f14 - f16) * i6 * 0.8660254f;
                float f25 = (f15 - f17) * i6 * 0.8660254f;
                float f26 = f21 - f25;
                float f27 = f25 + f21;
                float f28 = f23 + f24;
                float f29 = f23 - f24;
                int i24 = i20 + i5;
                int i25 = i20 + i7;
                float f30 = this.g[i24];
                float f31 = this.g[i24 + 1] * i6;
                float f32 = this.g[i25];
                float f33 = this.g[i25 + 1] * i6;
                int i26 = i20 + i19;
                int i27 = i26 + i8;
                int i28 = i27 + i8;
                fArr2[i26] = f18 + f20;
                fArr2[i26 + 1] = f19 + f22;
                fArr2[i27] = (f30 * f26) - (f31 * f28);
                fArr2[i27 + 1] = (f26 * f31) + (f28 * f30);
                fArr2[i28] = (f32 * f27) - (f33 * f29);
                fArr2[i28 + 1] = (f27 * f33) + (f32 * f29);
            }
            i16 = i17 + 1;
        }
    }

    void c(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int i5, int i6) {
        int i7 = i5 + i;
        int i8 = i7 + i;
        int i9 = i2 * i;
        if (i == 2) {
            for (int i10 = 0; i10 < i2; i10++) {
                int i11 = i10 * i;
                int i12 = (i11 * 4) + i3 + 1;
                int i13 = i12 + i;
                int i14 = i13 + i;
                int i15 = i14 + i;
                float f2 = fArr[i12 - 1];
                float f3 = fArr[i12];
                float f4 = fArr[i13 - 1];
                float f5 = fArr[i13];
                float f6 = fArr[i14 - 1];
                float f7 = fArr[i14];
                float f8 = fArr[i15 - 1];
                float f9 = fArr[i15];
                float f10 = f3 - f7;
                float f11 = f3 + f7;
                float f12 = f9 - f5;
                float f13 = f5 + f9;
                float f14 = f2 - f6;
                float f15 = f2 + f6;
                float f16 = f4 - f8;
                float f17 = f4 + f8;
                int i16 = i11 + i4;
                int i17 = i16 + i9;
                int i18 = i17 + i9;
                int i19 = i18 + i9;
                fArr2[i16] = f15 + f17;
                fArr2[i16 + 1] = f11 + f13;
                fArr2[i17] = (i6 * f12) + f14;
                fArr2[i17 + 1] = (i6 * f16) + f10;
                fArr2[i18] = f15 - f17;
                fArr2[i18 + 1] = f11 - f13;
                fArr2[i19] = f14 - (i6 * f12);
                fArr2[i19 + 1] = f10 - (i6 * f16);
            }
            return;
        }
        int i20 = 0;
        while (true) {
            int i21 = i20;
            if (i21 >= i2) {
                return;
            }
            int i22 = i21 * i;
            int i23 = (i22 * 4) + i3 + 1;
            for (int i24 = 0; i24 < i - 1; i24 += 2) {
                int i25 = i24 + i23;
                int i26 = i25 + i;
                int i27 = i26 + i;
                int i28 = i27 + i;
                float f18 = fArr[i25 - 1];
                float f19 = fArr[i25];
                float f20 = fArr[i26 - 1];
                float f21 = fArr[i26];
                float f22 = fArr[i27 - 1];
                float f23 = fArr[i27];
                float f24 = fArr[i28 - 1];
                float f25 = fArr[i28];
                float f26 = f19 - f23;
                float f27 = f19 + f23;
                float f28 = f21 + f25;
                float f29 = f25 - f21;
                float f30 = f18 - f22;
                float f31 = f18 + f22;
                float f32 = f20 - f24;
                float f33 = f20 + f24;
                float f34 = f31 - f33;
                float f35 = f27 - f28;
                float f36 = (i6 * f29) + f30;
                float f37 = f30 - (f29 * i6);
                float f38 = (i6 * f32) + f26;
                float f39 = f26 - (f32 * i6);
                int i29 = i24 + i5;
                int i30 = i24 + i7;
                int i31 = i24 + i8;
                float f40 = this.g[i29];
                float f41 = this.g[i29 + 1] * i6;
                float f42 = this.g[i30];
                float f43 = this.g[i30 + 1] * i6;
                float f44 = this.g[i31];
                float f45 = this.g[i31 + 1] * i6;
                int i32 = i4 + i24 + i22;
                int i33 = i32 + i9;
                int i34 = i33 + i9;
                int i35 = i34 + i9;
                fArr2[i32] = f31 + f33;
                fArr2[i32 + 1] = f27 + f28;
                fArr2[i33] = (f40 * f36) - (f41 * f38);
                fArr2[i33 + 1] = (f40 * f38) + (f41 * f36);
                fArr2[i34] = (f42 * f34) - (f43 * f35);
                fArr2[i34 + 1] = (f42 * f35) + (f43 * f34);
                fArr2[i35] = (f44 * f37) - (f45 * f39);
                fArr2[i35 + 1] = (f37 * f45) + (f44 * f39);
            }
            i20 = i21 + 1;
        }
    }

    void d(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int i5, int i6) {
        int i7 = i5 + i;
        int i8 = i7 + i;
        int i9 = i8 + i;
        int i10 = i2 * i;
        if (i == 2) {
            for (int i11 = 1; i11 <= i2; i11++) {
                int i12 = (((i11 * 5) - 4) * i) + i3 + 1;
                int i13 = i12 + i;
                int i14 = i12 - i;
                int i15 = i13 + i;
                int i16 = i15 + i;
                float f2 = fArr[i12 - 1];
                float f3 = fArr[i12];
                float f4 = fArr[i13 - 1];
                float f5 = fArr[i13];
                float f6 = fArr[i14 - 1];
                float f7 = fArr[i14];
                float f8 = fArr[i15 - 1];
                float f9 = fArr[i15];
                float f10 = fArr[i16 - 1];
                float f11 = fArr[i16];
                float f12 = f3 - f11;
                float f13 = f3 + f11;
                float f14 = f5 - f9;
                float f15 = f5 + f9;
                float f16 = f2 - f10;
                float f17 = f2 + f10;
                float f18 = f4 - f8;
                float f19 = f4 + f8;
                float f20 = (0.309017f * f17) + f6 + ((-0.809017f) * f19);
                float f21 = (0.309017f * f13) + f7 + ((-0.809017f) * f15);
                float f22 = ((-0.809017f) * f17) + f6 + (0.309017f * f19);
                float f23 = ((-0.809017f) * f13) + f7 + (0.309017f * f15);
                float f24 = i6 * ((0.95105654f * f16) + (0.58778524f * f18));
                float f25 = i6 * ((0.95105654f * f12) + (0.58778524f * f14));
                float f26 = ((f16 * 0.58778524f) - (f18 * 0.95105654f)) * i6;
                float f27 = ((f12 * 0.58778524f) - (f14 * 0.95105654f)) * i6;
                int i17 = ((i11 - 1) * i) + i4;
                int i18 = i17 + i10;
                int i19 = i18 + i10;
                int i20 = i19 + i10;
                int i21 = i20 + i10;
                fArr2[i17] = f17 + f6 + f19;
                fArr2[i17 + 1] = f13 + f7 + f15;
                fArr2[i18] = f20 - f25;
                fArr2[i18 + 1] = f21 + f24;
                fArr2[i19] = f22 - f27;
                fArr2[i19 + 1] = f23 + f26;
                fArr2[i20] = f22 + f27;
                fArr2[i20 + 1] = f23 - f26;
                fArr2[i21] = f20 + f25;
                fArr2[i21 + 1] = f21 - f24;
            }
            return;
        }
        int i22 = 1;
        while (true) {
            int i23 = i22;
            if (i23 > i2) {
                return;
            }
            int i24 = (((i23 * 5) - 4) * i) + i3 + 1;
            int i25 = i4 + ((i23 - 1) * i);
            for (int i26 = 0; i26 < i - 1; i26 += 2) {
                int i27 = i26 + i24;
                int i28 = i27 + i;
                int i29 = i27 - i;
                int i30 = i28 + i;
                int i31 = i30 + i;
                float f28 = fArr[i27 - 1];
                float f29 = fArr[i27];
                float f30 = fArr[i28 - 1];
                float f31 = fArr[i28];
                float f32 = fArr[i29 - 1];
                float f33 = fArr[i29];
                float f34 = fArr[i30 - 1];
                float f35 = fArr[i30];
                float f36 = fArr[i31 - 1];
                float f37 = fArr[i31];
                float f38 = f29 - f37;
                float f39 = f29 + f37;
                float f40 = f31 - f35;
                float f41 = f31 + f35;
                float f42 = f28 - f36;
                float f43 = f28 + f36;
                float f44 = f30 - f34;
                float f45 = f30 + f34;
                float f46 = (0.309017f * f43) + f32 + ((-0.809017f) * f45);
                float f47 = (0.309017f * f39) + f33 + ((-0.809017f) * f41);
                float f48 = ((-0.809017f) * f43) + f32 + (0.309017f * f45);
                float f49 = ((-0.809017f) * f39) + f33 + (0.309017f * f41);
                float f50 = i6 * ((0.95105654f * f42) + (0.58778524f * f44));
                float f51 = i6 * ((0.95105654f * f38) + (0.58778524f * f40));
                float f52 = ((f42 * 0.58778524f) - (f44 * 0.95105654f)) * i6;
                float f53 = ((f38 * 0.58778524f) - (f40 * 0.95105654f)) * i6;
                float f54 = f48 - f53;
                float f55 = f53 + f48;
                float f56 = f49 + f52;
                float f57 = f49 - f52;
                float f58 = f46 + f51;
                float f59 = f46 - f51;
                float f60 = f47 - f50;
                float f61 = f47 + f50;
                int i32 = i26 + i5;
                int i33 = i26 + i7;
                int i34 = i26 + i8;
                int i35 = i26 + i9;
                float f62 = this.g[i32];
                float f63 = this.g[i32 + 1] * i6;
                float f64 = this.g[i33];
                float f65 = this.g[i33 + 1] * i6;
                float f66 = this.g[i34];
                float f67 = this.g[i34 + 1] * i6;
                float f68 = this.g[i35];
                float f69 = this.g[i35 + 1] * i6;
                int i36 = i26 + i25;
                int i37 = i36 + i10;
                int i38 = i37 + i10;
                int i39 = i38 + i10;
                int i40 = i39 + i10;
                fArr2[i36] = f43 + f32 + f45;
                fArr2[i36 + 1] = f39 + f33 + f41;
                fArr2[i37] = (f62 * f59) - (f63 * f61);
                fArr2[i37 + 1] = (f62 * f61) + (f63 * f59);
                fArr2[i38] = (f64 * f54) - (f65 * f56);
                fArr2[i38 + 1] = (f64 * f56) + (f65 * f54);
                fArr2[i39] = (f66 * f55) - (f67 * f57);
                fArr2[i39 + 1] = (f66 * f57) + (f67 * f55);
                fArr2[i40] = (f68 * f58) - (f69 * f60);
                fArr2[i40 + 1] = (f68 * f60) + (f69 * f58);
            }
            i22 = i23 + 1;
        }
    }
}
