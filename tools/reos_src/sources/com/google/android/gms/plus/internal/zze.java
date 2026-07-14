package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zze extends zzj<com.google.android.gms.plus.internal.zzd> {
    private Person zzaYV;
    private final PlusSession zzaYW;

    static final class zza implements Moments.LoadMomentsResult {
        private final Status zzTA;
        private final String zzaYX;
        private final String zzaYY;
        private final MomentBuffer zzaYZ;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzTA = status;
            this.zzaYX = str;
            this.zzaYY = str2;
            this.zzaYZ = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
        public MomentBuffer getMomentBuffer() {
            return this.zzaYZ;
        }

        @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
        public String getNextPageToken() {
            return this.zzaYX;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzTA;
        }

        @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
        public String getUpdated() {
            return this.zzaYY;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaYZ != null) {
                this.zzaYZ.release();
            }
        }
    }

    static final class zzb implements People.LoadPeopleResult {
        private final Status zzTA;
        private final String zzaYX;
        private final PersonBuffer zzaZa;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzTA = status;
            this.zzaYX = str;
            this.zzaZa = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        @Override // com.google.android.gms.plus.People.LoadPeopleResult
        public String getNextPageToken() {
            return this.zzaYX;
        }

        @Override // com.google.android.gms.plus.People.LoadPeopleResult
        public PersonBuffer getPersonBuffer() {
            return this.zzaZa;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzTA;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaZa != null) {
                this.zzaZa.release();
            }
        }
    }

    static final class zzc extends com.google.android.gms.plus.internal.zza {
        private final zzlx.zzb<Status> zzaLZ;

        public zzc(zzlx.zzb<Status> zzbVar) {
            this.zzaLZ = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void zzba(Status status) {
            this.zzaLZ.zzr(status);
        }
    }

    static final class zzd extends com.google.android.gms.plus.internal.zza {
        private final zzlx.zzb<Moments.LoadMomentsResult> zzaLZ;

        public zzd(zzlx.zzb<Moments.LoadMomentsResult> zzbVar) {
            this.zzaLZ = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzpH() != null ? (PendingIntent) dataHolder.zzpH().getParcelable("pendingIntent") : null);
            if (!status.isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaLZ.zzr(new zza(status, dataHolder, str, str2));
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.plus.internal.zze$zze, reason: collision with other inner class name */
    static final class BinderC0185zze extends com.google.android.gms.plus.internal.zza {
        private final zzlx.zzb<People.LoadPeopleResult> zzaLZ;

        public BinderC0185zze(zzlx.zzb<People.LoadPeopleResult> zzbVar) {
            this.zzaLZ = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzpH() != null ? (PendingIntent) dataHolder.zzpH().getParcelable("pendingIntent") : null);
            if (!status.isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaLZ.zzr(new zzb(status, dataHolder, str));
        }
    }

    static final class zzf extends com.google.android.gms.plus.internal.zza {
        private final zzlx.zzb<Status> zzaLZ;

        public zzf(zzlx.zzb<Status> zzbVar) {
            this.zzaLZ = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void zzi(int i, Bundle bundle) {
            this.zzaLZ.zzr(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, PlusSession plusSession, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaYW = plusSession;
    }

    public static boolean zzd(Set<Scope> set) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        return (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    private Bundle zzlV() {
        Bundle bundleZzDp = this.zzaYW.zzDp();
        bundleZzDp.putStringArray("request_visible_actions", this.zzaYW.zzDj());
        bundleZzDp.putString("auth_package", this.zzaYW.zzDl());
        return bundleZzDp;
    }

    public String getAccountName() {
        zzqr();
        try {
            return zzqs().getAccountName();
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void zzDd() {
        zzqr();
        try {
            this.zzaYV = null;
            zzqs().zzDd();
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public Person zzDf() {
        zzqr();
        return this.zzaYV;
    }

    public zzq zza(zzlx.zzb<People.LoadPeopleResult> zzbVar, int i, String str) {
        zzqr();
        BinderC0185zze binderC0185zze = new BinderC0185zze(zzbVar);
        try {
            return zzqs().zza(binderC0185zze, 1, i, -1, str);
        } catch (RemoteException e2) {
            binderC0185zze.zza(DataHolder.zzbJ(8), (String) null);
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzaYV = PersonEntity.zzu(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(zzlx.zzb<Moments.LoadMomentsResult> zzbVar, int i, String str, Uri uri, String str2, String str3) {
        zzqr();
        zzd zzdVar = zzbVar != null ? new zzd(zzbVar) : null;
        try {
            zzqs().zza(zzdVar, i, str, uri, str2, str3);
        } catch (RemoteException e2) {
            zzdVar.zza(DataHolder.zzbJ(8), (String) null, (String) null);
        }
    }

    public void zza(zzlx.zzb<Status> zzbVar, Moment moment) {
        zzqr();
        zzc zzcVar = zzbVar != null ? new zzc(zzbVar) : null;
        try {
            zzqs().zza(zzcVar, SafeParcelResponse.zza((MomentEntity) moment));
        } catch (RemoteException e2) {
            if (zzcVar == null) {
                throw new IllegalStateException(e2);
            }
            zzcVar.zzba(new Status(8, null, null));
        }
    }

    public void zza(zzlx.zzb<People.LoadPeopleResult> zzbVar, Collection<String> collection) {
        zzqr();
        BinderC0185zze binderC0185zze = new BinderC0185zze(zzbVar);
        try {
            zzqs().zza(binderC0185zze, new ArrayList(collection));
        } catch (RemoteException e2) {
            binderC0185zze.zza(DataHolder.zzbJ(8), (String) null);
        }
    }

    public void zzd(zzlx.zzb<People.LoadPeopleResult> zzbVar, String[] strArr) {
        zza(zzbVar, Arrays.asList(strArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzdN, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.plus.internal.zzd zzW(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzdM(iBinder);
    }

    public void zzeS(String str) {
        zzqr();
        try {
            zzqs().zzeS(str);
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.plus.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void zzl(zzlx.zzb<Moments.LoadMomentsResult> zzbVar) {
        zza(zzbVar, 20, null, null, null, "me");
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzlU() {
        return zzlV();
    }

    public void zzm(zzlx.zzb<People.LoadPeopleResult> zzbVar) {
        zzqr();
        BinderC0185zze binderC0185zze = new BinderC0185zze(zzbVar);
        try {
            zzqs().zza(binderC0185zze, 2, 1, -1, null);
        } catch (RemoteException e2) {
            binderC0185zze.zza(DataHolder.zzbJ(8), (String) null);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmn() {
        return zzd(zzqq().zzb(Plus.API));
    }

    public void zzn(zzlx.zzb<Status> zzbVar) {
        zzqr();
        zzDd();
        zzf zzfVar = new zzf(zzbVar);
        try {
            zzqs().zzb(zzfVar);
        } catch (RemoteException e2) {
            zzfVar.zzi(8, null);
        }
    }

    public zzq zzq(zzlx.zzb<People.LoadPeopleResult> zzbVar, String str) {
        return zza(zzbVar, 0, str);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzqt() {
        return zzlV();
    }
}
