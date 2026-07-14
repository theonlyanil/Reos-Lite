package com.a.a.i;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.a.a.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2483a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.f2483a = str;
    }

    @Override // com.a.a.d.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f2483a.getBytes("UTF-8"));
    }

    @Override // com.a.a.d.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2483a.equals(((c) obj).f2483a);
    }

    @Override // com.a.a.d.c
    public int hashCode() {
        return this.f2483a.hashCode();
    }

    public String toString() {
        return "StringSignature{signature='" + this.f2483a + "'}";
    }
}
