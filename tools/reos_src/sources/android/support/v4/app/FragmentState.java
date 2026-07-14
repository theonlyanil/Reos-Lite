package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() { // from class: android.support.v4.app.FragmentState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f538f;
    final boolean g;
    final boolean h;
    final Bundle i;
    Bundle j;
    Fragment k;

    public FragmentState(Parcel parcel) {
        this.f533a = parcel.readString();
        this.f534b = parcel.readInt();
        this.f535c = parcel.readInt() != 0;
        this.f536d = parcel.readInt();
        this.f537e = parcel.readInt();
        this.f538f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readBundle();
    }

    public FragmentState(Fragment fragment) {
        this.f533a = fragment.getClass().getName();
        this.f534b = fragment.mIndex;
        this.f535c = fragment.mFromLayout;
        this.f536d = fragment.mFragmentId;
        this.f537e = fragment.mContainerId;
        this.f538f = fragment.mTag;
        this.g = fragment.mRetainInstance;
        this.h = fragment.mDetached;
        this.i = fragment.mArguments;
    }

    public Fragment a(s sVar, Fragment fragment) {
        if (this.k != null) {
            return this.k;
        }
        Context contextI = sVar.i();
        if (this.i != null) {
            this.i.setClassLoader(contextI.getClassLoader());
        }
        this.k = Fragment.instantiate(contextI, this.f533a, this.i);
        if (this.j != null) {
            this.j.setClassLoader(contextI.getClassLoader());
            this.k.mSavedFragmentState = this.j;
        }
        this.k.setIndex(this.f534b, fragment);
        this.k.mFromLayout = this.f535c;
        this.k.mRestored = true;
        this.k.mFragmentId = this.f536d;
        this.k.mContainerId = this.f537e;
        this.k.mTag = this.f538f;
        this.k.mRetainInstance = this.g;
        this.k.mDetached = this.h;
        this.k.mFragmentManager = sVar.f671d;
        if (u.f674a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.k);
        }
        return this.k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f533a);
        parcel.writeInt(this.f534b);
        parcel.writeInt(this.f535c ? 1 : 0);
        parcel.writeInt(this.f536d);
        parcel.writeInt(this.f537e);
        parcel.writeString(this.f538f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeBundle(this.j);
    }
}
