package com.facebook.a;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.b.ad;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.facebook.b.c f3608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3609e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b> f3605a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<b> f3606b = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3610f = 1000;

    public k(com.facebook.b.c cVar, String str) {
        this.f3608d = cVar;
        this.f3609e = str;
    }

    private void a(GraphRequest graphRequest, Context context, int i, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        try {
            jSONObject = com.facebook.b.b.a(com.facebook.b.b.a.CUSTOM_APP_EVENTS, this.f3608d, this.f3609e, z, context);
            if (this.f3607c > 0) {
                jSONObject.put("num_skipped_events", i);
            }
        } catch (JSONException e2) {
            jSONObject = new JSONObject();
        }
        graphRequest.a(jSONObject);
        Bundle bundleE = graphRequest.e();
        if (bundleE == null) {
            bundleE = new Bundle();
        }
        String string = jSONArray.toString();
        if (string != null) {
            bundleE.putByteArray("custom_events_file", a(string));
            graphRequest.a((Object) string);
        }
        graphRequest.a(bundleE);
    }

    private byte[] a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            ad.a("Encoding exception: ", (Exception) e2);
            return null;
        }
    }

    public synchronized int a() {
        return this.f3605a.size();
    }

    public int a(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        synchronized (this) {
            int i = this.f3607c;
            this.f3606b.addAll(this.f3605a);
            this.f3605a.clear();
            JSONArray jSONArray = new JSONArray();
            for (b bVar : this.f3606b) {
                if (!bVar.d()) {
                    ad.a("Event with invalid checksum: %s", bVar.toString());
                } else if (z || !bVar.b()) {
                    jSONArray.put(bVar.c());
                }
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
            a(graphRequest, context, i, jSONArray, z2);
            return jSONArray.length();
        }
    }

    public synchronized void a(b bVar) {
        if (this.f3605a.size() + this.f3606b.size() >= 1000) {
            this.f3607c++;
        } else {
            this.f3605a.add(bVar);
        }
    }

    public synchronized void a(boolean z) {
        if (z) {
            this.f3605a.addAll(this.f3606b);
        }
        this.f3606b.clear();
        this.f3607c = 0;
    }

    public synchronized List<b> b() {
        List<b> list;
        list = this.f3605a;
        this.f3605a = new ArrayList();
        return list;
    }
}
