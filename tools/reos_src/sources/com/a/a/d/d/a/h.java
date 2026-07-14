package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class h implements com.a.a.d.e<ParcelFileDescriptor, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f2228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.a.d.a f2230c;

    public h(com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this(new s(), cVar, aVar);
    }

    public h(s sVar, com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this.f2228a = sVar;
        this.f2229b = cVar;
        this.f2230c = aVar;
    }

    @Override // com.a.a.d.e
    public com.a.a.d.b.k<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) throws IOException {
        return c.a(this.f2228a.a(parcelFileDescriptor, this.f2229b, i, i2, this.f2230c), this.f2229b);
    }

    @Override // com.a.a.d.e
    public String a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
