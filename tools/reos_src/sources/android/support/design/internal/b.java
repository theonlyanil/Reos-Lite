package android.support.design.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.p;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NavigationMenuView f218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l.a f220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.support.v7.view.menu.f f221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C0008b f223f;
    private LayoutInflater g;
    private int h;
    private boolean i;
    private ColorStateList j;
    private ColorStateList k;
    private Drawable l;
    private int m;
    private int n;
    private final View.OnClickListener o = new View.OnClickListener() { // from class: android.support.design.internal.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.b(true);
            android.support.v7.view.menu.h itemData = ((NavigationMenuItemView) view).getItemData();
            boolean zA = b.this.f221d.a(itemData, b.this, 0);
            if (itemData != null && itemData.isCheckable() && zA) {
                b.this.f223f.a(itemData);
            }
            b.this.b(false);
            b.this.a(false);
        }
    };

    private static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: android.support.design.internal.b$b, reason: collision with other inner class name */
    private class C0008b extends RecyclerView.a<j> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<d> f226b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private android.support.v7.view.menu.h f227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ColorDrawable f228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f229e;

        C0008b() {
            f();
        }

        private void a(int i, int i2) {
            while (i < i2) {
                android.support.v7.view.menu.h hVarA = ((f) this.f226b.get(i)).a();
                if (hVarA.getIcon() == null) {
                    if (this.f228d == null) {
                        this.f228d = new ColorDrawable(0);
                    }
                    hVarA.setIcon(this.f228d);
                }
                i++;
            }
        }

        private void f() {
            boolean z;
            int i;
            boolean z2;
            int i2;
            int i3;
            if (this.f229e) {
                return;
            }
            this.f229e = true;
            this.f226b.clear();
            this.f226b.add(new c());
            int i4 = -1;
            int size = 0;
            boolean z3 = false;
            int size2 = b.this.f221d.i().size();
            int i5 = 0;
            while (i5 < size2) {
                android.support.v7.view.menu.h hVar = b.this.f221d.i().get(i5);
                if (hVar.isChecked()) {
                    a(hVar);
                }
                if (hVar.isCheckable()) {
                    hVar.a(false);
                }
                if (hVar.hasSubMenu()) {
                    SubMenu subMenu = hVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i5 != 0) {
                            this.f226b.add(new e(b.this.n, 0));
                        }
                        this.f226b.add(new f(hVar));
                        boolean z4 = false;
                        int size3 = this.f226b.size();
                        int size4 = subMenu.size();
                        for (int i6 = 0; i6 < size4; i6++) {
                            android.support.v7.view.menu.h hVar2 = (android.support.v7.view.menu.h) subMenu.getItem(i6);
                            if (hVar2.isVisible()) {
                                if (!z4 && hVar2.getIcon() != null) {
                                    z4 = true;
                                }
                                if (hVar2.isCheckable()) {
                                    hVar2.a(false);
                                }
                                if (hVar.isChecked()) {
                                    a(hVar);
                                }
                                this.f226b.add(new f(hVar2));
                            }
                        }
                        if (z4) {
                            a(size3, this.f226b.size());
                        }
                    }
                    z2 = z3;
                    i2 = size;
                    i3 = i4;
                } else {
                    int groupId = hVar.getGroupId();
                    if (groupId != i4) {
                        size = this.f226b.size();
                        z3 = hVar.getIcon() != null;
                        if (i5 != 0) {
                            this.f226b.add(new e(b.this.n, b.this.n));
                            z = z3;
                            i = size + 1;
                        }
                        if (z && hVar.getIcon() == null) {
                            hVar.setIcon(R.color.transparent);
                        }
                        this.f226b.add(new f(hVar));
                        z2 = z;
                        i2 = i;
                        i3 = groupId;
                    } else if (!z3 && hVar.getIcon() != null) {
                        z3 = true;
                        a(size, this.f226b.size());
                    }
                    z = z3;
                    i = size;
                    if (z) {
                        hVar.setIcon(R.color.transparent);
                    }
                    this.f226b.add(new f(hVar));
                    z2 = z;
                    i2 = i;
                    i3 = groupId;
                }
                i5++;
                size = i2;
                i4 = i3;
                z3 = z2;
            }
            this.f229e = false;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int a() {
            return this.f226b.size();
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public long a(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j b(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new g(b.this.g, viewGroup, b.this.o);
                case 1:
                    return new i(b.this.g, viewGroup);
                case 2:
                    return new h(b.this.g, viewGroup);
                case 3:
                    return new a(b.this.f219b);
                default:
                    return null;
            }
        }

        public void a(Bundle bundle) {
            android.support.v7.view.menu.h hVarA;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f229e = true;
                for (d dVar : this.f226b) {
                    if ((dVar instanceof f) && (hVarA = ((f) dVar).a()) != null && hVarA.getItemId() == i) {
                        a(hVarA);
                        break;
                    }
                }
                this.f229e = false;
                f();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            for (d dVar2 : this.f226b) {
                if (dVar2 instanceof f) {
                    android.support.v7.view.menu.h hVarA2 = ((f) dVar2).a();
                    View actionView = hVarA2 != null ? hVarA2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray.get(hVarA2.getItemId()));
                    }
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public void a(j jVar) {
            if (jVar instanceof g) {
                ((NavigationMenuItemView) jVar.f1584a).a();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public void a(j jVar, int i) {
            switch (b(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.f1584a;
                    navigationMenuItemView.setIconTintList(b.this.k);
                    if (b.this.i) {
                        navigationMenuItemView.a(navigationMenuItemView.getContext(), b.this.h);
                    }
                    if (b.this.j != null) {
                        navigationMenuItemView.setTextColor(b.this.j);
                    }
                    navigationMenuItemView.setBackgroundDrawable(b.this.l != null ? b.this.l.getConstantState().newDrawable() : null);
                    navigationMenuItemView.a(((f) this.f226b.get(i)).a(), 0);
                    break;
                case 1:
                    ((TextView) jVar.f1584a).setText(((f) this.f226b.get(i)).a().getTitle());
                    break;
                case 2:
                    e eVar = (e) this.f226b.get(i);
                    jVar.f1584a.setPadding(0, eVar.a(), 0, eVar.b());
                    break;
            }
        }

        public void a(android.support.v7.view.menu.h hVar) {
            if (this.f227c == hVar || !hVar.isCheckable()) {
                return;
            }
            if (this.f227c != null) {
                this.f227c.setChecked(false);
            }
            this.f227c = hVar;
            hVar.setChecked(true);
        }

        public void a(boolean z) {
            this.f229e = z;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int b(int i) {
            d dVar = this.f226b.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public void b() {
            f();
            e();
        }

        public Bundle c() {
            Bundle bundle = new Bundle();
            if (this.f227c != null) {
                bundle.putInt("android:menu:checked", this.f227c.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            for (d dVar : this.f226b) {
                if (dVar instanceof f) {
                    android.support.v7.view.menu.h hVarA = ((f) dVar).a();
                    View actionView = hVarA != null ? hVarA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(hVarA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }
    }

    private static class c implements d {
        private c() {
        }
    }

    private interface d {
    }

    private static class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f231b;

        public e(int i, int i2) {
            this.f230a = i;
            this.f231b = i2;
        }

        public int a() {
            return this.f230a;
        }

        public int b() {
            return this.f231b;
        }
    }

    private static class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final android.support.v7.view.menu.h f232a;

        private f(android.support.v7.view.menu.h hVar) {
            this.f232a = hVar;
        }

        public android.support.v7.view.menu.h a() {
            return this.f232a;
        }
    }

    private static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(android.support.design.a.f.design_navigation_item, viewGroup, false));
            this.f1584a.setOnClickListener(onClickListener);
        }
    }

    private static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class j extends RecyclerView.u {
        public j(View view) {
            super(view);
        }
    }

    public m a(ViewGroup viewGroup) {
        if (this.f218a == null) {
            this.f218a = (NavigationMenuView) this.g.inflate(android.support.design.a.f.design_navigation_menu, viewGroup, false);
            if (this.f223f == null) {
                this.f223f = new C0008b();
            }
            this.f219b = (LinearLayout) this.g.inflate(android.support.design.a.f.design_navigation_item_header, (ViewGroup) this.f218a, false);
            this.f218a.setAdapter(this.f223f);
        }
        return this.f218a;
    }

    public void a(int i2) {
        this.f222e = i2;
    }

    @Override // android.support.v7.view.menu.l
    public void a(Context context, android.support.v7.view.menu.f fVar) {
        this.g = LayoutInflater.from(context);
        this.f221d = fVar;
        this.n = context.getResources().getDimensionPixelOffset(android.support.design.a.d.design_navigation_separator_vertical_padding);
    }

    public void a(ColorStateList colorStateList) {
        this.k = colorStateList;
        a(false);
    }

    public void a(Drawable drawable) {
        this.l = drawable;
        a(false);
    }

    @Override // android.support.v7.view.menu.l
    public void a(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f218a.restoreHierarchyState(sparseParcelableArray);
        }
        Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            this.f223f.a(bundle2);
        }
    }

    @Override // android.support.v7.view.menu.l
    public void a(android.support.v7.view.menu.f fVar, boolean z) {
        if (this.f220c != null) {
            this.f220c.a(fVar, z);
        }
    }

    public void a(android.support.v7.view.menu.h hVar) {
        this.f223f.a(hVar);
    }

    public void a(View view) {
        this.f219b.addView(view);
        this.f218a.setPadding(0, 0, 0, this.f218a.getPaddingBottom());
    }

    @Override // android.support.v7.view.menu.l
    public void a(boolean z) {
        if (this.f223f != null) {
            this.f223f.b();
        }
    }

    @Override // android.support.v7.view.menu.l
    public boolean a() {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public boolean a(android.support.v7.view.menu.f fVar, android.support.v7.view.menu.h hVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public boolean a(p pVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public int b() {
        return this.f222e;
    }

    public View b(int i2) {
        View viewInflate = this.g.inflate(i2, (ViewGroup) this.f219b, false);
        a(viewInflate);
        return viewInflate;
    }

    public void b(ColorStateList colorStateList) {
        this.j = colorStateList;
        a(false);
    }

    public void b(boolean z) {
        if (this.f223f != null) {
            this.f223f.a(z);
        }
    }

    @Override // android.support.v7.view.menu.l
    public boolean b(android.support.v7.view.menu.f fVar, android.support.v7.view.menu.h hVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public Parcelable c() {
        Bundle bundle = new Bundle();
        if (this.f218a != null) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            this.f218a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.f223f != null) {
            bundle.putBundle("android:menu:adapter", this.f223f.c());
        }
        return bundle;
    }

    public void c(int i2) {
        this.h = i2;
        this.i = true;
        a(false);
    }

    public int d() {
        return this.f219b.getChildCount();
    }

    public void d(int i2) {
        if (this.m != i2) {
            this.m = i2;
            if (this.f219b.getChildCount() == 0) {
                this.f218a.setPadding(0, this.m, 0, this.f218a.getPaddingBottom());
            }
        }
    }

    public ColorStateList e() {
        return this.k;
    }

    public ColorStateList f() {
        return this.j;
    }

    public Drawable g() {
        return this.l;
    }
}
