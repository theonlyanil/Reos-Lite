package android.support.v7.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f1158a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocationManager f1160c;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f1163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f1164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f1165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f1166f;

        private a() {
        }
    }

    r(Context context) {
        this.f1159b = context;
        this.f1160c = (LocationManager) context.getSystemService("location");
    }

    private Location a(String str) {
        if (this.f1160c != null) {
            try {
                if (this.f1160c.isProviderEnabled(str)) {
                    return this.f1160c.getLastKnownLocation(str);
                }
            } catch (Exception e2) {
                Log.d("TwilightManager", "Failed to get last known location", e2);
            }
        }
        return null;
    }

    private void a(Location location) {
        long j;
        long j2;
        a aVar = f1158a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        q qVarA = q.a();
        qVarA.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = qVarA.f1155a;
        qVarA.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = qVarA.f1157c == 1;
        long j4 = qVarA.f1156b;
        long j5 = qVarA.f1155a;
        qVarA.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = qVarA.f1156b;
        if (j4 == -1 || j5 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j5) {
                j2 = 0 + j6;
            } else {
                j2 = jCurrentTimeMillis > j4 ? 0 + j5 : 0 + j4;
            }
            j = j2 + 60000;
        }
        aVar.f1161a = z;
        aVar.f1162b = j3;
        aVar.f1163c = j4;
        aVar.f1164d = j5;
        aVar.f1165e = j6;
        aVar.f1166f = j;
    }

    private boolean a(a aVar) {
        return aVar != null && aVar.f1166f > System.currentTimeMillis();
    }

    private Location b() {
        Location locationA = android.support.v4.b.l.a(this.f1159b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location locationA2 = android.support.v4.b.l.a(this.f1159b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        if (locationA2 != null && locationA != null) {
            return locationA2.getTime() > locationA.getTime() ? locationA2 : locationA;
        }
        if (locationA2 == null) {
            locationA2 = locationA;
        }
        return locationA2;
    }

    boolean a() {
        a aVar = f1158a;
        if (a(aVar)) {
            return aVar.f1161a;
        }
        Location locationB = b();
        if (locationB != null) {
            a(locationB);
            return aVar.f1161a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
