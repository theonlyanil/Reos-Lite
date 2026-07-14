package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zze;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class zzob {
    private static final Pattern zzamq = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean zzcP(String str) {
        return str == null || zze.zzaiV.zzb(str);
    }
}
