package android.support.v4.view;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
class bi extends bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowInsets f924a;

    bi(WindowInsets windowInsets) {
        this.f924a = windowInsets;
    }

    @Override // android.support.v4.view.bh
    public int a() {
        return this.f924a.getSystemWindowInsetLeft();
    }

    @Override // android.support.v4.view.bh
    public bh a(int i, int i2, int i3, int i4) {
        return new bi(this.f924a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    @Override // android.support.v4.view.bh
    public int b() {
        return this.f924a.getSystemWindowInsetTop();
    }

    @Override // android.support.v4.view.bh
    public int c() {
        return this.f924a.getSystemWindowInsetRight();
    }

    @Override // android.support.v4.view.bh
    public int d() {
        return this.f924a.getSystemWindowInsetBottom();
    }

    @Override // android.support.v4.view.bh
    public boolean e() {
        return this.f924a.isConsumed();
    }

    @Override // android.support.v4.view.bh
    public bh f() {
        return new bi(this.f924a.consumeSystemWindowInsets());
    }

    WindowInsets g() {
        return this.f924a;
    }
}
