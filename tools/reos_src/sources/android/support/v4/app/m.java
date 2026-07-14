package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f661b;

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (!f661b) {
            try {
                f660a = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                f660a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("BundleCompatDonut", "Failed to retrieve putIBinder method", e2);
            }
            f661b = true;
        }
        if (f660a != null) {
            try {
                f660a.invoke(bundle, str, iBinder);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                Log.i("BundleCompatDonut", "Failed to invoke putIBinder via reflection", e3);
                f660a = null;
            }
        }
    }
}
