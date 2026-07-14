package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements android.support.v4.view.ad, android.support.v4.view.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f1511a;
    private static final Interpolator aq;
    private static final int[] k = {R.attr.nestedScrollingEnabled};
    private static final boolean l;
    private static final Class<?>[] m;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private final boolean G;
    private final AccessibilityManager H;
    private List<j> I;
    private boolean J;
    private int K;
    private android.support.v4.widget.j L;
    private android.support.v4.widget.j M;
    private android.support.v4.widget.j N;
    private android.support.v4.widget.j O;
    private int P;
    private int Q;
    private VelocityTracker R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private final int aa;
    private final int ab;
    private float ac;
    private final t ad;
    private l ae;
    private List<l> af;
    private e.b ag;
    private boolean ah;
    private ab ai;
    private d aj;
    private final int[] ak;
    private android.support.v4.view.y al;
    private final int[] am;
    private final int[] an;
    private final int[] ao;
    private Runnable ap;
    private final as.b ar;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final n f1512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.support.v7.widget.e f1513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    android.support.v7.widget.s f1514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final as f1515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    h f1516f;
    e g;
    final r h;
    boolean i;
    boolean j;
    private final p n;
    private SavedState o;
    private boolean p;
    private final Runnable q;
    private final Rect r;
    private a s;
    private o t;
    private final ArrayList<g> u;
    private final ArrayList<k> v;
    private k w;
    private boolean x;
    private boolean y;
    private boolean z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.RecyclerView.SavedState.1
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
        Parcelable f1522a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1522a = parcel.readParcelable(h.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SavedState savedState) {
            this.f1522a = savedState.f1522a;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1522a, 0);
        }
    }

    public static abstract class a<VH extends u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f1523a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1524b = false;

        public abstract int a();

        public long a(int i) {
            return -1L;
        }

        public void a(c cVar) {
            this.f1523a.registerObserver(cVar);
        }

        public void a(VH vh) {
        }

        public abstract void a(VH vh, int i);

        public void a(VH vh, int i, List<Object> list) {
            a(vh, i);
        }

        public void a(RecyclerView recyclerView) {
        }

        public int b(int i) {
            return 0;
        }

        public abstract VH b(ViewGroup viewGroup, int i);

        public void b(c cVar) {
            this.f1523a.unregisterObserver(cVar);
        }

        public final void b(VH vh, int i) {
            vh.f1585b = i;
            if (d()) {
                vh.f1587d = a(i);
            }
            vh.a(1, 519);
            android.support.v4.f.h.a("RV OnBindView");
            a(vh, i, vh.u());
            vh.t();
            android.support.v4.f.h.a();
        }

        public void b(RecyclerView recyclerView) {
        }

        public boolean b(VH vh) {
            return false;
        }

        public final VH c(ViewGroup viewGroup, int i) {
            android.support.v4.f.h.a("RV CreateView");
            VH vh = (VH) b(viewGroup, i);
            vh.f1588e = i;
            android.support.v4.f.h.a();
            return vh;
        }

        public void c(VH vh) {
        }

        public void d(VH vh) {
        }

        public final boolean d() {
            return this.f1524b;
        }

        public final void e() {
            this.f1523a.a();
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public void a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }
    }

    public static abstract class c {
        public void a() {
        }
    }

    public interface d {
        int a(int i, int i2);
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f1525a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<a> f1526b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1527c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f1528d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f1529e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f1530f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(u uVar);
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1531a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1532b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1533c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f1534d;

            public c a(u uVar) {
                return a(uVar, 0);
            }

            public c a(u uVar, int i) {
                View view = uVar.f1584a;
                this.f1531a = view.getLeft();
                this.f1532b = view.getTop();
                this.f1533c = view.getRight();
                this.f1534d = view.getBottom();
                return this;
            }
        }

        static int d(u uVar) {
            int i = uVar.l & 14;
            if (uVar.n()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iF = uVar.f();
            int iE = uVar.e();
            return (iF == -1 || iE == -1 || iF == iE) ? i : i | 2048;
        }

        public c a(r rVar, u uVar) {
            return i().a(uVar);
        }

        public c a(r rVar, u uVar, int i, List<Object> list) {
            return i().a(uVar);
        }

        public abstract void a();

        void a(b bVar) {
            this.f1525a = bVar;
        }

        public abstract boolean a(u uVar, c cVar, c cVar2);

        public abstract boolean a(u uVar, u uVar2, c cVar, c cVar2);

        public boolean a(u uVar, List<Object> list) {
            return g(uVar);
        }

        public abstract boolean b();

        public abstract boolean b(u uVar, c cVar, c cVar2);

        public abstract void c();

        public abstract void c(u uVar);

        public abstract boolean c(u uVar, c cVar, c cVar2);

        public long d() {
            return this.f1529e;
        }

        public long e() {
            return this.f1527c;
        }

        public final void e(u uVar) {
            f(uVar);
            if (this.f1525a != null) {
                this.f1525a.a(uVar);
            }
        }

        public long f() {
            return this.f1528d;
        }

        public void f(u uVar) {
        }

        public long g() {
            return this.f1530f;
        }

        public boolean g(u uVar) {
            return true;
        }

        public final void h() {
            int size = this.f1526b.size();
            for (int i = 0; i < size; i++) {
                this.f1526b.get(i).a();
            }
            this.f1526b.clear();
        }

        public c i() {
            return new c();
        }
    }

    private class f implements e.b {
        private f() {
        }

        @Override // android.support.v7.widget.RecyclerView.e.b
        public void a(u uVar) {
            uVar.a(true);
            if (uVar.g != null && uVar.h == null) {
                uVar.g = null;
            }
            uVar.h = null;
            if (uVar.B() || RecyclerView.this.h(uVar.f1584a) || !uVar.r()) {
                return;
            }
            RecyclerView.this.removeDetachedView(uVar.f1584a, false);
        }
    }

    public static abstract class g {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, r rVar) {
            a(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, r rVar) {
            a(rect, ((i) view.getLayoutParams()).e(), recyclerView);
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, r rVar) {
            b(canvas, recyclerView);
        }
    }

    public static abstract class h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1539d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1540e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1541f;
        private int g;
        android.support.v7.widget.s p;
        RecyclerView q;
        q r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1536a = false;
        boolean s = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1537b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1538c = true;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1542a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1543b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f1544c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f1545d;
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        /* JADX WARN: Code duplicated, block: B:24:0x003a  */
        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    iMax = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = iMax;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    iMax = i5;
                    i5 = i2;
                } else if (i4 == -2) {
                    iMax = 0;
                } else {
                    iMax = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                iMax = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else if (i4 != -2) {
                iMax = 0;
            } else if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                i5 = Integer.MIN_VALUE;
            }
            return View.MeasureSpec.makeMeasureSpec(iMax, i5);
        }

        public static a a(Context context, AttributeSet attributeSet, int i, int i2) {
            a aVar = new a();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.e.a.C0031a.RecyclerView, i, i2);
            aVar.f1542a = typedArrayObtainStyledAttributes.getInt(android.support.v7.e.a.C0031a.RecyclerView_android_orientation, 1);
            aVar.f1543b = typedArrayObtainStyledAttributes.getInt(android.support.v7.e.a.C0031a.RecyclerView_spanCount, 1);
            aVar.f1544c = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.e.a.C0031a.RecyclerView_reverseLayout, false);
            aVar.f1545d = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.e.a.C0031a.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return aVar;
        }

        private void a(int i, View view) {
            this.p.d(i);
        }

        private void a(n nVar, int i, View view) {
            u uVarC = RecyclerView.c(view);
            if (uVarC.c()) {
                return;
            }
            if (uVarC.n() && !uVarC.q() && !this.q.s.d()) {
                f(i);
                nVar.b(uVarC);
            } else {
                g(i);
                nVar.c(view);
                this.q.f1515e.h(uVarC);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(q qVar) {
            if (this.r == qVar) {
                this.r = null;
            }
        }

        private void a(View view, int i, boolean z) {
            u uVarC = RecyclerView.c(view);
            if (z || uVarC.q()) {
                this.q.f1515e.e(uVarC);
            } else {
                this.q.f1515e.f(uVarC);
            }
            i iVar = (i) view.getLayoutParams();
            if (uVarC.k() || uVarC.i()) {
                if (uVarC.i()) {
                    uVarC.j();
                } else {
                    uVarC.l();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int iB = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (iB == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view));
                }
                if (iB != i) {
                    this.q.f1516f.c(iB, i);
                }
            } else {
                this.p.a(view, i, false);
                iVar.f1548c = true;
                if (this.r != null && this.r.c()) {
                    this.r.b(view);
                }
            }
            if (iVar.f1549d) {
                uVarC.f1584a.invalidate();
                iVar.f1549d = false;
            }
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size >= i;
                case 0:
                    return true;
                case 1073741824:
                    return size == i;
                default:
                    return false;
            }
        }

        public int A() {
            if (this.q != null) {
                return this.q.getPaddingRight();
            }
            return 0;
        }

        public int B() {
            if (this.q != null) {
                return this.q.getPaddingBottom();
            }
            return 0;
        }

        public View C() {
            View focusedChild;
            if (this.q == null || (focusedChild = this.q.getFocusedChild()) == null || this.p.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int D() {
            return android.support.v4.view.ah.q(this.q);
        }

        public int E() {
            return android.support.v4.view.ah.r(this.q);
        }

        void F() {
            if (this.r != null) {
                this.r.a();
            }
        }

        public void G() {
            this.f1536a = true;
        }

        boolean H() {
            int iT = t();
            for (int i = 0; i < iT; i++) {
                ViewGroup.LayoutParams layoutParams = h(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int a(int i, n nVar, r rVar) {
            return 0;
        }

        public int a(n nVar, r rVar) {
            if (this.q == null || this.q.s == null || !e()) {
                return 1;
            }
            return this.q.s.a();
        }

        public abstract i a();

        public i a(Context context, AttributeSet attributeSet) {
            return new i(context, attributeSet);
        }

        public i a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof i) {
                return new i((i) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new i((ViewGroup.MarginLayoutParams) layoutParams) : new i(layoutParams);
        }

        public View a(View view, int i, n nVar, r rVar) {
            return null;
        }

        void a(int i, int i2) {
            this.f1541f = View.MeasureSpec.getSize(i);
            this.f1539d = View.MeasureSpec.getMode(i);
            if (this.f1539d == 0 && !RecyclerView.f1511a) {
                this.f1541f = 0;
            }
            this.g = View.MeasureSpec.getSize(i2);
            this.f1540e = View.MeasureSpec.getMode(i2);
            if (this.f1540e != 0 || RecyclerView.f1511a) {
                return;
            }
            this.g = 0;
        }

        public void a(int i, n nVar) {
            View viewH = h(i);
            f(i);
            nVar.a(viewH);
        }

        public void a(Rect rect, int i, int i2) {
            d(a(i, rect.width() + y() + A(), D()), a(i2, rect.height() + z() + B(), E()));
        }

        public void a(Parcelable parcelable) {
        }

        void a(android.support.v4.view.a.c cVar) {
            a(this.q.f1512b, this.q.h, cVar);
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(n nVar) {
            for (int iT = t() - 1; iT >= 0; iT--) {
                a(nVar, iT, h(iT));
            }
        }

        public void a(n nVar, r rVar, int i, int i2) {
            this.q.d(i, i2);
        }

        public void a(n nVar, r rVar, android.support.v4.view.a.c cVar) {
            if (android.support.v4.view.ah.b((View) this.q, -1) || android.support.v4.view.ah.a((View) this.q, -1)) {
                cVar.a(8192);
                cVar.i(true);
            }
            if (android.support.v4.view.ah.b((View) this.q, 1) || android.support.v4.view.ah.a((View) this.q, 1)) {
                cVar.a(4096);
                cVar.i(true);
            }
            cVar.b(android.support.v4.view.a.c.k.a(a(nVar, rVar), b(nVar, rVar), e(nVar, rVar), d(nVar, rVar)));
        }

        public void a(n nVar, r rVar, View view, android.support.v4.view.a.c cVar) {
            cVar.c(android.support.v4.view.a.c.l.a(e() ? d(view) : 0, 1, d() ? d(view) : 0, 1, false, false));
        }

        public void a(n nVar, r rVar, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            android.support.v4.view.a.m mVarA = android.support.v4.view.a.a.a(accessibilityEvent);
            if (this.q == null || mVarA == null) {
                return;
            }
            if (!android.support.v4.view.ah.b((View) this.q, 1) && !android.support.v4.view.ah.b((View) this.q, -1) && !android.support.v4.view.ah.a((View) this.q, -1) && !android.support.v4.view.ah.a((View) this.q, 1)) {
                z = false;
            }
            mVarA.a(z);
            if (this.q.s != null) {
                mVarA.a(this.q.s.a());
            }
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(RecyclerView recyclerView, n nVar) {
            e(recyclerView);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void a(View view, int i, int i2) {
            i iVar = (i) view.getLayoutParams();
            Rect rectG = this.q.g(view);
            int i3 = rectG.left + rectG.right + i;
            int i4 = rectG.bottom + rectG.top + i2;
            int iA = a(w(), u(), i3 + y() + A() + iVar.leftMargin + iVar.rightMargin, iVar.width, d());
            int iA2 = a(x(), v(), i4 + z() + B() + iVar.topMargin + iVar.bottomMargin, iVar.height, e());
            if (b(view, iA, iA2, iVar)) {
                view.measure(iA, iA2);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((i) view.getLayoutParams()).f1547b;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public void a(View view, int i, i iVar) {
            u uVarC = RecyclerView.c(view);
            if (uVarC.q()) {
                this.q.f1515e.e(uVarC);
            } else {
                this.q.f1515e.f(uVarC);
            }
            this.p.a(view, i, iVar, uVarC.q());
        }

        public void a(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.g(view));
            }
        }

        void a(View view, android.support.v4.view.a.c cVar) {
            u uVarC = RecyclerView.c(view);
            if (uVarC == null || uVarC.q() || this.p.c(uVarC.f1584a)) {
                return;
            }
            a(this.q.f1512b, this.q.h, view, cVar);
        }

        public void a(View view, n nVar) {
            c(view);
            nVar.a(view);
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.f1512b, this.q.h, accessibilityEvent);
        }

        public void a(String str) {
            if (this.q != null) {
                this.q.a(str);
            }
        }

        boolean a(int i, Bundle bundle) {
            return a(this.q.f1512b, this.q.h, i, bundle);
        }

        public boolean a(i iVar) {
            return iVar != null;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x007a A[PHI: r0
          0x007a: PHI (r0v9 int) = (r0v4 int), (r0v14 int) binds: [B:20:0x0066, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
        public boolean a(n nVar, r rVar, int i, Bundle bundle) {
            int iX;
            int i2;
            int iW;
            if (this.q == null) {
                return false;
            }
            switch (i) {
                case 4096:
                    iX = android.support.v4.view.ah.b((View) this.q, 1) ? (x() - z()) - B() : 0;
                    if (!android.support.v4.view.ah.a((View) this.q, 1)) {
                        i2 = iX;
                        iW = 0;
                    } else {
                        i2 = iX;
                        iW = (w() - y()) - A();
                    }
                    break;
                case 8192:
                    iX = android.support.v4.view.ah.b((View) this.q, -1) ? -((x() - z()) - B()) : 0;
                    if (!android.support.v4.view.ah.a((View) this.q, -1)) {
                        i2 = iX;
                        iW = 0;
                    } else {
                        i2 = iX;
                        iW = -((w() - y()) - A());
                    }
                    break;
                default:
                    iW = 0;
                    i2 = 0;
                    break;
            }
            if (i2 == 0 && iW == 0) {
                return false;
            }
            this.q.scrollBy(iW, i2);
            return true;
        }

        public boolean a(n nVar, r rVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, r rVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int iMin;
            int iY = y();
            int iZ = z();
            int iW = w() - A();
            int iX = x() - B();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = left + rect.width();
            int iHeight = top + rect.height();
            int iMin2 = Math.min(0, left - iY);
            int iMin3 = Math.min(0, top - iZ);
            int iMax = Math.max(0, iWidth - iW);
            int iMax2 = Math.max(0, iHeight - iX);
            if (r() == 1) {
                if (iMax == 0) {
                    iMax = Math.max(iMin2, iWidth - iW);
                }
                iMin = iMax;
            } else {
                iMin = iMin2 != 0 ? iMin2 : Math.min(left - iY, iMax);
            }
            int iMin4 = iMin3 != 0 ? iMin3 : Math.min(top - iZ, iMax2);
            if (iMin == 0 && iMin4 == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(iMin, iMin4);
            } else {
                recyclerView.a(iMin, iMin4);
            }
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return q() || recyclerView.j();
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        boolean a(View view, int i, int i2, i iVar) {
            return (this.f1538c && b(view.getMeasuredWidth(), i, iVar.width) && b(view.getMeasuredHeight(), i2, iVar.height)) ? false : true;
        }

        boolean a(View view, int i, Bundle bundle) {
            return a(this.q.f1512b, this.q.h, view, i, bundle);
        }

        public boolean a(Runnable runnable) {
            if (this.q != null) {
                return this.q.removeCallbacks(runnable);
            }
            return false;
        }

        public int b(int i, n nVar, r rVar) {
            return 0;
        }

        public int b(n nVar, r rVar) {
            if (this.q == null || this.q.s == null || !d()) {
                return 1;
            }
            return this.q.s.a();
        }

        public int b(r rVar) {
            return 0;
        }

        void b(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int iT = t();
            if (iT == 0) {
                this.q.d(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < iT) {
                View viewH = h(i5);
                i iVar = (i) viewH.getLayoutParams();
                int iH = h(viewH) - iVar.leftMargin;
                int iJ = iVar.rightMargin + j(viewH);
                int i8 = i(viewH) - iVar.topMargin;
                int iK = iVar.bottomMargin + k(viewH);
                if (iH >= i7) {
                    iH = i7;
                }
                if (iJ <= i6) {
                    iJ = i6;
                }
                if (i8 >= i3) {
                    i8 = i3;
                }
                if (iK <= i4) {
                    iK = i4;
                }
                i5++;
                i6 = iJ;
                i3 = i8;
                i7 = iH;
                i4 = iK;
            }
            this.q.r.set(i7, i3, i6, i4);
            a(this.q.r, i, i2);
        }

        void b(n nVar) {
            int iD = nVar.d();
            for (int i = iD - 1; i >= 0; i--) {
                View viewE = nVar.e(i);
                u uVarC = RecyclerView.c(viewE);
                if (!uVarC.c()) {
                    uVarC.a(false);
                    if (uVarC.r()) {
                        this.q.removeDetachedView(viewE, false);
                    }
                    if (this.q.g != null) {
                        this.q.g.c(uVarC);
                    }
                    uVarC.a(true);
                    nVar.b(viewE);
                }
            }
            nVar.e();
            if (iD > 0) {
                this.q.invalidate();
            }
        }

        void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.f1541f = 0;
                this.g = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.f1514d;
                this.f1541f = recyclerView.getWidth();
                this.g = recyclerView.getHeight();
            }
            this.f1539d = 1073741824;
            this.f1540e = 1073741824;
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        void b(RecyclerView recyclerView, n nVar) {
            this.s = false;
            a(recyclerView, nVar);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        public boolean b() {
            return false;
        }

        boolean b(View view, int i, int i2, i iVar) {
            return (!view.isLayoutRequested() && this.f1538c && b(view.getWidth(), i, iVar.width) && b(view.getHeight(), i2, iVar.height)) ? false : true;
        }

        public int c(r rVar) {
            return 0;
        }

        public Parcelable c() {
            return null;
        }

        public View c(int i) {
            int iT = t();
            for (int i2 = 0; i2 < iT; i2++) {
                View viewH = h(i2);
                u uVarC = RecyclerView.c(viewH);
                if (uVarC != null && uVarC.d() == i && !uVarC.c() && (this.q.h.a() || !uVarC.q())) {
                    return viewH;
                }
            }
            return null;
        }

        public void c(int i, int i2) {
            View viewH = h(i);
            if (viewH == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            g(i);
            c(viewH, i2);
        }

        public void c(n nVar) {
            for (int iT = t() - 1; iT >= 0; iT--) {
                if (!RecyclerView.c(h(iT)).c()) {
                    a(iT, nVar);
                }
            }
        }

        public void c(n nVar, r rVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void c(RecyclerView recyclerView) {
            this.s = true;
            d(recyclerView);
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void c(View view, int i) {
            a(view, i, (i) view.getLayoutParams());
        }

        public void c(boolean z) {
            this.f1537b = z;
        }

        public int d(n nVar, r rVar) {
            return 0;
        }

        public int d(r rVar) {
            return 0;
        }

        public int d(View view) {
            return ((i) view.getLayoutParams()).e();
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(int i) {
        }

        public void d(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public void d(RecyclerView recyclerView) {
        }

        public boolean d() {
            return false;
        }

        public int e(r rVar) {
            return 0;
        }

        public View e(View view) {
            View viewB;
            if (this.q == null || (viewB = this.q.b(view)) == null || this.p.c(viewB)) {
                return null;
            }
            return viewB;
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(n nVar, r rVar) {
            return false;
        }

        public int f(r rVar) {
            return 0;
        }

        public int f(View view) {
            Rect rect = ((i) view.getLayoutParams()).f1547b;
            return rect.right + view.getMeasuredWidth() + rect.left;
        }

        public void f(int i) {
            if (h(i) != null) {
                this.p.a(i);
            }
        }

        void f(RecyclerView recyclerView) {
            a(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int g(r rVar) {
            return 0;
        }

        public int g(View view) {
            Rect rect = ((i) view.getLayoutParams()).f1547b;
            return rect.bottom + view.getMeasuredHeight() + rect.top;
        }

        public void g(int i) {
            a(i, h(i));
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public View h(int i) {
            if (this.p != null) {
                return this.p.b(i);
            }
            return null;
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public void i(int i) {
            if (this.q != null) {
                this.q.b(i);
            }
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public void j(int i) {
            if (this.q != null) {
                this.q.a(i);
            }
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void k(int i) {
        }

        boolean k() {
            return false;
        }

        public int l(View view) {
            return ((i) view.getLayoutParams()).f1547b.top;
        }

        public int m(View view) {
            return ((i) view.getLayoutParams()).f1547b.bottom;
        }

        public int n(View view) {
            return ((i) view.getLayoutParams()).f1547b.left;
        }

        public void n() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public int o(View view) {
            return ((i) view.getLayoutParams()).f1547b.right;
        }

        public boolean o() {
            return this.s;
        }

        public boolean p() {
            return this.q != null && this.q.p;
        }

        public boolean q() {
            return this.r != null && this.r.c();
        }

        public int r() {
            return android.support.v4.view.ah.h(this.q);
        }

        public int s() {
            return -1;
        }

        public int t() {
            if (this.p != null) {
                return this.p.b();
            }
            return 0;
        }

        public int u() {
            return this.f1539d;
        }

        public int v() {
            return this.f1540e;
        }

        public int w() {
            return this.f1541f;
        }

        public int x() {
            return this.g;
        }

        public int y() {
            if (this.q != null) {
                return this.q.getPaddingLeft();
            }
            return 0;
        }

        public int z() {
            if (this.q != null) {
                return this.q.getPaddingTop();
            }
            return 0;
        }
    }

    public static class i extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        u f1546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Rect f1547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1549d;

        public i(int i, int i2) {
            super(i, i2);
            this.f1547b = new Rect();
            this.f1548c = true;
            this.f1549d = false;
        }

        public i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1547b = new Rect();
            this.f1548c = true;
            this.f1549d = false;
        }

        public i(i iVar) {
            super((ViewGroup.LayoutParams) iVar);
            this.f1547b = new Rect();
            this.f1548c = true;
            this.f1549d = false;
        }

        public i(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1547b = new Rect();
            this.f1548c = true;
            this.f1549d = false;
        }

        public i(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1547b = new Rect();
            this.f1548c = true;
            this.f1549d = false;
        }

        public boolean c() {
            return this.f1546a.q();
        }

        public boolean d() {
            return this.f1546a.x();
        }

        public int e() {
            return this.f1546a.d();
        }
    }

    public interface j {
        void a(View view);

        void b(View view);
    }

    public interface k {
        void a(boolean z);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class l {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SparseArray<ArrayList<u>> f1550a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseIntArray f1551b = new SparseIntArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1552c = 0;

        private ArrayList<u> b(int i) {
            ArrayList<u> arrayList = this.f1550a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f1550a.put(i, arrayList);
                if (this.f1551b.indexOfKey(i) < 0) {
                    this.f1551b.put(i, 5);
                }
            }
            return arrayList;
        }

        public u a(int i) {
            ArrayList<u> arrayList = this.f1550a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            u uVar = arrayList.get(size);
            arrayList.remove(size);
            return uVar;
        }

        public void a() {
            this.f1550a.clear();
        }

        void a(a aVar) {
            this.f1552c++;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                b();
            }
            if (!z && this.f1552c == 0) {
                a();
            }
            if (aVar2 != null) {
                a(aVar2);
            }
        }

        public void a(u uVar) {
            int iH = uVar.h();
            ArrayList<u> arrayListB = b(iH);
            if (this.f1551b.get(iH) <= arrayListB.size()) {
                return;
            }
            uVar.v();
            arrayListB.add(uVar);
        }

        void b() {
            this.f1552c--;
        }
    }

    public final class n {
        private m g;
        private s h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList<u> f1553a = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList<u> f1556d = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<u> f1554b = new ArrayList<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<u> f1557e = Collections.unmodifiableList(this.f1553a);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1558f = 2;

        public n() {
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void d(View view) {
            if (RecyclerView.this.i()) {
                if (android.support.v4.view.ah.e(view) == 0) {
                    android.support.v4.view.ah.c(view, 1);
                }
                if (android.support.v4.view.ah.b(view)) {
                    return;
                }
                android.support.v4.view.ah.a(view, RecyclerView.this.ai.b());
            }
        }

        private void f(u uVar) {
            if (uVar.f1584a instanceof ViewGroup) {
                a((ViewGroup) uVar.f1584a, false);
            }
        }

        u a(int i, int i2, boolean z) {
            View viewA;
            int size = this.f1553a.size();
            for (int i3 = 0; i3 < size; i3++) {
                u uVar = this.f1553a.get(i3);
                if (!uVar.k() && uVar.d() == i && !uVar.n() && (RecyclerView.this.h.h || !uVar.q())) {
                    if (i2 != -1 && uVar.h() != i2) {
                        Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has wrong view type! (found " + uVar.h() + " but expected " + i2 + ")");
                        break;
                    }
                    uVar.b(32);
                    return uVar;
                }
            }
            if (!z && (viewA = RecyclerView.this.f1514d.a(i, i2)) != null) {
                u uVarC = RecyclerView.c(viewA);
                RecyclerView.this.f1514d.e(viewA);
                int iB = RecyclerView.this.f1514d.b(viewA);
                if (iB == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + uVarC);
                }
                RecyclerView.this.f1514d.d(iB);
                c(viewA);
                uVarC.b(8224);
                return uVarC;
            }
            int size2 = this.f1554b.size();
            for (int i4 = 0; i4 < size2; i4++) {
                u uVar2 = this.f1554b.get(i4);
                if (!uVar2.n() && uVar2.d() == i) {
                    if (z) {
                        return uVar2;
                    }
                    this.f1554b.remove(i4);
                    return uVar2;
                }
            }
            return null;
        }

        u a(long j, int i, boolean z) {
            for (int size = this.f1553a.size() - 1; size >= 0; size--) {
                u uVar = this.f1553a.get(size);
                if (uVar.g() == j && !uVar.k()) {
                    if (i == uVar.h()) {
                        uVar.b(32);
                        if (!uVar.q() || RecyclerView.this.h.a()) {
                            return uVar;
                        }
                        uVar.a(2, 14);
                        return uVar;
                    }
                    if (!z) {
                        this.f1553a.remove(size);
                        RecyclerView.this.removeDetachedView(uVar.f1584a, false);
                        b(uVar.f1584a);
                    }
                }
            }
            for (int size2 = this.f1554b.size() - 1; size2 >= 0; size2--) {
                u uVar2 = this.f1554b.get(size2);
                if (uVar2.g() == j) {
                    if (i == uVar2.h()) {
                        if (z) {
                            return uVar2;
                        }
                        this.f1554b.remove(size2);
                        return uVar2;
                    }
                    if (!z) {
                        d(size2);
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0227 A[PHI: r0 r3
          0x0227: PHI (r0v11 android.support.v7.widget.RecyclerView$u) = (r0v10 android.support.v7.widget.RecyclerView$u), (r0v49 android.support.v7.widget.RecyclerView$u) binds: [B:25:0x0084, B:61:0x0153] A[DONT_GENERATE, DONT_INLINE]
          0x0227: PHI (r3v3 boolean) = (r3v2 boolean), (r3v14 boolean) binds: [B:25:0x0084, B:61:0x0153] A[DONT_GENERATE, DONT_INLINE]] */
        View a(int i, boolean z) {
            u uVarA;
            boolean z2;
            boolean z3;
            u uVarC;
            boolean z4;
            boolean z5;
            i iVar;
            View viewA;
            if (i < 0 || i >= RecyclerView.this.h.e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.h.e());
            }
            if (RecyclerView.this.h.a()) {
                u uVarF = f(i);
                z2 = uVarF != null;
                uVarA = uVarF;
            } else {
                uVarA = null;
                z2 = false;
            }
            if (uVarA != null || (uVarA = a(i, -1, z)) == null) {
                z3 = z2;
            } else if (a(uVarA)) {
                z3 = true;
            } else {
                if (!z) {
                    uVarA.b(4);
                    if (uVarA.i()) {
                        RecyclerView.this.removeDetachedView(uVarA.f1584a, false);
                        uVarA.j();
                    } else if (uVarA.k()) {
                        uVarA.l();
                    }
                    b(uVarA);
                }
                uVarA = null;
                z3 = z2;
            }
            if (uVarA != null) {
                uVarC = uVarA;
                z4 = z3;
            } else {
                int iB = RecyclerView.this.f1513c.b(i);
                if (iB < 0 || iB >= RecyclerView.this.s.a()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iB + ").state:" + RecyclerView.this.h.e());
                }
                int iB2 = RecyclerView.this.s.b(iB);
                if (RecyclerView.this.s.d() && (uVarA = a(RecyclerView.this.s.a(iB), iB2, z)) != null) {
                    uVarA.f1585b = iB;
                    z3 = true;
                }
                if (uVarA == null && this.h != null && (viewA = this.h.a(this, i, iB2)) != null) {
                    uVarA = RecyclerView.this.a(viewA);
                    if (uVarA == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    }
                    if (uVarA.c()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
                if (uVarA == null && (uVarA = f().a(iB2)) != null) {
                    uVarA.v();
                    if (RecyclerView.l) {
                        f(uVarA);
                    }
                }
                if (uVarA == null) {
                    uVarC = RecyclerView.this.s.c(RecyclerView.this, iB2);
                    z4 = z3;
                } else {
                    uVarC = uVarA;
                    z4 = z3;
                }
            }
            if (z4 && !RecyclerView.this.h.a() && uVarC.a(8192)) {
                uVarC.a(0, 8192);
                if (RecyclerView.this.h.i) {
                    RecyclerView.this.a(uVarC, RecyclerView.this.g.a(RecyclerView.this.h, uVarC, e.d(uVarC) | 4096, uVarC.u()));
                }
            }
            if (RecyclerView.this.h.a() && uVarC.p()) {
                uVarC.f1589f = i;
                z5 = false;
            } else if (!uVarC.p() || uVarC.o() || uVarC.n()) {
                int iB3 = RecyclerView.this.f1513c.b(i);
                uVarC.k = RecyclerView.this;
                RecyclerView.this.s.b(uVarC, iB3);
                d(uVarC.f1584a);
                if (RecyclerView.this.h.a()) {
                    uVarC.f1589f = i;
                }
                z5 = true;
            } else {
                z5 = false;
            }
            ViewGroup.LayoutParams layoutParams = uVarC.f1584a.getLayoutParams();
            if (layoutParams == null) {
                iVar = (i) RecyclerView.this.generateDefaultLayoutParams();
                uVarC.f1584a.setLayoutParams(iVar);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                iVar = (i) layoutParams;
            } else {
                iVar = (i) RecyclerView.this.generateLayoutParams(layoutParams);
                uVarC.f1584a.setLayoutParams(iVar);
            }
            iVar.f1546a = uVarC;
            iVar.f1549d = z4 && z5;
            return uVarC.f1584a;
        }

        public void a() {
            this.f1553a.clear();
            c();
        }

        public void a(int i) {
            this.f1558f = i;
            for (int size = this.f1554b.size() - 1; size >= 0 && this.f1554b.size() > i; size--) {
                d(size);
            }
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f1554b.size();
            for (int i6 = 0; i6 < size; i6++) {
                u uVar = this.f1554b.get(i6);
                if (uVar != null && uVar.f1585b >= i5 && uVar.f1585b <= i4) {
                    if (uVar.f1585b == i) {
                        uVar.a(i2 - i, false);
                    } else {
                        uVar.a(i3, false);
                    }
                }
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            f().a(aVar, aVar2, z);
        }

        void a(m mVar) {
            if (this.g != null) {
                this.g.b();
            }
            this.g = mVar;
            if (mVar != null) {
                this.g.a(RecyclerView.this.getAdapter());
            }
        }

        void a(s sVar) {
            this.h = sVar;
        }

        public void a(View view) {
            u uVarC = RecyclerView.c(view);
            if (uVarC.r()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (uVarC.i()) {
                uVarC.j();
            } else if (uVarC.k()) {
                uVarC.l();
            }
            b(uVarC);
        }

        boolean a(u uVar) {
            if (uVar.q()) {
                return RecyclerView.this.h.a();
            }
            if (uVar.f1585b < 0 || uVar.f1585b >= RecyclerView.this.s.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + uVar);
            }
            if (RecyclerView.this.h.a() || RecyclerView.this.s.b(uVar.f1585b) == uVar.h()) {
                return !RecyclerView.this.s.d() || uVar.g() == RecyclerView.this.s.a(uVar.f1585b);
            }
            return false;
        }

        public int b(int i) {
            if (i < 0 || i >= RecyclerView.this.h.e()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.h.e());
            }
            return !RecyclerView.this.h.a() ? i : RecyclerView.this.f1513c.b(i);
        }

        public List<u> b() {
            return this.f1557e;
        }

        void b(int i, int i2) {
            int size = this.f1554b.size();
            for (int i3 = 0; i3 < size; i3++) {
                u uVar = this.f1554b.get(i3);
                if (uVar != null && uVar.f1585b >= i) {
                    uVar.a(i2, true);
                }
            }
        }

        void b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f1554b.size() - 1; size >= 0; size--) {
                u uVar = this.f1554b.get(size);
                if (uVar != null) {
                    if (uVar.f1585b >= i3) {
                        uVar.a(-i2, z);
                    } else if (uVar.f1585b >= i) {
                        uVar.b(8);
                        d(size);
                    }
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:47:0x00ce  */
        void b(u uVar) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (uVar.i() || uVar.f1584a.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + uVar.i() + " isAttached:" + (uVar.f1584a.getParent() != null));
            }
            if (uVar.r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + uVar);
            }
            if (uVar.c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            }
            boolean zC = uVar.C();
            if ((RecyclerView.this.s != null && zC && RecyclerView.this.s.b(uVar)) || uVar.w()) {
                if (uVar.a(14)) {
                    z = false;
                } else {
                    int size = this.f1554b.size();
                    if (size == this.f1558f && size > 0) {
                        d(0);
                    }
                    if (size < this.f1558f) {
                        this.f1554b.add(uVar);
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    z2 = z;
                } else {
                    c(uVar);
                    z3 = true;
                    z2 = z;
                }
            } else {
                z2 = false;
            }
            RecyclerView.this.f1515e.g(uVar);
            if (z2 || z3 || !zC) {
                return;
            }
            uVar.k = null;
        }

        void b(View view) {
            u uVarC = RecyclerView.c(view);
            uVarC.o = null;
            uVarC.p = false;
            uVarC.l();
            b(uVarC);
        }

        public View c(int i) {
            return a(i, false);
        }

        void c() {
            for (int size = this.f1554b.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.f1554b.clear();
        }

        void c(int i, int i2) {
            int iD;
            int i3 = i + i2;
            for (int size = this.f1554b.size() - 1; size >= 0; size--) {
                u uVar = this.f1554b.get(size);
                if (uVar != null && (iD = uVar.d()) >= i && iD < i3) {
                    uVar.b(2);
                    d(size);
                }
            }
        }

        void c(u uVar) {
            android.support.v4.view.ah.a(uVar.f1584a, (android.support.v4.view.a) null);
            e(uVar);
            uVar.k = null;
            f().a(uVar);
        }

        void c(View view) {
            u uVarC = RecyclerView.c(view);
            if (!uVarC.a(12) && uVarC.x() && !RecyclerView.this.c(uVarC)) {
                if (this.f1556d == null) {
                    this.f1556d = new ArrayList<>();
                }
                uVarC.a(this, true);
                this.f1556d.add(uVarC);
                return;
            }
            if (uVarC.n() && !uVarC.q() && !RecyclerView.this.s.d()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
            uVarC.a(this, false);
            this.f1553a.add(uVarC);
        }

        int d() {
            return this.f1553a.size();
        }

        void d(int i) {
            c(this.f1554b.get(i));
            this.f1554b.remove(i);
        }

        void d(u uVar) {
            if (uVar.p) {
                this.f1556d.remove(uVar);
            } else {
                this.f1553a.remove(uVar);
            }
            uVar.o = null;
            uVar.p = false;
            uVar.l();
        }

        View e(int i) {
            return this.f1553a.get(i).f1584a;
        }

        void e() {
            this.f1553a.clear();
            if (this.f1556d != null) {
                this.f1556d.clear();
            }
        }

        void e(u uVar) {
            if (RecyclerView.this.t != null) {
                RecyclerView.this.t.a(uVar);
            }
            if (RecyclerView.this.s != null) {
                RecyclerView.this.s.a(uVar);
            }
            if (RecyclerView.this.h != null) {
                RecyclerView.this.f1515e.g(uVar);
            }
        }

        m f() {
            if (this.g == null) {
                this.g = new m();
            }
            return this.g;
        }

        u f(int i) {
            int size;
            int iB;
            if (this.f1556d == null || (size = this.f1556d.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                u uVar = this.f1556d.get(i2);
                if (!uVar.k() && uVar.d() == i) {
                    uVar.b(32);
                    return uVar;
                }
            }
            if (RecyclerView.this.s.d() && (iB = RecyclerView.this.f1513c.b(i)) > 0 && iB < RecyclerView.this.s.a()) {
                long jA = RecyclerView.this.s.a(iB);
                for (int i3 = 0; i3 < size; i3++) {
                    u uVar2 = this.f1556d.get(i3);
                    if (!uVar2.k() && uVar2.g() == jA) {
                        uVar2.b(32);
                        return uVar2;
                    }
                }
            }
            return null;
        }

        void g() {
            int size = this.f1554b.size();
            for (int i = 0; i < size; i++) {
                u uVar = this.f1554b.get(i);
                if (uVar != null) {
                    uVar.b(512);
                }
            }
        }

        void h() {
            if (RecyclerView.this.s == null || !RecyclerView.this.s.d()) {
                c();
                return;
            }
            int size = this.f1554b.size();
            for (int i = 0; i < size; i++) {
                u uVar = this.f1554b.get(i);
                if (uVar != null) {
                    uVar.b(6);
                    uVar.a((Object) null);
                }
            }
        }

        void i() {
            int size = this.f1554b.size();
            for (int i = 0; i < size; i++) {
                this.f1554b.get(i).a();
            }
            int size2 = this.f1553a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f1553a.get(i2).a();
            }
            if (this.f1556d != null) {
                int size3 = this.f1556d.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f1556d.get(i3).a();
                }
            }
        }

        void j() {
            int size = this.f1554b.size();
            for (int i = 0; i < size; i++) {
                i iVar = (i) this.f1554b.get(i).f1584a.getLayoutParams();
                if (iVar != null) {
                    iVar.f1548c = true;
                }
            }
        }
    }

    public interface o {
        void a(u uVar);
    }

    private class p extends c {
        private p() {
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public void a() {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.s.d()) {
                RecyclerView.this.h.g = true;
                RecyclerView.this.I();
            } else {
                RecyclerView.this.h.g = true;
                RecyclerView.this.I();
            }
            if (RecyclerView.this.f1513c.d()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    public static abstract class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView f1561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h f1562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1564e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f1565f;
        private final a g;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f1566a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f1567b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f1568c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f1569d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Interpolator f1570e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f1571f;
            private int g;

            /* JADX INFO: Access modifiers changed from: private */
            public void a(RecyclerView recyclerView) {
                if (this.f1569d >= 0) {
                    int i = this.f1569d;
                    this.f1569d = -1;
                    recyclerView.e(i);
                    this.f1571f = false;
                    return;
                }
                if (!this.f1571f) {
                    this.g = 0;
                    return;
                }
                b();
                if (this.f1570e != null) {
                    recyclerView.ad.a(this.f1566a, this.f1567b, this.f1568c, this.f1570e);
                } else if (this.f1568c == Integer.MIN_VALUE) {
                    recyclerView.ad.b(this.f1566a, this.f1567b);
                } else {
                    recyclerView.ad.a(this.f1566a, this.f1567b, this.f1568c);
                }
                this.g++;
                if (this.g > 10) {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                this.f1571f = false;
            }

            private void b() {
                if (this.f1570e != null && this.f1568c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f1568c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f1569d >= 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2) {
            RecyclerView recyclerView = this.f1561b;
            if (!this.f1564e || this.f1560a == -1 || recyclerView == null) {
                a();
            }
            this.f1563d = false;
            if (this.f1565f != null) {
                if (a(this.f1565f) == this.f1560a) {
                    a(this.f1565f, recyclerView.h, this.g);
                    this.g.a(recyclerView);
                    a();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f1565f = null;
                }
            }
            if (this.f1564e) {
                a(i, i2, recyclerView.h, this.g);
                boolean zA = this.g.a();
                this.g.a(recyclerView);
                if (zA) {
                    if (!this.f1564e) {
                        a();
                    } else {
                        this.f1563d = true;
                        recyclerView.ad.a();
                    }
                }
            }
        }

        public int a(View view) {
            return this.f1561b.d(view);
        }

        protected final void a() {
            if (this.f1564e) {
                e();
                this.f1561b.h.f1573b = -1;
                this.f1565f = null;
                this.f1560a = -1;
                this.f1563d = false;
                this.f1564e = false;
                this.f1562c.a(this);
                this.f1562c = null;
                this.f1561b = null;
            }
        }

        public void a(int i) {
            this.f1560a = i;
        }

        protected abstract void a(int i, int i2, r rVar, a aVar);

        protected abstract void a(View view, r rVar, a aVar);

        protected void b(View view) {
            if (a(view) == d()) {
                this.f1565f = view;
            }
        }

        public boolean b() {
            return this.f1563d;
        }

        public boolean c() {
            return this.f1564e;
        }

        public int d() {
            return this.f1560a;
        }

        protected abstract void e();
    }

    public static class r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private SparseArray<Object> f1575d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1573b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1574c = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1572a = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1576e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1577f = 0;
        private boolean g = false;
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private boolean k = false;
        private boolean l = false;

        static /* synthetic */ int a(r rVar, int i) {
            int i2 = rVar.f1577f + i;
            rVar.f1577f = i2;
            return i2;
        }

        void a(int i) {
            if ((this.f1574c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f1574c));
            }
        }

        public boolean a() {
            return this.h;
        }

        public boolean b() {
            return this.j;
        }

        public int c() {
            return this.f1573b;
        }

        public boolean d() {
            return this.f1573b != -1;
        }

        public int e() {
            return this.h ? this.f1576e - this.f1577f : this.f1572a;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1573b + ", mData=" + this.f1575d + ", mItemCount=" + this.f1572a + ", mPreviousLayoutItemCount=" + this.f1576e + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1577f + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.i + ", mRunPredictiveAnimations=" + this.j + '}';
        }
    }

    public static abstract class s {
        public abstract View a(n nVar, int i, int i2);
    }

    private class t implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private android.support.v4.widget.w f1581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Interpolator f1582e = RecyclerView.aq;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1583f = false;
        private boolean g = false;

        public t() {
            this.f1581d = android.support.v4.widget.w.a(RecyclerView.this.getContext(), RecyclerView.aq);
        }

        private float a(float f2) {
            return (float) Math.sin((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d));
        }

        private int b(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i5 = width / 2;
            float fA = (a(Math.min(1.0f, (iSqrt2 * 1.0f) / width)) * i5) + i5;
            if (iSqrt > 0) {
                iRound = Math.round(1000.0f * Math.abs(fA / iSqrt)) * 4;
            } else {
                iRound = (int) ((((z ? iAbs : iAbs2) / width) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
        }

        private void c() {
            this.g = false;
            this.f1583f = true;
        }

        private void d() {
            this.f1583f = false;
            if (this.g) {
                a();
            }
        }

        void a() {
            if (this.f1583f) {
                this.g = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                android.support.v4.view.ah.a(RecyclerView.this, this);
            }
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f1580c = 0;
            this.f1579b = 0;
            this.f1581d.a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, RecyclerView.aq);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f1582e != interpolator) {
                this.f1582e = interpolator;
                this.f1581d = android.support.v4.widget.w.a(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f1580c = 0;
            this.f1579b = 0;
            this.f1581d.a(0, 0, i, i2, i3);
            a();
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f1581d.h();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        /* JADX WARN: Code duplicated, block: B:90:0x0185 A[PHI: r0 r1 r2 r3
          0x0185: PHI (r0v12 int) = (r0v11 int), (r0v34 int), (r0v34 int), (r0v34 int), (r0v34 int) binds: [B:9:0x003e, B:16:0x008a, B:18:0x0090, B:20:0x0096, B:89:0x017e] A[DONT_GENERATE, DONT_INLINE]
          0x0185: PHI (r1v2 int) = (r1v1 int), (r1v11 int), (r1v11 int), (r1v11 int), (r1v11 int) binds: [B:9:0x003e, B:16:0x008a, B:18:0x0090, B:20:0x0096, B:89:0x017e] A[DONT_GENERATE, DONT_INLINE]
          0x0185: PHI (r2v1 int) = (r2v0 int), (r2v4 int), (r2v4 int), (r2v4 int), (r2v4 int) binds: [B:9:0x003e, B:16:0x008a, B:18:0x0090, B:20:0x0096, B:89:0x017e] A[DONT_GENERATE, DONT_INLINE]
          0x0185: PHI (r3v1 int) = (r3v0 int), (r3v3 int), (r3v3 int), (r3v3 int), (r3v3 int) binds: [B:9:0x003e, B:16:0x008a, B:18:0x0090, B:20:0x0096, B:89:0x017e] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            if (RecyclerView.this.f1516f == null) {
                b();
                return;
            }
            c();
            RecyclerView.this.t();
            android.support.v4.widget.w wVar = this.f1581d;
            q qVar = RecyclerView.this.f1516f.r;
            if (wVar.g()) {
                int iB = wVar.b();
                int iC = wVar.c();
                int i5 = iB - this.f1579b;
                int i6 = iC - this.f1580c;
                int iA = 0;
                int iB2 = 0;
                this.f1579b = iB;
                this.f1580c = iC;
                int i7 = 0;
                int i8 = 0;
                if (RecyclerView.this.s != null) {
                    RecyclerView.this.b();
                    RecyclerView.this.z();
                    android.support.v4.f.h.a("RV Scroll");
                    if (i5 != 0) {
                        iA = RecyclerView.this.f1516f.a(i5, RecyclerView.this.f1512b, RecyclerView.this.h);
                        i7 = i5 - iA;
                    }
                    if (i6 != 0) {
                        iB2 = RecyclerView.this.f1516f.b(i6, RecyclerView.this.f1512b, RecyclerView.this.h);
                        i8 = i6 - iB2;
                    }
                    android.support.v4.f.h.a();
                    RecyclerView.this.J();
                    RecyclerView.this.A();
                    RecyclerView.this.a(false);
                    if (qVar == null || qVar.b() || !qVar.c()) {
                        int i9 = i7;
                        i = iB2;
                        i2 = i9;
                    } else {
                        int iE = RecyclerView.this.h.e();
                        if (iE == 0) {
                            qVar.a();
                            int i10 = i7;
                            i = iB2;
                            i2 = i10;
                        } else if (qVar.d() >= iE) {
                            qVar.a(iE - 1);
                            qVar.a(i5 - i7, i6 - i8);
                            int i11 = i7;
                            i = iB2;
                            i2 = i11;
                        } else {
                            qVar.a(i5 - i7, i6 - i8);
                            int i12 = i7;
                            i = iB2;
                            i2 = i12;
                        }
                    }
                } else {
                    int i13 = i7;
                    i = iB2;
                    i2 = i13;
                }
                if (!RecyclerView.this.u.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (android.support.v4.view.ah.a(RecyclerView.this) != 2) {
                    RecyclerView.this.i(i5, i6);
                }
                if (i2 != 0 || i8 != 0) {
                    int iF = (int) wVar.f();
                    if (i2 != iB) {
                        if (i2 < 0) {
                            i4 = -iF;
                        } else {
                            i4 = i2 > 0 ? iF : 0;
                        }
                        i3 = i4;
                    } else {
                        i3 = 0;
                    }
                    if (i8 == iC) {
                        iF = 0;
                    } else if (i8 < 0) {
                        iF = -iF;
                    } else if (i8 <= 0) {
                        iF = 0;
                    }
                    if (android.support.v4.view.ah.a(RecyclerView.this) != 2) {
                        RecyclerView.this.c(i3, iF);
                    }
                    if ((i3 != 0 || i2 == iB || wVar.d() == 0) && (iF != 0 || i8 == iC || wVar.e() == 0)) {
                        wVar.h();
                    }
                }
                if (iA != 0 || i != 0) {
                    RecyclerView.this.h(iA, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i5 == 0 && i6 == 0) || (i5 != 0 && RecyclerView.this.f1516f.d() && iA == i5) || (i6 != 0 && RecyclerView.this.f1516f.e() && i == i6);
                if (wVar.a() || !z) {
                    RecyclerView.this.setScrollState(0);
                } else {
                    a();
                }
            }
            if (qVar != null) {
                if (qVar.b()) {
                    qVar.a(0, 0);
                }
                if (!this.g) {
                    qVar.a();
                }
            }
            d();
        }
    }

    public static abstract class u {
        private static final List<Object> m = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f1584a;
        RecyclerView k;
        private int l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1585b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1586c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f1587d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1588e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1589f = -1;
        u g = null;
        u h = null;
        List<Object> i = null;
        List<Object> j = null;
        private int n = 0;
        private n o = null;
        private boolean p = false;
        private int q = 0;

        public u(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f1584a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A() {
            android.support.v4.view.ah.c(this.f1584a, this.q);
            this.q = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean B() {
            return (this.l & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean C() {
            return (this.l & 16) == 0 && android.support.v4.view.ah.c(this.f1584a);
        }

        private void y() {
            if (this.i == null) {
                this.i = new ArrayList();
                this.j = Collections.unmodifiableList(this.i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z() {
            this.q = android.support.v4.view.ah.e(this.f1584a);
            android.support.v4.view.ah.c(this.f1584a, 4);
        }

        void a() {
            this.f1586c = -1;
            this.f1589f = -1;
        }

        void a(int i, int i2) {
            this.l = (this.l & (i2 ^ (-1))) | (i & i2);
        }

        void a(int i, int i2, boolean z) {
            b(8);
            a(i2, z);
            this.f1585b = i;
        }

        void a(int i, boolean z) {
            if (this.f1586c == -1) {
                this.f1586c = this.f1585b;
            }
            if (this.f1589f == -1) {
                this.f1589f = this.f1585b;
            }
            if (z) {
                this.f1589f += i;
            }
            this.f1585b += i;
            if (this.f1584a.getLayoutParams() != null) {
                ((i) this.f1584a.getLayoutParams()).f1548c = true;
            }
        }

        void a(n nVar, boolean z) {
            this.o = nVar;
            this.p = z;
        }

        void a(Object obj) {
            if (obj == null) {
                b(Place.TYPE_SUBLOCALITY_LEVEL_2);
            } else if ((this.l & Place.TYPE_SUBLOCALITY_LEVEL_2) == 0) {
                y();
                this.i.add(obj);
            }
        }

        public final void a(boolean z) {
            this.n = z ? this.n - 1 : this.n + 1;
            if (this.n < 0) {
                this.n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.n == 1) {
                this.l |= 16;
            } else if (z && this.n == 0) {
                this.l &= -17;
            }
        }

        boolean a(int i) {
            return (this.l & i) != 0;
        }

        void b() {
            if (this.f1586c == -1) {
                this.f1586c = this.f1585b;
            }
        }

        void b(int i) {
            this.l |= i;
        }

        boolean c() {
            return (this.l & 128) != 0;
        }

        public final int d() {
            return this.f1589f == -1 ? this.f1585b : this.f1589f;
        }

        public final int e() {
            if (this.k == null) {
                return -1;
            }
            return this.k.d(this);
        }

        public final int f() {
            return this.f1586c;
        }

        public final long g() {
            return this.f1587d;
        }

        public final int h() {
            return this.f1588e;
        }

        boolean i() {
            return this.o != null;
        }

        void j() {
            this.o.d(this);
        }

        boolean k() {
            return (this.l & 32) != 0;
        }

        void l() {
            this.l &= -33;
        }

        void m() {
            this.l &= -257;
        }

        boolean n() {
            return (this.l & 4) != 0;
        }

        boolean o() {
            return (this.l & 2) != 0;
        }

        boolean p() {
            return (this.l & 1) != 0;
        }

        boolean q() {
            return (this.l & 8) != 0;
        }

        boolean r() {
            return (this.l & 256) != 0;
        }

        boolean s() {
            return (this.l & 512) != 0 || n();
        }

        void t() {
            if (this.i != null) {
                this.i.clear();
            }
            this.l &= -1025;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f1585b + " id=" + this.f1587d + ", oldPos=" + this.f1586c + ", pLpos:" + this.f1589f);
            if (i()) {
                sb.append(" scrap ").append(this.p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                sb.append(" invalid");
            }
            if (!p()) {
                sb.append(" unbound");
            }
            if (o()) {
                sb.append(" update");
            }
            if (q()) {
                sb.append(" removed");
            }
            if (c()) {
                sb.append(" ignored");
            }
            if (r()) {
                sb.append(" tmpDetached");
            }
            if (!w()) {
                sb.append(" not recyclable(" + this.n + ")");
            }
            if (s()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1584a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        List<Object> u() {
            if ((this.l & Place.TYPE_SUBLOCALITY_LEVEL_2) == 0) {
                return (this.i == null || this.i.size() == 0) ? m : this.j;
            }
            return m;
        }

        void v() {
            this.l = 0;
            this.f1585b = -1;
            this.f1586c = -1;
            this.f1587d = -1L;
            this.f1589f = -1;
            this.n = 0;
            this.g = null;
            this.h = null;
            t();
            this.q = 0;
        }

        public final boolean w() {
            return (this.l & 16) == 0 && !android.support.v4.view.ah.c(this.f1584a);
        }

        boolean x() {
            return (this.l & 2) != 0;
        }
    }

    static {
        l = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        f1511a = Build.VERSION.SDK_INT >= 23;
        m = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        aq = new Interpolator() { // from class: android.support.v7.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i2) throws NoSuchMethodException {
        super(context, attributeSet, i2);
        boolean z = true;
        this.n = new p();
        this.f1512b = new n();
        this.f1515e = new as();
        this.q = new Runnable() { // from class: android.support.v7.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.z || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (RecyclerView.this.C) {
                    RecyclerView.this.B = true;
                } else {
                    RecyclerView.this.t();
                }
            }
        };
        this.r = new Rect();
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
        this.A = 0;
        this.J = false;
        this.K = 0;
        this.g = new v();
        this.P = 0;
        this.Q = -1;
        this.ac = Float.MIN_VALUE;
        this.ad = new t();
        this.h = new r();
        this.i = false;
        this.j = false;
        this.ag = new f();
        this.ah = false;
        this.ak = new int[2];
        this.am = new int[2];
        this.an = new int[2];
        this.ao = new int[2];
        this.ap = new Runnable() { // from class: android.support.v7.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.g != null) {
                    RecyclerView.this.g.a();
                }
                RecyclerView.this.ah = false;
            }
        };
        this.ar = new as.b() { // from class: android.support.v7.widget.RecyclerView.4
            @Override // android.support.v7.widget.as.b
            public void a(u uVar) {
                RecyclerView.this.f1516f.a(uVar.f1584a, RecyclerView.this.f1512b);
            }

            @Override // android.support.v7.widget.as.b
            public void a(u uVar, e.c cVar, e.c cVar2) {
                RecyclerView.this.f1512b.d(uVar);
                RecyclerView.this.b(uVar, cVar, cVar2);
            }

            @Override // android.support.v7.widget.as.b
            public void b(u uVar, e.c cVar, e.c cVar2) {
                RecyclerView.this.a(uVar, cVar, cVar2);
            }

            @Override // android.support.v7.widget.as.b
            public void c(u uVar, e.c cVar, e.c cVar2) {
                uVar.a(false);
                if (RecyclerView.this.J) {
                    if (RecyclerView.this.g.a(uVar, uVar, cVar, cVar2)) {
                        RecyclerView.this.C();
                    }
                } else if (RecyclerView.this.g.c(uVar, cVar, cVar2)) {
                    RecyclerView.this.C();
                }
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.G = Build.VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.W = viewConfiguration.getScaledTouchSlop();
        this.aa = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ab = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(android.support.v4.view.ah.a(this) == 2);
        this.g.a(this.ag);
        a();
        s();
        if (android.support.v4.view.ah.e(this) == 0) {
            android.support.v4.view.ah.c((View) this, 1);
        }
        this.H = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ab(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.e.a.C0031a.RecyclerView, i2, 0);
            String string = typedArrayObtainStyledAttributes.getString(android.support.v7.e.a.C0031a.RecyclerView_layoutManager);
            typedArrayObtainStyledAttributes.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, k, i2, 0);
                z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
                typedArrayObtainStyledAttributes2.recycle();
            }
        }
        setNestedScrollingEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.K--;
        if (this.K < 1) {
            this.K = 0;
            B();
        }
    }

    private void B() {
        int i2 = this.E;
        this.E = 0;
        if (i2 == 0 || !i()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        android.support.v4.view.a.a.a(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.ah || !this.x) {
            return;
        }
        android.support.v4.view.ah.a(this, this.ap);
        this.ah = true;
    }

    private boolean D() {
        return this.g != null && this.f1516f.b();
    }

    private void E() {
        if (this.J) {
            this.f1513c.a();
            o();
            this.f1516f.a(this);
        }
        if (D()) {
            this.f1513c.b();
        } else {
            this.f1513c.e();
        }
        boolean z = this.i || this.j;
        this.h.i = this.z && this.g != null && (this.J || z || this.f1516f.f1536a) && (!this.J || this.s.d());
        this.h.j = this.h.i && z && !this.J && D();
    }

    private void F() {
        this.h.a(1);
        this.h.l = false;
        b();
        this.f1515e.a();
        z();
        E();
        this.h.k = this.h.i && this.j;
        this.j = false;
        this.i = false;
        this.h.h = this.h.j;
        this.h.f1572a = this.s.a();
        a(this.ak);
        if (this.h.i) {
            int iB = this.f1514d.b();
            for (int i2 = 0; i2 < iB; i2++) {
                u uVarC = c(this.f1514d.b(i2));
                if (!uVarC.c() && (!uVarC.n() || this.s.d())) {
                    this.f1515e.a(uVarC, this.g.a(this.h, uVarC, e.d(uVarC), uVarC.u()));
                    if (this.h.k && uVarC.x() && !uVarC.q() && !uVarC.c() && !uVarC.n()) {
                        this.f1515e.a(a(uVarC), uVarC);
                    }
                }
            }
        }
        if (this.h.j) {
            m();
            boolean z = this.h.g;
            this.h.g = false;
            this.f1516f.c(this.f1512b, this.h);
            this.h.g = z;
            for (int i3 = 0; i3 < this.f1514d.b(); i3++) {
                u uVarC2 = c(this.f1514d.b(i3));
                if (!uVarC2.c() && !this.f1515e.d(uVarC2)) {
                    int iD = e.d(uVarC2);
                    boolean zA = uVarC2.a(8192);
                    if (!zA) {
                        iD |= 4096;
                    }
                    e.c cVarA = this.g.a(this.h, uVarC2, iD, uVarC2.u());
                    if (zA) {
                        a(uVarC2, cVarA);
                    } else {
                        this.f1515e.b(uVarC2, cVarA);
                    }
                }
            }
            n();
        } else {
            n();
        }
        A();
        a(false);
        this.h.f1574c = 2;
    }

    private void G() {
        b();
        z();
        this.h.a(6);
        this.f1513c.e();
        this.h.f1572a = this.s.a();
        this.h.f1577f = 0;
        this.h.h = false;
        this.f1516f.c(this.f1512b, this.h);
        this.h.g = false;
        this.o = null;
        this.h.i = this.h.i && this.g != null;
        this.h.f1574c = 4;
        A();
        a(false);
    }

    private void H() {
        this.h.a(4);
        b();
        z();
        this.h.f1574c = 1;
        if (this.h.i) {
            for (int iB = this.f1514d.b() - 1; iB >= 0; iB--) {
                u uVarC = c(this.f1514d.b(iB));
                if (!uVarC.c()) {
                    long jA = a(uVarC);
                    e.c cVarA = this.g.a(this.h, uVarC);
                    u uVarA = this.f1515e.a(jA);
                    if (uVarA == null || uVarA.c()) {
                        this.f1515e.c(uVarC, cVarA);
                    } else {
                        boolean zA = this.f1515e.a(uVarA);
                        boolean zA2 = this.f1515e.a(uVarC);
                        if (zA && uVarA == uVarC) {
                            this.f1515e.c(uVarC, cVarA);
                        } else {
                            e.c cVarB = this.f1515e.b(uVarA);
                            this.f1515e.c(uVarC, cVarA);
                            e.c cVarC = this.f1515e.c(uVarC);
                            if (cVarB == null) {
                                a(jA, uVarC, uVarA);
                            } else {
                                a(uVarA, uVarC, cVarB, cVarC, zA, zA2);
                            }
                        }
                    }
                }
            }
            this.f1515e.a(this.ar);
        }
        this.f1516f.b(this.f1512b);
        this.h.f1576e = this.h.f1572a;
        this.J = false;
        this.h.i = false;
        this.h.j = false;
        this.f1516f.f1536a = false;
        if (this.f1512b.f1556d != null) {
            this.f1512b.f1556d.clear();
        }
        A();
        a(false);
        this.f1515e.a();
        if (j(this.ak[0], this.ak[1])) {
            h(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.J) {
            return;
        }
        this.J = true;
        int iC = this.f1514d.c();
        for (int i2 = 0; i2 < iC; i2++) {
            u uVarC = c(this.f1514d.c(i2));
            if (uVarC != null && !uVarC.c()) {
                uVarC.b(512);
            }
        }
        this.f1512b.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        int iB = this.f1514d.b();
        for (int i2 = 0; i2 < iB; i2++) {
            View viewB = this.f1514d.b(i2);
            u uVarA = a(viewB);
            if (uVarA != null && uVarA.h != null) {
                View view = uVarA.h.f1584a;
                int left = viewB.getLeft();
                int top = viewB.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008e  */
    private void a(float f2, float f3, float f4, float f5) {
        boolean z = true;
        boolean z2 = false;
        if (f3 < BitmapDescriptorFactory.HUE_RED) {
            d();
            if (this.L.a((-f3) / getWidth(), 1.0f - (f4 / getHeight()))) {
                z2 = true;
            }
        } else if (f3 > BitmapDescriptorFactory.HUE_RED) {
            e();
            if (this.N.a(f3 / getWidth(), f4 / getHeight())) {
                z2 = true;
            }
        }
        if (f5 < BitmapDescriptorFactory.HUE_RED) {
            f();
            if (!this.M.a((-f5) / getHeight(), f2 / getWidth())) {
                z = z2;
            }
        } else if (f5 > BitmapDescriptorFactory.HUE_RED) {
            g();
            if (!this.O.a(f5 / getHeight(), 1.0f - (f2 / getWidth()))) {
                z = z2;
            }
        } else {
            z = z2;
        }
        if (!z && f3 == BitmapDescriptorFactory.HUE_RED && f5 == BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        android.support.v4.view.ah.d(this);
    }

    private void a(long j2, u uVar, u uVar2) {
        int iB = this.f1514d.b();
        for (int i2 = 0; i2 < iB; i2++) {
            u uVarC = c(this.f1514d.b(i2));
            if (uVarC != uVar && a(uVarC) == j2) {
                if (this.s != null && this.s.d()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + uVarC + " \n View Holder 2:" + uVar);
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + uVarC + " \n View Holder 2:" + uVar);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + uVar2 + " cannot be found but it is necessary for " + uVar);
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) throws NoSuchMethodException {
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.length() != 0) {
                String strA = a(context, strTrim);
                try {
                    Class<? extends U> clsAsSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(strA).asSubclass(h.class);
                    try {
                        Constructor constructor2 = clsAsSubclass.getConstructor(m);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                        constructor = constructor2;
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = clsAsSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strA, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((h) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strA, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strA, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strA, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strA, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strA, e8);
                }
            }
        }
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (this.s != null) {
            this.s.b(this.n);
            this.s.b(this);
        }
        if (!z || z2) {
            if (this.g != null) {
                this.g.c();
            }
            if (this.f1516f != null) {
                this.f1516f.c(this.f1512b);
                this.f1516f.b(this.f1512b);
            }
            this.f1512b.a();
        }
        this.f1513c.a();
        a aVar2 = this.s;
        this.s = aVar;
        if (aVar != null) {
            aVar.a(this.n);
            aVar.a(this);
        }
        if (this.f1516f != null) {
            this.f1516f.a(aVar2, this.s);
        }
        this.f1512b.a(aVar2, this.s, z);
        this.h.g = true;
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar, e.c cVar) {
        uVar.a(0, 8192);
        if (this.h.k && uVar.x() && !uVar.q() && !uVar.c()) {
            this.f1515e.a(a(uVar), uVar);
        }
        this.f1515e.a(uVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar, e.c cVar, e.c cVar2) {
        uVar.a(false);
        if (this.g.b(uVar, cVar, cVar2)) {
            C();
        }
    }

    private void a(u uVar, u uVar2, e.c cVar, e.c cVar2, boolean z, boolean z2) {
        uVar.a(false);
        if (z) {
            b(uVar);
        }
        if (uVar != uVar2) {
            if (z2) {
                b(uVar2);
            }
            uVar.g = uVar2;
            b(uVar);
            this.f1512b.d(uVar);
            uVar2.a(false);
            uVar2.h = uVar;
        }
        if (this.g.a(uVar, uVar2, cVar, cVar2)) {
            C();
        }
    }

    private void a(int[] iArr) {
        int iB = this.f1514d.b();
        if (iB == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = 0;
        while (i4 < iB) {
            u uVarC = c(this.f1514d.b(i4));
            if (!uVarC.c()) {
                int iD = uVarC.d();
                if (iD < i2) {
                    i2 = iD;
                }
                if (iD > i3) {
                    i3 = iD;
                }
            }
            i4++;
            i2 = i2;
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.w = null;
        }
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.v.get(i2);
            if (kVar.a(this, motionEvent) && action != 3) {
                this.w = kVar;
                return true;
            }
        }
        return false;
    }

    private void b(u uVar) {
        View view = uVar.f1584a;
        boolean z = view.getParent() == this;
        this.f1512b.d(a(view));
        if (uVar.r()) {
            this.f1514d.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f1514d.d(view);
        } else {
            this.f1514d.a(view, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar, e.c cVar, e.c cVar2) {
        b(uVar);
        uVar.a(false);
        if (this.g.a(uVar, cVar, cVar2)) {
            C();
        }
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.w != null) {
            if (action != 0) {
                this.w.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.w = null;
                }
                return true;
            }
            this.w = null;
        }
        if (action != 0) {
            int size = this.v.size();
            for (int i2 = 0; i2 < size; i2++) {
                k kVar = this.v.get(i2);
                if (kVar.a(this, motionEvent)) {
                    this.w = kVar;
                    return true;
                }
            }
        }
        return false;
    }

    static u c(View view) {
        if (view == null) {
            return null;
        }
        return ((i) view.getLayoutParams()).f1546a;
    }

    private void c(MotionEvent motionEvent) {
        int iB = android.support.v4.view.t.b(motionEvent);
        if (android.support.v4.view.t.b(motionEvent, iB) == this.Q) {
            int i2 = iB == 0 ? 1 : 0;
            this.Q = android.support.v4.view.t.b(motionEvent, i2);
            int iC = (int) (android.support.v4.view.t.c(motionEvent, i2) + 0.5f);
            this.U = iC;
            this.S = iC;
            int iD = (int) (android.support.v4.view.t.d(motionEvent, i2) + 0.5f);
            this.V = iD;
            this.T = iD;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(u uVar) {
        return this.g == null || this.g.a(uVar, uVar.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(u uVar) {
        if (uVar.a(524) || !uVar.p()) {
            return -1;
        }
        return this.f1513c.c(uVar.f1585b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        if (this.f1516f == null) {
            return;
        }
        this.f1516f.d(i2);
        awakenScrollBars();
    }

    private float getScrollFactor() {
        if (this.ac == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            this.ac = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.ac;
    }

    private android.support.v4.view.y getScrollingChildHelper() {
        if (this.al == null) {
            this.al = new android.support.v4.view.y(this);
        }
        return this.al;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(View view) {
        b();
        boolean zF = this.f1514d.f(view);
        if (zF) {
            u uVarC = c(view);
            this.f1512b.d(uVarC);
            this.f1512b.b(uVarC);
        }
        a(!zF);
        return zF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i2, int i3) {
        boolean zC = false;
        if (this.L != null && !this.L.a() && i2 > 0) {
            zC = this.L.c();
        }
        if (this.N != null && !this.N.a() && i2 < 0) {
            zC |= this.N.c();
        }
        if (this.M != null && !this.M.a() && i3 > 0) {
            zC |= this.M.c();
        }
        if (this.O != null && !this.O.a() && i3 < 0) {
            zC |= this.O.c();
        }
        if (zC) {
            android.support.v4.view.ah.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(View view) {
        u uVarC = c(view);
        f(view);
        if (this.s != null && uVarC != null) {
            this.s.d(uVarC);
        }
        if (this.I != null) {
            for (int size = this.I.size() - 1; size >= 0; size--) {
                this.I.get(size).b(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view) {
        u uVarC = c(view);
        e(view);
        if (this.s != null && uVarC != null) {
            this.s.c(uVarC);
        }
        if (this.I != null) {
            for (int size = this.I.size() - 1; size >= 0; size--) {
                this.I.get(size).a(view);
            }
        }
    }

    private boolean j(int i2, int i3) {
        if (this.f1514d.b() == 0) {
            return (i2 == 0 && i3 == 0) ? false : true;
        }
        a(this.ak);
        return (this.ak[0] == i2 && this.ak[1] == i3) ? false : true;
    }

    private void s() {
        this.f1514d = new android.support.v7.widget.s(new android.support.v7.widget.s.b() { // from class: android.support.v7.widget.RecyclerView.5
            @Override // android.support.v7.widget.s.b
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            @Override // android.support.v7.widget.s.b
            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // android.support.v7.widget.s.b
            public void a(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.i(childAt);
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // android.support.v7.widget.s.b
            public void a(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.j(view);
            }

            @Override // android.support.v7.widget.s.b
            public void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                u uVarC = RecyclerView.c(view);
                if (uVarC != null) {
                    if (!uVarC.r() && !uVarC.c()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + uVarC);
                    }
                    uVarC.m();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // android.support.v7.widget.s.b
            public u b(View view) {
                return RecyclerView.c(view);
            }

            @Override // android.support.v7.widget.s.b
            public View b(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // android.support.v7.widget.s.b
            public void b() {
                int iA = a();
                for (int i2 = 0; i2 < iA; i2++) {
                    RecyclerView.this.i(b(i2));
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // android.support.v7.widget.s.b
            public void c(int i2) {
                u uVarC;
                View viewB = b(i2);
                if (viewB != null && (uVarC = RecyclerView.c(viewB)) != null) {
                    if (uVarC.r() && !uVarC.c()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + uVarC);
                    }
                    uVarC.b(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // android.support.v7.widget.s.b
            public void c(View view) {
                u uVarC = RecyclerView.c(view);
                if (uVarC != null) {
                    uVarC.z();
                }
            }

            @Override // android.support.v7.widget.s.b
            public void d(View view) {
                u uVarC = RecyclerView.c(view);
                if (uVarC != null) {
                    uVarC.A();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i2) {
        if (i2 == this.P) {
            return;
        }
        this.P = i2;
        if (i2 != 2) {
            v();
        }
        d(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.z) {
            if (this.J) {
                android.support.v4.f.h.a("RV FullInvalidate");
                k();
                android.support.v4.f.h.a();
                return;
            }
            if (this.f1513c.d()) {
                if (!this.f1513c.a(4) || this.f1513c.a(11)) {
                    if (this.f1513c.d()) {
                        android.support.v4.f.h.a("RV FullInvalidate");
                        k();
                        android.support.v4.f.h.a();
                        return;
                    }
                    return;
                }
                android.support.v4.f.h.a("RV PartialInvalidate");
                b();
                this.f1513c.b();
                if (!this.B) {
                    if (u()) {
                        k();
                    } else {
                        this.f1513c.c();
                    }
                }
                a(true);
                android.support.v4.f.h.a();
            }
        }
    }

    private boolean u() {
        int iB = this.f1514d.b();
        for (int i2 = 0; i2 < iB; i2++) {
            u uVarC = c(this.f1514d.b(i2));
            if (uVarC != null && !uVarC.c() && uVarC.x()) {
                return true;
            }
        }
        return false;
    }

    private void v() {
        this.ad.b();
        if (this.f1516f != null) {
            this.f1516f.F();
        }
    }

    private void w() {
        boolean zC = this.L != null ? this.L.c() : false;
        if (this.M != null) {
            zC |= this.M.c();
        }
        if (this.N != null) {
            zC |= this.N.c();
        }
        if (this.O != null) {
            zC |= this.O.c();
        }
        if (zC) {
            android.support.v4.view.ah.d(this);
        }
    }

    private void x() {
        if (this.R != null) {
            this.R.clear();
        }
        stopNestedScroll();
        w();
    }

    private void y() {
        x();
        setScrollState(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.K++;
    }

    long a(u uVar) {
        return this.s.d() ? uVar.g() : uVar.f1585b;
    }

    u a(int i2, boolean z) {
        int iC = this.f1514d.c();
        for (int i3 = 0; i3 < iC; i3++) {
            u uVarC = c(this.f1514d.c(i3));
            if (uVarC != null && !uVarC.q()) {
                if (z) {
                    if (uVarC.f1585b == i2) {
                        return uVarC;
                    }
                } else if (uVarC.d() == i2) {
                    return uVarC;
                }
            }
        }
        return null;
    }

    public u a(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return c(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void a() {
        this.f1513c = new android.support.v7.widget.e(new android.support.v7.widget.e.a() { // from class: android.support.v7.widget.RecyclerView.6
            @Override // android.support.v7.widget.e.a
            public u a(int i2) {
                u uVarA = RecyclerView.this.a(i2, true);
                if (uVarA == null || RecyclerView.this.f1514d.c(uVarA.f1584a)) {
                    return null;
                }
                return uVarA;
            }

            @Override // android.support.v7.widget.e.a
            public void a(int i2, int i3) {
                RecyclerView.this.a(i2, i3, true);
                RecyclerView.this.i = true;
                r.a(RecyclerView.this.h, i3);
            }

            @Override // android.support.v7.widget.e.a
            public void a(int i2, int i3, Object obj) {
                RecyclerView.this.a(i2, i3, obj);
                RecyclerView.this.j = true;
            }

            @Override // android.support.v7.widget.e.a
            public void a(android.support.v7.widget.e.b bVar) {
                c(bVar);
            }

            @Override // android.support.v7.widget.e.a
            public void b(int i2, int i3) {
                RecyclerView.this.a(i2, i3, false);
                RecyclerView.this.i = true;
            }

            @Override // android.support.v7.widget.e.a
            public void b(android.support.v7.widget.e.b bVar) {
                c(bVar);
            }

            @Override // android.support.v7.widget.e.a
            public void c(int i2, int i3) {
                RecyclerView.this.f(i2, i3);
                RecyclerView.this.i = true;
            }

            void c(android.support.v7.widget.e.b bVar) {
                switch (bVar.f1789a) {
                    case 1:
                        RecyclerView.this.f1516f.a(RecyclerView.this, bVar.f1790b, bVar.f1792d);
                        break;
                    case 2:
                        RecyclerView.this.f1516f.b(RecyclerView.this, bVar.f1790b, bVar.f1792d);
                        break;
                    case 4:
                        RecyclerView.this.f1516f.a(RecyclerView.this, bVar.f1790b, bVar.f1792d, bVar.f1791c);
                        break;
                    case 8:
                        RecyclerView.this.f1516f.a(RecyclerView.this, bVar.f1790b, bVar.f1792d, 1);
                        break;
                }
            }

            @Override // android.support.v7.widget.e.a
            public void d(int i2, int i3) {
                RecyclerView.this.e(i2, i3);
                RecyclerView.this.i = true;
            }
        });
    }

    public void a(int i2) {
        int iB = this.f1514d.b();
        for (int i3 = 0; i3 < iB; i3++) {
            this.f1514d.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void a(int i2, int i3) {
        if (this.f1516f == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.C) {
            return;
        }
        if (!this.f1516f.d()) {
            i2 = 0;
        }
        int i4 = this.f1516f.e() ? i3 : 0;
        if (i2 == 0 && i4 == 0) {
            return;
        }
        this.ad.b(i2, i4);
    }

    void a(int i2, int i3, Object obj) {
        int iC = this.f1514d.c();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < iC; i5++) {
            View viewC = this.f1514d.c(i5);
            u uVarC = c(viewC);
            if (uVarC != null && !uVarC.c() && uVarC.f1585b >= i2 && uVarC.f1585b < i4) {
                uVarC.b(2);
                uVarC.a(obj);
                ((i) viewC.getLayoutParams()).f1548c = true;
            }
        }
        this.f1512b.c(i2, i3);
    }

    void a(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int iC = this.f1514d.c();
        for (int i5 = 0; i5 < iC; i5++) {
            u uVarC = c(this.f1514d.c(i5));
            if (uVarC != null && !uVarC.c()) {
                if (uVarC.f1585b >= i4) {
                    uVarC.a(-i3, z);
                    this.h.g = true;
                } else if (uVarC.f1585b >= i2) {
                    uVarC.a(i2 - 1, -i3, z);
                    this.h.g = true;
                }
            }
        }
        this.f1512b.b(i2, i3, z);
        requestLayout();
    }

    void a(String str) {
        if (j()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
    }

    void a(boolean z) {
        if (this.A < 1) {
            this.A = 1;
        }
        if (!z) {
            this.B = false;
        }
        if (this.A == 1) {
            if (z && this.B && !this.C && this.f1516f != null && this.s != null) {
                k();
            }
            if (!this.C) {
                this.B = false;
            }
        }
        this.A--;
    }

    boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iA;
        int iB;
        int i8;
        t();
        if (this.s != null) {
            b();
            z();
            android.support.v4.f.h.a("RV Scroll");
            if (i2 != 0) {
                iA = this.f1516f.a(i2, this.f1512b, this.h);
                i7 = i2 - iA;
            } else {
                iA = 0;
                i7 = 0;
            }
            if (i3 != 0) {
                iB = this.f1516f.b(i3, this.f1512b, this.h);
                i8 = i3 - iB;
            } else {
                iB = 0;
                i8 = 0;
            }
            android.support.v4.f.h.a();
            J();
            A();
            a(false);
            i6 = i8;
            i5 = iA;
            i4 = iB;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.u.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i5, i4, i7, i6, this.am)) {
            this.U -= this.am[0];
            this.V -= this.am[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(this.am[0], this.am[1]);
            }
            int[] iArr = this.ao;
            iArr[0] = iArr[0] + this.am[0];
            int[] iArr2 = this.ao;
            iArr2[1] = iArr2[1] + this.am[1];
        } else if (android.support.v4.view.ah.a(this) != 2) {
            if (motionEvent != null) {
                a(motionEvent.getX(), i7, motionEvent.getY(), i6);
            }
            i(i2, i3);
        }
        if (i5 != 0 || i4 != 0) {
            h(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i4 == 0) ? false : true;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (!j()) {
            return false;
        }
        int iB = accessibilityEvent != null ? android.support.v4.view.a.a.b(accessibilityEvent) : 0;
        this.E = (iB != 0 ? iB : 0) | this.E;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (this.f1516f == null || !this.f1516f.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public View b(View view) {
        Object parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = (View) parent;
            view2 = view3;
            parent = view3.getParent();
        }
        if (parent == this) {
            return view2;
        }
        return null;
    }

    void b() {
        this.A++;
        if (this.A != 1 || this.C) {
            return;
        }
        this.B = false;
    }

    public void b(int i2) {
        int iB = this.f1514d.b();
        for (int i3 = 0; i3 < iB; i3++) {
            this.f1514d.b(i3).offsetLeftAndRight(i2);
        }
    }

    public boolean b(int i2, int i3) {
        if (this.f1516f == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.C) {
            return false;
        }
        boolean zD = this.f1516f.d();
        boolean zE = this.f1516f.e();
        if (!zD || Math.abs(i2) < this.aa) {
            i2 = 0;
        }
        if (!zE || Math.abs(i3) < this.aa) {
            i3 = 0;
        }
        if ((i2 == 0 && i3 == 0) || dispatchNestedPreFling(i2, i3)) {
            return false;
        }
        boolean z = zD || zE;
        dispatchNestedFling(i2, i3, z);
        if (!z) {
            return false;
        }
        this.ad.a(Math.max(-this.ab, Math.min(i2, this.ab)), Math.max(-this.ab, Math.min(i3, this.ab)));
        return true;
    }

    public void c() {
        setScrollState(0);
        v();
    }

    public void c(int i2) {
    }

    void c(int i2, int i3) {
        if (i2 < 0) {
            d();
            this.L.a(-i2);
        } else if (i2 > 0) {
            e();
            this.N.a(i2);
        }
        if (i3 < 0) {
            f();
            this.M.a(-i3);
        } else if (i3 > 0) {
            g();
            this.O.a(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        android.support.v4.view.ah.d(this);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof i) && this.f1516f.a((i) layoutParams);
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeHorizontalScrollExtent() {
        if (this.f1516f != null && this.f1516f.d()) {
            return this.f1516f.d(this.h);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeHorizontalScrollOffset() {
        if (this.f1516f != null && this.f1516f.d()) {
            return this.f1516f.b(this.h);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeHorizontalScrollRange() {
        if (this.f1516f != null && this.f1516f.d()) {
            return this.f1516f.f(this.h);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeVerticalScrollExtent() {
        if (this.f1516f != null && this.f1516f.e()) {
            return this.f1516f.e(this.h);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeVerticalScrollOffset() {
        if (this.f1516f != null && this.f1516f.e()) {
            return this.f1516f.c(this.h);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeVerticalScrollRange() {
        if (this.f1516f != null && this.f1516f.e()) {
            return this.f1516f.g(this.h);
        }
        return 0;
    }

    public int d(View view) {
        u uVarC = c(view);
        if (uVarC != null) {
            return uVarC.d();
        }
        return -1;
    }

    void d() {
        if (this.L != null) {
            return;
        }
        this.L = new android.support.v4.widget.j(getContext());
        if (this.p) {
            this.L.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.L.a(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void d(int i2) {
        if (this.f1516f != null) {
            this.f1516f.k(i2);
        }
        c(i2);
        if (this.ae != null) {
            this.ae.a(this, i2);
        }
        if (this.af != null) {
            for (int size = this.af.size() - 1; size >= 0; size--) {
                this.af.get(size).a(this, i2);
            }
        }
    }

    void d(int i2, int i3) {
        setMeasuredDimension(h.a(i2, getPaddingLeft() + getPaddingRight(), android.support.v4.view.ah.q(this)), h.a(i3, getPaddingTop() + getPaddingBottom(), android.support.v4.view.ah.r(this)));
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2 = false;
        super.draw(canvas);
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.u.get(i2).b(canvas, this, this.h);
        }
        if (this.L == null || this.L.a()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.p ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate(paddingBottom + (-getHeight()), BitmapDescriptorFactory.HUE_RED);
            z = this.L != null && this.L.a(canvas);
            canvas.restoreToCount(iSave);
        }
        if (this.M != null && !this.M.a()) {
            int iSave2 = canvas.save();
            if (this.p) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            z |= this.M != null && this.M.a(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (this.N != null && !this.N.a()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.p ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            z |= this.N != null && this.N.a(canvas);
            canvas.restoreToCount(iSave3);
        }
        if (this.O != null && !this.O.a()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.p) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            if (this.O != null && this.O.a(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.g == null || this.u.size() <= 0 || !this.g.b()) ? z : true) {
            android.support.v4.view.ah.d(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    void e() {
        if (this.N != null) {
            return;
        }
        this.N = new android.support.v4.widget.j(getContext());
        if (this.p) {
            this.N.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.N.a(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void e(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int iC = this.f1514d.c();
        if (i2 < i3) {
            i4 = -1;
            i5 = i3;
            i6 = i2;
        } else {
            i4 = 1;
            i5 = i2;
            i6 = i3;
        }
        for (int i7 = 0; i7 < iC; i7++) {
            u uVarC = c(this.f1514d.c(i7));
            if (uVarC != null && uVarC.f1585b >= i6 && uVarC.f1585b <= i5) {
                if (uVarC.f1585b == i2) {
                    uVarC.a(i3 - i2, false);
                } else {
                    uVarC.a(i4, false);
                }
                this.h.g = true;
            }
        }
        this.f1512b.a(i2, i3);
        requestLayout();
    }

    public void e(View view) {
    }

    void f() {
        if (this.M != null) {
            return;
        }
        this.M = new android.support.v4.widget.j(getContext());
        if (this.p) {
            this.M.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.M.a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void f(int i2, int i3) {
        int iC = this.f1514d.c();
        for (int i4 = 0; i4 < iC; i4++) {
            u uVarC = c(this.f1514d.c(i4));
            if (uVarC != null && !uVarC.c() && uVarC.f1585b >= i2) {
                uVarC.a(i3, false);
                this.h.g = true;
            }
        }
        this.f1512b.b(i2, i3);
        requestLayout();
    }

    public void f(View view) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewD = this.f1516f.d(view, i2);
        if (viewD != null) {
            return viewD;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (viewFindNextFocus == null && this.s != null && this.f1516f != null && !j() && !this.C) {
            b();
            viewFindNextFocus = this.f1516f.a(view, i2, this.f1512b, this.h);
            a(false);
        }
        return viewFindNextFocus == null ? super.focusSearch(view, i2) : viewFindNextFocus;
    }

    Rect g(View view) {
        i iVar = (i) view.getLayoutParams();
        if (!iVar.f1548c) {
            return iVar.f1547b;
        }
        Rect rect = iVar.f1547b;
        rect.set(0, 0, 0, 0);
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.r.set(0, 0, 0, 0);
            this.u.get(i2).a(this.r, view, this, this.h);
            rect.left += this.r.left;
            rect.top += this.r.top;
            rect.right += this.r.right;
            rect.bottom += this.r.bottom;
        }
        iVar.f1548c = false;
        return rect;
    }

    void g() {
        if (this.O != null) {
            return;
        }
        this.O = new android.support.v4.widget.j(getContext());
        if (this.p) {
            this.O.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.O.a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void g(int i2, int i3) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.f1516f == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.f1516f.a();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f1516f == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.f1516f.a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f1516f == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.f1516f.a(layoutParams);
    }

    public a getAdapter() {
        return this.s;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f1516f != null ? this.f1516f.s() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        return this.aj == null ? super.getChildDrawingOrder(i2, i3) : this.aj.a(i2, i3);
    }

    public ab getCompatAccessibilityDelegate() {
        return this.ai;
    }

    public e getItemAnimator() {
        return this.g;
    }

    public h getLayoutManager() {
        return this.f1516f;
    }

    public int getMaxFlingVelocity() {
        return this.ab;
    }

    public int getMinFlingVelocity() {
        return this.aa;
    }

    public m getRecycledViewPool() {
        return this.f1512b.f();
    }

    public int getScrollState() {
        return this.P;
    }

    void h() {
        this.O = null;
        this.M = null;
        this.N = null;
        this.L = null;
    }

    void h(int i2, int i3) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        g(i2, i3);
        if (this.ae != null) {
            this.ae.a(this, i2, i3);
        }
        if (this.af != null) {
            for (int size = this.af.size() - 1; size >= 0; size--) {
                this.af.get(size).a(this, i2, i3);
            }
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    boolean i() {
        return this.H != null && this.H.isEnabled();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.x;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    public boolean j() {
        return this.K > 0;
    }

    void k() {
        if (this.s == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f1516f == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.h.l = false;
        if (this.h.f1574c == 1) {
            F();
            this.f1516f.f(this);
            G();
        } else if (!this.f1513c.f() && this.f1516f.w() == getWidth() && this.f1516f.x() == getHeight()) {
            this.f1516f.f(this);
        } else {
            this.f1516f.f(this);
            G();
        }
        H();
    }

    void l() {
        int iC = this.f1514d.c();
        for (int i2 = 0; i2 < iC; i2++) {
            ((i) this.f1514d.c(i2).getLayoutParams()).f1548c = true;
        }
        this.f1512b.j();
    }

    void m() {
        int iC = this.f1514d.c();
        for (int i2 = 0; i2 < iC; i2++) {
            u uVarC = c(this.f1514d.c(i2));
            if (!uVarC.c()) {
                uVarC.b();
            }
        }
    }

    void n() {
        int iC = this.f1514d.c();
        for (int i2 = 0; i2 < iC; i2++) {
            u uVarC = c(this.f1514d.c(i2));
            if (!uVarC.c()) {
                uVarC.a();
            }
        }
        this.f1512b.i();
    }

    void o() {
        int iC = this.f1514d.c();
        for (int i2 = 0; i2 < iC; i2++) {
            u uVarC = c(this.f1514d.c(i2));
            if (uVarC != null && !uVarC.c()) {
                uVarC.b(6);
            }
        }
        l();
        this.f1512b.h();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K = 0;
        this.x = true;
        this.z = false;
        if (this.f1516f != null) {
            this.f1516f.c(this);
        }
        this.ah = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g != null) {
            this.g.c();
        }
        this.z = false;
        c();
        this.x = false;
        if (this.f1516f != null) {
            this.f1516f.b(this, this.f1512b);
        }
        removeCallbacks(this.ap);
        this.f1515e.b();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.u.get(i2).a(canvas, this, this.h);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.f1516f != null && !this.C && (android.support.v4.view.t.d(motionEvent) & 2) != 0 && motionEvent.getAction() == 8) {
            float f2 = this.f1516f.e() ? -android.support.v4.view.t.e(motionEvent, 9) : 0.0f;
            float fE = this.f1516f.d() ? android.support.v4.view.t.e(motionEvent, 10) : 0.0f;
            if (f2 != BitmapDescriptorFactory.HUE_RED || fE != BitmapDescriptorFactory.HUE_RED) {
                float scrollFactor = getScrollFactor();
                a((int) (fE * scrollFactor), (int) (f2 * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.C) {
            return false;
        }
        if (a(motionEvent)) {
            y();
            return true;
        }
        if (this.f1516f == null) {
            return false;
        }
        boolean zD = this.f1516f.d();
        boolean zE = this.f1516f.e();
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        int iA = android.support.v4.view.t.a(motionEvent);
        int iB = android.support.v4.view.t.b(motionEvent);
        switch (iA) {
            case 0:
                if (this.D) {
                    this.D = false;
                }
                this.Q = android.support.v4.view.t.b(motionEvent, 0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.U = x;
                this.S = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.V = y;
                this.T = y;
                if (this.P == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.ao;
                this.ao[1] = 0;
                iArr[0] = 0;
                int i2 = zD ? 1 : 0;
                if (zE) {
                    i2 |= 2;
                }
                startNestedScroll(i2);
                break;
            case 1:
                this.R.clear();
                stopNestedScroll();
                break;
            case 2:
                int iA2 = android.support.v4.view.t.a(motionEvent, this.Q);
                if (iA2 < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.Q + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int iC = (int) (android.support.v4.view.t.c(motionEvent, iA2) + 0.5f);
                int iD = (int) (android.support.v4.view.t.d(motionEvent, iA2) + 0.5f);
                if (this.P != 1) {
                    int i3 = iC - this.S;
                    int i4 = iD - this.T;
                    if (!zD || Math.abs(i3) <= this.W) {
                        z = false;
                    } else {
                        this.U = ((i3 < 0 ? -1 : 1) * this.W) + this.S;
                        z = true;
                    }
                    if (zE && Math.abs(i4) > this.W) {
                        this.V = this.T + ((i4 >= 0 ? 1 : -1) * this.W);
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
                break;
            case 3:
                y();
                break;
            case 5:
                this.Q = android.support.v4.view.t.b(motionEvent, iB);
                int iC2 = (int) (android.support.v4.view.t.c(motionEvent, iB) + 0.5f);
                this.U = iC2;
                this.S = iC2;
                int iD2 = (int) (android.support.v4.view.t.d(motionEvent, iB) + 0.5f);
                this.V = iD2;
                this.T = iD2;
                break;
            case 6:
                c(motionEvent);
                break;
        }
        return this.P == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        android.support.v4.f.h.a("RV OnLayout");
        k();
        android.support.v4.f.h.a();
        this.z = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        boolean z = false;
        if (this.f1516f == null) {
            d(i2, i3);
            return;
        }
        if (!this.f1516f.f1537b) {
            if (this.y) {
                this.f1516f.a(this.f1512b, this.h, i2, i3);
                return;
            }
            if (this.F) {
                b();
                E();
                if (this.h.j) {
                    this.h.h = true;
                } else {
                    this.f1513c.e();
                    this.h.h = false;
                }
                this.F = false;
                a(false);
            }
            if (this.s != null) {
                this.h.f1572a = this.s.a();
            } else {
                this.h.f1572a = 0;
            }
            b();
            this.f1516f.a(this.f1512b, this.h, i2, i3);
            a(false);
            this.h.h = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z = true;
        }
        this.f1516f.a(this.f1512b, this.h, i2, i3);
        if (z || this.s == null) {
            return;
        }
        if (this.h.f1574c == 1) {
            F();
        }
        this.f1516f.a(i2, i3);
        this.h.l = true;
        G();
        this.f1516f.b(i2, i3);
        if (this.f1516f.k()) {
            this.f1516f.a(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            this.h.l = true;
            G();
            this.f1516f.b(i2, i3);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.o = (SavedState) parcelable;
        super.onRestoreInstanceState(this.o.getSuperState());
        if (this.f1516f == null || this.o.f1522a == null) {
            return;
        }
        this.f1516f.a(this.o.f1522a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.o != null) {
            savedState.a(this.o);
        } else if (this.f1516f != null) {
            savedState.f1522a = this.f1516f.c();
        } else {
            savedState.f1522a = null;
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        h();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.C || this.D) {
            return false;
        }
        if (b(motionEvent)) {
            y();
            return true;
        }
        if (this.f1516f == null) {
            return false;
        }
        boolean zD = this.f1516f.d();
        boolean zE = this.f1516f.e();
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int iA = android.support.v4.view.t.a(motionEvent);
        int iB = android.support.v4.view.t.b(motionEvent);
        if (iA == 0) {
            int[] iArr = this.ao;
            this.ao[1] = 0;
            iArr[0] = 0;
        }
        motionEventObtain.offsetLocation(this.ao[0], this.ao[1]);
        switch (iA) {
            case 0:
                this.Q = android.support.v4.view.t.b(motionEvent, 0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.U = x;
                this.S = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.V = y;
                this.T = y;
                int i2 = zD ? 1 : 0;
                if (zE) {
                    i2 |= 2;
                }
                startNestedScroll(i2);
                break;
            case 1:
                this.R.addMovement(motionEventObtain);
                this.R.computeCurrentVelocity(1000, this.ab);
                float f2 = zD ? -android.support.v4.view.af.a(this.R, this.Q) : 0.0f;
                float f3 = zE ? -android.support.v4.view.af.b(this.R, this.Q) : 0.0f;
                if ((f2 == BitmapDescriptorFactory.HUE_RED && f3 == BitmapDescriptorFactory.HUE_RED) || !b((int) f2, (int) f3)) {
                    setScrollState(0);
                }
                x();
                z2 = true;
                break;
            case 2:
                int iA2 = android.support.v4.view.t.a(motionEvent, this.Q);
                if (iA2 < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.Q + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int iC = (int) (android.support.v4.view.t.c(motionEvent, iA2) + 0.5f);
                int iD = (int) (android.support.v4.view.t.d(motionEvent, iA2) + 0.5f);
                int i3 = this.U - iC;
                int i4 = this.V - iD;
                if (dispatchNestedPreScroll(i3, i4, this.an, this.am)) {
                    i3 -= this.an[0];
                    i4 -= this.an[1];
                    motionEventObtain.offsetLocation(this.am[0], this.am[1]);
                    int[] iArr2 = this.ao;
                    iArr2[0] = iArr2[0] + this.am[0];
                    int[] iArr3 = this.ao;
                    iArr3[1] = iArr3[1] + this.am[1];
                }
                if (this.P != 1) {
                    if (!zD || Math.abs(i3) <= this.W) {
                        z = false;
                    } else {
                        i3 = i3 > 0 ? i3 - this.W : i3 + this.W;
                        z = true;
                    }
                    if (zE && Math.abs(i4) > this.W) {
                        i4 = i4 > 0 ? i4 - this.W : i4 + this.W;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
                if (this.P == 1) {
                    this.U = iC - this.am[0];
                    this.V = iD - this.am[1];
                    if (!zD) {
                        i3 = 0;
                    }
                    if (!zE) {
                        i4 = 0;
                    }
                    if (a(i3, i4, motionEventObtain)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
                break;
            case 3:
                y();
                break;
            case 5:
                this.Q = android.support.v4.view.t.b(motionEvent, iB);
                int iC2 = (int) (android.support.v4.view.t.c(motionEvent, iB) + 0.5f);
                this.U = iC2;
                this.S = iC2;
                int iD2 = (int) (android.support.v4.view.t.d(motionEvent, iB) + 0.5f);
                this.V = iD2;
                this.T = iD2;
                break;
            case 6:
                c(motionEvent);
                break;
        }
        if (!z2) {
            this.R.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public boolean p() {
        return !this.z || this.J || this.f1513c.d();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        u uVarC = c(view);
        if (uVarC != null) {
            if (uVarC.r()) {
                uVarC.m();
            } else if (!uVarC.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + uVarC);
            }
        }
        i(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f1516f.a(this, this.h, view, view2) && view2 != null) {
            this.r.set(0, 0, view2.getWidth(), view2.getHeight());
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof i) {
                i iVar = (i) layoutParams;
                if (!iVar.f1548c) {
                    Rect rect = iVar.f1547b;
                    this.r.left -= rect.left;
                    this.r.right += rect.right;
                    this.r.top -= rect.top;
                    Rect rect2 = this.r;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.r);
            offsetRectIntoDescendantCoords(view, this.r);
            requestChildRectangleOnScreen(view, this.r, !this.z);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f1516f.a(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.v.get(i2).a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.A != 0 || this.C) {
            this.B = true;
        } else {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        if (this.f1516f == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.C) {
            return;
        }
        boolean zD = this.f1516f.d();
        boolean zE = this.f1516f.e();
        if (zD || zE) {
            if (!zD) {
                i2 = 0;
            }
            if (!zE) {
                i3 = 0;
            }
            a(i2, i3, (MotionEvent) null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(ab abVar) {
        this.ai = abVar;
        android.support.v4.view.ah.a(this, this.ai);
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar == this.aj) {
            return;
        }
        this.aj = dVar;
        setChildrenDrawingOrderEnabled(this.aj != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.p) {
            h();
        }
        this.p = z;
        super.setClipToPadding(z);
        if (this.z) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.y = z;
    }

    public void setItemAnimator(e eVar) {
        if (this.g != null) {
            this.g.c();
            this.g.a(null);
        }
        this.g = eVar;
        if (this.g != null) {
            this.g.a(this.ag);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f1512b.a(i2);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.C) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0));
                this.C = true;
                this.D = true;
                c();
                return;
            }
            this.C = false;
            if (this.B && this.f1516f != null && this.s != null) {
                requestLayout();
            }
            this.B = false;
        }
    }

    public void setLayoutManager(h hVar) {
        if (hVar == this.f1516f) {
            return;
        }
        c();
        if (this.f1516f != null) {
            if (this.x) {
                this.f1516f.b(this, this.f1512b);
            }
            this.f1516f.b((RecyclerView) null);
        }
        this.f1512b.a();
        this.f1514d.a();
        this.f1516f = hVar;
        if (hVar != null) {
            if (hVar.q != null) {
                throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView: " + hVar.q);
            }
            this.f1516f.b(this);
            if (this.x) {
                this.f1516f.c(this);
            }
        }
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    @Deprecated
    public void setOnScrollListener(l lVar) {
        this.ae = lVar;
    }

    public void setRecycledViewPool(m mVar) {
        this.f1512b.a(mVar);
    }

    public void setRecyclerListener(o oVar) {
        this.t = oVar;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i2) {
            case 0:
                break;
            case 1:
                this.W = android.support.v4.view.at.a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
                break;
        }
        this.W = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(s sVar) {
        this.f1512b.a(sVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    @Override // android.view.View, android.support.v4.view.x
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }
}
