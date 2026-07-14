package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class p extends f implements SubMenu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f1306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f1307e;

    public p(Context context, f fVar, h hVar) {
        super(context);
        this.f1306d = fVar;
        this.f1307e = hVar;
    }

    @Override // android.support.v7.view.menu.f
    public String a() {
        int itemId = this.f1307e != null ? this.f1307e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.a() + ":" + itemId;
    }

    @Override // android.support.v7.view.menu.f
    public void a(f.a aVar) {
        this.f1306d.a(aVar);
    }

    @Override // android.support.v7.view.menu.f
    boolean a(f fVar, MenuItem menuItem) {
        return super.a(fVar, menuItem) || this.f1306d.a(fVar, menuItem);
    }

    @Override // android.support.v7.view.menu.f
    public boolean b() {
        return this.f1306d.b();
    }

    @Override // android.support.v7.view.menu.f
    public boolean c() {
        return this.f1306d.c();
    }

    @Override // android.support.v7.view.menu.f
    public boolean c(h hVar) {
        return this.f1306d.c(hVar);
    }

    @Override // android.support.v7.view.menu.f
    public boolean d(h hVar) {
        return this.f1306d.d(hVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f1307e;
    }

    @Override // android.support.v7.view.menu.f
    public f p() {
        return this.f1306d;
    }

    public Menu s() {
        return this.f1306d;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        super.a(android.support.v4.b.b.a(e(), i));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        super.a(e().getResources().getString(i));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f1307e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1307e.setIcon(drawable);
        return this;
    }

    @Override // android.support.v7.view.menu.f, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1306d.setQwertyMode(z);
    }
}
