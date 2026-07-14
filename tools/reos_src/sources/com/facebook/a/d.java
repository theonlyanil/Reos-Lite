package com.facebook.a;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.b.ad;
import com.facebook.b.v;
import com.facebook.m;
import com.facebook.r;
import com.facebook.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ScheduledFuture f3569d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3566a = d.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f3567b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ScheduledExecutorService f3568c = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Runnable f3570e = new Runnable() { // from class: com.facebook.a.d.1
        @Override // java.lang.Runnable
        public void run() {
            ScheduledFuture unused = d.f3569d = null;
            if (f.a() != f.a.EXPLICIT_ONLY) {
                d.b(g.TIMER);
            }
        }
    };

    d() {
    }

    private static GraphRequest a(final a aVar, final k kVar, boolean z, final i iVar) {
        int iA;
        String strB = aVar.b();
        ad.b bVarA = ad.a(strB, false);
        final GraphRequest graphRequestA = GraphRequest.a((AccessToken) null, String.format("%s/activities", strB), (JSONObject) null, (GraphRequest.b) null);
        Bundle bundleE = graphRequestA.e();
        if (bundleE == null) {
            bundleE = new Bundle();
        }
        bundleE.putString("access_token", aVar.a());
        String strC = f.c();
        if (strC != null) {
            bundleE.putString("device_token", strC);
        }
        graphRequestA.a(bundleE);
        if (bVarA != null && (iA = kVar.a(graphRequestA, m.f(), bVarA.a(), z)) != 0) {
            iVar.f3601a = iA + iVar.f3601a;
            graphRequestA.a(new GraphRequest.b() { // from class: com.facebook.a.d.4
                @Override // com.facebook.GraphRequest.b
                public void a(r rVar) {
                    d.b(aVar, graphRequestA, rVar, kVar, iVar);
                }
            });
            return graphRequestA;
        }
        return null;
    }

    private static i a(g gVar, c cVar) {
        i iVar = new i();
        boolean zB = m.b(m.f());
        ArrayList arrayList = new ArrayList();
        for (a aVar : cVar.a()) {
            GraphRequest graphRequestA = a(aVar, cVar.a(aVar), zB, iVar);
            if (graphRequestA != null) {
                arrayList.add(graphRequestA);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        v.a(u.APP_EVENTS, f3566a, "Flushing %d events due to %s.", Integer.valueOf(iVar.f3601a), gVar.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((GraphRequest) it.next()).i();
        }
        return iVar;
    }

    public static Set<a> a() {
        return f3567b.a();
    }

    public static void a(final a aVar, final b bVar) {
        f3568c.execute(new Runnable() { // from class: com.facebook.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.f3567b.a(aVar, bVar);
                if (f.a() != f.a.EXPLICIT_ONLY && d.f3567b.b() > 100) {
                    d.b(g.EVENT_THRESHOLD);
                } else if (d.f3569d == null) {
                    ScheduledFuture unused = d.f3569d = d.f3568c.schedule(d.f3570e, 15L, TimeUnit.SECONDS);
                }
            }
        });
    }

    public static void a(final g gVar) {
        f3568c.execute(new Runnable() { // from class: com.facebook.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.b(gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar, GraphRequest graphRequest, r rVar, final k kVar, i iVar) {
        String str;
        h hVar;
        String string;
        FacebookRequestError facebookRequestErrorA = rVar.a();
        h hVar2 = h.SUCCESS;
        if (facebookRequestErrorA == null) {
            str = "Success";
            hVar = hVar2;
        } else if (facebookRequestErrorA.b() == -1) {
            str = "Failed: No Connectivity";
            hVar = h.NO_CONNECTIVITY;
        } else {
            str = String.format("Failed:\n  Response: %s\n  Error %s", rVar.toString(), facebookRequestErrorA.toString());
            hVar = h.SERVER_ERROR;
        }
        if (m.a(u.APP_EVENTS)) {
            try {
                string = new JSONArray((String) graphRequest.h()).toString(2);
            } catch (JSONException e2) {
                string = "<Can't encode events for debug logging>";
            }
            v.a(u.APP_EVENTS, f3566a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.a().toString(), str, string);
        }
        kVar.a(facebookRequestErrorA != null);
        if (hVar == h.NO_CONNECTIVITY) {
            m.d().execute(new Runnable() { // from class: com.facebook.a.d.5
                @Override // java.lang.Runnable
                public void run() {
                    e.a(aVar, kVar);
                }
            });
        }
        if (hVar == h.SUCCESS || iVar.f3602b == h.NO_CONNECTIVITY) {
            return;
        }
        iVar.f3602b = hVar;
    }

    static void b(g gVar) {
        f3567b.a(e.a());
        try {
            i iVarA = a(gVar, f3567b);
            if (iVarA != null) {
                Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", iVarA.f3601a);
                intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", iVarA.f3602b);
                android.support.v4.b.j.a(m.f()).a(intent);
            }
        } catch (Exception e2) {
            Log.w(f3566a, "Caught unexpected exception while flushing app events: ", e2);
        }
    }
}
