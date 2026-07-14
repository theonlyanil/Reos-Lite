package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public interface ICameraUpdateFactoryDelegate extends IInterface {

    public static abstract class zza extends Binder implements ICameraUpdateFactoryDelegate {

        /* JADX INFO: renamed from: com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate$zza$zza, reason: collision with other inner class name */
        private static class C0135zza implements ICameraUpdateFactoryDelegate {
            private IBinder zzoo;

            C0135zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoo;
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd newCameraPosition(CameraPosition cameraPosition) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (cameraPosition != null) {
                        parcelObtain.writeInt(1);
                        cameraPosition.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd newLatLng(LatLng latLng) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLng != null) {
                        parcelObtain.writeInt(1);
                        latLng.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd newLatLngBounds(LatLngBounds latLngBounds, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLngBounds != null) {
                        parcelObtain.writeInt(1);
                        latLngBounds.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    this.zzoo.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd newLatLngBoundsWithSize(LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLngBounds != null) {
                        parcelObtain.writeInt(1);
                        latLngBounds.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.zzoo.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd newLatLngZoom(LatLng latLng, float f2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLng != null) {
                        parcelObtain.writeInt(1);
                        latLng.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeFloat(f2);
                    this.zzoo.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd scrollBy(float f2, float f3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcelObtain.writeFloat(f2);
                    parcelObtain.writeFloat(f3);
                    this.zzoo.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd zoomBy(float f2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcelObtain.writeFloat(f2);
                    this.zzoo.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd zoomByWithFocus(float f2, int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcelObtain.writeFloat(f2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.zzoo.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd zoomIn() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    this.zzoo.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd zoomOut() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    this.zzoo.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
            public com.google.android.gms.dynamic.zzd zoomTo(float f2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcelObtain.writeFloat(f2);
                    this.zzoo.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbs(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ICameraUpdateFactoryDelegate zzcs(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICameraUpdateFactoryDelegate)) ? new C0135zza(iBinder) : (ICameraUpdateFactoryDelegate) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarZoomIn = zoomIn();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarZoomIn != null ? zzdVarZoomIn.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarZoomOut = zoomOut();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarZoomOut != null ? zzdVarZoomOut.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarScrollBy = scrollBy(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarScrollBy != null ? zzdVarScrollBy.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarZoomTo = zoomTo(parcel.readFloat());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarZoomTo != null ? zzdVarZoomTo.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarZoomBy = zoomBy(parcel.readFloat());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarZoomBy != null ? zzdVarZoomBy.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarZoomByWithFocus = zoomByWithFocus(parcel.readFloat(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarZoomByWithFocus != null ? zzdVarZoomByWithFocus.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarNewCameraPosition = newCameraPosition(parcel.readInt() != 0 ? CameraPosition.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarNewCameraPosition != null ? zzdVarNewCameraPosition.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarNewLatLng = newLatLng(parcel.readInt() != 0 ? LatLng.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarNewLatLng != null ? zzdVarNewLatLng.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarNewLatLngZoom = newLatLngZoom(parcel.readInt() != 0 ? LatLng.CREATOR.createFromParcel(parcel) : null, parcel.readFloat());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarNewLatLngZoom != null ? zzdVarNewLatLngZoom.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarNewLatLngBounds = newLatLngBounds(parcel.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarNewLatLngBounds != null ? zzdVarNewLatLngBounds.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    com.google.android.gms.dynamic.zzd zzdVarNewLatLngBoundsWithSize = newLatLngBoundsWithSize(parcel.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzdVarNewLatLngBoundsWithSize != null ? zzdVarNewLatLngBoundsWithSize.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    com.google.android.gms.dynamic.zzd newCameraPosition(CameraPosition cameraPosition) throws RemoteException;

    com.google.android.gms.dynamic.zzd newLatLng(LatLng latLng) throws RemoteException;

    com.google.android.gms.dynamic.zzd newLatLngBounds(LatLngBounds latLngBounds, int i) throws RemoteException;

    com.google.android.gms.dynamic.zzd newLatLngBoundsWithSize(LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException;

    com.google.android.gms.dynamic.zzd newLatLngZoom(LatLng latLng, float f2) throws RemoteException;

    com.google.android.gms.dynamic.zzd scrollBy(float f2, float f3) throws RemoteException;

    com.google.android.gms.dynamic.zzd zoomBy(float f2) throws RemoteException;

    com.google.android.gms.dynamic.zzd zoomByWithFocus(float f2, int i, int i2) throws RemoteException;

    com.google.android.gms.dynamic.zzd zoomIn() throws RemoteException;

    com.google.android.gms.dynamic.zzd zoomOut() throws RemoteException;

    com.google.android.gms.dynamic.zzd zoomTo(float f2) throws RemoteException;
}
