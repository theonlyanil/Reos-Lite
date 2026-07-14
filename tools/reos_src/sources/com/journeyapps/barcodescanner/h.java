package com.journeyapps.barcodescanner;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Collection<com.google.b.a> f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<com.google.b.e, ?> f5906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5907c;

    public h() {
    }

    public h(Collection<com.google.b.a> collection, Map<com.google.b.e, ?> map, String str) {
        this.f5905a = collection;
        this.f5906b = map;
        this.f5907c = str;
    }

    @Override // com.journeyapps.barcodescanner.e
    public d a(Map<com.google.b.e, ?> map) {
        EnumMap enumMap = new EnumMap(com.google.b.e.class);
        enumMap.putAll(map);
        if (this.f5906b != null) {
            enumMap.putAll(this.f5906b);
        }
        if (this.f5905a != null) {
            enumMap.put(com.google.b.e.POSSIBLE_FORMATS, this.f5905a);
        }
        if (this.f5907c != null) {
            enumMap.put(com.google.b.e.CHARACTER_SET, this.f5907c);
        }
        com.google.b.h hVar = new com.google.b.h();
        hVar.a(enumMap);
        return new d(hVar);
    }
}
