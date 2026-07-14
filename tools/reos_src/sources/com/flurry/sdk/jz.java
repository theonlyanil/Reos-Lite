package com.flurry.sdk;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class jz<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4541a = jz.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f4542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final lb<T> f4543c;

    public jz(File file, String str, int i, le<T> leVar) {
        this.f4542b = file;
        this.f4543c = new kz(new ld(str, i, leVar));
    }

    public T a() throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        T tB = null;
        if (this.f4542b != null) {
            if (this.f4542b.exists()) {
                boolean z = false;
                try {
                    try {
                        fileInputStream = new FileInputStream(this.f4542b);
                        try {
                            tB = this.f4543c.b(fileInputStream);
                            lt.a((Closeable) fileInputStream);
                        } catch (Exception e2) {
                            e = e2;
                            kg.a(3, f4541a, "Error reading data file:" + this.f4542b.getName(), e);
                            z = true;
                            lt.a((Closeable) fileInputStream);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        lt.a((Closeable) fileInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th3) {
                    fileInputStream = null;
                    th = th3;
                    lt.a((Closeable) fileInputStream);
                    throw th;
                }
                if (z) {
                    kg.a(3, f4541a, "Deleting data file:" + this.f4542b.getName());
                    this.f4542b.delete();
                }
            } else {
                kg.a(5, f4541a, "No data to read for file:" + this.f4542b.getName());
            }
        }
        return tB;
    }

    public void a(T t) throws Throwable {
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            if (t == null) {
                kg.a(3, f4541a, "No data to write for file:" + this.f4542b.getName());
                z = true;
            } else {
                try {
                    if (!ls.a(this.f4542b)) {
                        throw new IOException("Cannot create parent directory!");
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.f4542b);
                    try {
                        this.f4543c.a(fileOutputStream2, t);
                        lt.a(fileOutputStream2);
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        kg.a(3, f4541a, "Error writing data file:" + this.f4542b.getName(), e);
                        lt.a(fileOutputStream);
                        z = true;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        lt.a(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (z) {
                kg.a(3, f4541a, "Deleting data file:" + this.f4542b.getName());
                this.f4542b.delete();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean b() {
        if (this.f4542b == null) {
            return false;
        }
        return this.f4542b.delete();
    }
}
