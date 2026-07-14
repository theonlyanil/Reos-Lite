package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements android.support.v4.view.z, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f1316a = {android.support.v7.b.a.C0029a.actionBarSize, R.attr.windowContentOverlay};
    private final Runnable A;
    private final android.support.v4.view.aa B;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ContentFrameLayout f1319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ActionBarContainer f1320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u f1321f;
    private Drawable g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private a u;
    private final int v;
    private android.support.v4.widget.w w;
    private ba x;
    private final be y;
    private final Runnable z;

    public interface a {
        void b(int i);

        void h(boolean z);

        void m();

        void n();

        void o();

        void p();
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1318c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.v = 600;
        this.y = new bf() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.support.v4.view.bf, android.support.v4.view.be
            public void b(View view) {
                ActionBarOverlayLayout.this.x = null;
                ActionBarOverlayLayout.this.l = false;
            }

            @Override // android.support.v4.view.bf, android.support.v4.view.be
            public void c(View view) {
                ActionBarOverlayLayout.this.x = null;
                ActionBarOverlayLayout.this.l = false;
            }
        };
        this.z = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.k();
                ActionBarOverlayLayout.this.x = android.support.v4.view.ah.s(ActionBarOverlayLayout.this.f1320e).c(BitmapDescriptorFactory.HUE_RED).a(ActionBarOverlayLayout.this.y);
            }
        };
        this.A = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.k();
                ActionBarOverlayLayout.this.x = android.support.v4.view.ah.s(ActionBarOverlayLayout.this.f1320e).c(-ActionBarOverlayLayout.this.f1320e.getHeight()).a(ActionBarOverlayLayout.this.y);
            }
        };
        a(context);
        this.B = new android.support.v4.view.aa(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private u a(View view) {
        if (view instanceof u) {
            return (u) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1316a);
        this.f1317b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.g = typedArrayObtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.g == null);
        typedArrayObtainStyledAttributes.recycle();
        this.h = context.getApplicationInfo().targetSdkVersion < 19;
        this.w = android.support.v4.widget.w.a(context);
    }

    private boolean a(float f2, float f3) {
        this.w.a(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.w.e() > this.f1320e.getHeight();
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        b bVar = (b) view.getLayoutParams();
        if (z && bVar.leftMargin != rect.left) {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        if (this.x != null) {
            this.x.b();
        }
    }

    private void l() {
        k();
        postDelayed(this.z, 600L);
    }

    private void m() {
        k();
        postDelayed(this.A, 600L);
    }

    private void n() {
        k();
        this.z.run();
    }

    private void o() {
        k();
        this.A.run();
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.support.v7.widget.t
    public void a(int i) {
        c();
        switch (i) {
            case 2:
                this.f1321f.f();
                break;
            case 5:
                this.f1321f.g();
                break;
            case 109:
                setOverlayMode(true);
                break;
        }
    }

    @Override // android.support.v7.widget.t
    public void a(Menu menu, android.support.v7.view.menu.l.a aVar) {
        c();
        this.f1321f.a(menu, aVar);
    }

    public boolean a() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    void c() {
        if (this.f1319d == null) {
            this.f1319d = (ContentFrameLayout) findViewById(android.support.v7.b.a.f.action_bar_activity_content);
            this.f1320e = (ActionBarContainer) findViewById(android.support.v7.b.a.f.action_bar_container);
            this.f1321f = a(findViewById(android.support.v7.b.a.f.action_bar));
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.support.v7.widget.t
    public boolean d() {
        c();
        return this.f1321f.h();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g == null || this.h) {
            return;
        }
        int bottom = this.f1320e.getVisibility() == 0 ? (int) (this.f1320e.getBottom() + android.support.v4.view.ah.p(this.f1320e) + 0.5f) : 0;
        this.g.setBounds(0, bottom, getWidth(), this.g.getIntrinsicHeight() + bottom);
        this.g.draw(canvas);
    }

    @Override // android.support.v7.widget.t
    public boolean e() {
        c();
        return this.f1321f.i();
    }

    @Override // android.support.v7.widget.t
    public boolean f() {
        c();
        return this.f1321f.j();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        c();
        if ((android.support.v4.view.ah.u(this) & 256) != 0) {
        }
        boolean zA = a(this.f1320e, rect, true, true, false, true);
        this.r.set(rect);
        at.a(this, this.r, this.o);
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            zA = true;
        }
        if (zA) {
            requestLayout();
        }
        return true;
    }

    @Override // android.support.v7.widget.t
    public boolean g() {
        c();
        return this.f1321f.k();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public int getActionBarHideOffset() {
        if (this.f1320e != null) {
            return -((int) android.support.v4.view.ah.p(this.f1320e));
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        c();
        return this.f1321f.e();
    }

    @Override // android.support.v7.widget.t
    public boolean h() {
        c();
        return this.f1321f.l();
    }

    @Override // android.support.v7.widget.t
    public void i() {
        c();
        this.f1321f.m();
    }

    @Override // android.support.v7.widget.t
    public void j() {
        c();
        this.f1321f.n();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        android.support.v4.view.ah.v(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = bVar.leftMargin + paddingLeft;
                int i7 = bVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        c();
        measureChildWithMargins(this.f1320e, i, 0, i2, 0);
        b bVar = (b) this.f1320e.getLayoutParams();
        int iMax = Math.max(0, this.f1320e.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int iMax2 = Math.max(0, bVar.bottomMargin + this.f1320e.getMeasuredHeight() + bVar.topMargin);
        int iA = at.a(0, android.support.v4.view.ah.l(this.f1320e));
        boolean z = (android.support.v4.view.ah.u(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f1317b;
            if (this.j && this.f1320e.getTabContainer() != null) {
                measuredHeight += this.f1317b;
            }
        } else {
            measuredHeight = this.f1320e.getVisibility() != 8 ? this.f1320e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.s.set(this.r);
        if (this.i || z) {
            Rect rect = this.s;
            rect.top = measuredHeight + rect.top;
            this.s.bottom += 0;
        } else {
            Rect rect2 = this.q;
            rect2.top = measuredHeight + rect2.top;
            this.q.bottom += 0;
        }
        a(this.f1319d, this.q, true, true, true, true);
        if (!this.t.equals(this.s)) {
            this.t.set(this.s);
            this.f1319d.a(this.s);
        }
        measureChildWithMargins(this.f1319d, i, 0, i2, 0);
        b bVar2 = (b) this.f1319d.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1319d.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int iMax4 = Math.max(iMax2, bVar2.bottomMargin + this.f1319d.getMeasuredHeight() + bVar2.topMargin);
        int iA2 = at.a(iA, android.support.v4.view.ah.l(this.f1319d));
        setMeasuredDimension(android.support.v4.view.ah.a(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iA2), android.support.v4.view.ah.a(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iA2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (!this.k || !z) {
            return false;
        }
        if (a(f2, f3)) {
            o();
        } else {
            n();
        }
        this.l = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.m += i2;
        setActionBarHideOffset(this.m);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.B.a(view, view2, i);
        this.m = getActionBarHideOffset();
        k();
        if (this.u != null) {
            this.u.o();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1320e.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.f1320e.getHeight()) {
                l();
            } else {
                m();
            }
        }
        if (this.u != null) {
            this.u.p();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.n ^ i;
        this.n = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.u != null) {
            this.u.h(z2 ? false : true);
            if (z || !z2) {
                this.u.m();
            } else {
                this.u.n();
            }
        }
        if ((i2 & 256) == 0 || this.u == null) {
            return;
        }
        android.support.v4.view.ah.v(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1318c = i;
        if (this.u != null) {
            this.u.b(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        k();
        android.support.v4.view.ah.b(this.f1320e, -Math.max(0, Math.min(i, this.f1320e.getHeight())));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.u = aVar;
        if (getWindowToken() != null) {
            this.u.b(this.f1318c);
            if (this.n != 0) {
                onWindowSystemUiVisibilityChanged(this.n);
                android.support.v4.view.ah.v(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (z) {
                return;
            }
            k();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        c();
        this.f1321f.a(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.f1321f.a(drawable);
    }

    public void setLogo(int i) {
        c();
        this.f1321f.b(i);
    }

    public void setOverlayMode(boolean z) {
        this.i = z;
        this.h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.support.v7.widget.t
    public void setWindowCallback(Window.Callback callback) {
        c();
        this.f1321f.a(callback);
    }

    @Override // android.support.v7.widget.t
    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.f1321f.a(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
