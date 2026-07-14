package android.support.v4.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static int a(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static final Drawable a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 21 ? c.a(context, i) : context.getResources().getDrawable(i);
    }

    private static synchronized File a(File file) {
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
            file = null;
        }
        return file;
    }

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            f.a(context, intentArr, bundle);
            return true;
        }
        if (i < 11) {
            return false;
        }
        e.a(context, intentArr);
        return true;
    }

    public static final int b(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? d.a(context, i) : context.getResources().getColor(i);
    }

    public final File a(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? c.a(context) : a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }
}
