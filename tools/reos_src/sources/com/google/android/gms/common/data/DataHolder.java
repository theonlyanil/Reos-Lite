package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private static final zza zzahI = new zza(new String[0], null) { // from class: com.google.android.gms.common.data.DataHolder.1
    };
    boolean mClosed;
    private final int mVersionCode;
    private final int zzabx;
    private final String[] zzahA;
    Bundle zzahB;
    private final CursorWindow[] zzahC;
    private final Bundle zzahD;
    int[] zzahE;
    int zzahF;
    private Object zzahG;
    private boolean zzahH;

    public static class zza {
        private final String[] zzahA;
        private final ArrayList<HashMap<String, Object>> zzahJ;
        private final String zzahK;
        private final HashMap<Object, Integer> zzahL;
        private boolean zzahM;
        private String zzahN;

        private zza(String[] strArr, String str) {
            this.zzahA = (String[]) zzx.zzy(strArr);
            this.zzahJ = new ArrayList<>();
            this.zzahK = str;
            this.zzahL = new HashMap<>();
            this.zzahM = false;
            this.zzahN = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzahH = true;
        this.mVersionCode = i;
        this.zzahA = strArr;
        this.zzahC = cursorWindowArr;
        this.zzabx = i2;
        this.zzahD = bundle;
    }

    private DataHolder(zza zzaVar, int i, Bundle bundle) {
        this(zzaVar.zzahA, zza(zzaVar, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzahH = true;
        this.mVersionCode = 1;
        this.zzahA = (String[]) zzx.zzy(strArr);
        this.zzahC = (CursorWindow[]) zzx.zzy(cursorWindowArr);
        this.zzabx = i;
        this.zzahD = bundle;
        zzpL();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzahI, i, bundle);
    }

    private static CursorWindow[] zza(zza zzaVar, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zzaVar.zzahA.length == 0) {
            return new CursorWindow[0];
        }
        List listSubList = (i < 0 || i >= zzaVar.zzahJ.size()) ? zzaVar.zzahJ : zzaVar.zzahJ.subList(0, i);
        int size = listSubList.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(zzaVar.zzahA.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zzaVar.zzahA.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) listSubList.get(i3);
                boolean zPutDouble = true;
                for (int i4 = 0; i4 < zzaVar.zzahA.length && zPutDouble; i4++) {
                    String str = zzaVar.zzahA[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        zPutDouble = cursorWindow2.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        zPutDouble = cursorWindow2.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        zPutDouble = cursorWindow2.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        zPutDouble = cursorWindow2.putLong(((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        zPutDouble = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i3, i4);
                    } else if (obj instanceof byte[]) {
                        zPutDouble = cursorWindow2.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        zPutDouble = cursorWindow2.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else {
                        if (!(obj instanceof Float)) {
                            throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                        }
                        zPutDouble = cursorWindow2.putDouble(((Float) obj).floatValue(), i3, i4);
                    }
                }
                if (zPutDouble) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else {
                    if (z2) {
                        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zzaVar.zzahA.length);
                    arrayList.add(cursorWindow3);
                    i2 = i3 - 1;
                    cursorWindow = cursorWindow3;
                    z = true;
                }
                z2 = z;
                cursorWindow2 = cursorWindow;
                i3 = i2 + 1;
            } catch (RuntimeException e2) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw e2;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zzbJ(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzg(String str, int i) {
        if (this.zzahB == null || !this.zzahB.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.zzahF) {
            throw new CursorIndexOutOfBoundsException(i, this.zzahF);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (int i = 0; i < this.zzahC.length; i++) {
                    this.zzahC[i].close();
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.zzahH && this.zzahC.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.zzahG == null ? "internal object: " + toString() : this.zzahG.toString()) + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzahF;
    }

    public int getStatusCode() {
        return this.zzabx;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzg(str, i);
        this.zzahC[i2].copyStringToBuffer(i, this.zzahB.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getLong(i, this.zzahB.getInt(str));
    }

    public int zzbI(int i) {
        int i2 = 0;
        zzx.zzaa(i >= 0 && i < this.zzahF);
        while (i2 < this.zzahE.length) {
            if (i < this.zzahE[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzahE.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getInt(i, this.zzahB.getInt(str));
    }

    public boolean zzct(String str) {
        return this.zzahB.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getString(i, this.zzahB.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzg(str, i);
        return Long.valueOf(this.zzahC[i2].getLong(i, this.zzahB.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getFloat(i, this.zzahB.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getBlob(i, this.zzahB.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String strZzd = zzd(str, i, i2);
        if (strZzd == null) {
            return null;
        }
        return Uri.parse(strZzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].isNull(i, this.zzahB.getInt(str));
    }

    public Bundle zzpH() {
        return this.zzahD;
    }

    public void zzpL() {
        this.zzahB = new Bundle();
        for (int i = 0; i < this.zzahA.length; i++) {
            this.zzahB.putInt(this.zzahA[i], i);
        }
        this.zzahE = new int[this.zzahC.length];
        int numRows = 0;
        for (int i2 = 0; i2 < this.zzahC.length; i2++) {
            this.zzahE[i2] = numRows;
            numRows += this.zzahC[i2].getNumRows() - (numRows - this.zzahC[i2].getStartPosition());
        }
        this.zzahF = numRows;
    }

    String[] zzpM() {
        return this.zzahA;
    }

    CursorWindow[] zzpN() {
        return this.zzahC;
    }

    public void zzt(Object obj) {
        this.zzahG = obj;
    }
}
