package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class an {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f583c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f581a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f584d = new Object();

    public static class a implements ae, af {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Notification.Builder f585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<Bundle> f587c = new ArrayList();

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            this.f585a = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f586b = new Bundle();
            if (bundle != null) {
                this.f586b.putAll(bundle);
            }
            if (z3) {
                this.f586b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f586b.putString("android.support.groupKey", str);
                if (z4) {
                    this.f586b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f586b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f586b.putString("android.support.sortKey", str2);
            }
        }

        @Override // android.support.v4.app.af
        public Notification.Builder a() {
            return this.f585a;
        }

        @Override // android.support.v4.app.ae
        public void a(aj.a aVar) {
            this.f587c.add(an.a(this.f585a, aVar));
        }

        @Override // android.support.v4.app.af
        public Notification b() {
            Notification notificationBuild = this.f585a.build();
            Bundle bundleA = an.a(notificationBuild);
            Bundle bundle = new Bundle(this.f586b);
            for (String str : this.f586b.keySet()) {
                if (bundleA.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            bundleA.putAll(bundle);
            SparseArray<Bundle> sparseArrayA = an.a(this.f587c);
            if (sparseArrayA != null) {
                an.a(notificationBuild).putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            return notificationBuild;
        }
    }

    public static Bundle a(Notification.Builder builder, aj.a aVar) {
        builder.addAction(aVar.a(), aVar.b(), aVar.c());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", au.a(aVar.f()));
        }
        return bundle;
    }

    public static Bundle a(Notification notification) {
        synchronized (f581a) {
            if (f583c) {
                return null;
            }
            try {
                if (f582b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f583c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f582b = declaredField;
                }
                Bundle bundle = (Bundle) f582b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f582b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f583c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f583c = true;
                return null;
            }
        }
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static void a(af afVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        Notification.BigPictureStyle bigPictureStyleBigPicture = new Notification.BigPictureStyle(afVar.a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPictureStyleBigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPictureStyleBigPicture.setSummaryText(charSequence2);
        }
    }

    public static void a(af afVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(afVar.a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigTextStyleBigText.setSummaryText(charSequence2);
        }
    }

    public static void a(af afVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(afVar.a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }
}
