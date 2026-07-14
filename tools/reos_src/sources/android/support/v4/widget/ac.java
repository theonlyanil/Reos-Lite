package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
class ac {
    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z = textView.getLayoutDirection() == 1;
        Drawable drawable5 = z ? drawable3 : drawable;
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }
}
