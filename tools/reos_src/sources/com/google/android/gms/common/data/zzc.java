package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzc {
    protected final DataHolder zzafC;
    protected int zzahw;
    private int zzahx;

    public zzc(DataHolder dataHolder, int i) {
        this.zzafC = (DataHolder) zzx.zzy(dataHolder);
        zzbG(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        return zzw.equal(Integer.valueOf(zzcVar.zzahw), Integer.valueOf(this.zzahw)) && zzw.equal(Integer.valueOf(zzcVar.zzahx), Integer.valueOf(this.zzahx)) && zzcVar.zzafC == this.zzafC;
    }

    protected boolean getBoolean(String str) {
        return this.zzafC.zze(str, this.zzahw, this.zzahx);
    }

    protected byte[] getByteArray(String str) {
        return this.zzafC.zzg(str, this.zzahw, this.zzahx);
    }

    protected float getFloat(String str) {
        return this.zzafC.zzf(str, this.zzahw, this.zzahx);
    }

    protected int getInteger(String str) {
        return this.zzafC.zzc(str, this.zzahw, this.zzahx);
    }

    protected long getLong(String str) {
        return this.zzafC.zzb(str, this.zzahw, this.zzahx);
    }

    protected String getString(String str) {
        return this.zzafC.zzd(str, this.zzahw, this.zzahx);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzahw), Integer.valueOf(this.zzahx), this.zzafC);
    }

    public boolean isDataValid() {
        return !this.zzafC.isClosed();
    }

    protected void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.zzafC.zza(str, this.zzahw, this.zzahx, charArrayBuffer);
    }

    protected void zzbG(int i) {
        zzx.zzaa(i >= 0 && i < this.zzafC.getCount());
        this.zzahw = i;
        this.zzahx = this.zzafC.zzbI(this.zzahw);
    }

    public boolean zzct(String str) {
        return this.zzafC.zzct(str);
    }

    protected Uri zzcu(String str) {
        return this.zzafC.zzh(str, this.zzahw, this.zzahx);
    }

    protected boolean zzcv(String str) {
        return this.zzafC.zzi(str, this.zzahw, this.zzahx);
    }

    protected int zzpK() {
        return this.zzahw;
    }
}
