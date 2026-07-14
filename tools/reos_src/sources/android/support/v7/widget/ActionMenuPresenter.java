package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends android.support.v7.view.menu.b implements android.support.v4.view.d.a {
    private b A;
    final f g;
    int h;
    private d i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private final SparseBooleanArray v;
    private View w;
    private e x;
    private a y;
    private c z;

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.ActionMenuPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1325a;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f1325a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1325a);
        }
    }

    private class a extends android.support.v7.view.menu.k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ActionMenuPresenter f1326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private android.support.v7.view.menu.p f1327d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ActionMenuPresenter actionMenuPresenter, Context context, android.support.v7.view.menu.p pVar) {
            super(context, pVar, null, false, android.support.v7.b.a.C0029a.actionOverflowMenuStyle);
            boolean z = false;
            this.f1326c = actionMenuPresenter;
            this.f1327d = pVar;
            if (!((android.support.v7.view.menu.h) pVar.getItem()).j()) {
                a(actionMenuPresenter.i == null ? (View) actionMenuPresenter.f1259f : actionMenuPresenter.i);
            }
            a(actionMenuPresenter.g);
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            b(z);
        }

        @Override // android.support.v7.view.menu.k, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            super.onDismiss();
            this.f1326c.y = null;
            this.f1326c.h = 0;
        }
    }

    private class b extends ActionMenuItemView.b {
        private b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.b
        public ListPopupWindow a() {
            if (ActionMenuPresenter.this.y != null) {
                return ActionMenuPresenter.this.y.e();
            }
            return null;
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f1330b;

        public c(e eVar) {
            this.f1330b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuPresenter.this.f1256c.f();
            View view = (View) ActionMenuPresenter.this.f1259f;
            if (view != null && view.getWindowToken() != null && this.f1330b.f()) {
                ActionMenuPresenter.this.x = this.f1330b;
            }
            ActionMenuPresenter.this.z = null;
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f1332b;

        public d(Context context) {
            super(context, null, android.support.v7.b.a.C0029a.actionOverflowButtonStyle);
            this.f1332b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ListPopupWindow.b(this) { // from class: android.support.v7.widget.ActionMenuPresenter.d.1
                @Override // android.support.v7.widget.ListPopupWindow.b
                public ListPopupWindow a() {
                    if (ActionMenuPresenter.this.x == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.x.e();
                }

                @Override // android.support.v7.widget.ListPopupWindow.b
                public boolean b() {
                    ActionMenuPresenter.this.f();
                    return true;
                }

                @Override // android.support.v7.widget.ListPopupWindow.b
                public boolean c() {
                    if (ActionMenuPresenter.this.z != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.g();
                    return true;
                }
            });
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.f();
            }
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.c.a.a.a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class e extends android.support.v7.view.menu.k {
        public e(Context context, android.support.v7.view.menu.f fVar, View view, boolean z) {
            super(context, fVar, view, z, android.support.v7.b.a.C0029a.actionOverflowMenuStyle);
            a(8388613);
            a(ActionMenuPresenter.this.g);
        }

        @Override // android.support.v7.view.menu.k, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            super.onDismiss();
            if (ActionMenuPresenter.this.f1256c != null) {
                ActionMenuPresenter.this.f1256c.close();
            }
            ActionMenuPresenter.this.x = null;
        }
    }

    private class f implements android.support.v7.view.menu.l.a {
        private f() {
        }

        @Override // android.support.v7.view.menu.l.a
        public void a(android.support.v7.view.menu.f fVar, boolean z) {
            if (fVar instanceof android.support.v7.view.menu.p) {
                ((android.support.v7.view.menu.p) fVar).p().b(false);
            }
            android.support.v7.view.menu.l.a aVarD = ActionMenuPresenter.this.d();
            if (aVarD != null) {
                aVarD.a(fVar, z);
            }
        }

        @Override // android.support.v7.view.menu.l.a
        public boolean a(android.support.v7.view.menu.f fVar) {
            if (fVar == null) {
                return false;
            }
            ActionMenuPresenter.this.h = ((android.support.v7.view.menu.p) fVar).getItem().getItemId();
            android.support.v7.view.menu.l.a aVarD = ActionMenuPresenter.this.d();
            return aVarD != null ? aVarD.a(fVar) : false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, android.support.v7.b.a.h.abc_action_menu_layout, android.support.v7.b.a.h.abc_action_menu_item_layout);
        this.v = new SparseBooleanArray();
        this.g = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1259f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof android.support.v7.view.menu.m.a) && ((android.support.v7.view.menu.m.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.support.v7.view.menu.b
    public android.support.v7.view.menu.m a(ViewGroup viewGroup) {
        android.support.v7.view.menu.m mVarA = super.a(viewGroup);
        ((ActionMenuView) mVarA).setPresenter(this);
        return mVarA;
    }

    @Override // android.support.v7.view.menu.b
    public View a(android.support.v7.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.n()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.l
    public void a(Context context, android.support.v7.view.menu.f fVar) {
        super.a(context, fVar);
        Resources resources = context.getResources();
        android.support.v7.view.a aVarA = android.support.v7.view.a.a(context);
        if (!this.m) {
            this.l = aVarA.b();
        }
        if (!this.s) {
            this.n = aVarA.c();
        }
        if (!this.q) {
            this.p = aVarA.a();
        }
        int measuredWidth = this.n;
        if (this.l) {
            if (this.i == null) {
                this.i = new d(this.f1254a);
                if (this.k) {
                    this.i.setImageDrawable(this.j);
                    this.j = null;
                    this.k = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.o = measuredWidth;
        this.u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.w = null;
    }

    public void a(Configuration configuration) {
        if (!this.q) {
            this.p = this.f1255b.getResources().getInteger(android.support.v7.b.a.g.abc_max_action_buttons);
        }
        if (this.f1256c != null) {
            this.f1256c.a(true);
        }
    }

    public void a(Drawable drawable) {
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
        } else {
            this.k = true;
            this.j = drawable;
        }
    }

    @Override // android.support.v7.view.menu.l
    public void a(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f1325a <= 0 || (menuItemFindItem = this.f1256c.findItem(savedState.f1325a)) == null) {
                return;
            }
            a((android.support.v7.view.menu.p) menuItemFindItem.getSubMenu());
        }
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.l
    public void a(android.support.v7.view.menu.f fVar, boolean z) {
        h();
        super.a(fVar, z);
    }

    @Override // android.support.v7.view.menu.b
    public void a(android.support.v7.view.menu.h hVar, android.support.v7.view.menu.m.a aVar) {
        aVar.a(hVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1259f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f1259f = actionMenuView;
        actionMenuView.a(this.f1256c);
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.l
    public void a(boolean z) {
        boolean z2 = false;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f1259f).getParent();
        if (viewGroup != null) {
            android.support.v7.g.a.a(viewGroup);
        }
        super.a(z);
        ((View) this.f1259f).requestLayout();
        if (this.f1256c != null) {
            ArrayList<android.support.v7.view.menu.h> arrayListK = this.f1256c.k();
            int size = arrayListK.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.view.d dVarA = arrayListK.get(i).a();
                if (dVarA != null) {
                    dVarA.a(this);
                }
            }
        }
        ArrayList<android.support.v7.view.menu.h> arrayListL = this.f1256c != null ? this.f1256c.l() : null;
        if (this.l && arrayListL != null) {
            int size2 = arrayListL.size();
            z2 = size2 == 1 ? !arrayListL.get(0).isActionViewExpanded() : size2 > 0;
        }
        if (z2) {
            if (this.i == null) {
                this.i = new d(this.f1254a);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
            if (viewGroup2 != this.f1259f) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1259f;
                actionMenuView.addView(this.i, actionMenuView.c());
            }
        } else if (this.i != null && this.i.getParent() == this.f1259f) {
            ((ViewGroup) this.f1259f).removeView(this.i);
        }
        ((ActionMenuView) this.f1259f).setOverflowReserved(this.l);
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.l
    public boolean a() {
        int i;
        int measuredWidth;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        ArrayList<android.support.v7.view.menu.h> arrayListI = this.f1256c.i();
        int size = arrayListI.size();
        int i8 = this.p;
        int i9 = this.o;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f1259f;
        int i10 = 0;
        int i11 = 0;
        boolean z3 = false;
        int i12 = 0;
        while (i12 < size) {
            android.support.v7.view.menu.h hVar = arrayListI.get(i12);
            if (hVar.l()) {
                i10++;
            } else if (hVar.k()) {
                i11++;
            } else {
                z3 = true;
            }
            i12++;
            i8 = (this.t && hVar.isActionViewExpanded()) ? 0 : i8;
        }
        if (this.l && (z3 || i10 + i11 > i8)) {
            i8--;
        }
        int i13 = i8 - i10;
        SparseBooleanArray sparseBooleanArray = this.v;
        sparseBooleanArray.clear();
        int i14 = 0;
        if (this.r) {
            i14 = i9 / this.u;
            i = ((i9 % this.u) / i14) + this.u;
        } else {
            i = 0;
        }
        int i15 = 0;
        int i16 = 0;
        int iA = i14;
        while (i15 < size) {
            android.support.v7.view.menu.h hVar2 = arrayListI.get(i15);
            if (hVar2.l()) {
                View viewA = a(hVar2, this.w, viewGroup);
                if (this.w == null) {
                    this.w = viewA;
                }
                if (this.r) {
                    iA -= ActionMenuView.a(viewA, i, iA, iMakeMeasureSpec, 0);
                } else {
                    viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                measuredWidth = viewA.getMeasuredWidth();
                int i17 = i9 - measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = hVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                hVar2.d(true);
                i2 = i17;
                i3 = i13;
            } else if (hVar2.k()) {
                int groupId2 = hVar2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i13 > 0 || z4) && i9 > 0 && (!this.r || iA > 0);
                if (z5) {
                    View viewA2 = a(hVar2, this.w, viewGroup);
                    if (this.w == null) {
                        this.w = viewA2;
                    }
                    if (this.r) {
                        int iA2 = ActionMenuView.a(viewA2, i, iA, iMakeMeasureSpec, 0);
                        int i18 = iA - iA2;
                        z2 = iA2 == 0 ? false : z5;
                        i7 = i18;
                    } else {
                        viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        boolean z6 = z5;
                        i7 = iA;
                        z2 = z6;
                    }
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i9 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    if (this.r) {
                        z = z2 & (i9 >= 0);
                        i4 = i16;
                        i5 = i7;
                    } else {
                        z = z2 & (i9 + i16 > 0);
                        i4 = i16;
                        i5 = i7;
                    }
                } else {
                    z = z5;
                    i4 = i16;
                    i5 = iA;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i6 = i13;
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i19 = i13;
                    for (int i20 = 0; i20 < i15; i20++) {
                        android.support.v7.view.menu.h hVar3 = arrayListI.get(i20);
                        if (hVar3.getGroupId() == groupId2) {
                            if (hVar3.j()) {
                                i19++;
                            }
                            hVar3.d(false);
                        }
                    }
                    i6 = i19;
                } else {
                    i6 = i13;
                }
                if (z) {
                    i6--;
                }
                hVar2.d(z);
                measuredWidth = i4;
                i2 = i9;
                int i21 = i5;
                i3 = i6;
                iA = i21;
            } else {
                hVar2.d(false);
                measuredWidth = i16;
                i2 = i9;
                i3 = i13;
            }
            i15++;
            i9 = i2;
            i13 = i3;
            i16 = measuredWidth;
        }
        return true;
    }

    @Override // android.support.v7.view.menu.b
    public boolean a(int i, android.support.v7.view.menu.h hVar) {
        return hVar.j();
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.l
    public boolean a(android.support.v7.view.menu.p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        android.support.v7.view.menu.p pVar2 = pVar;
        while (pVar2.s() != this.f1256c) {
            pVar2 = (android.support.v7.view.menu.p) pVar2.s();
        }
        View viewA = a(pVar2.getItem());
        if (viewA == null) {
            if (this.i == null) {
                return false;
            }
            viewA = this.i;
        }
        this.h = pVar.getItem().getItemId();
        this.y = new a(this, this.f1255b, pVar);
        this.y.a(viewA);
        this.y.d();
        super.a(pVar);
        return true;
    }

    @Override // android.support.v7.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.i) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // android.support.v4.view.d.a
    public void b(boolean z) {
        if (z) {
            super.a((android.support.v7.view.menu.p) null);
        } else {
            this.f1256c.b(false);
        }
    }

    @Override // android.support.v7.view.menu.l
    public Parcelable c() {
        SavedState savedState = new SavedState();
        savedState.f1325a = this.h;
        return savedState;
    }

    public void c(boolean z) {
        this.l = z;
        this.m = true;
    }

    public void d(boolean z) {
        this.t = z;
    }

    public Drawable e() {
        if (this.i != null) {
            return this.i.getDrawable();
        }
        if (this.k) {
            return this.j;
        }
        return null;
    }

    public boolean f() {
        if (!this.l || j() || this.f1256c == null || this.f1259f == null || this.z != null || this.f1256c.l().isEmpty()) {
            return false;
        }
        this.z = new c(new e(this.f1255b, this.f1256c, this.i, true));
        ((View) this.f1259f).post(this.z);
        super.a((android.support.v7.view.menu.p) null);
        return true;
    }

    public boolean g() {
        if (this.z != null && this.f1259f != null) {
            ((View) this.f1259f).removeCallbacks(this.z);
            this.z = null;
            return true;
        }
        e eVar = this.x;
        if (eVar == null) {
            return false;
        }
        eVar.g();
        return true;
    }

    public boolean h() {
        return g() | i();
    }

    public boolean i() {
        if (this.y == null) {
            return false;
        }
        this.y.g();
        return true;
    }

    public boolean j() {
        return this.x != null && this.x.h();
    }

    public boolean k() {
        return this.z != null || j();
    }
}
