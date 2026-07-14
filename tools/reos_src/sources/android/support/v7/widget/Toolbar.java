package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private boolean A;
    private final ArrayList<View> B;
    private final ArrayList<View> C;
    private final int[] D;
    private c E;
    private final ActionMenuView.e F;
    private aq G;
    private ActionMenuPresenter H;
    private a I;
    private android.support.v7.view.menu.l.a J;
    private android.support.v7.view.menu.f.a K;
    private boolean L;
    private final Runnable M;
    private final h N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    View f1659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ActionMenuView f1660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f1661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f1662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageButton f1663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageView f1664f;
    private Drawable g;
    private CharSequence h;
    private ImageButton i;
    private Context j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final af t;
    private int u;
    private CharSequence v;
    private CharSequence w;
    private int x;
    private int y;
    private boolean z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.Toolbar.SavedState.1
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
        int f1668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1669b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1668a = parcel.readInt();
            this.f1669b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1668a);
            parcel.writeInt(this.f1669b ? 1 : 0);
        }
    }

    private class a implements android.support.v7.view.menu.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.support.v7.view.menu.f f1670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        android.support.v7.view.menu.h f1671b;

        private a() {
        }

        @Override // android.support.v7.view.menu.l
        public void a(Context context, android.support.v7.view.menu.f fVar) {
            if (this.f1670a != null && this.f1671b != null) {
                this.f1670a.d(this.f1671b);
            }
            this.f1670a = fVar;
        }

        @Override // android.support.v7.view.menu.l
        public void a(Parcelable parcelable) {
        }

        @Override // android.support.v7.view.menu.l
        public void a(android.support.v7.view.menu.f fVar, boolean z) {
        }

        @Override // android.support.v7.view.menu.l
        public void a(boolean z) {
            boolean z2 = false;
            if (this.f1671b != null) {
                if (this.f1670a != null) {
                    int size = this.f1670a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f1670a.getItem(i) == this.f1671b) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                b(this.f1670a, this.f1671b);
            }
        }

        @Override // android.support.v7.view.menu.l
        public boolean a() {
            return false;
        }

        @Override // android.support.v7.view.menu.l
        public boolean a(android.support.v7.view.menu.f fVar, android.support.v7.view.menu.h hVar) {
            Toolbar.this.p();
            if (Toolbar.this.i.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.i);
            }
            Toolbar.this.f1659a = hVar.getActionView();
            this.f1671b = hVar;
            if (Toolbar.this.f1659a.getParent() != Toolbar.this) {
                b bVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                bVarGenerateDefaultLayoutParams.f1038a = 8388611 | (Toolbar.this.n & 112);
                bVarGenerateDefaultLayoutParams.f1673b = 2;
                Toolbar.this.f1659a.setLayoutParams(bVarGenerateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.f1659a);
            }
            Toolbar.this.j();
            Toolbar.this.requestLayout();
            hVar.e(true);
            if (Toolbar.this.f1659a instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) Toolbar.this.f1659a).a();
            }
            return true;
        }

        @Override // android.support.v7.view.menu.l
        public boolean a(android.support.v7.view.menu.p pVar) {
            return false;
        }

        @Override // android.support.v7.view.menu.l
        public int b() {
            return 0;
        }

        @Override // android.support.v7.view.menu.l
        public boolean b(android.support.v7.view.menu.f fVar, android.support.v7.view.menu.h hVar) {
            if (Toolbar.this.f1659a instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) Toolbar.this.f1659a).b();
            }
            Toolbar.this.removeView(Toolbar.this.f1659a);
            Toolbar.this.removeView(Toolbar.this.i);
            Toolbar.this.f1659a = null;
            Toolbar.this.k();
            this.f1671b = null;
            Toolbar.this.requestLayout();
            hVar.e(false);
            return true;
        }

        @Override // android.support.v7.view.menu.l
        public Parcelable c() {
            return null;
        }
    }

    public static class b extends android.support.v7.a.a.C0026a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1673b;

        public b(int i, int i2) {
            super(i, i2);
            this.f1673b = 0;
            this.f1038a = 8388627;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1673b = 0;
        }

        public b(android.support.v7.a.a.C0026a c0026a) {
            super(c0026a);
            this.f1673b = 0;
        }

        public b(b bVar) {
            super((android.support.v7.a.a.C0026a) bVar);
            this.f1673b = 0;
            this.f1673b = bVar.f1673b;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1673b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1673b = 0;
            a(marginLayoutParams);
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface c {
        boolean a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.a.C0029a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = new af();
        this.u = 8388627;
        this.B = new ArrayList<>();
        this.C = new ArrayList<>();
        this.D = new int[2];
        this.F = new ActionMenuView.e() { // from class: android.support.v7.widget.Toolbar.1
            @Override // android.support.v7.widget.ActionMenuView.e
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.E != null) {
                    return Toolbar.this.E.a(menuItem);
                }
                return false;
            }
        };
        this.M = new Runnable() { // from class: android.support.v7.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.d();
            }
        };
        ap apVarA = ap.a(getContext(), attributeSet, android.support.v7.b.a.k.Toolbar, i, 0);
        this.l = apVarA.g(android.support.v7.b.a.k.Toolbar_titleTextAppearance, 0);
        this.m = apVarA.g(android.support.v7.b.a.k.Toolbar_subtitleTextAppearance, 0);
        this.u = apVarA.c(android.support.v7.b.a.k.Toolbar_android_gravity, this.u);
        this.n = 48;
        int iD = apVarA.d(android.support.v7.b.a.k.Toolbar_titleMargins, 0);
        this.s = iD;
        this.r = iD;
        this.q = iD;
        this.p = iD;
        int iD2 = apVarA.d(android.support.v7.b.a.k.Toolbar_titleMarginStart, -1);
        if (iD2 >= 0) {
            this.p = iD2;
        }
        int iD3 = apVarA.d(android.support.v7.b.a.k.Toolbar_titleMarginEnd, -1);
        if (iD3 >= 0) {
            this.q = iD3;
        }
        int iD4 = apVarA.d(android.support.v7.b.a.k.Toolbar_titleMarginTop, -1);
        if (iD4 >= 0) {
            this.r = iD4;
        }
        int iD5 = apVarA.d(android.support.v7.b.a.k.Toolbar_titleMarginBottom, -1);
        if (iD5 >= 0) {
            this.s = iD5;
        }
        this.o = apVarA.e(android.support.v7.b.a.k.Toolbar_maxButtonHeight, -1);
        int iD6 = apVarA.d(android.support.v7.b.a.k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iD7 = apVarA.d(android.support.v7.b.a.k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.t.b(apVarA.e(android.support.v7.b.a.k.Toolbar_contentInsetLeft, 0), apVarA.e(android.support.v7.b.a.k.Toolbar_contentInsetRight, 0));
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.t.a(iD6, iD7);
        }
        this.g = apVarA.a(android.support.v7.b.a.k.Toolbar_collapseIcon);
        this.h = apVarA.c(android.support.v7.b.a.k.Toolbar_collapseContentDescription);
        CharSequence charSequenceC = apVarA.c(android.support.v7.b.a.k.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceC)) {
            setTitle(charSequenceC);
        }
        CharSequence charSequenceC2 = apVarA.c(android.support.v7.b.a.k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceC2)) {
            setSubtitle(charSequenceC2);
        }
        this.j = getContext();
        setPopupTheme(apVarA.g(android.support.v7.b.a.k.Toolbar_popupTheme, 0));
        Drawable drawableA = apVarA.a(android.support.v7.b.a.k.Toolbar_navigationIcon);
        if (drawableA != null) {
            setNavigationIcon(drawableA);
        }
        CharSequence charSequenceC3 = apVarA.c(android.support.v7.b.a.k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceC3)) {
            setNavigationContentDescription(charSequenceC3);
        }
        Drawable drawableA2 = apVarA.a(android.support.v7.b.a.k.Toolbar_logo);
        if (drawableA2 != null) {
            setLogo(drawableA2);
        }
        CharSequence charSequenceC4 = apVarA.c(android.support.v7.b.a.k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceC4)) {
            setLogoDescription(charSequenceC4);
        }
        if (apVarA.f(android.support.v7.b.a.k.Toolbar_titleTextColor)) {
            setTitleTextColor(apVarA.b(android.support.v7.b.a.k.Toolbar_titleTextColor, -1));
        }
        if (apVarA.f(android.support.v7.b.a.k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(apVarA.b(android.support.v7.b.a.k.Toolbar_subtitleTextColor, -1));
        }
        apVarA.a();
        this.N = h.a();
    }

    private int a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.u & 112;
        }
    }

    private int a(View view, int i) {
        int iMax;
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (a(bVar.f1038a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i3 < bVar.topMargin) {
                    iMax = bVar.topMargin;
                } else {
                    int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    iMax = i4 < bVar.bottomMargin ? Math.max(0, i3 - (bVar.bottomMargin - i4)) : i3;
                }
                return iMax + paddingTop;
        }
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int iMax = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int iA = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iA, iMax + measuredWidth, view.getMeasuredHeight() + iA);
        return bVar.rightMargin + measuredWidth + iMax;
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int measuredWidth = 0;
        int iMax = i2;
        int iMax2 = i;
        while (i3 < size) {
            View view = list.get(i3);
            b bVar = (b) view.getLayoutParams();
            int i4 = bVar.leftMargin - iMax2;
            int i5 = bVar.rightMargin - iMax;
            int iMax3 = Math.max(0, i4);
            int iMax4 = Math.max(0, i5);
            iMax2 = Math.max(0, -i4);
            iMax = Math.max(0, -i5);
            i3++;
            measuredWidth += view.getMeasuredWidth() + iMax3 + iMax4;
        }
        return measuredWidth;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z) {
        b bVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            bVarGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (b) layoutParams;
        }
        bVarGenerateLayoutParams.f1673b = 1;
        if (!z || this.f1659a == null) {
            addView(view, bVarGenerateLayoutParams);
        } else {
            view.setLayoutParams(bVarGenerateLayoutParams);
            this.C.add(view);
        }
    }

    private void a(List<View> list, int i) {
        boolean z = android.support.v4.view.ah.h(this) == 1;
        int childCount = getChildCount();
        int iA = android.support.v4.view.e.a(i, android.support.v4.view.ah.h(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.f1673b == 0 && a(childAt) && b(bVar.f1038a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.f1673b == 0 && a(childAt2) && b(bVar2.f1038a) == iA) {
                list.add(childAt2);
            }
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i) {
        int iH = android.support.v4.view.ah.h(this);
        int iA = android.support.v4.view.e.a(i, iH) & 7;
        switch (iA) {
            case 1:
            case 3:
            case 5:
                return iA;
            case 2:
            case 4:
            default:
                return iH == 1 ? 5 : 3;
        }
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.view.o.b(marginLayoutParams) + android.support.v4.view.o.a(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iA = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iA, iMax, view.getMeasuredHeight() + iA);
        return iMax - (bVar.leftMargin + measuredWidth);
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.C.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new android.support.v7.view.g(getContext());
    }

    private void l() {
        if (this.f1664f == null) {
            this.f1664f = new ImageView(getContext());
        }
    }

    private void m() {
        n();
        if (this.f1660b.d() == null) {
            android.support.v7.view.menu.f fVar = (android.support.v7.view.menu.f) this.f1660b.getMenu();
            if (this.I == null) {
                this.I = new a();
            }
            this.f1660b.setExpandedActionViewsExclusive(true);
            fVar.a(this.I, this.j);
        }
    }

    private void n() {
        if (this.f1660b == null) {
            this.f1660b = new ActionMenuView(getContext());
            this.f1660b.setPopupTheme(this.k);
            this.f1660b.setOnMenuItemClickListener(this.F);
            this.f1660b.a(this.J, this.K);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f1038a = 8388613 | (this.n & 112);
            this.f1660b.setLayoutParams(bVarGenerateDefaultLayoutParams);
            a((View) this.f1660b, false);
        }
    }

    private void o() {
        if (this.f1663e == null) {
            this.f1663e = new ImageButton(getContext(), null, android.support.v7.b.a.C0029a.toolbarNavigationButtonStyle);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f1038a = 8388611 | (this.n & 112);
            this.f1663e.setLayoutParams(bVarGenerateDefaultLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.i == null) {
            this.i = new ImageButton(getContext(), null, android.support.v7.b.a.C0029a.toolbarNavigationButtonStyle);
            this.i.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f1038a = 8388611 | (this.n & 112);
            bVarGenerateDefaultLayoutParams.f1673b = 2;
            this.i.setLayoutParams(bVarGenerateDefaultLayoutParams);
            this.i.setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.h();
                }
            });
        }
    }

    private void q() {
        removeCallbacks(this.M);
        post(this.M);
    }

    private boolean r() {
        if (!this.L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.a.a.C0026a) {
            return new b((android.support.v7.a.a.C0026a) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(int i, int i2) {
        this.t.a(i, i2);
    }

    public void a(Context context, int i) {
        this.l = i;
        if (this.f1661c != null) {
            this.f1661c.setTextAppearance(context, i);
        }
    }

    public void a(android.support.v7.view.menu.f fVar, ActionMenuPresenter actionMenuPresenter) {
        if (fVar == null && this.f1660b == null) {
            return;
        }
        n();
        android.support.v7.view.menu.f fVarD = this.f1660b.d();
        if (fVarD != fVar) {
            if (fVarD != null) {
                fVarD.b(this.H);
                fVarD.b(this.I);
            }
            if (this.I == null) {
                this.I = new a();
            }
            actionMenuPresenter.d(true);
            if (fVar != null) {
                fVar.a(actionMenuPresenter, this.j);
                fVar.a(this.I, this.j);
            } else {
                actionMenuPresenter.a(this.j, (android.support.v7.view.menu.f) null);
                this.I.a(this.j, (android.support.v7.view.menu.f) null);
                actionMenuPresenter.a(true);
                this.I.a(true);
            }
            this.f1660b.setPopupTheme(this.k);
            this.f1660b.setPresenter(actionMenuPresenter);
            this.H = actionMenuPresenter;
        }
    }

    public void a(android.support.v7.view.menu.l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        this.J = aVar;
        this.K = aVar2;
        if (this.f1660b != null) {
            this.f1660b.a(aVar, aVar2);
        }
    }

    public boolean a() {
        return getVisibility() == 0 && this.f1660b != null && this.f1660b.a();
    }

    public void b(Context context, int i) {
        this.m = i;
        if (this.f1662d != null) {
            this.f1662d.setTextAppearance(context, i);
        }
    }

    public boolean b() {
        return this.f1660b != null && this.f1660b.g();
    }

    public boolean c() {
        return this.f1660b != null && this.f1660b.h();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public boolean d() {
        return this.f1660b != null && this.f1660b.e();
    }

    public boolean e() {
        return this.f1660b != null && this.f1660b.f();
    }

    public void f() {
        if (this.f1660b != null) {
            this.f1660b.i();
        }
    }

    public boolean g() {
        return (this.I == null || this.I.f1671b == null) ? false : true;
    }

    public int getContentInsetEnd() {
        return this.t.d();
    }

    public int getContentInsetLeft() {
        return this.t.a();
    }

    public int getContentInsetRight() {
        return this.t.b();
    }

    public int getContentInsetStart() {
        return this.t.c();
    }

    public Drawable getLogo() {
        if (this.f1664f != null) {
            return this.f1664f.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        if (this.f1664f != null) {
            return this.f1664f.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m();
        return this.f1660b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        if (this.f1663e != null) {
            return this.f1663e.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        if (this.f1663e != null) {
            return this.f1663e.getDrawable();
        }
        return null;
    }

    public Drawable getOverflowIcon() {
        m();
        return this.f1660b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.w;
    }

    public CharSequence getTitle() {
        return this.v;
    }

    public u getWrapper() {
        if (this.G == null) {
            this.G = new aq(this, true);
        }
        return this.G;
    }

    public void h() {
        android.support.v7.view.menu.h hVar = this.I == null ? null : this.I.f1671b;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    void j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((b) childAt.getLayoutParams()).f1673b != 2 && childAt != this.f1660b) {
                removeViewAt(childCount);
                this.C.add(childAt);
            }
        }
    }

    void k() {
        for (int size = this.C.size() - 1; size >= 0; size--) {
            addView(this.C.get(size));
        }
        this.C.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.M);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int iA = android.support.v4.view.t.a(motionEvent);
        if (iA == 9) {
            this.A = false;
        }
        if (!this.A) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (iA == 9 && !zOnHoverEvent) {
                this.A = true;
            }
        }
        if (iA == 10 || iA == 3) {
            this.A = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iA;
        int iMin;
        int iMax;
        int measuredHeight;
        int paddingTop;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int iMax2;
        boolean z2 = android.support.v4.view.ah.h(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int iB = width - paddingRight;
        int[] iArr = this.D;
        iArr[1] = 0;
        iArr[0] = 0;
        int iR = android.support.v4.view.ah.r(this);
        if (!a(this.f1663e)) {
            iA = paddingLeft;
        } else if (z2) {
            iB = b(this.f1663e, iB, iArr, iR);
            iA = paddingLeft;
        } else {
            iA = a(this.f1663e, paddingLeft, iArr, iR);
        }
        if (a(this.i)) {
            if (z2) {
                iB = b(this.i, iB, iArr, iR);
            } else {
                iA = a(this.i, iA, iArr, iR);
            }
        }
        if (a(this.f1660b)) {
            if (z2) {
                iA = a(this.f1660b, iA, iArr, iR);
            } else {
                iB = b(this.f1660b, iB, iArr, iR);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - iA);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - iB));
        int iMax3 = Math.max(iA, getContentInsetLeft());
        int iMin2 = Math.min(iB, (width - paddingRight) - getContentInsetRight());
        if (a(this.f1659a)) {
            if (z2) {
                iMin2 = b(this.f1659a, iMin2, iArr, iR);
            } else {
                iMax3 = a(this.f1659a, iMax3, iArr, iR);
            }
        }
        if (!a(this.f1664f)) {
            iMin = iMin2;
            iMax = iMax3;
        } else if (z2) {
            iMin = b(this.f1664f, iMin2, iArr, iR);
            iMax = iMax3;
        } else {
            iMin = iMin2;
            iMax = a(this.f1664f, iMax3, iArr, iR);
        }
        boolean zA = a(this.f1661c);
        boolean zA2 = a(this.f1662d);
        int measuredHeight2 = 0;
        if (zA) {
            b bVar = (b) this.f1661c.getLayoutParams();
            measuredHeight2 = 0 + bVar.bottomMargin + bVar.topMargin + this.f1661c.getMeasuredHeight();
        }
        if (zA2) {
            b bVar2 = (b) this.f1662d.getLayoutParams();
            measuredHeight = bVar2.bottomMargin + bVar2.topMargin + this.f1662d.getMeasuredHeight() + measuredHeight2;
        } else {
            measuredHeight = measuredHeight2;
        }
        if (zA || zA2) {
            TextView textView = zA ? this.f1661c : this.f1662d;
            TextView textView2 = zA2 ? this.f1662d : this.f1661c;
            b bVar3 = (b) textView.getLayoutParams();
            b bVar4 = (b) textView2.getLayoutParams();
            boolean z3 = (zA && this.f1661c.getMeasuredWidth() > 0) || (zA2 && this.f1662d.getMeasuredWidth() > 0);
            switch (this.u & 112) {
                case 48:
                    paddingTop = bVar3.topMargin + getPaddingTop() + this.r;
                    break;
                case 80:
                    paddingTop = (((height - paddingBottom) - bVar4.bottomMargin) - this.s) - measuredHeight;
                    break;
                default:
                    int i10 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (i10 < bVar3.topMargin + this.r) {
                        iMax2 = bVar3.topMargin + this.r;
                    } else {
                        int i11 = (((height - paddingBottom) - measuredHeight) - i10) - paddingTop2;
                        iMax2 = i11 < bVar3.bottomMargin + this.s ? Math.max(0, i10 - ((bVar4.bottomMargin + this.s) - i11)) : i10;
                    }
                    paddingTop = paddingTop2 + iMax2;
                    break;
            }
            if (z2) {
                int i12 = (z3 ? this.p : 0) - iArr[1];
                int iMax4 = iMin - Math.max(0, i12);
                iArr[1] = Math.max(0, -i12);
                if (zA) {
                    b bVar5 = (b) this.f1661c.getLayoutParams();
                    int measuredWidth = iMax4 - this.f1661c.getMeasuredWidth();
                    int measuredHeight3 = this.f1661c.getMeasuredHeight() + paddingTop;
                    this.f1661c.layout(measuredWidth, paddingTop, iMax4, measuredHeight3);
                    int i13 = measuredWidth - this.q;
                    paddingTop = measuredHeight3 + bVar5.bottomMargin;
                    i8 = i13;
                } else {
                    i8 = iMax4;
                }
                if (zA2) {
                    b bVar6 = (b) this.f1662d.getLayoutParams();
                    int i14 = bVar6.topMargin + paddingTop;
                    int measuredWidth2 = iMax4 - this.f1662d.getMeasuredWidth();
                    int measuredHeight4 = this.f1662d.getMeasuredHeight() + i14;
                    this.f1662d.layout(measuredWidth2, i14, iMax4, measuredHeight4);
                    int i15 = iMax4 - this.q;
                    int i16 = bVar6.bottomMargin + measuredHeight4;
                    i9 = i15;
                } else {
                    i9 = iMax4;
                }
                iMin = z3 ? Math.min(i8, i9) : iMax4;
            } else {
                int i17 = (z3 ? this.p : 0) - iArr[0];
                iMax += Math.max(0, i17);
                iArr[0] = Math.max(0, -i17);
                if (zA) {
                    b bVar7 = (b) this.f1661c.getLayoutParams();
                    int measuredWidth3 = this.f1661c.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.f1661c.getMeasuredHeight() + paddingTop;
                    this.f1661c.layout(iMax, paddingTop, measuredWidth3, measuredHeight5);
                    int i18 = measuredWidth3 + this.q;
                    int i19 = bVar7.bottomMargin + measuredHeight5;
                    i5 = i18;
                    i6 = i19;
                } else {
                    i5 = iMax;
                    i6 = paddingTop;
                }
                if (zA2) {
                    b bVar8 = (b) this.f1662d.getLayoutParams();
                    int i20 = i6 + bVar8.topMargin;
                    int measuredWidth4 = this.f1662d.getMeasuredWidth() + iMax;
                    int measuredHeight6 = this.f1662d.getMeasuredHeight() + i20;
                    this.f1662d.layout(iMax, i20, measuredWidth4, measuredHeight6);
                    int i21 = this.q + measuredWidth4;
                    int i22 = bVar8.bottomMargin + measuredHeight6;
                    i7 = i21;
                } else {
                    i7 = iMax;
                }
                if (z3) {
                    iMax = Math.max(i5, i7);
                }
            }
        }
        a(this.B, 3);
        int size = this.B.size();
        int iA2 = iMax;
        for (int i23 = 0; i23 < size; i23++) {
            iA2 = a(this.B.get(i23), iA2, iArr, iR);
        }
        a(this.B, 5);
        int size2 = this.B.size();
        for (int i24 = 0; i24 < size2; i24++) {
            iMin = b(this.B.get(i24), iMin, iArr, iR);
        }
        a(this.B, 1);
        int iA3 = a(this.B, iArr);
        int i25 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (iA3 / 2);
        int i26 = iA3 + i25;
        if (i25 < iA2) {
            i25 = iA2;
        } else if (i26 > iMin) {
            i25 -= i26 - iMin;
        }
        int size3 = this.B.size();
        int iA4 = i25;
        for (int i27 = 0; i27 < size3; i27++) {
            iA4 = a(this.B.get(i27), iA4, iArr, iR);
        }
        this.B.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int iA;
        int i3;
        int iMax = 0;
        int iA2 = 0;
        int[] iArr = this.D;
        if (at.a(this)) {
            c2 = 0;
            c3 = 1;
        } else {
            c2 = 1;
            c3 = 0;
        }
        int measuredWidth = 0;
        if (a(this.f1663e)) {
            a(this.f1663e, i, 0, i2, 0, this.o);
            measuredWidth = this.f1663e.getMeasuredWidth() + b(this.f1663e);
            int iMax2 = Math.max(0, this.f1663e.getMeasuredHeight() + c(this.f1663e));
            iA2 = at.a(0, android.support.v4.view.ah.l(this.f1663e));
            iMax = iMax2;
        }
        if (a(this.i)) {
            a(this.i, i, 0, i2, 0, this.o);
            measuredWidth = this.i.getMeasuredWidth() + b(this.i);
            iMax = Math.max(iMax, this.i.getMeasuredHeight() + c(this.i));
            iA2 = at.a(iA2, android.support.v4.view.ah.l(this.i));
        }
        int contentInsetStart = getContentInsetStart();
        int iMax3 = 0 + Math.max(contentInsetStart, measuredWidth);
        iArr[c3] = Math.max(0, contentInsetStart - measuredWidth);
        int measuredWidth2 = 0;
        if (a(this.f1660b)) {
            a(this.f1660b, i, iMax3, i2, 0, this.o);
            measuredWidth2 = this.f1660b.getMeasuredWidth() + b(this.f1660b);
            iMax = Math.max(iMax, this.f1660b.getMeasuredHeight() + c(this.f1660b));
            iA2 = at.a(iA2, android.support.v4.view.ah.l(this.f1660b));
        }
        int contentInsetEnd = getContentInsetEnd();
        int iMax4 = iMax3 + Math.max(contentInsetEnd, measuredWidth2);
        iArr[c2] = Math.max(0, contentInsetEnd - measuredWidth2);
        if (a(this.f1659a)) {
            iMax4 += a(this.f1659a, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f1659a.getMeasuredHeight() + c(this.f1659a));
            iA2 = at.a(iA2, android.support.v4.view.ah.l(this.f1659a));
        }
        if (a(this.f1664f)) {
            iMax4 += a(this.f1664f, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f1664f.getMeasuredHeight() + c(this.f1664f));
            iA2 = at.a(iA2, android.support.v4.view.ah.l(this.f1664f));
        }
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = iMax;
        int iA3 = iA2;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (((b) childAt.getLayoutParams()).f1673b != 0) {
                iA = iA3;
                i3 = i5;
            } else if (a(childAt)) {
                iMax4 += a(childAt, i, iMax4, i2, 0, iArr);
                int iMax5 = Math.max(i5, childAt.getMeasuredHeight() + c(childAt));
                iA = at.a(iA3, android.support.v4.view.ah.l(childAt));
                i3 = iMax5;
            } else {
                iA = iA3;
                i3 = i5;
            }
            i4++;
            iA3 = iA;
            i5 = i3;
        }
        int iMax6 = 0;
        int measuredHeight = 0;
        int i6 = this.r + this.s;
        int i7 = this.p + this.q;
        if (a(this.f1661c)) {
            a(this.f1661c, i, iMax4 + i7, i2, i6, iArr);
            iMax6 = b(this.f1661c) + this.f1661c.getMeasuredWidth();
            measuredHeight = this.f1661c.getMeasuredHeight() + c(this.f1661c);
            iA3 = at.a(iA3, android.support.v4.view.ah.l(this.f1661c));
        }
        if (a(this.f1662d)) {
            iMax6 = Math.max(iMax6, a(this.f1662d, i, iMax4 + i7, i2, i6 + measuredHeight, iArr));
            measuredHeight += this.f1662d.getMeasuredHeight() + c(this.f1662d);
            iA3 = at.a(iA3, android.support.v4.view.ah.l(this.f1662d));
        }
        int iMax7 = Math.max(i5, measuredHeight);
        int paddingLeft = iMax6 + iMax4 + getPaddingLeft() + getPaddingRight();
        int paddingTop = iMax7 + getPaddingTop() + getPaddingBottom();
        int iA4 = android.support.v4.view.ah.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & iA3);
        int iA5 = android.support.v4.view.ah.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iA3 << 16);
        if (r()) {
            iA5 = 0;
        }
        setMeasuredDimension(iA4, iA5);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        android.support.v7.view.menu.f fVarD = this.f1660b != null ? this.f1660b.d() : null;
        if (savedState.f1668a != 0 && this.I != null && fVarD != null && (menuItemFindItem = fVarD.findItem(savedState.f1668a)) != null) {
            android.support.v4.view.q.b(menuItemFindItem);
        }
        if (savedState.f1669b) {
            q();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        this.t.a(i == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.I != null && this.I.f1671b != null) {
            savedState.f1668a = this.I.f1671b.getItemId();
        }
        savedState.f1669b = b();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iA = android.support.v4.view.t.a(motionEvent);
        if (iA == 0) {
            this.z = false;
        }
        if (!this.z) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (iA == 0 && !zOnTouchEvent) {
                this.z = true;
            }
        }
        if (iA == 1 || iA == 3) {
            this.z = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.L = z;
        requestLayout();
    }

    public void setLogo(int i) {
        setLogo(this.N.a(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!d(this.f1664f)) {
                a((View) this.f1664f, true);
            }
        } else if (this.f1664f != null && d(this.f1664f)) {
            removeView(this.f1664f);
            this.C.remove(this.f1664f);
        }
        if (this.f1664f != null) {
            this.f1664f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        if (this.f1664f != null) {
            this.f1664f.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            o();
        }
        if (this.f1663e != null) {
            this.f1663e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.N.a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            o();
            if (!d(this.f1663e)) {
                a((View) this.f1663e, true);
            }
        } else if (this.f1663e != null && d(this.f1663e)) {
            removeView(this.f1663e);
            this.C.remove(this.f1663e);
        }
        if (this.f1663e != null) {
            this.f1663e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        o();
        this.f1663e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.E = cVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        m();
        this.f1660b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1662d == null) {
                Context context = getContext();
                this.f1662d = new TextView(context);
                this.f1662d.setSingleLine();
                this.f1662d.setEllipsize(TextUtils.TruncateAt.END);
                if (this.m != 0) {
                    this.f1662d.setTextAppearance(context, this.m);
                }
                if (this.y != 0) {
                    this.f1662d.setTextColor(this.y);
                }
            }
            if (!d(this.f1662d)) {
                a((View) this.f1662d, true);
            }
        } else if (this.f1662d != null && d(this.f1662d)) {
            removeView(this.f1662d);
            this.C.remove(this.f1662d);
        }
        if (this.f1662d != null) {
            this.f1662d.setText(charSequence);
        }
        this.w = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.y = i;
        if (this.f1662d != null) {
            this.f1662d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1661c == null) {
                Context context = getContext();
                this.f1661c = new TextView(context);
                this.f1661c.setSingleLine();
                this.f1661c.setEllipsize(TextUtils.TruncateAt.END);
                if (this.l != 0) {
                    this.f1661c.setTextAppearance(context, this.l);
                }
                if (this.x != 0) {
                    this.f1661c.setTextColor(this.x);
                }
            }
            if (!d(this.f1661c)) {
                a((View) this.f1661c, true);
            }
        } else if (this.f1661c != null && d(this.f1661c)) {
            removeView(this.f1661c);
            this.C.remove(this.f1661c);
        }
        if (this.f1661c != null) {
            this.f1661c.setText(charSequence);
        }
        this.v = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.x = i;
        if (this.f1661c != null) {
            this.f1661c.setTextColor(i);
        }
    }
}
