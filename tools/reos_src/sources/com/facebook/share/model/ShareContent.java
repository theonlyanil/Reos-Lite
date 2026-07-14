package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareContent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareContent<P extends ShareContent, E> implements ShareModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f4088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f4089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ShareHashtag f4092e;

    protected ShareContent(Parcel parcel) {
        this.f4088a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4089b = a(parcel);
        this.f4090c = parcel.readString();
        this.f4091d = parcel.readString();
        this.f4092e = new ShareHashtag.a().a(parcel).a();
    }

    private List<String> a(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.size() == 0) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri h() {
        return this.f4088a;
    }

    public List<String> i() {
        return this.f4089b;
    }

    public String j() {
        return this.f4090c;
    }

    public String k() {
        return this.f4091d;
    }

    public ShareHashtag l() {
        return this.f4092e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4088a, 0);
        parcel.writeStringList(this.f4089b);
        parcel.writeString(this.f4090c);
        parcel.writeString(this.f4091d);
        parcel.writeParcelable(this.f4092e, 0);
    }
}
