package com.flurry.sdk;

import android.location.Criteria;
import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public class lk extends ll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f4705a = 216;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f4706b = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Integer f4707c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer f4708d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f4709e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Boolean f4710f = true;
    public static final Boolean g = true;
    public static final String h = null;
    public static final Boolean i = true;
    public static final Criteria j = null;
    public static final Location k = null;
    public static final Long l = 10000L;
    public static final Boolean m = true;
    public static final Long n = null;
    public static final Byte o = (byte) -1;
    public static final Boolean p = false;
    public static final String q = null;
    public static final Boolean r = true;
    private static lk s;

    private lk() {
        c();
    }

    public static synchronized lk a() {
        if (s == null) {
            s = new lk();
        }
        return s;
    }

    public static synchronized void b() {
        if (s != null) {
            s.d();
        }
        s = null;
    }

    public void c() {
        a("AgentVersion", (Object) f4705a);
        a("ReleaseMajorVersion", (Object) f4706b);
        a("ReleaseMinorVersion", (Object) f4707c);
        a("ReleasePatchVersion", (Object) f4708d);
        a("ReleaseBetaVersion", "");
        a("VersionName", (Object) f4709e);
        a("CaptureUncaughtExceptions", (Object) f4710f);
        a("UseHttps", (Object) g);
        a("ReportUrl", (Object) h);
        a("ReportLocation", (Object) i);
        a("ExplicitLocation", (Object) k);
        a("ContinueSessionMillis", (Object) l);
        a("LogEvents", (Object) m);
        a("Age", (Object) n);
        a("Gender", (Object) o);
        a("UserId", "");
        a("ProtonEnabled", (Object) p);
        a("ProtonConfigUrl", (Object) q);
        a("analyticsEnabled", (Object) r);
    }
}
