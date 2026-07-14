package com.android.library.http.d;

import android.content.Context;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.google.a.o;
import com.google.a.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static o a(JSONObject jSONObject) {
        return (o) new q().a(jSONObject.toString());
    }

    public static JSONArray a(Context context, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray("values".toString());
            for (int i = 0; i < jSONArray2.length(); i++) {
                String strEncryptConfig = Config.getInstance(context).encryptConfig(f.b(context), jSONArray2.getJSONObject(i).toString());
                CLog.b("HTTPLibrary", "Encrypted String : " + strEncryptConfig);
                CLog.b("HTTPLibrary", "De-Encrypted String : " + Config.getInstance(context).decryptConfig(f.b(context), strEncryptConfig));
                jSONArray.put(strEncryptConfig);
                CLog.b("HTTPLibrary", "Encrypted JSONArray (Values) in " + i + " st iteration " + jSONArray.toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONArray;
    }

    public static JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject a(String str, String str2, String str3, String str4, String str5, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", str);
            jSONObject.put("subCategory", str2);
            jSONObject.put("identifier", str3);
            jSONObject.put("version", str4);
            jSONObject.put("actionId", str5);
            jSONObject.put("values", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, Context context) {
        try {
            jSONObject.put("sendTime", System.currentTimeMillis());
            jSONObject.put("IMEI1", f.a(context));
            jSONObject.put("andId", f.b(context));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("values", a(context, jSONObject));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
