package f;

import d.aa;
import d.r;
import d.v;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class i<T> {

    static final class a<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f.e<T, aa> f6539a;

        a(f.e<T, aa> eVar) {
            this.f6539a = eVar;
        }

        @Override // f.i
        void a(f.k kVar, T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                kVar.a(this.f6539a.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    static final class b<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f.e<T, String> f6541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f6542c;

        b(String str, f.e<T, String> eVar, boolean z) {
            this.f6540a = (String) o.a(str, "name == null");
            this.f6541b = eVar;
            this.f6542c = z;
        }

        @Override // f.i
        void a(f.k kVar, T t) throws IOException {
            if (t == null) {
                return;
            }
            kVar.c(this.f6540a, this.f6541b.a(t), this.f6542c);
        }
    }

    static final class c<T> extends i<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f.e<T, String> f6543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6544b;

        c(f.e<T, String> eVar, boolean z) {
            this.f6543a = eVar;
            this.f6544b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // f.i
        public void a(f.k kVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                kVar.c(key, this.f6543a.a(value), this.f6544b);
            }
        }
    }

    static final class d<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f.e<T, String> f6546b;

        d(String str, f.e<T, String> eVar) {
            this.f6545a = (String) o.a(str, "name == null");
            this.f6546b = eVar;
        }

        @Override // f.i
        void a(f.k kVar, T t) throws IOException {
            if (t == null) {
                return;
            }
            kVar.a(this.f6545a, this.f6546b.a(t));
        }
    }

    static final class e<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f6547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f.e<T, aa> f6548b;

        e(r rVar, f.e<T, aa> eVar) {
            this.f6547a = rVar;
            this.f6548b = eVar;
        }

        @Override // f.i
        void a(f.k kVar, T t) {
            if (t == null) {
                return;
            }
            try {
                kVar.a(this.f6547a, this.f6548b.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    static final class f<T> extends i<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f.e<T, aa> f6549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6550b;

        f(f.e<T, aa> eVar, String str) {
            this.f6549a = eVar;
            this.f6550b = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // f.i
        public void a(f.k kVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                kVar.a(r.a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f6550b), this.f6549a.a(value));
            }
        }
    }

    static final class g<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f.e<T, String> f6552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f6553c;

        g(String str, f.e<T, String> eVar, boolean z) {
            this.f6551a = (String) o.a(str, "name == null");
            this.f6552b = eVar;
            this.f6553c = z;
        }

        @Override // f.i
        void a(f.k kVar, T t) throws IOException {
            if (t == null) {
                throw new IllegalArgumentException("Path parameter \"" + this.f6551a + "\" value must not be null.");
            }
            kVar.a(this.f6551a, this.f6552b.a(t), this.f6553c);
        }
    }

    static final class h<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f.e<T, String> f6555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f6556c;

        h(String str, f.e<T, String> eVar, boolean z) {
            this.f6554a = (String) o.a(str, "name == null");
            this.f6555b = eVar;
            this.f6556c = z;
        }

        @Override // f.i
        void a(f.k kVar, T t) throws IOException {
            if (t == null) {
                return;
            }
            kVar.b(this.f6554a, this.f6555b.a(t), this.f6556c);
        }
    }

    /* JADX INFO: renamed from: f.i$i, reason: collision with other inner class name */
    static final class C0212i<T> extends i<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f.e<T, String> f6557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6558b;

        C0212i(f.e<T, String> eVar, boolean z) {
            this.f6557a = eVar;
            this.f6558b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // f.i
        public void a(f.k kVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                kVar.b(key, this.f6557a.a(value), this.f6558b);
            }
        }
    }

    static final class j extends i<v.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final j f6559a = new j();

        private j() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // f.i
        public void a(f.k kVar, v.b bVar) throws IOException {
            if (bVar != null) {
                kVar.a(bVar);
            }
        }
    }

    static final class k extends i<Object> {
        k() {
        }

        @Override // f.i
        void a(f.k kVar, Object obj) {
            kVar.a(obj);
        }
    }

    i() {
    }

    final i<Iterable<T>> a() {
        return new i<Iterable<T>>() { // from class: f.i.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // f.i
            public void a(f.k kVar, Iterable<T> iterable) throws IOException {
                if (iterable == null) {
                    return;
                }
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    i.this.a(kVar, it.next());
                }
            }
        };
    }

    abstract void a(f.k kVar, T t) throws IOException;

    final i<Object> b() {
        return new i<Object>() { // from class: f.i.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // f.i
            void a(f.k kVar, Object obj) throws IOException {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    i.this.a(kVar, Array.get(obj, i));
                }
            }
        };
    }
}
