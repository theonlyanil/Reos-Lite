package com.a.a.d.b;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
class j implements com.a.a.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.c f2162b;

    public j(String str, com.a.a.d.c cVar) {
        this.f2161a = str;
        this.f2162b = cVar;
    }

    @Override // com.a.a.d.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f2161a.getBytes("UTF-8"));
        this.f2162b.a(messageDigest);
    }

    @Override // com.a.a.d.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f2161a.equals(jVar.f2161a) && this.f2162b.equals(jVar.f2162b);
    }

    @Override // com.a.a.d.c
    public int hashCode() {
        return (this.f2161a.hashCode() * 31) + this.f2162b.hashCode();
    }
}
