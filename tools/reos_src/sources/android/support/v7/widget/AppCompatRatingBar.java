package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RatingBar;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f1399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f1400b;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1400b = h.a();
        this.f1399a = new j(this, this.f1400b);
        this.f1399a.a(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmapA = this.f1399a.a();
        if (bitmapA != null) {
            setMeasuredDimension(android.support.v4.view.ah.a(bitmapA.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
