package com.android.library.userprofile.model;

import com.android.library.userprofile.util.Constants;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.c(a = Constants.SMS_COLUMN_ID)
    String f2780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.c(a = "displayName")
    String f2781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.a.a.c(a = "selected")
    Boolean f2782c;

    public void a(String str) {
        this.f2780a = str;
    }

    public void b(String str) {
        this.f2781b = str;
    }

    public String toString() {
        return "CalendarDetails{_id='" + this.f2780a + "', displayName='" + this.f2781b + "', selected=" + this.f2782c + '}';
    }
}
