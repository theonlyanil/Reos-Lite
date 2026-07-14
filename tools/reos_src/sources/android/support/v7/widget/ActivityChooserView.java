package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.support.v4.view.d f1351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f1352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f1353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayoutCompat f1354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Drawable f1355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FrameLayout f1356f;
    private final ImageView g;
    private final FrameLayout h;
    private final ImageView i;
    private final int j;
    private final DataSetObserver k;
    private final ViewTreeObserver.OnGlobalLayoutListener l;
    private ListPopupWindow m;
    private PopupWindow.OnDismissListener n;
    private boolean o;
    private int p;
    private boolean q;
    private int r;

    public static class InnerLayout extends LinearLayoutCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int[] f1361a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ap apVarA = ap.a(context, attributeSet, f1361a);
            setBackgroundDrawable(apVarA.a(0));
            apVarA.a();
        }
    }

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f1363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1366e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1367f;

        private a() {
            this.f1364c = 4;
        }

        public int a() {
            int i = this.f1364c;
            this.f1364c = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int iMax = 0;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f1364c = i;
            return iMax;
        }

        public void a(int i) {
            if (this.f1364c != i) {
                this.f1364c = i;
                notifyDataSetChanged();
            }
        }

        public void a(d dVar) {
            d dVarE = ActivityChooserView.this.f1352b.e();
            if (dVarE != null && ActivityChooserView.this.isShown()) {
                dVarE.unregisterObserver(ActivityChooserView.this.k);
            }
            this.f1363b = dVar;
            if (dVar != null && ActivityChooserView.this.isShown()) {
                dVar.registerObserver(ActivityChooserView.this.k);
            }
            notifyDataSetChanged();
        }

        public void a(boolean z) {
            if (this.f1367f != z) {
                this.f1367f = z;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z, boolean z2) {
            if (this.f1365d == z && this.f1366e == z2) {
                return;
            }
            this.f1365d = z;
            this.f1366e = z2;
            notifyDataSetChanged();
        }

        public ResolveInfo b() {
            return this.f1363b.b();
        }

        public int c() {
            return this.f1363b.a();
        }

        public int d() {
            return this.f1363b.c();
        }

        public d e() {
            return this.f1363b;
        }

        public boolean f() {
            return this.f1365d;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iA = this.f1363b.a();
            if (!this.f1365d && this.f1363b.b() != null) {
                iA--;
            }
            int iMin = Math.min(iA, this.f1364c);
            return this.f1367f ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f1365d && this.f1363b.b() != null) {
                        i++;
                    }
                    return this.f1363b.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f1367f && i == getCount() + (-1)) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != android.support.v7.b.a.f.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(android.support.v7.b.a.h.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(android.support.v7.b.a.f.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(android.support.v7.b.a.f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1365d && i == 0 && this.f1366e) {
                        android.support.v4.view.ah.c(view, true);
                        return view;
                    }
                    android.support.v4.view.ah.c(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(android.support.v7.b.a.h.abc_activity_chooser_view_list_item, viewGroup, false);
                    viewInflate.setId(1);
                    ((TextView) viewInflate.findViewById(android.support.v7.b.a.f.title)).setText(ActivityChooserView.this.getContext().getString(android.support.v7.b.a.i.abc_activity_chooser_view_see_all));
                    return viewInflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    private class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        private b() {
        }

        private void a() {
            if (ActivityChooserView.this.n != null) {
                ActivityChooserView.this.n.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != ActivityChooserView.this.h) {
                if (view != ActivityChooserView.this.f1356f) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.o = false;
                ActivityChooserView.this.a(ActivityChooserView.this.p);
                return;
            }
            ActivityChooserView.this.b();
            Intent intentB = ActivityChooserView.this.f1352b.e().b(ActivityChooserView.this.f1352b.e().a(ActivityChooserView.this.f1352b.b()));
            if (intentB != null) {
                intentB.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentB);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            if (ActivityChooserView.this.f1351a != null) {
                ActivityChooserView.this.f1351a.a(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.b();
                    if (ActivityChooserView.this.o) {
                        if (i > 0) {
                            ActivityChooserView.this.f1352b.e().c(i);
                            return;
                        }
                        return;
                    }
                    if (!ActivityChooserView.this.f1352b.f()) {
                        i++;
                    }
                    Intent intentB = ActivityChooserView.this.f1352b.e().b(i);
                    if (intentB != null) {
                        intentB.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(intentB);
                        return;
                    }
                    return;
                case 1:
                    ActivityChooserView.this.a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view != ActivityChooserView.this.h) {
                throw new IllegalArgumentException();
            }
            if (ActivityChooserView.this.f1352b.getCount() > 0) {
                ActivityChooserView.this.o = true;
                ActivityChooserView.this.a(ActivityChooserView.this.p);
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f1352b.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f1352b.notifyDataSetInvalidated();
            }
        };
        this.l = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.c()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().i();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().c();
                    if (ActivityChooserView.this.f1351a != null) {
                        ActivityChooserView.this.f1351a.a(true);
                    }
                }
            }
        };
        this.p = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.ActivityChooserView, i, 0);
        this.p = typedArrayObtainStyledAttributes.getInt(android.support.v7.b.a.k.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(android.support.v7.b.a.k.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(android.support.v7.b.a.h.abc_activity_chooser_view, (ViewGroup) this, true);
        this.f1353c = new b();
        this.f1354d = (LinearLayoutCompat) findViewById(android.support.v7.b.a.f.activity_chooser_view_content);
        this.f1355e = this.f1354d.getBackground();
        this.h = (FrameLayout) findViewById(android.support.v7.b.a.f.default_activity_button);
        this.h.setOnClickListener(this.f1353c);
        this.h.setOnLongClickListener(this.f1353c);
        this.i = (ImageView) this.h.findViewById(android.support.v7.b.a.f.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(android.support.v7.b.a.f.expand_activities_button);
        frameLayout.setOnClickListener(this.f1353c);
        frameLayout.setOnTouchListener(new ListPopupWindow.b(frameLayout) { // from class: android.support.v7.widget.ActivityChooserView.3
            @Override // android.support.v7.widget.ListPopupWindow.b
            public ListPopupWindow a() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // android.support.v7.widget.ListPopupWindow.b
            protected boolean b() {
                ActivityChooserView.this.a();
                return true;
            }

            @Override // android.support.v7.widget.ListPopupWindow.b
            protected boolean c() {
                ActivityChooserView.this.b();
                return true;
            }
        });
        this.f1356f = frameLayout;
        this.g = (ImageView) frameLayout.findViewById(android.support.v7.b.a.f.image);
        this.g.setImageDrawable(drawable);
        this.f1352b = new a();
        this.f1352b.registerDataSetObserver(new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.4
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.d();
            }
        });
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(android.support.v7.b.a.d.abc_config_prefDialogWidth));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.f1352b.e() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.l);
        boolean z = this.h.getVisibility() == 0;
        int iC = this.f1352b.c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || iC <= i2 + i) {
            this.f1352b.a(false);
            this.f1352b.a(i);
        } else {
            this.f1352b.a(true);
            this.f1352b.a(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.k()) {
            return;
        }
        if (this.o || !z) {
            this.f1352b.a(true, z);
        } else {
            this.f1352b.a(false, false);
        }
        listPopupWindow.f(Math.min(this.f1352b.a(), this.j));
        listPopupWindow.c();
        if (this.f1351a != null) {
            this.f1351a.a(true);
        }
        listPopupWindow.m().setContentDescription(getContext().getString(android.support.v7.b.a.i.abc_activitychooserview_choose_application));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f1352b.getCount() > 0) {
            this.f1356f.setEnabled(true);
        } else {
            this.f1356f.setEnabled(false);
        }
        int iC = this.f1352b.c();
        int iD = this.f1352b.d();
        if (iC == 1 || (iC > 1 && iD > 0)) {
            this.h.setVisibility(0);
            ResolveInfo resolveInfoB = this.f1352b.b();
            PackageManager packageManager = getContext().getPackageManager();
            this.i.setImageDrawable(resolveInfoB.loadIcon(packageManager));
            if (this.r != 0) {
                this.h.setContentDescription(getContext().getString(this.r, resolveInfoB.loadLabel(packageManager)));
            }
        } else {
            this.h.setVisibility(8);
        }
        if (this.h.getVisibility() == 0) {
            this.f1354d.setBackgroundDrawable(this.f1355e);
        } else {
            this.f1354d.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ListPopupWindow getListPopupWindow() {
        if (this.m == null) {
            this.m = new ListPopupWindow(getContext());
            this.m.a(this.f1352b);
            this.m.a(this);
            this.m.a(true);
            this.m.a((AdapterView.OnItemClickListener) this.f1353c);
            this.m.a((PopupWindow.OnDismissListener) this.f1353c);
        }
        return this.m;
    }

    public boolean a() {
        if (c() || !this.q) {
            return false;
        }
        this.o = false;
        a(this.p);
        return true;
    }

    public boolean b() {
        if (!c()) {
            return true;
        }
        getListPopupWindow().i();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        return true;
    }

    public boolean c() {
        return getListPopupWindow().k();
    }

    public d getDataModel() {
        return this.f1352b.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVarE = this.f1352b.e();
        if (dVarE != null) {
            dVarE.registerObserver(this.k);
        }
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVarE = this.f1352b.e();
        if (dVarE != null) {
            dVarE.unregisterObserver(this.k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        }
        if (c()) {
            b();
        }
        this.q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1354d.layout(0, 0, i3 - i, i4 - i2);
        if (c()) {
            return;
        }
        b();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.f1354d;
        if (this.h.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    public void setActivityChooserModel(d dVar) {
        this.f1352b.a(dVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.g.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.g.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.p = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public void setProvider(android.support.v4.view.d dVar) {
        this.f1351a = dVar;
    }
}
