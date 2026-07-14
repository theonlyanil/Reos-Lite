package com.facebook.b;

import android.content.Context;
import android.net.Uri;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f3796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f3797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f3799e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f3800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f3801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b f3802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f3803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Object f3804e;

        public a(Context context, Uri uri) {
            ae.a(uri, "imageUri");
            this.f3800a = context;
            this.f3801b = uri;
        }

        public a a(b bVar) {
            this.f3802c = bVar;
            return this;
        }

        public a a(Object obj) {
            this.f3804e = obj;
            return this;
        }

        public a a(boolean z) {
            this.f3803d = z;
            return this;
        }

        public q a() {
            return new q(this);
        }
    }

    public interface b {
        void a(r rVar);
    }

    private q(a aVar) {
        this.f3795a = aVar.f3800a;
        this.f3796b = aVar.f3801b;
        this.f3797c = aVar.f3802c;
        this.f3798d = aVar.f3803d;
        this.f3799e = aVar.f3804e == null ? new Object() : aVar.f3804e;
    }

    public static Uri a(String str, int i, int i2) {
        ae.a(str, "userId");
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (iMax == 0 && iMax2 == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        Uri.Builder builderPath = new Uri.Builder().scheme("https").authority("graph.facebook.com").path(String.format(Locale.US, "%s/picture", str));
        if (iMax2 != 0) {
            builderPath.appendQueryParameter("height", String.valueOf(iMax2));
        }
        if (iMax != 0) {
            builderPath.appendQueryParameter("width", String.valueOf(iMax));
        }
        builderPath.appendQueryParameter("migration_overrides", "{october_2012:true}");
        return builderPath.build();
    }

    public Context a() {
        return this.f3795a;
    }

    public Uri b() {
        return this.f3796b;
    }

    public b c() {
        return this.f3797c;
    }

    public boolean d() {
        return this.f3798d;
    }

    public Object e() {
        return this.f3799e;
    }
}
