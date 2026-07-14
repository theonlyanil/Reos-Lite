package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ah;
import android.support.v4.view.bh;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Toolbar f266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f269f;
    private int g;
    private int h;
    private int i;
    private final Rect j;
    private final d k;
    private boolean l;
    private boolean m;
    private Drawable n;
    private Drawable o;
    private int p;
    private boolean q;
    private u r;
    private AppBarLayout.b s;
    private int t;
    private bh u;

    public static class a extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f273b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f272a = 0;
            this.f273b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.CollapsingAppBarLayout_LayoutParams);
            this.f272a = typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
            a(typedArrayObtainStyledAttributes.getFloat(android.support.design.a.i.CollapsingAppBarLayout_LayoutParams_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f272a = 0;
            this.f273b = 0.5f;
        }

        public a(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f272a = 0;
            this.f273b = 0.5f;
        }

        public void a(float f2) {
            this.f273b = f2;
        }
    }

    private class b implements AppBarLayout.b {
        private b() {
        }

        @Override // android.support.design.widget.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout.this.t = i;
            int iB = CollapsingToolbarLayout.this.u != null ? CollapsingToolbarLayout.this.u.b() : 0;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                a aVar = (a) childAt.getLayoutParams();
                aa aaVarD = CollapsingToolbarLayout.d(childAt);
                switch (aVar.f272a) {
                    case 1:
                        if ((CollapsingToolbarLayout.this.getHeight() - iB) + i >= childAt.getHeight()) {
                            aaVarD.a(-i);
                        }
                        break;
                    case 2:
                        aaVarD.a(Math.round(aVar.f273b * (-i)));
                        break;
                }
            }
            if (CollapsingToolbarLayout.this.n != null || CollapsingToolbarLayout.this.o != null) {
                CollapsingToolbarLayout.this.setScrimsShown(CollapsingToolbarLayout.this.getHeight() + i < CollapsingToolbarLayout.this.getScrimTriggerOffset() + iB);
            }
            if (CollapsingToolbarLayout.this.o != null && iB > 0) {
                ah.d(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.k.b(Math.abs(i) / ((CollapsingToolbarLayout.this.getHeight() - ah.r(CollapsingToolbarLayout.this)) - iB));
            if (Math.abs(i) == totalScrollRange) {
                ah.d(appBarLayout, appBarLayout.getTargetElevation());
            } else {
                ah.d(appBarLayout, BitmapDescriptorFactory.HUE_RED);
            }
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f264a = true;
        this.j = new Rect();
        t.a(context);
        this.k = new d(this);
        this.k.a(android.support.design.widget.a.f408e);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.CollapsingToolbarLayout, i, android.support.design.a.h.Widget_Design_CollapsingToolbar);
        this.k.c(typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.k.d(typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f269f = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f269f = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.l = typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayObtainStyledAttributes.getText(android.support.design.a.i.CollapsingToolbarLayout_title));
        this.k.f(android.support.design.a.h.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.k.e(android.support.design.a.h.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.k.f(typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.k.e(typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(android.support.design.a.i.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(android.support.design.a.i.CollapsingToolbarLayout_statusBarScrim));
        this.f265b = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.CollapsingToolbarLayout_toolbarId, -1);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ah.a(this, new android.support.v4.view.ab() { // from class: android.support.design.widget.CollapsingToolbarLayout.1
            @Override // android.support.v4.view.ab
            public bh a(View view, bh bhVar) {
                return CollapsingToolbarLayout.this.a(bhVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bh a(bh bhVar) {
        if (this.u != bhVar) {
            this.u = bhVar;
            requestLayout();
        }
        return bhVar.f();
    }

    private void a(int i) {
        b();
        if (this.r == null) {
            this.r = ab.a();
            this.r.a(600);
            this.r.a(i > this.p ? android.support.design.widget.a.f406c : android.support.design.widget.a.f407d);
            this.r.a(new u.c() { // from class: android.support.design.widget.CollapsingToolbarLayout.2
                @Override // android.support.design.widget.u.c
                public void a(u uVar) {
                    CollapsingToolbarLayout.this.setScrimAlpha(uVar.c());
                }
            });
        } else if (this.r.b()) {
            this.r.e();
        }
        this.r.a(this.p, i);
        this.r.a();
    }

    private View b(View view) {
        View view2 = view;
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view2 = parent;
            }
        }
        return view2;
    }

    private void b() {
        Toolbar toolbar;
        if (this.f264a) {
            this.f266c = null;
            this.f267d = null;
            if (this.f265b != -1) {
                this.f266c = (Toolbar) findViewById(this.f265b);
                if (this.f266c != null) {
                    this.f267d = b(this.f266c);
                }
            }
            if (this.f266c == null) {
                int childCount = getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        toolbar = null;
                        break;
                    }
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i++;
                }
                this.f266c = toolbar;
            }
            c();
            this.f264a = false;
        }
    }

    private static int c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + view.getHeight() + marginLayoutParams.topMargin;
    }

    private void c() {
        if (!this.l && this.f268e != null) {
            ViewParent parent = this.f268e.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f268e);
            }
        }
        if (!this.l || this.f266c == null) {
            return;
        }
        if (this.f268e == null) {
            this.f268e = new View(getContext());
        }
        if (this.f268e.getParent() == null) {
            this.f266c.addView(this.f268e, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static aa d(View view) {
        aa aaVar = (aa) view.getTag(android.support.design.a.e.view_offset_helper);
        if (aaVar != null) {
            return aaVar;
        }
        aa aaVar2 = new aa(view);
        view.setTag(android.support.design.a.e.view_offset_helper, aaVar2);
        return aaVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrimAlpha(int i) {
        if (i != this.p) {
            if (this.n != null && this.f266c != null) {
                ah.d(this.f266c);
            }
            this.p = i;
            ah.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(super.generateDefaultLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public void a(boolean z, boolean z2) {
        if (this.q != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.q = z;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        b();
        if (this.f266c == null && this.n != null && this.p > 0) {
            this.n.mutate().setAlpha(this.p);
            this.n.draw(canvas);
        }
        if (this.l && this.m) {
            this.k.a(canvas);
        }
        if (this.o == null || this.p <= 0) {
            return;
        }
        int iB = this.u != null ? this.u.b() : 0;
        if (iB > 0) {
            this.o.setBounds(0, -this.t, getWidth(), iB - this.t);
            this.o.mutate().setAlpha(this.p);
            this.o.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        b();
        if (view == this.f266c && this.n != null && this.p > 0) {
            this.n.mutate().setAlpha(this.p);
            this.n.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean state = false;
        Drawable drawable = this.o;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.k.c();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.k.d();
    }

    public Drawable getContentScrim() {
        return this.n;
    }

    public int getExpandedTitleGravity() {
        return this.k.b();
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f269f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.k.e();
    }

    final int getScrimTriggerOffset() {
        return ah.r(this) * 2;
    }

    public Drawable getStatusBarScrim() {
        return this.o;
    }

    public CharSequence getTitle() {
        if (this.l) {
            return this.k.i();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.s == null) {
                this.s = new b();
            }
            ((AppBarLayout) parent).a(this.s);
        }
        ah.v(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.s != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(this.s);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iB;
        super.onLayout(z, i, i2, i3, i4);
        if (this.l && this.f268e != null) {
            this.m = ah.F(this.f268e) && this.f268e.getVisibility() == 0;
            if (this.m) {
                int i5 = (this.f267d == null || this.f267d == this) ? 0 : ((a) this.f267d.getLayoutParams()).bottomMargin;
                x.b(this, this.f268e, this.j);
                this.k.b(this.j.left, (i4 - this.j.height()) - i5, this.j.right, i4 - i5);
                boolean z2 = ah.h(this) == 1;
                this.k.a(z2 ? this.h : this.f269f, this.j.bottom + this.g, (i3 - i) - (z2 ? this.f269f : this.h), (i4 - i2) - this.i);
                this.k.h();
            }
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (this.u != null && !ah.w(childAt) && childAt.getTop() < (iB = this.u.b())) {
                ah.e(childAt, iB);
            }
            d(childAt).a();
        }
        if (this.f266c != null) {
            if (this.l && TextUtils.isEmpty(this.k.i())) {
                this.k.a(this.f266c.getTitle());
            }
            if (this.f267d == null || this.f267d == this) {
                setMinimumHeight(c(this.f266c));
            } else {
                setMinimumHeight(c(this.f267d));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        b();
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.n != null) {
            this.n.setBounds(0, 0, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.k.d(i);
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.k.e(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        this.k.a(i);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.k.a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        if (this.n != drawable) {
            if (this.n != null) {
                this.n.setCallback(null);
            }
            this.n = drawable != null ? drawable.mutate() : null;
            if (this.n != null) {
                this.n.setBounds(0, 0, getWidth(), getHeight());
                this.n.setCallback(this);
                this.n.setAlpha(this.p);
            }
            ah.d(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(android.support.v4.b.b.a(getContext(), i));
    }

    public void setExpandedTitleColor(int i) {
        this.k.b(i);
    }

    public void setExpandedTitleGravity(int i) {
        this.k.c(i);
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.i = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.h = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f269f = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.g = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.k.f(i);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.k.b(typeface);
    }

    public void setScrimsShown(boolean z) {
        a(z, ah.D(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        if (this.o != drawable) {
            if (this.o != null) {
                this.o.setCallback(null);
            }
            this.o = drawable != null ? drawable.mutate() : null;
            if (this.o != null) {
                if (this.o.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                android.support.v4.c.a.a.b(this.o, ah.h(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
                this.o.setAlpha(this.p);
            }
            ah.d(this);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(android.support.v4.b.b.a(getContext(), i));
    }

    public void setTitle(CharSequence charSequence) {
        this.k.a(charSequence);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            c();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.o != null && this.o.isVisible() != z) {
            this.o.setVisible(z, false);
        }
        if (this.n == null || this.n.isVisible() == z) {
            return;
        }
        this.n.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n || drawable == this.o;
    }
}
