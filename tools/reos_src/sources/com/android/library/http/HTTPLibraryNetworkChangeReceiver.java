package com.android.library.http;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.apps.config.util.CLog;
import com.android.library.http.d.c;
import com.android.library.http.d.e;
import com.android.library.http.d.f;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HTTPLibraryNetworkChangeReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.android.library.http.a.a f2679a;

    private void a(Context context, com.android.library.http.a.a.EnumC0048a enumC0048a) {
        if (c.a(context)) {
            CLog.b("HTTPLibrary", " $$$ NETWORK CHANGE RECEIVER INITIATED $$$");
            this.f2679a = com.android.library.http.a.a.a(context);
            for (Map.Entry<String, ArrayList<com.android.library.http.a.b>> entry : this.f2679a.a(enumC0048a).entrySet()) {
                String key = entry.getKey();
                for (com.android.library.http.a.b bVar : entry.getValue()) {
                    ArrayList<String> arrayListC = bVar.c();
                    JSONObject jSONObjectB = bVar.b();
                    CLog.b("HTTPLibrary", " *** NETWORK CHANGE POST URL *** " + key);
                    CLog.b("HTTPLibrary", " *** NETWORK CHANGE POST JSON ***" + jSONObjectB.toString());
                    HTTPLibrary.a(context, arrayListC, key, jSONObjectB, 0, 10, enumC0048a);
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        CLog.b("HTTPLibrary", "$$$ LAST SYNCED OFFLINE DATA MILLIS $$$ " + f.a(e.d(context)));
        if (f.a(e.d(context), jCurrentTimeMillis) >= com.android.library.http.d.a.c(context)) {
            a(context, com.android.library.http.a.a.EnumC0048a.NORMAL);
        }
        if (f.b(e.c(context), jCurrentTimeMillis) < com.android.library.http.d.a.b(context)) {
            com.android.library.http.a.a.a(context);
            if (!com.android.library.http.a.a.b(context)) {
                return;
            }
        }
        a(context, com.android.library.http.a.a.EnumC0048a.BATCH);
    }
}
