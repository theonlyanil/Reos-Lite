package f;

import d.aa;
import d.ac;
import d.s;
import d.w;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Method, n> f6575a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.e.a f6576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f6577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<e.a> f6578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<c.a> f6579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f6580f;
    private final boolean g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private j f6584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d.e.a f6585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private s f6586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<e.a> f6587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<c.a> f6588e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Executor f6589f;
        private boolean g;

        public a() {
            this(j.a());
        }

        a(j jVar) {
            this.f6587d = new ArrayList();
            this.f6588e = new ArrayList();
            this.f6584a = jVar;
            this.f6587d.add(new f.a());
        }

        public a a(d.e.a aVar) {
            this.f6585b = (d.e.a) o.a(aVar, "factory == null");
            return this;
        }

        public a a(s sVar) {
            o.a(sVar, "baseUrl == null");
            List<String> listJ = sVar.j();
            if (!"".equals(listJ.get(listJ.size() - 1))) {
                throw new IllegalArgumentException("baseUrl must end in /: " + sVar);
            }
            this.f6586c = sVar;
            return this;
        }

        public a a(w wVar) {
            return a((d.e.a) o.a(wVar, "client == null"));
        }

        public a a(e.a aVar) {
            this.f6587d.add((e.a) o.a(aVar, "factory == null"));
            return this;
        }

        public a a(String str) {
            o.a(str, "baseUrl == null");
            s sVarE = s.e(str);
            if (sVarE == null) {
                throw new IllegalArgumentException("Illegal URL: " + str);
            }
            return a(sVarE);
        }

        public m a() {
            if (this.f6586c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            d.e.a wVar = this.f6585b;
            if (wVar == null) {
                wVar = new w();
            }
            Executor executorB = this.f6589f;
            if (executorB == null) {
                executorB = this.f6584a.b();
            }
            ArrayList arrayList = new ArrayList(this.f6588e);
            arrayList.add(this.f6584a.a(executorB));
            return new m(wVar, this.f6586c, new ArrayList(this.f6587d), arrayList, executorB, this.g);
        }
    }

    m(d.e.a aVar, s sVar, List<e.a> list, List<c.a> list2, Executor executor, boolean z) {
        this.f6576b = aVar;
        this.f6577c = sVar;
        this.f6578d = Collections.unmodifiableList(list);
        this.f6579e = Collections.unmodifiableList(list2);
        this.f6580f = executor;
        this.g = z;
    }

    private void b(Class<?> cls) {
        j jVarA = j.a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!jVarA.a(method)) {
                a(method);
            }
        }
    }

    public d.e.a a() {
        return this.f6576b;
    }

    public c<?> a(c.a aVar, Type type, Annotation[] annotationArr) {
        o.a(type, "returnType == null");
        o.a(annotationArr, "annotations == null");
        int iIndexOf = this.f6579e.indexOf(aVar) + 1;
        int size = this.f6579e.size();
        for (int i = iIndexOf; i < size; i++) {
            c<?> cVarA = this.f6579e.get(i).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate call adapter for ").append(type).append(".\n");
        if (aVar != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.f6579e.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.f6579e.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.f6579e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public c<?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public <T> e<ac, T> a(e.a aVar, Type type, Annotation[] annotationArr) {
        o.a(type, "type == null");
        o.a(annotationArr, "annotations == null");
        int iIndexOf = this.f6578d.indexOf(aVar) + 1;
        int size = this.f6578d.size();
        for (int i = iIndexOf; i < size; i++) {
            e<ac, T> eVar = (e<ac, T>) this.f6578d.get(i).a(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate ResponseBody converter for ").append(type).append(".\n");
        if (aVar != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.f6578d.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.f6578d.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.f6578d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public <T> e<T, aa> a(e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        o.a(type, "type == null");
        o.a(annotationArr, "parameterAnnotations == null");
        o.a(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f6578d.indexOf(aVar) + 1;
        int size = this.f6578d.size();
        for (int i = iIndexOf; i < size; i++) {
            e<T, aa> eVar = (e<T, aa>) this.f6578d.get(i).a(type, annotationArr, annotationArr2, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate RequestBody converter for ").append(type).append(".\n");
        if (aVar != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.f6578d.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.f6578d.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.f6578d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public <T> e<T, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    n a(Method method) {
        n nVarA;
        synchronized (this.f6575a) {
            nVarA = this.f6575a.get(method);
            if (nVarA == null) {
                nVarA = new n.a(this, method).a();
                this.f6575a.put(method, nVarA);
            }
        }
        return nVarA;
    }

    public <T> T a(final Class<T> cls) {
        o.a((Class) cls);
        if (this.g) {
            b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: f.m.1

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final j f6583c = j.a();

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object... objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.f6583c.a(method)) {
                    return this.f6583c.a(method, cls, obj, objArr);
                }
                n nVarA = m.this.a(method);
                return nVarA.f6593d.a(new h(nVarA, objArr));
            }
        });
    }

    public s b() {
        return this.f6577c;
    }

    public <T> e<ac, T> b(Type type, Annotation[] annotationArr) {
        return a((e.a) null, type, annotationArr);
    }

    public <T> e<T, String> c(Type type, Annotation[] annotationArr) {
        o.a(type, "type == null");
        o.a(annotationArr, "annotations == null");
        int size = this.f6578d.size();
        for (int i = 0; i < size; i++) {
            e<T, String> eVar = (e<T, String>) this.f6578d.get(i).b(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        return f.a.e.f6499a;
    }
}
