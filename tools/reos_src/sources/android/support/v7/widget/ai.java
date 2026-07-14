package android.support.v7.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class ai extends RecyclerView.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1728a = true;

    public final void a(RecyclerView.u uVar, boolean z) {
        d(uVar, z);
        e(uVar);
    }

    public abstract boolean a(RecyclerView.u uVar);

    public abstract boolean a(RecyclerView.u uVar, int i, int i2, int i3, int i4);

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean a(RecyclerView.u uVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        int i = cVar.f1531a;
        int i2 = cVar.f1532b;
        View view = uVar.f1584a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1531a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1532b;
        if (uVar.q() || (i == left && i2 == top)) {
            return a(uVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(uVar, i, i2, left, top);
    }

    public abstract boolean a(RecyclerView.u uVar, RecyclerView.u uVar2, int i, int i2, int i3, int i4);

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean a(RecyclerView.u uVar, RecyclerView.u uVar2, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f1531a;
        int i4 = cVar.f1532b;
        if (uVar2.c()) {
            i = cVar.f1531a;
            i2 = cVar.f1532b;
        } else {
            i = cVar2.f1531a;
            i2 = cVar2.f1532b;
        }
        return a(uVar, uVar2, i3, i4, i, i2);
    }

    public final void b(RecyclerView.u uVar, boolean z) {
        c(uVar, z);
    }

    public abstract boolean b(RecyclerView.u uVar);

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean b(RecyclerView.u uVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        return (cVar == null || (cVar.f1531a == cVar2.f1531a && cVar.f1532b == cVar2.f1532b)) ? b(uVar) : a(uVar, cVar.f1531a, cVar.f1532b, cVar2.f1531a, cVar2.f1532b);
    }

    public void c(RecyclerView.u uVar, boolean z) {
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean c(RecyclerView.u uVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        if (cVar.f1531a != cVar2.f1531a || cVar.f1532b != cVar2.f1532b) {
            return a(uVar, cVar.f1531a, cVar.f1532b, cVar2.f1531a, cVar2.f1532b);
        }
        i(uVar);
        return false;
    }

    public void d(RecyclerView.u uVar, boolean z) {
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean g(RecyclerView.u uVar) {
        return !this.f1728a || uVar.n();
    }

    public final void h(RecyclerView.u uVar) {
        o(uVar);
        e(uVar);
    }

    public final void i(RecyclerView.u uVar) {
        s(uVar);
        e(uVar);
    }

    public final void j(RecyclerView.u uVar) {
        q(uVar);
        e(uVar);
    }

    public final void k(RecyclerView.u uVar) {
        n(uVar);
    }

    public final void l(RecyclerView.u uVar) {
        r(uVar);
    }

    public final void m(RecyclerView.u uVar) {
        p(uVar);
    }

    public void n(RecyclerView.u uVar) {
    }

    public void o(RecyclerView.u uVar) {
    }

    public void p(RecyclerView.u uVar) {
    }

    public void q(RecyclerView.u uVar) {
    }

    public void r(RecyclerView.u uVar) {
    }

    public void s(RecyclerView.u uVar) {
    }
}
