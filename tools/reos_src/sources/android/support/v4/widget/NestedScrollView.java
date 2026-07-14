package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements android.support.v4.view.ad, android.support.v4.view.x, android.support.v4.view.z {
    private static final a v = new a();
    private static final int[] w = {R.attr.fillViewport};
    private b A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w f967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private j f968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j f969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f970f;
    private boolean g;
    private boolean h;
    private View i;
    private boolean j;
    private VelocityTracker k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private final int[] s;
    private int t;
    private SavedState u;
    private final android.support.v4.view.aa x;
    private final android.support.v4.view.y y;
    private float z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v4.widget.NestedScrollView.SavedState.1
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
        public int f971a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f971a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f971a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f971a);
        }
    }

    static class a extends android.support.v4.view.a {
        a() {
        }

        @Override // android.support.v4.view.a
        public void a(View view, android.support.v4.view.a.c cVar) {
            int scrollRange;
            super.a(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.b((CharSequence) ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            cVar.i(true);
            if (nestedScrollView.getScrollY() > 0) {
                cVar.a(8192);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                cVar.a(4096);
            }
        }

        @Override // android.support.v4.view.a
        public void a(View view, AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            android.support.v4.view.a.m mVarA = android.support.v4.view.a.a.a(accessibilityEvent);
            mVarA.a(nestedScrollView.getScrollRange() > 0);
            mVarA.d(nestedScrollView.getScrollX());
            mVarA.e(nestedScrollView.getScrollY());
            mVarA.f(nestedScrollView.getScrollX());
            mVarA.g(nestedScrollView.getScrollRange());
        }

        @Override // android.support.v4.view.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            switch (i) {
                case 4096:
                    int iMin = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (iMin == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.b(0, iMin);
                    return true;
                case 8192:
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.b(0, iMax);
                    return true;
                default:
                    return false;
            }
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f966b = new Rect();
        this.g = true;
        this.h = false;
        this.i = null;
        this.j = false;
        this.m = true;
        this.q = -1;
        this.r = new int[2];
        this.s = new int[2];
        a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w, i, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.x = new android.support.v4.view.aa(this);
        this.y = new android.support.v4.view.y(this);
        setNestedScrollingEnabled(true);
        ah.a(this, v);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    private View a(boolean z, int i, int i2) {
        boolean z2;
        View view;
        ArrayList focusables = getFocusables(2);
        View view2 = null;
        boolean z3 = false;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i >= bottom || top >= i2) {
                z2 = z3;
                view = view2;
            } else {
                boolean z4 = i < top && bottom < i2;
                if (view2 == null) {
                    boolean z5 = z4;
                    view = view3;
                    z2 = z5;
                } else {
                    boolean z6 = (z && top < view2.getTop()) || (!z && bottom > view2.getBottom());
                    if (z3) {
                        if (z4 && z6) {
                            view = view3;
                            z2 = z3;
                        } else {
                            z2 = z3;
                            view = view2;
                        }
                    } else if (z4) {
                        view = view3;
                        z2 = true;
                    } else if (z6) {
                        view = view3;
                        z2 = z3;
                    } else {
                        z2 = z3;
                        view = view2;
                    }
                }
            }
            i3++;
            view2 = view;
            z3 = z2;
        }
        return view2;
    }

    private void a() {
        this.f967c = w.a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (android.support.v4.view.t.b(motionEvent, action) == this.q) {
            int i = action == 0 ? 1 : 0;
            this.f970f = (int) android.support.v4.view.t.d(motionEvent, i);
            this.q = android.support.v4.view.t.b(motionEvent, i);
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    private boolean a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View viewA = a(z2, i2, i3);
        if (viewA == null) {
            viewA = this;
        }
        if (i2 < scrollY || i3 > i4) {
            e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (viewA != findFocus()) {
            viewA.requestFocus(i);
        }
        return z;
    }

    private boolean a(Rect rect, boolean z) {
        int iA = a(rect);
        boolean z2 = iA != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iA);
            } else {
                a(0, iA);
            }
        }
        return z2;
    }

    private boolean a(View view) {
        return !a(view, 0, getHeight());
    }

    private boolean a(View view, int i, int i2) {
        view.getDrawingRect(this.f966b);
        offsetDescendantRectToMyCoords(view, this.f966b);
        return this.f966b.bottom + i >= getScrollY() && this.f966b.top - i <= getScrollY() + i2;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    private static int b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    private void b(View view) {
        view.getDrawingRect(this.f966b);
        offsetDescendantRectToMyCoords(view, this.f966b);
        int iA = a(this.f966b);
        if (iA != 0) {
            scrollBy(0, iA);
        }
    }

    private boolean b() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        }
        return false;
    }

    private void c() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        } else {
            this.k.clear();
        }
    }

    private boolean c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void d() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private void e() {
        if (this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }

    private void e(int i) {
        if (i != 0) {
            if (this.m) {
                a(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    private void f() {
        this.j = false;
        e();
        stopNestedScroll();
        if (this.f968d != null) {
            this.f968d.c();
            this.f969e.c();
        }
    }

    private void f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (dispatchNestedPreFling(BitmapDescriptorFactory.HUE_RED, i)) {
            return;
        }
        dispatchNestedFling(BitmapDescriptorFactory.HUE_RED, i, z);
        if (z) {
            d(i);
        }
    }

    private void g() {
        if (ah.a(this) == 2) {
            this.f968d = null;
            this.f969e = null;
        } else if (this.f968d == null) {
            Context context = getContext();
            this.f968d = new j(context);
            this.f969e = new j(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.z == BitmapDescriptorFactory.HUE_RED) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.z;
    }

    protected int a(Rect rect) {
        int iMax;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            iMax = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            iMax = 0;
        } else {
            iMax = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return iMax;
    }

    public final void a(int i, int i2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f965a > 250) {
            int iMax = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            int scrollY = getScrollY();
            this.f967c.a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, iMax)) - scrollY);
            ah.d(this);
        } else {
            if (!this.f967c.a()) {
                this.f967c.h();
            }
            scrollBy(i, i2);
        }
        this.f965a = AnimationUtils.currentAnimationTimeMillis();
    }

    public boolean a(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f966b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f966b.top + height > childAt.getBottom()) {
                    this.f966b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f966b.top = getScrollY() - height;
            if (this.f966b.top < 0) {
                this.f966b.top = 0;
            }
        }
        this.f966b.bottom = this.f966b.top + height;
        return a(i, this.f966b.top, this.f966b.bottom);
    }

    boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int iA = ah.a(this);
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = iA == 0 || (iA == 1 && z4);
        boolean z7 = iA == 0 || (iA == 1 && z5);
        int i9 = i3 + i;
        if (!z6) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (!z7) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        int i13 = -i8;
        int i14 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i14) {
            z3 = true;
        } else if (i10 < i13) {
            z3 = true;
            i14 = i13;
        } else {
            z3 = false;
            i14 = i10;
        }
        if (z3) {
            this.f967c.a(i12, i14, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i14, z2, z3);
        return z2 || z3;
    }

    public boolean a(KeyEvent keyEvent) {
        this.f966b.setEmpty();
        if (b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    return !keyEvent.isAltPressed() ? c(33) : b(33);
                case 20:
                    return !keyEvent.isAltPressed() ? c(130) : b(130);
                case 62:
                    a(keyEvent.isShiftPressed() ? 33 : 130);
                    return false;
                default:
                    return false;
            }
        }
        if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
        return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void b(int i, int i2) {
        a(i - getScrollX(), i2 - getScrollY());
    }

    public boolean b(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        this.f966b.top = 0;
        this.f966b.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            this.f966b.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
            this.f966b.top = this.f966b.bottom - height;
        }
        return a(i, this.f966b.top, this.f966b.bottom);
    }

    public boolean c(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !a(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            e(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f966b);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f966b);
            e(a(this.f966b));
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && a(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f967c.g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int iB = this.f967c.b();
            int iC = this.f967c.c();
            if (scrollX == iB && scrollY == iC) {
                return;
            }
            int scrollRange = getScrollRange();
            int iA = ah.a(this);
            boolean z = iA == 0 || (iA == 1 && scrollRange > 0);
            a(iB - scrollX, iC - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
            if (z) {
                g();
                if (iC <= 0 && scrollY > 0) {
                    this.f968d.a((int) this.f967c.f());
                } else {
                    if (iC < scrollRange || scrollY >= scrollRange) {
                        return;
                    }
                    this.f969e.a((int) this.f967c.f());
                }
            }
        }
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, android.support.v4.view.ad
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    public void d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.f967c.a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - height), 0, height / 2);
            ah.d(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.y.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.y.a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.y.a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.y.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f968d != null) {
            int scrollY = getScrollY();
            if (!this.f968d.a()) {
                int iSave = canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), Math.min(0, scrollY));
                this.f968d.a(width, getHeight());
                if (this.f968d.a(canvas)) {
                    ah.d(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f969e.a()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = getHeight();
            canvas.translate((-width2) + getPaddingLeft(), Math.max(getScrollRange(), scrollY) + height);
            canvas.rotate(180.0f, width2, BitmapDescriptorFactory.HUE_RED);
            this.f969e.a(width2, height);
            if (this.f969e.a(canvas)) {
                ah.d(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * getHeight());
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.x.a();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.y.b();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.y.a();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.h = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((android.support.v4.view.t.d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.j) {
                    return false;
                }
                float fE = android.support.v4.view.t.e(motionEvent, 9);
                if (fE == BitmapDescriptorFactory.HUE_RED) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (fE * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    scrollRange = 0;
                } else if (i <= scrollRange) {
                    scrollRange = i;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int y = (int) motionEvent.getY();
                if (!c((int) motionEvent.getX(), y)) {
                    this.j = false;
                    e();
                } else {
                    this.f970f = y;
                    this.q = android.support.v4.view.t.b(motionEvent, 0);
                    c();
                    this.k.addMovement(motionEvent);
                    this.f967c.g();
                    this.j = this.f967c.a() ? false : true;
                    startNestedScroll(2);
                }
                break;
            case 1:
            case 3:
                this.j = false;
                this.q = -1;
                e();
                if (this.f967c.a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ah.d(this);
                }
                stopNestedScroll();
                break;
            case 2:
                int i = this.q;
                if (i != -1) {
                    int iA = android.support.v4.view.t.a(motionEvent, i);
                    if (iA != -1) {
                        int iD = (int) android.support.v4.view.t.d(motionEvent, iA);
                        if (Math.abs(iD - this.f970f) > this.n && (getNestedScrollAxes() & 2) == 0) {
                            this.j = true;
                            this.f970f = iD;
                            d();
                            this.k.addMovement(motionEvent);
                            this.t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    } else {
                        Log.e("NestedScrollView", "Invalid pointerId=" + i + " in onInterceptTouchEvent");
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        return this.j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.g = false;
        if (this.i != null && a(this.i, this)) {
            b(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.u != null) {
                scrollTo(getScrollX(), this.u.f971a);
                this.u = null;
            }
            int iMax = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > iMax) {
                scrollTo(getScrollX(), iMax);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.h = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (z) {
            return false;
        }
        f((int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.x.a(view, view2, i);
        startNestedScroll(2);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null || a(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.u = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f971a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.A != null) {
            this.A.a(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !a(viewFindFocus, 0, i4)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f966b);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f966b);
        e(a(this.f966b));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onStopNestedScroll(View view) {
        this.x.a(view);
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        ViewParent parent;
        d();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int iA = android.support.v4.view.t.a(motionEvent);
        if (iA == 0) {
            this.t = 0;
        }
        motionEventObtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, this.t);
        switch (iA) {
            case 0:
                if (getChildCount() == 0) {
                    return false;
                }
                boolean z = !this.f967c.a();
                this.j = z;
                if (z && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.f967c.a()) {
                    this.f967c.h();
                }
                this.f970f = (int) motionEvent.getY();
                this.q = android.support.v4.view.t.b(motionEvent, 0);
                startNestedScroll(2);
                break;
            case 1:
                if (this.j) {
                    VelocityTracker velocityTracker = this.k;
                    velocityTracker.computeCurrentVelocity(1000, this.p);
                    int iB = (int) android.support.v4.view.af.b(velocityTracker, this.q);
                    if (Math.abs(iB) > this.o) {
                        f(-iB);
                    } else if (this.f967c.a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ah.d(this);
                    }
                }
                this.q = -1;
                f();
                break;
            case 2:
                int iA2 = android.support.v4.view.t.a(motionEvent, this.q);
                if (iA2 != -1) {
                    int iD = (int) android.support.v4.view.t.d(motionEvent, iA2);
                    int i2 = this.f970f - iD;
                    if (dispatchNestedPreScroll(0, i2, this.s, this.r)) {
                        i2 -= this.s[1];
                        motionEventObtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, this.r[1]);
                        this.t += this.r[1];
                    }
                    if (this.j || Math.abs(i2) <= this.n) {
                        i = i2;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.j = true;
                        i = i2 > 0 ? i2 - this.n : i2 + this.n;
                    }
                    if (this.j) {
                        this.f970f = iD - this.r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int iA3 = ah.a(this);
                        boolean z2 = iA3 == 0 || (iA3 == 1 && scrollRange > 0);
                        if (a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.r)) {
                            this.f970f -= this.r[1];
                            motionEventObtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, this.r[1]);
                            this.t += this.r[1];
                        } else if (z2) {
                            g();
                            int i3 = scrollY + i;
                            if (i3 < 0) {
                                this.f968d.a(i / getHeight(), android.support.v4.view.t.c(motionEvent, iA2) / getWidth());
                                if (!this.f969e.a()) {
                                    this.f969e.c();
                                }
                            } else if (i3 > scrollRange) {
                                this.f969e.a(i / getHeight(), 1.0f - (android.support.v4.view.t.c(motionEvent, iA2) / getWidth()));
                                if (!this.f968d.a()) {
                                    this.f968d.c();
                                }
                            }
                            if (this.f968d != null && (!this.f968d.a() || !this.f969e.a())) {
                                ah.d(this);
                            }
                        }
                    }
                } else {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.q + " in onTouchEvent");
                }
                break;
            case 3:
                if (this.j && getChildCount() > 0 && this.f967c.a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ah.d(this);
                }
                this.q = -1;
                f();
                break;
            case 5:
                int iB2 = android.support.v4.view.t.b(motionEvent);
                this.f970f = (int) android.support.v4.view.t.d(motionEvent, iB2);
                this.q = android.support.v4.view.t.b(motionEvent, iB2);
                break;
            case 6:
                a(motionEvent);
                this.f970f = (int) android.support.v4.view.t.d(motionEvent, android.support.v4.view.t.a(motionEvent, this.q));
                break;
        }
        if (this.k != null) {
            this.k.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.g) {
            this.i = view2;
        } else {
            b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return a(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int iB = b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int iB2 = b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (iB == getScrollX() && iB2 == getScrollY()) {
                return;
            }
            super.scrollTo(iB, iB2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.l) {
            this.l = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.y.a(z);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.A = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.m = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.y.a(i);
    }

    @Override // android.view.View, android.support.v4.view.x
    public void stopNestedScroll() {
        this.y.c();
    }
}
