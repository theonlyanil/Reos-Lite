package com.facebook.a;

import com.facebook.AccessToken;
import com.facebook.b.ad;
import com.facebook.m;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3546b;

    /* JADX INFO: renamed from: com.facebook.a.a$a, reason: collision with other inner class name */
    static class C0068a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f3548b;

        private C0068a(String str, String str2) {
            this.f3547a = str;
            this.f3548b = str2;
        }

        private Object readResolve() {
            return new a(this.f3547a, this.f3548b);
        }
    }

    public a(AccessToken accessToken) {
        this(accessToken.b(), m.i());
    }

    public a(String str, String str2) {
        this.f3545a = ad.a(str) ? null : str;
        this.f3546b = str2;
    }

    private Object writeReplace() {
        return new C0068a(this.f3545a, this.f3546b);
    }

    public String a() {
        return this.f3545a;
    }

    public String b() {
        return this.f3546b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return ad.a(aVar.f3545a, this.f3545a) && ad.a(aVar.f3546b, this.f3546b);
    }

    public int hashCode() {
        return (this.f3545a == null ? 0 : this.f3545a.hashCode()) ^ (this.f3546b != null ? this.f3546b.hashCode() : 0);
    }
}
