package com.android.library.apptrack.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.android.apps.config.Config;
import com.android.library.apptrack.POJO.UninstallEvent;
import com.google.a.f;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2542a = "identifier";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2543b = "category";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f2544c = "version";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f2545d = "actionId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f2546e = "values";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f2547f = "com.cube26.library.apptrack";
    private static String g = ".library.apptrack";
    private static String h = "apptrack";
    private static String i = "uninstall";
    private static String j = "eventTime";
    private static String k = "packageName";
    private static String l = "version";

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            return "notFound";
        }
    }

    public static JSONObject a(long j2, String str, String str2, JSONObject jSONObject, Context context, String str3) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(j, j2);
            jSONObject2.put(k, str);
            jSONObject2.put(l, str2);
        } catch (JSONException e2) {
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject2.put(next, jSONObject.get(next));
            } catch (JSONException e3) {
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject3.put(f2542a, b(context));
            jSONObject3.put(f2543b, h);
            jSONObject3.put(f2545d, str3);
            jSONObject3.put(f2544c, a(context));
            jSONArray.put(0, jSONObject2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject3.put(f2546e, jSONArray);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        return jSONObject3;
    }

    public static JSONObject a(UninstallEvent uninstallEvent, Context context, boolean z) {
        String strA = new f().a(uninstallEvent, new com.google.a.c.a<UninstallEvent>() { // from class: com.android.library.apptrack.a.d.1
        }.getType());
        new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(strA);
            if (z) {
                jSONObject.put("auto", "true");
                jSONObject.put("platform", context.getApplicationContext().getPackageName());
            }
            jSONArray.put(0, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(f2542a, b(context));
            jSONObject2.put(f2543b, h);
            jSONObject2.put(f2545d, i);
            jSONObject2.put(f2544c, a(context));
            jSONObject2.put(f2546e, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject2;
    }

    public static void a(Context context, long j2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("app_track_shared_prefs", 0).edit();
        editorEdit.putLong("last_seen_on_play_store", j2);
        editorEdit.commit();
    }

    public static String b(Context context) {
        String str = Config.getInstance(context).get("configLib.idPrefix");
        return str == null ? f2547f : str + g;
    }
}
