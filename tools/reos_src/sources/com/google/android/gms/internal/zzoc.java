package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzoc {
    private static final Method zzamr = zzrZ();
    private static final Method zzams = zzsa();
    private static final Method zzamt = zzsb();
    private static final Method zzamu = zzsc();
    private static final Method zzamv = zzsd();

    public static int zza(WorkSource workSource) {
        if (zzamt != null) {
            try {
                return ((Integer) zzamt.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    public static String zza(WorkSource workSource, int i) {
        if (zzamv != null) {
            try {
                return (String) zzamv.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return null;
    }

    public static void zza(WorkSource workSource, int i, String str) {
        if (zzams != null) {
            if (str == null) {
                str = "";
            }
            try {
                zzams.invoke(workSource, Integer.valueOf(i), str);
                return;
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        if (zzamr != null) {
            try {
                zzamr.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    public static boolean zzaz(Context context) {
        PackageManager packageManager;
        return (context == null || (packageManager = context.getPackageManager()) == null || packageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    public static List<String> zzb(WorkSource workSource) {
        int iZza = workSource == null ? 0 : zza(workSource);
        if (iZza == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iZza; i++) {
            String strZza = zza(workSource, i);
            if (!zzob.zzcP(strZza)) {
                arrayList.add(strZza);
            }
        }
        return arrayList;
    }

    public static WorkSource zzh(int i, String str) {
        WorkSource workSource = new WorkSource();
        zza(workSource, i, str);
        return workSource;
    }

    public static WorkSource zzk(Context context, String str) {
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return zzh(applicationInfo.uid, str);
            }
            Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + str);
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("WorkSourceUtil", "Could not find package: " + str);
            return null;
        }
    }

    private static Method zzrZ() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception e2) {
            return null;
        }
    }

    private static Method zzsa() {
        if (!zznx.zzrT()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception e2) {
            return null;
        }
    }

    private static Method zzsb() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    private static Method zzsc() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception e2) {
            return null;
        }
    }

    private static Method zzsd() {
        if (!zznx.zzrT()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception e2) {
            return null;
        }
    }
}
