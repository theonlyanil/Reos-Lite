package com.google.b.g;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f5633a = new e();

    private static com.google.b.m a(com.google.b.m mVar) throws com.google.b.f {
        String strA = mVar.a();
        if (strA.charAt(0) == '0') {
            return new com.google.b.m(strA.substring(1), null, mVar.c(), com.google.b.a.UPC_A);
        }
        throw com.google.b.f.a();
    }

    @Override // com.google.b.g.p
    protected int a(com.google.b.c.a aVar, int[] iArr, StringBuilder sb) throws com.google.b.i {
        return this.f5633a.a(aVar, iArr, sb);
    }

    @Override // com.google.b.g.p, com.google.b.g.k
    public com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f, com.google.b.d {
        return a(this.f5633a.a(i, aVar, map));
    }

    @Override // com.google.b.g.p
    public com.google.b.m a(int i, com.google.b.c.a aVar, int[] iArr, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f, com.google.b.d {
        return a(this.f5633a.a(i, aVar, iArr, map));
    }

    @Override // com.google.b.g.k, com.google.b.k
    public com.google.b.m a(com.google.b.c cVar) throws com.google.b.i, com.google.b.f {
        return a(this.f5633a.a(cVar));
    }

    @Override // com.google.b.g.k, com.google.b.k
    public com.google.b.m a(com.google.b.c cVar, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f {
        return a(this.f5633a.a(cVar, map));
    }

    @Override // com.google.b.g.p
    com.google.b.a b() {
        return com.google.b.a.UPC_A;
    }
}
