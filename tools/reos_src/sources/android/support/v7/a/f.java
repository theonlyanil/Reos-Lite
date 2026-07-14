package android.support.v7.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.ax;
import android.support.v7.widget.ar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class f extends android.support.v4.app.p implements ax.a, b.InterfaceC0027b, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f1099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1100b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Resources f1102d;

    @Override // android.support.v4.app.ax.a
    public Intent a() {
        return ab.a(this);
    }

    @Override // android.support.v7.a.g
    public android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        return null;
    }

    public void a(ax axVar) {
        axVar.a((Activity) this);
    }

    @Override // android.support.v7.a.g
    public void a(android.support.v7.view.b bVar) {
    }

    public boolean a(Intent intent) {
        return ab.a(this, intent);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f().b(view, layoutParams);
    }

    @Override // android.support.v7.a.b.InterfaceC0027b
    public b.a b() {
        return f().g();
    }

    public void b(Intent intent) {
        ab.b(this, intent);
    }

    public void b(ax axVar) {
    }

    @Override // android.support.v7.a.g
    public void b(android.support.v7.view.b bVar) {
    }

    public a c() {
        return f().a();
    }

    public boolean d() {
        Intent intentA = a();
        if (intentA == null) {
            return false;
        }
        if (a(intentA)) {
            ax axVarA = ax.a((Context) this);
            a(axVarA);
            b(axVarA);
            axVarA.a();
            try {
                android.support.v4.app.a.a((Activity) this);
            } catch (IllegalStateException e2) {
                finish();
            }
        } else {
            b(intentA);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (android.support.v4.view.g.a(keyEvent, 4096) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & (-28673)) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                a aVarC = c();
                if (aVarC != null && aVarC.c() && aVarC.h()) {
                    this.f1101c = true;
                    return true;
                }
            } else if (action == 1 && this.f1101c) {
                this.f1101c = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Deprecated
    public void e() {
    }

    public h f() {
        if (this.f1099a == null) {
            this.f1099a = h.a(this, this);
        }
        return this.f1099a;
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        return f().a(i);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return f().b();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f1102d == null && ar.a()) {
            this.f1102d = new ar(this, super.getResources());
        }
        return this.f1102d == null ? super.getResources() : this.f1102d;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        f().e();
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f().a(configuration);
        if (this.f1102d != null) {
            this.f1102d.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        e();
    }

    @Override // android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    protected void onCreate(Bundle bundle) {
        h hVarF = f();
        hVarF.h();
        hVarF.a(bundle);
        if (hVarF.i() && this.f1100b != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f1100b, false);
            } else {
                setTheme(this.f1100b);
            }
        }
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        f().f();
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a aVarC = c();
        if (menuItem.getItemId() != 16908332 || aVarC == null || (aVarC.a() & 4) == 0) {
            return false;
        }
        return d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        f().b(bundle);
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        f().d();
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        f().c(bundle);
    }

    @Override // android.support.v4.app.p, android.app.Activity
    protected void onStop() {
        super.onStop();
        f().c();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        f().a(charSequence);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        f().b(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        f().a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f().a(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.f1100b = i;
    }

    @Override // android.support.v4.app.p
    public void supportInvalidateOptionsMenu() {
        f().e();
    }
}
