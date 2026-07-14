package com.android.library.apptrack.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.apptrack.a.a;
import com.android.library.apptrack.a.c;
import com.android.library.apptrack.a.d;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppInstallListener extends BroadcastReceiver {
    private JSONObject a(Context context, String str) {
        String installerPackageName;
        PackageManager packageManager = context.getPackageManager();
        try {
            installerPackageName = packageManager.getInstallerPackageName(str);
        } catch (Exception e2) {
            try {
                TimeUnit.SECONDS.sleep(5L);
                installerPackageName = packageManager.getInstallerPackageName(str);
            } catch (Exception e3) {
                installerPackageName = null;
            }
        }
        if (installerPackageName != null && installerPackageName.equalsIgnoreCase(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE)) {
            d.a(context, System.currentTimeMillis());
        }
        if (installerPackageName == null || installerPackageName.equals("")) {
            installerPackageName = "other";
        }
        return a(installerPackageName);
    }

    private JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("platform", str);
                return jSONObject2;
            } catch (JSONException e3) {
                return jSONObject;
            }
        }
    }

    private boolean a(String str, Context context) {
        Config config = Config.getInstance(context);
        if (!str.contains(".")) {
            return false;
        }
        String str2 = config.get("appTrackLib.appsToIgnore");
        if (str2 == null || str2.isEmpty() || str2.equals("")) {
            return true;
        }
        String[] strArrSplit = str2.split(",");
        for (String str3 : strArrSplit) {
            if (str.startsWith(str3)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        String str;
        String str2;
        if (intent.getAction().equalsIgnoreCase("android.intent.action.PACKAGE_REPLACED")) {
            Uri data = intent.getData();
            final String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
            if (a(schemeSpecificPart, context)) {
                ArrayList arrayList = new ArrayList();
                if (!a.f2540b.containsKey("replacePackages")) {
                    arrayList.add(schemeSpecificPart);
                    a.f2540b.put("replacePackages", arrayList);
                } else if (!a.f2540b.get("replacePackages").contains(schemeSpecificPart)) {
                    List<String> list = a.f2540b.get("replacePackages");
                    list.add(schemeSpecificPart);
                    a.f2540b.put("replacePackages", list);
                }
                try {
                    str2 = context.getPackageManager().getPackageInfo(schemeSpecificPart, 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    str2 = "notFound";
                }
                final JSONObject jSONObjectA = d.a(System.currentTimeMillis(), schemeSpecificPart, str2, a(context, schemeSpecificPart), context, "replace");
                new Handler().postDelayed(new Runnable() { // from class: com.android.library.apptrack.receivers.AppInstallListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CLog.a(a.f2539a, jSONObjectA.toString());
                        new c(context, jSONObjectA);
                        if (a.f2540b.containsKey("uninstallPackages")) {
                            a.f2540b.get("uninstallPackages").remove(schemeSpecificPart);
                        }
                        if (a.f2540b.containsKey("installPackages")) {
                            a.f2540b.get("installPackages").remove(schemeSpecificPart);
                        }
                        if (a.f2540b.containsKey("replacePackages")) {
                            a.f2540b.get("replacePackages").remove(schemeSpecificPart);
                        }
                    }
                }, 10000L);
            }
        }
        if (intent.getAction().equalsIgnoreCase("android.intent.action.PACKAGE_ADDED")) {
            Uri data2 = intent.getData();
            final String schemeSpecificPart2 = data2 != null ? data2.getSchemeSpecificPart() : null;
            if (a(schemeSpecificPart2, context)) {
                ArrayList arrayList2 = new ArrayList();
                if (!a.f2540b.containsKey("installPackages")) {
                    arrayList2.add(schemeSpecificPart2);
                    a.f2540b.put("installPackages", arrayList2);
                } else if (!a.f2540b.get("installPackages").contains(schemeSpecificPart2)) {
                    List<String> list2 = a.f2540b.get("installPackages");
                    list2.add(schemeSpecificPart2);
                    a.f2540b.put("installPackages", list2);
                }
                try {
                    str = context.getPackageManager().getPackageInfo(schemeSpecificPart2, 0).versionName;
                } catch (PackageManager.NameNotFoundException e3) {
                    str = "notFound";
                }
                final JSONObject jSONObjectA2 = d.a(System.currentTimeMillis(), schemeSpecificPart2, str, a(context, schemeSpecificPart2), context, "install");
                new Handler().postDelayed(new Runnable() { // from class: com.android.library.apptrack.receivers.AppInstallListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.f2540b.containsKey("replacePackages")) {
                            CLog.a(a.f2539a, jSONObjectA2.toString());
                            new c(context, jSONObjectA2);
                            if (a.f2540b.containsKey("uninstallPackages")) {
                                a.f2540b.get("uninstallPackages").remove(schemeSpecificPart2);
                            }
                            if (a.f2540b.containsKey("installPackages")) {
                                a.f2540b.get("installPackages").remove(schemeSpecificPart2);
                                return;
                            }
                            return;
                        }
                        if (a.f2540b.get("replacePackages").contains(schemeSpecificPart2)) {
                            return;
                        }
                        CLog.a(a.f2539a, jSONObjectA2.toString());
                        new c(context, jSONObjectA2);
                        if (a.f2540b.containsKey("uninstallPackages")) {
                            a.f2540b.get("uninstallPackages").remove(schemeSpecificPart2);
                        }
                        if (a.f2540b.containsKey("installPackages")) {
                            a.f2540b.get("installPackages").remove(schemeSpecificPart2);
                        }
                    }
                }, 10000L);
            }
        }
    }
}
