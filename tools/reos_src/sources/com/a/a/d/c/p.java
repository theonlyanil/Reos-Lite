package com.a.a.d.c;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class p<T> implements l<String, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<Uri, T> f2207a;

    public p(l<Uri, T> lVar) {
        this.f2207a = lVar;
    }

    private static Uri a(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<T> a(String str, int i, int i2) {
        Uri uriA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            uriA = a(str);
        } else {
            uriA = Uri.parse(str);
            if (uriA.getScheme() == null) {
                uriA = a(str);
            }
        }
        return this.f2207a.a(uriA, i, i2);
    }
}
