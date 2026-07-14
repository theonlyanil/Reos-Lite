package com.android.library.rmnlibrary.b;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.ag;
import com.android.apps.config.util.CLog;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static Intent a(String str, Context context) {
        return c(context) ? new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)) : new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionName;
        } catch (Exception e2) {
            CLog.d("RMNLibrary", "Invalid package name for play services");
            return "0";
        }
    }

    public static String a(Context context, String str) {
        try {
            return InstanceID.getInstance(context).getToken(str, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    /* JADX WARN: Code duplicated, block: B:13:? A[RETURN, SYNTHETIC] */
    public static boolean a(Context context, com.android.library.rmnlibrary.a.b bVar) {
        switch (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)) {
            case 0:
                return true;
            case 1:
                bVar.onRegistrationErrorEncountered(103);
                if (!a(a(context), "8.4")) {
                    return true;
                }
                bVar.onRegistrationErrorEncountered(104);
                return false;
            case 2:
                if (!a(a(context), "8.4")) {
                    return true;
                }
                bVar.onRegistrationErrorEncountered(104);
                return false;
            case 3:
                bVar.onRegistrationErrorEncountered(101);
                bVar.onRegistrationErrorEncountered(102);
                bVar.onRegistrationErrorEncountered(103);
                if (!a(a(context), "8.4")) {
                    return true;
                }
                bVar.onRegistrationErrorEncountered(104);
                return false;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
            case 9:
                bVar.onRegistrationErrorEncountered(102);
                bVar.onRegistrationErrorEncountered(103);
                if (!a(a(context), "8.4")) {
                    return true;
                }
                bVar.onRegistrationErrorEncountered(104);
                return false;
        }
    }

    public static boolean a(String str, String str2) {
        int i;
        int i2;
        if (str2.equals("") || str2.equals("0")) {
            return true;
        }
        String[] strArrSplit = str.split(".");
        String[] strArrSplit2 = str2.split(".");
        int length = strArrSplit.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            try {
                i = Integer.parseInt(strArrSplit[i3]);
            } catch (Exception e2) {
                CLog.d("RMNLibrary", "Exception while parsing versions");
                i = 0;
            }
            if (strArrSplit2.length > i4) {
                try {
                    i2 = Integer.parseInt(strArrSplit2[i4]);
                } catch (Exception e3) {
                    CLog.d("RMNLibrary", "Exception while parsing versions");
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
            if (i > i2) {
                return true;
            }
            if (i < i2) {
                return false;
            }
            if (i2 == 0) {
                return true;
            }
            i3++;
            i4++;
        }
        return false;
    }

    public static void b(Context context) {
        Intent intentA = a("com.google.android.gms", context);
        intentA.addFlags(268435456);
        ((NotificationManager) context.getSystemService("notification")).notify(1212, new ag.d(context).a(BitmapFactory.decodeResource(context.getResources(), com.android.library.rmnlibrary.a.C0050a.ic_noti_rmn_default)).a(com.android.library.rmnlibrary.a.C0050a.ic_noti_rmn_default).a("Google Play services").b("Click to update your Google Play services to the latest version").a(PendingIntent.getActivity(context, 0, intentA, 134217728)).c(true).a());
        CLog.b("RMNLibrary", "Notification posted for GCM");
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            String str = (String) packageManager.getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 1).applicationInfo.loadLabel(packageManager);
            return (str == null || str.equals("Market")) ? false : true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }
}
