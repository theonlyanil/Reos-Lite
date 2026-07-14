package android.support.v7.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1812b = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final h f1813a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProgressBar f1814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f1815d;

    j(ProgressBar progressBar, h hVar) {
        this.f1814c = progressBar;
        this.f1813a = hVar;
    }

    private Drawable a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableA = a(animationDrawable.getFrame(i), true);
            drawableA.setLevel(10000);
            animationDrawable2.addFrame(drawableA, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable a(Drawable drawable, boolean z) {
        if (drawable instanceof android.support.v4.c.a.i) {
            Drawable drawableA = ((android.support.v4.c.a.i) drawable).a();
            if (drawableA != null) {
                ((android.support.v4.c.a.i) drawable).a(a(drawableA, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f1815d == null) {
                    this.f1815d = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(b());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap a() {
        return this.f1815d;
    }

    void a(AttributeSet attributeSet, int i) {
        ap apVarA = ap.a(this.f1814c.getContext(), attributeSet, f1812b, i, 0);
        Drawable drawableB = apVarA.b(0);
        if (drawableB != null) {
            this.f1814c.setIndeterminateDrawable(a(drawableB));
        }
        Drawable drawableB2 = apVarA.b(1);
        if (drawableB2 != null) {
            this.f1814c.setProgressDrawable(a(drawableB2, false));
        }
        apVarA.a();
    }
}
