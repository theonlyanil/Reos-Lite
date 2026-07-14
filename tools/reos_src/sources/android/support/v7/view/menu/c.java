package android.support.v7.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class c<T> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f1260a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<android.support.v4.d.a.b, MenuItem> f1261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<android.support.v4.d.a.c, SubMenu> f1262d;

    c(Context context, T t) {
        super(t);
        this.f1260a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof android.support.v4.d.a.b)) {
            return menuItem;
        }
        android.support.v4.d.a.b bVar = (android.support.v4.d.a.b) menuItem;
        if (this.f1261c == null) {
            this.f1261c = new android.support.v4.h.a();
        }
        MenuItem menuItem2 = this.f1261c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem menuItemA = n.a(this.f1260a, bVar);
        this.f1261c.put(bVar, menuItemA);
        return menuItemA;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.d.a.c)) {
            return subMenu;
        }
        android.support.v4.d.a.c cVar = (android.support.v4.d.a.c) subMenu;
        if (this.f1262d == null) {
            this.f1262d = new android.support.v4.h.a();
        }
        SubMenu subMenu2 = this.f1262d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu subMenuA = n.a(this.f1260a, cVar);
        this.f1262d.put(cVar, subMenuA);
        return subMenuA;
    }

    final void a() {
        if (this.f1261c != null) {
            this.f1261c.clear();
        }
        if (this.f1262d != null) {
            this.f1262d.clear();
        }
    }

    final void a(int i) {
        if (this.f1261c == null) {
            return;
        }
        Iterator<android.support.v4.d.a.b> it = this.f1261c.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    final void b(int i) {
        if (this.f1261c == null) {
            return;
        }
        Iterator<android.support.v4.d.a.b> it = this.f1261c.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
