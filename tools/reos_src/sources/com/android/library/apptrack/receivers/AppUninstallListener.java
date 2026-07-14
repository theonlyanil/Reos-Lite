package com.android.library.apptrack.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.apptrack.POJO.UninstallEvent;
import com.android.library.apptrack.a.a;
import com.android.library.apptrack.a.b;
import com.android.library.apptrack.a.c;
import com.android.library.apptrack.a.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppUninstallListener extends BroadcastReceiver {
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
        if (intent.getAction().equalsIgnoreCase("android.intent.action.PACKAGE_REMOVED")) {
            Uri data = intent.getData();
            final String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
            if (schemeSpecificPart != null && b.a(schemeSpecificPart, context)) {
                CLog.a(a.f2539a, "Package detected as our auto delete package :" + schemeSpecificPart);
                UninstallEvent uninstallEvent = new UninstallEvent();
                uninstallEvent.a(schemeSpecificPart);
                uninstallEvent.a(System.currentTimeMillis());
                new c(context, d.a(uninstallEvent, context, true));
                b.b(schemeSpecificPart, context);
                return;
            }
            if (a(schemeSpecificPart, context)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(schemeSpecificPart);
                if (!a.f2540b.containsKey("uninstallPackages")) {
                    arrayList.add(schemeSpecificPart);
                    a.f2540b.put("uninstallPackages", arrayList);
                } else if (!a.f2540b.get("uninstallPackages").contains(schemeSpecificPart)) {
                    List<String> list = a.f2540b.get("uninstallPackages");
                    list.add(schemeSpecificPart);
                    a.f2540b.put("uninstallPackages", list);
                }
                UninstallEvent uninstallEvent2 = new UninstallEvent();
                uninstallEvent2.a(schemeSpecificPart);
                uninstallEvent2.a(System.currentTimeMillis());
                final JSONObject jSONObjectA = d.a(uninstallEvent2, context, false);
                new Handler().postDelayed(new Runnable() { // from class: com.android.library.apptrack.receivers.AppUninstallListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.f2540b.containsKey("installPackages")) {
                            CLog.a(a.f2539a, jSONObjectA.toString());
                            new c(context, jSONObjectA);
                            if (a.f2540b.containsKey("uninstallPackages")) {
                                a.f2540b.get("uninstallPackages").remove(schemeSpecificPart);
                            }
                            if (a.f2540b.containsKey("installPackages")) {
                                a.f2540b.get("installPackages").remove(schemeSpecificPart);
                                return;
                            }
                            return;
                        }
                        if (a.f2540b.get("installPackages").contains(schemeSpecificPart)) {
                            return;
                        }
                        CLog.a(a.f2539a, jSONObjectA.toString());
                        new c(context, jSONObjectA);
                        if (a.f2540b.containsKey("uninstallPackages")) {
                            a.f2540b.get("uninstallPackages").remove(schemeSpecificPart);
                        }
                        if (a.f2540b.containsKey("installPackages")) {
                            a.f2540b.get("installPackages").remove(schemeSpecificPart);
                        }
                    }
                }, 10000L);
            }
        }
    }
}
