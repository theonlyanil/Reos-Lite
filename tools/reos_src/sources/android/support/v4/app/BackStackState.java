package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: android.support.v4.app.BackStackState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f527f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;

    public BackStackState(Parcel parcel) {
        this.f522a = parcel.createIntArray();
        this.f523b = parcel.readInt();
        this.f524c = parcel.readInt();
        this.f525d = parcel.readString();
        this.f526e = parcel.readInt();
        this.f527f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
    }

    public BackStackState(h hVar) {
        int size = 0;
        for (h.a aVar = hVar.f632c; aVar != null; aVar = aVar.f649a) {
            if (aVar.i != null) {
                size += aVar.i.size();
            }
        }
        this.f522a = new int[size + (hVar.f634e * 7)];
        if (!hVar.l) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        for (h.a aVar2 = hVar.f632c; aVar2 != null; aVar2 = aVar2.f649a) {
            int i2 = i + 1;
            this.f522a[i] = aVar2.f651c;
            int i3 = i2 + 1;
            this.f522a[i2] = aVar2.f652d != null ? aVar2.f652d.mIndex : -1;
            int i4 = i3 + 1;
            this.f522a[i3] = aVar2.f653e;
            int i5 = i4 + 1;
            this.f522a[i4] = aVar2.f654f;
            int i6 = i5 + 1;
            this.f522a[i5] = aVar2.g;
            int i7 = i6 + 1;
            this.f522a[i6] = aVar2.h;
            if (aVar2.i != null) {
                int size2 = aVar2.i.size();
                int i8 = i7 + 1;
                this.f522a[i7] = size2;
                int i9 = 0;
                while (i9 < size2) {
                    this.f522a[i8] = aVar2.i.get(i9).mIndex;
                    i9++;
                    i8++;
                }
                i = i8;
            } else {
                i = i7 + 1;
                this.f522a[i7] = 0;
            }
        }
        this.f523b = hVar.j;
        this.f524c = hVar.k;
        this.f525d = hVar.n;
        this.f526e = hVar.p;
        this.f527f = hVar.q;
        this.g = hVar.r;
        this.h = hVar.s;
        this.i = hVar.t;
        this.j = hVar.u;
        this.k = hVar.v;
    }

    public h a(u uVar) {
        h hVar = new h(uVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f522a.length) {
            h.a aVar = new h.a();
            int i3 = i2 + 1;
            aVar.f651c = this.f522a[i2];
            if (u.f674a) {
                Log.v("FragmentManager", "Instantiate " + hVar + " op #" + i + " base fragment #" + this.f522a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f522a[i3];
            if (i5 >= 0) {
                aVar.f652d = uVar.f679f.get(i5);
            } else {
                aVar.f652d = null;
            }
            int i6 = i4 + 1;
            aVar.f653e = this.f522a[i4];
            int i7 = i6 + 1;
            aVar.f654f = this.f522a[i6];
            int i8 = i7 + 1;
            aVar.g = this.f522a[i7];
            int i9 = i8 + 1;
            aVar.h = this.f522a[i8];
            int i10 = i9 + 1;
            int i11 = this.f522a[i9];
            if (i11 > 0) {
                aVar.i = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (u.f674a) {
                        Log.v("FragmentManager", "Instantiate " + hVar + " set remove fragment #" + this.f522a[i10]);
                    }
                    aVar.i.add(uVar.f679f.get(this.f522a[i10]));
                    i12++;
                    i10++;
                }
            }
            hVar.f635f = aVar.f653e;
            hVar.g = aVar.f654f;
            hVar.h = aVar.g;
            hVar.i = aVar.h;
            hVar.a(aVar);
            i++;
            i2 = i10;
        }
        hVar.j = this.f523b;
        hVar.k = this.f524c;
        hVar.n = this.f525d;
        hVar.p = this.f526e;
        hVar.l = true;
        hVar.q = this.f527f;
        hVar.r = this.g;
        hVar.s = this.h;
        hVar.t = this.i;
        hVar.u = this.j;
        hVar.v = this.k;
        hVar.a(1);
        return hVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f522a);
        parcel.writeInt(this.f523b);
        parcel.writeInt(this.f524c);
        parcel.writeString(this.f525d);
        parcel.writeInt(this.f526e);
        parcel.writeInt(this.f527f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
    }
}
