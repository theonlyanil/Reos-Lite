package com.google.android.gms.internal;

import com.google.android.gms.internal.zzte;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zztf<M extends zzte<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbpR;
    protected final boolean zzbpS;

    private zztf(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzbpR = cls;
        this.tag = i2;
        this.zzbpS = z;
    }

    private T zzH(List<zztm> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zztm zztmVar = list.get(i);
            if (zztmVar.zzbqc.length != 0) {
                zza(zztmVar, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T tCast = this.zzbpR.cast(Array.newInstance(this.zzbpR.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(tCast, i2, arrayList.get(i2));
        }
        return tCast;
    }

    private T zzI(List<zztm> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbpR.cast(zzE(zztc.zzC(list.get(list.size() - 1).zzbqc)));
    }

    public static <M extends zzte<M>, T extends zztk> zztf<M, T> zza(int i, Class<T> cls, long j) {
        return new zztf<>(i, cls, (int) j, false);
    }

    protected Object zzE(zztc zztcVar) {
        Class componentType = this.zzbpS ? this.zzbpR.getComponentType() : this.zzbpR;
        try {
            switch (this.type) {
                case 10:
                    zztk zztkVar = (zztk) componentType.newInstance();
                    zztcVar.zza(zztkVar, zztn.zzmG(this.tag));
                    return zztkVar;
                case 11:
                    zztk zztkVar2 = (zztk) componentType.newInstance();
                    zztcVar.zza(zztkVar2);
                    return zztkVar2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e2) {
            throw new IllegalArgumentException("Error reading extension field", e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e3);
        } catch (InstantiationException e4) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e4);
        }
    }

    final T zzG(List<zztm> list) {
        if (list == null) {
            return null;
        }
        return this.zzbpS ? zzH(list) : zzI(list);
    }

    int zzY(Object obj) {
        return this.zzbpS ? zzZ(obj) : zzaa(obj);
    }

    protected int zzZ(Object obj) {
        int iZzaa = 0;
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            if (Array.get(obj, i) != null) {
                iZzaa += zzaa(Array.get(obj, i));
            }
        }
        return iZzaa;
    }

    protected void zza(zztm zztmVar, List<Object> list) {
        list.add(zzE(zztc.zzC(zztmVar.zzbqc)));
    }

    void zza(Object obj, zztd zztdVar) throws IOException {
        if (this.zzbpS) {
            zzc(obj, zztdVar);
        } else {
            zzb(obj, zztdVar);
        }
    }

    protected int zzaa(Object obj) {
        int iZzmG = zztn.zzmG(this.tag);
        switch (this.type) {
            case 10:
                return zztd.zzb(iZzmG, (zztk) obj);
            case 11:
                return zztd.zzc(iZzmG, (zztk) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void zzb(Object obj, zztd zztdVar) {
        try {
            zztdVar.zzmy(this.tag);
            switch (this.type) {
                case 10:
                    int iZzmG = zztn.zzmG(this.tag);
                    zztdVar.zzb((zztk) obj);
                    zztdVar.zzK(iZzmG, 4);
                    return;
                case 11:
                    zztdVar.zzc((zztk) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    protected void zzc(Object obj, zztd zztdVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zztdVar);
            }
        }
    }
}
