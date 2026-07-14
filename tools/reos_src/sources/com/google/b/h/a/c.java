package com.google.b.h.a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.b.o;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.b.c.b f5670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o f5671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private o f5672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o f5673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private o f5674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5675f;
    private int g;
    private int h;
    private int i;

    c(com.google.b.c.b bVar, o oVar, o oVar2, o oVar3, o oVar4) throws com.google.b.i {
        if ((oVar == null && oVar3 == null) || ((oVar2 == null && oVar4 == null) || ((oVar != null && oVar2 == null) || (oVar3 != null && oVar4 == null)))) {
            throw com.google.b.i.a();
        }
        a(bVar, oVar, oVar2, oVar3, oVar4);
    }

    c(c cVar) {
        a(cVar.f5670a, cVar.f5671b, cVar.f5672c, cVar.f5673d, cVar.f5674e);
    }

    static c a(c cVar, c cVar2) throws com.google.b.i {
        if (cVar == null) {
            return cVar2;
        }
        return cVar2 == null ? cVar : new c(cVar.f5670a, cVar.f5671b, cVar.f5672c, cVar2.f5673d, cVar2.f5674e);
    }

    private void a(com.google.b.c.b bVar, o oVar, o oVar2, o oVar3, o oVar4) {
        this.f5670a = bVar;
        this.f5671b = oVar;
        this.f5672c = oVar2;
        this.f5673d = oVar3;
        this.f5674e = oVar4;
        i();
    }

    private void i() {
        if (this.f5671b == null) {
            this.f5671b = new o(BitmapDescriptorFactory.HUE_RED, this.f5673d.b());
            this.f5672c = new o(BitmapDescriptorFactory.HUE_RED, this.f5674e.b());
        } else if (this.f5673d == null) {
            this.f5673d = new o(this.f5670a.e() - 1, this.f5671b.b());
            this.f5674e = new o(this.f5670a.e() - 1, this.f5672c.b());
        }
        this.f5675f = (int) Math.min(this.f5671b.a(), this.f5672c.a());
        this.g = (int) Math.max(this.f5673d.a(), this.f5674e.a());
        this.h = (int) Math.min(this.f5671b.b(), this.f5673d.b());
        this.i = (int) Math.max(this.f5672c.b(), this.f5674e.b());
    }

    int a() {
        return this.f5675f;
    }

    c a(int i, int i2, boolean z) throws com.google.b.i {
        o oVar;
        o oVar2;
        o oVar3 = this.f5671b;
        o oVar4 = this.f5672c;
        o oVar5 = this.f5673d;
        o oVar6 = this.f5674e;
        if (i > 0) {
            o oVar7 = z ? this.f5671b : this.f5673d;
            int iB = ((int) oVar7.b()) - i;
            if (iB < 0) {
                iB = 0;
            }
            oVar = new o(oVar7.a(), iB);
            if (!z) {
                oVar5 = oVar;
                oVar = oVar3;
            }
        } else {
            oVar = oVar3;
        }
        if (i2 > 0) {
            o oVar8 = z ? this.f5672c : this.f5674e;
            int iB2 = ((int) oVar8.b()) + i2;
            if (iB2 >= this.f5670a.f()) {
                iB2 = this.f5670a.f() - 1;
            }
            oVar2 = new o(oVar8.a(), iB2);
            if (!z) {
                oVar6 = oVar2;
                oVar2 = oVar4;
            }
        } else {
            oVar2 = oVar4;
        }
        i();
        return new c(this.f5670a, oVar, oVar2, oVar5, oVar6);
    }

    int b() {
        return this.g;
    }

    int c() {
        return this.h;
    }

    int d() {
        return this.i;
    }

    o e() {
        return this.f5671b;
    }

    o f() {
        return this.f5673d;
    }

    o g() {
        return this.f5672c;
    }

    o h() {
        return this.f5674e;
    }
}
