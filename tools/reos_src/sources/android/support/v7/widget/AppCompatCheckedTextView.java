package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1378a = {R.attr.checkMark};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f1379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l f1380c;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(am.a(context), attributeSet, i);
        this.f1380c = l.a(this);
        this.f1380c.a(attributeSet, i);
        this.f1380c.a();
        this.f1379b = h.a();
        ap apVarA = ap.a(getContext(), attributeSet, f1378a, i, 0);
        setCheckMarkDrawable(apVarA.a(0));
        apVarA.a();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1380c != null) {
            this.f1380c.a();
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        if (this.f1379b != null) {
            setCheckMarkDrawable(this.f1379b.a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1380c != null) {
            this.f1380c.a(context, i);
        }
    }
}
