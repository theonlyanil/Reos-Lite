package com.android.library.rmnlibrary.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.android.apps.config.util.CLog;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f2769a = "0123456789abcdef".toCharArray();

    public static String a() {
        return Environment.getExternalStorageDirectory() + "/Android/obb/.utils/com.library.download/";
    }

    public static String a(File file) {
        String string = "";
        try {
            byte[] bArr = new byte[4096];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(32);
            for (byte b2 : bArrDigest) {
                sb.append(f2769a[(b2 >> 4) & 15]);
                sb.append(f2769a[b2 & 15]);
            }
            string = sb.toString();
            fileInputStream.close();
            return string;
        } catch (Exception e2) {
            CLog.d("RMNLibrary", "Error while checking md5 of file.");
            return string;
        }
    }

    public static String a(String str) {
        return a() + str + ".apk";
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean a(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e2) {
            CLog.d("RMNLibrary", "Error while checking app for system flag.");
            return false;
        }
    }

    public static String b() {
        return Environment.getExternalStorageDirectory() + "/.appStore/";
    }

    public static void b(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean b(String str) {
        return new File(str).exists();
    }

    public static void c(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                c(file2);
            }
        }
        file.delete();
    }

    public static void c(String str) {
        new File(str).mkdirs();
    }

    public static void d(String str) {
        if (b(str)) {
            return;
        }
        c(str);
    }
}
