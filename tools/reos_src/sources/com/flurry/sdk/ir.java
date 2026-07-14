package com.flurry.sdk;

/* JADX INFO: loaded from: classes.dex */
public enum ir {
    INSTALL(1),
    SESSION_START(2),
    SESSION_END(3),
    APPLICATION_EVENT(4);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4375e;

    ir(int i) {
        this.f4375e = i;
    }

    public static ir a(int i) {
        switch (i) {
            case 1:
                return INSTALL;
            case 2:
                return SESSION_START;
            case 3:
                return SESSION_END;
            case 4:
                return APPLICATION_EVENT;
            default:
                return null;
        }
    }

    public int a() {
        return this.f4375e;
    }
}
