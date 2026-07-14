package com.facebook.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.android.library.userprofile.util.Constants;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f3654a = {"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "gdpv4_chrome_custom_tabs_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, b> f3655b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f3656c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f3657d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f3658e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f3659f = -1;
    private static long g = -1;
    private static String h = "";
    private static String i = "";
    private static String j = "NoCarrier";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Uri f3667c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int[] f3668d;

        private a(String str, String str2, Uri uri, int[] iArr) {
            this.f3665a = str;
            this.f3666b = str2;
            this.f3667c = uri;
            this.f3668d = iArr;
        }

        private static int[] a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                int iOptInt = jSONArray.optInt(i, -1);
                if (iOptInt == -1) {
                    String strOptString = jSONArray.optString(i);
                    if (!ad.a(strOptString)) {
                        try {
                            iOptInt = Integer.parseInt(strOptString);
                        } catch (NumberFormatException e2) {
                            ad.a("FacebookSDK", (Exception) e2);
                            iOptInt = -1;
                        }
                    }
                }
                iArr[i] = iOptInt;
            }
            return iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("name");
            if (ad.a(strOptString)) {
                return null;
            }
            String[] strArrSplit = strOptString.split("\\|");
            if (strArrSplit.length != 2) {
                return null;
            }
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            if (ad.a(str) || ad.a(str2)) {
                return null;
            }
            String strOptString2 = jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
            return new a(str, str2, ad.a(strOptString2) ? null : Uri.parse(strOptString2), a(jSONObject.optJSONArray("versions")));
        }

        public String a() {
            return this.f3665a;
        }

        public String b() {
            return this.f3666b;
        }

        public int[] c() {
            return this.f3668d;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f3672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3673e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map<String, Map<String, a>> f3674f;
        private l g;

        private b(boolean z, String str, boolean z2, boolean z3, int i, Map<String, Map<String, a>> map, l lVar) {
            this.f3669a = z;
            this.f3670b = str;
            this.f3671c = z2;
            this.f3672d = z3;
            this.f3674f = map;
            this.g = lVar;
            this.f3673e = i;
        }

        public boolean a() {
            return this.f3669a;
        }

        public String b() {
            return this.f3670b;
        }

        public boolean c() {
            return this.f3671c;
        }

        public boolean d() {
            return this.f3672d;
        }

        public Map<String, Map<String, a>> e() {
            return this.f3674f;
        }

        public l f() {
            return this.g;
        }
    }

    public interface c {
        void a(com.facebook.k kVar);

        void a(JSONObject jSONObject);
    }

    public interface d<T, K> {
        K a(T t);
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<String> f3675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<String> f3676b;

        public e(List<String> list, List<String> list2) {
            this.f3675a = list;
            this.f3676b = list2;
        }

        public List<String> a() {
            return this.f3675a;
        }

        public List<String> b() {
            return this.f3676b;
        }
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        int i2 = 0;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i3 = bufferedInputStream.read(bArr);
                    if (i3 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, i3);
                    i2 += i3;
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return i2;
            } catch (Throwable th) {
                th = th;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    private static long a(double d2) {
        return Math.round(d2 / 1.073741824E9d);
    }

    public static Uri a(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        return builder.build();
    }

    public static a a(String str, String str2, String str3) {
        Map<String, a> map;
        if (a(str2) || a(str3)) {
            return null;
        }
        b bVar = f3655b.get(str);
        if (bVar == null || (map = bVar.e().get(str2)) == null) {
            return null;
        }
        return map.get(str3);
    }

    public static b a(String str, boolean z) {
        if (!z && f3655b.containsKey(str)) {
            return f3655b.get(str);
        }
        JSONObject jSONObjectG = g(str);
        if (jSONObjectG == null) {
            return null;
        }
        return b(str, jSONObjectG);
    }

    public static e a(JSONObject jSONObject) throws JSONException {
        String strOptString;
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            String strOptString2 = jSONObjectOptJSONObject.optString("permission");
            if (strOptString2 != null && !strOptString2.equals("installed") && (strOptString = jSONObjectOptJSONObject.optString(Constants.SMS_COLUMN_STATUS)) != null) {
                if (strOptString.equals("granted")) {
                    arrayList.add(strOptString2);
                } else if (strOptString.equals("declined")) {
                    arrayList2.add(strOptString2);
                }
            }
        }
        return new e(arrayList, arrayList2);
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            return null;
        } catch (InvocationTargetException e3) {
            return null;
        }
    }

    public static Object a(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object objOpt = jSONObject.opt(str);
        Object objNextValue = (objOpt == null || !(objOpt instanceof String)) ? objOpt : new JSONTokener((String) objOpt).nextValue();
        if (objNextValue == null || (objNextValue instanceof JSONObject) || (objNextValue instanceof JSONArray)) {
            return objNextValue;
        }
        if (str2 == null) {
            throw new com.facebook.k("Got an unexpected non-JSON object.");
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt(str2, objNextValue);
        return jSONObject2;
    }

    public static String a(int i2) {
        return new BigInteger(i2 * 5, new Random()).toString(32);
    }

    public static String a(Context context) {
        ae.a(context, "context");
        com.facebook.m.a(context);
        return com.facebook.m.i();
    }

    public static String a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public static String a(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream2);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int i2 = inputStreamReader.read(cArr);
                        if (i2 == -1) {
                            String string = sb.toString();
                            a((Closeable) bufferedInputStream2);
                            a(inputStreamReader);
                            return string;
                        }
                        sb.append(cArr, 0, i2);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    a((Closeable) bufferedInputStream);
                    a(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
                bufferedInputStream = bufferedInputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static String a(String str, byte[] bArr) {
        try {
            return a(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }

    private static String a(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArrDigest) {
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString((b2 >> 0) & 15));
        }
        return sb.toString();
    }

    public static String a(byte[] bArr) {
        return a("SHA-1", bArr);
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    public static Method a(String str, String str2, Class<?>... clsArr) {
        try {
            return a(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    public static <T> Collection<T> a(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    public static Date a(Bundle bundle, String str, Date date) {
        long jLongValue;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            jLongValue = ((Long) obj).longValue();
        } else {
            if (!(obj instanceof String)) {
                return null;
            }
            try {
                jLongValue = Long.parseLong((String) obj);
            } catch (NumberFormatException e2) {
                return null;
            }
        }
        if (jLongValue == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date((jLongValue * 1000) + date.getTime());
    }

    public static <T, K> List<K> a(List<T> list, d<T, K> dVar) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            K kA = dVar.a(it.next());
            if (kA != null) {
                arrayList.add(kA);
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        return null;
    }

    public static List<String> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        return arrayList;
    }

    public static Map<String, String> a(Parcel parcel) {
        int i2 = parcel.readInt();
        if (i2 < 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < i2; i3++) {
            map.put(parcel.readString(), parcel.readString());
        }
        return map;
    }

    public static void a(final Context context, final String str) {
        boolean zCompareAndSet = f3656c.compareAndSet(false, true);
        if (a(str) || f3655b.containsKey(str) || !zCompareAndSet) {
            return;
        }
        final String str2 = String.format("com.facebook.internal.APP_SETTINGS.%s", str);
        com.facebook.m.d().execute(new Runnable() { // from class: com.facebook.b.ad.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                String string = sharedPreferences.getString(str2, null);
                if (!ad.a(string)) {
                    try {
                        jSONObject = new JSONObject(string);
                    } catch (JSONException e2) {
                        ad.a("FacebookSDK", (Exception) e2);
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        ad.b(str, jSONObject);
                    }
                }
                JSONObject jSONObjectG = ad.g(str);
                if (jSONObjectG != null) {
                    ad.b(str, jSONObjectG);
                    sharedPreferences.edit().putString(str2, jSONObjectG.toString()).apply();
                }
                ad.f3656c.set(false);
            }
        });
    }

    public static void a(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            a(bundle, str, uri.toString());
        }
    }

    public static void a(Bundle bundle, String str, String str2) {
        if (a(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    public static void a(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file.exists()) {
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    a(file2);
                }
            }
            file.delete();
        }
    }

    public static void a(final String str, final c cVar) {
        JSONObject jSONObjectA = aa.a(str);
        if (jSONObjectA != null) {
            cVar.a(jSONObjectA);
            return;
        }
        GraphRequest.b bVar = new GraphRequest.b() { // from class: com.facebook.b.ad.2
            @Override // com.facebook.GraphRequest.b
            public void a(com.facebook.r rVar) {
                if (rVar.a() != null) {
                    cVar.a(rVar.a().f());
                } else {
                    aa.a(str, rVar.b());
                    cVar.a(rVar.b());
                }
            }
        };
        GraphRequest graphRequestH = h(str);
        graphRequestH.a(bVar);
        graphRequestH.j();
    }

    public static void a(String str, Exception exc) {
        if (!com.facebook.m.b() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
    }

    public static void a(String str, String str2) {
        if (!com.facebook.m.b() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!com.facebook.m.b() || a(str)) {
            return;
        }
        Log.d(str, str2, th);
    }

    public static void a(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    public static void a(JSONObject jSONObject, Context context) throws JSONException {
        Locale locale;
        int i2;
        int i3;
        int i4;
        int i5;
        double d2;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        d(context);
        String packageName = context.getPackageName();
        int i6 = -1;
        String str = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i6 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i6);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception e3) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(h);
        jSONArray.put(j);
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int i7 = displayMetrics.widthPixels;
                try {
                    int i8 = displayMetrics.heightPixels;
                    try {
                        d2 = displayMetrics.density;
                        i4 = i8;
                        i5 = i7;
                    } catch (Exception e4) {
                        i2 = i8;
                        i3 = i7;
                        i4 = i2;
                        i5 = i3;
                        d2 = 0.0d;
                    }
                } catch (Exception e5) {
                    i2 = 0;
                    i3 = i7;
                }
            } else {
                d2 = 0.0d;
                i4 = 0;
                i5 = 0;
            }
        } catch (Exception e6) {
            i2 = 0;
            i3 = 0;
        }
        jSONArray.put(i5);
        jSONArray.put(i4);
        jSONArray.put(String.format("%.2f", Double.valueOf(d2)));
        jSONArray.put(b());
        jSONArray.put(f3659f);
        jSONArray.put(g);
        jSONArray.put(i);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static void a(JSONObject jSONObject, com.facebook.b.c cVar, String str, boolean z) throws JSONException {
        if (cVar != null && cVar.a() != null) {
            jSONObject.put("attribution", cVar.a());
        }
        if (cVar != null && cVar.b() != null) {
            jSONObject.put("advertiser_id", cVar.b());
            jSONObject.put("advertiser_tracking_enabled", !cVar.d());
        }
        if (cVar != null && cVar.c() != null) {
            jSONObject.put("installer_package", cVar.c());
        }
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", z ? false : true);
    }

    public static boolean a(AccessToken accessToken) {
        if (accessToken != null) {
            return accessToken.equals(AccessToken.a());
        }
        return false;
    }

    public static <T> boolean a(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return t.equals(t2);
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static <T> boolean a(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    private static int b() {
        if (f3657d > 0) {
            return f3657d;
        }
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.b.ad.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]+", str);
                }
            });
            if (fileArrListFiles != null) {
                f3657d = fileArrListFiles.length;
            }
        } catch (Exception e2) {
        }
        if (f3657d <= 0) {
            f3657d = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return f3657d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b b(String str, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("android_sdk_error_categories");
        b bVar = new b(jSONObject.optBoolean("supports_implicit_sdk_logging", false), jSONObject.optString("gdpv4_nux_content", ""), jSONObject.optBoolean("gdpv4_nux_enabled", false), jSONObject.optBoolean("gdpv4_chrome_custom_tabs_enabled", false), jSONObject.optInt("app_events_session_timeout", com.facebook.a.a.b.a()), b(jSONObject.optJSONObject("android_dialog_configs")), jSONArrayOptJSONArray == null ? l.a() : l.a(jSONArrayOptJSONArray));
        f3655b.put(str, bVar);
        return bVar;
    }

    public static String b(String str) {
        return b("MD5", str);
    }

    private static String b(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static <T> List<T> b(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    private static Map<String, Map<String, a>> b(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        HashMap map = new HashMap();
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArrayOptJSONArray.length()) {
                    break;
                }
                a aVarB = a.b(jSONArrayOptJSONArray.optJSONObject(i3));
                if (aVarB != null) {
                    String strA = aVarB.a();
                    Map map2 = (Map) map.get(strA);
                    if (map2 == null) {
                        map2 = new HashMap();
                        map.put(strA, map2);
                    }
                    map2.put(aVarB.b(), aVarB);
                }
                i2 = i3 + 1;
            }
        }
        return map;
    }

    public static Set<String> b(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(jSONArray.getString(i2));
        }
        return hashSet;
    }

    public static void b(Context context) {
        b(context, "facebook.com");
        b(context, ".facebook.com");
        b(context, "https://facebook.com");
        b(context, "https://.facebook.com");
    }

    private static void b(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        String[] strArrSplit = cookie.split(";");
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("=");
            if (strArrSplit2.length > 0) {
                cookieManager.setCookie(str, strArrSplit2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        cookieManager.removeExpiredCookie();
    }

    public static boolean b(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()));
    }

    public static Bundle c(String str) {
        Bundle bundle = new Bundle();
        if (!a(str)) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                try {
                    if (strArrSplit.length == 2) {
                        bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8"));
                    } else if (strArrSplit.length == 1) {
                        bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e2) {
                    a("FacebookSDK", (Exception) e2);
                }
            }
        }
        return bundle;
    }

    public static String c(Context context) {
        if (context == null) {
            return "null";
        }
        return context == context.getApplicationContext() ? "unknown" : context.getClass().getSimpleName();
    }

    private static void c() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            h = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            i = timeZone.getID();
        } catch (Exception e2) {
        }
    }

    public static boolean c(Uri uri) {
        return uri != null && "content".equalsIgnoreCase(uri.getScheme());
    }

    public static b d(String str) {
        if (str != null) {
            return f3655b.get(str);
        }
        return null;
    }

    private static void d(Context context) {
        if (f3658e == -1 || System.currentTimeMillis() - f3658e >= 1800000) {
            f3658e = System.currentTimeMillis();
            c();
            e(context);
            f();
            e();
        }
    }

    private static boolean d() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean d(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    public static long e(Uri uri) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = com.facebook.m.f().getContentResolver().query(uri, null, null, null, null);
            try {
                int columnIndex = cursorQuery.getColumnIndex("_size");
                cursorQuery.moveToFirst();
                long j2 = cursorQuery.getLong(columnIndex);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return j2;
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    public static JSONObject e(String str) {
        JSONObject jSONObjectA = aa.a(str);
        if (jSONObjectA != null) {
            return jSONObjectA;
        }
        com.facebook.r rVarI = h(str).i();
        if (rVarI.a() != null) {
            return null;
        }
        return rVarI.b();
    }

    private static void e() {
        try {
            if (d()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                g = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            }
            g = a(g);
        } catch (Exception e2) {
        }
    }

    private static void e(Context context) {
        if (j.equals("NoCarrier")) {
            try {
                j = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e2) {
            }
        }
    }

    private static void f() {
        try {
            if (d()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f3659f = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
            f3659f = a(f3659f);
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject g(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", f3654a));
        GraphRequest graphRequestA = GraphRequest.a((AccessToken) null, str, (GraphRequest.b) null);
        graphRequestA.a(true);
        graphRequestA.a(bundle);
        return graphRequestA.i().b();
    }

    private static GraphRequest h(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, com.facebook.s.GET, null);
    }
}
