package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.location.places.Place;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class lt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4726a = lt.class.getSimpleName();

    public static double a(double d2, int i) {
        return Math.round(Math.pow(10.0d, i) * d2) / Math.pow(10.0d, i);
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[Place.TYPE_SUBLOCALITY_LEVEL_2];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i < 0) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static String a(String str) {
        Uri uri;
        return (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || uri.getScheme() != null) ? str : "http://" + str;
    }

    public static String a(String str, int i) {
        if (str == null) {
            return "";
        }
        return str.length() > i ? str.substring(0, i) : str;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (byte b2 : bArr) {
            sb.append(cArr[(byte) ((b2 & 240) >> 4)]);
            sb.append(cArr[(byte) (b2 & 15)]);
        }
        return sb.toString();
    }

    public static void a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be called from the main thread!");
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static boolean a(long j) {
        return j == 0 || System.currentTimeMillis() <= j;
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e2) {
            kg.a(6, f4726a, "Error occured when checking if app has permission.  Error: " + e2.getMessage());
            return false;
        }
    }

    public static boolean a(Intent intent) {
        return js.a().e().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String b(String str) {
        return a(str, 255);
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            kg.a(5, f4726a, "Unsupported ISO-8859-1:" + e2.getMessage());
            return null;
        }
    }

    public static void b() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
        }
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            kg.a(5, f4726a, "Cannot encode '" + str + "'");
            return "";
        }
    }

    public static String d(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            kg.a(5, f4726a, "Cannot decode '" + str + "'");
            return "";
        }
    }

    public static byte[] e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            kg.a(5, f4726a, "Unsupported UTF-8: " + e2.getMessage());
            return null;
        }
    }

    public static byte[] f(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes(), 0, str.length());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            kg.a(6, f4726a, "Unsupported SHA1: " + e2.getMessage());
            return null;
        }
    }

    public static String g(String str) {
        return str.replace("\\b", "").replace("\\n", "").replace("\\r", "").replace("\\t", "").replace("\\", "\\\\").replace("'", "\\'").replace("\"", "\\\"");
    }

    public static Map<String, String> h(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (!strArrSplit[0].equals("event")) {
                    map.put(d(strArrSplit[0]), d(strArrSplit[1]));
                }
            }
        }
        return map;
    }

    public static long i(String str) {
        if (str == null) {
            return 0L;
        }
        int length = str.length();
        long j = 1125899906842597L;
        int i = 0;
        while (i < length) {
            long jCharAt = ((long) str.charAt(i)) + (j * 31);
            i++;
            j = jCharAt;
        }
        return j;
    }
}
