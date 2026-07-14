package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FastJsonResponse {

    public static class Field<I, O> implements SafeParcelable {
        public static final com.google.android.gms.common.server.response.zza CREATOR = new com.google.android.gms.common.server.response.zza();
        private final int mVersionCode;
        protected final int zzakU;
        protected final boolean zzakV;
        protected final int zzakW;
        protected final boolean zzakX;
        protected final String zzakY;
        protected final int zzakZ;
        protected final Class<? extends FastJsonResponse> zzala;
        protected final String zzalb;
        private FieldMappingDictionary zzalc;
        private zza<I, O> zzald;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.mVersionCode = i;
            this.zzakU = i2;
            this.zzakV = z;
            this.zzakW = i3;
            this.zzakX = z2;
            this.zzakY = str;
            this.zzakZ = i4;
            if (str2 == null) {
                this.zzala = null;
                this.zzalb = null;
            } else {
                this.zzala = SafeParcelResponse.class;
                this.zzalb = str2;
            }
            if (converterWrapper == null) {
                this.zzald = null;
            } else {
                this.zzald = (zza<I, O>) converterWrapper.zzqR();
            }
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> zzaVar) {
            this.mVersionCode = 1;
            this.zzakU = i;
            this.zzakV = z;
            this.zzakW = i2;
            this.zzakX = z2;
            this.zzakY = str;
            this.zzakZ = i3;
            this.zzala = cls;
            if (cls == null) {
                this.zzalb = null;
            } else {
                this.zzalb = cls.getCanonicalName();
            }
            this.zzald = zzaVar;
        }

        public static Field zza(String str, int i, zza<?, ?> zzaVar, boolean z) {
            return new Field(zzaVar.zzqT(), z, zzaVar.zzqU(), false, str, i, null, zzaVar);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Integer, Integer> zzi(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public static Field<Double, Double> zzj(String str, int i) {
            return new Field<>(4, false, 4, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> zzk(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> zzl(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> zzm(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        public I convertBack(O o) {
            return this.zzald.convertBack(o);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.mVersionCode).append('\n');
            sb.append("                 typeIn=").append(this.zzakU).append('\n');
            sb.append("            typeInArray=").append(this.zzakV).append('\n');
            sb.append("                typeOut=").append(this.zzakW).append('\n');
            sb.append("           typeOutArray=").append(this.zzakX).append('\n');
            sb.append("        outputFieldName=").append(this.zzakY).append('\n');
            sb.append("      safeParcelFieldId=").append(this.zzakZ).append('\n');
            sb.append("       concreteTypeName=").append(zzre()).append('\n');
            if (zzrd() != null) {
                sb.append("     concreteType.class=").append(zzrd().getCanonicalName()).append('\n');
            }
            sb.append("          converterName=").append(this.zzald == null ? "null" : this.zzald.getClass().getCanonicalName()).append('\n');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            com.google.android.gms.common.server.response.zza.zza(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.zzalc = fieldMappingDictionary;
        }

        public int zzqT() {
            return this.zzakU;
        }

        public int zzqU() {
            return this.zzakW;
        }

        public Field<I, O> zzqY() {
            return new Field<>(this.mVersionCode, this.zzakU, this.zzakV, this.zzakW, this.zzakX, this.zzakY, this.zzakZ, this.zzalb, zzrg());
        }

        public boolean zzqZ() {
            return this.zzakV;
        }

        public boolean zzra() {
            return this.zzakX;
        }

        public String zzrb() {
            return this.zzakY;
        }

        public int zzrc() {
            return this.zzakZ;
        }

        public Class<? extends FastJsonResponse> zzrd() {
            return this.zzala;
        }

        String zzre() {
            if (this.zzalb == null) {
                return null;
            }
            return this.zzalb;
        }

        public boolean zzrf() {
            return this.zzald != null;
        }

        ConverterWrapper zzrg() {
            if (this.zzald == null) {
                return null;
            }
            return ConverterWrapper.zza(this.zzald);
        }

        public Map<String, Field<?, ?>> zzrh() {
            zzx.zzy(this.zzalb);
            zzx.zzy(this.zzalc);
            return this.zzalc.zzcL(this.zzalb);
        }
    }

    public interface zza<I, O> {
        I convertBack(O o);

        int zzqT();

        int zzqU();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        if (field.zzqT() == 11) {
            sb.append(field.zzrd().cast(obj).toString());
        } else {
            if (field.zzqT() != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(zznu.zzcO((String) obj));
            sb.append("\"");
        }
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        Map<String, Field<?, ?>> mapZzqV = zzqV();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapZzqV.keySet()) {
            Field<?, ?> field = mapZzqV.get(str);
            if (zza(field)) {
                Object objZza = zza(field, zzb(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (objZza != null) {
                    switch (field.zzqU()) {
                        case 8:
                            sb.append("\"").append(zzni.zzj((byte[]) objZza)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(zzni.zzk((byte[]) objZza)).append("\"");
                            break;
                        case 10:
                            zznv.zza(sb, (HashMap) objZza);
                            break;
                        default:
                            if (field.zzqZ()) {
                                zza(sb, (Field) field, (ArrayList<Object>) objZza);
                            } else {
                                zza(sb, field, objZza);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <O, I> I zza(Field<I, O> field, Object obj) {
        return ((Field) field).zzald != null ? field.convertBack(obj) : obj;
    }

    protected boolean zza(Field field) {
        if (field.zzqU() == 11) {
            return field.zzra() ? zzcK(field.zzrb()) : zzcJ(field.zzrb());
        }
        return zzcI(field.zzrb());
    }

    protected Object zzb(Field field) {
        String strZzrb = field.zzrb();
        if (field.zzrd() == null) {
            return zzcH(field.zzrb());
        }
        zzx.zza(zzcH(field.zzrb()) == null, "Concrete field shouldn't be value object: %s", field.zzrb());
        HashMap<String, Object> mapZzqX = field.zzra() ? zzqX() : zzqW();
        if (mapZzqX != null) {
            return mapZzqX.get(strZzrb);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(strZzrb.charAt(0)) + strZzrb.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    protected abstract Object zzcH(String str);

    protected abstract boolean zzcI(String str);

    protected boolean zzcJ(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzcK(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map<String, Field<?, ?>> zzqV();

    public HashMap<String, Object> zzqW() {
        return null;
    }

    public HashMap<String, Object> zzqX() {
        return null;
    }
}
