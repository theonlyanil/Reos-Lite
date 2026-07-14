package com.android.library.http.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.d.d;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f2682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2683b = "cube26_network_library";

    /* JADX INFO: renamed from: com.android.library.http.a.a$a, reason: collision with other inner class name */
    public enum EnumC0048a {
        NORMAL,
        BATCH
    }

    public a(Context context) {
        super(context, f2683b, (SQLiteDatabase.CursorFactory) null, 3);
    }

    public static a a(Context context) {
        if (f2682a == null) {
            synchronized (a.class) {
                if (f2682a == null) {
                    f2682a = new a(context);
                }
            }
        }
        return f2682a;
    }

    private String b(EnumC0048a enumC0048a) {
        return enumC0048a == EnumC0048a.BATCH ? "table_network_library" : "table_batch";
    }

    public static boolean b(Context context) {
        return a(context).a("table_batch") >= Integer.parseInt(Config.getInstance(context).get("httpLib.batchCount"));
    }

    public int a(String str) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursorQuery = readableDatabase.query(str, null, null, null, null, null, null);
        int count = cursorQuery.getCount();
        cursorQuery.close();
        readableDatabase.close();
        close();
        return count;
    }

    public HashMap<String, ArrayList<b>> a(EnumC0048a enumC0048a) {
        String strB = b(enumC0048a);
        HashMap map = new HashMap();
        HashMap<String, ArrayList<b>> map2 = new HashMap<>();
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                Cursor cursorQuery = readableDatabase.query(strB, null, null, null, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("ID"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(PlusShare.KEY_CALL_TO_ACTION_URL));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("json"));
                        CLog.b("HTTPLibrary", "DB_ID " + string);
                        CLog.b("HTTPLibrary", "DB_URL " + string2);
                        CLog.b("HTTPLibrary", "DB_JSON " + string3);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(string);
                        JSONObject jSONObjectA = d.a(string3);
                        if (map.containsKey(string2)) {
                            ArrayList arrayList2 = (ArrayList) map.get(string2);
                            arrayList2.add(new b(arrayList, string2, jSONObjectA));
                            map.put(string2, arrayList2);
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(new b(arrayList, string2, jSONObjectA));
                            map.put(string2, arrayList3);
                        }
                    } while (cursorQuery.moveToNext());
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    ArrayList arrayList4 = (ArrayList) entry.getValue();
                    HashMap map3 = new HashMap();
                    for (int i = 0; i < arrayList4.size(); i++) {
                        b bVar = (b) arrayList4.get(i);
                        JSONObject jSONObjectB = bVar.b();
                        String strA = bVar.a();
                        ArrayList<String> arrayListC = bVar.c();
                        try {
                            JSONArray jSONArray = (JSONArray) jSONObjectB.get("values");
                            String str2 = ((String) jSONObjectB.get("category")) + "|" + jSONObjectB.get("subCategory").toString() + "|" + jSONObjectB.get("identifier").toString() + "|" + jSONObjectB.get("version").toString() + "|" + jSONObjectB.get("actionId").toString();
                            if (map3.containsKey(str2)) {
                                b bVar2 = (b) map3.get(str2);
                                ArrayList<String> arrayListC2 = bVar2.c();
                                arrayListC2.add(arrayListC.get(0));
                                bVar2.a(arrayListC2);
                                JSONObject jSONObjectB2 = bVar2.b();
                                JSONArray jSONArray2 = (JSONArray) jSONObjectB2.get("values");
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    jSONArray2.put(jSONArray.get(i2));
                                }
                                jSONObjectB2.put("values", jSONArray2);
                                bVar2.a(jSONObjectB2);
                                map3.put(str2, bVar2);
                            } else {
                                map3.put(str2, new b(arrayListC, strA, jSONObjectB));
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    Iterator it = map3.entrySet().iterator();
                    while (it.hasNext()) {
                        b bVar3 = (b) ((Map.Entry) it.next()).getValue();
                        if (map2.containsKey(str)) {
                            ArrayList<b> arrayList5 = map2.get(str);
                            arrayList5.add(bVar3);
                            map2.put(str, arrayList5);
                        } else {
                            ArrayList<b> arrayList6 = new ArrayList<>();
                            arrayList6.add(bVar3);
                            map2.put(str, arrayList6);
                        }
                    }
                }
                readableDatabase.close();
                close();
                return map2;
            } catch (RuntimeException e3) {
                e3.printStackTrace();
                CLog.d("HTTPLibraryError", e3.getMessage());
                return map2;
            }
        } catch (Throwable th) {
            return map2;
        }
    }

    public void a(String str, EnumC0048a enumC0048a) {
        String strB = b(enumC0048a);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete(strB, "ID = ?", new String[]{str});
        writableDatabase.close();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0063 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r5, java.lang.String r6, com.android.library.http.a.a.EnumC0048a r7) {
        /*
            r4 = this;
            java.lang.String r0 = r4.b(r7)
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L63
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r2.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "insert into "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "("
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "url"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = ","
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "json"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = ") values (?,?)"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60
            android.database.sqlite.SQLiteStatement r0 = r1.compileStatement(r0)     // Catch: java.lang.Throwable -> L60
            r2 = 1
            r0.bindString(r2, r5)     // Catch: java.lang.Throwable -> L60
            r2 = 2
            r0.bindString(r2, r6)     // Catch: java.lang.Throwable -> L60
            r0.executeInsert()     // Catch: java.lang.Throwable -> L60
            r1.close()     // Catch: java.lang.Throwable -> L60
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L5f
            boolean r0 = r1.isOpen()
            if (r0 == 0) goto L5f
            r1.close()
            r4.close()
        L5f:
            return
        L60:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
            throw r0     // Catch: java.lang.Throwable -> L63
        L63:
            r0 = move-exception
            if (r1 == 0) goto L72
            boolean r2 = r1.isOpen()
            if (r2 == 0) goto L72
            r1.close()
            r4.close()
        L72:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.library.http.a.a.a(java.lang.String, java.lang.String, com.android.library.http.a.a$a):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_network_library (ID INTEGER PRIMARY KEY AUTOINCREMENT,url TEXT,json TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_batch (ID INTEGER PRIMARY KEY AUTOINCREMENT,url TEXT,json TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
