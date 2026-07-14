package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.p;
import android.support.v4.app.t;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class zzmr extends Fragment implements DialogInterface.OnCancelListener {
    private static final GoogleApiAvailability zzagU = GoogleApiAvailability.getInstance();
    private boolean mStarted;
    private boolean zzagV;
    private ConnectionResult zzagX;
    private zzmk zzagZ;
    private int zzagW = -1;
    private final Handler zzagY = new Handler(Looper.getMainLooper());
    private final SparseArray<zza> zzaha = new SparseArray<>();

    private class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzahb;
        public final GoogleApiClient zzahc;
        public final GoogleApiClient.OnConnectionFailedListener zzahd;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzahb = i;
            this.zzahc = googleApiClient;
            this.zzahd = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append((CharSequence) str).append("GoogleApiClient #").print(this.zzahb);
            printWriter.println(":");
            this.zzahc.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            zzmr.this.zzagY.post(zzmr.this.new zzb(this.zzahb, connectionResult));
        }

        public void zzpC() {
            this.zzahc.unregisterConnectionFailedListener(this);
            this.zzahc.disconnect();
        }
    }

    private class zzb implements Runnable {
        private final int zzahf;
        private final ConnectionResult zzahg;

        public zzb(int i, ConnectionResult connectionResult) {
            this.zzahf = i;
            this.zzahg = connectionResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!zzmr.this.mStarted || zzmr.this.zzagV) {
                return;
            }
            zzmr.this.zzagV = true;
            zzmr.this.zzagW = this.zzahf;
            zzmr.this.zzagX = this.zzahg;
            if (this.zzahg.hasResolution()) {
                try {
                    this.zzahg.startResolutionForResult(zzmr.this.getActivity(), ((zzmr.this.getActivity().getSupportFragmentManager().d().indexOf(zzmr.this) + 1) << 16) + 1);
                    return;
                } catch (IntentSender.SendIntentException e2) {
                    zzmr.this.zzpA();
                    return;
                }
            }
            if (zzmr.zzagU.isUserResolvableError(this.zzahg.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.zzahg.getErrorCode(), zzmr.this.getActivity(), zzmr.this, 2, zzmr.this);
            } else {
                if (this.zzahg.getErrorCode() != 18) {
                    zzmr.this.zza(this.zzahf, this.zzahg);
                    return;
                }
                final Dialog dialogZza = zzmr.zzagU.zza(zzmr.this.getActivity(), zzmr.this);
                zzmr.this.zzagZ = zzmk.zza(zzmr.this.getActivity().getApplicationContext(), new zzmk() { // from class: com.google.android.gms.internal.zzmr.zzb.1
                    @Override // com.google.android.gms.internal.zzmk
                    protected void zzpv() {
                        zzmr.this.zzpA();
                        dialogZza.dismiss();
                    }
                });
            }
        }
    }

    public static zzmr zza(p pVar) {
        zzx.zzcx("Must be called from main thread of process");
        try {
            zzmr zzmrVar = (zzmr) pVar.getSupportFragmentManager().a("GmsSupportLifecycleFrag");
            if (zzmrVar == null || zzmrVar.isRemoving()) {
                return null;
            }
            return zzmrVar;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        zza zzaVar = this.zzaha.get(i);
        if (zzaVar != null) {
            zzbE(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzaVar.zzahd;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzpA();
    }

    public static zzmr zzb(p pVar) {
        zzmr zzmrVarZza = zza(pVar);
        t supportFragmentManager = pVar.getSupportFragmentManager();
        if (zzmrVarZza != null) {
            return zzmrVarZza;
        }
        zzmr zzmrVar = new zzmr();
        supportFragmentManager.a().a(zzmrVar, "GmsSupportLifecycleFrag").b();
        supportFragmentManager.b();
        return zzmrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzpA() {
        int i = 0;
        this.zzagV = false;
        this.zzagW = -1;
        this.zzagX = null;
        if (this.zzagZ != null) {
            this.zzagZ.unregister();
            this.zzagZ = null;
        }
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaha.size()) {
                return;
            }
            this.zzaha.valueAt(i2).zzahc.connect();
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaha.size()) {
                return;
            }
            this.zzaha.valueAt(i2).dump(str, fileDescriptor, printWriter, strArr);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0005  */
    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (i2 == 0) {
                        this.zzagX = new ConnectionResult(13, null);
                    }
                    z = false;
                }
                break;
            case 2:
                if (zzagU.isGooglePlayServicesAvailable(getActivity()) != 0) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            zzpA();
        } else {
            zza(this.zzagW, this.zzagX);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzagW, new ConnectionResult(13, null));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzagV = bundle.getBoolean("resolving_error", false);
            this.zzagW = bundle.getInt("failed_client_id", -1);
            if (this.zzagW >= 0) {
                this.zzagX = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.zzagV);
        if (this.zzagW >= 0) {
            bundle.putInt("failed_client_id", this.zzagW);
            bundle.putInt("failed_status", this.zzagX.getErrorCode());
            bundle.putParcelable("failed_resolution", this.zzagX.getResolution());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (this.zzagV) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaha.size()) {
                return;
            }
            this.zzaha.valueAt(i2).zzahc.connect();
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        int i = 0;
        super.onStop();
        this.mStarted = false;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaha.size()) {
                return;
            }
            this.zzaha.valueAt(i2).zzahc.disconnect();
            i = i2 + 1;
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        zzx.zza(this.zzaha.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.zzaha.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (!this.mStarted || this.zzagV) {
            return;
        }
        googleApiClient.connect();
    }

    public void zzbE(int i) {
        zza zzaVar = this.zzaha.get(i);
        this.zzaha.remove(i);
        if (zzaVar != null) {
            zzaVar.zzpC();
        }
    }
}
