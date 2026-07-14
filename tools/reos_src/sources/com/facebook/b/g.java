package com.facebook.b;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f3733a;

    public g(String str, Bundle bundle) {
        this.f3733a = ad.a(ab.a(), ab.d() + "/dialog/" + str, bundle == null ? new Bundle() : bundle);
    }

    public void a(Activity activity, String str) {
        android.support.a.a aVarA = new android.support.a.a.C0003a().a();
        aVarA.f138a.setPackage(str);
        aVarA.f138a.addFlags(1073741824);
        aVarA.a(activity, this.f3733a);
    }
}
