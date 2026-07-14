package com.android.library.rmnlibrary.b;

import android.content.Context;
import android.content.Intent;
import com.android.apps.config.util.CLog;
import com.android.library.installer.InstallApp;
import com.android.library.rmnlibrary.AbstractNotification;
import com.google.android.gms.gcm.Task;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2762a = 0;

    private static int a(String str, String str2, String str3, String str4, Context context, AbstractNotification abstractNotification, boolean z) {
        if (!i.a(context)) {
            return -1;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.connect();
            long contentLength = httpURLConnection.getContentLength();
            CLog.b("RMNLibrary", " apk size :: " + contentLength);
            if (f.a(httpURLConnection)) {
                String headerField = httpURLConnection.getHeaderField("Location");
                httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
                CLog.b("RMNLibrary", "Redirect to URL : " + headerField);
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[Task.EXTRAS_LIMIT_BYTES];
            long j = 0;
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                long j2 = j + ((long) i);
                if (contentLength > 0) {
                    CLog.b("RMNLibrary", " Count :: " + ((100 * j2) / contentLength));
                    if (z) {
                        jCurrentTimeMillis = com.android.library.rmnlibrary.b.a("Downloading..", (int) ((100 * j2) / contentLength), str4, context, jCurrentTimeMillis, abstractNotification);
                    }
                }
                fileOutputStream.write(bArr, 0, i);
                j = j2;
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream.close();
            CLog.e("RMNLibrary", "md5 from server :: " + str3);
            if (h.b(str3) || str3.equals(i.a(new File(str)))) {
                return 100;
            }
            CLog.e("****MD5 generated from the file****", i.a(new File(str)));
            CLog.c("RMNLibrary", "File downloaded but corrupt");
            com.android.library.rmnlibrary.b.a(context, str4, abstractNotification);
            return -1;
        } catch (IOException e2) {
            CLog.d("RMNLibrary", "IOException at URL::" + str2 + " :: " + e2.getMessage());
            return -1;
        }
    }

    public static JSONObject a(String str, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deal_id", str);
            jSONObject.put("platform", str2);
            jSONObject.put("auto", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(Context context, AbstractNotification abstractNotification) {
        f2762a = 0;
        List<AbstractNotification.ResponseEntity.NotificationsEntity> notifications = abstractNotification.getResponse().getNotifications();
        List<AbstractNotification.ResponseEntity.NotificationsEntity.APK_DOWNLOAD> apk_download = notifications.get(0).getApk_download();
        if (apk_download == null || apk_download.size() <= 0) {
            return;
        }
        while (f2762a < apk_download.size()) {
            String package_name = apk_download.get(f2762a).getPackage_name();
            String md5 = apk_download.get(f2762a).getMd5();
            String strReplaceAll = apk_download.get(f2762a).getApk_url().replaceAll(" ", "%20");
            com.android.library.rmnlibrary.b.a(context, notifications.get(0).getDeal_id(), "download_started", package_name, abstractNotification);
            String strA = i.a(package_name);
            File file = new File(strA);
            String strA2 = i.a(file);
            i.d(i.a());
            CLog.b("RMNLibrary", "appPackage id :: " + package_name);
            if (!file.exists() || !strA2.equalsIgnoreCase(md5)) {
                CLog.b("RMNLibrary", "Deleting corrupted .apk file :: " + file.toString());
                i.b(file);
                CLog.b("RMNLibrary", "Connected to net over wifi");
                switch (a(strA, strReplaceAll, md5, package_name, context, abstractNotification, false)) {
                    case -1:
                        CLog.b("RMNLibrary", "Download failed");
                        com.android.library.rmnlibrary.b.a(context, package_name, abstractNotification);
                        i.b(file);
                        CLog.b("RMNLibrary", "Handler is called after failure case");
                        if (i.a(context)) {
                            if (f.b(context, abstractNotification.getResponse().getMode())) {
                                CLog.b("RMNLibrary", "Downloading apk after failure case");
                                a(context, abstractNotification);
                                return;
                            } else {
                                CLog.b("RMNLibrary", "Starting notification after failure case");
                                com.android.library.rmnlibrary.b.a(context, abstractNotification, abstractNotification.getResponse().getNotification_type());
                                return;
                            }
                        }
                        return;
                    case 2:
                        CLog.b("RMNLibrary", "Download canceled");
                        com.android.library.rmnlibrary.b.a(context, package_name, abstractNotification);
                        i.b(file);
                        break;
                    case 100:
                        CLog.b("RMNLibrary", "Download completed");
                        int i = f2762a + 1;
                        f2762a = i;
                        g.b("com.android.library.rmnlibrary.DOWNLOAD.APK_COUNT", i, context);
                        if (g.a("com.android.library.rmnlibrary.DOWNLOAD.APK_COUNT", 99, context) == apk_download.size()) {
                            if (!f.b(context, abstractNotification.getResponse().getMode())) {
                                a(context, strA, file, package_name, abstractNotification);
                                com.android.library.rmnlibrary.b.a(context, package_name, abstractNotification);
                            } else {
                                com.android.library.rmnlibrary.b.a(context, abstractNotification, "UA");
                            }
                        }
                        break;
                }
            } else {
                CLog.b("RMNLibrary", "Generated md5 value " + strA2);
                CLog.b("RMNLibrary", "Retrieved md5 value " + md5);
                CLog.b("RMNLibrary", "apk already exists in the folder");
                int i2 = f2762a + 1;
                f2762a = i2;
                g.b("com.android.library.rmnlibrary.DOWNLOAD.APK_COUNT", i2, context);
                if (g.a("com.android.library.rmnlibrary.DOWNLOAD.APK_COUNT", 99, context) == apk_download.size()) {
                    com.android.library.rmnlibrary.b.a(context, abstractNotification, "MULTIPLE_UA");
                    return;
                }
            }
        }
    }

    private static void a(final Context context, final File file, final String str, final AbstractNotification abstractNotification) {
        InstallApp.installPackage(a(abstractNotification.getResponse().getNotifications().get(0).getDeal_id(), com.android.library.rmnlibrary.b.b(context), false), file, new InstallApp.InstallerLibraryCallback() { // from class: com.android.library.rmnlibrary.b.c.1
        });
    }

    public static void a(Context context, String str, File file, String str2, AbstractNotification abstractNotification) {
        if (i.a(context, context.getPackageName())) {
            a(context, file, str2, abstractNotification);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.android.library.daise.intentcatcher");
        intent.putExtra("com.android.library.daise.intentextra.filepath", str);
        intent.putExtra("com.android.library.daise.intentextra.dealid", abstractNotification.getResponse().getNotifications().get(0).getDeal_id());
        context.sendBroadcast(intent);
    }

    public static void a(Context context, String str, String str2, String str3, AbstractNotification abstractNotification, boolean z) {
        com.android.library.rmnlibrary.b.a(context, abstractNotification.getResponse().getNotifications().get(0).getDeal_id(), "download_started", str, abstractNotification);
        String strA = i.a(str);
        File file = new File(strA);
        String strA2 = i.a(file);
        i.d(i.a());
        CLog.b("RMNLibrary", "appPackage id :: " + str);
        if (file.exists() && strA2.equalsIgnoreCase(str2)) {
            CLog.b("RMNLibrary", "Generated md5 value " + strA2);
            CLog.b("RMNLibrary", "Retrieved md5 value " + str2);
            CLog.b("RMNLibrary", "apk alredy exists in the folder");
            com.android.library.rmnlibrary.b.a(context, abstractNotification, "UA");
        }
        CLog.b("RMNLibrary", "Deleting corrupted .apk file :: " + file.toString());
        i.b(file);
        switch (a(strA, str3, str2, str, context, abstractNotification, z)) {
            case -1:
                CLog.b("RMNLibrary", "Download failed");
                com.android.library.rmnlibrary.b.a(context, str, abstractNotification);
                i.b(file);
                com.android.library.rmnlibrary.b.b(context, "UA", abstractNotification);
            case 2:
                CLog.b("RMNLibrary", "Download canceled");
                com.android.library.rmnlibrary.b.a(context, str, abstractNotification);
                i.b(file);
            case 100:
                CLog.b("RMNLibrary", "Download completed");
                if (!f.b(context, abstractNotification.getResponse().getMode())) {
                    a(context, strA, file, str, abstractNotification);
                    com.android.library.rmnlibrary.b.a(context, str, abstractNotification);
                } else {
                    com.android.library.rmnlibrary.b.a(context, abstractNotification, "UA");
                }
                break;
        }
    }
}
