package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* JADX INFO: loaded from: classes.dex */
public interface zzkz extends IInterface {

    public static abstract class zza extends Binder implements zzkz {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzkz$zza$zza, reason: collision with other inner class name */
        private static class C0113zza implements zzkz {
            private IBinder zzoo;

            C0113zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoo;
            }

            @Override // com.google.android.gms.internal.zzkz
            public void zza(zzky zzkyVar, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    parcelObtain.writeStrongBinder(zzkyVar != null ? zzkyVar.asBinder() : null);
                    if (proxyGrpcRequest != null) {
                        parcelObtain.writeInt(1);
                        proxyGrpcRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzkz
            public void zza(zzky zzkyVar, ProxyRequest proxyRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    parcelObtain.writeStrongBinder(zzkyVar != null ? zzkyVar.asBinder() : null);
                    if (proxyRequest != null) {
                        parcelObtain.writeInt(1);
                        proxyRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzkz zzaA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzkz)) ? new C0113zza(iBinder) : (zzkz) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zza(zzky.zza.zzaz(parcel.readStrongBinder()), parcel.readInt() != 0 ? ProxyRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zza(zzky.zza.zzaz(parcel.readStrongBinder()), parcel.readInt() != 0 ? ProxyGrpcRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.internal.IAuthService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzky zzkyVar, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException;

    void zza(zzky zzkyVar, ProxyRequest proxyRequest) throws RemoteException;
}
