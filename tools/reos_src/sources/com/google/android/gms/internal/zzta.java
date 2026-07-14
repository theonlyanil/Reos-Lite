package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzta extends zzte<zzta> {
    public String[] zzbpA;
    public int[] zzbpB;
    public byte[][] zzbpC;

    public zzta() {
        zzHh();
    }

    public static zzta zzA(byte[] bArr) throws zztj {
        return (zzta) zztk.mergeFrom(new zzta(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzta)) {
            return false;
        }
        zzta zztaVar = (zzta) obj;
        if (!zzti.equals(this.zzbpA, zztaVar.zzbpA) || !zzti.equals(this.zzbpB, zztaVar.zzbpB) || !zzti.zza(this.zzbpC, zztaVar.zzbpC)) {
            return false;
        }
        if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
            return zztaVar.zzbpQ == null || zztaVar.zzbpQ.isEmpty();
        }
        return this.zzbpQ.equals(zztaVar.zzbpQ);
    }

    public int hashCode() {
        return ((this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzbpA)) * 31) + zzti.hashCode(this.zzbpB)) * 31) + zzti.zza(this.zzbpC)) * 31);
    }

    @Override // com.google.android.gms.internal.zzte, com.google.android.gms.internal.zztk
    public void writeTo(zztd zztdVar) throws IOException {
        if (this.zzbpA != null && this.zzbpA.length > 0) {
            for (int i = 0; i < this.zzbpA.length; i++) {
                String str = this.zzbpA[i];
                if (str != null) {
                    zztdVar.zzb(1, str);
                }
            }
        }
        if (this.zzbpB != null && this.zzbpB.length > 0) {
            for (int i2 = 0; i2 < this.zzbpB.length; i2++) {
                zztdVar.zzG(2, this.zzbpB[i2]);
            }
        }
        if (this.zzbpC != null && this.zzbpC.length > 0) {
            for (int i3 = 0; i3 < this.zzbpC.length; i3++) {
                byte[] bArr = this.zzbpC[i3];
                if (bArr != null) {
                    zztdVar.zza(3, bArr);
                }
            }
        }
        super.writeTo(zztdVar);
    }

    @Override // com.google.android.gms.internal.zztk
    /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
    public zzta mergeFrom(zztc zztcVar) throws IOException {
        while (true) {
            int iZzHi = zztcVar.zzHi();
            switch (iZzHi) {
                case 0:
                    break;
                case 10:
                    int iZzc = zztn.zzc(zztcVar, 10);
                    int length = this.zzbpA == null ? 0 : this.zzbpA.length;
                    String[] strArr = new String[iZzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzbpA, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zztcVar.readString();
                        zztcVar.zzHi();
                        length++;
                    }
                    strArr[length] = zztcVar.readString();
                    this.zzbpA = strArr;
                    break;
                case 16:
                    int iZzc2 = zztn.zzc(zztcVar, 16);
                    int length2 = this.zzbpB == null ? 0 : this.zzbpB.length;
                    int[] iArr = new int[iZzc2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbpB, 0, iArr, 0, length2);
                    }
                    while (length2 < iArr.length - 1) {
                        iArr[length2] = zztcVar.zzHl();
                        zztcVar.zzHi();
                        length2++;
                    }
                    iArr[length2] = zztcVar.zzHl();
                    this.zzbpB = iArr;
                    break;
                case 18:
                    int iZzmn = zztcVar.zzmn(zztcVar.zzHp());
                    int position = zztcVar.getPosition();
                    int i = 0;
                    while (zztcVar.zzHu() > 0) {
                        zztcVar.zzHl();
                        i++;
                    }
                    zztcVar.zzmp(position);
                    int length3 = this.zzbpB == null ? 0 : this.zzbpB.length;
                    int[] iArr2 = new int[i + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzbpB, 0, iArr2, 0, length3);
                    }
                    while (length3 < iArr2.length) {
                        iArr2[length3] = zztcVar.zzHl();
                        length3++;
                    }
                    this.zzbpB = iArr2;
                    zztcVar.zzmo(iZzmn);
                    break;
                case 26:
                    int iZzc3 = zztn.zzc(zztcVar, 26);
                    int length4 = this.zzbpC == null ? 0 : this.zzbpC.length;
                    byte[][] bArr = new byte[iZzc3 + length4][];
                    if (length4 != 0) {
                        System.arraycopy(this.zzbpC, 0, bArr, 0, length4);
                    }
                    while (length4 < bArr.length - 1) {
                        bArr[length4] = zztcVar.readBytes();
                        zztcVar.zzHi();
                        length4++;
                    }
                    bArr[length4] = zztcVar.readBytes();
                    this.zzbpC = bArr;
                    break;
                default:
                    if (!zza(zztcVar, iZzHi)) {
                    }
                    break;
            }
        }
        return this;
    }

    public zzta zzHh() {
        this.zzbpA = zztn.zzbqg;
        this.zzbpB = zztn.zzboD;
        this.zzbpC = zztn.zzbqh;
        this.zzbpQ = null;
        this.zzbqb = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzte, com.google.android.gms.internal.zztk
    protected int zzz() {
        int length;
        int iZzz = super.zzz();
        if (this.zzbpA == null || this.zzbpA.length <= 0) {
            length = iZzz;
        } else {
            int iZzga = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.zzbpA.length; i2++) {
                String str = this.zzbpA[i2];
                if (str != null) {
                    i++;
                    iZzga += zztd.zzga(str);
                }
            }
            length = iZzz + iZzga + (i * 1);
        }
        if (this.zzbpB != null && this.zzbpB.length > 0) {
            int iZzmu = 0;
            for (int i3 = 0; i3 < this.zzbpB.length; i3++) {
                iZzmu += zztd.zzmu(this.zzbpB[i3]);
            }
            length = length + iZzmu + (this.zzbpB.length * 1);
        }
        if (this.zzbpC == null || this.zzbpC.length <= 0) {
            return length;
        }
        int iZzF = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzbpC.length; i5++) {
            byte[] bArr = this.zzbpC[i5];
            if (bArr != null) {
                i4++;
                iZzF += zztd.zzF(bArr);
            }
        }
        return length + iZzF + (i4 * 1);
    }
}
