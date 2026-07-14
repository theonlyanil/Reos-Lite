package com.flurry.sdk;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class jj implements ll.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static jj f4471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4472b = jj.class.getSimpleName();
    private boolean g;
    private Location h;
    private Location l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4473c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f4474d = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f4475e = 90000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f4476f = 0;
    private long i = 0;
    private boolean m = false;
    private int n = 0;
    private kb<ln> o = new kb<ln>() { // from class: com.flurry.sdk.jj.1
        @Override // com.flurry.sdk.kb
        public void a(ln lnVar) {
            if (jj.this.i <= 0 || jj.this.i >= System.currentTimeMillis()) {
                return;
            }
            kg.a(4, jj.f4472b, "No location received in 90 seconds , stopping LocationManager");
            jj.this.h();
        }
    };
    private LocationManager j = (LocationManager) js.a().c().getSystemService("location");
    private a k = new a();

    class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                jj.this.l = location;
            }
            if (jj.c(jj.this) >= 3) {
                kg.a(4, jj.f4472b, "Max location reports reached, stopping");
                jj.this.h();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private jj() {
        lk lkVarA = lk.a();
        this.g = ((Boolean) lkVarA.a("ReportLocation")).booleanValue();
        lkVarA.a("ReportLocation", (ll.a) this);
        kg.a(4, f4472b, "initSettings, ReportLocation = " + this.g);
        this.h = (Location) lkVarA.a("ExplicitLocation");
        lkVarA.a("ExplicitLocation", (ll.a) this);
        kg.a(4, f4472b, "initSettings, ExplicitLocation = " + this.h);
    }

    public static synchronized jj a() {
        if (f4471a == null) {
            f4471a = new jj();
        }
        return f4471a;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.j.requestLocationUpdates(str, 10000L, BitmapDescriptorFactory.HUE_RED, this.k, Looper.getMainLooper());
    }

    private boolean a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private Location b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.j.getLastKnownLocation(str);
    }

    public static void b() {
        if (f4471a != null) {
            lk.a().b("ReportLocation", (ll.a) f4471a);
            lk.a().b("ExplicitLocation", (ll.a) f4471a);
        }
        f4471a = null;
    }

    private boolean b(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    static /* synthetic */ int c(jj jjVar) {
        int i = jjVar.n + 1;
        jjVar.n = i;
        return i;
    }

    private void g() {
        if (!this.m && this.g && this.h == null) {
            Context contextC = js.a().c();
            if (contextC.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || contextC.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.n = 0;
                String strJ = null;
                if (a(contextC)) {
                    strJ = i();
                } else if (b(contextC)) {
                    strJ = j();
                }
                a(strJ);
                this.l = b(strJ);
                this.i = System.currentTimeMillis() + 90000;
                k();
                this.m = true;
                kg.a(4, f4472b, "LocationProvider started");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.m) {
            this.j.removeUpdates(this.k);
            this.n = 0;
            this.i = 0L;
            l();
            this.m = false;
            kg.a(4, f4472b, "LocationProvider stopped");
        }
    }

    private String i() {
        return "passive";
    }

    private String j() {
        return "network";
    }

    private void k() {
        kg.a(4, f4472b, "Register location timer");
        lo.a().a(this.o);
    }

    private void l() {
        kg.a(4, f4472b, "Unregister location timer");
        lo.a().b(this.o);
    }

    @Override // com.flurry.sdk.ll.a
    public void a(String str, Object obj) {
        switch (str) {
            case "ReportLocation":
                this.g = ((Boolean) obj).booleanValue();
                kg.a(4, f4472b, "onSettingUpdate, ReportLocation = " + this.g);
                break;
            case "ExplicitLocation":
                this.h = (Location) obj;
                kg.a(4, f4472b, "onSettingUpdate, ExplicitLocation = " + this.h);
                break;
            default:
                kg.a(6, f4472b, "LocationProvider internal error! Had to be LocationCriteria, ReportLocation or ExplicitLocation key.");
                break;
        }
    }

    public synchronized void c() {
        kg.a(4, f4472b, "Location update requested");
        if (this.n < 3) {
            g();
        }
    }

    public synchronized void d() {
        kg.a(4, f4472b, "Stop update location requested");
        h();
    }

    public Location e() {
        String strJ;
        Location location = null;
        if (this.h != null) {
            return this.h;
        }
        if (this.g) {
            Context contextC = js.a().c();
            if (!a(contextC) && !b(contextC)) {
                return null;
            }
            if (a(contextC)) {
                strJ = i();
            } else {
                strJ = b(contextC) ? j() : null;
            }
            if (strJ != null) {
                Location locationB = b(strJ);
                if (locationB != null) {
                    this.l = locationB;
                }
                location = this.l;
            }
        }
        kg.a(4, f4472b, "getLocation() = " + location);
        return location;
    }
}
