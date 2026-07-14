package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzrn implements Moments {

    private static abstract class zza extends Plus.zza<Moments.LoadMomentsResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzbb, reason: merged with bridge method [inline-methods] */
        public Moments.LoadMomentsResult zzc(final Status status) {
            return new Moments.LoadMomentsResult() { // from class: com.google.android.gms.internal.zzrn.zza.1
                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getNextPageToken() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getUpdated() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class zzb extends Plus.zza<Status> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static abstract class zzc extends Plus.zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzrn.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zzeVar.zzl(this);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient, final int i, final String str, final Uri uri, final String str2, final String str3) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzrn.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zzeVar.zza(this, i, str, uri, str2, str3);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzrn.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zzeVar.zzeS(str);
                zzb(Status.zzaeX);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzrn.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zzeVar.zza(this, moment);
            }
        });
    }
}
