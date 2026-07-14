package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.auth.api.credentials.IdentityProviders;

/* JADX INFO: loaded from: classes.dex */
public enum zze {
    GOOGLE("google.com", R.string.auth_google_play_services_client_google_display_name, IdentityProviders.GOOGLE),
    FACEBOOK("facebook.com", R.string.auth_google_play_services_client_facebook_display_name, IdentityProviders.FACEBOOK);

    private final String zzUB;
    private final String zzVL;
    private final int zzVM;

    zze(String str, int i, String str2) {
        this.zzVL = str;
        this.zzVM = i;
        this.zzUB = str2;
    }

    public static zze zzbI(String str) {
        if (str != null) {
            for (zze zzeVar : values()) {
                if (zzeVar.zzmC().equals(str)) {
                    return zzeVar;
                }
            }
            Log.w("IdProvider", "Unrecognized providerId: " + str);
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.zzVL;
    }

    public CharSequence zzad(Context context) {
        return context.getResources().getString(this.zzVM);
    }

    public String zzmC() {
        return this.zzVL;
    }
}
