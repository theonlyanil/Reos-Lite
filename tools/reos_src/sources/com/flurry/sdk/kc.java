package com.flurry.sdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class kc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static kc f4544a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final jx<String, kq<kb<?>>> f4545b = new jx<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final jx<kq<kb<?>>, String> f4546c = new jx<>();

    private kc() {
    }

    public static synchronized kc a() {
        if (f4544a == null) {
            f4544a = new kc();
        }
        return f4544a;
    }

    public static synchronized void b() {
        if (f4544a != null) {
            f4544a.c();
            f4544a = null;
        }
    }

    public void a(final ka kaVar) {
        if (kaVar == null) {
            return;
        }
        for (final kb<?> kbVar : c(kaVar.a())) {
            js.a().b(new ly() { // from class: com.flurry.sdk.kc.1
                @Override // com.flurry.sdk.ly
                public void a() {
                    kbVar.a(kaVar);
                }
            });
        }
    }

    public synchronized void a(kb<?> kbVar) {
        if (kbVar != null) {
            kq<kb<?>> kqVar = new kq<>(kbVar);
            Iterator<String> it = this.f4546c.a(kqVar).iterator();
            while (it.hasNext()) {
                this.f4545b.b(it.next(), kqVar);
            }
            this.f4546c.b(kqVar);
        }
    }

    public synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<kq<kb<?>>> it = this.f4545b.a(str).iterator();
            while (it.hasNext()) {
                this.f4546c.b(it.next(), str);
            }
            this.f4545b.b(str);
        }
    }

    public synchronized void a(String str, kb<?> kbVar) {
        if (!TextUtils.isEmpty(str) && kbVar != null) {
            kq<kb<?>> kqVar = new kq<>(kbVar);
            if (!this.f4545b.c(str, kqVar)) {
                this.f4545b.a(str, kqVar);
                this.f4546c.a(kqVar, str);
            }
        }
    }

    public synchronized int b(String str) {
        return TextUtils.isEmpty(str) ? 0 : this.f4545b.a(str).size();
    }

    public synchronized void b(String str, kb<?> kbVar) {
        if (!TextUtils.isEmpty(str)) {
            kq<kb<?>> kqVar = new kq<>(kbVar);
            this.f4545b.b(str, kqVar);
            this.f4546c.b(kqVar, str);
        }
    }

    public synchronized List<kb<?>> c(String str) {
        List<kb<?>> listEmptyList;
        if (TextUtils.isEmpty(str)) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<kq<kb<?>>> it = this.f4545b.a(str).iterator();
            while (it.hasNext()) {
                kb kbVar = (kb) it.next().get();
                if (kbVar == null) {
                    it.remove();
                } else {
                    arrayList.add(kbVar);
                }
            }
            listEmptyList = arrayList;
        }
        return listEmptyList;
    }

    public synchronized void c() {
        this.f4545b.a();
        this.f4546c.a();
    }
}
