package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f1810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f1811b;

    public i(ImageView imageView, h hVar) {
        this.f1810a = imageView;
        this.f1811b = hVar;
    }

    public void a(int i) {
        if (i == 0) {
            this.f1810a.setImageDrawable(null);
            return;
        }
        Drawable drawableA = this.f1811b != null ? this.f1811b.a(this.f1810a.getContext(), i) : android.support.v4.b.b.a(this.f1810a.getContext(), i);
        if (drawableA != null) {
            w.b(drawableA);
        }
        this.f1810a.setImageDrawable(drawableA);
    }

    public void a(AttributeSet attributeSet, int i) {
        Drawable drawableA;
        ap apVarA = ap.a(this.f1810a.getContext(), attributeSet, android.support.v7.b.a.k.AppCompatImageView, i, 0);
        try {
            Drawable drawableB = apVarA.b(android.support.v7.b.a.k.AppCompatImageView_android_src);
            if (drawableB != null) {
                this.f1810a.setImageDrawable(drawableB);
            }
            int iG = apVarA.g(android.support.v7.b.a.k.AppCompatImageView_srcCompat, -1);
            if (iG != -1 && (drawableA = this.f1811b.a(this.f1810a.getContext(), iG)) != null) {
                this.f1810a.setImageDrawable(drawableA);
            }
            Drawable drawable = this.f1810a.getDrawable();
            if (drawable != null) {
                w.b(drawable);
            }
        } finally {
            apVarA.a();
        }
    }
}
