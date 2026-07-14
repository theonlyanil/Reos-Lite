package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.android.library.userprofile.util.Constants;
import com.facebook.b.ad;
import com.facebook.b.ae;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f3621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.support.v4.b.j f3622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.facebook.a f3623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AccessToken f3624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f3625e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Date f3626f = new Date(0);

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3642b;

        private a() {
        }
    }

    b(android.support.v4.b.j jVar, com.facebook.a aVar) {
        ae.a(jVar, "localBroadcastManager");
        ae.a(aVar, "accessTokenCache");
        this.f3622b = jVar;
        this.f3623c = aVar;
    }

    private static GraphRequest a(AccessToken accessToken, GraphRequest.b bVar) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), s.GET, bVar);
    }

    static b a() {
        if (f3621a == null) {
            synchronized (b.class) {
                if (f3621a == null) {
                    f3621a = new b(android.support.v4.b.j.a(m.f()), new com.facebook.a());
                }
            }
        }
        return f3621a;
    }

    private void a(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.f3622b.a(intent);
    }

    private void a(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.f3624d;
        this.f3624d = accessToken;
        this.f3625e.set(false);
        this.f3626f = new Date(0L);
        if (z) {
            if (accessToken != null) {
                this.f3623c.a(accessToken);
            } else {
                this.f3623c.b();
                ad.b(m.f());
            }
        }
        if (ad.a(accessToken2, accessToken)) {
            return;
        }
        a(accessToken2, accessToken);
    }

    private static GraphRequest b(AccessToken accessToken, GraphRequest.b bVar) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", bundle, s.GET, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AccessToken.a aVar) {
        final AccessToken accessToken = this.f3624d;
        if (accessToken == null) {
            if (aVar != null) {
                aVar.a(new k("No current access token to refresh"));
            }
        } else {
            if (!this.f3625e.compareAndSet(false, true)) {
                if (aVar != null) {
                    aVar.a(new k("Refresh already in progress"));
                    return;
                }
                return;
            }
            this.f3626f = new Date();
            final HashSet hashSet = new HashSet();
            final HashSet hashSet2 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final a aVar2 = new a();
            q qVar = new q(a(accessToken, new GraphRequest.b() { // from class: com.facebook.b.2
                @Override // com.facebook.GraphRequest.b
                public void a(r rVar) {
                    JSONArray jSONArrayOptJSONArray;
                    JSONObject jSONObjectB = rVar.b();
                    if (jSONObjectB == null || (jSONArrayOptJSONArray = jSONObjectB.optJSONArray("data")) == null) {
                        return;
                    }
                    atomicBoolean.set(true);
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("permission");
                            String strOptString2 = jSONObjectOptJSONObject.optString(Constants.SMS_COLUMN_STATUS);
                            if (!ad.a(strOptString) && !ad.a(strOptString2)) {
                                String lowerCase = strOptString2.toLowerCase(Locale.US);
                                if (lowerCase.equals("granted")) {
                                    hashSet.add(strOptString);
                                } else if (lowerCase.equals("declined")) {
                                    hashSet2.add(strOptString);
                                } else {
                                    Log.w("AccessTokenManager", "Unexpected status: " + lowerCase);
                                }
                            }
                        }
                    }
                }
            }), b(accessToken, new GraphRequest.b() { // from class: com.facebook.b.3
                @Override // com.facebook.GraphRequest.b
                public void a(r rVar) {
                    JSONObject jSONObjectB = rVar.b();
                    if (jSONObjectB == null) {
                        return;
                    }
                    aVar2.f3641a = jSONObjectB.optString("access_token");
                    aVar2.f3642b = jSONObjectB.optInt("expires_at");
                }
            }));
            qVar.a(new q.a() { // from class: com.facebook.b.4
                @Override // com.facebook.q.a
                public void a(q qVar2) throws Throwable {
                    AccessToken accessToken2;
                    try {
                        if (b.a().b() == null || b.a().b().i() != accessToken.i()) {
                            if (aVar != null) {
                                aVar.a(new k("No current access token to refresh"));
                            }
                            b.this.f3625e.set(false);
                            if (aVar == null || 0 == 0) {
                                return;
                            }
                            aVar.a((AccessToken) null);
                            return;
                        }
                        if (!atomicBoolean.get() && aVar2.f3641a == null && aVar2.f3642b == 0) {
                            if (aVar != null) {
                                aVar.a(new k("Failed to refresh access token"));
                            }
                            b.this.f3625e.set(false);
                            if (aVar == null || 0 == 0) {
                                return;
                            }
                            aVar.a((AccessToken) null);
                            return;
                        }
                        AccessToken accessToken3 = new AccessToken(aVar2.f3641a != null ? aVar2.f3641a : accessToken.b(), accessToken.h(), accessToken.i(), atomicBoolean.get() ? hashSet : accessToken.d(), atomicBoolean.get() ? hashSet2 : accessToken.e(), accessToken.f(), aVar2.f3642b != 0 ? new Date(((long) aVar2.f3642b) * 1000) : accessToken.c(), new Date());
                        try {
                            b.a().a(accessToken3);
                            b.this.f3625e.set(false);
                            if (aVar == null || accessToken3 == null) {
                                return;
                            }
                            aVar.a(accessToken3);
                        } catch (Throwable th) {
                            accessToken2 = accessToken3;
                            th = th;
                            b.this.f3625e.set(false);
                            if (aVar != null && accessToken2 != null) {
                                aVar.a(accessToken2);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        accessToken2 = null;
                    }
                }
            });
            qVar.h();
        }
    }

    private boolean e() {
        if (this.f3624d == null) {
            return false;
        }
        Long lValueOf = Long.valueOf(new Date().getTime());
        return this.f3624d.f().a() && lValueOf.longValue() - this.f3626f.getTime() > 3600000 && lValueOf.longValue() - this.f3624d.g().getTime() > 86400000;
    }

    void a(final AccessToken.a aVar) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            b(aVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(aVar);
                }
            });
        }
    }

    void a(AccessToken accessToken) {
        a(accessToken, true);
    }

    AccessToken b() {
        return this.f3624d;
    }

    boolean c() {
        AccessToken accessTokenA = this.f3623c.a();
        if (accessTokenA == null) {
            return false;
        }
        a(accessTokenA, false);
        return true;
    }

    void d() {
        if (e()) {
            a((AccessToken.a) null);
        }
    }
}
