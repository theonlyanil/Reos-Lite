package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final m f887a;

    static class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakHashMap<View, ba> f888a = null;

        a() {
        }

        private boolean a(ad adVar, int i) {
            int iComputeHorizontalScrollOffset = adVar.computeHorizontalScrollOffset();
            int iComputeHorizontalScrollRange = adVar.computeHorizontalScrollRange() - adVar.computeHorizontalScrollExtent();
            if (iComputeHorizontalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                return iComputeHorizontalScrollOffset > 0;
            }
            return iComputeHorizontalScrollOffset < iComputeHorizontalScrollRange + (-1);
        }

        private boolean b(ad adVar, int i) {
            int iComputeVerticalScrollOffset = adVar.computeVerticalScrollOffset();
            int iComputeVerticalScrollRange = adVar.computeVerticalScrollRange() - adVar.computeVerticalScrollExtent();
            if (iComputeVerticalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                return iComputeVerticalScrollOffset > 0;
            }
            return iComputeVerticalScrollOffset < iComputeVerticalScrollRange + (-1);
        }

        @Override // android.support.v4.view.ah.m
        public boolean A(View view) {
            return false;
        }

        @Override // android.support.v4.view.ah.m
        public ColorStateList B(View view) {
            return ai.a(view);
        }

        @Override // android.support.v4.view.ah.m
        public PorterDuff.Mode C(View view) {
            return ai.b(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ah.m
        public void D(View view) {
            if (view instanceof x) {
                ((x) view).stopNestedScroll();
            }
        }

        @Override // android.support.v4.view.ah.m
        public boolean E(View view) {
            return ai.c(view);
        }

        @Override // android.support.v4.view.ah.m
        public float F(View view) {
            return x(view) + w(view);
        }

        @Override // android.support.v4.view.ah.m
        public boolean G(View view) {
            return ai.f(view);
        }

        @Override // android.support.v4.view.ah.m
        public boolean H(View view) {
            return false;
        }

        @Override // android.support.v4.view.ah.m
        public int a(int i, int i2) {
            return i | i2;
        }

        @Override // android.support.v4.view.ah.m
        public int a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        @Override // android.support.v4.view.ah.m
        public int a(View view) {
            return 2;
        }

        long a() {
            return 10L;
        }

        @Override // android.support.v4.view.ah.m
        public bh a(View view, bh bhVar) {
            return bhVar;
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, float f2) {
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, int i, int i2) {
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, int i, Paint paint) {
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, ColorStateList colorStateList) {
            ai.a(view, colorStateList);
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, Paint paint) {
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, PorterDuff.Mode mode) {
            ai.a(view, mode);
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, android.support.v4.view.a aVar) {
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, ab abVar) {
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        @Override // android.support.v4.view.ah.m
        public void a(View view, boolean z) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ah.m
        public boolean a(View view, int i) {
            return (view instanceof ad) && a((ad) view, i);
        }

        @Override // android.support.v4.view.ah.m
        public bh b(View view, bh bhVar) {
            return bhVar;
        }

        @Override // android.support.v4.view.ah.m
        public void b(View view, float f2) {
        }

        @Override // android.support.v4.view.ah.m
        public void b(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ah.m
        public void b(View view, boolean z) {
        }

        @Override // android.support.v4.view.ah.m
        public boolean b(View view) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ah.m
        public boolean b(View view, int i) {
            return (view instanceof ad) && b((ad) view, i);
        }

        @Override // android.support.v4.view.ah.m
        public void c(View view, float f2) {
        }

        @Override // android.support.v4.view.ah.m
        public void c(View view, int i) {
        }

        @Override // android.support.v4.view.ah.m
        public void c(View view, boolean z) {
        }

        @Override // android.support.v4.view.ah.m
        public boolean c(View view) {
            return false;
        }

        @Override // android.support.v4.view.ah.m
        public void d(View view) {
            view.invalidate();
        }

        @Override // android.support.v4.view.ah.m
        public void d(View view, float f2) {
        }

        @Override // android.support.v4.view.ah.m
        public void d(View view, int i) {
        }

        @Override // android.support.v4.view.ah.m
        public int e(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ah.m
        public void e(View view, int i) {
            ai.b(view, i);
        }

        @Override // android.support.v4.view.ah.m
        public float f(View view) {
            return 1.0f;
        }

        @Override // android.support.v4.view.ah.m
        public void f(View view, int i) {
            ai.a(view, i);
        }

        @Override // android.support.v4.view.ah.m
        public int g(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ah.m
        public int h(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ah.m
        public ViewParent i(View view) {
            return view.getParent();
        }

        @Override // android.support.v4.view.ah.m
        public boolean j(View view) {
            Drawable background = view.getBackground();
            return background != null && background.getOpacity() == -1;
        }

        @Override // android.support.v4.view.ah.m
        public int k(View view) {
            return view.getMeasuredWidth();
        }

        @Override // android.support.v4.view.ah.m
        public int l(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ah.m
        public int m(View view) {
            return view.getPaddingLeft();
        }

        @Override // android.support.v4.view.ah.m
        public int n(View view) {
            return view.getPaddingRight();
        }

        @Override // android.support.v4.view.ah.m
        public boolean o(View view) {
            return true;
        }

        @Override // android.support.v4.view.ah.m
        public float p(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        @Override // android.support.v4.view.ah.m
        public float q(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        @Override // android.support.v4.view.ah.m
        public int r(View view) {
            return ai.d(view);
        }

        @Override // android.support.v4.view.ah.m
        public int s(View view) {
            return ai.e(view);
        }

        @Override // android.support.v4.view.ah.m
        public ba t(View view) {
            return new ba(view);
        }

        @Override // android.support.v4.view.ah.m
        public int u(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ah.m
        public void v(View view) {
        }

        @Override // android.support.v4.view.ah.m
        public float w(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float x(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        @Override // android.support.v4.view.ah.m
        public boolean y(View view) {
            return false;
        }

        @Override // android.support.v4.view.ah.m
        public void z(View view) {
        }
    }

    static class b extends a {
        b() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean j(View view) {
            return aj.a(view);
        }
    }

    static class c extends b {
        c() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int a(View view) {
            return ak.a(view);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int a(int i, int i2) {
            return al.a(i, i2);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int a(int i, int i2, int i3) {
            return al.a(i, i2, i3);
        }

        @Override // android.support.v4.view.ah.a
        long a() {
            return al.a();
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, float f2) {
            al.a(view, f2);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, int i, Paint paint) {
            al.a(view, i, paint);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, Paint paint) {
            a(view, g(view), paint);
            view.invalidate();
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void b(View view, float f2) {
            al.b(view, f2);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void b(View view, boolean z) {
            al.a(view, z);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void c(View view, float f2) {
            al.c(view, f2);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void c(View view, boolean z) {
            al.b(view, z);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void e(View view, int i) {
            al.b(view, i);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public float f(View view) {
            return al.a(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void f(View view, int i) {
            al.a(view, i);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int g(View view) {
            return al.b(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int k(View view) {
            return al.c(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int l(View view) {
            return al.d(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public float p(View view) {
            return al.e(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public float q(View view) {
            return al.f(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void z(View view) {
            al.g(view);
        }
    }

    static class e extends f {
        e() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean H(View view) {
            return an.a(view);
        }
    }

    static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static Field f889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static boolean f890c = false;

        f() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, android.support.v4.view.a aVar) {
            am.a(view, aVar == null ? null : aVar.a());
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, boolean z) {
            am.a(view, z);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean a(View view, int i) {
            return am.a(view, i);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean b(View view) {
            if (f890c) {
                return false;
            }
            if (f889b == null) {
                try {
                    f889b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f889b.setAccessible(true);
                } catch (Throwable th) {
                    f890c = true;
                    return false;
                }
            }
            try {
                return f889b.get(view) != null;
            } catch (Throwable th2) {
                f890c = true;
                return false;
            }
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean b(View view, int i) {
            return am.b(view, i);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public ba t(View view) {
            if (this.f888a == null) {
                this.f888a = new WeakHashMap<>();
            }
            ba baVar = this.f888a.get(view);
            if (baVar != null) {
                return baVar;
            }
            ba baVar2 = new ba(view);
            this.f888a.put(view, baVar2);
            return baVar2;
        }
    }

    static class g extends e {
        g() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, int i, int i2, int i3, int i4) {
            ao.a(view, i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, Runnable runnable) {
            ao.a(view, runnable);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, Runnable runnable, long j) {
            ao.a(view, runnable, j);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            ao.a(view, i);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean c(View view) {
            return ao.a(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void d(View view) {
            ao.b(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int e(View view) {
            return ao.c(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public ViewParent i(View view) {
            return ao.d(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean o(View view) {
            return ao.i(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int r(View view) {
            return ao.e(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int s(View view) {
            return ao.f(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void v(View view) {
            ao.g(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean y(View view) {
            return ao.h(view);
        }
    }

    static class h extends g {
        h() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean A(View view) {
            return ap.e(view);
        }

        @Override // android.support.v4.view.ah.d, android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, Paint paint) {
            ap.a(view, paint);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void b(View view, int i, int i2, int i3, int i4) {
            ap.a(view, i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int h(View view) {
            return ap.a(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int m(View view) {
            return ap.b(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int n(View view) {
            return ap.c(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public int u(View view) {
            return ap.d(view);
        }
    }

    static class i extends h {
        i() {
        }
    }

    static class j extends i {
        j() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean E(View view) {
            return aq.a(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public boolean G(View view) {
            return aq.b(view);
        }

        @Override // android.support.v4.view.ah.g, android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void c(View view, int i) {
            ao.a(view, i);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void d(View view, int i) {
            aq.a(view, i);
        }
    }

    static class k extends j {
        k() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public ColorStateList B(View view) {
            return ar.d(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public PorterDuff.Mode C(View view) {
            return ar.e(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void D(View view) {
            ar.f(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public float F(View view) {
            return ar.g(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public bh a(View view, bh bhVar) {
            return ar.a(view, bhVar);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, ColorStateList colorStateList) {
            ar.a(view, colorStateList);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, PorterDuff.Mode mode) {
            ar.a(view, mode);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, ab abVar) {
            ar.a(view, abVar);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public bh b(View view, bh bhVar) {
            return ar.b(view, bhVar);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void d(View view, float f2) {
            ar.a(view, f2);
        }

        @Override // android.support.v4.view.ah.d, android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void e(View view, int i) {
            ar.b(view, i);
        }

        @Override // android.support.v4.view.ah.d, android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void f(View view, int i) {
            ar.a(view, i);
        }

        @Override // android.support.v4.view.ah.g, android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void v(View view) {
            ar.a(view);
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public float w(View view) {
            return ar.b(view);
        }

        @Override // android.support.v4.view.ah.a
        public float x(View view) {
            return ar.c(view);
        }
    }

    static class l extends k {
        l() {
        }

        @Override // android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void a(View view, int i, int i2) {
            as.a(view, i, i2);
        }

        @Override // android.support.v4.view.ah.k, android.support.v4.view.ah.d, android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void e(View view, int i) {
            as.b(view, i);
        }

        @Override // android.support.v4.view.ah.k, android.support.v4.view.ah.d, android.support.v4.view.ah.a, android.support.v4.view.ah.m
        public void f(View view, int i) {
            as.a(view, i);
        }
    }

    interface m {
        boolean A(View view);

        ColorStateList B(View view);

        PorterDuff.Mode C(View view);

        void D(View view);

        boolean E(View view);

        float F(View view);

        boolean G(View view);

        boolean H(View view);

        int a(int i, int i2);

        int a(int i, int i2, int i3);

        int a(View view);

        bh a(View view, bh bhVar);

        void a(View view, float f2);

        void a(View view, int i, int i2);

        void a(View view, int i, int i2, int i3, int i4);

        void a(View view, int i, Paint paint);

        void a(View view, ColorStateList colorStateList);

        void a(View view, Paint paint);

        void a(View view, PorterDuff.Mode mode);

        void a(View view, android.support.v4.view.a aVar);

        void a(View view, ab abVar);

        void a(View view, Runnable runnable);

        void a(View view, Runnable runnable, long j);

        void a(View view, boolean z);

        boolean a(View view, int i);

        bh b(View view, bh bhVar);

        void b(View view, float f2);

        void b(View view, int i, int i2, int i3, int i4);

        void b(View view, boolean z);

        boolean b(View view);

        boolean b(View view, int i);

        void c(View view, float f2);

        void c(View view, int i);

        void c(View view, boolean z);

        boolean c(View view);

        void d(View view);

        void d(View view, float f2);

        void d(View view, int i);

        int e(View view);

        void e(View view, int i);

        float f(View view);

        void f(View view, int i);

        int g(View view);

        int h(View view);

        ViewParent i(View view);

        boolean j(View view);

        int k(View view);

        int l(View view);

        int m(View view);

        int n(View view);

        boolean o(View view);

        float p(View view);

        float q(View view);

        int r(View view);

        int s(View view);

        ba t(View view);

        int u(View view);

        void v(View view);

        float w(View view);

        boolean y(View view);

        void z(View view);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            f887a = new l();
            return;
        }
        if (i2 >= 21) {
            f887a = new k();
            return;
        }
        if (i2 >= 19) {
            f887a = new j();
            return;
        }
        if (i2 >= 17) {
            f887a = new h();
            return;
        }
        if (i2 >= 16) {
            f887a = new g();
            return;
        }
        if (i2 >= 15) {
            f887a = new e();
            return;
        }
        if (i2 >= 14) {
            f887a = new f();
            return;
        }
        if (i2 >= 11) {
            f887a = new d();
            return;
        }
        if (i2 >= 9) {
            f887a = new c();
        } else if (i2 >= 7) {
            f887a = new b();
        } else {
            f887a = new a();
        }
    }

    public static ColorStateList A(View view) {
        return f887a.B(view);
    }

    public static PorterDuff.Mode B(View view) {
        return f887a.C(view);
    }

    public static void C(View view) {
        f887a.D(view);
    }

    public static boolean D(View view) {
        return f887a.E(view);
    }

    public static float E(View view) {
        return f887a.F(view);
    }

    public static boolean F(View view) {
        return f887a.G(view);
    }

    public static boolean G(View view) {
        return f887a.H(view);
    }

    public static int a(int i2, int i3) {
        return f887a.a(i2, i3);
    }

    public static int a(int i2, int i3, int i4) {
        return f887a.a(i2, i3, i4);
    }

    public static int a(View view) {
        return f887a.a(view);
    }

    public static bh a(View view, bh bhVar) {
        return f887a.a(view, bhVar);
    }

    public static void a(View view, float f2) {
        f887a.a(view, f2);
    }

    public static void a(View view, int i2, int i3) {
        f887a.a(view, i2, i3);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        f887a.a(view, i2, i3, i4, i5);
    }

    public static void a(View view, int i2, Paint paint) {
        f887a.a(view, i2, paint);
    }

    public static void a(View view, ColorStateList colorStateList) {
        f887a.a(view, colorStateList);
    }

    public static void a(View view, Paint paint) {
        f887a.a(view, paint);
    }

    public static void a(View view, PorterDuff.Mode mode) {
        f887a.a(view, mode);
    }

    public static void a(View view, android.support.v4.view.a aVar) {
        f887a.a(view, aVar);
    }

    public static void a(View view, ab abVar) {
        f887a.a(view, abVar);
    }

    public static void a(View view, Runnable runnable) {
        f887a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j2) {
        f887a.a(view, runnable, j2);
    }

    public static void a(View view, boolean z) {
        f887a.a(view, z);
    }

    public static boolean a(View view, int i2) {
        return f887a.a(view, i2);
    }

    public static bh b(View view, bh bhVar) {
        return f887a.b(view, bhVar);
    }

    public static void b(View view, float f2) {
        f887a.b(view, f2);
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        f887a.b(view, i2, i3, i4, i5);
    }

    public static void b(View view, boolean z) {
        f887a.b(view, z);
    }

    public static boolean b(View view) {
        return f887a.b(view);
    }

    public static boolean b(View view, int i2) {
        return f887a.b(view, i2);
    }

    public static void c(View view, float f2) {
        f887a.c(view, f2);
    }

    public static void c(View view, int i2) {
        f887a.c(view, i2);
    }

    public static void c(View view, boolean z) {
        f887a.c(view, z);
    }

    public static boolean c(View view) {
        return f887a.c(view);
    }

    public static void d(View view) {
        f887a.d(view);
    }

    public static void d(View view, float f2) {
        f887a.d(view, f2);
    }

    public static void d(View view, int i2) {
        f887a.d(view, i2);
    }

    public static int e(View view) {
        return f887a.e(view);
    }

    public static void e(View view, int i2) {
        f887a.f(view, i2);
    }

    public static float f(View view) {
        return f887a.f(view);
    }

    public static void f(View view, int i2) {
        f887a.e(view, i2);
    }

    public static int g(View view) {
        return f887a.g(view);
    }

    public static int h(View view) {
        return f887a.h(view);
    }

    public static ViewParent i(View view) {
        return f887a.i(view);
    }

    public static boolean j(View view) {
        return f887a.j(view);
    }

    public static int k(View view) {
        return f887a.k(view);
    }

    public static int l(View view) {
        return f887a.l(view);
    }

    public static int m(View view) {
        return f887a.m(view);
    }

    public static int n(View view) {
        return f887a.n(view);
    }

    public static float o(View view) {
        return f887a.p(view);
    }

    public static float p(View view) {
        return f887a.q(view);
    }

    public static int q(View view) {
        return f887a.r(view);
    }

    public static int r(View view) {
        return f887a.s(view);
    }

    public static ba s(View view) {
        return f887a.t(view);
    }

    public static float t(View view) {
        return f887a.w(view);
    }

    public static int u(View view) {
        return f887a.u(view);
    }

    public static void v(View view) {
        f887a.v(view);
    }

    public static boolean w(View view) {
        return f887a.y(view);
    }

    public static void x(View view) {
        f887a.z(view);
    }

    public static boolean y(View view) {
        return f887a.o(view);
    }

    public static boolean z(View view) {
        return f887a.A(view);
    }
}
