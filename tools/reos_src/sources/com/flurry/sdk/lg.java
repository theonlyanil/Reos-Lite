package com.flurry.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class lg extends ka {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f4680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lf f4681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f4682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4683d;

    public enum a {
        CREATE,
        SESSION_ID_CREATED,
        START,
        END,
        FINALIZE
    }

    public lg() {
        super("com.flurry.android.sdk.FlurrySessionEvent");
    }
}
