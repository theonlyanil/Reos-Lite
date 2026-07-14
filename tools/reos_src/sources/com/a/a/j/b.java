package com.a.a.j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f2503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2504b;

    b(InputStream inputStream, long j) {
        super(inputStream);
        this.f2503a = j;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.f2504b += i;
        } else if (this.f2503a - ((long) this.f2504b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f2503a + ", but read: " + this.f2504b);
        }
        return i;
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f2503a - ((long) this.f2504b), this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        return a(super.read());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return a(super.read(bArr, i, i2));
    }
}
