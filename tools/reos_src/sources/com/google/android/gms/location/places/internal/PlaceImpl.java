package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class PlaceImpl implements SafeParcelable, Place {
    public static final zzl CREATOR = new zzl();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaMo;
    private final List<Integer> zzaMp;
    private final String zzaMq;
    private final Uri zzaMr;
    private final Bundle zzaND;

    @Deprecated
    private final PlaceLocalization zzaNE;
    private final float zzaNF;
    private final LatLngBounds zzaNG;
    private final String zzaNH;
    private final boolean zzaNI;
    private final float zzaNJ;
    private final int zzaNK;
    private final long zzaNL;
    private final List<Integer> zzaNM;
    private final String zzaNN;
    private final List<String> zzaNO;
    final boolean zzaNP;
    private final Map<Integer, String> zzaNQ;
    private final TimeZone zzaNR;
    private zzp zzaNS;
    private Locale zzaNy;
    private final String zzatX;
    private final String zzxX;

    public static class zza {
        private String mName;
        private int mVersionCode = 0;
        private LatLng zzaMo;
        private String zzaMq;
        private Uri zzaMr;
        private float zzaNF;
        private LatLngBounds zzaNG;
        private String zzaNH;
        private boolean zzaNI;
        private float zzaNJ;
        private int zzaNK;
        private long zzaNL;
        private String zzaNN;
        private List<String> zzaNO;
        private boolean zzaNP;
        private Bundle zzaNT;
        private List<Integer> zzaNU;
        private String zzatX;
        private String zzxX;

        public zza zza(LatLng latLng) {
            this.zzaMo = latLng;
            return this;
        }

        public zza zza(LatLngBounds latLngBounds) {
            this.zzaNG = latLngBounds;
            return this;
        }

        public zza zzaj(boolean z) {
            this.zzaNI = z;
            return this;
        }

        public zza zzak(boolean z) {
            this.zzaNP = z;
            return this;
        }

        public zza zzdX(String str) {
            this.zzxX = str;
            return this;
        }

        public zza zzdY(String str) {
            this.mName = str;
            return this;
        }

        public zza zzdZ(String str) {
            this.zzatX = str;
            return this;
        }

        public zza zzea(String str) {
            this.zzaMq = str;
            return this;
        }

        public zza zzf(float f2) {
            this.zzaNF = f2;
            return this;
        }

        public zza zzg(float f2) {
            this.zzaNJ = f2;
            return this;
        }

        public zza zzhM(int i) {
            this.zzaNK = i;
            return this;
        }

        public zza zzo(Uri uri) {
            this.zzaMr = uri;
            return this;
        }

        public zza zzv(List<Integer> list) {
            this.zzaNU = list;
            return this;
        }

        public zza zzw(List<String> list) {
            this.zzaNO = list;
            return this;
        }

        public PlaceImpl zzyL() {
            return new PlaceImpl(this.mVersionCode, this.zzxX, this.zzaNU, Collections.emptyList(), this.zzaNT, this.mName, this.zzatX, this.zzaMq, this.zzaNN, this.zzaNO, this.zzaMo, this.zzaNF, this.zzaNG, this.zzaNH, this.zzaMr, this.zzaNI, this.zzaNJ, this.zzaNK, this.zzaNL, this.zzaNP, PlaceLocalization.zza(this.mName, this.zzatX, this.zzaMq, this.zzaNN, this.zzaNO));
        }
    }

    PlaceImpl(int i, String str, List<Integer> list, List<Integer> list2, Bundle bundle, String str2, String str3, String str4, String str5, List<String> list3, LatLng latLng, float f2, LatLngBounds latLngBounds, String str6, Uri uri, boolean z, float f3, int i2, long j, boolean z2, PlaceLocalization placeLocalization) {
        this.mVersionCode = i;
        this.zzxX = str;
        this.zzaMp = Collections.unmodifiableList(list);
        this.zzaNM = list2;
        this.zzaND = bundle == null ? new Bundle() : bundle;
        this.mName = str2;
        this.zzatX = str3;
        this.zzaMq = str4;
        this.zzaNN = str5;
        this.zzaNO = list3 == null ? Collections.emptyList() : list3;
        this.zzaMo = latLng;
        this.zzaNF = f2;
        this.zzaNG = latLngBounds;
        this.zzaNH = str6 == null ? "UTC" : str6;
        this.zzaMr = uri;
        this.zzaNI = z;
        this.zzaNJ = f3;
        this.zzaNK = i2;
        this.zzaNL = j;
        this.zzaNQ = Collections.unmodifiableMap(new HashMap());
        this.zzaNR = null;
        this.zzaNy = null;
        this.zzaNP = z2;
        this.zzaNE = placeLocalization;
    }

    private void zzdW(String str) {
        if (!this.zzaNP || this.zzaNS == null) {
            return;
        }
        this.zzaNS.zzH(this.zzxX, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzl zzlVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceImpl)) {
            return false;
        }
        PlaceImpl placeImpl = (PlaceImpl) obj;
        return this.zzxX.equals(placeImpl.zzxX) && zzw.equal(this.zzaNy, placeImpl.zzaNy) && this.zzaNL == placeImpl.zzaNL;
    }

    @Override // com.google.android.gms.location.places.Place
    public String getAddress() {
        zzdW("getAddress");
        return this.zzatX;
    }

    @Override // com.google.android.gms.location.places.Place
    public String getId() {
        zzdW("getId");
        return this.zzxX;
    }

    @Override // com.google.android.gms.location.places.Place
    public LatLng getLatLng() {
        zzdW("getLatLng");
        return this.zzaMo;
    }

    @Override // com.google.android.gms.location.places.Place
    public Locale getLocale() {
        zzdW("getLocale");
        return this.zzaNy;
    }

    @Override // com.google.android.gms.location.places.Place
    public String getName() {
        zzdW("getName");
        return this.mName;
    }

    @Override // com.google.android.gms.location.places.Place
    public String getPhoneNumber() {
        zzdW("getPhoneNumber");
        return this.zzaMq;
    }

    @Override // com.google.android.gms.location.places.Place
    public List<Integer> getPlaceTypes() {
        zzdW("getPlaceTypes");
        return this.zzaMp;
    }

    @Override // com.google.android.gms.location.places.Place
    public int getPriceLevel() {
        zzdW("getPriceLevel");
        return this.zzaNK;
    }

    @Override // com.google.android.gms.location.places.Place
    public float getRating() {
        zzdW("getRating");
        return this.zzaNJ;
    }

    @Override // com.google.android.gms.location.places.Place
    public LatLngBounds getViewport() {
        zzdW("getViewport");
        return this.zzaNG;
    }

    @Override // com.google.android.gms.location.places.Place
    public Uri getWebsiteUri() {
        zzdW("getWebsiteUri");
        return this.zzaMr;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzxX, this.zzaNy, Long.valueOf(this.zzaNL));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public void setLocale(Locale locale) {
        this.zzaNy = locale;
    }

    public String toString() {
        return zzw.zzx(this).zzg("id", this.zzxX).zzg("placeTypes", this.zzaMp).zzg("locale", this.zzaNy).zzg("name", this.mName).zzg(Constants.SMS_COLUMN_ADDRESS, this.zzatX).zzg("phoneNumber", this.zzaMq).zzg("latlng", this.zzaMo).zzg("viewport", this.zzaNG).zzg("websiteUri", this.zzaMr).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzaNI)).zzg("priceLevel", Integer.valueOf(this.zzaNK)).zzg("timestampSecs", Long.valueOf(this.zzaNL)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl zzlVar = CREATOR;
        zzl.zza(this, parcel, i);
    }

    public void zza(zzp zzpVar) {
        this.zzaNS = zzpVar;
    }

    public List<Integer> zzyB() {
        zzdW("getTypesDeprecated");
        return this.zzaNM;
    }

    public float zzyC() {
        zzdW("getLevelNumber");
        return this.zzaNF;
    }

    public String zzyD() {
        zzdW("getRegularOpenHours");
        return this.zzaNN;
    }

    public List<String> zzyE() {
        zzdW("getAttributions");
        return this.zzaNO;
    }

    public boolean zzyF() {
        zzdW("isPermanentlyClosed");
        return this.zzaNI;
    }

    public long zzyG() {
        return this.zzaNL;
    }

    public Bundle zzyH() {
        return this.zzaND;
    }

    public String zzyI() {
        return this.zzaNH;
    }

    @Deprecated
    public PlaceLocalization zzyJ() {
        zzdW("getLocalization");
        return this.zzaNE;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzyK, reason: merged with bridge method [inline-methods] */
    public Place freeze() {
        return this;
    }
}
