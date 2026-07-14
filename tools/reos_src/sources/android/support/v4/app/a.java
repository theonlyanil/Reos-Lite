package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends android.support.v4.b.b {

    /* JADX INFO: renamed from: android.support.v4.app.a$a, reason: collision with other inner class name */
    public interface InterfaceC0010a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    private static class b extends android.support.v4.app.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private av f542a;

        public b(av avVar) {
            this.f542a = avVar;
        }

        @Override // android.support.v4.app.b.a
        public Parcelable a(View view, Matrix matrix, RectF rectF) {
            return this.f542a.a(view, matrix, rectF);
        }

        @Override // android.support.v4.app.b.a
        public View a(Context context, Parcelable parcelable) {
            return this.f542a.a(context, parcelable);
        }

        @Override // android.support.v4.app.b.a
        public void a(List<View> list) {
            this.f542a.a(list);
        }

        @Override // android.support.v4.app.b.a
        public void a(List<String> list, List<View> list2, List<View> list3) {
            this.f542a.a(list, list2, list3);
        }

        @Override // android.support.v4.app.b.a
        public void a(List<String> list, Map<String, View> map) {
            this.f542a.a(list, map);
        }

        @Override // android.support.v4.app.b.a
        public void b(List<String> list, List<View> list2, List<View> list3) {
            this.f542a.b(list, list2, list3);
        }
    }

    private static android.support.v4.app.b.a a(av avVar) {
        if (avVar != null) {
            return new b(avVar);
        }
        return null;
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            e.a(activity);
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            e.a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            e.a(activity, intent, bundle);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void a(Activity activity, av avVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.app.b.a(activity, a(avVar));
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            c.a(activity, strArr, i);
        } else if (activity instanceof InterfaceC0010a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: android.support.v4.app.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    ((InterfaceC0010a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c.a(activity, str);
        }
        return false;
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.app.b.a(activity);
        } else {
            activity.finish();
        }
    }

    public static void b(Activity activity, av avVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.app.b.b(activity, a(avVar));
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.app.b.b(activity);
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.app.b.c(activity);
        }
    }
}
