package android.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f307a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f308b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final android.support.design.internal.a f309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final android.support.design.internal.b f310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f312f;
    private MenuInflater g;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.f.d.a(new android.support.v4.f.e<SavedState>() { // from class: android.support.design.widget.NavigationView.SavedState.1
            @Override // android.support.v4.f.e
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.support.v4.f.e
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] b(int i) {
                return new SavedState[i];
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f314a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.f314a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f314a);
        }
    }

    public interface a {
        boolean a(MenuItem menuItem);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        boolean z;
        super(context, attributeSet, i);
        this.f310d = new android.support.design.internal.b();
        t.a(context);
        this.f309c = new android.support.design.internal.a(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.NavigationView, i, android.support.design.a.h.Widget_Design_NavigationView);
        setBackgroundDrawable(typedArrayObtainStyledAttributes.getDrawable(android.support.design.a.i.NavigationView_android_background));
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.NavigationView_elevation)) {
            ah.d(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.NavigationView_elevation, 0));
        }
        ah.a(this, typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.NavigationView_android_fitsSystemWindows, false));
        this.f312f = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.NavigationView_itemIconTint) ? typedArrayObtainStyledAttributes.getColorStateList(android.support.design.a.i.NavigationView_itemIconTint) : c(R.attr.textColorSecondary);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.NavigationView_itemTextAppearance)) {
            resourceId = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            resourceId = 0;
            z = false;
        }
        ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.NavigationView_itemTextColor) ? typedArrayObtainStyledAttributes.getColorStateList(android.support.design.a.i.NavigationView_itemTextColor) : null;
        if (!z && colorStateList2 == null) {
            colorStateList2 = c(R.attr.textColorPrimary);
        }
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(android.support.design.a.i.NavigationView_itemBackground);
        this.f309c.a(new android.support.v7.view.menu.f.a() { // from class: android.support.design.widget.NavigationView.1
            @Override // android.support.v7.view.menu.f.a
            public void a(android.support.v7.view.menu.f fVar) {
            }

            @Override // android.support.v7.view.menu.f.a
            public boolean a(android.support.v7.view.menu.f fVar, MenuItem menuItem) {
                return NavigationView.this.f311e != null && NavigationView.this.f311e.a(menuItem);
            }
        });
        this.f310d.a(1);
        this.f310d.a(context, this.f309c);
        this.f310d.a(colorStateList);
        if (z) {
            this.f310d.c(resourceId);
        }
        this.f310d.b(colorStateList2);
        this.f310d.a(drawable);
        this.f309c.a(this.f310d);
        addView((View) this.f310d.a((ViewGroup) this));
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.NavigationView_menu)) {
            a(typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.NavigationView_menu, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.NavigationView_headerLayout)) {
            b(typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.NavigationView_headerLayout, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private ColorStateList c(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = getResources().getColorStateList(typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(android.support.design.a.b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{f308b, f307a, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(f308b, defaultColor), i2, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.g == null) {
            this.g = new android.support.v7.view.g(getContext());
        }
        return this.g;
    }

    public void a(int i) {
        this.f310d.b(true);
        getMenuInflater().inflate(i, this.f309c);
        this.f310d.b(false);
        this.f310d.a(false);
    }

    @Override // android.support.design.internal.ScrimInsetsFrameLayout
    protected void a(Rect rect) {
        this.f310d.d(rect.top);
    }

    public View b(int i) {
        return this.f310d.b(i);
    }

    public int getHeaderCount() {
        return this.f310d.d();
    }

    public Drawable getItemBackground() {
        return this.f310d.g();
    }

    public ColorStateList getItemIconTintList() {
        return this.f310d.e();
    }

    public ColorStateList getItemTextColor() {
        return this.f310d.f();
    }

    public Menu getMenu() {
        return this.f309c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        switch (View.MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.f312f), 1073741824);
                break;
            case 0:
                i = View.MeasureSpec.makeMeasureSpec(this.f312f, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f309c.b(savedState.f314a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f314a = new Bundle();
        this.f309c.a(savedState.f314a);
        return savedState;
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.f309c.findItem(i);
        if (menuItemFindItem != null) {
            this.f310d.a((android.support.v7.view.menu.h) menuItemFindItem);
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f310d.a(drawable);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(android.support.v4.b.b.a(getContext(), i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f310d.a(colorStateList);
    }

    public void setItemTextAppearance(int i) {
        this.f310d.c(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f310d.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.f311e = aVar;
    }
}
