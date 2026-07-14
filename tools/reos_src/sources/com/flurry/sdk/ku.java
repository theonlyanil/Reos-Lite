package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class ku {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4649b = ku.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f4650a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f4651c;

    public static class a implements lb<ku> {
        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ku b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.ku.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            ku kuVar = new ku();
            int i = dataInputStream.readShort();
            if (i == 0) {
                return null;
            }
            kuVar.f4651c = new byte[i];
            dataInputStream.readFully(kuVar.f4651c);
            if (dataInputStream.readUnsignedShort() == 0) {
            }
            return kuVar;
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, ku kuVar) throws IOException {
            if (outputStream == null || kuVar == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.ku.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            dataOutputStream.writeShort(kuVar.f4651c.length);
            dataOutputStream.write(kuVar.f4651c);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
        }
    }

    private ku() {
        this.f4650a = null;
        this.f4651c = null;
    }

    public ku(byte[] bArr) {
        this.f4650a = null;
        this.f4651c = null;
        this.f4650a = UUID.randomUUID().toString();
        this.f4651c = bArr;
    }

    public static String a(String str) {
        return ".yflurrydatasenderblock." + str;
    }

    public String a() {
        return this.f4650a;
    }

    public byte[] b() {
        return this.f4651c;
    }
}
