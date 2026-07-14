package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Object> implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>() { // from class: com.facebook.share.model.ShareVideoContent.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareVideoContent createFromParcel(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareVideoContent[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharePhoto f4122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ShareVideo f4123d;

    ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.f4120a = parcel.readString();
        this.f4121b = parcel.readString();
        SharePhoto.a aVarB = new SharePhoto.a().b(parcel);
        if (aVarB.a() == null && aVarB.b() == null) {
            this.f4122c = null;
        } else {
            this.f4122c = aVarB.c();
        }
        this.f4123d = new ShareVideo.a().b(parcel).a();
    }

    public String a() {
        return this.f4120a;
    }

    public String b() {
        return this.f4121b;
    }

    public SharePhoto c() {
        return this.f4122c;
    }

    public ShareVideo d() {
        return this.f4123d;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4120a);
        parcel.writeString(this.f4121b);
        parcel.writeParcelable(this.f4122c, 0);
        parcel.writeParcelable(this.f4123d, 0);
    }
}
