package android.support.v7.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final int[] F = {R.attr.state_checked};
    private Layout A;
    private TransformationMethod B;
    private a C;
    private final Rect D;
    private final h E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f1647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f1648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1652f;
    private CharSequence g;
    private CharSequence h;
    private boolean i;
    private int j;
    private int k;
    private float l;
    private float m;
    private VelocityTracker n;
    private int o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private TextPaint x;
    private ColorStateList y;
    private Layout z;

    private class a extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f1655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f1656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f1657c;

        private a(float f2, float f3) {
            this.f1655a = f2;
            this.f1656b = f3;
            this.f1657c = f3 - f2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            SwitchCompat.this.setThumbPosition(this.f1655a + (this.f1657c * f2));
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = VelocityTracker.obtain();
        this.D = new Rect();
        this.x = new TextPaint(1);
        Resources resources = getResources();
        this.x.density = resources.getDisplayMetrics().density;
        ap apVarA = ap.a(context, attributeSet, android.support.v7.b.a.k.SwitchCompat, i, 0);
        this.f1647a = apVarA.a(android.support.v7.b.a.k.SwitchCompat_android_thumb);
        if (this.f1647a != null) {
            this.f1647a.setCallback(this);
        }
        this.f1648b = apVarA.a(android.support.v7.b.a.k.SwitchCompat_track);
        if (this.f1648b != null) {
            this.f1648b.setCallback(this);
        }
        this.g = apVarA.c(android.support.v7.b.a.k.SwitchCompat_android_textOn);
        this.h = apVarA.c(android.support.v7.b.a.k.SwitchCompat_android_textOff);
        this.i = apVarA.a(android.support.v7.b.a.k.SwitchCompat_showText, true);
        this.f1649c = apVarA.e(android.support.v7.b.a.k.SwitchCompat_thumbTextPadding, 0);
        this.f1650d = apVarA.e(android.support.v7.b.a.k.SwitchCompat_switchMinWidth, 0);
        this.f1651e = apVarA.e(android.support.v7.b.a.k.SwitchCompat_switchPadding, 0);
        this.f1652f = apVarA.a(android.support.v7.b.a.k.SwitchCompat_splitTrack, false);
        int iG = apVarA.g(android.support.v7.b.a.k.SwitchCompat_switchTextAppearance, 0);
        if (iG != 0) {
            a(context, iG);
        }
        this.E = h.a();
        apVarA.a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.k = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private static float a(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        return f2 > f4 ? f4 : f2;
    }

    private Layout a(CharSequence charSequence) {
        CharSequence transformation = this.B != null ? this.B.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.x, transformation != null ? (int) Math.ceil(Layout.getDesiredWidth(transformation, this.x)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, BitmapDescriptorFactory.HUE_RED, true);
    }

    private void a() {
        if (this.C != null) {
            clearAnimation();
            this.C = null;
        }
    }

    private void a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        a(typeface, i2);
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void a(final boolean z) {
        if (this.C != null) {
            a();
        }
        this.C = new a(this.p, z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
        this.C.setDuration(250L);
        this.C.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.v7.widget.SwitchCompat.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwitchCompat.this.C == animation) {
                    SwitchCompat.this.setThumbPosition(z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
                    SwitchCompat.this.C = null;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(this.C);
    }

    private boolean a(float f2, float f3) {
        if (this.f1647a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1647a.getPadding(this.D);
        int i = this.u - this.k;
        int i2 = (thumbOffset + this.t) - this.k;
        return f2 > ((float) i2) && f2 < ((float) ((((this.s + i2) + this.D.left) + this.D.right) + this.k)) && f3 > ((float) i) && f3 < ((float) (this.w + this.k));
    }

    private void b(MotionEvent motionEvent) {
        boolean targetCheckedState = true;
        this.j = 0;
        boolean z = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z) {
            this.n.computeCurrentVelocity(1000);
            float xVelocity = this.n.getXVelocity();
            if (Math.abs(xVelocity) <= this.o) {
                targetCheckedState = getTargetCheckedState();
            } else if (at.a(this)) {
                if (xVelocity >= BitmapDescriptorFactory.HUE_RED) {
                    targetCheckedState = false;
                }
            } else if (xVelocity <= BitmapDescriptorFactory.HUE_RED) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        a(motionEvent);
    }

    private boolean getTargetCheckedState() {
        return this.p > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((at.a(this) ? 1.0f - this.p : this.p) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.f1648b == null) {
            return 0;
        }
        Rect rect = this.D;
        this.f1648b.getPadding(rect);
        Rect rectA = this.f1647a != null ? w.a(this.f1647a) : w.f1875a;
        return ((((this.q - this.s) - rect.left) - rect.right) - rectA.left) - rectA.right;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f2) {
        this.p = f2;
        invalidate();
    }

    public void a(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, android.support.v7.b.a.k.TextAppearance);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(android.support.v7.b.a.k.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.y = colorStateList;
        } else {
            this.y = getTextColors();
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.b.a.k.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0 && dimensionPixelSize != this.x.getTextSize()) {
            this.x.setTextSize(dimensionPixelSize);
            requestLayout();
        }
        a(typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.TextAppearance_android_typeface, -1), typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.TextAppearance_android_textStyle, -1));
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.TextAppearance_textAllCaps, false)) {
            this.B = new android.support.v7.f.a(getContext());
        } else {
            this.B = null;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void a(Typeface typeface, int i) {
        if (i <= 0) {
            this.x.setFakeBoldText(false);
            this.x.setTextSkewX(BitmapDescriptorFactory.HUE_RED);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int style = ((typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0) ^ (-1)) & i;
            this.x.setFakeBoldText((style & 1) != 0);
            this.x.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Rect rect = this.D;
        int i4 = this.t;
        int i5 = this.u;
        int i6 = this.v;
        int i7 = this.w;
        int thumbOffset = i4 + getThumbOffset();
        Rect rectA = this.f1647a != null ? w.a(this.f1647a) : w.f1875a;
        if (this.f1648b != null) {
            this.f1648b.getPadding(rect);
            int i8 = rect.left + thumbOffset;
            if (rectA != null) {
                if (rectA.left > rect.left) {
                    i4 += rectA.left - rect.left;
                }
                i3 = rectA.top > rect.top ? (rectA.top - rect.top) + i5 : i5;
                if (rectA.right > rect.right) {
                    i6 -= rectA.right - rect.right;
                }
                i2 = rectA.bottom > rect.bottom ? i7 - (rectA.bottom - rect.bottom) : i7;
            } else {
                i2 = i7;
                i3 = i5;
            }
            this.f1648b.setBounds(i4, i3, i6, i2);
            i = i8;
        } else {
            i = thumbOffset;
        }
        if (this.f1647a != null) {
            this.f1647a.getPadding(rect);
            int i9 = i - rect.left;
            int i10 = i + this.s + rect.right;
            this.f1647a.setBounds(i9, i5, i10, i7);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.c.a.a.a(background, i9, i5, i10, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        if (this.f1647a != null) {
            android.support.v4.c.a.a.a(this.f1647a, f2, f3);
        }
        if (this.f1648b != null) {
            android.support.v4.c.a.a.a(this.f1648b, f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f1647a != null) {
            this.f1647a.setState(drawableState);
        }
        if (this.f1648b != null) {
            this.f1648b.setState(drawableState);
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!at.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1651e : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (at.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1651e : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.i;
    }

    public boolean getSplitTrack() {
        return this.f1652f;
    }

    public int getSwitchMinWidth() {
        return this.f1650d;
    }

    public int getSwitchPadding() {
        return this.f1651e;
    }

    public CharSequence getTextOff() {
        return this.h;
    }

    public CharSequence getTextOn() {
        return this.g;
    }

    public Drawable getThumbDrawable() {
        return this.f1647a;
    }

    public int getThumbTextPadding() {
        return this.f1649c;
    }

    public Drawable getTrackDrawable() {
        return this.f1648b;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1647a != null) {
                this.f1647a.jumpToCurrentState();
            }
            if (this.f1648b != null) {
                this.f1648b.jumpToCurrentState();
            }
            a();
            setThumbPosition(isChecked() ? 1.0f : BitmapDescriptorFactory.HUE_RED);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, F);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.D;
        Drawable drawable = this.f1648b;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.u;
        int i2 = this.w;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f1647a;
        if (drawable != null) {
            if (!this.f1652f || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectA = w.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectA.left;
                rect.right -= rectA.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.z : this.A;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.y != null) {
                this.x.setColor(this.y.getColorForState(drawableState, 0));
            }
            this.x.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.right + bounds.left;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.g : this.h;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text).append(' ').append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int i5;
        int i6;
        int height;
        int paddingTop;
        int iMax2 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1647a != null) {
            Rect rect = this.D;
            if (this.f1648b != null) {
                this.f1648b.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectA = w.a(this.f1647a);
            iMax = Math.max(0, rectA.left - rect.left);
            iMax2 = Math.max(0, rectA.right - rect.right);
        } else {
            iMax = 0;
        }
        if (at.a(this)) {
            int paddingLeft = getPaddingLeft() + iMax;
            i6 = ((this.q + paddingLeft) - iMax) - iMax2;
            i5 = paddingLeft;
        } else {
            int width = (getWidth() - getPaddingRight()) - iMax2;
            i5 = iMax2 + iMax + (width - this.q);
            i6 = width;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.r / 2);
                height = this.r + paddingTop;
                break;
            case 80:
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.r;
                break;
            default:
                paddingTop = getPaddingTop();
                height = this.r + paddingTop;
                break;
        }
        this.t = i5;
        this.u = paddingTop;
        this.w = height;
        this.v = i6;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int intrinsicHeight;
        int intrinsicWidth;
        int intrinsicHeight2 = 0;
        if (this.i) {
            if (this.z == null) {
                this.z = a(this.g);
            }
            if (this.A == null) {
                this.A = a(this.h);
            }
        }
        Rect rect = this.D;
        if (this.f1647a != null) {
            this.f1647a.getPadding(rect);
            intrinsicWidth = (this.f1647a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f1647a.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        this.s = Math.max(this.i ? Math.max(this.z.getWidth(), this.A.getWidth()) + (this.f1649c * 2) : 0, intrinsicWidth);
        if (this.f1648b != null) {
            this.f1648b.getPadding(rect);
            intrinsicHeight2 = this.f1648b.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        if (this.f1647a != null) {
            Rect rectA = w.a(this.f1647a);
            iMax = Math.max(iMax, rectA.left);
            iMax2 = Math.max(iMax2, rectA.right);
        }
        int iMax3 = Math.max(this.f1650d, iMax2 + iMax + (this.s * 2));
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.q = iMax3;
        this.r = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(android.support.v4.view.ah.k(this), iMax4);
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.g : this.h;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.n.addMovement(motionEvent);
        switch (android.support.v4.view.t.a(motionEvent)) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && a(x, y)) {
                    this.j = 1;
                    this.l = x;
                    this.m = y;
                }
                break;
            case 1:
            case 3:
                if (this.j == 2) {
                    b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.j = 0;
                this.n.clear();
                break;
            case 2:
                switch (this.j) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.l) > this.k || Math.abs(y2 - this.m) > this.k) {
                            this.j = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.l = x2;
                            this.m = y2;
                            return true;
                        }
                        break;
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x3 - this.l;
                        float f3 = thumbScrollRange != 0 ? f2 / thumbScrollRange : f2 > BitmapDescriptorFactory.HUE_RED ? 1.0f : -1.0f;
                        if (at.a(this)) {
                            f3 = -f3;
                        }
                        float fA = a(f3 + this.p, BitmapDescriptorFactory.HUE_RED, 1.0f);
                        if (fA != this.p) {
                            this.l = x3;
                            setThumbPosition(fA);
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && android.support.v4.view.ah.D(this) && isShown()) {
            a(zIsChecked);
        } else {
            a();
            setThumbPosition(zIsChecked ? 1.0f : BitmapDescriptorFactory.HUE_RED);
        }
    }

    public void setShowText(boolean z) {
        if (this.i != z) {
            this.i = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.f1652f = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f1650d = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f1651e = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.x.getTypeface() != typeface) {
            this.x.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.h = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.g = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f1647a = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.E.a(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f1649c = i;
        requestLayout();
    }

    public void setTrackDrawable(Drawable drawable) {
        this.f1648b = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.E.a(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1647a || drawable == this.f1648b;
    }
}
