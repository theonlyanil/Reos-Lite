package com.facebook;

import android.os.Handler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class z extends FilterOutputStream implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<GraphRequest, ac> f4174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f4175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f4176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4179f;
    private ac g;

    z(OutputStream outputStream, q qVar, Map<GraphRequest, ac> map, long j) {
        super(outputStream);
        this.f4175b = qVar;
        this.f4174a = map;
        this.f4179f = j;
        this.f4176c = m.h();
    }

    private void a() {
        if (this.f4177d > this.f4178e) {
            for (q.a aVar : this.f4175b.e()) {
                if (aVar instanceof q.b) {
                    Handler handlerC = this.f4175b.c();
                    final q.b bVar = (q.b) aVar;
                    if (handlerC == null) {
                        bVar.a(this.f4175b, this.f4177d, this.f4179f);
                    } else {
                        handlerC.post(new Runnable() { // from class: com.facebook.z.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bVar.a(z.this.f4175b, z.this.f4177d, z.this.f4179f);
                            }
                        });
                    }
                }
            }
            this.f4178e = this.f4177d;
        }
    }

    private void a(long j) {
        if (this.g != null) {
            this.g.a(j);
        }
        this.f4177d += j;
        if (this.f4177d >= this.f4178e + this.f4176c || this.f4177d >= this.f4179f) {
            a();
        }
    }

    @Override // com.facebook.ab
    public void a(GraphRequest graphRequest) {
        this.g = graphRequest != null ? this.f4174a.get(graphRequest) : null;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Iterator<ac> it = this.f4174a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        a();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        a(1L);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        a(bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        a(i2);
    }
}
