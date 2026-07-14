package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ShareVideo extends ShareMedia {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new Parcelable.Creator<ShareVideo>() { // from class: com.facebook.share.model.ShareVideo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareVideo createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareVideo[] newArray(int i) {
            return new ShareVideo[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f4118a;

    public static final class a extends ShareMedia.a<ShareVideo, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f4119a;

        public a a(Uri uri) {
            this.f4119a = uri;
            return this;
        }

        @Override // com.facebook.share.model.ShareMedia.a
        public a a(ShareVideo shareVideo) {
            return shareVideo == null ? this : ((a) super.a(shareVideo)).a(shareVideo.c());
        }

        public ShareVideo a() {
            return new ShareVideo(this);
        }

        a b(Parcel parcel) {
            return a((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.f4118a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    private ShareVideo(a aVar) {
        super(aVar);
        this.f4118a = aVar.f4119a;
    }

    @Override // com.facebook.share.model.ShareMedia
    public ShareMedia.b b() {
        return ShareMedia.b.VIDEO;
    }

    public Uri c() {
        return this.f4118a;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4118a, 0);
    }
}
