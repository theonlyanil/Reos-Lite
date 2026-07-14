package com.google.b.h.a.a;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f5668b;

    c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f5667a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f5668b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f5668b = new int[]{0};
        } else {
            this.f5668b = new int[length - i];
            System.arraycopy(iArr, i, this.f5668b, 0, this.f5668b.length);
        }
    }

    int a() {
        return this.f5668b.length - 1;
    }

    int a(int i) {
        return this.f5668b[(this.f5668b.length - 1) - i];
    }

    c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f5667a.a();
        }
        int length = this.f5668b.length;
        int[] iArr = new int[length + i];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f5667a.d(this.f5668b[i3], i2);
        }
        return new c(this.f5667a, iArr);
    }

    c a(c cVar) {
        if (!this.f5667a.equals(cVar.f5667a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (b()) {
            return cVar;
        }
        if (cVar.b()) {
            return this;
        }
        int[] iArr = this.f5668b;
        int[] iArr2 = cVar.f5668b;
        if (iArr.length <= iArr2.length) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.f5667a.b(iArr2[i - length], iArr[i]);
        }
        return new c(this.f5667a, iArr3);
    }

    int b(int i) {
        int i2 = 0;
        if (i == 0) {
            return a(0);
        }
        int length = this.f5668b.length;
        if (i != 1) {
            int i3 = this.f5668b[0];
            int i4 = 1;
            while (i4 < length) {
                int iB = this.f5667a.b(this.f5667a.d(i, i3), this.f5668b[i4]);
                i4++;
                i3 = iB;
            }
            return i3;
        }
        int[] iArr = this.f5668b;
        int length2 = iArr.length;
        int i5 = 0;
        while (i2 < length2) {
            int iB2 = this.f5667a.b(i5, iArr[i2]);
            i2++;
            i5 = iB2;
        }
        return i5;
    }

    c b(c cVar) {
        if (this.f5667a.equals(cVar.f5667a)) {
            return cVar.b() ? this : a(cVar.c());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    boolean b() {
        return this.f5668b[0] == 0;
    }

    c c() {
        int length = this.f5668b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f5667a.c(0, this.f5668b[i]);
        }
        return new c(this.f5667a, iArr);
    }

    c c(int i) {
        if (i == 0) {
            return this.f5667a.a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f5668b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f5667a.d(this.f5668b[i2], i);
        }
        return new c(this.f5667a, iArr);
    }

    c c(c cVar) {
        if (!this.f5667a.equals(cVar.f5667a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (b() || cVar.b()) {
            return this.f5667a.a();
        }
        int[] iArr = this.f5668b;
        int length = iArr.length;
        int[] iArr2 = cVar.f5668b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                iArr3[i + i3] = this.f5667a.b(iArr3[i + i3], this.f5667a.d(i2, iArr2[i3]));
            }
        }
        return new c(this.f5667a, iArr3);
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
                    sb.append(iA2);
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
