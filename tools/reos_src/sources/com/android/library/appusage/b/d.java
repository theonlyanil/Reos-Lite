package com.android.library.appusage.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.appusage.usagetrack.DCService;
import com.android.library.userprofile.util.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2585a = "identifier";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2586b = "category";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f2587c = "version";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f2588d = "actionId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f2589e = "values";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f2590f = "eventTime";
    private static String g = "eventInterval";
    private static String h = "trackDetails";
    private static String i = "packageName";
    private static String j = "count";

    public static int a(Context context, int i2) {
        ArrayList<com.android.library.appusage.a.a> arrayListF = f(context);
        int size = arrayListF.size() + 2345;
        arrayListF.add(new com.android.library.appusage.a.a(size, i2));
        a(context, arrayListF);
        return size;
    }

    public static JSONObject a(ArrayList<com.android.library.appusage.a.b> arrayList, Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj = Config.getInstance(context).get("appUsageLib.ucsFrequency");
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (com.android.library.appusage.a.b bVar : arrayList) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(i, bVar.a());
                jSONObject3.put(j, bVar.b());
                jSONArray.put(jSONObject3);
            }
            jSONObject2.put(h, jSONArray);
            jSONObject2.put(g, obj);
            jSONObject2.put(f2590f, System.currentTimeMillis());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            jSONObject.put(f2589e, jSONArray2);
            jSONObject.put(f2586b, "appUsage");
            jSONObject.put(f2588d, "");
            jSONObject.put(f2585a, b.a(context));
            jSONObject.put(f2587c, b.b(context));
        } catch (JSONException e2) {
            CLog.d(a.f2572b, "Error while creating track apps JSON");
        }
        return jSONObject;
    }

    public static void a(Context context, ArrayList<com.android.library.appusage.a.a> arrayList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.android.appusage.sharedprefs.filename", 0);
        try {
            JSONArray jSONArray = new JSONArray();
            for (com.android.library.appusage.a.a aVar : arrayList) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alarm_type", aVar.b());
                jSONObject.put("alarm_id", aVar.a());
                jSONArray.put(jSONObject);
            }
            sharedPreferences.edit().putString("com.android.appusage.sharedprefs.key.alarm", jSONArray.toString()).commit();
        } catch (Exception e2) {
            CLog.d(a.f2572b, "Exception while trying to save alarms json list");
        }
    }

    public static boolean a(Context context) {
        String str = Config.getInstance(context).get("appUsageLib.shouldflush");
        return str != null && str.equals("true");
    }

    public static boolean a(Class<?> cls, Context context) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (cls.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            if (str.equals(context.getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName)) {
                return false;
            }
        } catch (Exception e2) {
            CLog.d(a.f2572b, "Exception while finding package name of launcher");
        }
        Config config = Config.getInstance(context);
        if (!str.contains(".")) {
            return false;
        }
        String str2 = config.get("appUsageLib.ucsIgnore");
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

    public static ArrayList<com.android.library.appusage.a.d> b(Context context) {
        Config config = Config.getInstance(context);
        ArrayList<com.android.library.appusage.a.d> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(config.get("appUsageLib.ucsTimeSlots"));
            if (jSONObject.has("slots")) {
                JSONArray jSONArray = jSONObject.getJSONArray("slots");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2.has("start_time") && jSONObject2.has("end_time")) {
                        com.android.library.appusage.a.d dVar = new com.android.library.appusage.a.d();
                        dVar.a(jSONObject2.getString("start_time"));
                        dVar.b(jSONObject2.getString("end_time"));
                        if (jSONObject2.has(Constants.SMS_COLUMN_DATE)) {
                            dVar.c(jSONObject2.getString(Constants.SMS_COLUMN_DATE));
                        }
                        arrayList.add(dVar);
                    }
                }
            }
        } catch (Exception e2) {
            CLog.d(a.f2572b, "Exception occurred while parsing tracking time slots :" + e2.getMessage());
        }
        return arrayList;
    }

    public static ArrayList<com.android.library.appusage.a.b> b(ArrayList<com.android.library.appusage.a.b> arrayList, Context context) {
        ArrayList<com.android.library.appusage.a.b> arrayList2 = new ArrayList<>();
        for (com.android.library.appusage.a.b bVar : arrayList) {
            if (a(bVar.a(), context)) {
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    public static void c(Context context) {
        Intent intent = new Intent(context, (Class<?>) DCService.class);
        intent.putExtra("com.android.appusage.intentextra.startingservice", true);
        context.startService(intent);
    }

    public static int d(Context context) {
        int i2;
        try {
            i2 = Integer.parseInt(Config.getInstance(context).get("appUsageLib.ucsPeriodInDays"));
        } catch (Exception e2) {
            CLog.d(a.f2572b, "Exception while parsing dc interval in days from config");
            i2 = 1;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    public static int e(Context context) {
        int i2;
        try {
            i2 = Integer.parseInt(Config.getInstance(context).get("appUsageLib.ucsRepeatIntervalInSec"));
        } catch (Exception e2) {
            CLog.d(a.f2572b, "Exception while parsing dc interval in days from config");
            i2 = 5;
        }
        if (i2 < 1) {
            return 5;
        }
        return i2;
    }

    public static ArrayList<com.android.library.appusage.a.a> f(Context context) {
        ArrayList<com.android.library.appusage.a.a> arrayList = new ArrayList<>();
        String string = context.getSharedPreferences("com.android.appusage.sharedprefs.filename", 0).getString("com.android.appusage.sharedprefs.key.alarm", null);
        if (string != null && !string.equals("")) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    arrayList.add(new com.android.library.appusage.a.a(jSONObject.getInt("alarm_id"), jSONObject.getInt("alarm_type")));
                }
            } catch (Exception e2) {
                CLog.d(a.f2572b, "Exception while trying to parse saved alarms list");
            }
        }
        return arrayList;
    }
}
