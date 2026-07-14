package com.facebook.share.internal;

/* JADX INFO: loaded from: classes.dex */
public enum i implements com.facebook.b.h {
    SHARE_DIALOG(20130618),
    PHOTOS(20140204),
    VIDEO(20141028),
    MULTIMEDIA(20160327),
    HASHTAG(20160327),
    LINK_SHARE_QUOTES(20160327);

    private int g;

    i(int i) {
        this.g = i;
    }

    @Override // com.facebook.b.h
    public String a() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    @Override // com.facebook.b.h
    public int b() {
        return this.g;
    }
}
