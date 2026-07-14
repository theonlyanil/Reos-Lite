package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
final class d extends h {
    d(com.google.b.c.a aVar) {
        super(aVar);
    }

    @Override // com.google.b.g.a.a.a.j
    public String a() throws com.google.b.i, com.google.b.f {
        if (b().a() < 48) {
            throw com.google.b.i.a();
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        int iA = c().a(48, 2);
        sb.append("(393");
        sb.append(iA);
        sb.append(')');
        int iA2 = c().a(50, 10);
        if (iA2 / 100 == 0) {
            sb.append('0');
        }
        if (iA2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iA2);
        sb.append(c().a(60, (String) null).a());
        return sb.toString();
    }
}
