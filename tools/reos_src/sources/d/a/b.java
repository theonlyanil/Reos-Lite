package d.a;

import e.n;
import e.s;
import e.t;
import e.u;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f6071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f6072b;
    private static final s v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.a.c.a f6073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f6074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f6075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f6076f;
    private final File g;
    private final int h;
    private long i;
    private final int j;
    private e.d l;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private final Executor t;
    private long k = 0;
    private final LinkedHashMap<String, C0205b> m = new LinkedHashMap<>(0, 0.75f, true);
    private long s = 0;
    private final Runnable u = new Runnable() { // from class: d.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                if ((b.this.p ? false : true) || b.this.q) {
                    return;
                }
                try {
                    b.this.k();
                } catch (IOException e2) {
                    b.this.r = true;
                }
                try {
                    if (b.this.i()) {
                        b.this.h();
                        b.this.n = 0;
                    }
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
    };

    public final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0205b f6081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean[] f6082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f6083d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f6084e;

        private a(C0205b c0205b) {
            this.f6081b = c0205b;
            this.f6082c = c0205b.f6091f ? null : new boolean[b.this.j];
        }

        public s a(int i) throws IOException {
            s sVar;
            synchronized (b.this) {
                if (this.f6081b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f6081b.f6091f) {
                    this.f6082c[i] = true;
                }
                try {
                    sVar = new d.a.c(b.this.f6073c.b(this.f6081b.f6090e[i])) { // from class: d.a.b.a.1
                        @Override // d.a.c
                        protected void a(IOException iOException) {
                            synchronized (b.this) {
                                a.this.f6083d = true;
                            }
                        }
                    };
                } catch (FileNotFoundException e2) {
                    sVar = b.v;
                }
            }
            return sVar;
        }

        public void a() throws IOException {
            synchronized (b.this) {
                if (this.f6083d) {
                    b.this.a(this, false);
                    b.this.a(this.f6081b);
                } else {
                    b.this.a(this, true);
                }
                this.f6084e = true;
            }
        }

        public void b() throws IOException {
            synchronized (b.this) {
                b.this.a(this, false);
            }
        }
    }

    /* JADX INFO: renamed from: d.a.b$b, reason: collision with other inner class name */
    private final class C0205b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f6088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File[] f6089d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final File[] f6090e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f6091f;
        private a g;
        private long h;

        private C0205b(String str) {
            this.f6087b = str;
            this.f6088c = new long[b.this.j];
            this.f6089d = new File[b.this.j];
            this.f6090e = new File[b.this.j];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < b.this.j; i++) {
                sbAppend.append(i);
                this.f6089d[i] = new File(b.this.f6074d, sbAppend.toString());
                sbAppend.append(".tmp");
                this.f6090e[i] = new File(b.this.f6074d, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != b.this.j) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f6088c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e2) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        c a() {
            if (!Thread.holdsLock(b.this)) {
                throw new AssertionError();
            }
            t[] tVarArr = new t[b.this.j];
            long[] jArr = (long[]) this.f6088c.clone();
            for (int i = 0; i < b.this.j; i++) {
                try {
                    tVarArr[i] = b.this.f6073c.a(this.f6089d[i]);
                } catch (FileNotFoundException e2) {
                    for (int i2 = 0; i2 < b.this.j && tVarArr[i2] != null; i2++) {
                        j.a(tVarArr[i2]);
                    }
                    return null;
                }
            }
            return new c(this.f6087b, this.h, tVarArr, jArr);
        }

        void a(e.d dVar) throws IOException {
            for (long j : this.f6088c) {
                dVar.j(32).k(j);
            }
        }
    }

    public final class c implements Closeable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f6094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final t[] f6095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long[] f6096e;

        private c(String str, long j, t[] tVarArr, long[] jArr) {
            this.f6093b = str;
            this.f6094c = j;
            this.f6095d = tVarArr;
            this.f6096e = jArr;
        }

        public a a() throws IOException {
            return b.this.a(this.f6093b, this.f6094c);
        }

        public t a(int i) {
            return this.f6095d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (t tVar : this.f6095d) {
                j.a(tVar);
            }
        }
    }

    static {
        f6072b = !b.class.desiredAssertionStatus();
        f6071a = Pattern.compile("[a-z0-9_-]{1,120}");
        v = new s() { // from class: d.a.b.3
            @Override // e.s
            public u a() {
                return u.f6490b;
            }

            @Override // e.s
            public void a_(e.c cVar, long j) throws IOException {
                cVar.g(j);
            }

            @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // e.s, java.io.Flushable
            public void flush() throws IOException {
            }
        };
    }

    b(d.a.c.a aVar, File file, int i, int i2, long j, Executor executor) {
        this.f6073c = aVar;
        this.f6074d = file;
        this.h = i;
        this.f6075e = new File(file, "journal");
        this.f6076f = new File(file, "journal.tmp");
        this.g = new File(file, "journal.bkp");
        this.j = i2;
        this.i = j;
        this.t = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a a(String str, long j) throws IOException {
        C0205b c0205b;
        a aVar;
        a();
        j();
        e(str);
        C0205b c0205b2 = this.m.get(str);
        if (j != -1 && (c0205b2 == null || c0205b2.h != j)) {
            aVar = null;
        } else if (c0205b2 != null && c0205b2.g != null) {
            aVar = null;
        } else if (this.r) {
            this.t.execute(this.u);
            aVar = null;
        } else {
            this.l.b("DIRTY").j(32).b(str).j(10);
            this.l.flush();
            if (this.o) {
                aVar = null;
            } else {
                if (c0205b2 == null) {
                    C0205b c0205b3 = new C0205b(str);
                    this.m.put(str, c0205b3);
                    c0205b = c0205b3;
                } else {
                    c0205b = c0205b2;
                }
                aVar = new a(c0205b);
                c0205b.g = aVar;
            }
        }
        return aVar;
    }

    public static b a(d.a.c.a aVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        return new b(aVar, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), j.a("OkHttp DiskLruCache", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0060 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0068 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0070 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0097 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ae A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d6 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00f3 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00fc A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0094 A[SYNTHETIC] */
    public synchronized void a(a aVar, boolean z) throws IOException {
        File file;
        synchronized (this) {
            C0205b c0205b = aVar.f6081b;
            if (c0205b.g != aVar) {
                throw new IllegalStateException();
            }
            if (!z || c0205b.f6091f) {
                for (int i = 0; i < this.j; i++) {
                    file = c0205b.f6090e[i];
                    if (z) {
                        this.f6073c.d(file);
                    } else if (this.f6073c.e(file)) {
                        File file2 = c0205b.f6089d[i];
                        this.f6073c.a(file, file2);
                        long j = c0205b.f6088c[i];
                        long jF = this.f6073c.f(file2);
                        c0205b.f6088c[i] = jF;
                        this.k = (this.k - j) + jF;
                    }
                }
                this.n++;
                c0205b.g = null;
                if (c0205b.f6091f || z) {
                    c0205b.f6091f = true;
                    this.l.b("CLEAN").j(32);
                    this.l.b(c0205b.f6087b);
                    c0205b.a(this.l);
                    this.l.j(10);
                    if (z) {
                        long j2 = this.s;
                        this.s = 1 + j2;
                        c0205b.h = j2;
                    }
                } else {
                    this.m.remove(c0205b.f6087b);
                    this.l.b("REMOVE").j(32);
                    this.l.b(c0205b.f6087b);
                    this.l.j(10);
                }
                this.l.flush();
                if (this.k <= this.i || i()) {
                    this.t.execute(this.u);
                }
            } else {
                for (int i2 = 0; i2 < this.j; i2++) {
                    if (!aVar.f6082c[i2]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                    if (!this.f6073c.e(c0205b.f6090e[i2])) {
                        aVar.b();
                    }
                }
                while (i < this.j) {
                    file = c0205b.f6090e[i];
                    if (z) {
                        this.f6073c.d(file);
                    } else if (this.f6073c.e(file)) {
                        File file3 = c0205b.f6089d[i];
                        this.f6073c.a(file, file3);
                        long j3 = c0205b.f6088c[i];
                        long jF2 = this.f6073c.f(file3);
                        c0205b.f6088c[i] = jF2;
                        this.k = (this.k - j3) + jF2;
                    }
                }
                this.n++;
                c0205b.g = null;
                if (c0205b.f6091f || z) {
                    c0205b.f6091f = true;
                    this.l.b("CLEAN").j(32);
                    this.l.b(c0205b.f6087b);
                    c0205b.a(this.l);
                    this.l.j(10);
                    if (z) {
                        long j4 = this.s;
                        this.s = 1 + j4;
                        c0205b.h = j4;
                    }
                } else {
                    this.m.remove(c0205b.f6087b);
                    this.l.b("REMOVE").j(32);
                    this.l.b(c0205b.f6087b);
                    this.l.j(10);
                }
                this.l.flush();
                if (this.k <= this.i) {
                    this.t.execute(this.u);
                } else {
                    this.t.execute(this.u);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(C0205b c0205b) throws IOException {
        if (c0205b.g != null) {
            c0205b.g.f6083d = true;
        }
        for (int i = 0; i < this.j; i++) {
            this.f6073c.d(c0205b.f6089d[i]);
            this.k -= c0205b.f6088c[i];
            c0205b.f6088c[i] = 0;
        }
        this.n++;
        this.l.b("REMOVE").j(32).b(c0205b.f6087b).j(10);
        this.m.remove(c0205b.f6087b);
        if (i()) {
            this.t.execute(this.u);
        }
        return true;
    }

    private void d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            String strSubstring2 = str.substring(i);
            if (iIndexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.m.remove(strSubstring2);
                return;
            }
            strSubstring = strSubstring2;
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        C0205b c0205b = this.m.get(strSubstring);
        if (c0205b == null) {
            c0205b = new C0205b(strSubstring);
            this.m.put(strSubstring, c0205b);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            c0205b.f6091f = true;
            c0205b.g = null;
            c0205b.a(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c0205b.g = new a(c0205b);
        } else if (iIndexOf2 != -1 || iIndexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e() throws IOException {
        e.e eVarA = n.a(this.f6073c.a(this.f6075e));
        try {
            String strS = eVarA.s();
            String strS2 = eVarA.s();
            String strS3 = eVarA.s();
            String strS4 = eVarA.s();
            String strS5 = eVarA.s();
            if (!"libcore.io.DiskLruCache".equals(strS) || !"1".equals(strS2) || !Integer.toString(this.h).equals(strS3) || !Integer.toString(this.j).equals(strS4) || !"".equals(strS5)) {
                throw new IOException("unexpected journal header: [" + strS + ", " + strS2 + ", " + strS4 + ", " + strS5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(eVarA.s());
                    i++;
                } catch (EOFException e2) {
                    this.n = i - this.m.size();
                    if (eVarA.g()) {
                        this.l = f();
                    } else {
                        h();
                    }
                    j.a(eVarA);
                    return;
                }
            }
        } catch (Throwable th) {
            j.a(eVarA);
            throw th;
        }
    }

    private void e(String str) {
        if (!f6071a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private e.d f() throws FileNotFoundException {
        return n.a(new d.a.c(this.f6073c.c(this.f6075e)) { // from class: d.a.b.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ boolean f6078a;

            static {
                f6078a = !b.class.desiredAssertionStatus();
            }

            @Override // d.a.c
            protected void a(IOException iOException) {
                if (!f6078a && !Thread.holdsLock(b.this)) {
                    throw new AssertionError();
                }
                b.this.o = true;
            }
        });
    }

    private void g() throws IOException {
        this.f6073c.d(this.f6076f);
        Iterator<C0205b> it = this.m.values().iterator();
        while (it.hasNext()) {
            C0205b next = it.next();
            if (next.g == null) {
                for (int i = 0; i < this.j; i++) {
                    this.k += next.f6088c[i];
                }
            } else {
                next.g = null;
                for (int i2 = 0; i2 < this.j; i2++) {
                    this.f6073c.d(next.f6089d[i2]);
                    this.f6073c.d(next.f6090e[i2]);
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() throws IOException {
        if (this.l != null) {
            this.l.close();
        }
        e.d dVarA = n.a(this.f6073c.b(this.f6076f));
        try {
            dVarA.b("libcore.io.DiskLruCache").j(10);
            dVarA.b("1").j(10);
            dVarA.k(this.h).j(10);
            dVarA.k(this.j).j(10);
            dVarA.j(10);
            for (C0205b c0205b : this.m.values()) {
                if (c0205b.g != null) {
                    dVarA.b("DIRTY").j(32);
                    dVarA.b(c0205b.f6087b);
                    dVarA.j(10);
                } else {
                    dVarA.b("CLEAN").j(32);
                    dVarA.b(c0205b.f6087b);
                    c0205b.a(dVarA);
                    dVarA.j(10);
                }
            }
            dVarA.close();
            if (this.f6073c.e(this.f6075e)) {
                this.f6073c.a(this.f6075e, this.g);
            }
            this.f6073c.a(this.f6076f, this.f6075e);
            this.f6073c.d(this.g);
            this.l = f();
            this.o = false;
        } catch (Throwable th) {
            dVarA.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return this.n >= 2000 && this.n >= this.m.size();
    }

    private synchronized void j() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws IOException {
        while (this.k > this.i) {
            a(this.m.values().iterator().next());
        }
        this.r = false;
    }

    public synchronized c a(String str) throws IOException {
        c cVarA;
        a();
        j();
        e(str);
        C0205b c0205b = this.m.get(str);
        if (c0205b == null || !c0205b.f6091f || (cVarA = c0205b.a()) == null) {
            cVarA = null;
        } else {
            this.n++;
            this.l.b("READ").j(32).b(str).j(10);
            if (i()) {
                this.t.execute(this.u);
            }
        }
        return cVarA;
    }

    public synchronized void a() throws IOException {
        if (!f6072b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.p) {
            if (this.f6073c.e(this.g)) {
                if (this.f6073c.e(this.f6075e)) {
                    this.f6073c.d(this.g);
                } else {
                    this.f6073c.a(this.g, this.f6075e);
                }
            }
            if (this.f6073c.e(this.f6075e)) {
                try {
                    e();
                    g();
                    this.p = true;
                } catch (IOException e2) {
                    h.a().a("DiskLruCache " + this.f6074d + " is corrupt: " + e2.getMessage() + ", removing");
                    c();
                    this.q = false;
                    h();
                    this.p = true;
                }
            } else {
                h();
                this.p = true;
            }
        }
    }

    public a b(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized boolean b() {
        return this.q;
    }

    public void c() throws IOException {
        close();
        this.f6073c.g(this.f6074d);
    }

    public synchronized boolean c(String str) throws IOException {
        boolean zA;
        a();
        j();
        e(str);
        C0205b c0205b = this.m.get(str);
        if (c0205b == null) {
            zA = false;
        } else {
            zA = a(c0205b);
            if (zA && this.k <= this.i) {
                this.r = false;
            }
        }
        return zA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.p || this.q) {
            this.q = true;
        } else {
            for (C0205b c0205b : (C0205b[]) this.m.values().toArray(new C0205b[this.m.size()])) {
                if (c0205b.g != null) {
                    c0205b.g.b();
                }
            }
            k();
            this.l.close();
            this.l = null;
            this.q = true;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.p) {
            j();
            k();
            this.l.flush();
        }
    }
}
