package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ba;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1482a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f1483c;
    private final c A;
    private Runnable B;
    private final Handler C;
    private Rect D;
    private boolean E;
    private int F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1484b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f1485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PopupWindow f1486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListAdapter f1487f;
    private a g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;
    private View q;
    private int r;
    private DataSetObserver s;
    private View t;
    private Drawable u;
    private AdapterView.OnItemClickListener v;
    private AdapterView.OnItemSelectedListener w;
    private final g x;
    private final f y;
    private final e z;

    /* JADX INFO: renamed from: android.support.v7.widget.ListPopupWindow$1, reason: invalid class name */
    class AnonymousClass1 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ListPopupWindow f1488a;

        @Override // android.support.v7.widget.ListPopupWindow.b
        public ListPopupWindow a() {
            return this.f1488a;
        }
    }

    private static class a extends ListViewCompat {
        private boolean g;
        private boolean h;
        private boolean i;
        private ba j;
        private android.support.v4.widget.m k;

        public a(Context context, boolean z) {
            super(context, null, android.support.v7.b.a.C0029a.dropDownListViewStyle);
            this.h = z;
            setCacheColorHint(0);
        }

        private void a(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        private void a(View view, int i, float f2, float f3) {
            View childAt;
            this.i = true;
            if (Build.VERSION.SDK_INT >= 21) {
                drawableHotspotChanged(f2, f3);
            }
            if (!isPressed()) {
                setPressed(true);
            }
            layoutChildren();
            if (this.f1509f != -1 && (childAt = getChildAt(this.f1509f - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
                childAt.setPressed(false);
            }
            this.f1509f = i;
            float left = f2 - view.getLeft();
            float top = f3 - view.getTop();
            if (Build.VERSION.SDK_INT >= 21) {
                view.drawableHotspotChanged(left, top);
            }
            if (!view.isPressed()) {
                view.setPressed(true);
            }
            a(i, view, f2, f3);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        private void d() {
            this.i = false;
            setPressed(false);
            drawableStateChanged();
            View childAt = getChildAt(this.f1509f - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            if (this.j != null) {
                this.j.b();
                this.j = null;
            }
        }

        @Override // android.support.v7.widget.ListViewCompat
        protected boolean a() {
            return this.i || super.a();
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0034  */
        /* JADX WARN: Code duplicated, block: B:19:0x0037  */
        /* JADX WARN: Code duplicated, block: B:21:0x0048  */
        /* JADX WARN: Code duplicated, block: B:22:0x004b  */
        /* JADX WARN: Code duplicated, block: B:24:0x005c  */
        public boolean a(MotionEvent motionEvent, int i) {
            boolean z;
            int iFindPointerIndex;
            int x;
            int y;
            int iPointToPosition;
            View childAt;
            boolean z2;
            boolean z3;
            int iA = android.support.v4.view.t.a(motionEvent);
            switch (iA) {
                case 1:
                    z = false;
                    iFindPointerIndex = motionEvent.findPointerIndex(i);
                    if (iFindPointerIndex < 0) {
                        x = (int) motionEvent.getX(iFindPointerIndex);
                        y = (int) motionEvent.getY(iFindPointerIndex);
                        iPointToPosition = pointToPosition(x, y);
                        if (iPointToPosition == -1) {
                            childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                            a(childAt, iPointToPosition, x, y);
                            if (iA == 1) {
                                a(childAt, iPointToPosition);
                            }
                            z3 = false;
                            z2 = true;
                        } else {
                            z2 = z;
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                        z2 = false;
                    }
                    break;
                case 2:
                    z = true;
                    iFindPointerIndex = motionEvent.findPointerIndex(i);
                    if (iFindPointerIndex < 0) {
                        x = (int) motionEvent.getX(iFindPointerIndex);
                        y = (int) motionEvent.getY(iFindPointerIndex);
                        iPointToPosition = pointToPosition(x, y);
                        if (iPointToPosition == -1) {
                            childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                            a(childAt, iPointToPosition, x, y);
                            if (iA == 1) {
                                a(childAt, iPointToPosition);
                            }
                            z3 = false;
                            z2 = true;
                        } else {
                            z2 = z;
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                        z2 = false;
                    }
                    break;
                case 3:
                    z3 = false;
                    z2 = false;
                    break;
                default:
                    z3 = false;
                    z2 = true;
                    break;
            }
            if (!z2 || z3) {
                d();
            }
            if (z2) {
                if (this.k == null) {
                    this.k = new android.support.v4.widget.m(this);
                }
                this.k.a(true);
                this.k.onTouch(this, motionEvent);
            } else if (this.k != null) {
                this.k.a(false);
            }
            return z2;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean hasFocus() {
            return this.h || super.hasFocus();
        }

        @Override // android.view.View
        public boolean hasWindowFocus() {
            return this.h || super.hasWindowFocus();
        }

        @Override // android.view.View
        public boolean isFocused() {
            return this.h || super.isFocused();
        }

        @Override // android.view.View
        public boolean isInTouchMode() {
            return (this.h && this.g) || super.isInTouchMode();
        }
    }

    public static abstract class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f1491a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final View f1494d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Runnable f1495e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Runnable f1496f;
        private boolean g;
        private boolean h;
        private int i;
        private final int[] j = new int[2];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1492b = ViewConfiguration.getTapTimeout();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1493c = (this.f1492b + ViewConfiguration.getLongPressTimeout()) / 2;

        private class a implements Runnable {
            private a() {
            }

            /* synthetic */ a(b bVar, AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1494d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* JADX INFO: renamed from: android.support.v7.widget.ListPopupWindow$b$b, reason: collision with other inner class name */
        private class RunnableC0032b implements Runnable {
            private RunnableC0032b() {
            }

            /* synthetic */ RunnableC0032b(b bVar, AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.e();
            }
        }

        public b(View view) {
            this.f1494d = view;
            this.f1491a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        }

        private boolean a(MotionEvent motionEvent) {
            AnonymousClass1 anonymousClass1 = null;
            View view = this.f1494d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (android.support.v4.view.t.a(motionEvent)) {
                case 0:
                    this.i = motionEvent.getPointerId(0);
                    this.h = false;
                    if (this.f1495e == null) {
                        this.f1495e = new a(this, anonymousClass1);
                    }
                    view.postDelayed(this.f1495e, this.f1492b);
                    if (this.f1496f == null) {
                        this.f1496f = new RunnableC0032b(this, anonymousClass1);
                    }
                    view.postDelayed(this.f1496f, this.f1493c);
                    return false;
                case 1:
                case 3:
                    d();
                    return false;
                case 2:
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.i);
                    if (iFindPointerIndex < 0 || a(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f1491a)) {
                        return false;
                    }
                    d();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        private static boolean a(View view, float f2, float f3, float f4) {
            return f2 >= (-f4) && f3 >= (-f4) && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
        }

        private boolean a(View view, MotionEvent motionEvent) {
            int[] iArr = this.j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation(-iArr[0], -iArr[1]);
            return true;
        }

        private boolean b(MotionEvent motionEvent) {
            a aVar;
            View view = this.f1494d;
            ListPopupWindow listPopupWindowA = a();
            if (listPopupWindowA == null || !listPopupWindowA.k() || (aVar = listPopupWindowA.g) == null || !aVar.isShown()) {
                return false;
            }
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            b(view, motionEventObtainNoHistory);
            a(aVar, motionEventObtainNoHistory);
            boolean zA = aVar.a(motionEventObtainNoHistory, this.i);
            motionEventObtainNoHistory.recycle();
            int iA = android.support.v4.view.t.a(motionEvent);
            return zA && (iA != 1 && iA != 3);
        }

        private boolean b(View view, MotionEvent motionEvent) {
            int[] iArr = this.j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation(iArr[0], iArr[1]);
            return true;
        }

        private void d() {
            if (this.f1496f != null) {
                this.f1494d.removeCallbacks(this.f1496f);
            }
            if (this.f1495e != null) {
                this.f1494d.removeCallbacks(this.f1495e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            d();
            View view = this.f1494d;
            if (view.isEnabled() && !view.isLongClickable() && b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                view.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                this.g = true;
                this.h = true;
            }
        }

        public abstract ListPopupWindow a();

        protected boolean b() {
            ListPopupWindow listPopupWindowA = a();
            if (listPopupWindowA == null || listPopupWindowA.k()) {
                return true;
            }
            listPopupWindowA.c();
            return true;
        }

        protected boolean c() {
            ListPopupWindow listPopupWindowA = a();
            if (listPopupWindowA == null || !listPopupWindowA.k()) {
                return true;
            }
            listPopupWindowA.i();
            return true;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean zB;
            boolean z = this.g;
            if (!z) {
                boolean z2 = a(motionEvent) && b();
                if (z2) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                    this.f1494d.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                zB = z2;
            } else if (this.h) {
                zB = b(motionEvent);
            } else {
                zB = b(motionEvent) || !c();
            }
            this.g = zB;
            return zB || z;
        }
    }

    private class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(ListPopupWindow listPopupWindow, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.j();
        }
    }

    private class d extends DataSetObserver {
        private d() {
        }

        /* synthetic */ d(ListPopupWindow listPopupWindow, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.k()) {
                ListPopupWindow.this.c();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.i();
        }
    }

    private class e implements AbsListView.OnScrollListener {
        private e() {
        }

        /* synthetic */ e(ListPopupWindow listPopupWindow, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.l() || ListPopupWindow.this.f1486e.getContentView() == null) {
                return;
            }
            ListPopupWindow.this.C.removeCallbacks(ListPopupWindow.this.x);
            ListPopupWindow.this.x.run();
        }
    }

    private class f implements View.OnTouchListener {
        private f() {
        }

        /* synthetic */ f(ListPopupWindow listPopupWindow, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.f1486e != null && ListPopupWindow.this.f1486e.isShowing() && x >= 0 && x < ListPopupWindow.this.f1486e.getWidth() && y >= 0 && y < ListPopupWindow.this.f1486e.getHeight()) {
                ListPopupWindow.this.C.postDelayed(ListPopupWindow.this.x, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow.this.C.removeCallbacks(ListPopupWindow.this.x);
            return false;
        }
    }

    private class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(ListPopupWindow listPopupWindow, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ListPopupWindow.this.g == null || !android.support.v4.view.ah.F(ListPopupWindow.this.g) || ListPopupWindow.this.g.getCount() <= ListPopupWindow.this.g.getChildCount() || ListPopupWindow.this.g.getChildCount() > ListPopupWindow.this.f1484b) {
                return;
            }
            ListPopupWindow.this.f1486e.setInputMethodMode(2);
            ListPopupWindow.this.c();
        }
    }

    static {
        try {
            f1482a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f1483c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, android.support.v7.b.a.C0029a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        AnonymousClass1 anonymousClass1 = null;
        this.h = -2;
        this.i = -2;
        this.l = 1002;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.f1484b = Integer.MAX_VALUE;
        this.r = 0;
        this.x = new g(this, anonymousClass1);
        this.y = new f(this, anonymousClass1);
        this.z = new e(this, anonymousClass1);
        this.A = new c(this, anonymousClass1);
        this.D = new Rect();
        this.f1485d = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.b.a.k.ListPopupWindow, i, i2);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(android.support.v7.b.a.k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelOffset(android.support.v7.b.a.k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.k != 0) {
            this.m = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f1486e = new AppCompatPopupWindow(context, attributeSet, i);
        this.f1486e.setInputMethodMode(1);
        this.F = android.support.v4.g.f.a(this.f1485d.getResources().getConfiguration().locale);
    }

    private int a(View view, int i, boolean z) {
        if (f1483c != null) {
            try {
                return ((Integer) f1483c.invoke(this.f1486e, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1486e.getMaxAvailableHeight(view, i);
    }

    private void a() {
        if (this.q != null) {
            ViewParent parent = this.q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.q);
            }
        }
    }

    private int b() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        View view;
        int measuredHeight2;
        int i2;
        int i3;
        if (this.g == null) {
            Context context = this.f1485d;
            this.B = new Runnable() { // from class: android.support.v7.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View viewE = ListPopupWindow.this.e();
                    if (viewE == null || viewE.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.c();
                }
            };
            this.g = new a(context, !this.E);
            if (this.u != null) {
                this.g.setSelector(this.u);
            }
            this.g.setAdapter(this.f1487f);
            this.g.setOnItemClickListener(this.v);
            this.g.setFocusable(true);
            this.g.setFocusableInTouchMode(true);
            this.g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i4, long j) {
                    a aVar;
                    if (i4 == -1 || (aVar = ListPopupWindow.this.g) == null) {
                        return;
                    }
                    aVar.g = false;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.g.setOnScrollListener(this.z);
            if (this.w != null) {
                this.g.setOnItemSelectedListener(this.w);
            }
            a aVar = this.g;
            View view2 = this.q;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.r) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(aVar, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(aVar, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.r);
                        break;
                }
                if (this.i >= 0) {
                    i3 = this.i;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i3, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight2 = layoutParams2.bottomMargin + view2.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                view = aVar;
                measuredHeight2 = 0;
            }
            this.f1486e.setContentView(view);
            measuredHeight = measuredHeight2;
        } else {
            View view3 = this.q;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = layoutParams3.bottomMargin + view3.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f1486e.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            int i4 = this.D.top + this.D.bottom;
            if (this.m) {
                i = i4;
            } else {
                this.k = -this.D.top;
                i = i4;
            }
        } else {
            this.D.setEmpty();
            i = 0;
        }
        int iA = a(e(), this.k, this.f1486e.getInputMethodMode() == 2);
        if (this.o || this.h == -1) {
            return iA + i;
        }
        switch (this.i) {
            case -2:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1485d.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right), Integer.MIN_VALUE);
                break;
            case -1:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1485d.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right), 1073741824);
                break;
            default:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
                break;
        }
        int iA2 = this.g.a(iMakeMeasureSpec, 0, -1, iA - measuredHeight, -1);
        if (iA2 > 0) {
            measuredHeight += i;
        }
        return iA2 + measuredHeight;
    }

    private void b(boolean z) {
        if (f1482a != null) {
            try {
                f1482a.invoke(this.f1486e, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void a(int i) {
        this.r = i;
    }

    public void a(Drawable drawable) {
        this.f1486e.setBackgroundDrawable(drawable);
    }

    public void a(View view) {
        this.t = view;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.v = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        if (this.s == null) {
            this.s = new d(this, null);
        } else if (this.f1487f != null) {
            this.f1487f.unregisterDataSetObserver(this.s);
        }
        this.f1487f = listAdapter;
        if (this.f1487f != null) {
            listAdapter.registerDataSetObserver(this.s);
        }
        if (this.g != null) {
            this.g.setAdapter(this.f1487f);
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1486e.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z) {
        this.E = z;
        this.f1486e.setFocusable(z);
    }

    public void b(int i) {
        this.j = i;
    }

    public void c() {
        int width;
        int width2;
        int i;
        boolean z = false;
        int iB = b();
        boolean zL = l();
        android.support.v4.widget.q.a(this.f1486e, this.l);
        if (!this.f1486e.isShowing()) {
            if (this.i == -1) {
                width = -1;
            } else {
                width = this.i == -2 ? e().getWidth() : this.i;
            }
            if (this.h == -1) {
                iB = -1;
            } else if (this.h != -2) {
                iB = this.h;
            }
            this.f1486e.setWidth(width);
            this.f1486e.setHeight(iB);
            b(true);
            this.f1486e.setOutsideTouchable((this.p || this.o) ? false : true);
            this.f1486e.setTouchInterceptor(this.y);
            android.support.v4.widget.q.a(this.f1486e, e(), this.j, this.k, this.n);
            this.g.setSelection(-1);
            if (!this.E || this.g.isInTouchMode()) {
                j();
            }
            if (this.E) {
                return;
            }
            this.C.post(this.A);
            return;
        }
        if (this.i == -1) {
            width2 = -1;
        } else {
            width2 = this.i == -2 ? e().getWidth() : this.i;
        }
        if (this.h == -1) {
            if (!zL) {
                iB = -1;
            }
            if (zL) {
                this.f1486e.setWidth(this.i == -1 ? -1 : 0);
                this.f1486e.setHeight(0);
                i = iB;
            } else {
                this.f1486e.setWidth(this.i == -1 ? -1 : 0);
                this.f1486e.setHeight(-1);
                i = iB;
            }
        } else {
            i = this.h == -2 ? iB : this.h;
        }
        PopupWindow popupWindow = this.f1486e;
        if (!this.p && !this.o) {
            z = true;
        }
        popupWindow.setOutsideTouchable(z);
        PopupWindow popupWindow2 = this.f1486e;
        View viewE = e();
        int i2 = this.j;
        int i3 = this.k;
        if (width2 < 0) {
            width2 = -1;
        }
        popupWindow2.update(viewE, i2, i3, width2, i >= 0 ? i : -1);
    }

    public void c(int i) {
        this.k = i;
        this.m = true;
    }

    public Drawable d() {
        return this.f1486e.getBackground();
    }

    public void d(int i) {
        this.n = i;
    }

    public View e() {
        return this.t;
    }

    public void e(int i) {
        this.i = i;
    }

    public int f() {
        return this.j;
    }

    public void f(int i) {
        Drawable background = this.f1486e.getBackground();
        if (background == null) {
            e(i);
        } else {
            background.getPadding(this.D);
            this.i = this.D.left + this.D.right + i;
        }
    }

    public int g() {
        if (this.m) {
            return this.k;
        }
        return 0;
    }

    public void g(int i) {
        this.f1486e.setInputMethodMode(i);
    }

    public int h() {
        return this.i;
    }

    public void h(int i) {
        a aVar = this.g;
        if (!k() || aVar == null) {
            return;
        }
        aVar.g = false;
        aVar.setSelection(i);
        if (Build.VERSION.SDK_INT < 11 || aVar.getChoiceMode() == 0) {
            return;
        }
        aVar.setItemChecked(i, true);
    }

    public void i() {
        this.f1486e.dismiss();
        a();
        this.f1486e.setContentView(null);
        this.g = null;
        this.C.removeCallbacks(this.x);
    }

    public void j() {
        a aVar = this.g;
        if (aVar != null) {
            aVar.g = true;
            aVar.requestLayout();
        }
    }

    public boolean k() {
        return this.f1486e.isShowing();
    }

    public boolean l() {
        return this.f1486e.getInputMethodMode() == 2;
    }

    public ListView m() {
        return this.g;
    }
}
