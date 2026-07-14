package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.p;
import android.support.v4.h.a;
import android.view.View;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> zzaez = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Account zzSo;
        private String zzTz;
        private final Set<Scope> zzaeA;
        private final Set<Scope> zzaeB;
        private int zzaeC;
        private View zzaeD;
        private String zzaeE;
        private final Map<Api<?>, zzf.zza> zzaeF;
        private final Map<Api<?>, Api.ApiOptions> zzaeG;
        private p zzaeH;
        private int zzaeI;
        private OnConnectionFailedListener zzaeJ;
        private Looper zzaeK;
        private GoogleApiAvailability zzaeL;
        private Api.zza<? extends zzsc, zzsd> zzaeM;
        private final ArrayList<ConnectionCallbacks> zzaeN;
        private final ArrayList<OnConnectionFailedListener> zzaeO;
        private zzsd zzaeP;

        public Builder(Context context) {
            this.zzaeA = new HashSet();
            this.zzaeB = new HashSet();
            this.zzaeF = new a();
            this.zzaeG = new a();
            this.zzaeI = -1;
            this.zzaeL = GoogleApiAvailability.getInstance();
            this.zzaeM = zzsa.zzTp;
            this.zzaeN = new ArrayList<>();
            this.zzaeO = new ArrayList<>();
            this.mContext = context;
            this.zzaeK = context.getMainLooper();
            this.zzTz = context.getPackageName();
            this.zzaeE = context.getClass().getName();
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzx.zzb(connectionCallbacks, "Must provide a connected listener");
            this.zzaeN.add(connectionCallbacks);
            zzx.zzb(onConnectionFailedListener, "Must provide a connection failed listener");
            this.zzaeO.add(onConnectionFailedListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <C extends Api.zzb, O> C zza(Api.zza<C, O> zzaVar, Object obj, Context context, Looper looper, zzf zzfVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return (C) zzaVar.zza(context, looper, zzfVar, obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <C extends Api.zzd, O> zzad zza(Api.zze<C, O> zzeVar, Object obj, Context context, Looper looper, zzf zzfVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzad(context, looper, zzeVar.zzoD(), connectionCallbacks, onConnectionFailedListener, zzfVar, zzeVar.zzp(obj));
        }

        private <O extends Api.ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
                z = false;
            }
            HashSet hashSet = new HashSet(api.zzoy().zzn(o));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.zzaeF.put(api, new zzf.zza(hashSet, z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void zza(zzmr zzmrVar, GoogleApiClient googleApiClient) {
            zzmrVar.zza(this.zzaeI, googleApiClient, this.zzaeJ);
        }

        private void zzd(final GoogleApiClient googleApiClient) {
            zzmr zzmrVarZza = zzmr.zza(this.zzaeH);
            if (zzmrVarZza == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.common.api.GoogleApiClient.Builder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Builder.this.zzaeH.isFinishing() || Builder.this.zzaeH.getSupportFragmentManager().e()) {
                            return;
                        }
                        Builder.this.zza(zzmr.zzb(Builder.this.zzaeH), googleApiClient);
                    }
                });
            } else {
                zza(zzmrVarZza, googleApiClient);
            }
        }

        private GoogleApiClient zzoI() {
            Api.zzb zzbVarZza;
            Api<?> api;
            zzf zzfVarZzoH = zzoH();
            Api<?> api2 = null;
            Map<Api<?>, zzf.zza> mapZzqc = zzfVarZzoH.zzqc();
            a aVar = new a();
            a aVar2 = new a();
            ArrayList arrayList = new ArrayList();
            Api<?> api3 = null;
            for (Api<?> api4 : this.zzaeG.keySet()) {
                Api.ApiOptions apiOptions = this.zzaeG.get(api4);
                int i = mapZzqc.get(api4) != null ? mapZzqc.get(api4).zzaju ? 1 : 2 : 0;
                aVar.put(api4, Integer.valueOf(i));
                zzlz zzlzVar = new zzlz(api4, i);
                arrayList.add(zzlzVar);
                if (api4.zzoB()) {
                    Api.zze<?, O> zzeVarZzoz = api4.zzoz();
                    Api<?> api5 = zzeVarZzoz.getPriority() == 1 ? api4 : api3;
                    zzbVarZza = zza(zzeVarZzoz, apiOptions, this.mContext, this.zzaeK, zzfVarZzoH, zzlzVar, zzlzVar);
                    api = api5;
                } else {
                    Api.zza<?, O> zzaVarZzoy = api4.zzoy();
                    Api<?> api6 = zzaVarZzoy.getPriority() == 1 ? api4 : api3;
                    zzbVarZza = zza((Api.zza<Api.zzb, O>) zzaVarZzoy, (Object) apiOptions, this.mContext, this.zzaeK, zzfVarZzoH, (ConnectionCallbacks) zzlzVar, (OnConnectionFailedListener) zzlzVar);
                    api = api6;
                }
                aVar2.put(api4.zzoA(), zzbVarZza);
                if (!zzbVarZza.zzmJ()) {
                    api4 = api2;
                } else if (api2 != null) {
                    throw new IllegalStateException(api4.getName() + " cannot be used with " + api2.getName());
                }
                api3 = api;
                api2 = api4;
            }
            if (api2 != null) {
                if (api3 != null) {
                    throw new IllegalStateException(api2.getName() + " cannot be used with " + api3.getName());
                }
                zzx.zza(this.zzSo == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api2.getName());
                zzx.zza(this.zzaeA.equals(this.zzaeB), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api2.getName());
                zzx.zza(this.zzaeP == null, "Must not call requestServerAuthCode in GoogleApiClient.Builder when using %s. Call requestServerAuthCode in GoogleSignInOptions.Builder instead.", api2.getName());
            }
            return new zzmg(this.mContext, new ReentrantLock(), this.zzaeK, zzfVarZzoH, this.zzaeL, this.zzaeM, aVar, this.zzaeN, this.zzaeO, aVar2, this.zzaeI, zzmg.zza(aVar2.values(), true), arrayList);
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzx.zzb(api, "Api must not be null");
            this.zzaeG.put(api, null);
            List<Scope> listZzn = api.zzoy().zzn(null);
            this.zzaeB.addAll(listZzn);
            this.zzaeA.addAll(listZzn);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            zzx.zzb(api, "Api must not be null");
            zzx.zzb(o, "Null options are not permitted for this Api");
            this.zzaeG.put(api, o);
            List<Scope> listZzn = api.zzoy().zzn(o);
            this.zzaeB.addAll(listZzn);
            this.zzaeA.addAll(listZzn);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            zzx.zzb(api, "Api must not be null");
            zzx.zzb(o, "Null options are not permitted for this Api");
            this.zzaeG.put(api, o);
            zza(api, o, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            zzx.zzb(api, "Api must not be null");
            this.zzaeG.put(api, null);
            zza(api, null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            zzx.zzb(connectionCallbacks, "Listener must not be null");
            this.zzaeN.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(onConnectionFailedListener, "Listener must not be null");
            this.zzaeO.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope scope) {
            zzx.zzb(scope, "Scope must not be null");
            this.zzaeA.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.zzaeG.isEmpty(), "must call addApi() to add at least one API");
            GoogleApiClient googleApiClientZzoI = zzoI();
            synchronized (GoogleApiClient.zzaez) {
                GoogleApiClient.zzaez.add(googleApiClientZzoI);
            }
            if (this.zzaeI >= 0) {
                zzd(googleApiClientZzoI);
            }
            return googleApiClientZzoI;
        }

        public Builder enableAutoManage(p pVar, int i, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(i >= 0, "clientId must be non-negative");
            this.zzaeI = i;
            this.zzaeH = (p) zzx.zzb(pVar, "Null activity is not permitted.");
            this.zzaeJ = onConnectionFailedListener;
            return this;
        }

        public Builder enableAutoManage(p pVar, OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(pVar, 0, onConnectionFailedListener);
        }

        @Deprecated
        public Builder requestServerAuthCode(String str, ServerAuthCodeCallbacks serverAuthCodeCallbacks) {
            this.zzaeP = new zzsd.zza().zza(str, serverAuthCodeCallbacks).zzDQ();
            return this;
        }

        public Builder setAccountName(String str) {
            this.zzSo = str == null ? null : new Account(str, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.zzaeC = i;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzx.zzb(handler, "Handler must not be null");
            this.zzaeK = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View view) {
            zzx.zzb(view, "View must not be null");
            this.zzaeD = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzoH() {
            if (this.zzaeG.containsKey(zzsa.API)) {
                zzx.zza(this.zzaeP == null, "SignIn.API can't be used in conjunction with requestServerAuthCode.");
                this.zzaeP = (zzsd) this.zzaeG.get(zzsa.API);
            }
            return new zzf(this.zzSo, this.zzaeA, this.zzaeF, this.zzaeC, this.zzaeD, this.zzTz, this.zzaeE, this.zzaeP != null ? this.zzaeP : zzsd.zzbbH);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public interface ServerAuthCodeCallbacks {

        public static class CheckResult {
            private Set<Scope> zzVH;
            private boolean zzaeR;

            private CheckResult(boolean z, Set<Scope> set) {
                this.zzaeR = z;
                this.zzVH = set;
            }

            public static CheckResult newAuthNotRequiredResult() {
                return new CheckResult(false, null);
            }

            public static CheckResult newAuthRequiredResult(Set<Scope> set) {
                zzx.zzb((set == null || set.isEmpty()) ? false : true, "A non-empty scope set is required if further auth is needed.");
                return new CheckResult(true, set);
            }

            public boolean zzoJ() {
                return this.zzaeR;
            }

            public Set<Scope> zzoK() {
                return this.zzVH;
            }
        }

        CheckResult onCheckServerAuthorization(String str, Set<Scope> set);

        boolean onUploadServerAuthCode(String str, String str2);
    }

    public interface zza {
        void zza(ConnectionResult connectionResult);

        void zzb(ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (zzaez) {
            String str2 = str + "  ";
            int i = 0;
            for (GoogleApiClient googleApiClient : zzaez) {
                printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i);
                googleApiClient.dump(str2, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public static Set<GoogleApiClient> zzoE() {
        return zzaez;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(p pVar);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public <C extends Api.zzb> C zza(Api.zzc<C> zzcVar) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T t) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzmp zzmpVar) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T t) {
        throw new UnsupportedOperationException();
    }

    public void zzoF() {
        throw new UnsupportedOperationException();
    }

    public <L> zzmn<L> zzq(L l) {
        throw new UnsupportedOperationException();
    }
}
