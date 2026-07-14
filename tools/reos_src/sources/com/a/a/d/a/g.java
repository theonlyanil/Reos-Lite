package com.a.a.d.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class g<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f2037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f2039c;

    public g(Context context, Uri uri) {
        this.f2038b = context.getApplicationContext();
        this.f2037a = uri;
    }

    @Override // com.a.a.d.a.c
    public final T a(com.a.a.i iVar) throws Exception {
        this.f2039c = b(this.f2037a, this.f2038b.getContentResolver());
        return this.f2039c;
    }

    @Override // com.a.a.d.a.c
    public void a() {
        if (this.f2039c != null) {
            try {
                a(this.f2039c);
            } catch (IOException e2) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e2);
                }
            }
        }
    }

    protected abstract void a(T t) throws IOException;

    protected abstract T b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.a.a.d.a.c
    public String b() {
        return this.f2037a.toString();
    }

    @Override // com.a.a.d.a.c
    public void c() {
    }
}
