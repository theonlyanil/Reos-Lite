package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ah;
import android.support.v4.widget.af;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f258f;
    private af g;
    private boolean h;
    private int i;
    private boolean j;
    private int k;
    private WeakReference<V> l;
    private WeakReference<View> m;
    private a n;
    private VelocityTracker o;
    private int p;
    private int q;
    private boolean r;
    private final af.a s;

    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.design.widget.BottomSheetBehavior.SavedState.1
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
        final int f260a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f260a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f260a = i;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f260a);
        }
    }

    public static abstract class a {
        public abstract void a(View view, float f2);

        public abstract void a(View view, int i);
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f263c;

        b(View view, int i) {
            this.f262b = view;
            this.f263c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BottomSheetBehavior.this.g == null || !BottomSheetBehavior.this.g.a(true)) {
                BottomSheetBehavior.this.b(this.f263c);
            } else {
                ah.a(this.f262b, this);
            }
        }
    }

    public BottomSheetBehavior() {
        this.f258f = 4;
        this.s = new af.a() { // from class: android.support.design.widget.BottomSheetBehavior.1
            @Override // android.support.v4.widget.af.a
            public int a(View view) {
                return BottomSheetBehavior.this.f257e ? BottomSheetBehavior.this.k - BottomSheetBehavior.this.f255c : BottomSheetBehavior.this.f256d - BottomSheetBehavior.this.f255c;
            }

            @Override // android.support.v4.widget.af.a
            public int a(View view, int i, int i2) {
                return n.a(i, BottomSheetBehavior.this.f255c, BottomSheetBehavior.this.f257e ? BottomSheetBehavior.this.k : BottomSheetBehavior.this.f256d);
            }

            @Override // android.support.v4.widget.af.a
            public void a(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.b(1);
                }
            }

            @Override // android.support.v4.widget.af.a
            public void a(View view, float f2, float f3) {
                int i;
                int i2 = 3;
                if (f3 < BitmapDescriptorFactory.HUE_RED) {
                    i = BottomSheetBehavior.this.f255c;
                } else if (BottomSheetBehavior.this.f257e && BottomSheetBehavior.this.a(view, f3)) {
                    i = BottomSheetBehavior.this.k;
                    i2 = 5;
                } else if (f3 == BitmapDescriptorFactory.HUE_RED) {
                    int top = view.getTop();
                    if (Math.abs(top - BottomSheetBehavior.this.f255c) < Math.abs(top - BottomSheetBehavior.this.f256d)) {
                        i = BottomSheetBehavior.this.f255c;
                    } else {
                        i = BottomSheetBehavior.this.f256d;
                        i2 = 4;
                    }
                } else {
                    i = BottomSheetBehavior.this.f256d;
                    i2 = 4;
                }
                if (!BottomSheetBehavior.this.g.a(view.getLeft(), i)) {
                    BottomSheetBehavior.this.b(i2);
                } else {
                    BottomSheetBehavior.this.b(2);
                    ah.a(view, new b(view, i2));
                }
            }

            @Override // android.support.v4.widget.af.a
            public void a(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.c(i2);
            }

            @Override // android.support.v4.widget.af.a
            public boolean a(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.f258f == 1 || BottomSheetBehavior.this.r) {
                    return false;
                }
                if (BottomSheetBehavior.this.f258f == 3 && BottomSheetBehavior.this.p == i && (view2 = (View) BottomSheetBehavior.this.m.get()) != null && ah.b(view2, -1)) {
                    return false;
                }
                return BottomSheetBehavior.this.l != null && BottomSheetBehavior.this.l.get() == view;
            }

            @Override // android.support.v4.widget.af.a
            public int b(View view, int i, int i2) {
                return view.getLeft();
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f258f = 4;
        this.s = new af.a() { // from class: android.support.design.widget.BottomSheetBehavior.1
            @Override // android.support.v4.widget.af.a
            public int a(View view) {
                return BottomSheetBehavior.this.f257e ? BottomSheetBehavior.this.k - BottomSheetBehavior.this.f255c : BottomSheetBehavior.this.f256d - BottomSheetBehavior.this.f255c;
            }

            @Override // android.support.v4.widget.af.a
            public int a(View view, int i, int i2) {
                return n.a(i, BottomSheetBehavior.this.f255c, BottomSheetBehavior.this.f257e ? BottomSheetBehavior.this.k : BottomSheetBehavior.this.f256d);
            }

            @Override // android.support.v4.widget.af.a
            public void a(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.b(1);
                }
            }

            @Override // android.support.v4.widget.af.a
            public void a(View view, float f2, float f3) {
                int i;
                int i2 = 3;
                if (f3 < BitmapDescriptorFactory.HUE_RED) {
                    i = BottomSheetBehavior.this.f255c;
                } else if (BottomSheetBehavior.this.f257e && BottomSheetBehavior.this.a(view, f3)) {
                    i = BottomSheetBehavior.this.k;
                    i2 = 5;
                } else if (f3 == BitmapDescriptorFactory.HUE_RED) {
                    int top = view.getTop();
                    if (Math.abs(top - BottomSheetBehavior.this.f255c) < Math.abs(top - BottomSheetBehavior.this.f256d)) {
                        i = BottomSheetBehavior.this.f255c;
                    } else {
                        i = BottomSheetBehavior.this.f256d;
                        i2 = 4;
                    }
                } else {
                    i = BottomSheetBehavior.this.f256d;
                    i2 = 4;
                }
                if (!BottomSheetBehavior.this.g.a(view.getLeft(), i)) {
                    BottomSheetBehavior.this.b(i2);
                } else {
                    BottomSheetBehavior.this.b(2);
                    ah.a(view, new b(view, i2));
                }
            }

            @Override // android.support.v4.widget.af.a
            public void a(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.c(i2);
            }

            @Override // android.support.v4.widget.af.a
            public boolean a(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.f258f == 1 || BottomSheetBehavior.this.r) {
                    return false;
                }
                if (BottomSheetBehavior.this.f258f == 3 && BottomSheetBehavior.this.p == i && (view2 = (View) BottomSheetBehavior.this.m.get()) != null && ah.b(view2, -1)) {
                    return false;
                }
                return BottomSheetBehavior.this.l != null && BottomSheetBehavior.this.l.get() == view;
            }

            @Override // android.support.v4.widget.af.a
            public int b(View view, int i, int i2) {
                return view.getLeft();
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.BottomSheetBehavior_Params);
        a(typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.BottomSheetBehavior_Params_behavior_peekHeight, 0));
        a(typedArrayObtainStyledAttributes.getBoolean(android.support.design.a.i.BottomSheetBehavior_Params_behavior_hideable, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f253a = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private View a(View view) {
        if (view instanceof android.support.v4.view.x) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View viewA = a(viewGroup.getChildAt(i));
                if (viewA != null) {
                    return viewA;
                }
            }
        }
        return null;
    }

    private void a() {
        this.p = -1;
        if (this.o != null) {
            this.o.recycle();
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, float f2) {
        return view.getTop() >= this.f256d && Math.abs((((float) view.getTop()) + (0.1f * f2)) - ((float) this.f256d)) / ((float) this.f254b) > 0.5f;
    }

    private float b() {
        this.o.computeCurrentVelocity(1000, this.f253a);
        return android.support.v4.view.af.b(this.o, this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.f258f == i) {
            return;
        }
        this.f258f = i;
        V v = this.l.get();
        if (v == null || this.n == null) {
            return;
        }
        this.n.a((View) v, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        V v = this.l.get();
        if (v == null || this.n == null) {
            return;
        }
        if (i > this.f256d) {
            this.n.a(v, (this.f256d - i) / this.f254b);
        } else {
            this.n.a(v, (this.f256d - i) / (this.f256d - this.f255c));
        }
    }

    public final void a(int i) {
        this.f254b = Math.max(0, i);
        this.f256d = this.k - i;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.f260a == 1 || savedState.f260a == 2) {
            this.f258f = 4;
        } else {
            this.f258f = savedState.f260a;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i;
        int i2 = 3;
        if (v.getTop() == this.f255c) {
            b(3);
            return;
        }
        if (view == this.m.get() && this.j) {
            if (this.i > 0) {
                i = this.f255c;
            } else if (this.f257e && a(v, b())) {
                i = this.k;
                i2 = 5;
            } else if (this.i == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.f255c) < Math.abs(top - this.f256d)) {
                    i = this.f255c;
                } else {
                    i = this.f256d;
                    i2 = 4;
                }
            } else {
                i = this.f256d;
                i2 = 4;
            }
            if (this.g.a((View) v, v.getLeft(), i)) {
                b(2);
                ah.a(v, new b(v, i2));
            } else {
                b(i2);
            }
            this.j = false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view != this.m.get()) {
            return;
        }
        int top = v.getTop();
        int i3 = top - i2;
        if (i2 > 0) {
            if (i3 < this.f255c) {
                iArr[1] = top - this.f255c;
                ah.e(v, -iArr[1]);
                b(3);
            } else {
                iArr[1] = i2;
                ah.e(v, -i2);
                b(1);
            }
        } else if (i2 < 0 && !ah.b(view, -1)) {
            if (i3 <= this.f256d || this.f257e) {
                iArr[1] = i2;
                ah.e(v, -i2);
                b(1);
            } else {
                iArr[1] = top - this.f256d;
                ah.e(v, -iArr[1]);
                b(4);
            }
        }
        c(v.getTop());
        this.i = i2;
        this.j = true;
    }

    public void a(boolean z) {
        this.f257e = z;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (this.f258f != 1 && this.f258f != 2) {
            if (ah.w(coordinatorLayout) && !ah.w(v)) {
                ah.a((View) v, true);
            }
            coordinatorLayout.a(v, i);
        }
        this.k = coordinatorLayout.getHeight();
        this.f255c = Math.max(0, this.k - v.getHeight());
        this.f256d = Math.max(this.k - this.f254b, this.f255c);
        if (this.f258f == 3) {
            ah.e(v, this.f255c);
        } else if (this.f257e && this.f258f == 5) {
            ah.e(v, this.k);
        } else if (this.f258f == 4) {
            ah.e(v, this.f256d);
        }
        if (this.g == null) {
            this.g = af.a(coordinatorLayout, this.s);
        }
        this.l = new WeakReference<>(v);
        this.m = new WeakReference<>(a(v));
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int iA = android.support.v4.view.t.a(motionEvent);
        if (iA == 0) {
            a();
        }
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        }
        this.o.addMovement(motionEvent);
        switch (iA) {
            case 0:
                int x = (int) motionEvent.getX();
                this.q = (int) motionEvent.getY();
                View view = this.m.get();
                if (view != null && coordinatorLayout.a(view, x, this.q)) {
                    this.p = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.r = true;
                }
                this.h = this.p == -1 && !coordinatorLayout.a(v, x, this.q);
                break;
            case 1:
            case 3:
                this.r = false;
                this.p = -1;
                if (this.h) {
                    this.h = false;
                    return false;
                }
                break;
        }
        if (!this.h && this.g.a(motionEvent)) {
            return true;
        }
        View view2 = this.m.get();
        return (iA != 2 || view2 == null || this.h || this.f258f == 1 || coordinatorLayout.a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.q) - motionEvent.getY()) <= ((float) this.g.d())) ? false : true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        return view == this.m.get() && (this.f258f != 3 || super.a(coordinatorLayout, v, view, f2, f3));
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.i = 0;
        this.j = false;
        return (i & 2) != 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, v), this.f258f);
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int iA = android.support.v4.view.t.a(motionEvent);
        if (this.f258f == 1 && iA == 0) {
            return true;
        }
        this.g.b(motionEvent);
        if (iA == 0) {
            a();
        }
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        }
        this.o.addMovement(motionEvent);
        if (iA == 2 && !this.h && Math.abs(this.q - motionEvent.getY()) > this.g.d()) {
            this.g.a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.h;
    }
}
