package com.google.android.gms.location.places.internal;

import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzta;
import com.google.android.gms.internal.zztj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzu extends com.google.android.gms.common.data.zzc {
    private final String TAG;

    public zzu(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.TAG = "SafeDataBufferRef";
    }

    protected String zzI(String str, String str2) {
        return (!zzct(str) || zzcv(str)) ? str2 : getString(str);
    }

    protected <E extends SafeParcelable> E zza(String str, Parcelable.Creator<E> creator) {
        byte[] bArrZzc = zzc(str, null);
        if (bArrZzc == null) {
            return null;
        }
        return (E) com.google.android.gms.common.internal.safeparcel.zzc.zza(bArrZzc, creator);
    }

    protected <E extends SafeParcelable> List<E> zza(String str, Parcelable.Creator<E> creator, List<E> list) {
        byte[] bArrZzc = zzc(str, null);
        if (bArrZzc == null) {
            return list;
        }
        try {
            zzta zztaVarZzA = zzta.zzA(bArrZzc);
            if (zztaVarZzA.zzbpC == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zztaVarZzA.zzbpC.length);
            byte[][] bArr = zztaVarZzA.zzbpC;
            for (byte[] bArr2 : bArr) {
                arrayList.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(bArr2, creator));
            }
            return arrayList;
        } catch (zztj e2) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e2);
            return list;
        }
    }

    protected List<Integer> zza(String str, List<Integer> list) {
        byte[] bArrZzc = zzc(str, null);
        if (bArrZzc == null) {
            return list;
        }
        try {
            zzta zztaVarZzA = zzta.zzA(bArrZzc);
            if (zztaVarZzA.zzbpB == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zztaVarZzA.zzbpB.length);
            for (int i = 0; i < zztaVarZzA.zzbpB.length; i++) {
                arrayList.add(Integer.valueOf(zztaVarZzA.zzbpB[i]));
            }
            return arrayList;
        } catch (zztj e2) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e2);
            return list;
        }
    }

    protected float zzb(String str, float f2) {
        return (!zzct(str) || zzcv(str)) ? f2 : getFloat(str);
    }

    protected List<String> zzb(String str, List<String> list) {
        byte[] bArrZzc = zzc(str, null);
        if (bArrZzc == null) {
            return list;
        }
        try {
            zzta zztaVarZzA = zzta.zzA(bArrZzc);
            return zztaVarZzA.zzbpA != null ? Arrays.asList(zztaVarZzA.zzbpA) : list;
        } catch (zztj e2) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e2);
            return list;
        }
    }

    protected byte[] zzc(String str, byte[] bArr) {
        return (!zzct(str) || zzcv(str)) ? bArr : getByteArray(str);
    }

    protected boolean zzh(String str, boolean z) {
        return (!zzct(str) || zzcv(str)) ? z : getBoolean(str);
    }

    protected int zzz(String str, int i) {
        return (!zzct(str) || zzcv(str)) ? i : getInteger(str);
    }
}
