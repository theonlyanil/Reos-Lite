package com.android.apps.config;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import com.android.apps.config.util.CLog;
import com.android.library.deviceData.c.b;
import com.android.library.http.HTTPLibrary;
import com.android.library.rmnlibrary.GCMListenerService;
import f.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Config {
    public static final String APPEND_URL = "config/";
    public static final String CONFIG = "config";
    public static final String RESPONSE = "response";
    private static volatile Config i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2525f;
    private final double g = 24.0d;
    private final ArrayList<a> j = new ArrayList<>();
    private final ConcurrentHashMap<String, String> h = new ConcurrentHashMap<>();

    public static class UpdateConfig extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Config f2530a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CLog.b("config.logs", "Action received is " + intent.getAction());
            this.f2530a = Config.getInstance(context);
            if (intent.getAction().equals("UPDATE_CONFIGURATION") || intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                long millis = (long) (24.0d * TimeUnit.HOURS.toMillis(1L));
                try {
                    millis = (long) (TimeUnit.HOURS.toMillis(1L) * Double.parseDouble(this.f2530a.get("configLib.updateTime")));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                CLog.b("config.logs", "Update timer interval " + millis);
                if (this.f2530a.c(context) < millis) {
                    CLog.b("config.logs", "Time difference " + this.f2530a.c(context));
                    CLog.b("config.logs", "Update Interval Millis " + millis);
                } else {
                    this.f2530a.updateConfigNow(context);
                    CLog.b("config.logs", "Server url is " + this.f2530a.get("configLib.getBaseUrl"));
                }
            }
        }
    }

    public interface a {
        void onConfigUpdate();
    }

    private Config() {
    }

    private long a() {
        return new Date().getTime();
    }

    private synchronized String a(Context context, String str) {
        String strValueOf = null;
        synchronized (this) {
            try {
                try {
                    if (fileExistence(context, str)) {
                        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
                        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        }
                        CLog.b("config.logs", "Local File Config are " + String.valueOf(sb));
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStreamOpenFileInput.close();
                        strValueOf = String.valueOf(sb);
                    }
                } catch (IOException e2) {
                    CLog.d("config.logs.excep", "Exception in CONFIGURATION_MAP class,IOException Method ->" + e2);
                    e2.printStackTrace();
                }
            } catch (FileNotFoundException e3) {
                CLog.d("config.logs.excep", "Exception in CONFIGURATION_MAP class,readConfigFromFile Method,file not found ->" + e3);
                e3.printStackTrace();
            }
        }
        return strValueOf;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0074 A[Catch: all -> 0x0062, Exception -> 0x007d, TryCatch #10 {Exception -> 0x007d, blocks: (B:44:0x006f, B:46:0x0074, B:48:0x0079), top: B:70:0x006f, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0079 A[Catch: all -> 0x0062, Exception -> 0x007d, TRY_LEAVE, TryCatch #10 {Exception -> 0x007d, blocks: (B:44:0x006f, B:46:0x0074, B:48:0x0079), top: B:70:0x006f, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private synchronized String a(String str, Context context) {
        InputStreamReader inputStreamReader;
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        InputStream inputStream;
        String strDecryptConfig;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        inputStreamReader = null;
        bufferedReader2 = null;
        InputStreamReader inputStreamReader2 = null;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            try {
                inputStreamOpen = context.getResources().getAssets().open(str, 0);
                try {
                    inputStreamReader = new InputStreamReader(inputStreamOpen);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            } catch (Exception e2) {
                                e = e2;
                                inputStreamReader2 = inputStreamReader;
                                inputStream = inputStreamOpen;
                                try {
                                    e.getMessage();
                                    if (inputStreamReader2 != null) {
                                        try {
                                            inputStreamReader2.close();
                                        } catch (Exception e3) {
                                            e3.getMessage();
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    inputStreamOpen = inputStream;
                                    inputStreamReader = inputStreamReader2;
                                    bufferedReader2 = bufferedReader;
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (Exception e4) {
                                            e4.getMessage();
                                            throw th;
                                        }
                                    }
                                    if (inputStreamOpen != null) {
                                        inputStreamOpen.close();
                                    }
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader2 = bufferedReader;
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (inputStreamOpen != null) {
                                    inputStreamOpen.close();
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                throw th;
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Exception e5) {
                                e5.getMessage();
                            }
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Exception e6) {
                        e = e6;
                        bufferedReader = null;
                        inputStreamReader2 = inputStreamReader;
                        inputStream = inputStreamOpen;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e7) {
                    e = e7;
                    bufferedReader = null;
                    inputStream = inputStreamOpen;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                }
            } catch (Exception e8) {
                e = e8;
                bufferedReader = null;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                inputStreamOpen = null;
            }
            strDecryptConfig = decryptConfig(c(), String.valueOf(sb));
        }
        return strDecryptConfig;
    }

    private String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            int i2 = (b2 >>> 4) & 15;
            int i3 = 0;
            while (true) {
                if (i2 < 0 || i2 > 9) {
                    sb.append((char) ((i2 - 10) + 97));
                } else {
                    sb.append((char) (i2 + 48));
                }
                int i4 = b2 & 15;
                int i5 = i3 + 1;
                if (i3 >= 1) {
                    break;
                }
                i3 = i5;
                i2 = i4;
            }
        }
        return sb.toString();
    }

    private void a(final Context context) throws JSONException {
        if (this.f2520a) {
            return;
        }
        this.f2521b = context.getPackageName();
        this.f2522c = this.f2521b + "Config.json";
        this.f2523d = "." + this.f2521b + "ConfigLocalConfig.json";
        this.f2524e = "." + this.f2521b + "backupConfig.json";
        this.f2525f = "." + this.f2521b + "ConfigMeta.json";
        if (d(context)) {
            CLog.a(context.getPackageName());
        }
        CLog.b("config.logs", "Package name retreived is " + this.f2521b);
        String strB = b(b(), context);
        CLog.b("config.logs", "Tester config are " + strB);
        boolean zF = f(context);
        if ((fileExistence(context, this.f2523d) || fileExistence(context, this.f2524e)) && !zF) {
            String strDecryptConfig = decryptConfig(Settings.Secure.getString(context.getContentResolver(), "android_id"), a(context, this.f2523d));
            CLog.b(CONFIG, "json" + strDecryptConfig);
            if (strDecryptConfig == null || strDecryptConfig.length() <= 0) {
                String strDecryptConfig2 = decryptConfig(Settings.Secure.getString(context.getContentResolver(), "android_id"), a(context, this.f2524e));
                CLog.b("config.logs", "backup config are" + strDecryptConfig2);
                if (strDecryptConfig2 == null || strDecryptConfig2.length() <= 0) {
                    a(b(context), strB);
                } else {
                    a(strDecryptConfig2, strB);
                }
            } else {
                a(strDecryptConfig, strB);
            }
            CLog.b("config.logs", "Configuration after putting in hashmap are " + this.h.get("jsonObject"));
        } else {
            a(b(context), strB);
            CLog.b("config.logs", "default config after putting in hashmap are " + this.h.get("jsonObject"));
        }
        if (get("configLib.getBaseUrl") == null) {
            throw new JSONException("configLib.getBaseUrl key not found");
        }
        if (get("configLib.updateTime") != null) {
            CLog.b("config.logs", "New time interval " + get("configLib.updateTime"));
        } else {
            CLog.b("config.logs", "UpdateConfig not found 24.0");
        }
        a(context, false);
        GCMListenerService.a(CONFIG, new com.android.library.rmnlibrary.a.a() { // from class: com.android.apps.config.Config.1
            @Override // com.android.library.rmnlibrary.a.a
            public void a(String str, String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2).getJSONObject(Config.RESPONSE).getJSONObject(Config.CONFIG);
                    if (jSONObject == null || !String.valueOf(true).equals(jSONObject.getString("refetch"))) {
                        return;
                    }
                    Config.this.updateConfigNow(context);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.f2520a = true;
    }

    private void a(Context context, long j, long j2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lastServerAccessTime", j);
            jSONObject.put("lastConfigUpdateTime", j2);
            a(context, this.f2525f, String.valueOf(jSONObject));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, boolean z) {
        if (z || !e(context)) {
            context.sendBroadcast(new Intent("UPDATE_CONFIGURATION"));
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("UPDATE_CONFIGURATION"), 134217728);
            long millis = (long) (24.0d * TimeUnit.HOURS.toMillis(1L));
            try {
                millis = (long) (Double.parseDouble(getInstance(context).get("configLib.updateTime")) * TimeUnit.HOURS.toMillis(1L));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            alarmManager.setRepeating(0, System.currentTimeMillis() + TimeUnit.HOURS.toMillis(new Random().nextInt(24)), millis, broadcast);
        }
    }

    private void a(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (str2 != null) {
            try {
                try {
                    jSONObject2 = new JSONObject(str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject = null;
                }
            } catch (JSONException e3) {
                CLog.b("config.logs.excep", "Excep in Config,copyFieldsFromTesterFile", e3);
                e3.printStackTrace();
                this.h.put("jsonObject", String.valueOf(str));
                return;
            }
        } else {
            jSONObject2 = null;
        }
        jSONObject = jSONObject2;
        JSONObject jSONObject3 = new JSONObject(str);
        if (jSONObject == null) {
            this.h.put("jsonObject", String.valueOf(jSONObject3));
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (jSONObject3.has(next)) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(next);
                JSONObject jSONObject5 = jSONObject3.getJSONObject(next);
                Iterator<String> itKeys2 = jSONObject4.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (jSONObject5.has(next2)) {
                        JSONObject jSONObject6 = jSONObject4.getJSONObject(next2);
                        JSONObject jSONObject7 = jSONObject5.getJSONObject(next2);
                        Iterator<String> itKeys3 = jSONObject6.keys();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            if (jSONObject7.has(next3)) {
                                jSONObject3.getJSONObject(next).getJSONObject(next2).put(next3, jSONObject6.getString(next3));
                                CLog.b("config.logs", "Overriden " + next3);
                            }
                        }
                        CLog.b("config.logs", "Attribute json is " + jSONObject6.toString());
                    }
                }
            }
        }
        this.h.put("jsonObject", String.valueOf(jSONObject3));
    }

    private synchronized boolean a(Context context, String str, String str2) {
        boolean z = false;
        synchronized (this) {
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(str, 0));
                outputStreamWriter.write(str2);
                outputStreamWriter.close();
                z = true;
            } catch (Exception e2) {
                CLog.d("config.logs.excep", "Exception in CONFIGURATION_MAP class,writeToConfigFile Method ->" + e2);
                e2.printStackTrace();
            }
        }
        return z;
    }

    private String b() {
        String str = String.valueOf(Environment.getExternalStorageDirectory()) + "/" + this.f2521b;
        CLog.b("config.logs", "tester path is " + str);
        return str + "/testConfig.json";
    }

    private String b(Context context) {
        String strA = a(this.f2522c, context);
        String strEncryptConfig = encryptConfig(Settings.Secure.getString(context.getContentResolver(), "android_id"), strA);
        CLog.b("config.logs", "Default configuration are " + strA);
        a(context, this.f2523d, strEncryptConfig);
        a(context, this.f2524e, strEncryptConfig);
        return strA;
    }

    private String b(String str, Context context) {
        if (d(context)) {
            File file = new File(str);
            if (file.exists()) {
                StringBuilder sb = new StringBuilder();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            return String.valueOf(sb);
                        }
                        sb.append(line);
                        sb.append('\n');
                    }
                } catch (IOException e2) {
                    CLog.d("config.logs.excep", "Exception in Config class,readConfigFromTesterFile " + e2);
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Context context, String str) {
        CLog.b("config.logs", "updateConfig and serverUrl is " + str + "");
        boolean z = false;
        if (str != null) {
            try {
                a(context, a(), 0L);
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = new JSONObject(this.h.get("jsonObject"));
                CLog.b("config.logs", "Config json receive from server " + str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (jSONObject2.has(next)) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject(next);
                        JSONObject jSONObject4 = jSONObject2.getJSONObject(next);
                        Iterator<String> itKeys2 = jSONObject3.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            if (jSONObject4.has(next2)) {
                                JSONObject jSONObject5 = jSONObject3.getJSONObject(next2);
                                JSONObject jSONObject6 = jSONObject4.getJSONObject(next2);
                                String string = jSONObject5.getString("override");
                                String string2 = jSONObject5.getString("value");
                                String string3 = jSONObject6.getString("override");
                                String string4 = jSONObject6.getString("value");
                                if (string3.equals("0")) {
                                    if (string.equals("1")) {
                                        jSONObject2.getJSONObject(next).getJSONObject(next2).put("value", string2);
                                        jSONObject2.getJSONObject(next).getJSONObject(next2).put("override", string);
                                        z = true;
                                    }
                                } else if (!string2.equals(string4)) {
                                    jSONObject2.getJSONObject(next).getJSONObject(next2).put("value", string2);
                                    jSONObject2.getJSONObject(next).getJSONObject(next2).put("override", 1);
                                    z = true;
                                }
                                CLog.b("config.logs", "Attribute json is " + jSONObject5.toString());
                            }
                        }
                    }
                }
                if (z) {
                    this.h.put("jsonObject", String.valueOf(jSONObject2));
                    String strEncryptConfig = encryptConfig(Settings.Secure.getString(context.getContentResolver(), "android_id"), String.valueOf(jSONObject2));
                    a(context, this.f2523d, strEncryptConfig);
                    a(context, this.f2524e, strEncryptConfig);
                    a(context, a(), a());
                }
            } catch (JSONException e2) {
                boolean z2 = z;
                CLog.d("config.logs.excep", "JsonException in UpdateConfig class,updateConfig " + e2);
                e2.printStackTrace();
                return z2;
            } catch (Exception e3) {
                boolean z3 = z;
                CLog.d("config.logs.excep", "Exception in UpdateConfig class,updateConfig " + e3);
                e3.printStackTrace();
                return z3;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(Context context) {
        long jA;
        try {
            if (fileExistence(context, this.f2525f)) {
                long j = new JSONObject(a(context, this.f2525f)).getLong("lastServerAccessTime");
                CLog.b("config.logs", "timeInMilliSec " + j);
                jA = a() - j;
                CLog.b("config.logs", "diff in mill sec " + jA);
            } else {
                jA = (long) (24.0d * TimeUnit.HOURS.toMillis(1L));
                try {
                    jA = (long) (TimeUnit.HOURS.toMillis(1L) * Double.parseDouble(getInstance(context).get("configLib.updateTime")));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return jA;
        } catch (JSONException e3) {
            CLog.b("config.logs.excep", "Exception in class Config,method getTimeDiffInMilliSec " + e3.getMessage());
            e3.printStackTrace();
            return 0L;
        }
    }

    private String c() {
        return getHash(this.f2521b + 308915776);
    }

    private boolean d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int iCheckPermission = packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName());
        int iCheckPermission2 = packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", context.getPackageName());
        if (iCheckPermission != 0) {
            CLog.d("config.logs", "Storage Write permission not granted");
        }
        if (iCheckPermission2 != 0) {
            CLog.d("config.logs", "Storage Read permission not granted");
        }
        return iCheckPermission2 == 0 && iCheckPermission == 0;
    }

    private boolean e(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent("UPDATE_CONFIGURATION"), 536870912) != null;
    }

    private boolean f(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.android.library.config", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        int i2 = sharedPreferences.getInt("lastVersionCode", -1);
        int iG = g(context);
        if (iG <= i2) {
            return false;
        }
        editorEdit.putInt("lastVersionCode", iG);
        editorEdit.apply();
        return true;
    }

    private int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        } catch (Exception e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public static Config getInstance(Context context) {
        if (i == null) {
            synchronized (Config.class) {
                if (i == null) {
                    i = new Config();
                }
            }
        }
        if (context == null) {
            Log.d("config.logs.excep", "initialize config again with live context");
        } else {
            try {
                i.a(context);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return i;
    }

    private String h(Context context) {
        return "config/?manufacturer=" + com.android.library.deviceData.c.a.d() + "&model=" + com.android.library.deviceData.c.a.b() + "&mcc=" + b.a(context).d() + "," + b.a(context).c() + "&mnc=" + b.a(context).e() + "," + b.a(context).f() + "&android_api_level=" + Build.VERSION.SDK_INT + "&operator=" + b.a(context).g() + "," + b.a(context).h() + "&package_name=" + context.getPackageName() + "&version=" + get("configLib.version");
    }

    public synchronized boolean commitConfig(Context context) {
        boolean z;
        String strEncryptConfig = encryptConfig(Settings.Secure.getString(context.getContentResolver(), "android_id"), this.h.get("jsonObject"));
        z = false;
        if (a(context, this.f2523d, strEncryptConfig) && a(context, this.f2524e, strEncryptConfig)) {
            z = true;
        }
        return z;
    }

    public String decryptConfig(String str, String str2) {
        try {
            return com.android.apps.config.a.a.b(str, str2);
        } catch (Exception e2) {
            CLog.b("config.logs", "Exception in Config, decryptConfig" + e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    public String encryptConfig(String str, String str2) {
        try {
            return com.android.apps.config.a.a.a(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean fileExistence(Context context, String str) {
        return context.getFileStreamPath(str).exists();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0084  */
    public synchronized String get(String str) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject(this.h.get("jsonObject"));
            String[] strArrSplit = str.split("\\.");
            if (jSONObject.has(strArrSplit[0])) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(strArrSplit[0]);
                if (jSONObject2.has(strArrSplit[1])) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(strArrSplit[1]);
                    if (jSONObject3.has("value")) {
                        CLog.b("config.logs", "Components value is " + jSONObject3.getString("value"));
                        string = jSONObject3.getString("value");
                    } else {
                        string = null;
                    }
                } else {
                    string = null;
                }
            } else {
                string = null;
            }
        } catch (JSONException e2) {
            CLog.d("config.logs.excep", "Exception in Config class,get method,jsonException catch clause " + e2.getMessage());
            e2.printStackTrace();
        } catch (Exception e3) {
            CLog.d("config.logs.excep", "Exception in Config class,get method,exception catch clause " + e3.getMessage());
            e3.printStackTrace();
        }
        return string;
    }

    @Deprecated
    public synchronized String get(String str, String str2) {
        return get(str);
    }

    public String getHash(String str) {
        byte[] bArrDigest;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            bArrDigest = messageDigest.digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            bArrDigest = null;
        }
        return a(bArrDigest);
    }

    public void onBoot(Context context) {
        a(context, false);
    }

    public synchronized boolean put(String str, String str2) {
        boolean z;
        try {
            String[] strArrSplit = str.split("\\.");
            JSONObject jSONObject = new JSONObject(this.h.get("jsonObject"));
            if (!jSONObject.has(strArrSplit[0]) || str2 == null) {
                throw new Exception(str + " cannot be modified");
            }
            if (strArrSplit[1].equals("modifiableBy")) {
                z = false;
            } else {
                if (!jSONObject.getJSONObject(strArrSplit[0]).getJSONObject(strArrSplit[1]).getString("modifiableBy").equals("other")) {
                    throw new Exception(str + " can only be modified by server");
                }
                jSONObject.getJSONObject(strArrSplit[0]).getJSONObject(strArrSplit[1]).put("value", str2);
                jSONObject.getJSONObject(strArrSplit[0]).getJSONObject(strArrSplit[1]).put("override", 0);
                this.h.put("jsonObject", String.valueOf(jSONObject));
                z = true;
            }
        } catch (Exception e2) {
            CLog.a("config.logs.excep", "Exception in Config class,put method " + e2);
            e2.printStackTrace();
        }
        return z;
    }

    public void registerConfigUpdateCallback(a aVar) {
        if (aVar == null || this.j.contains(aVar)) {
            return;
        }
        this.j.add(aVar);
    }

    public void updateConfigNow(final Context context) {
        CLog.b("config.logs", "retrofit reached ");
        HTTPLibrary.get(context, new HTTPLibrary.b() { // from class: com.android.apps.config.Config.2
            @Override // com.android.library.http.HTTPLibrary.b
            public void onError(int i2, l<com.google.a.l> lVar) {
                CLog.b("config.logs", "Response onError " + lVar.f());
            }

            @Override // com.android.library.http.HTTPLibrary.b
            public void onFailure(Throwable th) {
                CLog.b("config.logs", "Response failure " + th);
            }

            @Override // com.android.library.http.HTTPLibrary.b
            public void onSuccess(int i2, l<com.google.a.l> lVar) {
                CLog.b("config.logs", "retrofit response code " + lVar.b() + " " + lVar.d());
                CLog.b("config.logs", "reponse body " + String.valueOf(lVar.e()));
                if (Config.this.b(context, String.valueOf(lVar.e()))) {
                    Config.this.a(context, true);
                    for (a aVar : Config.getInstance(context).j) {
                        if (aVar != null) {
                            aVar.onConfigUpdate();
                        }
                    }
                }
            }
        }, 0, get("configLib.getBaseUrl"), h(context), null);
    }
}
