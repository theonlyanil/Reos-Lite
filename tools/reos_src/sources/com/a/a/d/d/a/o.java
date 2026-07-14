package com.a.a.d.d.a;

import android.util.Log;
import com.flurry.android.Constants;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class o extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile byte[] f2259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2263e;

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public o(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f2262d = -1;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.f2259a = bArr;
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        if (this.f2262d == -1 || this.f2263e - this.f2262d >= this.f2261c) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                return i;
            }
            this.f2262d = -1;
            this.f2263e = 0;
            this.f2260b = i;
            return i;
        }
        if (this.f2262d == 0 && this.f2261c > bArr.length && this.f2260b == bArr.length) {
            int length = bArr.length * 2;
            if (length > this.f2261c) {
                length = this.f2261c;
            }
            if (Log.isLoggable("BufferedIs", 3)) {
                Log.d("BufferedIs", "allocate buffer of length: " + length);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f2259a = bArr2;
            bArr = bArr2;
        } else if (this.f2262d > 0) {
            System.arraycopy(bArr, this.f2262d, bArr, 0, bArr.length - this.f2262d);
        }
        this.f2263e -= this.f2262d;
        this.f2262d = 0;
        this.f2260b = 0;
        int i2 = inputStream.read(bArr, this.f2263e, bArr.length - this.f2263e);
        this.f2260b = i2 <= 0 ? this.f2263e : this.f2263e + i2;
        return i2;
    }

    private static IOException b() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f2261c = this.f2259a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f2259a == null || inputStream == null) {
            throw b();
        }
        return inputStream.available() + (this.f2260b - this.f2263e);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2259a = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f2261c = Math.max(this.f2261c, i);
        this.f2262d = this.f2263e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            byte[] bArr = this.f2259a;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                throw b();
            }
            if (this.f2263e < this.f2260b || a(inputStream, bArr) != -1) {
                if (bArr != this.f2259a && (bArr = this.f2259a) == null) {
                    throw b();
                }
                if (this.f2260b - this.f2263e > 0) {
                    int i2 = this.f2263e;
                    this.f2263e = i2 + 1;
                    i = bArr[i2] & Constants.UNKNOWN;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0090 A[Catch: all -> 0x000b, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0006, B:7:0x000a, B:15:0x0013, B:17:0x0017, B:18:0x001b, B:19:0x001c, B:21:0x0022, B:24:0x002a, B:26:0x0036, B:30:0x0044, B:31:0x0047, B:33:0x004b, B:35:0x004e, B:38:0x0056, B:54:0x0085, B:58:0x0090, B:40:0x005b, B:43:0x0063, B:44:0x0066, B:46:0x006a, B:48:0x006e, B:49:0x0072, B:50:0x0073, B:53:0x007b, B:57:0x008a, B:29:0x003e), top: B:62:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x009a A[LOOP:0: B:31:0x0047->B:61:0x009a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0096 A[SYNTHETIC] */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5 = -1;
        synchronized (this) {
            byte[] bArr2 = this.f2259a;
            if (bArr2 == null) {
                throw b();
            }
            if (i2 == 0) {
                i5 = 0;
            } else {
                InputStream inputStream = this.in;
                if (inputStream == null) {
                    throw b();
                }
                if (this.f2263e < this.f2260b) {
                    int i6 = this.f2260b - this.f2263e >= i2 ? i2 : this.f2260b - this.f2263e;
                    System.arraycopy(bArr2, this.f2263e, bArr, i, i6);
                    this.f2263e += i6;
                    if (i6 == i2 || inputStream.available() == 0) {
                        i5 = i6;
                    } else {
                        i += i6;
                        i3 = i2 - i6;
                    }
                } else {
                    i3 = i2;
                }
                while (true) {
                    if (this.f2262d == -1 && i3 >= bArr2.length) {
                        i4 = inputStream.read(bArr, i, i3);
                        if (i4 == -1) {
                            if (i3 == i2) {
                                break;
                            }
                            i5 = i2 - i3;
                            break;
                        }
                        i3 -= i4;
                        if (i3 == 0) {
                            i5 = i2;
                            break;
                        }
                        if (inputStream.available() == 0) {
                            i5 = i2 - i3;
                            break;
                        }
                        i += i4;
                    } else {
                        if (a(inputStream, bArr2) == -1) {
                            if (i3 == i2) {
                                break;
                            }
                            i5 = i2 - i3;
                            break;
                        }
                        if (bArr2 != this.f2259a && (bArr2 = this.f2259a) == null) {
                            throw b();
                        }
                        i4 = this.f2260b - this.f2263e >= i3 ? i3 : this.f2260b - this.f2263e;
                        System.arraycopy(bArr2, this.f2263e, bArr, i, i4);
                        this.f2263e += i4;
                        i3 -= i4;
                        if (i3 == 0) {
                            i5 = i2;
                            break;
                        }
                        if (inputStream.available() == 0) {
                            i5 = i2 - i3;
                            break;
                        }
                        i += i4;
                    }
                }
            }
        }
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f2259a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f2262d) {
            throw new a("Mark has been invalidated");
        }
        this.f2263e = this.f2262d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        byte[] bArr = this.f2259a;
        InputStream inputStream = this.in;
        if (bArr == null) {
            throw b();
        }
        if (j < 1) {
            j = 0;
        } else {
            if (inputStream == null) {
                throw b();
            }
            if (this.f2260b - this.f2263e >= j) {
                this.f2263e = (int) (((long) this.f2263e) + j);
            } else {
                long j2 = this.f2260b - this.f2263e;
                this.f2263e = this.f2260b;
                if (this.f2262d == -1 || j > this.f2261c) {
                    j = j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    j = j2;
                } else if (this.f2260b - this.f2263e >= j - j2) {
                    this.f2263e = (int) ((j - j2) + ((long) this.f2263e));
                } else {
                    j = (j2 + ((long) this.f2260b)) - ((long) this.f2263e);
                    this.f2263e = this.f2260b;
                }
            }
        }
        return j;
    }
}
