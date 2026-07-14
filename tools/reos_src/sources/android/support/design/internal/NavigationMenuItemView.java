package android.support.design.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.widget.z;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements m.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f210c = {R.attr.state_checked};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CheckedTextView f212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FrameLayout f213f;
    private h g;
    private ColorStateList h;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(android.support.design.a.f.design_navigation_menu_item, (ViewGroup) this, true);
        this.f211d = context.getResources().getDimensionPixelSize(android.support.design.a.d.design_navigation_icon_size);
        this.f212e = (CheckedTextView) findViewById(android.support.design.a.e.design_menu_item_text);
        this.f212e.setDuplicateParentStateEnabled(true);
    }

    private StateListDrawable c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(android.support.design.a.b.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f210c, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (this.f213f == null) {
            this.f213f = (FrameLayout) ((ViewStub) findViewById(android.support.design.a.e.design_menu_item_action_area_stub)).inflate();
        }
        this.f213f.removeAllViews();
        if (view != null) {
            this.f213f.addView(view);
        }
    }

    public void a() {
        if (this.f213f != null) {
            this.f213f.removeAllViews();
        }
        this.f212e.setCompoundDrawables(null, null, null, null);
    }

    public void a(Context context, int i) {
        this.f212e.setTextAppearance(context, i);
    }

    @Override // android.support.v7.view.menu.m.a
    public void a(h hVar, int i) {
        this.g = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(c());
        }
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setTitle(hVar.getTitle());
        setIcon(hVar.getIcon());
        setActionView(hVar.getActionView());
    }

    @Override // android.support.v7.view.menu.m.a
    public boolean b() {
        return false;
    }

    @Override // android.support.v7.view.menu.m.a
    public h getItemData() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.g != null && this.g.isCheckable() && this.g.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f210c);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f212e.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = android.support.v4.c.a.a.f(drawable).mutate();
            drawable.setBounds(0, 0, this.f211d, this.f211d);
            android.support.v4.c.a.a.a(drawable, this.h);
        }
        z.a(this.f212e, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        if (this.g != null) {
            setIcon(this.g.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f212e.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f212e.setText(charSequence);
    }
}
