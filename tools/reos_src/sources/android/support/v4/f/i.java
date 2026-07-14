package android.support.v4.f;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
class i {
    public static void a() {
        Trace.endSection();
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }
}
