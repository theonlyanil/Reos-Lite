package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class ah extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f1712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f1715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LinearLayoutCompat f1716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Spinner f1717f;
    private boolean g;
    private int h;
    private int i;

    private class a extends BaseAdapter {
        private a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ah.this.f1716e.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) ah.this.f1716e.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ah.this.a((android.support.v7.a.a.c) getItem(i), true);
            }
            ((c) view).a((android.support.v7.a.a.c) getItem(i));
            return view;
        }
    }

    private class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = ah.this.f1716e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ah.this.f1716e.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class c extends LinearLayoutCompat implements View.OnLongClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f1723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private android.support.v7.a.a.c f1724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TextView f1725d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ImageView f1726e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f1727f;

        public c(Context context, android.support.v7.a.a.c cVar, boolean z) {
            super(context, null, android.support.v7.b.a.C0029a.actionBarTabStyle);
            this.f1723b = new int[]{R.attr.background};
            this.f1724c = cVar;
            ap apVarA = ap.a(context, null, this.f1723b, android.support.v7.b.a.C0029a.actionBarTabStyle, 0);
            if (apVarA.f(0)) {
                setBackgroundDrawable(apVarA.a(0));
            }
            apVarA.a();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a() {
            android.support.v7.a.a.c cVar = this.f1724c;
            View viewC = cVar.c();
            if (viewC != null) {
                ViewParent parent = viewC.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewC);
                    }
                    addView(viewC);
                }
                this.f1727f = viewC;
                if (this.f1725d != null) {
                    this.f1725d.setVisibility(8);
                }
                if (this.f1726e != null) {
                    this.f1726e.setVisibility(8);
                    this.f1726e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f1727f != null) {
                removeView(this.f1727f);
                this.f1727f = null;
            }
            Drawable drawableA = cVar.a();
            CharSequence charSequenceB = cVar.b();
            if (drawableA != null) {
                if (this.f1726e == null) {
                    ImageView imageView = new ImageView(getContext());
                    LinearLayoutCompat.a aVar = new LinearLayoutCompat.a(-2, -2);
                    aVar.h = 16;
                    imageView.setLayoutParams(aVar);
                    addView(imageView, 0);
                    this.f1726e = imageView;
                }
                this.f1726e.setImageDrawable(drawableA);
                this.f1726e.setVisibility(0);
            } else if (this.f1726e != null) {
                this.f1726e.setVisibility(8);
                this.f1726e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(charSequenceB);
            if (z) {
                if (this.f1725d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, android.support.v7.b.a.C0029a.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayoutCompat.a aVar2 = new LinearLayoutCompat.a(-2, -2);
                    aVar2.h = 16;
                    appCompatTextView.setLayoutParams(aVar2);
                    addView(appCompatTextView);
                    this.f1725d = appCompatTextView;
                }
                this.f1725d.setText(charSequenceB);
                this.f1725d.setVisibility(0);
            } else if (this.f1725d != null) {
                this.f1725d.setVisibility(8);
                this.f1725d.setText((CharSequence) null);
            }
            if (this.f1726e != null) {
                this.f1726e.setContentDescription(cVar.e());
            }
            if (!z && !TextUtils.isEmpty(cVar.e())) {
                setOnLongClickListener(this);
            } else {
                setOnLongClickListener(null);
                setLongClickable(false);
            }
        }

        public void a(android.support.v7.a.a.c cVar) {
            this.f1724c = cVar;
            a();
        }

        public android.support.v7.a.a.c b() {
            return this.f1724c;
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.a.a.c.class.getName());
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(android.support.v7.a.a.c.class.getName());
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast toastMakeText = Toast.makeText(context, this.f1724c.e(), 0);
            toastMakeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            toastMakeText.show();
            return true;
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ah.this.f1713b <= 0 || getMeasuredWidth() <= ah.this.f1713b) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ah.this.f1713b, 1073741824), i2);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(android.support.v7.a.a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            cVar2.setFocusable(true);
            if (this.f1715d == null) {
                this.f1715d = new b();
            }
            cVar2.setOnClickListener(this.f1715d);
        }
        return cVar2;
    }

    private boolean a() {
        return this.f1717f != null && this.f1717f.getParent() == this;
    }

    private void b() {
        if (a()) {
            return;
        }
        if (this.f1717f == null) {
            this.f1717f = d();
        }
        removeView(this.f1716e);
        addView(this.f1717f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1717f.getAdapter() == null) {
            this.f1717f.setAdapter((SpinnerAdapter) new a());
        }
        if (this.f1712a != null) {
            removeCallbacks(this.f1712a);
            this.f1712a = null;
        }
        this.f1717f.setSelection(this.i);
    }

    private boolean c() {
        if (a()) {
            removeView(this.f1717f);
            addView(this.f1716e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f1717f.getSelectedItemPosition());
        }
        return false;
    }

    private Spinner d() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, android.support.v7.b.a.C0029a.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public void a(int i) {
        final View childAt = this.f1716e.getChildAt(i);
        if (this.f1712a != null) {
            removeCallbacks(this.f1712a);
        }
        this.f1712a = new Runnable() { // from class: android.support.v7.widget.ah.1
            @Override // java.lang.Runnable
            public void run() {
                ah.this.smoothScrollTo(childAt.getLeft() - ((ah.this.getWidth() - childAt.getWidth()) / 2), 0);
                ah.this.f1712a = null;
            }
        };
        post(this.f1712a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1712a != null) {
            post(this.f1712a);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        android.support.v7.view.a aVarA = android.support.v7.view.a.a(getContext());
        setContentHeight(aVarA.e());
        this.f1714c = aVarA.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1712a != null) {
            removeCallbacks(this.f1712a);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
        ((c) view).b().d();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1716e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1713b = -1;
        } else {
            if (childCount > 2) {
                this.f1713b = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f1713b = View.MeasureSpec.getSize(i) / 2;
            }
            this.f1713b = Math.min(this.f1713b, this.f1714c);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (!z && this.g) {
            this.f1716e.measure(0, iMakeMeasureSpec);
            if (this.f1716e.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.f1716e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1716e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        if (this.f1717f == null || i < 0) {
            return;
        }
        this.f1717f.setSelection(i);
    }
}
