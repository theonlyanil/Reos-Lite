package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f1830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f1831b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<View> f1832c = new ArrayList();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f1833a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f1834b;

        a() {
        }

        private void b() {
            if (this.f1834b == null) {
                this.f1834b = new a();
            }
        }

        void a() {
            this.f1833a = 0L;
            if (this.f1834b != null) {
                this.f1834b.a();
            }
        }

        void a(int i) {
            if (i < 64) {
                this.f1833a |= 1 << i;
            } else {
                b();
                this.f1834b.a(i - 64);
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f1834b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f1833a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f1833a = (((j ^ (-1)) & this.f1833a) << 1) | (this.f1833a & j);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.f1834b != null) {
                b();
                this.f1834b.a(0, z2);
            }
        }

        void b(int i) {
            if (i < 64) {
                this.f1833a &= (1 << i) ^ (-1);
            } else if (this.f1834b != null) {
                this.f1834b.b(i - 64);
            }
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f1833a & (1 << i)) != 0;
            }
            b();
            return this.f1834b.c(i - 64);
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f1834b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1833a & j) != 0;
            this.f1833a &= j ^ (-1);
            long j2 = j - 1;
            this.f1833a = Long.rotateRight((j2 ^ (-1)) & this.f1833a, 1) | (this.f1833a & j2);
            if (this.f1834b == null) {
                return z;
            }
            if (this.f1834b.c(0)) {
                a(63);
            }
            this.f1834b.d(0);
            return z;
        }

        int e(int i) {
            if (this.f1834b == null) {
                return i >= 64 ? Long.bitCount(this.f1833a) : Long.bitCount(this.f1833a & ((1 << i) - 1));
            }
            return i < 64 ? Long.bitCount(this.f1833a & ((1 << i) - 1)) : this.f1834b.e(i - 64) + Long.bitCount(this.f1833a);
        }

        public String toString() {
            return this.f1834b == null ? Long.toBinaryString(this.f1833a) : this.f1834b.toString() + "xx" + Long.toBinaryString(this.f1833a);
        }
    }

    interface b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        RecyclerView.u b(View view);

        View b(int i);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    s(b bVar) {
        this.f1830a = bVar;
    }

    private int e(int i) {
        if (i < 0) {
            return -1;
        }
        int iA = this.f1830a.a();
        int i2 = i;
        while (i2 < iA) {
            int iE = i - (i2 - this.f1831b.e(i2));
            if (iE == 0) {
                while (this.f1831b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iE;
        }
        return -1;
    }

    private void g(View view) {
        this.f1832c.add(view);
        this.f1830a.c(view);
    }

    private boolean h(View view) {
        if (!this.f1832c.remove(view)) {
            return false;
        }
        this.f1830a.d(view);
        return true;
    }

    View a(int i, int i2) {
        int size = this.f1832c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f1832c.get(i3);
            RecyclerView.u uVarB = this.f1830a.b(view);
            if (uVarB.d() == i && !uVarB.n() && !uVarB.q() && (i2 == -1 || uVarB.h() == i2)) {
                return view;
            }
        }
        return null;
    }

    void a() {
        this.f1831b.a();
        for (int size = this.f1832c.size() - 1; size >= 0; size--) {
            this.f1830a.d(this.f1832c.get(size));
            this.f1832c.remove(size);
        }
        this.f1830a.b();
    }

    void a(int i) {
        int iE = e(i);
        View viewB = this.f1830a.b(iE);
        if (viewB == null) {
            return;
        }
        if (this.f1831b.d(iE)) {
            h(viewB);
        }
        this.f1830a.a(iE);
    }

    void a(View view) {
        int iA = this.f1830a.a(view);
        if (iA < 0) {
            return;
        }
        if (this.f1831b.d(iA)) {
            h(view);
        }
        this.f1830a.a(iA);
    }

    void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iA = i < 0 ? this.f1830a.a() : e(i);
        this.f1831b.a(iA, z);
        if (z) {
            g(view);
        }
        this.f1830a.a(view, iA, layoutParams);
    }

    void a(View view, int i, boolean z) {
        int iA = i < 0 ? this.f1830a.a() : e(i);
        this.f1831b.a(iA, z);
        if (z) {
            g(view);
        }
        this.f1830a.a(view, iA);
    }

    void a(View view, boolean z) {
        a(view, -1, z);
    }

    int b() {
        return this.f1830a.a() - this.f1832c.size();
    }

    int b(View view) {
        int iA = this.f1830a.a(view);
        if (iA == -1 || this.f1831b.c(iA)) {
            return -1;
        }
        return iA - this.f1831b.e(iA);
    }

    View b(int i) {
        return this.f1830a.b(e(i));
    }

    int c() {
        return this.f1830a.a();
    }

    View c(int i) {
        return this.f1830a.b(i);
    }

    boolean c(View view) {
        return this.f1832c.contains(view);
    }

    void d(int i) {
        int iE = e(i);
        this.f1831b.d(iE);
        this.f1830a.c(iE);
    }

    void d(View view) {
        int iA = this.f1830a.a(view);
        if (iA < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f1831b.a(iA);
        g(view);
    }

    void e(View view) {
        int iA = this.f1830a.a(view);
        if (iA < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.f1831b.c(iA)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.f1831b.b(iA);
        h(view);
    }

    boolean f(View view) {
        int iA = this.f1830a.a(view);
        if (iA == -1) {
            if (h(view)) {
            }
            return true;
        }
        if (!this.f1831b.c(iA)) {
            return false;
        }
        this.f1831b.d(iA);
        if (!h(view)) {
        }
        this.f1830a.a(iA);
        return true;
    }

    public String toString() {
        return this.f1831b.toString() + ", hidden list:" + this.f1832c.size();
    }
}
