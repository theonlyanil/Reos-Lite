package com.flurry.android;

/* JADX INFO: loaded from: classes.dex */
public enum FlurrySyndicationEventName {
    REBLOG("Reblog"),
    FAST_REBLOG("FastReblog"),
    SOURCE_LINK("SourceClick"),
    LIKE("Like");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4191a;

    FlurrySyndicationEventName(String str) {
        this.f4191a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f4191a;
    }
}
