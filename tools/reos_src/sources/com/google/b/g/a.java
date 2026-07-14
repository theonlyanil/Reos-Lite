package com.google.b.g;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f5544a = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f5545b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f5546c = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StringBuilder f5547d = new StringBuilder(20);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f5548e = new int[80];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5549f = 0;

    private void a(com.google.b.c.a aVar) throws com.google.b.i {
        this.f5549f = 0;
        int iD = aVar.d(0);
        int iA = aVar.a();
        if (iD >= iA) {
            throw com.google.b.i.a();
        }
        boolean z = true;
        int i = 0;
        for (int i2 = iD; i2 < iA; i2++) {
            if (aVar.a(i2) ^ z) {
                i++;
            } else {
                b(i);
                z = !z;
                i = 1;
            }
        }
        b(i);
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr == null) {
            return false;
        }
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    private int b() throws com.google.b.i {
        for (int i = 1; i < this.f5549f; i += 2) {
            int iC = c(i);
            if (iC != -1 && a(f5546c, f5544a[iC])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.f5548e[i3];
                }
                if (i == 1 || this.f5548e[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw com.google.b.i.a();
    }

    private void b(int i) {
        this.f5548e[this.f5549f] = i;
        this.f5549f++;
        if (this.f5549f >= this.f5548e.length) {
            int[] iArr = new int[this.f5549f * 2];
            System.arraycopy(this.f5548e, 0, iArr, 0, this.f5549f);
            this.f5548e = iArr;
        }
    }

    private int c(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = i + 7;
        if (i3 >= this.f5549f) {
            return -1;
        }
        int[] iArr = this.f5548e;
        int i4 = i;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = iArr[i4];
            if (i7 < i5) {
                i5 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        int i8 = (i5 + i6) / 2;
        int i9 = i + 1;
        int i10 = 0;
        while (i9 < i3) {
            int i11 = iArr[i9];
            if (i11 < i2) {
                i2 = i11;
            }
            if (i11 <= i10) {
                i11 = i10;
            }
            i9 += 2;
            i10 = i11;
        }
        int i12 = (i2 + i10) / 2;
        int i13 = 0;
        int i14 = 0;
        int i15 = 128;
        while (i13 < 7) {
            i15 >>= 1;
            int i16 = iArr[i + i13] > ((i13 & 1) == 0 ? i8 : i12) ? i14 | i15 : i14;
            i13++;
            i14 = i16;
        }
        for (int i17 = 0; i17 < f5545b.length; i17++) {
            if (f5545b[i17] == i14) {
                return i17;
            }
        }
        return -1;
    }

    @Override // com.google.b.g.k
    public com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i {
        Arrays.fill(this.f5548e, 0);
        a(aVar);
        int iB = b();
        this.f5547d.setLength(0);
        int i2 = iB;
        do {
            int iC = c(i2);
            if (iC == -1) {
                throw com.google.b.i.a();
            }
            this.f5547d.append((char) iC);
            i2 += 8;
            if (this.f5547d.length() > 1 && a(f5546c, f5544a[iC])) {
                break;
            }
        } while (i2 < this.f5549f);
        int i3 = this.f5548e[i2 - 1];
        int i4 = 0;
        for (int i5 = -8; i5 < -1; i5++) {
            i4 += this.f5548e[i2 + i5];
        }
        if (i2 < this.f5549f && i3 < i4 / 2) {
            throw com.google.b.i.a();
        }
        a(iB);
        for (int i6 = 0; i6 < this.f5547d.length(); i6++) {
            this.f5547d.setCharAt(i6, f5544a[this.f5547d.charAt(i6)]);
        }
        if (!a(f5546c, this.f5547d.charAt(0))) {
            throw com.google.b.i.a();
        }
        if (!a(f5546c, this.f5547d.charAt(this.f5547d.length() - 1))) {
            throw com.google.b.i.a();
        }
        if (this.f5547d.length() <= 3) {
            throw com.google.b.i.a();
        }
        if (map == null || !map.containsKey(com.google.b.e.RETURN_CODABAR_START_END)) {
            this.f5547d.deleteCharAt(this.f5547d.length() - 1);
            this.f5547d.deleteCharAt(0);
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < iB) {
            int i9 = this.f5548e[i7] + i8;
            i7++;
            i8 = i9;
        }
        float f2 = i8;
        while (iB < i2 - 1) {
            i8 += this.f5548e[iB];
            iB++;
        }
        return new com.google.b.m(this.f5547d.toString(), null, new com.google.b.o[]{new com.google.b.o(f2, i), new com.google.b.o(i8, i)}, com.google.b.a.CODABAR);
    }

    void a(int i) throws com.google.b.i {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f5547d.length() - 1;
        int i2 = 0;
        int i3 = i;
        while (true) {
            int i4 = f5545b[this.f5547d.charAt(i2)];
            for (int i5 = 6; i5 >= 0; i5--) {
                int i6 = (i5 & 1) + ((i4 & 1) * 2);
                iArr[i6] = iArr[i6] + this.f5548e[i3 + i5];
                iArr2[i6] = iArr2[i6] + 1;
                i4 >>= 1;
            }
            if (i2 >= length) {
                break;
            }
            i3 += 8;
            i2++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i7 = 0; i7 < 2; i7++) {
            fArr2[i7] = 0.0f;
            fArr2[i7 + 2] = ((iArr[i7] / iArr2[i7]) + (iArr[i7 + 2] / iArr2[i7 + 2])) / 2.0f;
            fArr[i7] = fArr2[i7 + 2];
            fArr[i7 + 2] = ((iArr[i7 + 2] * 2.0f) + 1.5f) / iArr2[i7 + 2];
        }
        int i8 = 0;
        loop3: while (true) {
            int i9 = f5545b[this.f5547d.charAt(i8)];
            for (int i10 = 6; i10 >= 0; i10--) {
                int i11 = (i10 & 1) + ((i9 & 1) * 2);
                int i12 = this.f5548e[i + i10];
                if (i12 < fArr2[i11] || i12 > fArr[i11]) {
                    break loop3;
                }
                i9 >>= 1;
            }
            if (i8 >= length) {
                return;
            }
            i += 8;
            i8++;
        }
        throw com.google.b.i.a();
    }
}
