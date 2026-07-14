package com.a.a.j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Queue<c> f2505a = h.a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f2506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IOException f2507c;

    c() {
    }

    public static c a(InputStream inputStream) {
        c cVarPoll;
        synchronized (f2505a) {
            cVarPoll = f2505a.poll();
        }
        if (cVarPoll == null) {
            cVarPoll = new c();
        }
        cVarPoll.b(inputStream);
        return cVarPoll;
    }

    public IOException a() {
        return this.f2507c;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f2506b.available();
    }

    public void b() {
        this.f2507c = null;
        this.f2506b = null;
        synchronized (f2505a) {
            f2505a.offer(this);
        }
    }

    void b(InputStream inputStream) {
        this.f2506b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2506b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f2506b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f2506b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f2506b.read();
        } catch (IOException e2) {
            this.f2507c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f2506b.read(bArr);
        } catch (IOException e2) {
            this.f2507c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f2506b.read(bArr, i, i2);
        } catch (IOException e2) {
            this.f2507c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f2506b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.f2506b.skip(j);
        } catch (IOException e2) {
            this.f2507c = e2;
            return 0L;
        }
    }
}
