package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialPickerConfig implements SafeParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();
    private final boolean mShowCancelButton;
    final int mVersionCode;
    private final boolean zzUE;
    private final boolean zzUF;

    public static class Builder {
        private boolean zzUE = false;
        private boolean mShowCancelButton = true;
        private boolean zzUF = false;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        public Builder setForNewAccount(boolean z) {
            this.zzUF = z;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzUE = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.zzUE = z;
        this.mShowCancelButton = z2;
        this.zzUF = z3;
    }

    private CredentialPickerConfig(Builder builder) {
        this(1, builder.zzUE, builder.mShowCancelButton, builder.zzUF);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isForNewAccount() {
        return this.zzUF;
    }

    public boolean shouldShowAddAccountButton() {
        return this.zzUE;
    }

    public boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
