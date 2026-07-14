package com.google.b.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f5429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5430b;

    public a() {
        this.f5430b = 0;
        this.f5429a = new int[1];
    }

    public a(int i) {
        this.f5430b = i;
        this.f5429a = e(i);
    }

    a(int[] iArr, int i) {
        this.f5429a = iArr;
        this.f5430b = i;
    }

    private static int[] e(int i) {
        return new int[(i + 31) / 32];
    }

    public int a() {
        return this.f5430b;
    }

    public void a(int i, int i2) {
        this.f5429a[i / 32] = i2;
    }

    public boolean a(int i) {
        return (this.f5429a[i / 32] & (1 << (i & 31))) != 0;
    }

    public boolean a(int i, int i2, boolean z) {
        int i3;
        if (i2 < i) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return true;
        }
        int i4 = i2 - 1;
        int i5 = i / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = i7 > i5 ? 0 : i & 31;
            int i9 = i7 < i6 ? 31 : i4 & 31;
            if (i8 == 0 && i9 == 31) {
                i3 = -1;
            } else {
                int i10 = i8;
                i3 = 0;
                while (i10 <= i9) {
                    int i11 = (1 << i10) | i3;
                    i10++;
                    i3 = i11;
                }
            }
            int i12 = this.f5429a[i7] & i3;
            if (!z) {
                i3 = 0;
            }
            if (i12 != i3) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void b() {
        int length = this.f5429a.length;
        for (int i = 0; i < length; i++) {
            this.f5429a[i] = 0;
        }
    }

    public void b(int i) {
        int[] iArr = this.f5429a;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] | (1 << (i & 31));
    }

    public int c(int i) {
        if (i >= this.f5430b) {
            return this.f5430b;
        }
        int i2 = i / 32;
        int i3 = this.f5429a[i2] & (((1 << (i & 31)) - 1) ^ (-1));
        while (i3 == 0) {
            i2++;
            if (i2 == this.f5429a.length) {
                return this.f5430b;
            }
            i3 = this.f5429a[i2];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        return iNumberOfTrailingZeros > this.f5430b ? this.f5430b : iNumberOfTrailingZeros;
    }

    public int[] c() {
        return this.f5429a;
    }

    public int d(int i) {
        if (i >= this.f5430b) {
            return this.f5430b;
        }
        int i2 = i / 32;
        int i3 = (this.f5429a[i2] ^ (-1)) & (((1 << (i & 31)) - 1) ^ (-1));
        while (i3 == 0) {
            i2++;
            if (i2 == this.f5429a.length) {
                return this.f5430b;
            }
            i3 = this.f5429a[i2] ^ (-1);
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        return iNumberOfTrailingZeros > this.f5430b ? this.f5430b : iNumberOfTrailingZeros;
    }

    public void d() {
        int[] iArr = new int[this.f5429a.length];
        int i = (this.f5430b - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = this.f5429a[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        if (this.f5430b != i2 * 32) {
            int i4 = (i2 * 32) - this.f5430b;
            int i5 = 1;
            for (int i6 = 0; i6 < 31 - i4; i6++) {
                i5 = (i5 << 1) | 1;
            }
            int i7 = (iArr[0] >> i4) & i5;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i4));
                i7 = (i9 >> i4) & i5;
            }
            iArr[i2 - 1] = i7;
        }
        this.f5429a = iArr;
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f5429a.clone(), this.f5430b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5430b == aVar.f5430b && Arrays.equals(this.f5429a, aVar.f5429a);
    }

    public int hashCode() {
        return (this.f5430b * 31) + Arrays.hashCode(this.f5429a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f5430b);
        for (int i = 0; i < this.f5430b; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i) ? 'X' : '.');
        }
        return sb.toString();
    }
}
