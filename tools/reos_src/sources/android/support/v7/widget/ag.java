package android.support.v7.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ag {
    static int a(RecyclerView.r rVar, aa aaVar, View view, View view2, RecyclerView.h hVar, boolean z) {
        if (hVar.t() == 0 || rVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(hVar.d(view) - hVar.d(view2)) + 1;
        }
        return Math.min(aaVar.f(), aaVar.b(view2) - aaVar.a(view));
    }

    static int a(RecyclerView.r rVar, aa aaVar, View view, View view2, RecyclerView.h hVar, boolean z, boolean z2) {
        if (hVar.t() == 0 || rVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (rVar.e() - Math.max(hVar.d(view), hVar.d(view2))) - 1) : Math.max(0, Math.min(hVar.d(view), hVar.d(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(aaVar.b(view2) - aaVar.a(view)) / (Math.abs(hVar.d(view) - hVar.d(view2)) + 1))) + (aaVar.c() - aaVar.a(view)));
        }
        return iMax;
    }

    static int b(RecyclerView.r rVar, aa aaVar, View view, View view2, RecyclerView.h hVar, boolean z) {
        if (hVar.t() == 0 || rVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return rVar.e();
        }
        return (int) (((aaVar.b(view2) - aaVar.a(view)) / (Math.abs(hVar.d(view) - hVar.d(view2)) + 1)) * rVar.e());
    }
}
