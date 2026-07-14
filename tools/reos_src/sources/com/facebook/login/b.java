package com.facebook.login;

import android.net.Uri;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class b extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f3931b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f3932a;

    public static b a() {
        if (f3931b == null) {
            synchronized (b.class) {
                if (f3931b == null) {
                    f3931b = new b();
                }
            }
        }
        return f3931b;
    }

    @Override // com.facebook.login.g
    protected LoginClient.Request a(Collection<String> collection) {
        LoginClient.Request requestA = super.a(collection);
        Uri uriB = b();
        if (uriB != null) {
            requestA.a(uriB.toString());
        }
        return requestA;
    }

    public void a(Uri uri) {
        this.f3932a = uri;
    }

    public Uri b() {
        return this.f3932a;
    }
}
