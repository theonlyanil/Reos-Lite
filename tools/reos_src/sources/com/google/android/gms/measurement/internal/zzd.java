package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.v4.h.a;
import android.util.Pair;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzd extends zzw {
    private static final Map<String, String> zzaSu = new a(5);
    private final zza zzaSv;
    private final zzaa zzaSw;

    private class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) throws SQLiteException {
            if (!zza(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                zza(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e2) {
                zzd.this.zzzz().zzBl().zzj("Failed to verify columns on table that was just created", str);
                throw e2;
            }
        }

        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) throws SQLiteException {
            Set<String> setZzb = zzb(sQLiteDatabase, str);
            for (String str3 : str2.split(",")) {
                if (!setZzb.remove(str3)) {
                    throw new SQLiteException("Database " + str + " is missing required column: " + str3);
                }
            }
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!setZzb.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL(entry.getValue());
                    }
                }
            }
            if (!setZzb.isEmpty()) {
                throw new SQLiteException("Database " + str + " table has extra columns");
            }
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0041  */
        private boolean zza(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
            Cursor cursorQuery;
            Cursor cursor = null;
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    try {
                        boolean zMoveToFirst = cursorQuery.moveToFirst();
                        if (cursorQuery == null) {
                            return zMoveToFirst;
                        }
                        cursorQuery.close();
                        return zMoveToFirst;
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzd.this.zzzz().zzBm().zze("Error querying for table", str, e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                return hashSet;
            } finally {
                cursorRawQuery.close();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (!zzd.this.zzaSw.zzv(zzd.this.zzAX().zzAA())) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e2) {
                zzd.this.zzaSw.start();
                zzd.this.zzzz().zzBl().zzez("Opening the database failed, dropping and recreating it");
                zzd.this.getContext().getDatabasePath(zzd.this.zzjz()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zzd.this.zzaSw.clear();
                    return writableDatabase;
                } catch (SQLiteException e3) {
                    zzd.this.zzzz().zzBl().zzj("Failed to open freshly created database", e3);
                    throw e3;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    cursorRawQuery.moveToFirst();
                    cursorRawQuery.close();
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            }
            zza(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            zza(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            zza(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzd.zzaSu);
            zza(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        zzaSu.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        zzaSu.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        zzaSu.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        zzaSu.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        zzaSu.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
    }

    zzd(zzt zztVar) {
        super(zztVar);
        this.zzaSw = new zzaa(zziT());
        this.zzaSv = new zza(getContext(), zzjz());
    }

    private boolean zzBc() {
        return getContext().getDatabasePath(zzjz()).exists();
    }

    static int zza(Cursor cursor, int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        if (window.isNull(position, i)) {
            return 0;
        }
        if (window.isLong(position, i)) {
            return 1;
        }
        if (window.isFloat(position, i)) {
            return 2;
        }
        if (window.isString(position, i)) {
            return 3;
        }
        return window.isBlob(position, i) ? 4 : -1;
    }

    private long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getWritableDatabase().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e2) {
                zzzz().zzBl().zze("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zzjz() {
        if (zzAX().zzka() && !zzAX().zzkb()) {
            zzzz().zzBn().zzez("Using secondary database");
            return zzAX().zzkB();
        }
        return zzAX().zzkA();
    }

    public void beginTransaction() {
        zzje();
        getWritableDatabase().beginTransaction();
    }

    public void endTransaction() {
        zzje();
        getWritableDatabase().endTransaction();
    }

    SQLiteDatabase getWritableDatabase() {
        zziS();
        try {
            return this.zzaSv.getWritableDatabase();
        } catch (SQLiteException e2) {
            zzzz().zzBm().zzj("Error opening database", e2);
            throw e2;
        }
    }

    public void setTransactionSuccessful() {
        zzje();
        getWritableDatabase().setTransactionSuccessful();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    public String zzAY() {
        Cursor cursorRawQuery;
        Throwable th;
        String string = null;
        try {
            try {
                cursorRawQuery = getWritableDatabase().rawQuery("SELECT q.app_id FROM queue q JOIN apps a ON a.app_id=q.app_id WHERE a.measurement_enabled!=0 ORDER BY q.rowid LIMIT 1;", null);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        string = cursorRawQuery.getString(0);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } else if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzzz().zzBl().zzj("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            cursorRawQuery = null;
            th = th3;
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        return string;
    }

    void zzAZ() {
        zziS();
        zzje();
        if (zzBc()) {
            long j = zzAW().zzaTI.get();
            long jElapsedRealtime = zziT().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - j) > zzAX().zzAG()) {
                zzAW().zzaTI.set(jElapsedRealtime);
                zzBa();
            }
        }
    }

    void zzBa() {
        int iDelete;
        zziS();
        zzje();
        if (zzBc() && (iDelete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zziT().currentTimeMillis()), String.valueOf(zzAX().zzAF())})) > 0) {
            zzzz().zzBr().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
        }
    }

    public long zzBb() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x008c  */
    public zzh zzL(String str, String str2) throws Throwable {
        Cursor cursor;
        Cursor cursor2 = null;
        com.google.android.gms.common.internal.zzx.zzcG(str);
        com.google.android.gms.common.internal.zzx.zzcG(str2);
        zziS();
        zzje();
        try {
            Cursor cursorQuery = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                zzh zzhVar = new zzh(str, str2, cursorQuery.getLong(0), cursorQuery.getLong(1), cursorQuery.getLong(2));
                if (cursorQuery.moveToNext()) {
                    zzzz().zzBl().zzez("Got multiple records for event aggregates, expected one");
                }
                if (cursorQuery == null) {
                    return zzhVar;
                }
                cursorQuery.close();
                return zzhVar;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursorQuery;
                try {
                    zzzz().zzBl().zzd("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursorQuery;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void zzM(String str, String str2) {
        com.google.android.gms.common.internal.zzx.zzcG(str);
        com.google.android.gms.common.internal.zzx.zzcG(str2);
        zziS();
        zzje();
        try {
            zzzz().zzBr().zzj("Deleted user attribute rows:", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e2) {
            zzzz().zzBl().zzd("Error deleting user attribute", str, str2, e2);
        }
    }

    public void zzP(long j) {
        zziS();
        zzje();
        if (getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzzz().zzBl().zzez("Deleted fewer rows from queue than expected");
        }
    }

    void zza(ContentValues contentValues, String str, Object obj) {
        com.google.android.gms.common.internal.zzx.zzcG(str);
        com.google.android.gms.common.internal.zzx.zzy(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Float)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Float) obj);
        }
    }

    public void zza(zzqq.zzd zzdVar) {
        zziS();
        zzje();
        com.google.android.gms.common.internal.zzx.zzy(zzdVar);
        com.google.android.gms.common.internal.zzx.zzcG(zzdVar.appId);
        com.google.android.gms.common.internal.zzx.zzy(zzdVar.zzaVw);
        zzAZ();
        long jCurrentTimeMillis = zziT().currentTimeMillis();
        if (zzdVar.zzaVw.longValue() < jCurrentTimeMillis - zzAX().zzAF() || zzdVar.zzaVw.longValue() > zzAX().zzAF() + jCurrentTimeMillis) {
            zzzz().zzBm().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(jCurrentTimeMillis), zzdVar.zzaVw);
        }
        try {
            byte[] bArr = new byte[zzdVar.getSerializedSize()];
            zztd zztdVarZzD = zztd.zzD(bArr);
            zzdVar.writeTo(zztdVarZzD);
            zztdVarZzD.zzHy();
            byte[] bArrZzg = zzAU().zzg(bArr);
            zzzz().zzBr().zzj("Saving bundle, size", Integer.valueOf(bArrZzg.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzdVar.appId);
            contentValues.put("bundle_end_timestamp", zzdVar.zzaVw);
            contentValues.put("data", bArrZzg);
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) == -1) {
                    zzzz().zzBl().zzez("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e2) {
                zzzz().zzBl().zzj("Error storing bundle", e2);
            }
        } catch (IOException e3) {
            zzzz().zzBl().zzj("Data loss. Failed to serialize bundle", e3);
        }
    }

    public void zza(com.google.android.gms.measurement.internal.zza zzaVar) {
        com.google.android.gms.common.internal.zzx.zzy(zzaVar);
        zziS();
        zzje();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaVar.zzaRd);
        contentValues.put("app_instance_id", zzaVar.zzaSe);
        contentValues.put("gmp_app_id", zzaVar.zzaSf);
        contentValues.put("resettable_device_id_hash", zzaVar.zzaSg);
        contentValues.put("last_bundle_index", Long.valueOf(zzaVar.zzaSh));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzaVar.zzaSi));
        contentValues.put("app_version", zzaVar.zzRl);
        contentValues.put("app_store", zzaVar.zzaSj);
        contentValues.put("gmp_version", Long.valueOf(zzaVar.zzaSk));
        contentValues.put("dev_cert_hash", Long.valueOf(zzaVar.zzaSl));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzaVar.zzaSm));
        try {
            if (getWritableDatabase().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzzz().zzBl().zzez("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e2) {
            zzzz().zzBl().zzj("Error storing app", e2);
        }
    }

    public void zza(zzac zzacVar) {
        com.google.android.gms.common.internal.zzx.zzy(zzacVar);
        zziS();
        zzje();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzacVar.zzaRd);
        contentValues.put("name", zzacVar.mName);
        contentValues.put("set_timestamp", Long.valueOf(zzacVar.zzaVf));
        zza(contentValues, "value", zzacVar.zzLI);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzzz().zzBl().zzez("Failed to insert/update user attribute (got -1)");
            }
        } catch (SQLiteException e2) {
            zzzz().zzBl().zzj("Error storing user attribute", e2);
        }
    }

    public void zza(zzh zzhVar) {
        com.google.android.gms.common.internal.zzx.zzy(zzhVar);
        zziS();
        zzje();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzhVar.zzaRd);
        contentValues.put("name", zzhVar.mName);
        contentValues.put("lifetime_count", Long.valueOf(zzhVar.zzaSF));
        contentValues.put("current_bundle_count", Long.valueOf(zzhVar.zzaSG));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzhVar.zzaSH));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzzz().zzBl().zzez("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e2) {
            zzzz().zzBl().zzj("Error storing event aggregates", e2);
        }
    }

    Object zzb(Cursor cursor, int i) {
        int iZza = zza(cursor, i);
        switch (iZza) {
            case 0:
                zzzz().zzBl().zzez("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Float.valueOf(cursor.getFloat(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzzz().zzBl().zzez("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzzz().zzBl().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(iZza));
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c7  */
    public List<zzac> zzev(String str) {
        Cursor cursorQuery;
        Cursor cursor;
        com.google.android.gms.common.internal.zzx.zzcG(str);
        zziS();
        zzje();
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = getWritableDatabase().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzAX().zzAz() + 1));
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    long j = cursorQuery.getLong(1);
                    Object objZzb = zzb(cursorQuery, 2);
                    if (objZzb == null) {
                        zzzz().zzBl().zzez("Read invalid user attribute value, ignoring it");
                    } else {
                        arrayList.add(new zzac(str, string, j, objZzb));
                    }
                } while (cursorQuery.moveToNext());
                if (arrayList.size() > zzAX().zzAz()) {
                    zzzz().zzBl().zzez("Loaded too many user attributes");
                    arrayList.remove(zzAX().zzAz());
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursorQuery;
                try {
                    zzzz().zzBl().zze("Error querying user attributes", str, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00fb  */
    public com.google.android.gms.measurement.internal.zza zzew(String str) {
        Cursor cursor;
        com.google.android.gms.measurement.internal.zza zzaVar;
        com.google.android.gms.common.internal.zzx.zzcG(str);
        zziS();
        zzje();
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    zzaVar = new com.google.android.gms.measurement.internal.zza(str, cursorQuery.getString(0), cursorQuery.getString(1), cursorQuery.getString(2), cursorQuery.getLong(3), cursorQuery.getLong(4), cursorQuery.getString(5), cursorQuery.getString(6), cursorQuery.getLong(7), cursorQuery.getLong(8), (cursorQuery.isNull(9) ? 1 : cursorQuery.getInt(9)) != 0);
                    if (cursorQuery.moveToNext()) {
                        zzzz().zzBl().zzez("Got multiple records for app, expected one");
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } else {
                    zzaVar = null;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursorQuery;
                try {
                    zzzz().zzBl().zze("Error querying app", str, e);
                    zzaVar = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursorQuery;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return zzaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzw
    protected void zzir() {
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00da  */
    public List<Pair<zzqq.zzd, Long>> zzn(String str, int i, int i2) {
        Cursor cursorQuery;
        Cursor cursor;
        List<Pair<zzqq.zzd, Long>> listEmptyList;
        int length;
        zziS();
        zzje();
        com.google.android.gms.common.internal.zzx.zzab(i > 0);
        com.google.android.gms.common.internal.zzx.zzab(i2 > 0);
        com.google.android.gms.common.internal.zzx.zzcG(str);
        try {
            cursorQuery = getWritableDatabase().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (cursorQuery.moveToFirst()) {
                    listEmptyList = new ArrayList<>();
                    int i3 = 0;
                    while (true) {
                        long j = cursorQuery.getLong(0);
                        try {
                            byte[] bArrZzq = zzAU().zzq(cursorQuery.getBlob(1));
                            if (!listEmptyList.isEmpty() && bArrZzq.length + i3 > i2) {
                                break;
                            }
                            zztc zztcVarZzC = zztc.zzC(bArrZzq);
                            zzqq.zzd zzdVar = new zzqq.zzd();
                            try {
                                zzdVar.mergeFrom(zztcVarZzC);
                                length = bArrZzq.length + i3;
                                listEmptyList.add(Pair.create(zzdVar, Long.valueOf(j)));
                            } catch (IOException e2) {
                                zzzz().zzBl().zze("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!cursorQuery.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e3) {
                            zzzz().zzBl().zze("Failed to unzip queued bundle", str, e3);
                            length = i3;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } else {
                    listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = cursorQuery;
                try {
                    zzzz().zzBl().zze("Error querying bundles", str, e);
                    listEmptyList = Collections.emptyList();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        return listEmptyList;
    }
}
