package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int[] f1445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    View[] f1446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final SparseIntArray f1447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final SparseIntArray f1448f;
    c g;
    final Rect h;

    public static final class a extends c {
        @Override // android.support.v7.widget.GridLayoutManager.c
        public int a(int i) {
            return 1;
        }

        @Override // android.support.v7.widget.GridLayoutManager.c
        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends RecyclerView.i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1449e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1450f;

        public b(int i, int i2) {
            super(i, i2);
            this.f1449e = -1;
            this.f1450f = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1449e = -1;
            this.f1450f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1449e = -1;
            this.f1450f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1449e = -1;
            this.f1450f = 0;
        }

        public int a() {
            return this.f1449e;
        }

        public int b() {
            return this.f1450f;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseIntArray f1451a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1452b = false;

        public abstract int a(int i);

        public int a(int i, int i2) {
            int i3;
            int iA;
            int iB;
            int iA2 = a(i);
            if (iA2 == i2) {
                return 0;
            }
            if (!this.f1452b || this.f1451a.size() <= 0 || (iB = b(i)) < 0) {
                i3 = 0;
                iA = 0;
            } else {
                iA = this.f1451a.get(iB) + a(iB);
                i3 = iB + 1;
            }
            int i4 = i3;
            while (i4 < i) {
                int iA3 = a(i4);
                int i5 = iA + iA3;
                if (i5 == i2) {
                    iA3 = 0;
                } else if (i5 <= i2) {
                    iA3 = i5;
                }
                i4++;
                iA = iA3;
            }
            if (iA + iA2 <= i2) {
                return iA;
            }
            return 0;
        }

        public void a() {
            this.f1451a.clear();
        }

        int b(int i) {
            int i2 = 0;
            int size = this.f1451a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f1451a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f1451a.size()) {
                return -1;
            }
            return this.f1451a.keyAt(i4);
        }

        int b(int i, int i2) {
            if (!this.f1452b) {
                return a(i, i2);
            }
            int i3 = this.f1451a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iA = a(i, i2);
            this.f1451a.put(i, iA);
            return iA;
        }

        public int c(int i, int i2) {
            int iA = a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int iA2 = a(i3);
                int i6 = i5 + iA2;
                if (i6 == i2) {
                    i4++;
                    iA2 = 0;
                } else if (i6 > i2) {
                    i4++;
                } else {
                    iA2 = i6;
                }
                i3++;
                i5 = iA2;
            }
            return i5 + iA > i2 ? i4 + 1 : i4;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f1443a = false;
        this.f1444b = -1;
        this.f1447e = new SparseIntArray();
        this.f1448f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f1443a = false;
        this.f1444b = -1;
        this.f1447e = new SparseIntArray();
        this.f1448f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1443a = false;
        this.f1444b = -1;
        this.f1447e = new SparseIntArray();
        this.f1448f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(a(context, attributeSet, i, i2).f1543b);
    }

    private void I() {
        this.f1447e.clear();
        this.f1448f.clear();
    }

    private void J() {
        int iT = t();
        for (int i = 0; i < iT; i++) {
            b bVar = (b) h(i).getLayoutParams();
            int iE = bVar.e();
            this.f1447e.put(iE, bVar.b());
            this.f1448f.put(iE, bVar.a());
        }
    }

    private void K() {
        l(f() == 1 ? (w() - A()) - y() : (x() - B()) - z());
    }

    private void L() {
        if (this.f1446d == null || this.f1446d.length != this.f1444b) {
            this.f1446d = new View[this.f1444b];
        }
    }

    private int a(RecyclerView.n nVar, RecyclerView.r rVar, int i) {
        if (!rVar.a()) {
            return this.g.c(i, this.f1444b);
        }
        int iB = nVar.b(i);
        if (iB != -1) {
            return this.g.c(iB, this.f1444b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void a(float f2, int i) {
        l(Math.max(Math.round(this.f1444b * f2), i));
    }

    private void a(RecyclerView.n nVar, RecyclerView.r rVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i4 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i4 = -1;
            i = -1;
        }
        if (this.i == 1 && g()) {
            i5 = this.f1444b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (int i8 = i3; i8 != i; i8 += i4) {
            View view = this.f1446d[i8];
            b bVar = (b) view.getLayoutParams();
            bVar.f1450f = c(nVar, rVar, d(view));
            if (i6 != -1 || bVar.f1450f <= 1) {
                bVar.f1449e = i7;
            } else {
                bVar.f1449e = i7 - (bVar.f1450f - 1);
            }
            i7 += bVar.f1450f * i6;
        }
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        a(view, this.h);
        RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
        if (z || this.i == 1) {
            i = b(i, iVar.leftMargin + this.h.left, iVar.rightMargin + this.h.right);
        }
        if (z || this.i == 0) {
            i2 = b(i2, iVar.topMargin + this.h.top, iVar.bottomMargin + this.h.bottom);
        }
        if (z2 ? a(view, i, i2, iVar) : b(view, i, i2, iVar)) {
            view.measure(i, i2);
        }
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        int i4 = 0;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int b(RecyclerView.n nVar, RecyclerView.r rVar, int i) {
        if (!rVar.a()) {
            return this.g.b(i, this.f1444b);
        }
        int i2 = this.f1448f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = nVar.b(i);
        if (iB != -1) {
            return this.g.b(iB, this.f1444b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void b(RecyclerView.n nVar, RecyclerView.r rVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int iB = b(nVar, rVar, aVar.f1468a);
        if (z) {
            while (iB > 0 && aVar.f1468a > 0) {
                aVar.f1468a--;
                iB = b(nVar, rVar, aVar.f1468a);
            }
            return;
        }
        int iE = rVar.e() - 1;
        int i2 = aVar.f1468a;
        int i3 = iB;
        while (i2 < iE) {
            int iB2 = b(nVar, rVar, i2 + 1);
            if (iB2 <= i3) {
                break;
            }
            i2++;
            i3 = iB2;
        }
        aVar.f1468a = i2;
    }

    private int c(RecyclerView.n nVar, RecyclerView.r rVar, int i) {
        if (!rVar.a()) {
            return this.g.a(i);
        }
        int i2 = this.f1447e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = nVar.b(i);
        if (iB != -1) {
            return this.g.a(iB);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void l(int i) {
        this.f1445c = a(this.f1445c, this.f1444b, i);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.h
    public int a(int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        K();
        L();
        return super.a(i, nVar, rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int a(RecyclerView.n nVar, RecyclerView.r rVar) {
        if (this.i == 0) {
            return this.f1444b;
        }
        if (rVar.e() < 1) {
            return 0;
        }
        return a(nVar, rVar, rVar.e() - 1) + 1;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.h
    public RecyclerView.i a() {
        return this.i == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public RecyclerView.i a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public RecyclerView.i a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    @Override // android.support.v7.widget.LinearLayoutManager
    View a(RecyclerView.n nVar, RecyclerView.r rVar, int i, int i2, int i3) {
        View view;
        View view2 = null;
        h();
        int iC = this.j.c();
        int iD = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view3 = null;
        while (i != i2) {
            View viewH = h(i);
            int iD2 = d(viewH);
            if (iD2 < 0 || iD2 >= i3) {
                view = view2;
                viewH = view3;
            } else if (b(nVar, rVar, iD2) != 0) {
                view = view2;
                viewH = view3;
            } else if (((RecyclerView.i) viewH.getLayoutParams()).c()) {
                if (view3 == null) {
                    view = view2;
                } else {
                    view = view2;
                    viewH = view3;
                }
            } else {
                if (this.j.a(viewH) < iD && this.j.b(viewH) >= iC) {
                    return viewH;
                }
                if (view2 == null) {
                    view = viewH;
                    viewH = view3;
                } else {
                    view = view2;
                    viewH = view3;
                }
            }
            i += i4;
            view2 = view;
            view3 = viewH;
        }
        if (view2 == null) {
            view2 = view3;
        }
        return view2;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.h
    public View a(View view, int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        int iT;
        int i2;
        int iT2;
        int iMin;
        int i3;
        View view2;
        View viewE = e(view);
        if (viewE == null) {
            return null;
        }
        b bVar = (b) viewE.getLayoutParams();
        int i4 = bVar.f1449e;
        int i5 = bVar.f1449e + bVar.f1450f;
        if (super.a(view, i, nVar, rVar) == null) {
            return null;
        }
        if ((e(i) == 1) != this.k) {
            iT = t() - 1;
            i2 = -1;
            iT2 = -1;
        } else {
            iT = 0;
            i2 = 1;
            iT2 = t();
        }
        boolean z = this.i == 1 && g();
        View view3 = null;
        int i6 = -1;
        int i7 = 0;
        int i8 = iT;
        while (i8 != iT2) {
            View viewH = h(i8);
            if (viewH == viewE) {
                break;
            }
            if (viewH.isFocusable()) {
                b bVar2 = (b) viewH.getLayoutParams();
                int i9 = bVar2.f1449e;
                int i10 = bVar2.f1449e + bVar2.f1450f;
                if (i9 == i4 && i10 == i5) {
                    return viewH;
                }
                boolean z2 = false;
                if (view3 == null) {
                    z2 = true;
                } else {
                    int iMin2 = Math.min(i10, i5) - Math.max(i9, i4);
                    if (iMin2 > i7) {
                        z2 = true;
                    } else if (iMin2 == i7) {
                        if (z == (i9 > i6)) {
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    i3 = bVar2.f1449e;
                    iMin = Math.min(i10, i5) - Math.max(i9, i4);
                    view2 = viewH;
                } else {
                    iMin = i7;
                    i3 = i6;
                    view2 = view3;
                }
            } else {
                iMin = i7;
                i3 = i6;
                view2 = view3;
            }
            i8 += i2;
            view3 = view2;
            i6 = i3;
            i7 = iMin;
        }
        return view3;
    }

    public void a(int i) {
        if (i == this.f1444b) {
            return;
        }
        this.f1443a = true;
        if (i < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.f1444b = i;
        this.g.a();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        if (this.f1445c == null) {
            super.a(rect, i, i2);
        }
        int iA3 = A() + y();
        int iZ = z() + B();
        if (this.i == 1) {
            iA2 = a(i2, iZ + rect.height(), E());
            iA = a(i, iA3 + this.f1445c[this.f1445c.length - 1], D());
        } else {
            iA = a(i, iA3 + rect.width(), D());
            iA2 = a(i2, iZ + this.f1445c[this.f1445c.length - 1], E());
        }
        d(iA, iA2);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    void a(RecyclerView.n nVar, RecyclerView.r rVar, LinearLayoutManager.a aVar, int i) {
        super.a(nVar, rVar, aVar, i);
        K();
        if (rVar.e() > 0 && !rVar.a()) {
            b(nVar, rVar, aVar, i);
        }
        L();
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    void a(RecyclerView.n nVar, RecyclerView.r rVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int iD;
        int iD2;
        View viewA;
        int i3 = this.j.i();
        boolean z = i3 != 1073741824;
        int i4 = t() > 0 ? this.f1445c[this.f1444b] : 0;
        if (z) {
            K();
        }
        boolean z2 = cVar.f1480e == 1;
        int i5 = 0;
        int i6 = 0;
        int iB = this.f1444b;
        if (!z2) {
            iB = b(nVar, rVar, cVar.f1479d) + c(nVar, rVar, cVar.f1479d);
        }
        while (i5 < this.f1444b && cVar.a(rVar) && iB > 0) {
            int i7 = cVar.f1479d;
            int iC = c(nVar, rVar, i7);
            if (iC > this.f1444b) {
                throw new IllegalArgumentException("Item at position " + i7 + " requires " + iC + " spans but GridLayoutManager has only " + this.f1444b + " spans.");
            }
            iB -= iC;
            if (iB < 0 || (viewA = cVar.a(nVar)) == null) {
                break;
            }
            i6 += iC;
            this.f1446d[i5] = viewA;
            i5++;
        }
        if (i5 == 0) {
            bVar.f1473b = true;
            return;
        }
        a(nVar, rVar, i5, i6, z2);
        int i8 = 0;
        float f2 = 0.0f;
        int i9 = 0;
        while (i8 < i5) {
            View view = this.f1446d[i8];
            if (cVar.k == null) {
                if (z2) {
                    b(view);
                } else {
                    b(view, 0);
                }
            } else if (z2) {
                a(view);
            } else {
                a(view, 0);
            }
            b bVar2 = (b) view.getLayoutParams();
            int iA = a(this.f1445c[bVar2.f1449e + bVar2.f1450f] - this.f1445c[bVar2.f1449e], i3, 0, this.i == 0 ? bVar2.height : bVar2.width, false);
            int iA2 = a(this.j.f(), this.j.h(), 0, this.i == 1 ? bVar2.height : bVar2.width, true);
            if (this.i == 1) {
                a(view, iA, iA2, bVar2.height == -1, false);
            } else {
                a(view, iA2, iA, bVar2.width == -1, false);
            }
            int iC2 = this.j.c(view);
            if (iC2 <= i9) {
                iC2 = i9;
            }
            float fD = (1.0f * this.j.d(view)) / bVar2.f1450f;
            if (fD <= f2) {
                fD = f2;
            }
            i8++;
            f2 = fD;
            i9 = iC2;
        }
        if (z) {
            a(f2, i4);
            i9 = 0;
            int i10 = 0;
            while (i10 < i5) {
                View view2 = this.f1446d[i10];
                b bVar3 = (b) view2.getLayoutParams();
                int iA3 = a(this.f1445c[bVar3.f1449e + bVar3.f1450f] - this.f1445c[bVar3.f1449e], 1073741824, 0, this.i == 0 ? bVar3.height : bVar3.width, false);
                int iA4 = a(this.j.f(), this.j.h(), 0, this.i == 1 ? bVar3.height : bVar3.width, true);
                if (this.i == 1) {
                    a(view2, iA3, iA4, false, true);
                } else {
                    a(view2, iA4, iA3, false, true);
                }
                int iC3 = this.j.c(view2);
                if (iC3 <= i9) {
                    iC3 = i9;
                }
                i10++;
                i9 = iC3;
            }
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        for (int i11 = 0; i11 < i5; i11++) {
            View view3 = this.f1446d[i11];
            if (this.j.c(view3) != i9) {
                b bVar4 = (b) view3.getLayoutParams();
                int iA5 = a(this.f1445c[bVar4.f1449e + bVar4.f1450f] - this.f1445c[bVar4.f1449e], 1073741824, 0, this.i == 0 ? bVar4.height : bVar4.width, false);
                if (this.i == 1) {
                    a(view3, iA5, iMakeMeasureSpec, true, true);
                } else {
                    a(view3, iMakeMeasureSpec, iA5, true, true);
                }
            }
        }
        bVar.f1472a = i9;
        int i12 = 0;
        int i13 = 0;
        if (this.i == 1) {
            if (cVar.f1481f == -1) {
                i13 = cVar.f1477b;
                i12 = i13 - i9;
                i2 = 0;
                i = 0;
            } else {
                i12 = cVar.f1477b;
                i13 = i12 + i9;
                i2 = 0;
                i = 0;
            }
        } else if (cVar.f1481f == -1) {
            int i14 = cVar.f1477b;
            i = i14 - i9;
            i2 = i14;
        } else {
            i = cVar.f1477b;
            i2 = i9 + i;
        }
        int i15 = 0;
        int i16 = i;
        int i17 = i2;
        int iZ = i12;
        int iD3 = i13;
        while (i15 < i5) {
            View view4 = this.f1446d[i15];
            b bVar5 = (b) view4.getLayoutParams();
            if (this.i != 1) {
                iZ = this.f1445c[bVar5.f1449e] + z();
                iD3 = this.j.d(view4) + iZ;
                iD = i17;
                iD2 = i16;
            } else if (g()) {
                int iY = y() + this.f1445c[bVar5.f1449e + bVar5.f1450f];
                iD = iY;
                iD2 = iY - this.j.d(view4);
            } else {
                int iY2 = this.f1445c[bVar5.f1449e] + y();
                iD = this.j.d(view4) + iY2;
                iD2 = iY2;
            }
            a(view4, iD2 + bVar5.leftMargin, iZ + bVar5.topMargin, iD - bVar5.rightMargin, iD3 - bVar5.bottomMargin);
            if (bVar5.c() || bVar5.d()) {
                bVar.f1474c = true;
            }
            bVar.f1475d |= view4.isFocusable();
            i15++;
            i17 = iD;
            i16 = iD2;
        }
        Arrays.fill(this.f1446d, (Object) null);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView.n nVar, RecyclerView.r rVar, View view, android.support.v4.view.a.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int iA = a(nVar, rVar, bVar.e());
        if (this.i == 0) {
            cVar.c(android.support.v4.view.a.c.l.a(bVar.a(), bVar.b(), iA, 1, this.f1444b > 1 && bVar.b() == this.f1444b, false));
        } else {
            cVar.c(android.support.v4.view.a.c.l.a(iA, 1, bVar.a(), bVar.b(), this.f1444b > 1 && bVar.b() == this.f1444b, false));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView) {
        this.g.a();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.a();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.a();
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public boolean a(RecyclerView.i iVar) {
        return iVar instanceof b;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.h
    public int b(int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        K();
        L();
        return super.b(i, nVar, rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int b(RecyclerView.n nVar, RecyclerView.r rVar) {
        if (this.i == 1) {
            return this.f1444b;
        }
        if (rVar.e() < 1) {
            return 0;
        }
        return a(nVar, rVar, rVar.e() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void b(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.h
    public boolean b() {
        return this.n == null && !this.f1443a;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.h
    public void c(RecyclerView.n nVar, RecyclerView.r rVar) {
        if (rVar.a()) {
            J();
        }
        super.c(nVar, rVar);
        I();
        if (rVar.a()) {
            return;
        }
        this.f1443a = false;
    }
}
