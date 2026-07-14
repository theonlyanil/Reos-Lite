package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements m.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f1242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f1243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RadioButton f1244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f1245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CheckBox f1246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f1247f;
    private Drawable g;
    private int h;
    private Context i;
    private boolean j;
    private int k;
    private Context l;
    private LayoutInflater m;
    private boolean n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.l = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.MenuView, i, 0);
        this.g = typedArrayObtainStyledAttributes.getDrawable(android.support.v7.b.a.k.MenuView_android_itemBackground);
        this.h = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.b.a.k.MenuView_android_itemTextAppearance, -1);
        this.j = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.b.a.k.MenuView_preserveIconSpacing, false);
        this.i = context;
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a() {
        this.f1243b = (ImageView) getInflater().inflate(android.support.v7.b.a.h.abc_list_menu_item_icon, (ViewGroup) this, false);
        addView(this.f1243b, 0);
    }

    private void c() {
        this.f1244c = (RadioButton) getInflater().inflate(android.support.v7.b.a.h.abc_list_menu_item_radio, (ViewGroup) this, false);
        addView(this.f1244c);
    }

    private void d() {
        this.f1246e = (CheckBox) getInflater().inflate(android.support.v7.b.a.h.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        addView(this.f1246e);
    }

    private LayoutInflater getInflater() {
        if (this.m == null) {
            this.m = LayoutInflater.from(this.l);
        }
        return this.m;
    }

    @Override // android.support.v7.view.menu.m.a
    public void a(h hVar, int i) {
        this.f1242a = hVar;
        this.k = i;
        setVisibility(hVar.isVisible() ? 0 : 8);
        setTitle(hVar.a((m.a) this));
        setCheckable(hVar.isCheckable());
        a(hVar.f(), hVar.d());
        setIcon(hVar.getIcon());
        setEnabled(hVar.isEnabled());
    }

    public void a(boolean z, char c2) {
        int i = (z && this.f1242a.f()) ? 0 : 8;
        if (i == 0) {
            this.f1247f.setText(this.f1242a.e());
        }
        if (this.f1247f.getVisibility() != i) {
            this.f1247f.setVisibility(i);
        }
    }

    @Override // android.support.v7.view.menu.m.a
    public boolean b() {
        return false;
    }

    @Override // android.support.v7.view.menu.m.a
    public h getItemData() {
        return this.f1242a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.g);
        this.f1245d = (TextView) findViewById(android.support.v7.b.a.f.title);
        if (this.h != -1) {
            this.f1245d.setTextAppearance(this.i, this.h);
        }
        this.f1247f = (TextView) findViewById(android.support.v7.b.a.f.shortcut);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f1243b != null && this.j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1243b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f1244c == null && this.f1246e == null) {
            return;
        }
        if (this.f1242a.g()) {
            if (this.f1244c == null) {
                c();
            }
            compoundButton = this.f1244c;
            compoundButton2 = this.f1246e;
        } else {
            if (this.f1246e == null) {
                d();
            }
            compoundButton = this.f1246e;
            compoundButton2 = this.f1244c;
        }
        if (!z) {
            if (this.f1246e != null) {
                this.f1246e.setVisibility(8);
            }
            if (this.f1244c != null) {
                this.f1244c.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.f1242a.isChecked());
        int i = z ? 0 : 8;
        if (compoundButton.getVisibility() != i) {
            compoundButton.setVisibility(i);
        }
        if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
            return;
        }
        compoundButton2.setVisibility(8);
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1242a.g()) {
            if (this.f1244c == null) {
                c();
            }
            compoundButton = this.f1244c;
        } else {
            if (this.f1246e == null) {
                d();
            }
            compoundButton = this.f1246e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.n = z;
        this.j = z;
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f1242a.i() || this.n;
        if (z || this.j) {
            if (this.f1243b == null && drawable == null && !this.j) {
                return;
            }
            if (this.f1243b == null) {
                a();
            }
            if (drawable == null && !this.j) {
                this.f1243b.setVisibility(8);
                return;
            }
            ImageView imageView = this.f1243b;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.f1243b.getVisibility() != 0) {
                this.f1243b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1245d.getVisibility() != 8) {
                this.f1245d.setVisibility(8);
            }
        } else {
            this.f1245d.setText(charSequence);
            if (this.f1245d.getVisibility() != 0) {
                this.f1245d.setVisibility(0);
            }
        }
    }
}
