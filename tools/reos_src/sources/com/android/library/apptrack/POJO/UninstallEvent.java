package com.android.library.apptrack.POJO;

import com.google.a.a.a;
import com.google.a.a.c;

/* JADX INFO: loaded from: classes.dex */
public class UninstallEvent {

    @a
    @c(a = "eventTime")
    long eventTime;

    @a
    @c(a = "packageName")
    String packageName;

    public void a(long j) {
        this.eventTime = j;
    }

    public void a(String str) {
        this.packageName = str;
    }
}
