package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private com.google.android.gms.maps.model.internal.zzi zzaQR;
    private TileProvider zzaQS;
    private boolean zzaQT;
    private float zzaQj;
    private boolean zzaQk;

    public TileOverlayOptions() {
        this.zzaQk = true;
        this.zzaQT = true;
        this.mVersionCode = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f2, boolean z2) {
        this.zzaQk = true;
        this.zzaQT = true;
        this.mVersionCode = i;
        this.zzaQR = com.google.android.gms.maps.model.internal.zzi.zza.zzdh(iBinder);
        this.zzaQS = this.zzaQR == null ? null : new TileProvider() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.1
            private final com.google.android.gms.maps.model.internal.zzi zzaQU;

            {
                this.zzaQU = TileOverlayOptions.this.zzaQR;
            }

            @Override // com.google.android.gms.maps.model.TileProvider
            public Tile getTile(int i2, int i3, int i4) {
                try {
                    return this.zzaQU.getTile(i2, i3, i4);
                } catch (RemoteException e2) {
                    return null;
                }
            }
        };
        this.zzaQk = z;
        this.zzaQj = f2;
        this.zzaQT = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.zzaQT = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaQT;
    }

    public TileProvider getTileProvider() {
        return this.zzaQS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaQj;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzaQS = tileProvider;
        this.zzaQR = this.zzaQS == null ? null : new com.google.android.gms.maps.model.internal.zzi.zza() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.2
            @Override // com.google.android.gms.maps.model.internal.zzi
            public Tile getTile(int i, int i2, int i3) {
                return tileProvider.getTile(i, i2, i3);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.zzaQk = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public TileOverlayOptions zIndex(float f2) {
        this.zzaQj = f2;
        return this;
    }

    IBinder zzzx() {
        return this.zzaQR.asBinder();
    }
}
