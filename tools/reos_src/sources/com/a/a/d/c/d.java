package com.a.a.d.c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f2174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f2175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private URL f2178e;

    public d(String str) {
        this(str, e.f2180b);
    }

    public d(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (eVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.f2176c = str;
        this.f2174a = null;
        this.f2175b = eVar;
    }

    public d(URL url) {
        this(url, e.f2180b);
    }

    public d(URL url, e eVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (eVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.f2174a = url;
        this.f2176c = null;
        this.f2175b = eVar;
    }

    private URL d() throws MalformedURLException {
        if (this.f2178e == null) {
            this.f2178e = new URL(e());
        }
        return this.f2178e;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f2177d)) {
            String string = this.f2176c;
            if (TextUtils.isEmpty(string)) {
                string = this.f2174a.toString();
            }
            this.f2177d = Uri.encode(string, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f2177d;
    }

    public URL a() throws MalformedURLException {
        return d();
    }

    public Map<String, String> b() {
        return this.f2175b.a();
    }

    public String c() {
        return this.f2176c != null ? this.f2176c : this.f2174a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c().equals(dVar.c()) && this.f2175b.equals(dVar.f2175b);
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.f2175b.hashCode();
    }

    public String toString() {
        return c() + '\n' + this.f2175b.toString();
    }
}
