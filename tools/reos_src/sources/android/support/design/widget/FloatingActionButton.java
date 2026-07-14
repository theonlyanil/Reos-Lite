package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CoordinatorLayout.c(a = Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ColorStateList f292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PorterDuff.Mode f293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f297f;
    private boolean g;
    private final Rect h;
    private android.support.v7.widget.i i;
    private j j;

    public static class Behavior extends CoordinatorLayout.b<FloatingActionButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final boolean f300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private u f301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Rect f303d;

        static {
            f300a = Build.VERSION.SDK_INT >= 11;
        }

        private float a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            float fMin = BitmapDescriptorFactory.HUE_RED;
            List<View> listD = coordinatorLayout.d(floatingActionButton);
            int size = listD.size();
            int i = 0;
            while (i < size) {
                View view = listD.get(i);
                i++;
                fMin = ((view instanceof Snackbar.SnackbarLayout) && coordinatorLayout.a(floatingActionButton, view)) ? Math.min(fMin, ah.p(view) - view.getHeight()) : fMin;
            }
            return fMin;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).a() == appBarLayout.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                if (this.f303d == null) {
                    this.f303d = new Rect();
                }
                Rect rect = this.f303d;
                x.b(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    floatingActionButton.b(null, false);
                } else {
                    floatingActionButton.a((a) null, false);
                }
                return true;
            }
            return false;
        }

        private void b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            int i2 = 0;
            Rect rect = floatingActionButton.h;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= eVar.leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - eVar.bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= eVar.topMargin) {
                i2 = -rect.top;
            }
            floatingActionButton.offsetTopAndBottom(i2);
            floatingActionButton.offsetLeftAndRight(i);
        }

        private void d(CoordinatorLayout coordinatorLayout, final FloatingActionButton floatingActionButton, View view) {
            float fA = a(coordinatorLayout, floatingActionButton);
            if (this.f302c == fA) {
                return;
            }
            float fP = ah.p(floatingActionButton);
            if (this.f301b != null && this.f301b.b()) {
                this.f301b.e();
            }
            if (!floatingActionButton.isShown() || Math.abs(fP - fA) <= floatingActionButton.getHeight() * 0.667f) {
                ah.b(floatingActionButton, fA);
            } else {
                if (this.f301b == null) {
                    this.f301b = ab.a();
                    this.f301b.a(android.support.design.widget.a.f405b);
                    this.f301b.a(new u.c() { // from class: android.support.design.widget.FloatingActionButton.Behavior.1
                        @Override // android.support.design.widget.u.c
                        public void a(u uVar) {
                            ah.b(floatingActionButton, uVar.d());
                        }
                    });
                }
                this.f301b.a(fP, fA);
                this.f301b.a();
            }
            this.f302c = fA;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> listD = coordinatorLayout.d(floatingActionButton);
            int size = listD.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = listD.get(i2);
                if ((view instanceof AppBarLayout) && a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.a(floatingActionButton, i);
            b(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return f300a && (view instanceof Snackbar.SnackbarLayout);
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof Snackbar.SnackbarLayout) {
                d(coordinatorLayout, floatingActionButton, view);
                return false;
            }
            if (!(view instanceof AppBarLayout)) {
                return false;
            }
            a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof Snackbar.SnackbarLayout) {
                d(coordinatorLayout, floatingActionButton, view);
            }
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class b implements p {
        private b() {
        }

        @Override // android.support.design.widget.p
        public float a() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // android.support.design.widget.p
        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.h.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(FloatingActionButton.this.f297f + i, FloatingActionButton.this.f297f + i2, FloatingActionButton.this.f297f + i3, FloatingActionButton.this.f297f + i4);
        }

        @Override // android.support.design.widget.p
        public void a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // android.support.design.widget.p
        public boolean b() {
            return FloatingActionButton.this.g;
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
        this.h = new Rect();
        t.a(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.FloatingActionButton, i, android.support.design.a.h.Widget_Design_FloatingActionButton);
        this.f292a = typedArrayObtainStyledAttributes.getColorStateList(android.support.design.a.i.FloatingActionButton_backgroundTint);
        this.f293b = a(typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.f295d = typedArrayObtainStyledAttributes.getColor(android.support.design.a.i.FloatingActionButton_rippleColor, 0);
        this.f296e = typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.FloatingActionButton_fabSize, 0);
        this.f294c = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(android.support.design.a.i.FloatingActionButton_elevation, BitmapDescriptorFactory.HUE_RED);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(android.support.design.a.i.FloatingActionButton_pressedTranslationZ, BitmapDescriptorFactory.HUE_RED);
        this.g = typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.FloatingActionButton_useCompatPadding, false);
        typedArrayObtainStyledAttributes.recycle();
        this.i = new android.support.v7.widget.i(this, android.support.v7.widget.h.a());
        this.i.a(attributeSet, i);
        this.f297f = (getSizeDimension() - ((int) getResources().getDimension(android.support.design.a.d.design_fab_image_size))) / 2;
        getImpl().a(this.f292a, this.f293b, this.f295d, this.f294c);
        getImpl().c(dimension);
        getImpl().d(dimension2);
        getImpl().g();
    }

    private static int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 0:
            default:
                return i;
            case 1073741824:
                return size;
        }
    }

    static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            default:
                return mode;
        }
    }

    private j.a a(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new j.a() { // from class: android.support.design.widget.FloatingActionButton.1
            @Override // android.support.design.widget.j.a
            public void a() {
                aVar.a(FloatingActionButton.this);
            }

            @Override // android.support.design.widget.j.a
            public void b() {
                aVar.b(FloatingActionButton.this);
            }
        };
    }

    private j a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            return new k(this, new b());
        }
        return i >= 14 ? new i(this, new b()) : new h(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    private j getImpl() {
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f292a;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f293b;
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public Drawable getContentBackground() {
        return getImpl().f();
    }

    final int getSizeDimension() {
        switch (this.f296e) {
            case 1:
                return getResources().getDimensionPixelSize(android.support.design.a.d.design_fab_size_mini);
            default:
                return getResources().getDimensionPixelSize(android.support.design.a.d.design_fab_size_normal);
        }
    }

    public boolean getUseCompatPadding() {
        return this.g;
    }

    @Override // android.widget.ImageView, android.view.View
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().b();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().h();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().i();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        int iMin = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        setMeasuredDimension(this.h.left + iMin + this.h.right, iMin + this.h.top + this.h.bottom);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f292a != colorStateList) {
            this.f292a = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f293b != mode) {
            this.f293b = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().c(f2);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.i.a(i);
    }

    public void setRippleColor(int i) {
        if (this.f295d != i) {
            this.f295d = i;
            getImpl().a(i);
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.g != z) {
            this.g = z;
            getImpl().c();
        }
    }

    @Override // android.support.design.widget.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }
}
