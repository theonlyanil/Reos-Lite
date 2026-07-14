package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
final class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5557b;

    e(com.google.b.c.a aVar, String str, String str2) {
        super(aVar);
        this.f5556a = str2;
        this.f5557b = str;
    }

    private void c(StringBuilder sb, int i) {
        int iA = c().a(i, 16);
        if (iA == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f5556a);
        sb.append(')');
        int i2 = iA % 32;
        int i3 = iA / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }

    @Override // com.google.b.g.a.a.a.i
    protected int a(int i) {
        return i % 100000;
    }

    @Override // com.google.b.g.a.a.a.j
    public String a() throws com.google.b.i {
        if (b().a() != 84) {
            throw com.google.b.i.a();
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        b(sb, 48, 20);
        c(sb, 68);
        return sb.toString();
    }

    @Override // com.google.b.g.a.a.a.i
    protected void a(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.f5557b);
        sb.append(i / 100000);
        sb.append(')');
    }
}
