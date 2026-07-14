package com.a.a.d.c;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class q<T> implements l<Uri, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<d, T> f2209b;

    public q(Context context, l<d, T> lVar) {
        this.f2208a = context;
        this.f2209b = lVar;
    }

    private static boolean a(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }

    protected abstract com.a.a.d.a.c<T> a(Context context, Uri uri);

    protected abstract com.a.a.d.a.c<T> a(Context context, String str);

    @Override // com.a.a.d.c.l
    public final com.a.a.d.a.c<T> a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (a(scheme)) {
            if (!a.a(uri)) {
                return a(this.f2208a, uri);
            }
            return a(this.f2208a, a.b(uri));
        }
        if (this.f2209b == null) {
            return null;
        }
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return this.f2209b.a(new d(uri.toString()), i, i2);
        }
        return null;
    }
}
