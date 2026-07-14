package com.flurry.android.tumblr;

import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.sdk.ec;
import com.flurry.sdk.js;
import com.flurry.sdk.kb;
import com.flurry.sdk.kc;
import com.flurry.sdk.kg;
import com.flurry.sdk.ly;
import com.flurry.sdk.me;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class Post {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4194a = Post.class.getName();
    private static AtomicInteger g = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PostListener f4198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4199f;
    private final kb<ec> h = new kb<ec>() { // from class: com.flurry.android.tumblr.Post.1
        @Override // com.flurry.sdk.kb
        public void a(final ec ecVar) {
            final PostListener postListener;
            if (ecVar.c != Post.this.f4199f || ecVar.b == null || (postListener = Post.this.f4198e) == null) {
                return;
            }
            js.a().a(new ly() { // from class: com.flurry.android.tumblr.Post.1.1
                @Override // com.flurry.sdk.ly
                public void a() {
                    switch (AnonymousClass2.f4204a[ecVar.b.ordinal()]) {
                        case 1:
                            kg.a(3, Post.f4194a, "Post success for " + ecVar.c);
                            postListener.onPostSuccess(ecVar.f);
                            kc.a().b("com.flurry.android.impl.analytics.tumblr.TumblrEvents", Post.this.h);
                            me.a().a(Post.this.f4199f);
                            break;
                        case 2:
                            String str = ecVar.e;
                            if (TextUtils.isEmpty(str)) {
                                str = "Internal error.";
                            }
                            kg.a(3, Post.f4194a, "Post failed for " + ecVar.c + " with error code: " + ecVar.d + "  and error message: " + str);
                            postListener.onPostFailure(str);
                            kc.a().b("com.flurry.android.impl.analytics.tumblr.TumblrEvents", Post.this.h);
                            me.a().a(Post.this.f4199f);
                            break;
                    }
                }
            });
        }
    };

    /* JADX INFO: renamed from: com.flurry.android.tumblr.Post$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4204a = new int[ec.a.values().length];

        static {
            try {
                f4204a[ec.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4204a[ec.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    Post() {
        this.f4199f = 0;
        this.f4199f = g.incrementAndGet();
        kc.a().a("com.flurry.android.impl.analytics.tumblr.TumblrEvents", this.h);
    }

    abstract Bundle c();

    String d() {
        return this.f4196c;
    }

    String e() {
        return this.f4195b;
    }

    String f() {
        return this.f4197d;
    }

    int g() {
        return this.f4199f;
    }

    public void setAndroidDeeplink(String str) {
        this.f4196c = str;
    }

    public void setIOSDeepLink(String str) {
        this.f4195b = str;
    }

    public void setPostListener(PostListener postListener) {
        this.f4198e = postListener;
    }

    public void setWebLink(String str) {
        this.f4197d = str;
    }
}
