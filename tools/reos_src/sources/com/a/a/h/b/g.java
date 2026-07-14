package com.a.a.h.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes.dex */
public class g extends h<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RemoteViews f2445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Notification f2448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2449e;

    public g(Context context, RemoteViews remoteViews, int i, int i2, int i3, Notification notification, int i4) {
        super(i2, i3);
        if (context == null) {
            throw new NullPointerException("Context must not be null!");
        }
        if (notification == null) {
            throw new NullPointerException("Notification object can not be null!");
        }
        if (remoteViews == null) {
            throw new NullPointerException("RemoteViews object can not be null!");
        }
        this.f2446b = context;
        this.f2449e = i;
        this.f2448d = notification;
        this.f2447c = i4;
        this.f2445a = remoteViews;
    }

    public g(Context context, RemoteViews remoteViews, int i, Notification notification, int i2) {
        this(context, remoteViews, i, Integer.MIN_VALUE, Integer.MIN_VALUE, notification, i2);
    }

    private void b() {
        ((NotificationManager) this.f2446b.getSystemService("notification")).notify(this.f2447c, this.f2448d);
    }

    public void a(Bitmap bitmap, com.a.a.h.a.c<? super Bitmap> cVar) {
        this.f2445a.setImageViewBitmap(this.f2449e, bitmap);
        b();
    }

    @Override // com.a.a.h.b.k
    public /* bridge */ /* synthetic */ void a(Object obj, com.a.a.h.a.c cVar) {
        a((Bitmap) obj, (com.a.a.h.a.c<? super Bitmap>) cVar);
    }
}
