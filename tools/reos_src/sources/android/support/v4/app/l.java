package android.support.v4.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            n.a(bundle, str, iBinder);
        } else {
            m.a(bundle, str, iBinder);
        }
    }
}
