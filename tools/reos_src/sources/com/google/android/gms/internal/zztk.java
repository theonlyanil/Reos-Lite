package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class zztk {
    protected volatile int zzbqb = -1;

    public static final <T extends zztk> T mergeFrom(T t, byte[] bArr) throws zztj {
        return (T) mergeFrom(t, bArr, 0, bArr.length);
    }

    public static final <T extends zztk> T mergeFrom(T t, byte[] bArr, int i, int i2) throws zztj {
        try {
            zztc zztcVarZza = zztc.zza(bArr, i, i2);
            t.mergeFrom(zztcVarZza);
            zztcVarZza.zzmk(0);
            return t;
        } catch (zztj e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean messageNanoEquals(zztk zztkVar, zztk zztkVar2) {
        int serializedSize;
        if (zztkVar == zztkVar2) {
            return true;
        }
        if (zztkVar == null || zztkVar2 == null || zztkVar.getClass() != zztkVar2.getClass() || zztkVar2.getSerializedSize() != (serializedSize = zztkVar.getSerializedSize())) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(zztkVar, bArr, 0, serializedSize);
        toByteArray(zztkVar2, bArr2, 0, serializedSize);
        return Arrays.equals(bArr, bArr2);
    }

    public static final void toByteArray(zztk zztkVar, byte[] bArr, int i, int i2) {
        try {
            zztd zztdVarZzb = zztd.zzb(bArr, i, i2);
            zztkVar.writeTo(zztdVarZzb);
            zztdVarZzb.zzHy();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final byte[] toByteArray(zztk zztkVar) {
        byte[] bArr = new byte[zztkVar.getSerializedSize()];
        toByteArray(zztkVar, bArr, 0, bArr.length);
        return bArr;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public zztk mo0clone() throws CloneNotSupportedException {
        return (zztk) super.clone();
    }

    public int getCachedSize() {
        if (this.zzbqb < 0) {
            getSerializedSize();
        }
        return this.zzbqb;
    }

    public int getSerializedSize() {
        int iZzz = zzz();
        this.zzbqb = iZzz;
        return iZzz;
    }

    public abstract zztk mergeFrom(zztc zztcVar) throws IOException;

    public String toString() {
        return zztl.zzf(this);
    }

    public void writeTo(zztd zztdVar) throws IOException {
    }

    protected int zzz() {
        return 0;
    }
}
