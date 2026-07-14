package com.getbase.floatingactionbutton;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class AddFloatingActionButton extends FloatingActionButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4750a;

    public AddFloatingActionButton(Context context) {
        this(context, null);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionButton
    void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.d.AddFloatingActionButton, 0, 0);
        this.f4750a = typedArrayObtainStyledAttributes.getColor(a.d.AddFloatingActionButton_fab_plusIconColor, a(R.color.white));
        typedArrayObtainStyledAttributes.recycle();
        super.a(context, attributeSet);
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionButton
    Drawable getIconDrawable() {
        final float fB = b(a.C0081a.fab_icon_size);
        final float f2 = fB / 2.0f;
        float fB2 = b(a.C0081a.fab_plus_icon_size);
        final float fB3 = b(a.C0081a.fab_plus_icon_stroke) / 2.0f;
        final float f3 = (fB - fB2) / 2.0f;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new Shape() { // from class: com.getbase.floatingactionbutton.AddFloatingActionButton.1
            @Override // android.graphics.drawable.shapes.Shape
            public void draw(Canvas canvas, Paint paint) {
                canvas.drawRect(f3, f2 - fB3, fB - f3, fB3 + f2, paint);
                canvas.drawRect(f2 - fB3, f3, fB3 + f2, fB - f3, paint);
            }
        });
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.f4750a);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        return shapeDrawable;
    }

    public int getPlusColor() {
        return this.f4750a;
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionButton
    public void setIcon(int i) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    public void setPlusColor(int i) {
        if (this.f4750a != i) {
            this.f4750a = i;
            a();
        }
    }

    public void setPlusColorResId(int i) {
        setPlusColor(a(i));
    }
}
