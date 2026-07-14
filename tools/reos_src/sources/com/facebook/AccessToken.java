package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.b.ad;
import com.facebook.b.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class AccessToken implements Parcelable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Date f3486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<String> f3487f;
    private final Set<String> g;
    private final String h;
    private final c i;
    private final Date j;
    private final String k;
    private final String l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Date f3482a = new Date(Long.MAX_VALUE);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Date f3483b = f3482a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Date f3484c = new Date();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final c f3485d = c.FACEBOOK_APPLICATION_WEB;
    public static final Parcelable.Creator<AccessToken> CREATOR = new Parcelable.Creator() { // from class: com.facebook.AccessToken.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccessToken createFromParcel(Parcel parcel) {
            return new AccessToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccessToken[] newArray(int i) {
            return new AccessToken[i];
        }
    };

    public interface a {
        void a(AccessToken accessToken);

        void a(k kVar);
    }

    AccessToken(Parcel parcel) {
        this.f3486e = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f3487f = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.g = Collections.unmodifiableSet(new HashSet(arrayList));
        this.h = parcel.readString();
        this.i = c.valueOf(parcel.readString());
        this.j = new Date(parcel.readLong());
        this.k = parcel.readString();
        this.l = parcel.readString();
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, c cVar, Date date, Date date2) {
        ae.a(str, "accessToken");
        ae.a(str2, "applicationId");
        ae.a(str3, "userId");
        this.f3486e = date == null ? f3483b : date;
        this.f3487f = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.g = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.h = str;
        this.i = cVar == null ? f3485d : cVar;
        this.j = date2 == null ? f3484c : date2;
        this.k = str2;
        this.l = str3;
    }

    public static AccessToken a() {
        return b.a().b();
    }

    static AccessToken a(Bundle bundle) {
        List<String> listA = a(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        List<String> listA2 = a(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        String strD = t.d(bundle);
        if (ad.a(strD)) {
            strD = m.i();
        }
        String strB = t.b(bundle);
        try {
            return new AccessToken(strB, strD, ad.e(strB).getString("id"), listA, listA2, t.c(bundle), t.a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), t.a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
        } catch (JSONException e2) {
            return null;
        }
    }

    static AccessToken a(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt("version") > 1) {
            throw new k("Unknown AccessToken serialization format.");
        }
        String string = jSONObject.getString("token");
        Date date = new Date(jSONObject.getLong("expires_at"));
        JSONArray jSONArray = jSONObject.getJSONArray("permissions");
        JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
        Date date2 = new Date(jSONObject.getLong("last_refresh"));
        return new AccessToken(string, jSONObject.getString("application_id"), jSONObject.getString("user_id"), ad.a(jSONArray), ad.a(jSONArray2), c.valueOf(jSONObject.getString("source")), date, date2);
    }

    static List<String> a(Bundle bundle, String str) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        return stringArrayList == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    public static void a(AccessToken accessToken) {
        b.a().a(accessToken);
    }

    private void a(StringBuilder sb) {
        sb.append(" permissions:");
        if (this.f3487f == null) {
            sb.append("null");
            return;
        }
        sb.append("[");
        sb.append(TextUtils.join(", ", this.f3487f));
        sb.append("]");
    }

    private String k() {
        if (this.h == null) {
            return "null";
        }
        return m.a(u.INCLUDE_ACCESS_TOKENS) ? this.h : "ACCESS_TOKEN_REMOVED";
    }

    public String b() {
        return this.h;
    }

    public Date c() {
        return this.f3486e;
    }

    public Set<String> d() {
        return this.f3487f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Set<String> e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        return this.f3486e.equals(accessToken.f3486e) && this.f3487f.equals(accessToken.f3487f) && this.g.equals(accessToken.g) && this.h.equals(accessToken.h) && this.i == accessToken.i && this.j.equals(accessToken.j) && (this.k != null ? this.k.equals(accessToken.k) : accessToken.k == null) && this.l.equals(accessToken.l);
    }

    public c f() {
        return this.i;
    }

    public Date g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    public int hashCode() {
        return (((this.k == null ? 0 : this.k.hashCode()) + ((((((((((((this.f3486e.hashCode() + 527) * 31) + this.f3487f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31)) * 31) + this.l.hashCode();
    }

    public String i() {
        return this.l;
    }

    JSONObject j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.h);
        jSONObject.put("expires_at", this.f3486e.getTime());
        jSONObject.put("permissions", new JSONArray((Collection) this.f3487f));
        jSONObject.put("declined_permissions", new JSONArray((Collection) this.g));
        jSONObject.put("last_refresh", this.j.getTime());
        jSONObject.put("source", this.i.name());
        jSONObject.put("application_id", this.k);
        jSONObject.put("user_id", this.l);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:").append(k());
        a(sb);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f3486e.getTime());
        parcel.writeStringList(new ArrayList(this.f3487f));
        parcel.writeStringList(new ArrayList(this.g));
        parcel.writeString(this.h);
        parcel.writeString(this.i.name());
        parcel.writeLong(this.j.getTime());
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }
}
