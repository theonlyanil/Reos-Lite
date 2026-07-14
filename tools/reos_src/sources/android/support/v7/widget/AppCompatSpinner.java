package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements android.support.v4.view.ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f1403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f1404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f1405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f1406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f1407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f1408f;
    private ListPopupWindow.b g;
    private SpinnerAdapter h;
    private boolean i;
    private b j;
    private int k;
    private final Rect l;

    private static class a implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f1411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f1412b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1411a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1412b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (AppCompatSpinner.f1403a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof al) {
                    al alVar = (al) spinnerAdapter;
                    if (alVar.a() == null) {
                        alVar.a(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1412b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f1411a == null) {
                return 0;
            }
            return this.f1411a.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f1411a == null) {
                return null;
            }
            return this.f1411a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f1411a == null) {
                return null;
            }
            return this.f1411a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.f1411a == null) {
                return -1L;
            }
            return this.f1411a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.f1411a != null && this.f1411a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1412b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1411a != null) {
                this.f1411a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1411a != null) {
                this.f1411a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class b extends ListPopupWindow {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f1414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ListAdapter f1415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Rect f1416e;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1416e = new Rect();
            a(AppCompatSpinner.this);
            a(true);
            a(0);
            a(new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, b.this.f1415d.getItemId(i2));
                    }
                    b.this.i();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(View view) {
            return android.support.v4.view.ah.F(view) && view.getGlobalVisibleRect(this.f1416e);
        }

        public CharSequence a() {
            return this.f1414c;
        }

        @Override // android.support.v7.widget.ListPopupWindow
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.f1415d = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.f1414c = charSequence;
        }

        void b() {
            int i;
            Drawable drawableD = d();
            if (drawableD != null) {
                drawableD.getPadding(AppCompatSpinner.this.l);
                i = at.a(AppCompatSpinner.this) ? AppCompatSpinner.this.l.right : -AppCompatSpinner.this.l.left;
            } else {
                Rect rect = AppCompatSpinner.this.l;
                AppCompatSpinner.this.l.right = 0;
                rect.left = 0;
                i = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.k == -2) {
                int iA = AppCompatSpinner.this.a((SpinnerAdapter) this.f1415d, d());
                int i2 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.l.left) - AppCompatSpinner.this.l.right;
                if (iA <= i2) {
                    i2 = iA;
                }
                f(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.k == -1) {
                f((width - paddingLeft) - paddingRight);
            } else {
                f(AppCompatSpinner.this.k);
            }
            b(at.a(AppCompatSpinner.this) ? ((width - paddingRight) - h()) + i : i + paddingLeft);
        }

        @Override // android.support.v7.widget.ListPopupWindow
        public void c() {
            ViewTreeObserver viewTreeObserver;
            boolean zK = k();
            b();
            g(2);
            super.c();
            m().setChoiceMode(1);
            h(AppCompatSpinner.this.getSelectedItemPosition());
            if (zK || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!b.this.b(AppCompatSpinner.this)) {
                        b.this.i();
                    } else {
                        b.this.b();
                        b.super.c();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            a(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }
    }

    static {
        f1403a = Build.VERSION.SDK_INT >= 23;
        f1404b = Build.VERSION.SDK_INT >= 16;
        f1405c = new int[]{R.attr.spinnerMode};
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0053  */
    /* JADX WARN: Code duplicated, block: B:22:0x0091  */
    /* JADX WARN: Code duplicated, block: B:25:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e7  */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) throws Throwable {
        CharSequence[] charSequenceArrE;
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.l = new Rect();
        ap apVarA = ap.a(context, attributeSet, android.support.v7.b.a.k.Spinner, i, 0);
        this.f1406d = h.a();
        this.f1407e = new f(this, this.f1406d);
        if (theme != null) {
            this.f1408f = new android.support.v7.view.d(context, theme);
        } else {
            int iG = apVarA.g(android.support.v7.b.a.k.Spinner_popupTheme, 0);
            if (iG != 0) {
                this.f1408f = new android.support.v7.view.d(context, iG);
            } else {
                this.f1408f = !f1403a ? context : null;
            }
        }
        if (this.f1408f != null) {
            if (i2 == -1) {
                if (Build.VERSION.SDK_INT >= 11) {
                    try {
                        typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1405c, i, 0);
                        try {
                            try {
                                i2 = typedArrayObtainStyledAttributes.hasValue(0) ? typedArrayObtainStyledAttributes.getInt(0, 0) : i2;
                                if (typedArrayObtainStyledAttributes != null) {
                                    typedArrayObtainStyledAttributes.recycle();
                                }
                            } catch (Exception e2) {
                                e = e2;
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (typedArrayObtainStyledAttributes != null) {
                                    typedArrayObtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    final b bVar = new b(this.f1408f, attributeSet, i);
                                    ap apVarA2 = ap.a(this.f1408f, attributeSet, android.support.v7.b.a.k.Spinner, i, 0);
                                    this.k = apVarA2.f(android.support.v7.b.a.k.Spinner_android_dropDownWidth, -2);
                                    bVar.a(apVarA2.a(android.support.v7.b.a.k.Spinner_android_popupBackground));
                                    bVar.a(apVarA.d(android.support.v7.b.a.k.Spinner_android_prompt));
                                    apVarA2.a();
                                    this.j = bVar;
                                    this.g = new ListPopupWindow.b(this) { // from class: android.support.v7.widget.AppCompatSpinner.1
                                        @Override // android.support.v7.widget.ListPopupWindow.b
                                        public ListPopupWindow a() {
                                            return bVar;
                                        }

                                        @Override // android.support.v7.widget.ListPopupWindow.b
                                        public boolean b() {
                                            if (AppCompatSpinner.this.j.k()) {
                                                return true;
                                            }
                                            AppCompatSpinner.this.j.c();
                                            return true;
                                        }
                                    };
                                }
                                charSequenceArrE = apVarA.e(android.support.v7.b.a.k.Spinner_android_entries);
                                if (charSequenceArrE != null) {
                                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrE);
                                    arrayAdapter.setDropDownViewResource(android.support.v7.b.a.h.support_simple_spinner_dropdown_item);
                                    setAdapter((SpinnerAdapter) arrayAdapter);
                                }
                                apVarA.a();
                                this.i = true;
                                if (this.h != null) {
                                    setAdapter(this.h);
                                    this.h = null;
                                }
                                this.f1407e.a(attributeSet, i);
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (typedArrayObtainStyledAttributes != null) {
                                typedArrayObtainStyledAttributes.recycle();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        typedArrayObtainStyledAttributes = null;
                    } catch (Throwable th2) {
                        th = th2;
                        typedArrayObtainStyledAttributes = null;
                        if (typedArrayObtainStyledAttributes != null) {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                        throw th;
                    }
                } else {
                    i2 = 1;
                }
            }
            if (i2 == 1) {
                final b bVar2 = new b(this.f1408f, attributeSet, i);
                ap apVarA3 = ap.a(this.f1408f, attributeSet, android.support.v7.b.a.k.Spinner, i, 0);
                this.k = apVarA3.f(android.support.v7.b.a.k.Spinner_android_dropDownWidth, -2);
                bVar2.a(apVarA3.a(android.support.v7.b.a.k.Spinner_android_popupBackground));
                bVar2.a(apVarA.d(android.support.v7.b.a.k.Spinner_android_prompt));
                apVarA3.a();
                this.j = bVar2;
                this.g = new ListPopupWindow.b(this) { // from class: android.support.v7.widget.AppCompatSpinner.1
                    @Override // android.support.v7.widget.ListPopupWindow.b
                    public ListPopupWindow a() {
                        return bVar2;
                    }

                    @Override // android.support.v7.widget.ListPopupWindow.b
                    public boolean b() {
                        if (AppCompatSpinner.this.j.k()) {
                            return true;
                        }
                        AppCompatSpinner.this.j.c();
                        return true;
                    }
                };
            }
        }
        charSequenceArrE = apVarA.e(android.support.v7.b.a.k.Spinner_android_entries);
        if (charSequenceArrE != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrE);
            arrayAdapter2.setDropDownViewResource(android.support.v7.b.a.h.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        apVarA.a();
        this.i = true;
        if (this.h != null) {
            setAdapter(this.h);
            this.h = null;
        }
        this.f1407e.a(attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        View view;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        int iMax2 = Math.max(0, iMax - (15 - (iMin - iMax)));
        View view2 = null;
        int iMax3 = 0;
        int i = 0;
        while (iMax2 < iMin) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax2);
            if (itemViewType != i) {
                view = null;
            } else {
                itemViewType = i;
                view = view2;
            }
            view2 = spinnerAdapter.getView(iMax2, view, this);
            if (view2.getLayoutParams() == null) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax3 = Math.max(iMax3, view2.getMeasuredWidth());
            iMax2++;
            i = itemViewType;
        }
        if (drawable == null) {
            return iMax3;
        }
        drawable.getPadding(this.l);
        return this.l.left + this.l.right + iMax3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1407e != null) {
            this.f1407e.c();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.j != null) {
            return this.j.f();
        }
        if (f1404b) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.j != null) {
            return this.j.g();
        }
        if (f1404b) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.j != null) {
            return this.k;
        }
        if (f1404b) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.j != null) {
            return this.j.d();
        }
        if (f1404b) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.j != null) {
            return this.f1408f;
        }
        if (f1403a) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.j != null ? this.j.a() : super.getPrompt();
    }

    @Override // android.support.v4.view.ae
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1407e != null) {
            return this.f1407e.a();
        }
        return null;
    }

    @Override // android.support.v4.view.ae
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1407e != null) {
            return this.f1407e.b();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j == null || !this.j.k()) {
            return;
        }
        this.j.i();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.j == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g == null || !this.g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.j == null) {
            return super.performClick();
        }
        if (!this.j.k()) {
            this.j.c();
        }
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.i) {
            this.h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.j != null) {
            this.j.a(new a(spinnerAdapter, (this.f1408f == null ? getContext() : this.f1408f).getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1407e != null) {
            this.f1407e.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1407e != null) {
            this.f1407e.a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.j != null) {
            this.j.b(i);
        } else if (f1404b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.j != null) {
            this.j.c(i);
        } else if (f1404b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.j != null) {
            this.k = i;
        } else if (f1404b) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.j != null) {
            this.j.a(drawable);
        } else if (f1404b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v4.b.b.a(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.j != null) {
            this.j.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1407e != null) {
            this.f1407e.a(colorStateList);
        }
    }

    @Override // android.support.v4.view.ae
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1407e != null) {
            this.f1407e.a(mode);
        }
    }
}
