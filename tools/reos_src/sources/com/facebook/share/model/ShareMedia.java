package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareMedia implements ShareModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f4099a;

    public static abstract class a<M extends ShareMedia, B extends a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bundle f4100a = new Bundle();

        static List<ShareMedia> a(Parcel parcel) {
            Parcelable[] parcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((ShareMedia) parcelable);
            }
            return arrayList;
        }

        @Deprecated
        public B a(Bundle bundle) {
            this.f4100a.putAll(bundle);
            return this;
        }

        public B a(M m) {
            return m == null ? this : (B) a(m.a());
        }
    }

    public enum b {
        PHOTO,
        VIDEO
    }

    ShareMedia(Parcel parcel) {
        this.f4099a = parcel.readBundle();
    }

    protected ShareMedia(a aVar) {
        this.f4099a = new Bundle(aVar.f4100a);
    }

    @Deprecated
    public Bundle a() {
        return new Bundle(this.f4099a);
    }

    public abstract b b();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f4099a);
    }
}
