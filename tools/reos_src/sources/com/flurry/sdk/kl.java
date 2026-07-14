package com.flurry.sdk;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class kl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f4581a = Pattern.compile(".*?(%\\{\\w+\\}).*?");

    public String a(String str) {
        Matcher matcher = this.f4581a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    protected boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals("%{" + str + "}");
    }
}
