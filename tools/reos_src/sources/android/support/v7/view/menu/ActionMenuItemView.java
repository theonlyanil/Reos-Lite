package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ah;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements m.a, ActionMenuView.a, View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f1232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f1233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f1234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f.b f1235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ListPopupWindow.b f1236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f1237f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;

    private class a extends ListPopupWindow.b {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // android.support.v7.widget.ListPopupWindow.b
        public ListPopupWindow a() {
            if (ActionMenuItemView.this.f1237f != null) {
                return ActionMenuItemView.this.f1237f.a();
            }
            return null;
        }

        @Override // android.support.v7.widget.ListPopupWindow.b
        protected boolean b() {
            ListPopupWindow listPopupWindowA;
            return ActionMenuItemView.this.f1235d != null && ActionMenuItemView.this.f1235d.a(ActionMenuItemView.this.f1232a) && (listPopupWindowA = a()) != null && listPopupWindowA.k();
        }
    }

    public static abstract class b {
        public abstract ListPopupWindow a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.g = resources.getBoolean(android.support.v7.b.a.b.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.ActionMenuItemView, i, 0);
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.b.a.k.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.j = -1;
    }

    private void e() {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(this.f1233b);
        if (this.f1234c == null || (this.f1232a.m() && (this.g || this.h))) {
            z = true;
        }
        setText(z2 & z ? this.f1233b : null);
    }

    @Override // android.support.v7.view.menu.m.a
    public void a(h hVar, int i) {
        this.f1232a = hVar;
        setIcon(hVar.getIcon());
        setTitle(hVar.a((m.a) this));
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.f1236e == null) {
            this.f1236e = new a();
        }
    }

    public boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.support.v7.view.menu.m.a
    public boolean b() {
        return true;
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public boolean c() {
        return a() && this.f1232a.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public boolean d() {
        return a();
    }

    @Override // android.support.v7.view.menu.m.a
    public h getItemData() {
        return this.f1232a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1235d != null) {
            this.f1235d.a(this.f1232a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.g = getContext().getResources().getBoolean(android.support.v7.b.a.b.abc_config_allowActionMenuItemTextWithIcon);
        e();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (a()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = (width / 2) + iArr[0];
        if (ah.h(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast toastMakeText = Toast.makeText(context, this.f1232a.getTitle(), 0);
        if (i < rect.height()) {
            toastMakeText.setGravity(8388661, i2, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean zA = a();
        if (zA && this.j >= 0) {
            super.setPadding(this.j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.i) : this.i;
        if (mode != 1073741824 && this.i > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zA || this.f1234c == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1234c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1232a.hasSubMenu() && this.f1236e != null && this.f1236e.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.h != z) {
            this.h = z;
            if (this.f1232a != null) {
                this.f1232a.h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1234c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.k) {
                float f2 = this.k / intrinsicWidth;
                intrinsicWidth = this.k;
                intrinsicHeight = (int) (intrinsicHeight * f2);
            }
            if (intrinsicHeight > this.k) {
                float f3 = this.k / intrinsicHeight;
                intrinsicHeight = this.k;
                intrinsicWidth = (int) (intrinsicWidth * f3);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        e();
    }

    public void setItemInvoker(f.b bVar) {
        this.f1235d = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.f1237f = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1233b = charSequence;
        setContentDescription(this.f1233b);
        e();
    }
}
