package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.b.b;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class zzd {
    Context context;
    SharedPreferences zzaKG;

    public zzd(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public zzd(Context context, String str) {
        this.context = context;
        this.zzaKG = context.getSharedPreferences(str, 4);
        zzdL(str + "-no-backup");
    }

    private void zzdL(String str) {
        File file = new File(new b().a(this.context), str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || isEmpty()) {
                return;
            }
            Log.i("InstanceID/Store", "App restored, clearing state");
            InstanceIDListenerService.zza(this.context, this);
        } catch (IOException e2) {
            if (Log.isLoggable("InstanceID/Store", 3)) {
                Log.d("InstanceID/Store", "Error creating file in no backup dir: " + e2.getMessage());
            }
        }
    }

    private String zzf(String str, String str2, String str3) {
        return str + "|T|" + str2 + "|" + str3;
    }

    synchronized String get(String str) {
        return this.zzaKG.getString(str, null);
    }

    synchronized String get(String str, String str2) {
        return this.zzaKG.getString(str + "|S|" + str2, null);
    }

    boolean isEmpty() {
        return this.zzaKG.getAll().isEmpty();
    }

    synchronized void zza(SharedPreferences.Editor editor, String str, String str2, String str3) {
        editor.putString(str + "|S|" + str2, str3);
    }

    public synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String strZzf = zzf(str, str2, str3);
        SharedPreferences.Editor editorEdit = this.zzaKG.edit();
        editorEdit.putString(strZzf, str4);
        editorEdit.putString("appVersion", str5);
        editorEdit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        editorEdit.commit();
    }

    synchronized KeyPair zzd(String str, long j) {
        KeyPair keyPairZzxM;
        keyPairZzxM = zza.zzxM();
        SharedPreferences.Editor editorEdit = this.zzaKG.edit();
        zza(editorEdit, str, "|P|", InstanceID.zzn(keyPairZzxM.getPublic().getEncoded()));
        zza(editorEdit, str, "|K|", InstanceID.zzn(keyPairZzxM.getPrivate().getEncoded()));
        zza(editorEdit, str, "cre", Long.toString(j));
        editorEdit.commit();
        return keyPairZzxM;
    }

    public synchronized void zzdM(String str) {
        SharedPreferences.Editor editorEdit = this.zzaKG.edit();
        for (String str2 : this.zzaKG.getAll().keySet()) {
            if (str2.startsWith(str)) {
                editorEdit.remove(str2);
            }
        }
        editorEdit.commit();
    }

    public KeyPair zzdN(String str) {
        return zzdQ(str);
    }

    void zzdO(String str) {
        zzdM(str + "|");
    }

    public void zzdP(String str) {
        zzdM(str + "|T|");
    }

    KeyPair zzdQ(String str) {
        String str2 = get(str, "|P|");
        String str3 = get(str, "|K|");
        if (str3 == null) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str2, 8);
            byte[] bArrDecode2 = Base64.decode(str3, 8);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(bArrDecode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArrDecode2)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            Log.w("InstanceID/Store", "Invalid key stored " + e2);
            InstanceIDListenerService.zza(this.context, this);
            return null;
        }
    }

    public synchronized String zzg(String str, String str2, String str3) {
        return this.zzaKG.getString(zzf(str, str2, str3), null);
    }

    public synchronized void zzh(String str, String str2, String str3) {
        String strZzf = zzf(str, str2, str3);
        SharedPreferences.Editor editorEdit = this.zzaKG.edit();
        editorEdit.remove(strZzf);
        editorEdit.commit();
    }

    public synchronized void zzxU() {
        this.zzaKG.edit().clear().commit();
    }
}
