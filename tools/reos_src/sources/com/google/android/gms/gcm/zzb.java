package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.ag;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
class zzb {
    static zzb zzaIN;
    private final Context mContext;
    private final Class<? extends GcmListenerService> zzaIO;

    private class zza extends IllegalArgumentException {
        private zza(String str) {
            super(str);
        }
    }

    private zzb(Context context, Class<? extends GcmListenerService> cls) {
        this.mContext = context.getApplicationContext();
        this.zzaIO = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Notification zzA(Bundle bundle) {
        PendingIntent pendingIntentZzC = null;
        Object[] objArr = 0;
        String strZzd = zzd(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(strZzd)) {
            throw new zza("Missing title");
        }
        String strZzd2 = zzd(bundle, "gcm.n.body");
        int iZzdH = zzdH(zzc(bundle, "gcm.n.icon"));
        String strZzc = zzc(bundle, "gcm.n.color");
        Uri uriZzdI = zzdI(zzc(bundle, "gcm.n.sound"));
        PendingIntent pendingIntentZzB = zzB(bundle);
        if (GcmListenerService.zzw(bundle)) {
            pendingIntentZzB = zza(bundle, pendingIntentZzB);
            pendingIntentZzC = zzC(bundle);
        }
        ag.d dVarB = new ag.d(this.mContext).c(true).a(iZzdH).a(strZzd).b(strZzd2);
        if (!TextUtils.isEmpty(strZzc)) {
            dVarB.c(Color.parseColor(strZzc));
        }
        if (uriZzdI != null) {
            dVarB.a(uriZzdI);
        }
        if (pendingIntentZzB != null) {
            dVarB.a(pendingIntentZzB);
        }
        if (pendingIntentZzC != null) {
            dVarB.b(pendingIntentZzC);
        }
        return dVarB.a();
    }

    private PendingIntent zzB(Bundle bundle) {
        String strZzc = zzc(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(strZzc)) {
            return null;
        }
        Intent intent = new Intent(strZzc);
        intent.setPackage(this.mContext.getPackageName());
        intent.setFlags(268435456);
        intent.putExtras(bundle);
        for (String str : bundle.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, zzxx(), intent, 1073741824);
    }

    private PendingIntent zzC(Bundle bundle) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_DISMISS");
        zza(intent, bundle);
        return PendingIntent.getService(this.mContext, zzxx(), intent, 1073741824);
    }

    private PendingIntent zza(Bundle bundle, PendingIntent pendingIntent) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_OPEN");
        zza(intent, bundle);
        intent.putExtra("com.google.android.gms.gcm.PENDING_INTENT", pendingIntent);
        return PendingIntent.getService(this.mContext, zzxx(), intent, 1073741824);
    }

    private void zza(Intent intent, Bundle bundle) {
        intent.setClass(this.mContext, this.zzaIO);
        for (String str : bundle.keySet()) {
            if (str.startsWith("gcm.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private void zza(String str, Notification notification) {
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    static boolean zzaH(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    static synchronized zzb zzc(Context context, Class<? extends GcmListenerService> cls) {
        if (zzaIN == null) {
            zzaIN = new zzb(context, cls);
        }
        return zzaIN;
    }

    static String zzc(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String zzd(Bundle bundle, String str) {
        String strZzc = zzc(bundle, str);
        if (!TextUtils.isEmpty(strZzc)) {
            return strZzc;
        }
        String strZzc2 = zzc(bundle, str + "_loc_key");
        if (TextUtils.isEmpty(strZzc2)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(strZzc2, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            throw new zza(zzdG(str + "_loc_key") + " resource not found: " + strZzc2);
        }
        String strZzc3 = zzc(bundle, str + "_loc_args");
        if (TextUtils.isEmpty(strZzc3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(strZzc3);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            try {
                return resources.getString(identifier, objArr);
            } catch (MissingFormatArgumentException e2) {
                throw new zza("Missing format argument for " + strZzc2 + ": " + e2);
            }
        } catch (JSONException e3) {
            throw new zza("Malformed " + zzdG(str + "_loc_args") + ": " + strZzc3);
        }
    }

    private String zzdG(String str) {
        return str.substring("gcm.n.".length());
    }

    private int zzdH(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new zza("Missing icon");
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(str, "drawable", this.mContext.getPackageName());
        if (identifier == 0 && (identifier = resources.getIdentifier(str, "mipmap", this.mContext.getPackageName())) == 0) {
            throw new zza("Icon resource not found: " + str);
        }
        return identifier;
    }

    private Uri zzdI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str)) {
            return RingtoneManager.getDefaultUri(2);
        }
        throw new zza("Invalid sound: " + str);
    }

    static boolean zzx(Bundle bundle) {
        return zzc(bundle, "gcm.n.icon") != null;
    }

    private int zzxx() {
        return (int) SystemClock.uptimeMillis();
    }

    static void zzy(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.startsWith("gcm.n.")) {
                bundle2.putString(next.substring("gcm.n.".length()), bundle.getString(next));
                it.remove();
            } else if (next.startsWith("gcm.notification.")) {
                bundle2.putString(next.substring("gcm.notification.".length()), bundle.getString(next));
                it.remove();
            }
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("notification", bundle2);
    }

    boolean zzz(Bundle bundle) {
        try {
            zza(zzc(bundle, "gcm.n.tag"), zzA(bundle));
            return true;
        } catch (zza e2) {
            Log.w("GcmNotification", "Failed to show notification: " + e2.getMessage());
            return false;
        }
    }
}
