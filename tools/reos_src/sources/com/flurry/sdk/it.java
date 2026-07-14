package com.flurry.sdk;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class it implements lb<ht> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4378a = it.class.getSimpleName();

    private iq a(String str) {
        iq iqVar = iq.GET;
        try {
            return !TextUtils.isEmpty(str) ? (iq) Enum.valueOf(iq.class, str) : iqVar;
        } catch (Exception e2) {
            return iqVar;
        }
    }

    private void a(hq hqVar, JSONArray jSONArray) {
        String[] strArr;
        if (jSONArray != null) {
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    if (jSONObjectOptJSONObject.has("string")) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        hw hwVar = new hw();
                        hwVar.f4251a = jSONObjectOptJSONObject.optString("string", "");
                        arrayList.add(hwVar);
                    } else if (jSONObjectOptJSONObject.has("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger")) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger");
                        if (jSONObjectOptJSONObject2 != null) {
                            hx hxVar = new hx();
                            hxVar.f4251a = jSONObjectOptJSONObject2.optString("event_name", "");
                            hxVar.f4253c = jSONObjectOptJSONObject2.optString("event_parameter_name", "");
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("event_parameter_values");
                            if (jSONArrayOptJSONArray != null) {
                                String[] strArr2 = new String[jSONArrayOptJSONArray.length()];
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                    strArr2[i2] = jSONArrayOptJSONArray.optString(i2, "");
                                }
                                strArr = strArr2;
                            } else {
                                strArr = new String[0];
                            }
                            hxVar.f4254d = strArr;
                            arrayList.add(hxVar);
                        }
                    }
                }
            }
            hqVar.f4227c = arrayList;
        }
    }

    private void a(hr hrVar, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    hq hqVar = new hq();
                    hqVar.f4226b = jSONObjectOptJSONObject2.optString("partner", "");
                    a(hqVar, jSONObjectOptJSONObject2.optJSONArray("events"));
                    hqVar.f4228d = a(jSONObjectOptJSONObject2.optString("method"));
                    hqVar.f4229e = jSONObjectOptJSONObject2.optString("uri_template", "");
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("body_template");
                    if (jSONObjectOptJSONObject3 != null) {
                        String strOptString = jSONObjectOptJSONObject3.optString("string", "null");
                        if (!strOptString.equals("null")) {
                            hqVar.f4230f = strOptString;
                        }
                    }
                    hqVar.g = jSONObjectOptJSONObject2.optInt("max_redirects", 5);
                    hqVar.h = jSONObjectOptJSONObject2.optInt("connect_timeout", 20);
                    hqVar.i = jSONObjectOptJSONObject2.optInt("request_timeout", 20);
                    hqVar.f4225a = jSONObjectOptJSONObject2.optLong("callback_id", -1L);
                    JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("headers");
                    if (jSONObjectOptJSONObject4 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("map")) != null) {
                        hqVar.j = lv.a(jSONObjectOptJSONObject);
                    }
                    arrayList.add(hqVar);
                }
            }
            hrVar.f4231a = arrayList;
        }
    }

    private void a(ht htVar, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("global_settings");
        htVar.f4245d = new ia();
        if (jSONObjectOptJSONObject != null) {
            htVar.f4245d.f4259a = b(jSONObjectOptJSONObject.optString("log_level"));
        }
    }

    private ib b(String str) {
        ib ibVar = ib.OFF;
        try {
            return !TextUtils.isEmpty(str) ? (ib) Enum.valueOf(ib.class, str) : ibVar;
        } catch (Exception e2) {
            return ibVar;
        }
    }

    private void b(ht htVar, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pulse");
        hr hrVar = new hr();
        if (jSONObjectOptJSONObject != null) {
            a(hrVar, jSONObjectOptJSONObject.optJSONArray("callbacks"));
            hrVar.f4232b = jSONObjectOptJSONObject.optInt("max_callback_retries", 3);
            hrVar.f4233c = jSONObjectOptJSONObject.optInt("max_callback_attempts_per_report", 15);
            hrVar.f4234d = jSONObjectOptJSONObject.optInt("max_report_delay_seconds", 600);
            hrVar.f4235e = jSONObjectOptJSONObject.optString("agent_report_url", "");
        }
        htVar.f4246e = hrVar;
    }

    private void c(ht htVar, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("analytics");
        htVar.f4247f = new id();
        if (jSONObjectOptJSONObject != null) {
            htVar.f4247f.f4268b = jSONObjectOptJSONObject.optBoolean("analytics_enabled", true);
            htVar.f4247f.f4267a = jSONObjectOptJSONObject.optInt("max_session_properties", 10);
        }
    }

    @Override // com.flurry.sdk.lb
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ht b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        String str = new String(lt.a(inputStream));
        kg.a(5, f4378a, "Proton response string: " + str);
        ht htVar = new ht();
        try {
            JSONObject jSONObject = new JSONObject(str);
            htVar.f4242a = jSONObject.optLong("issued_at", -1L);
            htVar.f4243b = jSONObject.optLong("refresh_ttl", 3600L);
            htVar.f4244c = jSONObject.optLong("expiration_ttl", 86400L);
            a(htVar, jSONObject);
            b(htVar, jSONObject);
            c(htVar, jSONObject);
            return htVar;
        } catch (JSONException e2) {
            throw new IOException("Exception while deserialize: ", e2);
        }
    }

    @Override // com.flurry.sdk.lb
    public void a(OutputStream outputStream, ht htVar) throws IOException {
        throw new IOException("Serialize not supported for response");
    }
}
