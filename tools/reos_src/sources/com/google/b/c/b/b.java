package com.google.b.c.b;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f5448b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f5447a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f5448b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f5448b = new int[]{0};
        } else {
            this.f5448b = new int[length - i];
            System.arraycopy(iArr, i, this.f5448b, 0, this.f5448b.length);
        }
    }

    int a() {
        return this.f5448b.length - 1;
    }

    int a(int i) {
        return this.f5448b[(this.f5448b.length - 1) - i];
    }

    b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f5447a.a();
        }
        int length = this.f5448b.length;
        int[] iArr = new int[length + i];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f5447a.c(this.f5448b[i3], i2);
        }
        return new b(this.f5447a, iArr);
    }

    b a(b bVar) {
        if (!this.f5447a.equals(bVar.f5447a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (b()) {
            return bVar;
        }
        if (bVar.b()) {
            return this;
        }
        int[] iArr = this.f5448b;
        int[] iArr2 = bVar.f5448b;
        if (iArr.length <= iArr2.length) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = a.b(iArr2[i - length], iArr[i]);
        }
        return new b(this.f5447a, iArr3);
    }

    int b(int i) {
        int i2 = 0;
        if (i == 0) {
            return a(0);
        }
        int length = this.f5448b.length;
        if (i != 1) {
            int i3 = this.f5448b[0];
            int i4 = 1;
            while (i4 < length) {
                int iB = a.b(this.f5447a.c(i, i3), this.f5448b[i4]);
                i4++;
                i3 = iB;
            }
            return i3;
        }
        int[] iArr = this.f5448b;
        int length2 = iArr.length;
        int i5 = 0;
        while (i2 < length2) {
            int iB2 = a.b(i5, iArr[i2]);
            i2++;
            i5 = iB2;
        }
        return i5;
    }

    b b(b bVar) {
        if (!this.f5447a.equals(bVar.f5447a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (b() || bVar.b()) {
            return this.f5447a.a();
        }
        int[] iArr = this.f5448b;
        int length = iArr.length;
        int[] iArr2 = bVar.f5448b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                iArr3[i + i3] = a.b(iArr3[i + i3], this.f5447a.c(i2, iArr2[i3]));
            }
        }
        return new b(this.f5447a, iArr3);
    }

    boolean b() {
        return this.f5448b[0] == 0;
    }

    b c(int i) {
        if (i == 0) {
            return this.f5447a.a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f5448b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f5447a.c(this.f5448b[i2], i);
        }
        return new b(this.f5447a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int iA = a(); iA >= 0; iA--) {
            int iA2 = a(iA);
            if (iA2 != 0) {
                if (iA2 < 0) {
                    sb.append(" - ");
                    iA2 = -iA2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iA == 0 || iA2 != 1) {
                    int iB = this.f5447a.b(iA2);
                    if (iB == 0) {
                        sb.append('1');
                    } else if (iB == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iB);
                    }
                }
                if (iA != 0) {
                    if (iA == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iA);
                    }
                }
            }
        }
        return sb.toString();
    }
}
