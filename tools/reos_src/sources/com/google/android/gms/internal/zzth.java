package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class zzth implements Cloneable {
    private zztf<?, ?> zzbpX;
    private Object zzbpY;
    private List<zztm> zzbpZ = new ArrayList();

    zzth() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzz()];
        writeTo(zztd.zzD(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzth)) {
            return false;
        }
        zzth zzthVar = (zzth) obj;
        if (this.zzbpY == null || zzthVar.zzbpY == null) {
            if (this.zzbpZ != null && zzthVar.zzbpZ != null) {
                return this.zzbpZ.equals(zzthVar.zzbpZ);
            }
            try {
                return Arrays.equals(toByteArray(), zzthVar.toByteArray());
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }
        if (this.zzbpX != zzthVar.zzbpX) {
            return false;
        }
        if (!this.zzbpX.zzbpR.isArray()) {
            return this.zzbpY.equals(zzthVar.zzbpY);
        }
        if (this.zzbpY instanceof byte[]) {
            return Arrays.equals((byte[]) this.zzbpY, (byte[]) zzthVar.zzbpY);
        }
        if (this.zzbpY instanceof int[]) {
            return Arrays.equals((int[]) this.zzbpY, (int[]) zzthVar.zzbpY);
        }
        if (this.zzbpY instanceof long[]) {
            return Arrays.equals((long[]) this.zzbpY, (long[]) zzthVar.zzbpY);
        }
        if (this.zzbpY instanceof float[]) {
            return Arrays.equals((float[]) this.zzbpY, (float[]) zzthVar.zzbpY);
        }
        if (this.zzbpY instanceof double[]) {
            return Arrays.equals((double[]) this.zzbpY, (double[]) zzthVar.zzbpY);
        }
        return this.zzbpY instanceof boolean[] ? Arrays.equals((boolean[]) this.zzbpY, (boolean[]) zzthVar.zzbpY) : Arrays.deepEquals((Object[]) this.zzbpY, (Object[]) zzthVar.zzbpY);
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    void writeTo(zztd zztdVar) throws IOException {
        if (this.zzbpY != null) {
            this.zzbpX.zza(this.zzbpY, zztdVar);
            return;
        }
        Iterator<zztm> it = this.zzbpZ.iterator();
        while (it.hasNext()) {
            it.next().writeTo(zztdVar);
        }
    }

    /* JADX INFO: renamed from: zzHB, reason: merged with bridge method [inline-methods] */
    public final zzth clone() {
        zzth zzthVar = new zzth();
        try {
            zzthVar.zzbpX = this.zzbpX;
            if (this.zzbpZ == null) {
                zzthVar.zzbpZ = null;
            } else {
                zzthVar.zzbpZ.addAll(this.zzbpZ);
            }
            if (this.zzbpY != null) {
                if (this.zzbpY instanceof zztk) {
                    zzthVar.zzbpY = ((zztk) this.zzbpY).mo0clone();
                } else if (this.zzbpY instanceof byte[]) {
                    zzthVar.zzbpY = ((byte[]) this.zzbpY).clone();
                } else if (this.zzbpY instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzbpY;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzthVar.zzbpY = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.zzbpY instanceof boolean[]) {
                    zzthVar.zzbpY = ((boolean[]) this.zzbpY).clone();
                } else if (this.zzbpY instanceof int[]) {
                    zzthVar.zzbpY = ((int[]) this.zzbpY).clone();
                } else if (this.zzbpY instanceof long[]) {
                    zzthVar.zzbpY = ((long[]) this.zzbpY).clone();
                } else if (this.zzbpY instanceof float[]) {
                    zzthVar.zzbpY = ((float[]) this.zzbpY).clone();
                } else if (this.zzbpY instanceof double[]) {
                    zzthVar.zzbpY = ((double[]) this.zzbpY).clone();
                } else if (this.zzbpY instanceof zztk[]) {
                    zztk[] zztkVarArr = (zztk[]) this.zzbpY;
                    zztk[] zztkVarArr2 = new zztk[zztkVarArr.length];
                    zzthVar.zzbpY = zztkVarArr2;
                    for (int i2 = 0; i2 < zztkVarArr.length; i2++) {
                        zztkVarArr2[i2] = zztkVarArr[i2].mo0clone();
                    }
                }
            }
            return zzthVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    void zza(zztm zztmVar) {
        this.zzbpZ.add(zztmVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T zzb(zztf<?, T> zztfVar) {
        if (this.zzbpY == null) {
            this.zzbpX = zztfVar;
            this.zzbpY = zztfVar.zzG(this.zzbpZ);
            this.zzbpZ = null;
        } else if (this.zzbpX != zztfVar) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return (T) this.zzbpY;
    }

    int zzz() {
        int iZzz = 0;
        if (this.zzbpY != null) {
            return this.zzbpX.zzY(this.zzbpY);
        }
        Iterator<zztm> it = this.zzbpZ.iterator();
        while (true) {
            int i = iZzz;
            if (!it.hasNext()) {
                return i;
            }
            iZzz = it.next().zzz() + i;
        }
    }
}
