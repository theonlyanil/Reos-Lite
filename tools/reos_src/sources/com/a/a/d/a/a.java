package com.a.a.d.a;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f2027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f2028c;

    public a(AssetManager assetManager, String str) {
        this.f2027b = assetManager;
        this.f2026a = str;
    }

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.a.a.d.a.c
    public T a(com.a.a.i iVar) throws Exception {
        this.f2028c = a(this.f2027b, this.f2026a);
        return this.f2028c;
    }

    @Override // com.a.a.d.a.c
    public void a() {
        if (this.f2028c == null) {
            return;
        }
        try {
            a(this.f2028c);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetUriFetcher", 2)) {
                Log.v("AssetUriFetcher", "Failed to close data", e2);
            }
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.a.a.d.a.c
    public String b() {
        return this.f2026a;
    }

    @Override // com.a.a.d.a.c
    public void c() {
    }
}
