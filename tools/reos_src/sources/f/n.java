package f;

import d.aa;
import d.ab;
import d.ac;
import d.r;
import d.s;
import d.u;
import d.z;
import f.b.p;
import f.b.q;
import f.b.t;
import f.b.v;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f6590a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Pattern f6591b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final d.e.a f6592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final c<?> f6593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s f6594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e<ac, T> f6595f;
    private final String g;
    private final String h;
    private final r i;
    private final u j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final i<?>[] n;

    static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final m f6596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f6597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Annotation[] f6598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[][] f6599d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Type[] f6600e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Type f6601f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        String m;
        boolean n;
        boolean o;
        boolean p;
        String q;
        r r;
        u s;
        Set<String> t;
        i<?>[] u;
        e<ac, T> v;
        c<?> w;

        public a(m mVar, Method method) {
            this.f6596a = mVar;
            this.f6597b = method;
            this.f6598c = method.getAnnotations();
            this.f6600e = method.getGenericParameterTypes();
            this.f6599d = method.getParameterAnnotations();
        }

        private r a(String[] strArr) {
            r.a aVar = new r.a();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    this.s = u.a(strTrim);
                } else {
                    aVar.a(strSubstring, strTrim);
                }
            }
            return aVar.a();
        }

        private i<?> a(int i, Type type, Annotation[] annotationArr) {
            i<?> iVar = null;
            for (Annotation annotation : annotationArr) {
                i<?> iVarA = a(i, type, annotationArr, annotation);
                if (iVarA != null) {
                    if (iVar != null) {
                        throw a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    iVar = iVarA;
                }
            }
            if (iVar == null) {
                throw a(i, "No Retrofit annotation found.", new Object[0]);
            }
            return iVar;
        }

        private i<?> a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof v) {
                if (this.l) {
                    throw a(i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.j) {
                    throw a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.k) {
                    throw a(i, "A @Url parameter must not come after a @Query", new Object[0]);
                }
                if (this.q != null) {
                    throw a(i, "@Url cannot be used with @%s URL", this.m);
                }
                this.l = true;
                if (type == s.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new i.k();
                }
                throw a(i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof f.b.r) {
                if (this.k) {
                    throw a(i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.l) {
                    throw a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.q == null) {
                    throw a(i, "@Path can only be used with relative url on @%s", this.m);
                }
                this.j = true;
                f.b.r rVar = (f.b.r) annotation;
                String strA = rVar.a();
                a(i, strA);
                return new i.g(strA, this.f6596a.c(type, annotationArr), rVar.b());
            }
            if (annotation instanceof f.b.s) {
                f.b.s sVar = (f.b.s) annotation;
                String strA2 = sVar.a();
                boolean zB = sVar.b();
                Class<?> clsA = o.a(type);
                this.k = true;
                if (!Iterable.class.isAssignableFrom(clsA)) {
                    return clsA.isArray() ? new i.h(strA2, this.f6596a.c(n.a(clsA.getComponentType()), annotationArr), zB).b() : new i.h(strA2, this.f6596a.c(type, annotationArr), zB);
                }
                if (type instanceof ParameterizedType) {
                    return new i.h(strA2, this.f6596a.c(o.a(0, (ParameterizedType) type), annotationArr), zB).a();
                }
                throw a(i, clsA.getSimpleName() + " must include generic type (e.g., " + clsA.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof t) {
                Class<?> clsA2 = o.a(type);
                if (!Map.class.isAssignableFrom(clsA2)) {
                    throw a(i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeB = o.b(type, clsA2, Map.class);
                if (!(typeB instanceof ParameterizedType)) {
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeB;
                Type typeA = o.a(0, parameterizedType);
                if (String.class != typeA) {
                    throw a(i, "@QueryMap keys must be of type String: " + typeA, new Object[0]);
                }
                return new i.C0212i(this.f6596a.c(o.a(1, parameterizedType), annotationArr), ((t) annotation).a());
            }
            if (annotation instanceof f.b.i) {
                String strA3 = ((f.b.i) annotation).a();
                Class<?> clsA3 = o.a(type);
                if (!Iterable.class.isAssignableFrom(clsA3)) {
                    return clsA3.isArray() ? new i.d(strA3, this.f6596a.c(n.a(clsA3.getComponentType()), annotationArr)).b() : new i.d(strA3, this.f6596a.c(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new i.d(strA3, this.f6596a.c(o.a(0, (ParameterizedType) type), annotationArr)).a();
                }
                throw a(i, clsA3.getSimpleName() + " must include generic type (e.g., " + clsA3.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof f.b.c) {
                if (!this.o) {
                    throw a(i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                f.b.c cVar = (f.b.c) annotation;
                String strA4 = cVar.a();
                boolean zB2 = cVar.b();
                this.g = true;
                Class<?> clsA4 = o.a(type);
                if (!Iterable.class.isAssignableFrom(clsA4)) {
                    return clsA4.isArray() ? new i.b(strA4, this.f6596a.c(n.a(clsA4.getComponentType()), annotationArr), zB2).b() : new i.b(strA4, this.f6596a.c(type, annotationArr), zB2);
                }
                if (type instanceof ParameterizedType) {
                    return new i.b(strA4, this.f6596a.c(o.a(0, (ParameterizedType) type), annotationArr), zB2).a();
                }
                throw a(i, clsA4.getSimpleName() + " must include generic type (e.g., " + clsA4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof f.b.d) {
                if (!this.o) {
                    throw a(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsA5 = o.a(type);
                if (!Map.class.isAssignableFrom(clsA5)) {
                    throw a(i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeB2 = o.b(type, clsA5, Map.class);
                if (!(typeB2 instanceof ParameterizedType)) {
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeB2;
                Type typeA2 = o.a(0, parameterizedType2);
                if (String.class != typeA2) {
                    throw a(i, "@FieldMap keys must be of type String: " + typeA2, new Object[0]);
                }
                e<T, String> eVarC = this.f6596a.c(o.a(1, parameterizedType2), annotationArr);
                this.g = true;
                return new i.c(eVarC, ((f.b.d) annotation).a());
            }
            if (!(annotation instanceof p)) {
                if (!(annotation instanceof q)) {
                    if (!(annotation instanceof f.b.a)) {
                        return null;
                    }
                    if (this.o || this.p) {
                        throw a(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                    }
                    if (this.i) {
                        throw a(i, "Multiple @Body method annotations found.", new Object[0]);
                    }
                    try {
                        e<T, aa> eVarA = this.f6596a.a(type, annotationArr, this.f6598c);
                        this.i = true;
                        return new i.a(eVarA);
                    } catch (RuntimeException e2) {
                        throw a(e2, i, "Unable to create @Body converter for %s", type);
                    }
                }
                if (!this.p) {
                    throw a(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.h = true;
                Class<?> clsA6 = o.a(type);
                if (!Map.class.isAssignableFrom(clsA6)) {
                    throw a(i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeB3 = o.b(type, clsA6, Map.class);
                if (!(typeB3 instanceof ParameterizedType)) {
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeB3;
                Type typeA3 = o.a(0, parameterizedType3);
                if (String.class != typeA3) {
                    throw a(i, "@PartMap keys must be of type String: " + typeA3, new Object[0]);
                }
                Type typeA4 = o.a(1, parameterizedType3);
                if (d.v.b.class.isAssignableFrom(o.a(typeA4))) {
                    throw a(i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new i.f(this.f6596a.a(typeA4, annotationArr, this.f6598c), ((q) annotation).a());
            }
            if (!this.p) {
                throw a(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            p pVar = (p) annotation;
            this.h = true;
            String strA5 = pVar.a();
            Class<?> clsA7 = o.a(type);
            if (strA5.isEmpty()) {
                if (Iterable.class.isAssignableFrom(clsA7)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw a(i, clsA7.getSimpleName() + " must include generic type (e.g., " + clsA7.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (d.v.b.class.isAssignableFrom(o.a(o.a(0, (ParameterizedType) type)))) {
                        return i.j.f6559a.a();
                    }
                    throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (clsA7.isArray()) {
                    if (d.v.b.class.isAssignableFrom(clsA7.getComponentType())) {
                        return i.j.f6559a.b();
                    }
                    throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (d.v.b.class.isAssignableFrom(clsA7)) {
                    return i.j.f6559a;
                }
                throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
            }
            r rVarA = r.a("Content-Disposition", "form-data; name=\"" + strA5 + "\"", "Content-Transfer-Encoding", pVar.b());
            if (Iterable.class.isAssignableFrom(clsA7)) {
                if (!(type instanceof ParameterizedType)) {
                    throw a(i, clsA7.getSimpleName() + " must include generic type (e.g., " + clsA7.getSimpleName() + "<String>)", new Object[0]);
                }
                Type typeA5 = o.a(0, (ParameterizedType) type);
                if (d.v.b.class.isAssignableFrom(o.a(typeA5))) {
                    throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new i.e(rVarA, this.f6596a.a(typeA5, annotationArr, this.f6598c)).a();
            }
            if (!clsA7.isArray()) {
                if (d.v.b.class.isAssignableFrom(clsA7)) {
                    throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new i.e(rVarA, this.f6596a.a(type, annotationArr, this.f6598c));
            }
            Class<?> clsA8 = n.a(clsA7.getComponentType());
            if (d.v.b.class.isAssignableFrom(clsA8)) {
                throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
            }
            return new i.e(rVarA, this.f6596a.a(clsA8, annotationArr, this.f6598c)).b();
        }

        private RuntimeException a(int i, String str, Object... objArr) {
            return a(str + " (parameter #" + (i + 1) + ")", objArr);
        }

        private RuntimeException a(String str, Object... objArr) {
            return a((Throwable) null, str, objArr);
        }

        private RuntimeException a(Throwable th, int i, String str, Object... objArr) {
            return a(th, str + " (parameter #" + (i + 1) + ")", objArr);
        }

        private RuntimeException a(Throwable th, String str, Object... objArr) {
            return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.f6597b.getDeclaringClass().getSimpleName() + "." + this.f6597b.getName(), th);
        }

        private void a(int i, String str) {
            if (!n.f6591b.matcher(str).matches()) {
                throw a(i, "@Path parameter name must match %s. Found: %s", n.f6590a.pattern(), str);
            }
            if (!this.t.contains(str)) {
                throw a(i, "URL \"%s\" does not contain \"{%s}\".", this.q, str);
            }
        }

        private void a(String str, String str2, boolean z) {
            if (this.m != null) {
                throw a("Only one HTTP method is allowed. Found: %s and %s.", this.m, str);
            }
            this.m = str;
            this.n = z;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (n.f6590a.matcher(strSubstring).find()) {
                    throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.q = str2;
            this.t = n.a(str2);
        }

        private void a(Annotation annotation) {
            if (annotation instanceof f.b.b) {
                a("DELETE", ((f.b.b) annotation).a(), false);
                return;
            }
            if (annotation instanceof f.b.f) {
                a("GET", ((f.b.f) annotation).a(), false);
                return;
            }
            if (annotation instanceof f.b.g) {
                a("HEAD", ((f.b.g) annotation).a(), false);
                if (!Void.class.equals(this.f6601f)) {
                    throw a("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof f.b.m) {
                a("PATCH", ((f.b.m) annotation).a(), true);
                return;
            }
            if (annotation instanceof f.b.n) {
                a("POST", ((f.b.n) annotation).a(), true);
                return;
            }
            if (annotation instanceof f.b.o) {
                a("PUT", ((f.b.o) annotation).a(), true);
                return;
            }
            if (annotation instanceof f.b.l) {
                a("OPTIONS", ((f.b.l) annotation).a(), false);
                return;
            }
            if (annotation instanceof f.b.h) {
                f.b.h hVar = (f.b.h) annotation;
                a(hVar.a(), hVar.b(), hVar.c());
                return;
            }
            if (annotation instanceof f.b.j) {
                String[] strArrA = ((f.b.j) annotation).a();
                if (strArrA.length == 0) {
                    throw a("@Headers annotation is empty.", new Object[0]);
                }
                this.r = a(strArrA);
                return;
            }
            if (annotation instanceof f.b.k) {
                if (this.o) {
                    throw a("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.p = true;
            } else if (annotation instanceof f.b.e) {
                if (this.p) {
                    throw a("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.o = true;
            }
        }

        private c<?> b() {
            Type genericReturnType = this.f6597b.getGenericReturnType();
            if (o.d(genericReturnType)) {
                throw a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw a("Service methods cannot return void.", new Object[0]);
            }
            try {
                return this.f6596a.a(genericReturnType, this.f6597b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a(e2, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        private e<ac, T> c() {
            try {
                return this.f6596a.b(this.f6601f, this.f6597b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a(e2, "Unable to create converter for %s", this.f6601f);
            }
        }

        public n a() {
            this.w = b();
            this.f6601f = this.w.a();
            if (this.f6601f == l.class || this.f6601f == ab.class) {
                throw a("'" + o.a(this.f6601f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.v = c();
            for (Annotation annotation : this.f6598c) {
                a(annotation);
            }
            if (this.m == null) {
                throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.n) {
                if (this.p) {
                    throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.o) {
                    throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f6599d.length;
            this.u = new i[length];
            for (int i = 0; i < length; i++) {
                Type type = this.f6600e[i];
                if (o.d(type)) {
                    throw a(i, "Parameter type must not include a type variable or wildcard: %s", type);
                }
                Annotation[] annotationArr = this.f6599d[i];
                if (annotationArr == null) {
                    throw a(i, "No Retrofit annotation found.", new Object[0]);
                }
                this.u[i] = a(i, type, annotationArr);
            }
            if (this.q == null && !this.l) {
                throw a("Missing either @%s URL or @Url parameter.", this.m);
            }
            if (!this.o && !this.p && !this.n && this.i) {
                throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (this.o && !this.g) {
                throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.p || this.h) {
                return new n(this);
            }
            throw a("Multipart method must contain at least one @Part.", new Object[0]);
        }
    }

    n(a<T> aVar) {
        this.f6592c = aVar.f6596a.a();
        this.f6593d = aVar.w;
        this.f6594e = aVar.f6596a.b();
        this.f6595f = aVar.v;
        this.g = aVar.m;
        this.h = aVar.q;
        this.i = aVar.r;
        this.j = aVar.s;
        this.k = aVar.n;
        this.l = aVar.o;
        this.m = aVar.p;
        this.n = aVar.u;
    }

    static Class<?> a(Class<?> cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }

    static Set<String> a(String str) {
        Matcher matcher = f6590a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    z a(Object... objArr) throws IOException {
        k kVar = new k(this.g, this.f6594e, this.h, this.i, this.j, this.k, this.l, this.m);
        i<?>[] iVarArr = this.n;
        int length = objArr != null ? objArr.length : 0;
        if (length != iVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + iVarArr.length + ")");
        }
        for (int i = 0; i < length; i++) {
            iVarArr[i].a(kVar, objArr[i]);
        }
        return kVar.a();
    }

    T a(ac acVar) throws IOException {
        return this.f6595f.a(acVar);
    }
}
