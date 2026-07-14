package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
class j extends i {

    class a extends i.a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        android.support.v4.view.d.b f1295c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.view.d
        public View a(MenuItem menuItem) {
            return this.f1290a.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.view.d
        public void a(android.support.v4.view.d.b bVar) {
            this.f1295c = bVar;
            ActionProvider actionProvider = this.f1290a;
            if (bVar == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.support.v4.view.d
        public boolean b() {
            return this.f1290a.overridesItemVisibility();
        }

        @Override // android.support.v4.view.d
        public boolean c() {
            return this.f1290a.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1295c != null) {
                this.f1295c.a(z);
            }
        }
    }

    j(Context context, android.support.v4.d.a.b bVar) {
        super(context, bVar);
    }

    @Override // android.support.v7.view.menu.i
    i.a a(ActionProvider actionProvider) {
        return new a(this.f1260a, actionProvider);
    }
}
