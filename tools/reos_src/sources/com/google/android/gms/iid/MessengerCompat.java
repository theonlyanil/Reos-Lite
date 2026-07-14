package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class MessengerCompat implements Parcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new Parcelable.Creator<MessengerCompat>() { // from class: com.google.android.gms.iid.MessengerCompat.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzeF, reason: merged with bridge method [inline-methods] */
        public MessengerCompat createFromParcel(Parcel parcel) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                return new MessengerCompat(strongBinder);
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzhd, reason: merged with bridge method [inline-methods] */
        public MessengerCompat[] newArray(int i) {
            return new MessengerCompat[i];
        }
    };
    Messenger zzaKq;
    zzb zzaKr;

    private final class zza extends zzb.zza {
        Handler handler;

        zza(Handler handler) {
            this.handler = handler;
        }

        @Override // com.google.android.gms.iid.zzb
        public void send(Message message) throws RemoteException {
            message.arg2 = Binder.getCallingUid();
            this.handler.dispatchMessage(message);
        }
    }

    public MessengerCompat(Handler handler) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzaKq = new Messenger(handler);
        } else {
            this.zzaKr = new zza(handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzaKq = new Messenger(iBinder);
        } else {
            this.zzaKr = zzb.zza.zzcd(iBinder);
        }
    }

    public static int zzc(Message message) {
        return Build.VERSION.SDK_INT >= 21 ? zzd(message) : message.arg2;
    }

    private static int zzd(Message message) {
        return message.sendingUid;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public IBinder getBinder() {
        return this.zzaKq != null ? this.zzaKq.getBinder() : this.zzaKr.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        if (this.zzaKq != null) {
            this.zzaKq.send(message);
        } else {
            this.zzaKr.send(message);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzaKq != null) {
            parcel.writeStrongBinder(this.zzaKq.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzaKr.asBinder());
        }
    }
}
