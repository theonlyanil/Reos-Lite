package com.google.android.gms.location.places.personalized;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface zza extends IInterface {

    /* JADX INFO: renamed from: com.google.android.gms.location.places.personalized.zza$zza, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0130zza extends Binder implements zza {

        /* JADX INFO: renamed from: com.google.android.gms.location.places.personalized.zza$zza$zza, reason: collision with other inner class name */
        private static class C0131zza implements zza {
            private IBinder zzoo;

            C0131zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoo;
            }

            @Override // com.google.android.gms.location.places.personalized.zza
            public void zza(PlaceAliasResult placeAliasResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    if (placeAliasResult != null) {
                        parcelObtain.writeInt(1);
                        placeAliasResult.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.places.personalized.zza
            public void zzb(PlaceAliasResult placeAliasResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    if (placeAliasResult != null) {
                        parcelObtain.writeInt(1);
                        placeAliasResult.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static zza zzcr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zza)) ? new C0131zza(iBinder) : (zza) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    zza(parcel.readInt() != 0 ? PlaceAliasResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    zzb(parcel.readInt() != 0 ? PlaceAliasResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(PlaceAliasResult placeAliasResult) throws RemoteException;

    void zzb(PlaceAliasResult placeAliasResult) throws RemoteException;
}
