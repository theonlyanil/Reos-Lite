package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.a.a.d.f<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap.CompressFormat f2214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2215b;

    public b() {
        this(null, 90);
    }

    public b(Bitmap.CompressFormat compressFormat, int i) {
        this.f2214a = compressFormat;
        this.f2215b = i;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap) {
        if (this.f2214a != null) {
            return this.f2214a;
        }
        return bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.a.a.d.b
    public String a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.a.a.d.b
    public boolean a(com.a.a.d.b.k<Bitmap> kVar, OutputStream outputStream) {
        Bitmap bitmapB = kVar.b();
        long jA = com.a.a.j.d.a();
        Bitmap.CompressFormat compressFormatA = a(bitmapB);
        bitmapB.compress(compressFormatA, this.f2215b, outputStream);
        if (!Log.isLoggable("BitmapEncoder", 2)) {
            return true;
        }
        Log.v("BitmapEncoder", "Compressed with type: " + compressFormatA + " of size " + com.a.a.j.h.a(bitmapB) + " in " + com.a.a.j.d.a(jA));
        return true;
    }
}
