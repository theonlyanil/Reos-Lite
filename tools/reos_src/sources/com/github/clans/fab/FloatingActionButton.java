package com.github.clans.fab;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends ImageButton {
    private static final Xfermode h = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private float A;
    private float B;
    private boolean C;
    private RectF D;
    private Paint E;
    private Paint F;
    private boolean G;
    private long H;
    private float I;
    private long J;
    private double K;
    private boolean L;
    private int M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private boolean V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f4789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f4791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f4792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f4793f;
    GestureDetector g;
    private int i;
    private int j;
    private int k;
    private int l;
    private Drawable m;
    private int n;
    private Animation o;
    private Animation p;
    private String q;
    private View.OnClickListener r;
    private Drawable s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    static class ProgressSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<ProgressSavedState> CREATOR = new Parcelable.Creator<ProgressSavedState>() { // from class: com.github.clans.fab.FloatingActionButton.ProgressSavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ProgressSavedState createFromParcel(Parcel parcel) {
                return new ProgressSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ProgressSavedState[] newArray(int i) {
                return new ProgressSavedState[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f4797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f4798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f4799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4800d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f4801e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f4802f;
        int g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;

        private ProgressSavedState(Parcel parcel) {
            super(parcel);
            this.f4797a = parcel.readFloat();
            this.f4798b = parcel.readFloat();
            this.h = parcel.readInt() != 0;
            this.f4799c = parcel.readFloat();
            this.f4800d = parcel.readInt();
            this.f4801e = parcel.readInt();
            this.f4802f = parcel.readInt();
            this.g = parcel.readInt();
            this.i = parcel.readInt() != 0;
            this.j = parcel.readInt() != 0;
            this.k = parcel.readInt() != 0;
            this.l = parcel.readInt() != 0;
            this.m = parcel.readInt() != 0;
            this.n = parcel.readInt() != 0;
        }

        ProgressSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f4797a);
            parcel.writeFloat(this.f4798b);
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeFloat(this.f4799c);
            parcel.writeInt(this.f4800d);
            parcel.writeInt(this.f4801e);
            parcel.writeInt(this.f4802f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeInt(this.l ? 1 : 0);
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeInt(this.n ? 1 : 0);
        }
    }

    private class a extends ShapeDrawable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4805c;

        private a(Shape shape) {
            super(shape);
            this.f4804b = FloatingActionButton.this.h() ? FloatingActionButton.this.f4791d + Math.abs(FloatingActionButton.this.f4792e) : 0;
            this.f4805c = FloatingActionButton.this.h() ? Math.abs(FloatingActionButton.this.f4793f) + FloatingActionButton.this.f4791d : 0;
            if (FloatingActionButton.this.v) {
                this.f4804b += FloatingActionButton.this.w;
                this.f4805c += FloatingActionButton.this.w;
            }
        }

        @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            setBounds(this.f4804b, this.f4805c, FloatingActionButton.this.k() - this.f4804b, FloatingActionButton.this.l() - this.f4805c);
            super.draw(canvas);
        }
    }

    private class b extends Drawable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Paint f4807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Paint f4808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f4809d;

        private b() {
            this.f4807b = new Paint(1);
            this.f4808c = new Paint(1);
            a();
        }

        private void a() {
            FloatingActionButton.this.setLayerType(1, null);
            this.f4807b.setStyle(Paint.Style.FILL);
            this.f4807b.setColor(FloatingActionButton.this.i);
            this.f4808c.setXfermode(FloatingActionButton.h);
            if (!FloatingActionButton.this.isInEditMode()) {
                this.f4807b.setShadowLayer(FloatingActionButton.this.f4791d, FloatingActionButton.this.f4792e, FloatingActionButton.this.f4793f, FloatingActionButton.this.f4790c);
            }
            this.f4809d = FloatingActionButton.this.getCircleSize() / 2;
            if (FloatingActionButton.this.v && FloatingActionButton.this.V) {
                this.f4809d += FloatingActionButton.this.w;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawCircle(FloatingActionButton.this.m(), FloatingActionButton.this.n(), this.f4809d, this.f4807b);
            canvas.drawCircle(FloatingActionButton.this.m(), FloatingActionButton.this.n(), this.f4809d, this.f4808c);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4791d = com.github.clans.fab.b.a(getContext(), 4.0f);
        this.f4792e = com.github.clans.fab.b.a(getContext(), 1.0f);
        this.f4793f = com.github.clans.fab.b.a(getContext(), 3.0f);
        this.n = com.github.clans.fab.b.a(getContext(), 24.0f);
        this.w = com.github.clans.fab.b.a(getContext(), 6.0f);
        this.A = -1.0f;
        this.B = -1.0f;
        this.D = new RectF();
        this.E = new Paint(1);
        this.F = new Paint(1);
        this.I = 195.0f;
        this.J = 0L;
        this.L = true;
        this.M = 16;
        this.U = 100;
        this.g = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.github.clans.fab.FloatingActionButton.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                Label label = (Label) FloatingActionButton.this.getTag(com.github.clans.fab.a.d.fab_label);
                if (label != null) {
                    label.d();
                }
                FloatingActionButton.this.f();
                return super.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                Label label = (Label) FloatingActionButton.this.getTag(com.github.clans.fab.a.d.fab_label);
                if (label != null) {
                    label.e();
                }
                FloatingActionButton.this.g();
                return super.onSingleTapUp(motionEvent);
            }
        });
        a(context, attributeSet, i);
    }

    @TargetApi(21)
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4791d = com.github.clans.fab.b.a(getContext(), 4.0f);
        this.f4792e = com.github.clans.fab.b.a(getContext(), 1.0f);
        this.f4793f = com.github.clans.fab.b.a(getContext(), 3.0f);
        this.n = com.github.clans.fab.b.a(getContext(), 24.0f);
        this.w = com.github.clans.fab.b.a(getContext(), 6.0f);
        this.A = -1.0f;
        this.B = -1.0f;
        this.D = new RectF();
        this.E = new Paint(1);
        this.F = new Paint(1);
        this.I = 195.0f;
        this.J = 0L;
        this.L = true;
        this.M = 16;
        this.U = 100;
        this.g = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.github.clans.fab.FloatingActionButton.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                Label label = (Label) FloatingActionButton.this.getTag(com.github.clans.fab.a.d.fab_label);
                if (label != null) {
                    label.d();
                }
                FloatingActionButton.this.f();
                return super.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                Label label = (Label) FloatingActionButton.this.getTag(com.github.clans.fab.a.d.fab_label);
                if (label != null) {
                    label.e();
                }
                FloatingActionButton.this.g();
                return super.onSingleTapUp(motionEvent);
            }
        });
        a(context, attributeSet, i);
    }

    private Drawable a(int i) {
        a aVar = new a(new OvalShape());
        aVar.getPaint().setColor(i);
        return aVar;
    }

    private void a(long j) {
        if (this.J < 200) {
            this.J += j;
            return;
        }
        this.K += j;
        if (this.K > 500.0d) {
            this.K -= 500.0d;
            this.J = 0L;
            this.L = !this.L;
        }
        float fCos = (((float) Math.cos(((this.K / 500.0d) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
        float f2 = 270 - this.M;
        if (this.L) {
            this.N = fCos * f2;
            return;
        }
        float f3 = (1.0f - fCos) * f2;
        this.O += this.N - f3;
        this.N = f3;
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.github.clans.fab.a.e.FloatingActionButton, i, 0);
        this.i = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionButton_fab_colorNormal, -2473162);
        this.j = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionButton_fab_colorPressed, -1617853);
        this.k = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionButton_fab_colorDisabled, -5592406);
        this.l = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionButton_fab_colorRipple, -1711276033);
        this.f4789b = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.a.e.FloatingActionButton_fab_showShadow, true);
        this.f4790c = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionButton_fab_shadowColor, 1711276032);
        this.f4791d = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionButton_fab_shadowRadius, this.f4791d);
        this.f4792e = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionButton_fab_shadowXOffset, this.f4792e);
        this.f4793f = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionButton_fab_shadowYOffset, this.f4793f);
        this.f4788a = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionButton_fab_size, 0);
        this.q = typedArrayObtainStyledAttributes.getString(com.github.clans.fab.a.e.FloatingActionButton_fab_label);
        this.S = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.a.e.FloatingActionButton_fab_progress_indeterminate, false);
        this.x = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionButton_fab_progress_color, -16738680);
        this.y = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionButton_fab_progress_backgroundColor, 1291845632);
        this.U = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionButton_fab_progress_max, this.U);
        this.V = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.a.e.FloatingActionButton_fab_progress_showBackground, true);
        if (typedArrayObtainStyledAttributes.hasValue(com.github.clans.fab.a.e.FloatingActionButton_fab_progress)) {
            this.Q = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionButton_fab_progress, 0);
            this.T = true;
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.github.clans.fab.a.e.FloatingActionButton_fab_elevationCompat)) {
            float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.github.clans.fab.a.e.FloatingActionButton_fab_elevationCompat, 0);
            if (isInEditMode()) {
                setElevation(dimensionPixelOffset);
            } else {
                setElevationCompat(dimensionPixelOffset);
            }
        }
        a(typedArrayObtainStyledAttributes);
        b(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        if (isInEditMode()) {
            if (this.S) {
                setIndeterminate(true);
            } else if (this.T) {
                p();
                a(this.Q, false);
            }
        }
        setClickable(true);
    }

    private void a(TypedArray typedArray) {
        this.o = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(com.github.clans.fab.a.e.FloatingActionButton_fab_showAnimation, com.github.clans.fab.a.C0082a.fab_scale_up));
    }

    private void b(TypedArray typedArray) {
        this.p = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(com.github.clans.fab.a.e.FloatingActionButton_fab_hideAnimation, com.github.clans.fab.a.C0082a.fab_scale_down));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCircleSize() {
        return getResources().getDimensionPixelSize(this.f4788a == 0 ? com.github.clans.fab.a.b.fab_size_normal : com.github.clans.fab.a.b.fab_size_mini);
    }

    private int getShadowX() {
        return this.f4791d + Math.abs(this.f4792e);
    }

    private int getShadowY() {
        return this.f4791d + Math.abs(this.f4793f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        int circleSize = getCircleSize() + a();
        return this.v ? circleSize + (this.w * 2) : circleSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        int circleSize = getCircleSize() + b();
        return this.v ? circleSize + (this.w * 2) : circleSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m() {
        return getMeasuredWidth() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return getMeasuredHeight() / 2;
    }

    @TargetApi(21)
    private Drawable o() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, a(this.k));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, a(this.j));
        stateListDrawable.addState(new int[0], a(this.i));
        if (!com.github.clans.fab.b.b()) {
            this.s = stateListDrawable;
            return stateListDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.l}), stateListDrawable, null);
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.github.clans.fab.FloatingActionButton.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        });
        setClipToOutline(true);
        this.s = rippleDrawable;
        return rippleDrawable;
    }

    private void p() {
        if (this.C) {
            return;
        }
        if (this.A == -1.0f) {
            this.A = getX();
        }
        if (this.B == -1.0f) {
            this.B = getY();
        }
        this.C = true;
    }

    private void q() {
        float x;
        float y;
        if (this.v) {
            x = this.A > getX() ? getX() + this.w : getX() - this.w;
            y = this.B > getY() ? getY() + this.w : getY() - this.w;
        } else {
            x = this.A;
            y = this.B;
        }
        setX(x);
        setY(y);
    }

    private void r() {
        this.E.setColor(this.y);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(this.w);
        this.F.setColor(this.x);
        this.F.setStyle(Paint.Style.STROKE);
        this.F.setStrokeWidth(this.w);
    }

    private void s() {
        int shadowX = h() ? getShadowX() : 0;
        int shadowY = h() ? getShadowY() : 0;
        this.D = new RectF((this.w / 2) + shadowX, (this.w / 2) + shadowY, (k() - shadowX) - (this.w / 2), (l() - shadowY) - (this.w / 2));
    }

    @TargetApi(16)
    private void setBackgroundCompat(Drawable drawable) {
        if (com.github.clans.fab.b.a()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    int a() {
        if (h()) {
            return getShadowX() * 2;
        }
        return 0;
    }

    void a(int i, int i2, int i3) {
        this.i = i;
        this.j = i2;
        this.l = i3;
    }

    public synchronized void a(int i, boolean z) {
        if (!this.G) {
            this.Q = i;
            this.R = z;
            if (this.C) {
                this.v = true;
                this.z = true;
                s();
                p();
                c();
                if (i < 0) {
                    i = 0;
                } else if (i > this.U) {
                    i = this.U;
                }
                if (i != this.P) {
                    this.P = this.U > 0 ? (i / this.U) * 360.0f : BitmapDescriptorFactory.HUE_RED;
                    this.H = SystemClock.uptimeMillis();
                    if (!z) {
                        this.O = this.P;
                    }
                    invalidate();
                }
            } else {
                this.T = true;
            }
        }
    }

    public void a(boolean z) {
        if (i()) {
            if (z) {
                d();
            }
            super.setVisibility(0);
        }
    }

    int b() {
        if (h()) {
            return getShadowY() * 2;
        }
        return 0;
    }

    public void b(boolean z) {
        if (i()) {
            return;
        }
        if (z) {
            e();
        }
        super.setVisibility(4);
    }

    void c() {
        int i;
        int i2;
        LayerDrawable layerDrawable = h() ? new LayerDrawable(new Drawable[]{new b(), o(), getIconDrawable()}) : new LayerDrawable(new Drawable[]{o(), getIconDrawable()});
        int iMax = getIconDrawable() != null ? Math.max(getIconDrawable().getIntrinsicWidth(), getIconDrawable().getIntrinsicHeight()) : -1;
        int circleSize = getCircleSize();
        if (iMax <= 0) {
            iMax = this.n;
        }
        int i3 = (circleSize - iMax) / 2;
        int iAbs = h() ? this.f4791d + Math.abs(this.f4792e) : 0;
        int iAbs2 = h() ? this.f4791d + Math.abs(this.f4793f) : 0;
        if (this.v) {
            int i4 = iAbs + this.w;
            i = iAbs2 + this.w;
            i2 = i4;
        } else {
            i = iAbs2;
            i2 = iAbs;
        }
        layerDrawable.setLayerInset(h() ? 2 : 1, i2 + i3, i + i3, i2 + i3, i + i3);
        setBackgroundCompat(layerDrawable);
    }

    void d() {
        this.p.cancel();
        startAnimation(this.o);
    }

    void e() {
        this.o.cancel();
        startAnimation(this.p);
    }

    @TargetApi(21)
    void f() {
        if (this.s instanceof StateListDrawable) {
            ((StateListDrawable) this.s).setState(new int[]{R.attr.state_enabled, R.attr.state_pressed});
        } else if (com.github.clans.fab.b.b()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.s;
            rippleDrawable.setState(new int[]{R.attr.state_enabled, R.attr.state_pressed});
            rippleDrawable.setHotspot(m(), n());
            rippleDrawable.setVisible(true, true);
        }
    }

    @TargetApi(21)
    void g() {
        if (this.s instanceof StateListDrawable) {
            ((StateListDrawable) this.s).setState(new int[]{R.attr.state_enabled});
        } else if (com.github.clans.fab.b.b()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.s;
            rippleDrawable.setState(new int[]{R.attr.state_enabled});
            rippleDrawable.setHotspot(m(), n());
            rippleDrawable.setVisible(true, true);
        }
    }

    public int getButtonSize() {
        return this.f4788a;
    }

    public int getColorDisabled() {
        return this.k;
    }

    public int getColorNormal() {
        return this.i;
    }

    public int getColorPressed() {
        return this.j;
    }

    public int getColorRipple() {
        return this.l;
    }

    Animation getHideAnimation() {
        return this.p;
    }

    protected Drawable getIconDrawable() {
        return this.m != null ? this.m : new ColorDrawable(0);
    }

    public String getLabelText() {
        return this.q;
    }

    Label getLabelView() {
        return (Label) getTag(com.github.clans.fab.a.d.fab_label);
    }

    public int getLabelVisibility() {
        Label labelView = getLabelView();
        if (labelView != null) {
            return labelView.getVisibility();
        }
        return -1;
    }

    public synchronized int getMax() {
        return this.U;
    }

    View.OnClickListener getOnClickListener() {
        return this.r;
    }

    public synchronized int getProgress() {
        return this.G ? 0 : this.Q;
    }

    public int getShadowColor() {
        return this.f4790c;
    }

    public int getShadowRadius() {
        return this.f4791d;
    }

    public int getShadowXOffset() {
        return this.f4792e;
    }

    public int getShadowYOffset() {
        return this.f4793f;
    }

    Animation getShowAnimation() {
        return this.o;
    }

    public boolean h() {
        return !this.t && this.f4789b;
    }

    public boolean i() {
        return getVisibility() == 4;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = true;
        super.onDraw(canvas);
        if (this.v) {
            if (this.V) {
                canvas.drawArc(this.D, 360.0f, 360.0f, false, this.E);
            }
            if (this.G) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.H;
                float f2 = (jUptimeMillis * this.I) / 1000.0f;
                a(jUptimeMillis);
                this.O += f2;
                if (this.O > 360.0f) {
                    this.O -= 360.0f;
                }
                this.H = SystemClock.uptimeMillis();
                float f3 = this.O - 90.0f;
                float f4 = this.M + this.N;
                if (isInEditMode()) {
                    f3 = BitmapDescriptorFactory.HUE_RED;
                    f4 = 135.0f;
                }
                canvas.drawArc(this.D, f3, f4, false, this.F);
            } else {
                if (this.O != this.P) {
                    float fUptimeMillis = ((SystemClock.uptimeMillis() - this.H) / 1000.0f) * this.I;
                    if (this.O > this.P) {
                        this.O = Math.max(this.O - fUptimeMillis, this.P);
                    } else {
                        this.O = Math.min(fUptimeMillis + this.O, this.P);
                    }
                    this.H = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                canvas.drawArc(this.D, -90.0f, this.O, false, this.F);
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(k(), l());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ProgressSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ProgressSavedState progressSavedState = (ProgressSavedState) parcelable;
        super.onRestoreInstanceState(progressSavedState.getSuperState());
        this.O = progressSavedState.f4797a;
        this.P = progressSavedState.f4798b;
        this.I = progressSavedState.f4799c;
        this.w = progressSavedState.f4801e;
        this.x = progressSavedState.f4802f;
        this.y = progressSavedState.g;
        this.S = progressSavedState.k;
        this.T = progressSavedState.l;
        this.Q = progressSavedState.f4800d;
        this.R = progressSavedState.m;
        this.V = progressSavedState.n;
        this.H = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ProgressSavedState progressSavedState = new ProgressSavedState(super.onSaveInstanceState());
        progressSavedState.f4797a = this.O;
        progressSavedState.f4798b = this.P;
        progressSavedState.f4799c = this.I;
        progressSavedState.f4801e = this.w;
        progressSavedState.f4802f = this.x;
        progressSavedState.g = this.y;
        progressSavedState.k = this.G;
        progressSavedState.l = this.v && this.Q > 0 && !this.G;
        progressSavedState.f4800d = this.Q;
        progressSavedState.m = this.R;
        progressSavedState.n = this.V;
        return progressSavedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        p();
        if (this.S) {
            setIndeterminate(true);
            this.S = false;
        } else if (this.T) {
            a(this.Q, this.R);
            this.T = false;
        } else if (this.z) {
            q();
            this.z = false;
        }
        super.onSizeChanged(i, i2, i3, i4);
        s();
        r();
        c();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.r != null && isEnabled()) {
            Label label = (Label) getTag(com.github.clans.fab.a.d.fab_label);
            if (label == null) {
                return super.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction()) {
                case 1:
                    if (label != null) {
                        label.e();
                    }
                    g();
                    break;
                case 3:
                    if (label != null) {
                        label.e();
                    }
                    g();
                    break;
            }
            this.g.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setButtonSize(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Use @FabSize constants only!");
        }
        if (this.f4788a != i) {
            this.f4788a = i;
            c();
        }
    }

    public void setColorDisabled(int i) {
        if (i != this.k) {
            this.k = i;
            c();
        }
    }

    public void setColorDisabledResId(int i) {
        setColorDisabled(getResources().getColor(i));
    }

    public void setColorNormal(int i) {
        if (this.i != i) {
            this.i = i;
            c();
        }
    }

    public void setColorNormalResId(int i) {
        setColorNormal(getResources().getColor(i));
    }

    public void setColorPressed(int i) {
        if (i != this.j) {
            this.j = i;
            c();
        }
    }

    public void setColorPressedResId(int i) {
        setColorPressed(getResources().getColor(i));
    }

    public void setColorRipple(int i) {
        if (i != this.l) {
            this.l = i;
            c();
        }
    }

    public void setColorRippleResId(int i) {
        setColorRipple(getResources().getColor(i));
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (!com.github.clans.fab.b.b() || f2 <= BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        super.setElevation(f2);
        if (!isInEditMode()) {
            this.t = true;
            this.f4789b = false;
        }
        c();
    }

    @TargetApi(21)
    public void setElevationCompat(float f2) {
        this.f4790c = 637534208;
        this.f4791d = Math.round(f2 / 2.0f);
        this.f4792e = 0;
        this.f4793f = Math.round(this.f4788a == 0 ? f2 : f2 / 2.0f);
        if (!com.github.clans.fab.b.b()) {
            this.f4789b = true;
            c();
            return;
        }
        super.setElevation(f2);
        this.u = true;
        this.f4789b = false;
        c();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        Label label = (Label) getTag(com.github.clans.fab.a.d.fab_label);
        if (label != null) {
            label.setEnabled(z);
        }
    }

    public void setHideAnimation(Animation animation) {
        this.p = animation;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.m != drawable) {
            this.m = drawable;
            c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (this.m != drawable) {
            this.m = drawable;
            c();
        }
    }

    public synchronized void setIndeterminate(boolean z) {
        if (!z) {
            this.O = BitmapDescriptorFactory.HUE_RED;
        }
        this.v = z;
        this.z = true;
        this.G = z;
        this.H = SystemClock.uptimeMillis();
        s();
        p();
        c();
    }

    public void setLabelText(String str) {
        this.q = str;
        Label labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    public void setLabelVisibility(int i) {
        Label labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
            labelView.setHandleVisibilityChanges(i == 0);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.u) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += getShadowX();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += getShadowY();
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += getShadowX();
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += getShadowY();
        }
        super.setLayoutParams(layoutParams);
    }

    public synchronized void setMax(int i) {
        this.U = i;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.r = onClickListener;
        View view = (View) getTag(com.github.clans.fab.a.d.fab_label);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.github.clans.fab.FloatingActionButton.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FloatingActionButton.this.r != null) {
                        FloatingActionButton.this.r.onClick(FloatingActionButton.this);
                    }
                }
            });
        }
    }

    public void setShadowColor(int i) {
        if (this.f4790c != i) {
            this.f4790c = i;
            c();
        }
    }

    public void setShadowColorResource(int i) {
        int color = getResources().getColor(i);
        if (this.f4790c != color) {
            this.f4790c = color;
            c();
        }
    }

    public void setShadowRadius(float f2) {
        this.f4791d = com.github.clans.fab.b.a(getContext(), f2);
        requestLayout();
        c();
    }

    public void setShadowRadius(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f4791d != dimensionPixelSize) {
            this.f4791d = dimensionPixelSize;
            requestLayout();
            c();
        }
    }

    public void setShadowXOffset(float f2) {
        this.f4792e = com.github.clans.fab.b.a(getContext(), f2);
        requestLayout();
        c();
    }

    public void setShadowXOffset(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f4792e != dimensionPixelSize) {
            this.f4792e = dimensionPixelSize;
            requestLayout();
            c();
        }
    }

    public void setShadowYOffset(float f2) {
        this.f4793f = com.github.clans.fab.b.a(getContext(), f2);
        requestLayout();
        c();
    }

    public void setShadowYOffset(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f4793f != dimensionPixelSize) {
            this.f4793f = dimensionPixelSize;
            requestLayout();
            c();
        }
    }

    public void setShowAnimation(Animation animation) {
        this.o = animation;
    }

    public synchronized void setShowProgressBackground(boolean z) {
        this.V = z;
    }

    public void setShowShadow(boolean z) {
        if (this.f4789b != z) {
            this.f4789b = z;
            c();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        Label label = (Label) getTag(com.github.clans.fab.a.d.fab_label);
        if (label != null) {
            label.setVisibility(i);
        }
    }
}
