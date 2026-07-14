package f;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface c<T> {

    public static abstract class a {
        protected static Class<?> a(Type type) {
            return o.a(type);
        }

        public abstract c<?> a(Type type, Annotation[] annotationArr, m mVar);
    }

    <R> T a(b<R> bVar);

    Type a();
}
