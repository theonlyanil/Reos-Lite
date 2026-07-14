package com.facebook.login;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    NONE(null),
    ONLY_ME("only_me"),
    FRIENDS("friends"),
    EVERYONE("everyone");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f3930e;

    a(String str) {
        this.f3930e = str;
    }

    public String a() {
        return this.f3930e;
    }
}
