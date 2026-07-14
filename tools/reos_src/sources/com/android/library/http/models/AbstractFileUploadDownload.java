package com.android.library.http.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class AbstractFileUploadDownload implements Parcelable {
    public static final Parcelable.Creator<AbstractFileUploadDownload> CREATOR = new Parcelable.Creator<AbstractFileUploadDownload>() { // from class: com.android.library.http.models.AbstractFileUploadDownload.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractFileUploadDownload createFromParcel(Parcel parcel) {
            return new AbstractFileUploadDownload(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractFileUploadDownload[] newArray(int i) {
            return new AbstractFileUploadDownload[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2709c;

    public AbstractFileUploadDownload() {
    }

    private AbstractFileUploadDownload(Parcel parcel) {
        this.f2707a = parcel.readInt();
        this.f2708b = parcel.readInt();
        this.f2709c = parcel.readInt();
    }

    public void a(int i) {
        this.f2707a = i;
    }

    public void a(long j) {
        this.f2708b = j;
    }

    public void b(int i) {
        this.f2709c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2707a);
        parcel.writeLong(this.f2708b);
        parcel.writeInt(this.f2709c);
    }
}
