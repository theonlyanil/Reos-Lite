package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class HintRequest implements SafeParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzd();
    final int mVersionCode;
    private final String[] zzUH;
    private final CredentialPickerConfig zzUK;
    private final boolean zzUL;
    private final boolean zzUM;

    public static final class Builder {
        private String[] zzUH;
        private CredentialPickerConfig zzUK = new CredentialPickerConfig.Builder().build();
        private boolean zzUL;
        private boolean zzUM;

        public HintRequest build() {
            if (this.zzUH == null) {
                this.zzUH = new String[0];
            }
            if (this.zzUL || this.zzUM || this.zzUH.length != 0) {
                return new HintRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzUH = strArr;
            return this;
        }

        public Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzUL = z;
            return this;
        }

        public Builder setHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzUK = (CredentialPickerConfig) zzx.zzy(credentialPickerConfig);
            return this;
        }
    }

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr) {
        this.mVersionCode = i;
        this.zzUK = (CredentialPickerConfig) zzx.zzy(credentialPickerConfig);
        this.zzUL = z;
        this.zzUM = z2;
        this.zzUH = (String[]) zzx.zzy(strArr);
    }

    private HintRequest(Builder builder) {
        this(1, builder.zzUK, builder.zzUL, builder.zzUM, builder.zzUH);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] getAccountTypes() {
        return this.zzUH;
    }

    public CredentialPickerConfig getHintPickerConfig() {
        return this.zzUK;
    }

    public boolean isEmailAddressIdentifierSupported() {
        return this.zzUL;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public boolean zzmh() {
        return this.zzUM;
    }
}
