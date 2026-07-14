package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.google.android.gms.location.places.Place;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e f862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f863b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f864a = new a(1, null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f865b = new a(2, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f866c = new a(4, null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f867d = new a(8, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f868e = new a(16, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f869f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(128, null);
        public static final a i = new a(256, null);
        public static final a j = new a(512, null);
        public static final a k = new a(Place.TYPE_SUBLOCALITY_LEVEL_2, null);
        public static final a l = new a(2048, null);
        public static final a m = new a(4096, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(131072, null);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null);
        private final Object w;

        public a(int i2, CharSequence charSequence) {
            this(c.f862a.a(i2, charSequence));
        }

        private a(Object obj) {
            this.w = obj;
        }
    }

    static class b extends i {
        b() {
        }

        @Override // android.support.v4.view.a.c.i, android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return android.support.v4.view.a.d.a(i, i2, i3, i4, z, z2);
        }

        @Override // android.support.v4.view.a.c.i, android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public Object a(int i, int i2, boolean z, int i3) {
            return android.support.v4.view.a.d.a(i, i2, z, i3);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public Object a(int i, CharSequence charSequence) {
            return android.support.v4.view.a.d.a(i, charSequence);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void a(Object obj, CharSequence charSequence) {
            android.support.v4.view.a.d.a(obj, charSequence);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean a(Object obj, Object obj2) {
            return android.support.v4.view.a.d.a(obj, obj2);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.view.a.c$c, reason: collision with other inner class name */
    static class C0022c extends b {
        C0022c() {
        }
    }

    static class d extends j {
        d() {
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public Object a(Object obj) {
            return android.support.v4.view.a.e.a(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void a(Object obj, int i) {
            android.support.v4.view.a.e.a(obj, i);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void a(Object obj, Rect rect) {
            android.support.v4.view.a.e.a(obj, rect);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void a(Object obj, View view) {
            android.support.v4.view.a.e.a(obj, view);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void a(Object obj, boolean z) {
            android.support.v4.view.a.e.a(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public int b(Object obj) {
            return android.support.v4.view.a.e.b(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void b(Object obj, Rect rect) {
            android.support.v4.view.a.e.b(obj, rect);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void b(Object obj, View view) {
            android.support.v4.view.a.e.b(obj, view);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void b(Object obj, CharSequence charSequence) {
            android.support.v4.view.a.e.a(obj, charSequence);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void b(Object obj, boolean z) {
            android.support.v4.view.a.e.b(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public CharSequence c(Object obj) {
            return android.support.v4.view.a.e.c(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void c(Object obj, Rect rect) {
            android.support.v4.view.a.e.c(obj, rect);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void c(Object obj, View view) {
            android.support.v4.view.a.e.c(obj, view);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void c(Object obj, CharSequence charSequence) {
            android.support.v4.view.a.e.b(obj, charSequence);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void c(Object obj, boolean z) {
            android.support.v4.view.a.e.c(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public CharSequence d(Object obj) {
            return android.support.v4.view.a.e.d(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void d(Object obj, Rect rect) {
            android.support.v4.view.a.e.d(obj, rect);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void d(Object obj, CharSequence charSequence) {
            android.support.v4.view.a.e.c(obj, charSequence);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void d(Object obj, boolean z) {
            android.support.v4.view.a.e.d(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public CharSequence e(Object obj) {
            return android.support.v4.view.a.e.e(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void e(Object obj, CharSequence charSequence) {
            android.support.v4.view.a.e.d(obj, charSequence);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void e(Object obj, boolean z) {
            android.support.v4.view.a.e.e(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public CharSequence f(Object obj) {
            return android.support.v4.view.a.e.f(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void f(Object obj, boolean z) {
            android.support.v4.view.a.e.f(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void g(Object obj, boolean z) {
            android.support.v4.view.a.e.g(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean g(Object obj) {
            return android.support.v4.view.a.e.g(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean h(Object obj) {
            return android.support.v4.view.a.e.h(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean i(Object obj) {
            return android.support.v4.view.a.e.i(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean j(Object obj) {
            return android.support.v4.view.a.e.j(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean k(Object obj) {
            return android.support.v4.view.a.e.k(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean l(Object obj) {
            return android.support.v4.view.a.e.l(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean m(Object obj) {
            return android.support.v4.view.a.e.m(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean n(Object obj) {
            return android.support.v4.view.a.e.n(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean o(Object obj) {
            return android.support.v4.view.a.e.o(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean p(Object obj) {
            return android.support.v4.view.a.e.p(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void q(Object obj) {
            android.support.v4.view.a.e.q(obj);
        }
    }

    interface e {
        Object a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object a(int i, int i2, boolean z, int i3);

        Object a(int i, CharSequence charSequence);

        Object a(Object obj);

        void a(Object obj, int i);

        void a(Object obj, Rect rect);

        void a(Object obj, View view);

        void a(Object obj, CharSequence charSequence);

        void a(Object obj, boolean z);

        boolean a(Object obj, Object obj2);

        int b(Object obj);

        void b(Object obj, int i);

        void b(Object obj, Rect rect);

        void b(Object obj, View view);

        void b(Object obj, CharSequence charSequence);

        void b(Object obj, Object obj2);

        void b(Object obj, boolean z);

        CharSequence c(Object obj);

        void c(Object obj, Rect rect);

        void c(Object obj, View view);

        void c(Object obj, CharSequence charSequence);

        void c(Object obj, Object obj2);

        void c(Object obj, boolean z);

        CharSequence d(Object obj);

        void d(Object obj, Rect rect);

        void d(Object obj, View view);

        void d(Object obj, CharSequence charSequence);

        void d(Object obj, boolean z);

        CharSequence e(Object obj);

        void e(Object obj, CharSequence charSequence);

        void e(Object obj, boolean z);

        CharSequence f(Object obj);

        void f(Object obj, boolean z);

        void g(Object obj, boolean z);

        boolean g(Object obj);

        void h(Object obj, boolean z);

        boolean h(Object obj);

        void i(Object obj, boolean z);

        boolean i(Object obj);

        void j(Object obj, boolean z);

        boolean j(Object obj);

        boolean k(Object obj);

        boolean l(Object obj);

        boolean m(Object obj);

        boolean n(Object obj);

        boolean o(Object obj);

        boolean p(Object obj);

        void q(Object obj);

        int r(Object obj);

        boolean s(Object obj);

        boolean t(Object obj);

        String u(Object obj);
    }

    static class f extends d {
        f() {
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void b(Object obj, int i) {
            android.support.v4.view.a.f.a(obj, i);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void h(Object obj, boolean z) {
            android.support.v4.view.a.f.a(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void i(Object obj, boolean z) {
            android.support.v4.view.a.f.b(obj, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public int r(Object obj) {
            return android.support.v4.view.a.f.b(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean s(Object obj) {
            return android.support.v4.view.a.f.a(obj);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public boolean t(Object obj) {
            return android.support.v4.view.a.f.c(obj);
        }
    }

    static class g extends f {
        g() {
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void d(Object obj, View view) {
            android.support.v4.view.a.g.a(obj, view);
        }
    }

    static class h extends g {
        h() {
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public String u(Object obj) {
            return android.support.v4.view.a.h.a(obj);
        }
    }

    static class i extends h {
        i() {
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return android.support.v4.view.a.i.a(i, i2, i3, i4, z);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public Object a(int i, int i2, boolean z, int i3) {
            return android.support.v4.view.a.i.a(i, i2, z, i3);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void b(Object obj, Object obj2) {
            android.support.v4.view.a.i.a(obj, obj2);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void c(Object obj, Object obj2) {
            android.support.v4.view.a.i.b(obj, obj2);
        }

        @Override // android.support.v4.view.a.c.j, android.support.v4.view.a.c.e
        public void j(Object obj, boolean z) {
            android.support.v4.view.a.i.a(obj, z);
        }
    }

    static class j implements e {
        j() {
        }

        @Override // android.support.v4.view.a.c.e
        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        @Override // android.support.v4.view.a.c.e
        public Object a(int i, int i2, boolean z, int i3) {
            return null;
        }

        @Override // android.support.v4.view.a.c.e
        public Object a(int i, CharSequence charSequence) {
            return null;
        }

        @Override // android.support.v4.view.a.c.e
        public Object a(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.a.c.e
        public void a(Object obj, int i) {
        }

        @Override // android.support.v4.view.a.c.e
        public void a(Object obj, Rect rect) {
        }

        @Override // android.support.v4.view.a.c.e
        public void a(Object obj, View view) {
        }

        @Override // android.support.v4.view.a.c.e
        public void a(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.a.c.e
        public void a(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public int b(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.a.c.e
        public void b(Object obj, int i) {
        }

        @Override // android.support.v4.view.a.c.e
        public void b(Object obj, Rect rect) {
        }

        @Override // android.support.v4.view.a.c.e
        public void b(Object obj, View view) {
        }

        @Override // android.support.v4.view.a.c.e
        public void b(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.a.c.e
        public void b(Object obj, Object obj2) {
        }

        @Override // android.support.v4.view.a.c.e
        public void b(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public CharSequence c(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.a.c.e
        public void c(Object obj, Rect rect) {
        }

        @Override // android.support.v4.view.a.c.e
        public void c(Object obj, View view) {
        }

        @Override // android.support.v4.view.a.c.e
        public void c(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.a.c.e
        public void c(Object obj, Object obj2) {
        }

        @Override // android.support.v4.view.a.c.e
        public void c(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public CharSequence d(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.a.c.e
        public void d(Object obj, Rect rect) {
        }

        @Override // android.support.v4.view.a.c.e
        public void d(Object obj, View view) {
        }

        @Override // android.support.v4.view.a.c.e
        public void d(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.a.c.e
        public void d(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public CharSequence e(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.a.c.e
        public void e(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.a.c.e
        public void e(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public CharSequence f(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.a.c.e
        public void f(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public void g(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public boolean g(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public void h(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public boolean h(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public void i(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public boolean i(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public void j(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.c.e
        public boolean j(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public boolean k(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public boolean l(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public boolean m(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public boolean n(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public boolean o(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public boolean p(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public void q(Object obj) {
        }

        @Override // android.support.v4.view.a.c.e
        public int r(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.a.c.e
        public boolean s(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public boolean t(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.a.c.e
        public String u(Object obj) {
            return null;
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f870a;

        private k(Object obj) {
            this.f870a = obj;
        }

        public static k a(int i, int i2, boolean z, int i3) {
            return new k(c.f862a.a(i, i2, z, i3));
        }
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f871a;

        private l(Object obj) {
            this.f871a = obj;
        }

        public static l a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new l(c.f862a.a(i, i2, i3, i4, z, z2));
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f862a = new C0022c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            f862a = new b();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            f862a = new i();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            f862a = new h();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            f862a = new g();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            f862a = new f();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f862a = new d();
        } else {
            f862a = new j();
        }
    }

    public c(Object obj) {
        this.f863b = obj;
    }

    public static c a(c cVar) {
        return a(f862a.a(cVar.f863b));
    }

    static c a(Object obj) {
        if (obj != null) {
            return new c(obj);
        }
        return null;
    }

    private static String c(int i2) {
        switch (i2) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case Place.TYPE_SUBLOCALITY_LEVEL_2 /* 1024 */:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public Object a() {
        return this.f863b;
    }

    public void a(int i2) {
        f862a.a(this.f863b, i2);
    }

    public void a(Rect rect) {
        f862a.a(this.f863b, rect);
    }

    public void a(View view) {
        f862a.c(this.f863b, view);
    }

    public void a(CharSequence charSequence) {
        f862a.d(this.f863b, charSequence);
    }

    public void a(boolean z) {
        f862a.c(this.f863b, z);
    }

    public boolean a(a aVar) {
        return f862a.a(this.f863b, aVar.w);
    }

    public int b() {
        return f862a.b(this.f863b);
    }

    public void b(int i2) {
        f862a.b(this.f863b, i2);
    }

    public void b(Rect rect) {
        f862a.c(this.f863b, rect);
    }

    public void b(View view) {
        f862a.a(this.f863b, view);
    }

    public void b(CharSequence charSequence) {
        f862a.b(this.f863b, charSequence);
    }

    public void b(Object obj) {
        f862a.b(this.f863b, ((k) obj).f870a);
    }

    public void b(boolean z) {
        f862a.d(this.f863b, z);
    }

    public int c() {
        return f862a.r(this.f863b);
    }

    public void c(Rect rect) {
        f862a.b(this.f863b, rect);
    }

    public void c(View view) {
        f862a.b(this.f863b, view);
    }

    public void c(CharSequence charSequence) {
        f862a.e(this.f863b, charSequence);
    }

    public void c(Object obj) {
        f862a.c(this.f863b, ((l) obj).f871a);
    }

    public void c(boolean z) {
        f862a.h(this.f863b, z);
    }

    public void d(Rect rect) {
        f862a.d(this.f863b, rect);
    }

    public void d(View view) {
        f862a.d(this.f863b, view);
    }

    public void d(CharSequence charSequence) {
        f862a.c(this.f863b, charSequence);
    }

    public void d(boolean z) {
        f862a.i(this.f863b, z);
    }

    public boolean d() {
        return f862a.g(this.f863b);
    }

    public void e(CharSequence charSequence) {
        f862a.a(this.f863b, charSequence);
    }

    public void e(boolean z) {
        f862a.g(this.f863b, z);
    }

    public boolean e() {
        return f862a.h(this.f863b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f863b == null) {
                return cVar.f863b == null;
            }
            return this.f863b.equals(cVar.f863b);
        }
        return false;
    }

    public void f(boolean z) {
        f862a.a(this.f863b, z);
    }

    public boolean f() {
        return f862a.k(this.f863b);
    }

    public void g(boolean z) {
        f862a.e(this.f863b, z);
    }

    public boolean g() {
        return f862a.l(this.f863b);
    }

    public void h(boolean z) {
        f862a.b(this.f863b, z);
    }

    public boolean h() {
        return f862a.s(this.f863b);
    }

    public int hashCode() {
        if (this.f863b == null) {
            return 0;
        }
        return this.f863b.hashCode();
    }

    public void i(boolean z) {
        f862a.f(this.f863b, z);
    }

    public boolean i() {
        return f862a.t(this.f863b);
    }

    public void j(boolean z) {
        f862a.j(this.f863b, z);
    }

    public boolean j() {
        return f862a.p(this.f863b);
    }

    public boolean k() {
        return f862a.i(this.f863b);
    }

    public boolean l() {
        return f862a.m(this.f863b);
    }

    public boolean m() {
        return f862a.j(this.f863b);
    }

    public boolean n() {
        return f862a.n(this.f863b);
    }

    public boolean o() {
        return f862a.o(this.f863b);
    }

    public CharSequence p() {
        return f862a.e(this.f863b);
    }

    public CharSequence q() {
        return f862a.c(this.f863b);
    }

    public CharSequence r() {
        return f862a.f(this.f863b);
    }

    public CharSequence s() {
        return f862a.d(this.f863b);
    }

    public void t() {
        f862a.q(this.f863b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(p());
        sb.append("; className: ").append(q());
        sb.append("; text: ").append(r());
        sb.append("; contentDescription: ").append(s());
        sb.append("; viewId: ").append(u());
        sb.append("; checkable: ").append(d());
        sb.append("; checked: ").append(e());
        sb.append("; focusable: ").append(f());
        sb.append("; focused: ").append(g());
        sb.append("; selected: ").append(j());
        sb.append("; clickable: ").append(k());
        sb.append("; longClickable: ").append(l());
        sb.append("; enabled: ").append(m());
        sb.append("; password: ").append(n());
        sb.append("; scrollable: " + o());
        sb.append("; [");
        int iB = b();
        while (iB != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iB);
            iB &= iNumberOfTrailingZeros ^ (-1);
            sb.append(c(iNumberOfTrailingZeros));
            if (iB != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String u() {
        return f862a.u(this.f863b);
    }
}
