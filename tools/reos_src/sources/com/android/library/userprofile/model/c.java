package com.android.library.userprofile.model;

import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.c(a = "phNumber")
    String f2789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.c(a = "callType")
    String f2790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.a.a.c(a = "callDate")
    String f2791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.a.a.c(a = "callDayTime")
    Date f2792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.a.a.c(a = "callDuration")
    String f2793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.a.a.c(a = "dir")
    String f2794f;

    @com.google.a.a.c(a = "dircode")
    int g;

    public void a(String str) {
        this.f2789a = str;
    }

    public void a(Date date) {
        this.f2792d = date;
    }

    public void b(String str) {
        this.f2790b = str;
    }

    public void c(String str) {
        this.f2791c = str;
    }

    public void d(String str) {
        this.f2793e = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.g != cVar.g) {
            return false;
        }
        if (this.f2789a != null) {
            if (!this.f2789a.equals(cVar.f2789a)) {
                return false;
            }
        } else if (cVar.f2789a != null) {
            return false;
        }
        if (this.f2790b != null) {
            if (!this.f2790b.equals(cVar.f2790b)) {
                return false;
            }
        } else if (cVar.f2790b != null) {
            return false;
        }
        if (this.f2791c != null) {
            if (!this.f2791c.equals(cVar.f2791c)) {
                return false;
            }
        } else if (cVar.f2791c != null) {
            return false;
        }
        if (this.f2792d != null) {
            if (!this.f2792d.equals(cVar.f2792d)) {
                return false;
            }
        } else if (cVar.f2792d != null) {
            return false;
        }
        if (this.f2793e != null) {
            if (!this.f2793e.equals(cVar.f2793e)) {
                return false;
            }
        } else if (cVar.f2793e != null) {
            return false;
        }
        if (this.f2794f == null ? cVar.f2794f != null : !this.f2794f.equals(cVar.f2794f)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((this.f2793e != null ? this.f2793e.hashCode() : 0) + (((this.f2792d != null ? this.f2792d.hashCode() : 0) + (((this.f2791c != null ? this.f2791c.hashCode() : 0) + (((this.f2790b != null ? this.f2790b.hashCode() : 0) + ((this.f2789a != null ? this.f2789a.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31) + (this.f2794f != null ? this.f2794f.hashCode() : 0)) * 31) + this.g;
    }

    public String toString() {
        return "CallDetails{phNumber='" + this.f2789a + "', callType='" + this.f2790b + "', callDate='" + this.f2791c + "', callDayTime=" + this.f2792d + ", callDuration='" + this.f2793e + "', dir='" + this.f2794f + "', dircode=" + this.g + '}';
    }
}
