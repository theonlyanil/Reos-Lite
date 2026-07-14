package android.support.v7.a;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.support.v4.view.bg;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ah;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class s extends android.support.v7.a.a implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean h;
    private static final Interpolator i;
    private static final Interpolator j;
    private static final boolean k;
    private boolean A;
    private boolean D;
    private boolean E;
    private boolean F;
    private android.support.v7.view.h H;
    private boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f1167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    android.support.v7.view.b f1168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.support.v7.view.b.a f1169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f1170d;
    private Context l;
    private Context m;
    private Activity n;
    private Dialog o;
    private ActionBarOverlayLayout p;
    private ActionBarContainer q;
    private u r;
    private ActionBarContextView s;
    private View t;
    private ah u;
    private boolean x;
    private boolean y;
    private ArrayList<Object> v = new ArrayList<>();
    private int w = -1;
    private ArrayList<android.support.v7.a.a.b> z = new ArrayList<>();
    private int B = 0;
    private boolean C = true;
    private boolean G = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final be f1171e = new bf() { // from class: android.support.v7.a.s.1
        @Override // android.support.v4.view.bf, android.support.v4.view.be
        public void b(View view) {
            if (s.this.C && s.this.t != null) {
                android.support.v4.view.ah.b(s.this.t, BitmapDescriptorFactory.HUE_RED);
                android.support.v4.view.ah.b(s.this.q, BitmapDescriptorFactory.HUE_RED);
            }
            s.this.q.setVisibility(8);
            s.this.q.setTransitioning(false);
            s.this.H = null;
            s.this.j();
            if (s.this.p != null) {
                android.support.v4.view.ah.v(s.this.p);
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final be f1172f = new bf() { // from class: android.support.v7.a.s.2
        @Override // android.support.v4.view.bf, android.support.v4.view.be
        public void b(View view) {
            s.this.H = null;
            s.this.q.requestLayout();
        }
    };
    final bg g = new bg() { // from class: android.support.v7.a.s.3
        @Override // android.support.v4.view.bg
        public void a(View view) {
            ((View) s.this.q.getParent()).invalidate();
        }
    };

    public class a extends android.support.v7.view.b implements android.support.v7.view.menu.f.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f1177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final android.support.v7.view.menu.f f1178c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private android.support.v7.view.b.a f1179d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private WeakReference<View> f1180e;

        public a(Context context, android.support.v7.view.b.a aVar) {
            this.f1177b = context;
            this.f1179d = aVar;
            this.f1178c = new android.support.v7.view.menu.f(context).a(1);
            this.f1178c.a(this);
        }

        @Override // android.support.v7.view.b
        public MenuInflater a() {
            return new android.support.v7.view.g(this.f1177b);
        }

        @Override // android.support.v7.view.b
        public void a(int i) {
            b(s.this.l.getResources().getString(i));
        }

        @Override // android.support.v7.view.menu.f.a
        public void a(android.support.v7.view.menu.f fVar) {
            if (this.f1179d == null) {
                return;
            }
            d();
            s.this.s.a();
        }

        @Override // android.support.v7.view.b
        public void a(View view) {
            s.this.s.setCustomView(view);
            this.f1180e = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.b
        public void a(CharSequence charSequence) {
            s.this.s.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.b
        public void a(boolean z) {
            super.a(z);
            s.this.s.setTitleOptional(z);
        }

        @Override // android.support.v7.view.menu.f.a
        public boolean a(android.support.v7.view.menu.f fVar, MenuItem menuItem) {
            if (this.f1179d != null) {
                return this.f1179d.a(this, menuItem);
            }
            return false;
        }

        @Override // android.support.v7.view.b
        public Menu b() {
            return this.f1178c;
        }

        @Override // android.support.v7.view.b
        public void b(int i) {
            a((CharSequence) s.this.l.getResources().getString(i));
        }

        @Override // android.support.v7.view.b
        public void b(CharSequence charSequence) {
            s.this.s.setTitle(charSequence);
        }

        @Override // android.support.v7.view.b
        public void c() {
            if (s.this.f1167a != this) {
                return;
            }
            if (s.b(s.this.D, s.this.E, false)) {
                this.f1179d.a(this);
            } else {
                s.this.f1168b = this;
                s.this.f1169c = this.f1179d;
            }
            this.f1179d = null;
            s.this.k(false);
            s.this.s.b();
            s.this.r.a().sendAccessibilityEvent(32);
            s.this.p.setHideOnContentScrollEnabled(s.this.f1170d);
            s.this.f1167a = null;
        }

        @Override // android.support.v7.view.b
        public void d() {
            if (s.this.f1167a != this) {
                return;
            }
            this.f1178c.g();
            try {
                this.f1179d.b(this, this.f1178c);
            } finally {
                this.f1178c.h();
            }
        }

        public boolean e() {
            this.f1178c.g();
            try {
                return this.f1179d.a(this, this.f1178c);
            } finally {
                this.f1178c.h();
            }
        }

        @Override // android.support.v7.view.b
        public CharSequence f() {
            return s.this.s.getTitle();
        }

        @Override // android.support.v7.view.b
        public CharSequence g() {
            return s.this.s.getSubtitle();
        }

        @Override // android.support.v7.view.b
        public boolean h() {
            return s.this.s.d();
        }

        @Override // android.support.v7.view.b
        public View i() {
            if (this.f1180e != null) {
                return this.f1180e.get();
            }
            return null;
        }
    }

    static {
        h = !s.class.desiredAssertionStatus();
        i = new AccelerateInterpolator();
        j = new DecelerateInterpolator();
        k = Build.VERSION.SDK_INT >= 14;
    }

    public s(Activity activity, boolean z) {
        this.n = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (z) {
            return;
        }
        this.t = decorView.findViewById(R.id.content);
    }

    public s(Dialog dialog) {
        this.o = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.p = (ActionBarOverlayLayout) view.findViewById(android.support.v7.b.a.f.decor_content_parent);
        if (this.p != null) {
            this.p.setActionBarVisibilityCallback(this);
        }
        this.r = b(view.findViewById(android.support.v7.b.a.f.action_bar));
        this.s = (ActionBarContextView) view.findViewById(android.support.v7.b.a.f.action_context_bar);
        this.q = (ActionBarContainer) view.findViewById(android.support.v7.b.a.f.action_bar_container);
        if (this.r == null || this.s == null || this.q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.l = this.r.b();
        boolean z = (this.r.o() & 4) != 0;
        if (z) {
            this.x = true;
        }
        android.support.v7.view.a aVarA = android.support.v7.view.a.a(this.l);
        c(aVarA.f() || z);
        l(aVarA.d());
        TypedArray typedArrayObtainStyledAttributes = this.l.obtainStyledAttributes(null, android.support.v7.b.a.k.ActionBar, android.support.v7.b.a.C0029a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.ActionBar_hideOnContentScroll, false)) {
            d(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.b.a.k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private u b(View view) {
        if (view instanceof u) {
            return (u) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private void l(boolean z) {
        this.A = z;
        if (this.A) {
            this.q.setTabContainer(null);
            this.r.a(this.u);
        } else {
            this.r.a((ah) null);
            this.q.setTabContainer(this.u);
        }
        boolean z2 = k() == 2;
        if (this.u != null) {
            if (z2) {
                this.u.setVisibility(0);
                if (this.p != null) {
                    android.support.v4.view.ah.v(this.p);
                }
            } else {
                this.u.setVisibility(8);
            }
        }
        this.r.a(!this.A && z2);
        this.p.setHasNonEmbeddedTabs(!this.A && z2);
    }

    private void m(boolean z) {
        if (b(this.D, this.E, this.F)) {
            if (this.G) {
                return;
            }
            this.G = true;
            i(z);
            return;
        }
        if (this.G) {
            this.G = false;
            j(z);
        }
    }

    private void q() {
        if (this.F) {
            return;
        }
        this.F = true;
        if (this.p != null) {
            this.p.setShowingForActionMode(true);
        }
        m(false);
    }

    private void r() {
        if (this.F) {
            this.F = false;
            if (this.p != null) {
                this.p.setShowingForActionMode(false);
            }
            m(false);
        }
    }

    @Override // android.support.v7.a.a
    public int a() {
        return this.r.o();
    }

    @Override // android.support.v7.a.a
    public android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        if (this.f1167a != null) {
            this.f1167a.c();
        }
        this.p.setHideOnContentScrollEnabled(false);
        this.s.c();
        a aVar2 = new a(this.s.getContext(), aVar);
        if (!aVar2.e()) {
            return null;
        }
        aVar2.d();
        this.s.a(aVar2);
        k(true);
        this.s.sendAccessibilityEvent(32);
        this.f1167a = aVar2;
        return aVar2;
    }

    @Override // android.support.v7.a.a
    public void a(float f2) {
        android.support.v4.view.ah.d(this.q, f2);
    }

    @Override // android.support.v7.a.a
    public void a(int i2) {
        this.r.d(i2);
    }

    public void a(int i2, int i3) {
        int iO = this.r.o();
        if ((i3 & 4) != 0) {
            this.x = true;
        }
        this.r.c((iO & (i3 ^ (-1))) | (i2 & i3));
    }

    @Override // android.support.v7.a.a
    public void a(Configuration configuration) {
        l(android.support.v7.view.a.a(this.l).d());
    }

    @Override // android.support.v7.a.a
    public void a(Drawable drawable) {
        this.q.setPrimaryBackground(drawable);
    }

    @Override // android.support.v7.a.a
    public void a(CharSequence charSequence) {
        this.r.b(charSequence);
    }

    @Override // android.support.v7.a.a
    public void a(boolean z) {
        a(z ? 2 : 0, 2);
    }

    @Override // android.support.v7.a.a
    public void b() {
        if (this.D) {
            return;
        }
        this.D = true;
        m(false);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void b(int i2) {
        this.B = i2;
    }

    @Override // android.support.v7.a.a
    public void b(Drawable drawable) {
        this.r.b(drawable);
    }

    @Override // android.support.v7.a.a
    public void b(CharSequence charSequence) {
        this.r.a(charSequence);
    }

    @Override // android.support.v7.a.a
    public void b(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.a.a
    public void c(boolean z) {
        this.r.b(z);
    }

    @Override // android.support.v7.a.a
    public boolean c() {
        int iL = l();
        return this.G && (iL == 0 || e() < iL);
    }

    @Override // android.support.v7.a.a
    public Context d() {
        if (this.m == null) {
            TypedValue typedValue = new TypedValue();
            this.l.getTheme().resolveAttribute(android.support.v7.b.a.C0029a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.m = new ContextThemeWrapper(this.l, i2);
            } else {
                this.m = this.l;
            }
        }
        return this.m;
    }

    @Override // android.support.v7.a.a
    public void d(boolean z) {
        if (z && !this.p.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f1170d = z;
        this.p.setHideOnContentScrollEnabled(z);
    }

    @Override // android.support.v7.a.a
    public int e() {
        return this.p.getActionBarHideOffset();
    }

    @Override // android.support.v7.a.a
    public void e(boolean z) {
        if (this.x) {
            return;
        }
        b(z);
    }

    @Override // android.support.v7.a.a
    public void f(boolean z) {
        this.I = z;
        if (z || this.H == null) {
            return;
        }
        this.H.b();
    }

    @Override // android.support.v7.a.a
    public void g(boolean z) {
        if (z == this.y) {
            return;
        }
        this.y = z;
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.z.get(i2).a(z);
        }
    }

    @Override // android.support.v7.a.a
    public boolean g() {
        if (this.r == null || !this.r.c()) {
            return false;
        }
        this.r.d();
        return true;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void h(boolean z) {
        this.C = z;
    }

    @Override // android.support.v7.a.a
    public boolean h() {
        ViewGroup viewGroupA = this.r.a();
        if (viewGroupA == null || viewGroupA.hasFocus()) {
            return false;
        }
        viewGroupA.requestFocus();
        return true;
    }

    public void i(boolean z) {
        if (this.H != null) {
            this.H.b();
        }
        this.q.setVisibility(0);
        if (this.B == 0 && k && (this.I || z)) {
            android.support.v4.view.ah.b(this.q, BitmapDescriptorFactory.HUE_RED);
            float f2 = -this.q.getHeight();
            if (z) {
                int[] iArr = {0, 0};
                this.q.getLocationInWindow(iArr);
                f2 -= iArr[1];
            }
            android.support.v4.view.ah.b(this.q, f2);
            android.support.v7.view.h hVar = new android.support.v7.view.h();
            ba baVarC = android.support.v4.view.ah.s(this.q).c(BitmapDescriptorFactory.HUE_RED);
            baVarC.a(this.g);
            hVar.a(baVarC);
            if (this.C && this.t != null) {
                android.support.v4.view.ah.b(this.t, f2);
                hVar.a(android.support.v4.view.ah.s(this.t).c(BitmapDescriptorFactory.HUE_RED));
            }
            hVar.a(j);
            hVar.a(250L);
            hVar.a(this.f1172f);
            this.H = hVar;
            hVar.a();
        } else {
            android.support.v4.view.ah.c((View) this.q, 1.0f);
            android.support.v4.view.ah.b(this.q, BitmapDescriptorFactory.HUE_RED);
            if (this.C && this.t != null) {
                android.support.v4.view.ah.b(this.t, BitmapDescriptorFactory.HUE_RED);
            }
            this.f1172f.b(null);
        }
        if (this.p != null) {
            android.support.v4.view.ah.v(this.p);
        }
    }

    void j() {
        if (this.f1169c != null) {
            this.f1169c.a(this.f1168b);
            this.f1168b = null;
            this.f1169c = null;
        }
    }

    public void j(boolean z) {
        if (this.H != null) {
            this.H.b();
        }
        if (this.B != 0 || !k || (!this.I && !z)) {
            this.f1171e.b(null);
            return;
        }
        android.support.v4.view.ah.c((View) this.q, 1.0f);
        this.q.setTransitioning(true);
        android.support.v7.view.h hVar = new android.support.v7.view.h();
        float f2 = -this.q.getHeight();
        if (z) {
            int[] iArr = {0, 0};
            this.q.getLocationInWindow(iArr);
            f2 -= iArr[1];
        }
        ba baVarC = android.support.v4.view.ah.s(this.q).c(f2);
        baVarC.a(this.g);
        hVar.a(baVarC);
        if (this.C && this.t != null) {
            hVar.a(android.support.v4.view.ah.s(this.t).c(f2));
        }
        hVar.a(i);
        hVar.a(250L);
        hVar.a(this.f1171e);
        this.H = hVar;
        hVar.a();
    }

    public int k() {
        return this.r.p();
    }

    public void k(boolean z) {
        ba baVarA;
        ba baVarA2;
        if (z) {
            q();
        } else {
            r();
        }
        if (z) {
            baVarA2 = this.r.a(4, 100L);
            baVarA = this.s.a(0, 200L);
        } else {
            baVarA = this.r.a(0, 200L);
            baVarA2 = this.s.a(8, 100L);
        }
        android.support.v7.view.h hVar = new android.support.v7.view.h();
        hVar.a(baVarA2, baVarA);
        hVar.a();
    }

    public int l() {
        return this.q.getHeight();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void m() {
        if (this.E) {
            this.E = false;
            m(true);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void n() {
        if (this.E) {
            return;
        }
        this.E = true;
        m(true);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void o() {
        if (this.H != null) {
            this.H.b();
            this.H = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void p() {
    }
}
