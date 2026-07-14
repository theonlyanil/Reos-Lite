package android.support.v7.a;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ab;
import android.support.v4.view.ah;
import android.support.v4.view.at;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.support.v4.view.bh;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ar;
import android.support.v7.widget.t;
import android.support.v7.widget.x;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
class m extends i implements android.support.v4.view.n, android.support.v7.view.menu.f.a {
    private boolean A;
    private d[] B;
    private d C;
    private boolean D;
    private boolean E;
    private int F;
    private final Runnable G;
    private boolean H;
    private Rect I;
    private Rect J;
    private o K;
    android.support.v7.view.b m;
    ActionBarContextView n;
    PopupWindow o;
    Runnable p;
    ba q;
    private t r;
    private a s;
    private e t;
    private boolean u;
    private ViewGroup v;
    private TextView w;
    private View x;
    private boolean y;
    private boolean z;

    private final class a implements android.support.v7.view.menu.l.a {
        private a() {
        }

        @Override // android.support.v7.view.menu.l.a
        public void a(android.support.v7.view.menu.f fVar, boolean z) {
            m.this.b(fVar);
        }

        @Override // android.support.v7.view.menu.l.a
        public boolean a(android.support.v7.view.menu.f fVar) {
            Window.Callback callbackQ = m.this.q();
            if (callbackQ == null) {
                return true;
            }
            callbackQ.onMenuOpened(108, fVar);
            return true;
        }
    }

    class b implements android.support.v7.view.b.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private android.support.v7.view.b.a f1124b;

        public b(android.support.v7.view.b.a aVar) {
            this.f1124b = aVar;
        }

        @Override // android.support.v7.view.b.a
        public void a(android.support.v7.view.b bVar) {
            this.f1124b.a(bVar);
            if (m.this.o != null) {
                m.this.f1106b.getDecorView().removeCallbacks(m.this.p);
            }
            if (m.this.n != null) {
                m.this.w();
                m.this.q = ah.s(m.this.n).a(BitmapDescriptorFactory.HUE_RED);
                m.this.q.a(new bf() { // from class: android.support.v7.a.m.b.1
                    @Override // android.support.v4.view.bf, android.support.v4.view.be
                    public void b(View view) {
                        m.this.n.setVisibility(8);
                        if (m.this.o != null) {
                            m.this.o.dismiss();
                        } else if (m.this.n.getParent() instanceof View) {
                            ah.v((View) m.this.n.getParent());
                        }
                        m.this.n.removeAllViews();
                        m.this.q.a((be) null);
                        m.this.q = null;
                    }
                });
            }
            if (m.this.f1109e != null) {
                m.this.f1109e.b(m.this.m);
            }
            m.this.m = null;
        }

