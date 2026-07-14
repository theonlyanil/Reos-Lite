package android.support.v4.f;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    static class a<T> implements Parcelable.Creator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e<T> f764a;

        public a(e<T> eVar) {
            this.f764a = eVar;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return this.f764a.b(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i) {
            return this.f764a.b(i);
        }
    }

    public static <T> Parcelable.Creator<T> a(e<T> eVar) {
        return Build.VERSION.SDK_INT >= 13 ? g.a(eVar) : new a(eVar);
    }
}
