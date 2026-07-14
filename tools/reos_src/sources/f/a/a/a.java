package f.a.a;

import com.google.a.f;
import d.aa;
import d.ac;
import f.e;
import f.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f6501a;

    private a(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("gson == null");
        }
        this.f6501a = fVar;
    }

    public static a a() {
        return a(new f());
    }

    public static a a(f fVar) {
        return new a(fVar);
    }

    @Override // f.e.a
    public e<ac, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        return new c(this.f6501a, this.f6501a.a((com.google.a.c.a) com.google.a.c.a.get(type)));
    }

    @Override // f.e.a
    public e<?, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        return new b(this.f6501a, this.f6501a.a((com.google.a.c.a) com.google.a.c.a.get(type)));
    }
}
