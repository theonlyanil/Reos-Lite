package com.a.a.d.d.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class i implements com.a.a.d.e<InputStream, com.a.a.d.d.d.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f2318a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f2319b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f2320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f2321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f2323f;
    private final com.a.a.d.d.d.a g;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<com.a.a.b.a> f2324a = com.a.a.j.h.a(0);

        a() {
        }

        public synchronized com.a.a.b.a a(com.a.a.b.a.InterfaceC0037a interfaceC0037a) {
            com.a.a.b.a aVarPoll;
            aVarPoll = this.f2324a.poll();
            if (aVarPoll == null) {
                aVarPoll = new com.a.a.b.a(interfaceC0037a);
            }
            return aVarPoll;
        }

        public synchronized void a(com.a.a.b.a aVar) {
            aVar.g();
            this.f2324a.offer(aVar);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<com.a.a.b.d> f2325a = com.a.a.j.h.a(0);

        b() {
        }

        public synchronized com.a.a.b.d a(byte[] bArr) {
            com.a.a.b.d dVarPoll;
            dVarPoll = this.f2325a.poll();
            if (dVarPoll == null) {
                dVarPoll = new com.a.a.b.d();
            }
            return dVarPoll.a(bArr);
        }

        public synchronized void a(com.a.a.b.d dVar) {
            dVar.a();
            this.f2325a.offer(dVar);
        }
    }

    public i(Context context, com.a.a.d.b.a.c cVar) {
        this(context, cVar, f2318a, f2319b);
    }

    i(Context context, com.a.a.d.b.a.c cVar, b bVar, a aVar) {
        this.f2320c = context;
        this.f2322e = cVar;
        this.f2323f = aVar;
        this.g = new com.a.a.d.d.d.a(cVar);
        this.f2321d = bVar;
    }

    private Bitmap a(com.a.a.b.a aVar, com.a.a.b.c cVar, byte[] bArr) {
        aVar.a(cVar, bArr);
        aVar.a();
        return aVar.f();
    }

    private d a(byte[] bArr, int i, int i2, com.a.a.b.d dVar, com.a.a.b.a aVar) {
        Bitmap bitmapA;
        com.a.a.b.c cVarB = dVar.b();
        if (cVarB.a() <= 0 || cVarB.b() != 0 || (bitmapA = a(aVar, cVarB, bArr)) == null) {
            return null;
        }
        return new d(new com.a.a.d.d.d.b(this.f2320c, this.g, this.f2322e, com.a.a.d.d.d.b(), i, i2, cVarB, bArr, bitmapA));
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e2) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.a.a.d.e
    public d a(InputStream inputStream, int i, int i2) {
        byte[] bArrA = a(inputStream);
        com.a.a.b.d dVarA = this.f2321d.a(bArrA);
        com.a.a.b.a aVarA = this.f2323f.a(this.g);
        try {
            return a(bArrA, i, i2, dVarA, aVarA);
        } finally {
            this.f2321d.a(dVarA);
            this.f2323f.a(aVarA);
        }
    }

    @Override // com.a.a.d.e
    public String a() {
        return "";
    }
}
