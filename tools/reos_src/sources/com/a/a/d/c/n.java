package com.a.a.d.c;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class n<T> implements l<Integer, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<Uri, T> f2205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f2206b;

    public n(Context context, l<Uri, T> lVar) {
        this(context.getResources(), lVar);
    }

    public n(Resources resources, l<Uri, T> lVar) {
        this.f2206b = resources;
        this.f2205a = lVar;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<T> a(Integer num, int i, int i2) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.f2206b.getResourcePackageName(num.intValue()) + '/' + this.f2206b.getResourceTypeName(num.intValue()) + '/' + this.f2206b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            }
            uri = null;
        }
        if (uri != null) {
            return this.f2205a.a(uri, i, i2);
        }
        return null;
    }
}
