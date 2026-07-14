package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialRequest implements SafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzc();
    final int mVersionCode;
    private final boolean zzUG;
    private final String[] zzUH;
    private final CredentialPickerConfig zzUI;
    private final CredentialPickerConfig zzUJ;

    public static final class Builder {
        private boolean zzUG;
        private String[] zzUH;
        private CredentialPickerConfig zzUI;
        private CredentialPickerConfig zzUJ;

        public CredentialRequest build() {
            if (this.zzUH == null) {
                this.zzUH = new String[0];
            }
            if (this.zzUG || this.zzUH.length != 0) {
                return new CredentialRequest(this);
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

        public Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzUJ = credentialPickerConfig;
            return this;
        }

        public Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzUI = credentialPickerConfig;
            return this;
        }

        public Builder setPasswordLoginSupported(boolean z) {
            this.zzUG = z;
            return this;
        }

        @Deprecated
        public Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.mVersionCode = i;
        this.zzUG = z;
        this.zzUH = (String[]) zzx.zzy(strArr);
        this.zzUI = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.zzUJ = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
    }

    private CredentialRequest(Builder builder) {
        this(2, builder.zzUG, builder.zzUH, builder.zzUI, builder.zzUJ);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] getAccountTypes() {
        return this.zzUH;
    }

    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzUJ;
    }

    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzUI;
    }

    @Deprecated
    public boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public boolean isPasswordLoginSupported() {
        return this.zzUG;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
