package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class k {

    static class a implements LayoutInflater.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final n f932a;

        a(n nVar) {
            this.f932a = nVar;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f932a.a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f932a + "}";
        }
    }

    static n a(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof a) {
            return ((a) factory).f932a;
        }
        return null;
    }

    static void a(LayoutInflater layoutInflater, n nVar) {
        layoutInflater.setFactory(nVar != null ? new a(nVar) : null);
    }
}
