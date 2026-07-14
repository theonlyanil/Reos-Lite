package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Drawable f1308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable f1309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Drawable f1310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f1311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f1312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1313f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(Build.VERSION.SDK_INT >= 21 ? new c(this) : new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.ActionBar);
        this.f1308a = typedArrayObtainStyledAttributes.getDrawable(android.support.v7.b.a.k.ActionBar_background);
        this.f1309b = typedArrayObtainStyledAttributes.getDrawable(android.support.v7.b.a.k.ActionBar_backgroundStacked);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.b.a.k.ActionBar_height, -1);
        if (getId() == android.support.v7.b.a.f.split_action_bar) {
            this.f1311d = true;
            this.f1310c = typedArrayObtainStyledAttributes.getDrawable(android.support.v7.b.a.k.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(this.f1311d ? this.f1310c == null : this.f1308a == null && this.f1309b == null);
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1308a != null && this.f1308a.isStateful()) {
            this.f1308a.setState(getDrawableState());
        }
        if (this.f1309b != null && this.f1309b.isStateful()) {
            this.f1309b.setState(getDrawableState());
        }
        if (this.f1310c == null || !this.f1310c.isStateful()) {
            return;
        }
        this.f1310c.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1308a != null) {
                this.f1308a.jumpToCurrentState();
            }
            if (this.f1309b != null) {
                this.f1309b.jumpToCurrentState();
            }
            if (this.f1310c != null) {
                this.f1310c.jumpToCurrentState();
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(android.support.v7.b.a.f.action_bar);
        this.i = findViewById(android.support.v7.b.a.f.action_context_bar);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1313f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.g;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1311d) {
            if (this.f1308a != null) {
                if (this.h.getVisibility() == 0) {
                    this.f1308a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                } else if (this.i == null || this.i.getVisibility() != 0) {
                    this.f1308a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1308a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.f1312e = z4;
            if (!z4 || this.f1309b == null) {
                z3 = z2;
            } else {
                this.f1309b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1310c != null) {
            this.f1310c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z3 = false;
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iB;
        if (this.h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.j, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.h == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (this.g == null || this.g.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (a(this.h)) {
            iB = !a(this.i) ? b(this.i) : 0;
        } else {
            iB = b(this.h);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iB + b(this.g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1308a != null) {
            this.f1308a.setCallback(null);
            unscheduleDrawable(this.f1308a);
        }
        this.f1308a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.h != null) {
                this.f1308a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        if (this.f1311d) {
            if (this.f1310c != null) {
                z = false;
            }
        } else if (this.f1308a != null || this.f1309b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1310c != null) {
            this.f1310c.setCallback(null);
            unscheduleDrawable(this.f1310c);
        }
        this.f1310c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1311d && this.f1310c != null) {
                this.f1310c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1311d) {
            if (this.f1310c != null) {
                z = false;
            }
        } else if (this.f1308a != null || this.f1309b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1309b != null) {
            this.f1309b.setCallback(null);
            unscheduleDrawable(this.f1309b);
        }
        this.f1309b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1312e && this.f1309b != null) {
                this.f1309b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        if (this.f1311d) {
            if (this.f1310c != null) {
                z = false;
            }
        } else if (this.f1308a != null || this.f1309b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ah ahVar) {
        if (this.g != null) {
            removeView(this.g);
        }
        this.g = ahVar;
        if (ahVar != null) {
            addView(ahVar);
            ViewGroup.LayoutParams layoutParams = ahVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            ahVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1313f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1308a != null) {
            this.f1308a.setVisible(z, false);
        }
        if (this.f1309b != null) {
            this.f1309b.setVisible(z, false);
        }
        if (this.f1310c != null) {
            this.f1310c.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1308a && !this.f1311d) || (drawable == this.f1309b && this.f1312e) || ((drawable == this.f1310c && this.f1311d) || super.verifyDrawable(drawable));
    }
}
