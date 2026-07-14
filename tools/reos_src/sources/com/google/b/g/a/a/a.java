package com.google.b.g.a.a;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class a {
    static com.google.b.c.a a(List<b> list) {
        int size = (list.size() * 2) - 1;
        com.google.b.c.a aVar = new com.google.b.c.a((list.get(list.size() + (-1)).b() == null ? size - 1 : size) * 12);
        int iA = list.get(0).b().a();
        int i = 11;
        int i2 = 0;
        while (i >= 0) {
            if (((1 << i) & iA) != 0) {
                aVar.b(i2);
            }
            i--;
            i2++;
        }
        int i3 = i2;
        for (int i4 = 1; i4 < list.size(); i4++) {
            b bVar = list.get(i4);
            int iA2 = bVar.a().a();
            int i5 = 11;
            while (i5 >= 0) {
                if (((1 << i5) & iA2) != 0) {
                    aVar.b(i3);
                }
                i5--;
                i3++;
            }
            if (bVar.b() != null) {
                int iA3 = bVar.b().a();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & iA3) != 0) {
                        aVar.b(i3);
                    }
                    i3++;
                }
            }
        }
        return aVar;
    }
}
