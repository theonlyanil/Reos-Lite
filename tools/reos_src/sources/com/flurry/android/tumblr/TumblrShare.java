package com.flurry.android.tumblr;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.em;
import com.flurry.sdk.fi;
import com.flurry.sdk.hc;
import com.flurry.sdk.hl;
import com.flurry.sdk.js;
import com.flurry.sdk.kg;
import com.flurry.sdk.me;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class TumblrShare {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4207a = TumblrShare.class.getName();

    public static Bitmap getTumblrImage() {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4207a, "Device SDK Version older than 10");
            return null;
        }
        if (js.a() == null) {
            throw new IllegalStateException("Flurry SDK must be initialized.");
        }
        hc hcVar = new hc();
        hcVar.x();
        return hcVar.o();
    }

    public static void post(Context context, Post post) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4207a, "Device SDK Version older than 10");
            return;
        }
        if (js.a() == null) {
            throw new IllegalStateException("Flurry SDK must be initialized before posting on Tumblr");
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        if (post == null) {
            throw new IllegalArgumentException("Post object cannot be null.");
        }
        if (TextUtils.isEmpty(em.a())) {
            throw new IllegalArgumentException("Consumer api key cannot be null or empty. Please set consumer key using setOAuthConfig().");
        }
        if (TextUtils.isEmpty(em.b())) {
            throw new IllegalArgumentException("Consumer secret cannot be null or empty. Please set consumer secret using setOAuthConfig().");
        }
        hl.a().b("ShareClick", post.d(), new HashMap());
        me.a().a(post.g(), post);
        fi.a(context, post.c());
    }

    public static void setOAuthConfig(String str, String str2) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4207a, "Device SDK Version older than 10");
        } else {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Consumer api key cannot be null or empty.");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("Consumer secret cannot be null or empty.");
            }
            em.a(str);
            em.b(str2);
        }
    }
}
