package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ju {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ju f4523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4524b = ju.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<String, Map<String, String>> f4525c = new HashMap<>();

    public static synchronized ju a() {
        if (f4523a == null) {
            f4523a = new ju();
        }
        return f4523a;
    }

    public static synchronized void b() {
        f4523a = null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e A[Catch: all -> 0x0069, TRY_ENTER, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0010, B:11:0x002e, B:12:0x0035, B:22:0x0068, B:13:0x0036, B:15:0x003e, B:17:0x0046, B:18:0x0064, B:26:0x006c, B:27:0x0071), top: B:32:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x006c A[Catch: all -> 0x0066, TRY_ENTER, TryCatch #0 {, blocks: (B:13:0x0036, B:15:0x003e, B:17:0x0046, B:18:0x0064, B:26:0x006c, B:27:0x0071), top: B:30:0x0036, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0010 A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0010, B:11:0x002e, B:12:0x0035, B:22:0x0068, B:13:0x0036, B:15:0x003e, B:17:0x0046, B:18:0x0064, B:26:0x006c, B:27:0x0071), top: B:32:0x0005, inners: #0 }] */
    public synchronized void a(String str, String str2, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
            if (map.size() >= 10) {
                kg.e(f4524b, "MaxOriginParams exceeded: " + map.size());
            } else {
                map.put("flurryOriginVersion", str2);
                synchronized (f4525c) {
                    if (f4525c.size() >= 10 || f4525c.containsKey(str)) {
                        f4525c.put(str, map);
                    } else {
                        kg.e(f4524b, "MaxOrigins exceeded: " + f4525c.size());
                    }
                }
            }
        } else if (map.size() >= 10) {
            kg.e(f4524b, "MaxOriginParams exceeded: " + map.size());
        } else {
            map.put("flurryOriginVersion", str2);
            synchronized (f4525c) {
                if (f4525c.size() >= 10) {
                    f4525c.put(str, map);
                } else {
                    f4525c.put(str, map);
                }
            }
        }
        throw th;
    }

    public synchronized HashMap<String, Map<String, String>> c() {
        HashMap<String, Map<String, String>> map;
        synchronized (f4525c) {
            map = new HashMap<>(f4525c);
        }
        return map;
    }
}
