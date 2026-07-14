package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzajw = new Object();
    private static ClassLoader zzajx = null;
    private static Integer zzajy = null;
    private boolean zzajz = false;

    private static boolean zza(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException e2) {
            return false;
        } catch (NoSuchFieldException e3) {
            return false;
        }
    }

    protected static boolean zzcz(String str) {
        ClassLoader classLoaderZzqi = zzqi();
        if (classLoaderZzqi == null) {
            return true;
        }
        try {
            return zza(classLoaderZzqi.loadClass(str));
        } catch (Exception e2) {
            return false;
        }
    }

    protected static ClassLoader zzqi() {
        ClassLoader classLoader;
        synchronized (zzajw) {
            classLoader = zzajx;
        }
        return classLoader;
    }

    protected static Integer zzqj() {
        Integer num;
        synchronized (zzajw) {
            num = zzajy;
        }
        return num;
    }

    protected boolean zzqk() {
        return this.zzajz;
    }
}
