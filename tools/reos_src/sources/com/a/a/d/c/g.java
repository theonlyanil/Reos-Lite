package com.a.a.d.c;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f2185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParcelFileDescriptor f2186b;

    public g(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.f2185a = inputStream;
        this.f2186b = parcelFileDescriptor;
    }

    public InputStream a() {
        return this.f2185a;
    }

    public ParcelFileDescriptor b() {
        return this.f2186b;
    }
}
