package com.google.android.youtube.player.a;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f5307a = b();

    public static b a() {
        return f5307a;
    }

    private static b b() {
        try {
            try {
                return (b) Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(b.class).newInstance();
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException(e2);
            } catch (InstantiationException e3) {
                throw new IllegalStateException(e3);
            }
        } catch (ClassNotFoundException e4) {
            return new d();
        }
    }

    public abstract e a(Context context, String str, v.a aVar, v.b bVar);

    public abstract g a(Activity activity, e eVar, boolean z) throws y.a;
}
