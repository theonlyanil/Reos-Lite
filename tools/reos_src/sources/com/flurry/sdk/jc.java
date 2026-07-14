package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class jc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4445a = jc.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<iz> f4448d = new ArrayList();

    public static class a implements lb<jc> {
        @Override // com.flurry.sdk.lb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public jc b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.jc.a.1
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            jc jcVar = new jc();
            dataInputStream.readUTF();
            dataInputStream.readUTF();
            jcVar.f4446b = dataInputStream.readBoolean();
            jcVar.f4447c = dataInputStream.readLong();
            while (true) {
                int unsignedShort = dataInputStream.readUnsignedShort();
                if (unsignedShort == 0) {
                    return jcVar;
                }
                byte[] bArr = new byte[unsignedShort];
                dataInputStream.readFully(bArr);
                jcVar.f4448d.add(0, new iz(bArr));
            }
        }

        @Override // com.flurry.sdk.lb
        public void a(OutputStream outputStream, jc jcVar) throws IOException {
            throw new UnsupportedOperationException("Serialization not supported");
        }
    }

    public boolean a() {
        return this.f4446b;
    }

    public long b() {
        return this.f4447c;
    }

    public List<iz> c() {
        return Collections.unmodifiableList(this.f4448d);
    }
}
