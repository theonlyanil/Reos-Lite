package com.flurry.sdk;

/* JADX INFO: loaded from: classes.dex */
public enum il {
    COMPLETE(1),
    TIMEOUT(2),
    INVALID_RESPONSE(3),
    PENDING_COMPLETION(4);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4330e;

    il(int i) {
        this.f4330e = i;
    }

    public static il a(int i) {
        switch (i) {
            case 1:
                return COMPLETE;
            case 2:
                return TIMEOUT;
            case 3:
                return INVALID_RESPONSE;
            case 4:
                return PENDING_COMPLETION;
            default:
                return null;
        }
    }

    public int a() {
        return this.f4330e;
    }
}
