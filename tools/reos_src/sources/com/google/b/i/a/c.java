package com.google.b.i.a;

/* JADX INFO: loaded from: classes.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c[] f5720a;

    private static final class a extends c {
        private a() {
            super();
        }

        @Override // com.google.b.i.a.c
        boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    private static final class b extends c {
        private b() {
            super();
        }

        @Override // com.google.b.i.a.c
        boolean a(int i, int i2) {
            return (i & 1) == 0;
        }
    }

    /* JADX INFO: renamed from: com.google.b.i.a.c$c, reason: collision with other inner class name */
    private static final class C0203c extends c {
        private C0203c() {
            super();
        }

        @Override // com.google.b.i.a.c
        boolean a(int i, int i2) {
            return i2 % 3 == 0;
        }
    }

    private static final class d extends c {
        private d() {
            super();
        }

        @Override // com.google.b.i.a.c
        boolean a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    }

    private static final class e extends c {
        private e() {
            super();
        }

        @Override // com.google.b.i.a.c
        boolean a(int i, int i2) {
            return (((i / 2) + (i2 / 3)) & 1) == 0;
        }
    }

    private static final class f extends c {
        private f() {
            super();
        }

        @Override // com.google.b.i.a.c
        boolean a(int i, int i2) {
            int i3 = i * i2;
            return (i3 % 3) + (i3 & 1) == 0;
        }
    }

    private static final class g extends c {
        private g() {
            super();
        }

        @Override // com.google.b.i.a.c
        boolean a(int i, int i2) {
            int i3 = i * i2;
            return (((i3 % 3) + (i3 & 1)) & 1) == 0;
        }
    }

    private static final class h extends c {
        private h() {
            super();
        }

        @Override // com.google.b.i.a.c
        boolean a(int i, int i2) {
            return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
        }
    }

    static {
        f5720a = new c[]{new a(), new b(), new C0203c(), new d(), new e(), new f(), new g(), new h()};
    }

    private c() {
    }

    static c a(int i) {
        if (i < 0 || i > 7) {
            throw new IllegalArgumentException();
        }
        return f5720a[i];
    }

    final void a(com.google.b.c.b bVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (a(i2, i3)) {
                    bVar.c(i3, i2);
                }
            }
        }
    }

    abstract boolean a(int i, int i2);
}
