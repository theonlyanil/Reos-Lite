package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
class ak {
    private static final ThreadLocal<TypedValue> i = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f1734a = {-16842910};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f1735b = {R.attr.state_focused};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f1736c = {R.attr.state_activated};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f1737d = {R.attr.state_pressed};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f1738e = {R.attr.state_checked};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f1739f = {R.attr.state_selected};
    static final int[] g = {-16842919, -16842908};
    static final int[] h = new int[0];
    private static final int[] j = new int[1];

    public static int a(Context context, int i2) {
        j[0] = i2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, j);
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static int a(Context context, int i2, float f2) {
        int iA = a(context, i2);
        return android.support.v4.c.a.b(iA, Math.round(Color.alpha(iA) * f2));
    }

    private static TypedValue a() {
        TypedValue typedValue = i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        i.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList b(Context context, int i2) {
        j[0] = i2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, j);
        try {
            return typedArrayObtainStyledAttributes.getColorStateList(0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int c(Context context, int i2) {
        ColorStateList colorStateListB = b(context, i2);
        if (colorStateListB != null && colorStateListB.isStateful()) {
            return colorStateListB.getColorForState(f1734a, colorStateListB.getDefaultColor());
        }
        TypedValue typedValueA = a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueA, true);
        return a(context, i2, typedValueA.getFloat());
    }
}
