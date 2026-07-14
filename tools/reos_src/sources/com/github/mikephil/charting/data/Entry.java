package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class Entry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() { // from class: com.github.mikephil.charting.data.Entry.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Entry[] newArray(int i) {
            return new Entry[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f4953c;

    public Entry(float f2, int i) {
        this.f4951a = BitmapDescriptorFactory.HUE_RED;
        this.f4952b = 0;
        this.f4953c = null;
        this.f4951a = f2;
        this.f4952b = i;
    }

    protected Entry(Parcel parcel) {
        this.f4951a = BitmapDescriptorFactory.HUE_RED;
        this.f4952b = 0;
        this.f4953c = null;
        this.f4951a = parcel.readFloat();
        this.f4952b = parcel.readInt();
        if (parcel.readInt() == 1) {
            this.f4953c = parcel.readParcelable(Object.class.getClassLoader());
        }
    }

    public boolean a(Entry entry) {
        return entry != null && entry.f4953c == this.f4953c && entry.f4952b == this.f4952b && Math.abs(entry.f4951a - this.f4951a) <= 1.0E-5f;
    }

    public float b() {
        return this.f4951a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int f() {
        return this.f4952b;
    }

    public String toString() {
        return "Entry, xIndex: " + this.f4952b + " val (sum): " + b();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f4951a);
        parcel.writeInt(this.f4952b);
        if (this.f4953c == null) {
            parcel.writeInt(0);
        } else {
            if (!(this.f4953c instanceof Parcelable)) {
                throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
            }
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) this.f4953c, i);
        }
    }
}
