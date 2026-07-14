package com.a.a.d.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f2190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f2191d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f2192a = System.getProperty("http.agent");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Map<String, List<i>> f2193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2194c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2195d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<String, List<i>> f2196e = f2193b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2197f = this.f2196e.containsKey(f2192a);

        static {
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(f2192a)) {
                map.put("User-Agent", Collections.singletonList(new b(f2192a)));
            }
            map.put("Accept-Encoding", Collections.singletonList(new b("identity")));
            f2193b = Collections.unmodifiableMap(map);
        }

        public j a() {
            this.f2194c = true;
            return new j(this.f2196e);
        }
    }

    static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2198a;

        b(String str) {
            this.f2198a = str;
        }

        @Override // com.a.a.d.c.i
        public String a() {
            return this.f2198a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f2198a.equals(((b) obj).f2198a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2198a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f2198a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f2190c = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f2190c.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<i> value = entry.getValue();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < value.size()) {
                    sb.append(value.get(i2).a());
                    if (i2 != value.size() - 1) {
                        sb.append(',');
                    }
                    i = i2 + 1;
                }
            }
            map.put(entry.getKey(), sb.toString());
        }
        return map;
    }

    @Override // com.a.a.d.c.e
    public Map<String, String> a() {
        if (this.f2191d == null) {
            synchronized (this) {
                if (this.f2191d == null) {
                    this.f2191d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f2191d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f2190c.equals(((j) obj).f2190c);
        }
        return false;
    }

    public int hashCode() {
        return this.f2190c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f2190c + '}';
    }
}
