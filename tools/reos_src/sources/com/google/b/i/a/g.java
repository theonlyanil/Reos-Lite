package com.google.b.i.a;

/* JADX INFO: loaded from: classes.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[][] f5729a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f5730b = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f5731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte f5732d;

    private g(int i) {
        this.f5731c = f.a((i >> 3) & 3);
        this.f5732d = (byte) (i & 7);
    }

    static int a(int i, int i2) {
        int i3 = i ^ i2;
        return f5730b[(i3 >>> 28) & 15] + f5730b[i3 & 15] + f5730b[(i3 >>> 4) & 15] + f5730b[(i3 >>> 8) & 15] + f5730b[(i3 >>> 12) & 15] + f5730b[(i3 >>> 16) & 15] + f5730b[(i3 >>> 20) & 15] + f5730b[(i3 >>> 24) & 15];
    }

    static g b(int i, int i2) {
        g gVarC = c(i, i2);
        return gVarC != null ? gVarC : c(i ^ 21522, i2 ^ 21522);
    }

    private static g c(int i, int i2) {
        int i3;
        int iA;
        int i4 = Integer.MAX_VALUE;
        int[][] iArr = f5729a;
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr2 = iArr[i5];
            int i7 = iArr2[0];
            if (i7 == i || i7 == i2) {
                return new g(iArr2[1]);
            }
            int iA2 = a(i, i7);
            if (iA2 < i4) {
                i3 = iArr2[1];
            } else {
                iA2 = i4;
                i3 = i6;
            }
            if (i == i2 || (iA = a(i2, i7)) >= iA2) {
                iA = iA2;
            } else {
                i3 = iArr2[1];
            }
            i5++;
            int i8 = i3;
            i4 = iA;
            i6 = i8;
        }
        if (i4 <= 3) {
            return new g(i6);
        }
        return null;
    }

    f a() {
        return this.f5731c;
    }

    byte b() {
        return this.f5732d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f5731c == gVar.f5731c && this.f5732d == gVar.f5732d;
    }

    public int hashCode() {
        return (this.f5731c.ordinal() << 3) | this.f5732d;
    }
}
