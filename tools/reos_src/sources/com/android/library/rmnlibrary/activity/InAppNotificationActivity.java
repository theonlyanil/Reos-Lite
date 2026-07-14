package com.android.library.rmnlibrary.activity;

import android.app.Activity;
import android.os.Bundle;
import com.android.library.rmnlibrary.a;
import com.google.android.gms.location.places.Place;

/* JADX INFO: loaded from: classes.dex */
public class InAppNotificationActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(Place.TYPE_SUBLOCALITY_LEVEL_2, Place.TYPE_SUBLOCALITY_LEVEL_2);
        setContentView(a.c.activity_in_app_notifications);
    }
}
