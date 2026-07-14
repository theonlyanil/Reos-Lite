package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements android.support.v4.view.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f1384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f1385b;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        h hVarA = h.a();
        this.f1384a = new f(this, hVarA);
        this.f1384a.a(attributeSet, i);
        this.f1385b = new i(this, hVarA);
        this.f1385b.a(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1384a != null) {
            this.f1384a.c();
        }
    }

    @Override // android.support.v4.view.ae
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1384a != null) {
            return this.f1384a.a();
        }
        return null;
    }

    @Override // android.support.v4.view.ae
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1384a != null) {
            return this.f1384a.b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1384a != null) {
            this.f1384a.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1384a != null) {
            this.f1384a.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f1385b.a(i);
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1384a != null) {
            this.f1384a.a(colorStateList);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1384a != null) {
            this.f1384a.a(mode);
        }
    }
}
