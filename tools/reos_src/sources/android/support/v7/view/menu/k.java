package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class k implements l, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f1297a = android.support.v7.b.a.h.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f1298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f1299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LayoutInflater f1300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f1301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f1302f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private View k;
    private ListPopupWindow l;
    private ViewTreeObserver m;
    private l.a n;
    private ViewGroup o;
    private boolean p;
    private int q;
    private int r;

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f f1304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1305c = -1;

        public a(f fVar) {
            this.f1304b = fVar;
            a();
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h getItem(int i) {
            ArrayList<h> arrayListL = k.this.g ? this.f1304b.l() : this.f1304b.i();
            if (this.f1305c >= 0 && i >= this.f1305c) {
                i++;
            }
            return arrayListL.get(i);
        }

        void a() {
            h hVarR = k.this.f1301e.r();
            if (hVarR != null) {
                ArrayList<h> arrayListL = k.this.f1301e.l();
                int size = arrayListL.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListL.get(i) == hVarR) {
                        this.f1305c = i;
                        return;
                    }
                }
            }
            this.f1305c = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<h> arrayListL = k.this.g ? this.f1304b.l() : this.f1304b.i();
            return this.f1305c < 0 ? arrayListL.size() : arrayListL.size() - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = view == null ? k.this.f1300d.inflate(k.f1297a, viewGroup, false) : view;
            m.a aVar = (m.a) viewInflate;
            if (k.this.f1298b) {
                ((ListMenuItemView) viewInflate).setForceShowIcon(true);
            }
            aVar.a(getItem(i), 0);
            return viewInflate;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public k(Context context, f fVar, View view) {
        this(context, fVar, view, false, android.support.v7.b.a.C0029a.popupMenuStyle);
    }

    public k(Context context, f fVar, View view, boolean z, int i) {
        this(context, fVar, view, z, i, 0);
    }

    public k(Context context, f fVar, View view, boolean z, int i, int i2) {
        this.r = 0;
        this.f1299c = context;
        this.f1300d = LayoutInflater.from(context);
        this.f1301e = fVar;
        this.f1302f = new a(this.f1301e);
        this.g = z;
        this.i = i;
        this.j = i2;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(android.support.v7.b.a.d.abc_config_prefDialogWidth));
        this.k = view;
        fVar.a(this, context);
    }

    private int i() {
        View view;
        a aVar = this.f1302f;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = aVar.getCount();
        int i = 0;
        int i2 = 0;
        View view2 = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = aVar.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view = null;
            } else {
                view = view2;
            }
            if (this.o == null) {
                this.o = new FrameLayout(this.f1299c);
            }
            view2 = aVar.getView(i, view, this.o);
            view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view2.getMeasuredWidth();
            if (measuredWidth >= this.h) {
                return this.h;
            }
            if (measuredWidth <= i3) {
                measuredWidth = i3;
            }
            i++;
            i3 = measuredWidth;
        }
        return i3;
    }

    public void a(int i) {
        this.r = i;
    }

    @Override // android.support.v7.view.menu.l
    public void a(Context context, f fVar) {
    }

    @Override // android.support.v7.view.menu.l
    public void a(Parcelable parcelable) {
    }

    @Override // android.support.v7.view.menu.l
    public void a(f fVar, boolean z) {
        if (fVar != this.f1301e) {
            return;
        }
        g();
        if (this.n != null) {
            this.n.a(fVar, z);
        }
    }

    public void a(l.a aVar) {
        this.n = aVar;
    }

    public void a(View view) {
        this.k = view;
    }

    @Override // android.support.v7.view.menu.l
    public void a(boolean z) {
        this.p = false;
        if (this.f1302f != null) {
            this.f1302f.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.l
    public boolean a() {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public boolean a(f fVar, h hVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public boolean a(p pVar) {
        boolean z;
        if (pVar.hasVisibleItems()) {
            k kVar = new k(this.f1299c, pVar, this.k);
            kVar.a(this.n);
            int size = pVar.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            kVar.b(z);
            if (kVar.f()) {
                if (this.n == null) {
                    return true;
                }
                this.n.a(pVar);
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public int b() {
        return 0;
    }

    public void b(boolean z) {
        this.f1298b = z;
    }

    @Override // android.support.v7.view.menu.l
    public boolean b(f fVar, h hVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public Parcelable c() {
        return null;
    }

    public void d() {
        if (!f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public ListPopupWindow e() {
        return this.l;
    }

    public boolean f() {
        this.l = new ListPopupWindow(this.f1299c, null, this.i, this.j);
        this.l.a((PopupWindow.OnDismissListener) this);
        this.l.a((AdapterView.OnItemClickListener) this);
        this.l.a(this.f1302f);
        this.l.a(true);
        View view = this.k;
        if (view == null) {
            return false;
        }
        boolean z = this.m == null;
        this.m = view.getViewTreeObserver();
        if (z) {
            this.m.addOnGlobalLayoutListener(this);
        }
        this.l.a(view);
        this.l.d(this.r);
        if (!this.p) {
            this.q = i();
            this.p = true;
        }
        this.l.f(this.q);
        this.l.g(2);
        this.l.c();
        this.l.m().setOnKeyListener(this);
        return true;
    }

    public void g() {
        if (h()) {
            this.l.i();
        }
    }

    public boolean h() {
        return this.l != null && this.l.k();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.l = null;
        this.f1301e.close();
        if (this.m != null) {
            if (!this.m.isAlive()) {
                this.m = this.k.getViewTreeObserver();
            }
            this.m.removeGlobalOnLayoutListener(this);
            this.m = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (h()) {
            View view = this.k;
            if (view == null || !view.isShown()) {
                g();
            } else if (h()) {
                this.l.c();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = this.f1302f;
        aVar.f1304b.a(aVar.getItem(i), 0);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        g();
        return true;
    }
}
