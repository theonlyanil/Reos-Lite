package com.facebook;

import android.content.Intent;
import com.facebook.b.ad;
import com.facebook.b.ae;

/* JADX INFO: loaded from: classes.dex */
final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile w f4161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.support.v4.b.j f4162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v f4163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Profile f4164d;

    w(android.support.v4.b.j jVar, v vVar) {
        ae.a(jVar, "localBroadcastManager");
        ae.a(vVar, "profileCache");
        this.f4162b = jVar;
        this.f4163c = vVar;
    }

    static w a() {
        if (f4161a == null) {
            synchronized (w.class) {
                if (f4161a == null) {
                    f4161a = new w(android.support.v4.b.j.a(m.f()), new v());
                }
            }
        }
        return f4161a;
    }

    private void a(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.f4162b.a(intent);
    }

    private void a(Profile profile, boolean z) {
        Profile profile2 = this.f4164d;
        this.f4164d = profile;
        if (z) {
            if (profile != null) {
                this.f4163c.a(profile);
            } else {
                this.f4163c.b();
            }
        }
        if (ad.a(profile2, profile)) {
            return;
        }
        a(profile2, profile);
    }

    void a(Profile profile) {
        a(profile, true);
    }

    Profile b() {
        return this.f4164d;
    }

    boolean c() {
        Profile profileA = this.f4163c.a();
        if (profileA == null) {
            return false;
        }
        a(profileA, false);
        return true;
    }
}
