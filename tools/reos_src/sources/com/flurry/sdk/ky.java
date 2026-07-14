package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ky<ObjectType> implements lb<ObjectType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final lb<ObjectType> f4668a;

    public ky(lb<ObjectType> lbVar) {
        this.f4668a = lbVar;
    }

    @Override // com.flurry.sdk.lb
    public void a(OutputStream outputStream, ObjectType objecttype) throws IOException {
        if (this.f4668a == null || outputStream == null || objecttype == null) {
            return;
        }
        this.f4668a.a(outputStream, objecttype);
    }

    @Override // com.flurry.sdk.lb
    public ObjectType b(InputStream inputStream) throws IOException {
        if (this.f4668a == null || inputStream == null) {
            return null;
        }
        return this.f4668a.b(inputStream);
    }
}
