package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

/* JADX INFO: loaded from: classes.dex */
public interface zzkv extends IInterface {

    public static abstract class zza extends Binder implements zzkv {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzkv$zza$zza, reason: collision with other inner class name */
        private static class C0111zza implements zzkv {
            private IBinder zzoo;

            C0111zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoo;
            }

            @Override // com.google.android.gms.internal.zzkv
            public Intent zza(GetConsentIntentRequest getConsentIntentRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    if (getConsentIntentRequest != null) {
                        parcelObtain.writeInt(1);
                        getConsentIntentRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzkv zzau(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzkv)) ? new C0111zza(iBinder) : (zzkv) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    Intent intentZza = zza(parcel.readInt() != 0 ? GetConsentIntentRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentZza != null) {
                        parcel2.writeInt(1);
                        intentZza.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Intent zza(GetConsentIntentRequest getConsentIntentRequest) throws RemoteException;
}
