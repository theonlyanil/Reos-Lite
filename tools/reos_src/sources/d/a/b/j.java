package d.a.b;

import d.ab;
import d.z;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f6152a = d.a.h.a().b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6153b = f6152a + "-Sent-Millis";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6154c = f6152a + "-Received-Millis";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6155d = f6152a + "-Selected-Protocol";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6156e = f6152a + "-Response-Source";

    public static long a(ab abVar) {
        return a(abVar.g());
    }

    public static long a(d.r rVar) {
        return b(rVar.a("Content-Length"));
    }

    public static long a(z zVar) {
        return a(zVar.c());
    }

    public static d.r a(d.r rVar, d.r rVar2) {
        Set<String> setC = c(rVar2);
        if (setC.isEmpty()) {
            return new d.r.a().a();
        }
        d.r.a aVar = new d.r.a();
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = rVar.a(i);
            if (setC.contains(strA)) {
                aVar.a(strA, rVar.b(i));
            }
        }
        return aVar.a();
    }

    public static boolean a(ab abVar, d.r rVar, z zVar) {
        for (String str : d(abVar)) {
            if (!d.a.j.a(rVar.c(str), zVar.b(str))) {
                return false;
            }
        }
        return true;
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static long b(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            return -1L;
        }
    }

    public static boolean b(ab abVar) {
        return b(abVar.g());
    }

    public static boolean b(d.r rVar) {
        return c(rVar).contains("*");
    }

    public static d.r c(ab abVar) {
        return a(abVar.j().a().c(), abVar.g());
    }

    public static Set<String> c(d.r rVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            if ("Vary".equalsIgnoreCase(rVar.a(i))) {
                String strB = rVar.b(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                String[] strArrSplit = strB.split(",");
                for (String str : strArrSplit) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    private static Set<String> d(ab abVar) {
        return c(abVar.g());
    }
}
