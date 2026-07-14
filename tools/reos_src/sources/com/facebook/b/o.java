package com.facebook.b;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Fragment f3774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.app.Fragment f3775b;

    public o(android.app.Fragment fragment) {
        ae.a(fragment, "fragment");
        this.f3775b = fragment;
    }

    public o(Fragment fragment) {
        ae.a(fragment, "fragment");
        this.f3774a = fragment;
    }

    public android.app.Fragment a() {
        return this.f3775b;
    }

    public void a(Intent intent, int i) {
        if (this.f3774a != null) {
            this.f3774a.startActivityForResult(intent, i);
        } else {
            this.f3775b.startActivityForResult(intent, i);
        }
    }

    public Fragment b() {
        return this.f3774a;
    }

    public final Activity c() {
        return this.f3774a != null ? this.f3774a.getActivity() : this.f3775b.getActivity();
    }
}
