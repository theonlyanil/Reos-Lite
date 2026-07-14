package com.facebook.b;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, JSONObject> f3647a = new ConcurrentHashMap<>();

    public static JSONObject a(String str) {
        return f3647a.get(str);
    }

    public static void a(String str, JSONObject jSONObject) {
        f3647a.put(str, jSONObject);
    }
}
