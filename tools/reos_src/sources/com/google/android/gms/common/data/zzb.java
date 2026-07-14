package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> zzaht;
    protected int zzahu = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.zzaht = (DataBuffer) zzx.zzy(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.zzahu < this.zzaht.getCount() + (-1);
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzahu);
        }
        DataBuffer<T> dataBuffer = this.zzaht;
        int i = this.zzahu + 1;
        this.zzahu = i;
        return dataBuffer.get(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
