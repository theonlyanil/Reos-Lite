package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class zzn {
    private static final Lock zzWv = new ReentrantLock();
    private static zzn zzWw;
    private final Lock zzWx = new ReentrantLock();
    private final SharedPreferences zzWy;

    zzn(Context context) {
        this.zzWy = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzn zzae(Context context) {
        zzx.zzy(context);
        zzWv.lock();
        try {
            if (zzWw == null) {
                zzWw = new zzn(context.getApplicationContext());
            }
            return zzWw;
        } finally {
            zzWv.unlock();
        }
    }

    private String zzt(String str, String str2) {
        return str + ":" + str2;
    }

    void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzy(googleSignInAccount);
        zzx.zzy(googleSignInOptions);
        String strZzmw = googleSignInAccount.zzmw();
        zzs(zzt("googleSignInAccount", strZzmw), googleSignInAccount.zzmx());
        zzs(zzt("googleSignInOptions", strZzmw), googleSignInOptions.zzmr());
    }

    void zza(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzy(signInAccount);
        zzx.zzy(signInConfiguration);
        String userId = signInAccount.getUserId();
        SignInAccount signInAccountZzbK = zzbK(userId);
        if (signInAccountZzbK != null && signInAccountZzbK.zzmD() != null) {
            zzbP(signInAccountZzbK.zzmD().zzmw());
        }
        zzs(zzt("signInConfiguration", userId), signInConfiguration.zzmr());
        zzs(zzt("signInAccount", userId), signInAccount.zzmr());
        if (signInAccount.zzmD() != null) {
            zza(signInAccount.zzmD(), signInConfiguration.zzmR());
        }
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzy(googleSignInAccount);
        zzx.zzy(googleSignInOptions);
        zzs("defaultGoogleSignInAccount", googleSignInAccount.zzmw());
        zza(googleSignInAccount, googleSignInOptions);
    }

    public void zzb(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzy(signInAccount);
        zzx.zzy(signInConfiguration);
        zzmY();
        zzs("defaultSignInAccount", signInAccount.getUserId());
        if (signInAccount.zzmD() != null) {
            zzs("defaultGoogleSignInAccount", signInAccount.zzmD().zzmw());
        }
        zza(signInAccount, signInConfiguration);
    }

    SignInAccount zzbK(String str) {
        GoogleSignInAccount googleSignInAccountZzbL;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strZzbN = zzbN(zzt("signInAccount", str));
        if (TextUtils.isEmpty(strZzbN)) {
            return null;
        }
        try {
            SignInAccount signInAccountZzbJ = SignInAccount.zzbJ(strZzbN);
            if (signInAccountZzbJ.zzmD() != null && (googleSignInAccountZzbL = zzbL(signInAccountZzbJ.zzmD().zzmw())) != null) {
                signInAccountZzbJ.zza(googleSignInAccountZzbL);
            }
            return signInAccountZzbJ;
        } catch (JSONException e2) {
            return null;
        }
    }

    GoogleSignInAccount zzbL(String str) {
        String strZzbN;
        if (TextUtils.isEmpty(str) || (strZzbN = zzbN(zzt("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zzbE(strZzbN);
        } catch (JSONException e2) {
            return null;
        }
    }

    GoogleSignInOptions zzbM(String str) {
        String strZzbN;
        if (TextUtils.isEmpty(str) || (strZzbN = zzbN(zzt("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zzbG(strZzbN);
        } catch (JSONException e2) {
            return null;
        }
    }

    protected String zzbN(String str) {
        this.zzWx.lock();
        try {
            return this.zzWy.getString(str, null);
        } finally {
            this.zzWx.unlock();
        }
    }

    void zzbO(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SignInAccount signInAccountZzbK = zzbK(str);
        zzbQ(zzt("signInAccount", str));
        zzbQ(zzt("signInConfiguration", str));
        if (signInAccountZzbK == null || signInAccountZzbK.zzmD() == null) {
            return;
        }
        zzbP(signInAccountZzbK.zzmD().zzmw());
    }

    void zzbP(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzbQ(zzt("googleSignInAccount", str));
        zzbQ(zzt("googleSignInOptions", str));
    }

    protected void zzbQ(String str) {
        this.zzWx.lock();
        try {
            this.zzWy.edit().remove(str).apply();
        } finally {
            this.zzWx.unlock();
        }
    }

    public GoogleSignInAccount zzmW() {
        return zzbL(zzbN("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zzmX() {
        return zzbM(zzbN("defaultGoogleSignInAccount"));
    }

    public void zzmY() {
        String strZzbN = zzbN("defaultSignInAccount");
        zzbQ("defaultSignInAccount");
        zzmZ();
        zzbO(strZzbN);
    }

    public void zzmZ() {
        String strZzbN = zzbN("defaultGoogleSignInAccount");
        zzbQ("defaultGoogleSignInAccount");
        zzbP(strZzbN);
    }

    protected void zzs(String str, String str2) {
        this.zzWx.lock();
        try {
            this.zzWy.edit().putString(str, str2).apply();
        } finally {
            this.zzWx.unlock();
        }
    }
}
