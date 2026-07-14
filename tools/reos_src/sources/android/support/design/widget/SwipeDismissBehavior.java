package android.support.design.widget;

import android.support.v4.view.ah;
import android.support.v4.widget.af;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private af f341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f343c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f345e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f344d = BitmapDescriptorFactory.HUE_RED;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f346f = 2;
    private float g = 0.5f;
    private float h = BitmapDescriptorFactory.HUE_RED;
    private float i = 0.5f;
    private final af.a j = new af.a() { // from class: android.support.design.widget.SwipeDismissBehavior.1

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f349c = -1;

        private boolean a(View view, float f2) {
            if (f2 == BitmapDescriptorFactory.HUE_RED) {
                return Math.abs(view.getLeft() - this.f348b) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.g);
            }
            boolean z = ah.h(view) == 1;
            if (SwipeDismissBehavior.this.f346f == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.f346f == 0) {
                if (z) {
                    return f2 < BitmapDescriptorFactory.HUE_RED;
                }
                return f2 > BitmapDescriptorFactory.HUE_RED;
            }
            if (SwipeDismissBehavior.this.f346f != 1) {
                return false;
            }
            if (z) {
                return f2 > BitmapDescriptorFactory.HUE_RED;
            }
            return f2 < BitmapDescriptorFactory.HUE_RED;
        }

        @Override // android.support.v4.widget.af.a
        public int a(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.af.a
        public void a(int i) {
            if (SwipeDismissBehavior.this.f342b != null) {
                SwipeDismissBehavior.this.f342b.a(i);
            }
        }

        @Override // android.support.v4.widget.af.a
        public void a(View view, float f2, float f3) {
            int i;
            this.f349c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (a(view, f2)) {
                i = view.getLeft() < this.f348b ? this.f348b - width : this.f348b + width;
                z = true;
            } else {
                i = this.f348b;
            }
            if (SwipeDismissBehavior.this.f341a.a(i, view.getTop())) {
                ah.a(view, new b(view, z));
            } else {
                if (!z || SwipeDismissBehavior.this.f342b == null) {
                    return;
                }
                SwipeDismissBehavior.this.f342b.a(view);
            }
        }

        @Override // android.support.v4.widget.af.a
        public void a(View view, int i, int i2, int i3, int i4) {
            float width = this.f348b + (view.getWidth() * SwipeDismissBehavior.this.h);
            float width2 = this.f348b + (view.getWidth() * SwipeDismissBehavior.this.i);
            if (i <= width) {
                ah.c(view, 1.0f);
            } else if (i >= width2) {
                ah.c(view, BitmapDescriptorFactory.HUE_RED);
            } else {
                ah.c(view, SwipeDismissBehavior.c(BitmapDescriptorFactory.HUE_RED, 1.0f - SwipeDismissBehavior.a(width, width2, i), 1.0f));
            }
        }

        @Override // android.support.v4.widget.af.a
        public boolean a(View view, int i) {
            return this.f349c == -1 && SwipeDismissBehavior.this.a(view);
        }

        @Override // android.support.v4.widget.af.a
        public int b(View view) {
            return view.getWidth();
        }

        @Override // android.support.v4.widget.af.a
        public int b(View view, int i, int i2) {
            int width;
            int width2;
            boolean z = ah.h(view) == 1;
            if (SwipeDismissBehavior.this.f346f == 0) {
                if (z) {
                    width = this.f348b - view.getWidth();
                    width2 = this.f348b;
                } else {
                    width = this.f348b;
                    width2 = this.f348b + view.getWidth();
                }
            } else if (SwipeDismissBehavior.this.f346f != 1) {
                width = this.f348b - view.getWidth();
                width2 = this.f348b + view.getWidth();
            } else if (z) {
                width = this.f348b;
                width2 = this.f348b + view.getWidth();
            } else {
                width = this.f348b - view.getWidth();
                width2 = this.f348b;
            }
            return SwipeDismissBehavior.b(width, i, width2);
        }

        @Override // android.support.v4.widget.af.a
        public void b(View view, int i) {
            this.f349c = i;
            this.f348b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    };

    public interface a {
        void a(int i);

        void a(View view);
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f352c;

        b(View view, boolean z) {
            this.f351b = view;
            this.f352c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.f341a != null && SwipeDismissBehavior.this.f341a.a(true)) {
                ah.a(this.f351b, this);
            } else {
                if (!this.f352c || SwipeDismissBehavior.this.f342b == null) {
                    return;
                }
                SwipeDismissBehavior.this.f342b.a(this.f351b);
            }
        }
    }

    static float a(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    private void a(ViewGroup viewGroup) {
        if (this.f341a == null) {
            this.f341a = this.f345e ? af.a(viewGroup, this.f344d, this.j) : af.a(viewGroup, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float c(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    public void a(float f2) {
        this.h = c(BitmapDescriptorFactory.HUE_RED, f2, 1.0f);
    }

    public void a(int i) {
        this.f346f = i;
    }

    public void a(a aVar) {
        this.f342b = aVar;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (android.support.v4.view.t.a(motionEvent)) {
            case 1:
            case 3:
                if (this.f343c) {
                    this.f343c = false;
                    return false;
                }
                break;
            case 2:
            default:
                this.f343c = !coordinatorLayout.a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f343c) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f341a.a(motionEvent);
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f2) {
        this.i = c(BitmapDescriptorFactory.HUE_RED, f2, 1.0f);
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f341a == null) {
            return false;
        }
        this.f341a.b(motionEvent);
        return true;
    }
}
