package com.github.mikephil.charting.i;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {
    public e(g gVar) {
        super(gVar);
    }

    @Override // com.github.mikephil.charting.i.d
    public void a(boolean z) {
        this.f5066b.reset();
        if (!z) {
            this.f5066b.postTranslate(this.f5067c.a(), this.f5067c.m() - this.f5067c.d());
        } else {
            this.f5066b.setTranslate(-(this.f5067c.n() - this.f5067c.b()), this.f5067c.m() - this.f5067c.d());
            this.f5066b.postScale(-1.0f, 1.0f);
        }
    }
}
