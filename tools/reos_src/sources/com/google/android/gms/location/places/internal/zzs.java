package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zzs extends zzu implements Place {
    private final String zzaMO;
    private boolean zzaNP;
    private final zzp zzaNS;

    public zzs(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.zzaNS = context != null ? zzp.zzaN(context) : null;
        this.zzaNP = zzh("place_is_logging_enabled", false);
        this.zzaMO = zzI("place_id", "");
    }

    private void zzdW(String str) {
        if (!this.zzaNP || this.zzaNS == null) {
            return;
        }
        this.zzaNS.zzH(this.zzaMO, str);
    }

    @Override // com.google.android.gms.location.places.Place
    public CharSequence getAddress() {
        zzdW("getAddress");
        return zzI("place_address", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public String getId() {
        zzdW("getId");
        return this.zzaMO;
    }

    @Override // com.google.android.gms.location.places.Place
    public LatLng getLatLng() {
        zzdW("getLatLng");
        return (LatLng) zza("place_lat_lng", LatLng.CREATOR);
    }

    @Override // com.google.android.gms.location.places.Place
    public Locale getLocale() {
        zzdW("getLocale");
        String strZzI = zzI("place_locale", "");
        return !TextUtils.isEmpty(strZzI) ? new Locale(strZzI) : Locale.getDefault();
    }

    @Override // com.google.android.gms.location.places.Place
    public CharSequence getName() {
        zzdW("getName");
        return zzI("place_name", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public CharSequence getPhoneNumber() {
        zzdW("getPhoneNumber");
        return zzI("place_phone_number", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public List<Integer> getPlaceTypes() {
        zzdW("getPlaceTypes");
        return zza("place_types", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.Place
    public int getPriceLevel() {
        zzdW("getPriceLevel");
        return zzz("place_price_level", -1);
    }

    @Override // com.google.android.gms.location.places.Place
    public float getRating() {
        zzdW("getRating");
        return zzb("place_rating", -1.0f);
    }

    @Override // com.google.android.gms.location.places.Place
    public LatLngBounds getViewport() {
        zzdW("getViewport");
        return (LatLngBounds) zza("place_viewport", LatLngBounds.CREATOR);
    }

    @Override // com.google.android.gms.location.places.Place
    public Uri getWebsiteUri() {
        zzdW("getWebsiteUri");
        String strZzI = zzI("place_website_uri", null);
        if (strZzI == null) {
            return null;
        }
        return Uri.parse(strZzI);
    }

    public float zzyC() {
        zzdW("getLevelNumber");
        return zzb("place_level_number", BitmapDescriptorFactory.HUE_RED);
    }

    public boolean zzyF() {
        zzdW("isPermanentlyClosed");
        return zzh("place_is_permanently_closed", false);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzyK, reason: merged with bridge method [inline-methods] */
    public Place freeze() {
        PlaceImpl.zza zzaVarZzak = new PlaceImpl.zza().zzak(this.zzaNP);
        this.zzaNP = false;
        PlaceImpl placeImplZzyL = zzaVarZzak.zzdZ(getAddress().toString()).zzw(zzb("place_attributions", Collections.emptyList())).zzdX(getId()).zzaj(zzyF()).zza(getLatLng()).zzf(zzyC()).zzdY(getName().toString()).zzea(getPhoneNumber().toString()).zzhM(getPriceLevel()).zzg(getRating()).zzv(getPlaceTypes()).zza(getViewport()).zzo(getWebsiteUri()).zzyL();
        placeImplZzyL.setLocale(getLocale());
        placeImplZzyL.zza(this.zzaNS);
        return placeImplZzyL;
    }
}
