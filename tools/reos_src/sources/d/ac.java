package d;

import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class ac implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Reader f6243a;

    public static ac a(final u uVar, final long j, final e.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new ac() { // from class: d.ac.1
            @Override // d.ac
            public u a() {
                return uVar;
            }

            @Override // d.ac
            public long b() {
                return j;
            }

            @Override // d.ac
            public e.e c() {
                return eVar;
            }
        };
    }

    private Charset f() {
        u uVarA = a();
        return uVarA != null ? uVarA.a(d.a.j.f6220c) : d.a.j.f6220c;
    }

    public abstract u a();

    public abstract long b();

    public abstract e.e c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.a.j.a(c());
    }

    public final InputStream d() {
        return c().h();
    }

    public final Reader e() {
        Reader reader = this.f6243a;
        if (reader != null) {
            return reader;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(d(), f());
        this.f6243a = inputStreamReader;
        return inputStreamReader;
    }
}
