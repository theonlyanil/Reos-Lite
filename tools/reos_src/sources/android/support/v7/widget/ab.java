package android.support.v7.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class ab extends android.support.v4.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RecyclerView f1690a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final android.support.v4.view.a f1691c = new android.support.v4.view.a() { // from class: android.support.v7.widget.ab.1
        @Override // android.support.v4.view.a
        public void a(View view, android.support.v4.view.a.c cVar) {
            super.a(view, cVar);
            if (ab.this.c() || ab.this.f1690a.getLayoutManager() == null) {
                return;
            }
            ab.this.f1690a.getLayoutManager().a(view, cVar);
        }

        @Override // android.support.v4.view.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (ab.this.c() || ab.this.f1690a.getLayoutManager() == null) {
                return false;
            }
            return ab.this.f1690a.getLayoutManager().a(view, i, bundle);
        }
    };

    public ab(RecyclerView recyclerView) {
        this.f1690a = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f1690a.p();
    }

    @Override // android.support.v4.view.a
    public void a(View view, android.support.v4.view.a.c cVar) {
        super.a(view, cVar);
        cVar.b((CharSequence) RecyclerView.class.getName());
        if (c() || this.f1690a.getLayoutManager() == null) {
            return;
        }
        this.f1690a.getLayoutManager().a(cVar);
    }

    @Override // android.support.v4.view.a
    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || c()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().a(accessibilityEvent);
        }
    }

    @Override // android.support.v4.view.a
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (c() || this.f1690a.getLayoutManager() == null) {
            return false;
        }
        return this.f1690a.getLayoutManager().a(i, bundle);
    }

    android.support.v4.view.a b() {
        return this.f1691c;
    }
}
