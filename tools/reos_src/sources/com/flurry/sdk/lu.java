package com.flurry.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class lu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4727a = lu.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f4728b = "com.google.android.gms.common.GooglePlayServicesUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f4729c = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    static String a(Object obj, String str) {
        try {
            return (String) lw.a(obj, "getId").a();
        } catch (Exception e2) {
            kg.b(f4727a, "GOOGLE PLAY SERVICES ERROR: " + e2.getMessage());
            kg.b(f4727a, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return str;
        }
    }

    public static boolean a(Context context) {
        try {
            Object objA = lw.a(null, "isGooglePlayServicesAvailable").a(Class.forName(f4728b)).a(Context.class, context).a();
            return objA != null && ((Integer) objA).intValue() == 0;
        } catch (Exception e2) {
            kg.b(f4727a, "GOOGLE PLAY SERVICES EXCEPTION: " + e2.getMessage());
            kg.b(f4727a, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return false;
        }
    }

    static boolean a(Object obj, boolean z) {
        try {
            Boolean bool = (Boolean) lw.a(obj, "isLimitAdTrackingEnabled").a();
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e2) {
            kg.b(f4727a, "GOOGLE PLAY SERVICES ERROR: " + e2.getMessage());
            kg.b(f4727a, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return z;
        }
    }

    public static jp b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object objA = lw.a(null, "getAdvertisingIdInfo").a(Class.forName(f4729c)).a(Context.class, context).a();
            return new jp(a(objA, (String) null), a(objA, false));
        } catch (Exception e2) {
            kg.b(f4727a, "GOOGLE PLAY SERVICES ERROR: " + e2.getMessage());
            kg.b(f4727a, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        }
    }
}
