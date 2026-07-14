package com.google.a.b.a;

import com.google.a.n;
import com.google.a.o;
import com.google.a.r;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f extends com.google.a.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Writer f5097a = new Writer() { // from class: com.google.a.b.a.f.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final r f5098b = new r("closed");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.google.a.l> f5099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.a.l f5101e;

    public f() {
        super(f5097a);
        this.f5099c = new ArrayList();
        this.f5101e = n.f5272a;
    }

    private void a(com.google.a.l lVar) {
        if (this.f5100d != null) {
            if (!lVar.j() || i()) {
                ((o) j()).a(this.f5100d, lVar);
            }
            this.f5100d = null;
            return;
        }
        if (this.f5099c.isEmpty()) {
            this.f5101e = lVar;
            return;
        }
        com.google.a.l lVarJ = j();
        if (!(lVarJ instanceof com.google.a.i)) {
            throw new IllegalStateException();
        }
        ((com.google.a.i) lVarJ).a(lVar);
    }

    private com.google.a.l j() {
        return this.f5099c.get(this.f5099c.size() - 1);
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c a(long j) throws IOException {
        a(new r(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new r(number));
        return this;
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c a(String str) throws IOException {
        if (this.f5099c.isEmpty() || this.f5100d != null) {
            throw new IllegalStateException();
        }
        if (!(j() instanceof o)) {
            throw new IllegalStateException();
        }
        this.f5100d = str;
        return this;
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c a(boolean z) throws IOException {
        a(new r(Boolean.valueOf(z)));
        return this;
    }

    public com.google.a.l a() {
        if (this.f5099c.isEmpty()) {
            return this.f5101e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f5099c);
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c b() throws IOException {
        com.google.a.i iVar = new com.google.a.i();
        a(iVar);
        this.f5099c.add(iVar);
        return this;
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        a(new r(str));
        return this;
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c c() throws IOException {
        if (this.f5099c.isEmpty() || this.f5100d != null) {
            throw new IllegalStateException();
        }
        if (!(j() instanceof com.google.a.i)) {
            throw new IllegalStateException();
        }
        this.f5099c.remove(this.f5099c.size() - 1);
        return this;
    }

    @Override // com.google.a.d.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f5099c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f5099c.add(f5098b);
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c d() throws IOException {
        o oVar = new o();
        a(oVar);
        this.f5099c.add(oVar);
        return this;
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c e() throws IOException {
        if (this.f5099c.isEmpty() || this.f5100d != null) {
            throw new IllegalStateException();
        }
        if (!(j() instanceof o)) {
            throw new IllegalStateException();
        }
        this.f5099c.remove(this.f5099c.size() - 1);
        return this;
    }

    @Override // com.google.a.d.c
    public com.google.a.d.c f() throws IOException {
        a(n.f5272a);
        return this;
    }

    @Override // com.google.a.d.c, java.io.Flushable
    public void flush() throws IOException {
    }
}
