package android.support.v7.widget;

import android.R;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes.dex */
class k extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1816b = {R.attr.thumb};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SeekBar f1817c;

    k(SeekBar seekBar, h hVar) {
        super(seekBar, hVar);
        this.f1817c = seekBar;
    }

    @Override // android.support.v7.widget.j
    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ap apVarA = ap.a(this.f1817c.getContext(), attributeSet, f1816b, i, 0);
        Drawable drawableB = apVarA.b(0);
        if (drawableB != null) {
            this.f1817c.setThumb(drawableB);
        }
        apVarA.a();
    }
}
