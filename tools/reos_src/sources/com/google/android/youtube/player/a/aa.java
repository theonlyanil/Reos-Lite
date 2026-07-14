package com.google.android.youtube.player.a;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class aa {
    public static void a(String str, Throwable th) {
        Log.e("YouTubeAndroidPlayerAPI", str, th);
    }

    public static void a(String str, Object... objArr) {
        Log.w("YouTubeAndroidPlayerAPI", String.format(str, objArr));
    }
}
