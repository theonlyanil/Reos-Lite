package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzri;

/* JADX INFO: loaded from: classes.dex */
public final class zzo {
    public static final int zzaku = 23 - " PII_LOG".length();
    private static final String zzakv = null;
    private final String zzakw;
    private final String zzakx;

    public zzo(String str) {
        this(str, zzakv);
    }

    public zzo(String str, String str2) {
        zzx.zzb(str, "log tag cannot be null");
        zzx.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zzakw = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzakx = zzakv;
        } else {
            this.zzakx = str2;
        }
    }

    private String zzcE(String str) {
        return this.zzakx == null ? str : this.zzakx.concat(str);
    }

    public void zzA(String str, String str2) {
        if (zzbW(5)) {
            Log.w(str, zzcE(str2));
        }
    }

    public void zzB(String str, String str2) {
        if (zzbW(6)) {
            Log.e(str, zzcE(str2));
        }
    }

    public void zza(Context context, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackTrace.length && i < 2; i++) {
            sb.append(stackTrace[i].toString());
            sb.append("\n");
        }
        zzri zzriVar = new zzri(context, 10);
        zzriVar.zza("GMS_WTF", null, "GMS_WTF", sb.toString());
        zzriVar.send();
        if (zzbW(7)) {
            Log.e(str, zzcE(str2), th);
            Log.wtf(str, zzcE(str2), th);
        }
    }

    public void zza(String str, String str2, Throwable th) {
        if (zzbW(4)) {
            Log.i(str, zzcE(str2), th);
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzbW(5)) {
            Log.w(str, zzcE(str2), th);
        }
    }

    public boolean zzbW(int i) {
        return Log.isLoggable(this.zzakw, i);
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzbW(6)) {
            Log.e(str, zzcE(str2), th);
        }
    }

    public void zzz(String str, String str2) {
        if (zzbW(3)) {
            Log.d(str, zzcE(str2));
        }
    }
}
