package com.a.a.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f1973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f1974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f1975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1977e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f1979a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f1973a = inputStream;
        this.f1974b = charset;
        this.f1975c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        int i = this.f1973a.read(this.f1975c, 0, this.f1975c.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.f1976d = 0;
        this.f1977e = i;
    }

    public String a() throws IOException {
        int i;
        String string;
        synchronized (this.f1973a) {
            if (this.f1975c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f1976d >= this.f1977e) {
                c();
            }
            int i2 = this.f1976d;
            while (i2 != this.f1977e) {
                if (this.f1975c[i2] == 10) {
                    string = new String(this.f1975c, this.f1976d, ((i2 == this.f1976d || this.f1975c[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.f1976d, this.f1974b.name());
                    this.f1976d = i2 + 1;
                    return string;
                }
                i2++;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f1977e - this.f1976d) + 80) { // from class: com.a.a.a.b.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, b.this.f1974b.name());
                    } catch (UnsupportedEncodingException e2) {
                        throw new AssertionError(e2);
                    }
                }
            };
            loop1: while (true) {
                byteArrayOutputStream.write(this.f1975c, this.f1976d, this.f1977e - this.f1976d);
                this.f1977e = -1;
                c();
                i = this.f1976d;
                while (i != this.f1977e) {
                    if (this.f1975c[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f1976d) {
                byteArrayOutputStream.write(this.f1975c, this.f1976d, i - this.f1976d);
            }
            this.f1976d = i + 1;
            string = byteArrayOutputStream.toString();
            return string;
        }
    }

    public boolean b() {
        return this.f1977e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f1973a) {
            if (this.f1975c != null) {
                this.f1975c = null;
                this.f1973a.close();
            }
        }
    }
}
