package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final f f972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f977f;
    private boolean g;
    private View h;
    private float i;
    private float j;
    private int k;
    private boolean l;
    private int m;
    private float n;
    private float o;
    private e p;
    private final af q;
    private boolean r;
    private boolean s;
    private final Rect t;
    private final ArrayList<b> u;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v4.widget.SlidingPaneLayout.SavedState.1
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
        boolean f978a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f978a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f978a ? 1 : 0);
        }
    }

    class a extends android.support.v4.view.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Rect f980c = new Rect();

        a() {
        }

        private void a(android.support.v4.view.a.c cVar, android.support.v4.view.a.c cVar2) {
            Rect rect = this.f980c;
            cVar2.a(rect);
            cVar.b(rect);
            cVar2.c(rect);
            cVar.d(rect);
            cVar.c(cVar2.h());
            cVar.a(cVar2.p());
            cVar.b(cVar2.q());
            cVar.d(cVar2.s());
            cVar.h(cVar2.m());
            cVar.f(cVar2.k());
            cVar.a(cVar2.f());
            cVar.b(cVar2.g());
            cVar.d(cVar2.i());
            cVar.e(cVar2.j());
            cVar.g(cVar2.l());
            cVar.a(cVar2.b());
            cVar.b(cVar2.c());
        }

        @Override // android.support.v4.view.a
        public void a(View view, android.support.v4.view.a.c cVar) {
            android.support.v4.view.a.c cVarA = android.support.v4.view.a.c.a(cVar);
            super.a(view, cVarA);
            a(cVar, cVarA);
            cVarA.t();
            cVar.b((CharSequence) SlidingPaneLayout.class.getName());
            cVar.a(view);
            Object objI = ah.i(view);
            if (objI instanceof View) {
                cVar.c((View) objI);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!b(childAt) && childAt.getVisibility() == 0) {
                    ah.c(childAt, 1);
                    cVar.b(childAt);
                }
            }
        }

        @Override // android.support.v4.view.a
        public void a(View view, AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // android.support.v4.view.a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (b(view)) {
                return false;
            }
            return super.a(viewGroup, view, accessibilityEvent);
        }

        public boolean b(View view) {
            return SlidingPaneLayout.this.e(view);
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f981a;

        b(View view) {
            this.f981a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f981a.getParent() == SlidingPaneLayout.this) {
                ah.a(this.f981a, 0, (Paint) null);
                SlidingPaneLayout.this.g(this.f981a);
            }
            SlidingPaneLayout.this.u.remove(this);
        }
    }

    private class c extends af.a {
        private c() {
        }

        @Override // android.support.v4.widget.af.a
        public int a(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.af.a
        public void a(int i) {
            if (SlidingPaneLayout.this.q.a() == 0) {
                if (SlidingPaneLayout.this.i != BitmapDescriptorFactory.HUE_RED) {
                    SlidingPaneLayout.this.b(SlidingPaneLayout.this.h);
                    SlidingPaneLayout.this.r = true;
                } else {
                    SlidingPaneLayout.this.d(SlidingPaneLayout.this.h);
                    SlidingPaneLayout.this.c(SlidingPaneLayout.this.h);
                    SlidingPaneLayout.this.r = false;
                }
            }
        }

        @Override // android.support.v4.widget.af.a
        public void a(View view, float f2, float f3) {
            int paddingLeft;
            d dVar = (d) view.getLayoutParams();
            if (SlidingPaneLayout.this.f()) {
                int paddingRight = dVar.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f2 < BitmapDescriptorFactory.HUE_RED || (f2 == BitmapDescriptorFactory.HUE_RED && SlidingPaneLayout.this.i > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.k;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.h.getWidth();
            } else {
                paddingLeft = dVar.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f2 > BitmapDescriptorFactory.HUE_RED || (f2 == BitmapDescriptorFactory.HUE_RED && SlidingPaneLayout.this.i > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.k;
                }
            }
            SlidingPaneLayout.this.q.a(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.af.a
        public void a(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.a(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.af.a
        public boolean a(View view, int i) {
            if (SlidingPaneLayout.this.l) {
                return false;
            }
            return ((d) view.getLayoutParams()).f986b;
        }

        @Override // android.support.v4.widget.af.a
        public int b(View view) {
            return SlidingPaneLayout.this.k;
        }

        @Override // android.support.v4.widget.af.a
        public int b(View view, int i, int i2) {
            d dVar = (d) SlidingPaneLayout.this.h.getLayoutParams();
            if (!SlidingPaneLayout.this.f()) {
                int paddingLeft = dVar.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.k + paddingLeft);
            }
            int width = SlidingPaneLayout.this.getWidth() - ((dVar.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.h.getWidth());
            return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.k);
        }

        @Override // android.support.v4.widget.af.a
        public void b(int i, int i2) {
            SlidingPaneLayout.this.q.a(SlidingPaneLayout.this.h, i2);
        }

        @Override // android.support.v4.widget.af.a
        public void b(View view, int i) {
            SlidingPaneLayout.this.a();
        }
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int[] f984e = {R.attr.layout_weight};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f988d;

        public d() {
            super(-1, -1);
            this.f985a = BitmapDescriptorFactory.HUE_RED;
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f985a = BitmapDescriptorFactory.HUE_RED;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f984e);
            this.f985a = typedArrayObtainStyledAttributes.getFloat(0, BitmapDescriptorFactory.HUE_RED);
            typedArrayObtainStyledAttributes.recycle();
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f985a = BitmapDescriptorFactory.HUE_RED;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f985a = BitmapDescriptorFactory.HUE_RED;
        }
    }

    public interface e {
        void a(View view);

        void a(View view, float f2);

        void b(View view);
    }

    interface f {
        void a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static class g implements f {
        g() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view) {
            ah.a(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class h extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Field f990b;

        h() {
            try {
                this.f989a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e2);
            }
            try {
                this.f990b = View.class.getDeclaredField("mRecreateDisplayList");
                this.f990b.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e3);
            }
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.g, android.support.v4.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.f989a == null || this.f990b == null) {
                view.invalidate();
                return;
            }
            try {
                this.f990b.setBoolean(view, true);
                this.f989a.invoke(view, (Object[]) null);
            } catch (Exception e2) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e2);
            }
            super.a(slidingPaneLayout, view);
        }
    }

    static class i extends g {
        i() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.g, android.support.v4.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view) {
            ah.a(view, ((d) view.getLayoutParams()).f988d);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            f972a = new i();
        } else if (i2 >= 16) {
            f972a = new h();
        } else {
            f972a = new g();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f973b = -858993460;
        this.s = true;
        this.t = new Rect();
        this.u = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f977f = (int) ((32.0f * f2) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        ah.a(this, new a());
        ah.c((View) this, 1);
        this.q = af.a(this, 0.5f, new c());
        this.q.a(f2 * 400.0f);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    private void a(float f2) {
        boolean z;
        boolean zF = f();
        d dVar = (d) this.h.getLayoutParams();
        if (!dVar.f987c) {
            z = false;
        } else if ((zF ? dVar.rightMargin : dVar.leftMargin) <= 0) {
            z = true;
        } else {
            z = false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != this.h) {
                int i3 = (int) ((1.0f - this.j) * this.m);
                this.j = f2;
                int i4 = i3 - ((int) ((1.0f - f2) * this.m));
                if (zF) {
                    i4 = -i4;
                }
                childAt.offsetLeftAndRight(i4);
                if (z) {
                    a(childAt, zF ? this.j - 1.0f : 1.0f - this.j, this.f974c);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (this.h == null) {
            this.i = BitmapDescriptorFactory.HUE_RED;
            return;
        }
        boolean zF = f();
        d dVar = (d) this.h.getLayoutParams();
        int width = this.h.getWidth();
        if (zF) {
            i2 = (getWidth() - i2) - width;
        }
        this.i = (i2 - ((zF ? dVar.rightMargin : dVar.leftMargin) + (zF ? getPaddingRight() : getPaddingLeft()))) / this.k;
        if (this.m != 0) {
            a(this.i);
        }
        if (dVar.f987c) {
            a(this.h, this.i, this.f973b);
        }
        a(this.h);
    }

    private void a(View view, float f2, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (f2 <= BitmapDescriptorFactory.HUE_RED || i2 == 0) {
            if (ah.g(view) != 0) {
                if (dVar.f988d != null) {
                    dVar.f988d.setColorFilter(null);
                }
                b bVar = new b(view);
                this.u.add(bVar);
                ah.a(this, bVar);
                return;
            }
            return;
        }
        int i3 = (((int) ((((-16777216) & i2) >>> 24) * f2)) << 24) | (16777215 & i2);
        if (dVar.f988d == null) {
            dVar.f988d = new Paint();
        }
        dVar.f988d.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
        if (ah.g(view) != 2) {
            ah.a(view, 2, dVar.f988d);
        }
        g(view);
    }

    private boolean a(View view, int i2) {
        if (!this.s && !a(BitmapDescriptorFactory.HUE_RED, i2)) {
            return false;
        }
        this.r = false;
        return true;
    }

    private boolean b(View view, int i2) {
        if (!this.s && !a(1.0f, i2)) {
            return false;
        }
        this.r = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return ah.h(this) == 1;
    }

    private static boolean f(View view) {
        Drawable background;
        if (ah.j(view)) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view) {
        f972a.a(this, view);
    }

    void a() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    void a(View view) {
        if (this.p != null) {
            this.p.a(view, this.i);
        }
    }

    boolean a(float f2, int i2) {
        int paddingLeft;
        if (!this.g) {
            return false;
        }
        boolean zF = f();
        d dVar = (d) this.h.getLayoutParams();
        if (zF) {
            paddingLeft = (int) (getWidth() - (((dVar.rightMargin + getPaddingRight()) + (this.k * f2)) + this.h.getWidth()));
        } else {
            paddingLeft = (int) (dVar.leftMargin + getPaddingLeft() + (this.k * f2));
        }
        if (!this.q.a(this.h, paddingLeft, this.h.getTop())) {
            return false;
        }
        a();
        ah.d(this);
        return true;
    }

    void b(View view) {
        if (this.p != null) {
            this.p.a(view);
        }
        sendAccessibilityEvent(32);
    }

    public boolean b() {
        return b(this.h, 0);
    }

    void c(View view) {
        if (this.p != null) {
            this.p.b(view);
        }
        sendAccessibilityEvent(32);
    }

    public boolean c() {
        return a(this.h, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.q.a(true)) {
            if (this.g) {
                ah.d(this);
            } else {
                this.q.f();
            }
        }
    }

    void d(View view) {
        int bottom;
        int top;
        int right;
        int left;
        boolean zF = f();
        int width = zF ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zF ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view == null || !f(view)) {
            bottom = 0;
            top = 0;
            right = 0;
            left = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt == view) {
                return;
            }
            childAt.setVisibility((Math.max(zF ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zF ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
        }
    }

    public boolean d() {
        return !this.g || this.i == 1.0f;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int left;
        int right;
        super.draw(canvas);
        Drawable drawable = f() ? this.f976e : this.f975d;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (f()) {
            right = childAt.getRight();
            left = right + intrinsicWidth;
        } else {
            left = childAt.getLeft();
            right = left - intrinsicWidth;
        }
        drawable.setBounds(right, top, left, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild;
        d dVar = (d) view.getLayoutParams();
        int iSave = canvas.save(2);
        if (this.g && !dVar.f986b && this.h != null) {
            canvas.getClipBounds(this.t);
            if (f()) {
                this.t.left = Math.max(this.t.left, this.h.getRight());
            } else {
                this.t.right = Math.min(this.t.right, this.h.getLeft());
            }
            canvas.clipRect(this.t);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            zDrawChild = super.drawChild(canvas, view, j);
        } else if (!dVar.f987c || this.i <= BitmapDescriptorFactory.HUE_RED) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            zDrawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, view.getLeft(), view.getTop(), dVar.f988d);
                zDrawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                zDrawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    public boolean e() {
        return this.g;
    }

    boolean e(View view) {
        if (view == null) {
            return false;
        }
        return this.g && ((d) view.getLayoutParams()).f987c && this.i > BitmapDescriptorFactory.HUE_RED;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f974c;
    }

    public int getParallaxDistance() {
        return this.m;
    }

    public int getSliderFadeColor() {
        return this.f973b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.u.get(i2).run();
        }
        this.u.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int iA = android.support.v4.view.t.a(motionEvent);
        if (!this.g && iA == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.r = !this.q.b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.g || (this.l && iA != 0)) {
            this.q.e();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (iA == 3 || iA == 1) {
            this.q.e();
            return false;
        }
        switch (iA) {
            case 0:
                this.l = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.n = x;
                this.o = y;
                z = this.q.b(this.h, (int) x, (int) y) && e(this.h);
                break;
            case 1:
            default:
                z = false;
                break;
            case 2:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float fAbs = Math.abs(x2 - this.n);
                float fAbs2 = Math.abs(y2 - this.o);
                if (fAbs > this.q.d() && fAbs2 > fAbs) {
                    this.q.e();
                    this.l = true;
                    return false;
                }
                z = false;
                break;
                break;
        }
        return this.q.a(motionEvent) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int width;
        int i10;
        boolean zF = f();
        if (zF) {
            this.q.a(2);
        } else {
            this.q.a(1);
        }
        int i11 = i4 - i2;
        int paddingRight = zF ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zF ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.s) {
            this.i = (this.g && this.r) ? 1.0f : BitmapDescriptorFactory.HUE_RED;
        }
        int i12 = 0;
        int i13 = paddingRight;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                width = paddingRight;
                i10 = i13;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (dVar.f986b) {
                    int iMin = (Math.min(paddingRight, (i11 - paddingLeft) - this.f977f) - i13) - (dVar.leftMargin + dVar.rightMargin);
                    this.k = iMin;
                    int i14 = zF ? dVar.rightMargin : dVar.leftMargin;
                    dVar.f987c = ((i13 + i14) + iMin) + (measuredWidth / 2) > i11 - paddingLeft;
                    int i15 = (int) (iMin * this.i);
                    i7 = i13 + i14 + i15;
                    this.i = i15 / this.k;
                    i6 = 0;
                } else if (!this.g || this.m == 0) {
                    i6 = 0;
                    i7 = paddingRight;
                } else {
                    i6 = (int) ((1.0f - this.i) * this.m);
                    i7 = paddingRight;
                }
                if (zF) {
                    i9 = (i11 - i7) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i7 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                width = childAt.getWidth() + paddingRight;
                i10 = i7;
            }
            i12++;
            paddingRight = width;
            i13 = i10;
        }
        if (this.s) {
            if (this.g) {
                if (this.m != 0) {
                    a(this.i);
                }
                if (((d) this.h.getLayoutParams()).f987c) {
                    a(this.h, this.i, this.f973b);
                }
            } else {
                for (int i16 = 0; i16 < childCount; i16++) {
                    a(getChildAt(i16), BitmapDescriptorFactory.HUE_RED, this.f973b);
                }
            }
            d(this.h);
        }
        this.s = false;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x026d  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d3 A[PHI: r3
      0x00d3: PHI (r3v12 float) = (r3v11 float), (r3v14 float) binds: [B:35:0x00c5, B:37:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:41:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:51:0x0109  */
    /* JADX WARN: Code duplicated, block: B:54:0x0111  */
    /* JADX WARN: Code duplicated, block: B:56:0x011e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0123  */
    /* JADX WARN: Code duplicated, block: B:59:0x012c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0135  */
    /* JADX WARN: Code duplicated, block: B:62:0x013a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0141  */
    /* JADX WARN: Code duplicated, block: B:64:0x014a  */
    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int paddingTop;
        int paddingTop2;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int i7;
        int iMakeMeasureSpec3;
        int iMakeMeasureSpec4;
        int measuredHeight;
        int i8;
        boolean z;
        int i9;
        int i10;
        boolean z2;
        float f2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                i4 = mode2;
                i5 = 300;
                i6 = size2;
            } else {
                i4 = mode2;
                i5 = size;
                i6 = size2;
            }
        } else if (mode2 != 0) {
            i4 = mode2;
            i5 = size;
            i6 = size2;
        } else {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                i4 = Integer.MIN_VALUE;
                i5 = size;
                i6 = 300;
            } else {
                i4 = mode2;
                i5 = size;
                i6 = size2;
            }
        }
        switch (i4) {
            case Integer.MIN_VALUE:
                paddingTop = 0;
                paddingTop2 = (i6 - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                paddingTop = (i6 - getPaddingTop()) - getPaddingBottom();
                paddingTop2 = paddingTop;
                break;
            default:
                paddingTop = 0;
                paddingTop2 = -1;
                break;
        }
        boolean z3 = false;
        int paddingLeft = (i5 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.h = null;
        int i11 = 0;
        int i12 = paddingLeft;
        int iMin = paddingTop;
        float f3 = 0.0f;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            d dVar = (d) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                dVar.f987c = false;
                i9 = i12;
                f2 = f3;
                i10 = iMin;
                z2 = z3;
            } else if (dVar.f985a > BitmapDescriptorFactory.HUE_RED) {
                f3 += dVar.f985a;
                if (dVar.width == 0) {
                    i9 = i12;
                    f2 = f3;
                    i10 = iMin;
                    z2 = z3;
                } else {
                    i7 = dVar.leftMargin + dVar.rightMargin;
                    if (dVar.width == -2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i7, Integer.MIN_VALUE);
                    } else if (dVar.width == -1) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i7, 1073741824);
                    } else {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(dVar.width, 1073741824);
                    }
                    if (dVar.height == -2) {
                        iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop2, Integer.MIN_VALUE);
                    } else if (dVar.height == -1) {
                        iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop2, 1073741824);
                    } else {
                        iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(dVar.height, 1073741824);
                    }
                    childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                    int measuredWidth = childAt.getMeasuredWidth();
                    measuredHeight = childAt.getMeasuredHeight();
                    if (i4 == Integer.MIN_VALUE && measuredHeight > iMin) {
                        iMin = Math.min(measuredHeight, paddingTop2);
                    }
                    i8 = i12 - measuredWidth;
                    if (i8 < 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    dVar.f986b = z;
                    boolean z4 = z | z3;
                    if (dVar.f986b) {
                        this.h = childAt;
                    }
                    i9 = i8;
                    i10 = iMin;
                    float f4 = f3;
                    z2 = z4;
                    f2 = f4;
                }
            } else {
                i7 = dVar.leftMargin + dVar.rightMargin;
                if (dVar.width == -2) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i7, Integer.MIN_VALUE);
                } else if (dVar.width == -1) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i7, 1073741824);
                } else {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(dVar.width, 1073741824);
                }
                if (dVar.height == -2) {
                    iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop2, Integer.MIN_VALUE);
                } else if (dVar.height == -1) {
                    iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop2, 1073741824);
                } else {
                    iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(dVar.height, 1073741824);
                }
                childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                int measuredWidth2 = childAt.getMeasuredWidth();
                measuredHeight = childAt.getMeasuredHeight();
                if (i4 == Integer.MIN_VALUE) {
                    iMin = Math.min(measuredHeight, paddingTop2);
                }
                i8 = i12 - measuredWidth2;
                if (i8 < 0) {
                    z = true;
                } else {
                    z = false;
                }
                dVar.f986b = z;
                boolean z5 = z | z3;
                if (dVar.f986b) {
                    this.h = childAt;
                }
                i9 = i8;
                i10 = iMin;
                float f5 = f3;
                z2 = z5;
                f2 = f5;
            }
            i11++;
            z3 = z2;
            iMin = i10;
            f3 = f2;
            i12 = i9;
        }
        if (z3 || f3 > BitmapDescriptorFactory.HUE_RED) {
            int i13 = paddingLeft - this.f977f;
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt2 = getChildAt(i14);
                if (childAt2.getVisibility() != 8) {
                    d dVar2 = (d) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        boolean z6 = dVar2.width == 0 && dVar2.f985a > BitmapDescriptorFactory.HUE_RED;
                        int measuredWidth3 = z6 ? 0 : childAt2.getMeasuredWidth();
                        if (!z3 || childAt2 == this.h) {
                            if (dVar2.f985a > BitmapDescriptorFactory.HUE_RED) {
                                if (dVar2.width != 0) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (dVar2.height == -2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop2, Integer.MIN_VALUE);
                                } else {
                                    iMakeMeasureSpec = dVar2.height == -1 ? View.MeasureSpec.makeMeasureSpec(paddingTop2, 1073741824) : View.MeasureSpec.makeMeasureSpec(dVar2.height, 1073741824);
                                }
                                if (z3) {
                                    int i15 = paddingLeft - (dVar2.rightMargin + dVar2.leftMargin);
                                    int iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                    if (measuredWidth3 != i15) {
                                        childAt2.measure(iMakeMeasureSpec5, iMakeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(((int) ((dVar2.f985a * Math.max(0, i12)) / f3)) + measuredWidth3, 1073741824), iMakeMeasureSpec);
                                }
                            }
                        } else if (dVar2.width < 0 && (measuredWidth3 > i13 || dVar2.f985a > BitmapDescriptorFactory.HUE_RED)) {
                            if (!z6) {
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (dVar2.height == -2) {
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop2, Integer.MIN_VALUE);
                            } else {
                                iMakeMeasureSpec2 = dVar2.height == -1 ? View.MeasureSpec.makeMeasureSpec(paddingTop2, 1073741824) : View.MeasureSpec.makeMeasureSpec(dVar2.height, 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), iMakeMeasureSpec2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i5, getPaddingTop() + iMin + getPaddingBottom());
        this.g = z3;
        if (this.q.a() == 0 || z3) {
            return;
        }
        this.q.f();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f978a) {
            b();
        } else {
            c();
        }
        this.r = savedState.f978a;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f978a = e() ? d() : this.r;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.s = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.g) {
            return super.onTouchEvent(motionEvent);
        }
        this.q.b(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.n = x;
                this.o = y;
                return true;
            case 1:
                if (!e(this.h)) {
                    return true;
                }
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f2 = x2 - this.n;
                float f3 = y2 - this.o;
                int iD = this.q.d();
                if ((f2 * f2) + (f3 * f3) >= iD * iD || !this.q.b(this.h, (int) x2, (int) y2)) {
                    return true;
                }
                a(this.h, 0);
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.g) {
            return;
        }
        this.r = view == this.h;
    }

    public void setCoveredFadeColor(int i2) {
        this.f974c = i2;
    }

    public void setPanelSlideListener(e eVar) {
        this.p = eVar;
    }

    public void setParallaxDistance(int i2) {
        this.m = i2;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f975d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f976e = drawable;
    }

    @Deprecated
    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(getResources().getDrawable(i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(getResources().getDrawable(i2));
    }

    public void setSliderFadeColor(int i2) {
        this.f973b = i2;
    }
}
