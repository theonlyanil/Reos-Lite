package android.support.v7.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.h f1688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1689b;

    private aa(RecyclerView.h hVar) {
        this.f1689b = Integer.MIN_VALUE;
        this.f1688a = hVar;
    }

    public static aa a(RecyclerView.h hVar) {
        return new aa(hVar) { // from class: android.support.v7.widget.aa.1
            @Override // android.support.v7.widget.aa
            public int a(View view) {
                return this.f1688a.h(view) - ((RecyclerView.i) view.getLayoutParams()).leftMargin;
            }

            @Override // android.support.v7.widget.aa
            public void a(int i) {
                this.f1688a.i(i);
            }

            @Override // android.support.v7.widget.aa
            public int b(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.rightMargin + this.f1688a.j(view);
            }

            @Override // android.support.v7.widget.aa
            public int c() {
                return this.f1688a.y();
            }

            @Override // android.support.v7.widget.aa
            public int c(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.rightMargin + this.f1688a.f(view) + iVar.leftMargin;
            }

            @Override // android.support.v7.widget.aa
            public int d() {
                return this.f1688a.w() - this.f1688a.A();
            }

            @Override // android.support.v7.widget.aa
            public int d(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.bottomMargin + this.f1688a.g(view) + iVar.topMargin;
            }

            @Override // android.support.v7.widget.aa
            public int e() {
                return this.f1688a.w();
            }

            @Override // android.support.v7.widget.aa
            public int f() {
                return (this.f1688a.w() - this.f1688a.y()) - this.f1688a.A();
            }

            @Override // android.support.v7.widget.aa
            public int g() {
                return this.f1688a.A();
            }

            @Override // android.support.v7.widget.aa
            public int h() {
                return this.f1688a.u();
            }

            @Override // android.support.v7.widget.aa
            public int i() {
                return this.f1688a.v();
            }
        };
    }

    public static aa a(RecyclerView.h hVar, int i) {
        switch (i) {
            case 0:
                return a(hVar);
            case 1:
                return b(hVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static aa b(RecyclerView.h hVar) {
        return new aa(hVar) { // from class: android.support.v7.widget.aa.2
            @Override // android.support.v7.widget.aa
            public int a(View view) {
                return this.f1688a.i(view) - ((RecyclerView.i) view.getLayoutParams()).topMargin;
            }

            @Override // android.support.v7.widget.aa
            public void a(int i) {
                this.f1688a.j(i);
            }

            @Override // android.support.v7.widget.aa
            public int b(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.bottomMargin + this.f1688a.k(view);
            }

            @Override // android.support.v7.widget.aa
            public int c() {
                return this.f1688a.z();
            }

            @Override // android.support.v7.widget.aa
            public int c(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.bottomMargin + this.f1688a.g(view) + iVar.topMargin;
            }

            @Override // android.support.v7.widget.aa
            public int d() {
                return this.f1688a.x() - this.f1688a.B();
            }

            @Override // android.support.v7.widget.aa
            public int d(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return iVar.rightMargin + this.f1688a.f(view) + iVar.leftMargin;
            }

            @Override // android.support.v7.widget.aa
            public int e() {
                return this.f1688a.x();
            }

            @Override // android.support.v7.widget.aa
            public int f() {
                return (this.f1688a.x() - this.f1688a.z()) - this.f1688a.B();
            }

            @Override // android.support.v7.widget.aa
            public int g() {
                return this.f1688a.B();
            }

            @Override // android.support.v7.widget.aa
            public int h() {
                return this.f1688a.v();
            }

            @Override // android.support.v7.widget.aa
            public int i() {
                return this.f1688a.u();
            }
        };
    }

    public abstract int a(View view);

    public void a() {
        this.f1689b = f();
    }

    public abstract void a(int i);

    public int b() {
        if (Integer.MIN_VALUE == this.f1689b) {
            return 0;
        }
        return f() - this.f1689b;
    }

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();
}
