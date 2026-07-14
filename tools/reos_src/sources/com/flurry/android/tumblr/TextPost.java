package com.flurry.android.tumblr;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class TextPost extends Post {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4206b;

    public TextPost(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Body to post cannot be null or empty");
        }
        this.f4206b = str;
    }

    String a() {
        return this.f4205a;
    }

    String b() {
        return this.f4206b;
    }

    @Override // com.flurry.android.tumblr.Post
    Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putString("com.flurry.android.post_title", a());
        bundle.putString("com.flurry.android.post_body", b());
        bundle.putString("com.flurry.android.post_ios_deeplinks", e());
        bundle.putString("com.flurry.android.post_android_deeplinks", d());
        bundle.putString("com.flurry.android.post_weblink", f());
        bundle.putBoolean("com.flurry.android.is_text_post", true);
        bundle.putInt("com.flurry.android.post_id", g());
        return bundle;
    }

    public void setTitle(String str) {
        this.f4205a = str;
    }
}
