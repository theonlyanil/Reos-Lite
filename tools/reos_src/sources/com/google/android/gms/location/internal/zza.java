package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

/* JADX INFO: loaded from: classes.dex */
public class zza implements ActivityRecognitionApi {

    /* JADX INFO: renamed from: com.google.android.gms.location.internal.zza$zza, reason: collision with other inner class name */
    private static abstract class AbstractC0121zza extends ActivityRecognition.zza<Status> {
        public AbstractC0121zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new AbstractC0121zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zza.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(pendingIntent);
                zzb(Status.zzaeX);
            }
        });
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, final long j, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new AbstractC0121zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zza.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(j, pendingIntent);
                zzb(Status.zzaeX);
            }
        });
    }
}
