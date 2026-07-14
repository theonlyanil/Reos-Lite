package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class ly implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4737a = ly.class.getSimpleName();
    PrintStream h;
    PrintWriter i;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            if (this.h != null) {
                th.printStackTrace(this.h);
            } else if (this.i != null) {
                th.printStackTrace(this.i);
            } else {
                th.printStackTrace();
            }
            kg.a(6, f4737a, "", th);
        }
    }
}
