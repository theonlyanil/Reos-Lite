package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class i extends android.support.v7.view.menu.c<android.support.v4.d.a.b> implements MenuItem {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Method f1289c;

    class a extends android.support.v4.view.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionProvider f1290a;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1290a = actionProvider;
        }

        @Override // android.support.v4.view.d
        public View a() {
            return this.f1290a.onCreateActionView();
        }

        @Override // android.support.v4.view.d
        public void a(SubMenu subMenu) {
            this.f1290a.onPrepareSubMenu(i.this.a(subMenu));
        }

        @Override // android.support.v4.view.d
        public boolean d() {
            return this.f1290a.onPerformDefaultAction();
        }

        @Override // android.support.v4.view.d
        public boolean e() {
            return this.f1290a.hasSubMenu();
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f1292a;

        /* JADX WARN: Multi-variable type inference failed */
        b(View view) {
            super(view.getContext());
            this.f1292a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // android.support.v7.view.c
        public void a() {
            this.f1292a.onActionViewExpanded();
        }

        @Override // android.support.v7.view.c
        public void b() {
            this.f1292a.onActionViewCollapsed();
        }

        View c() {
            return (View) this.f1292a;
        }
    }

    private class c extends android.support.v7.view.menu.d<MenuItem.OnActionExpandListener> implements android.support.v4.view.q.e {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.support.v4.view.q.e
        public boolean a(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f1263b).onMenuItemActionExpand(i.this.a(menuItem));
        }

        @Override // android.support.v4.view.q.e
        public boolean b(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f1263b).onMenuItemActionCollapse(i.this.a(menuItem));
        }
    }

    private class d extends android.support.v7.view.menu.d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f1263b).onMenuItemClick(i.this.a(menuItem));
        }
    }

    i(Context context, android.support.v4.d.a.b bVar) {
        super(context, bVar);
    }

    a a(ActionProvider actionProvider) {
        return new a(this.f1260a, actionProvider);
    }

    public void a(boolean z) {
        try {
            if (this.f1289c == null) {
                this.f1289c = ((android.support.v4.d.a.b) this.f1263b).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1289c.invoke(this.f1263b, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((android.support.v4.d.a.b) this.f1263b).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((android.support.v4.d.a.b) this.f1263b).expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        android.support.v4.view.d dVarA = ((android.support.v4.d.a.b) this.f1263b).a();
        if (dVarA instanceof a) {
            return ((a) dVarA).f1290a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((android.support.v4.d.a.b) this.f1263b).getActionView();
        return actionView instanceof b ? ((b) actionView).c() : actionView;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((android.support.v4.d.a.b) this.f1263b).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((android.support.v4.d.a.b) this.f1263b).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((android.support.v4.d.a.b) this.f1263b).getIcon();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((android.support.v4.d.a.b) this.f1263b).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((android.support.v4.d.a.b) this.f1263b).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.d.a.b) this.f1263b).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((android.support.v4.d.a.b) this.f1263b).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((android.support.v4.d.a.b) this.f1263b).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(((android.support.v4.d.a.b) this.f1263b).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((android.support.v4.d.a.b) this.f1263b).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((android.support.v4.d.a.b) this.f1263b).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((android.support.v4.d.a.b) this.f1263b).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((android.support.v4.d.a.b) this.f1263b).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((android.support.v4.d.a.b) this.f1263b).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((android.support.v4.d.a.b) this.f1263b).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((android.support.v4.d.a.b) this.f1263b).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((android.support.v4.d.a.b) this.f1263b).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.d.a.b) this.f1263b).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        ((android.support.v4.d.a.b) this.f1263b).setActionView(i);
        View actionView = ((android.support.v4.d.a.b) this.f1263b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.d.a.b) this.f1263b).setActionView(new b(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.d.a.b) this.f1263b).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        ((android.support.v4.d.a.b) this.f1263b).setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.d.a.b) this.f1263b).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((android.support.v4.d.a.b) this.f1263b).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.d.a.b) this.f1263b).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        ((android.support.v4.d.a.b) this.f1263b).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.d.a.b) this.f1263b).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.d.a.b) this.f1263b).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        ((android.support.v4.d.a.b) this.f1263b).setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.d.a.b) this.f1263b).a(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.d.a.b) this.f1263b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        ((android.support.v4.d.a.b) this.f1263b).setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((android.support.v4.d.a.b) this.f1263b).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.d.a.b) this.f1263b).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        ((android.support.v4.d.a.b) this.f1263b).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.d.a.b) this.f1263b).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.d.a.b) this.f1263b).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.d.a.b) this.f1263b).setVisible(z);
    }
}
