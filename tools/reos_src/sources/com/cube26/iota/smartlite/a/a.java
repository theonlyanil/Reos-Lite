package com.cube26.iota.smartlite.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.widget.Toast;
import com.android.apps.config.util.CLog;
import com.android.library.userprofile.util.Constants;
import com.cube26.iota.smartlite.b.d;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f3222b;

    public a(Context context) {
        super(context, "IotaSmartLite", (SQLiteDatabase.CursorFactory) null, 20);
        this.f3222b = context;
    }

    private boolean a(int i, String str, String str2, int i2) {
        if (!b(str, str2, i2)) {
            return false;
        }
        int iC = c(str, str2, i2);
        CLog.a("IOTA", " checkUpdateAlert row_id " + iC + " && _id " + i);
        return iC != i;
    }

    private boolean b(String str, String str2, int i) {
        String str3;
        String[] strArr;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (i < 3 || i == 5 || i == 6) {
            str3 = "alert_contact_name = ? and recipe_id = ? ";
            strArr = new String[]{str2, String.valueOf(i)};
        } else if (i == 9) {
            str3 = "alert_type = ? and recipe_id = ? and alert_contact_name = ? ";
            strArr = new String[]{str, String.valueOf(i), str2};
        } else {
            str3 = "alert_type = ? and recipe_id = ? ";
            strArr = new String[]{str, String.valueOf(i)};
        }
        Cursor cursorQuery = readableDatabase.query("Alerts", null, str3, strArr, null, null, null);
        CLog.a("IOTA", "check count " + cursorQuery.getCount());
        if (cursorQuery.getCount() > 0) {
            CLog.a("IOTA", "alert already exists");
            cursorQuery.close();
            return true;
        }
        CLog.a("IOTA", "new alert");
        cursorQuery.close();
        return false;
    }

    private int c(String str, String str2, int i) {
        String str3;
        String[] strArr;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (i < 3 || i == 5 || i == 6) {
            str3 = "alert_contact_name = ? and recipe_id = ? ";
            strArr = new String[]{str2, String.valueOf(i)};
        } else if (i == 9) {
            str3 = "alert_type = ? and recipe_id = ? and alert_contact_name = ? ";
            strArr = new String[]{str, String.valueOf(i), str2};
        } else {
            str3 = "alert_type = ? and recipe_id = ? ";
            strArr = new String[]{str, String.valueOf(i)};
        }
        Cursor cursorQuery = readableDatabase.query("Alerts", null, str3, strArr, null, null, null);
        cursorQuery.moveToFirst();
        CLog.a("IOTA", "check count " + cursorQuery.getCount());
        if (cursorQuery.getCount() > 0) {
            CLog.a("IOTA", "alert already exists");
            return cursorQuery.getInt(cursorQuery.getColumnIndex(Constants.SMS_COLUMN_ID));
        }
        CLog.a("IOTA", "new alert");
        return -1;
    }

    public Cursor a(String str, int i) {
        return getReadableDatabase().query("Alerts", null, "alert_contact_name = ? and recipe_id = ? ", new String[]{str, String.valueOf(i)}, null, null, null);
    }

    public Cursor a(String str, String str2, int i) {
        return getReadableDatabase().query("Alerts", null, "alert_type = ? and alert_contact_name = ? and recipe_id = ? ", new String[]{str, str2, String.valueOf(i)}, null, null, null);
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return getReadableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    public com.cube26.iota.smartlite.b.a a(int i) {
        Cursor cursorQuery = getReadableDatabase().query("saved_lite_groups", null, "_id = ? ", new String[]{String.valueOf(i)}, null, null, null);
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("saved_lite_group_name"));
        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("saved_lites"));
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = string2.split(";");
        for (String str : strArrSplit) {
            com.cube26.iota.smartlite.d.a aVar = new com.cube26.iota.smartlite.d.a();
            aVar.e(str);
            arrayList.add(aVar);
        }
        return new com.cube26.iota.smartlite.b.a(string, i, arrayList);
    }

    public ArrayList<d> a() {
        ArrayList<d> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT  * FROM Mood", null);
        if (cursorRawQuery.moveToFirst()) {
            do {
                d dVar = new d();
                dVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name")));
                dVar.c(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)));
                dVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("icon")));
                dVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("strobe_set_colors")));
                dVar.c(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color1")));
                dVar.d(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color2")));
                dVar.e(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color3")));
                dVar.f(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color4")));
                dVar.g(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color5")));
                dVar.h(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color6")));
                dVar.d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("transition")));
                dVar.i(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("interval")));
                dVar.j(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("speed")));
                dVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id")));
                arrayList.add(dVar);
            } while (cursorRawQuery.moveToNext());
        }
        writableDatabase.close();
        return arrayList;
    }

    public ArrayList<d> a(String str) {
        f3221a = str;
        ArrayList<d> arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT  * FROM Mood where name = '" + str + "'", null);
        if (cursorRawQuery.moveToFirst()) {
            do {
                d dVar = new d();
                dVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name")));
                dVar.c(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)));
                dVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("icon")));
                dVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("strobe_set_colors")));
                dVar.c(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color1")));
                dVar.d(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color2")));
                dVar.e(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color3")));
                dVar.f(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color4")));
                dVar.g(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color5")));
                dVar.h(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("color6")));
                dVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id")));
                dVar.d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("transition")));
                dVar.i(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("interval")));
                dVar.j(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("speed")));
                arrayList.add(dVar);
            } while (cursorRawQuery.moveToNext());
        }
        writableDatabase.close();
        return arrayList;
    }

    public void a(int i, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursorE = e(i);
        cursorE.moveToFirst();
        ContentValues contentValues = new ContentValues();
        contentValues.put("recipe_id", cursorE.getString(cursorE.getColumnIndex("recipe_id")));
        contentValues.put("alert_color", cursorE.getString(cursorE.getColumnIndex("alert_color")));
        contentValues.put("alert_transition", cursorE.getString(cursorE.getColumnIndex("alert_transition")));
        contentValues.put("alert_sentence", cursorE.getString(cursorE.getColumnIndex("alert_sentence")));
        contentValues.put("alert_contact_name", cursorE.getString(cursorE.getColumnIndex("alert_contact_name")));
        contentValues.put("alert_contact_number", cursorE.getString(cursorE.getColumnIndex("alert_contact_number")));
        contentValues.put("alert_status", Integer.valueOf(i2));
        writableDatabase.update("Alerts", contentValues, " _id = ? ", new String[]{String.valueOf(i)});
        CLog.b("IOTA", "status updated");
        Cursor cursorE2 = e(i);
        cursorE2.moveToFirst();
        CLog.b("IOTA", "status update " + cursorE2.getInt(cursorE2.getColumnIndex("alert_status")) + "");
    }

    public void a(int i, String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("saved_lites", str);
        CLog.a("IOTA", " updated group " + writableDatabase.update("saved_lite_groups", contentValues, "_id = ? ", new String[]{String.valueOf(i)}));
    }

    public void a(int i, String str, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("schedule_valid", Integer.valueOf(i2));
        writableDatabase.update("schedule", contentValues, "schedule_rule_id = ? AND schedule_lite_address = ? ", new String[]{String.valueOf(i), str});
        CLog.a("IOTA", "schedule status updated ");
    }

    public void a(int i, String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("saved_lite_group_name", str);
        contentValues.put("saved_lites", str2);
        long jUpdate = writableDatabase.update("saved_lite_groups", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        Cursor cursorQuery = writableDatabase.query("saved_lite_groups", null, "_id = ? ", new String[]{String.valueOf(i)}, null, null, null, null);
        cursorQuery.moveToFirst();
        CLog.a("IOTA", " updated row id :" + String.valueOf(jUpdate) + " name :: " + cursorQuery.getString(cursorQuery.getColumnIndex("saved_lite_group_name")) + " contained lite :: " + cursorQuery.getString(cursorQuery.getColumnIndex("saved_lites")));
    }

    public void a(int i, String str, String str2, String str3, int i2, String str4, int i3, int i4, String str5, int i5) {
        CLog.a("IOTA", " repeat :: " + str4);
        ContentValues contentValues = new ContentValues();
        contentValues.put("schedule_name", str2);
        contentValues.put("schedule_rule_id", Integer.valueOf(i));
        contentValues.put("schedule_lite_address", str);
        contentValues.put("schedule_time", str3);
        contentValues.put("schedule_color", Integer.valueOf(i2));
        contentValues.put("schedule_repeat", str4);
        contentValues.put("schedule_mode", Integer.valueOf(i3));
        contentValues.put("schedule_valid", Integer.valueOf(i4));
        contentValues.put("schedule_notification_type", str5);
        contentValues.put("schedule_notification_mins", Integer.valueOf(i5));
        CLog.a("IOTA", "schedule inserted with id :: " + getWritableDatabase().insert("schedule", null, contentValues));
    }

    public void a(int i, ArrayList<String> arrayList) {
        String str = "";
        Iterator<String> it = arrayList.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                CLog.a("IOTA", "inserted types string : " + str2);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("recipe_id", Integer.valueOf(i));
                contentValues.put("alert_types", str2);
                writableDatabase.insert("ALERTTYPES", null, contentValues);
                return;
            }
            str = str2 + "," + it.next();
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        CLog.a("IOTA", " init sticky view ");
        d dVar = new d();
        dVar.b("Kaleidoscope");
        dVar.c("Soothing colors");
        dVar.b(5);
        dVar.a(4);
        dVar.d("kldscp");
        dVar.i(60);
        dVar.j(10);
        dVar.a("");
        a(dVar, sQLiteDatabase);
        d dVar2 = new d();
        dVar2.b("Strobe");
        dVar2.c("Strobing Color");
        dVar2.b(0);
        dVar2.a(5);
        dVar2.d("strobe");
        dVar2.i(60);
        dVar2.j(10);
        dVar2.a("");
        a(dVar2, sQLiteDatabase);
        d dVar3 = new d();
        dVar3.b("Candle");
        dVar3.c("Romantic candle flicking color");
        dVar3.b(19);
        dVar3.a(6);
        dVar3.d("candle");
        dVar3.i(60);
        dVar3.j(10);
        dVar3.a("");
        a(dVar3, sQLiteDatabase);
        d dVar4 = new d();
        dVar4.b("Christmas Mode");
        dVar4.c("Jingle bells");
        dVar4.b(24);
        dVar4.c(-65536);
        dVar4.d(-1);
        dVar4.e(-16711936);
        dVar4.a(7);
        dVar4.d("color");
        dVar4.i(60);
        dVar4.j(10);
        dVar4.a("");
        a(dVar4, sQLiteDatabase);
        d dVar5 = new d();
        dVar5.b("Reading Mode");
        dVar5.c("Bright yellow lights. Perfect for reading a book.");
        dVar5.b(21);
        dVar5.c(-1);
        dVar5.d("color");
        dVar5.i(60);
        dVar5.j(10);
        dVar5.a(1);
        dVar5.a("");
        a(dVar5, sQLiteDatabase);
        d dVar6 = new d();
        dVar6.b("Party Mode");
        dVar6.c("Self changing color. Sure to groove with you.");
        dVar6.b(13);
        dVar6.c(Color.parseColor("#9400D3"));
        dVar6.d(Color.parseColor("#4B0082"));
        dVar6.e(-16776961);
        dVar6.f(-16711936);
        dVar6.g(-256);
        dVar6.h(Color.parseColor("#FF7F00"));
        dVar6.a(2);
        dVar6.d("color");
        dVar6.i(60);
        dVar6.j(10);
        dVar6.a("");
        a(dVar6, sQLiteDatabase);
        d dVar7 = new d();
        dVar7.b("Movie Mode");
        dVar7.c("Dim lights. Make your room like a movie theatre.");
        dVar7.b(12);
        dVar7.c(-1);
        dVar7.a(3);
        dVar7.d("color");
        dVar7.i(10);
        dVar7.j(10);
        dVar7.a("");
        a(dVar7, sQLiteDatabase);
    }

    public void a(d dVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", dVar.c());
        contentValues.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dVar.d());
        contentValues.put("strobe_set_colors", dVar.a());
        contentValues.put("color1", Integer.valueOf(dVar.f()));
        contentValues.put("color2", Integer.valueOf(dVar.g()));
        contentValues.put("color3", Integer.valueOf(dVar.h()));
        contentValues.put("color4", Integer.valueOf(dVar.i()));
        contentValues.put("color5", Integer.valueOf(dVar.j()));
        contentValues.put("color6", Integer.valueOf(dVar.k()));
        contentValues.put("speed", Integer.valueOf(dVar.n()));
        contentValues.put("interval", Integer.valueOf(dVar.m()));
        contentValues.put("icon", Integer.valueOf(dVar.e()));
        contentValues.put("transition", dVar.l());
        contentValues.put("id", Integer.valueOf(dVar.b()));
        writableDatabase.insert("Mood", null, contentValues);
        writableDatabase.close();
    }

    public void a(d dVar, SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase.isOpen()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", dVar.c());
            contentValues.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dVar.d());
            contentValues.put("strobe_set_colors", dVar.a());
            contentValues.put("color1", Integer.valueOf(dVar.f()));
            contentValues.put("color2", Integer.valueOf(dVar.g()));
            contentValues.put("color3", Integer.valueOf(dVar.h()));
            contentValues.put("color4", Integer.valueOf(dVar.i()));
            contentValues.put("color5", Integer.valueOf(dVar.j()));
            contentValues.put("color6", Integer.valueOf(dVar.k()));
            contentValues.put("speed", Integer.valueOf(dVar.n()));
            contentValues.put("interval", Integer.valueOf(dVar.m()));
            contentValues.put("icon", Integer.valueOf(dVar.e()));
            contentValues.put("transition", dVar.l());
            contentValues.put("id", Integer.valueOf(dVar.b()));
            sQLiteDatabase.insert("Mood", null, contentValues);
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("name", dVar.c());
        contentValues2.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dVar.d());
        contentValues2.put("strobe_set_colors", dVar.a());
        contentValues2.put("color1", Integer.valueOf(dVar.f()));
        contentValues2.put("color2", Integer.valueOf(dVar.g()));
        contentValues2.put("color3", Integer.valueOf(dVar.h()));
        contentValues2.put("color4", Integer.valueOf(dVar.i()));
        contentValues2.put("color5", Integer.valueOf(dVar.j()));
        contentValues2.put("color6", Integer.valueOf(dVar.k()));
        contentValues2.put("speed", Integer.valueOf(dVar.n()));
        contentValues2.put("interval", Integer.valueOf(dVar.m()));
        contentValues2.put("icon", Integer.valueOf(dVar.e()));
        contentValues2.put("transition", dVar.l());
        contentValues2.put("id", Integer.valueOf(dVar.b()));
        writableDatabase.insert("Mood", null, contentValues2);
    }

    public void a(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("lite_name", str);
        writableDatabase.update("saved_lite", contentValues, "lite_address = ? ", new String[]{str2});
    }

    public void a(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("lite_address", str);
        contentValues.put("lite_name", str2);
        CLog.a("IOTA", " row id :: " + getWritableDatabase().insert("saved_lite", null, contentValues));
    }

    public boolean a(int i, int i2, String str, Integer num, String str2, String str3, String str4, String str5, String str6, int i3, String str7, int i4, byte[] bArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        CLog.a("IOTA", " recipe_id " + i2 + " alert_type  " + str + "alert_contact_name " + str4);
        if (a(i, str, str4, i2)) {
            String str8 = str != null ? str : null;
            if (str4 == null) {
                str4 = str8;
            }
            if (str4.equals("null")) {
                Toast.makeText(this.f3222b, "Similar alert already present. ", 0).show();
            } else {
                Toast.makeText(this.f3222b, "Alert for " + str4 + " Already Exists ", 0).show();
            }
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("recipe_id", Integer.valueOf(i2));
        contentValues.put("alert_type", str);
        contentValues.put("alert_color", num);
        contentValues.put("alert_transition", str2);
        contentValues.put("alert_sentence", str3);
        contentValues.put("alert_contact_name", str4);
        contentValues.put("alert_contact_number", str5);
        contentValues.put("alert_status", Integer.valueOf(i4));
        contentValues.put("recipe_api_id", Integer.valueOf(i3));
        contentValues.put("recipe_unique_name", str6);
        contentValues.put("alert_description", str7);
        contentValues.put("alert_contact_blob", bArr);
        CLog.a("weather", " updated row id :" + String.valueOf(writableDatabase.update("Alerts", contentValues, " _id = ?", new String[]{String.valueOf(i)})));
        return true;
    }

    public boolean a(int i, String str, Integer num, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8, String str9, byte[] bArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        CLog.a("IOTA", " recipe_id " + i + " alert_type  " + str + "alert_contact_name " + str4);
        if (b(str, str4, i)) {
            String str10 = str != null ? str : null;
            if (str4 == null) {
                str4 = str10;
            }
            Toast.makeText(this.f3222b, "Alert for " + str4 + " already exists", 0).show();
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("recipe_id", Integer.valueOf(i));
        contentValues.put("alert_type", str);
        contentValues.put("alert_color", num);
        contentValues.put("alert_transition", str2);
        contentValues.put("alert_sentence", str3);
        contentValues.put("alert_contact_name", str4);
        contentValues.put("alert_contact_number", str5);
        contentValues.put("alert_status", (Integer) 0);
        contentValues.put("recipe_api_id", Integer.valueOf(i2));
        contentValues.put("recipe_unique_name", str6);
        contentValues.put("alert_description", str7);
        contentValues.put("lat_value", str8);
        contentValues.put("long_value", str9);
        contentValues.put("alert_contact_blob", bArr);
        CLog.a("weather", " inserted row id :" + String.valueOf(writableDatabase.insert("Alerts", null, contentValues)));
        return true;
    }

    public String b(String str) {
        Cursor cursorQuery = getReadableDatabase().query("saved_lite", null, "lite_address = ? ", new String[]{str}, null, null, null);
        cursorQuery.moveToFirst();
        return cursorQuery.getString(cursorQuery.getColumnIndex("lite_name"));
    }

    public ArrayList<com.cube26.iota.smartlite.d.a> b() {
        ArrayList<com.cube26.iota.smartlite.d.a> arrayList = new ArrayList<>();
        Cursor cursorQuery = getReadableDatabase().query("saved_lite", null, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            com.cube26.iota.smartlite.d.a aVar = new com.cube26.iota.smartlite.d.a();
            aVar.d(cursorQuery.getString(cursorQuery.getColumnIndex("lite_name")));
            aVar.e(cursorQuery.getString(cursorQuery.getColumnIndex("lite_address")));
            aVar.c(true);
            arrayList.add(aVar);
            cursorQuery.moveToNext();
        }
        return arrayList;
    }

    public void b(int i) {
        CLog.a("IOTA", " delete row id :: " + getWritableDatabase().delete("saved_lite_groups", "_id = ? ", new String[]{String.valueOf(i)}));
    }

    public void b(int i, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("UPDATE Alerts SET user_recipe_id = " + i2 + " WHERE _id = " + String.valueOf(i) + " ;");
        Cursor cursorQuery = writableDatabase.query("Alerts", null, " _id = ? ", new String[]{String.valueOf(i)}, null, null, null);
        cursorQuery.moveToFirst();
        CLog.a("IOTA", "added user recipe id " + i2 + " t is " + cursorQuery.getInt(cursorQuery.getColumnIndex("user_recipe_id")));
    }

    public void b(int i, String str, String str2, String str3, int i2, String str4, int i3, int i4, String str5, int i5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("schedule_name", str2);
        contentValues.put("schedule_time", str3);
        contentValues.put("schedule_color", Integer.valueOf(i2));
        contentValues.put("schedule_repeat", str4);
        contentValues.put("schedule_mode", Integer.valueOf(i3));
        contentValues.put("schedule_valid", Integer.valueOf(i4));
        contentValues.put("schedule_notification_type", str5);
        contentValues.put("schedule_notification_mins", Integer.valueOf(i5));
        getWritableDatabase().update("schedule", contentValues, "schedule_rule_id = ? AND schedule_lite_address = ? ", new String[]{String.valueOf(i), str});
        CLog.a("IOTA", " updated ");
    }

    public void b(d dVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", dVar.c());
        contentValues.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dVar.d());
        contentValues.put("strobe_set_colors", dVar.a());
        contentValues.put("color1", Integer.valueOf(dVar.f()));
        contentValues.put("color2", Integer.valueOf(dVar.g()));
        contentValues.put("color3", Integer.valueOf(dVar.h()));
        contentValues.put("color4", Integer.valueOf(dVar.i()));
        contentValues.put("color5", Integer.valueOf(dVar.j()));
        contentValues.put("color6", Integer.valueOf(dVar.k()));
        contentValues.put("speed", Integer.valueOf(dVar.n()));
        contentValues.put("interval", Integer.valueOf(dVar.m()));
        contentValues.put("icon", Integer.valueOf(dVar.e()));
        contentValues.put("transition", dVar.l());
        contentValues.put("id", Integer.valueOf(dVar.b()));
        writableDatabase.update("Mood", contentValues, "name = '" + f3221a + "'", null);
        writableDatabase.close();
    }

    public void b(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("saved_lite_group_name", str);
        contentValues.put("saved_lites", str2);
        CLog.a("IOTA", " row id :: " + getWritableDatabase().insert("saved_lite_groups", null, contentValues));
    }

    public boolean b(int i, String str) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        CLog.a("IOTA", "similar schedule :: " + readableDatabase.query("schedule", null, "schedule_rule_id = ?  AND schedule_lite_address = ? ", new String[]{String.valueOf(i), str}, null, null, null).getCount());
        return readableDatabase.query("schedule", null, "schedule_rule_id = ?  AND schedule_lite_address = ? ", new String[]{String.valueOf(i), str}, null, null, null).getCount() > 0;
    }

    public Cursor c(int i, String str) {
        return getReadableDatabase().query("schedule", null, "schedule_rule_id = ? AND schedule_lite_address = ? ", new String[]{String.valueOf(i), str}, null, null, null);
    }

    public ArrayList<com.cube26.iota.smartlite.b.a> c() {
        ArrayList<com.cube26.iota.smartlite.b.a> arrayList = new ArrayList<>();
        Cursor cursorQuery = getReadableDatabase().query("saved_lite_groups", null, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            String[] strArrSplit = cursorQuery.getString(cursorQuery.getColumnIndex("saved_lites")).split(";");
            ArrayList arrayList2 = new ArrayList();
            for (String str : strArrSplit) {
                com.cube26.iota.smartlite.d.a aVar = new com.cube26.iota.smartlite.d.a();
                aVar.e(str);
                arrayList2.add(aVar);
            }
            arrayList.add(new com.cube26.iota.smartlite.b.a(cursorQuery.getString(cursorQuery.getColumnIndex("saved_lite_group_name")), cursorQuery.getInt(cursorQuery.getColumnIndex(Constants.SMS_COLUMN_ID)), arrayList2));
            cursorQuery.moveToNext();
        }
        return arrayList;
    }

    public void c(int i) {
        getWritableDatabase().delete("schedule", "_id = ? ", new String[]{String.valueOf(i)});
    }

    public void c(String str) {
        getWritableDatabase().delete("saved_lite", "lite_address = ? ", new String[]{str});
    }

    public int d(String str) {
        return getReadableDatabase().query("schedule", null, "schedule_lite_address = ? ", new String[]{str}, null, null, null).getCount();
    }

    public Cursor d(int i) {
        return getReadableDatabase().query("Alerts", null, "recipe_id = ?", new String[]{String.valueOf(i)}, null, null, null);
    }

    public ArrayList<String> d() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursorQuery = readableDatabase.query("saved_lite", new String[]{"lite_address"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            CLog.a("IOTA", " saved lite address :: " + cursorQuery.getString(cursorQuery.getColumnIndex("lite_address")));
            arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("lite_address")));
            cursorQuery.moveToNext();
        }
        cursorQuery.close();
        return arrayList;
    }

    public Cursor e() {
        return getReadableDatabase().query("schedule", null, null, null, null, null, null);
    }

    public Cursor e(int i) {
        return getReadableDatabase().query("Alerts", null, " _id = ?", new String[]{String.valueOf(i)}, null, null, null);
    }

    public void e(String str) {
        getWritableDatabase().delete("schedule", "schedule_lite_address = ? ", new String[]{str});
    }

    public int f() {
        return getReadableDatabase().query("schedule", null, null, null, null, null, null).getCount();
    }

    public ArrayList<String> f(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursorQuery = getReadableDatabase().query("ALERTTYPES", null, "recipe_id = ? ", new String[]{String.valueOf(i)}, null, null, null);
        cursorQuery.moveToFirst();
        StringTokenizer stringTokenizer = new StringTokenizer(cursorQuery.getString(cursorQuery.getColumnIndex("alert_types")), ",");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    public void f(String str) {
        CLog.b("IOTA", "alert dropped items affected " + getWritableDatabase().delete("Mood", "name = ? ", new String[]{String.valueOf(str)}));
    }

    public void g(int i) {
        CLog.b("IOTA", "alert dropped items affected " + getWritableDatabase().delete("Alerts", " _id = ? ", new String[]{String.valueOf(i)}));
    }

    public void h(int i) {
        CLog.b("IOTA", "alert dropped items affected " + getWritableDatabase().delete("Alerts", "recipe_id = ? ", new String[]{String.valueOf(i)}));
    }

    public Cursor i(int i) {
        return getReadableDatabase().query("Alerts", null, "user_recipe_id = ? ", new String[]{String.valueOf(i)}, null, null, null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        CLog.a("IOTA", " on create ");
        sQLiteDatabase.execSQL("CREATE TABLE Mood(id INTEGER ,name TEXT PRIMARY KEY,description TEXT,icon INTEGER,color1 INTEGER,color2 INTEGER,color3 INTEGER,color4 INTEGER,color5 INTEGER,color6 INTEGER,interval INTEGER,speed INTEGER,transition TEXT, strobe_set_colors TEXT ) ");
        sQLiteDatabase.execSQL("CREATE TABLE Device(id INTEGER ,Device_Name TEXT,Address TEXT PRIMARY KEY,STATUS INTEGER )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Alerts ( _id INTEGER PRIMARY KEY, recipe_id INTEGER, alert_type TEXT, alert_color INTEGER, alert_transition TEXT, alert_sentence TEXT, alert_contact_name TEXT , alert_contact_number TEXT, alert_status INTEGER, recipe_unique_name TEXT, recipe_api_id INTEGER, user_recipe_id TEXT, alert_description TEXT , lat_value TEXT , long_value TEXT, alert_contact_blob BLOB);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ALERTTYPES ( recipe_id INTEGER, alert_types TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE schedule(_id INTEGER PRIMARY KEY, schedule_rule_id INTEGER, schedule_lite_address TEXT, schedule_name TEXT, schedule_time TEXT, schedule_color INTEGER, schedule_mode INTEGER, schedule_repeat TEXT, schedule_valid INTEGER, schedule_notification_type TEXT, schedule_notification_mins INTEGER ) ");
        sQLiteDatabase.execSQL("CREATE TABLE saved_lite(_id INTEGER ,lite_address TEXT PRIMARY KEY,lite_name TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE saved_lite_groups ( _id INTEGER PRIMARY KEY ,saved_lite_group_name TEXT ,saved_lites TEXT )");
        CLog.a("IOTA", " anyone count::" + sQLiteDatabase.query("Alerts", null, " _id = ?", new String[]{String.valueOf(1)}, null, null, null).getCount());
        if (sQLiteDatabase.query("Alerts", null, " _id = ?", new String[]{String.valueOf(1)}, null, null, null).getCount() == 0) {
            sQLiteDatabase.execSQL("INSERT INTO Alerts VALUES ( 1 , 1 , null ,-65536 , 'Fade in' , 'Anyone' , 'Anyone', null , 1 , 'Call_channel' , -1 , '-1' , 'If','0.0','0.0', null); ");
        }
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        CLog.a("IOTA", "OnUpgrade called");
        sQLiteDatabase.execSQL("ALTER TABLE Alerts ADD COLUMN alert_contact_blob BLOB;");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Device");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Mood");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS schedule");
        onCreate(sQLiteDatabase);
    }
}
