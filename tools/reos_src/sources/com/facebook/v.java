package com.facebook;

import android.content.SharedPreferences;
import com.facebook.b.ae;
import com.google.android.gms.common.Scopes;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f4160a = m.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    v() {
    }

    Profile a() {
        String string = this.f4160a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException e2) {
            }
        }
        return null;
    }

    void a(Profile profile) {
        ae.a(profile, Scopes.PROFILE);
        JSONObject jSONObjectD = profile.d();
        if (jSONObjectD != null) {
            this.f4160a.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObjectD.toString()).apply();
        }
    }

    void b() {
        this.f4160a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
