package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.b.ae;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f3542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0067a f3543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t f3544c;

    /* JADX INFO: renamed from: com.facebook.a$a, reason: collision with other inner class name */
    static class C0067a {
        C0067a() {
        }

        public t a() {
            return new t(m.f());
        }
    }

    public a() {
        this(m.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new C0067a());
    }

    a(SharedPreferences sharedPreferences, C0067a c0067a) {
        this.f3542a = sharedPreferences;
        this.f3543b = c0067a;
    }

    private boolean c() {
        return this.f3542a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private AccessToken d() {
        String string = this.f3542a.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string == null) {
            return null;
        }
        try {
            return AccessToken.a(new JSONObject(string));
        } catch (JSONException e2) {
            return null;
        }
    }

    private boolean e() {
        return m.c();
    }

    private AccessToken f() {
        Bundle bundleA = g().a();
        if (bundleA == null || !t.a(bundleA)) {
            return null;
        }
        return AccessToken.a(bundleA);
    }

    private t g() {
        if (this.f3544c == null) {
            synchronized (this) {
                if (this.f3544c == null) {
                    this.f3544c = this.f3543b.a();
                }
            }
        }
        return this.f3544c;
    }

    public AccessToken a() {
        if (c()) {
            return d();
        }
        if (!e()) {
            return null;
        }
        AccessToken accessTokenF = f();
        if (accessTokenF == null) {
            return accessTokenF;
        }
        a(accessTokenF);
        g().b();
        return accessTokenF;
    }

    public void a(AccessToken accessToken) {
        ae.a(accessToken, "accessToken");
        try {
            this.f3542a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.j().toString()).apply();
        } catch (JSONException e2) {
        }
    }

    public void b() {
        this.f3542a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (e()) {
            g().b();
        }
    }
}
