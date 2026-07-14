package com.journeyapps.barcodescanner;

import com.google.b.o;
import com.google.b.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.b.k f5894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<o> f5895b = new ArrayList();

    public d(com.google.b.k kVar) {
        this.f5894a = kVar;
    }

    protected com.google.b.m a(com.google.b.c cVar) {
        this.f5895b.clear();
        try {
            return this.f5894a instanceof com.google.b.h ? ((com.google.b.h) this.f5894a).b(cVar) : this.f5894a.a(cVar);
        } catch (Exception e2) {
            return null;
        } finally {
            this.f5894a.a();
        }
    }

    public com.google.b.m a(com.google.b.g gVar) {
        return a(b(gVar));
    }

    public List<o> a() {
        return new ArrayList(this.f5895b);
    }

    @Override // com.google.b.p
    public void a(o oVar) {
        this.f5895b.add(oVar);
    }

    protected com.google.b.c b(com.google.b.g gVar) {
        return new com.google.b.c(new com.google.b.c.j(gVar));
    }
}
