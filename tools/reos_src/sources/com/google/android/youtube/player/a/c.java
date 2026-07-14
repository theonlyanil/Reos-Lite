package com.google.android.youtube.player.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static <T> T a(T t) {
        if (t == null) {
            throw new NullPointerException("null reference");
        }
        return t;
    }

    public static <T> T a(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    public static String a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
