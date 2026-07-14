package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface zzu extends IInterface {

    public static abstract class zza extends Binder implements zzu {

        /* JADX INFO: renamed from: com.google.android.gms.common.internal.zzu$zza$zza, reason: collision with other inner class name */
        private static class C0100zza implements zzu {
            private IBinder zzoo;

            C0100zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoo;
            }

            @Override // com.google.android.gms.common.internal.zzu
            public com.google.android.gms.dynamic.zzd zza(com.google.android.gms.dynamic.zzd zzdVar, int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.zzoo.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.common.internal.zzu
            public com.google.android.gms.dynamic.zzd zza(com.google.android.gms.dynamic.zzd zzdVar, SignInButtonConfig signInButtonConfig) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (signInButtonConfig != null) {
                        parcelObtain.writeInt(1);
                        signInButtonConfig.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzu zzaU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzu)) ? new C0100zza(iBinder) : (zzu) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    com.google.android.gms.dynamic.zzd zzdVarZza = zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarZza != null ? zzdVarZza.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    com.google.android.gms.dynamic.zzd zzdVarZza2 = zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel.readStrongBinder()), parcel.readInt() != 0 ? SignInButtonConfig.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarZza2 != null ? zzdVarZza2.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    com.google.android.gms.dynamic.zzd zza(com.google.android.gms.dynamic.zzd zzdVar, int i, int i2) throws RemoteException;

    com.google.android.gms.dynamic.zzd zza(com.google.android.gms.dynamic.zzd zzdVar, SignInButtonConfig signInButtonConfig) throws RemoteException;
}
