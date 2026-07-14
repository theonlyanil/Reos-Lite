package com.github.clans.fab;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionMenu extends ViewGroup {
    private boolean A;
    private int B;
    private float C;
    private float D;
    private float E;
    private int F;
    private int G;
    private int H;
    private Drawable I;
    private int J;
    private Interpolator K;
    private Interpolator L;
    private boolean M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private ImageView T;
    private Animation U;
    private Animation V;
    private boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    GestureDetector f4810a;
    private int aa;
    private a ab;
    private ValueAnimator ac;
    private ValueAnimator ad;
    private int ae;
    private int af;
    private Context ag;
    private String ah;
    private boolean ai;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimatorSet f4811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimatorSet f4812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AnimatorSet f4813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FloatingActionButton f4815f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private Handler m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private ColorStateList t;
    private float u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    public interface a {
        void a(boolean z);
    }

    public FloatingActionMenu(Context context) {
        this(context, null);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4811b = new AnimatorSet();
        this.f4812c = new AnimatorSet();
        this.f4814e = b.a(getContext(), BitmapDescriptorFactory.HUE_RED);
        this.h = b.a(getContext(), BitmapDescriptorFactory.HUE_RED);
        this.i = b.a(getContext(), BitmapDescriptorFactory.HUE_RED);
        this.m = new Handler();
        this.p = b.a(getContext(), 4.0f);
        this.q = b.a(getContext(), 8.0f);
        this.r = b.a(getContext(), 4.0f);
        this.s = b.a(getContext(), 8.0f);
        this.v = b.a(getContext(), 3.0f);
        this.C = 4.0f;
        this.D = 1.0f;
        this.E = 3.0f;
        this.M = true;
        this.S = true;
        this.f4810a = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.github.clans.fab.FloatingActionMenu.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return FloatingActionMenu.this.W && FloatingActionMenu.this.b();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                FloatingActionMenu.this.c(FloatingActionMenu.this.M);
                return true;
            }
        });
        a(context, attributeSet);
    }

    private void a(int i) {
        this.p = i;
        this.q = i;
        this.r = i;
        this.s = i;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.github.clans.fab.a.e.FloatingActionMenu, 0, 0);
        this.f4814e = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionMenu_menu_buttonSpacing, this.f4814e);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_margin, this.h);
        this.af = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_position, 0);
        this.n = typedArrayObtainStyledAttributes.getResourceId(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_showAnimation, this.af == 0 ? com.github.clans.fab.a.C0082a.fab_slide_in_from_right : com.github.clans.fab.a.C0082a.fab_slide_in_from_left);
        this.o = typedArrayObtainStyledAttributes.getResourceId(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_hideAnimation, this.af == 0 ? com.github.clans.fab.a.C0082a.fab_slide_out_to_right : com.github.clans.fab.a.C0082a.fab_slide_out_to_left);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_paddingTop, this.p);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_paddingRight, this.q);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_paddingBottom, this.r);
        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_paddingLeft, this.s);
        this.t = typedArrayObtainStyledAttributes.getColorStateList(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_textColor);
        if (this.t == null) {
            this.t = ColorStateList.valueOf(-1);
        }
        this.u = typedArrayObtainStyledAttributes.getDimension(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_textSize, getResources().getDimension(com.github.clans.fab.a.b.labels_text_size));
        this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_cornerRadius, this.v);
        this.w = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_showShadow, true);
        this.x = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_colorNormal, -13421773);
        this.y = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_colorPressed, -12303292);
        this.z = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_colorRipple, 1728053247);
        this.A = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.a.e.FloatingActionMenu_menu_showShadow, true);
        this.B = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionMenu_menu_shadowColor, 1711276032);
        this.C = typedArrayObtainStyledAttributes.getDimension(com.github.clans.fab.a.e.FloatingActionMenu_menu_shadowRadius, this.C);
        this.D = typedArrayObtainStyledAttributes.getDimension(com.github.clans.fab.a.e.FloatingActionMenu_menu_shadowXOffset, this.D);
        this.E = typedArrayObtainStyledAttributes.getDimension(com.github.clans.fab.a.e.FloatingActionMenu_menu_shadowYOffset, this.E);
        this.F = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionMenu_menu_colorNormal, -2473162);
        this.G = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionMenu_menu_colorPressed, -1617853);
        this.H = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionMenu_menu_colorRipple, -1711276033);
        this.J = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionMenu_menu_animationDelayPerItem, 50);
        this.I = typedArrayObtainStyledAttributes.getDrawable(com.github.clans.fab.a.e.FloatingActionMenu_menu_icon);
        if (this.I == null) {
            this.I = getResources().getDrawable(com.github.clans.fab.a.c.fab_add);
        }
        this.N = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_singleLine, false);
        this.O = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_ellipsize, 0);
        this.P = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_maxLines, -1);
        this.Q = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionMenu_menu_fab_size, 0);
        this.R = typedArrayObtainStyledAttributes.getResourceId(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_style, 0);
        this.aa = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.a.e.FloatingActionMenu_menu_openDirection, 0);
        this.ae = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.a.e.FloatingActionMenu_menu_backgroundColor, 0);
        if (typedArrayObtainStyledAttributes.hasValue(com.github.clans.fab.a.e.FloatingActionMenu_menu_fab_label)) {
            this.ai = true;
            this.ah = typedArrayObtainStyledAttributes.getString(com.github.clans.fab.a.e.FloatingActionMenu_menu_fab_label);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_padding)) {
            a(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.a.e.FloatingActionMenu_menu_labels_padding, 0));
        }
        this.K = new OvershootInterpolator();
        this.L = new AnticipateInterpolator();
        this.ag = new ContextThemeWrapper(getContext(), this.R);
        c();
        e();
        a(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(TypedArray typedArray) {
        setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(com.github.clans.fab.a.e.FloatingActionMenu_menu_fab_show_animation, com.github.clans.fab.a.C0082a.fab_scale_up)));
        setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(com.github.clans.fab.a.e.FloatingActionMenu_menu_fab_hide_animation, com.github.clans.fab.a.C0082a.fab_scale_down)));
    }

    private void a(FloatingActionButton floatingActionButton) {
        String labelText = floatingActionButton.getLabelText();
        if (TextUtils.isEmpty(labelText)) {
            return;
        }
        Label label = new Label(this.ag);
        label.setClickable(true);
        label.setFab(floatingActionButton);
        label.setShowAnimation(AnimationUtils.loadAnimation(getContext(), this.n));
        label.setHideAnimation(AnimationUtils.loadAnimation(getContext(), this.o));
        if (this.R > 0) {
            label.setTextAppearance(getContext(), this.R);
            label.setShowShadow(false);
            label.setUsingStyle(true);
        } else {
            label.a(this.x, this.y, this.z);
            label.setShowShadow(this.w);
            label.setCornerRadius(this.v);
            if (this.O > 0) {
                setLabelEllipsize(label);
            }
            label.setMaxLines(this.P);
            label.c();
            label.setTextSize(0, this.u);
            label.setTextColor(this.t);
            int shadowRadius = this.s;
            int shadowRadius2 = this.p;
            if (this.w) {
                shadowRadius += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowXOffset());
                shadowRadius2 += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowYOffset());
            }
            label.setPadding(shadowRadius, shadowRadius2, this.s, this.p);
            if (this.P < 0 || this.N) {
                label.setSingleLine(this.N);
            }
        }
        label.setText(labelText);
        label.setOnClickListener(floatingActionButton.getOnClickListener());
        addView(label);
        floatingActionButton.setTag(com.github.clans.fab.a.d.fab_label, label);
    }

    private int b(int i) {
        return (int) ((((double) i) * 0.03d) + ((double) i));
    }

    private void c() {
        int iAlpha = Color.alpha(this.ae);
        final int iRed = Color.red(this.ae);
        final int iGreen = Color.green(this.ae);
        final int iBlue = Color.blue(this.ae);
        this.ac = ValueAnimator.ofInt(0, iAlpha);
        this.ac.setDuration(300L);
        this.ac.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.clans.fab.FloatingActionMenu.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), iRed, iGreen, iBlue));
            }
        });
        this.ad = ValueAnimator.ofInt(iAlpha, 0);
        this.ad.setDuration(300L);
        this.ad.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.clans.fab.FloatingActionMenu.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), iRed, iGreen, iBlue));
            }
        });
    }

    private boolean d() {
        return this.ae != 0;
    }

    private void e() {
        this.f4815f = new FloatingActionButton(getContext());
        this.f4815f.f4789b = this.A;
        if (this.A) {
            this.f4815f.f4791d = b.a(getContext(), this.C);
            this.f4815f.f4792e = b.a(getContext(), this.D);
            this.f4815f.f4793f = b.a(getContext(), this.E);
        }
        this.f4815f.a(this.F, this.G, this.H);
        this.f4815f.f4790c = this.B;
        this.f4815f.f4788a = this.Q;
        this.f4815f.c();
        this.f4815f.setLabelText(this.ah);
        this.T = new ImageView(getContext());
        this.T.setImageDrawable(this.I);
        addView(this.f4815f, super.generateDefaultLayoutParams());
        addView(this.T);
        f();
    }

    private void f() {
        float f2;
        float f3 = -135.0f;
        if (this.aa == 0) {
            f2 = this.af == 0 ? -135.0f : 135.0f;
            if (this.af != 0) {
                f3 = 135.0f;
            }
        } else {
            f2 = this.af == 0 ? 135.0f : -135.0f;
            f3 = this.af != 0 ? -135.0f : 135.0f;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.T, "rotation", f2, BitmapDescriptorFactory.HUE_RED);
        this.f4811b.play(ObjectAnimator.ofFloat(this.T, "rotation", BitmapDescriptorFactory.HUE_RED, f3));
        this.f4812c.play(objectAnimatorOfFloat);
        this.f4811b.setInterpolator(this.K);
        this.f4812c.setInterpolator(this.L);
        this.f4811b.setDuration(300L);
        this.f4812c.setDuration(300L);
    }

    private void g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.j) {
                return;
            }
            if (getChildAt(i2) != this.T) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i2);
                if (floatingActionButton.getTag(com.github.clans.fab.a.d.fab_label) == null) {
                    a(floatingActionButton);
                    if (floatingActionButton == this.f4815f) {
                        this.f4815f.setOnClickListener(new View.OnClickListener() { // from class: com.github.clans.fab.FloatingActionMenu.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                FloatingActionMenu.this.a(FloatingActionMenu.this.M);
                            }
                        });
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private void setLabelEllipsize(Label label) {
        switch (this.O) {
            case 1:
                label.setEllipsize(TextUtils.TruncateAt.START);
                break;
            case 2:
                label.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                break;
            case 3:
                label.setEllipsize(TextUtils.TruncateAt.END);
                break;
            case 4:
                label.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public void a(boolean z) {
        if (b()) {
            c(z);
        } else {
            b(z);
        }
    }

    public void b(final boolean z) {
        int i;
        int i2;
        int i3 = 0;
        if (b()) {
            return;
        }
        if (d()) {
            this.ac.start();
        }
        if (this.S) {
            if (this.f4813d != null) {
                this.f4813d.start();
            } else {
                this.f4812c.cancel();
                this.f4811b.start();
            }
        }
        this.l = true;
        int childCount = getChildCount() - 1;
        int i4 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (!(childAt instanceof FloatingActionButton) || childAt.getVisibility() == 8) {
                i = i3;
                i2 = i4;
            } else {
                int i5 = i3 + 1;
                final FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                this.m.postDelayed(new Runnable() { // from class: com.github.clans.fab.FloatingActionMenu.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FloatingActionMenu.this.b()) {
                            return;
                        }
                        if (floatingActionButton != FloatingActionMenu.this.f4815f) {
                            floatingActionButton.a(z);
                        }
                        Label label = (Label) floatingActionButton.getTag(com.github.clans.fab.a.d.fab_label);
                        if (label == null || !label.f()) {
                            return;
                        }
                        label.a(z);
                    }
                }, i4);
                i2 = this.J + i4;
                i = i5;
            }
            childCount--;
            i4 = i2;
            i3 = i;
        }
        this.m.postDelayed(new Runnable() { // from class: com.github.clans.fab.FloatingActionMenu.6
            @Override // java.lang.Runnable
            public void run() {
                FloatingActionMenu.this.k = true;
                if (FloatingActionMenu.this.ab != null) {
                    FloatingActionMenu.this.ab.a(true);
                }
            }
        }, (i3 + 1) * this.J);
    }

    public boolean b() {
        return this.k;
    }

    public void c(final boolean z) {
        if (b()) {
            if (d()) {
                this.ad.start();
            }
            if (this.S) {
                if (this.f4813d != null) {
                    this.f4813d.start();
                } else {
                    this.f4812c.start();
                    this.f4811b.cancel();
                }
            }
            this.l = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i++;
                    final FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                    this.m.postDelayed(new Runnable() { // from class: com.github.clans.fab.FloatingActionMenu.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (FloatingActionMenu.this.b()) {
                                if (floatingActionButton != FloatingActionMenu.this.f4815f) {
                                    floatingActionButton.b(z);
                                }
                                Label label = (Label) floatingActionButton.getTag(com.github.clans.fab.a.d.fab_label);
                                if (label == null || !label.f()) {
                                    return;
                                }
                                label.b(z);
                            }
                        }
                    }, i2);
                    i2 += this.J;
                }
            }
            this.m.postDelayed(new Runnable() { // from class: com.github.clans.fab.FloatingActionMenu.8
                @Override // java.lang.Runnable
                public void run() {
                    FloatingActionMenu.this.k = false;
                    if (FloatingActionMenu.this.ab != null) {
                        FloatingActionMenu.this.ab.a(false);
                    }
                }
            }, (i + 1) * this.J);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    public int getAnimationDelayPerItem() {
        return this.J;
    }

    public AnimatorSet getIconToggleAnimatorSet() {
        return this.f4813d;
    }

    public int getMenuButtonColorNormal() {
        return this.F;
    }

    public int getMenuButtonColorPressed() {
        return this.G;
    }

    public int getMenuButtonColorRipple() {
        return this.H;
    }

    public String getMenuButtonLabelText() {
        return this.ah;
    }

    public ImageView getMenuIconView() {
        return this.T;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.f4815f);
        bringChildToFront(this.T);
        this.j = getChildCount();
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingRight = this.af == 0 ? ((i3 - i) - (this.g / 2)) - getPaddingRight() : (this.g / 2) + getPaddingLeft();
        boolean z2 = this.aa == 0;
        int measuredHeight = z2 ? ((i4 - i2) - this.f4815f.getMeasuredHeight()) - getPaddingBottom() : getPaddingTop();
        int measuredWidth = paddingRight - (this.f4815f.getMeasuredWidth() / 2);
        this.f4815f.layout(measuredWidth, measuredHeight, this.f4815f.getMeasuredWidth() + measuredWidth, this.f4815f.getMeasuredHeight() + measuredHeight);
        int measuredWidth2 = paddingRight - (this.T.getMeasuredWidth() / 2);
        int measuredHeight2 = ((this.f4815f.getMeasuredHeight() / 2) + measuredHeight) - (this.T.getMeasuredHeight() / 2);
        this.T.layout(measuredWidth2, measuredHeight2, this.T.getMeasuredWidth() + measuredWidth2, this.T.getMeasuredHeight() + measuredHeight2);
        if (z2) {
            measuredHeight = measuredHeight + this.f4815f.getMeasuredHeight() + this.f4814e;
        }
        int measuredHeight3 = measuredHeight;
        for (int i5 = this.j - 1; i5 >= 0; i5--) {
            View childAt = getChildAt(i5);
            if (childAt != this.T) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                if (floatingActionButton.getVisibility() != 8) {
                    int measuredWidth3 = paddingRight - (floatingActionButton.getMeasuredWidth() / 2);
                    int measuredHeight4 = z2 ? (measuredHeight3 - floatingActionButton.getMeasuredHeight()) - this.f4814e : measuredHeight3;
                    if (floatingActionButton != this.f4815f) {
                        floatingActionButton.layout(measuredWidth3, measuredHeight4, floatingActionButton.getMeasuredWidth() + measuredWidth3, floatingActionButton.getMeasuredHeight() + measuredHeight4);
                        if (!this.l) {
                            floatingActionButton.b(false);
                        }
                    }
                    View view = (View) floatingActionButton.getTag(com.github.clans.fab.a.d.fab_label);
                    if (view != null) {
                        int measuredWidth4 = (this.ai ? this.g / 2 : floatingActionButton.getMeasuredWidth() / 2) + this.h;
                        int i6 = this.af == 0 ? paddingRight - measuredWidth4 : measuredWidth4 + paddingRight;
                        int measuredWidth5 = this.af == 0 ? i6 - view.getMeasuredWidth() : view.getMeasuredWidth() + i6;
                        int i7 = this.af == 0 ? measuredWidth5 : i6;
                        if (this.af != 0) {
                            i6 = measuredWidth5;
                        }
                        int measuredHeight5 = ((floatingActionButton.getMeasuredHeight() - view.getMeasuredHeight()) / 2) + (measuredHeight4 - this.i);
                        view.layout(i7, measuredHeight5, i6, view.getMeasuredHeight() + measuredHeight5);
                        if (!this.l) {
                            view.setVisibility(4);
                        }
                    }
                    measuredHeight3 = z2 ? measuredHeight4 - this.f4814e : childAt.getMeasuredHeight() + measuredHeight4 + this.f4814e;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMax;
        int i3;
        this.g = 0;
        int i4 = 0;
        measureChildWithMargins(this.T, i, 0, i2, 0);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.j) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && childAt != this.T) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                this.g = Math.max(this.g, childAt.getMeasuredWidth());
            }
            i5 = i6 + 1;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < this.j) {
            View childAt2 = getChildAt(i7);
            if (childAt2.getVisibility() == 8) {
                iMax = i4;
                i3 = i8;
            } else if (childAt2 == this.T) {
                iMax = i4;
                i3 = i8;
            } else {
                int measuredWidth = 0 + childAt2.getMeasuredWidth();
                int measuredHeight = i8 + childAt2.getMeasuredHeight();
                Label label = (Label) childAt2.getTag(com.github.clans.fab.a.d.fab_label);
                if (label != null) {
                    int measuredWidth2 = (this.g - childAt2.getMeasuredWidth()) / (this.ai ? 1 : 2);
                    measureChildWithMargins(label, i, childAt2.getMeasuredWidth() + label.a() + this.h + measuredWidth2, i2, 0);
                    iMax = Math.max(i4, label.getMeasuredWidth() + measuredWidth + measuredWidth2);
                    i3 = measuredHeight;
                } else {
                    iMax = i4;
                    i3 = measuredHeight;
                }
            }
            i7++;
            i4 = iMax;
            i8 = i3;
        }
        setMeasuredDimension(getLayoutParams().width == -1 ? getDefaultSize(getSuggestedMinimumWidth(), i) : Math.max(this.g, this.h + i4) + getPaddingLeft() + getPaddingRight(), getLayoutParams().height == -1 ? getDefaultSize(getSuggestedMinimumHeight(), i2) : b(i8 + (this.f4814e * (this.j - 1)) + getPaddingTop() + getPaddingBottom()));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.W ? this.f4810a.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void setAnimated(boolean z) {
        this.M = z;
        this.f4811b.setDuration(z ? 300L : 0L);
        this.f4812c.setDuration(z ? 300L : 0L);
    }

    public void setAnimationDelayPerItem(int i) {
        this.J = i;
    }

    public void setClosedOnTouchOutside(boolean z) {
        this.W = z;
    }

    public void setIconAnimated(boolean z) {
        this.S = z;
    }

    public void setIconAnimationCloseInterpolator(Interpolator interpolator) {
        this.f4812c.setInterpolator(interpolator);
    }

    public void setIconAnimationInterpolator(Interpolator interpolator) {
        this.f4811b.setInterpolator(interpolator);
        this.f4812c.setInterpolator(interpolator);
    }

    public void setIconAnimationOpenInterpolator(Interpolator interpolator) {
        this.f4811b.setInterpolator(interpolator);
    }

    public void setIconToggleAnimatorSet(AnimatorSet animatorSet) {
        this.f4813d = animatorSet;
    }

    public void setMenuButtonColorNormal(int i) {
        this.F = i;
        this.f4815f.setColorNormal(i);
    }

    public void setMenuButtonColorNormalResId(int i) {
        this.F = getResources().getColor(i);
        this.f4815f.setColorNormalResId(i);
    }

    public void setMenuButtonColorPressed(int i) {
        this.G = i;
        this.f4815f.setColorPressed(i);
    }

    public void setMenuButtonColorPressedResId(int i) {
        this.G = getResources().getColor(i);
        this.f4815f.setColorPressedResId(i);
    }

    public void setMenuButtonColorRipple(int i) {
        this.H = i;
        this.f4815f.setColorRipple(i);
    }

    public void setMenuButtonColorRippleResId(int i) {
        this.H = getResources().getColor(i);
        this.f4815f.setColorRippleResId(i);
    }

    public void setMenuButtonHideAnimation(Animation animation) {
        this.V = animation;
        this.f4815f.setHideAnimation(animation);
    }

    public void setMenuButtonLabelText(String str) {
        this.f4815f.setLabelText(str);
    }

    public void setMenuButtonShowAnimation(Animation animation) {
        this.U = animation;
        this.f4815f.setShowAnimation(animation);
    }

    public void setOnMenuButtonClickListener(View.OnClickListener onClickListener) {
        this.f4815f.setOnClickListener(onClickListener);
    }

    public void setOnMenuToggleListener(a aVar) {
        this.ab = aVar;
    }
}
