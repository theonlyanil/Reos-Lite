package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class IndoorLevel {
    private final com.google.android.gms.maps.model.internal.zze zzaQv;

    public IndoorLevel(com.google.android.gms.maps.model.internal.zze zzeVar) {
        this.zzaQv = (com.google.android.gms.maps.model.internal.zze) zzx.zzy(zzeVar);
    }

    public void activate() {
        try {
            this.zzaQv.activate();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.zzaQv.zza(((IndoorLevel) obj).zzaQv);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getName() {
        try {
            return this.zzaQv.getName();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getShortName() {
        try {
            return this.zzaQv.getShortName();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQv.hashCodeRemote();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
