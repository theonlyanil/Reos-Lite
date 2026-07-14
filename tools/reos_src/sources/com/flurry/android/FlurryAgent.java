package com.flurry.android;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.hl;
import com.flurry.sdk.je;
import com.flurry.sdk.js;
import com.flurry.sdk.jt;
import com.flurry.sdk.ju;
import com.flurry.sdk.kb;
import com.flurry.sdk.kc;
import com.flurry.sdk.kg;
import com.flurry.sdk.lg;
import com.flurry.sdk.lh;
import com.flurry.sdk.lk;
import com.flurry.sdk.lt;
import com.flurry.sdk.md;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class FlurryAgent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static FlurryAgentListener f4183b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4182a = FlurryAgent.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kb<lg> f4184c = new kb<lg>() { // from class: com.flurry.android.FlurryAgent.1
        @Override // com.flurry.sdk.kb
        public void a(final lg lgVar) {
            js.a().a(new Runnable() { // from class: com.flurry.android.FlurryAgent.1.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.f4187a[lgVar.f4682c.ordinal()]) {
                        case 1:
                            if (FlurryAgent.f4183b != null) {
                                FlurryAgent.f4183b.onSessionStarted();
                            }
                            break;
                    }
                }
            });
        }
    };

    /* JADX INFO: renamed from: com.flurry.android.FlurryAgent$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4187a = new int[lg.a.values().length];

        static {
            try {
                f4187a[lg.a.SESSION_ID_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private FlurryAgent() {
    }

    public static void addOrigin(String str, String str2) {
        addOrigin(str, str2, null);
    }

    public static void addOrigin(String str, String str2, Map<String, String> map) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("originName not specified");
        }
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("originVersion not specified");
        }
        try {
            ju.a().a(str, str2, map);
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
        }
    }

    public static void addSessionProperty(String str, String str2) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            kg.b(f4182a, "String name or value passed to addSessionProperty was null or empty.");
        } else {
            je.a().a(str, str2);
        }
    }

    public static void clearLocation() {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else {
            lk.a().a("ExplicitLocation", (Object) null);
        }
    }

    public static void endTimedEvent(String str) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            kg.b(f4182a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try {
            hl.a().b(str);
        } catch (Throwable th) {
            kg.a(f4182a, "Failed to signify the end of event: " + str, th);
        }
    }

    public static void endTimedEvent(String str, Map<String, String> map) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            kg.b(f4182a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        if (map == null) {
            kg.b(f4182a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try {
            hl.a().b(str, map);
        } catch (Throwable th) {
            kg.a(f4182a, "Failed to signify the end of event: " + str, th);
        }
    }

    public static int getAgentVersion() {
        return jt.a();
    }

    public static String getReleaseVersion() {
        return jt.f();
    }

    public static String getSessionId() {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return null;
        }
        try {
            return je.a().c();
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
            return null;
        }
    }

    public static synchronized void init(Context context, String str) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else {
            if (context == null) {
                throw new NullPointerException("Null context");
            }
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("apiKey not specified");
            }
            try {
                md.a();
                js.a(context, str);
            } catch (Throwable th) {
                kg.a(f4182a, "", th);
            }
        }
    }

    public static boolean isSessionActive() {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return false;
        }
        try {
            return lh.a().f();
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
            return false;
        }
    }

    public static FlurryEventRecordStatus logEvent(FlurrySyndicationEventName flurrySyndicationEventName, String str, Map<String, String> map) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return flurryEventRecordStatus;
        }
        if (flurrySyndicationEventName == null) {
            kg.b(f4182a, "String eventName passed to logEvent was null.");
            return flurryEventRecordStatus;
        }
        if (TextUtils.isEmpty(str)) {
            kg.b(f4182a, "String syndicationId passed to logEvent was null or empty.");
            return flurryEventRecordStatus;
        }
        if (map == null) {
            kg.b(f4182a, "String parameters passed to logEvent was null.");
            return flurryEventRecordStatus;
        }
        try {
            return hl.a().a(flurrySyndicationEventName.toString(), str, map);
        } catch (Throwable th) {
            kg.a(f4182a, "Failed to log event: " + flurrySyndicationEventName.toString(), th);
            return flurryEventRecordStatus;
        }
    }

    public static FlurryEventRecordStatus logEvent(String str) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return flurryEventRecordStatus;
        }
        if (str == null) {
            kg.b(f4182a, "String eventId passed to logEvent was null.");
            return flurryEventRecordStatus;
        }
        try {
            return hl.a().a(str);
        } catch (Throwable th) {
            kg.a(f4182a, "Failed to log event: " + str, th);
            return flurryEventRecordStatus;
        }
    }

    public static FlurryEventRecordStatus logEvent(String str, Map<String, String> map) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return flurryEventRecordStatus;
        }
        if (str == null) {
            kg.b(f4182a, "String eventId passed to logEvent was null.");
            return flurryEventRecordStatus;
        }
        if (map == null) {
            kg.b(f4182a, "String parameters passed to logEvent was null.");
            return flurryEventRecordStatus;
        }
        try {
            return hl.a().a(str, map);
        } catch (Throwable th) {
            kg.a(f4182a, "Failed to log event: " + str, th);
            return flurryEventRecordStatus;
        }
    }

    public static FlurryEventRecordStatus logEvent(String str, Map<String, String> map, boolean z) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return flurryEventRecordStatus;
        }
        if (str == null) {
            kg.b(f4182a, "String eventId passed to logEvent was null.");
            return flurryEventRecordStatus;
        }
        if (map == null) {
            kg.b(f4182a, "String parameters passed to logEvent was null.");
            return flurryEventRecordStatus;
        }
        try {
            return hl.a().a(str, map, z);
        } catch (Throwable th) {
            kg.a(f4182a, "Failed to log event: " + str, th);
            return flurryEventRecordStatus;
        }
    }

    public static FlurryEventRecordStatus logEvent(String str, boolean z) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return flurryEventRecordStatus;
        }
        if (str == null) {
            kg.b(f4182a, "String eventId passed to logEvent was null.");
            return flurryEventRecordStatus;
        }
        try {
            return hl.a().a(str, z);
        } catch (Throwable th) {
            kg.a(f4182a, "Failed to log event: " + str, th);
            return flurryEventRecordStatus;
        }
    }

    public static void onEndSession(Context context) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        if (js.a() == null) {
            throw new IllegalStateException("Flurry SDK must be initialized before ending a session");
        }
        try {
            lh.a().c(context);
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
        }
    }

    @Deprecated
    public static void onError(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            kg.b(f4182a, "String errorId passed to onError was null.");
            return;
        }
        if (str2 == null) {
            kg.b(f4182a, "String message passed to onError was null.");
            return;
        }
        if (str3 == null) {
            kg.b(f4182a, "String errorClass passed to onError was null.");
            return;
        }
        try {
            hl.a().a(str, str2, str3);
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
        }
    }

    public static void onError(String str, String str2, Throwable th) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            kg.b(f4182a, "String errorId passed to onError was null.");
            return;
        }
        if (str2 == null) {
            kg.b(f4182a, "String message passed to onError was null.");
            return;
        }
        if (th == null) {
            kg.b(f4182a, "Throwable passed to onError was null.");
            return;
        }
        try {
            hl.a().a(str, str2, th);
        } catch (Throwable th2) {
            kg.a(f4182a, "", th2);
        }
    }

    @Deprecated
    public static void onEvent(String str) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            kg.b(f4182a, "String eventId passed to onEvent was null.");
            return;
        }
        try {
            hl.a().c(str);
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
        }
    }

    @Deprecated
    public static void onEvent(String str, Map<String, String> map) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            kg.b(f4182a, "String eventId passed to onEvent was null.");
            return;
        }
        if (map == null) {
            kg.b(f4182a, "Parameters Map passed to onEvent was null.");
            return;
        }
        try {
            hl.a().c(str, map);
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
        }
    }

    public static void onPageView() {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        try {
            hl.a().g();
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
        }
    }

    public static void onStartSession(Context context) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        if (js.a() == null) {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        try {
            lh.a().b(context);
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
        }
    }

    @Deprecated
    public static void onStartSession(Context context, String str) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Api key not specified");
        }
        if (js.a() == null) {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        try {
            lh.a().b(context);
        } catch (Throwable th) {
            kg.a(f4182a, "", th);
        }
    }

    public static void setAge(int i) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else {
            if (i <= 0 || i >= 110) {
                return;
            }
            lk.a().a("Age", (Object) Long.valueOf(new Date(new Date(System.currentTimeMillis() - (((long) i) * 31449600000L)).getYear(), 1, 1).getTime()));
        }
    }

    public static void setCaptureUncaughtExceptions(boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else {
            lk.a().a("CaptureUncaughtExceptions", (Object) Boolean.valueOf(z));
        }
    }

    public static void setContinueSessionMillis(long j) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else if (j < 5000) {
            kg.b(f4182a, "Invalid time set for session resumption: " + j);
        } else {
            lk.a().a("ContinueSessionMillis", (Object) Long.valueOf(j));
        }
    }

    public static void setFlurryAgentListener(FlurryAgentListener flurryAgentListener) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else if (flurryAgentListener == null) {
            kg.b(f4182a, "Listener cannot be null");
            kc.a().b("com.flurry.android.sdk.FlurrySessionEvent", f4184c);
        } else {
            f4183b = flurryAgentListener;
            kc.a().a("com.flurry.android.sdk.FlurrySessionEvent", f4184c);
        }
    }

    public static void setGender(byte b2) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        }
        switch (b2) {
            case 0:
            case 1:
                lk.a().a("Gender", (Object) Byte.valueOf(b2));
                break;
            default:
                lk.a().a("Gender", (Object) (byte) -1);
                break;
        }
    }

    public static void setLocation(float f2, float f3) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        Location location = new Location("Explicit");
        location.setLatitude(f2);
        location.setLongitude(f3);
        lk.a().a("ExplicitLocation", (Object) location);
    }

    @Deprecated
    public static void setLocationCriteria(Criteria criteria) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        }
    }

    public static void setLogEnabled(boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else if (z) {
            kg.b();
        } else {
            kg.a();
        }
    }

    public static void setLogEvents(boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else {
            lk.a().a("LogEvents", (Object) Boolean.valueOf(z));
        }
    }

    public static void setLogLevel(int i) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else {
            kg.a(i);
        }
    }

    public static void setPulseEnabled(boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
            return;
        }
        lk.a().a("ProtonEnabled", (Object) Boolean.valueOf(z));
        if (z) {
            return;
        }
        lk.a().a("analyticsEnabled", (Object) true);
    }

    public static void setReportLocation(boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else {
            lk.a().a("ReportLocation", (Object) Boolean.valueOf(z));
        }
    }

    public static void setSessionOrigin(String str, String str2) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else if (TextUtils.isEmpty(str)) {
            kg.b(f4182a, "String originName passed to setSessionOrigin was null or empty.");
        } else {
            je.a().a(str);
            je.a().b(str2);
        }
    }

    public static void setUserId(String str) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else if (str == null) {
            kg.b(f4182a, "String userId passed to setUserId was null.");
        } else {
            lk.a().a("UserId", (Object) lt.b(str));
        }
    }

    public static void setVersionName(String str) {
        if (Build.VERSION.SDK_INT < 10) {
            kg.b(f4182a, "Device SDK Version older than 10");
        } else if (str == null) {
            kg.b(f4182a, "String versionName passed to setVersionName was null.");
        } else {
            lk.a().a("VersionName", (Object) str);
        }
    }
}
