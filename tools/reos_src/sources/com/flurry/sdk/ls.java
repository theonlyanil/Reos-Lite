package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.google.android.gms.location.places.Place;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4725a = ls.class.getSimpleName();

    public static File a(boolean z) {
        File externalFilesDir = null;
        Context contextC = js.a().c();
        if (z && "mounted".equals(Environment.getExternalStorageState()) && (Build.VERSION.SDK_INT >= 19 || contextC.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
            externalFilesDir = contextC.getExternalFilesDir(null);
        }
        return externalFilesDir == null ? contextC.getFilesDir() : externalFilesDir;
    }

    @Deprecated
    public static void a(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        if (file == null) {
            kg.a(4, f4725a, "No persistent file specified.");
            return;
        }
        if (str == null) {
            kg.a(4, f4725a, "No data specified; deleting persistent file: " + file.getAbsolutePath());
            file.delete();
            return;
        }
        kg.a(4, f4725a, "Writing persistent data: " + file.getAbsolutePath());
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    fileOutputStream.write(str.getBytes());
                    lt.a(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    kg.a(6, f4725a, "Error writing persistent file", th);
                    lt.a(fileOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                lt.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            lt.a(fileOutputStream);
            throw th;
        }
    }

    public static boolean a(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return true;
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        kg.a(6, f4725a, "Unable to create persistent dir: " + parentFile);
        return false;
    }

    public static File b(boolean z) {
        Context contextC = js.a().c();
        File externalCacheDir = null;
        if (z && "mounted".equals(Environment.getExternalStorageState()) && (Build.VERSION.SDK_INT >= 19 || contextC.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
            externalCacheDir = contextC.getExternalCacheDir();
        }
        return externalCacheDir == null ? contextC.getCacheDir() : externalCacheDir;
    }

    public static boolean b(File file) {
        if (file != null && file.isDirectory()) {
            for (String str : file.list()) {
                if (!b(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    @Deprecated
    public static String c(File file) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        StringBuilder sb;
        if (file == null || !file.exists()) {
            kg.a(4, f4725a, "Persistent file doesn't exist.");
            return null;
        }
        kg.a(4, f4725a, "Loading persistent data: " + file.getAbsolutePath());
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    sb = new StringBuilder();
                    byte[] bArr = new byte[Place.TYPE_SUBLOCALITY_LEVEL_2];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i));
                    }
                    lt.a((Closeable) fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    kg.a(6, f4725a, "Error when loading persistent file", th);
                    lt.a((Closeable) fileInputStream);
                    sb = null;
                }
            } catch (Throwable th3) {
                th = th3;
                lt.a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            lt.a((Closeable) fileInputStream);
            throw th;
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }
}
