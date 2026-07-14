package com.cube26.iota.smartlite.neonmusic;

import android.content.Context;
import com.android.apps.config.util.CLog;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static Boolean a(Context context, String str, boolean z) throws IllegalArgumentException {
        return a(context.getClassLoader(), str, z);
    }

    public static Boolean a(ClassLoader classLoader, String str, boolean z) throws IllegalArgumentException {
        try {
            Class<?> clsLoadClass = classLoader.loadClass("android.os.SystemProperties");
            return (Boolean) clsLoadClass.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(clsLoadClass, str, Boolean.valueOf(z));
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (Exception e3) {
            CLog.c("SystemPropertiesProxy", "getBoolean(context, key: " + str + ", def:" + z + ")", e3);
            return Boolean.valueOf(z);
        }
    }
}
