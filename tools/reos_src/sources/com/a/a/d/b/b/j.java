package com.a.a.d.b.b;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.j.e<com.a.a.d.c, String> f2104a = new com.a.a.j.e<>(1000);

    j() {
    }

    public String a(com.a.a.d.c cVar) {
        String strB;
        synchronized (this.f2104a) {
            strB = this.f2104a.b(cVar);
        }
        if (strB == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                cVar.a(messageDigest);
                strB = com.a.a.j.h.a(messageDigest.digest());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            }
            synchronized (this.f2104a) {
                this.f2104a.b(cVar, strB);
            }
        }
        return strB;
    }
}
