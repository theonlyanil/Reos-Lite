package com.android.library.deviceData.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.google.a.f;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2638a = "com.android.library.deviceData".concat("is_alarm_setted_up_once");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2639b = "com.android.library.deviceData".concat("device_data_sent_time");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f2640c = "com.android.library.deviceData".concat("advertising_value");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f2641d = e.class.getName();

    public static int a(Context context) {
        try {
            return Integer.valueOf(Config.getInstance(context).get("deviceSpecLib.frequencyInDay")).intValue();
        } catch (NumberFormatException e2) {
            return Integer.valueOf("30").intValue();
        }
    }

    public static void a(Context context, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.android.library.deviceData", 0).edit();
        editorEdit.putLong(f2639b, j);
        editorEdit.commit();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.android.library.deviceData.c.e$1] */
    public static synchronized void a(Context context, final com.android.library.deviceData.c cVar) {
        final Context applicationContext = context.getApplicationContext();
        new AsyncTask<Void, Void, String>() { // from class: com.android.library.deviceData.c.e.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String doInBackground(Void... voidArr) {
                AdvertisingIdClient.Info advertisingIdInfo;
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext);
                } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e2) {
                    CLog.c(e.f2641d, "setGaid# exception ", e2);
                    advertisingIdInfo = null;
                }
                return advertisingIdInfo == null ? "" : advertisingIdInfo.getId();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(String str) {
                SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("com.android.library.deviceData", 0).edit();
                editorEdit.putString(e.f2640c, str);
                editorEdit.commit();
                if (cVar != null) {
                    cVar.a();
                }
            }
        }.execute(new Void[0]);
    }

    public static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    public static String b(String str) {
        try {
            return new JSONObject(str).toString(2);
        } catch (JSONException e2) {
            CLog.c(f2641d, "getReadableJson# ", e2);
            return "";
        }
    }

    public static boolean b(Context context) {
        return context.getSharedPreferences("com.android.library.deviceData", 0).getBoolean(f2638a, false);
    }

    public static void c(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.android.library.deviceData", 0).edit();
        editorEdit.putBoolean(f2638a, true);
        editorEdit.commit();
    }

    public static long d(Context context) {
        return context.getSharedPreferences("com.android.library.deviceData", 0).getLong(f2639b, System.currentTimeMillis());
    }

    public static String e(Context context) {
        return Config.getInstance(context).get("httpLib.postBaseUrl");
    }

    public static com.android.library.deviceData.b.a f(Context context) {
        com.android.library.deviceData.b.a aVar = new com.android.library.deviceData.b.a();
        com.android.library.deviceData.b.b bVar = new com.android.library.deviceData.b.b();
        bVar.c(a.g());
        bVar.a(System.currentTimeMillis());
        bVar.g(a.a());
        bVar.f(a.b());
        bVar.e(a.c());
        bVar.d(a.d());
        bVar.a(d.a(context));
        bVar.c(a.d(context));
        bVar.d(a.c(context));
        bVar.b(i(context));
        bVar.b(a.a(context));
        bVar.a(a.b(context));
        bVar.a(a.f());
        bVar.b(a.e());
        bVar.c(a.g(context));
        bVar.h(d.f(context));
        bVar.i(d.g(context));
        bVar.k(a.j());
        bVar.a(Boolean.valueOf(a.h(context)));
        bVar.a(a.i(context));
        bVar.j(a.i());
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        aVar.a(arrayList);
        aVar.e("");
        aVar.c(Config.getInstance(context).get(com.android.library.deviceData.a.C0047a.f2601a) + com.android.library.deviceData.a.C0047a.f2602b);
        aVar.a("device");
        aVar.b("specifications");
        aVar.d("1.3.0");
        return aVar;
    }

    public static String g(Context context) {
        return new f().a(f(context), com.android.library.deviceData.b.a.class);
    }

    public static long h(Context context) {
        return d(context) + (((long) a(context)) * 86400000);
    }

    public static String i(Context context) {
        String string = context.getSharedPreferences("com.android.library.deviceData", 0).getString(f2640c, "");
        if (string.isEmpty()) {
            a(context, (com.android.library.deviceData.c) null);
        }
        return string;
    }

    public static boolean j(Context context) {
        return m(context.getApplicationContext()).equalsIgnoreCase("OFF");
    }

    public static boolean k(Context context) {
        return m(context.getApplicationContext()).equalsIgnoreCase("NOW");
    }

    public static boolean l(Context context) {
        return m(context.getApplicationContext()).equalsIgnoreCase("BATCH");
    }

    private static String m(Context context) {
        return Config.getInstance(context.getApplicationContext()).get("deviceSpecLib.mode");
    }
}
