package com.facebook.share.internal;

/* JADX INFO: loaded from: classes.dex */
public enum b implements com.facebook.b.h {
    MESSAGE_DIALOG(20140204),
    PHOTOS(20140324),
    VIDEO(20141218);


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4064d;

    b(int i) {
        this.f4064d = i;
    }

    @Override // com.facebook.b.h
    public String a() {
        return "com.facebook.platform.action.request.MESSAGE_DIALOG";
    }

    @Override // com.facebook.b.h
    public int b() {
        return this.f4064d;
    }
}
