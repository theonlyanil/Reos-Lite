package android.support.v4.view;

import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
class m {
    static void a(LayoutInflater layoutInflater, n nVar) {
        layoutInflater.setFactory2(nVar != null ? new l.a(nVar) : null);
    }
}
