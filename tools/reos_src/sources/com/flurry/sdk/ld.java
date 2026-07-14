package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ld<T> implements lb<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final le<T> f4674c;

    public ld(String str, int i, le<T> leVar) {
        this.f4672a = str;
        this.f4673b = i;
        this.f4674c = leVar;
    }

    @Override // com.flurry.sdk.lb
    public void a(OutputStream outputStream, T t) throws IOException {
        if (outputStream == null || this.f4674c == null) {
            return;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.ld.1
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
        dataOutputStream.writeUTF(this.f4672a);
        dataOutputStream.writeInt(this.f4673b);
        lb<T> lbVarA = this.f4674c.a(this.f4673b);
        if (lbVarA == null) {
            throw new IOException("No serializer for version: " + this.f4673b);
        }
        lbVarA.a(dataOutputStream, t);
        dataOutputStream.flush();
    }

    @Override // com.flurry.sdk.lb
    public T b(InputStream inputStream) throws IOException {
        if (inputStream == null || this.f4674c == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.ld.2
            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
        String utf = dataInputStream.readUTF();
        if (!this.f4672a.equals(utf)) {
            throw new IOException("Signature: " + utf + " is invalid");
        }
        int i = dataInputStream.readInt();
        lb<T> lbVarA = this.f4674c.a(i);
        if (lbVarA == null) {
            throw new IOException("No serializer for version: " + i);
        }
        return lbVarA.b(dataInputStream);
    }
}
