package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1426b;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1426b = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.ButtonBarLayout);
        this.f1425a = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.ButtonBarLayout_allowStacking, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean a() {
        return getOrientation() == 1;
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View viewFindViewById = findViewById(android.support.v7.b.a.f.spacer);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        boolean z2 = false;
        int size = View.MeasureSpec.getSize(i);
        if (this.f1425a) {
            if (size > this.f1426b && a()) {
                setStacked(false);
            }
            this.f1426b = size;
        }
        if (a() || View.MeasureSpec.getMode(i) != 1073741824) {
            iMakeMeasureSpec = i;
            z = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        if (this.f1425a && !a()) {
            if (Build.VERSION.SDK_INT < 11) {
                int childCount = getChildCount();
                int measuredWidth = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    measuredWidth += getChildAt(i3).getMeasuredWidth();
                }
                if (getPaddingLeft() + measuredWidth + getPaddingRight() > size) {
                    z2 = true;
                }
            } else if ((android.support.v4.view.ah.k(this) & (-16777216)) == 16777216) {
                z2 = true;
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f1425a != z) {
            this.f1425a = z;
            if (!this.f1425a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
