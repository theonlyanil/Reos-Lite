package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class kn<RequestObjectType, ResponseObjectType> extends kp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a<RequestObjectType, ResponseObjectType> f4583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RequestObjectType f4584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ResponseObjectType f4585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private lb<RequestObjectType> f4586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private lb<ResponseObjectType> f4587e;

    public interface a<RequestObjectType, ResponseObjectType> {
        void a(kn<RequestObjectType, ResponseObjectType> knVar, ResponseObjectType responseobjecttype);
    }

    private void r() {
        a(new kp.c() { // from class: com.flurry.sdk.kn.1
            @Override // com.flurry.sdk.kp.c
            public void a(kp kpVar) {
                kn.this.s();
            }

            @Override // com.flurry.sdk.kp.c
            public void a(kp kpVar, InputStream inputStream) throws Exception {
                if (kpVar.g() && kn.this.f4587e != null) {
                    kn.this.f4585c = kn.this.f4587e.b(inputStream);
                }
            }

            @Override // com.flurry.sdk.kp.c
            public void a(kp kpVar, OutputStream outputStream) throws Exception {
                if (kn.this.f4584b == null || kn.this.f4586d == null) {
                    return;
                }
                kn.this.f4586d.a(outputStream, kn.this.f4584b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f4583a == null || e()) {
            return;
        }
        this.f4583a.a(this, this.f4585c);
    }

    @Override // com.flurry.sdk.kp, com.flurry.sdk.ly
    public void a() {
        r();
        super.a();
    }

    public void a(a<RequestObjectType, ResponseObjectType> aVar) {
        this.f4583a = aVar;
    }

    public void a(lb<RequestObjectType> lbVar) {
        this.f4586d = lbVar;
    }

    public void a(RequestObjectType requestobjecttype) {
        this.f4584b = requestobjecttype;
    }

    public void b(lb<ResponseObjectType> lbVar) {
        this.f4587e = lbVar;
    }
}
