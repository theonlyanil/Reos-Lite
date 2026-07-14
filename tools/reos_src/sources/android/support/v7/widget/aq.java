package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ba;
import android.support.v4.view.bf;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class aq implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Toolbar f1750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f1752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f1753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f1754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f1755f;
    private Drawable g;
    private boolean h;
    private CharSequence i;
    private CharSequence j;
    private CharSequence k;
    private Window.Callback l;
    private boolean m;
    private ActionMenuPresenter n;
    private int o;
    private final h p;
    private int q;
    private Drawable r;

    public aq(Toolbar toolbar, boolean z) {
        this(toolbar, z, android.support.v7.b.a.i.abc_action_bar_up_description, android.support.v7.b.a.e.abc_ic_ab_back_mtrl_am_alpha);
    }

    public aq(Toolbar toolbar, boolean z, int i, int i2) {
        this.o = 0;
        this.q = 0;
        this.f1750a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        if (z) {
            ap apVarA = ap.a(toolbar.getContext(), null, android.support.v7.b.a.k.ActionBar, android.support.v7.b.a.C0029a.actionBarStyle, 0);
            CharSequence charSequenceC = apVarA.c(android.support.v7.b.a.k.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceC)) {
                b(charSequenceC);
            }
            CharSequence charSequenceC2 = apVarA.c(android.support.v7.b.a.k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceC2)) {
                c(charSequenceC2);
            }
            Drawable drawableA = apVarA.a(android.support.v7.b.a.k.ActionBar_logo);
            if (drawableA != null) {
                e(drawableA);
            }
            Drawable drawableA2 = apVarA.a(android.support.v7.b.a.k.ActionBar_icon);
            if (this.g == null && drawableA2 != null) {
                a(drawableA2);
            }
            Drawable drawableA3 = apVarA.a(android.support.v7.b.a.k.ActionBar_homeAsUpIndicator);
            if (drawableA3 != null) {
                b(drawableA3);
            }
            c(apVarA.a(android.support.v7.b.a.k.ActionBar_displayOptions, 0));
            int iG = apVarA.g(android.support.v7.b.a.k.ActionBar_customNavigationLayout, 0);
            if (iG != 0) {
                a(LayoutInflater.from(this.f1750a.getContext()).inflate(iG, (ViewGroup) this.f1750a, false));
                c(this.f1751b | 16);
            }
            int iF = apVarA.f(android.support.v7.b.a.k.ActionBar_height, 0);
            if (iF > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1750a.getLayoutParams();
                layoutParams.height = iF;
                this.f1750a.setLayoutParams(layoutParams);
            }
            int iD = apVarA.d(android.support.v7.b.a.k.ActionBar_contentInsetStart, -1);
            int iD2 = apVarA.d(android.support.v7.b.a.k.ActionBar_contentInsetEnd, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f1750a.a(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iG2 = apVarA.g(android.support.v7.b.a.k.ActionBar_titleTextStyle, 0);
            if (iG2 != 0) {
                this.f1750a.a(this.f1750a.getContext(), iG2);
            }
            int iG3 = apVarA.g(android.support.v7.b.a.k.ActionBar_subtitleTextStyle, 0);
            if (iG3 != 0) {
                this.f1750a.b(this.f1750a.getContext(), iG3);
            }
            int iG4 = apVarA.g(android.support.v7.b.a.k.ActionBar_popupTheme, 0);
            if (iG4 != 0) {
                this.f1750a.setPopupTheme(iG4);
            }
            apVarA.a();
        } else {
            this.f1751b = s();
        }
        this.p = h.a();
        f(i);
        this.k = this.f1750a.getNavigationContentDescription();
        d(this.p.a(b(), i2));
        this.f1750a.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.aq.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final android.support.v7.view.menu.a f1756a;

            {
                this.f1756a = new android.support.v7.view.menu.a(aq.this.f1750a.getContext(), 0, R.id.home, 0, 0, aq.this.i);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aq.this.l == null || !aq.this.m) {
                    return;
                }
                aq.this.l.onMenuItemSelected(0, this.f1756a);
            }
        });
    }

    private void e(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f1751b & 8) != 0) {
            this.f1750a.setTitle(charSequence);
        }
    }

    private int s() {
        return this.f1750a.getNavigationIcon() != null ? 15 : 11;
    }

    private void t() {
        Drawable drawable = null;
        if ((this.f1751b & 2) != 0) {
            drawable = ((this.f1751b & 1) == 0 || this.f1755f == null) ? this.f1754e : this.f1755f;
        }
        this.f1750a.setLogo(drawable);
    }

    private void u() {
        if ((this.f1751b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.f1750a.setNavigationContentDescription(this.q);
            } else {
                this.f1750a.setNavigationContentDescription(this.k);
            }
        }
    }

    private void v() {
        if ((this.f1751b & 4) != 0) {
            this.f1750a.setNavigationIcon(this.g != null ? this.g : this.r);
        }
    }

    @Override // android.support.v7.widget.u
    public ba a(final int i, long j) {
        return android.support.v4.view.ah.s(this.f1750a).a(i == 0 ? 1.0f : BitmapDescriptorFactory.HUE_RED).a(j).a(new bf() { // from class: android.support.v7.widget.aq.2

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f1760c = false;

            @Override // android.support.v4.view.bf, android.support.v4.view.be
            public void a(View view) {
                aq.this.f1750a.setVisibility(0);
            }

            @Override // android.support.v4.view.bf, android.support.v4.view.be
            public void b(View view) {
                if (this.f1760c) {
                    return;
                }
                aq.this.f1750a.setVisibility(i);
            }

            @Override // android.support.v4.view.bf, android.support.v4.view.be
            public void c(View view) {
                this.f1760c = true;
            }
        });
    }

    @Override // android.support.v7.widget.u
    public ViewGroup a() {
        return this.f1750a;
    }

    @Override // android.support.v7.widget.u
    public void a(int i) {
        a(i != 0 ? this.p.a(b(), i) : null);
    }

    @Override // android.support.v7.widget.u
    public void a(Drawable drawable) {
        this.f1754e = drawable;
        t();
    }

    @Override // android.support.v7.widget.u
    public void a(android.support.v7.view.menu.l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        this.f1750a.a(aVar, aVar2);
    }

    @Override // android.support.v7.widget.u
    public void a(ah ahVar) {
        if (this.f1752c != null && this.f1752c.getParent() == this.f1750a) {
            this.f1750a.removeView(this.f1752c);
        }
        this.f1752c = ahVar;
        if (ahVar == null || this.o != 2) {
            return;
        }
        this.f1750a.addView(this.f1752c, 0);
        Toolbar.b bVar = (Toolbar.b) this.f1752c.getLayoutParams();
        bVar.width = -2;
        bVar.height = -2;
        bVar.f1038a = 8388691;
        ahVar.setAllowCollapse(true);
    }

    @Override // android.support.v7.widget.u
    public void a(Menu menu, android.support.v7.view.menu.l.a aVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.f1750a.getContext());
            this.n.a(android.support.v7.b.a.f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f1750a.a((android.support.v7.view.menu.f) menu, this.n);
    }

    public void a(View view) {
        if (this.f1753d != null && (this.f1751b & 16) != 0) {
            this.f1750a.removeView(this.f1753d);
        }
        this.f1753d = view;
        if (view == null || (this.f1751b & 16) == 0) {
            return;
        }
        this.f1750a.addView(this.f1753d);
    }

    @Override // android.support.v7.widget.u
    public void a(Window.Callback callback) {
        this.l = callback;
    }

    @Override // android.support.v7.widget.u
    public void a(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        e(charSequence);
    }

    @Override // android.support.v7.widget.u
    public void a(boolean z) {
        this.f1750a.setCollapsible(z);
    }

    @Override // android.support.v7.widget.u
    public Context b() {
        return this.f1750a.getContext();
    }

    @Override // android.support.v7.widget.u
    public void b(int i) {
        e(i != 0 ? this.p.a(b(), i) : null);
    }

    @Override // android.support.v7.widget.u
    public void b(Drawable drawable) {
        this.g = drawable;
        v();
    }

    @Override // android.support.v7.widget.u
    public void b(CharSequence charSequence) {
        this.h = true;
        e(charSequence);
    }

    @Override // android.support.v7.widget.u
    public void b(boolean z) {
    }

    @Override // android.support.v7.widget.u
    public void c(int i) {
        int i2 = this.f1751b ^ i;
        this.f1751b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    v();
                    u();
                } else {
                    this.f1750a.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1750a.setTitle(this.i);
                    this.f1750a.setSubtitle(this.j);
                } else {
                    this.f1750a.setTitle((CharSequence) null);
                    this.f1750a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || this.f1753d == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f1750a.addView(this.f1753d);
            } else {
                this.f1750a.removeView(this.f1753d);
            }
        }
    }

    @Override // android.support.v7.widget.u
    public void c(Drawable drawable) {
        this.f1750a.setBackgroundDrawable(drawable);
    }

    public void c(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f1751b & 8) != 0) {
            this.f1750a.setSubtitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.u
    public boolean c() {
        return this.f1750a.g();
    }

    @Override // android.support.v7.widget.u
    public void d() {
        this.f1750a.h();
    }

    @Override // android.support.v7.widget.u
    public void d(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    public void d(Drawable drawable) {
        if (this.r != drawable) {
            this.r = drawable;
            v();
        }
    }

    public void d(CharSequence charSequence) {
        this.k = charSequence;
        u();
    }

    @Override // android.support.v7.widget.u
    public CharSequence e() {
        return this.f1750a.getTitle();
    }

    @Override // android.support.v7.widget.u
    public void e(int i) {
        this.f1750a.setVisibility(i);
    }

    public void e(Drawable drawable) {
        this.f1755f = drawable;
        t();
    }

    @Override // android.support.v7.widget.u
    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void f(int i) {
        if (i == this.q) {
            return;
        }
        this.q = i;
        if (TextUtils.isEmpty(this.f1750a.getNavigationContentDescription())) {
            d(this.q);
        }
    }

    @Override // android.support.v7.widget.u
    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.support.v7.widget.u
    public boolean h() {
        return this.f1750a.a();
    }

    @Override // android.support.v7.widget.u
    public boolean i() {
        return this.f1750a.b();
    }

    @Override // android.support.v7.widget.u
    public boolean j() {
        return this.f1750a.c();
    }

    @Override // android.support.v7.widget.u
    public boolean k() {
        return this.f1750a.d();
    }

    @Override // android.support.v7.widget.u
    public boolean l() {
        return this.f1750a.e();
    }

    @Override // android.support.v7.widget.u
    public void m() {
        this.m = true;
    }

    @Override // android.support.v7.widget.u
    public void n() {
        this.f1750a.f();
    }

    @Override // android.support.v7.widget.u
    public int o() {
        return this.f1751b;
    }

    @Override // android.support.v7.widget.u
    public int p() {
        return this.o;
    }

    @Override // android.support.v7.widget.u
    public int q() {
        return this.f1750a.getVisibility();
    }

    @Override // android.support.v7.widget.u
    public Menu r() {
        return this.f1750a.getMenu();
    }
}
