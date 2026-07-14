package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final com.google.android.gms.plus.internal.model.people.zza CREATOR = new com.google.android.gms.plus.internal.model.people.zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
    final int mVersionCode;
    String zzF;
    String zzVu;
    String zzZe;
    final Set<Integer> zzaZA;
    String zzbaA;
    String zzbaB;
    int zzbaC;
    CoverEntity zzbaD;
    String zzbaE;
    ImageEntity zzbaF;
    boolean zzbaG;
    NameEntity zzbaH;
    String zzbaI;
    int zzbaJ;
    List<OrganizationsEntity> zzbaK;
    List<PlacesLivedEntity> zzbaL;
    int zzbaM;
    int zzbaN;
    String zzbaO;
    List<UrlsEntity> zzbaP;
    boolean zzbaQ;
    String zzbay;
    AgeRangeEntity zzbaz;
    int zztH;
    String zzxX;

    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements Person.AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzaZA;
        int zzbaR;
        int zzbaS;

        static {
            zzaZz.put("max", FastJsonResponse.Field.zzi("max", 2));
            zzaZz.put("min", FastJsonResponse.Field.zzi("min", 3));
        }

        public AgeRangeEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        AgeRangeEntity(Set<Integer> set, int i, int i2, int i3) {
            this.zzaZA = set;
            this.mVersionCode = i;
            this.zzbaR = i2;
            this.zzbaS = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzb zzbVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                if (zza(field)) {
                    if (ageRangeEntity.zza(field) && zzb(field).equals(ageRangeEntity.zzb(field))) {
                    }
                    return false;
                }
                if (ageRangeEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public int getMax() {
            return this.zzbaR;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public int getMin() {
            return this.zzbaS;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public boolean hasMax() {
            return this.zzaZA.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public boolean hasMin() {
            return this.zzaZA.contains(3);
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
        /* JADX INFO: renamed from: zzDv, reason: merged with bridge method [inline-methods] */
        public AgeRangeEntity freeze() {
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
                    return Integer.valueOf(this.zzbaR);
                case 3:
                    return Integer.valueOf(this.zzbaS);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Person.Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzaZA;
        CoverInfoEntity zzbaT;
        CoverPhotoEntity zzbaU;
        int zzbaV;

        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
            final int mVersionCode;
            final Set<Integer> zzaZA;
            int zzbaW;
            int zzbaX;

            static {
                zzaZz.put("leftImageOffset", FastJsonResponse.Field.zzi("leftImageOffset", 2));
                zzaZz.put("topImageOffset", FastJsonResponse.Field.zzi("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.mVersionCode = 1;
                this.zzaZA = new HashSet();
            }

            CoverInfoEntity(Set<Integer> set, int i, int i2, int i3) {
                this.zzaZA = set;
                this.mVersionCode = i;
                this.zzbaW = i2;
                this.zzbaX = i3;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                zzd zzdVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                    if (zza(field)) {
                        if (coverInfoEntity.zza(field) && zzb(field).equals(coverInfoEntity.zzb(field))) {
                        }
                        return false;
                    }
                    if (coverInfoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public int getLeftImageOffset() {
                return this.zzbaW;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public int getTopImageOffset() {
                return this.zzbaX;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public boolean hasLeftImageOffset() {
                return this.zzaZA.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public boolean hasTopImageOffset() {
                return this.zzaZA.contains(3);
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
                zzd zzdVar = CREATOR;
                zzd.zza(this, parcel, i);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
            public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
                return zzaZz;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* JADX INFO: renamed from: zzDx, reason: merged with bridge method [inline-methods] */
            public CoverInfoEntity freeze() {
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
                        return Integer.valueOf(this.zzbaW);
                    case 3:
                        return Integer.valueOf(this.zzbaX);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
                }
            }
        }

        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
            final int mVersionCode;
            String zzF;
            final Set<Integer> zzaZA;
            int zzov;
            int zzow;

            static {
                zzaZz.put("height", FastJsonResponse.Field.zzi("height", 2));
                zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzaZz.put("width", FastJsonResponse.Field.zzi("width", 4));
            }

            public CoverPhotoEntity() {
                this.mVersionCode = 1;
                this.zzaZA = new HashSet();
            }

            CoverPhotoEntity(Set<Integer> set, int i, int i2, String str, int i3) {
                this.zzaZA = set;
                this.mVersionCode = i;
                this.zzow = i2;
                this.zzF = str;
                this.zzov = i3;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                zze zzeVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                    if (zza(field)) {
                        if (coverPhotoEntity.zza(field) && zzb(field).equals(coverPhotoEntity.zzb(field))) {
                        }
                        return false;
                    }
                    if (coverPhotoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public int getHeight() {
                return this.zzow;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public String getUrl() {
                return this.zzF;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public int getWidth() {
                return this.zzov;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasHeight() {
                return this.zzaZA.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasUrl() {
                return this.zzaZA.contains(3);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasWidth() {
                return this.zzaZA.contains(4);
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
                zze zzeVar = CREATOR;
                zze.zza(this, parcel, i);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
            public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
                return zzaZz;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* JADX INFO: renamed from: zzDy, reason: merged with bridge method [inline-methods] */
            public CoverPhotoEntity freeze() {
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
                        return Integer.valueOf(this.zzow);
                    case 3:
                        return this.zzF;
                    case 4:
                        return Integer.valueOf(this.zzov);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
                }
            }
        }

        static {
            zzaZz.put("coverInfo", FastJsonResponse.Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzaZz.put("coverPhoto", FastJsonResponse.Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzaZz.put("layout", FastJsonResponse.Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
        }

        public CoverEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        CoverEntity(Set<Integer> set, int i, CoverInfoEntity coverInfoEntity, CoverPhotoEntity coverPhotoEntity, int i2) {
            this.zzaZA = set;
            this.mVersionCode = i;
            this.zzbaT = coverInfoEntity;
            this.zzbaU = coverPhotoEntity;
            this.zzbaV = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                if (zza(field)) {
                    if (coverEntity.zza(field) && zzb(field).equals(coverEntity.zzb(field))) {
                    }
                    return false;
                }
                if (coverEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public Person.Cover.CoverInfo getCoverInfo() {
            return this.zzbaT;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.zzbaU;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public int getLayout() {
            return this.zzbaV;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasCoverInfo() {
            return this.zzaZA.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasCoverPhoto() {
            return this.zzaZA.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasLayout() {
            return this.zzaZA.contains(4);
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
            zzc zzcVar = CREATOR;
            zzc.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
            return zzaZz;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzDw, reason: merged with bridge method [inline-methods] */
        public CoverEntity freeze() {
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
                    return this.zzbaT;
                case 3:
                    return this.zzbaU;
                case 4:
                    return Integer.valueOf(this.zzbaV);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Person.Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
        final int mVersionCode;
        String zzF;
        final Set<Integer> zzaZA;

        static {
            zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public ImageEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        public ImageEntity(String str) {
            this.zzaZA = new HashSet();
            this.mVersionCode = 1;
            this.zzF = str;
            this.zzaZA.add(2);
        }

        ImageEntity(Set<Integer> set, int i, String str) {
            this.zzaZA = set;
            this.mVersionCode = i;
            this.zzF = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzf zzfVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                if (zza(field)) {
                    if (imageEntity.zza(field) && zzb(field).equals(imageEntity.zzb(field))) {
                    }
                    return false;
                }
                if (imageEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public String getUrl() {
            return this.zzF;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public boolean hasUrl() {
            return this.zzaZA.contains(2);
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
            zzf zzfVar = CREATOR;
            zzf.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
            return zzaZz;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzDz, reason: merged with bridge method [inline-methods] */
        public ImageEntity freeze() {
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
                    return this.zzF;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Person.Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzaZA;
        String zzaZY;
        String zzbaY;
        String zzbaZ;
        String zzbab;
        String zzbba;
        String zzbbb;

        static {
            zzaZz.put("familyName", FastJsonResponse.Field.zzl("familyName", 2));
            zzaZz.put("formatted", FastJsonResponse.Field.zzl("formatted", 3));
            zzaZz.put("givenName", FastJsonResponse.Field.zzl("givenName", 4));
            zzaZz.put("honorificPrefix", FastJsonResponse.Field.zzl("honorificPrefix", 5));
            zzaZz.put("honorificSuffix", FastJsonResponse.Field.zzl("honorificSuffix", 6));
            zzaZz.put("middleName", FastJsonResponse.Field.zzl("middleName", 7));
        }

        public NameEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        NameEntity(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.zzaZA = set;
            this.mVersionCode = i;
            this.zzaZY = str;
            this.zzbaY = str2;
            this.zzbab = str3;
            this.zzbaZ = str4;
            this.zzbba = str5;
            this.zzbbb = str6;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzg zzgVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                if (zza(field)) {
                    if (nameEntity.zza(field) && zzb(field).equals(nameEntity.zzb(field))) {
                    }
                    return false;
                }
                if (nameEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getFamilyName() {
            return this.zzaZY;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getFormatted() {
            return this.zzbaY;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getGivenName() {
            return this.zzbab;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getHonorificPrefix() {
            return this.zzbaZ;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getHonorificSuffix() {
            return this.zzbba;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getMiddleName() {
            return this.zzbbb;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasFamilyName() {
            return this.zzaZA.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasFormatted() {
            return this.zzaZA.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasGivenName() {
            return this.zzaZA.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasHonorificPrefix() {
            return this.zzaZA.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasHonorificSuffix() {
            return this.zzaZA.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasMiddleName() {
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
            zzg zzgVar = CREATOR;
            zzg.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzDA, reason: merged with bridge method [inline-methods] */
        public NameEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
            return zzaZz;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrc()) {
                case 2:
                    return this.zzaZY;
                case 3:
                    return this.zzbaY;
                case 4:
                    return this.zzbab;
                case 5:
                    return this.zzbaZ;
                case 6:
                    return this.zzbba;
                case 7:
                    return this.zzbbb;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Person.Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
        String mName;
        final int mVersionCode;
        int zzZU;
        final Set<Integer> zzaZA;
        String zzaZX;
        String zzank;
        String zzavc;
        String zzban;
        String zzbbc;
        String zzbbd;
        boolean zzbbe;

        static {
            zzaZz.put("department", FastJsonResponse.Field.zzl("department", 2));
            zzaZz.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzaZz.put("endDate", FastJsonResponse.Field.zzl("endDate", 4));
            zzaZz.put("location", FastJsonResponse.Field.zzl("location", 5));
            zzaZz.put("name", FastJsonResponse.Field.zzl("name", 6));
            zzaZz.put("primary", FastJsonResponse.Field.zzk("primary", 7));
            zzaZz.put("startDate", FastJsonResponse.Field.zzl("startDate", 8));
            zzaZz.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzaZz.put(Constants.SMS_COLUMN_TYPE, FastJsonResponse.Field.zza(Constants.SMS_COLUMN_TYPE, 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        OrganizationsEntity(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.zzaZA = set;
            this.mVersionCode = i;
            this.zzbbc = str;
            this.zzavc = str2;
            this.zzaZX = str3;
            this.zzbbd = str4;
            this.mName = str5;
            this.zzbbe = z;
            this.zzban = str6;
            this.zzank = str7;
            this.zzZU = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzh zzhVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                if (zza(field)) {
                    if (organizationsEntity.zza(field) && zzb(field).equals(organizationsEntity.zzb(field))) {
                    }
                    return false;
                }
                if (organizationsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getDepartment() {
            return this.zzbbc;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getDescription() {
            return this.zzavc;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getEndDate() {
            return this.zzaZX;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getLocation() {
            return this.zzbbd;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getName() {
            return this.mName;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getStartDate() {
            return this.zzban;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getTitle() {
            return this.zzank;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public int getType() {
            return this.zzZU;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasDepartment() {
            return this.zzaZA.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasDescription() {
            return this.zzaZA.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasEndDate() {
            return this.zzaZA.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasLocation() {
            return this.zzaZA.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasName() {
            return this.zzaZA.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasPrimary() {
            return this.zzaZA.contains(7);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasStartDate() {
            return this.zzaZA.contains(8);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasTitle() {
            return this.zzaZA.contains(9);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasType() {
            return this.zzaZA.contains(10);
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

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean isPrimary() {
            return this.zzbbe;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzh zzhVar = CREATOR;
            zzh.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzDB, reason: merged with bridge method [inline-methods] */
        public OrganizationsEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
            return zzaZz;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrc()) {
                case 2:
                    return this.zzbbc;
                case 3:
                    return this.zzavc;
                case 4:
                    return this.zzaZX;
                case 5:
                    return this.zzbbd;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzbbe);
                case 8:
                    return this.zzban;
                case 9:
                    return this.zzank;
                case 10:
                    return Integer.valueOf(this.zzZU);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzaZA;
        boolean zzbbe;

        static {
            zzaZz.put("primary", FastJsonResponse.Field.zzk("primary", 2));
            zzaZz.put("value", FastJsonResponse.Field.zzl("value", 3));
        }

        public PlacesLivedEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        PlacesLivedEntity(Set<Integer> set, int i, boolean z, String str) {
            this.zzaZA = set;
            this.mVersionCode = i;
            this.zzbbe = z;
            this.mValue = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzi zziVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                if (zza(field)) {
                    if (placesLivedEntity.zza(field) && zzb(field).equals(placesLivedEntity.zzb(field))) {
                    }
                    return false;
                }
                if (placesLivedEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public String getValue() {
            return this.mValue;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean hasPrimary() {
            return this.zzaZA.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean hasValue() {
            return this.zzaZA.contains(3);
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

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean isPrimary() {
            return this.zzbbe;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzi zziVar = CREATOR;
            zzi.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzDC, reason: merged with bridge method [inline-methods] */
        public PlacesLivedEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
            return zzaZz;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrc()) {
                case 2:
                    return Boolean.valueOf(this.zzbbe);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Person.Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
        String mValue;
        final int mVersionCode;
        int zzZU;
        String zzaRQ;
        final Set<Integer> zzaZA;
        private final int zzbbf;

        static {
            zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzaZz.put(Constants.SMS_COLUMN_TYPE, FastJsonResponse.Field.zza(Constants.SMS_COLUMN_TYPE, 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh(Scopes.PROFILE, 3).zzh("other", 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzaZz.put("value", FastJsonResponse.Field.zzl("value", 4));
        }

        public UrlsEntity() {
            this.zzbbf = 4;
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        UrlsEntity(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.zzbbf = 4;
            this.zzaZA = set;
            this.mVersionCode = i;
            this.zzaRQ = str;
            this.zzZU = i2;
            this.mValue = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzj zzjVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
                if (zza(field)) {
                    if (urlsEntity.zza(field) && zzb(field).equals(urlsEntity.zzb(field))) {
                    }
                    return false;
                }
                if (urlsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public String getLabel() {
            return this.zzaRQ;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public int getType() {
            return this.zzZU;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public String getValue() {
            return this.mValue;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasLabel() {
            return this.zzaZA.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasType() {
            return this.zzaZA.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasValue() {
            return this.zzaZA.contains(4);
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
            zzj zzjVar = CREATOR;
            zzj.zza(this, parcel, i);
        }

        @Deprecated
        public int zzDD() {
            return 4;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzDE, reason: merged with bridge method [inline-methods] */
        public UrlsEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
            return zzaZz;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrc()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzaRQ;
                case 6:
                    return Integer.valueOf(this.zzZU);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }
    }

    public static class zza {
        public static int zzeT(String str) {
            if (str.equals(Constants.SMS_COLUMN_PERSON)) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    static {
        zzaZz.put("aboutMe", FastJsonResponse.Field.zzl("aboutMe", 2));
        zzaZz.put("ageRange", FastJsonResponse.Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzaZz.put("birthday", FastJsonResponse.Field.zzl("birthday", 4));
        zzaZz.put("braggingRights", FastJsonResponse.Field.zzl("braggingRights", 5));
        zzaZz.put("circledByCount", FastJsonResponse.Field.zzi("circledByCount", 6));
        zzaZz.put("cover", FastJsonResponse.Field.zza("cover", 7, CoverEntity.class));
        zzaZz.put("currentLocation", FastJsonResponse.Field.zzl("currentLocation", 8));
        zzaZz.put("displayName", FastJsonResponse.Field.zzl("displayName", 9));
        zzaZz.put("gender", FastJsonResponse.Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh("other", 2), false));
        zzaZz.put("id", FastJsonResponse.Field.zzl("id", 14));
        zzaZz.put("image", FastJsonResponse.Field.zza("image", 15, ImageEntity.class));
        zzaZz.put("isPlusUser", FastJsonResponse.Field.zzk("isPlusUser", 16));
        zzaZz.put("language", FastJsonResponse.Field.zzl("language", 18));
        zzaZz.put("name", FastJsonResponse.Field.zza("name", 19, NameEntity.class));
        zzaZz.put("nickname", FastJsonResponse.Field.zzl("nickname", 20));
        zzaZz.put("objectType", FastJsonResponse.Field.zza("objectType", 21, new StringToIntConverter().zzh(Constants.SMS_COLUMN_PERSON, 0).zzh("page", 1), false));
        zzaZz.put("organizations", FastJsonResponse.Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzaZz.put("placesLived", FastJsonResponse.Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzaZz.put("plusOneCount", FastJsonResponse.Field.zzi("plusOneCount", 24));
        zzaZz.put("relationshipStatus", FastJsonResponse.Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzaZz.put("tagline", FastJsonResponse.Field.zzl("tagline", 26));
        zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzaZz.put("urls", FastJsonResponse.Field.zzb("urls", 28, UrlsEntity.class));
        zzaZz.put("verified", FastJsonResponse.Field.zzk("verified", 29));
    }

    public PersonEntity() {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
    }

    public PersonEntity(String str, String str2, ImageEntity imageEntity, int i, String str3) {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
        this.zzVu = str;
        this.zzaZA.add(9);
        this.zzxX = str2;
        this.zzaZA.add(14);
        this.zzbaF = imageEntity;
        this.zzaZA.add(15);
        this.zzbaJ = i;
        this.zzaZA.add(21);
        this.zzF = str3;
        this.zzaZA.add(27);
    }

    PersonEntity(Set<Integer> set, int i, String str, AgeRangeEntity ageRangeEntity, String str2, String str3, int i2, CoverEntity coverEntity, String str4, String str5, int i3, String str6, ImageEntity imageEntity, boolean z, String str7, NameEntity nameEntity, String str8, int i4, List<OrganizationsEntity> list, List<PlacesLivedEntity> list2, int i5, int i6, String str9, String str10, List<UrlsEntity> list3, boolean z2) {
        this.zzaZA = set;
        this.mVersionCode = i;
        this.zzbay = str;
        this.zzbaz = ageRangeEntity;
        this.zzbaA = str2;
        this.zzbaB = str3;
        this.zzbaC = i2;
        this.zzbaD = coverEntity;
        this.zzbaE = str4;
        this.zzVu = str5;
        this.zztH = i3;
        this.zzxX = str6;
        this.zzbaF = imageEntity;
        this.zzbaG = z;
        this.zzZe = str7;
        this.zzbaH = nameEntity;
        this.zzbaI = str8;
        this.zzbaJ = i4;
        this.zzbaK = list;
        this.zzbaL = list2;
        this.zzbaM = i5;
        this.zzbaN = i6;
        this.zzbaO = str9;
        this.zzF = str10;
        this.zzbaP = list3;
        this.zzbaQ = z2;
    }

    public static PersonEntity zzu(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        PersonEntity personEntityCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return personEntityCreateFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        com.google.android.gms.plus.internal.model.people.zza zzaVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
            if (zza(field)) {
                if (personEntity.zza(field) && zzb(field).equals(personEntity.zzb(field))) {
                }
                return false;
            }
            if (personEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getAboutMe() {
        return this.zzbay;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.AgeRange getAgeRange() {
        return this.zzbaz;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getBirthday() {
        return this.zzbaA;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getBraggingRights() {
        return this.zzbaB;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getCircledByCount() {
        return this.zzbaC;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Cover getCover() {
        return this.zzbaD;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getCurrentLocation() {
        return this.zzbaE;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getDisplayName() {
        return this.zzVu;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getGender() {
        return this.zztH;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getId() {
        return this.zzxX;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Image getImage() {
        return this.zzbaF;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getLanguage() {
        return this.zzZe;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Name getName() {
        return this.zzbaH;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getNickname() {
        return this.zzbaI;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getObjectType() {
        return this.zzbaJ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.zzbaK;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzbaL;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getPlusOneCount() {
        return this.zzbaM;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getRelationshipStatus() {
        return this.zzbaN;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getTagline() {
        return this.zzbaO;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getUrl() {
        return this.zzF;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.Urls> getUrls() {
        return (ArrayList) this.zzbaP;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasAboutMe() {
        return this.zzaZA.contains(2);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasAgeRange() {
        return this.zzaZA.contains(3);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasBirthday() {
        return this.zzaZA.contains(4);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasBraggingRights() {
        return this.zzaZA.contains(5);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCircledByCount() {
        return this.zzaZA.contains(6);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCover() {
        return this.zzaZA.contains(7);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCurrentLocation() {
        return this.zzaZA.contains(8);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasDisplayName() {
        return this.zzaZA.contains(9);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasGender() {
        return this.zzaZA.contains(12);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasId() {
        return this.zzaZA.contains(14);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasImage() {
        return this.zzaZA.contains(15);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasIsPlusUser() {
        return this.zzaZA.contains(16);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasLanguage() {
        return this.zzaZA.contains(18);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasName() {
        return this.zzaZA.contains(19);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasNickname() {
        return this.zzaZA.contains(20);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasObjectType() {
        return this.zzaZA.contains(21);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasOrganizations() {
        return this.zzaZA.contains(22);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasPlacesLived() {
        return this.zzaZA.contains(23);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasPlusOneCount() {
        return this.zzaZA.contains(24);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasRelationshipStatus() {
        return this.zzaZA.contains(25);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasTagline() {
        return this.zzaZA.contains(26);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasUrl() {
        return this.zzaZA.contains(27);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasUrls() {
        return this.zzaZA.contains(28);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasVerified() {
        return this.zzaZA.contains(29);
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

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean isPlusUser() {
        return this.zzbaG;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean isVerified() {
        return this.zzbaQ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.plus.internal.model.people.zza zzaVar = CREATOR;
        com.google.android.gms.plus.internal.model.people.zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
        return zzaZz;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzDu, reason: merged with bridge method [inline-methods] */
    public PersonEntity freeze() {
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
                return this.zzbay;
            case 3:
                return this.zzbaz;
            case 4:
                return this.zzbaA;
            case 5:
                return this.zzbaB;
            case 6:
                return Integer.valueOf(this.zzbaC);
            case 7:
                return this.zzbaD;
            case 8:
                return this.zzbaE;
            case 9:
                return this.zzVu;
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            case 12:
                return Integer.valueOf(this.zztH);
            case 14:
                return this.zzxX;
            case 15:
                return this.zzbaF;
            case 16:
                return Boolean.valueOf(this.zzbaG);
            case 18:
                return this.zzZe;
            case 19:
                return this.zzbaH;
            case 20:
                return this.zzbaI;
            case 21:
                return Integer.valueOf(this.zzbaJ);
            case 22:
                return this.zzbaK;
            case 23:
                return this.zzbaL;
            case 24:
                return Integer.valueOf(this.zzbaM);
            case 25:
                return Integer.valueOf(this.zzbaN);
            case 26:
                return this.zzbaO;
            case 27:
                return this.zzF;
            case 28:
                return this.zzbaP;
            case 29:
                return Boolean.valueOf(this.zzbaQ);
        }
    }
}
