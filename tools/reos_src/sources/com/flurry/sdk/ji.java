package com.flurry.sdk;

import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class ji {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ji f4470a;

    private ji() {
    }

    public static synchronized ji a() {
        if (f4470a == null) {
            f4470a = new ji();
        }
        return f4470a;
    }

    public static void b() {
        f4470a = null;
    }

    public String c() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    public String d() {
        return TimeZone.getDefault().getID();
    }
}
