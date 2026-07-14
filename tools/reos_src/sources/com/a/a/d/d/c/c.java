package com.a.a.d.d.c;

import com.a.a.d.b.k;
import com.a.a.d.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c<T> implements e<File, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f2278a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e<InputStream, T> f2279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2280c;

    static class a {
        a() {
        }

        public InputStream a(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

    public c(e<InputStream, T> eVar) {
        this(eVar, f2278a);
    }

    c(e<InputStream, T> eVar, a aVar) {
        this.f2279b = eVar;
        this.f2280c = aVar;
    }

    @Override // com.a.a.d.e
    public k<T> a(File file, int i, int i2) throws IOException {
        InputStream inputStreamA = null;
        try {
            inputStreamA = this.f2280c.a(file);
            return this.f2279b.a(inputStreamA, i, i2);
        } finally {
            if (inputStreamA != null) {
                try {
                    inputStreamA.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    @Override // com.a.a.d.e
    public String a() {
        return "";
    }
}
