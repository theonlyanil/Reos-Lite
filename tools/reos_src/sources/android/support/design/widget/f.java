package android.support.design.widget;

import android.support.v4.view.ah;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class f implements e {
    f() {
    }

    @Override // android.support.design.widget.e
    public void a(View view, android.support.v4.view.ab abVar) {
        if (ah.w(view)) {
            ah.a(view, abVar);
            view.setSystemUiVisibility(1280);
        }
    }
}
