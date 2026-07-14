package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

/* JADX INFO: loaded from: classes.dex */
public class ShareFeedContent extends ShareContent<ShareFeedContent, Object> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator<ShareFeedContent>() { // from class: com.facebook.share.internal.ShareFeedContent.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareFeedContent createFromParcel(Parcel parcel) {
            return new ShareFeedContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareFeedContent[] newArray(int i) {
            return new ShareFeedContent[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f4059f;
    private final String g;

    ShareFeedContent(Parcel parcel) {
        super(parcel);
        this.f4054a = parcel.readString();
        this.f4055b = parcel.readString();
        this.f4056c = parcel.readString();
        this.f4057d = parcel.readString();
        this.f4058e = parcel.readString();
        this.f4059f = parcel.readString();
        this.g = parcel.readString();
    }

    public String a() {
        return this.f4054a;
    }

    public String b() {
        return this.f4055b;
    }

    public String c() {
        return this.f4056c;
    }

    public String d() {
        return this.f4057d;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f4058e;
    }

    public String f() {
        return this.f4059f;
    }

    public String g() {
        return this.g;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4054a);
        parcel.writeString(this.f4055b);
        parcel.writeString(this.f4056c);
        parcel.writeString(this.f4057d);
        parcel.writeString(this.f4058e);
        parcel.writeString(this.f4059f);
        parcel.writeString(this.g);
    }
}
