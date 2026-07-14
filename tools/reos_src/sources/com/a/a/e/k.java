package com.a.a.e;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.p;
import android.support.v4.app.t;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k implements Handler.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final k f2379c = new k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile com.a.a.j f2382d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<FragmentManager, j> f2380a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<t, n> f2381b = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f2383e = new Handler(Looper.getMainLooper(), this);

    k() {
    }

    public static k a() {
        return f2379c;
    }

    private com.a.a.j b(Context context) {
        if (this.f2382d == null) {
            synchronized (this) {
                if (this.f2382d == null) {
                    this.f2382d = new com.a.a.j(context.getApplicationContext(), new b(), new f());
                }
            }
        }
        return this.f2382d;
    }

    @TargetApi(17)
    private static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    j a(FragmentManager fragmentManager) {
        j jVar = (j) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = this.f2380a.get(fragmentManager);
        if (jVar2 != null) {
            return jVar2;
        }
        j jVar3 = new j();
        this.f2380a.put(fragmentManager, jVar3);
        fragmentManager.beginTransaction().add(jVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f2383e.obtainMessage(1, fragmentManager).sendToTarget();
        return jVar3;
    }

    n a(t tVar) {
        n nVar = (n) tVar.a("com.bumptech.glide.manager");
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = this.f2381b.get(tVar);
        if (nVar2 != null) {
            return nVar2;
        }
        n nVar3 = new n();
        this.f2381b.put(tVar, nVar3);
        tVar.a().a(nVar3, "com.bumptech.glide.manager").b();
        this.f2383e.obtainMessage(2, tVar).sendToTarget();
        return nVar3;
    }

    @TargetApi(11)
    public com.a.a.j a(Activity activity) {
        if (com.a.a.j.h.d() || Build.VERSION.SDK_INT < 11) {
            return a(activity.getApplicationContext());
        }
        b(activity);
        return a(activity, activity.getFragmentManager());
    }

    public com.a.a.j a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.a.a.j.h.c() && !(context instanceof Application)) {
            if (context instanceof p) {
                return a((p) context);
            }
            if (context instanceof Activity) {
                return a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
        }
        return b(context);
    }

    @TargetApi(11)
    com.a.a.j a(Context context, FragmentManager fragmentManager) {
        j jVarA = a(fragmentManager);
        com.a.a.j jVarB = jVarA.b();
        if (jVarB != null) {
            return jVarB;
        }
        com.a.a.j jVar = new com.a.a.j(context, jVarA.a(), jVarA.c());
        jVarA.a(jVar);
        return jVar;
    }

    com.a.a.j a(Context context, t tVar) {
        n nVarA = a(tVar);
        com.a.a.j jVarB = nVarA.b();
        if (jVarB != null) {
            return jVarB;
        }
        com.a.a.j jVar = new com.a.a.j(context, nVarA.a(), nVarA.c());
        nVarA.a(jVar);
        return jVar;
    }

    public com.a.a.j a(p pVar) {
        if (com.a.a.j.h.d()) {
            return a(pVar.getApplicationContext());
        }
        b((Activity) pVar);
        return a(pVar, pVar.getSupportFragmentManager());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks componentCallbacksRemove;
        Object obj = null;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                componentCallbacksRemove = this.f2380a.remove(obj);
                break;
            case 2:
                obj = (t) message.obj;
                componentCallbacksRemove = this.f2381b.remove(obj);
                break;
            default:
                z = false;
                componentCallbacksRemove = null;
                break;
        }
        if (z && componentCallbacksRemove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
