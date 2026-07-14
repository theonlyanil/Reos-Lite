package com.flurry.sdk;

/* JADX INFO: loaded from: classes.dex */
public class md {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4746a = md.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4747b;

    public static synchronized void a() {
        if (!f4747b) {
            ki.a(je.class, 10);
            try {
                ki.a(hl.class, 10);
            } catch (NoClassDefFoundError e2) {
                kg.a(3, f4746a, "Analytics module not available");
            }
            try {
                ki.a(mb.class, 10);
            } catch (NoClassDefFoundError e3) {
                kg.a(3, f4746a, "Crash module not available");
            }
            try {
                ki.a(i.class, 10);
            } catch (NoClassDefFoundError e4) {
                kg.a(3, f4746a, "Ads module not available");
            }
            f4747b = true;
        }
    }
}
