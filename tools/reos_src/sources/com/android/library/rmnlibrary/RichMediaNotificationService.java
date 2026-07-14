package com.android.library.rmnlibrary;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.a.a.g;
import com.android.apps.config.util.CLog;
import com.android.library.rmnlibrary.activity.RichMediaVideoActivity;
import com.android.library.rmnlibrary.activity.RichMediaYouTubeActivity;
import com.android.library.rmnlibrary.b.c;
import com.android.library.rmnlibrary.b.e;
import com.android.library.rmnlibrary.b.f;
import com.android.library.rmnlibrary.b.i;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class RichMediaNotificationService extends Service {
    private LayoutInflater A;
    private View B;
    private ImageView C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f2721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Notification f2722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Notification f2723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Notification f2724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Notification f2725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Notification f2726f;
    private Notification g;
    private Notification h;
    private Notification i;
    private MediaPlayer j;
    private boolean k;
    private RemoteViews l;
    private RemoteViews m;
    private RemoteViews n;
    private AbstractNotification o;
    private AbstractNotification p;
    private AbstractNotification q;
    private AbstractNotification r;
    private AbstractNotification s;
    private AbstractNotification t;
    private AbstractNotification u;
    private AbstractNotification v;
    private AbstractNotification w;
    private int x;
    private Notification y;
    private WindowManager z;

    class a extends AsyncTask {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f2737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f2738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Context f2739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2740f;
        private AbstractNotification g;

        a(Context context, String str, String str2, String str3, boolean z, AbstractNotification abstractNotification) {
            this.f2738d = null;
            this.f2740f = null;
            this.f2737c = null;
            this.f2739e = context;
            this.f2736b = z;
            this.f2738d = str;
            this.f2740f = str2;
            this.f2737c = str3;
            this.g = abstractNotification;
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object[] objArr) {
            c.a(this.f2739e, this.f2738d, this.f2740f, this.f2737c, this.g, this.f2736b);
            return null;
        }
    }

    private void a(String str) {
        b.a(this, this.o.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.o.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.o);
        this.n = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_imageslider);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_basic_type);
        PendingIntent pendingIntentA = b.a(this, "com.android.library.rmnlibrary.CAROUSEL_PREV", RichMediaNotificationService.class);
        PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.CAROUSEL_NEXT", RichMediaNotificationService.class);
        int size = this.o.getResponse().getNotifications().size();
        for (int i = 0; i < size; i++) {
            RemoteViews remoteViews2 = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.list_imageslider_item);
            AbstractNotification.ResponseEntity.NotificationsEntity notificationsEntity = this.o.getResponse().getNotifications().get(i);
            b.a(this, remoteViews2, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notificationsEntity.getTitle1(), notificationsEntity.getMessage1(), notificationsEntity.getTitle2());
            remoteViews2.setImageViewBitmap(com.android.library.rmnlibrary.a.b.img, (Bitmap) e.a().get("com.android.library.rmnlibrary.CACHE_BANNER_CAROUSEL" + i));
            remoteViews2.setImageViewBitmap(com.android.library.rmnlibrary.a.b.img_noti_icon_small, (Bitmap) e.a().get("com.android.library.rmnlibrary.CACHE_ICON_CAROUSEL" + i));
            b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notificationsEntity.getTitle1(), notificationsEntity.getMessage1(), null);
            PendingIntent pendingIntentA3 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_CAROUSEL_1", RichMediaNotificationService.class, i);
            remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA3);
            remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img, pendingIntentA3);
            remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_2, b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_CAROUSEL_2", RichMediaNotificationService.class, i));
            this.n.addView(com.android.library.rmnlibrary.a.b.ViewFlipper01, remoteViews2);
        }
        remoteViews.setTextViewText(com.android.library.rmnlibrary.a.b.txt_noti_title, this.o.getResponse().getNotifications().get(0).getTitle1());
        remoteViews.setTextViewText(com.android.library.rmnlibrary.a.b.txt_noti_message, this.o.getResponse().getNotifications().get(0).getMessage1());
        remoteViews.setImageViewBitmap(com.android.library.rmnlibrary.a.b.img_noti_icon_small, (Bitmap) e.a().get("com.android.library.rmnlibrary.CACHE_ICON_CAROUSEL0"));
        this.n.setDisplayedChild(com.android.library.rmnlibrary.a.b.ViewFlipper01, 0);
        this.n.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_next, pendingIntentA2);
        this.n.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_previous, pendingIntentA);
        this.f2722b = b.a().a(this).a(this.x).a(remoteViews, this.n, 2222, true);
        b.b(this, this.o.getResponse().getNotifications().get(0).getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.f2722b, 2222);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String package_name = this.s.getResponse().getNotifications().get(0).getAction1().getPackage_name();
        if (this.k) {
            b.a(this, this.s.getResponse().getNotifications().get(0).getDeal_id(), "audio_paused", package_name, this.s);
            this.k = false;
            this.m.setImageViewResource(com.android.library.rmnlibrary.a.b.img_play_pause, com.android.library.rmnlibrary.a.C0050a.ic_noti_play_circle_white_24dp);
            this.l.setImageViewResource(com.android.library.rmnlibrary.a.b.img_play_pause, com.android.library.rmnlibrary.a.C0050a.ic_noti_play_circle_grey_24dp);
            b.a(1111, this.f2721a, this.f2723c);
            this.j.pause();
            return;
        }
        b.a(this, this.s.getResponse().getNotifications().get(0).getDeal_id(), "audio_played", package_name, this.s);
        this.k = true;
        this.m.setImageViewResource(com.android.library.rmnlibrary.a.b.img_play_pause, com.android.library.rmnlibrary.a.C0050a.ic_noti_pause_circle_white_24dp);
        this.l.setImageViewResource(com.android.library.rmnlibrary.a.b.img_play_pause, com.android.library.rmnlibrary.a.C0050a.ic_noti_pause_circle_grey_24dp);
        b.a(1111, this.f2721a, this.f2723c);
        this.j.start();
        c();
    }

    private void b(String str) {
        b.a(this, this.p.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.p.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.p);
        List<AbstractNotification.ResponseEntity.NotificationsEntity> notifications = this.p.getResponse().getNotifications();
        int size = notifications.size();
        RemoteViews remoteViews = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_banner_multi_type);
        RemoteViews remoteViews2 = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_basic_type);
        PendingIntent pendingIntentA = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_MULTI_TYPE_1", RichMediaNotificationService.class, 0);
        PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_MULTI_TYPE_2", RichMediaNotificationService.class, 0);
        PendingIntent pendingIntentA3 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_MULTI_TYPE_1", RichMediaNotificationService.class, 1);
        PendingIntent pendingIntentA4 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_MULTI_TYPE_2", RichMediaNotificationService.class, 1);
        PendingIntent pendingIntentA5 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_MULTI_TYPE_1", RichMediaNotificationService.class, 2);
        PendingIntent pendingIntentA6 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_MULTI_TYPE_2", RichMediaNotificationService.class, 2);
        b.a(this, remoteViews2, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notifications.get(0).getTitle1(), notifications.get(0).getMessage1(), notifications.get(0).getTitle2());
        b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title1, com.android.library.rmnlibrary.a.b.txt_noti_message1, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notifications.get(0).getTitle1(), notifications.get(0).getMessage1(), notifications.get(0).getTitle2());
        b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title2, com.android.library.rmnlibrary.a.b.txt_noti_message2, com.android.library.rmnlibrary.a.b.click_call_to_action_4, notifications.get(1).getTitle1(), notifications.get(1).getMessage1(), notifications.get(1).getTitle2());
        if (size > 2) {
            remoteViews.setViewVisibility(com.android.library.rmnlibrary.a.b.rl_action_3, 0);
            b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title3, com.android.library.rmnlibrary.a.b.txt_noti_message3, com.android.library.rmnlibrary.a.b.click_call_to_action_6, notifications.get(2).getTitle1(), notifications.get(2).getMessage1(), notifications.get(2).getTitle2());
            remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_5, pendingIntentA5);
            remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_6, pendingIntentA6);
        }
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_2, pendingIntentA2);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_2, pendingIntentA2);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_3, pendingIntentA3);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_4, pendingIntentA4);
        this.f2724d = b.a().a(this).a(this.x).a(remoteViews2, remoteViews, 4444, true);
        b.b(this, notifications.get(0).getIcon1(), remoteViews2, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.f2724d, 4444);
        b.b(this, notifications.get(0).getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small1, this.f2724d, 4444);
        b.b(this, notifications.get(1).getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small2, this.f2724d, 4444);
        if (size > 2) {
            b.b(this, notifications.get(2).getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small3, this.f2724d, 4444);
        }
        b.a(this, this.p.getResponse().getBanner(), remoteViews, com.android.library.rmnlibrary.a.b.img_banner, this.f2724d, 4444);
    }

    private void c() {
        final Handler handler = new Handler() { // from class: com.android.library.rmnlibrary.RichMediaNotificationService.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (RichMediaNotificationService.this.j == null) {
                    RichMediaNotificationService.this.m.setViewVisibility(com.android.library.rmnlibrary.a.b.txt_time_duration, 4);
                    RichMediaNotificationService.this.l.setViewVisibility(com.android.library.rmnlibrary.a.b.txt_time_duration, 4);
                    return;
                }
                if (!RichMediaNotificationService.this.j.isPlaying()) {
                    RichMediaNotificationService.this.m.setViewVisibility(com.android.library.rmnlibrary.a.b.txt_time_duration, 4);
                    RichMediaNotificationService.this.l.setViewVisibility(com.android.library.rmnlibrary.a.b.txt_time_duration, 4);
                    return;
                }
                RichMediaNotificationService.this.m.setViewVisibility(com.android.library.rmnlibrary.a.b.txt_time_duration, 0);
                RichMediaNotificationService.this.l.setViewVisibility(com.android.library.rmnlibrary.a.b.txt_time_duration, 0);
                int currentPosition = RichMediaNotificationService.this.j.getCurrentPosition();
                int duration = RichMediaNotificationService.this.j.getDuration();
                String strA = f.a(currentPosition);
                String strA2 = f.a(duration);
                RichMediaNotificationService.this.m.setTextViewText(com.android.library.rmnlibrary.a.b.txt_time_duration, strA + "/" + strA2);
                RichMediaNotificationService.this.l.setTextViewText(com.android.library.rmnlibrary.a.b.txt_time_duration, strA + "/" + strA2);
                b.a(1111, RichMediaNotificationService.this.f2721a, RichMediaNotificationService.this.f2723c);
            }
        };
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() { // from class: com.android.library.rmnlibrary.RichMediaNotificationService.3
            @Override // java.lang.Runnable
            public void run() {
                handler.sendMessage(handler.obtainMessage());
            }
        }, 100L, 1000L, TimeUnit.MILLISECONDS);
    }

    private void c(String str) {
        b.a(this, this.q.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.q.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.q);
        AbstractNotification.ResponseEntity.NotificationsEntity notificationsEntity = this.q.getResponse().getNotifications().get(0);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_banner_type);
        RemoteViews remoteViews2 = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_basic_type);
        PendingIntent pendingIntentA = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_TYPE_1", RichMediaNotificationService.class, 0);
        PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_TYPE_2", RichMediaNotificationService.class, 0);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_2, pendingIntentA2);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_banner, pendingIntentA);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_2, pendingIntentA2);
        b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notificationsEntity.getTitle1(), notificationsEntity.getMessage1(), notificationsEntity.getTitle2());
        b.a(this, remoteViews2, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notificationsEntity.getTitle1(), notificationsEntity.getMessage1(), notificationsEntity.getTitle2());
        this.f2725e = b.a().a(this).a(this.x).a(remoteViews2, remoteViews, 3333, true);
        b.a(this, this.q.getResponse().getBanner(), remoteViews, com.android.library.rmnlibrary.a.b.img_banner, this.f2725e, 3333);
        b.b(this, notificationsEntity.getIcon1(), remoteViews2, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.f2725e, 3333);
        b.b(this, notificationsEntity.getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.f2725e, 3333);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        b.a(this, this.s.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.s.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.s);
        List<AbstractNotification.ResponseEntity.NotificationsEntity> notifications = this.s.getResponse().getNotifications();
        this.l = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_audio_collapse);
        this.m = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_audio_expand);
        PendingIntent pendingIntentA = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_AUDIO_1", RichMediaNotificationService.class, 0);
        PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.AUDIO_PLAY_PAUSE", RichMediaNotificationService.class);
        PendingIntent pendingIntentA3 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_AUDIO_CLOSE", RichMediaNotificationService.class);
        PendingIntent pendingIntentB = b.b(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_AUDIO_SWIPE_DELETE", RichMediaNotificationService.class);
        this.l.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_play_pause, pendingIntentA2);
        this.m.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_play_pause, pendingIntentA2);
        this.m.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.ic_noti_close, pendingIntentA3);
        this.l.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA2);
        this.m.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA2);
        this.m.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_banner_musics, pendingIntentA);
        this.m.setTextViewText(com.android.library.rmnlibrary.a.b.txt_time_duration, f.a(this.j.getDuration()));
        this.l.setTextViewText(com.android.library.rmnlibrary.a.b.txt_time_duration, f.a(this.j.getDuration()));
        b.a(this, this.l, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, notifications.get(0).getTitle1(), notifications.get(0).getMessage1());
        b.a(this, this.m, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, notifications.get(0).getTitle1(), notifications.get(0).getMessage1());
        this.f2723c = b.a().a(this).a(this.x).a(pendingIntentB).a(this.l, this.m, 1111, false);
        b.a(this, this.s.getResponse().getBanner(), this.m, com.android.library.rmnlibrary.a.b.img_banner_musics, this.f2723c, 1111);
        b.b(this, notifications.get(0).getIcon1(), this.m, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.f2723c, 1111);
        b.b(this, notifications.get(0).getIcon1(), this.l, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.f2723c, 1111);
    }

    private void e(String str) {
        b.a(this, this.r.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.r.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.r);
        List<AbstractNotification.ResponseEntity.NotificationsEntity> notifications = this.r.getResponse().getNotifications();
        RemoteViews remoteViews = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_basic_type);
        PendingIntent pendingIntentA = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BASIC_TYPE_1", RichMediaNotificationService.class, 0);
        PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_BASIC_TYPE_2", RichMediaNotificationService.class, 0);
        b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notifications.get(0).getTitle1(), notifications.get(0).getMessage1(), notifications.get(0).getTitle2());
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_2, pendingIntentA2);
        this.f2726f = b.a().a(this).a(this.x).a(remoteViews, Integer.parseInt(this.r.getResponse().getNotification_id()), true);
        b.b(this, notifications.get(0).getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.f2726f, Integer.parseInt(this.r.getResponse().getNotification_id()));
    }

    private void f(String str) {
        PendingIntent pendingIntentA;
        PendingIntent pendingIntent;
        b.a(this, this.t.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.t.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.t);
        List<AbstractNotification.ResponseEntity.NotificationsEntity> notifications = this.t.getResponse().getNotifications();
        boolean zIsEmpty = TextUtils.isEmpty(this.t.getResponse().getBanner());
        RemoteViews remoteViews = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_basic_type);
        RemoteViews remoteViews2 = zIsEmpty ? new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_user_acquisition) : new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_user_acquisition_banner);
        if (str.equals("UA")) {
            PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_UA_1", RichMediaNotificationService.class, 0);
            pendingIntentA = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_UA_2", RichMediaNotificationService.class, 0);
            pendingIntent = pendingIntentA2;
        } else if (str.equals("MULTIPLE_UA")) {
            PendingIntent pendingIntentA3 = b.a(this, "com.android.library.rmnlibrary.UA_MULTIPLE.CLICK_ACTION_1", RichMediaNotificationService.class, 0);
            pendingIntentA = b.a(this, "com.android.library.rmnlibrary.UA_MULTIPLE.CLICK_ACTION_2", RichMediaNotificationService.class, 0);
            pendingIntent = pendingIntentA3;
        } else {
            pendingIntentA = null;
            pendingIntent = null;
        }
        b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notifications.get(0).getTitle1(), notifications.get(0).getMessage1());
        b.a(this, remoteViews2, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notifications.get(0).getTitle1(), notifications.get(0).getMessage1());
        b.a(remoteViews2, com.android.library.rmnlibrary.a.b.btn_ua_left, com.android.library.rmnlibrary.a.b.btn_ua_right, notifications.get(0).getCancel_label(), notifications.get(0).getOn_label());
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.btn_ua_left, pendingIntent);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.btn_ua_right, pendingIntentA);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_banner_UA, pendingIntentA);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA);
        Notification notificationA = b.a().a(this).a(this.x).a(remoteViews, remoteViews2, 6666, false);
        if (!zIsEmpty) {
            b.a(this, this.t.getResponse().getBanner(), remoteViews2, com.android.library.rmnlibrary.a.b.img_banner_UA, notificationA, 6666);
        }
        b.b(this, notifications.get(0).getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small, notificationA, 6666);
        b.b(this, notifications.get(0).getIcon1(), remoteViews2, com.android.library.rmnlibrary.a.b.img_noti_icon_small, notificationA, 6666);
    }

    private void g(String str) {
        b.a(this, this.u.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.u.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.u);
        List<AbstractNotification.ResponseEntity.NotificationsEntity> notifications = this.u.getResponse().getNotifications();
        boolean zIsEmpty = TextUtils.isEmpty(this.u.getResponse().getBanner());
        RemoteViews remoteViews = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_basic_type);
        RemoteViews remoteViews2 = zIsEmpty ? new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_user_acquisition) : new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_user_acquisition_banner);
        PendingIntent pendingIntentA = b.a(this, "com.android.library.rmnlibrary.UA_MULTIPLE.CLICK_ACTION_1", RichMediaNotificationService.class, 0);
        PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.UA_MULTIPLE.CLICK_ACTION_2", RichMediaNotificationService.class, 0);
        b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notifications.get(0).getTitle1(), notifications.get(0).getMessage1());
        b.a(this, remoteViews2, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, com.android.library.rmnlibrary.a.b.click_call_to_action_2, notifications.get(0).getTitle1(), notifications.get(0).getMessage1());
        b.a(remoteViews2, com.android.library.rmnlibrary.a.b.btn_ua_left, com.android.library.rmnlibrary.a.b.btn_ua_right, notifications.get(0).getCancel_label(), notifications.get(0).getOn_label());
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.btn_ua_left, pendingIntentA);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.btn_ua_right, pendingIntentA2);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA2);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_banner_UA, pendingIntentA2);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA2);
        Notification notificationA = b.a().a(this).a(this.x).a(remoteViews, remoteViews2, 9999, false);
        if (!zIsEmpty) {
            b.a(this, this.u.getResponse().getBanner(), remoteViews2, com.android.library.rmnlibrary.a.b.img_banner_UA, notificationA, 9999);
        }
        b.b(this, notifications.get(0).getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small, notificationA, 9999);
        b.b(this, notifications.get(0).getIcon1(), remoteViews2, com.android.library.rmnlibrary.a.b.img_noti_icon_small, notificationA, 9999);
    }

    private void h(String str) {
        b.a(this, this.v.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.v.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.v);
        AbstractNotification.ResponseEntity.NotificationsEntity notificationsEntity = this.v.getResponse().getNotifications().get(0);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_video_expand);
        RemoteViews remoteViews2 = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_video_collapse);
        PendingIntent pendingIntentA = b.a(this, "com.android.library.rmnlibrary.VIDEO_PLAY_PAUSE", RichMediaNotificationService.class);
        PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.CALL_TO_ACTION_VIDEO_TYPE", RichMediaNotificationService.class, 0);
        b.a(this, remoteViews2, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, notificationsEntity.getTitle1(), notificationsEntity.getMessage1());
        b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, notificationsEntity.getTitle1(), notificationsEntity.getMessage1());
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA2);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA2);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_banner, pendingIntentA);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_play_video, pendingIntentA);
        this.g = b.a().a(this).a(this.x).a(remoteViews2, remoteViews, 5555, true);
        b.a(this, this.v.getResponse().getBanner(), remoteViews, com.android.library.rmnlibrary.a.b.img_banner, this.g, 5555);
        b.b(this, notificationsEntity.getIcon1(), remoteViews2, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.g, 5555);
        b.b(this, notificationsEntity.getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.g, 5555);
    }

    private void i(String str) {
        b.a(this, this.w.getResponse().getNotifications().get(0).getDeal_id(), "displayed", this.w.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.w);
        AbstractNotification.ResponseEntity.NotificationsEntity notificationsEntity = this.w.getResponse().getNotifications().get(0);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_video_expand);
        RemoteViews remoteViews2 = new RemoteViews(getPackageName(), com.android.library.rmnlibrary.a.c.noti_view_video_collapse);
        PendingIntent pendingIntentA = b.a(this, "com.android.library.rmnlibrary.GIF.PLAY_PAUSE", RichMediaNotificationService.class);
        PendingIntent pendingIntentA2 = b.a(this, "com.android.library.rmnlibrary.GIF.CLICK_ACTION", RichMediaNotificationService.class, 0);
        b.a(this, remoteViews2, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, notificationsEntity.getTitle1(), notificationsEntity.getMessage1());
        b.a(this, remoteViews, com.android.library.rmnlibrary.a.b.txt_noti_title, com.android.library.rmnlibrary.a.b.txt_noti_message, notificationsEntity.getTitle1(), notificationsEntity.getMessage1());
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA2);
        remoteViews2.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.click_call_to_action_1, pendingIntentA2);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_banner, pendingIntentA);
        remoteViews.setOnClickPendingIntent(com.android.library.rmnlibrary.a.b.img_play_video, pendingIntentA);
        this.y = b.a().a(this).a(this.x).a(remoteViews2, remoteViews, 8888, true);
        b.a(this, this.w.getResponse().getBanner(), remoteViews, com.android.library.rmnlibrary.a.b.img_banner, this.y, 8888);
        b.b(this, notificationsEntity.getIcon1(), remoteViews2, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.y, 8888);
        b.b(this, notificationsEntity.getIcon1(), remoteViews, com.android.library.rmnlibrary.a.b.img_noti_icon_small, this.y, 8888);
    }

    private void j(final String str) {
        this.j = new MediaPlayer();
        try {
            this.j.setAudioStreamType(3);
            this.j.setDataSource(this.s.getResponse().getItem_url());
            this.j.prepare();
            this.j.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.android.library.rmnlibrary.RichMediaNotificationService.4
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    RichMediaNotificationService.this.d(str);
                }
            });
            this.j.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.android.library.rmnlibrary.RichMediaNotificationService.5
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    RichMediaNotificationService.this.k = false;
                    RichMediaNotificationService.this.m.setImageViewResource(com.android.library.rmnlibrary.a.b.img_play_pause, com.android.library.rmnlibrary.a.C0050a.ic_noti_play_circle_white_24dp);
                    RichMediaNotificationService.this.l.setImageViewResource(com.android.library.rmnlibrary.a.b.img_play_pause, com.android.library.rmnlibrary.a.C0050a.ic_noti_play_circle_grey_24dp);
                    RichMediaNotificationService.this.m.setTextViewText(com.android.library.rmnlibrary.a.b.txt_time_duration, f.a(RichMediaNotificationService.this.j.getDuration()));
                    RichMediaNotificationService.this.l.setTextViewText(com.android.library.rmnlibrary.a.b.txt_time_duration, f.a(RichMediaNotificationService.this.j.getDuration()));
                    b.a(1111, RichMediaNotificationService.this.f2721a, RichMediaNotificationService.this.f2723c);
                }
            });
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        this.z = (WindowManager) getApplicationContext().getSystemService("window");
        this.A = (LayoutInflater) getSystemService("layout_inflater");
        this.B = this.A.inflate(com.android.library.rmnlibrary.a.c.view_gif, (ViewGroup) null);
        this.C = (ImageView) this.B.findViewById(com.android.library.rmnlibrary.a.b.img_gif);
        g.b(this).a(this.w.getResponse().getItem_url()).d(com.android.library.rmnlibrary.a.C0050a.ic_placeholder_notification).c(com.android.library.rmnlibrary.a.C0050a.ic_placeholder_notification).a(this.C);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.android.library.rmnlibrary.RichMediaNotificationService.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((WindowManager) RichMediaNotificationService.this.getApplicationContext().getSystemService("window")).removeView(RichMediaNotificationService.this.B);
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2010, 296, -3);
        layoutParams.gravity = 48;
        this.z.addView(this.B, layoutParams);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f2721a = (NotificationManager) getSystemService("notification");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 0;
        }
        this.x = com.android.library.rmnlibrary.b.g.a("sharedprefs.key.drawableid", 0, (Context) this);
        if (this.x == 0) {
            this.x = com.android.library.rmnlibrary.a.C0050a.ic_launcher_rmn;
        }
        switch (intent.getAction()) {
            case "Single":
                b.a(this, this.f2725e, 3333);
                this.q = (AbstractNotification) intent.getExtras().getParcelable("Single");
                com.android.library.rmnlibrary.b.g.b("Single", f.a(this, this.q), this);
                c("Single");
                return 0;
            case "Multiple":
                b.a(this, this.f2724d, 4444);
                this.p = (AbstractNotification) intent.getExtras().getParcelable("Multiple");
                com.android.library.rmnlibrary.b.g.b("Multiple", f.a(this, this.p), this);
                b("Multiple");
                return 0;
            case "Audio":
                b.a(this, this.f2723c, 1111);
                this.s = (AbstractNotification) intent.getExtras().getParcelable("Audio");
                com.android.library.rmnlibrary.b.g.b("Audio", f.a(this, this.s), this);
                j("Audio");
                return 0;
            case "Carousel":
                b.a(this, this.f2722b, 2222);
                this.o = (AbstractNotification) intent.getExtras().getParcelable("Carousel");
                com.android.library.rmnlibrary.b.g.b("Carousel", f.a(this, this.o), this);
                a("Carousel");
                return 0;
            case "Basic":
                b.a(this, this.f2726f, 7777);
                this.r = (AbstractNotification) intent.getExtras().getParcelable("Basic");
                com.android.library.rmnlibrary.b.g.b("Basic", f.a(this, this.r), this);
                e("Basic");
                return 0;
            case "Video":
                b.a(this, this.g, 5555);
                this.v = (AbstractNotification) intent.getExtras().getParcelable("Video");
                com.android.library.rmnlibrary.b.g.b("Video", f.a(this, this.v), this);
                h("Video");
                return 0;
            case "GIF":
                b.a(this, this.y, 8888);
                this.w = (AbstractNotification) intent.getExtras().getParcelable("GIF");
                com.android.library.rmnlibrary.b.g.b("GIF", f.a(this, this.w), this);
                i("GIF");
                return 0;
            case "UA":
                b.a(this, this.h, 6666);
                this.t = (AbstractNotification) intent.getExtras().getParcelable("UA");
                com.android.library.rmnlibrary.b.g.b("UA", f.a(this, this.t), this);
                f("UA");
                return 0;
            case "MULTIPLE_UA":
                b.a(this, this.i, 9999);
                this.u = (AbstractNotification) intent.getExtras().getParcelable("MULTIPLE_UA");
                com.android.library.rmnlibrary.b.g.b("MULTIPLE_UA", f.a(this, this.u), this);
                g("MULTIPLE_UA");
                return 0;
            case "com.android.library.rmnlibrary.CAROUSEL_PREV":
                this.o = b.a(this, "Carousel", this.o, AbstractNotification.class);
                if (this.n == null) {
                    a("Carousel");
                } else {
                    this.n.showPrevious(com.android.library.rmnlibrary.a.b.ViewFlipper01);
                }
                b.a(2222, this.f2721a, this.f2722b);
                return 0;
            case "com.android.library.rmnlibrary.CAROUSEL_NEXT":
                this.o = b.a(this, "Carousel", this.o, AbstractNotification.class);
                if (this.n == null) {
                    a("Carousel");
                } else {
                    this.n.showNext(com.android.library.rmnlibrary.a.b.ViewFlipper01);
                }
                b.a(2222, this.f2721a, this.f2722b);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_CAROUSEL_1":
                int intExtra = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 99);
                this.o = b.a(this, "Carousel", this.o, AbstractNotification.class);
                b.a((Context) this, this.o.getResponse().getNotifications().get(intExtra).getDeal_id(), this.o, this.o.getResponse().getNotifications().get(intExtra).getAction1(), 2222, true);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_CAROUSEL_2":
                int intExtra2 = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 99);
                this.o = b.a(this, "Carousel", this.o, AbstractNotification.class);
                b.a((Context) this, this.o.getResponse().getNotifications().get(intExtra2).getDeal_id(), this.o, this.o.getResponse().getNotifications().get(intExtra2).getAction2(), 2222, true);
                return 0;
            case "com.android.library.rmnlibrary.AUDIO_PLAY_PAUSE":
                this.s = b.a(this, "Audio", this.s, AbstractNotification.class);
                if (this.m == null || this.l == null) {
                    b.a(this, 1111);
                    j("Audio");
                    new Handler().postDelayed(new Runnable() { // from class: com.android.library.rmnlibrary.RichMediaNotificationService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RichMediaNotificationService.this.b();
                        }
                    }, 2000L);
                } else {
                    b();
                }
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_AUDIO_CLOSE":
                this.s = b.a(this, "Audio", this.s, AbstractNotification.class);
                if (this.j != null) {
                    this.j.stop();
                }
                b.a(this, 1111);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_AUDIO_SWIPE_DELETE":
                this.s = b.a(this, "Audio", this.s, AbstractNotification.class);
                if (this.j != null) {
                    this.j.stop();
                }
                b.a(this, 1111);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_AUDIO_1":
                this.s = b.a(this, "Audio", this.s, AbstractNotification.class);
                int intExtra3 = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 0);
                b.a((Context) this, this.s.getResponse().getNotifications().get(intExtra3).getDeal_id(), this.s, this.s.getResponse().getNotifications().get(intExtra3).getAction1(), 1111, true);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_TYPE_1":
                this.q = b.a(this, "Single", this.q, AbstractNotification.class);
                int intExtra4 = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 0);
                b.a((Context) this, this.q.getResponse().getNotifications().get(intExtra4).getDeal_id(), this.q, this.q.getResponse().getNotifications().get(intExtra4).getAction1(), 3333, true);
                b.a(this, 3333);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_TYPE_2":
                this.q = b.a(this, "Single", this.q, AbstractNotification.class);
                int intExtra5 = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 0);
                b.a((Context) this, this.q.getResponse().getNotifications().get(intExtra5).getDeal_id(), this.q, this.q.getResponse().getNotifications().get(intExtra5).getAction2(), 3333, true);
                b.a(this, 3333);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_BASIC_TYPE_1":
                this.r = b.a(this, "Basic", this.r, AbstractNotification.class);
                int intExtra6 = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 0);
                b.a((Context) this, this.r.getResponse().getNotifications().get(intExtra6).getDeal_id(), this.r, this.r.getResponse().getNotifications().get(intExtra6).getAction1(), 7777, true);
                b.a(this, Integer.parseInt(this.r.getResponse().getNotification_id()));
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_BASIC_TYPE_2":
                this.r = b.a(this, "Basic", this.r, AbstractNotification.class);
                int intExtra7 = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 0);
                b.a((Context) this, this.r.getResponse().getNotifications().get(intExtra7).getDeal_id(), this.r, this.r.getResponse().getNotifications().get(intExtra7).getAction2(), 7777, true);
                b.a(this, Integer.parseInt(this.r.getResponse().getNotification_id()));
                return 0;
            case "com.android.library.rmnlibrary.VIDEO_PLAY_PAUSE":
                this.v = b.a(this, "Video", this.v, AbstractNotification.class);
                b.a(this, this.v.getResponse().getNotifications().get(0).getDeal_id(), "video_played", this.v.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.v);
                if (!this.v.getResponse().getIs_youtube().equalsIgnoreCase("true")) {
                    b.a(this, RichMediaVideoActivity.class, "Video", this.v);
                } else if (TextUtils.isEmpty(com.android.library.rmnlibrary.b.g.a("sharedprefs.key.youtubekey", (String) null, this))) {
                    CLog.b("RMNLibrary", "YouTube API Key Should not be null or empty");
                } else {
                    b.a(this, RichMediaYouTubeActivity.class, "Video", this.v);
                }
                return 0;
            case "com.android.library.rmnlibrary.GIF.PLAY_PAUSE":
                this.w = b.a(this, "GIF", this.w, AbstractNotification.class);
                a();
                return 0;
            case "com.android.library.rmnlibrary.GIF.CLICK_ACTION":
                this.w = b.a(this, "GIF", this.w, AbstractNotification.class);
                b.a((Context) this, this.w.getResponse().getNotifications().get(0).getDeal_id(), this.w, this.w.getResponse().getNotifications().get(0).getAction1(), 8888, true);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_MULTI_TYPE_1":
                this.p = b.a(this, "Multiple", this.p, AbstractNotification.class);
                int intExtra8 = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 0);
                b.a((Context) this, this.p.getResponse().getNotifications().get(intExtra8).getDeal_id(), this.p, this.p.getResponse().getNotifications().get(intExtra8).getAction1(), 4444, true);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_BANNER_MULTI_TYPE_2":
                this.p = b.a(this, "Multiple", this.p, AbstractNotification.class);
                int intExtra9 = intent.getIntExtra("com.android.library.rmnlibrary.CLICKED_POSITION", 0);
                b.a((Context) this, this.p.getResponse().getNotifications().get(intExtra9).getDeal_id(), this.p, this.p.getResponse().getNotifications().get(intExtra9).getAction2(), 4444, true);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_UA_1":
                this.t = b.a(this, "UA", this.t, AbstractNotification.class);
                b.a(this, this.t.getResponse().getNotifications().get(0).getDeal_id(), "cancel_clicked", this.t.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.t);
                f.a(this);
                b.a(this, 6666);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_UA_2":
                this.t = b.a(this, "UA", this.t, AbstractNotification.class);
                String package_name = this.t.getResponse().getNotifications().get(0).getAction1().getPackage_name();
                String md5 = this.t.getResponse().getNotifications().get(0).getMd5();
                String strReplaceAll = this.t.getResponse().getNotifications().get(0).getAction1().getApp_url().replaceAll(" ", "%20");
                String strA = i.a(package_name);
                File file = new File(strA);
                b.a(this, this.t.getResponse().getNotifications().get(0).getDeal_id(), "ok_clicked", package_name, this.t);
                if (file.exists()) {
                    c.a(this, strA, file, package_name, this.t);
                } else {
                    new a(this, package_name, md5, strReplaceAll, !f.b(this, this.t.getResponse().getMode()), this.t).execute(new Object[0]);
                }
                b.a(this, 6666);
                return 0;
            case "com.android.library.rmnlibrary.UA_MULTIPLE.CLICK_ACTION_1":
                this.u = b.a(this, "MULTIPLE_UA", this.u, AbstractNotification.class);
                b.a(this, this.u.getResponse().getNotifications().get(0).getDeal_id(), "cancel_clicked", this.u.getResponse().getNotifications().get(0).getAction1().getPackage_name(), this.u);
                f.a(this);
                b.a(this, 9999);
                return 0;
            case "com.android.library.rmnlibrary.UA_MULTIPLE.CLICK_ACTION_2":
                this.u = b.a(this, "MULTIPLE_UA", this.u, AbstractNotification.class);
                for (AbstractNotification.ResponseEntity.NotificationsEntity.APK_DOWNLOAD apk_download : this.u.getResponse().getNotifications().get(0).getApk_download()) {
                    String package_name2 = apk_download.getPackage_name();
                    String md6 = apk_download.getMd5();
                    String apk_url = apk_download.getApk_url();
                    String strA2 = i.a(package_name2);
                    File file2 = new File(strA2);
                    b.a(this, this.u.getResponse().getNotifications().get(0).getDeal_id(), "ok_clicked", package_name2, this.u);
                    if (file2.exists()) {
                        c.a(this, strA2, file2, package_name2, this.u);
                    } else {
                        new a(this, package_name2, md6, apk_url, !f.b(this, this.u.getResponse().getMode()), this.u).execute(new Object[0]);
                    }
                }
                b.a(this, 9999);
                return 0;
            case "com.android.library.rmnlibrary.CALL_TO_ACTION_VIDEO_TYPE":
                this.v = b.a(this, "Video", this.v, AbstractNotification.class);
                b.a((Context) this, this.v.getResponse().getNotifications().get(0).getDeal_id(), this.v, this.v.getResponse().getNotifications().get(0).getAction1(), 5555, true);
                return 0;
            default:
                return 0;
        }
    }
}
