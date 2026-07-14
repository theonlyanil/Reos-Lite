package com.facebook.login;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.Profile;
import com.facebook.b.ae;
import com.facebook.b.o;
import com.facebook.k;
import com.facebook.m;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f3948a = a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile g f3949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f3950c = d.NATIVE_WITH_FALLBACK;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.facebook.login.a f3951d = com.facebook.login.a.FRIENDS;

    private static class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f3955a;

        a(Activity activity) {
            ae.a(activity, "activity");
            this.f3955a = activity;
        }

        @Override // com.facebook.login.i
        public Activity a() {
            return this.f3955a;
        }

        @Override // com.facebook.login.i
        public void a(Intent intent, int i) {
            this.f3955a.startActivityForResult(intent, i);
        }
    }

    private static class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f3956a;

        b(o oVar) {
            ae.a(oVar, "fragment");
            this.f3956a = oVar;
        }

        @Override // com.facebook.login.i
        public Activity a() {
            return this.f3956a.c();
        }

        @Override // com.facebook.login.i
        public void a(Intent intent, int i) {
            this.f3956a.a(intent, i);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile f f3957a;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:10:0x000f A[Catch: all -> 0x0021, TryCatch #0 {, blocks: (B:10:0x000f, B:12:0x0013, B:13:0x001e, B:9:0x000a), top: B:18:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:12:0x0013 A[Catch: all -> 0x0021, TryCatch #0 {, blocks: (B:10:0x000f, B:12:0x0013, B:13:0x001e, B:9:0x000a), top: B:18:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:6:0x0007  */
        public static synchronized f b(Context context) {
            f fVar;
            if (context == null) {
                context = m.f();
                if (context == null) {
                    fVar = null;
                } else {
                    if (f3957a == null) {
                        f3957a = new f(context, m.i());
                    }
                    fVar = f3957a;
                }
            } else if (context == null) {
                fVar = null;
            } else {
                if (f3957a == null) {
                    f3957a = new f(context, m.i());
                }
                fVar = f3957a;
            }
            throw th;
            return fVar;
        }
    }

    g() {
        ae.a();
    }

    private Intent a(LoginClient.Request request) {
        Intent intent = new Intent();
        intent.setClass(m.f(), FacebookActivity.class);
        intent.setAction(request.b().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    static h a(LoginClient.Request request, AccessToken accessToken) {
        Set<String> setA = request.a();
        HashSet hashSet = new HashSet(accessToken.d());
        if (request.f()) {
            hashSet.retainAll(setA);
        }
        HashSet hashSet2 = new HashSet(setA);
        hashSet2.removeAll(hashSet);
        return new h(accessToken, hashSet, hashSet2);
    }

    private static Set<String> a() {
        return Collections.unmodifiableSet(new HashSet<String>() { // from class: com.facebook.login.g.2
            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
        });
    }

    private void a(Context context, LoginClient.Request request) {
        f fVarB = c.b(context);
        if (fVarB == null || request == null) {
            return;
        }
        fVarB.a(request);
    }

    private void a(Context context, LoginClient.Result.a aVar, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        f fVarB = c.b(context);
        if (fVarB == null) {
            return;
        }
        if (request == null) {
            fVarB.c("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("try_login_activity", z ? "1" : "0");
        fVarB.a(request.e(), map2, aVar, map, exc);
    }

    private void a(AccessToken accessToken, LoginClient.Request request, k kVar, boolean z, com.facebook.h<h> hVar) {
        if (accessToken != null) {
            AccessToken.a(accessToken);
            Profile.b();
        }
        if (hVar != null) {
            h hVarA = accessToken != null ? a(request, accessToken) : null;
            if (z || (hVarA != null && hVarA.b().size() == 0)) {
                hVar.a();
            } else if (kVar != null) {
                hVar.a(kVar);
            } else if (accessToken != null) {
                hVar.a(hVarA);
            }
        }
    }

    private void a(o oVar, Collection<String> collection) {
        b(collection);
        a(new b(oVar), a(collection));
    }

    private void a(i iVar, LoginClient.Request request) throws k {
        a(iVar.a(), request);
        com.facebook.b.f.a(com.facebook.b.f.b.Login.a(), new com.facebook.b.f.a() { // from class: com.facebook.login.g.3
            @Override // com.facebook.b.f.a
            public boolean a(int i, Intent intent) {
                return g.this.a(i, intent);
            }
        });
        if (b(iVar, request)) {
            return;
        }
        k kVar = new k("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        a(iVar.a(), LoginClient.Result.a.ERROR, null, kVar, false, request);
        throw kVar;
    }

    private boolean a(Intent intent) {
        return m.f().getPackageManager().resolveActivity(intent, 0) != null;
    }

    static boolean a(String str) {
        return str != null && (str.startsWith("publish") || str.startsWith("manage") || f3948a.contains(str));
    }

    private void b(o oVar, Collection<String> collection) {
        c(collection);
        a(new b(oVar), a(collection));
    }

    private void b(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (a(str)) {
                throw new k(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
            }
        }
    }

    private boolean b(i iVar, LoginClient.Request request) {
        Intent intentA = a(request);
        if (!a(intentA)) {
            return false;
        }
        try {
            iVar.a(intentA, LoginClient.d());
            return true;
        } catch (ActivityNotFoundException e2) {
            return false;
        }
    }

    public static g c() {
        if (f3949b == null) {
            synchronized (g.class) {
                if (f3949b == null) {
                    f3949b = new g();
                }
            }
        }
        return f3949b;
    }

    private void c(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (!a(str)) {
                throw new k(String.format("Cannot pass a read permission (%s) to a request for publish authorization", str));
            }
        }
    }

    protected LoginClient.Request a(Collection<String> collection) {
        LoginClient.Request request = new LoginClient.Request(this.f3950c, Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet()), this.f3951d, m.i(), UUID.randomUUID().toString());
        request.a(AccessToken.a() != null);
        return request;
    }

    public g a(com.facebook.login.a aVar) {
        this.f3951d = aVar;
        return this;
    }

    public g a(d dVar) {
        this.f3950c = dVar;
        return this;
    }

    public void a(Activity activity, Collection<String> collection) {
        b(collection);
        a(new a(activity), a(collection));
    }

    public void a(Fragment fragment, Collection<String> collection) {
        a(new o(fragment), collection);
    }

    public void a(android.support.v4.app.Fragment fragment, Collection<String> collection) {
        a(new o(fragment), collection);
    }

    public void a(com.facebook.e eVar, final com.facebook.h<h> hVar) {
        if (!(eVar instanceof com.facebook.b.f)) {
            throw new k("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((com.facebook.b.f) eVar).b(com.facebook.b.f.b.Login.a(), new com.facebook.b.f.a() { // from class: com.facebook.login.g.1
            @Override // com.facebook.b.f.a
            public boolean a(int i, Intent intent) {
                return g.this.a(i, intent, hVar);
            }
        });
    }

    boolean a(int i, Intent intent) {
        return a(i, intent, null);
    }

    boolean a(int i, Intent intent, com.facebook.h<h> hVar) {
        boolean z;
        AccessToken accessToken;
        LoginClient.Result.a aVar;
        LoginClient.Request request;
        k kVar;
        Map<String, String> map;
        LoginClient.Request request2;
        AccessToken accessToken2;
        Map<String, String> map2;
        com.facebook.f fVar;
        LoginClient.Result.a aVar2;
        com.facebook.f fVar2 = null;
        AccessToken accessToken3 = null;
        LoginClient.Result.a aVar3 = LoginClient.Result.a.ERROR;
        boolean z2 = false;
        if (intent != null) {
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                LoginClient.Request request3 = result.f3909e;
                LoginClient.Result.a aVar4 = result.f3905a;
                if (i == -1) {
                    if (result.f3905a == LoginClient.Result.a.SUCCESS) {
                        accessToken3 = result.f3906b;
                    } else {
                        fVar2 = new com.facebook.f(result.f3907c);
                    }
                } else if (i == 0) {
                    z2 = true;
                }
                accessToken2 = accessToken3;
                map2 = result.f3910f;
                request2 = request3;
                fVar = fVar2;
                aVar2 = aVar4;
            } else {
                request2 = null;
                accessToken2 = null;
                map2 = null;
                fVar = null;
                aVar2 = aVar3;
            }
            z = z2;
            request = request2;
            accessToken = accessToken2;
            kVar = fVar;
            Map<String, String> map3 = map2;
            aVar = aVar2;
            map = map3;
        } else if (i == 0) {
            z = true;
            accessToken = null;
            aVar = LoginClient.Result.a.CANCEL;
            request = null;
            kVar = null;
            map = null;
        } else {
            z = false;
            accessToken = null;
            aVar = aVar3;
            request = null;
            kVar = null;
            map = null;
        }
        if (kVar == null && accessToken == null && !z) {
            kVar = new k("Unexpected call to LoginManager.onActivityResult");
        }
        a(null, aVar, map, kVar, true, request);
        a(accessToken, request, kVar, z, hVar);
        return true;
    }

    public void b(Activity activity, Collection<String> collection) {
        c(collection);
        a(new a(activity), a(collection));
    }

    public void b(Fragment fragment, Collection<String> collection) {
        b(new o(fragment), collection);
    }

    public void b(android.support.v4.app.Fragment fragment, Collection<String> collection) {
        b(new o(fragment), collection);
    }

    public void d() {
        AccessToken.a((AccessToken) null);
        Profile.a(null);
    }
}
