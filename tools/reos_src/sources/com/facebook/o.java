package com.facebook;

/* JADX INFO: loaded from: classes.dex */
public class o extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FacebookRequestError f4021a;

    public o(FacebookRequestError facebookRequestError, String str) {
        super(str);
        this.f4021a = facebookRequestError;
    }

    public final FacebookRequestError a() {
        return this.f4021a;
    }

    @Override // com.facebook.k, java.lang.Throwable
    public final String toString() {
        return "{FacebookServiceException: httpResponseCode: " + this.f4021a.a() + ", facebookErrorCode: " + this.f4021a.b() + ", facebookErrorType: " + this.f4021a.d() + ", message: " + this.f4021a.e() + "}";
    }
}
