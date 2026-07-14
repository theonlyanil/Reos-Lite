package com.facebook.share.internal;

/* JADX INFO: loaded from: classes.dex */
public enum f implements com.facebook.b.h {
    OG_MESSAGE_DIALOG(20140204);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4070b;

    f(int i) {
        this.f4070b = i;
    }

    @Override // com.facebook.b.h
    public String a() {
        return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    }

    @Override // com.facebook.b.h
    public int b() {
        return this.f4070b;
    }
}
