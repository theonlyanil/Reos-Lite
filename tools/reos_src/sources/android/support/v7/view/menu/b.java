package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ah;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f1254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f1255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected f f1256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected LayoutInflater f1257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LayoutInflater f1258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected m f1259f;
    private l.a g;
    private int h;
    private int i;
    private int j;

    public b(Context context, int i, int i2) {
        this.f1254a = context;
        this.f1257d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    public m a(ViewGroup viewGroup) {
        if (this.f1259f == null) {
            this.f1259f = (m) this.f1257d.inflate(this.h, viewGroup, false);
            this.f1259f.a(this.f1256c);
            a(true);
        }
        return this.f1259f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(h hVar, View view, ViewGroup viewGroup) {
        m.a aVarB = view instanceof m.a ? (m.a) view : b(viewGroup);
        a(hVar, aVarB);
        return (View) aVarB;
    }

    public void a(int i) {
        this.j = i;
    }

    @Override // android.support.v7.view.menu.l
    public void a(Context context, f fVar) {
        this.f1255b = context;
        this.f1258e = LayoutInflater.from(this.f1255b);
        this.f1256c = fVar;
    }

    @Override // android.support.v7.view.menu.l
    public void a(f fVar, boolean z) {
        if (this.g != null) {
            this.g.a(fVar, z);
        }
    }

    public abstract void a(h hVar, m.a aVar);

    public void a(l.a aVar) {
        this.g = aVar;
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1259f).addView(view, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.view.menu.l
    public void a(boolean z) {
        int i;
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.f1259f;
        if (viewGroup == null) {
            return;
        }
        if (this.f1256c != null) {
            this.f1256c.j();
            ArrayList<h> arrayListI = this.f1256c.i();
            int size = arrayListI.size();
            int i3 = 0;
            i = 0;
            while (i3 < size) {
                h hVar = arrayListI.get(i3);
                if (a(i, hVar)) {
                    View childAt = viewGroup.getChildAt(i);
                    h itemData = childAt instanceof m.a ? ((m.a) childAt).getItemData() : null;
                    View viewA = a(hVar, childAt, viewGroup);
                    if (hVar != itemData) {
                        viewA.setPressed(false);
                        ah.x(viewA);
                    }
                    if (viewA != childAt) {
                        a(viewA, i);
                    }
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i3++;
                i = i2;
            }
        } else {
            i = 0;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
        }
    }

    @Override // android.support.v7.view.menu.l
    public boolean a() {
        return false;
    }

    public boolean a(int i, h hVar) {
        return true;
    }

    @Override // android.support.v7.view.menu.l
    public boolean a(f fVar, h hVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.l
    public boolean a(p pVar) {
        if (this.g != null) {
            return this.g.a(pVar);
        }
        return false;
    }

    protected boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // android.support.v7.view.menu.l
    public int b() {
        return this.j;
    }

    public m.a b(ViewGroup viewGroup) {
        return (m.a) this.f1257d.inflate(this.i, viewGroup, false);
    }

    @Override // android.support.v7.view.menu.l
    public boolean b(f fVar, h hVar) {
        return false;
    }

    public l.a d() {
        return this.g;
    }
}
