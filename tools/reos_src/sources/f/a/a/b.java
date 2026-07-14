package f.a.a;

import com.google.a.f;
import com.google.a.x;
import d.aa;
import d.u;
import f.e;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class b<T> implements e<T, aa> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final u f6502a = u.a("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f6503b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f6504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<T> f6505d;

    b(f fVar, x<T> xVar) {
        this.f6504c = fVar;
        this.f6505d = xVar;
    }

    @Override // f.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa a(T t) throws IOException {
        e.c cVar = new e.c();
        com.google.a.d.c cVarA = this.f6504c.a((Writer) new OutputStreamWriter(cVar.d(), f6503b));
        this.f6505d.a(cVarA, t);
        cVarA.close();
        return aa.a(f6502a, cVar.q());
    }
}
