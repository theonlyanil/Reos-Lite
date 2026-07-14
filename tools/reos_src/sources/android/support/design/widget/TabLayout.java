package android.support.design.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ac;
import android.support.v4.view.ah;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final android.support.v4.h.h.a<d> f353a = new android.support.v4.h.h.c(16);
    private final android.support.v4.h.h.a<f> A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<d> f354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f358f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private float k;
    private float l;
    private final int m;
    private int n;
    private final int o;
    private final int p;
    private final int q;
    private int r;
    private int s;
    private int t;
    private a u;
    private u v;
    private ViewPager w;
    private ac x;
    private DataSetObserver y;
    private e z;

    public interface a {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    private class b extends DataSetObserver {
        private b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.c();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.c();
        }
    }

    private class c extends LinearLayout {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Paint f363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f365e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f366f;
        private int g;
        private u h;

        c(Context context) {
            super(context);
            this.f364d = -1;
            this.f366f = -1;
            this.g = -1;
            setWillNotDraw(false);
            this.f363c = new Paint();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, int i2) {
            if (i == this.f366f && i2 == this.g) {
                return;
            }
            this.f366f = i;
            this.g = i2;
            ah.d(this);
        }

        private void c() {
            int right;
            int left;
            View childAt = getChildAt(this.f364d);
            if (childAt == null || childAt.getWidth() <= 0) {
                right = -1;
                left = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                if (this.f365e > BitmapDescriptorFactory.HUE_RED && this.f364d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f364d + 1);
                    left = (int) ((left * (1.0f - this.f365e)) + (this.f365e * childAt2.getLeft()));
                    right = (int) ((right * (1.0f - this.f365e)) + (childAt2.getRight() * this.f365e));
                }
            }
            b(left, right);
        }

        void a(int i) {
            if (this.f363c.getColor() != i) {
                this.f363c.setColor(i);
                ah.d(this);
            }
        }

        void a(int i, float f2) {
            if (this.h != null && this.h.b()) {
                this.h.e();
            }
            this.f364d = i;
            this.f365e = f2;
            c();
        }

        void a(final int i, int i2) {
            final int i3;
            final int i4;
            if (this.h != null && this.h.b()) {
                this.h.e();
            }
            boolean z = ah.h(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                c();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.f364d) <= 1) {
                i4 = this.f366f;
                i3 = this.g;
            } else {
                int iB = TabLayout.this.b(24);
                if (i < this.f364d) {
                    if (z) {
                        i3 = left - iB;
                        i4 = i3;
                    } else {
                        i3 = right + iB;
                        i4 = i3;
                    }
                } else if (z) {
                    i3 = right + iB;
                    i4 = i3;
                } else {
                    i3 = left - iB;
                    i4 = i3;
                }
            }
            if (i4 == left && i3 == right) {
                return;
            }
            u uVarA = ab.a();
            this.h = uVarA;
            uVarA.a(android.support.design.widget.a.f405b);
            uVarA.a(i2);
            uVarA.a(BitmapDescriptorFactory.HUE_RED, 1.0f);
            uVarA.a(new u.c() { // from class: android.support.design.widget.TabLayout.c.1
                @Override // android.support.design.widget.u.c
                public void a(u uVar) {
                    float f2 = uVar.f();
                    c.this.b(android.support.design.widget.a.a(i4, left, f2), android.support.design.widget.a.a(i3, right, f2));
                }
            });
            uVarA.a(new u.b() { // from class: android.support.design.widget.TabLayout.c.2
                @Override // android.support.design.widget.u.b, android.support.design.widget.u.a
                public void a(u uVar) {
                    c.this.f364d = i;
                    c.this.f365e = BitmapDescriptorFactory.HUE_RED;
                }
            });
            uVarA.a();
        }

        boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        float b() {
            return this.f364d + this.f365e;
        }

        void b(int i) {
            if (this.f362b != i) {
                this.f362b = i;
                ah.d(this);
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f366f < 0 || this.g <= this.f366f) {
                return;
            }
            canvas.drawRect(this.f366f, getHeight() - this.f362b, this.g, getHeight(), this.f363c);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.h == null || !this.h.b()) {
                c();
                return;
            }
            this.h.e();
            a(this.f364d, Math.round(this.h.g() * (1.0f - this.h.f())));
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            boolean z2 = false;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && TabLayout.this.t == 1 && TabLayout.this.s == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int iMax = 0;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    i3++;
                    iMax = childAt.getVisibility() == 0 ? Math.max(iMax, childAt.getMeasuredWidth()) : iMax;
                }
                if (iMax > 0) {
                    if (iMax * childCount <= getMeasuredWidth() - (TabLayout.this.b(16) * 2)) {
                        int i4 = 0;
                        while (i4 < childCount) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                            if (layoutParams.width == iMax && layoutParams.weight == BitmapDescriptorFactory.HUE_RED) {
                                z = z2;
                            } else {
                                layoutParams.width = iMax;
                                layoutParams.weight = BitmapDescriptorFactory.HUE_RED;
                                z = true;
                            }
                            i4++;
                            z2 = z;
                        }
                    } else {
                        TabLayout.this.s = 0;
                        TabLayout.this.a(false);
                        z2 = true;
                    }
                    if (z2) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Drawable f375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f377d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f378e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f379f;
        private TabLayout g;
        private f h;

        private d() {
            this.f378e = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            if (this.h != null) {
                this.h.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.g = null;
            this.h = null;
            this.f374a = null;
            this.f375b = null;
            this.f376c = null;
            this.f377d = null;
            this.f378e = -1;
            this.f379f = null;
        }

        public d a(int i) {
            return a(LayoutInflater.from(this.h.getContext()).inflate(i, (ViewGroup) this.h, false));
        }

        public d a(Drawable drawable) {
            this.f375b = drawable;
            g();
            return this;
        }

        public d a(View view) {
            this.f379f = view;
            g();
            return this;
        }

        public d a(CharSequence charSequence) {
            this.f376c = charSequence;
            g();
            return this;
        }

        public View a() {
            return this.f379f;
        }

        public Drawable b() {
            return this.f375b;
        }

        void b(int i) {
            this.f378e = i;
        }

        public int c() {
            return this.f378e;
        }

        public CharSequence d() {
            return this.f376c;
        }

        public void e() {
            if (this.g == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.g.b(this);
        }

        public CharSequence f() {
            return this.f377d;
        }
    }

    public static class e implements ViewPager.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<TabLayout> f380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f382c;

        public e(TabLayout tabLayout) {
            this.f380a = new WeakReference<>(tabLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f382c = 0;
            this.f381b = 0;
        }

        @Override // android.support.v4.view.ViewPager.f
        public void a(int i) {
            this.f381b = this.f382c;
            this.f382c = i;
        }

        @Override // android.support.v4.view.ViewPager.f
        public void a(int i, float f2, int i2) {
            TabLayout tabLayout = this.f380a.get();
            if (tabLayout != null) {
                tabLayout.a(i, f2, this.f382c != 2 || this.f381b == 1, (this.f382c == 2 && this.f381b == 0) ? false : true);
            }
        }

        @Override // android.support.v4.view.ViewPager.f
        public void b(int i) {
            TabLayout tabLayout = this.f380a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i) {
                return;
            }
            tabLayout.b(tabLayout.a(i), this.f382c == 0 || (this.f382c == 2 && this.f381b == 0));
        }
    }

    class f extends LinearLayout implements View.OnLongClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f385c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ImageView f386d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f387e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private TextView f388f;
        private ImageView g;
        private int h;

        public f(Context context) {
            super(context);
            this.h = 2;
            if (TabLayout.this.m != 0) {
                setBackgroundDrawable(android.support.v7.widget.h.a().a(context, TabLayout.this.m));
            }
            ah.b(this, TabLayout.this.f357e, TabLayout.this.f358f, TabLayout.this.g, TabLayout.this.h);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        private float a(Layout layout, int i, float f2) {
            return layout.getLineWidth(i) * (f2 / layout.getPaint().getTextSize());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            if (dVar != this.f384b) {
                this.f384b = dVar;
                a();
            }
        }

        private void a(TextView textView, ImageView imageView) {
            Drawable drawableB = this.f384b != null ? this.f384b.b() : null;
            CharSequence charSequenceD = this.f384b != null ? this.f384b.d() : null;
            CharSequence charSequenceF = this.f384b != null ? this.f384b.f() : null;
            if (imageView != null) {
                if (drawableB != null) {
                    imageView.setImageDrawable(drawableB);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequenceF);
            }
            boolean z = !TextUtils.isEmpty(charSequenceD);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequenceD);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(charSequenceF);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iB = (z && imageView.getVisibility() == 0) ? TabLayout.this.b(8) : 0;
                if (iB != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iB;
                    imageView.requestLayout();
                }
            }
            if (!z && !TextUtils.isEmpty(charSequenceF)) {
                setOnLongClickListener(this);
            } else {
                setOnLongClickListener(null);
                setLongClickable(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            a((d) null);
            setSelected(false);
        }

        final void a() {
            d dVar = this.f384b;
            View viewA = dVar != null ? dVar.a() : null;
            if (viewA != null) {
                ViewParent parent = viewA.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewA);
                    }
                    addView(viewA);
                }
                this.f387e = viewA;
                if (this.f385c != null) {
                    this.f385c.setVisibility(8);
                }
                if (this.f386d != null) {
                    this.f386d.setVisibility(8);
                    this.f386d.setImageDrawable(null);
                }
                this.f388f = (TextView) viewA.findViewById(R.id.text1);
                if (this.f388f != null) {
                    this.h = android.support.v4.widget.z.a(this.f388f);
                }
                this.g = (ImageView) viewA.findViewById(R.id.icon);
            } else {
                if (this.f387e != null) {
                    removeView(this.f387e);
                    this.f387e = null;
                }
                this.f388f = null;
                this.g = null;
            }
            if (this.f387e != null) {
                if (this.f388f == null && this.g == null) {
                    return;
                }
                a(this.f388f, this.g);
                return;
            }
            if (this.f386d == null) {
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(android.support.design.a.f.design_layout_tab_icon, (ViewGroup) this, false);
                addView(imageView, 0);
                this.f386d = imageView;
            }
            if (this.f385c == null) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(android.support.design.a.f.design_layout_tab_text, (ViewGroup) this, false);
                addView(textView);
                this.f385c = textView;
                this.h = android.support.v4.widget.z.a(this.f385c);
            }
            this.f385c.setTextAppearance(getContext(), TabLayout.this.i);
            if (TabLayout.this.j != null) {
                this.f385c.setTextColor(TabLayout.this.j);
            }
            a(this.f385c, this.f386d);
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.a.a.c.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.a.a.c.class.getName());
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast toastMakeText = Toast.makeText(context, this.f384b.f(), 0);
            toastMakeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            toastMakeText.show();
            return true;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            boolean z = true;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.n, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f385c != null) {
                getResources();
                float f2 = TabLayout.this.k;
                int i3 = this.h;
                if (this.f386d != null && this.f386d.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.f385c != null && this.f385c.getLineCount() > 1) {
                    f2 = TabLayout.this.l;
                }
                float textSize = this.f385c.getTextSize();
                int lineCount = this.f385c.getLineCount();
                int iA = android.support.v4.widget.z.a(this.f385c);
                if (f2 != textSize || (iA >= 0 && i3 != iA)) {
                    if (TabLayout.this.t == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f385c.getLayout()) == null || a(layout, 0, f2) > layout.getWidth())) {
                        z = false;
                    }
                    if (z) {
                        this.f385c.setTextSize(0, f2);
                        this.f385c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f384b == null) {
                return zPerformClick;
            }
            this.f384b.e();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
                if (this.f385c != null) {
                    this.f385c.setSelected(z);
                }
                if (this.f386d != null) {
                    this.f386d.setSelected(z);
                }
            }
        }
    }

    public static class g implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f389a;

        public g(ViewPager viewPager) {
            this.f389a = viewPager;
        }

        @Override // android.support.design.widget.TabLayout.a
        public void a(d dVar) {
            this.f389a.setCurrentItem(dVar.c());
        }

        @Override // android.support.design.widget.TabLayout.a
        public void b(d dVar) {
        }

        @Override // android.support.design.widget.TabLayout.a
        public void c(d dVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f354b = new ArrayList<>();
        this.n = Integer.MAX_VALUE;
        this.A = new android.support.v4.h.h.b(12);
        t.a(context);
        setHorizontalScrollBarEnabled(false);
        this.f356d = new c(context);
        super.addView(this.f356d, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.TabLayout, i, android.support.design.a.h.Widget_Design_TabLayout);
        this.f356d.b(typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabIndicatorHeight, 0));
        this.f356d.a(typedArrayObtainStyledAttributes.getColor(android.support.design.a.i.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabPadding, 0);
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f358f = dimensionPixelSize;
        this.f357e = dimensionPixelSize;
        this.f357e = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabPaddingStart, this.f357e);
        this.f358f = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabPaddingTop, this.f358f);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabPaddingEnd, this.g);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabPaddingBottom, this.h);
        this.i = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.TabLayout_tabTextAppearance, android.support.design.a.h.TextAppearance_Design_Tab);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(this.i, android.support.design.a.i.TextAppearance);
        try {
            this.k = typedArrayObtainStyledAttributes2.getDimensionPixelSize(android.support.design.a.i.TextAppearance_android_textSize, 0);
            this.j = typedArrayObtainStyledAttributes2.getColorStateList(android.support.design.a.i.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes2.recycle();
            if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.TabLayout_tabTextColor)) {
                this.j = typedArrayObtainStyledAttributes.getColorStateList(android.support.design.a.i.TabLayout_tabTextColor);
            }
            if (typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.TabLayout_tabSelectedTextColor)) {
                this.j = a(this.j.getDefaultColor(), typedArrayObtainStyledAttributes.getColor(android.support.design.a.i.TabLayout_tabSelectedTextColor, 0));
            }
            this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabMinWidth, -1);
            this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabMaxWidth, -1);
            this.m = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.TabLayout_tabBackground, 0);
            this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.TabLayout_tabContentStart, 0);
            this.t = typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.TabLayout_tabMode, 1);
            this.s = typedArrayObtainStyledAttributes.getInt(android.support.design.a.i.TabLayout_tabGravity, 0);
            typedArrayObtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.l = resources.getDimensionPixelSize(android.support.design.a.d.design_tab_text_size_2line);
            this.q = resources.getDimensionPixelSize(android.support.design.a.d.design_tab_scrollable_min_width);
            f();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private int a(int i, float f2) {
        if (this.t != 0) {
            return 0;
        }
        View childAt = this.f356d.getChildAt(i);
        View childAt2 = i + 1 < this.f356d.getChildCount() ? this.f356d.getChildAt(i + 1) : null;
        return ((((int) ((((childAt2 != null ? childAt2.getWidth() : 0) + (childAt != null ? childAt.getWidth() : 0)) * f2) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private static ColorStateList a(int i, int i2) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f2, boolean z, boolean z2) {
        int iRound = Math.round(i + f2);
        if (iRound < 0 || iRound >= this.f356d.getChildCount()) {
            return;
        }
        if (z2) {
            this.f356d.a(i, f2);
        }
        if (this.v != null && this.v.b()) {
            this.v.e();
        }
        scrollTo(a(i, f2), 0);
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    private void a(d dVar, int i) {
        dVar.b(i);
        this.f354b.add(i, dVar);
        int size = this.f354b.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.f354b.get(i2).b(i2);
        }
    }

    private void a(s sVar) {
        d dVarA = a();
        if (sVar.f492a != null) {
            dVarA.a(sVar.f492a);
        }
        if (sVar.f493b != null) {
            dVarA.a(sVar.f493b);
        }
        if (sVar.f494c != 0) {
            dVarA.a(sVar.f494c);
        }
        a(dVarA);
    }

    private void a(ac acVar, boolean z) {
        if (this.x != null && this.y != null) {
            this.x.b(this.y);
        }
        this.x = acVar;
        if (z && acVar != null) {
            if (this.y == null) {
                this.y = new b();
            }
            acVar.a(this.y);
        }
        c();
    }

    private void a(View view) {
        if (!(view instanceof s)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        a((s) view);
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.t == 1 && this.s == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = BitmapDescriptorFactory.HUE_RED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f356d.getChildCount()) {
                return;
            }
            View childAt = this.f356d.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    private f c(d dVar) {
        f fVarA = this.A != null ? this.A.a() : null;
        if (fVarA == null) {
            fVarA = new f(getContext());
        }
        fVarA.a(dVar);
        fVarA.setFocusable(true);
        fVarA.setMinimumWidth(getTabMinWidth());
        return fVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int currentItem;
        b();
        if (this.x == null) {
            b();
            return;
        }
        int iB = this.x.b();
        for (int i = 0; i < iB; i++) {
            a(a().a(this.x.b(i)), false);
        }
        if (this.w == null || iB <= 0 || (currentItem = this.w.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
            return;
        }
        b(a(currentItem));
    }

    private void c(int i) {
        f fVar = (f) this.f356d.getChildAt(i);
        this.f356d.removeViewAt(i);
        if (fVar != null) {
            fVar.b();
            this.A.a(fVar);
        }
        requestLayout();
    }

    private void c(d dVar, boolean z) {
        f fVar = dVar.h;
        this.f356d.addView(fVar, e());
        if (z) {
            fVar.setSelected(true);
        }
    }

    private void d() {
        int size = this.f354b.size();
        for (int i = 0; i < size; i++) {
            this.f354b.get(i).g();
        }
    }

    private void d(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() == null || !ah.D(this) || this.f356d.a()) {
            a(i, BitmapDescriptorFactory.HUE_RED, true);
            return;
        }
        int scrollX = getScrollX();
        int iA = a(i, BitmapDescriptorFactory.HUE_RED);
        if (scrollX != iA) {
            if (this.v == null) {
                this.v = ab.a();
                this.v.a(android.support.design.widget.a.f405b);
                this.v.a(300);
                this.v.a(new u.c() { // from class: android.support.design.widget.TabLayout.1
                    @Override // android.support.design.widget.u.c
                    public void a(u uVar) {
                        TabLayout.this.scrollTo(uVar.c(), 0);
                    }
                });
            }
            this.v.a(scrollX, iA);
            this.v.a();
        }
        this.f356d.a(i, 300);
    }

    private LinearLayout.LayoutParams e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void f() {
        ah.b(this.f356d, this.t == 0 ? Math.max(0, this.r - this.f357e) : 0, 0, 0, 0);
        switch (this.t) {
            case 0:
                this.f356d.setGravity(8388611);
                break;
            case 1:
                this.f356d.setGravity(1);
                break;
        }
        a(true);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0027 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x002e A[RETURN, SYNTHETIC] */
    private int getDefaultHeight() {
        boolean z;
        int size = this.f354b.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.f354b.get(i);
            if (dVar != null && dVar.b() != null && !TextUtils.isEmpty(dVar.d())) {
                z = true;
                if (z) {
                    return 72;
                }
                return 48;
            }
        }
        z = false;
        if (z) {
            return 72;
        }
        return 48;
    }

    private float getScrollPosition() {
        return this.f356d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTabMaxWidth() {
        return this.n;
    }

    private int getTabMinWidth() {
        if (this.o != -1) {
            return this.o;
        }
        if (this.t == 0) {
            return this.q;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f356d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f356d.getChildCount();
        if (i >= childCount || this.f356d.getChildAt(i).isSelected()) {
            return;
        }
        int i2 = 0;
        while (i2 < childCount) {
            this.f356d.getChildAt(i2).setSelected(i2 == i);
            i2++;
        }
    }

    public d a() {
        d dVarA = f353a.a();
        if (dVarA == null) {
            dVarA = new d();
        }
        dVarA.g = this;
        dVarA.h = c(dVarA);
        return dVarA;
    }

    public d a(int i) {
        return this.f354b.get(i);
    }

    public void a(int i, float f2, boolean z) {
        a(i, f2, z, true);
    }

    public void a(d dVar) {
        a(dVar, this.f354b.isEmpty());
    }

    public void a(d dVar, boolean z) {
        if (dVar.g != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        c(dVar, z);
        a(dVar, this.f354b.size());
        if (z) {
            dVar.e();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void b() {
        for (int childCount = this.f356d.getChildCount() - 1; childCount >= 0; childCount--) {
            c(childCount);
        }
        Iterator<d> it = this.f354b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            it.remove();
            next.h();
            f353a.a(next);
        }
        this.f355c = null;
    }

    void b(d dVar) {
        b(dVar, true);
    }

    void b(d dVar, boolean z) {
        if (this.f355c == dVar) {
            if (this.f355c != null) {
                if (this.u != null) {
                    this.u.c(this.f355c);
                }
                d(dVar.c());
                return;
            }
            return;
        }
        if (z) {
            int iC = dVar != null ? dVar.c() : -1;
            if (iC != -1) {
                setSelectedTabView(iC);
            }
            if ((this.f355c == null || this.f355c.c() == -1) && iC != -1) {
                a(iC, BitmapDescriptorFactory.HUE_RED, true);
            } else {
                d(iC);
            }
        }
        if (this.f355c != null && this.u != null) {
            this.u.b(this.f355c);
        }
        this.f355c = dVar;
        if (this.f355c == null || this.u == null) {
            return;
        }
        this.u.a(this.f355c);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        if (this.f355c != null) {
            return this.f355c.c();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f354b.size();
    }

    public int getTabGravity() {
        return this.s;
    }

    public int getTabMode() {
        return this.t;
    }

    public ColorStateList getTabTextColors() {
        return this.j;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int iB = b(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        switch (View.MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(iB, View.MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = View.MeasureSpec.makeMeasureSpec(iB, 1073741824);
                break;
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            this.n = this.p > 0 ? this.p : size - b(56);
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.t) {
                case 0:
                    z = childAt.getMeasuredWidth() < getMeasuredWidth();
                    break;
                case 1:
                    z = childAt.getMeasuredWidth() != getMeasuredWidth();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void setOnTabSelectedListener(a aVar) {
        this.u = aVar;
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f356d.a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f356d.b(i);
    }

    public void setTabGravity(int i) {
        if (this.s != i) {
            this.s = i;
            f();
        }
    }

    public void setTabMode(int i) {
        if (i != this.t) {
            this.t = i;
            f();
        }
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            d();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(ac acVar) {
        a(acVar, false);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        if (this.w != null && this.z != null) {
            this.w.b(this.z);
        }
        if (viewPager == null) {
            this.w = null;
            setOnTabSelectedListener(null);
            a((ac) null, true);
            return;
        }
        ac adapter = viewPager.getAdapter();
        if (adapter == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        }
        this.w = viewPager;
        if (this.z == null) {
            this.z = new e(this);
        }
        this.z.a();
        viewPager.a(this.z);
        setOnTabSelectedListener(new g(viewPager));
        a(adapter, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
