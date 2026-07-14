package com.android.library.deviceData.c;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.util.Constants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2636a = d.class.getName();

    private static int a(Context context, com.android.library.deviceData.a.a aVar) {
        Object objInvoke;
        int iIntValue;
        try {
            switch (aVar) {
                case QUALCOMM:
                    Method[] methods = Class.forName(Constants.QUALCOMM_CLASS_NAME).getMethods();
                    int length = methods.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            Method method = methods[i];
                            if (method.getName().equals(Constants.GET_DEFAULT)) {
                                objInvoke = method.invoke(null, (Object[]) null);
                            } else {
                                i++;
                            }
                        } else {
                            objInvoke = null;
                        }
                    }
                    for (Method method2 : methods) {
                        if (method2.getName().equals(Constants.GET_PHONE_COUNT)) {
                            iIntValue = ((Integer) method2.invoke(objInvoke, (Object[]) null)).intValue();
                            return iIntValue;
                        }
                    }
                    iIntValue = 0;
                    return iIntValue;
                case SPREADTRUM:
                    for (Method method3 : Class.forName(((TelephonyManager) context.getSystemService("phone")).getClass().getName()).getMethods()) {
                        if (method3.getName().equals(Constants.GET_PHONE_COUNT)) {
                            return ((Integer) method3.invoke(null, (Object[]) null)).intValue();
                        }
                    }
                    return 0;
                case MEDIATEK:
                    return 2;
                case NONE:
                    HashSet hashSet = new HashSet();
                    for (int i2 = 0; i2 < 4; i2++) {
                        hashSet.add(a(context, aVar, i2));
                    }
                    return hashSet.size();
                default:
                    return 0;
            }
        } catch (Exception e2) {
            CLog.c(f2636a, "getPhoneCount# chipset: " + aVar.a(), e2);
            return 0;
        }
    }

    public static com.android.library.deviceData.a.a a() {
        com.android.library.deviceData.a.a aVar = com.android.library.deviceData.a.a.NONE;
        if (e.a(Constants.QUALCOMM_CLASS_NAME)) {
            return com.android.library.deviceData.a.a.QUALCOMM;
        }
        if (e.a(Constants.MTK_TELEPHONY_MANAGER_EX_CLASS_NAME)) {
            return com.android.library.deviceData.a.a.MEDIATEK;
        }
        return e.a(Constants.SPRD_OPERATORUTILS_CLASS_NAME) ? com.android.library.deviceData.a.a.SPREADTRUM : aVar;
    }

    public static String a(Context context, int i) {
        return b(context, a(), i);
    }

    private static String a(Context context, com.android.library.deviceData.a.a aVar, int i) {
        Object objInvoke;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            switch (aVar) {
                case QUALCOMM:
                case MEDIATEK:
                case NONE:
                    Method[] methods = Class.forName(aVar.a()).getMethods();
                    int length = methods.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            Method method = methods[i2];
                            if (method.getName().equals(Constants.GET_DEFAULT)) {
                                objInvoke = method.invoke(null, (Object[]) null);
                            } else {
                                i2++;
                            }
                        } else {
                            objInvoke = null;
                        }
                    }
                    for (Method method2 : methods) {
                        if (method2.getName().equals(Constants.GET_DEVICE_ID)) {
                            return method2.invoke(objInvoke, Integer.valueOf(i)).toString();
                        }
                    }
                    break;
                case SPREADTRUM:
                    Class<?> cls = Class.forName(telephonyManager.getClass().getName());
                    String str = "";
                    for (Method method3 : cls.getMethods()) {
                        if (method3.getName().equals(Constants.GET_SERVICE_NAME)) {
                            str = (String) method3.invoke(null, "phone", Integer.valueOf(i));
                            return ((TelephonyManager) context.getSystemService(str)).getDeviceId();
                        }
                    }
                    return ((TelephonyManager) context.getSystemService(str)).getDeviceId();
            }
            return null;
        } catch (Exception e2) {
            CLog.c(f2636a, "getImeiForChipset# chipset: " + aVar.a() + " slot:" + i, e2);
            return c(context);
        }
    }

    public static List<String> a(Context context) {
        TreeSet treeSet = new TreeSet();
        ArrayList arrayList = new ArrayList();
        if (e.a(context, "android.permission.READ_PHONE_STATE")) {
            if (Build.VERSION.SDK_INT >= 21) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                int phoneCount = telephonyManager.getPhoneCount();
                if (phoneCount > 0) {
                    for (int i = 0; i < phoneCount; i++) {
                        String deviceId = telephonyManager.getDeviceId(i);
                        if (deviceId != null && !deviceId.isEmpty()) {
                            treeSet.add(deviceId);
                        }
                    }
                }
            } else {
                com.android.library.deviceData.a.a aVarA = a();
                if (a(context, aVarA) <= 1) {
                    treeSet.add(c(context));
                } else {
                    for (int i2 = 0; i2 < 2; i2++) {
                        treeSet.add(a(context, aVarA, i2));
                    }
                }
            }
            arrayList.addAll(treeSet);
            Collections.sort(arrayList);
        } else {
            arrayList.add("-1");
            arrayList.add("-1");
        }
        return arrayList;
    }

    public static int b(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? ((TelephonyManager) context.getSystemService("phone")).getPhoneCount() : a(context, a());
    }

    public static String b(Context context, int i) {
        return c(context, a(), i);
    }

    private static String b(Context context, com.android.library.deviceData.a.a aVar, int i) {
        Object objInvoke;
        String string;
        int i2 = 0;
        try {
            switch (aVar) {
                case QUALCOMM:
                case MEDIATEK:
                    Method[] methods = Class.forName(aVar.a()).getMethods();
                    int length = methods.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            Method method = methods[i3];
                            if (method.getName().equals(Constants.GET_DEFAULT)) {
                                objInvoke = method.invoke(null, (Object[]) null);
                            } else {
                                i3++;
                            }
                        } else {
                            objInvoke = null;
                        }
                    }
                    int length2 = methods.length;
                    while (true) {
                        if (i2 < length2) {
                            Method method2 = methods[i2];
                            if (method2.getName().equals(Constants.GET_NETWORK_OPERATOR)) {
                                string = method2.invoke(objInvoke, Integer.valueOf(i)).toString();
                            } else {
                                i2++;
                            }
                        } else {
                            string = null;
                        }
                    }
                    return aVar == com.android.library.deviceData.a.a.QUALCOMM ? string.substring(3) : string.substring(0, 3);
                case SPREADTRUM:
                    String str = "";
                    Method[] methods2 = Class.forName(((TelephonyManager) context.getSystemService("phone")).getClass().getName()).getMethods();
                    int length3 = methods2.length;
                    while (i2 < length3) {
                        Method method3 = methods2[i2];
                        if (method3.getName().equals(Constants.GET_SERVICE_NAME)) {
                            str = (String) method3.invoke(null, "phone", Integer.valueOf(i));
                            return ((TelephonyManager) context.getSystemService(str)).getNetworkOperator().substring(0, 3);
                        }
                        i2++;
                    }
                    return ((TelephonyManager) context.getSystemService(str)).getNetworkOperator().substring(0, 3);
                default:
                    return d(context);
            }
        } catch (Exception e2) {
            CLog.c(f2636a, "getMccForChipset#", e2);
            return "-2";
        }
    }

    public static String c(Context context) {
        String deviceId = e.a(context, "android.permission.READ_PHONE_STATE") ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "-1";
        return deviceId != null ? deviceId : "";
    }

    private static String c(Context context, com.android.library.deviceData.a.a aVar, int i) {
        Object objInvoke;
        String string;
        int i2 = 0;
        try {
            switch (aVar) {
                case QUALCOMM:
                case MEDIATEK:
                    Method[] methods = Class.forName(aVar.a()).getMethods();
                    int length = methods.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            Method method = methods[i3];
                            if (method.getName().equals(Constants.GET_DEFAULT)) {
                                objInvoke = method.invoke(null, (Object[]) null);
                            } else {
                                i3++;
                            }
                        } else {
                            objInvoke = null;
                        }
                    }
                    int length2 = methods.length;
                    while (true) {
                        if (i2 < length2) {
                            Method method2 = methods[i2];
                            if (method2.getName().equals(Constants.GET_NETWORK_OPERATOR)) {
                                string = method2.invoke(objInvoke, Integer.valueOf(i)).toString();
                            } else {
                                i2++;
                            }
                        } else {
                            string = null;
                        }
                    }
                    return aVar == com.android.library.deviceData.a.a.QUALCOMM ? string.substring(3) : string.substring(0, 3);
                case SPREADTRUM:
                    String str = "";
                    Method[] methods2 = Class.forName(((TelephonyManager) context.getSystemService("phone")).getClass().getName()).getMethods();
                    int length3 = methods2.length;
                    while (i2 < length3) {
                        Method method3 = methods2[i2];
                        if (method3.getName().equals(Constants.GET_NETWORK_OPERATOR)) {
                            str = (String) method3.invoke(null, "phone", Integer.valueOf(i));
                            return ((TelephonyManager) context.getSystemService(str)).getNetworkOperator().substring(3);
                        }
                        i2++;
                    }
                    return ((TelephonyManager) context.getSystemService(str)).getNetworkOperator().substring(3);
                default:
                    return e(context);
            }
        } catch (Exception e2) {
            CLog.c(f2636a, "getMncForChipset# ", e2);
            return "-2";
        }
    }

    public static String d(Context context) {
        int i;
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (networkOperator != null) {
            try {
                i = Integer.parseInt(networkOperator.substring(0, 3));
            } catch (Exception e2) {
                i = -2;
            }
        } else {
            i = 0;
        }
        return String.valueOf(i);
    }

    public static String e(Context context) {
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        int i = 0;
        if (networkOperator != null) {
            try {
                i = Integer.parseInt(networkOperator.substring(3));
            } catch (Exception e2) {
                i = -2;
            }
        }
        return String.valueOf(i);
    }

    public static String f(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String simCountryIso = 5 == telephonyManager.getSimState() ? telephonyManager.getSimCountryIso() : "";
        return simCountryIso != null ? simCountryIso : "";
    }

    public static String g(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String networkCountryIso = 5 == telephonyManager.getSimState() ? telephonyManager.getNetworkCountryIso() : "";
        return networkCountryIso != null ? networkCountryIso : "";
    }
}
