package com.android.library.apptrack.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a(String str, Context context) {
        return context.getSharedPreferences("app_track_shared_prefs", 0).getStringSet("app_track_delete_package_name", new HashSet()).contains(str);
    }

    public static void b(String str, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_track_shared_prefs", 0);
        Set<String> stringSet = sharedPreferences.getStringSet("app_track_delete_package_name", new HashSet());
        if (stringSet.contains(str)) {
            stringSet.remove(str);
        }
        sharedPreferences.edit().putStringSet("app_track_delete_package_name", stringSet).commit();
    }
}
