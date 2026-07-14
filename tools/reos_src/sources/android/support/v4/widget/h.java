package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1027a = {R.attr.colorPrimaryDark};

    static class a implements View.OnApplyWindowInsetsListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((i) view).a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public static int a(Object obj) {
        if (obj != null) {
            return ((WindowInsets) obj).getSystemWindowInsetTop();
        }
        return 0;
    }

    public static Drawable a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f1027a);
        try {
            return typedArrayObtainStyledAttributes.getDrawable(0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static void a(View view) {
        if (view instanceof i) {
            view.setOnApplyWindowInsetsListener(new a());
            view.setSystemUiVisibility(1280);
        }
    }

    public static void a(View view, Object obj, int i) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        view.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        marginLayoutParams.leftMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft();
        marginLayoutParams.topMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop();
        marginLayoutParams.rightMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight();
        marginLayoutParams.bottomMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom();
    }
}
