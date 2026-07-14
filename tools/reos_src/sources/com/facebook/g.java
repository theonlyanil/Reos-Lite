package com.facebook;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View.OnClickListener f3859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View.OnClickListener f3860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3862f;
    private int g;
    private com.facebook.b.o h;

    protected g(Context context, AttributeSet attributeSet, int i, int i2, String str, String str2) {
        super(context, attributeSet, 0);
        int defaultStyleResource = i2 == 0 ? getDefaultStyleResource() : i2;
        a(context, attributeSet, i, defaultStyleResource == 0 ? aa.g.com_facebook_button : defaultStyleResource);
        this.f3857a = str;
        this.f3858b = str2;
        setClickable(true);
        setFocusable(true);
    }

    private void a() {
        super.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.b(g.this.getContext());
                if (g.this.f3860d != null) {
                    g.this.f3860d.onClick(view);
                } else if (g.this.f3859c != null) {
                    g.this.f3859c.onClick(view);
                }
            }
        });
    }

    private void a(Context context) {
        com.facebook.a.f.a(context).a(this.f3857a, (Double) null, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        com.facebook.a.f.a(context).a(this.f3858b, (Double) null, (Bundle) null);
    }

    private void b(Context context, AttributeSet attributeSet, int i, int i2) {
        if (isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.background}, i, i2);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    setBackgroundResource(resourceId);
                } else {
                    setBackgroundColor(typedArrayObtainStyledAttributes.getColor(0, 0));
                }
            } else {
                setBackgroundColor(android.support.v4.b.b.b(context, aa.a.com_facebook_blue));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @SuppressLint({"ResourceType"})
    private void c(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.drawableLeft, R.attr.drawableTop, R.attr.drawableRight, R.attr.drawableBottom, R.attr.drawablePadding}, i, i2);
        try {
            setCompoundDrawablesWithIntrinsicBounds(typedArrayObtainStyledAttributes.getResourceId(0, 0), typedArrayObtainStyledAttributes.getResourceId(1, 0), typedArrayObtainStyledAttributes.getResourceId(2, 0), typedArrayObtainStyledAttributes.getResourceId(3, 0));
            setCompoundDrawablePadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void d(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom}, i, i2);
        try {
            setPadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void e(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.textColor}, i, i2);
        try {
            setTextColor(typedArrayObtainStyledAttributes.getColorStateList(0));
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.gravity}, i, i2);
            try {
                setGravity(typedArrayObtainStyledAttributes2.getInt(0, 17));
                typedArrayObtainStyledAttributes2.recycle();
                TypedArray typedArrayObtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.textSize, R.attr.textStyle, R.attr.text}, i, i2);
                try {
                    setTextSize(0, typedArrayObtainStyledAttributes3.getDimensionPixelSize(0, 0));
                    setTypeface(Typeface.defaultFromStyle(typedArrayObtainStyledAttributes3.getInt(1, 1)));
                    setText(typedArrayObtainStyledAttributes3.getString(2));
                } finally {
                    typedArrayObtainStyledAttributes3.recycle();
                }
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes2.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    protected int a(String str) {
        return (int) Math.ceil(getPaint().measureText(str));
    }

    protected void a(Context context, AttributeSet attributeSet, int i, int i2) {
        b(context, attributeSet, i, i2);
        c(context, attributeSet, i, i2);
        d(context, attributeSet, i, i2);
        e(context, attributeSet, i, i2);
        a();
    }

    protected void a(View view) {
        if (this.f3859c != null) {
            this.f3859c.onClick(view);
        }
    }

    protected Activity getActivity() {
        Context context = getContext();
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        throw new k("Unable to get Activity.");
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        return this.f3861e ? this.f3862f : super.getCompoundPaddingLeft();
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        return this.f3861e ? this.g : super.getCompoundPaddingRight();
    }

    protected abstract int getDefaultRequestCode();

    protected int getDefaultStyleResource() {
        return 0;
    }

    public Fragment getFragment() {
        if (this.h != null) {
            return this.h.b();
        }
        return null;
    }

    public android.app.Fragment getNativeFragment() {
        if (this.h != null) {
            return this.h.a();
        }
        return null;
    }

    public int getRequestCode() {
        return getDefaultRequestCode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        a(getContext());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if ((getGravity() & 1) != 0) {
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int compoundPaddingRight = getCompoundPaddingRight();
            int iMin = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - a(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
            this.f3862f = compoundPaddingLeft - iMin;
            this.g = compoundPaddingRight + iMin;
            this.f3861e = true;
        }
        super.onDraw(canvas);
        this.f3861e = false;
    }

    public void setFragment(android.app.Fragment fragment) {
        this.h = new com.facebook.b.o(fragment);
    }

    public void setFragment(Fragment fragment) {
        this.h = new com.facebook.b.o(fragment);
    }

    protected void setInternalOnClickListener(View.OnClickListener onClickListener) {
        this.f3860d = onClickListener;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3859c = onClickListener;
    }
}
