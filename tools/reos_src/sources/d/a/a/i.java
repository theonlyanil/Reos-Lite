package d.a.a;

import com.flurry.android.Constants;
import e.t;
import e.u;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class i implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f6021a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e.f f6022b = e.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    static final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte f6024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6026d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        short f6027e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final e.e f6028f;

        public a(e.e eVar) {
            this.f6028f = eVar;
        }

        private void b() throws IOException {
            int i = this.f6025c;
            int iB = i.b(this.f6028f);
            this.f6026d = iB;
            this.f6023a = iB;
            byte bJ = (byte) (this.f6028f.j() & Constants.UNKNOWN);
            this.f6024b = (byte) (this.f6028f.j() & Constants.UNKNOWN);
            if (i.f6021a.isLoggable(Level.FINE)) {
                i.f6021a.fine(b.a(true, this.f6025c, this.f6023a, bJ, this.f6024b));
            }
            this.f6025c = this.f6028f.l() & Integer.MAX_VALUE;
            if (bJ != 9) {
                throw i.d("%s != TYPE_CONTINUATION", Byte.valueOf(bJ));
            }
            if (this.f6025c != i) {
                throw i.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // e.t
        public long a(e.c cVar, long j) throws IOException {
            while (this.f6026d == 0) {
                this.f6028f.g(this.f6027e);
                this.f6027e = (short) 0;
                if ((this.f6024b & 4) != 0) {
                    return -1L;
                }
                b();
            }
            long jA = this.f6028f.a(cVar, Math.min(j, this.f6026d));
            if (jA == -1) {
                return -1L;
            }
            this.f6026d = (int) (((long) this.f6026d) - jA);
            return jA;
        }

        @Override // e.t
        public u a() {
            return this.f6028f.a();
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f6029a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f6030b = new String[64];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String[] f6031c = new String[256];

        static {
            for (int i = 0; i < f6031c.length; i++) {
                f6031c[i] = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            }
            f6030b[0] = "";
            f6030b[1] = "END_STREAM";
            int[] iArr = {1};
            f6030b[8] = "PADDED";
            for (int i2 : iArr) {
                f6030b[i2 | 8] = f6030b[i2] + "|PADDED";
            }
            f6030b[4] = "END_HEADERS";
            f6030b[32] = "PRIORITY";
            f6030b[36] = "END_HEADERS|PRIORITY";
            for (int i3 : new int[]{4, 32, 36}) {
                for (int i4 : iArr) {
                    f6030b[i4 | i3] = f6030b[i4] + '|' + f6030b[i3];
                    f6030b[i4 | i3 | 8] = f6030b[i4] + '|' + f6030b[i3] + "|PADDED";
                }
            }
            for (int i5 = 0; i5 < f6030b.length; i5++) {
                if (f6030b[i5] == null) {
                    f6030b[i5] = f6031c[i5];
                }
            }
        }

        b() {
        }

        static String a(byte b2, byte b3) {
            if (b3 == 0) {
                return "";
            }
            switch (b2) {
                case 2:
                case 3:
                case 7:
                case 8:
                    return f6031c[b3];
                case 4:
                case 6:
                    return b3 == 1 ? "ACK" : f6031c[b3];
                case 5:
                default:
                    String str = b3 < f6030b.length ? f6030b[b3] : f6031c[b3];
                    if (b2 != 5 || (b3 & 4) == 0) {
                        return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }

        static String a(boolean z, int i, int i2, byte b2, byte b3) {
            String str = b2 < f6029a.length ? f6029a[b2] : String.format("0x%02x", Byte.valueOf(b2));
            String strA = a(b2, b3);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str;
            objArr[4] = strA;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    static final class c implements d.a.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h.a f6032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e.e f6033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a f6034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f6035d;

        c(e.e eVar, int i, boolean z) {
            this.f6033b = eVar;
            this.f6035d = z;
            this.f6034c = new a(this.f6033b);
            this.f6032a = new h.a(i, this.f6034c);
        }

        private List<f> a(int i, short s, byte b2, int i2) throws IOException {
            a aVar = this.f6034c;
            this.f6034c.f6026d = i;
            aVar.f6023a = i;
            this.f6034c.f6027e = s;
            this.f6034c.f6024b = b2;
            this.f6034c.f6025c = i2;
            this.f6032a.a();
            return this.f6032a.b();
        }

        private void a(d.a.a.b.a aVar, int i) throws IOException {
            int iL = this.f6033b.l();
            aVar.a(i, iL & Integer.MAX_VALUE, (this.f6033b.j() & Constants.UNKNOWN) + 1, (Integer.MIN_VALUE & iL) != 0);
        }

        private void a(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            if (i2 == 0) {
                throw i.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z = (b2 & 1) != 0;
            short sJ = (b2 & 8) != 0 ? (short) (this.f6033b.j() & Constants.UNKNOWN) : (short) 0;
            if ((b2 & 32) != 0) {
                a(aVar, i2);
                i -= 5;
            }
            aVar.a(false, z, i2, -1, a(i.b(i, b2, sJ), sJ, b2, i2), g.HTTP_20_HEADERS);
        }

        private void b(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 32) != 0) {
                throw i.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short sJ = (b2 & 8) != 0 ? (short) (this.f6033b.j() & Constants.UNKNOWN) : (short) 0;
            aVar.a(z, i2, this.f6033b, i.b(i, b2, sJ));
            this.f6033b.g(sJ);
        }

        private void c(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            if (i != 5) {
                throw i.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            }
            if (i2 == 0) {
                throw i.d("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            a(aVar, i2);
        }

        private void d(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            if (i != 4) {
                throw i.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            }
            if (i2 == 0) {
                throw i.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int iL = this.f6033b.l();
            d.a.a.a aVarB = d.a.a.a.b(iL);
            if (aVarB == null) {
                throw i.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iL));
            }
            aVar.a(i2, aVarB);
        }

        private void e(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            if (i2 != 0) {
                throw i.d("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b2 & 1) != 0) {
                if (i != 0) {
                    throw i.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                aVar.a();
                return;
            }
            if (i % 6 != 0) {
                throw i.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            }
            n nVar = new n();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short sK = this.f6033b.k();
                int iL = this.f6033b.l();
                switch (sK) {
                    case 2:
                        if (iL != 0 && iL != 1) {
                            throw i.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                        break;
                    case 3:
                        sK = 4;
                        break;
                    case 4:
                        sK = 7;
                        if (iL < 0) {
                            throw i.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        break;
                        break;
                    case 5:
                        if (iL < 16384 || iL > 16777215) {
                            throw i.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iL));
                        }
                        break;
                        break;
                }
                nVar.a(sK, 0, iL);
            }
            aVar.a(false, nVar);
            if (nVar.c() >= 0) {
                this.f6032a.a(nVar.c());
            }
        }

        private void f(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            if (i2 == 0) {
                throw i.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short sJ = (b2 & 8) != 0 ? (short) (this.f6033b.j() & Constants.UNKNOWN) : (short) 0;
            aVar.a(i2, this.f6033b.l() & Integer.MAX_VALUE, a(i.b(i - 4, b2, sJ), sJ, b2, i2));
        }

        private void g(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            if (i != 8) {
                throw i.d("TYPE_PING length != 8: %s", Integer.valueOf(i));
            }
            if (i2 != 0) {
                throw i.d("TYPE_PING streamId != 0", new Object[0]);
            }
            aVar.a((b2 & 1) != 0, this.f6033b.l(), this.f6033b.l());
        }

        private void h(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            if (i < 8) {
                throw i.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            }
            if (i2 != 0) {
                throw i.d("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int iL = this.f6033b.l();
            int iL2 = this.f6033b.l();
            int i3 = i - 8;
            d.a.a.a aVarB = d.a.a.a.b(iL2);
            if (aVarB == null) {
                throw i.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iL2));
            }
            e.f fVarC = e.f.f6445b;
            if (i3 > 0) {
                fVarC = this.f6033b.c(i3);
            }
            aVar.a(iL, aVarB, fVarC);
        }

        private void i(d.a.a.b.a aVar, int i, byte b2, int i2) throws IOException {
            if (i != 4) {
                throw i.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            }
            long jL = ((long) this.f6033b.l()) & 2147483647L;
            if (jL == 0) {
                throw i.d("windowSizeIncrement was 0", Long.valueOf(jL));
            }
            aVar.a(i2, jL);
        }

        @Override // d.a.a.b
        public void a() throws IOException {
            if (this.f6035d) {
                return;
            }
            e.f fVarC = this.f6033b.c(i.f6022b.f());
            if (i.f6021a.isLoggable(Level.FINE)) {
                i.f6021a.fine(String.format("<< CONNECTION %s", fVarC.d()));
            }
            if (!i.f6022b.equals(fVarC)) {
                throw i.d("Expected a connection header but was %s", fVarC.a());
            }
        }

        @Override // d.a.a.b
        public boolean a(d.a.a.b.a aVar) throws IOException {
            try {
                this.f6033b.a(9L);
                int iB = i.b(this.f6033b);
                if (iB < 0 || iB > 16384) {
                    throw i.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(iB));
                }
                byte bJ = (byte) (this.f6033b.j() & Constants.UNKNOWN);
                byte bJ2 = (byte) (this.f6033b.j() & Constants.UNKNOWN);
                int iL = this.f6033b.l() & Integer.MAX_VALUE;
                if (i.f6021a.isLoggable(Level.FINE)) {
                    i.f6021a.fine(b.a(true, iL, iB, bJ, bJ2));
                }
                switch (bJ) {
                    case 0:
                        b(aVar, iB, bJ2, iL);
                        return true;
                    case 1:
                        a(aVar, iB, bJ2, iL);
                        return true;
                    case 2:
                        c(aVar, iB, bJ2, iL);
                        return true;
                    case 3:
                        d(aVar, iB, bJ2, iL);
                        return true;
                    case 4:
                        e(aVar, iB, bJ2, iL);
                        return true;
                    case 5:
                        f(aVar, iB, bJ2, iL);
                        return true;
                    case 6:
                        g(aVar, iB, bJ2, iL);
                        return true;
                    case 7:
                        h(aVar, iB, bJ2, iL);
                        return true;
                    case 8:
                        i(aVar, iB, bJ2, iL);
                        return true;
                    default:
                        this.f6033b.g(iB);
                        return true;
                }
            } catch (IOException e2) {
                return false;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f6033b.close();
        }
    }

    static final class d implements d.a.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e.d f6036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e.c f6038c = new e.c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final h.b f6039d = new h.b(this.f6038c);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f6040e = 16384;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f6041f;

        d(e.d dVar, boolean z) {
            this.f6036a = dVar;
            this.f6037b = z;
        }

        private void b(int i, long j) throws IOException {
            while (j > 0) {
                int iMin = (int) Math.min(this.f6040e, j);
                j -= (long) iMin;
                a(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.f6036a.a_(this.f6038c, iMin);
            }
        }

        @Override // d.a.a.c
        public synchronized void a() throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            if (this.f6037b) {
                if (i.f6021a.isLoggable(Level.FINE)) {
                    i.f6021a.fine(String.format(">> CONNECTION %s", i.f6022b.d()));
                }
                this.f6036a.c(i.f6022b.g());
                this.f6036a.flush();
            }
        }

        void a(int i, byte b2, e.c cVar, int i2) throws IOException {
            a(i, i2, (byte) 0, b2);
            if (i2 > 0) {
                this.f6036a.a_(cVar, i2);
            }
        }

        void a(int i, int i2, byte b2, byte b3) throws IOException {
            if (i.f6021a.isLoggable(Level.FINE)) {
                i.f6021a.fine(b.a(false, i, i2, b2, b3));
            }
            if (i2 > this.f6040e) {
                throw i.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f6040e), Integer.valueOf(i2));
            }
            if ((Integer.MIN_VALUE & i) != 0) {
                throw i.c("reserved bit set: %s", Integer.valueOf(i));
            }
            i.b(this.f6036a, i2);
            this.f6036a.j(b2 & Constants.UNKNOWN);
            this.f6036a.j(b3 & Constants.UNKNOWN);
            this.f6036a.h(Integer.MAX_VALUE & i);
        }

        @Override // d.a.a.c
        public synchronized void a(int i, int i2, List<f> list) throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            this.f6039d.a(list);
            long jB = this.f6038c.b();
            int iMin = (int) Math.min(this.f6040e - 4, jB);
            a(i, iMin + 4, (byte) 5, jB == ((long) iMin) ? (byte) 4 : (byte) 0);
            this.f6036a.h(Integer.MAX_VALUE & i2);
            this.f6036a.a_(this.f6038c, iMin);
            if (jB > iMin) {
                b(i, jB - ((long) iMin));
            }
        }

        @Override // d.a.a.c
        public synchronized void a(int i, long j) throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            if (j == 0 || j > 2147483647L) {
                throw i.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            }
            a(i, 4, (byte) 8, (byte) 0);
            this.f6036a.h((int) j);
            this.f6036a.flush();
        }

        @Override // d.a.a.c
        public synchronized void a(int i, d.a.a.a aVar) throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            if (aVar.s == -1) {
                throw new IllegalArgumentException();
            }
            a(i, 4, (byte) 3, (byte) 0);
            this.f6036a.h(aVar.s);
            this.f6036a.flush();
        }

        @Override // d.a.a.c
        public synchronized void a(int i, d.a.a.a aVar, byte[] bArr) throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            if (aVar.s == -1) {
                throw i.c("errorCode.httpCode == -1", new Object[0]);
            }
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f6036a.h(i);
            this.f6036a.h(aVar.s);
            if (bArr.length > 0) {
                this.f6036a.c(bArr);
            }
            this.f6036a.flush();
        }

        @Override // d.a.a.c
        public synchronized void a(n nVar) throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            this.f6040e = nVar.e(this.f6040e);
            a(0, 0, (byte) 4, (byte) 1);
            this.f6036a.flush();
        }

        @Override // d.a.a.c
        public synchronized void a(boolean z, int i, int i2) throws IOException {
            synchronized (this) {
                if (this.f6041f) {
                    throw new IOException("closed");
                }
                a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                this.f6036a.h(i);
                this.f6036a.h(i2);
                this.f6036a.flush();
            }
        }

        @Override // d.a.a.c
        public synchronized void a(boolean z, int i, e.c cVar, int i2) throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            a(i, z ? (byte) 1 : (byte) 0, cVar, i2);
        }

        void a(boolean z, int i, List<f> list) throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            this.f6039d.a(list);
            long jB = this.f6038c.b();
            int iMin = (int) Math.min(this.f6040e, jB);
            byte b2 = jB == ((long) iMin) ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i, iMin, (byte) 1, b2);
            this.f6036a.a_(this.f6038c, iMin);
            if (jB > iMin) {
                b(i, jB - ((long) iMin));
            }
        }

        @Override // d.a.a.c
        public synchronized void a(boolean z, boolean z2, int i, int i2, List<f> list) throws IOException {
            try {
                if (z2) {
                    throw new UnsupportedOperationException();
                }
                if (this.f6041f) {
                    throw new IOException("closed");
                }
                a(z, i, list);
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // d.a.a.c
        public synchronized void b() throws IOException {
            if (this.f6041f) {
                throw new IOException("closed");
            }
            this.f6036a.flush();
        }

        @Override // d.a.a.c
        public synchronized void b(n nVar) throws IOException {
            int i;
            int i2 = 0;
            synchronized (this) {
                if (this.f6041f) {
                    throw new IOException("closed");
                }
                a(0, nVar.b() * 6, (byte) 4, (byte) 0);
                while (i2 < 10) {
                    if (nVar.a(i2)) {
                        if (i2 == 4) {
                            i = 3;
                        } else {
                            i = i2 == 7 ? 4 : i2;
                        }
                        this.f6036a.i(i);
                        this.f6036a.h(nVar.b(i2));
                    }
                    i2++;
                }
                this.f6036a.flush();
            }
        }

        @Override // d.a.a.c
        public int c() {
            return this.f6040e;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f6041f = true;
            this.f6036a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s > i) {
            throw d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        }
        return (short) (i - s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(e.e eVar) throws IOException {
        return ((eVar.j() & Constants.UNKNOWN) << 16) | ((eVar.j() & Constants.UNKNOWN) << 8) | (eVar.j() & Constants.UNKNOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(e.d dVar, int i) throws IOException {
        dVar.j((i >>> 16) & 255);
        dVar.j((i >>> 8) & 255);
        dVar.j(i & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    @Override // d.a.a.p
    public d.a.a.b a(e.e eVar, boolean z) {
        return new c(eVar, 4096, z);
    }

    @Override // d.a.a.p
    public d.a.a.c a(e.d dVar, boolean z) {
        return new d(dVar, z);
    }
}
