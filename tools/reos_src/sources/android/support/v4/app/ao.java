package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ao {

    public static class a implements ae, af {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Notification.Builder f588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<Bundle> f590c = new ArrayList();

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            this.f588a = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f589b = new Bundle();
            if (bundle != null) {
                this.f589b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f589b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f589b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f589b.putString("android.support.groupKey", str);
                if (z5) {
                    this.f589b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f589b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f589b.putString("android.support.sortKey", str2);
            }
        }

        @Override // android.support.v4.app.af
        public Notification.Builder a() {
            return this.f588a;
        }

        @Override // android.support.v4.app.ae
        public void a(aj.a aVar) {
            this.f590c.add(an.a(this.f588a, aVar));
        }

        @Override // android.support.v4.app.af
        public Notification b() {
            SparseArray<Bundle> sparseArrayA = an.a(this.f590c);
            if (sparseArrayA != null) {
                this.f589b.putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            this.f588a.setExtras(this.f589b);
            return this.f588a.build();
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
