package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1818b = {R.attr.textAppearance, R.attr.drawableLeft, R.attr.drawableTop, R.attr.drawableRight, R.attr.drawableBottom};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f1819c = {android.support.v7.b.a.C0029a.textAllCaps};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TextView f1820a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private an f1821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private an f1822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private an f1823f;
    private an g;

    l(TextView textView) {
        this.f1820a = textView;
    }

    protected static an a(Context context, h hVar, int i) {
        ColorStateList colorStateListB = hVar.b(context, i);
        if (colorStateListB == null) {
            return null;
        }
        an anVar = new an();
        anVar.f1746d = true;
        anVar.f1743a = colorStateListB;
        return anVar;
    }

    static l a(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new m(textView) : new l(textView);
    }

    void a() {
        if (this.f1821d == null && this.f1822e == null && this.f1823f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawables = this.f1820a.getCompoundDrawables();
        a(compoundDrawables[0], this.f1821d);
        a(compoundDrawables[1], this.f1822e);
        a(compoundDrawables[2], this.f1823f);
        a(compoundDrawables[3], this.g);
    }

    void a(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, f1819c);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            a(typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    final void a(Drawable drawable, an anVar) {
        if (drawable == null || anVar == null) {
            return;
        }
        h.a(drawable, anVar, this.f1820a.getDrawableState());
    }

    void a(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        Context context = this.f1820a.getContext();
        h hVarA = h.a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1818b, i, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f1821d = a(context, hVarA, typedArrayObtainStyledAttributes.getResourceId(1, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            this.f1822e = a(context, hVarA, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f1823f = a(context, hVarA, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(4)) {
            this.g = a(context, hVarA, typedArrayObtainStyledAttributes.getResourceId(4, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        if (this.f1820a.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return;
        }
        if (resourceId != -1) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, android.support.v7.b.a.k.TextAppearance);
            if (typedArrayObtainStyledAttributes2.hasValue(android.support.v7.b.a.k.TextAppearance_textAllCaps)) {
                z2 = typedArrayObtainStyledAttributes2.getBoolean(android.support.v7.b.a.k.TextAppearance_textAllCaps, false);
                z = true;
            } else {
                z = false;
                z2 = false;
            }
            typedArrayObtainStyledAttributes2.recycle();
        } else {
            z = false;
            z2 = false;
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1819c, i, 0);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            z2 = typedArrayObtainStyledAttributes3.getBoolean(0, false);
        } else {
            z3 = z;
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (z3) {
            a(z2);
        }
    }

    void a(boolean z) {
        this.f1820a.setTransformationMethod(z ? new android.support.v7.f.a(this.f1820a.getContext()) : null);
    }
}
