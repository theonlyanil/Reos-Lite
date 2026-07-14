package f;

import d.aa;
import d.ac;
import f.b.u;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class a extends f.e.a {

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    static final class C0210a implements f.e<ac, ac> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0210a f6495a = new C0210a();

        C0210a() {
        }

        @Override // f.e
        public ac a(ac acVar) throws IOException {
            try {
                return o.a(acVar);
            } finally {
                acVar.close();
            }
        }
    }

    static final class b implements f.e<aa, aa> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f6496a = new b();

        b() {
        }

        @Override // f.e
        public aa a(aa aaVar) throws IOException {
            return aaVar;
        }
    }

    static final class c implements f.e<ac, ac> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f6497a = new c();

        c() {
        }

        @Override // f.e
        public ac a(ac acVar) throws IOException {
            return acVar;
        }
    }

    static final class d implements f.e<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f6498a = new d();

        d() {
        }

        @Override // f.e
        public String a(String str) throws IOException {
            return str;
        }
    }

    static final class e implements f.e<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f6499a = new e();

        e() {
        }

        @Override // f.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            return obj.toString();
        }
    }

    static final class f implements f.e<ac, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f6500a = new f();

        f() {
        }

        @Override // f.e
        public Void a(ac acVar) throws IOException {
            acVar.close();
            return null;
        }
    }

    a() {
    }

    @Override // f.e.a
    public f.e<ac, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        if (type == ac.class) {
            return o.a(annotationArr, (Class<? extends Annotation>) u.class) ? c.f6497a : C0210a.f6495a;
        }
        if (type == Void.class) {
            return f.f6500a;
        }
        return null;
    }

    @Override // f.e.a
    public f.e<?, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        if (aa.class.isAssignableFrom(o.a(type))) {
            return b.f6496a;
        }
        return null;
    }

    @Override // f.e.a
    public f.e<?, String> b(Type type, Annotation[] annotationArr, m mVar) {
        if (type == String.class) {
            return d.f6498a;
        }
        return null;
    }
}
