package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.view.menu.n;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(11)
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f1201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f1202b;

    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f1203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f1204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<f> f1205c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final android.support.v4.h.i<Menu, Menu> f1206d = new android.support.v4.h.i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f1204b = context;
            this.f1203a = callback;
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f1206d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu menuA = n.a(this.f1204b, (android.support.v4.d.a.a) menu);
            this.f1206d.put(menu, menuA);
            return menuA;
        }

        @Override // android.support.v7.view.b.a
        public void a(b bVar) {
            this.f1203a.onDestroyActionMode(b(bVar));
        }

        @Override // android.support.v7.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f1203a.onCreateActionMode(b(bVar), a(menu));
        }

        @Override // android.support.v7.view.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f1203a.onActionItemClicked(b(bVar), n.a(this.f1204b, (android.support.v4.d.a.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.f1205c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f1205c.get(i);
                if (fVar != null && fVar.f1202b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f1204b, bVar);
            this.f1205c.add(fVar2);
            return fVar2;
        }

        @Override // android.support.v7.view.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f1203a.onPrepareActionMode(b(bVar), a(menu));
        }
    }

    public f(Context context, b bVar) {
        this.f1201a = context;
        this.f1202b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1202b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1202b.i();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return n.a(this.f1201a, (android.support.v4.d.a.a) this.f1202b.b());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1202b.a();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1202b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1202b.j();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1202b.f();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1202b.k();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1202b.d();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1202b.h();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1202b.a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f1202b.b(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1202b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1202b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f1202b.a(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1202b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f1202b.a(z);
    }
}
