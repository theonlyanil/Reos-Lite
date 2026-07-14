package com.a.a.d;

import com.a.a.d.b.k;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d<T> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<? extends g<T>> f2211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2212b;

    @SafeVarargs
    public d(g<T>... gVarArr) {
        if (gVarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f2211a = Arrays.asList(gVarArr);
    }

    @Override // com.a.a.d.g
    public k<T> a(k<T> kVar, int i, int i2) {
        Iterator<? extends g<T>> it = this.f2211a.iterator();
        k<T> kVar2 = kVar;
        while (it.hasNext()) {
            k<T> kVarA = it.next().a(kVar2, i, i2);
            if (kVar2 != null && !kVar2.equals(kVar) && !kVar2.equals(kVarA)) {
                kVar2.d();
            }
            kVar2 = kVarA;
        }
        return kVar2;
    }

    @Override // com.a.a.d.g
    public String a() {
        if (this.f2212b == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<? extends g<T>> it = this.f2211a.iterator();
            while (it.hasNext()) {
                sb.append(it.next().a());
            }
            this.f2212b = sb.toString();
        }
        return this.f2212b;
    }
}
