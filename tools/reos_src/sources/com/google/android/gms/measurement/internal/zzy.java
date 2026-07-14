package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
public class zzy extends zzw {
    private zza zzaUI;
    private AppMeasurement.zza zzaUJ;
    private boolean zzaUK;

    private class zza implements Application.ActivityLifecycleCallbacks {
        private zza() {
        }

        private boolean zzeD(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zzy.this.zza("auto", "_ldl", str);
            return true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Uri data;
            try {
                zzy.this.zzzz().zzBr().zzez("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                    String queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.contains("gclid")) {
                            zzy.this.zzzz().zzBq().zzj("Activity created with referrer", queryParameter);
                            zzeD(queryParameter);
                        } else {
                            zzy.this.zzzz().zzBq().zzez("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                zzy.this.zzzz().zzBl().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzy(zzt zztVar) {
        super(zztVar);
    }

    private void zzBT() {
        try {
            zzg(Class.forName(zzBU()));
        } catch (ClassNotFoundException e2) {
            zzzz().zzBp().zzez("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzBU() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        com.google.android.gms.common.internal.zzx.zzcG(str);
        com.google.android.gms.common.internal.zzx.zzcG(str2);
        com.google.android.gms.common.internal.zzx.zzy(bundle);
        zziS();
        zzje();
        if (!zzAW().zzzC()) {
            zzzz().zzBp().zzez("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.zzaUK) {
            this.zzaUK = true;
            zzBT();
        }
        if (z && this.zzaUJ != null) {
            zzzz().zzBq().zze("Passing event to registered event handler (FE)", str2, bundle);
            this.zzaUJ.zze(str, str2, bundle);
        } else if (this.zzaQX.zzBz()) {
            zzzz().zzBq().zze("Logging event (FE)", str2, bundle);
            zzAT().zzb(new EventParcel(str2, new EventParams(bundle), str, j), str3);
        }
    }

    private void zza(final String str, final String str2, Bundle bundle, final boolean z, final String str3) {
        com.google.android.gms.common.internal.zzx.zzcG(str);
        final long jCurrentTimeMillis = zziT().currentTimeMillis();
        zzAU().zzeE(str2);
        final Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str4 : bundle.keySet()) {
                zzAU().zzeG(str4);
                Object objZzk = zzAU().zzk(str4, bundle.get(str4));
                if (objZzk != null) {
                    zzAU().zza(bundle2, str4, objZzk);
                }
            }
        }
        zzAV().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzy.2
            @Override // java.lang.Runnable
            public void run() {
                zzy.this.zza(str, str2, jCurrentTimeMillis, bundle2, z, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(String str, String str2, Object obj, long j) {
        com.google.android.gms.common.internal.zzx.zzcG(str);
        com.google.android.gms.common.internal.zzx.zzcG(str2);
        zziS();
        zziR();
        zzje();
        if (!zzAW().zzzC()) {
            zzzz().zzBp().zzez("User attribute not set since app measurement is disabled");
        } else if (this.zzaQX.zzBz()) {
            zzzz().zzBq().zze("Setting user attribute (FE)", str2, obj);
            zzAT().zza(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzaq(boolean z) {
        zziS();
        zziR();
        zzje();
        zzzz().zzBq().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzAW().setMeasurementEnabled(z);
        zzAT().zzBV();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(final boolean z) {
        zzje();
        zziR();
        zzAV().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzy.1
            @Override // java.lang.Runnable
            public void run() {
                zzy.this.zzaq(z);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ void zzAR() {
        super.zzAR();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzc zzAX() {
        return super.zzAX();
    }

    public void zzBR() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.zzaUI == null) {
                this.zzaUI = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.zzaUI);
            application.registerActivityLifecycleCallbacks(this.zzaUI);
            zzzz().zzBr().zzez("Registered activity lifecycle callback");
        }
    }

    public void zzBS() {
        zziS();
        zziR();
        zzje();
        if (this.zzaQX.zzBz()) {
            zzAT().zzBS();
        }
    }

    public void zza(final String str, final String str2, Object obj) {
        com.google.android.gms.common.internal.zzx.zzcG(str);
        final long jCurrentTimeMillis = zziT().currentTimeMillis();
        zzAU().zzeF(str2);
        if (obj == null) {
            zzAV().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzy.4
                @Override // java.lang.Runnable
                public void run() {
                    zzy.this.zza(str, str2, null, jCurrentTimeMillis);
                }
            });
            return;
        }
        zzAU().zzl(str2, obj);
        final Object objZzm = zzAU().zzm(str2, obj);
        if (objZzm != null) {
            zzAV().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzy.3
                @Override // java.lang.Runnable
                public void run() {
                    zzy.this.zza(str, str2, objZzm, jCurrentTimeMillis);
                }
            });
        }
    }

    public void zze(String str, String str2, Bundle bundle) {
        zziR();
        zza(str, str2, bundle, true, (String) null);
    }

    public void zzg(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
        } catch (Exception e2) {
            zzzz().zzBm().zzj("Failed to invoke Tag Manager's initialize() method", e2);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ void zziS() {
        super.zziS();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    @Override // com.google.android.gms.measurement.internal.zzw
    protected void zzir() {
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
