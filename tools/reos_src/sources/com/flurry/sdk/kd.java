package com.flurry.sdk;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class kd implements Comparator<Runnable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4550a = kd.class.getSimpleName();

    private int a(Runnable runnable) {
        if (runnable == null) {
            return Integer.MAX_VALUE;
        }
        if (runnable instanceof ke) {
            lz lzVar = (lz) ((ke) runnable).a();
            return lzVar != null ? lzVar.n() : Integer.MAX_VALUE;
        }
        if (runnable instanceof lz) {
            return ((lz) runnable).n();
        }
        kg.a(6, f4550a, "Unknown runnable class: " + runnable.getClass().getName());
        return Integer.MAX_VALUE;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Runnable runnable, Runnable runnable2) {
        int iA = a(runnable);
        int iA2 = a(runnable2);
        if (iA < iA2) {
            return -1;
        }
        return iA > iA2 ? 1 : 0;
    }
}
