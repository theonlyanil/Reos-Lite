package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class s implements com.a.a.d.d.a.a<ParcelFileDescriptor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f2272a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2274c;

    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public s() {
        this(f2272a, -1);
    }

    s(a aVar, int i) {
        this.f2273b = aVar;
        this.f2274c = i;
    }

    public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, com.a.a.d.b.a.c cVar, int i, int i2, com.a.a.d.a aVar) throws IOException {
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f2273b.a();
        mediaMetadataRetrieverA.setDataSource(parcelFileDescriptor.getFileDescriptor());
        Bitmap frameAtTime = this.f2274c >= 0 ? mediaMetadataRetrieverA.getFrameAtTime(this.f2274c) : mediaMetadataRetrieverA.getFrameAtTime();
        mediaMetadataRetrieverA.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    @Override // com.a.a.d.d.a.a
    public String a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
