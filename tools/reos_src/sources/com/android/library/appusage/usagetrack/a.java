package com.android.library.appusage.usagetrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.apps.config.util.CLog;
import com.android.library.appusage.a.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "FeedReader.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public ArrayList<b> a(Context context) {
        CLog.b(com.android.library.appusage.b.a.f2572b, "Trying to fetch list of tracked apps");
        ArrayList<b> arrayList = new ArrayList<>();
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("select * from apps", null);
        cursorRawQuery.getCount();
        cursorRawQuery.moveToFirst();
        while (!cursorRawQuery.isAfterLast()) {
            b bVar = new b();
            bVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("app_name")));
            bVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("app_count")));
            arrayList.add(bVar);
            cursorRawQuery.moveToNext();
        }
        CLog.b(com.android.library.appusage.b.a.f2572b, "Tracked apps list retrieved of size: " + arrayList.size());
        return arrayList;
    }

    public void a(Context context, String str) {
        int i;
        CLog.b(com.android.library.appusage.b.a.f2572b, "Adding db : " + str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursorQuery = writableDatabase.query("apps", new String[]{"app_count"}, "app_name='" + str + "'", null, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToLast()) {
            i = -1;
        } else {
            if (cursorQuery.getCount() > 0) {
                CLog.b(com.android.library.appusage.b.a.f2572b, "Package alreday existed");
                i = cursorQuery.getInt(cursorQuery.getColumnIndex("app_count"));
            } else {
                i = -1;
            }
            cursorQuery.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_name", str);
        if (i != -1) {
            contentValues.put("app_count", Integer.valueOf(i + 1));
            writableDatabase.update("apps", contentValues, "app_name = ?", new String[]{str});
        } else {
            contentValues.put("app_count", (Integer) 1);
            writableDatabase.insert("apps", null, contentValues);
        }
    }

    public void b(Context context) {
        getReadableDatabase().delete("apps", null, null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE apps (_id INTEGER PRIMARY KEY,app_name TEXT,app_count INTEGER )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS apps");
        onCreate(sQLiteDatabase);
    }
}
