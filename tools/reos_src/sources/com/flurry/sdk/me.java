package com.flurry.sdk;

import android.util.SparseArray;
import com.flurry.android.tumblr.Post;

/* JADX INFO: loaded from: classes.dex */
public class me {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static me f4748b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray<Post> f4749a = new SparseArray<>();

    private me() {
    }

    public static me a() {
        if (f4748b == null) {
            f4748b = new me();
        }
        return f4748b;
    }

    public void a(int i) {
        this.f4749a.remove(i);
    }

    public void a(int i, Post post) {
        this.f4749a.append(i, post);
    }
}
