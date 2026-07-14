package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
class m extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1824b = {R.attr.drawableStart, R.attr.drawableEnd};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private an f1825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private an f1826d;

    m(TextView textView) {
        super(textView);
    }

    @Override // android.support.v7.widget.l
    void a() {
        super.a();
        if (this.f1825c == null && this.f1826d == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f1820a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f1825c);
        a(compoundDrawablesRelative[2], this.f1826d);
    }

    @Override // android.support.v7.widget.l
    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.f1820a.getContext();
        h hVarA = h.a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1824b, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f1825c = a(context, hVarA, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f1826d = a(context, hVarA, typedArrayObtainStyledAttributes.getResourceId(1, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
