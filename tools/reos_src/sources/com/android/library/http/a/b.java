package com.android.library.http.a;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<String> f2687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f2689c;

    public b(ArrayList<String> arrayList, String str, JSONObject jSONObject) {
        this.f2687a = new ArrayList<>();
        this.f2687a = arrayList;
        this.f2688b = str;
        this.f2689c = jSONObject;
    }

    public String a() {
        return this.f2688b;
    }

    public void a(ArrayList<String> arrayList) {
        this.f2687a = arrayList;
    }

    public void a(JSONObject jSONObject) {
        this.f2689c = jSONObject;
    }

    public JSONObject b() {
        return this.f2689c;
    }

    public ArrayList<String> c() {
        return this.f2687a;
    }
}
