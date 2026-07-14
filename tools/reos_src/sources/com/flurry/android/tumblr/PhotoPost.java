package com.flurry.android.tumblr;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class PhotoPost extends Post {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4193b;

    public PhotoPost(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Url to post cannot be null or empty");
        }
        this.f4192a = str;
    }

    String a() {
        return this.f4192a;
    }

    String b() {
        return this.f4193b;
    }

    @Override // com.flurry.android.tumblr.Post
    Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putString("com.flurry.android.post_caption", b());
        bundle.putString("com.flurry.android.post_url", a());
        bundle.putString("com.flurry.android.post_ios_deeplinks", e());
        bundle.putString("com.flurry.android.post_android_deeplinks", d());
        bundle.putString("com.flurry.android.post_weblink", f());
        bundle.putBoolean("com.flurry.android.is_image_post", true);
        bundle.putInt("com.flurry.android.post_id", g());
        return bundle;
    }

    public void setCaption(String str) {
        this.f4193b = str;
    }
}
