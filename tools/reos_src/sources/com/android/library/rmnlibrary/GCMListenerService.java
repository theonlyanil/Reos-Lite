package com.android.library.rmnlibrary;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.b.m;
import com.android.apps.config.util.CLog;
import com.android.library.rmnlibrary.b.f;
import com.android.library.rmnlibrary.b.h;
import com.google.android.gms.gcm.GcmListenerService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GCMListenerService extends GcmListenerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, List<com.android.library.rmnlibrary.a.a>> f2715a = new HashMap();

    public static void a(String str, com.android.library.rmnlibrary.a.a aVar) {
        List<com.android.library.rmnlibrary.a.a> arrayList = f2715a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(aVar);
        f2715a.put(str, arrayList);
    }

    @Override // com.google.android.gms.gcm.GcmListenerService
    public void onMessageReceived(String str, Bundle bundle) {
        super.onMessageReceived(str, bundle);
        CLog.a("RMNLibrary", bundle.toString());
        String string = bundle.getString("messages");
        CLog.a("RMNLibrary", string);
        AbstractNotification abstractNotification = (AbstractNotification) f.a(string, AbstractNotification.class);
        if (abstractNotification.getResponse().getNotification_type().contains("Silent|")) {
            CLog.b("RMNLibrary", "Silent Notification");
            String str2 = h.a(abstractNotification.getResponse().getNotification_type())[1];
            List<com.android.library.rmnlibrary.a.a> list = f2715a.get(str2);
            if (list != null && !list.isEmpty()) {
                for (com.android.library.rmnlibrary.a.a aVar : list) {
                    if (aVar != null) {
                        aVar.a(str2, string);
                    }
                }
            }
        }
        ComponentName componentName = new ComponentName(getPackageName(), GCMIntentService.class.getName());
        Intent intent = new Intent();
        intent.putExtra("message", abstractNotification);
        m.startWakefulService(getApplicationContext(), intent.setComponent(componentName));
    }
}
