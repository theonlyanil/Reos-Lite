package com.facebook.b;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, a> f3724a = new HashMap();

    public interface a {
        void a(Bundle bundle, String str, Object obj) throws JSONException;
    }

    static {
        f3724a.put(Boolean.class, new a() { // from class: com.facebook.b.e.1
            @Override // com.facebook.b.e.a
            public void a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }
        });
        f3724a.put(Integer.class, new a() { // from class: com.facebook.b.e.2
            @Override // com.facebook.b.e.a
            public void a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putInt(str, ((Integer) obj).intValue());
            }
        });
        f3724a.put(Long.class, new a() { // from class: com.facebook.b.e.3
            @Override // com.facebook.b.e.a
            public void a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putLong(str, ((Long) obj).longValue());
            }
        });
        f3724a.put(Double.class, new a() { // from class: com.facebook.b.e.4
            @Override // com.facebook.b.e.a
            public void a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }
        });
        f3724a.put(String.class, new a() { // from class: com.facebook.b.e.5
            @Override // com.facebook.b.e.a
            public void a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putString(str, (String) obj);
            }
        });
        f3724a.put(String[].class, new a() { // from class: com.facebook.b.e.6
            @Override // com.facebook.b.e.a
            public void a(Bundle bundle, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }
        });
        f3724a.put(JSONArray.class, new a() { // from class: com.facebook.b.e.7
            @Override // com.facebook.b.e.a
            public void a(Bundle bundle, String str, Object obj) throws JSONException {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList<String> arrayList = new ArrayList<>();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        bundle.putStringArrayList(str, arrayList);
                        return;
                    }
                    Object obj2 = jSONArray.get(i2);
                    if (!(obj2 instanceof String)) {
                        throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                    }
                    arrayList.add((String) obj2);
                    i = i2 + 1;
                }
            }
        });
    }

    public static Bundle a(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj != null && obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, a((JSONObject) obj));
                } else {
                    a aVar = f3724a.get(obj.getClass());
                    if (aVar == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    aVar.a(bundle, next, obj);
                }
            }
        }
        return bundle;
    }
}
