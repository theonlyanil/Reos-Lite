package com.android.library.userprofile.model;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.c(a = "emailID")
    String f2795a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.c(a = "emailType")
    String f2796b = "";

    public void a(String str) {
        this.f2795a = str;
    }

    public void b(String str) {
        this.f2796b = str;
    }

    public String toString() {
        return "ContactEmail{emailID='" + this.f2795a + "', emailType='" + this.f2796b + "'}";
    }
}
