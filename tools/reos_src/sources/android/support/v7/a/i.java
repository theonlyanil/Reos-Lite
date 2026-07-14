package android.support.v7.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.ap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
abstract class i extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f1105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Window f1106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Window.Callback f1107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Window.Callback f1108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final g f1109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    android.support.v7.a.a f1110f;
    MenuInflater g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private CharSequence m;
    private boolean n;

    private class a implements android.support.v7.a.b.a {
        private a() {
        }

        @Override // android.support.v7.a.b.a
        public Drawable a() {
            ap apVarA = ap.a(b(), null, new int[]{android.support.v7.b.a.C0029a.homeAsUpIndicator});
            Drawable drawableA = apVarA.a(0);
            apVarA.a();
            return drawableA;
        }

        @Override // android.support.v7.a.b.a
        public void a(int i) {
            android.support.v7.a.a aVarA = i.this.a();
            if (aVarA != null) {
                aVarA.a(i);
            }
        }

        @Override // android.support.v7.a.b.a
        public void a(Drawable drawable, int i) {
            android.support.v7.a.a aVarA = i.this.a();
            if (aVarA != null) {
                aVarA.b(drawable);
                aVarA.a(i);
            }
        }

        @Override // android.support.v7.a.b.a
        public Context b() {
            return i.this.n();
        }

        @Override // android.support.v7.a.b.a
        public boolean c() {
            android.support.v7.a.a aVarA = i.this.a();
            return (aVarA == null || (aVarA.a() & 4) == 0) ? false : true;
        }
    }

    class b extends android.support.v7.view.i {
        b(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || i.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof android.support.v7.view.menu.f)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            i.this.b(i, menu);
            return true;
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            i.this.a(i, menu);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            android.support.v7.view.menu.f fVar = menu instanceof android.support.v7.view.menu.f ? (android.support.v7.view.menu.f) menu : null;
            if (i == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.c(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (fVar == null) {
                return zOnPreparePanel;
            }
            fVar.c(false);
            return zOnPreparePanel;
        }
    }

    i(Context context, Window window, g gVar) {
        this.f1105a = context;
        this.f1106b = window;
        this.f1109e = gVar;
        this.f1107c = this.f1106b.getCallback();
        if (this.f1107c instanceof b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1108d = a(this.f1107c);
        this.f1106b.setCallback(this.f1108d);
    }

    @Override // android.support.v7.a.h
    public android.support.v7.a.a a() {
        l();
        return this.f1110f;
    }

    abstract android.support.v7.view.b a(android.support.v7.view.b.a aVar);

    Window.Callback a(Window.Callback callback) {
        return new b(callback);
    }

    abstract void a(int i, Menu menu);

    @Override // android.support.v7.a.h
    public final void a(CharSequence charSequence) {
        this.m = charSequence;
        b(charSequence);
    }

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(KeyEvent keyEvent);

    @Override // android.support.v7.a.h
    public MenuInflater b() {
        if (this.g == null) {
            l();
            this.g = new android.support.v7.view.g(this.f1110f != null ? this.f1110f.d() : this.f1105a);
        }
        return this.g;
    }

    abstract void b(CharSequence charSequence);

    abstract boolean b(int i, Menu menu);

    @Override // android.support.v7.a.h
    public void c(Bundle bundle) {
    }

    @Override // android.support.v7.a.h
    public void f() {
        this.n = true;
    }

    @Override // android.support.v7.a.h
    public final android.support.v7.a.b.a g() {
        return new a();
    }

    @Override // android.support.v7.a.h
    public boolean i() {
        return false;
    }

    abstract void l();

    final android.support.v7.a.a m() {
        return this.f1110f;
    }

    final Context n() {
        android.support.v7.a.a aVarA = a();
        Context contextD = aVarA != null ? aVarA.d() : null;
        return contextD == null ? this.f1105a : contextD;
    }

    public boolean o() {
        return false;
    }

    final boolean p() {
        return this.n;
    }

    final Window.Callback q() {
        return this.f1106b.getCallback();
    }

    final CharSequence r() {
        return this.f1107c instanceof Activity ? ((Activity) this.f1107c).getTitle() : this.m;
    }
}
