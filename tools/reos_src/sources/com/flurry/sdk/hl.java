package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.FlurryEventRecordStatus;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class hl implements kj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4208a = hl.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ig f4209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private iy f4210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ii f4211d;

    public static synchronized hl a() {
        return (hl) js.a().a(hl.class);
    }

    private jb a(lf lfVar) {
        if (lfVar == null) {
            return null;
        }
        return (jb) lfVar.c(jb.class);
    }

    private void b(Context context) {
        if (!lt.a(context, "android.permission.INTERNET")) {
            kg.b(f4208a, "Application must declare permission: android.permission.INTERNET");
        }
        if (lt.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return;
        }
        kg.e(f4208a, "It is highly recommended that the application declare permission: android.permission.ACCESS_NETWORK_STATE");
    }

    private jb h() {
        return a(lh.a().e());
    }

    public FlurryEventRecordStatus a(String str) {
        jb jbVarH = h();
        return jbVarH != null ? jbVarH.a(str, (Map<String, String>) null, false) : FlurryEventRecordStatus.kFlurryEventFailed;
    }

    public FlurryEventRecordStatus a(String str, String str2, Map<String, String> map) {
        jb jbVarH = h();
        return jbVarH != null ? jbVarH.a(str, str2, map, false) : FlurryEventRecordStatus.kFlurryEventFailed;
    }

    public FlurryEventRecordStatus a(String str, Map<String, String> map) {
        jb jbVarH = h();
        return jbVarH != null ? jbVarH.a(str, map, false) : FlurryEventRecordStatus.kFlurryEventFailed;
    }

    public FlurryEventRecordStatus a(String str, Map<String, String> map, boolean z) {
        jb jbVarH = h();
        return jbVarH != null ? jbVarH.a(str, map, z) : FlurryEventRecordStatus.kFlurryEventFailed;
    }

    public FlurryEventRecordStatus a(String str, boolean z) {
        jb jbVarH = h();
        return jbVarH != null ? jbVarH.a(str, (Map<String, String>) null, z) : FlurryEventRecordStatus.kFlurryEventFailed;
    }

    @Override // com.flurry.sdk.kj
    public void a(Context context) {
        lf.a(jb.class);
        this.f4210c = new iy();
        this.f4209b = new ig();
        this.f4211d = new ii();
        b(context);
    }

    @Deprecated
    public void a(String str, String str2, String str3) {
        StackTraceElement[] stackTraceElementArr;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 2) {
            stackTraceElementArr = stackTrace;
        } else {
            stackTraceElementArr = new StackTraceElement[stackTrace.length - 2];
            System.arraycopy(stackTrace, 2, stackTraceElementArr, 0, stackTraceElementArr.length);
        }
        Throwable th = new Throwable(str2);
        th.setStackTrace(stackTraceElementArr);
        jb jbVarH = h();
        if (jbVarH != null) {
            jbVarH.a(str, str2, str3, th);
        }
    }

    public void a(String str, String str2, Throwable th) {
        jb jbVarH = h();
        if (jbVarH != null) {
            jbVarH.a(str, str2, th.getClass().getName(), th);
        }
    }

    public FlurryEventRecordStatus b(String str, String str2, Map<String, String> map) {
        jb jbVarH = h();
        return jbVarH != null ? jbVarH.a(str, jd.a(str2), map, false) : FlurryEventRecordStatus.kFlurryEventFailed;
    }

    @Override // com.flurry.sdk.kj
    public void b() {
        if (this.f4211d != null) {
            this.f4211d.c();
            this.f4211d = null;
        }
        if (this.f4210c != null) {
            this.f4210c.a();
            this.f4210c = null;
        }
        if (this.f4209b != null) {
            this.f4209b.a();
            this.f4209b = null;
        }
        lf.b(jb.class);
    }

    public void b(String str) {
        jb jbVarH = h();
        if (jbVarH != null) {
            jbVarH.a(str, (Map<String, String>) null);
        }
    }

    public void b(String str, Map<String, String> map) {
        jb jbVarH = h();
        if (jbVarH != null) {
            jbVarH.a(str, map);
        }
    }

    public ig c() {
        return this.f4209b;
    }

    public void c(String str) {
        jb jbVarH = h();
        if (jbVarH != null) {
            jbVarH.a(str, (Map<String, String>) null, false);
        }
    }

    public void c(String str, Map<String, String> map) {
        jb jbVarH = h();
        if (jbVarH != null) {
            jbVarH.a(str, map, false);
        }
    }

    public iy d() {
        return this.f4210c;
    }

    public ii e() {
        return this.f4211d;
    }

    public void f() {
        jb jbVarH = h();
        if (jbVarH != null) {
            jbVarH.a();
        }
    }

    public void g() {
        jb jbVarH = h();
        if (jbVarH != null) {
            jbVarH.b();
        }
    }
}
