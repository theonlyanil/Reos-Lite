package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements l, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f1264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LayoutInflater f1265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    f f1266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ExpandedMenuView f1267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1269f;
    a g;
    private int h;
    private l.a i;
    private int j;

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1271b = -1;

        public a() {
            a();
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h getItem(int i) {
            ArrayList<h> arrayListL = e.this.f1266c.l();
            int i2 = e.this.h + i;
            if (this.f1271b >= 0 && i2 >= this.f1271b) {
                i2++;
            }
            return arrayListL.get(i2);
        }

        void a() {
            h hVarR = e.this.f1266c.r();
            if (hVarR != null) {
                ArrayList<h> arrayListL = e.this.f1266c.l();
                int size = arrayListL.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListL.get(i) == hVarR) {
                        this.f1271b = i;
                        return;
                    }
                }
            }
            this.f1271b = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f1266c.l().size() - e.this.h;
            return this.f1271b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = view == null ? e.this.f1265b.inflate(e.this.f1269f, viewGroup, false) : view;
            ((m.a) viewInflate).a(getItem(i), 0);
            return viewInflate;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(int i, int i2) {
        this.f1269f = i;
        this.f1268e = i2;
    }

    public e(Context context, int i) {
        this(i, 0);
        this.f1264a = context;
        this.f1265b = LayoutInflater.from(this.f1264a);
    }

    public m a(ViewGroup viewGroup) {
        if (this.f1267d == null) {
            this.f1267d = (ExpandedMenuView) this.f1265b.inflate(android.support.v7.b.a.h.abc_expanded_menu_layout, viewGroup, false);
            if (this.g == null) {
                this.g = new a();
            }
            this.f1267d.setAdapter((ListAdapter) this.g);
            this.f1267d.setOnItemClickListener(this);
        }
        return this.f1267d;
    }

    @Override // android.support.v7.view.menu.l
    public void a(Context context, f fVar) {
        if (this.f1268e != 0) {
            this.f1264a = new ContextThemeWrapper(context, this.f1268e);
            this.f1265b = LayoutInflater.from(this.f1264a);
        } else if (this.f1264a != null) {
            this.f1264a = context;
            if (this.f1265b == null) {
                this.f1265b = LayoutInflater.from(this.f1264a);
            }
        }
        this.f1266c = fVar;
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }

    public void a(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        if (this.f1267d != null) {
            this.f1267d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.support.v7.view.menu.l
    public void a(Parcelable parcelable) {
        b((Bundle) parcelable);
    }

    @Override // android.support.v7.view.menu.l
    public void a(f fVar, boolean z) {
        if (this.i != null) {
            this.i.a(fVar, z);
        }
    }

    public void a(l.a aVar) {
        this.i = aVar;
    }

    @Override // android.support.v7.view.menu.l
    public void a(boolean z) {
        if (this.g != null) {
            this.g.notifyDataSetChanged();
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
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        new g(pVar).a((IBinder) null);
        if (this.i != null) {
            this.i.a(pVar);
        }
        return true;
    }

    @Override // android.support.v7.view.menu.l
    public int b() {
        return this.j;
    }

    public void b(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1267d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // android.support.v7.view.menu.l
    public boolean b(f fVar, h hVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public Parcelable c() {
        if (this.f1267d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        a(bundle);
        return bundle;
    }

    public ListAdapter d() {
        if (this.g == null) {
            this.g = new a();
        }
        return this.g;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1266c.a(this.g.getItem(i), this, 0);
    }
}
