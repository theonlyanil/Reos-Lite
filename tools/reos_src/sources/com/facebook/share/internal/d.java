package com.facebook.share.internal;

/* JADX INFO: loaded from: classes.dex */
public enum d implements com.facebook.b.h {
    OG_ACTION_DIALOG(20130618);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4067b;

    d(int i) {
        this.f4067b = i;
    }

    @Override // com.facebook.b.h
    public String a() {
        return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    }

    @Override // com.facebook.b.h
    public int b() {
        return this.f4067b;
    }
}
