package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class aj {

    public static abstract class a {

        /* JADX INFO: renamed from: android.support.v4.app.aj$a$a, reason: collision with other inner class name */
        public interface InterfaceC0011a {
        }

        public abstract int a();

        public abstract CharSequence b();

        public abstract PendingIntent c();

        public abstract Bundle d();

        public abstract at.a[] f();
    }

    public static Notification a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        return notification;
    }
}
