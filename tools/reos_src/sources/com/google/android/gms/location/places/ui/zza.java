package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

/* JADX INFO: loaded from: classes.dex */
abstract class zza {
    public static final int RESULT_ERROR = 2;

    /* JADX INFO: renamed from: com.google.android.gms.location.places.ui.zza$zza, reason: collision with other inner class name */
    protected static abstract class AbstractC0132zza {
        protected final Intent mIntent;

        public AbstractC0132zza(String str) {
            this.mIntent = new Intent(str);
            this.mIntent.setPackage("com.google.android.gms");
        }

        protected Intent zzaO(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            GoogleApiAvailability.getInstance().zzai(context);
            return this.mIntent;
        }
    }

    zza() {
    }
}
