package com.facebook;

import com.android.library.userprofile.util.Constants;
import com.facebook.b.ad;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f4032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f4033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONArray f4034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FacebookRequestError f4035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final GraphRequest f4037f;

    r(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    r(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    r(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    r(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.f4037f = graphRequest;
        this.f4032a = httpURLConnection;
        this.f4036e = str;
        this.f4033b = jSONObject;
        this.f4034c = jSONArray;
        this.f4035d = facebookRequestError;
    }

    private static r a(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError facebookRequestErrorA = FacebookRequestError.a(jSONObject, obj2, httpURLConnection);
            if (facebookRequestErrorA != null) {
                if (facebookRequestErrorA.b() == 190 && ad.a(graphRequest.f())) {
                    AccessToken.a((AccessToken) null);
                }
                return new r(graphRequest, httpURLConnection, facebookRequestErrorA);
            }
            Object objA = ad.a(jSONObject, Constants.SMS_COLUMN_BODY, "FACEBOOK_NON_JSON_RESULT");
            if (objA instanceof JSONObject) {
                return new r(graphRequest, httpURLConnection, objA.toString(), (JSONObject) objA);
            }
            if (objA instanceof JSONArray) {
                return new r(graphRequest, httpURLConnection, objA.toString(), (JSONArray) objA);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new r(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
        }
        throw new k("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    static List<r> a(InputStream inputStream, HttpURLConnection httpURLConnection, q qVar) throws Throwable {
        String strA = ad.a(inputStream);
        com.facebook.b.v.a(u.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(strA.length()), strA);
        return a(strA, httpURLConnection, qVar);
    }

    static List<r> a(String str, HttpURLConnection httpURLConnection, q qVar) throws JSONException, k, IOException {
        List<r> listA = a(httpURLConnection, qVar, new JSONTokener(str).nextValue());
        com.facebook.b.v.a(u.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", qVar.b(), Integer.valueOf(str.length()), listA);
        return listA;
    }

    static List<r> a(HttpURLConnection httpURLConnection, q qVar) {
        List<r> listA;
        InputStream errorStream = null;
        try {
            errorStream = httpURLConnection.getResponseCode() >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            listA = a(errorStream, httpURLConnection, qVar);
        } catch (k e2) {
            com.facebook.b.v.a(u.REQUESTS, "Response", "Response <Error>: %s", e2);
            listA = a(qVar, httpURLConnection, e2);
        } catch (Exception e3) {
            com.facebook.b.v.a(u.REQUESTS, "Response", "Response <Error>: %s", e3);
            listA = a(qVar, httpURLConnection, new k(e3));
        } finally {
            ad.a((Closeable) errorStream);
        }
        return listA;
    }

    private static List<r> a(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object obj) throws JSONException, k {
        Object obj2;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (size == 1) {
            GraphRequest graphRequest = list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.SMS_COLUMN_BODY, obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                obj2 = jSONArray;
            } catch (IOException e2) {
                arrayList.add(new r(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e2)));
                obj2 = obj;
            } catch (JSONException e3) {
                arrayList.add(new r(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e3)));
                obj2 = obj;
            }
        } else {
            obj2 = obj;
        }
        if (!(obj2 instanceof JSONArray) || ((JSONArray) obj2).length() != size) {
            throw new k("Unexpected number of results");
        }
        JSONArray jSONArray2 = (JSONArray) obj2;
        for (int i = 0; i < jSONArray2.length(); i++) {
            GraphRequest graphRequest2 = list.get(i);
            try {
                arrayList.add(a(graphRequest2, httpURLConnection, jSONArray2.get(i), obj));
            } catch (k e4) {
                arrayList.add(new r(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e4)));
            } catch (JSONException e5) {
                arrayList.add(new r(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e5)));
            }
        }
        return arrayList;
    }

    static List<r> a(List<GraphRequest> list, HttpURLConnection httpURLConnection, k kVar) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new r(list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, kVar)));
        }
        return arrayList;
    }

    public final FacebookRequestError a() {
        return this.f4035d;
    }

    public final JSONObject b() {
        return this.f4033b;
    }

    public String toString() {
        String str;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.f4032a != null ? this.f4032a.getResponseCode() : 200);
            str = String.format(locale, "%d", objArr);
        } catch (IOException e2) {
            str = "unknown";
        }
        return "{Response:  responseCode: " + str + ", graphObject: " + this.f4033b + ", error: " + this.f4035d + "}";
    }
}
