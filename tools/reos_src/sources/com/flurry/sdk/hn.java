package com.flurry.sdk;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class hn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4217a = hn.class.getSimpleName();

    public Map<String, List<String>> a(String str) {
        kg.a(3, f4217a, "Parsing referrer map");
        if (str == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        String[] strArrSplit = str.split("&");
        int length = strArrSplit.length;
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("=");
            if (strArrSplit2.length != 2) {
                kg.a(5, f4217a, "Invalid referrer Element: " + str2 + " in referrer tag " + str);
            } else {
                String strDecode = URLDecoder.decode(strArrSplit2[0]);
                String strDecode2 = URLDecoder.decode(strArrSplit2[1]);
                if (map.get(strDecode) == null) {
                    map.put(strDecode, new ArrayList());
                }
                ((List) map.get(strDecode)).add(strDecode2);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            kg.a(3, f4217a, "entry: " + ((String) entry.getKey()) + "=" + entry.getValue());
        }
        StringBuilder sb = new StringBuilder();
        if (map.get("utm_source") == null) {
            sb.append("Campaign Source is missing.\n");
        }
        if (map.get("utm_medium") == null) {
            sb.append("Campaign Medium is missing.\n");
        }
        if (map.get("utm_campaign") == null) {
            sb.append("Campaign Name is missing.\n");
        }
        if (sb.length() > 0) {
            kg.a(5, f4217a, "Detected missing referrer keys : " + sb.toString());
        }
        return map;
    }
}
