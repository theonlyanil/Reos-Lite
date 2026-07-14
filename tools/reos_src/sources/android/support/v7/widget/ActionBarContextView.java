package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ba;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private boolean p;
    private int q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ap apVarA = ap.a(context, attributeSet, android.support.v7.b.a.k.ActionMode, i, 0);
        setBackgroundDrawable(apVarA.a(android.support.v7.b.a.k.ActionMode_background));
        this.n = apVarA.g(android.support.v7.b.a.k.ActionMode_titleTextStyle, 0);
        this.o = apVarA.g(android.support.v7.b.a.k.ActionMode_subtitleTextStyle, 0);
        this.f1683e = apVarA.f(android.support.v7.b.a.k.ActionMode_height, 0);
        this.q = apVarA.g(android.support.v7.b.a.k.ActionMode_closeItemLayout, android.support.v7.b.a.h.abc_action_mode_close_item_material);
        apVarA.a();
    }

    private void e() {
        if (this.k == null) {
            LayoutInflater.from(getContext()).inflate(android.support.v7.b.a.h.abc_action_bar_title_item, this);
            this.k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.l = (TextView) this.k.findViewById(android.support.v7.b.a.f.action_bar_title);
            this.m = (TextView) this.k.findViewById(android.support.v7.b.a.f.action_bar_subtitle);
            if (this.n != 0) {
                this.l.setTextAppearance(getContext(), this.n);
            }
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
        }
        this.l.setText(this.g);
        this.m.setText(this.h);
        boolean z = !TextUtils.isEmpty(this.g);
        boolean z2 = TextUtils.isEmpty(this.h) ? false : true;
        this.m.setVisibility(z2 ? 0 : 8);
        this.k.setVisibility((z || z2) ? 0 : 8);
        if (this.k.getParent() == null) {
            addView(this.k);
        }
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ ba a(int i, long j) {
        return super.a(i, j);
    }

    public void a(final android.support.v7.view.b bVar) {
        if (this.i == null) {
            this.i = LayoutInflater.from(getContext()).inflate(this.q, (ViewGroup) this, false);
            addView(this.i);
        } else if (this.i.getParent() == null) {
            addView(this.i);
        }
        this.i.findViewById(android.support.v7.b.a.f.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bVar.c();
            }
        });
        android.support.v7.view.menu.f fVar = (android.support.v7.view.menu.f) bVar.b();
        if (this.f1682d != null) {
            this.f1682d.h();
        }
        this.f1682d = new ActionMenuPresenter(getContext());
        this.f1682d.c(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        fVar.a(this.f1682d, this.f1680b);
        this.f1681c = (ActionMenuView) this.f1682d.a(this);
        this.f1681c.setBackgroundDrawable(null);
        addView(this.f1681c, layoutParams);
    }

    @Override // android.support.v7.widget.a
    public boolean a() {
        if (this.f1682d != null) {
            return this.f1682d.f();
        }
        return false;
    }

    public void b() {
        if (this.i == null) {
            c();
        }
    }

    public void c() {
        removeAllViews();
        this.j = null;
        this.f1681c = null;
    }

    public boolean d() {
        return this.p;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1682d != null) {
            this.f1682d.g();
            this.f1682d.i();
        }
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            if (accessibilityEvent.getEventType() != 32) {
                super.onInitializeAccessibilityEvent(accessibilityEvent);
                return;
            }
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.g);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iA;
        boolean zA = at.a(this);
        int paddingRight = zA ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.i == null || this.i.getVisibility() == 8) {
            iA = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int i5 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iA2 = a(paddingRight, i5, zA);
            iA = a(a(this.i, iA2, paddingTop, paddingTop2, zA) + iA2, i6, zA);
        }
        if (this.k != null && this.j == null && this.k.getVisibility() != 8) {
            iA += a(this.k, iA, paddingTop, paddingTop2, zA);
        }
        if (this.j != null) {
            int iA3 = a(this.j, iA, paddingTop, paddingTop2, zA) + iA;
        }
        int paddingLeft = zA ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f1681c != null) {
            int iA4 = a(this.f1681c, paddingLeft, paddingTop, paddingTop2, !zA) + paddingLeft;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f1683e > 0 ? this.f1683e : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i4 = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        if (this.i != null) {
            int iA = a(this.i, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
        }
        if (this.f1681c != null && this.f1681c.getParent() == this) {
            paddingLeft = a(this.f1681c, paddingLeft, iMakeMeasureSpec, 0);
        }
        if (this.k != null && this.j == null) {
            if (this.p) {
                this.k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.k.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.k.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = a(this.k, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        if (this.j != null) {
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            int i5 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            this.j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i4) : i4, layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824));
        }
        if (this.f1683e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (i3 < childCount) {
            int measuredHeight = getChildAt(i3).getMeasuredHeight() + paddingTop;
            if (measuredHeight <= i6) {
                measuredHeight = i6;
            }
            i3++;
            i6 = measuredHeight;
        }
        setMeasuredDimension(size, i6);
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.a
    public void setContentHeight(int i) {
        this.f1683e = i;
    }

    public void setCustomView(View view) {
        if (this.j != null) {
            removeView(this.j);
        }
        this.j = view;
        if (view != null && this.k != null) {
            removeView(this.k);
            this.k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.h = charSequence;
        e();
    }

    public void setTitle(CharSequence charSequence) {
        this.g = charSequence;
        e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.p) {
            requestLayout();
        }
        this.p = z;
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
