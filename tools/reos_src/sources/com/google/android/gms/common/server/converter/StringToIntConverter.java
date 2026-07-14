package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap<String, Integer> zzakP;
    private final HashMap<Integer, String> zzakQ;
    private final ArrayList<Entry> zzakR;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzakS;
        final int zzakT;

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.zzakS = str;
            this.zzakT = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.zzakS = str;
            this.zzakT = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzc zzcVar = CREATOR;
            zzc.zza(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzakP = new HashMap<>();
        this.zzakQ = new HashMap<>();
        this.zzakR = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.zzakP = new HashMap<>();
        this.zzakQ = new HashMap<>();
        this.zzakR = null;
        zzd(arrayList);
    }

    private void zzd(ArrayList<Entry> arrayList) {
        for (Entry entry : arrayList) {
            zzh(entry.zzakS, entry.zzakT);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public String convertBack(Integer num) {
        String str = this.zzakQ.get(num);
        return (str == null && this.zzakP.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public StringToIntConverter zzh(String str, int i) {
        this.zzakP.put(str, Integer.valueOf(i));
        this.zzakQ.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<Entry> zzqS() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.zzakP.keySet()) {
            arrayList.add(new Entry(str, this.zzakP.get(str).intValue()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzqT() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzqU() {
        return 0;
    }
}
