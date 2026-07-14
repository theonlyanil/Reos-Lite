package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements android.support.v4.view.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f1386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f1387b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        h hVarA = h.a();
        this.f1386a = new f(this, hVarA);
        this.f1386a.a(attributeSet, i);
        this.f1387b = new i(this, hVarA);
        this.f1387b.a(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1386a != null) {
            this.f1386a.c();
        }
    }

    @Override // android.support.v4.view.ae
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1386a != null) {
            return this.f1386a.a();
        }
        return null;
    }

    @Override // android.support.v4.view.ae
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1386a != null) {
            return this.f1386a.b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1386a != null) {
            this.f1386a.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1386a != null) {
            this.f1386a.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f1387b.a(i);
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1386a != null) {
            this.f1386a.a(colorStateList);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1386a != null) {
            this.f1386a.a(mode);
        }
    }
}
