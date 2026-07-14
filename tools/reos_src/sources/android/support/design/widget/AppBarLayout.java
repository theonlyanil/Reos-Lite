package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ah;
import android.support.v4.view.bh;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CoordinatorLayout.c(a = Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f238f;
    private bh g;
    private final List<b> h;

    public static class Behavior extends l<AppBarLayout> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private u f242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f243e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f244f;
        private float g;
        private WeakReference<View> h;
        private a i;

        protected static class SavedState extends View.BaseSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.f.d.a(new android.support.v4.f.e<SavedState>() { // from class: android.support.design.widget.AppBarLayout.Behavior.SavedState.1
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
            int f248a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            float f249b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            boolean f250c;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel);
                this.f248a = parcel.readInt();
                this.f249b = parcel.readFloat();
                this.f250c = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f248a);
                parcel.writeFloat(this.f249b);
                parcel.writeByte((byte) (this.f250c ? 1 : 0));
            }
        }

        public static abstract class a {
            public abstract boolean a(AppBarLayout appBarLayout);
        }

        public Behavior() {
            this.f243e = -1;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f243e = -1;
        }

        private int a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        private int b(AppBarLayout appBarLayout, int i) {
            int topInset;
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                a aVar = (a) childAt.getLayoutParams();
                Interpolator interpolatorB = aVar.b();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorB == null) {
                        return i;
                    }
                    int iA = aVar.a();
                    if ((iA & 1) != 0) {
                        topInset = aVar.bottomMargin + childAt.getHeight() + aVar.topMargin + 0;
                        if ((iA & 2) != 0) {
                            topInset -= ah.r(childAt);
                        }
                    } else {
                        topInset = 0;
                    }
                    if (ah.w(childAt)) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if (topInset <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(interpolatorB.getInterpolation((iAbs - childAt.getTop()) / topInset) * topInset) + childAt.getTop());
                }
            }
            return i;
        }

        private void b(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
            int iA = a();
            if (iA == i) {
                if (this.f242d == null || !this.f242d.b()) {
                    return;
                }
                this.f242d.e();
                return;
            }
            if (this.f242d == null) {
                this.f242d = ab.a();
                this.f242d.a(android.support.design.widget.a.f408e);
                this.f242d.a(new u.c() { // from class: android.support.design.widget.AppBarLayout.Behavior.1
                    @Override // android.support.design.widget.u.c
                    public void a(u uVar) {
                        Behavior.this.a_(coordinatorLayout, appBarLayout, uVar.c());
                    }
                });
            } else {
                this.f242d.e();
            }
            this.f242d.a(Math.round(((Math.abs(iA - i) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
            this.f242d.a(iA, i);
            this.f242d.a();
        }

        private void c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int iR;
            int iA = a();
            int iA2 = a(appBarLayout, iA);
            if (iA2 >= 0) {
                View childAt = appBarLayout.getChildAt(iA2);
                int iA3 = ((a) childAt.getLayoutParams()).a();
                if ((iA3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int iR2 = -childAt.getBottom();
                    if (iA2 == appBarLayout.getChildCount() - 1) {
                        iR2 += appBarLayout.getTopInset();
                    }
                    if (a(iA3, 2)) {
                        iR2 += ah.r(childAt);
                        iR = i;
                    } else if (a(iA3, 5)) {
                        iR = ah.r(childAt) + iR2;
                        if (iA >= iR) {
                            iR2 = iR;
                            iR = i;
                        }
                    } else {
                        iR = i;
                    }
                    if (iA >= (iR2 + iR) / 2) {
                        iR2 = iR;
                    }
                    b(coordinatorLayout, appBarLayout, n.a(iR2, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        private void d(AppBarLayout appBarLayout) {
            List list = appBarLayout.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) list.get(i);
                if (bVar != null) {
                    bVar.a(appBarLayout, b());
                }
            }
        }

        @Override // android.support.design.widget.l
        int a() {
            return b() + this.f239a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.l
        public int a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int iA = a();
            if (i2 == 0 || iA < i2 || iA > i3) {
                this.f239a = 0;
                return 0;
            }
            int iA2 = n.a(i, i2, i3);
            if (iA == iA2) {
                return 0;
            }
            int iB = appBarLayout.c() ? b(appBarLayout, iA2) : iA2;
            boolean zA = a(iB);
            int i4 = iA - iA2;
            this.f239a = iA2 - iB;
            if (!zA && appBarLayout.c()) {
                coordinatorLayout.c(appBarLayout);
            }
            d(appBarLayout);
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.l
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            c(coordinatorLayout, appBarLayout);
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (!(parcelable instanceof SavedState)) {
                super.a(coordinatorLayout, appBarLayout, parcelable);
                this.f243e = -1;
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.a(coordinatorLayout, appBarLayout, savedState.getSuperState());
            this.f243e = savedState.f248a;
            this.g = savedState.f249b;
            this.f244f = savedState.f250c;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f241c) {
                c(coordinatorLayout, appBarLayout);
            }
            this.f240b = false;
            this.f241c = false;
            this.h = new WeakReference<>(view);
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 >= 0) {
                this.f240b = false;
            } else {
                b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f240b = true;
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            int i3;
            int downNestedPreScrollRange;
            if (i2 == 0 || this.f240b) {
                return;
            }
            if (i2 < 0) {
                i3 = -appBarLayout.getTotalScrollRange();
                downNestedPreScrollRange = i3 + appBarLayout.getDownNestedPreScrollRange();
            } else {
                i3 = -appBarLayout.getUpNestedPreScrollRange();
                downNestedPreScrollRange = 0;
            }
            iArr[1] = b(coordinatorLayout, appBarLayout, i2, i3, downNestedPreScrollRange);
        }

        @Override // android.support.design.widget.z
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean c(AppBarLayout appBarLayout) {
            if (this.i != null) {
                return this.i.a(appBarLayout);
            }
            if (this.h == null) {
                return true;
            }
            View view = this.h.get();
            return (view == null || !view.isShown() || ah.b(view, -1)) ? false : true;
        }

        @Override // android.support.design.widget.z, android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean zA = super.a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i2 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        b(coordinatorLayout, appBarLayout, i2);
                    } else {
                        a_(coordinatorLayout, appBarLayout, i2);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        b(coordinatorLayout, appBarLayout, 0);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f243e >= 0) {
                View childAt = appBarLayout.getChildAt(this.f243e);
                int i3 = -childAt.getBottom();
                a(this.f244f ? ah.r(childAt) + i3 : Math.round(childAt.getHeight() * this.g) + i3);
            }
            appBarLayout.e();
            this.f243e = -1;
            a(n.a(b(), -appBarLayout.getTotalScrollRange(), 0));
            d(appBarLayout);
            return zA;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.e) appBarLayout.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.a(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f2, float f3, boolean z) {
            boolean zA = false;
            if (!z) {
                zA = a(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f3);
            } else if (f3 < BitmapDescriptorFactory.HUE_RED) {
                int downNestedPreScrollRange = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (a() < downNestedPreScrollRange) {
                    b(coordinatorLayout, appBarLayout, downNestedPreScrollRange);
                    zA = true;
                }
            } else {
                int i = -appBarLayout.getUpNestedPreScrollRange();
                if (a() > i) {
                    b(coordinatorLayout, appBarLayout, i);
                    zA = true;
                }
            }
            this.f241c = zA;
            return zA;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.d() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f242d != null) {
                this.f242d.e();
            }
            this.h = null;
            return z;
        }

        @Override // android.support.design.widget.z
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.l
        public int b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable parcelableB = super.b(coordinatorLayout, appBarLayout);
            int iB = b();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + iB;
                if (childAt.getTop() + iB <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(parcelableB);
                    savedState.f248a = i;
                    savedState.f250c = bottom == ah.r(childAt);
                    savedState.f249b = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return parcelableB;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }
    }

    public static class ScrollingViewBehavior extends m {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.ScrollingViewBehavior_Params);
            b(typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.b bVarB = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).b();
            if (bVarB instanceof Behavior) {
                return ((Behavior) bVarB).a();
            }
            return 0;
        }

        private void e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.b bVarB = ((CoordinatorLayout.e) view2.getLayoutParams()).b();
            if (bVarB instanceof Behavior) {
                Behavior behavior = (Behavior) bVarB;
                behavior.a();
                ah.e(view, ((behavior.f239a + (view2.getBottom() - view.getTop())) + a()) - c(view2));
            }
        }

        @Override // android.support.design.widget.m
        float a(View view) {
            int i;
            if (!(view instanceof AppBarLayout)) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            int iA = a(appBarLayout);
            return ((downNestedPreScrollRange == 0 || totalScrollRange + iA > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) ? 1.0f + (iA / i) : BitmapDescriptorFactory.HUE_RED;
        }

        @Override // android.support.design.widget.m
        View a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        @Override // android.support.design.widget.z
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // android.support.design.widget.z, android.support.design.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, view, i);
        }

        @Override // android.support.design.widget.m, android.support.design.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.z
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        @Override // android.support.design.widget.m
        int b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.b(view);
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            e(coordinatorLayout, view, view2);
            return false;
        }
    }

    public static class a extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Interpolator f252b;

        public a(int i, int i2) {
            super(i, i2);
            this.f251a = 1;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f251a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.AppBarLayout_LayoutParams);
            this.f251a = typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
                this.f252b = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f251a = 1;
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f251a = 1;
        }

        public a(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f251a = 1;
        }

        public int a() {
            return this.f251a;
        }

        public Interpolator b() {
            return this.f252b;
        }
    }

    public interface b {
        void a(AppBarLayout appBarLayout, int i);
    }

    private void b() {
        this.f234b = -1;
        this.f235c = -1;
        this.f236d = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f233a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return getTotalScrollRange() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f238f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDownNestedPreScrollRange() {
        int iR;
        if (this.f235c != -1) {
            return this.f235c;
        }
        int childCount = getChildCount() - 1;
        int i = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = aVar.f251a;
            if ((i2 & 5) == 5) {
                int i3 = aVar.bottomMargin + aVar.topMargin + i;
                if ((i2 & 8) != 0) {
                    iR = i3 + ah.r(childAt);
                } else {
                    iR = (i2 & 2) != 0 ? i3 + (measuredHeight - ah.r(childAt)) : i3 + measuredHeight;
                }
            } else {
                if (i > 0) {
                    break;
                }
                iR = i;
            }
            childCount--;
            i = iR;
        }
        int iMax = Math.max(0, i - getTopInset());
        this.f235c = iMax;
        return iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDownNestedScrollRange() {
        int iR;
        if (this.f236d != -1) {
            return this.f236d;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + aVar.topMargin + aVar.bottomMargin;
            int i3 = aVar.f251a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += measuredHeight;
            if ((i3 & 2) != 0) {
                iR = i - (ah.r(childAt) + getTopInset());
            }
            int iMax = Math.max(0, iR);
            this.f236d = iMax;
            return iMax;
        }
        iR = i;
        int iMax2 = Math.max(0, iR);
        this.f236d = iMax2;
        return iMax2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPendingAction() {
        return this.f238f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTopInset() {
        if (this.g != null) {
            return this.g.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new a((LinearLayout.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    public void a(b bVar) {
        if (bVar == null || this.h.contains(bVar)) {
            return;
        }
        this.h.add(bVar);
    }

    public void a(boolean z, boolean z2) {
        this.f238f = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.h.remove(bVar);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iR = ah.r(this);
        if (iR != 0) {
            return topInset + (iR * 2);
        }
        int childCount = getChildCount();
        if (childCount >= 1) {
            return topInset + (ah.r(getChildAt(childCount - 1)) * 2);
        }
        return 0;
    }

    public float getTargetElevation() {
        return this.f237e;
    }

    public final int getTotalScrollRange() {
        int iR;
        if (this.f234b != -1) {
            return this.f234b;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = aVar.f251a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += aVar.bottomMargin + measuredHeight + aVar.topMargin;
            if ((i3 & 2) != 0) {
                iR = i - ah.r(childAt);
            }
            int iMax = Math.max(0, iR - getTopInset());
            this.f234b = iMax;
            return iMax;
        }
        iR = i;
        int iMax2 = Math.max(0, iR - getTopInset());
        this.f234b = iMax2;
        return iMax2;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        b();
        this.f233a = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((a) getChildAt(i5).getLayoutParams()).b() != null) {
                this.f233a = true;
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        b();
    }

    public void setExpanded(boolean z) {
        a(z, ah.D(this));
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setTargetElevation(float f2) {
        this.f237e = f2;
    }
}
