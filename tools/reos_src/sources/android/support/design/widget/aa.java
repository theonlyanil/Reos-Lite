package android.support.design.widget;

import android.support.v4.view.ah;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f413e;

    public aa(View view) {
        this.f409a = view;
    }

    private void c() {
        ah.e(this.f409a, this.f412d - (this.f409a.getTop() - this.f410b));
        ah.f(this.f409a, this.f413e - (this.f409a.getLeft() - this.f411c));
    }

    public void a() {
        this.f410b = this.f409a.getTop();
        this.f411c = this.f409a.getLeft();
        c();
    }

    public boolean a(int i) {
        if (this.f412d == i) {
            return false;
        }
        this.f412d = i;
        c();
        return true;
    }

    public int b() {
        return this.f412d;
    }

    public boolean b(int i) {
        if (this.f413e == i) {
            return false;
        }
        this.f413e = i;
        c();
        return true;
    }
}
