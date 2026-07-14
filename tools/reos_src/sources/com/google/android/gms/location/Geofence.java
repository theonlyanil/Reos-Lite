package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

/* JADX INFO: loaded from: classes.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private double zzaKR;
        private double zzaKS;
        private float zzaKT;
        private String zzDX = null;
        private int zzaKO = 0;
        private long zzaKP = Long.MIN_VALUE;
        private short zzaKQ = -1;
        private int zzaKU = 0;
        private int zzaKV = -1;

        public Geofence build() {
            if (this.zzDX == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            if (this.zzaKO == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((this.zzaKO & 4) != 0 && this.zzaKV < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            }
            if (this.zzaKP == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (this.zzaKQ == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (this.zzaKU < 0) {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
            return new ParcelableGeofence(this.zzDX, this.zzaKO, (short) 1, this.zzaKR, this.zzaKS, this.zzaKT, this.zzaKP, this.zzaKU, this.zzaKV);
        }

        public Builder setCircularRegion(double d2, double d3, float f2) {
            this.zzaKQ = (short) 1;
            this.zzaKR = d2;
            this.zzaKS = d3;
            this.zzaKT = f2;
            return this;
        }

        public Builder setExpirationDuration(long j) {
            if (j < 0) {
                this.zzaKP = -1L;
            } else {
                this.zzaKP = SystemClock.elapsedRealtime() + j;
            }
            return this;
        }

        public Builder setLoiteringDelay(int i) {
            this.zzaKV = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i) {
            this.zzaKU = i;
            return this;
        }

        public Builder setRequestId(String str) {
            this.zzDX = str;
            return this;
        }

        public Builder setTransitionTypes(int i) {
            this.zzaKO = i;
            return this;
        }
    }

    String getRequestId();
}
