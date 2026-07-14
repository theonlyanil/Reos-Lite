package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GeofencingEvent {
    private final int zzFt;
    private final int zzaKW;
    private final List<Geofence> zzaKX;
    private final Location zzaKY;

    private GeofencingEvent(int i, int i2, List<Geofence> list, Location location) {
        this.zzFt = i;
        this.zzaKW = i2;
        this.zzaKX = list;
        this.zzaKY = location;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return new GeofencingEvent(intent.getIntExtra("gms_error_code", -1), zzy(intent), zzz(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int zzy(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra == -1) {
            return -1;
        }
        if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
            return intExtra;
        }
        return -1;
    }

    private static List<Geofence> zzz(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ParcelableGeofence.zzo((byte[]) it.next()));
        }
        return arrayList2;
    }

    public int getErrorCode() {
        return this.zzFt;
    }

    public int getGeofenceTransition() {
        return this.zzaKW;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.zzaKX;
    }

    public Location getTriggeringLocation() {
        return this.zzaKY;
    }

    public boolean hasError() {
        return this.zzFt != -1;
    }
}
