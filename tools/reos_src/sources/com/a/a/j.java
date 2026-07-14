package com.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.a.a.e.l;
import com.a.a.e.m;

/* JADX INFO: loaded from: classes.dex */
public class j implements com.a.a.e.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.e.g f2485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f2486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f2487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f2488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f2489f;
    private a g;

    public interface a {
        <T> void a(e<T, ?, ?, ?> eVar);
    }

    public final class b<A, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.a.a.d.c.l<A, T> f2493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<T> f2494c;

        public final class a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final A f2496b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Class<A> f2497c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final boolean f2498d = true;

            a(A a2) {
                this.f2496b = a2;
                this.f2497c = j.b(a2);
            }

            public <Z> f<A, T, Z> a(Class<Z> cls) {
                f<A, T, Z> fVar = (f) j.this.f2489f.a(new f(j.this.f2484a, j.this.f2488e, this.f2497c, b.this.f2493b, b.this.f2494c, cls, j.this.f2487d, j.this.f2485b, j.this.f2489f));
                if (this.f2498d) {
                    fVar.b(this.f2496b);
                }
                return fVar;
            }
        }

        b(com.a.a.d.c.l<A, T> lVar, Class<T> cls) {
            this.f2493b = lVar;
            this.f2494c = cls;
        }

        public b<A, T>.a a(A a2) {
            return new a(a2);
        }
    }

    class c {
        c() {
        }

        public <A, X extends e<A, ?, ?, ?>> X a(X x) {
            if (j.this.g != null) {
                j.this.g.a(x);
            }
            return x;
        }
    }

    private static class d implements com.a.a.e.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m f2500a;

        public d(m mVar) {
            this.f2500a = mVar;
        }

        @Override // com.a.a.e.c.a
        public void a(boolean z) {
            if (z) {
                this.f2500a.d();
            }
        }
    }

    public j(Context context, com.a.a.e.g gVar, l lVar) {
        this(context, gVar, lVar, new m(), new com.a.a.e.d());
    }

    j(Context context, final com.a.a.e.g gVar, l lVar, m mVar, com.a.a.e.d dVar) {
        this.f2484a = context.getApplicationContext();
        this.f2485b = gVar;
        this.f2486c = lVar;
        this.f2487d = mVar;
        this.f2488e = g.a(context);
        this.f2489f = new c();
        com.a.a.e.c cVarA = dVar.a(context, new d(mVar));
        if (com.a.a.j.h.d()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.a.a.j.1
                @Override // java.lang.Runnable
                public void run() {
                    gVar.a(j.this);
                }
            });
        } else {
            gVar.a(this);
        }
        gVar.a(cVarA);
    }

    private <T> com.a.a.d<T> a(Class<T> cls) {
        com.a.a.d.c.l lVarA = g.a(cls, this.f2484a);
        com.a.a.d.c.l lVarB = g.b(cls, this.f2484a);
        if (cls != null && lVarA == null && lVarB == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (com.a.a.d) this.f2489f.a(new com.a.a.d(cls, lVarA, lVarB, this.f2484a, this.f2488e, this.f2487d, this.f2485b, this.f2489f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Class<T> b(T t) {
        if (t != null) {
            return (Class<T>) t.getClass();
        }
        return null;
    }

    public com.a.a.d<Integer> a(Integer num) {
        return (com.a.a.d) h().b(num);
    }

    public com.a.a.d<String> a(String str) {
        return (com.a.a.d) g().b(str);
    }

    public <A, T> b<A, T> a(com.a.a.d.c.l<A, T> lVar, Class<T> cls) {
        return new b<>(lVar, cls);
    }

    public void a() {
        this.f2488e.i();
    }

    public void a(int i) {
        this.f2488e.a(i);
    }

    public void b() {
        com.a.a.j.h.a();
        this.f2487d.a();
    }

    public void c() {
        com.a.a.j.h.a();
        this.f2487d.b();
    }

    @Override // com.a.a.e.h
    public void d() {
        c();
    }

    @Override // com.a.a.e.h
    public void e() {
        b();
    }

    @Override // com.a.a.e.h
    public void f() {
        this.f2487d.c();
    }

    public com.a.a.d<String> g() {
        return a(String.class);
    }

    public com.a.a.d<Integer> h() {
        return (com.a.a.d) a(Integer.class).b(com.a.a.i.a.a(this.f2484a));
    }
}
