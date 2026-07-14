package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class m implements com.a.a.d.e<com.a.a.d.c.g, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.e<InputStream, Bitmap> f2253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.e<ParcelFileDescriptor, Bitmap> f2254b;

    public m(com.a.a.d.e<InputStream, Bitmap> eVar, com.a.a.d.e<ParcelFileDescriptor, Bitmap> eVar2) {
        this.f2253a = eVar;
        this.f2254b = eVar2;
    }

    @Override // com.a.a.d.e
    public com.a.a.d.b.k<Bitmap> a(com.a.a.d.c.g gVar, int i, int i2) throws IOException {
        com.a.a.d.b.k<Bitmap> kVarA;
        ParcelFileDescriptor parcelFileDescriptorB;
        InputStream inputStreamA = gVar.a();
        if (inputStreamA != null) {
            try {
                kVarA = this.f2253a.a(inputStreamA, i, i2);
            } catch (IOException e2) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e2);
                }
                kVarA = null;
            }
        } else {
            kVarA = null;
        }
        return (kVarA != null || (parcelFileDescriptorB = gVar.b()) == null) ? kVarA : this.f2254b.a(parcelFileDescriptorB, i, i2);
    }

    @Override // com.a.a.d.e
    public String a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
