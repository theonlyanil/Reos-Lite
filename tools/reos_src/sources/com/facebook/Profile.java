package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.b.ad;
import com.facebook.b.ae;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator() { // from class: com.facebook.Profile.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Profile[] newArray(int i) {
            return new Profile[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f3540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f3541f;

    private Profile(Parcel parcel) {
        this.f3536a = parcel.readString();
        this.f3537b = parcel.readString();
        this.f3538c = parcel.readString();
        this.f3539d = parcel.readString();
        this.f3540e = parcel.readString();
        String string = parcel.readString();
        this.f3541f = string == null ? null : Uri.parse(string);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        ae.a(str, "id");
        this.f3536a = str;
        this.f3537b = str2;
        this.f3538c = str3;
        this.f3539d = str4;
        this.f3540e = str5;
        this.f3541f = uri;
    }

    Profile(JSONObject jSONObject) {
        this.f3536a = jSONObject.optString("id", null);
        this.f3537b = jSONObject.optString("first_name", null);
        this.f3538c = jSONObject.optString("middle_name", null);
        this.f3539d = jSONObject.optString("last_name", null);
        this.f3540e = jSONObject.optString("name", null);
        String strOptString = jSONObject.optString("link_uri", null);
        this.f3541f = strOptString != null ? Uri.parse(strOptString) : null;
    }

    public static Profile a() {
        return w.a().b();
    }

    public static void a(Profile profile) {
        w.a().a(profile);
    }

    public static void b() {
        AccessToken accessTokenA = AccessToken.a();
        if (accessTokenA == null) {
            a(null);
        } else {
            ad.a(accessTokenA.b(), new ad.c() { // from class: com.facebook.Profile.1
                @Override // com.facebook.b.ad.c
                public void a(k kVar) {
                }

                @Override // com.facebook.b.ad.c
                public void a(JSONObject jSONObject) {
                    String strOptString = jSONObject.optString("id");
                    if (strOptString == null) {
                        return;
                    }
                    String strOptString2 = jSONObject.optString("link");
                    Profile.a(new Profile(strOptString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), strOptString2 != null ? Uri.parse(strOptString2) : null));
                }
            });
        }
    }

    public String c() {
        return this.f3540e;
    }

    JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f3536a);
            jSONObject.put("first_name", this.f3537b);
            jSONObject.put("middle_name", this.f3538c);
            jSONObject.put("last_name", this.f3539d);
            jSONObject.put("name", this.f3540e);
            if (this.f3541f == null) {
                return jSONObject;
            }
            jSONObject.put("link_uri", this.f3541f.toString());
            return jSONObject;
        } catch (JSONException e2) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        if (this.f3536a.equals(profile.f3536a) && this.f3537b == null) {
            return profile.f3537b == null;
        }
        if (this.f3537b.equals(profile.f3537b) && this.f3538c == null) {
            return profile.f3538c == null;
        }
        if (this.f3538c.equals(profile.f3538c) && this.f3539d == null) {
            return profile.f3539d == null;
        }
        if (this.f3539d.equals(profile.f3539d) && this.f3540e == null) {
            return profile.f3540e == null;
        }
        if (this.f3540e.equals(profile.f3540e) && this.f3541f == null) {
            return profile.f3541f == null;
        }
        return this.f3541f.equals(profile.f3541f);
    }

    public int hashCode() {
        int iHashCode = this.f3536a.hashCode() + 527;
        if (this.f3537b != null) {
            iHashCode = (iHashCode * 31) + this.f3537b.hashCode();
        }
        if (this.f3538c != null) {
            iHashCode = (iHashCode * 31) + this.f3538c.hashCode();
        }
        if (this.f3539d != null) {
            iHashCode = (iHashCode * 31) + this.f3539d.hashCode();
        }
        if (this.f3540e != null) {
            iHashCode = (iHashCode * 31) + this.f3540e.hashCode();
        }
        return this.f3541f != null ? (iHashCode * 31) + this.f3541f.hashCode() : iHashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3536a);
        parcel.writeString(this.f3537b);
        parcel.writeString(this.f3538c);
        parcel.writeString(this.f3539d);
        parcel.writeString(this.f3540e);
        parcel.writeString(this.f3541f == null ? null : this.f3541f.toString());
    }
}
