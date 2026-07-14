package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

/* JADX INFO: loaded from: classes.dex */
public final class zzc extends com.google.android.gms.common.data.zzc implements Moment {
    private MomentEntity zzbax;

    public zzc(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private MomentEntity zzDt() {
        synchronized (this) {
            if (this.zzbax == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                this.zzbax = MomentEntity.CREATOR.createFromParcel(parcelObtain);
                parcelObtain.recycle();
            }
        }
        return this.zzbax;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getId() {
        return zzDt().getId();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public ItemScope getResult() {
        return zzDt().getResult();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getStartDate() {
        return zzDt().getStartDate();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public ItemScope getTarget() {
        return zzDt().getTarget();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getType() {
        return zzDt().getType();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasId() {
        return zzDt().hasId();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasResult() {
        return zzDt().hasResult();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasStartDate() {
        return zzDt().hasStartDate();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasTarget() {
        return zzDt().hasTarget();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasType() {
        return zzDt().hasType();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzDs, reason: merged with bridge method [inline-methods] */
    public MomentEntity freeze() {
        return zzDt();
    }
}
