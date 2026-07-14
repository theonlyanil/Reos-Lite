package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f209f;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f207d = new Rect();
        this.f208e = new Rect();
        this.f209f = 119;
        this.f204a = true;
        this.f205b = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.ForegroundLinearLayout, i, 0);
        this.f209f = typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.ForegroundLinearLayout_android_foregroundGravity, this.f209f);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(android.support.design.a.i.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f204a = typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f206c != null) {
            Drawable drawable = this.f206c;
            if (this.f205b) {
                this.f205b = false;
                Rect rect = this.f207d;
                Rect rect2 = this.f208e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f204a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f209f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        if (this.f206c != null) {
            this.f206c.setHotspot(f2, f3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f206c == null || !this.f206c.isStateful()) {
            return;
        }
        this.f206c.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f206c;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f209f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f206c != null) {
            this.f206c.jumpToCurrentState();
        }
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f205b |= z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f205b = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        if (this.f206c != drawable) {
            if (this.f206c != null) {
                this.f206c.setCallback(null);
                unscheduleDrawable(this.f206c);
            }
            this.f206c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f209f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.f209f != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f209f = i2;
            if (this.f209f == 119 && this.f206c != null) {
                this.f206c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f206c;
    }
}
