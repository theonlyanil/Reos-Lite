package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class GcmListenerService extends Service {
    private static boolean zzaIK = false;
    private int zzaII;
    private final Object zzpK = new Object();
    private int zzaIJ = 0;

    private void zzm(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("com.google.android.gms.gcm.PENDING_INTENT");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e2) {
                Log.e("GcmListenerService", "Notification pending intent canceled");
            }
        }
        zza.zzf(this, intent);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.gcm.GcmListenerService$2] */
    private void zzn(final Intent intent) {
        if (Build.VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.google.android.gms.gcm.GcmListenerService.1
                @Override // java.lang.Runnable
                public void run() {
                    GcmListenerService.this.zzo(intent);
                }
            });
        } else {
            new AsyncTask<Void, Void, Void>() { // from class: com.google.android.gms.gcm.GcmListenerService.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    GcmListenerService.this.zzo(intent);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzo(Intent intent) {
        try {
            switch (intent.getAction()) {
                case "com.google.android.c2dm.intent.RECEIVE":
                    zzp(intent);
                    break;
                case "com.google.android.gms.gcm.NOTIFICATION_DISMISS":
                    zza.zzg(this, intent);
                    break;
                default:
                    Log.d("GcmListenerService", "Unknown intent action: " + intent.getAction());
                    break;
            }
            zzxv();
        } finally {
            GcmReceiver.completeWakefulIntent(intent);
        }
    }

    private void zzp(Intent intent) {
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
        }
        switch (stringExtra) {
            case "gcm":
                if (zzr(intent)) {
                    zza.zze(this, intent);
                }
                zzq(intent);
                break;
            case "deleted_messages":
                onDeletedMessages();
                break;
            case "send_event":
                onMessageSent(intent.getStringExtra("google.message_id"));
                break;
            case "send_error":
                onSendError(intent.getStringExtra("google.message_id"), intent.getStringExtra("error"));
                break;
            default:
                Log.w("GcmListenerService", "Received message with unknown type: " + stringExtra);
                break;
        }
    }

    private void zzq(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("message_type");
        extras.remove("android.support.content.wakelockid");
        if (zzb.zzx(extras)) {
            if (!zzb.zzaH(this)) {
                zzb.zzc((Context) this, (Class<? extends GcmListenerService>) getClass()).zzz(extras);
                return;
            } else {
                zzb.zzy(extras);
                if (zzr(intent)) {
                    zza.zzh(this, intent);
                }
            }
        }
        String string = extras.getString("from");
        extras.remove("from");
        onMessageReceived(string, extras);
    }

    static boolean zzr(Intent intent) {
        return zzaIK && !TextUtils.isEmpty(intent.getStringExtra("gcm.a.campaign"));
    }

    static boolean zzw(Bundle bundle) {
        return zzaIK && !TextUtils.isEmpty(bundle.getString("gcm.a.campaign"));
    }

    private void zzxv() {
        synchronized (this.zzpK) {
            this.zzaIJ--;
            if (this.zzaIJ == 0) {
                zzgU(this.zzaII);
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String str, Bundle bundle) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, String str2) {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.zzpK) {
            this.zzaII = i2;
            this.zzaIJ++;
        }
        if (!"com.google.android.gms.gcm.NOTIFICATION_OPEN".equals(intent.getAction())) {
            zzn(intent);
            return 3;
        }
        zzm(intent);
        zzxv();
        GcmReceiver.completeWakefulIntent(intent);
        return 3;
    }

    boolean zzgU(int i) {
        return stopSelfResult(i);
    }
}
