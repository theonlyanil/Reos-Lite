package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zzh implements Api.ApiOptions.HasOptions {
    private final SignInConfiguration zzVQ;

    public static class zza {
        private final SignInConfiguration zzVQ;

        public zza(String str) {
            zzx.zzcG(str);
            this.zzVQ = new SignInConfiguration(str);
        }

        public zza zzh(GoogleSignInOptions googleSignInOptions) {
            zzx.zzy(googleSignInOptions);
            this.zzVQ.zzi(googleSignInOptions);
            return this;
        }

        public zzh zzmG() {
            zzx.zza((this.zzVQ.zzmQ() == null && this.zzVQ.zzmS() == null && this.zzVQ.zzmR() == null) ? false : true, "Must support either Facebook, Google or Email sign-in.");
            return new zzh(this.zzVQ);
        }
    }

    private zzh(SignInConfiguration signInConfiguration) {
        this.zzVQ = signInConfiguration;
    }

    public SignInConfiguration zzmF() {
        return this.zzVQ;
    }
}
