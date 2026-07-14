package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public interface lb<ObjectType> {
    void a(OutputStream outputStream, ObjectType objecttype) throws IOException;

    ObjectType b(InputStream inputStream) throws IOException;
}
