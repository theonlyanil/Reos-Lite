package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class kk<ObjectType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4577a = kk.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f4578b = {113, -92, -8, 125, 121, 107, -65, -61, -74, -114, -32, 0, -57, -87, -35, -56, -6, -52, 51, 126, -104, 49, 79, -52, 118, -84, 99, -52, -14, -126, -27, -64};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private lb<ObjectType> f4580d;

    public kk(String str, lb<ObjectType> lbVar) {
        this.f4579c = str;
        this.f4580d = lbVar;
    }

    public static void a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int length = bArr.length;
        int length2 = f4578b.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ((bArr[i] ^ f4578b[i % length2]) ^ ((i * 31) % 251));
        }
    }

    public static void b(byte[] bArr) {
        a(bArr);
    }

    public static int c(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        jy jyVar = new jy();
        jyVar.update(bArr);
        return jyVar.b();
    }

    public byte[] a(ObjectType objecttype) throws IOException {
        if (objecttype == null) {
            throw new IOException("Encoding: " + this.f4579c + ": Nothing to encode");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f4580d.a(byteArrayOutputStream, objecttype);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        kg.a(3, f4577a, "Encoding " + this.f4579c + ": " + new String(byteArray));
        kz kzVar = new kz(new kx());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        kzVar.a(byteArrayOutputStream2, byteArray);
        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
        a(byteArray2);
        return byteArray2;
    }

    public ObjectType d(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new IOException("Decoding: " + this.f4579c + ": Nothing to decode");
        }
        b(bArr);
        byte[] bArr2 = (byte[]) new kz(new kx()).b(new ByteArrayInputStream(bArr));
        kg.a(3, f4577a, "Decoding: " + this.f4579c + ": " + new String(bArr2));
        return this.f4580d.b(new ByteArrayInputStream(bArr2));
    }
}
