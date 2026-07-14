package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zztm {
    final int tag;
    final byte[] zzbqc;

    zztm(int i, byte[] bArr) {
        this.tag = i;
        this.zzbqc = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zztm)) {
            return false;
        }
        zztm zztmVar = (zztm) obj;
        return this.tag == zztmVar.tag && Arrays.equals(this.zzbqc, zztmVar.zzbqc);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzbqc);
    }

    void writeTo(zztd zztdVar) throws IOException {
        zztdVar.zzmy(this.tag);
        zztdVar.zzG(this.zzbqc);
    }

    int zzz() {
        return 0 + zztd.zzmz(this.tag) + this.zzbqc.length;
    }
}
