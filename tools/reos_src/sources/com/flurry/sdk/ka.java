package com.flurry.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class ka {
    protected String g;

    public ka(String str) {
        this.g = "com.flurry.android.sdk.ReplaceMeWithAProperEventName";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Event must have a name!");
        }
        this.g = str;
    }

    public String a() {
        return this.g;
    }

    public void b() {
        kc.a().a(this);
    }
}
