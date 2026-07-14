package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class jo implements ll.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static jo f4499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4500b = jo.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4502d;

    private jo() {
        lk lkVarA = lk.a();
        this.f4501c = (String) lkVarA.a("VersionName");
        lkVarA.a("VersionName", (ll.a) this);
        kg.a(4, f4500b, "initSettings, VersionName = " + this.f4501c);
    }

    public static synchronized jo a() {
        if (f4499a == null) {
            f4499a = new jo();
        }
        return f4499a;
    }

    public static void b() {
        if (f4499a != null) {
            lk.a().b("VersionName", (ll.a) f4499a);
        }
        f4499a = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001b, code lost:
    
        r0 = "Unknown";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String f() {
        /*
            r4 = this;
            com.flurry.sdk.js r0 = com.flurry.sdk.js.a()     // Catch: java.lang.Throwable -> L27
            android.content.Context r0 = r0.c()     // Catch: java.lang.Throwable -> L27
            android.content.pm.PackageManager r1 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L27
            java.lang.String r0 = r0.getPackageName()     // Catch: java.lang.Throwable -> L27
            r2 = 0
            android.content.pm.PackageInfo r0 = r1.getPackageInfo(r0, r2)     // Catch: java.lang.Throwable -> L27
            java.lang.String r1 = r0.versionName     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L1c
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Throwable -> L27
        L1b:
            return r0
        L1c:
            int r1 = r0.versionCode     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L30
            int r0 = r0.versionCode     // Catch: java.lang.Throwable -> L27
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch: java.lang.Throwable -> L27
            goto L1b
        L27:
            r0 = move-exception
            r1 = 6
            java.lang.String r2 = com.flurry.sdk.jo.f4500b
            java.lang.String r3 = ""
            com.flurry.sdk.kg.a(r1, r2, r3, r0)
        L30:
            java.lang.String r0 = "Unknown"
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.jo.f():java.lang.String");
    }

    @Override // com.flurry.sdk.ll.a
    public void a(String str, Object obj) {
        if (!str.equals("VersionName")) {
            kg.a(6, f4500b, "onSettingUpdate internal error!");
        } else {
            this.f4501c = (String) obj;
            kg.a(4, f4500b, "onSettingUpdate, VersionName = " + this.f4501c);
        }
    }

    public String c() {
        return Build.VERSION.RELEASE;
    }

    public String d() {
        return Build.DEVICE;
    }

    public synchronized String e() {
        String str;
        if (!TextUtils.isEmpty(this.f4501c)) {
            str = this.f4501c;
        } else if (TextUtils.isEmpty(this.f4502d)) {
            this.f4502d = f();
            str = this.f4502d;
        } else {
            str = this.f4502d;
        }
        return str;
    }
}
