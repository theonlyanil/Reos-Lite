package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;

/* JADX INFO: loaded from: classes.dex */
public interface zzlw extends IInterface {

    public static abstract class zza extends Binder implements zzlw {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzlw$zza$zza, reason: collision with other inner class name */
        private static class C0116zza implements zzlw {
            private IBinder zzoo;

            C0116zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoo;
            }

            @Override // com.google.android.gms.internal.zzlw
            public void zza(zzlv zzlvVar, LogEventParcelable logEventParcelable) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    parcelObtain.writeStrongBinder(zzlvVar != null ? zzlvVar.asBinder() : null);
                    if (logEventParcelable != null) {
                        parcelObtain.writeInt(1);
                        logEventParcelable.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoo.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static zzlw zzaM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzlw)) ? new C0116zza(iBinder) : (zzlw) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(zzlv.zza.zzaL(parcel.readStrongBinder()), parcel.readInt() != 0 ? LogEventParcelable.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzlv zzlvVar, LogEventParcelable logEventParcelable) throws RemoteException;
}
