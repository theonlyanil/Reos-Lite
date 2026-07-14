package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements android.support.v4.view.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f1381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f1382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l f1383c;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        this.f1381a = h.a();
        this.f1382b = new f(this, this.f1381a);
        this.f1382b.a(attributeSet, i);
        this.f1383c = l.a(this);
        this.f1383c.a(attributeSet, i);
        this.f1383c.a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1382b != null) {
            this.f1382b.c();
        }
        if (this.f1383c != null) {
            this.f1383c.a();
        }
    }

    @Override // android.support.v4.view.ae
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1382b != null) {
            return this.f1382b.a();
        }
        return null;
    }

    @Override // android.support.v4.view.ae
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1382b != null) {
            return this.f1382b.b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1382b != null) {
            this.f1382b.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1382b != null) {
            this.f1382b.a(i);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1382b != null) {
            this.f1382b.a(colorStateList);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1382b != null) {
            this.f1382b.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1383c != null) {
            this.f1383c.a(context, i);
        }
    }
}
