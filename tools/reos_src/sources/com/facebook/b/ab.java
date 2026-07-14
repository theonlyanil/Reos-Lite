package com.facebook.b;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class ab {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f3650c = ab.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection<String> f3648a = ad.a("service_disabled", "AndroidAuthKillSwitchException");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Collection<String> f3649b = ad.a("access_denied", "OAuthAccessDeniedException");

    public static final String a() {
        return String.format("m.%s", com.facebook.m.e());
    }

    public static final String b() {
        return String.format("https://graph.%s", com.facebook.m.e());
    }

    public static final String c() {
        return String.format("https://graph-video.%s", com.facebook.m.e());
    }

    public static final String d() {
        return "v2.7";
    }
}
