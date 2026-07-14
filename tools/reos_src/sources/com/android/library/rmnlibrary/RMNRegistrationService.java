package com.android.library.rmnlibrary;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import com.android.library.rmnlibrary.b.d;
import com.android.library.rmnlibrary.b.f;
import com.android.library.rmnlibrary.b.g;
import com.android.library.rmnlibrary.b.h;
import com.android.library.rmnlibrary.b.i;
import f.l;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class RMNRegistrationService extends IntentService implements HTTPLibrary.b, com.android.library.rmnlibrary.a.b {
    public static final String RMN_REGISTRATION_SERVICE_INTENT_EXTRA_DRAWABLE_ID = "com.android.library.rmnlibrary.intentextra.drawableid";
    public static final String RMN_REGISTRATION_SERVICE_INTENT_EXTRA_NOTI_DEFAULT_ICON = "com.android.library.rmnlibrary.intentextra.notidefaulticon";
    public static final String RMN_REGISTRATION_SERVICE_INTENT_EXTRA_PACKAGE_NAME = "com.android.library.rmnlibrary.intentextra.packagename";
    public static final String RMN_REGISTRATION_SERVICE_INTENT_EXTRA_SENDER_ID = "com.android.library.rmnlibrary.intentextra.senderid";
    public static final String RMN_REGISTRATION_SERVICE_INTENT_GCM_APPEND_URL = "com.android.library.rmnlibrary.intentextra.GCM_APPEND_URL";
    public static final String RMN_REGISTRATION_SERVICE_INTENT_RMNALARMDURATION = "com.android.library.rmnlibrary.intentextra.RMN_REGISTRATION_SERVICE_INTENT_RETRY";
    public static final String RMN_REGISTRATION_SERVICE_INTENT_YOUTUBE_API_KEY = "com.android.library.rmnlibrary.intentextra.YOUTUBE_API_KEY";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.android.library.rmnlibrary.a.b f2716a;
    public a rmnAlarmDuration;

    public enum a {
        SIX_HOURS,
        MONTH
    }

    public RMNRegistrationService() {
        super("RMNRegistrationService");
    }

    private void a(int i, com.android.library.rmnlibrary.a.b bVar) {
        try {
            if (i == 106) {
                bVar.onRegistrationErrorEncountered("Network unavaliable");
            } else {
                bVar.onRegistrationErrorEncountered(i);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, String str, String str2, String str3, String str4) {
        CLog.b("RMNLibrary", "Registering GCM...Please Wait :: " + str);
        String strC = g.c(context);
        CLog.b("RMNLibrary", "Saved reg id while calling register method " + strC);
        if (!h.b(strC)) {
            this.f2716a.onRegistrationSuccess(600, "User Already Registered");
            return;
        }
        if (!i.a(context)) {
            a(106, this.f2716a);
        } else if (d.a(getApplicationContext(), this.f2716a)) {
            String strA = g.a("com.android.library.rmnlibrary.sharedprefs.key.registrationtoken", "", context);
            CLog.b("RMNLibrary", "Registering GCM with token :: " + strA);
            HTTPLibrary.postGCM(this, this, 1111, str2, str3, f.a(getApplicationContext(), str4, strA), 10);
        }
    }

    private void a(Intent intent) {
        int intExtra = intent.getIntExtra(RMN_REGISTRATION_SERVICE_INTENT_EXTRA_DRAWABLE_ID, 0);
        int intExtra2 = intent.getIntExtra(RMN_REGISTRATION_SERVICE_INTENT_EXTRA_NOTI_DEFAULT_ICON, 0);
        String stringExtra = intent.getStringExtra(RMN_REGISTRATION_SERVICE_INTENT_EXTRA_PACKAGE_NAME);
        String str = Config.getInstance(this).get("httpLib.gcmRegistrationUrl");
        String stringExtra2 = intent.getStringExtra(RMN_REGISTRATION_SERVICE_INTENT_GCM_APPEND_URL);
        String stringExtra3 = intent.getStringExtra(RMN_REGISTRATION_SERVICE_INTENT_YOUTUBE_API_KEY);
        String stringExtra4 = intent.getStringExtra(RMN_REGISTRATION_SERVICE_INTENT_EXTRA_SENDER_ID);
        CLog.b("RMNLibrary", "Registering GCM with appPackage :: " + stringExtra);
        CLog.b("RMNLibrary", "Base URL for RMN using config " + str);
        CLog.b("RMNLibrary", "Append URL for RMN using config " + stringExtra2);
        CLog.b("RMNLibrary", stringExtra3);
        CLog.b("RMNLibrary", "Registration token on registerGCM() method " + d.a(getApplicationContext(), stringExtra4));
        g.b("sharedprefs.key.packagename", stringExtra, getApplicationContext());
        g.b("sharedprefs.key.senderid", stringExtra4, getApplicationContext());
        g.b("sharedprefs.key.gcmbase", str, getApplicationContext());
        g.b("sharedprefs.key.gcmappend", stringExtra2, getApplicationContext());
        g.b("sharedprefs.key.keynotidefaulticon", intExtra2, getApplicationContext());
        g.b("sharedprefs.key.drawableid", intExtra, getApplicationContext());
        g.b("sharedprefs.key.youtubekey", stringExtra3, getApplicationContext());
        g.b("com.android.library.rmnlibrary.sharedprefs.key.registrationtoken", d.a(getApplicationContext(), stringExtra4), getApplicationContext());
        if (h.a(new String[]{stringExtra, stringExtra4, str, stringExtra2})) {
            CLog.b("RMNLibrary", "The package name, sender id, base url and append url should not be empty or null");
        } else {
            a(getApplicationContext(), stringExtra4, str, stringExtra2, stringExtra);
        }
    }

    private void a(a aVar) {
        long j;
        CLog.b("RMNLibrary", "Setting alarm for GCM re-registration");
        long jA = 0;
        switch (aVar) {
            case SIX_HOURS:
                CLog.b("RMNLibrary", "refreshInterval for 6 hours 21600000");
                j = 21600000;
                break;
            case MONTH:
                jA = ((long) com.android.library.rmnlibrary.b.a.a(this)) * 86400000;
                CLog.b("RMNLibrary", "refreshInterval for month " + jA);
            default:
                j = jA;
                break;
        }
        Calendar calendar = Calendar.getInstance();
        if (g.a("sharedprefs.key.SHARED_PREFS_KEY_GPS_UPDATED", true, (Context) this)) {
            ((AlarmManager) getApplicationContext().getSystemService("alarm")).set(0, j + calendar.getTimeInMillis(), PendingIntent.getService(getApplicationContext(), 102, f.a(getApplicationContext(), aVar), 268435456));
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onError(int i, l<com.google.a.l> lVar) {
        if (i == 1111) {
            CLog.b("RMNLibrary", "No Internet or No Network error");
            CLog.b("RMNLibrary", "onError()Error code : " + lVar.a().c() + "Error msg : " + lVar.f());
            try {
                this.f2716a.onRegistrationErrorEncountered("Error while sending to backend");
            } catch (Exception e2) {
                CLog.d("RMNLibrary", "Exception sending reg callback");
            }
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onFailure(Throwable th) {
        CLog.b("RMNLibrary", "FAILURE CASE " + th.getMessage());
        CLog.b("RMNLibrary", "No Internet or No Network Error");
        try {
            this.f2716a.onRegistrationErrorEncountered("Failure while sending to backend");
        } catch (Exception e2) {
            CLog.d("RMNLibrary", "Exception sending reg callback");
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        this.f2716a = this;
        if (intent != null) {
            if (h.a(intent, "com.android.library.rmnlibrary.tokenrefresh")) {
                CLog.b("RMNLibrary", "Calling token refresh");
                this.f2716a.onRegistrationErrorEncountered(1000);
            } else if (intent.getSerializableExtra(RMN_REGISTRATION_SERVICE_INTENT_RMNALARMDURATION) != a.MONTH) {
                CLog.b("RMNLibrary", "Normal GCM REgistration");
                a(intent);
            } else {
                CLog.b("RMNLibrary", "Calling alarm interval once in 30 days");
                g.d(this);
                a(intent);
            }
        }
    }

    @Override // com.android.library.rmnlibrary.a.b
    public void onRegistrationErrorEncountered(int i) {
        boolean z = true;
        CLog.b("RMNLibrary", "Play services error while GCM registration");
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                break;
            case 105:
                CLog.a("RMNLibrary", "Invalid Sender id");
                z = false;
                break;
            case 106:
                CLog.a("RMNLibrary", "Network Unavailable");
            default:
                z = false;
                break;
        }
        if (z) {
            g.b("sharedprefs.key.SHARED_PREFS_KEY_GPS_UPDATED", false, (Context) this);
            CLog.b("RMNLibrary", "Google play services update required");
            try {
                String str = getPackageManager().getPackageInfo("com.google.android.gms", 0).versionName;
                d.b(getApplicationContext());
                b.a(getApplicationContext(), str);
            } catch (Exception e2) {
                CLog.d("RMNLibrary", "Error fetching Play services version");
            }
        }
        g.b("sharedprefs.key.gcm.lastregtime", System.currentTimeMillis(), getApplicationContext());
        a aVar = this.rmnAlarmDuration;
        a(a.SIX_HOURS);
    }

    @Override // com.android.library.rmnlibrary.a.b
    public void onRegistrationErrorEncountered(String str) {
        CLog.b("RMNLibrary", "Error while GCM registration");
        a aVar = this.rmnAlarmDuration;
        a(a.SIX_HOURS);
    }

    @Override // com.android.library.rmnlibrary.a.b
    public void onRegistrationSuccess(int i, String str) {
        g.b("sharedprefs.key.gcmregistered", true, getApplicationContext());
        a aVar = this.rmnAlarmDuration;
        a(a.MONTH);
        switch (i) {
            case 200:
                CLog.b("RMNLibrary", "Gcm registration success case 200 ");
                CLog.b("RMNLibrary", str);
                break;
            case 600:
                CLog.b("RMNLibrary", "Gcm already registration success case 600 ");
                CLog.b("RMNLibrary", str);
                break;
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onSuccess(int i, l<com.google.a.l> lVar) {
        if (i == 1111) {
            AbstractRMNResponse abstractRMNResponse = (AbstractRMNResponse) HTTPLibrary.a(lVar.e(), AbstractRMNResponse.class);
            CLog.b("RMNLibrary", lVar.e().toString());
            if (TextUtils.isEmpty(abstractRMNResponse.getStatus()) || !abstractRMNResponse.getStatus().equals("200")) {
                return;
            }
            String strA = g.a("sharedprefs.key.senderid", "", this);
            String strA2 = g.a("com.android.library.rmnlibrary.sharedprefs.key.registrationtoken", "", this);
            CLog.b("RMNLibrary", "Sender id in onSuccess " + strA);
            CLog.b("RMNLibrary", "Register id in onSuccess " + strA2);
            g.a(this, strA2);
            this.f2716a.onRegistrationSuccess(200, abstractRMNResponse.getMessage());
        }
    }
}
