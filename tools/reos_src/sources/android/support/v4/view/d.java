package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f928c;

    public interface a {
        void b(boolean z);
    }

    public interface b {
        void a(boolean z);
    }

    public d(Context context) {
        this.f926a = context;
    }

    public abstract View a();

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(a aVar) {
        this.f927b = aVar;
    }

    public void a(b bVar) {
        if (this.f928c != null && bVar != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f928c = bVar;
    }

    public void a(SubMenu subMenu) {
    }

    public void a(boolean z) {
        if (this.f927b != null) {
            this.f927b.b(z);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.f928c = null;
        this.f927b = null;
    }
}
