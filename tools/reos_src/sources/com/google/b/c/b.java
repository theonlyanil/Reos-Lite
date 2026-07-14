package com.google.b.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f5440d;

    public b(int i) {
        this(i, i);
    }

    public b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f5437a = i;
        this.f5438b = i2;
        this.f5439c = (i + 31) / 32;
        this.f5440d = new int[this.f5439c * i2];
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.f5437a = i;
        this.f5438b = i2;
        this.f5439c = i3;
        this.f5440d = iArr;
    }

    public a a(int i, a aVar) {
        if (aVar == null || aVar.a() < this.f5437a) {
            aVar = new a(this.f5437a);
        } else {
            aVar.b();
        }
        int i2 = i * this.f5439c;
        for (int i3 = 0; i3 < this.f5439c; i3++) {
            aVar.a(i3 * 32, this.f5440d[i2 + i3]);
        }
        return aVar;
    }

    public String a(String str, String str2) {
        return a(str, str2, System.lineSeparator());
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f5438b * (this.f5437a + 1));
        for (int i = 0; i < this.f5438b; i++) {
            for (int i2 = 0; i2 < this.f5437a; i2++) {
                sb.append(a(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void a() {
        int iE = e();
        int iF = f();
        a aVar = new a(iE);
        a aVar2 = new a(iE);
        for (int i = 0; i < (iF + 1) / 2; i++) {
            aVar = a(i, aVar);
            aVar2 = a((iF - 1) - i, aVar2);
            aVar.d();
            aVar2.d();
            b(i, aVar2);
            b((iF - 1) - i, aVar);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i + i3;
        int i6 = i2 + i4;
        if (i6 > this.f5438b || i5 > this.f5437a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = i2 * this.f5439c;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.f5440d;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public boolean a(int i, int i2) {
        return ((this.f5440d[(this.f5439c * i2) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void b(int i, int i2) {
        int i3 = (this.f5439c * i2) + (i / 32);
        int[] iArr = this.f5440d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void b(int i, a aVar) {
        System.arraycopy(aVar.c(), 0, this.f5440d, this.f5439c * i, this.f5439c);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    public int[] b() {
        int i;
        int i2 = this.f5437a;
        int i3 = this.f5438b;
        int i4 = i2;
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < this.f5438b; i7++) {
            int i8 = 0;
            while (i8 < this.f5439c) {
                int i9 = this.f5440d[(this.f5439c * i7) + i8];
                if (i9 != 0) {
                    if (i7 < i3) {
                        i3 = i7;
                    }
                    if (i7 > i6) {
                        i6 = i7;
                    }
                    if (i8 * 32 < i4) {
                        int i10 = 0;
                        while ((i9 << (31 - i10)) == 0) {
                            i10++;
                        }
                        if ((i8 * 32) + i10 < i4) {
                            i = (i8 * 32) + i10;
                        } else {
                            i = i4;
                        }
                    } else {
                        i = i4;
                    }
                    if ((i8 * 32) + 31 > i5) {
                        int i11 = 31;
                        while ((i9 >>> i11) == 0) {
                            i11--;
                        }
                        if ((i8 * 32) + i11 > i5) {
                            i5 = (i8 * 32) + i11;
                        }
                    }
                } else {
                    i = i4;
                }
                i8++;
                i6 = i6;
                i5 = i5;
                i3 = i3;
                i4 = i;
            }
        }
        int i12 = i5 - i4;
        int i13 = i6 - i3;
        if (i12 < 0 || i13 < 0) {
            return null;
        }
        return new int[]{i4, i3, i12, i13};
    }

    public void c(int i, int i2) {
        int i3 = (this.f5439c * i2) + (i / 32);
        int[] iArr = this.f5440d;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public int[] c() {
        int i = 0;
        while (i < this.f5440d.length && this.f5440d[i] == 0) {
            i++;
        }
        if (i == this.f5440d.length) {
            return null;
        }
        int i2 = i / this.f5439c;
        int i3 = (i % this.f5439c) * 32;
        int i4 = this.f5440d[i];
        int i5 = 0;
        while ((i4 << (31 - i5)) == 0) {
            i5++;
        }
        return new int[]{i3 + i5, i2};
    }

    public int[] d() {
        int length = this.f5440d.length - 1;
        while (length >= 0 && this.f5440d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.f5439c;
        int i2 = (length % this.f5439c) * 32;
        int i3 = this.f5440d[length];
        int i4 = 31;
        while ((i3 >>> i4) == 0) {
            i4--;
        }
        return new int[]{i2 + i4, i};
    }

    public int e() {
        return this.f5437a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5437a == bVar.f5437a && this.f5438b == bVar.f5438b && this.f5439c == bVar.f5439c && Arrays.equals(this.f5440d, bVar.f5440d);
    }

    public int f() {
        return this.f5438b;
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f5437a, this.f5438b, this.f5439c, (int[]) this.f5440d.clone());
    }

    public int hashCode() {
        return (((((((this.f5437a * 31) + this.f5437a) * 31) + this.f5438b) * 31) + this.f5439c) * 31) + Arrays.hashCode(this.f5440d);
    }

    public String toString() {
        return a("X ", "  ");
    }
}
