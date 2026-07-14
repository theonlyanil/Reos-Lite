package com.google.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class w<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t<T> f5279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k<T> f5280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f5281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.a.c.a<T> f5282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f5283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private x<T> f5284f;

    private static class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.a.c.a<?> f5285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<?> f5287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final t<?> f5288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final k<?> f5289e;

        a(Object obj, com.google.a.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f5288d = obj instanceof t ? (t) obj : null;
            this.f5289e = obj instanceof k ? (k) obj : null;
            com.google.a.b.a.a((this.f5288d == null && this.f5289e == null) ? false : true);
            this.f5285a = aVar;
            this.f5286b = z;
            this.f5287c = cls;
        }

        @Override // com.google.a.y
        public <T> x<T> a(f fVar, com.google.a.c.a<T> aVar) {
            boolean zIsAssignableFrom;
            if (this.f5285a != null) {
                zIsAssignableFrom = this.f5285a.equals(aVar) || (this.f5286b && this.f5285a.getType() == aVar.getRawType());
            } else {
                zIsAssignableFrom = this.f5287c.isAssignableFrom(aVar.getRawType());
            }
            if (zIsAssignableFrom) {
                return new w(this.f5288d, this.f5289e, fVar, aVar, this);
            }
            return null;
        }
    }

    w(t<T> tVar, k<T> kVar, f fVar, com.google.a.c.a<T> aVar, y yVar) {
        this.f5279a = tVar;
        this.f5280b = kVar;
        this.f5281c = fVar;
        this.f5282d = aVar;
        this.f5283e = yVar;
    }

    public static y a(com.google.a.c.a<?> aVar, Object obj) {
        return new a(obj, aVar, false, null);
    }

    private x<T> b() {
        x<T> xVar = this.f5284f;
        if (xVar != null) {
            return xVar;
        }
        x<T> xVarA = this.f5281c.a(this.f5283e, this.f5282d);
        this.f5284f = xVarA;
        return xVarA;
    }

    @Override // com.google.a.x
    public void a(com.google.a.d.c cVar, T t) throws IOException {
        if (this.f5279a == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.google.a.b.j.a(this.f5279a.a(t, this.f5282d.getType(), this.f5281c.f5253b), cVar);
        }
    }

    @Override // com.google.a.x
    public T b(com.google.a.d.a aVar) throws IOException {
        if (this.f5280b == null) {
            return b().b(aVar);
        }
        l lVarA = com.google.a.b.j.a(aVar);
        if (lVarA.j()) {
            return null;
        }
        return this.f5280b.b(lVarA, this.f5282d.getType(), this.f5281c.f5252a);
    }
}
