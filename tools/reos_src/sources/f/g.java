package f;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class g extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Executor f6511a;

    static final class a<T> implements b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Executor f6514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T> f6515b;

        a(Executor executor, b<T> bVar) {
            this.f6514a = executor;
            this.f6515b = bVar;
        }

        @Override // f.b
        public void a(final d<T> dVar) {
            if (dVar == null) {
                throw new NullPointerException("callback == null");
            }
            this.f6515b.a(new d<T>() { // from class: f.g.a.1
                @Override // f.d
                public void a(final b<T> bVar, final l<T> lVar) {
                    a.this.f6514a.execute(new Runnable() { // from class: f.g.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.f6515b.a()) {
                                dVar.a(bVar, new IOException("Canceled"));
                            } else {
                                dVar.a(bVar, lVar);
                            }
                        }
                    });
                }

                @Override // f.d
                public void a(final b<T> bVar, final Throwable th) {
                    a.this.f6514a.execute(new Runnable() { // from class: f.g.a.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            dVar.a(bVar, th);
                        }
                    });
                }
            });
        }

        @Override // f.b
        public boolean a() {
            return this.f6515b.a();
        }

        @Override // f.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b<T> clone() {
            return new a(this.f6514a, this.f6515b.clone());
        }
    }

    g(Executor executor) {
        this.f6511a = executor;
    }

    @Override // f.c.a
    public c<b<?>> a(Type type, Annotation[] annotationArr, m mVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type typeE = o.e(type);
        return new c<b<?>>() { // from class: f.g.1
            @Override // f.c
            public Type a() {
                return typeE;
            }

            @Override // f.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public <R> b<R> a(b<R> bVar) {
                return new a(g.this.f6511a, bVar);
            }
        };
    }
}
