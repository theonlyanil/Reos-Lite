package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final C0033a f1679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f1680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ActionMenuView f1681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ActionMenuPresenter f1682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f1683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected ba f1684f;
    private boolean g;
    private boolean h;

    /* JADX INFO: renamed from: android.support.v7.widget.a$a, reason: collision with other inner class name */
    protected class C0033a implements be {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1685a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1687c = false;

        protected C0033a() {
        }

        public C0033a a(ba baVar, int i) {
            a.this.f1684f = baVar;
            this.f1685a = i;
            return this;
        }

        @Override // android.support.v4.view.be
        public void a(View view) {
            a.super.setVisibility(0);
            this.f1687c = false;
        }

        @Override // android.support.v4.view.be
        public void b(View view) {
            if (this.f1687c) {
                return;
            }
            a.this.f1684f = null;
            a.super.setVisibility(this.f1685a);
        }

        @Override // android.support.v4.view.be
        public void c(View view) {
            this.f1687c = true;
        }
    }

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1679a = new C0033a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(android.support.v7.b.a.C0029a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1680b = context;
        } else {
            this.f1680b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public ba a(int i, long j) {
        if (this.f1684f != null) {
            this.f1684f.b();
        }
        if (i != 0) {
            ba baVarA = android.support.v4.view.ah.s(this).a(BitmapDescriptorFactory.HUE_RED);
            baVarA.a(j);
            baVarA.a(this.f1679a.a(baVarA, i));
            return baVarA;
        }
        if (getVisibility() != 0) {
            android.support.v4.view.ah.c(this, BitmapDescriptorFactory.HUE_RED);
        }
        ba baVarA2 = android.support.v4.view.ah.s(this).a(1.0f);
        baVarA2.a(j);
        baVarA2.a(this.f1679a.a(baVarA2, i));
        return baVarA2;
    }

    public boolean a() {
        if (this.f1682d != null) {
            return this.f1682d.f();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.f1684f != null ? this.f1679a.f1685a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1683e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, android.support.v7.b.a.k.ActionBar, android.support.v7.b.a.C0029a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(android.support.v7.b.a.k.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        if (this.f1682d != null) {
            this.f1682d.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int iA = android.support.v4.view.t.a(motionEvent);
        if (iA == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (iA == 9 && !zOnHoverEvent) {
                this.h = true;
            }
        }
        if (iA == 10 || iA == 3) {
            this.h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iA = android.support.v4.view.t.a(motionEvent);
        if (iA == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (iA == 0 && !zOnTouchEvent) {
                this.g = true;
            }
        }
        if (iA == 1 || iA == 3) {
            this.g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1683e = i;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1684f != null) {
                this.f1684f.b();
            }
            super.setVisibility(i);
        }
    }
}
