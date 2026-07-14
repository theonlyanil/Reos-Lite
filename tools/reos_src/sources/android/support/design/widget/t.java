package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;

/* JADX INFO: loaded from: classes.dex */
class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f495a = {android.support.design.a.b.colorPrimary};

    static void a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f495a);
        boolean z = typedArrayObtainStyledAttributes.hasValue(0) ? false : true;
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
