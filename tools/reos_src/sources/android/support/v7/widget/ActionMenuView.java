package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements android.support.v7.view.menu.f.b, android.support.v7.view.menu.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.support.v7.view.menu.f f1337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ActionMenuPresenter f1341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.support.v7.view.menu.l.a f1342f;
    private android.support.v7.view.menu.f.a g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private e l;

    public interface a {
        boolean c();

        boolean d();
    }

    private class b implements android.support.v7.view.menu.l.a {
        private b() {
        }

        @Override // android.support.v7.view.menu.l.a
        public void a(android.support.v7.view.menu.f fVar, boolean z) {
        }

        @Override // android.support.v7.view.menu.l.a
        public boolean a(android.support.v7.view.menu.f fVar) {
            return false;
        }
    }

    public static class c extends LinearLayoutCompat.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1347d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1348e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1349f;

        public c(int i, int i2) {
            super(i, i2);
            this.f1344a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(c cVar) {
            super(cVar);
            this.f1344a = cVar.f1344a;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class d implements android.support.v7.view.menu.f.a {
        private d() {
        }

        @Override // android.support.v7.view.menu.f.a
        public void a(android.support.v7.view.menu.f fVar) {
            if (ActionMenuView.this.g != null) {
                ActionMenuView.this.g.a(fVar);
            }
        }

        @Override // android.support.v7.view.menu.f.a
        public boolean a(android.support.v7.view.menu.f fVar, MenuItem menuItem) {
            return ActionMenuView.this.l != null && ActionMenuView.this.l.a(menuItem);
        }
    }

    public interface e {
        boolean a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.j = (int) (56.0f * f2);
        this.k = (int) (f2 * 4.0f);
        this.f1338b = context;
        this.f1339c = 0;
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.a();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && i5 < 2) {
                i5 = 2;
            }
        }
        if (!cVar.f1344a && z2) {
            z = true;
        }
        cVar.f1347d = z;
        cVar.f1345b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Code duplicated, block: B:142:0x0304 A[PHI: r7
      0x0304: PHI (r7v9 float) = (r7v8 float), (r7v17 float), (r7v17 float) binds: [B:72:0x0189, B:79:0x01b2, B:81:0x01c4] A[DONT_GENERATE, DONT_INLINE]] */
    private void c(int i, int i2) {
        long j;
        boolean z;
        float f2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i10 = size - paddingLeft;
        int i11 = i10 / this.j;
        int i12 = i10 % this.j;
        if (i11 == 0) {
            setMeasuredDimension(i10, 0);
            return;
        }
        int i13 = this.j + (i12 / i11);
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z3 = false;
        long j3 = 0;
        int childCount = getChildCount();
        int i18 = 0;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() == 8) {
                i6 = i17;
                j2 = j3;
                i8 = i14;
                i9 = i11;
                i7 = i15;
            } else {
                boolean z4 = childAt instanceof ActionMenuItemView;
                int i19 = i17 + 1;
                if (z4) {
                    childAt.setPadding(this.k, 0, this.k, 0);
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f1349f = false;
                cVar.f1346c = 0;
                cVar.f1345b = 0;
                cVar.f1347d = false;
                cVar.leftMargin = 0;
                cVar.rightMargin = 0;
                cVar.f1348e = z4 && ((ActionMenuItemView) childAt).a();
                int iA = a(childAt, i13, cVar.f1344a ? 1 : i11, childMeasureSpec, paddingTop);
                int iMax = Math.max(i15, iA);
                int i20 = cVar.f1347d ? i16 + 1 : i16;
                boolean z5 = cVar.f1344a ? true : z3;
                int i21 = i11 - iA;
                int iMax2 = Math.max(i14, childAt.getMeasuredHeight());
                if (iA == 1) {
                    long j4 = ((long) (1 << i18)) | j3;
                    i8 = iMax2;
                    i9 = i21;
                    i16 = i20;
                    z3 = z5;
                    j2 = j4;
                    i7 = iMax;
                    i6 = i19;
                } else {
                    i6 = i19;
                    i7 = iMax;
                    long j5 = j3;
                    i8 = iMax2;
                    i9 = i21;
                    z3 = z5;
                    i16 = i20;
                    j2 = j5;
                }
            }
            i18++;
            i15 = i7;
            i14 = i8;
            i11 = i9;
            j3 = j2;
            i17 = i6;
        }
        boolean z6 = z3 && i17 == 2;
        boolean z7 = false;
        long j6 = j3;
        int i22 = i11;
        while (true) {
            if (i16 <= 0 || i22 <= 0) {
                j = j6;
                break;
            }
            int i23 = Integer.MAX_VALUE;
            long j7 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i25 < childCount) {
                c cVar2 = (c) getChildAt(i25).getLayoutParams();
                if (!cVar2.f1347d) {
                    i4 = i24;
                    i5 = i23;
                } else if (cVar2.f1345b < i23) {
                    i5 = cVar2.f1345b;
                    j7 = 1 << i25;
                    i4 = 1;
                } else if (cVar2.f1345b == i23) {
                    j7 |= (long) (1 << i25);
                    i4 = i24 + 1;
                    i5 = i23;
                } else {
                    i4 = i24;
                    i5 = i23;
                }
                i25++;
                i23 = i5;
                i24 = i4;
            }
            long j8 = j6 | j7;
            if (i24 > i22) {
                j = j8;
                break;
            }
            int i26 = i23 + 1;
            int i27 = 0;
            int i28 = i22;
            long j9 = j8;
            while (i27 < childCount) {
                View childAt2 = getChildAt(i27);
                c cVar3 = (c) childAt2.getLayoutParams();
                if ((((long) (1 << i27)) & j7) != 0) {
                    if (z6 && cVar3.f1348e && i28 == 1) {
                        childAt2.setPadding(this.k + i13, 0, this.k, 0);
                    }
                    cVar3.f1345b++;
                    cVar3.f1349f = true;
                    i3 = i28 - 1;
                } else if (cVar3.f1345b == i26) {
                    j9 |= (long) (1 << i27);
                    i3 = i28;
                } else {
                    i3 = i28;
                }
                i27++;
                i28 = i3;
            }
            j6 = j9;
            z7 = true;
            i22 = i28;
        }
        boolean z8 = !z3 && i17 == 1;
        if (i22 <= 0 || j == 0 || (i22 >= i17 - 1 && !z8 && i15 <= 1)) {
            z = z7;
        } else {
            float fBitCount = Long.bitCount(j);
            if (z8) {
                f2 = fBitCount;
            } else {
                if ((1 & j) != 0 && !((c) getChildAt(0).getLayoutParams()).f1348e) {
                    fBitCount -= 0.5f;
                }
                if ((((long) (1 << (childCount - 1))) & j) == 0 || ((c) getChildAt(childCount - 1).getLayoutParams()).f1348e) {
                    f2 = fBitCount;
                } else {
                    f2 = fBitCount - 0.5f;
                }
            }
            int i29 = f2 > BitmapDescriptorFactory.HUE_RED ? (int) ((i22 * i13) / f2) : 0;
            int i30 = 0;
            z = z7;
            while (i30 < childCount) {
                if ((((long) (1 << i30)) & j) == 0) {
                    z2 = z;
                } else {
                    View childAt3 = getChildAt(i30);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1346c = i29;
                        cVar4.f1349f = true;
                        if (i30 == 0 && !cVar4.f1348e) {
                            cVar4.leftMargin = (-i29) / 2;
                        }
                        z2 = true;
                    } else if (cVar4.f1344a) {
                        cVar4.f1346c = i29;
                        cVar4.f1349f = true;
                        cVar4.rightMargin = (-i29) / 2;
                        z2 = true;
                    } else {
                        if (i30 != 0) {
                            cVar4.leftMargin = i29 / 2;
                        }
                        if (i30 != childCount - 1) {
                            cVar4.rightMargin = i29 / 2;
                        }
                        z2 = z;
                    }
                }
                i30++;
                z = z2;
            }
        }
        if (z) {
            int i31 = 0;
            while (true) {
                int i32 = i31;
                if (i32 >= childCount) {
                    break;
                }
                View childAt4 = getChildAt(i32);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f1349f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec(cVar5.f1346c + (cVar5.f1345b * i13), 1073741824), childMeasureSpec);
                }
                i31 = i32 + 1;
            }
        }
        if (mode == 1073741824) {
            i14 = size2;
        }
        setMeasuredDimension(i10, i14);
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.h > 0) {
            return cVar;
        }
        cVar.h = 16;
        return cVar;
    }

    @Override // android.support.v7.view.menu.m
    public void a(android.support.v7.view.menu.f fVar) {
        this.f1337a = fVar;
    }

    public void a(android.support.v7.view.menu.l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        this.f1342f = aVar;
        this.g = aVar2;
    }

    public boolean a() {
        return this.f1340d;
    }

    protected boolean a(int i) {
        boolean zD = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            zD = false | ((a) childAt).d();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? zD : ((a) childAt2).c() | zD;
    }

    @Override // android.support.v7.view.menu.f.b
    public boolean a(android.support.v7.view.menu.h hVar) {
        return this.f1337a.a(hVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    public c c() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f1344a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public android.support.v7.view.menu.f d() {
        return this.f1337a;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        return this.f1341e != null && this.f1341e.f();
    }

    public boolean f() {
        return this.f1341e != null && this.f1341e.g();
    }

    public boolean g() {
        return this.f1341e != null && this.f1341e.j();
    }

    public Menu getMenu() {
        if (this.f1337a == null) {
            Context context = getContext();
            this.f1337a = new android.support.v7.view.menu.f(context);
            this.f1337a.a(new d());
            this.f1341e = new ActionMenuPresenter(context);
            this.f1341e.c(true);
            this.f1341e.a(this.f1342f != null ? this.f1342f : new b());
            this.f1337a.a(this.f1341e, this.f1338b);
            this.f1341e.a(this);
        }
        return this.f1337a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1341e.e();
    }

    public int getPopupTheme() {
        return this.f1339c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        return this.f1341e != null && this.f1341e.k();
    }

    public void i() {
        if (this.f1341e != null) {
            this.f1341e.h();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1341e != null) {
            this.f1341e.a(false);
            if (this.f1341e.j()) {
                this.f1341e.g();
                this.f1341e.f();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int width;
        int paddingLeft;
        if (!this.h) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = 0;
        int i12 = 0;
        int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
        boolean z3 = false;
        boolean zA = at.a(this);
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                z2 = z3;
                i8 = i12;
                i7 = paddingRight;
                i9 = i11;
            } else {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1344a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zA) {
                        paddingLeft = cVar.leftMargin + getPaddingLeft();
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i14 = i10 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i14, width, measuredHeight + i14);
                    i7 = paddingRight - measuredWidth;
                    z2 = true;
                    i8 = i12;
                    i9 = i11;
                } else {
                    int measuredWidth2 = childAt.getMeasuredWidth() + cVar.leftMargin + cVar.rightMargin;
                    int i15 = i11 + measuredWidth2;
                    int i16 = paddingRight - measuredWidth2;
                    if (a(i13)) {
                        i15 += dividerWidth;
                    }
                    boolean z4 = z3;
                    i7 = i16;
                    i8 = i12 + 1;
                    i9 = i15;
                    z2 = z4;
                }
            }
            i13++;
            i11 = i9;
            paddingRight = i7;
            i12 = i8;
            z3 = z2;
        }
        if (childCount == 1 && !z3) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = ((i3 - i) / 2) - (measuredWidth3 / 2);
            int i18 = i10 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth3 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i12 - (z3 ? 0 : 1);
        int iMax = Math.max(0, i19 > 0 ? paddingRight / i19 : 0);
        if (zA) {
            int width2 = getWidth() - getPaddingRight();
            int i20 = 0;
            while (i20 < childCount) {
                View childAt3 = getChildAt(i20);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    i6 = width2;
                } else if (cVar2.f1344a) {
                    i6 = width2;
                } else {
                    int i21 = width2 - cVar2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i22 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i21 - measuredWidth4, i22, i21, measuredHeight3 + i22);
                    i6 = i21 - ((cVar2.leftMargin + measuredWidth4) + iMax);
                }
                i20++;
                width2 = i6;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        int i23 = 0;
        while (i23 < childCount) {
            View childAt4 = getChildAt(i23);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() == 8) {
                i5 = paddingLeft2;
            } else if (cVar3.f1344a) {
                i5 = paddingLeft2;
            } else {
                int i24 = paddingLeft2 + cVar3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i25 = i10 - (measuredHeight4 / 2);
                childAt4.layout(i24, i25, i24 + measuredWidth5, measuredHeight4 + i25);
                i5 = cVar3.rightMargin + measuredWidth5 + iMax + i24;
            }
            i23++;
            paddingLeft2 = i5;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = this.h;
        this.h = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.h) {
            this.i = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.h && this.f1337a != null && size != this.i) {
            this.i = size;
            this.f1337a.a(true);
        }
        int childCount = getChildCount();
        if (this.h && childCount > 0) {
            c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            cVar.rightMargin = 0;
            cVar.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1341e.d(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.l = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1341e.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f1340d = z;
    }

    public void setPopupTheme(int i) {
        if (this.f1339c != i) {
            this.f1339c = i;
            if (i == 0) {
                this.f1338b = getContext();
            } else {
                this.f1338b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1341e = actionMenuPresenter;
        this.f1341e.a(this);
    }
}
