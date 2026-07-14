package com.getbase.floatingactionbutton;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionsMenu extends ViewGroup {
    private static Interpolator v = new OvershootInterpolator();
    private static Interpolator w = new DecelerateInterpolator(3.0f);
    private static Interpolator x = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4774f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private AnimatorSet k;
    private AnimatorSet l;
    private AddFloatingActionButton m;
    private c n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private com.getbase.floatingactionbutton.b t;
    private b u;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.getbase.floatingactionbutton.FloatingActionsMenu.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4776a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4776a = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4776a ? 1 : 0);
        }
    }

    private class a extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ObjectAnimator f4778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ObjectAnimator f4779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ObjectAnimator f4780d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ObjectAnimator f4781e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f4782f;

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4778b = new ObjectAnimator();
            this.f4779c = new ObjectAnimator();
            this.f4780d = new ObjectAnimator();
            this.f4781e = new ObjectAnimator();
            this.f4778b.setInterpolator(FloatingActionsMenu.v);
            this.f4779c.setInterpolator(FloatingActionsMenu.x);
            this.f4780d.setInterpolator(FloatingActionsMenu.w);
            this.f4781e.setInterpolator(FloatingActionsMenu.w);
            this.f4781e.setProperty(View.ALPHA);
            this.f4781e.setFloatValues(1.0f, BitmapDescriptorFactory.HUE_RED);
            this.f4779c.setProperty(View.ALPHA);
            this.f4779c.setFloatValues(BitmapDescriptorFactory.HUE_RED, 1.0f);
            switch (FloatingActionsMenu.this.f4774f) {
                case 0:
                case 1:
                    this.f4780d.setProperty(View.TRANSLATION_Y);
                    this.f4778b.setProperty(View.TRANSLATION_Y);
                    break;
                case 2:
                case 3:
                    this.f4780d.setProperty(View.TRANSLATION_X);
                    this.f4778b.setProperty(View.TRANSLATION_X);
                    break;
            }
        }

        public void a(View view) {
            this.f4781e.setTarget(view);
            this.f4780d.setTarget(view);
            this.f4779c.setTarget(view);
            this.f4778b.setTarget(view);
            if (this.f4782f) {
                return;
            }
            FloatingActionsMenu.this.l.play(this.f4781e);
            FloatingActionsMenu.this.l.play(this.f4780d);
            FloatingActionsMenu.this.k.play(this.f4779c);
            FloatingActionsMenu.this.k.play(this.f4778b);
            this.f4782f = true;
        }
    }

    public interface b {
        void a();

        void b();
    }

    private static class c extends LayerDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f4783a;

        public c(Drawable drawable) {
            super(new Drawable[]{drawable});
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.f4783a, getBounds().centerX(), getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }

        public float getRotation() {
            return this.f4783a;
        }

        public void setRotation(float f2) {
            this.f4783a = f2;
            invalidateSelf();
        }
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new AnimatorSet().setDuration(300L);
        this.l = new AnimatorSet().setDuration(300L);
        a(context, attributeSet);
    }

    private int a(int i) {
        return getResources().getColor(i);
    }

    private void a(Context context) {
        this.m = new AddFloatingActionButton(context) { // from class: com.getbase.floatingactionbutton.FloatingActionsMenu.1
            @Override // com.getbase.floatingactionbutton.FloatingActionButton
            void a() {
                this.f4750a = FloatingActionsMenu.this.f4769a;
                this.f4757b = FloatingActionsMenu.this.f4770b;
                this.f4758c = FloatingActionsMenu.this.f4771c;
                this.f4761f = FloatingActionsMenu.this.f4773e;
                super.a();
            }

            @Override // com.getbase.floatingactionbutton.AddFloatingActionButton, com.getbase.floatingactionbutton.FloatingActionButton
            Drawable getIconDrawable() {
                c cVar = new c(super.getIconDrawable());
                FloatingActionsMenu.this.n = cVar;
                OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cVar, "rotation", 135.0f, BitmapDescriptorFactory.HUE_RED);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(cVar, "rotation", BitmapDescriptorFactory.HUE_RED, 135.0f);
                objectAnimatorOfFloat.setInterpolator(overshootInterpolator);
                objectAnimatorOfFloat2.setInterpolator(overshootInterpolator);
                FloatingActionsMenu.this.k.play(objectAnimatorOfFloat2);
                FloatingActionsMenu.this.l.play(objectAnimatorOfFloat);
                return cVar;
            }
        };
        this.m.setId(com.getbase.floatingactionbutton.a.c.fab_expand_menu_button);
        this.m.setSize(this.f4772d);
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.getbase.floatingactionbutton.FloatingActionsMenu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatingActionsMenu.this.b();
            }
        });
        addView(this.m, super.generateDefaultLayoutParams());
        this.s++;
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.g = (int) ((getResources().getDimension(com.getbase.floatingactionbutton.a.C0081a.fab_actions_spacing) - getResources().getDimension(com.getbase.floatingactionbutton.a.C0081a.fab_shadow_radius)) - getResources().getDimension(com.getbase.floatingactionbutton.a.C0081a.fab_shadow_offset));
        this.h = getResources().getDimensionPixelSize(com.getbase.floatingactionbutton.a.C0081a.fab_labels_margin);
        this.i = getResources().getDimensionPixelSize(com.getbase.floatingactionbutton.a.C0081a.fab_shadow_offset);
        this.t = new com.getbase.floatingactionbutton.b(this);
        setTouchDelegate(this.t);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.getbase.floatingactionbutton.a.d.FloatingActionsMenu, 0, 0);
        this.f4769a = typedArrayObtainStyledAttributes.getColor(com.getbase.floatingactionbutton.a.d.FloatingActionsMenu_fab_addButtonPlusIconColor, a(R.color.white));
        this.f4770b = typedArrayObtainStyledAttributes.getColor(com.getbase.floatingactionbutton.a.d.FloatingActionsMenu_fab_addButtonColorNormal, a(R.color.holo_blue_dark));
        this.f4771c = typedArrayObtainStyledAttributes.getColor(com.getbase.floatingactionbutton.a.d.FloatingActionsMenu_fab_addButtonColorPressed, a(R.color.holo_blue_light));
        this.f4772d = typedArrayObtainStyledAttributes.getInt(com.getbase.floatingactionbutton.a.d.FloatingActionsMenu_fab_addButtonSize, 0);
        this.f4773e = typedArrayObtainStyledAttributes.getBoolean(com.getbase.floatingactionbutton.a.d.FloatingActionsMenu_fab_addButtonStrokeVisible, true);
        this.f4774f = typedArrayObtainStyledAttributes.getInt(com.getbase.floatingactionbutton.a.d.FloatingActionsMenu_fab_expandDirection, 0);
        this.q = typedArrayObtainStyledAttributes.getResourceId(com.getbase.floatingactionbutton.a.d.FloatingActionsMenu_fab_labelStyle, 0);
        this.r = typedArrayObtainStyledAttributes.getInt(com.getbase.floatingactionbutton.a.d.FloatingActionsMenu_fab_labelsPosition, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (this.q != 0 && g()) {
            throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
        }
        a(context);
    }

    private void a(boolean z) {
        if (this.j) {
            this.j = false;
            this.t.a(false);
            this.l.setDuration(z ? 0L : 300L);
            this.l.start();
            this.k.cancel();
            if (this.u != null) {
                this.u.b();
            }
        }
    }

    private int b(int i) {
        return (i * 12) / 10;
    }

    private boolean g() {
        return this.f4774f == 2 || this.f4774f == 3;
    }

    private void h() {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.q);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.s) {
                return;
            }
            FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i2);
            String title = floatingActionButton.getTitle();
            if (floatingActionButton != this.m && title != null && floatingActionButton.getTag(com.getbase.floatingactionbutton.a.c.fab_label) == null) {
                TextView textView = new TextView(contextThemeWrapper);
                textView.setTextAppearance(getContext(), this.q);
                textView.setText(floatingActionButton.getTitle());
                addView(textView);
                floatingActionButton.setTag(com.getbase.floatingactionbutton.a.c.fab_label, textView);
            }
            i = i2 + 1;
        }
    }

    public void a() {
        a(false);
    }

    public void b() {
        if (this.j) {
            a();
        } else {
            c();
        }
    }

    public void c() {
        if (this.j) {
            return;
        }
        this.j = true;
        this.t.a(true);
        this.l.cancel();
        this.k.start();
        if (this.u != null) {
            this.u.a();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(super.generateDefaultLayoutParams());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(super.generateLayoutParams(attributeSet));
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(super.generateLayoutParams(layoutParams));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.m);
        this.s = getChildCount();
        if (this.q != 0) {
            h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        switch (this.f4774f) {
            case 0:
            case 1:
                boolean z2 = this.f4774f == 0;
                if (z) {
                    this.t.a();
                }
                int measuredHeight = z2 ? (i4 - i2) - this.m.getMeasuredHeight() : 0;
                int i5 = this.r == 0 ? (i3 - i) - (this.o / 2) : this.o / 2;
                int measuredWidth = i5 - (this.m.getMeasuredWidth() / 2);
                this.m.layout(measuredWidth, measuredHeight, this.m.getMeasuredWidth() + measuredWidth, this.m.getMeasuredHeight() + measuredHeight);
                int i6 = (this.o / 2) + this.h;
                int i7 = this.r == 0 ? i5 - i6 : i5 + i6;
                int measuredHeight2 = z2 ? measuredHeight - this.g : this.m.getMeasuredHeight() + measuredHeight + this.g;
                for (int i8 = this.s - 1; i8 >= 0; i8--) {
                    View childAt = getChildAt(i8);
                    if (childAt != this.m && childAt.getVisibility() != 8) {
                        int measuredWidth2 = i5 - (childAt.getMeasuredWidth() / 2);
                        int measuredHeight3 = z2 ? measuredHeight2 - childAt.getMeasuredHeight() : measuredHeight2;
                        childAt.layout(measuredWidth2, measuredHeight3, childAt.getMeasuredWidth() + measuredWidth2, childAt.getMeasuredHeight() + measuredHeight3);
                        float f2 = measuredHeight - measuredHeight3;
                        childAt.setTranslationY(this.j ? 0.0f : f2);
                        childAt.setAlpha(this.j ? 1.0f : BitmapDescriptorFactory.HUE_RED);
                        a aVar = (a) childAt.getLayoutParams();
                        aVar.f4780d.setFloatValues(BitmapDescriptorFactory.HUE_RED, f2);
                        aVar.f4778b.setFloatValues(f2, BitmapDescriptorFactory.HUE_RED);
                        aVar.a(childAt);
                        View view = (View) childAt.getTag(com.getbase.floatingactionbutton.a.c.fab_label);
                        if (view != null) {
                            int measuredWidth3 = this.r == 0 ? i7 - view.getMeasuredWidth() : view.getMeasuredWidth() + i7;
                            int i9 = this.r == 0 ? measuredWidth3 : i7;
                            if (this.r == 0) {
                                measuredWidth3 = i7;
                            }
                            int measuredHeight4 = (measuredHeight3 - this.i) + ((childAt.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                            view.layout(i9, measuredHeight4, measuredWidth3, view.getMeasuredHeight() + measuredHeight4);
                            this.t.a(new TouchDelegate(new Rect(Math.min(measuredWidth2, i9), measuredHeight3 - (this.g / 2), Math.max(measuredWidth2 + childAt.getMeasuredWidth(), measuredWidth3), childAt.getMeasuredHeight() + measuredHeight3 + (this.g / 2)), childAt));
                            view.setTranslationY(this.j ? 0.0f : f2);
                            view.setAlpha(this.j ? 1.0f : BitmapDescriptorFactory.HUE_RED);
                            a aVar2 = (a) view.getLayoutParams();
                            aVar2.f4780d.setFloatValues(BitmapDescriptorFactory.HUE_RED, f2);
                            aVar2.f4778b.setFloatValues(f2, BitmapDescriptorFactory.HUE_RED);
                            aVar2.a(view);
                        }
                        measuredHeight2 = z2 ? measuredHeight3 - this.g : childAt.getMeasuredHeight() + measuredHeight3 + this.g;
                    }
                }
                break;
            case 2:
            case 3:
                boolean z3 = this.f4774f == 2;
                int measuredWidth4 = z3 ? (i3 - i) - this.m.getMeasuredWidth() : 0;
                int measuredHeight5 = ((i4 - i2) - this.p) + ((this.p - this.m.getMeasuredHeight()) / 2);
                this.m.layout(measuredWidth4, measuredHeight5, this.m.getMeasuredWidth() + measuredWidth4, this.m.getMeasuredHeight() + measuredHeight5);
                int measuredWidth5 = z3 ? measuredWidth4 - this.g : this.m.getMeasuredWidth() + measuredWidth4 + this.g;
                for (int i10 = this.s - 1; i10 >= 0; i10--) {
                    View childAt2 = getChildAt(i10);
                    if (childAt2 != this.m && childAt2.getVisibility() != 8) {
                        int measuredWidth6 = z3 ? measuredWidth5 - childAt2.getMeasuredWidth() : measuredWidth5;
                        int measuredHeight6 = ((this.m.getMeasuredHeight() - childAt2.getMeasuredHeight()) / 2) + measuredHeight5;
                        childAt2.layout(measuredWidth6, measuredHeight6, childAt2.getMeasuredWidth() + measuredWidth6, childAt2.getMeasuredHeight() + measuredHeight6);
                        float f3 = measuredWidth4 - measuredWidth6;
                        childAt2.setTranslationX(this.j ? 0.0f : f3);
                        childAt2.setAlpha(this.j ? 1.0f : BitmapDescriptorFactory.HUE_RED);
                        a aVar3 = (a) childAt2.getLayoutParams();
                        aVar3.f4780d.setFloatValues(BitmapDescriptorFactory.HUE_RED, f3);
                        aVar3.f4778b.setFloatValues(f3, BitmapDescriptorFactory.HUE_RED);
                        aVar3.a(childAt2);
                        measuredWidth5 = z3 ? measuredWidth6 - this.g : childAt2.getMeasuredWidth() + measuredWidth6 + this.g;
                    }
                }
                break;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int measuredHeight;
        TextView textView;
        measureChildren(i, i2);
        this.o = 0;
        this.p = 0;
        int i4 = 0;
        int iMax = 0;
        int iB = 0;
        int iB2 = 0;
        while (i4 < this.s) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8) {
                i3 = iB2;
                measuredHeight = iB;
            } else {
                switch (this.f4774f) {
                    case 0:
                    case 1:
                        this.o = Math.max(this.o, childAt.getMeasuredWidth());
                        i3 = iB2;
                        measuredHeight = iB + childAt.getMeasuredHeight();
                        break;
                    case 2:
                    case 3:
                        iB2 += childAt.getMeasuredWidth();
                        this.p = Math.max(this.p, childAt.getMeasuredHeight());
                    default:
                        i3 = iB2;
                        measuredHeight = iB;
                        break;
                }
                if (!g() && (textView = (TextView) childAt.getTag(com.getbase.floatingactionbutton.a.c.fab_label)) != null) {
                    iMax = Math.max(iMax, textView.getMeasuredWidth());
                }
            }
            i4++;
            iB = measuredHeight;
            iB2 = i3;
        }
        if (g()) {
            iB = this.p;
        } else {
            iB2 = this.o + (iMax > 0 ? this.h + iMax : 0);
        }
        switch (this.f4774f) {
            case 0:
            case 1:
                iB = b(iB + (this.g * (this.s - 1)));
                break;
            case 2:
            case 3:
                iB2 = b((this.g * (this.s - 1)) + iB2);
                break;
        }
        setMeasuredDimension(iB2, iB);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.j = savedState.f4776a;
        this.t.a(this.j);
        if (this.n != null) {
            this.n.setRotation(this.j ? 135.0f : BitmapDescriptorFactory.HUE_RED);
        }
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4776a = this.j;
        return savedState;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.m.setEnabled(z);
    }

    public void setOnFloatingActionsMenuUpdateListener(b bVar) {
        this.u = bVar;
    }
}
