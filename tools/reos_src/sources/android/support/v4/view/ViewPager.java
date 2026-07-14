package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private android.support.v4.widget.j R;
    private android.support.v4.widget.j S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private List<f> aa;
    private f ab;
    private f ac;
    private e ad;
    private g ae;
    private Method af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj;
    private int ak;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f832b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<b> f833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f834f;
    private final Rect g;
    private ac h;
    private int i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private boolean n;
    private h o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t;
    private float u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f829a = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Comparator<b> f830c = new Comparator<b>() { // from class: android.support.v4.view.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.f842b - bVar2.f842b;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Interpolator f831d = new Interpolator() { // from class: android.support.v4.view.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final i ai = new i();

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.f.d.a(new android.support.v4.f.e<SavedState>() { // from class: android.support.v4.view.ViewPager.SavedState.1
            @Override // android.support.v4.f.e
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.support.v4.f.e
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] b(int i) {
                return new SavedState[i];
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Parcelable f839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ClassLoader f840c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f838a = parcel.readInt();
            this.f839b = parcel.readParcelable(classLoader);
            this.f840c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f838a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f838a);
            parcel.writeParcelable(this.f839b, i);
        }
    }

    interface a {
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f845e;

        b() {
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f851f;

        public c() {
            super(-1, -1);
            this.f848c = BitmapDescriptorFactory.HUE_RED;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f848c = BitmapDescriptorFactory.HUE_RED;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f829a);
            this.f847b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class d extends android.support.v4.view.a {
        d() {
        }

        private boolean b() {
            return ViewPager.this.h != null && ViewPager.this.h.b() > 1;
        }

        @Override // android.support.v4.view.a
        public void a(View view, android.support.v4.view.a.c cVar) {
            super.a(view, cVar);
            cVar.b((CharSequence) ViewPager.class.getName());
            cVar.i(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        @Override // android.support.v4.view.a
        public void a(View view, AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            android.support.v4.view.a.m mVarA = android.support.v4.view.a.a.a(accessibilityEvent);
            mVarA.a(b());
            if (accessibilityEvent.getEventType() != 4096 || ViewPager.this.h == null) {
                return;
            }
            mVarA.a(ViewPager.this.h.b());
            mVarA.b(ViewPager.this.i);
            mVarA.c(ViewPager.this.i);
        }

        @Override // android.support.v4.view.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!ViewPager.this.canScrollHorizontally(1)) {
                        return false;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.i + 1);
                    return true;
                case 8192:
                    if (!ViewPager.this.canScrollHorizontally(-1)) {
                        return false;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.i - 1);
                    return true;
                default:
                    return false;
            }
        }
    }

    interface e {
        void a(ac acVar, ac acVar2);
    }

    public interface f {
        void a(int i);

        void a(int i, float f2, int i2);

        void b(int i);
    }

    public interface g {
        void a(View view, float f2);
    }

    private class h extends DataSetObserver {
        private h() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.b();
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f846a != cVar2.f846a) {
                return cVar.f846a ? 1 : -1;
            }
            return cVar.f850e - cVar2.f850e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f833e = new ArrayList<>();
        this.f834f = new b();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.t = -3.4028235E38f;
        this.u = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.T = true;
        this.U = false;
        this.aj = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.c();
            }
        };
        this.ak = 0;
        a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f833e = new ArrayList<>();
        this.f834f = new b();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.t = -3.4028235E38f;
        this.u = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.T = true;
        this.U = false;
        this.aj = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.c();
            }
        };
        this.ak = 0;
        a();
    }

    private int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.O || Math.abs(i3) <= this.M) {
            i2 = (int) ((i2 >= this.i ? 0.4f : 0.6f) + i2 + f2);
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f833e.size() > 0) {
            return Math.max(this.f833e.get(0).f842b, Math.min(i2, this.f833e.get(this.f833e.size() - 1).f842b));
        }
        return i2;
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.f833e.isEmpty()) {
            b bVarB = b(this.i);
            int iMin = (int) ((bVarB != null ? Math.min(bVarB.f845e, this.u) : BitmapDescriptorFactory.HUE_RED) * ((i2 - getPaddingLeft()) - getPaddingRight()));
            if (iMin != getScrollX()) {
                a(false);
                scrollTo(iMin, getScrollY());
                return;
            }
            return;
        }
        if (!this.m.isFinished()) {
            this.m.setFinalX(getCurrentItem() * getClientWidth());
            return;
        }
        scrollTo((int) ((((i2 - getPaddingLeft()) - getPaddingRight()) + i4) * (getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))), getScrollY());
    }

    private void a(int i2, boolean z, int i3, boolean z2) {
        int iMax;
        b bVarB = b(i2);
        if (bVarB != null) {
            iMax = (int) (Math.max(this.t, Math.min(bVarB.f845e, this.u)) * getClientWidth());
        } else {
            iMax = 0;
        }
        if (z) {
            a(iMax, 0, i3);
            if (z2) {
                e(i2);
                return;
            }
            return;
        }
        if (z2) {
            e(i2);
        }
        a(false);
        scrollTo(iMax, 0);
        d(iMax);
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int iB = this.h.b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.p / clientWidth : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.f842b;
            if (i3 < bVar.f842b) {
                float fC = bVar2.f845e + bVar2.f844d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.f842b && i5 < this.f833e.size()) {
                    b bVar5 = this.f833e.get(i5);
                    while (true) {
                        bVar4 = bVar5;
                        if (i4 <= bVar4.f842b || i5 >= this.f833e.size() - 1) {
                            break;
                        }
                        i5++;
                        bVar5 = this.f833e.get(i5);
                    }
                    while (i4 < bVar4.f842b) {
                        fC += this.h.c(i4) + f2;
                        i4++;
                    }
                    bVar4.f845e = fC;
                    fC += bVar4.f844d + f2;
                    i4++;
                }
            } else if (i3 > bVar.f842b) {
                int size = this.f833e.size() - 1;
                float fC2 = bVar2.f845e;
                int i6 = i3 - 1;
                while (i6 >= bVar.f842b && size >= 0) {
                    b bVar6 = this.f833e.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i6 >= bVar3.f842b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.f833e.get(size);
                    }
                    while (i6 > bVar3.f842b) {
                        fC2 -= this.h.c(i6) + f2;
                        i6--;
                    }
                    fC2 -= bVar3.f844d + f2;
                    bVar3.f845e = fC2;
                    i6--;
                }
            }
        }
        int size2 = this.f833e.size();
        float f3 = bVar.f845e;
        int i7 = bVar.f842b - 1;
        this.t = bVar.f842b == 0 ? bVar.f845e : -3.4028235E38f;
        this.u = bVar.f842b == iB + (-1) ? (bVar.f845e + bVar.f844d) - 1.0f : Float.MAX_VALUE;
        for (int i8 = i2 - 1; i8 >= 0; i8--) {
            b bVar7 = this.f833e.get(i8);
            float fC3 = f3;
            while (i7 > bVar7.f842b) {
                fC3 -= this.h.c(i7) + f2;
                i7--;
            }
            f3 = fC3 - (bVar7.f844d + f2);
            bVar7.f845e = f3;
            if (bVar7.f842b == 0) {
                this.t = f3;
            }
            i7--;
        }
        float f4 = bVar.f845e + bVar.f844d + f2;
        int i9 = bVar.f842b + 1;
        for (int i10 = i2 + 1; i10 < size2; i10++) {
            b bVar8 = this.f833e.get(i10);
            float fC4 = f4;
            while (i9 < bVar8.f842b) {
                fC4 = this.h.c(i9) + f2 + fC4;
                i9++;
            }
            if (bVar8.f842b == iB - 1) {
                this.u = (bVar8.f844d + fC4) - 1.0f;
            }
            bVar8.f845e = fC4;
            f4 = fC4 + bVar8.f844d + f2;
            i9++;
        }
        this.U = false;
    }

    private void a(MotionEvent motionEvent) {
        int iB = t.b(motionEvent);
        if (t.b(motionEvent, iB) == this.K) {
            int i2 = iB == 0 ? 1 : 0;
            this.G = t.c(motionEvent, i2);
            this.K = t.b(motionEvent, i2);
            if (this.L != null) {
                this.L.clear();
            }
        }
    }

    private void a(boolean z) {
        boolean z2 = this.ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.m.isFinished()) {
                this.m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.z = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.f833e.size(); i2++) {
            b bVar = this.f833e.get(i2);
            if (bVar.f843c) {
                bVar.f843c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ah.a(this, this.aj);
            } else {
                this.aj.run();
            }
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.E) && f3 > BitmapDescriptorFactory.HUE_RED) || (f2 > ((float) (getWidth() - this.E)) && f3 < BitmapDescriptorFactory.HUE_RED);
    }

    private void b(int i2, float f2, int i3) {
        if (this.ab != null) {
            this.ab.a(i2, f2, i3);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar = this.aa.get(i4);
                if (fVar != null) {
                    fVar.a(i2, f2, i3);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i2, f2, i3);
        }
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ah.a(getChildAt(i2), z ? 2 : 0, (Paint) null);
        }
    }

    private boolean b(float f2) {
        boolean z;
        float f3;
        boolean z2 = true;
        boolean zA = false;
        float f4 = this.G - f2;
        this.G = f2;
        float scrollX = getScrollX() + f4;
        int clientWidth = getClientWidth();
        float f5 = clientWidth * this.t;
        float f6 = clientWidth * this.u;
        b bVar = this.f833e.get(0);
        b bVar2 = this.f833e.get(this.f833e.size() - 1);
        if (bVar.f842b != 0) {
            f5 = bVar.f845e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f842b != this.h.b() - 1) {
            f3 = bVar2.f845e * clientWidth;
            z2 = false;
        } else {
            f3 = f6;
        }
        if (scrollX < f5) {
            if (z) {
                zA = this.R.a(Math.abs(f5 - scrollX) / clientWidth);
            }
        } else if (scrollX > f3) {
            zA = z2 ? this.S.a(Math.abs(scrollX - f3) / clientWidth) : false;
            f5 = f3;
        } else {
            f5 = scrollX;
        }
        this.G += f5 - ((int) f5);
        scrollTo((int) f5, getScrollY());
        d((int) f5);
        return zA;
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean d(int i2) {
        if (this.f833e.size() == 0) {
            if (this.T) {
                return false;
            }
            this.V = false;
            a(0, BitmapDescriptorFactory.HUE_RED, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b bVarJ = j();
        int clientWidth = getClientWidth();
        int i3 = this.p + clientWidth;
        float f2 = this.p / clientWidth;
        int i4 = bVarJ.f842b;
        float f3 = ((i2 / clientWidth) - bVarJ.f845e) / (bVarJ.f844d + f2);
        this.V = false;
        a(i4, f3, (int) (i3 * f3));
        if (this.V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void e(int i2) {
        if (this.ab != null) {
            this.ab.b(i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.aa.get(i3);
                if (fVar != null) {
                    fVar.b(i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.b(i2);
        }
    }

    private void f(int i2) {
        if (this.ab != null) {
            this.ab.a(i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.aa.get(i3);
                if (fVar != null) {
                    fVar.a(i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i2);
        }
    }

    private void g() {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= getChildCount()) {
                return;
            }
            if (!((c) getChildAt(i3).getLayoutParams()).f846a) {
                removeViewAt(i3);
                i3--;
            }
            i2 = i3 + 1;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList<>();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ah.add(getChildAt(i2));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private boolean i() {
        this.K = -1;
        k();
        return this.R.c() | this.S.c();
    }

    private b j() {
        int i2;
        b bVar;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.p / clientWidth : 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z = true;
        b bVar2 = null;
        while (i4 < this.f833e.size()) {
            b bVar3 = this.f833e.get(i4);
            if (z || bVar3.f842b == i3 + 1) {
                i2 = i4;
                bVar = bVar3;
            } else {
                b bVar4 = this.f834f;
                bVar4.f845e = f3 + f4 + f2;
                bVar4.f842b = i3 + 1;
                bVar4.f844d = this.h.c(bVar4.f842b);
                i2 = i4 - 1;
                bVar = bVar4;
            }
            float f5 = bVar.f845e;
            float f6 = bVar.f844d + f5 + f2;
            if (!z && scrollX < f5) {
                return bVar2;
            }
            if (scrollX < f6 || i2 == this.f833e.size() - 1) {
                return bVar;
            }
            f4 = f5;
            i3 = bVar.f842b;
            z = false;
            f3 = bVar.f844d;
            bVar2 = bVar;
            i4 = i2 + 1;
        }
        return bVar2;
    }

    private void k() {
        this.B = false;
        this.C = false;
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i2) {
        if (this.ak == i2) {
            return;
        }
        this.ak = i2;
        if (this.ae != null) {
            b(i2 != 0);
        }
        f(i2);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.y != z) {
            this.y = z;
        }
    }

    float a(float f2) {
        return (float) Math.sin((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d));
    }

    b a(int i2, int i3) {
        b bVar = new b();
        bVar.f842b = i2;
        bVar.f841a = this.h.a((ViewGroup) this, i2);
        bVar.f844d = this.h.c(i2);
        if (i3 < 0 || i3 >= this.f833e.size()) {
            this.f833e.add(bVar);
        } else {
            this.f833e.add(i3, bVar);
        }
        return bVar;
    }

    b a(View view) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f833e.size()) {
                return null;
            }
            b bVar = this.f833e.get(i3);
            if (this.h.a(view, bVar.f841a)) {
                return bVar;
            }
            i2 = i3 + 1;
        }
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, f831d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.F = at.a(viewConfiguration);
        this.M = (int) (400.0f * f2);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new android.support.v4.widget.j(context);
        this.S = new android.support.v4.widget.j(context);
        this.O = (int) (25.0f * f2);
        this.P = (int) (2.0f * f2);
        this.D = (int) (16.0f * f2);
        ah.a(this, new d());
        if (ah.e(this) == 0) {
            ah.c((View) this, 1);
        }
        ah.a(this, new ab() { // from class: android.support.v4.view.ViewPager.4

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Rect f837b = new Rect();

            @Override // android.support.v4.view.ab
            public bh a(View view, bh bhVar) {
                bh bhVarA = ah.a(view, bhVar);
                if (bhVarA.e()) {
                    return bhVarA;
                }
                Rect rect = this.f837b;
                rect.left = bhVarA.a();
                rect.top = bhVarA.b();
                rect.right = bhVarA.c();
                rect.bottom = bhVarA.d();
                int childCount = ViewPager.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    bh bhVarB = ah.b(ViewPager.this.getChildAt(i2), bhVarA);
                    rect.left = Math.min(bhVarB.a(), rect.left);
                    rect.top = Math.min(bhVarB.b(), rect.top);
                    rect.right = Math.min(bhVarB.c(), rect.right);
                    rect.bottom = Math.min(bhVarB.d(), rect.bottom);
                }
                return bhVarA.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    void a(int i2) {
        b bVar;
        String hexString;
        int i3;
        b bVar2;
        b bVarA;
        if (this.i != i2) {
            b bVarB = b(this.i);
            this.i = i2;
            bVar = bVarB;
        } else {
            bVar = null;
        }
        if (this.h == null) {
            h();
            return;
        }
        if (this.z) {
            h();
            return;
        }
        if (getWindowToken() != null) {
            this.h.a((ViewGroup) this);
            int i4 = this.A;
            int iMax = Math.max(0, this.i - i4);
            int iB = this.h.b();
            int iMin = Math.min(iB - 1, i4 + this.i);
            if (iB != this.f832b) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e2) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f832b + ", found: " + iB + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.h.getClass());
            }
            int i5 = 0;
            while (true) {
                i3 = i5;
                if (i3 < this.f833e.size()) {
                    bVar2 = this.f833e.get(i3);
                    if (bVar2.f842b >= this.i) {
                        if (bVar2.f842b != this.i) {
                            break;
                        } else {
                            break;
                        }
                    }
                    i5 = i3 + 1;
                }
                bVar2 = null;
                break;
            }
            b bVarA2 = (bVar2 != null || iB <= 0) ? bVar2 : a(this.i, i3);
            if (bVarA2 != null) {
                int i6 = i3 - 1;
                b bVar3 = i6 >= 0 ? this.f833e.get(i6) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? BitmapDescriptorFactory.HUE_RED : (2.0f - bVarA2.f844d) + (getPaddingLeft() / clientWidth);
                float f2 = 0.0f;
                int i7 = i3;
                int i8 = i6;
                for (int i9 = this.i - 1; i9 >= 0; i9--) {
                    if (f2 >= paddingLeft && i9 < iMax) {
                        if (bVar3 == null) {
                            break;
                        }
                        if (i9 == bVar3.f842b && !bVar3.f843c) {
                            this.f833e.remove(i8);
                            this.h.a((ViewGroup) this, i9, bVar3.f841a);
                            i8--;
                            i7--;
                            bVar3 = i8 >= 0 ? this.f833e.get(i8) : null;
                        }
                    } else if (bVar3 == null || i9 != bVar3.f842b) {
                        f2 += a(i9, i8 + 1).f844d;
                        i7++;
                        bVar3 = i8 >= 0 ? this.f833e.get(i8) : null;
                    } else {
                        f2 += bVar3.f844d;
                        i8--;
                        bVar3 = i8 >= 0 ? this.f833e.get(i8) : null;
                    }
                }
                float f3 = bVarA2.f844d;
                int i10 = i7 + 1;
                if (f3 < 2.0f) {
                    b bVar4 = i10 < this.f833e.size() ? this.f833e.get(i10) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    b bVar5 = bVar4;
                    int i11 = i10;
                    int i12 = this.i + 1;
                    while (i12 < iB) {
                        if (f3 >= paddingRight && i12 > iMin) {
                            if (bVar5 == null) {
                                break;
                            }
                            if (i12 == bVar5.f842b && !bVar5.f843c) {
                                this.f833e.remove(i11);
                                this.h.a((ViewGroup) this, i12, bVar5.f841a);
                                bVar5 = i11 < this.f833e.size() ? this.f833e.get(i11) : null;
                            }
                        } else if (bVar5 == null || i12 != bVar5.f842b) {
                            b bVarA3 = a(i12, i11);
                            i11++;
                            f3 += bVarA3.f844d;
                            bVar5 = i11 < this.f833e.size() ? this.f833e.get(i11) : null;
                        } else {
                            f3 += bVar5.f844d;
                            i11++;
                            bVar5 = i11 < this.f833e.size() ? this.f833e.get(i11) : null;
                        }
                        i12++;
                        bVar5 = bVar5;
                        f3 = f3;
                    }
                }
                a(bVarA2, i7, bVar);
            }
            this.h.b((ViewGroup) this, this.i, bVarA2 != null ? bVarA2.f841a : null);
            this.h.b((ViewGroup) this);
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                c cVar = (c) childAt.getLayoutParams();
                cVar.f851f = i13;
                if (!cVar.f846a && cVar.f848c == BitmapDescriptorFactory.HUE_RED && (bVarA = a(childAt)) != null) {
                    cVar.f848c = bVarA.f844d;
                    cVar.f850e = bVarA.f842b;
                }
            }
            h();
            if (hasFocus()) {
                View viewFindFocus = findFocus();
                b bVarB2 = viewFindFocus != null ? b(viewFindFocus) : null;
                if (bVarB2 == null || bVarB2.f842b != this.i) {
                    for (int i14 = 0; i14 < getChildCount(); i14++) {
                        View childAt2 = getChildAt(i14);
                        b bVarA4 = a(childAt2);
                        if (bVarA4 != null && bVarA4.f842b == this.i && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    protected void a(int i2, float f2, int i3) {
        int measuredWidth;
        int i4;
        int i5;
        if (this.W > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i6 = 0;
            while (i6 < childCount) {
                View childAt = getChildAt(i6);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f846a) {
                    switch (cVar.f847b & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            int i7 = paddingRight;
                            i4 = paddingLeft;
                            i5 = i7;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            int i8 = paddingRight;
                            i4 = paddingLeft;
                            i5 = i8;
                            break;
                        case 3:
                            int width2 = childAt.getWidth() + paddingLeft;
                            int i9 = paddingLeft;
                            i5 = paddingRight;
                            i4 = width2;
                            measuredWidth = i9;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            int measuredWidth2 = paddingRight + childAt.getMeasuredWidth();
                            i4 = paddingLeft;
                            i5 = measuredWidth2;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                } else {
                    int i10 = paddingRight;
                    i4 = paddingLeft;
                    i5 = i10;
                }
                i6++;
                int i11 = i5;
                paddingLeft = i4;
                paddingRight = i11;
            }
        }
        b(i2, f2, i3);
        if (this.ae != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt2 = getChildAt(i12);
                if (!((c) childAt2.getLayoutParams()).f846a) {
                    this.ae.a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.V = true;
    }

    void a(int i2, int i3, int i4) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if ((this.m == null || this.m.isFinished()) ? false : true) {
            int currX = this.n ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            setScrollingCacheEnabled(false);
            scrollX = currX;
        } else {
            scrollX = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float fA = (i7 * a(Math.min(1.0f, (Math.abs(i5) * 1.0f) / clientWidth))) + i7;
        int iAbs2 = Math.abs(i4);
        if (iAbs2 > 0) {
            iAbs = Math.round(1000.0f * Math.abs(fA / iAbs2)) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((clientWidth * this.h.c(this.i)) + this.p)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.n = false;
        this.m.startScroll(scrollX, scrollY, i5, i6, iMin);
        ah.d(this);
    }

    public void a(int i2, boolean z) {
        this.z = false;
        a(i2, z, false);
    }

    void a(int i2, boolean z, boolean z2) {
        a(i2, z, z2, 0);
    }

    void a(int i2, boolean z, boolean z2, int i3) {
        if (this.h == null || this.h.b() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.i == i2 && this.f833e.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.h.b()) {
            i2 = this.h.b() - 1;
        }
        int i4 = this.A;
        if (i2 > this.i + i4 || i2 < this.i - i4) {
            for (int i5 = 0; i5 < this.f833e.size(); i5++) {
                this.f833e.get(i5).f843c = true;
            }
        }
        boolean z3 = this.i != i2;
        if (!this.T) {
            a(i2);
            a(i2, z, i3, z3);
        } else {
            this.i = i2;
            if (z3) {
                e(i2);
            }
            requestLayout();
        }
    }

    public void a(f fVar) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(fVar);
    }

    public void a(boolean z, g gVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z2 = gVar != null;
            boolean z3 = z2 != (this.ae != null);
            this.ae = gVar;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                this.ag = z ? 2 : 1;
            } else {
                this.ag = 0;
            }
            if (z3) {
                c();
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return c(17);
            case 22:
                return c(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (android.support.v4.view.g.a(keyEvent)) {
                    return c(2);
                }
                if (android.support.v4.view.g.a(keyEvent, 1)) {
                    return c(1);
                }
                return false;
            default:
                return false;
        }
    }

    protected boolean a(View view, boolean z, int i2, int i3, int i4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom() && a(childAt, true, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ah.a(view, -i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b bVarA;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.f842b == this.i) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b bVarA;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.f842b == this.i) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        c cVar = (c) layoutParamsGenerateLayoutParams;
        cVar.f846a |= view instanceof a;
        if (!this.x) {
            super.addView(view, i2, layoutParamsGenerateLayoutParams);
        } else {
            if (cVar != null && cVar.f846a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            cVar.f849d = true;
            addViewInLayout(view, i2, layoutParamsGenerateLayoutParams);
        }
    }

    b b(int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.f833e.size()) {
                return null;
            }
            b bVar = this.f833e.get(i4);
            if (bVar.f842b == i2) {
                return bVar;
            }
            i3 = i4 + 1;
        }
    }

    b b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    void b() {
        int i2;
        boolean z;
        int iMax;
        boolean z2;
        int iB = this.h.b();
        this.f832b = iB;
        boolean z3 = this.f833e.size() < (this.A * 2) + 1 && this.f833e.size() < iB;
        boolean z4 = false;
        int i3 = this.i;
        boolean z5 = z3;
        int i4 = 0;
        while (i4 < this.f833e.size()) {
            b bVar = this.f833e.get(i4);
            int iA = this.h.a(bVar.f841a);
            if (iA == -1) {
                i2 = i4;
                z = z4;
                iMax = i3;
                z2 = z5;
            } else if (iA == -2) {
                this.f833e.remove(i4);
                int i5 = i4 - 1;
                if (!z4) {
                    this.h.a((ViewGroup) this);
                    z4 = true;
                }
                this.h.a((ViewGroup) this, bVar.f842b, bVar.f841a);
                if (this.i == bVar.f842b) {
                    i2 = i5;
                    z = z4;
                    iMax = Math.max(0, Math.min(this.i, iB - 1));
                    z2 = true;
                } else {
                    i2 = i5;
                    z = z4;
                    iMax = i3;
                    z2 = true;
                }
            } else if (bVar.f842b != iA) {
                if (bVar.f842b == this.i) {
                    i3 = iA;
                }
                bVar.f842b = iA;
                i2 = i4;
                z = z4;
                iMax = i3;
                z2 = true;
            } else {
                i2 = i4;
                z = z4;
                iMax = i3;
                z2 = z5;
            }
            z5 = z2;
            i3 = iMax;
            z4 = z;
            i4 = i2 + 1;
        }
        if (z4) {
            this.h.b((ViewGroup) this);
        }
        Collections.sort(this.f833e, f830c);
        if (z5) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                c cVar = (c) getChildAt(i6).getLayoutParams();
                if (!cVar.f846a) {
                    cVar.f848c = BitmapDescriptorFactory.HUE_RED;
                }
            }
            a(i3, false, true);
            requestLayout();
        }
    }

    public void b(f fVar) {
        if (this.aa != null) {
            this.aa.remove(fVar);
        }
    }

    void c() {
        a(this.i);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    public boolean c(int i2) {
        View view;
        boolean z;
        boolean zD;
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            view = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (z) {
                view = viewFindFocus;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ").append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                view = null;
            }
        } else {
            view = viewFindFocus;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (viewFindNextFocus == null || viewFindNextFocus == view) {
            if (i2 == 17 || i2 == 1) {
                zD = d();
            } else if (i2 == 66 || i2 == 2) {
                zD = e();
            } else {
                zD = false;
            }
        } else if (i2 == 17) {
            zD = (view == null || a(this.g, viewFindNextFocus).left < a(this.g, view).left) ? viewFindNextFocus.requestFocus() : d();
        } else if (i2 == 66) {
            zD = (view == null || a(this.g, viewFindNextFocus).left > a(this.g, view).left) ? viewFindNextFocus.requestFocus() : e();
        } else {
            zD = false;
        }
        if (zD) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return zD;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.t));
        }
        if (i2 > 0) {
            return scrollX < ((int) (((float) clientWidth) * this.u));
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.n = true;
        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.m.getCurrX();
        int currY = this.m.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ah.d(this);
    }

    boolean d() {
        if (this.i <= 0) {
            return false;
        }
        a(this.i - 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b bVarA;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.f842b == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean zA = false;
        int iA = ah.a(this);
        if (iA == 0 || (iA == 1 && this.h != null && this.h.b() > 1)) {
            if (!this.R.a()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.t * width);
                this.R.a(height, width);
                zA = false | this.R.a(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.S.a()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.u + 1.0f)) * width2);
                this.S.a(height2, width2);
                zA |= this.S.a(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.R.b();
            this.S.b();
        }
        if (zA) {
            ah.d(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    boolean e() {
        if (this.h == null || this.i >= this.h.b() - 1) {
            return false;
        }
        a(this.i + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public ac getAdapter() {
        return this.h;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.ag == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.ah.get(i3).getLayoutParams()).f851f;
    }

    public int getCurrentItem() {
        return this.i;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public int getPageMargin() {
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (this.m != null && !this.m.isFinished()) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        super.onDraw(canvas);
        if (this.p <= 0 || this.q == null || this.f833e.size() <= 0 || this.h == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f3 = this.p / width;
        b bVar = this.f833e.get(0);
        float f4 = bVar.f845e;
        int size = this.f833e.size();
        int i2 = bVar.f842b;
        int i3 = this.f833e.get(size - 1).f842b;
        int i4 = 0;
        for (int i5 = i2; i5 < i3; i5++) {
            while (i5 > bVar.f842b && i4 < size) {
                i4++;
                bVar = this.f833e.get(i4);
            }
            if (i5 == bVar.f842b) {
                f2 = (bVar.f845e + bVar.f844d) * width;
                f4 = bVar.f845e + bVar.f844d + f3;
            } else {
                float fC = this.h.c(i5);
                f2 = (f4 + fC) * width;
                f4 += fC + f3;
            }
            if (this.p + f2 > scrollX) {
                this.q.setBounds(Math.round(f2), this.r, Math.round(this.p + f2), this.s);
                this.q.draw(canvas);
            }
            if (f2 > scrollX + width) {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            i();
            return false;
        }
        if (action != 0) {
            if (this.B) {
                return true;
            }
            if (this.C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.I = x;
                this.G = x;
                float y = motionEvent.getY();
                this.J = y;
                this.H = y;
                this.K = t.b(motionEvent, 0);
                this.C = false;
                this.n = true;
                this.m.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
                    this.m.abortAnimation();
                    this.z = false;
                    c();
                    this.B = true;
                    c(true);
                    setScrollState(1);
                } else {
                    a(false);
                    this.B = false;
                }
                break;
            case 2:
                int i2 = this.K;
                if (i2 != -1) {
                    int iA = t.a(motionEvent, i2);
                    float fC = t.c(motionEvent, iA);
                    float f2 = fC - this.G;
                    float fAbs = Math.abs(f2);
                    float fD = t.d(motionEvent, iA);
                    float fAbs2 = Math.abs(fD - this.J);
                    if (f2 != BitmapDescriptorFactory.HUE_RED && !a(this.G, f2) && a(this, false, (int) f2, (int) fC, (int) fD)) {
                        this.G = fC;
                        this.H = fD;
                        this.C = true;
                        return false;
                    }
                    if (fAbs > this.F && 0.5f * fAbs > fAbs2) {
                        this.B = true;
                        c(true);
                        setScrollState(1);
                        this.G = f2 > BitmapDescriptorFactory.HUE_RED ? this.I + this.F : this.I - this.F;
                        this.H = fD;
                        setScrollingCacheEnabled(true);
                    } else if (fAbs2 > this.F) {
                        this.C = true;
                    }
                    if (this.B && b(fC)) {
                        ah.d(this);
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        return this.B;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0141  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVarA;
        int i6;
        int i7;
        int iMax;
        int measuredHeight;
        int i8;
        int i9;
        int childCount = getChildCount();
        int i10 = i4 - i2;
        int i11 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f846a) {
                    int i14 = cVar.f847b & 7;
                    int i15 = cVar.f847b & 112;
                    switch (i14) {
                        case 1:
                            iMax = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            iMax = paddingLeft;
                            break;
                        case 3:
                            iMax = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            iMax = measuredWidth;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i16 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i16;
                            break;
                        case 48:
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                            int i17 = paddingTop;
                            i9 = paddingBottom;
                            i8 = measuredHeight2;
                            measuredHeight = i17;
                            break;
                        case 80:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight3 = paddingBottom + childAt.getMeasuredHeight();
                            i8 = paddingTop;
                            i9 = measuredHeight3;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i18 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i18;
                            break;
                    }
                    int i19 = iMax + scrollX;
                    childAt.layout(i19, measuredHeight, childAt.getMeasuredWidth() + i19, childAt.getMeasuredHeight() + measuredHeight);
                    i6 = i12 + 1;
                    i7 = i8;
                    paddingBottom = i9;
                } else {
                    i6 = i12;
                    i7 = paddingTop;
                }
            } else {
                i6 = i12;
                i7 = paddingTop;
            }
            i13++;
            paddingLeft = paddingLeft;
            paddingRight = paddingRight;
            paddingTop = i7;
            i12 = i6;
        }
        int i20 = (i10 - paddingLeft) - paddingRight;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f846a && (bVarA = a(childAt2)) != null) {
                    int i22 = ((int) (bVarA.f845e * i20)) + paddingLeft;
                    if (cVar2.f849d) {
                        cVar2.f849d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (cVar2.f848c * i20), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i22, paddingTop, childAt2.getMeasuredWidth() + i22, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.r = paddingTop;
        this.s = i11 - paddingBottom;
        this.W = i12;
        if (this.T) {
            a(this.i, false, 0, false);
        }
        this.T = false;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x010a A[PHI: r1
      0x010a: PHI (r1v18 int) = (r1v17 int), (r1v20 int) binds: [B:28:0x0088, B:30:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.E = Math.min(measuredWidth / 10, this.D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (cVar2 = (c) childAt.getLayoutParams()) != null && cVar2.f846a) {
                int i8 = cVar2.f847b & 7;
                int i9 = cVar2.f847b & 112;
                int i10 = Integer.MIN_VALUE;
                int i11 = Integer.MIN_VALUE;
                boolean z = i9 == 48 || i9 == 80;
                boolean z2 = i8 == 3 || i8 == 5;
                if (z) {
                    i10 = 1073741824;
                } else if (z2) {
                    i11 = 1073741824;
                }
                if (cVar2.width != -2) {
                    i4 = 1073741824;
                    i5 = cVar2.width != -1 ? cVar2.width : paddingLeft;
                } else {
                    i4 = i10;
                    i5 = paddingLeft;
                }
                if (cVar2.height != -2) {
                    i11 = 1073741824;
                    if (cVar2.height != -1) {
                        i6 = cVar2.height;
                    } else {
                        i6 = measuredHeight;
                    }
                } else {
                    i6 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i4), View.MeasureSpec.makeMeasureSpec(i6, i11));
                if (z) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
        }
        this.v = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.w = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.x = true;
        c();
        this.x = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.f846a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (cVar.f848c * paddingLeft), 1073741824), this.w);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        b bVarA;
        int i4 = -1;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = 1;
            i3 = 0;
        } else {
            i3 = childCount - 1;
            childCount = -1;
        }
        while (i3 != childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.f842b == this.i && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.h != null) {
            this.h.a(savedState.f839b, savedState.f840c);
            a(savedState.f838a, false, true);
        } else {
            this.j = savedState.f838a;
            this.k = savedState.f839b;
            this.l = savedState.f840c;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f838a = this.i;
        if (this.h != null) {
            savedState.f839b = this.h.a();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            a(i2, i4, this.p, this.p);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zI = false;
        if (this.Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.h == null || this.h.b() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.z = false;
                c();
                float x = motionEvent.getX();
                this.I = x;
                this.G = x;
                float y = motionEvent.getY();
                this.J = y;
                this.H = y;
                this.K = t.b(motionEvent, 0);
                break;
            case 1:
                if (this.B) {
                    VelocityTracker velocityTracker = this.L;
                    velocityTracker.computeCurrentVelocity(1000, this.N);
                    int iA = (int) af.a(velocityTracker, this.K);
                    this.z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    b bVarJ = j();
                    a(a(bVarJ.f842b, ((scrollX / clientWidth) - bVarJ.f845e) / (bVarJ.f844d + (this.p / clientWidth)), iA, (int) (t.c(motionEvent, t.a(motionEvent, this.K)) - this.I)), true, true, iA);
                    zI = i();
                }
                break;
            case 2:
                if (!this.B) {
                    int iA2 = t.a(motionEvent, this.K);
                    if (iA2 != -1) {
                        float fC = t.c(motionEvent, iA2);
                        float fAbs = Math.abs(fC - this.G);
                        float fD = t.d(motionEvent, iA2);
                        float fAbs2 = Math.abs(fD - this.H);
                        if (fAbs > this.F && fAbs > fAbs2) {
                            this.B = true;
                            c(true);
                            this.G = fC - this.I > BitmapDescriptorFactory.HUE_RED ? this.I + this.F : this.I - this.F;
                            this.H = fD;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                        if (this.B) {
                            zI = false | b(t.c(motionEvent, t.a(motionEvent, this.K)));
                        }
                    } else {
                        zI = i();
                    }
                } else if (this.B) {
                    zI = false | b(t.c(motionEvent, t.a(motionEvent, this.K)));
                }
                break;
            case 3:
                if (this.B) {
                    a(this.i, true, 0, false);
                    zI = i();
                }
                break;
            case 5:
                int iB = t.b(motionEvent);
                this.G = t.c(motionEvent, iB);
                this.K = t.b(motionEvent, iB);
                break;
            case 6:
                a(motionEvent);
                this.G = t.c(motionEvent, t.a(motionEvent, this.K));
                break;
        }
        if (zI) {
            ah.d(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(ac acVar) {
        if (this.h != null) {
            this.h.c((DataSetObserver) null);
            this.h.a((ViewGroup) this);
            for (int i2 = 0; i2 < this.f833e.size(); i2++) {
                b bVar = this.f833e.get(i2);
                this.h.a((ViewGroup) this, bVar.f842b, bVar.f841a);
            }
            this.h.b((ViewGroup) this);
            this.f833e.clear();
            g();
            this.i = 0;
            scrollTo(0, 0);
        }
        ac acVar2 = this.h;
        this.h = acVar;
        this.f832b = 0;
        if (this.h != null) {
            if (this.o == null) {
                this.o = new h();
            }
            this.h.c(this.o);
            this.z = false;
            boolean z = this.T;
            this.T = true;
            this.f832b = this.h.b();
            if (this.j >= 0) {
                this.h.a(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (z) {
                requestLayout();
            } else {
                c();
            }
        }
        if (this.ad == null || acVar2 == acVar) {
            return;
        }
        this.ad.a(acVar2, acVar);
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.af == null) {
                try {
                    this.af = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            try {
                this.af.invoke(this, Boolean.valueOf(z));
            } catch (Exception e3) {
                Log.e("ViewPager", "Error changing children drawing order", e3);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.z = false;
        a(i2, !this.T, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.A) {
            this.A = i2;
            c();
        }
    }

    void setOnAdapterChangeListener(e eVar) {
        this.ad = eVar;
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.ab = fVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.p;
        this.p = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }
}
