package com.a.a.d.b.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bitmap.Config[] f2068a = {Bitmap.Config.ARGB_8888, null};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Bitmap.Config[] f2069b = {Bitmap.Config.RGB_565};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Bitmap.Config[] f2070c = {Bitmap.Config.ARGB_4444};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f2071d = {Bitmap.Config.ALPHA_8};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f2072e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e<a, Bitmap> f2073f = new e<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> g = new HashMap();

    /* JADX INFO: renamed from: com.a.a.d.b.a.i$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2074a = new int[Bitmap.Config.values().length];

        static {
            try {
                f2074a[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2074a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2074a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2074a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f2075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f2077c;

        public a(b bVar) {
            this.f2075a = bVar;
        }

        @Override // com.a.a.d.b.a.h
        public void a() {
            this.f2075a.a(this);
        }

        public void a(int i, Bitmap.Config config) {
            this.f2076b = i;
            this.f2077c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f2076b != aVar.f2076b) {
                return false;
            }
            if (this.f2077c == null) {
                if (aVar.f2077c != null) {
                    return false;
                }
            } else if (!this.f2077c.equals(aVar.f2077c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f2077c != null ? this.f2077c.hashCode() : 0) + (this.f2076b * 31);
        }

        public String toString() {
            return i.b(this.f2076b, this.f2077c);
        }
    }

    static class b extends com.a.a.d.b.a.b<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.a.a.d.b.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(this);
        }

        public a a(int i, Bitmap.Config config) {
            a aVarC = c();
            aVarC.a(i, config);
            return aVarC;
        }
    }

    private a a(a aVar, int i, Bitmap.Config config) {
        for (Bitmap.Config config2 : b(config)) {
            Integer numCeilingKey = a(config2).ceilingKey(Integer.valueOf(i));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i * 8) {
                if (numCeilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return aVar;
                        }
                    } else if (config2.equals(config)) {
                        return aVar;
                    }
                }
                this.f2072e.a(aVar);
                return this.f2072e.a(numCeilingKey.intValue(), config2);
            }
        }
        return aVar;
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.g.put(config, treeMap);
        return treeMap;
    }

    private void a(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMapA = a(config);
        Integer num2 = (Integer) navigableMapA.get(num);
        if (num2.intValue() == 1) {
            navigableMapA.remove(num);
        } else {
            navigableMapA.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        switch (AnonymousClass1.f2074a[config.ordinal()]) {
            case 1:
                return f2068a;
            case 2:
                return f2069b;
            case 3:
                return f2070c;
            case 4:
                return f2071d;
            default:
                return new Bitmap.Config[]{config};
        }
    }

    @Override // com.a.a.d.b.a.g
    public Bitmap a() {
        Bitmap bitmapA = this.f2073f.a();
        if (bitmapA != null) {
            a(Integer.valueOf(com.a.a.j.h.a(bitmapA)), bitmapA.getConfig());
        }
        return bitmapA;
    }

    @Override // com.a.a.d.b.a.g
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        int iA = com.a.a.j.h.a(i, i2, config);
        Bitmap bitmapA = this.f2073f.a(a(this.f2072e.a(iA, config), iA, config));
        if (bitmapA != null) {
            a(Integer.valueOf(com.a.a.j.h.a(bitmapA)), bitmapA.getConfig());
            bitmapA.reconfigure(i, i2, bitmapA.getConfig() != null ? bitmapA.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return bitmapA;
    }

    @Override // com.a.a.d.b.a.g
    public void a(Bitmap bitmap) {
        a aVarA = this.f2072e.a(com.a.a.j.h.a(bitmap), bitmap.getConfig());
        this.f2073f.a(aVarA, bitmap);
        NavigableMap<Integer, Integer> navigableMapA = a(bitmap.getConfig());
        Integer num = (Integer) navigableMapA.get(Integer.valueOf(aVarA.f2076b));
        navigableMapA.put(Integer.valueOf(aVarA.f2076b), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    @Override // com.a.a.d.b.a.g
    public String b(int i, int i2, Bitmap.Config config) {
        return b(com.a.a.j.h.a(i, i2, config), config);
    }

    @Override // com.a.a.d.b.a.g
    public String b(Bitmap bitmap) {
        return b(com.a.a.j.h.a(bitmap), bitmap.getConfig());
    }

    @Override // com.a.a.d.b.a.g
    public int c(Bitmap bitmap) {
        return com.a.a.j.h.a(bitmap);
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f2073f).append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.g.entrySet()) {
            sbAppend.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.g.isEmpty()) {
            sbAppend.replace(sbAppend.length() - 2, sbAppend.length(), "");
        }
        return sbAppend.append(")}").toString();
    }
}
