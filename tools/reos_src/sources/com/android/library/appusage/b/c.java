package com.android.library.appusage.b;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.android.apps.config.Config;
import com.android.library.userprofile.util.UtilFunctions;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2579a = "identifier";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2580b = "category";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f2581c = "version";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f2582d = "actionId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f2583e = "values";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f2584f = "appUsage";
    private static String g = "sessionLength";
    private static String h = "DAILY";
    private static String i = "WEEKLY";
    private static String j = UtilFunctions.MONTHLY;
    private static String k = "YEARLY";

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            return "notFound";
        }
    }

    public static Map<String, UsageStats> a(int i2, Context context, UsageStatsManager usageStatsManager) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        switch (i2) {
            case 0:
                calendar2.add(6, -1);
                break;
            case 1:
                calendar2.add(3, -1);
                break;
            case 2:
                calendar2.add(2, -1);
                break;
            case 3:
                calendar2.add(1, -1);
                break;
        }
        return usageStatsManager.queryAndAggregateUsageStats(calendar2.getTimeInMillis(), calendar.getTimeInMillis());
    }

    public static JSONObject a(ArrayList<com.android.library.appusage.a.c> arrayList, Context context) {
        JSONArray jSONArray;
        String strA = new com.google.a.f().a(arrayList, new com.google.a.c.a<ArrayList<com.android.library.appusage.a.c>>() { // from class: com.android.library.appusage.b.c.1
        }.getType());
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strA);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = jSONArray2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f2579a, b.a(context));
            jSONObject.put(f2580b, f2584f);
            jSONObject.put(f2581c, a(context));
            jSONObject.put(f2583e, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean a(String str, Context context) {
        Config config = Config.getInstance(context);
        if (!str.contains(".")) {
            return false;
        }
        String str2 = config.get("appUsageLib.appsToIgnore");
        if (str2.equals("") || str2.isEmpty() || str2 == null) {
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

    public static ArrayList<com.android.library.appusage.a.c> b(Context context) {
        String str;
        Map<String, UsageStats> mapA;
        String str2 = Config.getInstance(context).get("appUsageLib.usageFrequency");
        ArrayList<com.android.library.appusage.a.c> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 21) {
            return arrayList;
        }
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
        if (str2.equals(h)) {
            str = str2;
            mapA = a(0, context, usageStatsManager);
        } else if (str2.equals(i)) {
            str = str2;
            mapA = a(1, context, usageStatsManager);
        } else if (str2.equals(j)) {
            str = str2;
            mapA = a(2, context, usageStatsManager);
        } else if (str2.equals(k)) {
            str = str2;
            mapA = a(3, context, usageStatsManager);
        } else {
            str = i;
            mapA = a(1, context, usageStatsManager);
        }
        for (String str3 : mapA.keySet()) {
            if (a(str3, context)) {
                com.android.library.appusage.a.c cVar = new com.android.library.appusage.a.c();
                cVar.a(System.currentTimeMillis());
                cVar.b(str);
                cVar.a(str3);
                cVar.b(TimeUnit.MILLISECONDS.toMinutes(mapA.get(str3).getTotalTimeInForeground()));
                if (cVar.a() > 0) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }
}
