package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f1035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f1036b;

    interface a {
        Object a(Context context, Interpolator interpolator);

        void a(Object obj, int i, int i2, int i3, int i4);

        void a(Object obj, int i, int i2, int i3, int i4, int i5);

        void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean a(Object obj);

        boolean a(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        int b(Object obj);

        int c(Object obj);

        float d(Object obj);

        boolean e(Object obj);

        void f(Object obj);

        int g(Object obj);

        int h(Object obj);
    }

    static class b implements a {
        b() {
        }

        @Override // android.support.v4.widget.w.a
        public Object a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        @Override // android.support.v4.widget.w.a
        public void a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        @Override // android.support.v4.widget.w.a
        public void a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        @Override // android.support.v4.widget.w.a
        public void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // android.support.v4.widget.w.a
        public void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // android.support.v4.widget.w.a
        public boolean a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        @Override // android.support.v4.widget.w.a
        public boolean a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return false;
        }

        @Override // android.support.v4.widget.w.a
        public int b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        @Override // android.support.v4.widget.w.a
        public int c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        @Override // android.support.v4.widget.w.a
        public float d(Object obj) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        @Override // android.support.v4.widget.w.a
        public boolean e(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        @Override // android.support.v4.widget.w.a
        public void f(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        @Override // android.support.v4.widget.w.a
        public int g(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        @Override // android.support.v4.widget.w.a
        public int h(Object obj) {
            return ((Scroller) obj).getFinalY();
        }
    }

    static class c implements a {
        c() {
        }

        @Override // android.support.v4.widget.w.a
        public Object a(Context context, Interpolator interpolator) {
            return x.a(context, interpolator);
        }

        @Override // android.support.v4.widget.w.a
        public void a(Object obj, int i, int i2, int i3, int i4) {
            x.a(obj, i, i2, i3, i4);
        }

        @Override // android.support.v4.widget.w.a
        public void a(Object obj, int i, int i2, int i3, int i4, int i5) {
            x.a(obj, i, i2, i3, i4, i5);
        }

        @Override // android.support.v4.widget.w.a
        public void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            x.a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        @Override // android.support.v4.widget.w.a
        public void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            x.a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        @Override // android.support.v4.widget.w.a
        public boolean a(Object obj) {
            return x.a(obj);
        }

        @Override // android.support.v4.widget.w.a
        public boolean a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return x.a(obj, i, i2, i3, i4, i5, i6);
        }

        @Override // android.support.v4.widget.w.a
        public int b(Object obj) {
            return x.b(obj);
        }

        @Override // android.support.v4.widget.w.a
        public int c(Object obj) {
            return x.c(obj);
        }

        @Override // android.support.v4.widget.w.a
        public float d(Object obj) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        @Override // android.support.v4.widget.w.a
        public boolean e(Object obj) {
            return x.d(obj);
        }

        @Override // android.support.v4.widget.w.a
        public void f(Object obj) {
            x.e(obj);
        }

        @Override // android.support.v4.widget.w.a
        public int g(Object obj) {
            return x.f(obj);
        }

        @Override // android.support.v4.widget.w.a
        public int h(Object obj) {
            return x.g(obj);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.widget.w.c, android.support.v4.widget.w.a
        public float d(Object obj) {
            return y.a(obj);
        }
    }

    private w(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1036b = new d();
        } else if (i >= 9) {
            this.f1036b = new c();
        } else {
            this.f1036b = new b();
        }
        this.f1035a = this.f1036b.a(context, interpolator);
    }

    public static w a(Context context) {
        return a(context, null);
    }

    public static w a(Context context, Interpolator interpolator) {
        return new w(Build.VERSION.SDK_INT, context, interpolator);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f1036b.a(this.f1035a, i, i2, i3, i4);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.f1036b.a(this.f1035a, i, i2, i3, i4, i5);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1036b.a(this.f1035a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1036b.a(this.f1035a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean a() {
        return this.f1036b.a(this.f1035a);
    }

    public boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1036b.a(this.f1035a, i, i2, i3, i4, i5, i6);
    }

    public int b() {
        return this.f1036b.b(this.f1035a);
    }

    public int c() {
        return this.f1036b.c(this.f1035a);
    }

    public int d() {
        return this.f1036b.g(this.f1035a);
    }

    public int e() {
        return this.f1036b.h(this.f1035a);
    }

    public float f() {
        return this.f1036b.d(this.f1035a);
    }

    public boolean g() {
        return this.f1036b.e(this.f1035a);
    }

    public void h() {
        this.f1036b.f(this.f1035a);
    }
}
