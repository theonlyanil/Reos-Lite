package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements android.support.v4.view.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1388a = {R.attr.popupBackground};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f1389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f1390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f1391d;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        this.f1389b = h.a();
        ap apVarA = ap.a(getContext(), attributeSet, f1388a, i, 0);
        if (apVarA.f(0)) {
            setDropDownBackgroundDrawable(apVarA.a(0));
        }
        apVarA.a();
        this.f1390c = new f(this, this.f1389b);
        this.f1390c.a(attributeSet, i);
        this.f1391d = l.a(this);
        this.f1391d.a(attributeSet, i);
        this.f1391d.a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1390c != null) {
            this.f1390c.c();
        }
        if (this.f1391d != null) {
            this.f1391d.a();
        }
    }

    @Override // android.support.v4.view.ae
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1390c != null) {
            return this.f1390c.a();
        }
        return null;
    }

    @Override // android.support.v4.view.ae
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1390c != null) {
            return this.f1390c.b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1390c != null) {
            this.f1390c.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1390c != null) {
            this.f1390c.a(i);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        if (this.f1389b != null) {
            setDropDownBackgroundDrawable(this.f1389b.a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1390c != null) {
            this.f1390c.a(colorStateList);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1390c != null) {
            this.f1390c.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1391d != null) {
            this.f1391d.a(context, i);
        }
    }
}
