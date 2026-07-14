package d.a.a;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f6061d = new int[10];

    n a(int i, int i2, int i3) {
        if (i < this.f6061d.length) {
            int i4 = 1 << i;
            this.f6058a |= i4;
            if ((i2 & 1) != 0) {
                this.f6059b |= i4;
            } else {
                this.f6059b &= i4 ^ (-1);
            }
            if ((i2 & 2) != 0) {
                this.f6060c = i4 | this.f6060c;
            } else {
                this.f6060c = (i4 ^ (-1)) & this.f6060c;
            }
            this.f6061d[i] = i3;
        }
        return this;
    }

    void a() {
        this.f6060c = 0;
        this.f6059b = 0;
        this.f6058a = 0;
        Arrays.fill(this.f6061d, 0);
    }

    void a(n nVar) {
        for (int i = 0; i < 10; i++) {
            if (nVar.a(i)) {
                a(i, nVar.c(i), nVar.b(i));
            }
        }
    }

    boolean a(int i) {
        return ((1 << i) & this.f6058a) != 0;
    }

    int b() {
        return Integer.bitCount(this.f6058a);
    }

    int b(int i) {
        return this.f6061d[i];
    }

    int c() {
        if ((2 & this.f6058a) != 0) {
            return this.f6061d[1];
        }
        return -1;
    }

    int c(int i) {
        int i2 = h(i) ? 2 : 0;
        return g(i) ? i2 | 1 : i2;
    }

    int d(int i) {
        return (16 & this.f6058a) != 0 ? this.f6061d[4] : i;
    }

    int e(int i) {
        return (32 & this.f6058a) != 0 ? this.f6061d[5] : i;
    }

    int f(int i) {
        return (128 & this.f6058a) != 0 ? this.f6061d[7] : i;
    }

    boolean g(int i) {
        return ((1 << i) & this.f6059b) != 0;
    }

    boolean h(int i) {
        return ((1 << i) & this.f6060c) != 0;
    }
}
