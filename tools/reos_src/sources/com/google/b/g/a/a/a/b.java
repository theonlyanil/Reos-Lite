package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
final class b extends f {
    b(com.google.b.c.a aVar) {
        super(aVar);
    }

    @Override // com.google.b.g.a.a.a.i
    protected int a(int i) {
        return i < 10000 ? i : i - 10000;
    }

    @Override // com.google.b.g.a.a.a.i
    protected void a(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
