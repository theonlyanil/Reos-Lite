package com.getbase.floatingactionbutton;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f4759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f4760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f4761f;
    private Drawable g;
    private int h;
    private float i;
    private float j;
    private float k;
    private int l;

    private static class a extends LayerDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4768a;

        public a(int i, Drawable... drawableArr) {
            super(drawableArr);
            this.f4768a = i;
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f4768a, 31);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private Drawable a(int i, float f2) {
        int iAlpha = Color.alpha(i);
        int iF = f(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(iF);
        Drawable[] drawableArr = {shapeDrawable, c(iF, f2)};
        LayerDrawable layerDrawable = (iAlpha == 255 || !this.f4761f) ? new LayerDrawable(drawableArr) : new a(iAlpha, drawableArr);
        int i2 = (int) (f2 / 2.0f);
        layerDrawable.setLayerInset(1, i2, i2, i2, i2);
        return layerDrawable;
    }

    private StateListDrawable a(float f2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, a(this.f4759d, f2));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, a(this.f4758c, f2));
        stateListDrawable.addState(new int[0], a(this.f4757b, f2));
        return stateListDrawable;
    }

    private int b(int i, float f2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = Math.min(fArr[2] * f2, 1.0f);
        return Color.HSVToColor(Color.alpha(i), fArr);
    }

    private Drawable b(float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16777216);
        paint.setAlpha(c(0.02f));
        return shapeDrawable;
    }

    private void b() {
        this.l = (int) (this.i + (2.0f * this.j));
    }

    private int c(float f2) {
        return (int) (255.0f * f2);
    }

    private int c(int i) {
        return b(i, 0.9f);
    }

    private Drawable c(final int i, float f2) {
        if (!this.f4761f) {
            return new ColorDrawable(0);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        final int iC = c(i);
        final int iE = e(iC);
        final int iD = d(i);
        final int iE2 = e(iD);
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        shapeDrawable.setShaderFactory(new ShapeDrawable.ShaderFactory() { // from class: com.getbase.floatingactionbutton.FloatingActionButton.1
            @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
            public Shader resize(int i2, int i3) {
                return new LinearGradient(i2 / 2, BitmapDescriptorFactory.HUE_RED, i2 / 2, i3, new int[]{iD, iE2, i, iE, iC}, new float[]{BitmapDescriptorFactory.HUE_RED, 0.2f, 0.5f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
            }
        });
        return shapeDrawable;
    }

    private void c() {
        this.i = b(this.h == 0 ? com.getbase.floatingactionbutton.a.C0081a.fab_size_normal : com.getbase.floatingactionbutton.a.C0081a.fab_size_mini);
    }

    private int d(int i) {
        return b(i, 1.1f);
    }

    private int e(int i) {
        return Color.argb(Color.alpha(i) / 2, Color.red(i), Color.green(i), Color.blue(i));
    }

    private int f(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    int a(int i) {
        return getResources().getColor(i);
    }

    void a() {
        float fB = b(com.getbase.floatingactionbutton.a.C0081a.fab_stroke_width);
        float f2 = fB / 2.0f;
        Drawable[] drawableArr = new Drawable[4];
        drawableArr[0] = getResources().getDrawable(this.h == 0 ? com.getbase.floatingactionbutton.a.b.fab_bg_normal : com.getbase.floatingactionbutton.a.b.fab_bg_mini);
        drawableArr[1] = a(fB);
        drawableArr[2] = b(fB);
        drawableArr[3] = getIconDrawable();
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        int iB = ((int) (this.i - b(com.getbase.floatingactionbutton.a.C0081a.fab_icon_size))) / 2;
        int i = (int) this.j;
        int i2 = (int) (this.j - this.k);
        int i3 = (int) (this.j + this.k);
        layerDrawable.setLayerInset(1, i, i2, i, i3);
        layerDrawable.setLayerInset(2, (int) (i - f2), (int) (i2 - f2), (int) (i - f2), (int) (i3 - f2));
        layerDrawable.setLayerInset(3, i + iB, i2 + iB, i + iB, i3 + iB);
        setBackgroundCompat(layerDrawable);
    }

    void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.getbase.floatingactionbutton.a.d.FloatingActionButton, 0, 0);
        this.f4757b = typedArrayObtainStyledAttributes.getColor(com.getbase.floatingactionbutton.a.d.FloatingActionButton_fab_colorNormal, a(R.color.holo_blue_dark));
        this.f4758c = typedArrayObtainStyledAttributes.getColor(com.getbase.floatingactionbutton.a.d.FloatingActionButton_fab_colorPressed, a(R.color.holo_blue_light));
        this.f4759d = typedArrayObtainStyledAttributes.getColor(com.getbase.floatingactionbutton.a.d.FloatingActionButton_fab_colorDisabled, a(R.color.darker_gray));
        this.h = typedArrayObtainStyledAttributes.getInt(com.getbase.floatingactionbutton.a.d.FloatingActionButton_fab_size, 0);
        this.f4756a = typedArrayObtainStyledAttributes.getResourceId(com.getbase.floatingactionbutton.a.d.FloatingActionButton_fab_icon, 0);
        this.f4760e = typedArrayObtainStyledAttributes.getString(com.getbase.floatingactionbutton.a.d.FloatingActionButton_fab_title);
        this.f4761f = typedArrayObtainStyledAttributes.getBoolean(com.getbase.floatingactionbutton.a.d.FloatingActionButton_fab_stroke_visible, true);
        typedArrayObtainStyledAttributes.recycle();
        c();
        this.j = b(com.getbase.floatingactionbutton.a.C0081a.fab_shadow_radius);
        this.k = b(com.getbase.floatingactionbutton.a.C0081a.fab_shadow_offset);
        b();
        a();
    }

    float b(int i) {
        return getResources().getDimension(i);
    }

    public int getColorDisabled() {
        return this.f4759d;
    }

    public int getColorNormal() {
        return this.f4757b;
    }

    public int getColorPressed() {
        return this.f4758c;
    }

    Drawable getIconDrawable() {
        if (this.g != null) {
            return this.g;
        }
        return this.f4756a != 0 ? getResources().getDrawable(this.f4756a) : new ColorDrawable(0);
    }

    TextView getLabelView() {
        return (TextView) getTag(com.getbase.floatingactionbutton.a.c.fab_label);
    }

    public int getSize() {
        return this.h;
    }

    public String getTitle() {
        return this.f4760e;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.l, this.l);
    }

    public void setColorDisabled(int i) {
        if (this.f4759d != i) {
            this.f4759d = i;
            a();
        }
    }

    public void setColorDisabledResId(int i) {
        setColorDisabled(a(i));
    }

    public void setColorNormal(int i) {
        if (this.f4757b != i) {
            this.f4757b = i;
            a();
        }
    }

    public void setColorNormalResId(int i) {
        setColorNormal(a(i));
    }

    public void setColorPressed(int i) {
        if (this.f4758c != i) {
            this.f4758c = i;
            a();
        }
    }

    public void setColorPressedResId(int i) {
        setColorPressed(a(i));
    }

    public void setIcon(int i) {
        if (this.f4756a != i) {
            this.f4756a = i;
            this.g = null;
            a();
        }
    }

    public void setIconDrawable(Drawable drawable) {
        if (this.g != drawable) {
            this.f4756a = 0;
            this.g = drawable;
            a();
        }
    }

    public void setSize(int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        }
        if (this.h != i) {
            this.h = i;
            c();
            b();
            a();
        }
    }

    public void setStrokeVisible(boolean z) {
        if (this.f4761f != z) {
            this.f4761f = z;
            a();
        }
    }

    public void setTitle(String str) {
        this.f4760e = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
        }
        super.setVisibility(i);
    }
}
