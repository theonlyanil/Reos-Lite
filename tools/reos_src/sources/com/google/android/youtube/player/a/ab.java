package com.google.android.youtube.player.a;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* JADX INFO: loaded from: classes.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f5305a = Uri.parse("http://play.google.com/store/apps/details");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f5306b = {"com.google.android.youtube", "com.google.android.youtube.tv", "com.google.android.youtube.googletv", "com.google.android.gms", null};

    public static Intent a(String str) {
        Uri uriFromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uriFromParts);
        return intent;
    }

    public static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        for (String str : f5306b) {
            ResolveInfo resolveInfoResolveService = packageManager.resolveService(new Intent("com.google.android.youtube.api.service.START").setPackage(str), 0);
            if (resolveInfoResolveService != null && resolveInfoResolveService.serviceInfo != null && resolveInfoResolveService.serviceInfo.packageName != null) {
                return resolveInfoResolveService.serviceInfo.packageName;
            }
        }
        if (packageManager.hasSystemFeature("android.software.leanback")) {
            return "com.google.android.youtube.tv";
        }
        return packageManager.hasSystemFeature("com.google.android.tv") ? "com.google.android.youtube.googletv" : "com.google.android.youtube";
    }

    public static boolean a(Context context, String str) {
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(str);
            if (str.equals("com.google.android.youtube.googletvdev")) {
                str = "com.google.android.youtube.googletv";
            }
            int identifier = resourcesForApplication.getIdentifier("youtube_api_version_code", "integer", str);
            return identifier == 0 || 12 > resourcesForApplication.getInteger(identifier) / 100;
        } catch (PackageManager.NameNotFoundException e2) {
            return true;
        }
    }

    public static Context b(Context context) {
        try {
            return context.createPackageContext(a(context), 3);
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static Intent b(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(f5305a.buildUpon().appendQueryParameter("id", str).build());
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        intent.addFlags(524288);
        return intent;
    }

    public static int c(Context context) {
        Context contextB = b(context);
        int identifier = contextB != null ? contextB.getResources().getIdentifier("clientTheme", "style", a(context)) : 0;
        if (identifier != 0) {
            return identifier;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return R.style.Theme.DeviceDefault;
        }
        return Build.VERSION.SDK_INT >= 11 ? R.style.Theme.Holo : R.style.Theme;
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", e2);
        }
    }
}
