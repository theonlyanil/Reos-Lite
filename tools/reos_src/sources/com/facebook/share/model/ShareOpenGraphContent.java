package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Object> {
    public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new Parcelable.Creator<ShareOpenGraphContent>() { // from class: com.facebook.share.model.ShareOpenGraphContent.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareOpenGraphContent[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ShareOpenGraphAction f4105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4106b;

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.f4105a = new ShareOpenGraphAction.a().a(parcel).a();
        this.f4106b = parcel.readString();
    }

    public ShareOpenGraphAction a() {
        return this.f4105a;
    }

    public String b() {
        return this.f4106b;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4105a, 0);
        parcel.writeString(this.f4106b);
    }
}
