package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    aa f1615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    aa f1616b;
    private c[] h;
    private int i;
    private int j;
    private final y k;
    private BitSet m;
    private boolean o;
    private boolean t;
    private SavedState u;
    private int v;
    private int g = -1;
    private boolean l = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f1617c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1618d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1619e = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    LazySpanLookup f1620f = new LazySpanLookup();
    private int n = 2;
    private final Rect w = new Rect();
    private final a x = new a();
    private boolean y = false;
    private boolean z = true;
    private final Runnable A = new Runnable() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.I();
        }
    };

    static class LazySpanLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f1622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<FullSpanItem> f1623b;

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f1624a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f1625b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int[] f1626c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f1627d;

            public FullSpanItem() {
            }

            public FullSpanItem(Parcel parcel) {
                this.f1624a = parcel.readInt();
                this.f1625b = parcel.readInt();
                this.f1627d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    this.f1626c = new int[i];
                    parcel.readIntArray(this.f1626c);
                }
            }

            int a(int i) {
                if (this.f1626c == null) {
                    return 0;
                }
                return this.f1626c[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1624a + ", mGapDir=" + this.f1625b + ", mHasUnwantedGapAfter=" + this.f1627d + ", mGapPerSpan=" + Arrays.toString(this.f1626c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1624a);
                parcel.writeInt(this.f1625b);
                parcel.writeInt(this.f1627d ? 1 : 0);
                if (this.f1626c == null || this.f1626c.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(this.f1626c.length);
                    parcel.writeIntArray(this.f1626c);
                }
            }
        }

        LazySpanLookup() {
        }

        private void c(int i, int i2) {
            if (this.f1623b == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = this.f1623b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f1623b.get(size);
                if (fullSpanItem.f1624a >= i) {
                    if (fullSpanItem.f1624a < i3) {
                        this.f1623b.remove(size);
                    } else {
                        fullSpanItem.f1624a -= i2;
                    }
                }
            }
        }

        private void d(int i, int i2) {
            if (this.f1623b == null) {
                return;
            }
            for (int size = this.f1623b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f1623b.get(size);
                if (fullSpanItem.f1624a >= i) {
                    fullSpanItem.f1624a += i2;
                }
            }
        }

        private int g(int i) {
            if (this.f1623b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i);
            if (fullSpanItemF != null) {
                this.f1623b.remove(fullSpanItemF);
            }
            int size = this.f1623b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f1623b.get(i2).f1624a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f1623b.get(i2);
            this.f1623b.remove(i2);
            return fullSpanItem.f1624a;
        }

        int a(int i) {
            if (this.f1623b != null) {
                for (int size = this.f1623b.size() - 1; size >= 0; size--) {
                    if (this.f1623b.get(size).f1624a >= i) {
                        this.f1623b.remove(size);
                    }
                }
            }
            return b(i);
        }

        public FullSpanItem a(int i, int i2, int i3, boolean z) {
            if (this.f1623b == null) {
                return null;
            }
            int size = this.f1623b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f1623b.get(i4);
                if (fullSpanItem.f1624a >= i2) {
                    return null;
                }
                if (fullSpanItem.f1624a >= i) {
                    if (i3 == 0 || fullSpanItem.f1625b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f1627d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        void a() {
            if (this.f1622a != null) {
                Arrays.fill(this.f1622a, -1);
            }
            this.f1623b = null;
        }

        void a(int i, int i2) {
            if (this.f1622a == null || i >= this.f1622a.length) {
                return;
            }
            e(i + i2);
            System.arraycopy(this.f1622a, i + i2, this.f1622a, i, (this.f1622a.length - i) - i2);
            Arrays.fill(this.f1622a, this.f1622a.length - i2, this.f1622a.length, -1);
            c(i, i2);
        }

        void a(int i, c cVar) {
            e(i);
            this.f1622a[i] = cVar.f1644d;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f1623b == null) {
                this.f1623b = new ArrayList();
            }
            int size = this.f1623b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f1623b.get(i);
                if (fullSpanItem2.f1624a == fullSpanItem.f1624a) {
                    this.f1623b.remove(i);
                }
                if (fullSpanItem2.f1624a >= fullSpanItem.f1624a) {
                    this.f1623b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f1623b.add(fullSpanItem);
        }

        int b(int i) {
            if (this.f1622a == null || i >= this.f1622a.length) {
                return -1;
            }
            int iG = g(i);
            if (iG == -1) {
                Arrays.fill(this.f1622a, i, this.f1622a.length, -1);
                return this.f1622a.length;
            }
            Arrays.fill(this.f1622a, i, iG + 1, -1);
            return iG + 1;
        }

        void b(int i, int i2) {
            if (this.f1622a == null || i >= this.f1622a.length) {
                return;
            }
            e(i + i2);
            System.arraycopy(this.f1622a, i, this.f1622a, i + i2, (this.f1622a.length - i) - i2);
            Arrays.fill(this.f1622a, i, i + i2, -1);
            d(i, i2);
        }

        int c(int i) {
            if (this.f1622a == null || i >= this.f1622a.length) {
                return -1;
            }
            return this.f1622a[i];
        }

        int d(int i) {
            int length = this.f1622a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            if (this.f1622a == null) {
                this.f1622a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f1622a, -1);
            } else if (i >= this.f1622a.length) {
                int[] iArr = this.f1622a;
                this.f1622a = new int[d(i)];
                System.arraycopy(iArr, 0, this.f1622a, 0, iArr.length);
                Arrays.fill(this.f1622a, iArr.length, this.f1622a.length, -1);
            }
        }

        public FullSpanItem f(int i) {
            if (this.f1623b == null) {
                return null;
            }
            for (int size = this.f1623b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f1623b.get(size);
                if (fullSpanItem.f1624a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.SavedState.1
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
        int f1628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int[] f1631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f1633f;
        List<LazySpanLookup.FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f1628a = parcel.readInt();
            this.f1629b = parcel.readInt();
            this.f1630c = parcel.readInt();
            if (this.f1630c > 0) {
                this.f1631d = new int[this.f1630c];
                parcel.readIntArray(this.f1631d);
            }
            this.f1632e = parcel.readInt();
            if (this.f1632e > 0) {
                this.f1633f = new int[this.f1632e];
                parcel.readIntArray(this.f1633f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1630c = savedState.f1630c;
            this.f1628a = savedState.f1628a;
            this.f1629b = savedState.f1629b;
            this.f1631d = savedState.f1631d;
            this.f1632e = savedState.f1632e;
            this.f1633f = savedState.f1633f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        void a() {
            this.f1631d = null;
            this.f1630c = 0;
            this.f1632e = 0;
            this.f1633f = null;
            this.g = null;
        }

        void b() {
            this.f1631d = null;
            this.f1630c = 0;
            this.f1628a = -1;
            this.f1629b = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1628a);
            parcel.writeInt(this.f1629b);
            parcel.writeInt(this.f1630c);
            if (this.f1630c > 0) {
                parcel.writeIntArray(this.f1631d);
            }
            parcel.writeInt(this.f1632e);
            if (this.f1632e > 0) {
                parcel.writeIntArray(this.f1633f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }
    }

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1637d;

        private a() {
        }

        void a() {
            this.f1634a = -1;
            this.f1635b = Integer.MIN_VALUE;
            this.f1636c = false;
            this.f1637d = false;
        }

        void a(int i) {
            if (this.f1636c) {
                this.f1635b = StaggeredGridLayoutManager.this.f1615a.d() - i;
            } else {
                this.f1635b = StaggeredGridLayoutManager.this.f1615a.c() + i;
            }
        }

        void b() {
            this.f1635b = this.f1636c ? StaggeredGridLayoutManager.this.f1615a.d() : StaggeredGridLayoutManager.this.f1615a.c();
        }
    }

    public static class b extends RecyclerView.i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c f1639e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1640f;

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean a() {
            return this.f1640f;
        }

        public final int b() {
            if (this.f1639e == null) {
                return -1;
            }
            return this.f1639e.f1644d;
        }
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f1644d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ArrayList<View> f1646f;

        private c(int i) {
            this.f1646f = new ArrayList<>();
            this.f1641a = Integer.MIN_VALUE;
            this.f1642b = Integer.MIN_VALUE;
            this.f1643c = 0;
            this.f1644d = i;
        }

        int a(int i) {
            if (this.f1641a != Integer.MIN_VALUE) {
                return this.f1641a;
            }
            if (this.f1646f.size() == 0) {
                return i;
            }
            a();
            return this.f1641a;
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f1646f.size() - 1;
                while (size >= 0) {
                    View view2 = this.f1646f.get(size);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    if ((StaggeredGridLayoutManager.this.d(view2) > i) != (!StaggeredGridLayoutManager.this.l)) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = this.f1646f.size();
            int i3 = 0;
            while (i3 < size2) {
                View view3 = this.f1646f.get(i3);
                if (!view3.isFocusable()) {
                    break;
                }
                if ((StaggeredGridLayoutManager.this.d(view3) > i) != StaggeredGridLayoutManager.this.l) {
                    break;
                }
                i3++;
                view = view3;
            }
            return view;
        }

        void a() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = this.f1646f.get(0);
            b bVarC = c(view);
            this.f1641a = StaggeredGridLayoutManager.this.f1615a.a(view);
            if (bVarC.f1640f && (fullSpanItemF = StaggeredGridLayoutManager.this.f1620f.f(bVarC.e())) != null && fullSpanItemF.f1625b == -1) {
                this.f1641a -= fullSpanItemF.a(this.f1644d);
            }
        }

        void a(View view) {
            b bVarC = c(view);
            bVarC.f1639e = this;
            this.f1646f.add(0, view);
            this.f1641a = Integer.MIN_VALUE;
            if (this.f1646f.size() == 1) {
                this.f1642b = Integer.MIN_VALUE;
            }
            if (bVarC.c() || bVarC.d()) {
                this.f1643c += StaggeredGridLayoutManager.this.f1615a.c(view);
            }
        }

        void a(boolean z, int i) {
            int iB = z ? b(Integer.MIN_VALUE) : a(Integer.MIN_VALUE);
            e();
            if (iB == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iB >= StaggeredGridLayoutManager.this.f1615a.d()) {
                if (z || iB <= StaggeredGridLayoutManager.this.f1615a.c()) {
                    if (i != Integer.MIN_VALUE) {
                        iB += i;
                    }
                    this.f1642b = iB;
                    this.f1641a = iB;
                }
            }
        }

        int b() {
            if (this.f1641a != Integer.MIN_VALUE) {
                return this.f1641a;
            }
            a();
            return this.f1641a;
        }

        int b(int i) {
            if (this.f1642b != Integer.MIN_VALUE) {
                return this.f1642b;
            }
            if (this.f1646f.size() == 0) {
                return i;
            }
            c();
            return this.f1642b;
        }

        void b(View view) {
            b bVarC = c(view);
            bVarC.f1639e = this;
            this.f1646f.add(view);
            this.f1642b = Integer.MIN_VALUE;
            if (this.f1646f.size() == 1) {
                this.f1641a = Integer.MIN_VALUE;
            }
            if (bVarC.c() || bVarC.d()) {
                this.f1643c += StaggeredGridLayoutManager.this.f1615a.c(view);
            }
        }

        b c(View view) {
            return (b) view.getLayoutParams();
        }

        void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = this.f1646f.get(this.f1646f.size() - 1);
            b bVarC = c(view);
            this.f1642b = StaggeredGridLayoutManager.this.f1615a.b(view);
            if (bVarC.f1640f && (fullSpanItemF = StaggeredGridLayoutManager.this.f1620f.f(bVarC.e())) != null && fullSpanItemF.f1625b == 1) {
                this.f1642b = fullSpanItemF.a(this.f1644d) + this.f1642b;
            }
        }

        void c(int i) {
            this.f1641a = i;
            this.f1642b = i;
        }

        int d() {
            if (this.f1642b != Integer.MIN_VALUE) {
                return this.f1642b;
            }
            c();
            return this.f1642b;
        }

        void d(int i) {
            if (this.f1641a != Integer.MIN_VALUE) {
                this.f1641a += i;
            }
            if (this.f1642b != Integer.MIN_VALUE) {
                this.f1642b += i;
            }
        }

        void e() {
            this.f1646f.clear();
            f();
            this.f1643c = 0;
        }

        void f() {
            this.f1641a = Integer.MIN_VALUE;
            this.f1642b = Integer.MIN_VALUE;
        }

        void g() {
            int size = this.f1646f.size();
            View viewRemove = this.f1646f.remove(size - 1);
            b bVarC = c(viewRemove);
            bVarC.f1639e = null;
            if (bVarC.c() || bVarC.d()) {
                this.f1643c -= StaggeredGridLayoutManager.this.f1615a.c(viewRemove);
            }
            if (size == 1) {
                this.f1641a = Integer.MIN_VALUE;
            }
            this.f1642b = Integer.MIN_VALUE;
        }

        void h() {
            View viewRemove = this.f1646f.remove(0);
            b bVarC = c(viewRemove);
            bVarC.f1639e = null;
            if (this.f1646f.size() == 0) {
                this.f1642b = Integer.MIN_VALUE;
            }
            if (bVarC.c() || bVarC.d()) {
                this.f1643c -= StaggeredGridLayoutManager.this.f1615a.c(viewRemove);
            }
            this.f1641a = Integer.MIN_VALUE;
        }

        public int i() {
            return this.f1643c;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.i = i2;
        a(i);
        c(this.n != 0);
        this.k = new y();
        m();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.h.a aVarA = a(context, attributeSet, i, i2);
        b(aVarA.f1542a);
        a(aVarA.f1543b);
        a(aVarA.f1544c);
        c(this.n != 0);
        this.k = new y();
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I() {
        int iM;
        int iL;
        if (t() == 0 || this.n == 0 || !o()) {
            return false;
        }
        if (this.f1617c) {
            iM = L();
            iL = M();
        } else {
            iM = M();
            iL = L();
        }
        if (iM == 0 && f() != null) {
            this.f1620f.a();
            G();
            n();
            return true;
        }
        if (!this.y) {
            return false;
        }
        int i = this.f1617c ? -1 : 1;
        LazySpanLookup.FullSpanItem fullSpanItemA = this.f1620f.a(iM, iL + 1, i, true);
        if (fullSpanItemA == null) {
            this.y = false;
            this.f1620f.a(iL + 1);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemA2 = this.f1620f.a(iM, fullSpanItemA.f1624a, i * (-1), true);
        if (fullSpanItemA2 == null) {
            this.f1620f.a(fullSpanItemA.f1624a);
        } else {
            this.f1620f.a(fullSpanItemA2.f1624a + 1);
        }
        G();
        n();
        return true;
    }

    private void J() {
        if (this.i == 1 || !h()) {
            this.f1617c = this.l;
        } else {
            this.f1617c = this.l ? false : true;
        }
    }

    private void K() {
        if (this.f1616b.h() == 1073741824) {
            return;
        }
        float fMax = BitmapDescriptorFactory.HUE_RED;
        int iT = t();
        int i = 0;
        while (i < iT) {
            View viewH = h(i);
            float fC = this.f1616b.c(viewH);
            i++;
            fMax = fC < fMax ? fMax : Math.max(fMax, ((b) viewH.getLayoutParams()).a() ? (1.0f * fC) / this.g : fC);
        }
        int i2 = this.j;
        int iRound = Math.round(this.g * fMax);
        if (this.f1616b.h() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f1616b.f());
        }
        e(iRound);
        if (this.j != i2) {
            for (int i3 = 0; i3 < iT; i3++) {
                View viewH2 = h(i3);
                b bVar = (b) viewH2.getLayoutParams();
                if (!bVar.f1640f) {
                    if (h() && this.i == 1) {
                        viewH2.offsetLeftAndRight(((-((this.g - 1) - bVar.f1639e.f1644d)) * this.j) - ((-((this.g - 1) - bVar.f1639e.f1644d)) * i2));
                    } else {
                        int i4 = bVar.f1639e.f1644d * this.j;
                        int i5 = bVar.f1639e.f1644d * i2;
                        if (this.i == 1) {
                            viewH2.offsetLeftAndRight(i4 - i5);
                        } else {
                            viewH2.offsetTopAndBottom(i4 - i5);
                        }
                    }
                }
            }
        }
    }

    private int L() {
        int iT = t();
        if (iT == 0) {
            return 0;
        }
        return d(h(iT - 1));
    }

    private int M() {
        if (t() == 0) {
            return 0;
        }
        return d(h(0));
    }

    private int a(RecyclerView.n nVar, y yVar, RecyclerView.r rVar) {
        int i;
        int iQ;
        c cVar;
        int iC;
        int iC2;
        int iC3;
        int iC4;
        boolean z;
        this.m.set(0, this.g, true);
        if (this.k.i) {
            i = yVar.f1881e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i = yVar.f1881e == 1 ? yVar.g + yVar.f1878b : yVar.f1882f - yVar.f1878b;
        }
        e(yVar.f1881e, i);
        int iD = this.f1617c ? this.f1615a.d() : this.f1615a.c();
        boolean z2 = false;
        while (yVar.a(rVar) && (this.k.i || !this.m.isEmpty())) {
            View viewA = yVar.a(nVar);
            b bVar = (b) viewA.getLayoutParams();
            int iE = bVar.e();
            int iC5 = this.f1620f.c(iE);
            boolean z3 = iC5 == -1;
            if (z3) {
                c cVarA = bVar.f1640f ? this.h[0] : a(yVar);
                this.f1620f.a(iE, cVarA);
                cVar = cVarA;
            } else {
                cVar = this.h[iC5];
            }
            bVar.f1639e = cVar;
            if (yVar.f1881e == 1) {
                b(viewA);
            } else {
                b(viewA, 0);
            }
            a(viewA, bVar, false);
            if (yVar.f1881e == 1) {
                int iQ2 = bVar.f1640f ? q(iD) : cVar.b(iD);
                iC2 = iQ2 + this.f1615a.c(viewA);
                if (z3 && bVar.f1640f) {
                    LazySpanLookup.FullSpanItem fullSpanItemM = m(iQ2);
                    fullSpanItemM.f1625b = -1;
                    fullSpanItemM.f1624a = iE;
                    this.f1620f.a(fullSpanItemM);
                    iC = iQ2;
                } else {
                    iC = iQ2;
                }
            } else {
                int iP = bVar.f1640f ? p(iD) : cVar.a(iD);
                iC = iP - this.f1615a.c(viewA);
                if (z3 && bVar.f1640f) {
                    LazySpanLookup.FullSpanItem fullSpanItemN = n(iP);
                    fullSpanItemN.f1625b = 1;
                    fullSpanItemN.f1624a = iE;
                    this.f1620f.a(fullSpanItemN);
                }
                iC2 = iP;
            }
            if (bVar.f1640f && yVar.f1880d == -1) {
                if (z3) {
                    this.y = true;
                } else {
                    if (yVar.f1881e == 1) {
                        z = !j();
                    } else {
                        z = !l();
                    }
                    if (z) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = this.f1620f.f(iE);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.f1627d = true;
                        }
                        this.y = true;
                    }
                }
            }
            a(viewA, bVar, yVar);
            if (h() && this.i == 1) {
                int iD2 = bVar.f1640f ? this.f1616b.d() : this.f1616b.d() - (((this.g - 1) - cVar.f1644d) * this.j);
                iC4 = iD2 - this.f1616b.c(viewA);
                iC3 = iD2;
            } else {
                int iC6 = bVar.f1640f ? this.f1616b.c() : (cVar.f1644d * this.j) + this.f1616b.c();
                iC3 = iC6 + this.f1616b.c(viewA);
                iC4 = iC6;
            }
            if (this.i == 1) {
                b(viewA, iC4, iC, iC3, iC2);
            } else {
                b(viewA, iC, iC4, iC2, iC3);
            }
            if (bVar.f1640f) {
                e(this.k.f1881e, i);
            } else {
                a(cVar, this.k.f1881e, i);
            }
            a(nVar, this.k);
            if (this.k.h && viewA.isFocusable()) {
                if (bVar.f1640f) {
                    this.m.clear();
                } else {
                    this.m.set(cVar.f1644d, false);
                }
            }
            z2 = true;
        }
        if (!z2) {
            a(nVar, this.k);
        }
        if (this.k.f1881e == -1) {
            iQ = this.f1615a.c() - p(this.f1615a.c());
        } else {
            iQ = q(this.f1615a.d()) - this.f1615a.d();
        }
        if (iQ > 0) {
            return Math.min(yVar.f1878b, iQ);
        }
        return 0;
    }

    private int a(RecyclerView.r rVar) {
        if (t() == 0) {
            return 0;
        }
        return ag.a(rVar, this.f1615a, a(!this.z, true), b(this.z ? false : true, true), this, this.z, this.f1617c);
    }

    private c a(y yVar) {
        int i;
        int i2;
        c cVar;
        c cVar2;
        c cVar3 = null;
        int i3 = -1;
        if (s(yVar.f1881e)) {
            i = this.g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.g;
            i3 = 1;
        }
        if (yVar.f1881e == 1) {
            int iC = this.f1615a.c();
            int i4 = i;
            int i5 = Integer.MAX_VALUE;
            while (i4 != i2) {
                c cVar4 = this.h[i4];
                int iB = cVar4.b(iC);
                if (iB < i5) {
                    cVar2 = cVar4;
                } else {
                    iB = i5;
                    cVar2 = cVar3;
                }
                i4 += i3;
                cVar3 = cVar2;
                i5 = iB;
            }
        } else {
            int iD = this.f1615a.d();
            int i6 = i;
            int i7 = Integer.MIN_VALUE;
            while (i6 != i2) {
                c cVar5 = this.h[i6];
                int iA = cVar5.a(iD);
                if (iA > i7) {
                    cVar = cVar5;
                } else {
                    iA = i7;
                    cVar = cVar3;
                }
                i6 += i3;
                cVar3 = cVar;
                i7 = iA;
            }
        }
        return cVar3;
    }

    private void a(int i, RecyclerView.r rVar) {
        int iF;
        int iF2;
        int iC;
        boolean z = false;
        this.k.f1878b = 0;
        this.k.f1879c = i;
        if (!q() || (iC = rVar.c()) == -1) {
            iF = 0;
            iF2 = 0;
        } else {
            if (this.f1617c == (iC < i)) {
                iF = this.f1615a.f();
                iF2 = 0;
            } else {
                iF2 = this.f1615a.f();
                iF = 0;
            }
        }
        if (p()) {
            this.k.f1882f = this.f1615a.c() - iF2;
            this.k.g = iF + this.f1615a.d();
        } else {
            this.k.g = iF + this.f1615a.e();
            this.k.f1882f = -iF2;
        }
        this.k.h = false;
        this.k.f1877a = true;
        y yVar = this.k;
        if (this.f1615a.h() == 0 && this.f1615a.e() == 0) {
            z = true;
        }
        yVar.i = z;
    }

    private void a(RecyclerView.n nVar, int i) {
        while (t() > 0) {
            View viewH = h(0);
            if (this.f1615a.b(viewH) > i) {
                return;
            }
            b bVar = (b) viewH.getLayoutParams();
            if (bVar.f1640f) {
                for (int i2 = 0; i2 < this.g; i2++) {
                    if (this.h[i2].f1646f.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.g; i3++) {
                    this.h[i3].h();
                }
            } else if (bVar.f1639e.f1646f.size() == 1) {
                return;
            } else {
                bVar.f1639e.h();
            }
            a(viewH, nVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x013b  */
    private void a(RecyclerView.n nVar, RecyclerView.r rVar, boolean z) {
        boolean z2;
        a aVar = this.x;
        aVar.a();
        if (!(this.u == null && this.f1618d == -1) && rVar.e() == 0) {
            c(nVar);
            return;
        }
        if (this.u != null) {
            a(aVar);
        } else {
            J();
            aVar.f1636c = this.f1617c;
        }
        a(rVar, aVar);
        if (this.u == null && (aVar.f1636c != this.o || h() != this.t)) {
            this.f1620f.a();
            aVar.f1637d = true;
        }
        if (t() > 0 && (this.u == null || this.u.f1630c < 1)) {
            if (aVar.f1637d) {
                for (int i = 0; i < this.g; i++) {
                    this.h[i].e();
                    if (aVar.f1635b != Integer.MIN_VALUE) {
                        this.h[i].c(aVar.f1635b);
                    }
                }
            } else {
                for (int i2 = 0; i2 < this.g; i2++) {
                    this.h[i2].a(this.f1617c, aVar.f1635b);
                }
            }
        }
        a(nVar);
        this.k.f1877a = false;
        this.y = false;
        e(this.f1616b.f());
        a(aVar.f1634a, rVar);
        if (aVar.f1636c) {
            l(-1);
            a(nVar, this.k, rVar);
            l(1);
            this.k.f1879c = aVar.f1634a + this.k.f1880d;
            a(nVar, this.k, rVar);
        } else {
            l(1);
            a(nVar, this.k, rVar);
            l(-1);
            this.k.f1879c = aVar.f1634a + this.k.f1880d;
            a(nVar, this.k, rVar);
        }
        K();
        if (t() > 0) {
            if (this.f1617c) {
                b(nVar, rVar, true);
                c(nVar, rVar, false);
            } else {
                c(nVar, rVar, true);
                b(nVar, rVar, false);
            }
        }
        if (!z || rVar.a()) {
            z2 = false;
        } else {
            if (this.n != 0 && t() > 0 && (this.y || f() != null)) {
                a(this.A);
                if (I()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            this.f1618d = -1;
            this.f1619e = Integer.MIN_VALUE;
        }
        this.o = aVar.f1636c;
        this.t = h();
        this.u = null;
        if (z2) {
            a(nVar, rVar, false);
        }
    }

    private void a(RecyclerView.n nVar, y yVar) {
        int iMin;
        if (!yVar.f1877a || yVar.i) {
            return;
        }
        if (yVar.f1878b == 0) {
            if (yVar.f1881e == -1) {
                b(nVar, yVar.g);
                return;
            } else {
                a(nVar, yVar.f1882f);
                return;
            }
        }
        if (yVar.f1881e == -1) {
            int iO = yVar.f1882f - o(yVar.f1882f);
            b(nVar, iO < 0 ? yVar.g : yVar.g - Math.min(iO, yVar.f1878b));
            return;
        }
        int iR = r(yVar.g) - yVar.g;
        if (iR < 0) {
            iMin = yVar.f1882f;
        } else {
            iMin = Math.min(iR, yVar.f1878b) + yVar.f1882f;
        }
        a(nVar, iMin);
    }

    private void a(a aVar) {
        if (this.u.f1630c > 0) {
            if (this.u.f1630c == this.g) {
                for (int i = 0; i < this.g; i++) {
                    this.h[i].e();
                    int iD = this.u.f1631d[i];
                    if (iD != Integer.MIN_VALUE) {
                        iD = this.u.i ? iD + this.f1615a.d() : iD + this.f1615a.c();
                    }
                    this.h[i].c(iD);
                }
            } else {
                this.u.a();
                this.u.f1628a = this.u.f1629b;
            }
        }
        this.t = this.u.j;
        a(this.u.h);
        J();
        if (this.u.f1628a != -1) {
            this.f1618d = this.u.f1628a;
            aVar.f1636c = this.u.i;
        } else {
            aVar.f1636c = this.f1617c;
        }
        if (this.u.f1632e > 1) {
            this.f1620f.f1622a = this.u.f1633f;
            this.f1620f.f1623b = this.u.g;
        }
    }

    private void a(c cVar, int i, int i2) {
        int i3 = cVar.i();
        if (i == -1) {
            if (i3 + cVar.b() <= i2) {
                this.m.set(cVar.f1644d, false);
            }
        } else if (cVar.d() - i3 >= i2) {
            this.m.set(cVar.f1644d, false);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        a(view, this.w);
        b bVar = (b) view.getLayoutParams();
        int iB = b(i, bVar.leftMargin + this.w.left, bVar.rightMargin + this.w.right);
        int iB2 = b(i2, bVar.topMargin + this.w.top, bVar.bottomMargin + this.w.bottom);
        if (z ? a(view, iB, iB2, bVar) : b(view, iB, iB2, bVar)) {
            view.measure(iB, iB2);
        }
    }

    private void a(View view, b bVar, y yVar) {
        if (yVar.f1881e == 1) {
            if (bVar.f1640f) {
                p(view);
                return;
            } else {
                bVar.f1639e.b(view);
                return;
            }
        }
        if (bVar.f1640f) {
            q(view);
        } else {
            bVar.f1639e.a(view);
        }
    }

    private void a(View view, b bVar, boolean z) {
        if (bVar.f1640f) {
            if (this.i == 1) {
                a(view, this.v, a(x(), v(), 0, bVar.height, true), z);
                return;
            } else {
                a(view, a(w(), u(), 0, bVar.width, true), this.v, z);
                return;
            }
        }
        if (this.i == 1) {
            a(view, a(this.j, u(), 0, bVar.width, false), a(x(), v(), 0, bVar.height, true), z);
        } else {
            a(view, a(w(), u(), 0, bVar.width, true), a(this.j, v(), 0, bVar.height, false), z);
        }
    }

    private boolean a(c cVar) {
        if (this.f1617c) {
            if (cVar.d() < this.f1615a.d()) {
                return !cVar.c((View) cVar.f1646f.get(cVar.f1646f.size() + (-1))).f1640f;
            }
        } else if (cVar.b() > this.f1615a.c()) {
            return cVar.c((View) cVar.f1646f.get(0)).f1640f ? false : true;
        }
        return false;
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private void b(RecyclerView.n nVar, int i) {
        for (int iT = t() - 1; iT >= 0; iT--) {
            View viewH = h(iT);
            if (this.f1615a.a(viewH) < i) {
                return;
            }
            b bVar = (b) viewH.getLayoutParams();
            if (bVar.f1640f) {
                for (int i2 = 0; i2 < this.g; i2++) {
                    if (this.h[i2].f1646f.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.g; i3++) {
                    this.h[i3].g();
                }
            } else if (bVar.f1639e.f1646f.size() == 1) {
                return;
            } else {
                bVar.f1639e.g();
            }
            a(viewH, nVar);
        }
    }

    private void b(RecyclerView.n nVar, RecyclerView.r rVar, boolean z) {
        int iD;
        int iQ = q(Integer.MIN_VALUE);
        if (iQ != Integer.MIN_VALUE && (iD = this.f1615a.d() - iQ) > 0) {
            int i = iD - (-c(-iD, nVar, rVar));
            if (!z || i <= 0) {
                return;
            }
            this.f1615a.a(i);
        }
    }

    private void b(View view, int i, int i2, int i3, int i4) {
        b bVar = (b) view.getLayoutParams();
        a(view, i + bVar.leftMargin, i2 + bVar.topMargin, i3 - bVar.rightMargin, i4 - bVar.bottomMargin);
    }

    private void c(int i, int i2, int i3) {
        int i4;
        int i5;
        int iL = this.f1617c ? L() : M();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f1620f.b(i5);
        switch (i3) {
            case 1:
                this.f1620f.b(i, i2);
                break;
            case 2:
                this.f1620f.a(i, i2);
                break;
            case 8:
                this.f1620f.a(i, 1);
                this.f1620f.b(i2, 1);
                break;
        }
        if (i4 <= iL) {
            return;
        }
        if (i5 <= (this.f1617c ? M() : L())) {
            n();
        }
    }

    private void c(RecyclerView.n nVar, RecyclerView.r rVar, boolean z) {
        int iC;
        int iP = p(Integer.MAX_VALUE);
        if (iP != Integer.MAX_VALUE && (iC = iP - this.f1615a.c()) > 0) {
            int iC2 = iC - c(iC, nVar, rVar);
            if (!z || iC2 <= 0) {
                return;
            }
            this.f1615a.a(-iC2);
        }
    }

    private boolean c(RecyclerView.r rVar, a aVar) {
        aVar.f1634a = this.o ? v(rVar.e()) : u(rVar.e());
        aVar.f1635b = Integer.MIN_VALUE;
        return true;
    }

    private void e(int i, int i2) {
        for (int i3 = 0; i3 < this.g; i3++) {
            if (!this.h[i3].f1646f.isEmpty()) {
                a(this.h[i3], i, i2);
            }
        }
    }

    private int h(RecyclerView.r rVar) {
        if (t() == 0) {
            return 0;
        }
        return ag.a(rVar, this.f1615a, a(!this.z, true), b(this.z ? false : true, true), this, this.z);
    }

    private int i(RecyclerView.r rVar) {
        if (t() == 0) {
            return 0;
        }
        return ag.b(rVar, this.f1615a, a(!this.z, true), b(this.z ? false : true, true), this, this.z);
    }

    private void l(int i) {
        this.k.f1881e = i;
        this.k.f1880d = this.f1617c != (i == -1) ? -1 : 1;
    }

    private LazySpanLookup.FullSpanItem m(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1626c = new int[this.g];
        for (int i2 = 0; i2 < this.g; i2++) {
            fullSpanItem.f1626c[i2] = i - this.h[i2].b(i);
        }
        return fullSpanItem;
    }

    private void m() {
        this.f1615a = aa.a(this, this.i);
        this.f1616b = aa.a(this, 1 - this.i);
    }

    private LazySpanLookup.FullSpanItem n(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1626c = new int[this.g];
        for (int i2 = 0; i2 < this.g; i2++) {
            fullSpanItem.f1626c[i2] = this.h[i2].a(i) - i;
        }
        return fullSpanItem;
    }

    private int o(int i) {
        int iA = this.h[0].a(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int iA2 = this.h[i2].a(i);
            if (iA2 > iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    private int p(int i) {
        int iA = this.h[0].a(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int iA2 = this.h[i2].a(i);
            if (iA2 < iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    private void p(View view) {
        for (int i = this.g - 1; i >= 0; i--) {
            this.h[i].b(view);
        }
    }

    private int q(int i) {
        int iB = this.h[0].b(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int iB2 = this.h[i2].b(i);
            if (iB2 > iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private void q(View view) {
        for (int i = this.g - 1; i >= 0; i--) {
            this.h[i].a(view);
        }
    }

    private int r(int i) {
        int iB = this.h[0].b(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int iB2 = this.h[i2].b(i);
            if (iB2 < iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private boolean s(int i) {
        if (this.i == 0) {
            return (i == -1) != this.f1617c;
        }
        return ((i == -1) == this.f1617c) == h();
    }

    private int t(int i) {
        if (t() == 0) {
            return this.f1617c ? 1 : -1;
        }
        return (i < M()) == this.f1617c ? 1 : -1;
    }

    private int u(int i) {
        int iT = t();
        for (int i2 = 0; i2 < iT; i2++) {
            int iD = d(h(i2));
            if (iD >= 0 && iD < i) {
                return iD;
            }
        }
        return 0;
    }

    private int v(int i) {
        for (int iT = t() - 1; iT >= 0; iT--) {
            int iD = d(h(iT));
            if (iD >= 0 && iD < i) {
                return iD;
            }
        }
        return 0;
    }

    private int w(int i) {
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
    public int a(int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        return c(i, nVar, rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int a(RecyclerView.n nVar, RecyclerView.r rVar) {
        return this.i == 0 ? this.g : super.a(nVar, rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
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

    @Override // android.support.v7.widget.RecyclerView.h
    public View a(View view, int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        View viewE;
        View viewA;
        if (t() != 0 && (viewE = e(view)) != null) {
            J();
            int iW = w(i);
            if (iW == Integer.MIN_VALUE) {
                return null;
            }
            b bVar = (b) viewE.getLayoutParams();
            boolean z = bVar.f1640f;
            c cVar = bVar.f1639e;
            int iL = iW == 1 ? L() : M();
            a(iL, rVar);
            l(iW);
            this.k.f1879c = this.k.f1880d + iL;
            this.k.f1878b = (int) (0.33333334f * this.f1615a.f());
            this.k.h = true;
            this.k.f1877a = false;
            a(nVar, this.k, rVar);
            this.o = this.f1617c;
            if (!z && (viewA = cVar.a(iL, iW)) != null && viewA != viewE) {
                return viewA;
            }
            if (s(iW)) {
                for (int i2 = this.g - 1; i2 >= 0; i2--) {
                    View viewA2 = this.h[i2].a(iL, iW);
                    if (viewA2 != null && viewA2 != viewE) {
                        return viewA2;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.g; i3++) {
                    View viewA3 = this.h[i3].a(iL, iW);
                    if (viewA3 != null && viewA3 != viewE) {
                        return viewA3;
                    }
                }
            }
            return null;
        }
        return null;
    }

    View a(boolean z, boolean z2) {
        int iC = this.f1615a.c();
        int iD = this.f1615a.d();
        int iT = t();
        View view = null;
        for (int i = 0; i < iT; i++) {
            View viewH = h(i);
            int iA = this.f1615a.a(viewH);
            if (this.f1615a.b(viewH) > iC && iA < iD) {
                if (iA >= iC || !z) {
                    return viewH;
                }
                if (z2 && view == null) {
                    view = viewH;
                }
            }
        }
        return view;
    }

    public void a(int i) {
        a((String) null);
        if (i != this.g) {
            g();
            this.g = i;
            this.m = new BitSet(this.g);
            this.h = new c[this.g];
            for (int i2 = 0; i2 < this.g; i2++) {
                this.h[i2] = new c(i2);
            }
            n();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        int iA3 = A() + y();
        int iZ = z() + B();
        if (this.i == 1) {
            iA2 = a(i2, iZ + rect.height(), E());
            iA = a(i, iA3 + (this.j * this.g), D());
        } else {
            iA = a(i, iA3 + rect.width(), D());
            iA2 = a(i2, iZ + (this.j * this.g), E());
        }
        d(iA, iA2);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.u = (SavedState) parcelable;
            n();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView.n nVar, RecyclerView.r rVar, View view, android.support.v4.view.a.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        if (this.i == 0) {
            cVar.c(android.support.v4.view.a.c.l.a(bVar.b(), bVar.f1640f ? this.g : 1, -1, -1, bVar.f1640f, false));
        } else {
            cVar.c(android.support.v4.view.a.c.l.a(-1, -1, bVar.b(), bVar.f1640f ? this.g : 1, bVar.f1640f, false));
        }
    }

    void a(RecyclerView.r rVar, a aVar) {
        if (b(rVar, aVar) || c(rVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.f1634a = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView) {
        this.f1620f.a();
        n();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(RecyclerView recyclerView, RecyclerView.n nVar) {
        a(this.A);
        for (int i = 0; i < this.g; i++) {
            this.h[i].e();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (t() > 0) {
            android.support.v4.view.a.m mVarA = android.support.v4.view.a.a.a(accessibilityEvent);
            View viewA = a(false, true);
            View viewB = b(false, true);
            if (viewA == null || viewB == null) {
                return;
            }
            int iD = d(viewA);
            int iD2 = d(viewB);
            if (iD < iD2) {
                mVarA.b(iD);
                mVarA.c(iD2);
            } else {
                mVarA.b(iD2);
                mVarA.c(iD);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void a(String str) {
        if (this.u == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a((String) null);
        if (this.u != null && this.u.h != z) {
            this.u.h = z;
        }
        this.l = z;
        n();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public boolean a(RecyclerView.i iVar) {
        return iVar instanceof b;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int b(int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        return c(i, nVar, rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int b(RecyclerView.n nVar, RecyclerView.r rVar) {
        return this.i == 1 ? this.g : super.b(nVar, rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int b(RecyclerView.r rVar) {
        return a(rVar);
    }

    View b(boolean z, boolean z2) {
        int iC = this.f1615a.c();
        int iD = this.f1615a.d();
        View view = null;
        for (int iT = t() - 1; iT >= 0; iT--) {
            View viewH = h(iT);
            int iA = this.f1615a.a(viewH);
            int iB = this.f1615a.b(viewH);
            if (iB > iC && iA < iD) {
                if (iB <= iD || !z) {
                    return viewH;
                }
                if (z2 && view == null) {
                    view = viewH;
                }
            }
        }
        return view;
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a((String) null);
        if (i == this.i) {
            return;
        }
        this.i = i;
        aa aaVar = this.f1615a;
        this.f1615a = this.f1616b;
        this.f1616b = aaVar;
        n();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public boolean b() {
        return this.u == null;
    }

    boolean b(RecyclerView.r rVar, a aVar) {
        if (rVar.a() || this.f1618d == -1) {
            return false;
        }
        if (this.f1618d < 0 || this.f1618d >= rVar.e()) {
            this.f1618d = -1;
            this.f1619e = Integer.MIN_VALUE;
            return false;
        }
        if (this.u != null && this.u.f1628a != -1 && this.u.f1630c >= 1) {
            aVar.f1635b = Integer.MIN_VALUE;
            aVar.f1634a = this.f1618d;
            return true;
        }
        View viewC = c(this.f1618d);
        if (viewC == null) {
            aVar.f1634a = this.f1618d;
            if (this.f1619e == Integer.MIN_VALUE) {
                aVar.f1636c = t(aVar.f1634a) == 1;
                aVar.b();
            } else {
                aVar.a(this.f1619e);
            }
            aVar.f1637d = true;
            return true;
        }
        aVar.f1634a = this.f1617c ? L() : M();
        if (this.f1619e != Integer.MIN_VALUE) {
            if (aVar.f1636c) {
                aVar.f1635b = (this.f1615a.d() - this.f1619e) - this.f1615a.b(viewC);
                return true;
            }
            aVar.f1635b = (this.f1615a.c() + this.f1619e) - this.f1615a.a(viewC);
            return true;
        }
        if (this.f1615a.c(viewC) > this.f1615a.f()) {
            aVar.f1635b = aVar.f1636c ? this.f1615a.d() : this.f1615a.c();
            return true;
        }
        int iA = this.f1615a.a(viewC) - this.f1615a.c();
        if (iA < 0) {
            aVar.f1635b = -iA;
            return true;
        }
        int iD = this.f1615a.d() - this.f1615a.b(viewC);
        if (iD < 0) {
            aVar.f1635b = iD;
            return true;
        }
        aVar.f1635b = Integer.MIN_VALUE;
        return true;
    }

    int c(int i, RecyclerView.n nVar, RecyclerView.r rVar) {
        int i2;
        int iM;
        if (i > 0) {
            iM = L();
            i2 = 1;
        } else {
            i2 = -1;
            iM = M();
        }
        this.k.f1877a = true;
        a(iM, rVar);
        l(i2);
        this.k.f1879c = this.k.f1880d + iM;
        int iAbs = Math.abs(i);
        this.k.f1878b = iAbs;
        int iA = a(nVar, this.k, rVar);
        if (iAbs >= iA) {
            i = i < 0 ? -iA : iA;
        }
        this.f1615a.a(-i);
        this.o = this.f1617c;
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int c(RecyclerView.r rVar) {
        return a(rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public Parcelable c() {
        int iA;
        if (this.u != null) {
            return new SavedState(this.u);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.l;
        savedState.i = this.o;
        savedState.j = this.t;
        if (this.f1620f == null || this.f1620f.f1622a == null) {
            savedState.f1632e = 0;
        } else {
            savedState.f1633f = this.f1620f.f1622a;
            savedState.f1632e = savedState.f1633f.length;
            savedState.g = this.f1620f.f1623b;
        }
        if (t() > 0) {
            savedState.f1628a = this.o ? L() : M();
            savedState.f1629b = i();
            savedState.f1630c = this.g;
            savedState.f1631d = new int[this.g];
            for (int i = 0; i < this.g; i++) {
                if (this.o) {
                    iA = this.h[i].b(Integer.MIN_VALUE);
                    if (iA != Integer.MIN_VALUE) {
                        iA -= this.f1615a.d();
                    }
                } else {
                    iA = this.h[i].a(Integer.MIN_VALUE);
                    if (iA != Integer.MIN_VALUE) {
                        iA -= this.f1615a.c();
                    }
                }
                savedState.f1631d[i] = iA;
            }
        } else {
            savedState.f1628a = -1;
            savedState.f1629b = -1;
            savedState.f1630c = 0;
        }
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void c(RecyclerView.n nVar, RecyclerView.r rVar) {
        a(nVar, rVar, true);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int d(RecyclerView.r rVar) {
        return h(rVar);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void d(int i) {
        if (this.u != null && this.u.f1628a != i) {
            this.u.b();
        }
        this.f1618d = i;
        this.f1619e = Integer.MIN_VALUE;
        n();
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public boolean d() {
        return this.i == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int e(RecyclerView.r rVar) {
        return h(rVar);
    }

    void e(int i) {
        this.j = i / this.g;
        this.v = View.MeasureSpec.makeMeasureSpec(i, this.f1616b.h());
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public boolean e() {
        return this.i == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int f(RecyclerView.r rVar) {
        return i(rVar);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00b7  */
    View f() {
        int i;
        boolean z;
        int iT = t() - 1;
        BitSet bitSet = new BitSet(this.g);
        bitSet.set(0, this.g, true);
        byte b2 = (this.i == 1 && h()) ? (byte) 1 : (byte) -1;
        if (this.f1617c) {
            i = -1;
        } else {
            i = iT + 1;
            iT = 0;
        }
        int i2 = iT < i ? 1 : -1;
        for (int i3 = iT; i3 != i; i3 += i2) {
            View viewH = h(i3);
            b bVar = (b) viewH.getLayoutParams();
            if (bitSet.get(bVar.f1639e.f1644d)) {
                if (a(bVar.f1639e)) {
                    return viewH;
                }
                bitSet.clear(bVar.f1639e.f1644d);
            }
            if (!bVar.f1640f && i3 + i2 != i) {
                View viewH2 = h(i3 + i2);
                if (this.f1617c) {
                    int iB = this.f1615a.b(viewH);
                    int iB2 = this.f1615a.b(viewH2);
                    if (iB < iB2) {
                        return viewH;
                    }
                    if (iB == iB2) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    int iA = this.f1615a.a(viewH);
                    int iA2 = this.f1615a.a(viewH2);
                    if (iA > iA2) {
                        return viewH;
                    }
                    if (iA == iA2) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    if ((bVar.f1639e.f1644d - ((b) viewH2.getLayoutParams()).f1639e.f1644d < 0) != (b2 < 0)) {
                        return viewH;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public int g(RecyclerView.r rVar) {
        return i(rVar);
    }

    public void g() {
        this.f1620f.a();
        n();
    }

    boolean h() {
        return r() == 1;
    }

    int i() {
        View viewB = this.f1617c ? b(true, true) : a(true, true);
        if (viewB == null) {
            return -1;
        }
        return d(viewB);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void i(int i) {
        super.i(i);
        for (int i2 = 0; i2 < this.g; i2++) {
            this.h[i2].d(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void j(int i) {
        super.j(i);
        for (int i2 = 0; i2 < this.g; i2++) {
            this.h[i2].d(i);
        }
    }

    boolean j() {
        int iB = this.h[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.g; i++) {
            if (this.h[i].b(Integer.MIN_VALUE) != iB) {
                return false;
            }
        }
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public void k(int i) {
        if (i == 0) {
            I();
        }
    }

    boolean l() {
        int iA = this.h[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.g; i++) {
            if (this.h[i].a(Integer.MIN_VALUE) != iA) {
                return false;
            }
        }
        return true;
    }
}
