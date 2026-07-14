package com.a.a.c;

import com.flurry.android.Constants;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2009a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2011c;
    int j;
    int k;
    int l;
    int p;
    private int r;
    private int s;
    private byte[] t;
    private int u;
    private int v;
    private int w;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2010b = 12;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2012d = 4096;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int[] f2013e = new int[5003];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int[] f2014f = new int[5003];
    int g = 5003;
    int h = 0;
    boolean i = false;
    int m = 0;
    int n = 0;
    int[] o = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, Place.TYPE_SUBLOCALITY_LEVEL_1, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] q = new byte[256];

    b(int i, int i2, byte[] bArr, int i3) {
        this.r = i;
        this.s = i2;
        this.t = bArr;
        this.u = Math.max(2, i3);
    }

    private int a() {
        if (this.v == 0) {
            return -1;
        }
        this.v--;
        byte[] bArr = this.t;
        int i = this.w;
        this.w = i + 1;
        return bArr[i] & Constants.UNKNOWN;
    }

    void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.q;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = b2;
        if (this.p >= 254) {
            c(outputStream);
        }
    }

    void a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f2013e[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.j = i;
        this.i = false;
        this.f2009a = this.j;
        this.f2011c = b(this.f2009a);
        this.k = 1 << (i - 1);
        this.l = this.k + 1;
        this.h = this.k + 2;
        this.p = 0;
        int iA = a();
        for (int i3 = this.g; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.g;
        a(i5);
        b(this.k, outputStream);
        while (true) {
            int iA2 = a();
            if (iA2 == -1) {
                b(iA, outputStream);
                b(this.l, outputStream);
                return;
            }
            int i6 = (iA2 << this.f2010b) + iA;
            int i7 = (iA2 << i4) ^ iA;
            if (this.f2013e[i7] == i6) {
                iA = this.f2014f[i7];
            } else {
                if (this.f2013e[i7] >= 0) {
                    int i8 = i5 - i7;
                    if (i7 == 0) {
                        i8 = 1;
                    }
                    while (true) {
                        i7 -= i8;
                        if (i7 < 0) {
                            i7 += i5;
                        }
                        if (this.f2013e[i7] == i6) {
                            iA = this.f2014f[i7];
                        } else if (this.f2013e[i7] < 0) {
                        }
                    }
                }
                b(iA, outputStream);
                if (this.h < this.f2012d) {
                    int[] iArr = this.f2014f;
                    int i9 = this.h;
                    this.h = i9 + 1;
                    iArr[i7] = i9;
                    this.f2013e[i7] = i6;
                    iA = iA2;
                } else {
                    a(outputStream);
                    iA = iA2;
                }
            }
        }
    }

    void a(OutputStream outputStream) throws IOException {
        a(this.g);
        this.h = this.k + 2;
        this.i = true;
        b(this.k, outputStream);
    }

    final int b(int i) {
        return (1 << i) - 1;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.m &= this.o[this.n];
        if (this.n > 0) {
            this.m |= i << this.n;
        } else {
            this.m = i;
        }
        this.n += this.f2009a;
        while (this.n >= 8) {
            a((byte) (this.m & 255), outputStream);
            this.m >>= 8;
            this.n -= 8;
        }
        if (this.h > this.f2011c || this.i) {
            if (this.i) {
                int i2 = this.j;
                this.f2009a = i2;
                this.f2011c = b(i2);
                this.i = false;
            } else {
                this.f2009a++;
                if (this.f2009a == this.f2010b) {
                    this.f2011c = this.f2012d;
                } else {
                    this.f2011c = b(this.f2009a);
                }
            }
        }
        if (i == this.l) {
            while (this.n > 0) {
                a((byte) (this.m & 255), outputStream);
                this.m >>= 8;
                this.n -= 8;
            }
            c(outputStream);
        }
    }

    void b(OutputStream outputStream) throws IOException {
        outputStream.write(this.u);
        this.v = this.r * this.s;
        this.w = 0;
        a(this.u + 1, outputStream);
        outputStream.write(0);
    }

    void c(OutputStream outputStream) throws IOException {
        if (this.p > 0) {
            outputStream.write(this.p);
            outputStream.write(this.q, 0, this.p);
            this.p = 0;
        }
    }
}
