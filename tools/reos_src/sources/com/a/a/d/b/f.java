package com.a.a.d.b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
class f implements com.a.a.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.d.e f2144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.a.a.d.e f2145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.a.a.d.g f2146f;
    private final com.a.a.d.f g;
    private final com.a.a.d.d.f.c h;
    private final com.a.a.d.b i;
    private final com.a.a.d.c j;
    private String k;
    private int l;
    private com.a.a.d.c m;

    public f(String str, com.a.a.d.c cVar, int i, int i2, com.a.a.d.e eVar, com.a.a.d.e eVar2, com.a.a.d.g gVar, com.a.a.d.f fVar, com.a.a.d.d.f.c cVar2, com.a.a.d.b bVar) {
        this.f2141a = str;
        this.j = cVar;
        this.f2142b = i;
        this.f2143c = i2;
        this.f2144d = eVar;
        this.f2145e = eVar2;
        this.f2146f = gVar;
        this.g = fVar;
        this.h = cVar2;
        this.i = bVar;
    }

    public com.a.a.d.c a() {
        if (this.m == null) {
            this.m = new j(this.f2141a, this.j);
        }
        return this.m;
    }

    @Override // com.a.a.d.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] bArrArray = ByteBuffer.allocate(8).putInt(this.f2142b).putInt(this.f2143c).array();
        this.j.a(messageDigest);
        messageDigest.update(this.f2141a.getBytes("UTF-8"));
        messageDigest.update(bArrArray);
        messageDigest.update((this.f2144d != null ? this.f2144d.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.f2145e != null ? this.f2145e.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.f2146f != null ? this.f2146f.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.g != null ? this.g.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.i != null ? this.i.a() : "").getBytes("UTF-8"));
    }

    @Override // com.a.a.d.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.f2141a.equals(fVar.f2141a) || !this.j.equals(fVar.j) || this.f2143c != fVar.f2143c || this.f2142b != fVar.f2142b) {
            return false;
        }
        if ((this.f2146f == null) ^ (fVar.f2146f == null)) {
            return false;
        }
        if (this.f2146f != null && !this.f2146f.a().equals(fVar.f2146f.a())) {
            return false;
        }
        if ((this.f2145e == null) ^ (fVar.f2145e == null)) {
            return false;
        }
        if (this.f2145e != null && !this.f2145e.a().equals(fVar.f2145e.a())) {
            return false;
        }
        if ((this.f2144d == null) ^ (fVar.f2144d == null)) {
            return false;
        }
        if (this.f2144d != null && !this.f2144d.a().equals(fVar.f2144d.a())) {
            return false;
        }
        if ((this.g == null) ^ (fVar.g == null)) {
            return false;
        }
        if (this.g != null && !this.g.a().equals(fVar.g.a())) {
            return false;
        }
        if ((this.h == null) ^ (fVar.h == null)) {
            return false;
        }
        if (this.h != null && !this.h.a().equals(fVar.h.a())) {
            return false;
        }
        if ((this.i == null) ^ (fVar.i == null)) {
            return false;
        }
        return this.i == null || this.i.a().equals(fVar.i.a());
    }

    @Override // com.a.a.d.c
    public int hashCode() {
        if (this.l == 0) {
            this.l = this.f2141a.hashCode();
            this.l = (this.l * 31) + this.j.hashCode();
            this.l = (this.l * 31) + this.f2142b;
            this.l = (this.l * 31) + this.f2143c;
            this.l = (this.f2144d != null ? this.f2144d.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.f2145e != null ? this.f2145e.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.f2146f != null ? this.f2146f.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.g != null ? this.g.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.h != null ? this.h.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.l * 31) + (this.i != null ? this.i.a().hashCode() : 0);
        }
        return this.l;
    }

    public String toString() {
        if (this.k == null) {
            this.k = "EngineKey{" + this.f2141a + '+' + this.j + "+[" + this.f2142b + 'x' + this.f2143c + "]+'" + (this.f2144d != null ? this.f2144d.a() : "") + "'+'" + (this.f2145e != null ? this.f2145e.a() : "") + "'+'" + (this.f2146f != null ? this.f2146f.a() : "") + "'+'" + (this.g != null ? this.g.a() : "") + "'+'" + (this.h != null ? this.h.a() : "") + "'+'" + (this.i != null ? this.i.a() : "") + "'}";
        }
        return this.k;
    }
}
