package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class kx implements lb<byte[]> {
    @Override // com.flurry.sdk.lb
    public void a(OutputStream outputStream, byte[] bArr) throws IOException {
        if (outputStream == null || bArr == null) {
            return;
        }
        outputStream.write(bArr, 0, bArr.length);
    }

    @Override // com.flurry.sdk.lb
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        lt.a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
