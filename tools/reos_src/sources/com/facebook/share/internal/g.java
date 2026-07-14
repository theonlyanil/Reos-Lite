package com.facebook.share.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.facebook.h f4071a;

    public g(com.facebook.h hVar) {
        this.f4071a = hVar;
    }

    public void a(com.facebook.b.a aVar) {
        if (this.f4071a != null) {
            this.f4071a.a();
        }
    }

    public abstract void a(com.facebook.b.a aVar, Bundle bundle);

    public void a(com.facebook.b.a aVar, com.facebook.k kVar) {
        if (this.f4071a != null) {
            this.f4071a.a(kVar);
        }
    }
}
