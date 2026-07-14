package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzm extends zzl implements Handler.Callback {
    private final Handler mHandler;
    private final HashMap<zza, zzb> zzaki = new HashMap<>();
    private final com.google.android.gms.common.stats.zzb zzakj = com.google.android.gms.common.stats.zzb.zzrz();
    private final long zzakk = 5000;
    private final Context zzrI;

    private static final class zza {
        private final String zzRA;
        private final ComponentName zzakl;

        public zza(ComponentName componentName) {
            this.zzRA = null;
            this.zzakl = (ComponentName) zzx.zzy(componentName);
        }

        public zza(String str) {
            this.zzRA = zzx.zzcG(str);
            this.zzakl = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return zzw.equal(this.zzRA, zzaVar.zzRA) && zzw.equal(this.zzakl, zzaVar.zzakl);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzRA, this.zzakl);
        }

        public String toString() {
            return this.zzRA == null ? this.zzakl.flattenToString() : this.zzRA;
        }

        public Intent zzqC() {
            return this.zzRA != null ? new Intent(this.zzRA).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzakl);
        }
    }

    private final class zzb {
        private IBinder zzaiT;
        private ComponentName zzakl;
        private boolean zzako;
        private final zza zzakp;
        private final zza zzakm = new zza();
        private final Set<ServiceConnection> zzakn = new HashSet();
        private int mState = 2;

        public class zza implements ServiceConnection {
            public zza() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzm.this.zzaki) {
                    zzb.this.zzaiT = iBinder;
                    zzb.this.zzakl = componentName;
                    Iterator it = zzb.this.zzakn.iterator();
                    while (it.hasNext()) {
                        ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                    }
                    zzb.this.mState = 1;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzm.this.zzaki) {
                    zzb.this.zzaiT = null;
                    zzb.this.zzakl = componentName;
                    Iterator it = zzb.this.zzakn.iterator();
                    while (it.hasNext()) {
                        ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zzaVar) {
            this.zzakp = zzaVar;
        }

        public IBinder getBinder() {
            return this.zzaiT;
        }

        public ComponentName getComponentName() {
            return this.zzakl;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzako;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzm.this.zzakj.zza(zzm.this.zzrI, serviceConnection, str, this.zzakp.zzqC());
            this.zzakn.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzakn.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzm.this.zzakj.zzb(zzm.this.zzrI, serviceConnection);
            this.zzakn.remove(serviceConnection);
        }

        public void zzcB(String str) {
            this.mState = 3;
            this.zzako = zzm.this.zzakj.zza(zzm.this.zzrI, str, this.zzakp.zzqC(), this.zzakm, 129);
            if (this.zzako) {
                return;
            }
            this.mState = 2;
            try {
                zzm.this.zzakj.zza(zzm.this.zzrI, this.zzakm);
            } catch (IllegalArgumentException e2) {
            }
        }

        public void zzcC(String str) {
            zzm.this.zzakj.zza(zzm.this.zzrI, this.zzakm);
            this.zzako = false;
            this.mState = 2;
        }

        public boolean zzqD() {
            return this.zzakn.isEmpty();
        }
    }

    zzm(Context context) {
        this.zzrI = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
    }

    private boolean zza(zza zzaVar, ServiceConnection serviceConnection, String str) {
        boolean zIsBound;
        zzx.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzaki) {
            zzb zzbVar = this.zzaki.get(zzaVar);
            if (zzbVar != null) {
                this.mHandler.removeMessages(0, zzbVar);
                if (!zzbVar.zza(serviceConnection)) {
                    zzbVar.zza(serviceConnection, str);
                    switch (zzbVar.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzbVar.getComponentName(), zzbVar.getBinder());
                            break;
                        case 2:
                            zzbVar.zzcB(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzaVar);
                }
            } else {
                zzbVar = new zzb(zzaVar);
                zzbVar.zza(serviceConnection, str);
                zzbVar.zzcB(str);
                this.zzaki.put(zzaVar, zzbVar);
            }
            zIsBound = zzbVar.isBound();
        }
        return zIsBound;
    }

    private void zzb(zza zzaVar, ServiceConnection serviceConnection, String str) {
        zzx.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzaki) {
            zzb zzbVar = this.zzaki.get(zzaVar);
            if (zzbVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zzaVar);
            }
            if (!zzbVar.zza(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzaVar);
            }
            zzbVar.zzb(serviceConnection, str);
            if (zzbVar.zzqD()) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzbVar), this.zzakk);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb zzbVar = (zzb) message.obj;
                synchronized (this.zzaki) {
                    if (zzbVar.zzqD()) {
                        if (zzbVar.isBound()) {
                            zzbVar.zzcC("GmsClientSupervisor");
                        }
                        this.zzaki.remove(zzbVar.zzakp);
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zzl
    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzl
    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    @Override // com.google.android.gms.common.internal.zzl
    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzl
    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
