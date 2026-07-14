package com.a.a.h.b;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class d extends e<com.a.a.d.d.b.b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.a.d.d.b.b f2444c;

    public d(ImageView imageView) {
        this(imageView, -1);
    }

    public d(ImageView imageView, int i) {
        super(imageView);
        this.f2443b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.h.b.e
    public void a(com.a.a.d.d.b.b bVar) {
        ((ImageView) this.f2459a).setImageDrawable(bVar);
    }

    public void a(com.a.a.d.d.b.b bVar, com.a.a.h.a.c<? super com.a.a.d.d.b.b> cVar) {
        if (!bVar.a()) {
            float width = ((ImageView) this.f2459a).getWidth() / ((ImageView) this.f2459a).getHeight();
            float intrinsicWidth = bVar.getIntrinsicWidth() / bVar.getIntrinsicHeight();
            if (Math.abs(width - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                bVar = new j(bVar, ((ImageView) this.f2459a).getWidth());
            }
        }
        super.a(bVar, cVar);
        this.f2444c = bVar;
        bVar.a(this.f2443b);
        bVar.start();
    }

    @Override // com.a.a.h.b.e, com.a.a.h.b.k
    public /* bridge */ /* synthetic */ void a(Object obj, com.a.a.h.a.c cVar) {
        a((com.a.a.d.d.b.b) obj, (com.a.a.h.a.c<? super com.a.a.d.d.b.b>) cVar);
    }

    @Override // com.a.a.h.b.a, com.a.a.e.h
    public void d() {
        if (this.f2444c != null) {
            this.f2444c.start();
        }
    }

    @Override // com.a.a.h.b.a, com.a.a.e.h
    public void e() {
        if (this.f2444c != null) {
            this.f2444c.stop();
        }
    }
}
