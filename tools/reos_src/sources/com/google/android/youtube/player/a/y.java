package com.google.android.youtube.player.a;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    private static IBinder a(Class<?> cls, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) throws a {
        try {
            return (IBinder) cls.getConstructor(IBinder.class, IBinder.class, IBinder.class, Boolean.TYPE).newInstance(iBinder, iBinder2, iBinder3, Boolean.valueOf(z));
        } catch (IllegalAccessException e2) {
            String strValueOf = String.valueOf(cls.getName());
            throw new a(strValueOf.length() != 0 ? "Unable to call the default constructor of ".concat(strValueOf) : new String("Unable to call the default constructor of "), e2);
        } catch (InstantiationException e3) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new a(strValueOf2.length() != 0 ? "Unable to instantiate the dynamic class ".concat(strValueOf2) : new String("Unable to instantiate the dynamic class "), e3);
        } catch (NoSuchMethodException e4) {
            String strValueOf3 = String.valueOf(cls.getName());
            throw new a(strValueOf3.length() != 0 ? "Could not find the right constructor for ".concat(strValueOf3) : new String("Could not find the right constructor for "), e4);
        } catch (InvocationTargetException e5) {
            String strValueOf4 = String.valueOf(cls.getName());
            throw new a(strValueOf4.length() != 0 ? "Exception thrown by invoked constructor in ".concat(strValueOf4) : new String("Exception thrown by invoked constructor in "), e5);
        }
    }

    private static IBinder a(ClassLoader classLoader, String str, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) throws a {
        try {
            return a(classLoader.loadClass(str), iBinder, iBinder2, iBinder3, z);
        } catch (ClassNotFoundException e2) {
            String strValueOf = String.valueOf(str);
            throw new a(strValueOf.length() != 0 ? "Unable to find dynamic class ".concat(strValueOf) : new String("Unable to find dynamic class "), e2);
        }
    }

    public static g a(Activity activity, IBinder iBinder, boolean z) throws a {
        c.a(activity);
        c.a(iBinder);
        Context contextB = ab.b(activity);
        if (contextB == null) {
            throw new a("Could not create remote context");
        }
        return g.a.a(a(contextB.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", x.a(contextB).asBinder(), x.a(activity).asBinder(), iBinder, z));
    }
}
