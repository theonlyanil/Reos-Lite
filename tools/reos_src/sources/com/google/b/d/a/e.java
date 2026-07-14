package com.google.b.d.a;

import com.google.b.f;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e[] f5501a = h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5506f;
    private final b g;
    private final int h;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5508b;

        private a(int i, int i2) {
            this.f5507a = i;
            this.f5508b = i2;
        }

        int a() {
            return this.f5507a;
        }

        int b() {
            return this.f5508b;
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a[] f5510b;

        private b(int i, a aVar) {
            this.f5509a = i;
            this.f5510b = new a[]{aVar};
        }

        private b(int i, a aVar, a aVar2) {
            this.f5509a = i;
            this.f5510b = new a[]{aVar, aVar2};
        }

        int a() {
            return this.f5509a;
        }

        a[] b() {
            return this.f5510b;
        }
    }

    private e(int i, int i2, int i3, int i4, int i5, b bVar) {
        this.f5502b = i;
        this.f5503c = i2;
        this.f5504d = i3;
        this.f5505e = i4;
        this.f5506f = i5;
        this.g = bVar;
        int iA = bVar.a();
        int iB = 0;
        for (a aVar : bVar.b()) {
            iB += (aVar.b() + iA) * aVar.a();
        }
        this.h = iB;
    }

    public static e a(int i, int i2) throws f {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw f.a();
        }
        for (e eVar : f5501a) {
            if (eVar.f5503c == i && eVar.f5504d == i2) {
                return eVar;
            }
        }
        throw f.a();
    }

    private static e[] h() {
        return new e[]{new e(1, 10, 10, 8, 8, new b(5, new a(1, 3))), new e(2, 12, 12, 10, 10, new b(7, new a(1, 5))), new e(3, 14, 14, 12, 12, new b(10, new a(1, 8))), new e(4, 16, 16, 14, 14, new b(12, new a(1, 12))), new e(5, 18, 18, 16, 16, new b(14, new a(1, 18))), new e(6, 20, 20, 18, 18, new b(18, new a(1, 22))), new e(7, 22, 22, 20, 20, new b(20, new a(1, 30))), new e(8, 24, 24, 22, 22, new b(24, new a(1, 36))), new e(9, 26, 26, 24, 24, new b(28, new a(1, 44))), new e(10, 32, 32, 14, 14, new b(36, new a(1, 62))), new e(11, 36, 36, 16, 16, new b(42, new a(1, 86))), new e(12, 40, 40, 18, 18, new b(48, new a(1, 114))), new e(13, 44, 44, 20, 20, new b(56, new a(1, 144))), new e(14, 48, 48, 22, 22, new b(68, new a(1, 174))), new e(15, 52, 52, 24, 24, new b(42, new a(2, 102))), new e(16, 64, 64, 14, 14, new b(56, new a(2, 140))), new e(17, 72, 72, 16, 16, new b(36, new a(4, 92))), new e(18, 80, 80, 18, 18, new b(48, new a(4, 114))), new e(19, 88, 88, 20, 20, new b(56, new a(4, 144))), new e(20, 96, 96, 22, 22, new b(68, new a(4, 174))), new e(21, 104, 104, 24, 24, new b(56, new a(6, 136))), new e(22, 120, 120, 18, 18, new b(68, new a(6, 175))), new e(23, 132, 132, 20, 20, new b(62, new a(8, 163))), new e(24, 144, 144, 22, 22, new b(62, new a(8, 156), new a(2, 155))), new e(25, 8, 18, 6, 16, new b(7, new a(1, 5))), new e(26, 8, 32, 6, 14, new b(11, new a(1, 10))), new e(27, 12, 26, 10, 24, new b(14, new a(1, 16))), new e(28, 12, 36, 10, 16, new b(18, new a(1, 22))), new e(29, 16, 36, 14, 16, new b(24, new a(1, 32))), new e(30, 16, 48, 14, 22, new b(28, new a(1, 49)))};
    }

    public int a() {
        return this.f5502b;
    }

    public int b() {
        return this.f5503c;
    }

    public int c() {
        return this.f5504d;
    }

    public int d() {
        return this.f5505e;
    }

    public int e() {
        return this.f5506f;
    }

    public int f() {
        return this.h;
    }

    b g() {
        return this.g;
    }

    public String toString() {
        return String.valueOf(this.f5502b);
    }
}
