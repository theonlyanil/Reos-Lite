package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class km {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, String> f4582a = new HashMap<>();

    public String a() {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> setEntrySet = this.f4582a.entrySet();
        if (setEntrySet.size() > 0) {
            for (Map.Entry<String, String> entry : setEntrySet) {
                sb.append(lt.c(entry.getKey()));
                sb.append("=");
                sb.append(lt.c(entry.getValue()));
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void a(String str, String str2) {
        if (str == null) {
            return;
        }
        this.f4582a.put(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        km kmVar = (km) obj;
        if (this.f4582a != null) {
            if (this.f4582a.equals(kmVar.f4582a)) {
                return true;
            }
        } else if (kmVar.f4582a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f4582a != null) {
            return this.f4582a.hashCode();
        }
        return 0;
    }
}
