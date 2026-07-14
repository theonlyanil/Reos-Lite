package android.support.v4.widget;

import android.R;
import android.content.Context;
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
import android.support.v4.view.aw;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c f942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f943b = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f945d;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private CharSequence E;
    private CharSequence F;
    private Object G;
    private boolean H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private final ArrayList<View> M;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f947f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final af k;
    private final af l;
    private final h m;
    private final h n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;

    @Deprecated
    private f x;
    private List<f> y;
    private float z;

    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v4.widget.DrawerLayout.SavedState.1
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
        int f948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f951d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f952e;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f948a = 0;
            this.f948a = parcel.readInt();
            this.f949b = parcel.readInt();
            this.f950c = parcel.readInt();
            this.f951d = parcel.readInt();
            this.f952e = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f948a = 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f948a);
            parcel.writeInt(this.f949b);
            parcel.writeInt(this.f950c);
            parcel.writeInt(this.f951d);
            parcel.writeInt(this.f952e);
        }
    }

    class a extends android.support.v4.view.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Rect f954c = new Rect();

        a() {
        }

        private void a(android.support.v4.view.a.c cVar, android.support.v4.view.a.c cVar2) {
            Rect rect = this.f954c;
            cVar2.a(rect);
            cVar.b(rect);
            cVar2.c(rect);
            cVar.d(rect);
            cVar.c(cVar2.h());
            cVar.a(cVar2.p());
            cVar.b(cVar2.q());
            cVar.d(cVar2.s());
            cVar.h(cVar2.m());
            cVar.f(cVar2.k());
            cVar.a(cVar2.f());
            cVar.b(cVar2.g());
            cVar.d(cVar2.i());
            cVar.e(cVar2.j());
            cVar.g(cVar2.l());
            cVar.a(cVar2.b());
        }

        private void a(android.support.v4.view.a.c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.n(childAt)) {
                    cVar.b(childAt);
                }
            }
        }

        @Override // android.support.v4.view.a
        public void a(View view, android.support.v4.view.a.c cVar) {
            if (DrawerLayout.f944c) {
                super.a(view, cVar);
            } else {
                android.support.v4.view.a.c cVarA = android.support.v4.view.a.c.a(cVar);
                super.a(view, cVarA);
                cVar.a(view);
                Object objI = ah.i(view);
                if (objI instanceof View) {
                    cVar.c((View) objI);
                }
                a(cVar, cVarA);
                cVarA.t();
                a(cVar, (ViewGroup) view);
            }
            cVar.b((CharSequence) DrawerLayout.class.getName());
            cVar.a(false);
            cVar.b(false);
            cVar.a(android.support.v4.view.a.c.a.f864a);
            cVar.a(android.support.v4.view.a.c.a.f865b);
        }

        @Override // android.support.v4.view.a
        public void a(View view, AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // android.support.v4.view.a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f944c || DrawerLayout.n(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        @Override // android.support.v4.view.a
        public boolean d(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.d(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewK = DrawerLayout.this.k();
            if (viewK != null) {
                CharSequence charSequenceB = DrawerLayout.this.b(DrawerLayout.this.e(viewK));
                if (charSequenceB != null) {
                    text.add(charSequenceB);
                }
            }
            return true;
        }
    }

    final class b extends android.support.v4.view.a {
        b() {
        }

        @Override // android.support.v4.view.a
        public void a(View view, android.support.v4.view.a.c cVar) {
            super.a(view, cVar);
            if (DrawerLayout.n(view)) {
                return;
            }
            cVar.c((View) null);
        }
    }

    interface c {
        int a(Object obj);

        Drawable a(Context context);

        void a(View view);

        void a(View view, Object obj, int i);

        void a(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    static class d implements c {
        d() {
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public int a(Object obj) {
            return android.support.v4.widget.h.a(obj);
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public Drawable a(Context context) {
            return android.support.v4.widget.h.a(context);
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public void a(View view) {
            android.support.v4.widget.h.a(view);
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public void a(View view, Object obj, int i) {
            android.support.v4.widget.h.a(view, obj, i);
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
            android.support.v4.widget.h.a(marginLayoutParams, obj, i);
        }
    }

    static class e implements c {
        e() {
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public int a(Object obj) {
            return 0;
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public Drawable a(Context context) {
            return null;
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public void a(View view) {
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public void a(View view, Object obj, int i) {
        }

        @Override // android.support.v4.widget.DrawerLayout.c
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }
    }

    public interface f {
        void a(int i);

        void a(View view);

        void a(View view, float f2);

        void b(View view);
    }

    public static class g extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f959d;

        public g(int i, int i2) {
            super(i, i2);
            this.f956a = 0;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f956a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f943b);
            this.f956a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public g(g gVar) {
            super((ViewGroup.MarginLayoutParams) gVar);
            this.f956a = 0;
            this.f956a = gVar.f956a;
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f956a = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f956a = 0;
        }

        static /* synthetic */ int b(g gVar, int i) {
            int i2 = gVar.f959d | i;
            gVar.f959d = i2;
            return i2;
        }
    }

    private class h extends af.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private af f962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Runnable f963d = new Runnable() { // from class: android.support.v4.widget.DrawerLayout.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        };

        public h(int i) {
            this.f961b = i;
        }

        private void b() {
            View viewC = DrawerLayout.this.c(this.f961b == 3 ? 5 : 3);
            if (viewC != null) {
                DrawerLayout.this.i(viewC);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            View view;
            int i;
            int iB = this.f962c.b();
            boolean z = this.f961b == 3;
            if (z) {
                View viewC = DrawerLayout.this.c(3);
                int i2 = (viewC != null ? -viewC.getWidth() : 0) + iB;
                view = viewC;
                i = i2;
            } else {
                View viewC2 = DrawerLayout.this.c(5);
                int width = DrawerLayout.this.getWidth() - iB;
                view = viewC2;
                i = width;
            }
            if (view != null) {
                if (((!z || view.getLeft() >= i) && (z || view.getLeft() <= i)) || DrawerLayout.this.a(view) != 0) {
                    return;
                }
                g gVar = (g) view.getLayoutParams();
                this.f962c.a(view, i, view.getTop());
                gVar.f958c = true;
                DrawerLayout.this.invalidate();
                b();
                DrawerLayout.this.c();
            }
        }

        @Override // android.support.v4.widget.af.a
        public int a(View view, int i, int i2) {
            return view.getTop();
        }

        public void a() {
            DrawerLayout.this.removeCallbacks(this.f963d);
        }

        @Override // android.support.v4.widget.af.a
        public void a(int i) {
            DrawerLayout.this.a(this.f961b, i, this.f962c.c());
        }

        @Override // android.support.v4.widget.af.a
        public void a(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f963d, 160L);
        }

        public void a(af afVar) {
            this.f962c = afVar;
        }

        @Override // android.support.v4.widget.af.a
        public void a(View view, float f2, float f3) {
            int width;
            float fD = DrawerLayout.this.d(view);
            int width2 = view.getWidth();
            if (DrawerLayout.this.a(view, 3)) {
                width = (f2 > BitmapDescriptorFactory.HUE_RED || (f2 == BitmapDescriptorFactory.HUE_RED && fD > 0.5f)) ? 0 : -width2;
            } else {
                width = DrawerLayout.this.getWidth();
                if (f2 < BitmapDescriptorFactory.HUE_RED || (f2 == BitmapDescriptorFactory.HUE_RED && fD > 0.5f)) {
                    width -= width2;
                }
            }
            this.f962c.a(width, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.af.a
        public void a(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = DrawerLayout.this.a(view, 3) ? (width + i) / width : (DrawerLayout.this.getWidth() - i) / width;
            DrawerLayout.this.b(view, width2);
            view.setVisibility(width2 == BitmapDescriptorFactory.HUE_RED ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.af.a
        public boolean a(View view, int i) {
            return DrawerLayout.this.g(view) && DrawerLayout.this.a(view, this.f961b) && DrawerLayout.this.a(view) == 0;
        }

        @Override // android.support.v4.widget.af.a
        public int b(View view) {
            if (DrawerLayout.this.g(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // android.support.v4.widget.af.a
        public int b(View view, int i, int i2) {
            if (DrawerLayout.this.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // android.support.v4.widget.af.a
        public void b(int i, int i2) {
            View viewC = (i & 1) == 1 ? DrawerLayout.this.c(3) : DrawerLayout.this.c(5);
            if (viewC == null || DrawerLayout.this.a(viewC) != 0) {
                return;
            }
            this.f962c.a(viewC, i2);
        }

        @Override // android.support.v4.widget.af.a
        public void b(View view, int i) {
            ((g) view.getLayoutParams()).f958c = false;
            b();
        }

        @Override // android.support.v4.widget.af.a
        public boolean b(int i) {
            return false;
        }
    }

    static {
        f944c = Build.VERSION.SDK_INT >= 19;
        f945d = Build.VERSION.SDK_INT >= 21;
        if (Build.VERSION.SDK_INT >= 21) {
            f942a = new d();
        } else {
            f942a = new e();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f946e = new b();
        this.h = -1728053248;
        this.j = new Paint();
        this.q = true;
        this.r = 3;
        this.s = 3;
        this.t = 3;
        this.u = 3;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.g = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        this.m = new h(3);
        this.n = new h(5);
        this.k = af.a(this, 1.0f, this.m);
        this.k.a(1);
        this.k.a(f3);
        this.m.a(this.k);
        this.l = af.a(this, 1.0f, this.n);
        this.l.a(2);
        this.l.a(f3);
        this.n.a(this.l);
        setFocusableInTouchMode(true);
        ah.c((View) this, 1);
        ah.a(this, new a());
        aw.a(this, false);
        if (ah.w(this)) {
            f942a.a((View) this);
            this.B = f942a.a(context);
        }
        this.f947f = f2 * 10.0f;
        this.M = new ArrayList<>();
    }

    private void a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || g(childAt)) && !(z && childAt == view)) {
                ah.c(childAt, 4);
            } else {
                ah.c(childAt, 1);
            }
        }
    }

    private boolean a(Drawable drawable, int i) {
        if (drawable == null || !android.support.v4.c.a.a.b(drawable)) {
            return false;
        }
        android.support.v4.c.a.a.b(drawable, i);
        return true;
    }

    static String d(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private void f() {
        if (f945d) {
            return;
        }
        this.C = g();
        this.D = h();
    }

    private Drawable g() {
        int iH = ah.h(this);
        if (iH == 0) {
            if (this.I != null) {
                a(this.I, iH);
                return this.I;
            }
        } else if (this.J != null) {
            a(this.J, iH);
            return this.J;
        }
        return this.K;
    }

    private Drawable h() {
        int iH = ah.h(this);
        if (iH == 0) {
            if (this.J != null) {
                a(this.J, iH);
                return this.J;
            }
        } else if (this.I != null) {
            a(this.I, iH);
            return this.I;
        }
        return this.L;
    }

    private boolean i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((g) getChildAt(i).getLayoutParams()).f958c) {
                return true;
            }
        }
        return false;
    }

    private boolean j() {
        return k() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View k() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (g(childAt) && k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    private static boolean m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(View view) {
        return (ah.e(view) == 4 || ah.e(view) == 2) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0008 A[ORIG_RETURN, RETURN] */
    public int a(int i) {
        int iH = ah.h(this);
        switch (i) {
            case 3:
                if (this.r != 3) {
                    return this.r;
                }
                int i2 = iH == 0 ? this.t : this.u;
                if (i2 != 3) {
                    return i2;
                }
                return 0;
            case 5:
                if (this.s != 3) {
                    return this.s;
                }
                int i3 = iH == 0 ? this.u : this.t;
                if (i3 != 3) {
                    return i3;
                }
                return 0;
            case 8388611:
                if (this.t != 3) {
                    return this.t;
                }
                int i4 = iH == 0 ? this.r : this.s;
                if (i4 != 3) {
                    return i4;
                }
                return 0;
            case 8388613:
                if (this.u != 3) {
                    return this.u;
                }
                int i5 = iH == 0 ? this.s : this.r;
                if (i5 != 3) {
                    return i5;
                }
                return 0;
            default:
                return 0;
        }
    }

    public int a(View view) {
        if (g(view)) {
            return a(((g) view.getLayoutParams()).f956a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    View a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((g) childAt.getLayoutParams()).f959d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public void a(int i, int i2) {
        int iA = android.support.v4.view.e.a(i2, ah.h(this));
        switch (i2) {
            case 3:
                this.r = i;
                break;
            case 5:
                this.s = i;
                break;
            case 8388611:
                this.t = i;
                break;
            case 8388613:
                this.u = i;
                break;
        }
        if (i != 0) {
            (iA == 3 ? this.k : this.l).e();
        }
        switch (i) {
            case 1:
                View viewC = c(iA);
                if (viewC != null) {
                    i(viewC);
                }
                break;
            case 2:
                View viewC2 = c(iA);
                if (viewC2 != null) {
                    h(viewC2);
                }
                break;
        }
    }

    void a(int i, int i2, View view) {
        int iA = this.k.a();
        int iA2 = this.l.a();
        int i3 = (iA == 1 || iA2 == 1) ? 1 : (iA == 2 || iA2 == 2) ? 2 : 0;
        if (view != null && i2 == 0) {
            g gVar = (g) view.getLayoutParams();
            if (gVar.f957b == BitmapDescriptorFactory.HUE_RED) {
                b(view);
            } else if (gVar.f957b == 1.0f) {
                c(view);
            }
        }
        if (i3 != this.o) {
            this.o = i3;
            if (this.y != null) {
                for (int size = this.y.size() - 1; size >= 0; size--) {
                    this.y.get(size).a(i3);
                }
            }
        }
    }

    public void a(f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.y == null) {
            this.y = new ArrayList();
        }
        this.y.add(fVar);
    }

    void a(View view, float f2) {
        if (this.y != null) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                this.y.get(size).a(view, f2);
            }
        }
    }

    @Override // android.support.v4.widget.i
    public void a(Object obj, boolean z) {
        this.G = obj;
        this.H = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    void a(boolean z) {
        int childCount = getChildCount();
        boolean zA = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            g gVar = (g) childAt.getLayoutParams();
            if (g(childAt) && (!z || gVar.f958c)) {
                zA = a(childAt, 3) ? zA | this.k.a(childAt, -childAt.getWidth(), childAt.getTop()) : zA | this.l.a(childAt, getWidth(), childAt.getTop());
                gVar.f958c = false;
            }
        }
        this.m.a();
        this.n.a();
        if (zA) {
            invalidate();
        }
    }

    boolean a(View view, int i) {
        return (e(view) & i) == i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!g(childAt)) {
                this.M.add(childAt);
            } else if (j(childAt)) {
                z = true;
                childAt.addFocusables(arrayList, i, i2);
            }
        }
        if (!z) {
            int size = this.M.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.M.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.M.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (a() != null || g(view)) {
            ah.c(view, 4);
        } else {
            ah.c(view, 1);
        }
        if (f944c) {
            return;
        }
        ah.a(view, this.f946e);
    }

    public CharSequence b(int i) {
        int iA = android.support.v4.view.e.a(i, ah.h(this));
        if (iA == 3) {
            return this.E;
        }
        if (iA == 5) {
            return this.F;
        }
        return null;
    }

    public void b() {
        a(false);
    }

    public void b(f fVar) {
        if (fVar == null || this.y == null) {
            return;
        }
        this.y.remove(fVar);
    }

    void b(View view) {
        View rootView;
        g gVar = (g) view.getLayoutParams();
        if ((gVar.f959d & 1) == 1) {
            gVar.f959d = 0;
            if (this.y != null) {
                for (int size = this.y.size() - 1; size >= 0; size--) {
                    this.y.get(size).b(view);
                }
            }
            a(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void b(View view, float f2) {
        g gVar = (g) view.getLayoutParams();
        if (f2 == gVar.f957b) {
            return;
        }
        gVar.f957b = f2;
        a(view, f2);
    }

    View c(int i) {
        int iA = android.support.v4.view.e.a(i, ah.h(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((e(childAt) & 7) == iA) {
                return childAt;
            }
        }
        return null;
    }

    void c() {
        if (this.w) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.w = true;
    }

    void c(View view) {
        g gVar = (g) view.getLayoutParams();
        if ((gVar.f959d & 1) == 0) {
            gVar.f959d = 1;
            if (this.y != null) {
                for (int size = this.y.size() - 1; size >= 0; size--) {
                    this.y.get(size).a(view);
                }
            }
            a(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((g) getChildAt(i).getLayoutParams()).f957b);
        }
        this.i = fMax;
        if (this.k.a(true) || this.l.a(true)) {
            ah.d(this);
        }
    }

    float d(View view) {
        return ((g) view.getLayoutParams()).f957b;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int left;
        int height = getHeight();
        boolean zF = f(view);
        int i = 0;
        int width = getWidth();
        int iSave = canvas.save();
        if (zF) {
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt == view || childAt.getVisibility() != 0 || !m(childAt) || !g(childAt)) {
                    left = width;
                } else if (childAt.getHeight() < height) {
                    left = width;
                } else if (a(childAt, 3)) {
                    int right = childAt.getRight();
                    if (right <= i) {
                        right = i;
                    }
                    i = right;
                    left = width;
                } else {
                    left = childAt.getLeft();
                    if (left >= width) {
                        left = width;
                    }
                }
                i2++;
                width = left;
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        int i3 = width;
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        if (this.i > BitmapDescriptorFactory.HUE_RED && zF) {
            this.j.setColor((((int) (((this.h & (-16777216)) >>> 24) * this.i)) << 24) | (this.h & 16777215));
            canvas.drawRect(i, BitmapDescriptorFactory.HUE_RED, i3, getHeight(), this.j);
        } else if (this.C != null && a(view, 3)) {
            int intrinsicWidth = this.C.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(right2 / this.k.b(), 1.0f));
            this.C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.C.setAlpha((int) (255.0f * fMax));
            this.C.draw(canvas);
        } else if (this.D != null && a(view, 5)) {
            int intrinsicWidth2 = this.D.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min((getWidth() - left2) / this.l.b(), 1.0f));
            this.D.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.D.setAlpha((int) (255.0f * fMax2));
            this.D.draw(canvas);
        }
        return zDrawChild;
    }

    int e(View view) {
        return android.support.v4.view.e.a(((g) view.getLayoutParams()).f956a, ah.h(this));
    }

    public void e(int i) {
        View viewC = c(i);
        if (viewC == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + d(i));
        }
        h(viewC);
    }

    public void f(int i) {
        View viewC = c(i);
        if (viewC == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + d(i));
        }
        i(viewC);
    }

    boolean f(View view) {
        return ((g) view.getLayoutParams()).f956a == 0;
    }

    public boolean g(int i) {
        View viewC = c(i);
        if (viewC != null) {
            return j(viewC);
        }
        return false;
    }

    boolean g(View view) {
        int iA = android.support.v4.view.e.a(((g) view.getLayoutParams()).f956a, ah.h(view));
        return ((iA & 3) == 0 && (iA & 5) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof g) {
            return new g((g) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    public float getDrawerElevation() {
        return f945d ? this.f947f : BitmapDescriptorFactory.HUE_RED;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    public void h(View view) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        g gVar = (g) view.getLayoutParams();
        if (this.q) {
            gVar.f957b = 1.0f;
            gVar.f959d = 1;
            a(view, true);
        } else {
            g.b(gVar, 2);
            if (a(view, 3)) {
                this.k.a(view, 0, view.getTop());
            } else {
                this.l.a(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public boolean h(int i) {
        View viewC = c(i);
        if (viewC != null) {
            return k(viewC);
        }
        return false;
    }

    public void i(View view) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        g gVar = (g) view.getLayoutParams();
        if (this.q) {
            gVar.f957b = BitmapDescriptorFactory.HUE_RED;
            gVar.f959d = 0;
        } else {
            g.b(gVar, 4);
            if (a(view, 3)) {
                this.k.a(view, -view.getWidth(), view.getTop());
            } else {
                this.l.a(view, getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public boolean j(View view) {
        if (g(view)) {
            return (((g) view.getLayoutParams()).f959d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean k(View view) {
        if (g(view)) {
            return ((g) view.getLayoutParams()).f957b > BitmapDescriptorFactory.HUE_RED;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iA;
        super.onDraw(canvas);
        if (!this.H || this.B == null || (iA = f942a.a(this.G)) <= 0) {
            return;
        }
        this.B.setBounds(0, 0, getWidth(), iA);
        this.B.draw(canvas);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0016  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewD;
        int iA = android.support.v4.view.t.a(motionEvent);
        boolean zA = this.k.a(motionEvent) | this.l.a(motionEvent);
        switch (iA) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.z = x;
                this.A = y;
                z = this.i > BitmapDescriptorFactory.HUE_RED && (viewD = this.k.d((int) x, (int) y)) != null && f(viewD);
                this.v = false;
                this.w = false;
                break;
            case 1:
            case 3:
                a(true);
                this.v = false;
                this.w = false;
                z = false;
                break;
            case 2:
                if (!this.k.d(3)) {
                    z = false;
                } else {
                    this.m.a();
                    this.n.a();
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        return zA || z || i() || this.w;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !j()) {
            return super.onKeyDown(i, keyEvent);
        }
        android.support.v4.view.g.b(keyEvent);
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewK = k();
        if (viewK != null && a(viewK) == 0) {
            b();
        }
        return viewK != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f2;
        this.p = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(gVar.leftMargin, gVar.topMargin, gVar.leftMargin + childAt.getMeasuredWidth(), gVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        i5 = ((int) (measuredWidth * gVar.f957b)) + (-measuredWidth);
                        f2 = (measuredWidth + i5) / measuredWidth;
                    } else {
                        i5 = i6 - ((int) (measuredWidth * gVar.f957b));
                        f2 = (i6 - i5) / measuredWidth;
                    }
                    boolean z2 = f2 != gVar.f957b;
                    switch (gVar.f956a & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            int i9 = (i8 - measuredHeight) / 2;
                            if (i9 < gVar.topMargin) {
                                i9 = gVar.topMargin;
                            } else if (i9 + measuredHeight > i8 - gVar.bottomMargin) {
                                i9 = (i8 - gVar.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i5, i9, measuredWidth + i5, measuredHeight + i9);
                            break;
                        case 80:
                            int i10 = i4 - i2;
                            childAt.layout(i5, (i10 - gVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i10 - gVar.bottomMargin);
                            break;
                        default:
                            childAt.layout(i5, gVar.topMargin, measuredWidth + i5, measuredHeight + gVar.topMargin);
                            break;
                    }
                    if (z2) {
                        b(childAt, f2);
                    }
                    int i11 = gVar.f957b > BitmapDescriptorFactory.HUE_RED ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
        }
        this.p = false;
        this.q = false;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0169 A[PHI: r1
      0x0169: PHI (r1v23 int) = (r1v3 int), (r1v0 int) binds: [B:25:0x005a, B:5:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            i3 = size;
            i4 = size2;
        } else {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 == Integer.MIN_VALUE) {
                i3 = size;
                i4 = size2;
            } else if (mode2 == 0) {
                i3 = size;
                i4 = 300;
            } else {
                i3 = size;
                i4 = size2;
            }
        }
        setMeasuredDimension(i3, i4);
        boolean z = this.G != null && ah.w(this);
        int iH = ah.h(this);
        boolean z2 = false;
        boolean z3 = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (z) {
                    int iA = android.support.v4.view.e.a(gVar.f956a, iH);
                    if (ah.w(childAt)) {
                        f942a.a(childAt, this.G, iA);
                    } else {
                        f942a.a(gVar, this.G, iA);
                    }
                }
                if (f(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((i3 - gVar.leftMargin) - gVar.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((i4 - gVar.topMargin) - gVar.bottomMargin, 1073741824));
                } else {
                    if (!g(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (f945d && ah.t(childAt) != this.f947f) {
                        ah.d(childAt, this.f947f);
                    }
                    int iE = e(childAt) & 7;
                    boolean z4 = iE == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + d(iE) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(getChildMeasureSpec(i, this.g + gVar.leftMargin + gVar.rightMargin, gVar.width), getChildMeasureSpec(i2, gVar.topMargin + gVar.bottomMargin, gVar.height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewC;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f948a != 0 && (viewC = c(savedState.f948a)) != null) {
            h(viewC);
        }
        if (savedState.f949b != 3) {
            a(savedState.f949b, 3);
        }
        if (savedState.f950c != 3) {
            a(savedState.f950c, 5);
        }
        if (savedState.f951d != 3) {
            a(savedState.f951d, 8388611);
        }
        if (savedState.f952e != 3) {
            a(savedState.f952e, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        f();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            g gVar = (g) getChildAt(i).getLayoutParams();
            boolean z = gVar.f959d == 1;
            boolean z2 = gVar.f959d == 2;
            if (z || z2) {
                savedState.f948a = gVar.f956a;
                break;
            }
        }
        savedState.f949b = this.r;
        savedState.f950c = this.s;
        savedState.f951d = this.t;
        savedState.f952e = this.u;
        return savedState;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewA;
        this.k.b(motionEvent);
        this.l.b(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.z = x;
                this.A = y;
                this.v = false;
                this.w = false;
                return true;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View viewD = this.k.d((int) x2, (int) y2);
                if (viewD == null || !f(viewD)) {
                    z = true;
                } else {
                    float f2 = x2 - this.z;
                    float f3 = y2 - this.A;
                    int iD = this.k.d();
                    z = (f2 * f2) + (f3 * f3) >= ((float) (iD * iD)) || (viewA = a()) == null || a(viewA) == 2;
                }
                a(z);
                this.v = false;
                return true;
            case 2:
            default:
                return true;
            case 3:
                a(true);
                this.v = false;
                this.w = false;
                return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.v = z;
        if (z) {
            a(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.p) {
            return;
        }
        super.requestLayout();
    }

    public void setDrawerElevation(float f2) {
        this.f947f = f2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (g(childAt)) {
                ah.d(childAt, this.f947f);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(f fVar) {
        if (this.x != null) {
            b(this.x);
        }
        if (fVar != null) {
            a(fVar);
        }
        this.x = fVar;
    }

    public void setDrawerLockMode(int i) {
        a(i, 3);
        a(i, 5);
    }

    public void setScrimColor(int i) {
        this.h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.B = i != 0 ? android.support.v4.b.b.a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.B = new ColorDrawable(i);
        invalidate();
    }
}
