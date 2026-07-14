package com.a.a.d.b.a;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f2049a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<C0039a, Bitmap> f2050b = new e<>();

    /* JADX INFO: renamed from: com.a.a.d.b.a.a$a, reason: collision with other inner class name */
    static class C0039a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f2051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap.Config f2054d;

        public C0039a(b bVar) {
            this.f2051a = bVar;
        }

        @Override // com.a.a.d.b.a.h
        public void a() {
            this.f2051a.a(this);
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.f2052b = i;
            this.f2053c = i2;
            this.f2054d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0039a)) {
                return false;
            }
            C0039a c0039a = (C0039a) obj;
            return this.f2052b == c0039a.f2052b && this.f2053c == c0039a.f2053c && this.f2054d == c0039a.f2054d;
        }

        public int hashCode() {
            return (this.f2054d != null ? this.f2054d.hashCode() : 0) + (((this.f2052b * 31) + this.f2053c) * 31);
        }

        public String toString() {
            return a.d(this.f2052b, this.f2053c, this.f2054d);
        }
    }

    static class b extends com.a.a.d.b.a.b<C0039a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.a.a.d.b.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0039a b() {
            return new C0039a(this);
        }

        public C0039a a(int i, int i2, Bitmap.Config config) {
            C0039a c0039aC = c();
            c0039aC.a(i, i2, config);
            return c0039aC;
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String d(Bitmap bitmap) {
        return d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.a.a.d.b.a.g
    public Bitmap a() {
        return this.f2050b.a();
    }

    @Override // com.a.a.d.b.a.g
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f2050b.a(this.f2049a.a(i, i2, config));
    }

    @Override // com.a.a.d.b.a.g
    public void a(Bitmap bitmap) {
        this.f2050b.a(this.f2049a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.a.a.d.b.a.g
    public String b(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }

    @Override // com.a.a.d.b.a.g
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.a.a.d.b.a.g
    public int c(Bitmap bitmap) {
        return com.a.a.j.h.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f2050b;
    }
}
