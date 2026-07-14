package android.support.v7.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1881e;
    boolean h;
    boolean i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1877a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1882f = 0;
    int g = 0;

    y() {
    }

    View a(RecyclerView.n nVar) {
        View viewC = nVar.c(this.f1879c);
        this.f1879c += this.f1880d;
        return viewC;
    }

    boolean a(RecyclerView.r rVar) {
        return this.f1879c >= 0 && this.f1879c < rVar.e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1878b + ", mCurrentPosition=" + this.f1879c + ", mItemDirection=" + this.f1880d + ", mLayoutDirection=" + this.f1881e + ", mStartLine=" + this.f1882f + ", mEndLine=" + this.g + '}';
    }
}
