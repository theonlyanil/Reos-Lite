package com.android.library.userprofile.model;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.c(a = "fileName")
    String f2809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.c(a = "filePath")
    String f2810b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.a.a.c(a = "file")
    File f2811c = null;

    public void a(File file) {
        this.f2811c = file;
    }

    public void a(String str) {
        this.f2809a = str;
    }

    public void b(String str) {
        this.f2810b = str;
    }

    public String toString() {
        return "VideoFile{fileName='" + this.f2809a + "', filePath='" + this.f2810b + "', file=" + this.f2811c + '}';
    }
}
