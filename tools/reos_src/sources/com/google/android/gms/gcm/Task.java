package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class Task implements Parcelable {
    public static final int EXTRAS_LIMIT_BYTES = 10240;
    public static final int NETWORK_STATE_ANY = 2;
    public static final int NETWORK_STATE_CONNECTED = 0;
    public static final int NETWORK_STATE_UNMETERED = 1;
    protected static final long UNINITIALIZED = -1;
    private final Bundle mExtras;
    private final String mTag;
    private final String zzaJt;
    private final boolean zzaJu;
    private final boolean zzaJv;
    private final int zzaJw;
    private final boolean zzaJx;
    private final zzd zzaJy;

    public static abstract class Builder {
        protected Bundle extras;
        protected String gcmTaskService;
        protected boolean isPersisted;
        protected int requiredNetworkState;
        protected boolean requiresCharging;
        protected String tag;
        protected boolean updateCurrent;
        protected zzd zzaJz = zzd.zzaJo;

        public abstract Task build();

        protected void checkConditions() {
            zzx.zzb(this.gcmTaskService != null, "Must provide an endpoint for this task by calling setService(ComponentName).");
            GcmNetworkManager.zzdE(this.tag);
            Task.zza(this.zzaJz);
            if (this.isPersisted) {
                Task.zzF(this.extras);
            }
        }

        public abstract Builder setExtras(Bundle bundle);

        public abstract Builder setPersisted(boolean z);

        public abstract Builder setRequiredNetwork(int i);

        public abstract Builder setRequiresCharging(boolean z);

        public abstract Builder setService(Class<? extends GcmTaskService> cls);

        public abstract Builder setTag(String str);

        public abstract Builder setUpdateCurrent(boolean z);
    }

    @Deprecated
    Task(Parcel parcel) {
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.zzaJt = parcel.readString();
        this.mTag = parcel.readString();
        this.zzaJu = parcel.readInt() == 1;
        this.zzaJv = parcel.readInt() == 1;
        this.zzaJw = 2;
        this.zzaJx = false;
        this.zzaJy = zzd.zzaJo;
        this.mExtras = null;
    }

    Task(Builder builder) {
        this.zzaJt = builder.gcmTaskService;
        this.mTag = builder.tag;
        this.zzaJu = builder.updateCurrent;
        this.zzaJv = builder.isPersisted;
        this.zzaJw = builder.requiredNetworkState;
        this.zzaJx = builder.requiresCharging;
        this.zzaJy = builder.zzaJz;
        this.mExtras = builder.extras;
    }

    private static boolean zzC(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static void zzF(Bundle bundle) {
        if (bundle != null) {
            Parcel parcelObtain = Parcel.obtain();
            bundle.writeToParcel(parcelObtain, 0);
            int iDataSize = parcelObtain.dataSize();
            if (iDataSize > 10240) {
                parcelObtain.recycle();
                throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + iDataSize);
            }
            parcelObtain.recycle();
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                if (!zzC(bundle.get(it.next()))) {
                    throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
                }
            }
        }
    }

    public static void zza(zzd zzdVar) {
        if (zzdVar != null) {
            int iZzxA = zzdVar.zzxA();
            if (iZzxA != 1 && iZzxA != 0) {
                throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + iZzxA);
            }
            int iZzxB = zzdVar.zzxB();
            int iZzxC = zzdVar.zzxC();
            if (iZzxA == 0 && iZzxB < 0) {
                throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + iZzxB);
            }
            if (iZzxA == 1 && iZzxB < 10) {
                throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
            }
            if (iZzxC < iZzxB) {
                throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + zzdVar.zzxC());
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getRequiredNetwork() {
        return this.zzaJw;
    }

    public boolean getRequiresCharging() {
        return this.zzaJx;
    }

    public String getServiceName() {
        return this.zzaJt;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isPersisted() {
        return this.zzaJv;
    }

    public boolean isUpdateCurrent() {
        return this.zzaJu;
    }

    public void toBundle(Bundle bundle) {
        bundle.putString(Constants.SMS_COLUMN_TAG, this.mTag);
        bundle.putBoolean("update_current", this.zzaJu);
        bundle.putBoolean("persisted", this.zzaJv);
        bundle.putString("service", this.zzaJt);
        bundle.putInt("requiredNetwork", this.zzaJw);
        bundle.putBoolean("requiresCharging", this.zzaJx);
        bundle.putBundle("retryStrategy", this.zzaJy.zzE(new Bundle()));
        bundle.putBundle("extras", this.mExtras);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzaJt);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.zzaJu ? 1 : 0);
        parcel.writeInt(this.zzaJv ? 1 : 0);
    }
}
