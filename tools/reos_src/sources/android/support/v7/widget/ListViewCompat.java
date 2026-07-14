package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ListViewCompat extends ListView {
    private static final int[] g = {0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Rect f1504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f1509f;
    private Field h;
    private a i;

    private static class a extends android.support.v7.d.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1510a;

        public a(Drawable drawable) {
            super(drawable);
            this.f1510a = true;
        }

        void a(boolean z) {
            this.f1510a = z;
        }

        @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1510a) {
                super.draw(canvas);
            }
        }

        @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.f1510a) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1510a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1510a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // android.support.v7.d.a.a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1510a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public ListViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1504a = new Rect();
        this.f1505b = 0;
        this.f1506c = 0;
        this.f1507d = 0;
        this.f1508e = 0;
        try {
            this.h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.h.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        View view;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingBottom + listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i7 = 0;
        View view2 = null;
        int i8 = 0;
        int count = adapter.getCount();
        int i9 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            } else {
                view = view2;
            }
            view2 = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view2.setLayoutParams(layoutParams);
            }
            view2.measure(i, layoutParams.height > 0 ? View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view2.forceLayout();
            int measuredHeight = (i9 > 0 ? i6 + dividerHeight : i6) + view2.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i9 <= i5 || i7 <= 0 || measuredHeight == i4) ? i4 : i7;
            }
            if (i5 >= 0 && i9 >= i5) {
                i7 = measuredHeight;
            }
            i9++;
            i6 = measuredHeight;
        }
        return i6;
    }

    protected void a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        b(i, view);
        if (z) {
            Rect rect = this.f1504a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            android.support.v4.c.a.a.a(selector, fExactCenterX, fExactCenterY);
        }
    }

    protected void a(int i, View view, float f2, float f3) {
        a(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        android.support.v4.c.a.a.a(selector, f2, f3);
    }

    protected void a(Canvas canvas) {
        Drawable selector;
        if (this.f1504a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1504a);
        selector.draw(canvas);
    }

    protected boolean a() {
        return false;
    }

    protected void b() {
        Drawable selector = getSelector();
        if (selector == null || !c()) {
            return;
        }
        selector.setState(getDrawableState());
    }

    protected void b(int i, View view) {
        Rect rect = this.f1504a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1505b;
        rect.top -= this.f1506c;
        rect.right += this.f1507d;
        rect.bottom += this.f1508e;
        try {
            boolean z = this.h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    protected boolean c() {
        return a() && isPressed();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        b();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f1509f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.i = drawable != null ? new a(drawable) : null;
        super.setSelector(this.i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1505b = rect.left;
        this.f1506c = rect.top;
        this.f1507d = rect.right;
        this.f1508e = rect.bottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.i != null) {
            this.i.a(z);
        }
    }
}
