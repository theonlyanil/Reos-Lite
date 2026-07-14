package com.android.library.userprofile.model;

import android.graphics.Bitmap;
import com.android.library.userprofile.util.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private ArrayList<String> g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.c(a = "phone")
    private String f2797a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.c(a = "emailContact")
    private String f2798b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.a.a.c(a = "emailType")
    private String f2799c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.a.a.c(a = Constants.SMS_COLUMN_CONTACT_NAME)
    private String f2800d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.a.a.c(a = "image_uri")
    private String f2801e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.a.a.c(a = "bitmap")
    private Bitmap f2802f = null;
    private ArrayList<d> h = new ArrayList<>();

    public e() {
        this.g = new ArrayList<>();
        this.g = new ArrayList<>();
    }

    public void a(String str) {
        this.f2800d = str;
    }

    public void a(ArrayList<d> arrayList) {
        this.h = arrayList;
    }

    public void b(String str) {
        this.f2797a = str;
    }

    public void b(ArrayList<String> arrayList) {
        this.g = arrayList;
    }

    public void c(String str) {
        this.f2798b = str;
    }

    public void d(String str) {
        this.f2799c = str;
    }

    public String toString() {
        return "PhoneContactDetail{phone='" + this.f2797a + "', emailContact='" + this.f2798b + "', emailType='" + this.f2799c + "', contactName='" + this.f2800d + "', image_uri='" + this.f2801e + "', bitmap=" + this.f2802f + ", phoneNumberLists=" + this.g + ", contactEmailLists=" + this.h + '}';
    }
}
