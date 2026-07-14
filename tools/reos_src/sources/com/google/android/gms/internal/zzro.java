package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class zzro implements People {

    private static abstract class zza extends Plus.zza<People.LoadPeopleResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzbc, reason: merged with bridge method [inline-methods] */
        public People.LoadPeopleResult zzc(final Status status) {
            return new People.LoadPeopleResult() { // from class: com.google.android.gms.internal.zzro.zza.1
                @Override // com.google.android.gms.plus.People.LoadPeopleResult
                public String getNextPageToken() {
                    return null;
                }

                @Override // com.google.android.gms.plus.People.LoadPeopleResult
                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    @Override // com.google.android.gms.plus.People
    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzDf();
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> collection) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzro.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zzeVar.zza(this, collection);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... strArr) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzro.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zzeVar.zzd(this, strArr);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzro.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zzeVar.zzm(this);
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int i, final String str) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzro.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zza(zzeVar.zza(this, i, str));
            }
        });
    }

    @Override // com.google.android.gms.plus.People
    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzro.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) {
                zza(zzeVar.zzq(this, str));
            }
        });
    }
}
