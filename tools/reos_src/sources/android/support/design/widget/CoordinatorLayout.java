package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.ah;
import android.support.v4.view.bh;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements android.support.v4.view.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Class<?>[] f276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<b>>> f277c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Comparator<View> f278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final android.support.design.widget.e f279f;
    private final android.support.v4.view.aa A;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Comparator<View> f280d;
    private final List<View> g;
    private final List<View> h;
    private final List<View> i;
    private final Rect j;
    private final Rect k;
    private final Rect l;
    private final int[] m;
    private Paint n;
    private boolean o;
    private boolean p;
    private int[] q;
    private View r;
    private View s;
    private View t;
    private f u;
    private boolean v;
    private bh w;
    private boolean x;
    private Drawable y;
    private ViewGroup.OnHierarchyChangeListener z;

    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.f.d.a(new android.support.v4.f.e<SavedState>() { // from class: android.support.design.widget.CoordinatorLayout.SavedState.1
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
        SparseArray<Parcelable> f282a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f282a = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f282a.append(iArr[i2], parcelableArray[i2]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.f282a != null ? this.f282a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f282a.keyAt(i2);
                parcelableArr[i2] = this.f282a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    private class a implements android.support.v4.view.ab {
        private a() {
        }

        @Override // android.support.v4.view.ab
        public bh a(View view, bh bhVar) {
            return CoordinatorLayout.this.a(bhVar);
        }
    }

    public static abstract class b<V extends View> {
        public b() {
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public bh a(CoordinatorLayout coordinatorLayout, V v, bh bhVar) {
            return bhVar;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public void b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean c(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v) {
            return d(coordinatorLayout, v) > BitmapDescriptorFactory.HUE_RED;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class<? extends b> a();
    }

    private class d implements ViewGroup.OnHierarchyChangeListener {
        private d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.z != null) {
                CoordinatorLayout.this.z.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.b(view2);
            if (CoordinatorLayout.this.z != null) {
                CoordinatorLayout.this.z.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b f285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f289e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f290f;
        View g;
        View h;
        final Rect i;
        Object j;
        private boolean k;
        private boolean l;
        private boolean m;

        public e(int i, int i2) {
            super(i, i2);
            this.f286b = false;
            this.f287c = 0;
            this.f288d = 0;
            this.f289e = -1;
            this.f290f = -1;
            this.i = new Rect();
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f286b = false;
            this.f287c = 0;
            this.f288d = 0;
            this.f289e = -1;
            this.f290f = -1;
            this.i = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.CoordinatorLayout_LayoutParams);
            this.f287c = typedArrayObtainStyledAttributes.getInteger(android.support.design.a.i.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
            this.f290f = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.CoordinatorLayout_LayoutParams_layout_anchor, -1);
            this.f288d = typedArrayObtainStyledAttributes.getInteger(android.support.design.a.i.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
            this.f289e = typedArrayObtainStyledAttributes.getInteger(android.support.design.a.i.CoordinatorLayout_LayoutParams_layout_keyline, -1);
            this.f286b = typedArrayObtainStyledAttributes.hasValue(android.support.design.a.i.CoordinatorLayout_LayoutParams_layout_behavior);
            if (this.f286b) {
                this.f285a = CoordinatorLayout.a(context, attributeSet, typedArrayObtainStyledAttributes.getString(android.support.design.a.i.CoordinatorLayout_LayoutParams_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f286b = false;
            this.f287c = 0;
            this.f288d = 0;
            this.f289e = -1;
            this.f290f = -1;
            this.i = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f286b = false;
            this.f287c = 0;
            this.f288d = 0;
            this.f289e = -1;
            this.f290f = -1;
            this.i = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f286b = false;
            this.f287c = 0;
            this.f288d = 0;
            this.f289e = -1;
            this.f290f = -1;
            this.i = new Rect();
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.g = coordinatorLayout.findViewById(this.f290f);
            if (this.g == null) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f290f) + " to anchor view " + view);
                }
                this.h = null;
                this.g = null;
                return;
            }
            if (this.g == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.h = null;
                this.g = null;
                return;
            }
            View view2 = this.g;
            for (ViewParent parent = this.g.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.h = null;
                    this.g = null;
                    return;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.h = view2;
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.g.getId() != this.f290f) {
                return false;
            }
            View view2 = this.g;
            for (ViewParent parent = this.g.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.h = null;
                    this.g = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.h = view2;
            return true;
        }

        public int a() {
            return this.f290f;
        }

        void a(Rect rect) {
            this.i.set(rect);
        }

        public void a(b bVar) {
            if (this.f285a != bVar) {
                this.f285a = bVar;
                this.j = null;
                this.f286b = true;
            }
        }

        void a(boolean z) {
            this.l = z;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.k) {
                return true;
            }
            boolean zE = (this.f285a != null ? this.f285a.e(coordinatorLayout, view) : false) | this.k;
            this.k = zE;
            return zE;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.h || (this.f285a != null && this.f285a.b(coordinatorLayout, view, view2));
        }

        public b b() {
            return this.f285a;
        }

        View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f290f == -1) {
                this.h = null;
                this.g = null;
                return null;
            }
            if (this.g == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.g;
        }

        void b(boolean z) {
            this.m = z;
        }

        Rect c() {
            return this.i;
        }

        boolean d() {
            return this.g == null && this.f290f != -1;
        }

        boolean e() {
            if (this.f285a == null) {
                this.k = false;
            }
            return this.k;
        }

        void f() {
            this.k = false;
        }

        void g() {
            this.l = false;
        }

        boolean h() {
            return this.l;
        }

        boolean i() {
            return this.m;
        }

        void j() {
            this.m = false;
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.a(false);
            return true;
        }
    }

    static class g implements Comparator<View> {
        g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fE = ah.E(view);
            float fE2 = ah.E(view2);
            if (fE > fE2) {
                return -1;
            }
            return fE < fE2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f275a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f278e = new g();
            f279f = new android.support.design.widget.f();
        } else {
            f278e = null;
            f279f = null;
        }
        f276b = new Class[]{Context.class, AttributeSet.class};
        f277c = new ThreadLocal<>();
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f280d = new Comparator<View>() { // from class: android.support.design.widget.CoordinatorLayout.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(View view, View view2) {
                if (view == view2) {
                    return 0;
                }
                if (((e) view.getLayoutParams()).a(CoordinatorLayout.this, view, view2)) {
                    return 1;
                }
                return ((e) view2.getLayoutParams()).a(CoordinatorLayout.this, view2, view) ? -1 : 0;
            }
        };
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        this.m = new int[2];
        this.A = new android.support.v4.view.aa(this);
        t.a(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.CoordinatorLayout, i, android.support.design.a.h.Widget_Design_CoordinatorLayout);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(android.support.design.a.i.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.q = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.q.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.q;
                iArr[i2] = (int) (iArr[i2] * f2);
            }
        }
        this.y = typedArrayObtainStyledAttributes.getDrawable(android.support.design.a.i.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        if (f279f != null) {
            f279f.a(this, new a());
        }
        super.setOnHierarchyChangeListener(new d());
    }

    private int a(int i) {
        if (this.q == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < this.q.length) {
            return this.q[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static b a(Context context, AttributeSet attributeSet, String str) {
        Map<String, Constructor<b>> map;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f275a)) {
            str = f275a + '.' + str;
        }
        try {
            Map<String, Constructor<b>> map2 = f277c.get();
            if (map2 == null) {
                HashMap map3 = new HashMap();
                f277c.set(map3);
                map = map3;
            } else {
                map = map2;
            }
            Constructor<b> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f276b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bh a(bh bhVar) {
        if (this.w == bhVar) {
            return bhVar;
        }
        this.w = bhVar;
        this.x = bhVar != null && bhVar.b() > 0;
        setWillNotDraw(!this.x && getBackground() == null);
        bh bhVarB = b(bhVar);
        requestLayout();
        return bhVarB;
    }

    private void a(View view, View view2, int i) {
        Rect rect = this.j;
        Rect rect2 = this.k;
        a(view2, rect);
        a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void a(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        if (f278e != null) {
            Collections.sort(list, f278e);
        }
    }

    private static void a(List<View> list, Comparator<View> comparator) {
        if (list == null || list.size() < 2) {
            return;
        }
        View[] viewArr = new View[list.size()];
        list.toArray(viewArr);
        int length = viewArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i;
            for (int i3 = i + 1; i3 < length; i3++) {
                if (comparator.compare(viewArr[i3], viewArr[i2]) < 0) {
                    i2 = i3;
                }
            }
            if (i != i2) {
                View view = viewArr[i2];
                viewArr[i2] = viewArr[i];
                viewArr[i] = view;
            }
        }
        list.clear();
        for (View view2 : viewArr) {
            list.add(view2);
        }
    }

    private boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        MotionEvent motionEventObtain;
        boolean z2;
        boolean zB = false;
        boolean z3 = false;
        MotionEvent motionEvent2 = null;
        int iA = android.support.v4.view.t.a(motionEvent);
        List<View> list = this.h;
        a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            View view = list.get(i2);
            e eVar = (e) view.getLayoutParams();
            b bVarB = eVar.b();
            if ((!zB && !z3) || iA == 0) {
                if (!zB && bVarB != null) {
                    switch (i) {
                        case 0:
                            zB = bVarB.a(this, view, motionEvent);
                            break;
                        case 1:
                            zB = bVarB.b(this, view, motionEvent);
                            break;
                    }
                    if (zB) {
                        this.r = view;
                    }
                }
                z = zB;
                boolean zE = eVar.e();
                boolean zA = eVar.a(this, view);
                boolean z4 = zA && !zE;
                if (zA && !z4) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent3 = motionEvent2;
                z2 = z4;
                motionEventObtain = motionEvent3;
            } else if (bVarB != null) {
                if (motionEvent2 == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                } else {
                    motionEventObtain = motionEvent2;
                }
                switch (i) {
                    case 0:
                        bVarB.a(this, view, motionEventObtain);
                        break;
                    case 1:
                        bVarB.b(this, view, motionEventObtain);
                        break;
                }
                z2 = z3;
                z = zB;
            } else {
                motionEventObtain = motionEvent2;
                z = zB;
                z2 = z3;
            }
            i2++;
            z3 = z2;
            zB = z;
            motionEvent2 = motionEventObtain;
        }
        z = zB;
        list.clear();
        return z;
    }

    private static int b(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    private bh b(bh bhVar) {
        bh bhVarA;
        b bVarB;
        if (bhVar.e()) {
            return bhVar;
        }
        int childCount = getChildCount();
        int i = 0;
        bh bhVar2 = bhVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!ah.w(childAt) || (bVarB = ((e) childAt.getLayoutParams()).b()) == null) {
                bhVarA = bhVar2;
            } else {
                bhVarA = bVarB.a(this, childAt, bhVar2);
                if (bhVarA.e()) {
                    return bhVarA;
                }
            }
            i++;
            bhVar2 = bhVarA;
        }
        bhVarA = bhVar2;
        return bhVarA;
    }

    private void b(View view, int i, int i2) {
        e eVar = (e) view.getLayoutParams();
        int iA = android.support.v4.view.e.a(c(eVar.f287c), i2);
        int i3 = iA & 7;
        int i4 = iA & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int iA2 = a(i) - measuredWidth;
        int i5 = 0;
        switch (i3) {
            case 1:
                iA2 += measuredWidth / 2;
                break;
            case 5:
                iA2 += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i5 = 0 + (measuredHeight / 2);
                break;
            case 80:
                i5 = 0 + measuredHeight;
                break;
        }
        int iMax = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(iA2, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        view.layout(iMax, iMax2, iMax + measuredWidth, iMax2 + measuredHeight);
    }

    private static int c(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    private void c(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        Rect rect = this.j;
        rect.set(getPaddingLeft() + eVar.leftMargin, getPaddingTop() + eVar.topMargin, (getWidth() - getPaddingRight()) - eVar.rightMargin, (getHeight() - getPaddingBottom()) - eVar.bottomMargin);
        if (this.w != null && ah.w(this) && !ah.w(view)) {
            rect.left += this.w.a();
            rect.top += this.w.b();
            rect.right -= this.w.c();
            rect.bottom -= this.w.d();
        }
        Rect rect2 = this.k;
        android.support.v4.view.e.a(b(eVar.f287c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int d(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private void e() {
        if (this.r != null) {
            b bVarB = ((e) this.r.getLayoutParams()).b();
            if (bVarB != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                bVarB.b(this, this.r, motionEventObtain);
                motionEventObtain.recycle();
            }
            this.r = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((e) getChildAt(i).getLayoutParams()).f();
        }
        this.o = false;
    }

    private void f() {
        this.g.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            a(childAt).b(this, childAt);
            this.g.add(childAt);
        }
        a(this.g, this.f280d);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    e a(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f286b) {
            c cVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                cVar = (c) superclass.getAnnotation(c.class);
                if (cVar != null) {
                    break;
                }
            }
            c cVar2 = cVar;
            if (cVar2 != null) {
                try {
                    eVar.a(cVar2.a().newInstance());
                } catch (Exception e2) {
                    Log.e("CoordinatorLayout", "Default behavior class " + cVar2.a().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                }
            }
            eVar.f286b = true;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    void a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z != this.v) {
            if (z) {
                b();
            } else {
                c();
            }
        }
    }

    public void a(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (eVar.g != null) {
            a(view, eVar.g, i);
        } else if (eVar.f289e >= 0) {
            b(view, eVar.f289e, i);
        } else {
            c(view, i);
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        int iWidth;
        int iHeight;
        e eVar = (e) view.getLayoutParams();
        int iA = android.support.v4.view.e.a(d(eVar.f287c), i);
        int iA2 = android.support.v4.view.e.a(b(eVar.f288d), i);
        int i2 = iA & 7;
        int i3 = iA & 112;
        int i4 = iA2 & 7;
        int i5 = iA2 & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (i4) {
            case 1:
                iWidth = (rect.width() / 2) + rect.left;
                break;
            case 5:
                iWidth = rect.right;
                break;
            default:
                iWidth = rect.left;
                break;
        }
        switch (i5) {
            case 16:
                iHeight = rect.top + (rect.height() / 2);
                break;
            case 80:
                iHeight = rect.bottom;
                break;
            default:
                iHeight = rect.top;
                break;
        }
        switch (i2) {
            case 1:
                iWidth -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                iWidth -= measuredWidth;
                break;
        }
        switch (i3) {
            case 16:
                iHeight -= measuredHeight / 2;
                break;
            case 80:
                break;
            default:
                iHeight -= measuredHeight;
                break;
        }
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(iWidth, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(iHeight, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        rect2.set(iMax, iMax2, iMax + measuredWidth, iMax2 + measuredHeight);
    }

    void a(View view, Rect rect) {
        x.b(this, view, rect);
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    void a(boolean z) {
        int iH = ah.h(this);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            View view = this.g.get(i);
            e eVar = (e) view.getLayoutParams();
            for (int i2 = 0; i2 < i; i2++) {
                if (eVar.h == this.g.get(i2)) {
                    b(view, iH);
                }
            }
            Rect rect = this.j;
            Rect rect2 = this.k;
            c(view, rect);
            a(view, true, rect2);
            if (!rect.equals(rect2)) {
                b(view, rect2);
                for (int i3 = i + 1; i3 < size; i3++) {
                    View view2 = this.g.get(i3);
                    e eVar2 = (e) view2.getLayoutParams();
                    b bVarB = eVar2.b();
                    if (bVarB != null && bVarB.b(this, view2, view)) {
                        if (z || !eVar2.i()) {
                            boolean zC = bVarB.c(this, view2, view);
                            if (z) {
                                eVar2.b(zC);
                            }
                        } else {
                            eVar2.j();
                        }
                    }
                }
            }
        }
    }

    public boolean a(View view, int i, int i2) {
        Rect rect = this.j;
        a(view, rect);
        return rect.contains(i, i2);
    }

    public boolean a(View view, View view2) {
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rect = this.j;
        a(view, view.getParent() != this, rect);
        Rect rect2 = this.k;
        a(view2, view2.getParent() != this, rect2);
        return rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
    }

    void b() {
        if (this.p) {
            if (this.u == null) {
                this.u = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.u);
        }
        this.v = true;
    }

    void b(View view) {
        boolean z;
        e eVar;
        b bVarB;
        int size = this.g.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            View view2 = this.g.get(i);
            if (view2 == view) {
                z = true;
            } else {
                if (z2 && (bVarB = (eVar = (e) view2.getLayoutParams()).b()) != null && eVar.a(this, view2, view)) {
                    bVarB.d(this, view2, view);
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
    }

    void b(View view, int i) {
        b bVarB;
        e eVar = (e) view.getLayoutParams();
        if (eVar.g != null) {
            Rect rect = this.j;
            Rect rect2 = this.k;
            Rect rect3 = this.l;
            a(eVar.g, rect);
            a(view, false, rect2);
            a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if ((i2 == 0 && i3 == 0) || (bVarB = eVar.b()) == null) {
                return;
            }
            bVarB.c(this, view, eVar.g);
        }
    }

    void b(View view, Rect rect) {
        ((e) view.getLayoutParams()).a(rect);
    }

    void c() {
        if (this.p && this.u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.u);
        }
        this.v = false;
    }

    public void c(View view) {
        boolean z;
        e eVar;
        b bVarB;
        int size = this.g.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            View view2 = this.g.get(i);
            if (view2 == view) {
                z = true;
            } else {
                if (z2 && (bVarB = (eVar = (e) view2.getLayoutParams()).b()) != null && eVar.a(this, view2, view)) {
                    bVarB.c(this, view2, view);
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
    }

    void c(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).c());
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    public List<View> d(View view) {
        e eVar = (e) view.getLayoutParams();
        List<View> list = this.i;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && eVar.a(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.f285a != null && eVar.f285a.d(this, view) > BitmapDescriptorFactory.HUE_RED) {
            if (this.n == null) {
                this.n = new Paint();
            }
            this.n.setColor(eVar.f285a.c(this, view));
            canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.n);
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean state = false;
        Drawable drawable = this.y;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    boolean e(View view) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && eVar.a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.A.a();
    }

    public Drawable getStatusBarBackground() {
        return this.y;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
        if (this.v) {
            if (this.u == null) {
                this.u = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.u);
        }
        if (this.w == null && ah.w(this)) {
            ah.v(this);
        }
        this.p = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        if (this.v && this.u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.u);
        }
        if (this.t != null) {
            onStopNestedScroll(this.t);
        }
        this.p = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.x || this.y == null) {
            return;
        }
        int iB = this.w != null ? this.w.b() : 0;
        if (iB > 0) {
            this.y.setBounds(0, 0, getWidth(), iB);
            this.y.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int iA = android.support.v4.view.t.a(motionEvent);
        if (iA == 0) {
            e();
        }
        boolean zA = a(motionEvent, 0);
        if (0 != 0) {
            motionEvent2.recycle();
        }
        if (iA == 1 || iA == 3) {
            e();
        }
        return zA;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iH = ah.h(this);
        int size = this.g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.g.get(i5);
            b bVarB = ((e) view.getLayoutParams()).b();
            if (bVarB == null || !bVarB.a(this, view, iH)) {
                a(view, iH);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        f();
        a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iH = ah.h(this);
        boolean z = iH == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.w != null && ah.w(this);
        int size3 = this.g.size();
        int i5 = 0;
        int iA = 0;
        int i6 = suggestedMinimumHeight;
        int i7 = suggestedMinimumWidth;
        while (i5 < size3) {
            View view = this.g.get(i5);
            e eVar = (e) view.getLayoutParams();
            int iMax = 0;
            if (eVar.f289e >= 0 && mode != 0) {
                int iA2 = a(eVar.f289e);
                int iA3 = android.support.v4.view.e.a(c(eVar.f287c), iH) & 7;
                if ((iA3 == 3 && !z) || (iA3 == 5 && z)) {
                    iMax = Math.max(0, (size - paddingRight) - iA2);
                } else if ((iA3 == 5 && !z) || (iA3 == 3 && z)) {
                    iMax = Math.max(0, iA2 - paddingLeft);
                }
            }
            if (!z2 || ah.w(view)) {
                iMakeMeasureSpec = i2;
                iMakeMeasureSpec2 = i;
            } else {
                int iA4 = this.w.a() + this.w.c();
                int iB = this.w.b() + this.w.d();
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size - iA4, mode);
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2 - iB, mode2);
            }
            b bVarB = eVar.b();
            if (bVarB == null || !bVarB.a(this, view, iMakeMeasureSpec2, iMax, iMakeMeasureSpec, 0)) {
                a(view, iMakeMeasureSpec2, iMax, iMakeMeasureSpec, 0);
            }
            int iMax2 = Math.max(i7, view.getMeasuredWidth() + i3 + eVar.leftMargin + eVar.rightMargin);
            int iMax3 = Math.max(i6, view.getMeasuredHeight() + i4 + eVar.topMargin + eVar.bottomMargin);
            i5++;
            iA = ah.a(iA, ah.l(view));
            i6 = iMax3;
            i7 = iMax2;
        }
        setMeasuredDimension(ah.a(i7, i, (-16777216) & iA), ah.a(i6, i2, iA << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        boolean zA;
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.h()) {
                b bVarB = eVar.b();
                zA = bVarB != null ? bVarB.a(this, childAt, view, f2, f3, z) | z2 : z2;
            } else {
                zA = z2;
            }
            i++;
            z2 = zA;
        }
        if (z2) {
            a(true);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onNestedPreFling(View view, float f2, float f3) {
        boolean zA;
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.h()) {
                b bVarB = eVar.b();
                zA = bVarB != null ? bVarB.a(this, childAt, view, f2, f3) | z : z;
            } else {
                zA = z;
            }
            i++;
            z = zA;
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        boolean z;
        int iMax;
        int iMax2;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.h()) {
                b bVarB = eVar.b();
                if (bVarB != null) {
                    int[] iArr2 = this.m;
                    this.m[1] = 0;
                    iArr2[0] = 0;
                    bVarB.a(this, childAt, view, i, i2, this.m);
                    iMax = i > 0 ? Math.max(i3, this.m[0]) : Math.min(i3, this.m[0]);
                    iMax2 = i2 > 0 ? Math.max(i4, this.m[1]) : Math.min(i4, this.m[1]);
                    z = true;
                } else {
                    z = z2;
                    iMax = i3;
                    iMax2 = i4;
                }
            } else {
                z = z2;
                iMax = i3;
                iMax2 = i4;
            }
            i5++;
            i4 = iMax2;
            i3 = iMax;
            z2 = z;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (z2) {
            a(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.h()) {
                b bVarB = eVar.b();
                if (bVarB != null) {
                    bVarB.a(this, childAt, view, i, i2, i3, i4);
                    z = true;
                } else {
                    z = z2;
                }
            } else {
                z = z2;
            }
            i5++;
            z2 = z;
        }
        if (z2) {
            a(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onNestedScrollAccepted(View view, View view2, int i) {
        b bVarB;
        this.A.a(view, view2, i);
        this.s = view;
        this.t = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.h() && (bVarB = eVar.b()) != null) {
                bVarB.b(this, childAt, view, view2, i);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f282a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b bVarB = a(childAt).b();
            if (id != -1 && bVarB != null && (parcelable2 = sparseArray.get(id)) != null) {
                bVarB.a(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableB;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b bVarB = ((e) childAt.getLayoutParams()).b();
            if (id != -1 && bVarB != null && (parcelableB = bVarB.b(this, childAt)) != null) {
                sparseArray.append(id, parcelableB);
            }
        }
        savedState.f282a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public boolean onStartNestedScroll(View view, View view2, int i) {
        boolean z;
        int childCount = getChildCount();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            b bVarB = eVar.b();
            if (bVarB != null) {
                boolean zA = bVarB.a(this, childAt, view, view2, i);
                z = z2 | zA;
                eVar.a(zA);
            } else {
                eVar.a(false);
                z = z2;
            }
            i2++;
            z2 = z;
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.z
    public void onStopNestedScroll(View view) {
        this.A.a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.h()) {
                b bVarB = eVar.b();
                if (bVarB != null) {
                    bVarB.a(this, childAt, view);
                }
                eVar.g();
                eVar.j();
            }
        }
        this.s = null;
        this.t = null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    /* JADX WARN: Code duplicated, block: B:19:0x003f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043  */
    /* JADX WARN: Code duplicated, block: B:22:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean zOnTouchEvent;
        MotionEvent motionEventObtain;
        MotionEvent motionEvent2 = null;
        int iA = android.support.v4.view.t.a(motionEvent);
        if (this.r == null) {
            boolean zA = a(motionEvent, 1);
            if (zA) {
                z = zA;
            } else {
                z = zA;
                zOnTouchEvent = false;
            }
            if (this.r == null) {
                zOnTouchEvent |= super.onTouchEvent(motionEvent);
            } else if (z) {
                if (0 == 0) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                } else {
                    motionEventObtain = null;
                }
                super.onTouchEvent(motionEventObtain);
                motionEvent2 = motionEventObtain;
            }
            if (!zOnTouchEvent || iA == 0) {
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (iA != 1 || iA == 3) {
                e();
            }
            return zOnTouchEvent;
        }
        z = false;
        b bVarB = ((e) this.r.getLayoutParams()).b();
        zOnTouchEvent = bVarB != null ? bVarB.b(this, this.r, motionEvent) : false;
        if (this.r == null) {
            zOnTouchEvent |= super.onTouchEvent(motionEvent);
        } else if (z) {
            if (0 == 0) {
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
            } else {
                motionEventObtain = null;
            }
            super.onTouchEvent(motionEventObtain);
            motionEvent2 = motionEventObtain;
        }
        if (!zOnTouchEvent) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (iA != 1) {
            e();
        } else {
            e();
        }
        return zOnTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.o) {
            return;
        }
        e();
        this.o = true;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.z = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.y != drawable) {
            if (this.y != null) {
                this.y.setCallback(null);
            }
            this.y = drawable != null ? drawable.mutate() : null;
            if (this.y != null) {
                if (this.y.isStateful()) {
                    this.y.setState(getDrawableState());
                }
                android.support.v4.c.a.a.b(this.y, ah.h(this));
                this.y.setVisible(getVisibility() == 0, false);
                this.y.setCallback(this);
            }
            ah.d(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? android.support.v4.b.b.a(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.y == null || this.y.isVisible() == z) {
            return;
        }
        this.y.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.y;
    }
}
