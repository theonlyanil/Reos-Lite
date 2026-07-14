package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator<ShareHashtag>() { // from class: com.facebook.share.model.ShareHashtag.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareHashtag createFromParcel(Parcel parcel) {
            return new ShareHashtag(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareHashtag[] newArray(int i) {
            return new ShareHashtag[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4093a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4094a;

        a a(Parcel parcel) {
            return a((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }

        public a a(ShareHashtag shareHashtag) {
            return shareHashtag == null ? this : a(shareHashtag.a());
        }

        public a a(String str) {
            this.f4094a = str;
            return this;
        }

        public ShareHashtag a() {
            return new ShareHashtag(this);
        }
    }

    ShareHashtag(Parcel parcel) {
        this.f4093a = parcel.readString();
    }

    private ShareHashtag(a aVar) {
        this.f4093a = aVar.f4094a;
    }

    public String a() {
        return this.f4093a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4093a);
    }
}
