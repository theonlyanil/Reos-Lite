package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface Moment extends Freezable<Moment> {

    public static class Builder {
        private String zzIx;
        private final Set<Integer> zzaZA = new HashSet();
        private String zzban;
        private ItemScopeEntity zzbav;
        private ItemScopeEntity zzbaw;
        private String zzxX;

        public Moment build() {
            return new MomentEntity(this.zzaZA, this.zzxX, this.zzbav, this.zzban, this.zzbaw, this.zzIx);
        }

        public Builder setId(String str) {
            this.zzxX = str;
            this.zzaZA.add(2);
            return this;
        }

        public Builder setResult(ItemScope itemScope) {
            this.zzbav = (ItemScopeEntity) itemScope;
            this.zzaZA.add(4);
            return this;
        }

        public Builder setStartDate(String str) {
            this.zzban = str;
            this.zzaZA.add(5);
            return this;
        }

        public Builder setTarget(ItemScope itemScope) {
            this.zzbaw = (ItemScopeEntity) itemScope;
            this.zzaZA.add(6);
            return this;
        }

        public Builder setType(String str) {
            this.zzIx = str;
            this.zzaZA.add(7);
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
