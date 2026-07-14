package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f555a;

    interface a {
        Intent a(Activity activity);

        String a(Context context, ActivityInfo activityInfo);

        boolean a(Activity activity, Intent intent);

        void b(Activity activity, Intent intent);
    }

    static class b implements a {
        b() {
        }

        @Override // android.support.v4.app.ab.a
        public Intent a(Activity activity) {
            Intent intentA = null;
            String strB = ab.b(activity);
            if (strB != null) {
                ComponentName componentName = new ComponentName(activity, strB);
                try {
                    intentA = ab.b(activity, componentName) == null ? android.support.v4.b.g.a(componentName) : new Intent().setComponent(componentName);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strB + "' in manifest");
                }
            }
            return intentA;
        }

        @Override // android.support.v4.app.ab.a
        public String a(Context context, ActivityInfo activityInfo) {
            String string;
            if (activityInfo.metaData != null && (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) != null) {
                return string.charAt(0) == '.' ? context.getPackageName() + string : string;
            }
            return null;
        }

        @Override // android.support.v4.app.ab.a
        public boolean a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        @Override // android.support.v4.app.ab.a
        public void b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    static class c extends b {
        c() {
        }

        @Override // android.support.v4.app.ab.b, android.support.v4.app.ab.a
        public Intent a(Activity activity) {
            Intent intentA = ac.a(activity);
            return intentA == null ? b(activity) : intentA;
        }

        @Override // android.support.v4.app.ab.b, android.support.v4.app.ab.a
        public String a(Context context, ActivityInfo activityInfo) {
            String strA = ac.a(activityInfo);
            return strA == null ? super.a(context, activityInfo) : strA;
        }

        @Override // android.support.v4.app.ab.b, android.support.v4.app.ab.a
        public boolean a(Activity activity, Intent intent) {
            return ac.a(activity, intent);
        }

        Intent b(Activity activity) {
            return super.a(activity);
        }

        @Override // android.support.v4.app.ab.b, android.support.v4.app.ab.a
        public void b(Activity activity, Intent intent) {
            ac.b(activity, intent);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f555a = new c();
        } else {
            f555a = new b();
        }
    }

    public static Intent a(Activity activity) {
        return f555a.a(activity);
    }

    public static Intent a(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strB = b(context, componentName);
        if (strB == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strB);
        return b(context, componentName2) == null ? android.support.v4.b.g.a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static boolean a(Activity activity, Intent intent) {
        return f555a.a(activity, intent);
    }

    public static String b(Activity activity) {
        try {
            return b(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static String b(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return f555a.a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void b(Activity activity, Intent intent) {
        f555a.b(activity, intent);
    }
}
