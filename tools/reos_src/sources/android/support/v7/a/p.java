package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ah;
import android.support.v7.widget.u;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class p extends android.support.v7.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f1144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Window.Callback f1145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<android.support.v7.a.a.b> f1148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f1149f;

    /* JADX INFO: renamed from: android.support.v7.a.p$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f1150a;

        @Override // java.lang.Runnable
        public void run() {
            this.f1150a.j();
        }
    }

    private final class a implements android.support.v7.view.menu.l.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1152b;

        private a() {
        }

        /* synthetic */ a(p pVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.support.v7.view.menu.l.a
        public void a(android.support.v7.view.menu.f fVar, boolean z) {
            if (this.f1152b) {
                return;
            }
            this.f1152b = true;
            p.this.f1144a.n();
            if (p.this.f1145b != null) {
                p.this.f1145b.onPanelClosed(108, fVar);
            }
            this.f1152b = false;
        }

        @Override // android.support.v7.view.menu.l.a
        public boolean a(android.support.v7.view.menu.f fVar) {
            if (p.this.f1145b == null) {
                return false;
            }
            p.this.f1145b.onMenuOpened(108, fVar);
            return true;
        }
    }

    private final class b implements android.support.v7.view.menu.f.a {
        private b() {
        }

        /* synthetic */ b(p pVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.support.v7.view.menu.f.a
        public void a(android.support.v7.view.menu.f fVar) {
            if (p.this.f1145b != null) {
                if (p.this.f1144a.i()) {
                    p.this.f1145b.onPanelClosed(108, fVar);
                } else if (p.this.f1145b.onPreparePanel(0, null, fVar)) {
                    p.this.f1145b.onMenuOpened(108, fVar);
                }
            }
        }

        @Override // android.support.v7.view.menu.f.a
        public boolean a(android.support.v7.view.menu.f fVar, MenuItem menuItem) {
            return false;
        }
    }

    private Menu k() {
        AnonymousClass1 anonymousClass1 = null;
        if (!this.f1146c) {
            this.f1144a.a(new a(this, anonymousClass1), new b(this, anonymousClass1));
            this.f1146c = true;
        }
        return this.f1144a.r();
    }

    @Override // android.support.v7.a.a
    public int a() {
        return this.f1144a.o();
    }

    @Override // android.support.v7.a.a
    public void a(float f2) {
        ah.d(this.f1144a.a(), f2);
    }

    @Override // android.support.v7.a.a
    public void a(int i) {
        this.f1144a.d(i);
    }

    public void a(int i, int i2) {
        this.f1144a.c((this.f1144a.o() & (i2 ^ (-1))) | (i & i2));
    }

    @Override // android.support.v7.a.a
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // android.support.v7.a.a
    public void a(Drawable drawable) {
        this.f1144a.c(drawable);
    }

    @Override // android.support.v7.a.a
    public void a(CharSequence charSequence) {
        this.f1144a.b(charSequence);
    }

    @Override // android.support.v7.a.a
    public void a(boolean z) {
        a(z ? 2 : 0, 2);
    }

    @Override // android.support.v7.a.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu menuK = k();
        if (menuK != null) {
            menuK.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            menuK.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    @Override // android.support.v7.a.a
    public void b() {
        this.f1144a.e(8);
    }

    @Override // android.support.v7.a.a
    public void b(Drawable drawable) {
        this.f1144a.b(drawable);
    }

    @Override // android.support.v7.a.a
    public void b(CharSequence charSequence) {
        this.f1144a.a(charSequence);
    }

    @Override // android.support.v7.a.a
    public void b(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.a.a
    public void c(boolean z) {
    }

    @Override // android.support.v7.a.a
    public boolean c() {
        return this.f1144a.q() == 0;
    }

    @Override // android.support.v7.a.a
    public Context d() {
        return this.f1144a.b();
    }

    @Override // android.support.v7.a.a
    public void e(boolean z) {
    }

    @Override // android.support.v7.a.a
    public void f(boolean z) {
    }

    @Override // android.support.v7.a.a
    public boolean f() {
        this.f1144a.a().removeCallbacks(this.f1149f);
        ah.a(this.f1144a.a(), this.f1149f);
        return true;
    }

    @Override // android.support.v7.a.a
    public void g(boolean z) {
        if (z == this.f1147d) {
            return;
        }
        this.f1147d = z;
        int size = this.f1148e.size();
        for (int i = 0; i < size; i++) {
            this.f1148e.get(i).a(z);
        }
    }

    @Override // android.support.v7.a.a
    public boolean g() {
        if (!this.f1144a.c()) {
            return false;
        }
        this.f1144a.d();
        return true;
    }

    @Override // android.support.v7.a.a
    public boolean h() {
        ViewGroup viewGroupA = this.f1144a.a();
        if (viewGroupA == null || viewGroupA.hasFocus()) {
            return false;
        }
        viewGroupA.requestFocus();
        return true;
    }

    @Override // android.support.v7.a.a
    void i() {
        this.f1144a.a().removeCallbacks(this.f1149f);
    }

    void j() {
        Menu menuK = k();
        android.support.v7.view.menu.f fVar = menuK instanceof android.support.v7.view.menu.f ? (android.support.v7.view.menu.f) menuK : null;
        if (fVar != null) {
            fVar.g();
        }
        try {
            menuK.clear();
            if (!this.f1145b.onCreatePanelMenu(0, menuK) || !this.f1145b.onPreparePanel(0, null, menuK)) {
                menuK.clear();
            }
        } finally {
            if (fVar != null) {
                fVar.h();
            }
        }
    }
}
