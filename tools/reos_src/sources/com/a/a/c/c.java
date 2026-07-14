package com.a.a.c;

import com.flurry.android.Constants;
import com.google.android.gms.location.places.Place;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f2015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected byte[] f2016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f2017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f2018d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int[] f2020f = new int[256];
    protected int[] g = new int[256];
    protected int[] h = new int[256];
    protected int[] i = new int[32];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int[][] f2019e = new int[256][];

    public c(byte[] bArr, int i, int i2) {
        this.f2016b = bArr;
        this.f2017c = i;
        this.f2018d = i2;
        for (int i3 = 0; i3 < 256; i3++) {
            this.f2019e[i3] = new int[4];
            int[] iArr = this.f2019e[i3];
            int i4 = (i3 << 12) / 256;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.h[i3] = 256;
            this.g[i3] = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    public int a(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = this.f2020f[i2];
        int i7 = -1;
        int i8 = 1000;
        int i9 = i6 - 1;
        int i10 = i6;
        while (true) {
            if (i10 >= 256 && i9 < 0) {
                return i7;
            }
            if (i10 < 256) {
                int[] iArr = this.f2019e[i10];
                int i11 = iArr[1] - i2;
                if (i11 >= i8) {
                    i4 = i8;
                    i10 = 256;
                    i5 = i7;
                } else {
                    i10++;
                    if (i11 < 0) {
                        i11 = -i11;
                    }
                    int i12 = iArr[0] - i;
                    if (i12 < 0) {
                        i12 = -i12;
                    }
                    int i13 = i12 + i11;
                    if (i13 >= i8) {
                        i4 = i8;
                        i5 = i7;
                    } else {
                        int i14 = iArr[2] - i3;
                        if (i14 < 0) {
                            i14 = -i14;
                        }
                        i4 = i13 + i14;
                        if (i4 < i8) {
                            i5 = iArr[3];
                        } else {
                            i4 = i8;
                            i5 = i7;
                        }
                    }
                }
            } else {
                i10 = i10;
                i4 = i8;
                i5 = i7;
            }
            if (i9 >= 0) {
                int[] iArr2 = this.f2019e[i9];
                int i15 = i2 - iArr2[1];
                if (i15 >= i4) {
                    i7 = i5;
                    i9 = -1;
                    i8 = i4;
                } else {
                    i9--;
                    if (i15 < 0) {
                        i15 = -i15;
                    }
                    int i16 = iArr2[0] - i;
                    if (i16 < 0) {
                        i16 = -i16;
                    }
                    int i17 = i16 + i15;
                    if (i17 < i4) {
                        int i18 = iArr2[2] - i3;
                        if (i18 < 0) {
                            i18 = -i18;
                        }
                        int i19 = i18 + i17;
                        if (i19 < i4) {
                            i7 = iArr2[3];
                            i8 = i19;
                        }
                    }
                }
            }
            i7 = i5;
            i8 = i4;
        }
    }

    protected void a(int i, int i2, int i3, int i4, int i5) {
        int i6 = i2 - i;
        int i7 = i6 < -1 ? -1 : i6;
        int i8 = i2 + i;
        if (i8 > 256) {
            i8 = 256;
        }
        int i9 = 1;
        int i10 = i2 - 1;
        int i11 = i2 + 1;
        while (true) {
            if (i11 >= i8 && i10 <= i7) {
                return;
            }
            i9++;
            int i12 = this.i[i9];
            if (i11 < i8) {
                i11++;
                int[] iArr = this.f2019e[i11];
                try {
                    iArr[0] = iArr[0] - (((iArr[0] - i3) * i12) / 262144);
                    iArr[1] = iArr[1] - (((iArr[1] - i4) * i12) / 262144);
                    iArr[2] = iArr[2] - (((iArr[2] - i5) * i12) / 262144);
                } catch (Exception e2) {
                }
            } else {
                i11 = i11;
            }
            if (i10 > i7) {
                int i13 = i10 - 1;
                int[] iArr2 = this.f2019e[i10];
                try {
                    iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i12) / 262144);
                    iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i12) / 262144);
                    iArr2[2] = iArr2[2] - ((i12 * (iArr2[2] - i5)) / 262144);
                    i10 = i13;
                } catch (Exception e3) {
                    i10 = i13;
                }
            }
        }
    }

    public byte[] a() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[this.f2019e[i][3]] = i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = iArr[i3];
            int i5 = i2 + 1;
            bArr[i2] = (byte) this.f2019e[i4][0];
            int i6 = i5 + 1;
            bArr[i5] = (byte) this.f2019e[i4][1];
            i2 = i6 + 1;
            bArr[i6] = (byte) this.f2019e[i4][2];
        }
        return bArr;
    }

    protected int b(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = Integer.MAX_VALUE;
        int i8 = -1;
        int i9 = Integer.MAX_VALUE;
        int i10 = -1;
        int i11 = 0;
        while (i11 < 256) {
            int[] iArr = this.f2019e[i11];
            int i12 = iArr[0] - i;
            if (i12 < 0) {
                i12 = -i12;
            }
            int i13 = iArr[1] - i2;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = i13 + i12;
            int i15 = iArr[2] - i3;
            if (i15 < 0) {
                i15 = -i15;
            }
            int i16 = i14 + i15;
            if (i16 < i9) {
                i4 = i16;
                i5 = i11;
            } else {
                i4 = i9;
                i5 = i10;
            }
            int i17 = i16 - (this.g[i11] >> 12);
            if (i17 < i7) {
                i6 = i11;
            } else {
                i17 = i7;
                i6 = i8;
            }
            int i18 = this.h[i11] >> 10;
            int[] iArr2 = this.h;
            iArr2[i11] = iArr2[i11] - i18;
            int[] iArr3 = this.g;
            iArr3[i11] = (i18 << 10) + iArr3[i11];
            i11++;
            i7 = i17;
            i8 = i6;
            i10 = i5;
            i9 = i4;
        }
        int[] iArr4 = this.h;
        iArr4[i10] = iArr4[i10] + 64;
        int[] iArr5 = this.g;
        iArr5[i10] = iArr5[i10] - 65536;
        return i8;
    }

    public void b() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i5 < 256) {
            int[] iArr = this.f2019e[i5];
            int i6 = iArr[1];
            int i7 = i5;
            for (int i8 = i5 + 1; i8 < 256; i8++) {
                int[] iArr2 = this.f2019e[i8];
                if (iArr2[1] < i6) {
                    i6 = iArr2[1];
                    i7 = i8;
                }
            }
            int[] iArr3 = this.f2019e[i7];
            if (i5 != i7) {
                int i9 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i9;
                int i10 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i10;
                int i11 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i11;
                int i12 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i12;
            }
            if (i6 != i4) {
                this.f2020f[i4] = (i3 + i5) >> 1;
                for (int i13 = i4 + 1; i13 < i6; i13++) {
                    this.f2020f[i13] = i5;
                }
                i2 = i6;
                i = i5;
            } else {
                i = i3;
                i2 = i4;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        this.f2020f[i4] = (i3 + 255) >> 1;
        for (int i14 = i4 + 1; i14 < 256; i14++) {
            this.f2020f[i14] = 255;
        }
    }

    protected void b(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.f2019e[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / Place.TYPE_SUBLOCALITY_LEVEL_2);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / Place.TYPE_SUBLOCALITY_LEVEL_2);
        iArr[2] = iArr[2] - (((iArr[2] - i5) * i) / Place.TYPE_SUBLOCALITY_LEVEL_2);
    }

    public void c() {
        int i;
        if (this.f2017c < 1509) {
            this.f2018d = 1;
        }
        this.f2015a = ((this.f2018d - 1) / 3) + 30;
        byte[] bArr = this.f2016b;
        int i2 = this.f2017c;
        int i3 = this.f2017c / (this.f2018d * 3);
        int i4 = i3 / 100;
        for (int i5 = 0; i5 < 32; i5++) {
            this.i[i5] = (((1024 - (i5 * i5)) * 256) / Place.TYPE_SUBLOCALITY_LEVEL_2) * Place.TYPE_SUBLOCALITY_LEVEL_2;
        }
        if (this.f2017c < 1509) {
            i = 3;
        } else if (this.f2017c % 499 != 0) {
            i = 1497;
        } else if (this.f2017c % 491 != 0) {
            i = 1473;
        } else {
            i = this.f2017c % 487 != 0 ? 1461 : 1509;
        }
        int i6 = 0;
        int i7 = 32;
        int i8 = 2048;
        int i9 = 0;
        int i10 = 1024;
        while (i9 < i3) {
            int i11 = (bArr[i6 + 0] & Constants.UNKNOWN) << 4;
            int i12 = (bArr[i6 + 1] & Constants.UNKNOWN) << 4;
            int i13 = (bArr[i6 + 2] & Constants.UNKNOWN) << 4;
            int iB = b(i11, i12, i13);
            b(i10, iB, i11, i12, i13);
            if (i7 != 0) {
                a(i7, iB, i11, i12, i13);
            }
            int i14 = i6 + i;
            i6 = i14 >= i2 ? i14 - this.f2017c : i14;
            i9++;
            i4 = i4 == 0 ? 1 : i4;
            if (i9 % i4 == 0) {
                int i15 = i10 - (i10 / this.f2015a);
                int i16 = i8 - (i8 / 30);
                int i17 = i16 >> 6;
                if (i17 <= 1) {
                    i17 = 0;
                }
                for (int i18 = 0; i18 < i17; i18++) {
                    this.i[i18] = ((((i17 * i17) - (i18 * i18)) * 256) / (i17 * i17)) * i15;
                }
                i7 = i17;
                i8 = i16;
                i10 = i15;
            }
        }
    }

    public byte[] d() {
        c();
        e();
        b();
        return a();
    }

    public void e() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.f2019e[i];
            iArr[0] = iArr[0] >> 4;
            int[] iArr2 = this.f2019e[i];
            iArr2[1] = iArr2[1] >> 4;
            int[] iArr3 = this.f2019e[i];
            iArr3[2] = iArr3[2] >> 4;
            this.f2019e[i][3] = i;
        }
    }
}
