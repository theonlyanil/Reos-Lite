package com.facebook.b;

import com.android.library.userprofile.util.Constants;
import com.google.android.gms.location.places.Place;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f3753a = n.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f3754b = new AtomicLong();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f3756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f3757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3758f;
    private boolean g;
    private AtomicLong i = new AtomicLong(0);
    private final Object h = new Object();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final FilenameFilter f3764a = new FilenameFilter() { // from class: com.facebook.b.n.a.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return !str.startsWith("buffer");
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FilenameFilter f3765b = new FilenameFilter() { // from class: com.facebook.b.n.a.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("buffer");
            }
        };

        static FilenameFilter a() {
            return f3764a;
        }

        static void a(File file) {
            File[] fileArrListFiles = file.listFiles(b());
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    file2.delete();
                }
            }
        }

        static File b(File file) {
            return new File(file, "buffer" + Long.valueOf(n.f3754b.incrementAndGet()).toString());
        }

        static FilenameFilter b() {
            return f3765b;
        }
    }

    private static class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OutputStream f3766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final f f3767b;

        b(OutputStream outputStream, f fVar) {
            this.f3766a = outputStream;
            this.f3767b = fVar;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.f3766a.close();
            } finally {
                this.f3767b.a();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f3766a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f3766a.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f3766a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f3766a.write(bArr, i, i2);
        }
    }

    private static final class c extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final InputStream f3768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final OutputStream f3769b;

        c(InputStream inputStream, OutputStream outputStream) {
            this.f3768a = inputStream;
            this.f3769b = outputStream;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f3768a.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.f3768a.close();
            } finally {
                this.f3769b.close();
            }
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i = this.f3768a.read();
            if (i >= 0) {
                this.f3769b.write(i);
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int i = this.f3768a.read(bArr);
            if (i > 0) {
                this.f3769b.write(bArr, 0, i);
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f3768a.read(bArr, i, i2);
            if (i3 > 0) {
                this.f3769b.write(bArr, i, i3);
            }
            return i3;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            int i;
            byte[] bArr = new byte[Place.TYPE_SUBLOCALITY_LEVEL_2];
            long j2 = 0;
            while (j2 < j && (i = read(bArr, 0, (int) Math.min(j - j2, bArr.length))) >= 0) {
                j2 += (long) i;
            }
            return j2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3771b = Place.TYPE_SUBLOCALITY_LEVEL_2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3770a = 1048576;

        int a() {
            return this.f3770a;
        }

        int b() {
            return this.f3771b;
        }
    }

    private static final class e implements Comparable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f3772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f3773b;

        e(File file) {
            this.f3772a = file;
            this.f3773b = file.lastModified();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            if (b() < eVar.b()) {
                return -1;
            }
            if (b() > eVar.b()) {
                return 1;
            }
            return a().compareTo(eVar.a());
        }

        File a() {
            return this.f3772a;
        }

        long b() {
            return this.f3773b;
        }

        public boolean equals(Object obj) {
            return (obj instanceof e) && compareTo((e) obj) == 0;
        }

        public int hashCode() {
            return ((this.f3772a.hashCode() + 1073) * 37) + ((int) (this.f3773b % 2147483647L));
        }
    }

    private interface f {
        void a();
    }

    private static final class g {
        static JSONObject a(InputStream inputStream) throws IOException {
            JSONObject jSONObject;
            int i = 0;
            if (inputStream.read() != 0) {
                return null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = inputStream.read();
                if (i4 == -1) {
                    v.a(com.facebook.u.CACHE, n.f3753a, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (i4 & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < bArr.length) {
                int i5 = inputStream.read(bArr, i, bArr.length - i);
                if (i5 < 1) {
                    v.a(com.facebook.u.CACHE, n.f3753a, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + bArr.length);
                    return null;
                }
                i += i5;
            }
            try {
                Object objNextValue = new JSONTokener(new String(bArr)).nextValue();
                if (objNextValue instanceof JSONObject) {
                    jSONObject = (JSONObject) objNextValue;
                } else {
                    v.a(com.facebook.u.CACHE, n.f3753a, "readHeader: expected JSONObject, got " + objNextValue.getClass().getCanonicalName());
                    jSONObject = null;
                }
                return jSONObject;
            } catch (JSONException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        static void a(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }
    }

    public n(String str, d dVar) {
        this.f3755c = str;
        this.f3756d = dVar;
        this.f3757e = new File(com.facebook.m.m(), str);
        if (this.f3757e.mkdirs() || this.f3757e.isDirectory()) {
            a.a(this.f3757e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, File file) {
        if (!file.renameTo(new File(this.f3757e, ad.b(str)))) {
            file.delete();
        }
        b();
    }

    private void b() {
        synchronized (this.h) {
            if (!this.f3758f) {
                this.f3758f = true;
                com.facebook.m.d().execute(new Runnable() { // from class: com.facebook.b.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.c();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.h) {
            this.f3758f = false;
            this.g = true;
        }
        try {
            v.a(com.facebook.u.CACHE, f3753a, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            long length = 0;
            long j = 0;
            File[] fileArrListFiles = this.f3757e.listFiles(a.a());
            if (fileArrListFiles != null) {
                int length2 = fileArrListFiles.length;
                int i = 0;
                while (i < length2) {
                    File file = fileArrListFiles[i];
                    e eVar = new e(file);
                    priorityQueue.add(eVar);
                    v.a(com.facebook.u.CACHE, f3753a, "  trim considering time=" + Long.valueOf(eVar.b()) + " name=" + eVar.a().getName());
                    i++;
                    j = 1 + j;
                    length = file.length() + length;
                }
            }
            long length3 = length;
            while (true) {
                long j2 = j;
                if (length3 <= this.f3756d.a() && j2 <= this.f3756d.b()) {
                    synchronized (this.h) {
                        this.g = false;
                        this.h.notifyAll();
                    }
                    return;
                }
                File fileA = ((e) priorityQueue.remove()).a();
                v.a(com.facebook.u.CACHE, f3753a, "  trim removing " + fileA.getName());
                length3 -= fileA.length();
                j = j2 - 1;
                fileA.delete();
            }
        } catch (Throwable th) {
            synchronized (this.h) {
                this.g = false;
                this.h.notifyAll();
                throw th;
            }
        }
    }

    public InputStream a(String str) throws IOException {
        return a(str, (String) null);
    }

    public InputStream a(String str, InputStream inputStream) throws IOException {
        return new c(inputStream, b(str));
    }

    public InputStream a(String str, String str2) throws IOException {
        File file = new File(this.f3757e, ad.b(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject jSONObjectA = g.a(bufferedInputStream);
                if (jSONObjectA == null) {
                    bufferedInputStream.close();
                    return null;
                }
                String strOptString = jSONObjectA.optString("key");
                if (strOptString == null || !strOptString.equals(str)) {
                    bufferedInputStream.close();
                    return null;
                }
                String strOptString2 = jSONObjectA.optString(Constants.SMS_COLUMN_TAG, null);
                if ((str2 == null && strOptString2 != null) || (str2 != null && !str2.equals(strOptString2))) {
                    bufferedInputStream.close();
                    return null;
                }
                long time = new Date().getTime();
                v.a(com.facebook.u.CACHE, f3753a, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                file.setLastModified(time);
                return bufferedInputStream;
            } catch (Throwable th) {
                bufferedInputStream.close();
                throw th;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    public OutputStream b(String str) throws IOException {
        return b(str, null);
    }

    public OutputStream b(final String str, String str2) throws IOException {
        final File fileB = a.b(this.f3757e);
        fileB.delete();
        if (!fileB.createNewFile()) {
            throw new IOException("Could not create file at " + fileB.getAbsolutePath());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileB);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new b(fileOutputStream, new f() { // from class: com.facebook.b.n.1
                @Override // com.facebook.b.n.f
                public void a() {
                    if (jCurrentTimeMillis < n.this.i.get()) {
                        fileB.delete();
                    } else {
                        n.this.a(str, fileB);
                    }
                }
            }), 8192);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!ad.a(str2)) {
                        jSONObject.put(Constants.SMS_COLUMN_TAG, str2);
                    }
                    g.a(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e2) {
                    v.a(com.facebook.u.CACHE, 5, f3753a, "Error creating JSON header for cache file: " + e2);
                    throw new IOException(e2.getMessage());
                }
            } catch (Throwable th) {
                bufferedOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e3) {
            v.a(com.facebook.u.CACHE, 5, f3753a, "Error creating buffer output stream: " + e3);
            throw new IOException(e3.getMessage());
        }
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.f3755c + " file:" + this.f3757e.getName() + "}";
    }
}
