package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final GoogleApiAvailability zzagU = GoogleApiAvailability.getInstance();
    private static final Object zzqf = new Object();
    private static Method zzbbC = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzx.zzb(context, "Context must not be null");
        zzagU.zzai(context);
        Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (zzqf) {
            try {
                if (zzbbC == null) {
                    zzaV(remoteContext);
                }
                zzbbC.invoke(null, remoteContext);
            } catch (Exception e2) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e2.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener providerInstallListener) {
        zzx.zzb(context, "Context must not be null");
        zzx.zzb(providerInstallListener, "Listener must not be null");
        zzx.zzcx("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() { // from class: com.google.android.gms.security.ProviderInstaller.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
            public Integer doInBackground(Void... voidArr) {
                try {
                    ProviderInstaller.installIfNeeded(context);
                    return 0;
                } catch (GooglePlayServicesNotAvailableException e2) {
                    return Integer.valueOf(e2.errorCode);
                } catch (GooglePlayServicesRepairableException e3) {
                    return Integer.valueOf(e3.getConnectionStatusCode());
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Integer num) {
                if (num.intValue() == 0) {
                    providerInstallListener.onProviderInstalled();
                } else {
                    providerInstallListener.onProviderInstallFailed(num.intValue(), ProviderInstaller.zzagU.zza(context, num.intValue(), "pi"));
                }
            }
        }.execute(new Void[0]);
    }

    private static void zzaV(Context context) throws NoSuchMethodException, ClassNotFoundException {
        zzbbC = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
    }
}
