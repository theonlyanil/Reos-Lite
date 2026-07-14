package f;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class f extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c.a f6508a = new f();

    f() {
    }

    @Override // f.c.a
    public c<?> a(Type type, Annotation[] annotationArr, m mVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type typeE = o.e(type);
        return new c<b<?>>() { // from class: f.f.1
            @Override // f.c
            public Type a() {
                return typeE;
            }

            @Override // f.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public <R> b<R> a(b<R> bVar) {
                return bVar;
            }
        };
    }
}
