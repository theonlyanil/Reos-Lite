package com.flurry.sdk;

/* JADX INFO: loaded from: classes.dex */
public enum ih {
    HW_MACHINE(0),
    MODEL(1),
    BRAND(2),
    ID(3),
    DEVICE(4),
    PRODUCT(5),
    VERSION_RELEASE(6);

    private final int h;

    ih(int i2) {
        this.h = i2;
    }

    public int a() {
        return this.h;
    }
}
