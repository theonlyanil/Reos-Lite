package com.facebook.a;

import android.os.Bundle;
import com.facebook.b.ad;
import com.facebook.b.v;
import com.facebook.u;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f3555a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f3556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f3557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f3559e;

    static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3561b;

        /* JADX WARN: Multi-variable type inference failed */
        private Object readResolve() throws JSONException {
            return new b(this.f3560a, this.f3561b, null);
        }
    }

    /* JADX INFO: renamed from: com.facebook.a.b$b, reason: collision with other inner class name */
    static class C0069b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f3564c;

        private C0069b(String str, boolean z, String str2) {
            this.f3562a = str;
            this.f3563b = z;
            this.f3564c = str2;
        }

        private Object readResolve() throws JSONException {
            return new b(this.f3562a, this.f3563b, this.f3564c);
        }
    }

    public b(String str, String str2, Double d2, Bundle bundle, boolean z, UUID uuid) throws JSONException, com.facebook.k {
        this.f3556b = a(str, str2, d2, bundle, z, uuid);
        this.f3557c = z;
        this.f3558d = str2;
        this.f3559e = e();
    }

    private b(String str, boolean z, String str2) throws JSONException {
        this.f3556b = new JSONObject(str);
        this.f3557c = z;
        this.f3558d = this.f3556b.optString("_eventName");
        this.f3559e = str2;
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return stringBuffer.toString();
    }

    private static JSONObject a(String str, String str2, Double d2, Bundle bundle, boolean z, UUID uuid) throws JSONException, com.facebook.k {
        a(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_eventName", str2);
        jSONObject.put("_logTime", System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (d2 != null) {
            jSONObject.put("_valueToSum", d2.doubleValue());
        }
        if (z) {
            jSONObject.put("_implicitlyLogged", "1");
        }
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                a(str3);
                Object obj = bundle.get(str3);
                if (!(obj instanceof String) && !(obj instanceof Number)) {
                    throw new com.facebook.k(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, str3));
                }
                jSONObject.put(str3, obj.toString());
            }
        }
        if (!z) {
            v.a(u.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        return jSONObject;
    }

    private static void a(String str) throws com.facebook.k {
        boolean zContains;
        if (str == null || str.length() == 0 || str.length() > 40) {
            if (str == null) {
                str = "<None Provided>";
            }
            throw new com.facebook.k(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", str, 40));
        }
        synchronized (f3555a) {
            zContains = f3555a.contains(str);
        }
        if (zContains) {
            return;
        }
        if (!str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
            throw new com.facebook.k(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", str));
        }
        synchronized (f3555a) {
            f3555a.add(str);
        }
    }

    private static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return a(messageDigest.digest());
        } catch (UnsupportedEncodingException e2) {
            ad.a("Failed to generate checksum: ", (Exception) e2);
            return "1";
        } catch (NoSuchAlgorithmException e3) {
            ad.a("Failed to generate checksum: ", (Exception) e3);
            return "0";
        }
    }

    private String e() {
        return b(this.f3556b.toString());
    }

    private Object writeReplace() {
        return new C0069b(this.f3556b.toString(), this.f3557c, this.f3559e);
    }

    public String a() {
        return this.f3558d;
    }

    public boolean b() {
        return this.f3557c;
    }

    public JSONObject c() {
        return this.f3556b;
    }

    public boolean d() {
        if (this.f3559e == null) {
            return true;
        }
        return e().equals(this.f3559e);
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", this.f3556b.optString("_eventName"), Boolean.valueOf(this.f3557c), this.f3556b.toString());
    }
}
