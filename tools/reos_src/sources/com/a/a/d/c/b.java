package com.a.a.d.c;

import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b<T> implements l<File, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<Uri, T> f2166a;

    public b(l<Uri, T> lVar) {
        this.f2166a = lVar;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<T> a(File file, int i, int i2) {
        return this.f2166a.a(Uri.fromFile(file), i, i2);
    }
}
