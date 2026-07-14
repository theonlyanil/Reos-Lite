package com.cube26.iota.smartlite.b;

import android.content.Context;
import android.util.JsonReader;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, ArrayList<String>> f3249f = new HashMap<>();
    private String g;
    private int i;
    private int j;

    public static ArrayList<h> a(InputStream inputStream, Context context) throws UnsupportedEncodingException {
        ArrayList<h> arrayList = new ArrayList<>();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        try {
            h = 0;
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals(Config.RESPONSE)) {
                    a(jsonReader, arrayList);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            jsonReader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        CLog.b("weather", "object count :" + arrayList.size());
        return arrayList;
    }

    private static void a(JsonReader jsonReader, ArrayList<h> arrayList) {
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonReader.beginObject();
                String strE = null;
                h hVar = new h();
                HashMap<String, ArrayList<String>> map = new HashMap<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "title":
                            String strNextString = jsonReader.nextString();
                            CLog.a("IOTA", "title :" + strNextString);
                            hVar.a(strNextString);
                            break;
                        case "icon":
                            String strNextString2 = jsonReader.nextString();
                            CLog.a("IOTA", "icon :" + strNextString2);
                            hVar.b("http://45.79.143.20" + strNextString2);
                            break;
                        case "unique_name":
                            String strNextString3 = jsonReader.nextString();
                            CLog.a("IOTA", "unique name :" + strNextString3);
                            hVar.d(strNextString3);
                            break;
                        case "recipe_id":
                            int iNextInt = jsonReader.nextInt();
                            CLog.a("IOTA", "api recipe id :" + iNextInt);
                            hVar.d(iNextInt);
                            break;
                        case "description":
                            String strNextString4 = jsonReader.nextString();
                            CLog.a("IOTA", "description :" + strNextString4);
                            strE = e(strNextString4);
                            hVar.c(strNextString4);
                            break;
                        case "required_keys":
                            jsonReader.beginObject();
                            String strNextName = jsonReader.nextName();
                            CLog.a("IOTA", " temp " + strNextName + " place_holder " + strE);
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList2.add(jsonReader.nextString());
                            }
                            jsonReader.endArray();
                            map.put(strNextName, arrayList2);
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                CLog.a("IOTA", "values :" + arrayList2);
                hVar.a(map);
                arrayList.add(hVar);
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String e(String str) {
        int iIndexOf = str.indexOf("<dd>");
        h++;
        int iIndexOf2 = str.indexOf("</dd>");
        CLog.a("IOTA", " start index" + iIndexOf + "  end index " + iIndexOf2);
        String strSubstring = str.substring(iIndexOf + 5, iIndexOf2 - 1);
        CLog.a("IOTA", "place_holder :" + strSubstring);
        return strSubstring;
    }

    public int a() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(String str) {
        this.f3244a = str;
    }

    public void a(HashMap<String, ArrayList<String>> map) {
        this.f3249f = map;
    }

    public int b() {
        return this.i;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.f3245b = str;
    }

    public String c() {
        return this.f3244a;
    }

    public void c(int i) {
        this.f3246c = i;
    }

    public void c(String str) {
        this.f3248e = str;
    }

    public String d() {
        return this.f3245b;
    }

    public void d(int i) {
        this.f3247d = i;
    }

    public void d(String str) {
        this.g = str;
    }

    public int e() {
        return this.f3246c;
    }

    public String f() {
        return this.f3248e;
    }

    public int g() {
        return this.f3247d;
    }

    public HashMap<String, ArrayList<String>> h() {
        return this.f3249f;
    }

    public String i() {
        return this.g;
    }
}
