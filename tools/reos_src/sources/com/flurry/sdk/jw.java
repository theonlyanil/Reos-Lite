package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class jw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static jw f4534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4535b = jw.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f4536c;

    private jw() {
        e();
    }

    public static synchronized jw a() {
        if (f4534a == null) {
            f4534a = new jw();
        }
        return f4534a;
    }

    public static synchronized void b() {
        if (f4534a != null) {
            f4534a.f();
        }
        f4534a = null;
    }

    @TargetApi(14)
    private void e() {
        if (Build.VERSION.SDK_INT < 14 || this.f4536c != null) {
            return;
        }
        Context contextC = js.a().c();
        if (contextC instanceof Application) {
            this.f4536c = new Application.ActivityLifecycleCallbacks() { // from class: com.flurry.sdk.jw.1
                protected void a(Activity activity, jv.a aVar) {
                    jv jvVar = new jv();
                    jvVar.f4526a = activity;
                    jvVar.f4527b = aVar;
                    jvVar.b();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    kg.a(3, jw.f4535b, "onActivityCreated for activity:" + activity);
                    a(activity, jv.a.kCreated);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    kg.a(3, jw.f4535b, "onActivityDestroyed for activity:" + activity);
                    a(activity, jv.a.kDestroyed);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    kg.a(3, jw.f4535b, "onActivityPaused for activity:" + activity);
                    a(activity, jv.a.kPaused);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    kg.a(3, jw.f4535b, "onActivityResumed for activity:" + activity);
                    a(activity, jv.a.kResumed);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    kg.a(3, jw.f4535b, "onActivitySaveInstanceState for activity:" + activity);
                    a(activity, jv.a.kSaveState);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    kg.a(3, jw.f4535b, "onActivityStarted for activity:" + activity);
                    a(activity, jv.a.kStarted);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    kg.a(3, jw.f4535b, "onActivityStopped for activity:" + activity);
                    a(activity, jv.a.kStopped);
                }
            };
            ((Application) contextC).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) this.f4536c);
        }
    }

    @TargetApi(14)
    private void f() {
        if (Build.VERSION.SDK_INT < 14 || this.f4536c == null) {
            return;
        }
        Context contextC = js.a().c();
        if (contextC instanceof Application) {
            ((Application) contextC).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) this.f4536c);
            this.f4536c = null;
        }
    }

    public boolean c() {
        return this.f4536c != null;
    }
}
