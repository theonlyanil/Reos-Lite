package com.google.a.b.a;

import com.google.a.n;
import com.google.a.o;
import com.google.a.r;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e extends com.google.a.d.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Reader f5094b = new Reader() { // from class: com.google.a.b.a.e.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f5095c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Object> f5096d;

    private void a(com.google.a.d.b bVar) throws IOException {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f());
        }
    }

    private Object u() {
        return this.f5096d.get(this.f5096d.size() - 1);
    }

    private Object v() {
        return this.f5096d.remove(this.f5096d.size() - 1);
    }

    @Override // com.google.a.d.a
    public void a() throws IOException {
        a(com.google.a.d.b.BEGIN_ARRAY);
        this.f5096d.add(((com.google.a.i) u()).iterator());
    }

    @Override // com.google.a.d.a
    public void b() throws IOException {
        a(com.google.a.d.b.END_ARRAY);
        v();
        v();
    }

    @Override // com.google.a.d.a
    public void c() throws IOException {
        a(com.google.a.d.b.BEGIN_OBJECT);
        this.f5096d.add(((o) u()).o().iterator());
    }

    @Override // com.google.a.d.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5096d.clear();
        this.f5096d.add(f5095c);
    }

    @Override // com.google.a.d.a
    public void d() throws IOException {
        a(com.google.a.d.b.END_OBJECT);
        v();
        v();
    }

    @Override // com.google.a.d.a
    public boolean e() throws IOException {
        com.google.a.d.b bVarF = f();
        return (bVarF == com.google.a.d.b.END_OBJECT || bVarF == com.google.a.d.b.END_ARRAY) ? false : true;
    }

    @Override // com.google.a.d.a
    public com.google.a.d.b f() throws IOException {
        if (this.f5096d.isEmpty()) {
            return com.google.a.d.b.END_DOCUMENT;
        }
        Object objU = u();
        if (objU instanceof Iterator) {
            boolean z = this.f5096d.get(this.f5096d.size() - 2) instanceof o;
            Iterator it = (Iterator) objU;
            if (!it.hasNext()) {
                return z ? com.google.a.d.b.END_OBJECT : com.google.a.d.b.END_ARRAY;
            }
            if (z) {
                return com.google.a.d.b.NAME;
            }
            this.f5096d.add(it.next());
            return f();
        }
        if (objU instanceof o) {
            return com.google.a.d.b.BEGIN_OBJECT;
        }
        if (objU instanceof com.google.a.i) {
            return com.google.a.d.b.BEGIN_ARRAY;
        }
        if (!(objU instanceof r)) {
            if (objU instanceof n) {
                return com.google.a.d.b.NULL;
            }
            if (objU == f5095c) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        r rVar = (r) objU;
        if (rVar.q()) {
            return com.google.a.d.b.STRING;
        }
        if (rVar.o()) {
            return com.google.a.d.b.BOOLEAN;
        }
        if (rVar.p()) {
            return com.google.a.d.b.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.google.a.d.a
    public String g() throws IOException {
        a(com.google.a.d.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) u()).next();
        this.f5096d.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.google.a.d.a
    public String h() throws IOException {
        com.google.a.d.b bVarF = f();
        if (bVarF == com.google.a.d.b.STRING || bVarF == com.google.a.d.b.NUMBER) {
            return ((r) v()).b();
        }
        throw new IllegalStateException("Expected " + com.google.a.d.b.STRING + " but was " + bVarF);
    }

    @Override // com.google.a.d.a
    public boolean i() throws IOException {
        a(com.google.a.d.b.BOOLEAN);
        return ((r) v()).f();
    }

    @Override // com.google.a.d.a
    public void j() throws IOException {
        a(com.google.a.d.b.NULL);
        v();
    }

    @Override // com.google.a.d.a
    public double k() throws IOException {
        com.google.a.d.b bVarF = f();
        if (bVarF != com.google.a.d.b.NUMBER && bVarF != com.google.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.google.a.d.b.NUMBER + " but was " + bVarF);
        }
        double dC = ((r) u()).c();
        if (!p() && (Double.isNaN(dC) || Double.isInfinite(dC))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dC);
        }
        v();
        return dC;
    }

    @Override // com.google.a.d.a
    public long l() throws IOException {
        com.google.a.d.b bVarF = f();
        if (bVarF != com.google.a.d.b.NUMBER && bVarF != com.google.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.google.a.d.b.NUMBER + " but was " + bVarF);
        }
        long jD = ((r) u()).d();
        v();
        return jD;
    }

    @Override // com.google.a.d.a
    public int m() throws IOException {
        com.google.a.d.b bVarF = f();
        if (bVarF != com.google.a.d.b.NUMBER && bVarF != com.google.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.google.a.d.b.NUMBER + " but was " + bVarF);
        }
        int iE = ((r) u()).e();
        v();
        return iE;
    }

    @Override // com.google.a.d.a
    public void n() throws IOException {
        if (f() == com.google.a.d.b.NAME) {
            g();
        } else {
            v();
        }
    }

    public void o() throws IOException {
        a(com.google.a.d.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) u()).next();
        this.f5096d.add(entry.getValue());
        this.f5096d.add(new r((String) entry.getKey()));
    }

    @Override // com.google.a.d.a
    public String toString() {
        return getClass().getSimpleName();
    }
}
