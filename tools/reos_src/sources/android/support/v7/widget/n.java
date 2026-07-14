package android.support.v7.widget;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class n implements q {
    n() {
    }

    private ad i(o oVar) {
        return (ad) oVar.c();
    }

    @Override // android.support.v7.widget.q
    public float a(o oVar) {
        return i(oVar).a();
    }

    @Override // android.support.v7.widget.q
    public void a() {
    }

    @Override // android.support.v7.widget.q
    public void a(o oVar, float f2) {
        i(oVar).a(f2);
    }

    @Override // android.support.v7.widget.q
    public void a(o oVar, int i) {
        i(oVar).a(i);
    }

    @Override // android.support.v7.widget.q
    public void a(o oVar, Context context, int i, float f2, float f3, float f4) {
        oVar.a(new ad(i, f2));
        View viewD = oVar.d();
        viewD.setClipToOutline(true);
        viewD.setElevation(f3);
        b(oVar, f4);
    }

    @Override // android.support.v7.widget.q
    public float b(o oVar) {
        return d(oVar) * 2.0f;
    }

    @Override // android.support.v7.widget.q
    public void b(o oVar, float f2) {
        i(oVar).a(f2, oVar.a(), oVar.b());
        f(oVar);
    }

    @Override // android.support.v7.widget.q
    public float c(o oVar) {
        return d(oVar) * 2.0f;
    }

    @Override // android.support.v7.widget.q
    public void c(o oVar, float f2) {
        oVar.d().setElevation(f2);
    }

    @Override // android.support.v7.widget.q
    public float d(o oVar) {
        return i(oVar).b();
    }

    @Override // android.support.v7.widget.q
    public float e(o oVar) {
        return oVar.d().getElevation();
    }

    public void f(o oVar) {
        if (!oVar.a()) {
            oVar.a(0, 0, 0, 0);
            return;
        }
        float fA = a(oVar);
        float fD = d(oVar);
        int iCeil = (int) Math.ceil(ae.b(fA, fD, oVar.b()));
        int iCeil2 = (int) Math.ceil(ae.a(fA, fD, oVar.b()));
        oVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // android.support.v7.widget.q
    public void g(o oVar) {
        b(oVar, a(oVar));
    }

    @Override // android.support.v7.widget.q
    public void h(o oVar) {
        b(oVar, a(oVar));
    }
}
