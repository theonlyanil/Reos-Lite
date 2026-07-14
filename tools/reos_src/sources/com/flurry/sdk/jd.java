package com.flurry.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4450a = jd.class.getName();

    public static String a(String str) {
        String str2 = "a=" + js.a().d();
        return !TextUtils.isEmpty(str) ? String.format("%s&%s", str2, "cid=" + b(str)) : str2;
    }

    private static String b(String str) {
        byte[] bArr = null;
        if (str != null && str.trim().length() > 0) {
            try {
                byte[] bArrF = lt.f(str);
                if (bArrF == null || bArrF.length != 20) {
                    kg.a(6, f4450a, "sha1 is not 20 bytes long: " + Arrays.toString(bArrF));
                    bArrF = null;
                } else {
                    try {
                        kg.a(5, f4450a, "syndication hashedId is:" + new String(bArrF));
                    } catch (Exception e2) {
                        bArr = bArrF;
                        kg.a(6, f4450a, "Exception in getHashedSyndicationIdString()");
                    }
                }
                bArr = bArrF;
            } catch (Exception e3) {
            }
        }
        return lt.a(bArr);
    }
}
