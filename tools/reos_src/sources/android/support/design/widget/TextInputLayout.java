package android.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ah;
import android.support.v4.view.bf;
import android.support.v4.widget.Space;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EditText f390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LinearLayout f394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f395f;
    private boolean g;
    private TextView h;
    private int i;
    private boolean j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private ColorStateList r;
    private ColorStateList s;
    private final d t;
    private boolean u;
    private u v;
    private boolean w;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.design.widget.TextInputLayout.SavedState.1
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
        CharSequence f401a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f401a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f401a) + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f401a, parcel, i);
        }
    }

    private class a extends android.support.v4.view.a {
        private a() {
        }

        @Override // android.support.v4.view.a
        public void a(View view, android.support.v4.view.a.c cVar) {
            super.a(view, cVar);
            cVar.b((CharSequence) TextInputLayout.class.getSimpleName());
            CharSequence charSequenceI = TextInputLayout.this.t.i();
            if (!TextUtils.isEmpty(charSequenceI)) {
                cVar.c(charSequenceI);
            }
            if (TextInputLayout.this.f390a != null) {
                cVar.d(TextInputLayout.this.f390a);
            }
            CharSequence text = TextInputLayout.this.h != null ? TextInputLayout.this.h.getText() : null;
            if (TextUtils.isEmpty(text)) {
                return;
            }
            cVar.j(true);
            cVar.e(text);
        }

        @Override // android.support.v4.view.a
        public void a(View view, AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        @Override // android.support.v4.view.a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            CharSequence charSequenceI = TextInputLayout.this.t.i();
            if (TextUtils.isEmpty(charSequenceI)) {
                return;
            }
            accessibilityEvent.getText().add(charSequenceI);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.t = new d(this);
        t.a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.t.a(android.support.design.widget.a.f405b);
        this.t.b(new AccelerateInterpolator());
        this.t.d(8388659);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.TextInputLayout, i, android.support.design.a.h.Widget_Design_TextInputLayout);
        this.f391b = typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.TextInputLayout_hintEnabled, true);
        setHint(typedArrayObtainStyledAttributes.getText(android.support.design.a.i.TextInputLayout_android_hint));
        this.u = typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.TextInputLayout_hintAnimationEnabled, true);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(android.support.design.a.i.TextInputLayout_android_textColorHint);
            this.s = colorStateList;
            this.r = colorStateList;
        }
        if (typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.TextInputLayout_hintTextAppearance, 0));
        }
        this.i = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.TextInputLayout_errorTextAppearance, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.TextInputLayout_errorEnabled, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.TextInputLayout_counterMaxLength, -1));
        this.o = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.TextInputLayout_counterTextAppearance, 0);
        this.p = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.TextInputLayout_counterOverflowTextAppearance, 0);
        typedArrayObtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        if (ah.e(this) == 0) {
            ah.c((View) this, 1);
        }
        ah.a(this, new a());
    }

    private LinearLayout.LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.f391b) {
            if (this.f393d == null) {
                this.f393d = new Paint();
            }
            this.f393d.setTypeface(this.t.d());
            this.f393d.setTextSize(this.t.g());
            layoutParams2.topMargin = (int) (-this.f393d.ascent());
        } else {
            layoutParams2.topMargin = 0;
        }
        return layoutParams2;
    }

    private void a() {
        ah.b(this.f394e, ah.m(this.f390a), 0, ah.n(this.f390a), this.f390a.getPaddingBottom());
    }

    private void a(float f2) {
        if (this.t.f() == f2) {
            return;
        }
        if (this.v == null) {
            this.v = ab.a();
            this.v.a(android.support.design.widget.a.f404a);
            this.v.a(200);
            this.v.a(new u.c() { // from class: android.support.design.widget.TextInputLayout.4
                @Override // android.support.design.widget.u.c
                public void a(u uVar) {
                    TextInputLayout.this.t.b(uVar.d());
                }
            });
        }
        this.v.a(this.t.f(), f2);
        this.v.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        boolean z = this.q;
        if (this.n == -1) {
            this.m.setText(String.valueOf(i));
            this.q = false;
        } else {
            this.q = i > this.n;
            if (z != this.q) {
                this.m.setTextAppearance(getContext(), this.q ? this.p : this.o);
            }
            this.m.setText(getContext().getString(android.support.design.a.g.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.n)));
        }
        if (this.f390a == null || z == this.q) {
            return;
        }
        a(false);
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        drawable.clearColorFilter();
        if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
            if (drawable instanceof InsetDrawable) {
                a(((InsetDrawable) drawable).getDrawable());
                return;
            }
            if (drawable instanceof android.support.v4.c.a.i) {
                a(((android.support.v4.c.a.i) drawable).a());
                return;
            }
            if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
                return;
            }
            int childCount = drawableContainerState.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(drawableContainerState.getChild(i));
            }
        }
    }

    private void a(TextView textView) {
        if (this.f394e != null) {
            this.f394e.removeView(textView);
            int i = this.f395f - 1;
            this.f395f = i;
            if (i == 0) {
                this.f394e.setVisibility(8);
            }
        }
    }

    private void a(TextView textView, int i) {
        if (this.f394e == null) {
            this.f394e = new LinearLayout(getContext());
            this.f394e.setOrientation(0);
            addView(this.f394e, -1, -2);
            this.f394e.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f390a != null) {
                a();
            }
        }
        this.f394e.setVisibility(0);
        this.f394e.addView(textView, i);
        this.f395f++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2 = (this.f390a == null || TextUtils.isEmpty(this.f390a.getText())) ? false : true;
        boolean zA = a(getDrawableState(), R.attr.state_focused);
        boolean z3 = TextUtils.isEmpty(getError()) ? false : true;
        if (this.r != null) {
            this.t.b(this.r.getDefaultColor());
        }
        if (this.q && this.m != null) {
            this.t.a(this.m.getCurrentTextColor());
        } else if (zA && this.s != null) {
            this.t.a(this.s.getDefaultColor());
        } else if (this.r != null) {
            this.t.a(this.r.getDefaultColor());
        }
        if (z2 || zA || z3) {
            b(z);
        } else {
            c(z);
        }
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        c();
        Drawable background = this.f390a.getBackground();
        if (background == null) {
            return;
        }
        if (android.support.v7.widget.w.c(background)) {
            background = background.mutate();
        }
        if (this.j && this.h != null) {
            background.setColorFilter(android.support.v7.widget.h.a(this.h.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else if (this.q && this.m != null) {
            background.setColorFilter(android.support.v7.widget.h.a(this.m.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            a(background);
            this.f390a.refreshDrawableState();
        }
    }

    private void b(boolean z) {
        if (this.v != null && this.v.b()) {
            this.v.e();
        }
        if (z && this.u) {
            a(1.0f);
        } else {
            this.t.b(1.0f);
        }
    }

    private void c() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i != 21 && i != 22) || (background = this.f390a.getBackground()) == null || this.w) {
            return;
        }
        Drawable drawableNewDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.w = g.a((DrawableContainer) background, drawableNewDrawable.getConstantState());
        }
        if (this.w) {
            return;
        }
        this.f390a.setBackgroundDrawable(drawableNewDrawable);
        this.w = true;
    }

    private void c(boolean z) {
        if (this.v != null && this.v.b()) {
            this.v.e();
        }
        if (z && this.u) {
            a(BitmapDescriptorFactory.HUE_RED);
        } else {
            this.t.b(BitmapDescriptorFactory.HUE_RED);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f390a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f390a = editText;
        this.t.c(this.f390a.getTypeface());
        this.t.a(this.f390a.getTextSize());
        int gravity = this.f390a.getGravity();
        this.t.d((8388615 & gravity) | 48);
        this.t.c(gravity);
        this.f390a.addTextChangedListener(new TextWatcher() { // from class: android.support.design.widget.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.a(true);
                if (TextInputLayout.this.l) {
                    TextInputLayout.this.a(editable.length());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.r == null) {
            this.r = this.f390a.getHintTextColors();
        }
        if (this.f391b && TextUtils.isEmpty(this.f392c)) {
            setHint(this.f390a.getHint());
            this.f390a.setHint((CharSequence) null);
        }
        if (this.m != null) {
            a(this.f390a.getText().length());
        }
        if (this.f394e != null) {
            a();
        }
        a(false);
    }

    private void setHintInternal(CharSequence charSequence) {
        this.f392c = charSequence;
        this.t.a(charSequence);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
        } else {
            setEditText((EditText) view);
            super.addView(view, 0, a(layoutParams));
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f391b) {
            this.t.a(canvas);
        }
    }

    public int getCounterMaxLength() {
        return this.n;
    }

    public EditText getEditText() {
        return this.f390a;
    }

    public CharSequence getError() {
        if (this.g) {
            return this.k;
        }
        return null;
    }

    public CharSequence getHint() {
        if (this.f391b) {
            return this.f392c;
        }
        return null;
    }

    public Typeface getTypeface() {
        return this.t.d();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.f391b || this.f390a == null) {
            return;
        }
        int left = this.f390a.getLeft() + this.f390a.getCompoundPaddingLeft();
        int right = this.f390a.getRight() - this.f390a.getCompoundPaddingRight();
        this.t.a(left, this.f390a.getTop() + this.f390a.getCompoundPaddingTop(), right, this.f390a.getBottom() - this.f390a.getCompoundPaddingBottom());
        this.t.b(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
        this.t.h();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f401a);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.j) {
            savedState.f401a = getError();
        }
        return savedState;
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        a(ah.D(this));
    }

    public void setCounterEnabled(boolean z) {
        if (this.l != z) {
            if (z) {
                this.m = new TextView(getContext());
                this.m.setMaxLines(1);
                try {
                    this.m.setTextAppearance(getContext(), this.o);
                } catch (Exception e2) {
                    this.m.setTextAppearance(getContext(), android.support.design.a.h.TextAppearance_AppCompat_Caption);
                    this.m.setTextColor(android.support.v4.b.b.b(getContext(), android.support.design.a.c.design_textinput_error_color_light));
                }
                a(this.m, -1);
                if (this.f390a == null) {
                    a(0);
                } else {
                    a(this.f390a.getText().length());
                }
            } else {
                a(this.m);
                this.m = null;
            }
            this.l = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.n != i) {
            if (i > 0) {
                this.n = i;
            } else {
                this.n = -1;
            }
            if (this.l) {
                a(this.f390a == null ? 0 : this.f390a.getText().length());
            }
        }
    }

    public void setError(final CharSequence charSequence) {
        if (TextUtils.equals(this.k, charSequence)) {
            return;
        }
        this.k = charSequence;
        if (!this.g) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        boolean zD = ah.D(this);
        this.j = !TextUtils.isEmpty(charSequence);
        ah.s(this.h).b();
        if (this.j) {
            this.h.setText(charSequence);
            this.h.setVisibility(0);
            if (zD) {
                if (ah.f(this.h) == 1.0f) {
                    ah.c(this.h, BitmapDescriptorFactory.HUE_RED);
                }
                ah.s(this.h).a(1.0f).a(200L).a(android.support.design.widget.a.f407d).a(new bf() { // from class: android.support.design.widget.TextInputLayout.2
                    @Override // android.support.v4.view.bf, android.support.v4.view.be
                    public void a(View view) {
                        view.setVisibility(0);
                    }
                }).c();
            }
        } else if (this.h.getVisibility() == 0) {
            if (zD) {
                ah.s(this.h).a(BitmapDescriptorFactory.HUE_RED).a(200L).a(android.support.design.widget.a.f406c).a(new bf() { // from class: android.support.design.widget.TextInputLayout.3
                    @Override // android.support.v4.view.bf, android.support.v4.view.be
                    public void b(View view) {
                        TextInputLayout.this.h.setText(charSequence);
                        view.setVisibility(4);
                    }
                }).c();
            } else {
                this.h.setVisibility(4);
            }
        }
        b();
        a(true);
    }

    public void setErrorEnabled(boolean z) {
        if (this.g != z) {
            if (this.h != null) {
                ah.s(this.h).b();
            }
            if (z) {
                this.h = new TextView(getContext());
                try {
                    this.h.setTextAppearance(getContext(), this.i);
                } catch (Exception e2) {
                    this.h.setTextAppearance(getContext(), android.support.design.a.h.TextAppearance_AppCompat_Caption);
                    this.h.setTextColor(android.support.v4.b.b.b(getContext(), android.support.design.a.c.design_textinput_error_color_light));
                }
                this.h.setVisibility(4);
                ah.d((View) this.h, 1);
                a(this.h, 0);
            } else {
                this.j = false;
                b();
                a(this.h);
                this.h = null;
            }
            this.g = z;
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f391b) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.u = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f391b) {
            this.f391b = z;
            CharSequence hint = this.f390a.getHint();
            if (!this.f391b) {
                if (!TextUtils.isEmpty(this.f392c) && TextUtils.isEmpty(hint)) {
                    this.f390a.setHint(this.f392c);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f392c)) {
                    setHint(hint);
                }
                this.f390a.setHint((CharSequence) null);
            }
            if (this.f390a != null) {
                this.f390a.setLayoutParams(a(this.f390a.getLayoutParams()));
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.t.e(i);
        this.s = ColorStateList.valueOf(this.t.j());
        if (this.f390a != null) {
            a(false);
            this.f390a.setLayoutParams(a(this.f390a.getLayoutParams()));
            this.f390a.requestLayout();
        }
    }

    public void setTypeface(Typeface typeface) {
        this.t.c(typeface);
    }
}
