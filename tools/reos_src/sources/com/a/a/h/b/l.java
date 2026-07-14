package com.a.a.h.b;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class l<T extends View, Z> extends com.a.a.h.b.a<Z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2457b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Integer f2458c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f2459a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f2460d;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f2461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<i> f2462b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ViewTreeObserverOnPreDrawListenerC0046a f2463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Point f2464d;

        /* JADX INFO: renamed from: com.a.a.h.b.l$a$a, reason: collision with other inner class name */
        private static class ViewTreeObserverOnPreDrawListenerC0046a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f2465a;

            public ViewTreeObserverOnPreDrawListenerC0046a(a aVar) {
                this.f2465a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                a aVar = this.f2465a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        public a(View view) {
            this.f2461a = view;
        }

        private int a(int i, boolean z) {
            if (i != -2) {
                return i;
            }
            Point pointD = d();
            return z ? pointD.y : pointD.x;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.f2462b.isEmpty()) {
                return;
            }
            int iC = c();
            int iB = b();
            if (a(iC) && a(iB)) {
                a(iC, iB);
                ViewTreeObserver viewTreeObserver = this.f2461a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f2463c);
                }
                this.f2463c = null;
            }
        }

        private void a(int i, int i2) {
            Iterator<i> it = this.f2462b.iterator();
            while (it.hasNext()) {
                it.next().a(i, i2);
            }
            this.f2462b.clear();
        }

        private boolean a(int i) {
            return i > 0 || i == -2;
        }

        private int b() {
            ViewGroup.LayoutParams layoutParams = this.f2461a.getLayoutParams();
            if (a(this.f2461a.getHeight())) {
                return this.f2461a.getHeight();
            }
            if (layoutParams != null) {
                return a(layoutParams.height, true);
            }
            return 0;
        }

        private int c() {
            ViewGroup.LayoutParams layoutParams = this.f2461a.getLayoutParams();
            if (a(this.f2461a.getWidth())) {
                return this.f2461a.getWidth();
            }
            if (layoutParams != null) {
                return a(layoutParams.width, false);
            }
            return 0;
        }

        @TargetApi(13)
        private Point d() {
            if (this.f2464d != null) {
                return this.f2464d;
            }
            Display defaultDisplay = ((WindowManager) this.f2461a.getContext().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                this.f2464d = new Point();
                defaultDisplay.getSize(this.f2464d);
            } else {
                this.f2464d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.f2464d;
        }

        public void a(i iVar) {
            int iC = c();
            int iB = b();
            if (a(iC) && a(iB)) {
                iVar.a(iC, iB);
                return;
            }
            if (!this.f2462b.contains(iVar)) {
                this.f2462b.add(iVar);
            }
            if (this.f2463c == null) {
                ViewTreeObserver viewTreeObserver = this.f2461a.getViewTreeObserver();
                this.f2463c = new ViewTreeObserverOnPreDrawListenerC0046a(this);
                viewTreeObserver.addOnPreDrawListener(this.f2463c);
            }
        }
    }

    public l(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.f2459a = t;
        this.f2460d = new a(t);
    }

    private void a(Object obj) {
        if (f2458c != null) {
            this.f2459a.setTag(f2458c.intValue(), obj);
        } else {
            f2457b = true;
            this.f2459a.setTag(obj);
        }
    }

    private Object c() {
        return f2458c == null ? this.f2459a.getTag() : this.f2459a.getTag(f2458c.intValue());
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.k
    public com.a.a.h.c a() {
        Object objC = c();
        if (objC == null) {
            return null;
        }
        if (objC instanceof com.a.a.h.c) {
            return (com.a.a.h.c) objC;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.a.a.h.b.k
    public void a(i iVar) {
        this.f2460d.a(iVar);
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.k
    public void a(com.a.a.h.c cVar) {
        a((Object) cVar);
    }

    public T c_() {
        return this.f2459a;
    }

    public String toString() {
        return "Target for: " + this.f2459a;
    }
}
