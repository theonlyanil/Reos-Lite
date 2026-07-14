package com.flurry.sdk;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class jt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4522a = jt.class.getSimpleName();

    public static int a() {
        int iIntValue = ((Integer) lk.a().a("AgentVersion")).intValue();
        kg.a(4, f4522a, "getAgentVersion() = " + iIntValue);
        return iIntValue;
    }

    public static int b() {
        return ((Integer) lk.a().a("ReleaseMajorVersion")).intValue();
    }

    public static int c() {
        return ((Integer) lk.a().a("ReleaseMinorVersion")).intValue();
    }

    public static int d() {
        return ((Integer) lk.a().a("ReleasePatchVersion")).intValue();
    }

    public static String e() {
        return (String) lk.a().a("ReleaseBetaVersion");
    }

    public static String f() {
        return String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", Integer.valueOf(a()), Integer.valueOf(b()), Integer.valueOf(c()), Integer.valueOf(d()), e().length() > 0 ? "." : "", e());
    }
}
