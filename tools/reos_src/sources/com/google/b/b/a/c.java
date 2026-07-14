package com.google.b.b.a;

import android.content.Intent;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final Map<String, Set<com.google.b.a>> i;
    private static final Pattern g = Pattern.compile(",");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Set<com.google.b.a> f5412c = EnumSet.of(com.google.b.a.QR_CODE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Set<com.google.b.a> f5413d = EnumSet.of(com.google.b.a.DATA_MATRIX);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Set<com.google.b.a> f5414e = EnumSet.of(com.google.b.a.AZTEC);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Set<com.google.b.a> f5415f = EnumSet.of(com.google.b.a.PDF_417);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Set<com.google.b.a> f5410a = EnumSet.of(com.google.b.a.UPC_A, com.google.b.a.UPC_E, com.google.b.a.EAN_13, com.google.b.a.EAN_8, com.google.b.a.RSS_14, com.google.b.a.RSS_EXPANDED);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Set<com.google.b.a> f5411b = EnumSet.of(com.google.b.a.CODE_39, com.google.b.a.CODE_93, com.google.b.a.CODE_128, com.google.b.a.ITF, com.google.b.a.CODABAR);
    private static final Set<com.google.b.a> h = EnumSet.copyOf((Collection) f5410a);

    static {
        h.addAll(f5411b);
        i = new HashMap();
        i.put("ONE_D_MODE", h);
        i.put("PRODUCT_MODE", f5410a);
        i.put("QR_CODE_MODE", f5412c);
        i.put("DATA_MATRIX_MODE", f5413d);
        i.put("AZTEC_MODE", f5414e);
        i.put("PDF417_MODE", f5415f);
    }

    public static Set<com.google.b.a> a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return a(stringExtra != null ? Arrays.asList(g.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    private static Set<com.google.b.a> a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(com.google.b.a.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.add(com.google.b.a.valueOf(it.next()));
                }
                return enumSetNoneOf;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (str != null) {
            return i.get(str);
        }
        return null;
    }
}
