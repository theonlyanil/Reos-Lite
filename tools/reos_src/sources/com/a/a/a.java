package com.a.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.a.a.d.d.a.q;
import com.a.a.h.b.k;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class a<ModelType, TranscodeType> extends e<ModelType, com.a.a.d.c.g, Bitmap, TranscodeType> {
    private final com.a.a.d.b.a.c g;
    private com.a.a.d.d.a.f h;
    private com.a.a.d.a i;
    private com.a.a.d.e<InputStream, Bitmap> j;
    private com.a.a.d.e<ParcelFileDescriptor, Bitmap> k;

    a(com.a.a.g.f<ModelType, com.a.a.d.c.g, Bitmap, TranscodeType> fVar, Class<TranscodeType> cls, e<ModelType, ?, ?, ?> eVar) {
        super(fVar, cls, eVar);
        this.h = com.a.a.d.d.a.f.f2219a;
        this.g = eVar.f2357c.a();
        this.i = eVar.f2357c.h();
        this.j = new q(this.g, this.i);
        this.k = new com.a.a.d.d.a.h(this.g, this.i);
    }

    public a<ModelType, TranscodeType> a() {
        return a(this.f2357c.c());
    }

    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> d(int i) {
        super.d(i);
        return this;
    }

    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> b(int i, int i2) {
        super.b(i, i2);
        return this;
    }

    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> b(com.a.a.d.b.b bVar) {
        super.b(bVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> b(com.a.a.d.b<com.a.a.d.c.g> bVar) {
        super.b((com.a.a.d.b) bVar);
        return this;
    }

    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> b(com.a.a.d.c cVar) {
        super.b(cVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> b(com.a.a.d.e<com.a.a.d.c.g, Bitmap> eVar) {
        super.b((com.a.a.d.e) eVar);
        return this;
    }

    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> b(ModelType modeltype) {
        super.b(modeltype);
        return this;
    }

    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> b(boolean z) {
        super.b(z);
        return this;
    }

    public a<ModelType, TranscodeType> a(com.a.a.d.d.a.d... dVarArr) {
        super.b((com.a.a.d.g[]) dVarArr);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> b(com.a.a.d.g<Bitmap>... gVarArr) {
        super.b((com.a.a.d.g[]) gVarArr);
        return this;
    }

    @Override // com.a.a.e
    public k<TranscodeType> a(ImageView imageView) {
        return super.a(imageView);
    }

    public a<ModelType, TranscodeType> b() {
        return a(this.f2357c.d());
    }

    @Override // com.a.a.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> c(int i) {
        super.c(i);
        return this;
    }

    @Override // com.a.a.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a<ModelType, TranscodeType> f() {
        return (a) super.f();
    }

    @Override // com.a.a.e
    void d() {
        b();
    }

    @Override // com.a.a.e
    void e() {
        a();
    }
}
