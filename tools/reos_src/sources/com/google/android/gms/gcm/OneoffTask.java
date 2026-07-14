package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class OneoffTask extends Task {
    public static final Parcelable.Creator<OneoffTask> CREATOR = new Parcelable.Creator<OneoffTask>() { // from class: com.google.android.gms.gcm.OneoffTask.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzez, reason: merged with bridge method [inline-methods] */
        public OneoffTask createFromParcel(Parcel parcel) {
            return new OneoffTask(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzgW, reason: merged with bridge method [inline-methods] */
        public OneoffTask[] newArray(int i) {
            return new OneoffTask[i];
        }
    };
    private final long zzaJi;
    private final long zzaJj;

    public static class Builder extends Task.Builder {
        private long zzaJk = -1;
        private long zzaJl = -1;

        public Builder() {
            this.isPersisted = false;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public OneoffTask build() {
            checkConditions();
            return new OneoffTask(this);
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        protected void checkConditions() {
            super.checkConditions();
            if (this.zzaJk == -1 || this.zzaJl == -1) {
                throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
            }
            if (this.zzaJk >= this.zzaJl) {
                throw new IllegalArgumentException("Window start must be shorter than window end.");
            }
        }

        public Builder setExecutionWindow(long j, long j2) {
            this.zzaJk = j;
            this.zzaJl = j2;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setPersisted(boolean z) {
            this.isPersisted = z;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setRequiredNetwork(int i) {
            this.requiredNetworkState = i;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setService(Class<? extends GcmTaskService> cls) {
            this.gcmTaskService = cls.getName();
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public /* bridge */ /* synthetic */ Task.Builder setService(Class cls) {
            return setService((Class<? extends GcmTaskService>) cls);
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setUpdateCurrent(boolean z) {
            this.updateCurrent = z;
            return this;
        }
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.zzaJi = parcel.readLong();
        this.zzaJj = parcel.readLong();
    }

    private OneoffTask(Builder builder) {
        super(builder);
        this.zzaJi = builder.zzaJk;
        this.zzaJj = builder.zzaJl;
    }

    public long getWindowEnd() {
        return this.zzaJj;
    }

    public long getWindowStart() {
        return this.zzaJi;
    }

    @Override // com.google.android.gms.gcm.Task
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("window_start", this.zzaJi);
        bundle.putLong("window_end", this.zzaJj);
    }

    public String toString() {
        return super.toString() + " windowStart=" + getWindowStart() + " windowEnd=" + getWindowEnd();
    }

    @Override // com.google.android.gms.gcm.Task, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.zzaJi);
        parcel.writeLong(this.zzaJj);
    }
}
