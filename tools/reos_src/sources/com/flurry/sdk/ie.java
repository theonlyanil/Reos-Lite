package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f4271c;

    public static class a implements lb<ie> {
        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ie b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.ie.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            ie ieVar = new ie();
            ieVar.f4269a = dataInputStream.readLong();
            ieVar.f4270b = dataInputStream.readBoolean();
            ieVar.f4271c = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(ieVar.f4271c);
            return ieVar;
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, ie ieVar) throws IOException {
            if (outputStream == null || ieVar == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.ie.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            dataOutputStream.writeLong(ieVar.f4269a);
            dataOutputStream.writeBoolean(ieVar.f4270b);
            dataOutputStream.writeInt(ieVar.f4271c.length);
            dataOutputStream.write(ieVar.f4271c);
            dataOutputStream.flush();
        }
    }

    public long a() {
        return this.f4269a;
    }

    public void a(long j) {
        this.f4269a = j;
    }

    public void a(boolean z) {
        this.f4270b = z;
    }

    public void a(byte[] bArr) {
        this.f4271c = bArr;
    }

    public boolean b() {
        return this.f4270b;
    }

    public byte[] c() {
        return this.f4271c;
    }
}
