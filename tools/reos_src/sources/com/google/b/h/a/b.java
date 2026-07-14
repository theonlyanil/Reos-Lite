package com.google.b.h.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, Integer> f5669a = new HashMap();

    b() {
    }

    void a(int i) {
        Integer num = this.f5669a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f5669a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    int[] a() {
        int i = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, Integer>> it = this.f5669a.entrySet().iterator();
        while (true) {
            int iIntValue = i;
            if (!it.hasNext()) {
                return com.google.b.h.a.a(arrayList);
            }
            Map.Entry<Integer, Integer> next = it.next();
            if (next.getValue().intValue() > iIntValue) {
                iIntValue = next.getValue().intValue();
                arrayList.clear();
                arrayList.add(next.getKey());
            } else if (next.getValue().intValue() == iIntValue) {
                arrayList.add(next.getKey());
            }
            i = iIntValue;
        }
    }
}
