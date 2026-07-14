package com.a.a.d.d.d;

import com.a.a.d.c.l;

/* JADX INFO: loaded from: classes.dex */
class g implements l<com.a.a.b.a, com.a.a.b.a> {

    private static class a implements com.a.a.d.a.c<com.a.a.b.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.a.a.b.a f2316a;

        public a(com.a.a.b.a aVar) {
            this.f2316a = aVar;
        }

        @Override // com.a.a.d.a.c
        public void a() {
        }

        @Override // com.a.a.d.a.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.a.a.b.a a(com.a.a.i iVar) {
            return this.f2316a;
        }

        @Override // com.a.a.d.a.c
        public String b() {
            return String.valueOf(this.f2316a.d());
        }

        @Override // com.a.a.d.a.c
        public void c() {
        }
    }

    g() {
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<com.a.a.b.a> a(com.a.a.b.a aVar, int i, int i2) {
        return new a(aVar);
    }
}
