package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.ag;
import android.support.v4.app.p;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zznx;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";

    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzov();
    public static boolean zzaee = false;
    public static boolean zzaef = false;
    private static int zzaeg = -1;
    private static final Object zzqf = new Object();
    private static String zzaeh = null;
    private static Integer zzaei = null;
    static final AtomicBoolean zzaej = new AtomicBoolean();
    private static final AtomicBoolean zzaek = new AtomicBoolean();

    private static class zza extends Handler {
        private final Context zzrI;

        zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.zzrI = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int iIsGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzrI);
                    if (GooglePlayServicesUtil.isUserRecoverableError(iIsGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.zza(iIsGooglePlayServicesAvailable, this.zzrI);
                    }
                    break;
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + message.what);
                    break;
            }
        }
    }

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return zza(i, activity, null, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return GoogleApiAvailability.getInstance().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
            try {
                String next = new Scanner(inputStreamOpenInputStream).useDelimiter("\\A").next();
            } catch (NoSuchElementException e2) {
                return null;
            } finally {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
            }
        } catch (Exception e3) {
            return null;
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e5  */
    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        int i = 9;
        if (com.google.android.gms.common.internal.zzd.zzaiU) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            zzak(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzd zzdVarZzox = zzd.zzox();
            if (!zznj.zzav(context)) {
                try {
                    zzc.zza zzaVarZza = zzdVarZzox.zza(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256), zzc.zzcg.zzaed);
                    if (zzaVarZza == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    } else if (zzdVarZzox.zza(packageInfo, zzaVarZza) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    }
                    return i;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return i;
                }
            }
            if (zzdVarZzox.zza(packageInfo, zzc.zzcg.zzaed) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zznj.zzcp(packageInfo.versionCode) < zznj.zzcp(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo.versionCode);
                i = 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        if (applicationInfo.enabled) {
                            i = 0;
                        } else {
                            i = 3;
                        }
                    } catch (PackageManager.NameNotFoundException e3) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e3);
                        i = 1;
                    }
                } else if (applicationInfo.enabled) {
                    i = 3;
                } else {
                    i = 0;
                }
            }
            return i;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogZza = zza(i, activity, fragment, i2, onCancelListener);
        if (dialogZza == null) {
            return false;
        }
        zza(activity, onCancelListener, GMS_ERROR_DIALOG, dialogZza);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        if (zznj.zzav(context) && i == 2) {
            i = 42;
        }
        if (zzd(context, i) || zzf(context, i)) {
            zzal(context);
        } else {
            zza(i, context);
        }
    }

    private static Dialog zza(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (zznj.zzav(activity) && i == 2) {
            i = 42;
        }
        if (zznx.zzrQ()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zzg.zzc(activity, i, zzam(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent intentZza = GoogleApiAvailability.getInstance().zza(activity, i, "d");
        zzh zzhVar = fragment == null ? new zzh(activity, intentZza, i2) : new zzh(fragment, intentZza, i2);
        String strZzh = zzg.zzh(activity, i);
        if (strZzh != null) {
            builder.setPositiveButton(strZzh, zzhVar);
        }
        String strZzg = zzg.zzg(activity, i);
        if (strZzg != null) {
            builder.setTitle(strZzg);
        }
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(int i, Context context) {
        zza(i, context, null);
    }

    private static void zza(int i, Context context, String str) {
        Notification notificationA;
        Notification notification;
        int i2;
        Resources resources = context.getResources();
        String strZzam = zzam(context);
        String strZzi = zzg.zzi(context, i);
        if (strZzi == null) {
            strZzi = resources.getString(R.string.common_google_play_services_notification_ticker);
        }
        String strZzd = zzg.zzd(context, i, strZzam);
        PendingIntent pendingIntentZza = GoogleApiAvailability.getInstance().zza(context, i, 0, "n");
        if (zznj.zzav(context)) {
            zzx.zzaa(zznx.zzrR());
            notificationA = new Notification.Builder(context).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(strZzi + " " + strZzd)).addAction(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), pendingIntentZza).build();
        } else {
            String string = resources.getString(R.string.common_google_play_services_notification_ticker);
            if (zznx.zzrN()) {
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(android.R.drawable.stat_sys_warning).setContentTitle(strZzi).setContentText(strZzd).setContentIntent(pendingIntentZza).setTicker(string).setAutoCancel(true);
                if (zznx.zzrV()) {
                    autoCancel.setLocalOnly(true);
                }
                if (zznx.zzrR()) {
                    autoCancel.setStyle(new Notification.BigTextStyle().bigText(strZzd));
                    notification = autoCancel.build();
                } else {
                    notification = autoCancel.getNotification();
                }
                if (Build.VERSION.SDK_INT == 19) {
                    notification.extras.putBoolean("android.support.localOnly", true);
                }
                notificationA = notification;
            } else {
                notificationA = new ag.d(context).a(android.R.drawable.stat_sys_warning).c(string).a(System.currentTimeMillis()).c(true).a(pendingIntentZza).a(strZzi).b(strZzd).a();
            }
        }
        if (zzbw(i)) {
            zzaej.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, notificationA);
        } else {
            notificationManager.notify(i2, notificationA);
        }
    }

    public static void zza(Activity activity, DialogInterface.OnCancelListener onCancelListener, String str, Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof p;
        } catch (NoClassDefFoundError e2) {
            z = false;
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((p) activity).getSupportFragmentManager(), str);
        } else {
            if (!zznx.zzrN()) {
                throw new RuntimeException("This Activity does not support Fragments.");
            }
            ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    @Deprecated
    public static void zzac(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (iIsGooglePlayServicesAvailable != 0) {
            Intent intentZza = GoogleApiAvailability.getInstance().zza(context, iIsGooglePlayServicesAvailable, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + iIsGooglePlayServicesAvailable);
            if (intentZza != null) {
                throw new GooglePlayServicesRepairableException(iIsGooglePlayServicesAvailable, "Google Play Services not available", intentZza);
            }
            throw new GooglePlayServicesNotAvailableException(iIsGooglePlayServicesAvailable);
        }
    }

    @Deprecated
    public static void zzaj(Context context) {
        if (zzaej.getAndSet(true)) {
            return;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(10436);
        } catch (SecurityException e2) {
        }
    }

    private static void zzak(Context context) {
        Integer num;
        if (zzaek.get()) {
            return;
        }
        synchronized (zzqf) {
            if (zzaeh == null) {
                zzaeh = context.getPackageName();
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        zzaei = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                    } else {
                        zzaei = null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", "This should never happen.", e2);
                }
            } else if (!zzaeh.equals(context.getPackageName())) {
                throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzaeh + "' and this call used package '" + context.getPackageName() + "'.");
            }
            num = zzaei;
        }
        if (num == null) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        if (num.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
            throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + num + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
    }

    private static void zzal(Context context) {
        zza zzaVar = new zza(context);
        zzaVar.sendMessageDelayed(zzaVar.obtainMessage(1), 120000L);
    }

    public static String zzam(Context context) {
        ApplicationInfo applicationInfo;
        String str = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    @Deprecated
    public static int zzan(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static boolean zzao(Context context) {
        return zznx.zzrW() && context.getPackageManager().hasSystemFeature("cn.google");
    }

    public static boolean zzap(Context context) {
        Bundle applicationRestrictions;
        return zznx.zzrT() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    public static boolean zzb(Context context, int i, String str) {
        if (zznx.zzrU()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e2) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (String str2 : packagesForUid) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003c  */
    public static boolean zzb(PackageManager packageManager) {
        boolean z;
        synchronized (zzqf) {
            if (zzaeg == -1) {
                try {
                    if (zzd.zzox().zza(packageManager.getPackageInfo("com.google.android.gms", 64), zzc.zzadW[1]) != null) {
                        zzaeg = 1;
                    } else {
                        zzaeg = 0;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    zzaeg = 0;
                }
                z = zzaeg != 0;
            } else if (zzaeg != 0) {
            }
            throw th;
        }
        return z;
    }

    @Deprecated
    public static boolean zzb(PackageManager packageManager, String str) {
        return zzd.zzox().zzb(packageManager, str);
    }

    @Deprecated
    public static Intent zzbv(int i) {
        return GoogleApiAvailability.getInstance().zza(null, i, null);
    }

    private static boolean zzbw(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzc(PackageManager packageManager) {
        return zzb(packageManager) || !zzow();
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzh(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean zze(Context context, int i) {
        return zzb(context, i, "com.google.android.gms") && zzb(context.getPackageManager(), "com.google.android.gms");
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        if (i == 9) {
            return zzh(context, GOOGLE_PLAY_STORE_PACKAGE);
        }
        return false;
    }

    static boolean zzh(Context context, String str) {
        if (zznx.zzrW()) {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
        }
        if (zzap(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    private static int zzov() {
        return 8298000;
    }

    public static boolean zzow() {
        return zzaee ? zzaef : "user".equals(Build.TYPE);
    }
}
