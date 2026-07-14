package com.a.a.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f1952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f1953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f1954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f1955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1956f;
    private long g;
    private final int h;
    private Writer j;
    private int l;
    private long i = 0;
    private final LinkedHashMap<String, b> k = new LinkedHashMap<>(0, 0.75f, true);
    private long m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ThreadPoolExecutor f1951a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new Callable<Void>() { // from class: com.a.a.a.a.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.j != null) {
                    a.this.g();
                    if (a.this.e()) {
                        a.this.d();
                        a.this.l = 0;
                    }
                }
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: com.a.a.a.a$a, reason: collision with other inner class name */
    public final class C0036a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f1959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean[] f1960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1961d;

        private C0036a(b bVar) {
            this.f1959b = bVar;
            this.f1960c = bVar.f1967f ? null : new boolean[a.this.h];
        }

        public File a(int i) throws IOException {
            File fileB;
            synchronized (a.this) {
                if (this.f1959b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f1959b.f1967f) {
                    this.f1960c[i] = true;
                }
                fileB = this.f1959b.b(i);
                if (!a.this.f1952b.exists()) {
                    a.this.f1952b.mkdirs();
                }
            }
            return fileB;
        }

        public void a() throws IOException {
            a.this.a(this, true);
            this.f1961d = true;
        }

        public void b() throws IOException {
            a.this.a(this, false);
        }

        public void c() {
            if (this.f1961d) {
                return;
            }
            try {
                b();
            } catch (IOException e2) {
            }
        }
    }

    private final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        File[] f1962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        File[] f1963b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f1965d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long[] f1966e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1967f;
        private C0036a g;
        private long h;

        private b(String str) {
            this.f1965d = str;
            this.f1966e = new long[a.this.h];
            this.f1962a = new File[a.this.h];
            this.f1963b = new File[a.this.h];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < a.this.h; i++) {
                sbAppend.append(i);
                this.f1962a[i] = new File(a.this.f1952b, sbAppend.toString());
                sbAppend.append(".tmp");
                this.f1963b[i] = new File(a.this.f1952b, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != a.this.h) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f1966e[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e2) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f1962a[i];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f1966e) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return this.f1963b[i];
        }
    }

    public final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f1969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f1970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f1971d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final File[] f1972e;

        private c(String str, long j, File[] fileArr, long[] jArr) {
            this.f1969b = str;
            this.f1970c = j;
            this.f1972e = fileArr;
            this.f1971d = jArr;
        }

        public File a(int i) {
            return this.f1972e[i];
        }
    }

    private a(File file, int i, int i2, long j) {
        this.f1952b = file;
        this.f1956f = i;
        this.f1953c = new File(file, "journal");
        this.f1954d = new File(file, "journal.tmp");
        this.f1955e = new File(file, "journal.bkp");
        this.h = i2;
        this.g = j;
    }

    private synchronized C0036a a(String str, long j) throws IOException {
        b bVar;
        C0036a c0036a;
        f();
        b bVar2 = this.k.get(str);
        if (j == -1 || (bVar2 != null && bVar2.h == j)) {
            if (bVar2 == null) {
                b bVar3 = new b(str);
                this.k.put(str, bVar3);
                bVar = bVar3;
            } else if (bVar2.g != null) {
                c0036a = null;
            } else {
                bVar = bVar2;
            }
            c0036a = new C0036a(bVar);
            bVar.g = c0036a;
            this.j.append((CharSequence) "DIRTY");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            this.j.flush();
        } else {
            c0036a = null;
        }
        return c0036a;
    }

    public static a a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j);
        if (aVar.f1953c.exists()) {
            try {
                aVar.b();
                aVar.c();
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.a();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.d();
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x005c A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0062 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0068 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0089 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x009e A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00cb A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00e8 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f1 A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0086 A[SYNTHETIC] */
    public synchronized void a(C0036a c0036a, boolean z) throws IOException {
        File fileB;
        synchronized (this) {
            b bVar = c0036a.f1959b;
            if (bVar.g != c0036a) {
                throw new IllegalStateException();
            }
            if (!z || bVar.f1967f) {
                for (int i = 0; i < this.h; i++) {
                    fileB = bVar.b(i);
                    if (z) {
                        a(fileB);
                    } else if (fileB.exists()) {
                        File fileA = bVar.a(i);
                        fileB.renameTo(fileA);
                        long j = bVar.f1966e[i];
                        long length = fileA.length();
                        bVar.f1966e[i] = length;
                        this.i = (this.i - j) + length;
                    }
                }
                this.l++;
                bVar.g = null;
                if (bVar.f1967f || z) {
                    bVar.f1967f = true;
                    this.j.append((CharSequence) "CLEAN");
                    this.j.append(' ');
                    this.j.append((CharSequence) bVar.f1965d);
                    this.j.append((CharSequence) bVar.a());
                    this.j.append('\n');
                    if (z) {
                        long j2 = this.m;
                        this.m = 1 + j2;
                        bVar.h = j2;
                    }
                } else {
                    this.k.remove(bVar.f1965d);
                    this.j.append((CharSequence) "REMOVE");
                    this.j.append(' ');
                    this.j.append((CharSequence) bVar.f1965d);
                    this.j.append('\n');
                }
                this.j.flush();
                if (this.i <= this.g || e()) {
                    this.f1951a.submit(this.n);
                }
            } else {
                for (int i2 = 0; i2 < this.h; i2++) {
                    if (!c0036a.f1960c[i2]) {
                        c0036a.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                    if (!bVar.b(i2).exists()) {
                        c0036a.b();
                    }
                }
                while (i < this.h) {
                    fileB = bVar.b(i);
                    if (z) {
                        a(fileB);
                    } else if (fileB.exists()) {
                        File fileA2 = bVar.a(i);
                        fileB.renameTo(fileA2);
                        long j3 = bVar.f1966e[i];
                        long length2 = fileA2.length();
                        bVar.f1966e[i] = length2;
                        this.i = (this.i - j3) + length2;
                    }
                }
                this.l++;
                bVar.g = null;
                if (bVar.f1967f || z) {
                    bVar.f1967f = true;
                    this.j.append((CharSequence) "CLEAN");
                    this.j.append(' ');
                    this.j.append((CharSequence) bVar.f1965d);
                    this.j.append((CharSequence) bVar.a());
                    this.j.append('\n');
                    if (z) {
                        long j4 = this.m;
                        this.m = 1 + j4;
                        bVar.h = j4;
                    }
                } else {
                    this.k.remove(bVar.f1965d);
                    this.j.append((CharSequence) "REMOVE");
                    this.j.append(' ');
                    this.j.append((CharSequence) bVar.f1965d);
                    this.j.append('\n');
                }
                this.j.flush();
                if (this.i <= this.g) {
                    this.f1951a.submit(this.n);
                } else {
                    this.f1951a.submit(this.n);
                }
            }
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void b() throws IOException {
        com.a.a.a.b bVar = new com.a.a.a.b(new FileInputStream(this.f1953c), com.a.a.a.c.f1979a);
        try {
            String strA = bVar.a();
            String strA2 = bVar.a();
            String strA3 = bVar.a();
            String strA4 = bVar.a();
            String strA5 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.f1956f).equals(strA3) || !Integer.toString(this.h).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i++;
                } catch (EOFException e2) {
                    this.l = i - this.k.size();
                    if (bVar.b()) {
                        d();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1953c, true), com.a.a.a.c.f1979a));
                    }
                    com.a.a.a.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.a.a.a.c.a(bVar);
            throw th;
        }
    }

    private void c() throws IOException {
        a(this.f1954d);
        Iterator<b> it = this.k.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.g == null) {
                for (int i = 0; i < this.h; i++) {
                    this.i += next.f1966e[i];
                }
            } else {
                next.g = null;
                for (int i2 = 0; i2 < this.h; i2++) {
                    a(next.a(i2));
                    a(next.b(i2));
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() throws IOException {
        if (this.j != null) {
            this.j.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1954d), com.a.a.a.c.f1979a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f1956f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.k.values()) {
                if (bVar.g != null) {
                    bufferedWriter.write("DIRTY " + bVar.f1965d + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.f1965d + bVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f1953c.exists()) {
                a(this.f1953c, this.f1955e, true);
            }
            a(this.f1954d, this.f1953c, false);
            this.f1955e.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1953c, true), com.a.a.a.c.f1979a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
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
                this.k.remove(strSubstring2);
                return;
            }
            strSubstring = strSubstring2;
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.k.get(strSubstring);
        if (bVar == null) {
            bVar = new b(strSubstring);
            this.k.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bVar.f1967f = true;
            bVar.g = null;
            bVar.a(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            bVar.g = new C0036a(bVar);
        } else if (iIndexOf2 != -1 || iIndexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return this.l >= 2000 && this.l >= this.k.size();
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws IOException {
        while (this.i > this.g) {
            c(this.k.entrySet().iterator().next().getKey());
        }
    }

    public synchronized c a(String str) throws IOException {
        c cVar = null;
        synchronized (this) {
            f();
            b bVar = this.k.get(str);
            if (bVar != null && bVar.f1967f) {
                for (File file : bVar.f1962a) {
                    if (file.exists()) {
                    }
                }
                this.l++;
                this.j.append((CharSequence) "READ");
                this.j.append(' ');
                this.j.append((CharSequence) str);
                this.j.append('\n');
                if (e()) {
                    this.f1951a.submit(this.n);
                }
                cVar = new c(str, bVar.h, bVar.f1962a, bVar.f1966e);
            }
        }
        return cVar;
    }

    public void a() throws IOException {
        close();
        com.a.a.a.c.a(this.f1952b);
    }

    public C0036a b(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized boolean c(String str) throws IOException {
        boolean z;
        synchronized (this) {
            f();
            b bVar = this.k.get(str);
            if (bVar == null || bVar.g != null) {
                z = false;
            } else {
                for (int i = 0; i < this.h; i++) {
                    File fileA = bVar.a(i);
                    if (fileA.exists() && !fileA.delete()) {
                        throw new IOException("failed to delete " + fileA);
                    }
                    this.i -= bVar.f1966e[i];
                    bVar.f1966e[i] = 0;
                }
                this.l++;
                this.j.append((CharSequence) "REMOVE");
                this.j.append(' ');
                this.j.append((CharSequence) str);
                this.j.append('\n');
                this.k.remove(str);
                if (e()) {
                    this.f1951a.submit(this.n);
                }
                z = true;
            }
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.j != null) {
            for (b bVar : new ArrayList(this.k.values())) {
                if (bVar.g != null) {
                    bVar.g.b();
                }
            }
            g();
            this.j.close();
            this.j = null;
        }
    }
}
