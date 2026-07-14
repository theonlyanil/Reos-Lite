package android.support.v4.f;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
class f<T> implements Parcelable.ClassLoaderCreator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e<T> f765a;

    public f(e<T> eVar) {
        this.f765a = eVar;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return this.f765a.b(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f765a.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        return this.f765a.b(i);
    }
}
