package com.google.android.gms.common.data;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzahO;
    private ArrayList<Integer> zzahP;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
        this.zzahO = false;
    }

    private void zzpP() {
        synchronized (this) {
            if (!this.zzahO) {
                int count = this.zzafC.getCount();
                this.zzahP = new ArrayList<>();
                if (count > 0) {
                    this.zzahP.add(0);
                    String strZzpO = zzpO();
                    String strZzd = this.zzafC.zzd(strZzpO, 0, this.zzafC.zzbI(0));
                    int i = 1;
                    while (i < count) {
                        int iZzbI = this.zzafC.zzbI(i);
                        String strZzd2 = this.zzafC.zzd(strZzpO, i, iZzbI);
                        if (strZzd2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + strZzpO + ", at row: " + i + ", for window: " + iZzbI);
                        }
                        if (strZzd2.equals(strZzd)) {
                            strZzd2 = strZzd;
                        } else {
                            this.zzahP.add(Integer.valueOf(i));
                        }
                        i++;
                        strZzd = strZzd2;
                    }
                }
                this.zzahO = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final T get(int i) {
        zzpP();
        return zzk(zzbL(i), zzbM(i));
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        zzpP();
        return this.zzahP.size();
    }

    int zzbL(int i) {
        if (i < 0 || i >= this.zzahP.size()) {
            throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
        }
        return this.zzahP.get(i).intValue();
    }

    protected int zzbM(int i) {
        if (i < 0 || i == this.zzahP.size()) {
            return 0;
        }
        int count = i == this.zzahP.size() + (-1) ? this.zzafC.getCount() - this.zzahP.get(i).intValue() : this.zzahP.get(i + 1).intValue() - this.zzahP.get(i).intValue();
        if (count != 1) {
            return count;
        }
        int iZzbL = zzbL(i);
        int iZzbI = this.zzafC.zzbI(iZzbL);
        String strZzpQ = zzpQ();
        if (strZzpQ == null || this.zzafC.zzd(strZzpQ, iZzbL, iZzbI) != null) {
            return count;
        }
        return 0;
    }

    protected abstract T zzk(int i, int i2);

    protected abstract String zzpO();

    protected String zzpQ() {
        return null;
    }
}
