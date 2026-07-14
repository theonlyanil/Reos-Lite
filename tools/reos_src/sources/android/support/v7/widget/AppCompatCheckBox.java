package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements android.support.v4.widget.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f1376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1377b;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        this.f1376a = h.a();
        this.f1377b = new g(this, this.f1376a);
        this.f1377b.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1377b != null ? this.f1377b.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f1377b != null) {
            return this.f1377b.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f1377b != null) {
            return this.f1377b.b();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f1376a != null ? this.f1376a.a(getContext(), i) : android.support.v4.b.b.a(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1377b != null) {
            this.f1377b.c();
        }
    }

    @Override // android.support.v4.widget.ae
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1377b != null) {
            this.f1377b.a(colorStateList);
        }
    }

    @Override // android.support.v4.widget.ae
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f1377b != null) {
            this.f1377b.a(mode);
        }
    }
}
