package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements android.support.v4.view.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1369a = {R.attr.popupBackground};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f1370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f1371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f1372d;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        this.f1370b = h.a();
        ap apVarA = ap.a(getContext(), attributeSet, f1369a, i, 0);
        if (apVarA.f(0)) {
            setDropDownBackgroundDrawable(apVarA.a(0));
        }
        apVarA.a();
        this.f1371c = new f(this, this.f1370b);
        this.f1371c.a(attributeSet, i);
        this.f1372d = l.a(this);
        this.f1372d.a(attributeSet, i);
        this.f1372d.a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1371c != null) {
            this.f1371c.c();
        }
        if (this.f1372d != null) {
            this.f1372d.a();
        }
    }

    @Override // android.support.v4.view.ae
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1371c != null) {
            return this.f1371c.a();
        }
        return null;
    }

    @Override // android.support.v4.view.ae
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1371c != null) {
            return this.f1371c.b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1371c != null) {
            this.f1371c.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1371c != null) {
            this.f1371c.a(i);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        if (this.f1370b != null) {
            setDropDownBackgroundDrawable(this.f1370b.a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1371c != null) {
            this.f1371c.a(colorStateList);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1371c != null) {
            this.f1371c.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1372d != null) {
            this.f1372d.a(context, i);
        }
    }
}
