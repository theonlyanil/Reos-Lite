package com.a.a.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.a.a.d.c> f2481a = new ConcurrentHashMap<>();

    public static com.a.a.d.c a(Context context) {
        String packageName = context.getPackageName();
        com.a.a.d.c cVar = f2481a.get(packageName);
        if (cVar != null) {
            return cVar;
        }
        com.a.a.d.c cVarB = b(context);
        com.a.a.d.c cVarPutIfAbsent = f2481a.putIfAbsent(packageName, cVarB);
        return cVarPutIfAbsent == null ? cVarB : cVarPutIfAbsent;
    }

    private static com.a.a.d.c b(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return new c(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
    }
}
