package com.android.library.rmnlibrary;

import android.app.IntentService;
import android.content.Intent;
import com.android.library.rmnlibrary.b.f;
import com.android.library.rmnlibrary.b.i;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class GCMIntentService extends IntentService {
    public GCMIntentService() {
        super("feisty-tempest-840");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        i.c(new File(i.b()));
        GoogleCloudMessaging.getInstance(this);
        AbstractNotification abstractNotification = (AbstractNotification) intent.getExtras().getParcelable("message");
        if (abstractNotification != null) {
            String notification_type = abstractNotification.getResponse().getNotification_type();
            if (f.c(this)) {
                b.b(this, notification_type, abstractNotification);
            } else {
                b.a(this, abstractNotification.getResponse().getNotifications().get(0).getDeal_id(), "blocked", abstractNotification.getResponse().getNotifications().get(0).getAction1().getPackage_name(), abstractNotification);
            }
        }
    }
}
