package e;

import com.flurry.android.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public final class c implements d, e, Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f6439c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    q f6440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f6441b;

    public int a(byte[] bArr, int i, int i2) {
        v.a(bArr.length, i, i2);
        q qVar = this.f6440a;
        if (qVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, qVar.f6484c - qVar.f6483b);
        System.arraycopy(qVar.f6482a, qVar.f6483b, bArr, i, iMin);
        qVar.f6483b += iMin;
        this.f6441b -= (long) iMin;
        if (qVar.f6483b != qVar.f6484c) {
            return iMin;
        }
        this.f6440a = qVar.a();
        r.a(qVar);
        return iMin;
    }

    @Override // e.e
    public long a(byte b2) {
        return a(b2, 0L);
    }

    public long a(byte b2, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        q qVar = this.f6440a;
        if (qVar == null) {
            return -1L;
        }
        q qVar2 = qVar;
        long j2 = 0;
        do {
            int i = qVar2.f6484c - qVar2.f6483b;
            if (j >= i) {
                j -= (long) i;
            } else {
                byte[] bArr = qVar2.f6482a;
                int i2 = qVar2.f6484c;
                for (int i3 = (int) (((long) qVar2.f6483b) + j); i3 < i2; i3++) {
                    if (bArr[i3] == b2) {
                        return (j2 + ((long) i3)) - ((long) qVar2.f6483b);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            qVar2 = qVar2.f6487f;
        } while (qVar2 != this.f6440a);
        return -1L;
    }

    @Override // e.t
    public long a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f6441b == 0) {
            return -1L;
        }
        if (j > this.f6441b) {
            j = this.f6441b;
        }
        cVar.a_(this, j);
        return j;
    }

    @Override // e.e
    public long a(s sVar) throws IOException {
        long j = this.f6441b;
        if (j > 0) {
            sVar.a_(this, j);
        }
        return j;
    }

    @Override // e.d
    public long a(t tVar) throws IOException {
        if (tVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA = tVar.a(this, 2048L);
            if (jA == -1) {
                return j;
            }
            j += jA;
        }
    }

    public c a(int i) {
        if (i < 128) {
            j(i);
        } else if (i < 2048) {
            j((i >> 6) | 192);
            j((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            j((i >> 12) | 224);
            j(((i >> 6) & 63) | 128);
            j((i & 63) | 128);
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            j((i >> 18) | 240);
            j(((i >> 12) & 63) | 128);
            j(((i >> 6) & 63) | 128);
            j((i & 63) | 128);
        }
        return this;
    }

    public c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        v.a(this.f6441b, j, j2);
        if (j2 != 0) {
            cVar.f6441b += j2;
            q qVar = this.f6440a;
            while (j >= qVar.f6484c - qVar.f6483b) {
                j -= (long) (qVar.f6484c - qVar.f6483b);
                qVar = qVar.f6487f;
            }
            while (j2 > 0) {
                q qVar2 = new q(qVar);
                qVar2.f6483b = (int) (((long) qVar2.f6483b) + j);
                qVar2.f6484c = Math.min(qVar2.f6483b + ((int) j2), qVar2.f6484c);
                if (cVar.f6440a == null) {
                    qVar2.g = qVar2;
                    qVar2.f6487f = qVar2;
                    cVar.f6440a = qVar2;
                } else {
                    cVar.f6440a.g.a(qVar2);
                }
                j2 -= (long) (qVar2.f6484c - qVar2.f6483b);
                qVar = qVar.f6487f;
                j = 0;
            }
        }
        return this;
    }

    @Override // e.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c b(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.a(this);
        return this;
    }

    @Override // e.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                q qVarF = f(1);
                byte[] bArr = qVarF.f6482a;
                int i4 = qVarF.f6484c - i;
                int iMin = Math.min(i2, 2048 - i4);
                i3 = i + 1;
                bArr[i4 + i] = (byte) cCharAt;
                while (i3 < iMin) {
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i3 + i4] = (byte) cCharAt2;
                    i3++;
                }
                int i5 = (i3 + i4) - qVarF.f6484c;
                qVarF.f6484c += i5;
                this.f6441b += (long) i5;
            } else if (cCharAt < 2048) {
                j((cCharAt >> 6) | 192);
                j((cCharAt & '?') | 128);
                i3 = i + 1;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                j((cCharAt >> '\f') | 224);
                j(((cCharAt >> 6) & 63) | 128);
                j((cCharAt & '?') | 128);
                i3 = i + 1;
            } else {
                char cCharAt3 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                    j(63);
                    i++;
                } else {
                    int i6 = ((cCharAt3 & 9215) | ((cCharAt & 10239) << 10)) + 65536;
                    j((i6 >> 18) | 240);
                    j(((i6 >> 12) & 63) | 128);
                    j(((i6 >> 6) & 63) | 128);
                    j((i6 & 63) | 128);
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return this;
    }

    @Override // e.s
    public u a() {
        return u.f6490b;
    }

    public String a(long j, Charset charset) throws EOFException {
        v.a(this.f6441b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        q qVar = this.f6440a;
        if (((long) qVar.f6483b) + j > qVar.f6484c) {
            return new String(f(j), charset);
        }
        String str = new String(qVar.f6482a, qVar.f6483b, (int) j, charset);
        qVar.f6483b = (int) (((long) qVar.f6483b) + j);
        this.f6441b -= j;
        if (qVar.f6483b != qVar.f6484c) {
            return str;
        }
        this.f6440a = qVar.a();
        r.a(qVar);
        return str;
    }

    @Override // e.e
    public void a(long j) throws EOFException {
        if (this.f6441b < j) {
            throw new EOFException();
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    @Override // e.s
    public void a_(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        v.a(cVar.f6441b, 0L, j);
        while (j > 0) {
            if (j < cVar.f6440a.f6484c - cVar.f6440a.f6483b) {
                q qVar = this.f6440a != null ? this.f6440a.g : null;
                if (qVar != null && qVar.f6486e) {
                    if ((((long) qVar.f6484c) + j) - ((long) (qVar.f6485d ? 0 : qVar.f6483b)) <= 2048) {
                        cVar.f6440a.a(qVar, (int) j);
                        cVar.f6441b -= j;
                        this.f6441b += j;
                        return;
                    }
                }
                cVar.f6440a = cVar.f6440a.a((int) j);
            }
            q qVar2 = cVar.f6440a;
            long j2 = qVar2.f6484c - qVar2.f6483b;
            cVar.f6440a = qVar2.a();
            if (this.f6440a == null) {
                this.f6440a = qVar2;
                q qVar3 = this.f6440a;
                q qVar4 = this.f6440a;
                q qVar5 = this.f6440a;
                qVar4.g = qVar5;
                qVar3.f6487f = qVar5;
            } else {
                this.f6440a.g.a(qVar2).b();
            }
            cVar.f6441b -= j2;
            this.f6441b += j2;
            j -= j2;
        }
    }

    public byte b(long j) {
        v.a(this.f6441b, j, 1L);
        q qVar = this.f6440a;
        while (true) {
            int i = qVar.f6484c - qVar.f6483b;
            if (j < i) {
                return qVar.f6482a[qVar.f6483b + ((int) j)];
            }
            j -= (long) i;
            qVar = qVar.f6487f;
        }
    }

    public long b() {
        return this.f6441b;
    }

    @Override // e.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c j(int i) {
        q qVarF = f(1);
        byte[] bArr = qVarF.f6482a;
        int i2 = qVarF.f6484c;
        qVarF.f6484c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f6441b++;
        return this;
    }

    @Override // e.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    @Override // e.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        v.a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            q qVarF = f(1);
            int iMin = Math.min(i3 - i, 2048 - qVarF.f6484c);
            System.arraycopy(bArr, i, qVarF.f6482a, qVarF.f6484c, iMin);
            i += iMin;
            qVarF.f6484c = iMin + qVarF.f6484c;
        }
        this.f6441b += (long) i2;
        return this;
    }

    @Override // e.d, e.e
    public c c() {
        return this;
    }

    @Override // e.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c i(int i) {
        q qVarF = f(2);
        byte[] bArr = qVarF.f6482a;
        int i2 = qVarF.f6484c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        qVarF.f6484c = i3 + 1;
        this.f6441b += 2;
        return this;
    }

    @Override // e.e
    public f c(long j) throws EOFException {
        return new f(f(j));
    }

    @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // e.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c h(int i) {
        q qVarF = f(4);
        byte[] bArr = qVarF.f6482a;
        int i2 = qVarF.f6484c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        qVarF.f6484c = i5 + 1;
        this.f6441b += 4;
        return this;
    }

    public OutputStream d() {
        return new OutputStream() { // from class: e.c.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                c.this.j((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                c.this.c(bArr, i, i2);
            }
        };
    }

    public String d(long j) throws EOFException {
        return a(j, v.f6494a);
    }

    @Override // e.d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c w() {
        return this;
    }

    @Override // e.d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c g(int i) {
        return h(v.a(i));
    }

    String e(long j) throws EOFException {
        if (j <= 0 || b(j - 1) != 13) {
            String strD = d(j);
            g(1L);
            return strD;
        }
        String strD2 = d(j - 1);
        g(2L);
        return strD2;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f6441b != cVar.f6441b) {
            return false;
        }
        if (this.f6441b == 0) {
            return true;
        }
        q qVar = this.f6440a;
        q qVar2 = cVar.f6440a;
        int i = qVar.f6483b;
        int i2 = qVar2.f6483b;
        while (j < this.f6441b) {
            long jMin = Math.min(qVar.f6484c - i, qVar2.f6484c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                byte b2 = qVar.f6482a[i];
                int i5 = i2 + 1;
                if (b2 != qVar2.f6482a[i2]) {
                    return false;
                }
                i3++;
                i2 = i5;
                i = i4;
            }
            if (i == qVar.f6484c) {
                qVar = qVar.f6487f;
                i = qVar.f6483b;
            }
            if (i2 == qVar2.f6484c) {
                qVar2 = qVar2.f6487f;
                i2 = qVar2.f6483b;
            }
            j += jMin;
        }
        return true;
    }

    @Override // e.d
    public d f() {
        return this;
    }

    q f(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        if (this.f6440a != null) {
            q qVar = this.f6440a.g;
            return (qVar.f6484c + i > 2048 || !qVar.f6486e) ? qVar.a(r.a()) : qVar;
        }
        this.f6440a = r.a();
        q qVar2 = this.f6440a;
        q qVar3 = this.f6440a;
        q qVar4 = this.f6440a;
        qVar3.g = qVar4;
        qVar2.f6487f = qVar4;
        return qVar4;
    }

    @Override // e.e
    public byte[] f(long j) throws EOFException {
        v.a(this.f6441b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    @Override // e.s, java.io.Flushable
    public void flush() {
    }

    @Override // e.e
    public void g(long j) throws EOFException {
        while (j > 0) {
            if (this.f6440a == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, this.f6440a.f6484c - this.f6440a.f6483b);
            this.f6441b -= (long) iMin;
            j -= (long) iMin;
            q qVar = this.f6440a;
            qVar.f6483b = iMin + qVar.f6483b;
            if (this.f6440a.f6483b == this.f6440a.f6484c) {
                q qVar2 = this.f6440a;
                this.f6440a = qVar2.a();
                r.a(qVar2);
            }
        }
    }

    @Override // e.e
    public boolean g() {
        return this.f6441b == 0;
    }

    @Override // e.d
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public c k(long j) {
        boolean z;
        long j2;
        int i;
        if (j == 0) {
            return j(48);
        }
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
            j2 = j;
        }
        if (j2 < 100000000) {
            if (j2 < 10000) {
                if (j2 < 100) {
                    i = j2 < 10 ? 1 : 2;
                } else {
                    i = j2 < 1000 ? 3 : 4;
                }
            } else if (j2 < 1000000) {
                i = j2 < 100000 ? 5 : 6;
            } else {
                i = j2 < 10000000 ? 7 : 8;
            }
        } else if (j2 < 1000000000000L) {
            if (j2 < 10000000000L) {
                i = j2 < 1000000000 ? 9 : 10;
            } else {
                i = j2 < 100000000000L ? 11 : 12;
            }
        } else if (j2 < 1000000000000000L) {
            if (j2 < 10000000000000L) {
                i = 13;
            } else {
                i = j2 < 100000000000000L ? 14 : 15;
            }
        } else if (j2 < 100000000000000000L) {
            i = j2 < 10000000000000000L ? 16 : 17;
        } else {
            i = j2 < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        q qVarF = f(i);
        byte[] bArr = qVarF.f6482a;
        int i2 = qVarF.f6484c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f6439c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        qVarF.f6484c += i;
        this.f6441b = ((long) i) + this.f6441b;
        return this;
    }

    @Override // e.e
    public InputStream h() {
        return new InputStream() { // from class: e.c.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.f6441b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (c.this.f6441b > 0) {
                    return c.this.j() & Constants.UNKNOWN;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public int hashCode() {
        q qVar = this.f6440a;
        if (qVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = qVar.f6483b;
            int i3 = qVar.f6484c;
            while (i2 < i3) {
                int i4 = qVar.f6482a[i2] + (i * 31);
                i2++;
                i = i4;
            }
            qVar = qVar.f6487f;
        } while (qVar != this.f6440a);
        return i;
    }

    public long i() {
        long j = this.f6441b;
        if (j == 0) {
            return 0L;
        }
        q qVar = this.f6440a.g;
        return (qVar.f6484c >= 2048 || !qVar.f6486e) ? j : j - ((long) (qVar.f6484c - qVar.f6483b));
    }

    @Override // e.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public c j(long j) {
        if (j == 0) {
            return j(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        q qVarF = f(iNumberOfTrailingZeros);
        byte[] bArr = qVarF.f6482a;
        int i = qVarF.f6484c;
        for (int i2 = (qVarF.f6484c + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f6439c[(int) (15 & j)];
            j >>>= 4;
        }
        qVarF.f6484c += iNumberOfTrailingZeros;
        this.f6441b = ((long) iNumberOfTrailingZeros) + this.f6441b;
        return this;
    }

    @Override // e.e
    public byte j() {
        if (this.f6441b == 0) {
            throw new IllegalStateException("size == 0");
        }
        q qVar = this.f6440a;
        int i = qVar.f6483b;
        int i2 = qVar.f6484c;
        int i3 = i + 1;
        byte b2 = qVar.f6482a[i];
        this.f6441b--;
        if (i3 == i2) {
            this.f6440a = qVar.a();
            r.a(qVar);
        } else {
            qVar.f6483b = i3;
        }
        return b2;
    }

    @Override // e.e
    public short k() {
        if (this.f6441b < 2) {
            throw new IllegalStateException("size < 2: " + this.f6441b);
        }
        q qVar = this.f6440a;
        int i = qVar.f6483b;
        int i2 = qVar.f6484c;
        if (i2 - i < 2) {
            return (short) (((j() & Constants.UNKNOWN) << 8) | (j() & Constants.UNKNOWN));
        }
        byte[] bArr = qVar.f6482a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & Constants.UNKNOWN) << 8) | (bArr[i3] & Constants.UNKNOWN);
        this.f6441b -= 2;
        if (i4 == i2) {
            this.f6440a = qVar.a();
            r.a(qVar);
        } else {
            qVar.f6483b = i4;
        }
        return (short) i5;
    }

    @Override // e.e
    public int l() {
        if (this.f6441b < 4) {
            throw new IllegalStateException("size < 4: " + this.f6441b);
        }
        q qVar = this.f6440a;
        int i = qVar.f6483b;
        int i2 = qVar.f6484c;
        if (i2 - i < 4) {
            return ((j() & Constants.UNKNOWN) << 24) | ((j() & Constants.UNKNOWN) << 16) | ((j() & Constants.UNKNOWN) << 8) | (j() & Constants.UNKNOWN);
        }
        byte[] bArr = qVar.f6482a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & Constants.UNKNOWN) << 24) | ((bArr[i3] & Constants.UNKNOWN) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & Constants.UNKNOWN) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & Constants.UNKNOWN);
        this.f6441b -= 4;
        if (i8 != i2) {
            qVar.f6483b = i8;
            return i9;
        }
        this.f6440a = qVar.a();
        r.a(qVar);
        return i9;
    }

    @Override // e.e
    public short m() {
        return v.a(k());
    }

    @Override // e.e
    public int n() {
        return v.a(l());
    }

    @Override // e.e
    public long o() {
        if (this.f6441b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        long j2 = -7;
        do {
            q qVar = this.f6440a;
            byte[] bArr = qVar.f6482a;
            int i2 = qVar.f6483b;
            int i3 = qVar.f6484c;
            while (i2 < i3) {
                byte b2 = bArr[i2];
                if (b2 >= 48 && b2 <= 57) {
                    int i4 = 48 - b2;
                    if (j < -922337203685477580L || (j == -922337203685477580L && i4 < j2)) {
                        c cVarJ = new c().k(j).j((int) b2);
                        if (!z) {
                            cVarJ.j();
                        }
                        throw new NumberFormatException("Number too large: " + cVarJ.r());
                    }
                    j = (j * 10) + ((long) i4);
                } else {
                    if (b2 != 45 || i != 0) {
                        if (i != 0) {
                            z2 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b2));
                    }
                    z = true;
                    j2--;
                }
                i2++;
                i++;
            }
            if (i2 == i3) {
                this.f6440a = qVar.a();
                r.a(qVar);
            } else {
                qVar.f6483b = i2;
            }
            if (z2) {
                break;
            }
        } while (this.f6440a != null);
        this.f6441b -= (long) i;
        return z ? j : -j;
    }

    @Override // e.e
    public long p() {
        int i;
        if (this.f6441b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i2 = 0;
        boolean z = false;
        do {
            q qVar = this.f6440a;
            byte[] bArr = qVar.f6482a;
            int i3 = qVar.f6483b;
            int i4 = qVar.f6484c;
            int i5 = i3;
            while (i5 < i4) {
                byte b2 = bArr[i5];
                if (b2 >= 48 && b2 <= 57) {
                    i = b2 - 48;
                } else if (b2 >= 97 && b2 <= 102) {
                    i = (b2 - 97) + 10;
                } else {
                    if (b2 < 65 || b2 > 70) {
                        if (i2 != 0) {
                            z = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                    }
                    i = (b2 - 65) + 10;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new c().j(j).j((int) b2).r());
                }
                i2++;
                i5++;
                j = ((long) i) | (j << 4);
            }
            if (i5 == i4) {
                this.f6440a = qVar.a();
                r.a(qVar);
            } else {
                qVar.f6483b = i5;
            }
            if (z) {
                break;
            }
        } while (this.f6440a != null);
        this.f6441b -= (long) i2;
        return j;
    }

    public f q() {
        return new f(t());
    }

    public String r() {
        try {
            return a(this.f6441b, v.f6494a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // e.e
    public String s() throws EOFException {
        long jA = a((byte) 10);
        if (jA != -1) {
            return e(jA);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, this.f6441b));
        throw new EOFException("\\n not found: size=" + b() + " content=" + cVar.q().d() + "...");
    }

    public byte[] t() {
        try {
            return f(this.f6441b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String toString() {
        if (this.f6441b == 0) {
            return "Buffer[size=0]";
        }
        if (this.f6441b <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f6441b), clone().q().d());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f6440a.f6482a, this.f6440a.f6483b, this.f6440a.f6484c - this.f6440a.f6483b);
            for (q qVar = this.f6440a.f6487f; qVar != this.f6440a; qVar = qVar.f6487f) {
                messageDigest.update(qVar.f6482a, qVar.f6483b, qVar.f6484c - qVar.f6483b);
            }
            return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f6441b), f.a(messageDigest.digest()).d());
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError();
        }
    }

    public void u() {
        try {
            g(this.f6441b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.f6441b == 0) {
            return cVar;
        }
        cVar.f6440a = new q(this.f6440a);
        q qVar = cVar.f6440a;
        q qVar2 = cVar.f6440a;
        q qVar3 = cVar.f6440a;
        qVar2.g = qVar3;
        qVar.f6487f = qVar3;
        for (q qVar4 = this.f6440a.f6487f; qVar4 != this.f6440a; qVar4 = qVar4.f6487f) {
            cVar.f6440a.g.a(new q(qVar4));
        }
        cVar.f6441b = this.f6441b;
        return cVar;
    }
}
