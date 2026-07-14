package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f1459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1464f;
    int i;
    aa j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final a o;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.LinearLayoutManager.SavedState.1
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
        int f1465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1467c;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f1465a = parcel.readInt();
            this.f1466b = parcel.readInt();
            this.f1467c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f1465a = savedState.f1465a;
            this.f1466b = savedState.f1466b;
            this.f1467c = savedState.f1467c;
        }

        boolean a() {
            return this.f1465a >= 0;
        }

        void b() {
            this.f1465a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1465a);
            parcel.writeInt(this.f1466b);
            parcel.writeInt(this.f1467c ? 1 : 0);
        }
    }

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1470c;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(View view, RecyclerView.r rVar) {
            RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
            return !iVar.c() && iVar.e() >= 0 && iVar.e() < rVar.e();
        }

        void a() {
            this.f1468a = -1;
            this.f1469b = Integer.MIN_VALUE;
            this.f1470c = false;
        }

        public void a(View view) {
            int iB = LinearLayoutManager.this.j.b();
            if (iB >= 0) {
                b(view);
                return;
            }
            this.f1468a = LinearLayoutManager.this.d(view);
            if (!this.f1470c) {
                int iA = LinearLayoutManager.this.j.a(view);
                int iC = iA - LinearLayoutManager.this.j.c();
                this.f1469b = iA;
                if (iC > 0) {
                    int iD = (LinearLayoutManager.this.j.d() - Math.min(0, (LinearLayoutManager.this.j.d() - iB) - LinearLayoutManager.this.j.b(view))) - (iA + LinearLayoutManager.this.j.c(view));
                    if (iD < 0) {
                        this.f1469b -= Math.min(iC, -iD);
                        return;
                    }
                    return;
                }
                return;
            }
            int iD2 = (LinearLayoutManager.this.j.d() - iB) - LinearLayoutManager.this.j.b(view);
            this.f1469b = LinearLayoutManager.this.j.d() - iD2;
            if (iD2 > 0) {
                int iC2 = this.f1469b - LinearLayoutManager.this.j.c(view);
                int iC3 = LinearLayoutManager.this.j.c();
                int iMin = iC2 - (iC3 + Math.min(LinearLayoutManager.this.j.a(view) - iC3, 0));
                if (iMin < 0) {
                    this.f1469b = Math.min(iD2, -iMin) + this.f1469b;
                }
            }
        }

        void b() {
            this.f1469b = this.f1470c ? LinearLayoutManager.this.j.d() : LinearLayoutManager.this.j.c();
        }

        public void b(View view) {
            if (this.f1470c) {
                this.f1469b = LinearLayoutManager.this.j.b(view) + LinearLayoutManager.this.j.b();
            } else {
                this.f1469b = LinearLayoutManager.this.j.a(view);
            }
            this.f1468a = LinearLayoutManager.this.d(view);
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1468a + ", mCoordinate=" + this.f1469b + ", mLayoutFromEnd=" + this.f1470c + '}';
        }
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1475d;

        protected b() {
        }

        void a() {
            this.f1472a = 0;
            this.f1473b = false;
            this.f1474c = false;
            this.f1475d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1480e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1481f;
        int g;
        int j;
        boolean l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1476a = true;
        int h = 0;
        boolean i = false;
        List<RecyclerView.u> k = null;

        c() {
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).f1584a;
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                if (!iVar.c() && this.f1479d == iVar.e()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        View a(RecyclerView.n nVar) {
            if (this.k != null) {
                return b();
            }
            View viewC = nVar.c(this.f1479d);
            this.f1479d += this.f1480e;
            return viewC;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View viewB = b(view);
            if (viewB == null) {
                this.f1479d = -1;
            } else {
                this.f1479d = ((RecyclerView.i) viewB.getLayoutParams()).e();
            }
        }

        boolean a(RecyclerView.r rVar) {
            return this.f1479d >= 0 && this.f1479d < rVar.e();
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0044  */
        public View b(View view) {
            int iE;
            View view2;
            int size = this.k.size();
            View view3 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                View view4 = this.k.get(i2).f1584a;
                RecyclerView.i iVar = (RecyclerView.i) view4.getLayoutParams();
                if (view4 == view) {
                    iE = i;
                    view2 = view3;
                } else if (iVar.c()) {
                    iE = i;
                    view2 = view3;
                } else {
                    iE = (iVar.e() - this.f1479d) * this.f1480e;
                    if (iE < 0) {
                        iE = i;
                        view2 = view3;
                    } else if (iE >= i) {
                        iE = i;
                        view2 = view3;
                    } else {
                        if (iE == 0) {
                            return view4;
                        }
                        view2 = view4;
                    }
                }
                i2++;
                view3 = view2;
                i = iE;
            }
            return view3;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f1461c = false;
        this.k = false;
        this.f1462d = false;
        this.f1463e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        b(i);
        b(z);
        c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1461c = false;
        this.k = false;
        this.f1462d = false;
        this.f1463e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        RecyclerView.h.a aVarA = a(context, attributeSet, i, i2);
        b(aVarA.f1542a);
        b(aVarA.f1544c);
        a(aVarA.f1545d);
        c(true);
    }

    private void I() {
        if (this.i == 1 || !g()) {
            this.k = this.f1461c;
        } else {
            this.k = this.f1461c ? false : true;
        }
    }

    private View J() {
        return h(this.k ? t() - 1 : 0);
    }

    private View K() {
        return h(this.k ? 0 : t() - 1);
    }

    private int a(int i, RecyclerView.n nVar, RecyclerView.r rVar, boolean z) {
        int iD;
        int iD2 = this.j.d() - i;
        if (iD2 <= 0) {
            return 0;
        }
        int i2 = -c(-iD2, nVar, rVar);
        int i3 = i + i2;
        if (!z || (iD = this.j.d() - i3) <= 0) {
            return i2;
        }
        this.j.a(iD);
        return i2 + iD;
    }

    private View a(boolean z, boolean z2) {
        return this.k ? a(t() - 1, -1, z, z2) : a(0, t(), z, z2);
    }

    private void a(int i, int i2, boolean z, RecyclerView.r rVar) {
        int iC;
        this.f1459a.l = j();
        this.f1459a.h = a(rVar);
        this.f1459a.f1481f = i;
        if (i == 1) {
            this.f1459a.h += this.j.g();
            View viewK = K();
            this.f1459a.f1480e = this.k ? -1 : 1;
            this.f1459a.f1479d = d(viewK) + this.f1459a.f1480e;
            this.f1459a.f1477b = this.j.b(viewK);
            iC = this.j.b(viewK) - this.j.d();
        } else {
            View viewJ = J();
            this.f1459a.h += this.j.c();
            this.f1459a.f1480e = this.k ? 1 : -1;
            this.f1459a.f1479d = d(viewJ) + this.f1459a.f1480e;
            this.f1459a.f1477b = this.j.a(viewJ);
            iC = (-this.j.a(viewJ)) + this.j.c();
        }
        this.f1459a.f1478c = i2;
        if (z) {
            this.f1459a.f1478c -= iC;
        }
        this.f1459a.g = iC;
    }

    private void a(a aVar) {
        e(aVar.f1468a, aVar.f1469b);
    }

    private void a(RecyclerView.n nVar, int i) {
        if (i < 0) {
            return;
        }
        int iT = t();
        if (this.k) {
            for (int i2 = iT - 1; i2 >= 0; i2--) {
                if (this.j.b(h(i2)) > i) {
                    a(nVar, iT - 1, i2);
                    return;
                }
            }
            return;
        }
        for (int i3 = 0; i3 < iT; i3++) {
            if (this.j.b(h(i3)) > i) {
                a(nVar, 0, i3);
                return;
            }
        }
    }

    private void a(RecyclerView.n nVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                a(i, nVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                a(i3, nVar);
            }
        }
    }

    private void a(RecyclerView.n nVar, c cVar) {
        if (!cVar.f1476a || cVar.l) {
            return;
        }
        if (cVar.f1481f == -1) {
            b(nVar, cVar.g);
        } else {
            a(nVar, cVar.g);
        }
    }

    private void a(RecyclerView.n nVar, RecyclerView.r rVar, a aVar) {
        if (a(rVar, aVar) || b(nVar, rVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.f1468a = this.f1462d ? rVar.e() - 1 : 0;
    }

    private boolean a(RecyclerView.r rVar, a aVar) {
        if (rVar.a() || this.l == -1) {
            return false;
        }
        if (this.l < 0 || this.l >= rVar.e()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            return false;
        }
        aVar.f1468a = this.l;
        if (this.n != null && this.n.a()) {
            aVar.f1470c = this.n.f1467c;
            if (aVar.f1470c) {
                aVar.f1469b = this.j.d() - this.n.f1466b;
                return true;
            }
            aVar.f1469b = this.j.c() + this.n.f1466b;
            return true;
        }
        if (this.m != Integer.MIN_VALUE) {
            aVar.f1470c = this.k;
            if (this.k) {
                aVar.f1469b = this.j.d() - this.m;
                return true;
            }
            aVar.f1469b = this.j.c() + this.m;
            return true;
        }
        View viewC = c(this.l);
        if (viewC == null) {
            if (t() > 0) {
                aVar.f1470c = (this.l < d(h(0))) == this.k;
            }
            aVar.b();
            return true;
        }
        if (this.j.c(viewC) > this.j.f()) {
            aVar.b();
            return true;
        }
        if (this.j.a(viewC) - this.j.c() < 0) {
            aVar.f1469b = this.j.c();
            aVar.f1470c = false;
            return true;
        }
        if (this.j.d() - this.j.b(viewC) >= 0) {
            aVar.f1469b = aVar.f1470c ? this.j.b(viewC) + this.j.b() : this.j.a(viewC);
            return true;
        }
        aVar.f1469b = this.j.d();
        aVar.f1470c = true;
        return true;
    }

    private int b(int i, RecyclerView.n nVar, RecyclerView.r rVar, boolean z) {
        int iC;
        int iC2 = i - this.j.c();
        if (iC2 <= 0) {
            return 0;
        }
        int i2 = -c(iC2, nVar, rVar);
        int i3 = i + i2;
        if (!z || (iC = i3 - this.j.c()) <= 0) {
            return i2;
        }
        this.j.a(-iC);
        return i2 - iC;
    }

    private View b(boolean z, boolean z2) {
        return this.k ? a(0, t(), z, z2) : a(t() - 1, -1, z, z2);
    }

    private void b(a aVar) {
        f(aVar.f1468a, aVar.f1469b);
    }

    private void b(RecyclerView.n nVar, int i) {
        int iT = t();
        if (i < 0) {
            return;
        }
        int iE = this.j.e() - i;
        if (this.k) {
            for (int i2 = 0; i2 < iT; i2++) {
                if (this.j.a(h(i2)) < iE) {
                    a(nVar, 0, i2);
                    return;
                }
            }
            return;
        }
        for (int i3 = iT - 1; i3 >= 0; i3--) {
            if (this.j.a(h(i3)) < iE) {
                a(nVar, iT - 1, i3);
                return;
            }
        }
    }

    private void b(RecyclerView.n nVar, RecyclerView.r rVar, int i, int i2) {
        int iC;
        int iC2;
        if (!rVar.b() || t() == 0 || rVar.a() || !b()) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        List<RecyclerView.u> listB = nVar.b();
        int size = listB.size();
        int iD = d(h(0));
        int i5 = 0;
        while (i5 < size) {
            RecyclerView.u uVar = listB.get(i5);
            if (uVar.q()) {
                iC = i4;
                iC2 = i3;
            } else {
                if (((uVar.d() < iD) != this.k ? (byte) -1 : (byte) 1) == -1) {
                    iC2 = this.j.c(uVar.f1584a) + i3;
                    iC = i4;
                } else {
                    iC = this.j.c(uVar.f1584a) + i4;
                    iC2 = i3;
                }
            }
            i5++;
            i3 = iC2;
            i4 = iC;
        }
        this.f1459a.k = listB;
        if (i3 > 0) {
            f(d(J()), i);
            this.f1459a.h = i3;
            this.f1459a.f1478c = 0;
            this.f1459a.a();
            a(nVar, this.f1459a, rVar, false);
        }
        if (i4 > 0) {
            e(d(K()), i2);
            this.f1459a.h = i4;
            this.f1459a.f1478c = 0;
            this.f1459a.a();
            a(nVar, this.f1459a, rVar, false);
        }
        this.f1459a.k = null;
    }

    private boolean b(RecyclerView.n nVar, RecyclerView.r rVar, a aVar) {
        if (t() == 0) {
            return false;
        }
        View viewC = C();
        if (viewC != null && aVar.a(viewC, rVar)) {
            aVar.a(viewC);
            return true;
        }
        if (this.f1460b != this.f1462d) {
            return false;
        }
        View viewF = aVar.f1470c ? f(nVar, rVar) : g(nVar, rVar);
        if (viewF == null) {
            return false;
        }
        aVar.b(viewF);
        if (!rVar.a() && b()) {
            if (this.j.a(viewF) >= this.j.d() || this.j.b(viewF) < this.j.c()) {
                aVar.f1469b = aVar.f1470c ? this.j.d() : this.j.c();
            }
        }
        return true;
    }

    private void e(int i, int i2) {
        this.f1459a.f1478c = this.j.d() - i2;
        this.f1459a.f1480e = this.k ? -1 : 1;
        this.f1459a.f1479d = i;
        this.f1459a.f1481f = 1;
        this.f1459a.f1477b = i2;
        this.f1459a.g = Integer.MIN_VALUE;
    }

    private View f(RecyclerView.n nVar, RecyclerView.r rVar) {
        return this.k ? h(nVar, rVar) : i(nVar, rVar);
    }

    private void f(int i, int i2) {
        this.f1459a.f1478c = i2 - this.j.c();
        this.f1459a.f1479d = i;
        this.f1459a.f1480e = this.k ? 1 : -1;
        this.f1459a.f1481f = -1;
        this.f1459a.f1477b = i2;
        this.f1459a.g = Integer.MIN_VALUE;
    }

    private View g(RecyclerView.n nVar, RecyclerView.r rVar) {
        return this.k ? i(nVar, rVar) : h(nVar, rVar);
    }

    private int h(RecyclerView.r rVar) {
        if (t() == 0) {
            return 0;
        }
        h();
        return ag.a(rVar, this.j, a(!this.f1463e, true), b(this.f1463e ? false : true, true), this, this.f1463e, this.k);
    }

    private View h(RecyclerView.n nVar, RecyclerView.r rVar) {
        return a(nVar, rVar, 0, t(), rVar.e());
    }

    private int i(RecyclerView.r rVar) {
        if (t() == 0) {
            return 0;
        }
        h();
        return ag.a(rVar, this.j, a(!this.f1463e, true), b(this.f1463e ? false : true, true), this, this.f1463e);
    }

    private View i(RecyclerView.n nVar, RecyclerView.r rVar) {
        return a(nVar, rVar, t() - 1, -1, rVar.e());
    }

    private int j(RecyclerView.r rVar) {
        if (t() == 0) {
            return 0;
        }
        h();
        return ag.b(rVar, this.j, a(!this.f1463e, true), b(this.f1463e ? false : true, true), this, this.f1463e);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int a(int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        if (this.i == 1) {
            return 0;
        }
        return c(i, nVar, rVar);
    }

    int a(RecyclerView.n nVar, c cVar, RecyclerView.r rVar, boolean z) {
        int i = cVar.f1478c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.f1478c < 0) {
                cVar.g += cVar.f1478c;
            }
            a(nVar, cVar);
        }
        int i2 = cVar.f1478c + cVar.h;
        b bVar = new b();
        while (true) {
            if ((!cVar.l && i2 <= 0) || !cVar.a(rVar)) {
                break;
            }
            bVar.a();
            a(nVar, rVar, cVar, bVar);
            if (!bVar.f1473b) {
                cVar.f1477b += bVar.f1472a * cVar.f1481f;
                if (!bVar.f1474c || this.f1459a.k != null || !rVar.a()) {
                    cVar.f1478c -= bVar.f1472a;
                    i2 -= bVar.f1472a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.f1472a;
                    if (cVar.f1478c < 0) {
                        cVar.g += cVar.f1478c;
                    }
                    a(nVar, cVar);
                }
                if (z && bVar.f1475d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f1478c;
    }

    protected int a(RecyclerView.r rVar) {
        if (rVar.d()) {
            return this.j.f();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public RecyclerView.i a() {
        return new RecyclerView.i(-2, -2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    View a(int i, int i2, boolean z, boolean z2) {
        h();
        int iC = this.j.c();
        int iD = this.j.d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewH = h(i);
            int iA = this.j.a(viewH);
            int iB = this.j.b(viewH);
            if (iA >= iD || iB <= iC) {
                viewH = view;
            } else {
                if (!z) {
                    return viewH;
                }
                if (iA >= iC && iB <= iD) {
                    return viewH;
                }
                if (!z2 || view != null) {
                    viewH = view;
                }
            }
            i += i3;
            view = viewH;
        }
        return view;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
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

    @Override // android.support.v7.widget.RecyclerView.h
    public View a(View view, int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        int iE;
        I();
        if (t() == 0 || (iE = e(i)) == Integer.MIN_VALUE) {
            return null;
        }
        h();
        View viewG = iE == -1 ? g(nVar, rVar) : f(nVar, rVar);
        if (viewG == null) {
            return null;
        }
        h();
        a(iE, (int) (0.33333334f * this.j.f()), false, rVar);
        this.f1459a.g = Integer.MIN_VALUE;
        this.f1459a.f1476a = false;
        a(nVar, this.f1459a, rVar, true);
        View viewJ = iE == -1 ? J() : K();
        if (viewJ == viewG || !viewJ.isFocusable()) {
            return null;
        }
        return viewJ;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.n = (SavedState) parcelable;
            n();
        }
    }

    void a(RecyclerView.n nVar, RecyclerView.r rVar, a aVar, int i) {
    }

    void a(RecyclerView.n nVar, RecyclerView.r rVar, c cVar, b bVar) {
        int iZ;
        int iD;
        int iY;
        int i;
        int iD2;
        View viewA = cVar.a(nVar);
        if (viewA == null) {
            bVar.f1473b = true;
            return;
        }
        RecyclerView.i iVar = (RecyclerView.i) viewA.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f1481f == -1)) {
                b(viewA);
            } else {
                b(viewA, 0);
            }
        } else {
            if (this.k == (cVar.f1481f == -1)) {
                a(viewA);
            } else {
                a(viewA, 0);
            }
        }
        a(viewA, 0, 0);
        bVar.f1472a = this.j.c(viewA);
        if (this.i == 1) {
            if (g()) {
                iD2 = w() - A();
                iY = iD2 - this.j.d(viewA);
            } else {
                iY = y();
                iD2 = this.j.d(viewA) + iY;
            }
            if (cVar.f1481f == -1) {
                int i2 = cVar.f1477b;
                iZ = cVar.f1477b - bVar.f1472a;
                i = iD2;
                iD = i2;
            } else {
                iZ = cVar.f1477b;
                i = iD2;
                iD = cVar.f1477b + bVar.f1472a;
            }
        } else {
            iZ = z();
            iD = this.j.d(viewA) + iZ;
            if (cVar.f1481f == -1) {
                int i3 = cVar.f1477b;
                iY = cVar.f1477b - bVar.f1472a;
                i = i3;
            } else {
                iY = cVar.f1477b;
                i = cVar.f1477b + bVar.f1472a;
            }
        }
        a(viewA, iY + iVar.leftMargin, iZ + iVar.topMargin, i - iVar.rightMargin, iD - iVar.bottomMargin);
        if (iVar.c() || iVar.d()) {
            bVar.f1474c = true;
        }
        bVar.f1475d = viewA.isFocusable();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.a(recyclerView, nVar);
        if (this.f1464f) {
            c(nVar);
            nVar.a();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (t() > 0) {
            android.support.v4.view.a.m mVarA = android.support.v4.view.a.a.a(accessibilityEvent);
            mVarA.b(l());
            mVarA.c(m());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a((String) null);
        if (this.f1462d == z) {
            return;
        }
        this.f1462d = z;
        n();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int b(int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        if (this.i == 0) {
            return 0;
        }
        return c(i, nVar, rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int b(RecyclerView.r rVar) {
        return h(rVar);
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        a((String) null);
        if (i == this.i) {
            return;
        }
        this.i = i;
        this.j = null;
        n();
    }

    public void b(boolean z) {
        a((String) null);
        if (z == this.f1461c) {
            return;
        }
        this.f1461c = z;
        n();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public boolean b() {
        return this.n == null && this.f1460b == this.f1462d;
    }

    int c(int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        if (t() == 0 || i == 0) {
            return 0;
        }
        this.f1459a.f1476a = true;
        h();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        a(i2, iAbs, true, rVar);
        int iA = this.f1459a.g + a(nVar, this.f1459a, rVar, false);
        if (iA < 0) {
            return 0;
        }
        if (iAbs > iA) {
            i = i2 * iA;
        }
        this.j.a(-i);
        this.f1459a.j = i;
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int c(RecyclerView.r rVar) {
        return h(rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public Parcelable c() {
        if (this.n != null) {
            return new SavedState(this.n);
        }
        SavedState savedState = new SavedState();
        if (t() <= 0) {
            savedState.b();
            return savedState;
        }
        h();
        boolean z = this.f1460b ^ this.k;
        savedState.f1467c = z;
        if (z) {
            View viewK = K();
            savedState.f1466b = this.j.d() - this.j.b(viewK);
            savedState.f1465a = d(viewK);
            return savedState;
        }
        View viewJ = J();
        savedState.f1465a = d(viewJ);
        savedState.f1466b = this.j.a(viewJ) - this.j.c();
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public View c(int i) {
        int iT = t();
        if (iT == 0) {
            return null;
        }
        int iD = i - d(h(0));
        if (iD >= 0 && iD < iT) {
            View viewH = h(iD);
            if (d(viewH) == i) {
                return viewH;
            }
        }
        return super.c(i);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void c(RecyclerView.n nVar, RecyclerView.r rVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View viewC;
        if (!(this.n == null && this.l == -1) && rVar.e() == 0) {
            c(nVar);
            return;
        }
        if (this.n != null && this.n.a()) {
            this.l = this.n.f1465a;
        }
        h();
        this.f1459a.f1476a = false;
        I();
        this.o.a();
        this.o.f1470c = this.k ^ this.f1462d;
        a(nVar, rVar, this.o);
        int iA = a(rVar);
        if (this.f1459a.j >= 0) {
            i = 0;
        } else {
            i = iA;
            iA = 0;
        }
        int iC = i + this.j.c();
        int iG = iA + this.j.g();
        if (rVar.a() && this.l != -1 && this.m != Integer.MIN_VALUE && (viewC = c(this.l)) != null) {
            int iD = this.k ? (this.j.d() - this.j.b(viewC)) - this.m : this.m - (this.j.a(viewC) - this.j.c());
            if (iD > 0) {
                iC += iD;
            } else {
                iG -= iD;
            }
        }
        if (this.o.f1470c) {
            i2 = this.k ? 1 : -1;
        } else {
            i2 = this.k ? -1 : 1;
        }
        a(nVar, rVar, this.o, i2);
        a(nVar);
        this.f1459a.l = j();
        this.f1459a.i = rVar.a();
        if (this.o.f1470c) {
            b(this.o);
            this.f1459a.h = iC;
            a(nVar, this.f1459a, rVar, false);
            int i6 = this.f1459a.f1477b;
            int i7 = this.f1459a.f1479d;
            if (this.f1459a.f1478c > 0) {
                iG += this.f1459a.f1478c;
            }
            a(this.o);
            this.f1459a.h = iG;
            this.f1459a.f1479d += this.f1459a.f1480e;
            a(nVar, this.f1459a, rVar, false);
            int i8 = this.f1459a.f1477b;
            if (this.f1459a.f1478c > 0) {
                int i9 = this.f1459a.f1478c;
                f(i7, i6);
                this.f1459a.h = i9;
                a(nVar, this.f1459a, rVar, false);
                i5 = this.f1459a.f1477b;
            } else {
                i5 = i6;
            }
            i4 = i5;
            i3 = i8;
        } else {
            a(this.o);
            this.f1459a.h = iG;
            a(nVar, this.f1459a, rVar, false);
            i3 = this.f1459a.f1477b;
            int i10 = this.f1459a.f1479d;
            if (this.f1459a.f1478c > 0) {
                iC += this.f1459a.f1478c;
            }
            b(this.o);
            this.f1459a.h = iC;
            this.f1459a.f1479d += this.f1459a.f1480e;
            a(nVar, this.f1459a, rVar, false);
            i4 = this.f1459a.f1477b;
            if (this.f1459a.f1478c > 0) {
                int i11 = this.f1459a.f1478c;
                e(i10, i3);
                this.f1459a.h = i11;
                a(nVar, this.f1459a, rVar, false);
                i3 = this.f1459a.f1477b;
            }
        }
        if (t() > 0) {
            if (this.k ^ this.f1462d) {
                int iA2 = a(i3, nVar, rVar, true);
                int i12 = i4 + iA2;
                int iB = b(i12, nVar, rVar, false);
                i4 = i12 + iB;
                i3 = i3 + iA2 + iB;
            } else {
                int iB2 = b(i4, nVar, rVar, true);
                int i13 = i3 + iB2;
                int iA3 = a(i13, nVar, rVar, false);
                i4 = i4 + iB2 + iA3;
                i3 = i13 + iA3;
            }
        }
        b(nVar, rVar, i4, i3);
        if (!rVar.a()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            this.j.a();
        }
        this.f1460b = this.f1462d;
        this.n = null;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int d(RecyclerView.r rVar) {
        return i(rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void d(int i) {
        this.l = i;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        n();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public boolean d() {
        return this.i == 0;
    }

    int e(int i) {
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                return this.i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                return this.i != 0 ? Integer.MIN_VALUE : 1;
            case 130:
                return this.i == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int e(RecyclerView.r rVar) {
        return i(rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public boolean e() {
        return this.i == 1;
    }

    public int f() {
        return this.i;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int f(RecyclerView.r rVar) {
        return j(rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int g(RecyclerView.r rVar) {
        return j(rVar);
    }

    protected boolean g() {
        return r() == 1;
    }

    void h() {
        if (this.f1459a == null) {
            this.f1459a = i();
        }
        if (this.j == null) {
            this.j = aa.a(this, this.i);
        }
    }

    c i() {
        return new c();
    }

    boolean j() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    boolean k() {
        return (v() == 1073741824 || u() == 1073741824 || !H()) ? false : true;
    }

    public int l() {
        View viewA = a(0, t(), false, true);
        if (viewA == null) {
            return -1;
        }
        return d(viewA);
    }

    public int m() {
        View viewA = a(t() - 1, -1, false, true);
        if (viewA == null) {
            return -1;
        }
        return d(viewA);
    }
}
