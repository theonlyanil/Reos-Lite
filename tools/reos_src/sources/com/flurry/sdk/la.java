package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class la<T> implements lb<List<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    lb<T> f4669a;

    public la(lb<T> lbVar) {
        if (lbVar == null) {
            throw new IllegalArgumentException("recordSerializer cannot be null");
        }
        this.f4669a = lbVar;
    }

    @Override // com.flurry.sdk.lb
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<T> b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        int i = new DataInputStream(inputStream) { // from class: com.flurry.sdk.la.2
            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            T tB = this.f4669a.b(inputStream);
            if (tB == null) {
                throw new IOException("Missing record.");
            }
            arrayList.add(tB);
        }
        return arrayList;
    }

    @Override // com.flurry.sdk.lb
    public void a(OutputStream outputStream, List<T> list) throws IOException {
        if (outputStream == null) {
            return;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.la.1
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
        int size = list != null ? list.size() : 0;
        dataOutputStream.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.f4669a.a(outputStream, list.get(i));
        }
        dataOutputStream.flush();
    }
}
