package com.flurry.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class mb implements kj, ll.a, Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4740a = mb.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4741b;

    @Override // com.flurry.sdk.kj
    public void a(Context context) {
        lk lkVarA = lk.a();
        this.f4741b = ((Boolean) lkVarA.a("CaptureUncaughtExceptions")).booleanValue();
        lkVarA.a("CaptureUncaughtExceptions", (ll.a) this);
        kg.a(4, f4740a, "initSettings, CrashReportingEnabled = " + this.f4741b);
        mc.a().a(this);
    }

    @Override // com.flurry.sdk.ll.a
    public void a(String str, Object obj) {
        if (!str.equals("CaptureUncaughtExceptions")) {
            kg.a(6, f4740a, "onSettingUpdate internal error!");
        } else {
            this.f4741b = ((Boolean) obj).booleanValue();
            kg.a(4, f4740a, "onSettingUpdate, CrashReportingEnabled = " + this.f4741b);
        }
    }

    @Override // com.flurry.sdk.kj
    public void b() {
        mc.b();
        lk.a().b("CaptureUncaughtExceptions", (ll.a) this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
        if (this.f4741b) {
            String message = "";
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StringBuilder sb = new StringBuilder();
                if (th.getMessage() != null) {
                    sb.append(" (" + th.getMessage() + ")\n");
                }
                message = sb.toString();
            } else if (th.getMessage() != null) {
                message = th.getMessage();
            }
            hl.a().a("uncaught", message, th);
        }
        lh.a().g();
        jj.a().d();
    }
}
