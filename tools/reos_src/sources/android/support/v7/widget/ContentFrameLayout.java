package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TypedValue f1435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TypedValue f1436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f1437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TypedValue f1438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f1439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TypedValue f1440f;
    private final Rect g;
    private a h;

    public interface a {
        void a();

        void b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Rect();
    }

    public void a(int i, int i2, int i3, int i4) {
        this.g.set(i, i2, i3, i4);
        if (android.support.v4.view.ah.D(this)) {
            requestLayout();
        }
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1439e == null) {
            this.f1439e = new TypedValue();
        }
        return this.f1439e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1440f == null) {
            this.f1440f = new TypedValue();
        }
        return this.f1440f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1437c == null) {
            this.f1437c = new TypedValue();
        }
        return this.f1437c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1438d == null) {
            this.f1438d = new TypedValue();
        }
        return this.f1438d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1435a == null) {
            this.f1435a = new TypedValue();
        }
        return this.f1435a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1436b == null) {
            this.f1436b = new TypedValue();
        }
        return this.f1436b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h != null) {
            this.h.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h != null) {
            this.h.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:62:0x0100  */
    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int iMakeMeasureSpec;
        int fraction;
        int fraction2;
        int fraction3;
        boolean z2 = false;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            z = false;
        } else {
            TypedValue typedValue = z3 ? this.f1438d : this.f1437c;
            if (typedValue == null || typedValue.type == 0) {
                z = false;
            } else {
                if (typedValue.type == 5) {
                    fraction3 = (int) typedValue.getDimension(displayMetrics);
                } else {
                    fraction3 = typedValue.type == 6 ? (int) typedValue.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels) : 0;
                }
                if (fraction3 > 0) {
                    i = View.MeasureSpec.makeMeasureSpec(Math.min(fraction3 - (this.g.left + this.g.right), View.MeasureSpec.getSize(i)), 1073741824);
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.f1439e : this.f1440f;
            if (typedValue2 != null && typedValue2.type != 0) {
                if (typedValue2.type == 5) {
                    fraction2 = (int) typedValue2.getDimension(displayMetrics);
                } else {
                    fraction2 = typedValue2.type == 6 ? (int) typedValue2.getFraction(displayMetrics.heightPixels, displayMetrics.heightPixels) : 0;
                }
                if (fraction2 > 0) {
                    i2 = View.MeasureSpec.makeMeasureSpec(Math.min(fraction2 - (this.g.top + this.g.bottom), View.MeasureSpec.getSize(i2)), 1073741824);
                }
            }
        }
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z || mode != Integer.MIN_VALUE) {
            iMakeMeasureSpec = iMakeMeasureSpec2;
        } else {
            TypedValue typedValue3 = z3 ? this.f1436b : this.f1435a;
            if (typedValue3 == null || typedValue3.type == 0) {
                iMakeMeasureSpec = iMakeMeasureSpec2;
            } else {
                if (typedValue3.type == 5) {
                    fraction = (int) typedValue3.getDimension(displayMetrics);
                } else {
                    fraction = typedValue3.type == 6 ? (int) typedValue3.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels) : 0;
                }
                if (fraction > 0) {
                    fraction -= this.g.left + this.g.right;
                }
                if (measuredWidth < fraction) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(fraction, 1073741824);
                    z2 = true;
                } else {
                    iMakeMeasureSpec = iMakeMeasureSpec2;
                }
            }
        }
        if (z2) {
            super.onMeasure(iMakeMeasureSpec, i2);
        }
    }

    public void setAttachListener(a aVar) {
        this.h = aVar;
    }
}
