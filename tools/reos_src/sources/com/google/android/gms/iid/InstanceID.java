package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.android.library.userprofile.util.Constants;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InstanceID {
    public static final String ERROR_BACKOFF = "RETRY_LATER";
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    static Map<String, InstanceID> zzaKc = new HashMap();
    private static zzd zzaKd;
    private static zzc zzaKe;
    static String zzaKi;
    Context mContext;
    KeyPair zzaKf;
    String zzaKg;
    long zzaKh;

    protected InstanceID(Context context, String str, Bundle bundle) {
        this.zzaKg = "";
        this.mContext = context.getApplicationContext();
        this.zzaKg = str;
    }

    public static InstanceID getInstance(Context context) {
        return zza(context, null);
    }

    public static synchronized InstanceID zza(Context context, Bundle bundle) {
        InstanceID instanceID;
        String string = bundle == null ? "" : bundle.getString("subtype");
        String str = string == null ? "" : string;
        Context applicationContext = context.getApplicationContext();
        if (zzaKd == null) {
            zzaKd = new zzd(applicationContext);
            zzaKe = new zzc(applicationContext);
        }
        zzaKi = Integer.toString(zzaK(applicationContext));
        instanceID = zzaKc.get(str);
        if (instanceID == null) {
            instanceID = new InstanceID(applicationContext, str, bundle);
            zzaKc.put(str, instanceID);
        }
        return instanceID;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e2) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static int zzaK(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("InstanceID", "Never happens: can't find own package " + e2);
            return 0;
        }
    }

    static String zzn(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceID() throws IOException {
        zzb("*", "*", null);
        zzxO();
    }

    public void deleteToken(String str, String str2) throws IOException {
        zzb(str, str2, null);
    }

    public long getCreationTime() {
        String str;
        if (this.zzaKh == 0 && (str = zzaKd.get(this.zzaKg, "cre")) != null) {
            this.zzaKh = Long.parseLong(str);
        }
        return this.zzaKh;
    }

    public String getId() {
        return zza(zzxN());
    }

    public String getToken(String str, String str2) throws IOException {
        return getToken(str, str2, null);
    }

    public String getToken(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String strZzg = zzxR() ? null : zzaKd.zzg(this.zzaKg, str, str2);
        if (strZzg == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            boolean z = "jwt".equals(bundle.getString(Constants.SMS_COLUMN_TYPE)) ? false : bundle.getString("ttl") == null;
            strZzg = zzc(str, str2, bundle);
            Log.w("InstanceID", "token: " + strZzg);
            if (strZzg != null && z) {
                zzaKd.zza(this.zzaKg, str, str2, strZzg, zzaKi);
            }
        }
        return strZzg;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzaKd.zzh(this.zzaKg, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.zzaKg) ? str : this.zzaKg);
        if (!"".equals(this.zzaKg)) {
            str = this.zzaKg;
        }
        bundle.putString("X-subtype", str);
        zzaKe.zzv(zzaKe.zza(bundle, zzxN()));
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzaKg) ? str : this.zzaKg;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return zzaKe.zzv(zzaKe.zza(bundle, zzxN()));
    }

    KeyPair zzxN() {
        if (this.zzaKf == null) {
            this.zzaKf = zzaKd.zzdN(this.zzaKg);
        }
        if (this.zzaKf == null) {
            this.zzaKh = System.currentTimeMillis();
            this.zzaKf = zzaKd.zzd(this.zzaKg, this.zzaKh);
        }
        return this.zzaKf;
    }

    void zzxO() {
        this.zzaKh = 0L;
        zzaKd.zzdO(this.zzaKg);
        this.zzaKf = null;
    }

    zzd zzxP() {
        return zzaKd;
    }

    zzc zzxQ() {
        return zzaKe;
    }

    boolean zzxR() {
        String str;
        String str2 = zzaKd.get("appVersion");
        if (str2 == null || !str2.equals(zzaKi) || (str = zzaKd.get("lastToken")) == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }
}
