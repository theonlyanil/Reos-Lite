package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ah {

    public static class a implements ae, af {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Notification.Builder f577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f578b;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            this.f577a = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f578b = new Bundle();
            if (bundle != null) {
                this.f578b.putAll(bundle);
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            this.f578b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
        }

        @Override // android.support.v4.app.af
        public Notification.Builder a() {
            return this.f577a;
        }

        @Override // android.support.v4.app.ae
        public void a(aj.a aVar) {
            ah.a(this.f577a, aVar);
        }

        @Override // android.support.v4.app.af
        public Notification b() {
            this.f577a.setExtras(this.f578b);
            return this.f577a.build();
        }
    }

    public static void a(Notification.Builder builder, aj.a aVar) {
        Notification.Action.Builder builder2 = new Notification.Action.Builder(aVar.a(), aVar.b(), aVar.c());
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : as.a(aVar.f())) {
                builder2.addRemoteInput(remoteInput);
            }
        }
        if (aVar.d() != null) {
            builder2.addExtras(aVar.d());
        }
        builder.addAction(builder2.build());
    }
}
