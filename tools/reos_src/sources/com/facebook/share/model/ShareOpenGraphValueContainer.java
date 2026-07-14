package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.a;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends a> implements ShareModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f4107a;

    public static abstract class a<P extends ShareOpenGraphValueContainer, E extends a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bundle f4108a = new Bundle();

        public E a(P p) {
            if (p != null) {
                this.f4108a.putAll(p.b());
            }
            return this;
        }

        public E a(String str, String str2) {
            this.f4108a.putString(str, str2);
            return this;
        }
    }

    ShareOpenGraphValueContainer(Parcel parcel) {
        this.f4107a = parcel.readBundle(a.class.getClassLoader());
    }

    protected ShareOpenGraphValueContainer(a<P, E> aVar) {
        this.f4107a = (Bundle) ((a) aVar).f4108a.clone();
    }

    public Object a(String str) {
        return this.f4107a.get(str);
    }

    public Bundle b() {
        return (Bundle) this.f4107a.clone();
    }

    public String b(String str) {
        return this.f4107a.getString(str);
    }

    public Set<String> c() {
        return this.f4107a.keySet();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f4107a);
    }
}
