package com.a.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.a.a.d.c.l;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b<ModelType> extends a<ModelType, Bitmap> {
    private final l<ModelType, InputStream> g;
    private final l<ModelType, ParcelFileDescriptor> h;
    private final g i;
    private final j.c j;

    b(e<ModelType, ?, ?, ?> eVar, l<ModelType, InputStream> lVar, l<ModelType, ParcelFileDescriptor> lVar2, j.c cVar) {
        super(a(eVar.f2357c, lVar, lVar2, Bitmap.class, null), Bitmap.class, eVar);
        this.g = lVar;
        this.h = lVar2;
        this.i = eVar.f2357c;
        this.j = cVar;
    }

    private static <A, R> com.a.a.g.e<A, com.a.a.d.c.g, Bitmap, R> a(g gVar, l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2, Class<R> cls, com.a.a.d.d.f.c<Bitmap, R> cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = gVar.a(Bitmap.class, cls);
        }
        return new com.a.a.g.e<>(new com.a.a.d.c.f(lVar, lVar2), cVar, gVar.b(com.a.a.d.c.g.class, Bitmap.class));
    }
}
