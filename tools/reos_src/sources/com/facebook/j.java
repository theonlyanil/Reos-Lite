package com.facebook;

/* JADX INFO: loaded from: classes.dex */
public class j extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3866b;

    public j(String str, int i, String str2) {
        super(str);
        this.f3865a = i;
        this.f3866b = str2;
    }

    public int a() {
        return this.f3865a;
    }

    public String b() {
        return this.f3866b;
    }

    @Override // com.facebook.k, java.lang.Throwable
    public final String toString() {
        return "{FacebookDialogException: errorCode: " + a() + ", message: " + getMessage() + ", url: " + b() + "}";
    }
}
