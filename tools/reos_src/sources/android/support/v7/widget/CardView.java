package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1427a = {R.attr.colorBackground};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q f1428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1432f;
    private final Rect g;
    private final Rect h;
    private final o i;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1428b = new n();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f1428b = new r();
        } else {
            f1428b = new p();
        }
        f1428b.a();
    }

    public CardView(Context context) {
        super(context);
        this.g = new Rect();
        this.h = new Rect();
        this.i = new o() { // from class: android.support.v7.widget.CardView.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Drawable f1434b;

            @Override // android.support.v7.widget.o
            public void a(int i, int i2) {
                if (i > CardView.this.f1431e) {
                    CardView.super.setMinimumWidth(i);
                }
                if (i2 > CardView.this.f1432f) {
                    CardView.super.setMinimumHeight(i2);
                }
            }

            @Override // android.support.v7.widget.o
            public void a(int i, int i2, int i3, int i4) {
                CardView.this.h.set(i, i2, i3, i4);
                CardView.super.setPadding(CardView.this.g.left + i, CardView.this.g.top + i2, CardView.this.g.right + i3, CardView.this.g.bottom + i4);
            }

            @Override // android.support.v7.widget.o
            public void a(Drawable drawable) {
                this.f1434b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // android.support.v7.widget.o
            public boolean a() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // android.support.v7.widget.o
            public boolean b() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // android.support.v7.widget.o
            public Drawable c() {
                return this.f1434b;
            }

            @Override // android.support.v7.widget.o
            public View d() {
                return CardView.this;
            }
        };
        a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Rect();
        this.h = new Rect();
        this.i = new o() { // from class: android.support.v7.widget.CardView.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Drawable f1434b;

            @Override // android.support.v7.widget.o
            public void a(int i, int i2) {
                if (i > CardView.this.f1431e) {
                    CardView.super.setMinimumWidth(i);
                }
                if (i2 > CardView.this.f1432f) {
                    CardView.super.setMinimumHeight(i2);
                }
            }

            @Override // android.support.v7.widget.o
            public void a(int i, int i2, int i3, int i4) {
                CardView.this.h.set(i, i2, i3, i4);
                CardView.super.setPadding(CardView.this.g.left + i, CardView.this.g.top + i2, CardView.this.g.right + i3, CardView.this.g.bottom + i4);
            }

            @Override // android.support.v7.widget.o
            public void a(Drawable drawable) {
                this.f1434b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // android.support.v7.widget.o
            public boolean a() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // android.support.v7.widget.o
            public boolean b() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // android.support.v7.widget.o
            public Drawable c() {
                return this.f1434b;
            }

            @Override // android.support.v7.widget.o
            public View d() {
                return CardView.this;
            }
        };
        a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Rect();
        this.h = new Rect();
        this.i = new o() { // from class: android.support.v7.widget.CardView.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Drawable f1434b;

            @Override // android.support.v7.widget.o
            public void a(int i2, int i3) {
                if (i2 > CardView.this.f1431e) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.f1432f) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            @Override // android.support.v7.widget.o
            public void a(int i2, int i3, int i4, int i5) {
                CardView.this.h.set(i2, i3, i4, i5);
                CardView.super.setPadding(CardView.this.g.left + i2, CardView.this.g.top + i3, CardView.this.g.right + i4, CardView.this.g.bottom + i5);
            }

            @Override // android.support.v7.widget.o
            public void a(Drawable drawable) {
                this.f1434b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // android.support.v7.widget.o
            public boolean a() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // android.support.v7.widget.o
            public boolean b() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // android.support.v7.widget.o
            public Drawable c() {
                return this.f1434b;
            }

            @Override // android.support.v7.widget.o
            public View d() {
                return CardView.this;
            }
        };
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.c.a.d.CardView, i, android.support.v7.c.a.c.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.c.a.d.CardView_cardBackgroundColor)) {
            color = typedArrayObtainStyledAttributes.getColor(android.support.v7.c.a.d.CardView_cardBackgroundColor, 0);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f1427a);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(android.support.v7.c.a.C0030a.cardview_light_background) : getResources().getColor(android.support.v7.c.a.C0030a.cardview_dark_background);
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(android.support.v7.c.a.d.CardView_cardCornerRadius, BitmapDescriptorFactory.HUE_RED);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(android.support.v7.c.a.d.CardView_cardElevation, BitmapDescriptorFactory.HUE_RED);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(android.support.v7.c.a.d.CardView_cardMaxElevation, BitmapDescriptorFactory.HUE_RED);
        this.f1429c = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.c.a.d.CardView_cardUseCompatPadding, false);
        this.f1430d = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.c.a.d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.c.a.d.CardView_contentPadding, 0);
        this.g.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.c.a.d.CardView_contentPaddingLeft, dimensionPixelSize);
        this.g.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.c.a.d.CardView_contentPaddingTop, dimensionPixelSize);
        this.g.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.c.a.d.CardView_contentPaddingRight, dimensionPixelSize);
        this.g.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.c.a.d.CardView_contentPaddingBottom, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.f1431e = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.c.a.d.CardView_android_minWidth, 0);
        this.f1432f = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.c.a.d.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f1428b.a(this.i, context, color, dimension, dimension2, dimension3);
    }

    public float getCardElevation() {
        return f1428b.e(this.i);
    }

    public int getContentPaddingBottom() {
        return this.g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.g.left;
    }

    public int getContentPaddingRight() {
        return this.g.right;
    }

    public int getContentPaddingTop() {
        return this.g.top;
    }

    public float getMaxCardElevation() {
        return f1428b.a(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1430d;
    }

    public float getRadius() {
        return f1428b.d(this.i);
    }

    public boolean getUseCompatPadding() {
        return this.f1429c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (f1428b instanceof n) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f1428b.b(this.i)), View.MeasureSpec.getSize(i)), mode);
                break;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f1428b.c(this.i)), View.MeasureSpec.getSize(i2)), mode2);
                break;
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f1428b.a(this.i, i);
    }

    public void setCardElevation(float f2) {
        f1428b.c(this.i, f2);
    }

    public void setMaxCardElevation(float f2) {
        f1428b.b(this.i, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.f1432f = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f1431e = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1430d) {
            this.f1430d = z;
            f1428b.h(this.i);
        }
    }

    public void setRadius(float f2) {
        f1428b.a(this.i, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1429c != z) {
            this.f1429c = z;
            f1428b.g(this.i);
        }
    }
}
