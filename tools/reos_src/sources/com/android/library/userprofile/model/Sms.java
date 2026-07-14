package com.android.library.userprofile.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.library.userprofile.util.Constants;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class Sms implements Parcelable, Comparable<Sms>, Comparator<Sms> {
    public static final Parcelable.Creator<Sms> CREATOR = new Parcelable.Creator<Sms>() { // from class: com.android.library.userprofile.model.Sms.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Sms createFromParcel(Parcel parcel) {
            return new Sms(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Sms[] newArray(int i) {
            return new Sms[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.a.a.c(a = "id")
    private String f2774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.a.a.c(a = Constants.SMS_COLUMN_ADDRESS)
    private String f2775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.a.a.c(a = Constants.SMS_COLUMN_BODY)
    private String f2776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.a.a.c(a = Constants.SMS_COLUMN_DATE)
    private String f2777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.a.a.c(a = Constants.SMS_COLUMN_PERSON)
    private String f2778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.a.a.c(a = Constants.SMS_COLUMN_STATUS)
    private String f2779f;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_DATE_SENT)
    private String g;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_SEEN)
    private String h;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_PROTOCOL)
    private String i;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_TYPE)
    private String j;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_READ)
    private String k;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_CREATOR)
    private String l;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_THREAD_ID)
    private String m;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_ERROR_CODE)
    private String n;

    @com.google.a.a.c(a = "dateTime")
    private String o;

    @com.google.a.a.c(a = Constants.SMS_COLUMN_IS_MUTE)
    private String p;

    @com.google.a.a.c(a = "contactImageUri")
    private String q;

    public Sms() {
        this.f2774a = "";
        this.f2775b = "";
        this.f2776c = "";
        this.f2777d = "";
        this.f2778e = "";
        this.f2779f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "0";
        this.q = "";
    }

    public Sms(Parcel parcel) {
        this.f2774a = "";
        this.f2775b = "";
        this.f2776c = "";
        this.f2777d = "";
        this.f2778e = "";
        this.f2779f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "0";
        this.q = "";
        this.f2774a = parcel.readString();
        this.f2775b = parcel.readString();
        this.f2776c = parcel.readString();
        this.f2777d = parcel.readString();
        this.f2778e = parcel.readString();
        this.f2779f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Sms sms) {
        return 0;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Sms sms, Sms sms2) {
        return 0;
    }

    public String a() {
        return this.f2774a;
    }

    public void a(String str) {
        this.f2776c = str;
    }

    public void b(String str) {
        this.f2774a = str;
    }

    public void c(String str) {
        this.f2775b = str;
    }

    public void d(String str) {
        this.f2777d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.j = str;
    }

    public void f(String str) {
        this.k = str;
    }

    public void g(String str) {
        this.f2779f = str;
    }

    public void h(String str) {
        this.g = str;
    }

    public void i(String str) {
        this.h = str;
    }

    public void j(String str) {
        this.i = str;
    }

    public void k(String str) {
        this.l = str;
    }

    public void l(String str) {
        this.m = str;
    }

    public void m(String str) {
        this.n = str;
    }

    public void n(String str) {
        this.f2778e = str;
    }

    public String toString() {
        return "Sms{id='" + this.f2774a + "', address='" + this.f2775b + "', body='" + this.f2776c + "', date='" + this.f2777d + "', person='" + this.f2778e + "', status='" + this.f2779f + "', date_sent='" + this.g + "', seen='" + this.h + "', protocol='" + this.i + "', type='" + this.j + "', read='" + this.k + "', creator='" + this.l + "', thread_id='" + this.m + "', error_code='" + this.n + "', dateTime='" + this.o + "', isMute='" + this.p + "', contactImageUri='" + this.q + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2774a);
        parcel.writeString(this.f2775b);
        parcel.writeString(this.f2776c);
        parcel.writeString(this.f2777d);
        parcel.writeString(this.f2778e);
        parcel.writeString(this.f2779f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
    }
}
