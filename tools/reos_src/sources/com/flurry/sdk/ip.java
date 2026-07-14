package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f4361a;

    public static class a implements lb<ip> {
        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ip b(InputStream inputStream) throws IOException {
            DataInputStream dataInputStream;
            int i;
            ip ipVar = null;
            if (inputStream != null && (i = (dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.ip.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            }).readShort()) != 0) {
                ipVar = new ip();
                ipVar.f4361a = new byte[i];
                dataInputStream.readFully(ipVar.f4361a);
                if (dataInputStream.readUnsignedShort() == 0) {
                }
            }
            return ipVar;
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, ip ipVar) throws IOException {
            if (outputStream == null || ipVar == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.ip.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            dataOutputStream.writeShort(ipVar.f4361a.length);
            dataOutputStream.write(ipVar.f4361a);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
        }
    }

    public ip() {
    }

    public ip(byte[] bArr) {
        this.f4361a = bArr;
    }

    public byte[] a() {
        return this.f4361a;
    }
}
