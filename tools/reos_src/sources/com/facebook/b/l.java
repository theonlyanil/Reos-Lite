package com.facebook.b;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    private static l g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f3743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f3744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f3745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f3747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3748f;

    l(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.f3743a = map;
        this.f3744b = map2;
        this.f3745c = map3;
        this.f3746d = str;
        this.f3747e = str2;
        this.f3748f = str3;
    }

    public static synchronized l a() {
        if (g == null) {
            g = b();
        }
        return g;
    }

    public static l a(JSONArray jSONArray) {
        String strOptString;
        if (jSONArray == null) {
            return null;
        }
        String strOptString2 = null;
        String strOptString3 = null;
        String strOptString4 = null;
        Map<Integer, Set<Integer>> mapA = null;
        Map<Integer, Set<Integer>> mapA2 = null;
        Map<Integer, Set<Integer>> mapA3 = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("name")) != null) {
                if (strOptString.equalsIgnoreCase("other")) {
                    strOptString4 = jSONObjectOptJSONObject.optString("recovery_message", null);
                    mapA3 = a(jSONObjectOptJSONObject);
                } else if (strOptString.equalsIgnoreCase("transient")) {
                    strOptString3 = jSONObjectOptJSONObject.optString("recovery_message", null);
                    mapA2 = a(jSONObjectOptJSONObject);
                } else if (strOptString.equalsIgnoreCase("login_recoverable")) {
                    strOptString2 = jSONObjectOptJSONObject.optString("recovery_message", null);
                    mapA = a(jSONObjectOptJSONObject);
                }
            }
        }
        return new l(mapA3, mapA2, mapA, strOptString4, strOptString3, strOptString2);
    }

    private static Map<Integer, Set<Integer>> a(JSONObject jSONObject) {
        int iOptInt;
        HashSet hashSet;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
        if (jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (iOptInt = jSONObjectOptJSONObject.optInt("code")) != 0) {
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("subcodes");
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                    hashSet = null;
                } else {
                    HashSet hashSet2 = new HashSet();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        int iOptInt2 = jSONArrayOptJSONArray2.optInt(i2);
                        if (iOptInt2 != 0) {
                            hashSet2.add(Integer.valueOf(iOptInt2));
                        }
                    }
                    hashSet = hashSet2;
                }
                map.put(Integer.valueOf(iOptInt), hashSet);
            }
        }
        return map;
    }

    private static l b() {
        return new l(null, new HashMap<Integer, Set<Integer>>() { // from class: com.facebook.b.l.1
            {
                put(2, null);
                put(4, null);
                put(9, null);
                put(17, null);
                put(341, null);
            }
        }, new HashMap<Integer, Set<Integer>>() { // from class: com.facebook.b.l.2
            {
                put(102, null);
                put(190, null);
            }
        }, null, null, null);
    }

    public FacebookRequestError.a a(int i, int i2, boolean z) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        if (z) {
            return FacebookRequestError.a.TRANSIENT;
        }
        if (this.f3743a != null && this.f3743a.containsKey(Integer.valueOf(i)) && ((set3 = this.f3743a.get(Integer.valueOf(i))) == null || set3.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.a.OTHER;
        }
        if (this.f3745c != null && this.f3745c.containsKey(Integer.valueOf(i)) && ((set2 = this.f3745c.get(Integer.valueOf(i))) == null || set2.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.a.LOGIN_RECOVERABLE;
        }
        return (this.f3744b != null && this.f3744b.containsKey(Integer.valueOf(i)) && ((set = this.f3744b.get(Integer.valueOf(i))) == null || set.contains(Integer.valueOf(i2)))) ? FacebookRequestError.a.TRANSIENT : FacebookRequestError.a.OTHER;
    }

    public String a(FacebookRequestError.a aVar) {
        switch (aVar) {
            case OTHER:
                return this.f3746d;
            case LOGIN_RECOVERABLE:
                return this.f3748f;
            case TRANSIENT:
                return this.f3747e;
            default:
                return null;
        }
    }
}
