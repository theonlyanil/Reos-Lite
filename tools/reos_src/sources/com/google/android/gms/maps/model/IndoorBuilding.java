package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class IndoorBuilding {
    private final com.google.android.gms.maps.model.internal.zzd zzaQu;

    public IndoorBuilding(com.google.android.gms.maps.model.internal.zzd zzdVar) {
        this.zzaQu = (com.google.android.gms.maps.model.internal.zzd) zzx.zzy(zzdVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zzaQu.zzb(((IndoorBuilding) obj).zzaQu);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.zzaQu.getActiveLevelIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.zzaQu.getActiveLevelIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.zzaQu.getLevels();
            ArrayList arrayList = new ArrayList(levels.size());
            Iterator<IBinder> it = levels.iterator();
            while (it.hasNext()) {
                arrayList.add(new IndoorLevel(com.google.android.gms.maps.model.internal.zze.zza.zzdc(it.next())));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQu.hashCodeRemote();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isUnderground() {
        try {
            return this.zzaQu.isUnderground();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
