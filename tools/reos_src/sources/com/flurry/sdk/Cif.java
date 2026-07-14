package com.flurry.sdk;

import android.location.Location;
import java.util.Map;

/* JADX INFO: renamed from: com.flurry.sdk.if, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public class Cif extends kl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4274a = Cif.class.getSimpleName();

    private String a(String str, String str2, Map<String, String> map) {
        if (a("timestamp_epoch_millis", str2)) {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            kg.a(3, f4274a, "Replacing param timestamp_epoch_millis with: " + strValueOf);
            return str.replace(str2, lt.c(strValueOf));
        }
        if (a("session_duration_millis", str2)) {
            String string = Long.toString(je.a().f());
            kg.a(3, f4274a, "Replacing param session_duration_millis with: " + string);
            return str.replace(str2, lt.c(string));
        }
        if (a("fg_timespent_millis", str2)) {
            String string2 = Long.toString(je.a().f());
            kg.a(3, f4274a, "Replacing param fg_timespent_millis with: " + string2);
            return str.replace(str2, lt.c(string2));
        }
        if (a("install_referrer", str2)) {
            String strB = new hm().b();
            if (strB == null) {
                strB = "";
            }
            kg.a(3, f4274a, "Replacing param install_referrer with: " + strB);
            return str.replace(str2, lt.c(strB));
        }
        if (a("geo_latitude", str2)) {
            Location locationE = jj.a().e();
            String str3 = locationE != null ? "" + lt.a(locationE.getLatitude(), 3) : "";
            kg.a(3, f4274a, "Replacing param geo_latitude with: " + str3);
            return str.replace(str2, lt.c(str3));
        }
        if (a("geo_longitude", str2)) {
            Location locationE2 = jj.a().e();
            String str4 = locationE2 != null ? "" + lt.a(locationE2.getLongitude(), 3) : "";
            kg.a(3, f4274a, "Replacing param geo_longitude with: " + str4);
            return str.replace(str2, lt.c(str4));
        }
        if (a("publisher_user_id", str2)) {
            String str5 = (String) lk.a().a("UserId");
            kg.a(3, f4274a, "Replacing param publisher_user_id with: " + str5);
            return str.replace(str2, lt.c(str5));
        }
        if (a("event_name", str2)) {
            if (map == null || !map.containsKey("event_name")) {
                kg.a(3, f4274a, "Replacing param event_name with empty string");
                return str.replace(str2, "");
            }
            kg.a(3, f4274a, "Replacing param event_name with: " + map.get("event_name"));
            return str.replace(str2, lt.c(map.get("event_name")));
        }
        if (!a("event_time_millis", str2)) {
            kg.a(3, f4274a, "Unknown param: " + str2);
            return str.replace(str2, "");
        }
        if (map == null || !map.containsKey("event_time_millis")) {
            kg.a(3, f4274a, "Replacing param event_time_millis with empty string");
            return str.replace(str2, "");
        }
        kg.a(3, f4274a, "Replacing param event_time_millis with: " + map.get("event_time_millis"));
        return str.replace(str2, lt.c(map.get("event_time_millis")));
    }

    public String a(String str, Map<String, String> map) {
        String strA = a(str);
        while (strA != null) {
            str = a(str, strA, map);
            strA = a(str);
        }
        return str;
    }
}
