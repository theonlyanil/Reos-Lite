package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzau;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleAuthUtil {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME;
    public static final String KEY_CALLER_UID;
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";

    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    private static final ComponentName zzTH;
    private static final ComponentName zzTI;

    private interface zza<T> {
        T zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException;
    }

    static {
        KEY_CALLER_UID = Build.VERSION.SDK_INT >= 11 ? "callerUid" : "callerUid";
        KEY_ANDROID_PACKAGE_NAME = Build.VERSION.SDK_INT >= 14 ? "androidPackageName" : "androidPackageName";
        zzTH = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        zzTI = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
    }

    private GoogleAuthUtil() {
    }

    public static void clearToken(Context context, final String str) throws GoogleAuthException, IOException {
        zzx.zzcy("Calling this from your main thread can lead to deadlock");
        zzac(context);
        final Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        zza(context, zzTH, new zza<Void>() { // from class: com.google.android.gms.auth.GoogleAuthUtil.2
            @Override // com.google.android.gms.auth.GoogleAuthUtil.zza
            /* JADX INFO: renamed from: zzao, reason: merged with bridge method [inline-methods] */
            public Void zzan(IBinder iBinder) throws GoogleAuthException, RemoteException, IOException {
                Bundle bundle2 = (Bundle) GoogleAuthUtil.zzl(zzau.zza.zza(iBinder).zza(str, bundle));
                String string = bundle2.getString("Error");
                if (bundle2.getBoolean("booleanResult")) {
                    return null;
                }
                throw new GoogleAuthException(string);
            }
        });
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, final int i, final String str) throws GoogleAuthException, IOException {
        zzx.zzh(str, "accountName must be provided");
        zzx.zzcy("Calling this from your main thread can lead to deadlock");
        zzac(context);
        return (List) zza(context, zzTH, new zza<List<AccountChangeEvent>>() { // from class: com.google.android.gms.auth.GoogleAuthUtil.3
            @Override // com.google.android.gms.auth.GoogleAuthUtil.zza
            /* JADX INFO: renamed from: zzap, reason: merged with bridge method [inline-methods] */
            public List<AccountChangeEvent> zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return ((AccountChangeEventsResponse) GoogleAuthUtil.zzl(zzau.zza.zza(iBinder).zza(new AccountChangeEventsRequest().setAccountName(str).setEventIndex(i)))).getEvents();
            }
        });
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        zzx.zzh(str, "accountName must be provided");
        zzx.zzcy("Calling this from your main thread can lead to deadlock");
        zzac(context);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) throws IOException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        return zza(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, GoogleAuthException {
        return getToken(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, GoogleAuthException {
        return getToken(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2, bundle);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        return zzb(context, account, str, bundle).getToken();
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, Intent intent) throws IOException, GoogleAuthException {
        zzi(intent);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("callback_intent", intent);
        bundle.putBoolean("handle_notification", true);
        return zzc(context, account, str, bundle).getToken();
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, String str2, Bundle bundle2) throws IOException, GoogleAuthException {
        zzx.zzh(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle.putString("authority", str2);
        bundle.putBundle("sync_extras", bundle2);
        bundle.putBoolean("handle_notification", true);
        return zzc(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle) throws IOException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2, bundle);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, Intent intent) throws IOException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2, bundle, intent);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, String str3, Bundle bundle2) throws IOException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2, bundle, str3, bundle2);
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken(GOOGLE_ACCOUNT_TYPE, str);
    }

    public static TokenData zza(Context context, final Account account, final String str, Bundle bundle) throws GoogleAuthException, IOException {
        zzx.zzcy("Calling this from your main thread can lead to deadlock");
        zzac(context);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) zza(context, zzTH, new zza<TokenData>() { // from class: com.google.android.gms.auth.GoogleAuthUtil.1
            @Override // com.google.android.gms.auth.GoogleAuthUtil.zza
            /* JADX INFO: renamed from: zzam, reason: merged with bridge method [inline-methods] */
            public TokenData zzan(IBinder iBinder) throws IOException, GoogleAuthException, RemoteException {
                Bundle bundle3 = (Bundle) GoogleAuthUtil.zzl(zzau.zza.zza(iBinder).zza(account, str, bundle2));
                TokenData tokenDataZza = TokenData.zza(bundle3, "tokenDetails");
                if (tokenDataZza != null) {
                    return tokenDataZza;
                }
                String string = bundle3.getString("Error");
                Intent intent = (Intent) bundle3.getParcelable("userRecoveryIntent");
                com.google.android.gms.auth.firstparty.shared.zzd zzdVarZzbT = com.google.android.gms.auth.firstparty.shared.zzd.zzbT(string);
                if (com.google.android.gms.auth.firstparty.shared.zzd.zza(zzdVarZzbT)) {
                    throw new UserRecoverableAuthException(string, intent);
                }
                if (com.google.android.gms.auth.firstparty.shared.zzd.zzc(zzdVarZzbT)) {
                    throw new IOException(string);
                }
                throw new GoogleAuthException(string);
            }
        });
    }

    private static <T> T zza(Context context, ComponentName componentName, zza<T> zzaVar) throws IOException, GoogleAuthException {
        com.google.android.gms.common.zza zzaVar2 = new com.google.android.gms.common.zza();
        zzl zzlVarZzat = zzl.zzat(context);
        try {
            if (!zzlVarZzat.zza(componentName, zzaVar2, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service.");
            }
            try {
                T tZzan = zzaVar.zzan(zzaVar2.zzor());
                zzlVarZzat.zzb(componentName, zzaVar2, "GoogleAuthUtil");
                return tZzan;
            } catch (RemoteException | InterruptedException e2) {
                Log.i("GoogleAuthUtil", "Error on service connection.", e2);
                throw new IOException("Error on service connection.", e2);
            }
        } catch (Throwable th) {
            zzlVarZzat.zzb(componentName, zzaVar2, "GoogleAuthUtil");
            throw th;
        }
    }

    private static void zzac(Context context) throws GoogleAuthException {
        try {
            GooglePlayServicesUtil.zzac(context.getApplicationContext());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        } catch (GooglePlayServicesRepairableException e3) {
            throw new GooglePlayServicesAvailabilityException(e3.getConnectionStatusCode(), e3.getMessage(), e3.getIntent());
        }
    }

    public static TokenData zzb(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zzc(context, account, str, bundle);
    }

    private static TokenData zzc(Context context, Account account, String str, Bundle bundle) throws GoogleAuthException, IOException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            TokenData tokenDataZza = zza(context, account, str, bundle);
            GooglePlayServicesUtil.zzaj(context);
            return tokenDataZza;
        } catch (GooglePlayServicesAvailabilityException e2) {
            GooglePlayServicesUtil.showErrorNotification(e2.getConnectionStatusCode(), context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (UserRecoverableAuthException e3) {
            GooglePlayServicesUtil.zzaj(context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }

    private static void zzi(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T zzl(T t) throws IOException {
        if (t != null) {
            return t;
        }
        Log.w("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }
}
