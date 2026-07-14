package com.android.library.appusage.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.android.apps.config.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2573a = "identifier";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2574b = "category";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f2575c = "version";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f2576d = "actionId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f2577e = "values";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f2578f = "eventTime";
    private static String g = "packages";
    private static String h = "eventInterval";
    private static String i = ".library.appusage";
    private static String j = "appList";
    private static String k = "installedApps";

    public static String a(Context context) {
        return Config.getInstance(context).get("configLib.idPrefix") + i;
    }

    public static JSONObject a(ArrayList<String> arrayList, Context context) {
        JSONArray jSONArray;
        String strA = new com.google.a.f().a(arrayList, new com.google.a.c.a<ArrayList<com.android.library.appusage.a.c>>() { // from class: com.android.library.appusage.b.b.1
        }.getType());
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strA);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = jSONArray2;
        }
        String str = Config.getInstance(context).get("appUsageLib.appListFrequency");
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put(f2578f, jCurrentTimeMillis);
            jSONObject.put(g, jSONArray);
            jSONObject.put(h, str);
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(0, jSONObject);
            jSONObject2.put(f2573a, a(context));
            jSONObject2.put(f2574b, j);
            jSONObject2.put(f2575c, b(context));
            jSONObject2.put(f2577e, jSONArray3);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject2;
    }

    private static boolean a(String str, Context context) {
        Config config = Config.getInstance(context);
        if (!str.contains(".")) {
            return false;
        }
        String str2 = config.get("appUsageLib.appsToIgnore");
        if (str2.equals("") || str2.isEmpty()) {
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

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            return "notFound";
        }
    }

    public static ArrayList<String> c(Context context) {
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(128);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<ApplicationInfo> it = installedApplications.iterator();
        while (it.hasNext()) {
            String str = it.next().packageName;
            if (a(str, context)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
