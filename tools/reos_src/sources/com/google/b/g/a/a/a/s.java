package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.a f5580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f5581b = new m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f5582c = new StringBuilder();

    s(com.google.b.c.a aVar) {
        this.f5580a = aVar;
    }

    static int a(com.google.b.c.a aVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private o a() throws com.google.b.f {
        l lVarB;
        boolean zB;
        do {
            int iA = this.f5581b.a();
            if (this.f5581b.b()) {
                lVarB = d();
                zB = lVarB.b();
            } else if (this.f5581b.c()) {
                lVarB = c();
                zB = lVarB.b();
            } else {
                lVarB = b();
                zB = lVarB.b();
            }
            if (!(iA != this.f5581b.a()) && !zB) {
                break;
            }
        } while (!zB);
        return lVarB.a();
    }

    private boolean a(int i) {
        if (i + 7 > this.f5580a.a()) {
            return i + 4 <= this.f5580a.a();
        }
        for (int i2 = i; i2 < i + 3; i2++) {
            if (this.f5580a.a(i2)) {
                return true;
            }
        }
        return this.f5580a.a(i + 3);
    }

    private l b() throws com.google.b.f {
        while (a(this.f5581b.a())) {
            p pVarB = b(this.f5581b.a());
            this.f5581b.a(pVarB.e());
            if (pVarB.c()) {
                return new l(pVarB.d() ? new o(this.f5581b.a(), this.f5582c.toString()) : new o(this.f5581b.a(), this.f5582c.toString(), pVarB.b()), true);
            }
            this.f5582c.append(pVarB.a());
            if (pVarB.d()) {
                return new l(new o(this.f5581b.a(), this.f5582c.toString()), true);
            }
            this.f5582c.append(pVarB.b());
        }
        if (i(this.f5581b.a())) {
            this.f5581b.e();
            this.f5581b.b(4);
        }
        return new l(false);
    }

    private p b(int i) throws com.google.b.f {
        if (i + 7 > this.f5580a.a()) {
            int iA = a(i, 4);
            return iA == 0 ? new p(this.f5580a.a(), 10, 10) : new p(this.f5580a.a(), iA - 1, 10);
        }
        int iA2 = a(i, 7);
        return new p(i + 7, (iA2 - 8) / 11, (iA2 - 8) % 11);
    }

    private l c() throws com.google.b.f {
        while (c(this.f5581b.a())) {
            n nVarD = d(this.f5581b.a());
            this.f5581b.a(nVarD.e());
            if (nVarD.b()) {
                return new l(new o(this.f5581b.a(), this.f5582c.toString()), true);
            }
            this.f5582c.append(nVarD.a());
        }
        if (h(this.f5581b.a())) {
            this.f5581b.b(3);
            this.f5581b.d();
        } else if (g(this.f5581b.a())) {
            if (this.f5581b.a() + 5 < this.f5580a.a()) {
                this.f5581b.b(5);
            } else {
                this.f5581b.a(this.f5580a.a());
            }
            this.f5581b.e();
        }
        return new l(false);
    }

    private boolean c(int i) {
        if (i + 5 > this.f5580a.a()) {
            return false;
        }
        int iA = a(i, 5);
        if (iA >= 5 && iA < 16) {
            return true;
        }
        if (i + 7 > this.f5580a.a()) {
            return false;
        }
        int iA2 = a(i, 7);
        if (iA2 >= 64 && iA2 < 116) {
            return true;
        }
        if (i + 8 > this.f5580a.a()) {
            return false;
        }
        int iA3 = a(i, 8);
        return iA3 >= 232 && iA3 < 253;
    }

    private l d() {
        while (e(this.f5581b.a())) {
            n nVarF = f(this.f5581b.a());
            this.f5581b.a(nVarF.e());
            if (nVarF.b()) {
                return new l(new o(this.f5581b.a(), this.f5582c.toString()), true);
            }
            this.f5582c.append(nVarF.a());
        }
        if (h(this.f5581b.a())) {
            this.f5581b.b(3);
            this.f5581b.d();
        } else if (g(this.f5581b.a())) {
            if (this.f5581b.a() + 5 < this.f5580a.a()) {
                this.f5581b.b(5);
            } else {
                this.f5581b.a(this.f5580a.a());
            }
            this.f5581b.f();
        }
        return new l(false);
    }

    private n d(int i) throws com.google.b.f {
        char c2;
        int iA = a(i, 5);
        if (iA == 15) {
            return new n(i + 5, '$');
        }
        if (iA >= 5 && iA < 15) {
            return new n(i + 5, (char) ((iA + 48) - 5));
        }
        int iA2 = a(i, 7);
        if (iA2 >= 64 && iA2 < 90) {
            return new n(i + 7, (char) (iA2 + 1));
        }
        if (iA2 >= 90 && iA2 < 116) {
            return new n(i + 7, (char) (iA2 + 7));
        }
        switch (a(i, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = '\"';
                break;
            case 234:
                c2 = '%';
                break;
            case 235:
                c2 = '&';
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case 250:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw com.google.b.f.a();
        }
        return new n(i + 8, c2);
    }

    private boolean e(int i) {
        if (i + 5 > this.f5580a.a()) {
            return false;
        }
        int iA = a(i, 5);
        if (iA >= 5 && iA < 16) {
            return true;
        }
        if (i + 6 > this.f5580a.a()) {
            return false;
        }
        int iA2 = a(i, 6);
        return iA2 >= 16 && iA2 < 63;
    }

    private n f(int i) {
        char c2;
        int iA = a(i, 5);
        if (iA == 15) {
            return new n(i + 5, '$');
        }
        if (iA >= 5 && iA < 15) {
            return new n(i + 5, (char) ((iA + 48) - 5));
        }
        int iA2 = a(i, 6);
        if (iA2 >= 32 && iA2 < 58) {
            return new n(i + 6, (char) (iA2 + 33));
        }
        switch (iA2) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iA2);
        }
        return new n(i + 6, c2);
    }

    private boolean g(int i) {
        if (i + 1 > this.f5580a.a()) {
            return false;
        }
        for (int i2 = 0; i2 < 5 && i2 + i < this.f5580a.a(); i2++) {
            if (i2 == 2) {
                if (!this.f5580a.a(i + 2)) {
                    return false;
                }
            } else if (this.f5580a.a(i + i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean h(int i) {
        if (i + 3 > this.f5580a.a()) {
            return false;
        }
        for (int i2 = i; i2 < i + 3; i2++) {
            if (this.f5580a.a(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean i(int i) {
        if (i + 1 > this.f5580a.a()) {
            return false;
        }
        for (int i2 = 0; i2 < 4 && i2 + i < this.f5580a.a(); i2++) {
            if (this.f5580a.a(i + i2)) {
                return false;
            }
        }
        return true;
    }

    int a(int i, int i2) {
        return a(this.f5580a, i, i2);
    }

    o a(int i, String str) throws com.google.b.f {
        this.f5582c.setLength(0);
        if (str != null) {
            this.f5582c.append(str);
        }
        this.f5581b.a(i);
        o oVarA = a();
        return (oVarA == null || !oVarA.b()) ? new o(this.f5581b.a(), this.f5582c.toString()) : new o(this.f5581b.a(), this.f5582c.toString(), oVarA.c());
    }

    String a(StringBuilder sb, int i) throws com.google.b.i, com.google.b.f {
        String strValueOf = null;
        while (true) {
            o oVarA = a(i, strValueOf);
            String strA = r.a(oVarA.a());
            if (strA != null) {
                sb.append(strA);
            }
            strValueOf = oVarA.b() ? String.valueOf(oVarA.c()) : null;
            if (i == oVarA.e()) {
                return sb.toString();
            }
            i = oVarA.e();
        }
    }
}
