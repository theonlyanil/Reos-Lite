package com.flurry.sdk;

/* JADX INFO: loaded from: classes.dex */
public enum iq {
    GET("GET", 0),
    PUT("PUT", 1),
    POST("POST", 2);


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f4368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f4369e;

    iq(String str, int i) {
        this.f4368d = str;
        this.f4369e = i;
    }

    public static iq a(int i) {
        switch (i) {
            case 0:
                return GET;
            case 1:
                return PUT;
            case 2:
                return POST;
            default:
                return null;
        }
    }

    public int a() {
        return this.f4369e;
    }
}
