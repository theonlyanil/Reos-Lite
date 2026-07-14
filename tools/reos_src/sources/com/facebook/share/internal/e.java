package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    public interface a {
        JSONObject a(SharePhoto sharePhoto);
    }

    public static Object a(Object obj, a aVar) throws JSONException {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj;
        }
        if (obj instanceof SharePhoto) {
            if (aVar != null) {
                return aVar.a((SharePhoto) obj);
            }
            return null;
        }
        if (obj instanceof ShareOpenGraphObject) {
            return a((ShareOpenGraphObject) obj, aVar);
        }
        if (obj instanceof List) {
            return a((List) obj, aVar);
        }
        throw new IllegalArgumentException("Invalid object found for JSON serialization: " + obj.toString());
    }

    private static JSONArray a(List list, a aVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(a(it.next(), aVar));
        }
        return jSONArray;
    }

    public static JSONObject a(ShareOpenGraphAction shareOpenGraphAction, a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphAction.c()) {
            jSONObject.put(str, a(shareOpenGraphAction.a(str), aVar));
        }
        return jSONObject;
    }

    private static JSONObject a(ShareOpenGraphObject shareOpenGraphObject, a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphObject.c()) {
            jSONObject.put(str, a(shareOpenGraphObject.a(str), aVar));
        }
        return jSONObject;
    }
}
