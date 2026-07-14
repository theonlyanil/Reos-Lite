package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProxyRequest implements SafeParcelable {
    public static final int VERSION_CODE = 2;
    public final byte[] body;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    final int versionCode;
    Bundle zzVe;
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zzb();
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int LAST_CODE = 7;

    public static class Builder {
        private String zzVf;
        private int zzVg = ProxyRequest.HTTP_METHOD_GET;
        private long zzVh = 3000;
        private byte[] zzVi = null;
        private Bundle zzVj = new Bundle();

        public Builder(String str) {
            zzx.zzcG(str);
            if (!Patterns.WEB_URL.matcher(str).matches()) {
                throw new IllegalArgumentException("The supplied url [ " + str + "] is not match Patterns.WEB_URL!");
            }
            this.zzVf = str;
        }

        public ProxyRequest build() {
            if (this.zzVi == null) {
                this.zzVi = new byte[0];
            }
            return new ProxyRequest(2, this.zzVf, this.zzVg, this.zzVh, this.zzVi, this.zzVj);
        }

        public Builder putHeader(String str, String str2) {
            zzx.zzh(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zzVj;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.zzVi = bArr;
            return this;
        }

        public Builder setHttpMethod(int i) {
            zzx.zzb(i >= 0 && i <= ProxyRequest.LAST_CODE, "Unrecognized http method code.");
            this.zzVg = i;
            return this;
        }

        public Builder setTimeoutMillis(long j) {
            zzx.zzb(j >= 0, "The specified timeout must be non-negative.");
            this.zzVh = j;
            return this;
        }
    }

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzVe = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzVe.size());
        for (String str : this.zzVe.keySet()) {
            linkedHashMap.put(str, this.zzVe.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.url + ", method: " + this.httpMethod + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
