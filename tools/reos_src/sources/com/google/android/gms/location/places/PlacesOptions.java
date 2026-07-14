package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes.dex */
public final class PlacesOptions implements Api.ApiOptions.Optional {
    public final String zzaNb;
    public final int zzaNc;

    public static class Builder {
        private int zzaNc = 0;
        private String zzaNd;

        public PlacesOptions build() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.zzaNb = builder.zzaNd;
        this.zzaNc = builder.zzaNc;
    }
}
