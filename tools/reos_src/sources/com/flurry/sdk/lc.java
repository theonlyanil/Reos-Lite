package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class lc implements lb<String> {
    @Override // com.flurry.sdk.lb
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        lt.a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toString();
    }

    @Override // com.flurry.sdk.lb
    public void a(OutputStream outputStream, String str) throws IOException {
        if (outputStream == null || str == null) {
            return;
        }
        byte[] bytes = str.getBytes("utf-8");
        outputStream.write(bytes, 0, bytes.length);
    }
}
