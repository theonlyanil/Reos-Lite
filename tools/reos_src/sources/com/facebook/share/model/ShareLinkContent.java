package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ShareLinkContent extends ShareContent<ShareLinkContent, Object> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator<ShareLinkContent>() { // from class: com.facebook.share.model.ShareLinkContent.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f4097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4098d;

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.f4095a = parcel.readString();
        this.f4096b = parcel.readString();
        this.f4097c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4098d = parcel.readString();
    }

    public String a() {
        return this.f4095a;
    }

    public String b() {
        return this.f4096b;
    }

    public Uri c() {
        return this.f4097c;
    }

    public String d() {
        return this.f4098d;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4095a);
        parcel.writeString(this.f4096b);
        parcel.writeParcelable(this.f4097c, 0);
        parcel.writeString(this.f4098d);
    }
}
