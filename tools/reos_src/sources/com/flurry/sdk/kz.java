package com.flurry.sdk;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class kz<ObjectType> extends ky<ObjectType> {
    public kz(lb<ObjectType> lbVar) {
        super(lbVar);
    }

    @Override // com.flurry.sdk.ky, com.flurry.sdk.lb
    public void a(OutputStream outputStream, ObjectType objecttype) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        if (outputStream == null) {
            return;
        }
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                super.a(gZIPOutputStream, objecttype);
                lt.a(gZIPOutputStream);
            } catch (Throwable th) {
                th = th;
                lt.a(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
        }
    }

    @Override // com.flurry.sdk.ky, com.flurry.sdk.lb
    public ObjectType b(InputStream inputStream) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        ObjectType objecttype = null;
        if (inputStream != null) {
            try {
                gZIPInputStream = new GZIPInputStream(inputStream);
                try {
                    objecttype = (ObjectType) super.b(gZIPInputStream);
                    lt.a((Closeable) gZIPInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    lt.a((Closeable) gZIPInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                gZIPInputStream = null;
                th = th3;
            }
        }
        return objecttype;
    }
}
