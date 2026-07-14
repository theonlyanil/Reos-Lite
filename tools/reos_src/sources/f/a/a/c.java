package f.a.a;

import com.google.a.f;
import com.google.a.x;
import d.ac;
import f.e;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class c<T> implements e<ac, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f6506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<T> f6507b;

    c(f fVar, x<T> xVar) {
        this.f6506a = fVar;
        this.f6507b = xVar;
    }

    @Override // f.e
    public T a(ac acVar) throws IOException {
        try {
            return this.f6507b.b(this.f6506a.a(acVar.e()));
        } finally {
            acVar.close();
        }
    }
}
