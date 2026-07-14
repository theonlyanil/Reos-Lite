package com.google.android.youtube.player.a;

import android.content.Context;
import android.content.res.Resources;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5323f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public p(Context context) {
        Resources resources = context.getResources();
        Map<String, String> mapA = z.a((resources == null || resources.getConfiguration() == null || resources.getConfiguration().locale == null) ? Locale.getDefault() : resources.getConfiguration().locale);
        this.f5318a = mapA.get("error_initializing_player");
        this.f5319b = mapA.get("get_youtube_app_title");
        this.f5320c = mapA.get("get_youtube_app_text");
        this.f5321d = mapA.get("get_youtube_app_action");
        this.f5322e = mapA.get("enable_youtube_app_title");
        this.f5323f = mapA.get("enable_youtube_app_text");
        this.g = mapA.get("enable_youtube_app_action");
        this.h = mapA.get("update_youtube_app_title");
        this.i = mapA.get("update_youtube_app_text");
        this.j = mapA.get("update_youtube_app_action");
    }
}
