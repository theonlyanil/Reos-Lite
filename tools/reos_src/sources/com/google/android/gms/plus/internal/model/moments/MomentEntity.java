package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
    final int mVersionCode;
    String zzIx;
    final Set<Integer> zzaZA;
    String zzban;
    ItemScopeEntity zzbav;
    ItemScopeEntity zzbaw;
    String zzxX;

    static {
        zzaZz.put("id", FastJsonResponse.Field.zzl("id", 2));
        zzaZz.put("result", FastJsonResponse.Field.zza("result", 4, ItemScopeEntity.class));
        zzaZz.put("startDate", FastJsonResponse.Field.zzl("startDate", 5));
        zzaZz.put("target", FastJsonResponse.Field.zza("target", 6, ItemScopeEntity.class));
        zzaZz.put(Constants.SMS_COLUMN_TYPE, FastJsonResponse.Field.zzl(Constants.SMS_COLUMN_TYPE, 7));
    }

    public MomentEntity() {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
    }

    MomentEntity(Set<Integer> set, int i, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.zzaZA = set;
        this.mVersionCode = i;
        this.zzxX = str;
        this.zzbav = itemScopeEntity;
        this.zzban = str2;
        this.zzbaw = itemScopeEntity2;
        this.zzIx = str3;
    }

    public MomentEntity(Set<Integer> set, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.zzaZA = set;
        this.mVersionCode = 1;
        this.zzxX = str;
        this.zzbav = itemScopeEntity;
        this.zzban = str2;
        this.zzbaw = itemScopeEntity2;
        this.zzIx = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
            if (zza(field)) {
                if (momentEntity.zza(field) && zzb(field).equals(momentEntity.zzb(field))) {
                }
                return false;
            }
            if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getId() {
        return this.zzxX;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public ItemScope getResult() {
        return this.zzbav;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getStartDate() {
        return this.zzban;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public ItemScope getTarget() {
        return this.zzbaw;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getType() {
        return this.zzIx;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasId() {
        return this.zzaZA.contains(2);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasResult() {
        return this.zzaZA.contains(4);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasStartDate() {
        return this.zzaZA.contains(5);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasTarget() {
        return this.zzaZA.contains(6);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasType() {
        return this.zzaZA.contains(7);
    }

    public int hashCode() {
        int iHashCode = 0;
        Iterator<FastJsonResponse.Field<?, ?>> it = zzaZz.values().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            FastJsonResponse.Field<?, ?> next = it.next();
            if (zza(next)) {
                iHashCode = zzb(next).hashCode() + i + next.zzrc();
            } else {
                iHashCode = i;
            }
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
        return zzaZz;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzDs, reason: merged with bridge method [inline-methods] */
    public MomentEntity freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zza(FastJsonResponse.Field field) {
        return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzb(FastJsonResponse.Field field) {
        switch (field.zzrc()) {
            case 2:
                return this.zzxX;
            case 3:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            case 4:
                return this.zzbav;
            case 5:
                return this.zzban;
            case 6:
                return this.zzbaw;
            case 7:
                return this.zzIx;
        }
    }
}
