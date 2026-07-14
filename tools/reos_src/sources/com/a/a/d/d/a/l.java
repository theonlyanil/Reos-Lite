package com.a.a.d.d.a;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f2242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f2243b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f2244c;

    public enum a {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f2250f;

        a(boolean z) {
            this.f2250f = z;
        }

        public boolean a() {
            return this.f2250f;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f2251a;

        public b(byte[] bArr) {
            this.f2251a = ByteBuffer.wrap(bArr);
            this.f2251a.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f2251a.array().length;
        }

        public int a(int i) {
            return this.f2251a.getInt(i);
        }

        public void a(ByteOrder byteOrder) {
            this.f2251a.order(byteOrder);
        }

        public short b(int i) {
            return this.f2251a.getShort(i);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f2252a;

        public c(InputStream inputStream) {
            this.f2252a = inputStream;
        }

        public int a() throws IOException {
            return ((this.f2252a.read() << 8) & 65280) | (this.f2252a.read() & 255);
        }

        public int a(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int i = this.f2252a.read(bArr, bArr.length - length, length);
                if (i == -1) {
                    break;
                }
                length -= i;
            }
            return bArr.length - length;
        }

        public long a(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.f2252a.skip(j2);
                if (jSkip > 0) {
                    j2 -= jSkip;
                } else {
                    if (this.f2252a.read() == -1) {
                        break;
                    }
                    j2--;
                }
            }
            return j - j2;
        }

        public short b() throws IOException {
            return (short) (this.f2252a.read() & 255);
        }

        public int c() throws IOException {
            return this.f2252a.read();
        }
    }

    static {
        byte[] bytes = new byte[0];
        try {
            bytes = "Exif\u0000\u0000".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
        }
        f2242a = bytes;
    }

    public l(InputStream inputStream) {
        this.f2244c = new c(inputStream);
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        int length = "Exif\u0000\u0000".length();
        short sB = bVar.b(length);
        if (sB == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (sB == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) sB));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.a(byteOrder);
        int iA = length + bVar.a(length + 4);
        short sB2 = bVar.b(iA);
        for (int i = 0; i < sB2; i++) {
            int iA2 = a(iA, i);
            short sB3 = bVar.b(iA2);
            if (sB3 == 274) {
                short sB4 = bVar.b(iA2 + 2);
                if (sB4 >= 1 && sB4 <= 12) {
                    int iA3 = bVar.a(iA2 + 4);
                    if (iA3 >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) sB3) + " formatCode=" + ((int) sB4) + " componentCount=" + iA3);
                        }
                        int i2 = iA3 + f2243b[sB4];
                        if (i2 <= 4) {
                            int i3 = iA2 + 8;
                            if (i3 >= 0 && i3 <= bVar.a()) {
                                if (i2 >= 0 && i3 + i2 <= bVar.a()) {
                                    return bVar.b(i3);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sB3));
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) sB3));
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sB4));
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code=" + ((int) sB4));
                }
            }
        }
        return -1;
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private byte[] d() throws IOException {
        short sB;
        int iA;
        long jA;
        do {
            short sB2 = this.f2244c.b();
            if (sB2 != 255) {
                if (!Log.isLoggable("ImageHeaderParser", 3)) {
                    return null;
                }
                Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) sB2));
                return null;
            }
            sB = this.f2244c.b();
            if (sB == 218) {
                return null;
            }
            if (sB == 217) {
                if (!Log.isLoggable("ImageHeaderParser", 3)) {
                    return null;
                }
                Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                return null;
            }
            iA = this.f2244c.a() - 2;
            if (sB == 225) {
                byte[] bArr = new byte[iA];
                int iA2 = this.f2244c.a(bArr);
                if (iA2 == iA) {
                    return bArr;
                }
                if (!Log.isLoggable("ImageHeaderParser", 3)) {
                    return null;
                }
                Log.d("ImageHeaderParser", "Unable to read segment data, type: " + ((int) sB) + ", length: " + iA + ", actually read: " + iA2);
                return null;
            }
            jA = this.f2244c.a(iA);
        } while (jA == iA);
        if (!Log.isLoggable("ImageHeaderParser", 3)) {
            return null;
        }
        Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) sB) + ", wanted to skip: " + iA + ", but actually skipped: " + jA);
        return null;
    }

    public boolean a() throws IOException {
        return b().a();
    }

    public a b() throws IOException {
        int iA = this.f2244c.a();
        if (iA == 65496) {
            return a.JPEG;
        }
        int iA2 = ((iA << 16) & (-65536)) | (this.f2244c.a() & 65535);
        if (iA2 != -1991225785) {
            return (iA2 >> 8) == 4671814 ? a.GIF : a.UNKNOWN;
        }
        this.f2244c.a(21L);
        return this.f2244c.c() >= 3 ? a.PNG_A : a.PNG;
    }

    public int c() throws IOException {
        boolean z = false;
        if (!a(this.f2244c.a())) {
            return -1;
        }
        byte[] bArrD = d();
        boolean z2 = bArrD != null && bArrD.length > f2242a.length;
        if (z2) {
            for (int i = 0; i < f2242a.length; i++) {
                if (bArrD[i] == f2242a[i]) {
                }
            }
            z = z2;
        } else {
            z = z2;
        }
        if (z) {
            return a(new b(bArrD));
        }
        return -1;
    }
}
