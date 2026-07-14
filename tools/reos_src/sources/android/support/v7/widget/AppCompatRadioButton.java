package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements android.support.v4.widget.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f1397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1398b;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        this.f1397a = h.a();
        this.f1398b = new g(this, this.f1397a);
        this.f1398b.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1398b != null ? this.f1398b.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f1398b != null) {
            return this.f1398b.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f1398b != null) {
            return this.f1398b.b();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f1397a != null ? this.f1397a.a(getContext(), i) : android.support.v4.b.b.a(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1398b != null) {
            this.f1398b.c();
        }
    }

    @Override // android.support.v4.widget.ae
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1398b != null) {
            this.f1398b.a(colorStateList);
        }
    }

    @Override // android.support.v4.widget.ae
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f1398b != null) {
            this.f1398b.a(mode);
        }
    }
}
