package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SharePhoto extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator<SharePhoto>() { // from class: com.facebook.share.model.SharePhoto.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SharePhoto createFromParcel(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SharePhoto[] newArray(int i) {
            return new SharePhoto[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f4109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f4110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f4111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4112d;

    public static final class a extends ShareMedia.a<SharePhoto, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bitmap f4113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f4114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f4116d;

        static void a(Parcel parcel, int i, List<SharePhoto> list) {
            ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    parcel.writeParcelableArray(shareMediaArr, i);
                    return;
                } else {
                    shareMediaArr[i3] = list.get(i3);
                    i2 = i3 + 1;
                }
            }
        }

        static List<SharePhoto> c(Parcel parcel) {
            List<ShareMedia> listA = a(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia shareMedia : listA) {
                if (shareMedia instanceof SharePhoto) {
                    arrayList.add((SharePhoto) shareMedia);
                }
            }
            return arrayList;
        }

        Uri a() {
            return this.f4114b;
        }

        public a a(Bitmap bitmap) {
            this.f4113a = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f4114b = uri;
            return this;
        }

        @Override // com.facebook.share.model.ShareMedia.a
        public a a(SharePhoto sharePhoto) {
            return sharePhoto == null ? this : ((a) super.a(sharePhoto)).a(sharePhoto.c()).a(sharePhoto.d()).a(sharePhoto.e()).a(sharePhoto.f());
        }

        public a a(String str) {
            this.f4116d = str;
            return this;
        }

        public a a(boolean z) {
            this.f4115c = z;
            return this;
        }

        Bitmap b() {
            return this.f4113a;
        }

        a b(Parcel parcel) {
            return a((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        public SharePhoto c() {
            return new SharePhoto(this);
        }
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        this.f4109a = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f4110b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4111c = parcel.readByte() != 0;
        this.f4112d = parcel.readString();
    }

    private SharePhoto(a aVar) {
        super(aVar);
        this.f4109a = aVar.f4113a;
        this.f4110b = aVar.f4114b;
        this.f4111c = aVar.f4115c;
        this.f4112d = aVar.f4116d;
    }

    @Override // com.facebook.share.model.ShareMedia
    public ShareMedia.b b() {
        return ShareMedia.b.PHOTO;
    }

    public Bitmap c() {
        return this.f4109a;
    }

    public Uri d() {
        return this.f4110b;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f4111c;
    }

    public String f() {
        return this.f4112d;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4109a, 0);
        parcel.writeParcelable(this.f4110b, 0);
        parcel.writeByte((byte) (this.f4111c ? 1 : 0));
        parcel.writeString(this.f4112d);
    }
}
