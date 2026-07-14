package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class kw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4665a;

    public static class a implements lb<kw> {
        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kw b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.kw.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            kw kwVar = new kw();
            kwVar.f4665a = dataInputStream.readUTF();
            return kwVar;
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, kw kwVar) throws IOException {
            if (outputStream == null || kwVar == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.kw.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            dataOutputStream.writeUTF(kwVar.f4665a);
            dataOutputStream.flush();
        }
    }

    private kw() {
    }

    public kw(String str) {
        this.f4665a = str;
    }

    public String a() {
        return this.f4665a;
    }
}
