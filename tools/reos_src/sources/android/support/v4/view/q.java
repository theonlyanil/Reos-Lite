package android.support.v4.view;

import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d f936a;

    static class a implements d {
        a() {
        }

        @Override // android.support.v4.view.q.d
        public MenuItem a(MenuItem menuItem, View view) {
            return menuItem;
        }

        @Override // android.support.v4.view.q.d
        public View a(MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.q.d
        public void a(MenuItem menuItem, int i) {
        }

        @Override // android.support.v4.view.q.d
        public MenuItem b(MenuItem menuItem, int i) {
            return menuItem;
        }

        @Override // android.support.v4.view.q.d
        public boolean b(MenuItem menuItem) {
            return false;
        }

        @Override // android.support.v4.view.q.d
        public boolean c(MenuItem menuItem) {
            return false;
        }
    }

    static class b implements d {
        b() {
        }

        @Override // android.support.v4.view.q.d
        public MenuItem a(MenuItem menuItem, View view) {
            return r.a(menuItem, view);
        }

        @Override // android.support.v4.view.q.d
        public View a(MenuItem menuItem) {
            return r.a(menuItem);
        }

        @Override // android.support.v4.view.q.d
        public void a(MenuItem menuItem, int i) {
            r.a(menuItem, i);
        }

        @Override // android.support.v4.view.q.d
        public MenuItem b(MenuItem menuItem, int i) {
            return r.b(menuItem, i);
        }

        @Override // android.support.v4.view.q.d
        public boolean b(MenuItem menuItem) {
            return false;
        }

        @Override // android.support.v4.view.q.d
        public boolean c(MenuItem menuItem) {
            return false;
        }
    }

    static class c extends b {
        c() {
        }

        @Override // android.support.v4.view.q.b, android.support.v4.view.q.d
        public boolean b(MenuItem menuItem) {
            return s.a(menuItem);
        }

        @Override // android.support.v4.view.q.b, android.support.v4.view.q.d
        public boolean c(MenuItem menuItem) {
            return s.b(menuItem);
        }
    }

    interface d {
        MenuItem a(MenuItem menuItem, View view);

        View a(MenuItem menuItem);

        void a(MenuItem menuItem, int i);

        MenuItem b(MenuItem menuItem, int i);

        boolean b(MenuItem menuItem);

        boolean c(MenuItem menuItem);
    }

    public interface e {
        boolean a(MenuItem menuItem);

        boolean b(MenuItem menuItem);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            f936a = new c();
        } else if (i >= 11) {
            f936a = new b();
        } else {
            f936a = new a();
        }
    }

    public static MenuItem a(MenuItem menuItem, android.support.v4.view.d dVar) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            return ((android.support.v4.d.a.b) menuItem).a(dVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).setActionView(view) : f936a.a(menuItem, view);
    }

    public static View a(MenuItem menuItem) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).getActionView() : f936a.a(menuItem);
    }

    public static void a(MenuItem menuItem, int i) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            ((android.support.v4.d.a.b) menuItem).setShowAsAction(i);
        } else {
            f936a.a(menuItem, i);
        }
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).setActionView(i) : f936a.b(menuItem, i);
    }

    public static boolean b(MenuItem menuItem) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).expandActionView() : f936a.b(menuItem);
    }

    public static boolean c(MenuItem menuItem) {
        return menuItem instanceof android.support.v4.d.a.b ? ((android.support.v4.d.a.b) menuItem).isActionViewExpanded() : f936a.c(menuItem);
    }
}