        @Override // android.support.v7.view.b.a
        public boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.f1124b.a(bVar, menu);
        }

        @Override // android.support.v7.view.b.a
        public boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.f1124b.a(bVar, menuItem);
        }

        @Override // android.support.v7.view.b.a
        public boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.f1124b.b(bVar, menu);
        }
    }

    private class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return m.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            m.this.d(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(android.support.v7.widget.h.a().a(getContext(), i));
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1130d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1131e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1132f;
        ViewGroup g;
        View h;
        View i;
        android.support.v7.view.menu.f j;
        android.support.v7.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        d(int i) {
            this.f1127a = i;
        }

        android.support.v7.view.menu.m a(android.support.v7.view.menu.l.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new android.support.v7.view.menu.e(this.l, android.support.v7.b.a.h.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(android.support.v7.b.a.C0029a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            themeNewTheme.resolveAttribute(android.support.v7.b.a.C0029a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            } else {
                themeNewTheme.applyStyle(android.support.v7.b.a.j.Theme_AppCompat_CompactMenu, true);
            }
            android.support.v7.view.d dVar = new android.support.v7.view.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(android.support.v7.b.a.k.AppCompatTheme);
            this.f1128b = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.AppCompatTheme_panelBackground, 0);
            this.f1132f = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(android.support.v7.view.menu.f fVar) {
            if (fVar == this.j) {
                return;
            }
            if (this.j != null) {
                this.j.b(this.k);
            }
            this.j = fVar;
            if (fVar == null || this.k == null) {
                return;
            }
            fVar.a(this.k);
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.d().getCount() > 0;
        }
    }

    private final class e implements android.support.v7.view.menu.l.a {
        private e() {
        }

        @Override // android.support.v7.view.menu.l.a
        public void a(android.support.v7.view.menu.f fVar, boolean z) {
            android.support.v7.view.menu.f fVarP = fVar.p();
            boolean z2 = fVarP != fVar;
            m mVar = m.this;
            if (z2) {
                fVar = fVarP;
            }
            d dVarA = mVar.a((Menu) fVar);
            if (dVarA != null) {
                if (!z2) {
                    m.this.a(dVarA, z);
                } else {
                    m.this.a(dVarA.f1127a, dVarA, fVarP);
                    m.this.a(dVarA, true);
                }
            }
        }

        @Override // android.support.v7.view.menu.l.a
        public boolean a(android.support.v7.view.menu.f fVar) {
            Window.Callback callbackQ;
            if (fVar != null || !m.this.h || (callbackQ = m.this.q()) == null || m.this.p()) {
                return true;
            }
            callbackQ.onMenuOpened(108, fVar);
            return true;
        }
    }

    m(Context context, Window window, g gVar) {
        super(context, window, gVar);
        this.q = null;
        this.G = new Runnable() { // from class: android.support.v7.a.m.1
            @Override // java.lang.Runnable
            public void run() {
                if ((m.this.F & 1) != 0) {
                    m.this.f(0);
                }
                if ((m.this.F & 4096) != 0) {
                    m.this.f(108);
                }
                m.this.E = false;
                m.this.F = 0;
            }
        };
    }

    private d a(int i, boolean z) {
        d[] dVarArr = this.B;
        if (dVarArr == null || dVarArr.length <= i) {
            d[] dVarArr2 = new d[i + 1];
            if (dVarArr != null) {
                System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
            }
            this.B = dVarArr2;
            dVarArr = dVarArr2;
        }
        d dVar = dVarArr[i];
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(i);
        dVarArr[i] = dVar2;
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d a(Menu menu) {
        d[] dVarArr = this.B;
        int length = dVarArr != null ? dVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            d dVar = dVarArr[i];
            if (dVar != null && dVar.j == menu) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, d dVar, Menu menu) {
        if (menu == null) {
            if (dVar == null && i >= 0 && i < this.B.length) {
                dVar = this.B[i];
            }
            if (dVar != null) {
                menu = dVar.j;
            }
        }
        if ((dVar == null || dVar.o) && !p()) {
            this.f1107c.onPanelClosed(i, menu);
        }
    }

    private void a(d dVar, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (dVar.o || p()) {
            return;
        }
        if (dVar.f1127a == 0) {
            Context context = this.f1105a;
            boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
            boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (z && z2) {
                return;
            }
        }
        Window.Callback callbackQ = q();
        if (callbackQ != null && !callbackQ.onMenuOpened(dVar.f1127a, dVar.j)) {
            a(dVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1105a.getSystemService("window");
        if (windowManager == null || !b(dVar, keyEvent)) {
            return;
        }
        if (dVar.g == null || dVar.q) {
            if (dVar.g == null) {
                if (!a(dVar) || dVar.g == null) {
                    return;
                }
            } else if (dVar.q && dVar.g.getChildCount() > 0) {
                dVar.g.removeAllViews();
            }
            if (!c(dVar) || !dVar.a()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = dVar.h.getLayoutParams();
            ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
            dVar.g.setBackgroundResource(dVar.f1128b);
            ViewParent parent = dVar.h.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(dVar.h);
            }
            dVar.g.addView(dVar.h, layoutParams3);
            if (!dVar.h.hasFocus()) {
                dVar.h.requestFocus();
            }
            i = -2;
        } else if (dVar.i == null || (layoutParams = dVar.i.getLayoutParams()) == null || layoutParams.width != -1) {
            i = -2;
        }
        dVar.n = false;
        WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, dVar.f1130d, dVar.f1131e, 1002, 8519680, -3);
        layoutParams4.gravity = dVar.f1129c;
        layoutParams4.windowAnimations = dVar.f1132f;
        windowManager.addView(dVar.g, layoutParams4);
        dVar.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, boolean z) {
        if (z && dVar.f1127a == 0 && this.r != null && this.r.e()) {
            b(dVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1105a.getSystemService("window");
        if (windowManager != null && dVar.o && dVar.g != null) {
            windowManager.removeView(dVar.g);
            if (z) {
                a(dVar.f1127a, dVar, (Menu) null);
            }
        }
        dVar.m = false;
        dVar.n = false;
        dVar.o = false;
        dVar.h = null;
        dVar.q = true;
        if (this.C == dVar) {
            this.C = null;
        }
    }

    private void a(android.support.v7.view.menu.f fVar, boolean z) {
        if (this.r == null || !this.r.d() || (at.b(ViewConfiguration.get(this.f1105a)) && !this.r.f())) {
            d dVarA = a(0, true);
            dVarA.q = true;
            a(dVarA, false);
            a(dVarA, (KeyEvent) null);
            return;
        }
        Window.Callback callbackQ = q();
        if (this.r.e() && z) {
            this.r.h();
            if (p()) {
                return;
            }
            callbackQ.onPanelClosed(108, a(0, true).j);
            return;
        }
        if (callbackQ == null || p()) {
            return;
        }
        if (this.E && (this.F & 1) != 0) {
            this.f1106b.getDecorView().removeCallbacks(this.G);
            this.G.run();
        }
        d dVarA2 = a(0, true);
        if (dVarA2.j == null || dVarA2.r || !callbackQ.onPreparePanel(0, dVarA2.i, dVarA2.j)) {
            return;
        }
        callbackQ.onMenuOpened(108, dVarA2.j);
        this.r.g();
    }

    private boolean a(d dVar) {
        dVar.a(n());
        dVar.g = new c(dVar.l);
        dVar.f1129c = 81;
        return true;
    }

    private boolean a(d dVar, int i, KeyEvent keyEvent, int i2) {
        boolean zPerformShortcut = false;
        if (!keyEvent.isSystem()) {
            if ((dVar.m || b(dVar, keyEvent)) && dVar.j != null) {
                zPerformShortcut = dVar.j.performShortcut(i, keyEvent, i2);
            }
            if (zPerformShortcut && (i2 & 1) == 0 && this.r == null) {
                a(dVar, true);
            }
        }
        return zPerformShortcut;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1106b.getDecorView();
        for (ViewParent parent = viewParent; parent != null; parent = parent.getParent()) {
            if (parent == decorView || !(parent instanceof View) || ah.F((View) parent)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(android.support.v7.view.menu.f fVar) {
        if (this.A) {
            return;
        }
        this.A = true;
        this.r.j();
        Window.Callback callbackQ = q();
        if (callbackQ != null && !p()) {
            callbackQ.onPanelClosed(108, fVar);
        }
        this.A = false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    private boolean b(d dVar) {
        Context dVar2;
        Context context = this.f1105a;
        if ((dVar.f1127a == 0 || dVar.f1127a == 108) && this.r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(android.support.v7.b.a.C0029a.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(android.support.v7.b.a.C0029a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(android.support.v7.b.a.C0029a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            Resources.Theme theme2 = themeNewTheme;
            if (theme2 != null) {
                dVar2 = new android.support.v7.view.d(context, 0);
                dVar2.getTheme().setTo(theme2);
            } else {
                dVar2 = context;
            }
        } else {
            dVar2 = context;
        }
        android.support.v7.view.menu.f fVar = new android.support.v7.view.menu.f(dVar2);
        fVar.a(this);
        dVar.a(fVar);
        return true;
    }

    private boolean b(d dVar, KeyEvent keyEvent) {
        if (p()) {
            return false;
        }
        if (dVar.m) {
            return true;
        }
        if (this.C != null && this.C != dVar) {
            a(this.C, false);
        }
        Window.Callback callbackQ = q();
        if (callbackQ != null) {
            dVar.i = callbackQ.onCreatePanelView(dVar.f1127a);
        }
        boolean z = dVar.f1127a == 0 || dVar.f1127a == 108;
        if (z && this.r != null) {
            this.r.i();
        }
        if (dVar.i == null && (!z || !(m() instanceof p))) {
            if (dVar.j == null || dVar.r) {
                if (dVar.j == null && (!b(dVar) || dVar.j == null)) {
                    return false;
                }
                if (z && this.r != null) {
                    if (this.s == null) {
                        this.s = new a();
                    }
                    this.r.a(dVar.j, this.s);
                }
                dVar.j.g();
                if (!callbackQ.onCreatePanelMenu(dVar.f1127a, dVar.j)) {
                    dVar.a((android.support.v7.view.menu.f) null);
                    if (!z || this.r == null) {
                        return false;
                    }
                    this.r.a(null, this.s);
                    return false;
                }
                dVar.r = false;
            }
            dVar.j.g();
            if (dVar.s != null) {
                dVar.j.d(dVar.s);
                dVar.s = null;
            }
            if (!callbackQ.onPreparePanel(0, dVar.i, dVar.j)) {
                if (z && this.r != null) {
                    this.r.a(null, this.s);
                }
                dVar.j.h();
                return false;
            }
            dVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            dVar.j.setQwertyMode(dVar.p);
            dVar.j.h();
        }
        dVar.m = true;
        dVar.n = false;
        this.C = dVar;
        return true;
    }

    private boolean c(d dVar) {
        if (dVar.i != null) {
            dVar.h = dVar.i;
            return true;
        }
        if (dVar.j == null) {
            return false;
        }
        if (this.t == null) {
            this.t = new e();
        }
        dVar.h = (View) dVar.a(this.t);
        return dVar.h != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        a(a(i, true), true);
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            d dVarA = a(i, true);
            if (!dVarA.o) {
                return b(dVarA, keyEvent);
            }
        }
        return false;
    }

    private void e(int i) {
        this.F |= 1 << i;
        if (this.E) {
            return;
        }
        ah.a(this.f1106b.getDecorView(), this.G);
        this.E = true;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0085  */
    private boolean e(int i, KeyEvent keyEvent) {
        boolean zB;
        boolean zH = true;
        if (this.m != null) {
            return false;
        }
        d dVarA = a(i, true);
        if (i != 0 || this.r == null || !this.r.d() || at.b(ViewConfiguration.get(this.f1105a))) {
            if (dVarA.o || dVarA.n) {
                boolean z = dVarA.o;
                a(dVarA, true);
                zH = z;
            } else if (dVarA.m) {
                if (dVarA.r) {
                    dVarA.m = false;
                    zB = b(dVarA, keyEvent);
                } else {
                    zB = true;
                }
                if (zB) {
                    a(dVarA, keyEvent);
                } else {
                    zH = false;
                }
            } else {
                zH = false;
            }
        } else if (this.r.e()) {
            zH = this.r.h();
        } else if (p() || !b(dVarA, keyEvent)) {
            zH = false;
        } else {
            zH = this.r.g();
        }
        if (zH) {
            AudioManager audioManager = (AudioManager) this.f1105a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        d dVarA;
        d dVarA2 = a(i, true);
        if (dVarA2.j != null) {
            Bundle bundle = new Bundle();
            dVarA2.j.c(bundle);
            if (bundle.size() > 0) {
                dVarA2.s = bundle;
            }
            dVarA2.j.g();
            dVarA2.j.clear();
        }
        dVarA2.r = true;
        dVarA2.q = true;
        if ((i != 108 && i != 0) || this.r == null || (dVarA = a(0, false)) == null) {
            return;
        }
        dVarA.m = false;
        b(dVarA, (KeyEvent) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (this.n == null || !(this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
            if (this.n.isShown()) {
                if (this.I == null) {
                    this.I = new Rect();
                    this.J = new Rect();
                }
                Rect rect = this.I;
                Rect rect2 = this.J;
                rect.set(0, i, 0, 0);
                android.support.v7.widget.at.a(this.v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.x == null) {
                        this.x = new View(this.f1105a);
                        this.x.setBackgroundColor(this.f1105a.getResources().getColor(android.support.v7.b.a.c.abc_input_method_navigation_guard));
                        this.v.addView(this.x, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.x.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                z4 = this.x != null;
                if (!this.j && z4) {
                    i = 0;
                }
                boolean z5 = z3;
                z2 = z4;
                z4 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z4 = false;
                z2 = false;
            }
            if (z4) {
                this.n.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.x != null) {
            this.x.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    private int h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i != 9) {
            return i;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private void t() {
        if (this.u) {
            return;
        }
        this.v = u();
        CharSequence charSequenceR = r();
        if (!TextUtils.isEmpty(charSequenceR)) {
            b(charSequenceR);
        }
        v();
        a(this.v);
        this.u = true;
        d dVarA = a(0, false);
        if (p()) {
            return;
        }
        if (dVarA == null || dVarA.j == null) {
            e(108);
        }
    }

    private ViewGroup u() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f1105a.obtainStyledAttributes(android.support.v7.b.a.k.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.AppCompatTheme_windowNoTitle, false)) {
            c(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.AppCompatTheme_windowActionBar, false)) {
            c(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.AppCompatTheme_windowActionBarOverlay, false)) {
            c(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.AppCompatTheme_windowActionModeOverlay, false)) {
            c(10);
        }
        this.k = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f1106b.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1105a);
        if (this.l) {
            ViewGroup viewGroup2 = this.j ? (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.b.a.h.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.b.a.h.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                ah.a(viewGroup2, new ab() { // from class: android.support.v7.a.m.2
                    @Override // android.support.v4.view.ab
                    public bh a(View view, bh bhVar) {
                        int iB = bhVar.b();
                        int iG = m.this.g(iB);
                        if (iB != iG) {
                            bhVar = bhVar.a(bhVar.a(), iG, bhVar.c(), bhVar.d());
                        }
                        return ah.a(view, bhVar);
                    }
                });
                viewGroup = viewGroup2;
            } else {
                ((x) viewGroup2).setOnFitSystemWindowsListener(new x.a() { // from class: android.support.v7.a.m.3
                    @Override // android.support.v7.widget.x.a
                    public void a(Rect rect) {
                        rect.top = m.this.g(rect.top);
                    }
                });
                viewGroup = viewGroup2;
            }
        } else if (this.k) {
            ViewGroup viewGroup3 = (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.b.a.h.abc_dialog_title_material, (ViewGroup) null);
            this.i = false;
            this.h = false;
            viewGroup = viewGroup3;
        } else if (this.h) {
            TypedValue typedValue = new TypedValue();
            this.f1105a.getTheme().resolveAttribute(android.support.v7.b.a.C0029a.actionBarTheme, typedValue, true);
            ViewGroup viewGroup4 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.f1105a, typedValue.resourceId) : this.f1105a).inflate(android.support.v7.b.a.h.abc_screen_toolbar, (ViewGroup) null);
            this.r = (t) viewGroup4.findViewById(android.support.v7.b.a.f.decor_content_parent);
            this.r.setWindowCallback(q());
            if (this.i) {
                this.r.a(109);
            }
            if (this.y) {
                this.r.a(2);
            }
            if (this.z) {
                this.r.a(5);
            }
            viewGroup = viewGroup4;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        }
        if (this.r == null) {
            this.w = (TextView) viewGroup.findViewById(android.support.v7.b.a.f.title);
        }
        android.support.v7.widget.at.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(android.support.v7.b.a.f.action_bar_activity_content);
        ViewGroup viewGroup5 = (ViewGroup) this.f1106b.findViewById(R.id.content);
        if (viewGroup5 != null) {
            while (viewGroup5.getChildCount() > 0) {
                View childAt = viewGroup5.getChildAt(0);
                viewGroup5.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup5.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup5 instanceof FrameLayout) {
                ((FrameLayout) viewGroup5).setForeground(null);
            }
        }
        this.f1106b.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a() { // from class: android.support.v7.a.m.4
            @Override // android.support.v7.widget.ContentFrameLayout.a
            public void a() {
            }

            @Override // android.support.v7.widget.ContentFrameLayout.a
            public void b() {
                m.this.y();
            }
        });
        return viewGroup;
    }

    private void v() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.v.findViewById(R.id.content);
        View decorView = this.f1106b.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f1105a.obtainStyledAttributes(android.support.v7.b.a.k.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(android.support.v7.b.a.k.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(android.support.v7.b.a.k.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.b.a.k.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.b.a.k.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.b.a.k.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.b.a.k.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.b.a.k.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.q != null) {
            this.q.b();
        }
    }

    private void x() {
        if (this.u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.r != null) {
            this.r.j();
        }
        if (this.o != null) {
            this.f1106b.getDecorView().removeCallbacks(this.p);
            if (this.o.isShowing()) {
                try {
                    this.o.dismiss();
                } catch (IllegalArgumentException e2) {
                }
            }
            this.o = null;
        }
        w();
        d dVarA = a(0, false);
        if (dVarA == null || dVarA.j == null) {
            return;
        }
        dVarA.j.close();
    }

    @Override // android.support.v7.a.i
    android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        android.support.v7.view.b bVarA;
        Context dVar;
        w();
        if (this.m != null) {
            this.m.c();
        }
        b bVar = new b(aVar);
        if (this.f1109e == null || p()) {
            bVarA = null;
        } else {
            try {
                bVarA = this.f1109e.a(bVar);
            } catch (AbstractMethodError e2) {
                bVarA = null;
            }
        }
        if (bVarA != null) {
            this.m = bVarA;
        } else {
            if (this.n == null) {
                if (this.k) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f1105a.getTheme();
                    theme.resolveAttribute(android.support.v7.b.a.C0029a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f1105a.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new android.support.v7.view.d(this.f1105a, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f1105a;
                    }
                    this.n = new ActionBarContextView(dVar);
                    this.o = new PopupWindow(dVar, (AttributeSet) null, android.support.v7.b.a.C0029a.actionModePopupWindowStyle);
                    android.support.v4.widget.q.a(this.o, 2);
                    this.o.setContentView(this.n);
                    this.o.setWidth(-1);
                    dVar.getTheme().resolveAttribute(android.support.v7.b.a.C0029a.actionBarSize, typedValue, true);
                    this.n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.o.setHeight(-2);
                    this.p = new Runnable() { // from class: android.support.v7.a.m.5
                        @Override // java.lang.Runnable
                        public void run() {
                            m.this.o.showAtLocation(m.this.n, 55, 0, 0);
                            m.this.w();
                            ah.c(m.this.n, BitmapDescriptorFactory.HUE_RED);
                            m.this.q = ah.s(m.this.n).a(1.0f);
                            m.this.q.a(new bf() { // from class: android.support.v7.a.m.5.1
                                @Override // android.support.v4.view.bf, android.support.v4.view.be
                                public void a(View view) {
                                    m.this.n.setVisibility(0);
                                }

                                @Override // android.support.v4.view.bf, android.support.v4.view.be
                                public void b(View view) {
                                    ah.c((View) m.this.n, 1.0f);
                                    m.this.q.a((be) null);
                                    m.this.q = null;
                                }
                            });
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.v.findViewById(android.support.v7.b.a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(n()));
                        this.n = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.n != null) {
                w();
                this.n.c();
                android.support.v7.view.e eVar = new android.support.v7.view.e(this.n.getContext(), this.n, bVar, this.o == null);
                if (aVar.a(eVar, eVar.b())) {
                    eVar.d();
                    this.n.a(eVar);
                    this.m = eVar;
                    ah.c(this.n, BitmapDescriptorFactory.HUE_RED);
                    this.q = ah.s(this.n).a(1.0f);
                    this.q.a(new bf() { // from class: android.support.v7.a.m.6
                        @Override // android.support.v4.view.bf, android.support.v4.view.be
                        public void a(View view) {
                            m.this.n.setVisibility(0);
                            m.this.n.sendAccessibilityEvent(32);
                            if (m.this.n.getParent() != null) {
                                ah.v((View) m.this.n.getParent());
                            }
                        }

                        @Override // android.support.v4.view.bf, android.support.v4.view.be
                        public void b(View view) {
                            ah.c((View) m.this.n, 1.0f);
                            m.this.q.a((be) null);
                            m.this.q = null;
                        }
                    });
                    if (this.o != null) {
                        this.f1106b.getDecorView().post(this.p);
                    }
                } else {
                    this.m = null;
                }
            }
        }
        if (this.m != null && this.f1109e != null) {
            this.f1109e.a(this.m);
        }
        return this.m;
    }

    @Override // android.support.v7.a.h
    public View a(int i) {
        t();
        return this.f1106b.findViewById(i);
    }

    @Override // android.support.v4.view.n
    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        View viewB = b(view, str, context, attributeSet);
        return viewB != null ? viewB : c(view, str, context, attributeSet);
    }

    @Override // android.support.v7.a.i
    void a(int i, Menu menu) {
        if (i == 108) {
            android.support.v7.a.a aVarA = a();
            if (aVarA != null) {
                aVarA.g(false);
                return;
            }
            return;
        }
        if (i == 0) {
            d dVarA = a(i, true);
            if (dVarA.o) {
                a(dVarA, false);
            }
        }
    }

    @Override // android.support.v7.a.h
    public void a(Configuration configuration) {
        android.support.v7.a.a aVarA;
        if (this.h && this.u && (aVarA = a()) != null) {
            aVarA.a(configuration);
        }
        i();
    }

    @Override // android.support.v7.a.h
    public void a(Bundle bundle) {
        if (!(this.f1107c instanceof Activity) || android.support.v4.app.ab.b((Activity) this.f1107c) == null) {
            return;
        }
        android.support.v7.a.a aVarM = m();
        if (aVarM == null) {
            this.H = true;
        } else {
            aVarM.e(true);
        }
    }

    @Override // android.support.v7.view.menu.f.a
    public void a(android.support.v7.view.menu.f fVar) {
        a(fVar, true);
    }

    @Override // android.support.v7.a.h
    public void a(View view) {
        t();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1107c.onContentChanged();
    }

    @Override // android.support.v7.a.h
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        t();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1107c.onContentChanged();
    }

    void a(ViewGroup viewGroup) {
    }

    @Override // android.support.v7.a.i
    boolean a(int i, KeyEvent keyEvent) {
        android.support.v7.a.a aVarA = a();
        if (aVarA != null && aVarA.a(i, keyEvent)) {
            return true;
        }
        if (this.C != null && a(this.C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.C == null) {
                return true;
            }
            this.C.n = true;
            return true;
        }
        if (this.C == null) {
            d dVarA = a(0, true);
            b(dVarA, keyEvent);
            boolean zA = a(dVarA, keyEvent.getKeyCode(), keyEvent, 1);
            dVarA.m = false;
            if (zA) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.f.a
    public boolean a(android.support.v7.view.menu.f fVar, MenuItem menuItem) {
        d dVarA;
        Window.Callback callbackQ = q();
        if (callbackQ == null || p() || (dVarA = a((Menu) fVar.p())) == null) {
            return false;
        }
        return callbackQ.onMenuItemSelected(dVarA.f1127a, menuItem);
    }

    @Override // android.support.v7.a.i
    boolean a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.f1107c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    public android.support.v7.view.b b(android.support.v7.view.b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.m != null) {
            this.m.c();
        }
        b bVar = new b(aVar);
        android.support.v7.a.a aVarA = a();
        if (aVarA != null) {
            this.m = aVarA.a(bVar);
            if (this.m != null && this.f1109e != null) {
                this.f1109e.a(this.m);
            }
        }
        if (this.m == null) {
            this.m = a(bVar);
        }
        return this.m;
    }

    View b(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView;
        if (!(this.f1107c instanceof LayoutInflater.Factory) || (viewOnCreateView = ((LayoutInflater.Factory) this.f1107c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return viewOnCreateView;
    }

    @Override // android.support.v7.a.h
    public void b(int i) {
        t();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1105a).inflate(i, viewGroup);
        this.f1107c.onContentChanged();
    }

    @Override // android.support.v7.a.h
    public void b(Bundle bundle) {
        t();
    }

    @Override // android.support.v7.a.h
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        t();
        ((ViewGroup) this.v.findViewById(R.id.content)).addView(view, layoutParams);
        this.f1107c.onContentChanged();
    }

    @Override // android.support.v7.a.i
    void b(CharSequence charSequence) {
        if (this.r != null) {
            this.r.setWindowTitle(charSequence);
        } else if (m() != null) {
            m().b(charSequence);
        } else if (this.w != null) {
            this.w.setText(charSequence);
        }
    }

    boolean b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.D;
                this.D = false;
                d dVarA = a(0, false);
                if (dVarA != null && dVarA.o) {
                    if (z) {
                        return true;
                    }
                    a(dVarA, true);
                    return true;
                }
                if (s()) {
                    return true;
                }
                break;
            case 82:
                e(0, keyEvent);
                return true;
        }
        return false;
    }

    @Override // android.support.v7.a.i
    boolean b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        android.support.v7.a.a aVarA = a();
        if (aVarA == null) {
            return true;
        }
        aVarA.g(true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = Build.VERSION.SDK_INT < 21;
        if (this.K == null) {
            this.K = new o();
        }
        return this.K.a(view, str, context, attributeSet, z && a((ViewParent) view), z, true, ar.a());
    }

    @Override // android.support.v7.a.h
    public void c() {
        android.support.v7.a.a aVarA = a();
        if (aVarA != null) {
            aVarA.f(false);
        }
    }

    @Override // android.support.v7.a.h
    public boolean c(int i) {
        int iH = h(i);
        if (this.l && iH == 108) {
            return false;
        }
        if (this.h && iH == 1) {
            this.h = false;
        }
        switch (iH) {
            case 1:
                x();
                this.l = true;
                return true;
            case 2:
                x();
                this.y = true;
                return true;
            case 5:
                x();
                this.z = true;
                return true;
            case 10:
                x();
                this.j = true;
                return true;
            case 108:
                x();
                this.h = true;
                return true;
            case 109:
                x();
                this.i = true;
                return true;
            default:
                return this.f1106b.requestFeature(iH);
        }
    }

    boolean c(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                this.D = (keyEvent.getFlags() & 128) != 0;
                break;
            case 82:
                d(0, keyEvent);
                return true;
        }
        if (Build.VERSION.SDK_INT < 11) {
            a(i, keyEvent);
        }
        return false;
    }

    @Override // android.support.v7.a.h
    public void d() {
        android.support.v7.a.a aVarA = a();
        if (aVarA != null) {
            aVarA.f(true);
        }
    }

    @Override // android.support.v7.a.h
    public void e() {
        android.support.v7.a.a aVarA = a();
        if (aVarA == null || !aVarA.f()) {
            e(0);
        }
    }

    @Override // android.support.v7.a.i, android.support.v7.a.h
    public void f() {
        super.f();
        if (this.f1110f != null) {
            this.f1110f.i();
        }
    }

    @Override // android.support.v7.a.h
    public void h() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1105a);
        if (layoutInflaterFrom.getFactory() == null) {
            android.support.v4.view.j.a(layoutInflaterFrom, this);
        } else {
            if (android.support.v4.view.j.a(layoutInflaterFrom) instanceof m) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.support.v7.a.i
    public void l() {
        t();
        if (this.h && this.f1110f == null) {
            if (this.f1107c instanceof Activity) {
                this.f1110f = new s((Activity) this.f1107c, this.i);
            } else if (this.f1107c instanceof Dialog) {
                this.f1110f = new s((Dialog) this.f1107c);
            }
            if (this.f1110f != null) {
                this.f1110f.e(this.H);
            }
        }
    }

    boolean s() {
        if (this.m != null) {
            this.m.c();
            return true;
        }
        android.support.v7.a.a aVarA = a();
        return aVarA != null && aVarA.g();
    }
}
