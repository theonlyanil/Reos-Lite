package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessToken f3958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f3959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f3960c;

    public h(AccessToken accessToken, Set<String> set, Set<String> set2) {
        this.f3958a = accessToken;
        this.f3959b = set;
        this.f3960c = set2;
    }

    public AccessToken a() {
        return this.f3958a;
    }

    public Set<String> b() {
        return this.f3959b;
    }
}
