package com.google.android.youtube.player.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface w extends IInterface {

    public static abstract class a extends Binder implements w {

        /* JADX INFO: renamed from: com.google.android.youtube.player.a.w$a$a, reason: collision with other inner class name */
        private static class C0198a implements w {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5347a;

            C0198a(IBinder iBinder) {
                this.f5347a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5347a;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
        }

        public static w a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof w)) ? new C0198a(iBinder) : (w) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
