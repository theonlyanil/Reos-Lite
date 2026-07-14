package com.android.library.http;

import android.app.IntentService;
import android.content.Intent;
import com.android.apps.config.util.CLog;
import com.android.library.http.d.c;
import com.android.library.http.d.e;
import com.android.library.http.d.f;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HTTPLibraryAlarmSchedulingService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.android.library.http.a.a f2678a;

    public HTTPLibraryAlarmSchedulingService() {
        super("SchedulingService");
    }

    private void a(com.android.library.http.a.a.EnumC0048a enumC0048a) {
        if (c.a(this)) {
            this.f2678a = com.android.library.http.a.a.a(this);
            for (Map.Entry<String, ArrayList<com.android.library.http.a.b>> entry : this.f2678a.a(enumC0048a).entrySet()) {
                String key = entry.getKey();
                for (com.android.library.http.a.b bVar : entry.getValue()) {
                    ArrayList<String> arrayListC = bVar.c();
                    JSONObject jSONObjectB = bVar.b();
                    CLog.b("HTTPLibrary", " *** ALARM POST OFFLINE URL *** " + key);
                    CLog.b("HTTPLibrary", " *** ALARM POST OFFLINE JSONOBJECT *** " + jSONObjectB.toString());
                    HTTPLibrary.a(this, arrayListC, key, jSONObjectB, 0, 10, enumC0048a);
                }
            }
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        CLog.b("HTTPLibrary", " $$$ ALARM INITIATED $$$");
        com.android.library.http.a.a.EnumC0048a enumC0048a = (com.android.library.http.a.a.EnumC0048a) intent.getSerializableExtra("com.android.library.httplibrary.SEND_MODE");
        if (enumC0048a != com.android.library.http.a.a.EnumC0048a.BATCH) {
            a(enumC0048a);
            return;
        }
        if (f.b(e.c(this), System.currentTimeMillis()) < com.android.library.http.d.a.b(this)) {
            com.android.library.http.a.a.a(this);
            if (!com.android.library.http.a.a.b(this)) {
                return;
            }
        }
        a(enumC0048a);
    }
}
