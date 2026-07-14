package com.flurry.sdk;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public class jv extends ka {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f4526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f4527b;

    public enum a {
        kCreated,
        kDestroyed,
        kPaused,
        kResumed,
        kStarted,
        kStopped,
        kSaveState
    }

    public jv() {
        super("com.flurry.android.sdk.ActivityLifecycleEvent");
    }
}
