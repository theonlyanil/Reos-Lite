package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class WebImage implements SafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zzb();
    private final int mVersionCode;
    private final Uri zzair;
    private final int zzov;
    private final int zzow;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.zzair = uri;
        this.zzov = i2;
        this.zzow = i3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(zzi(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri zzi(JSONObject jSONObject) {
        if (!jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            return null;
        }
        try {
            return Uri.parse(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
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
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzw.equal(this.zzair, webImage.zzair) && this.zzov == webImage.zzov && this.zzow == webImage.zzow;
    }

    public int getHeight() {
        return this.zzow;
    }

    public Uri getUrl() {
        return this.zzair;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zzov;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzair, Integer.valueOf(this.zzov), Integer.valueOf(this.zzow));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, this.zzair.toString());
            jSONObject.put("width", this.zzov);
            jSONObject.put("height", this.zzow);
        } catch (JSONException e2) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", Integer.valueOf(this.zzov), Integer.valueOf(this.zzow), this.zzair.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
