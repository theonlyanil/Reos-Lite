package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f1749b;

    private ap(Context context, TypedArray typedArray) {
        this.f1748a = context;
        this.f1749b = typedArray;
    }

    public static ap a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ap(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ap a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ap(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float a(int i, float f2) {
        return this.f1749b.getFloat(i, f2);
    }

    public int a(int i, int i2) {
        return this.f1749b.getInt(i, i2);
    }

    public Drawable a(int i) {
        int resourceId;
        return (!this.f1749b.hasValue(i) || (resourceId = this.f1749b.getResourceId(i, 0)) == 0) ? this.f1749b.getDrawable(i) : h.a().a(this.f1748a, resourceId);
    }

    public void a() {
        this.f1749b.recycle();
    }

    public boolean a(int i, boolean z) {
        return this.f1749b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f1749b.getColor(i, i2);
    }

    public Drawable b(int i) {
        int resourceId;
        if (!this.f1749b.hasValue(i) || (resourceId = this.f1749b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return h.a().a(this.f1748a, resourceId, true);
    }

    public int c(int i, int i2) {
        return this.f1749b.getInteger(i, i2);
    }

    public CharSequence c(int i) {
        return this.f1749b.getText(i);
    }

    public int d(int i, int i2) {
        return this.f1749b.getDimensionPixelOffset(i, i2);
    }

    public String d(int i) {
        return this.f1749b.getString(i);
    }

    public int e(int i, int i2) {
        return this.f1749b.getDimensionPixelSize(i, i2);
    }

    public CharSequence[] e(int i) {
        return this.f1749b.getTextArray(i);
    }

    public int f(int i, int i2) {
        return this.f1749b.getLayoutDimension(i, i2);
    }

    public boolean f(int i) {
        return this.f1749b.hasValue(i);
    }

    public int g(int i, int i2) {
        return this.f1749b.getResourceId(i, i2);
    }
}
