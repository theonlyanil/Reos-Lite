package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class zzg<T> extends zzb<T> {
    private T zzahQ;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.zzb, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzahu);
        }
        this.zzahu++;
        if (this.zzahu == 0) {
            this.zzahQ = this.zzaht.get(0);
            if (!(this.zzahQ instanceof zzc)) {
                throw new IllegalStateException("DataBuffer reference of type " + this.zzahQ.getClass() + " is not movable");
            }
        } else {
            ((zzc) this.zzahQ).zzbG(this.zzahu);
        }
        return this.zzahQ;
    }
}
