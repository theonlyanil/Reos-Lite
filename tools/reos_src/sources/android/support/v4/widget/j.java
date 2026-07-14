package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f1028b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f1029a;

    static class a implements c {
        a() {
        }

        @Override // android.support.v4.widget.j.c
        public Object a(Context context) {
            return null;
        }

        @Override // android.support.v4.widget.j.c
        public void a(Object obj, int i, int i2) {
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj) {
            return true;
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj, float f2) {
            return false;
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj, float f2, float f3) {
            return false;
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj, int i) {
            return false;
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj, Canvas canvas) {
            return false;
        }

        @Override // android.support.v4.widget.j.c
        public void b(Object obj) {
        }

        @Override // android.support.v4.widget.j.c
        public boolean c(Object obj) {
            return false;
        }
    }

    static class b implements c {
        b() {
        }

        @Override // android.support.v4.widget.j.c
        public Object a(Context context) {
            return k.a(context);
        }

        @Override // android.support.v4.widget.j.c
        public void a(Object obj, int i, int i2) {
            k.a(obj, i, i2);
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj) {
            return k.a(obj);
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj, float f2) {
            return k.a(obj, f2);
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj, float f2, float f3) {
            return k.a(obj, f2);
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj, int i) {
            return k.a(obj, i);
        }

        @Override // android.support.v4.widget.j.c
        public boolean a(Object obj, Canvas canvas) {
            return k.a(obj, canvas);
        }

        @Override // android.support.v4.widget.j.c
        public void b(Object obj) {
            k.b(obj);
        }

        @Override // android.support.v4.widget.j.c
        public boolean c(Object obj) {
            return k.c(obj);
        }
    }

    interface c {
        Object a(Context context);

        void a(Object obj, int i, int i2);

        boolean a(Object obj);

        boolean a(Object obj, float f2);

        boolean a(Object obj, float f2, float f3);

        boolean a(Object obj, int i);

        boolean a(Object obj, Canvas canvas);

        void b(Object obj);

        boolean c(Object obj);
    }

    static class d extends b {
        d() {
        }

        @Override // android.support.v4.widget.j.b, android.support.v4.widget.j.c
        public boolean a(Object obj, float f2, float f3) {
            return l.a(obj, f2, f3);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1028b = new d();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f1028b = new b();
        } else {
            f1028b = new a();
        }
    }

    public j(Context context) {
        this.f1029a = f1028b.a(context);
    }

    public void a(int i, int i2) {
        f1028b.a(this.f1029a, i, i2);
    }

    public boolean a() {
        return f1028b.a(this.f1029a);
    }

    public boolean a(float f2) {
        return f1028b.a(this.f1029a, f2);
    }

    public boolean a(float f2, float f3) {
        return f1028b.a(this.f1029a, f2, f3);
    }

    public boolean a(int i) {
        return f1028b.a(this.f1029a, i);
    }

    public boolean a(Canvas canvas) {
        return f1028b.a(this.f1029a, canvas);
    }

    public void b() {
        f1028b.b(this.f1029a);
    }

    public boolean c() {
        return f1028b.c(this.f1029a);
    }
}
