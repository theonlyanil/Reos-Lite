package com.android.library.rmnlibrary;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AbstractNotification implements Parcelable {
    public static final Parcelable.Creator<AbstractNotification> CREATOR = new Parcelable.Creator<AbstractNotification>() { // from class: com.android.library.rmnlibrary.AbstractNotification.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractNotification createFromParcel(Parcel parcel) {
            return new AbstractNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractNotification[] newArray(int i) {
            return new AbstractNotification[i];
        }
    };
    private ResponseEntity response;

    public static class ResponseEntity implements Parcelable {
        public static final Parcelable.Creator<ResponseEntity> CREATOR = new Parcelable.Creator<ResponseEntity>() { // from class: com.android.library.rmnlibrary.AbstractNotification.ResponseEntity.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResponseEntity createFromParcel(Parcel parcel) {
                return new ResponseEntity(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResponseEntity[] newArray(int i) {
                return new ResponseEntity[i];
            }
        };
        private String banner;
        private String deal_type;
        private String is_youtube;
        private String item_length;
        private String item_url;
        private String mode;
        private String notification_id;
        private String notification_type;
        private String notification_validity;
        private List<NotificationsEntity> notifications;

        public static class NotificationsEntity implements Parcelable {
            public static final Parcelable.Creator<NotificationsEntity> CREATOR = new Parcelable.Creator<NotificationsEntity>() { // from class: com.android.library.rmnlibrary.AbstractNotification.ResponseEntity.NotificationsEntity.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public NotificationsEntity createFromParcel(Parcel parcel) {
                    return new NotificationsEntity(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public NotificationsEntity[] newArray(int i) {
                    return new NotificationsEntity[i];
                }
            };
            private ActionEntity action1;
            private ActionEntity action2;
            private List<APK_DOWNLOAD> apk_download;
            private String banner;
            private String cancel_label;
            private String deal_id;
            private String icon1;
            private String icon2;
            private String md5;
            private String message1;
            private String on_label;
            private String open_after_interval;
            private String open_app;
            private String title1;
            private String title2;

            public static class APK_DOWNLOAD implements Parcelable {
                public static final Parcelable.Creator<APK_DOWNLOAD> CREATOR = new Parcelable.Creator<APK_DOWNLOAD>() { // from class: com.android.library.rmnlibrary.AbstractNotification.ResponseEntity.NotificationsEntity.APK_DOWNLOAD.1
                    @Override // android.os.Parcelable.Creator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public APK_DOWNLOAD createFromParcel(Parcel parcel) {
                        return new APK_DOWNLOAD(parcel);
                    }

                    @Override // android.os.Parcelable.Creator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public APK_DOWNLOAD[] newArray(int i) {
                        return new APK_DOWNLOAD[i];
                    }
                };
                private String apk_url;
                private String md5;
                private String package_name;

                public APK_DOWNLOAD() {
                }

                protected APK_DOWNLOAD(Parcel parcel) {
                    this.apk_url = parcel.readString();
                    this.package_name = parcel.readString();
                    this.md5 = parcel.readString();
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                public String getApk_url() {
                    return this.apk_url;
                }

                public String getMd5() {
                    return this.md5;
                }

                public String getPackage_name() {
                    return this.package_name;
                }

                public void setApk_url(String str) {
                    this.apk_url = str;
                }

                public void setMd5(String str) {
                    this.md5 = str;
                }

                public void setPackage_name(String str) {
                    this.package_name = str;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(this.apk_url);
                    parcel.writeString(this.package_name);
                    parcel.writeString(this.md5);
                }
            }

            public static class ActionEntity implements Parcelable {
                public static final Parcelable.Creator<ActionEntity> CREATOR = new Parcelable.Creator<ActionEntity>() { // from class: com.android.library.rmnlibrary.AbstractNotification.ResponseEntity.NotificationsEntity.ActionEntity.1
                    @Override // android.os.Parcelable.Creator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public ActionEntity createFromParcel(Parcel parcel) {
                        return new ActionEntity(parcel);
                    }

                    @Override // android.os.Parcelable.Creator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public ActionEntity[] newArray(int i) {
                        return new ActionEntity[i];
                    }
                };
                private String add_calendar_events;
                private String add_snooze_time;
                private String app_url;
                private String deep_link;
                private Facebook facebook;
                private String open_in_playsore;
                private String package_name;
                private Facebook twitter;

                public ActionEntity() {
                }

                ActionEntity(Parcel parcel) {
                    this.app_url = parcel.readString();
                    this.open_in_playsore = parcel.readString();
                    this.package_name = parcel.readString();
                    this.deep_link = parcel.readString();
                    this.add_calendar_events = parcel.readString();
                    this.add_snooze_time = parcel.readString();
                    this.facebook = (Facebook) parcel.readParcelable(Facebook.class.getClassLoader());
                    this.twitter = (Facebook) parcel.readParcelable(Facebook.class.getClassLoader());
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                public String getAdd_calendar_events() {
                    return this.add_calendar_events;
                }

                public String getAdd_snooze_time() {
                    return this.add_snooze_time;
                }

                public String getApp_url() {
                    return this.app_url;
                }

                public String getDeep_link() {
                    return this.deep_link;
                }

                public Facebook getFacebook() {
                    return this.facebook;
                }

                public String getOpen_in_playsore() {
                    return this.open_in_playsore;
                }

                public String getPackage_name() {
                    return this.package_name;
                }

                public Facebook getTwitter() {
                    return this.twitter;
                }

                public void setAdd_calendar_events(String str) {
                    this.add_calendar_events = str;
                }

                public void setAdd_snooze_time(String str) {
                    this.add_snooze_time = str;
                }

                public void setApp_url(String str) {
                    this.app_url = str;
                }

                public void setDeep_link(String str) {
                    this.deep_link = str;
                }

                public void setFacebook(Facebook facebook) {
                    this.facebook = facebook;
                }

                public void setOpen_in_playsore(String str) {
                    this.open_in_playsore = str;
                }

                public void setPackage_name(String str) {
                    this.package_name = str;
                }

                public void setTwitter(Facebook facebook) {
                    this.twitter = facebook;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(this.app_url);
                    parcel.writeString(this.open_in_playsore);
                    parcel.writeString(this.package_name);
                    parcel.writeString(this.deep_link);
                    parcel.writeString(this.add_calendar_events);
                    parcel.writeString(this.add_snooze_time);
                    parcel.writeParcelable(this.facebook, 0);
                    parcel.writeParcelable(this.twitter, 0);
                }
            }

            public static class Facebook implements Parcelable {
                public static final Parcelable.Creator<Facebook> CREATOR = new Parcelable.Creator<Facebook>() { // from class: com.android.library.rmnlibrary.AbstractNotification.ResponseEntity.NotificationsEntity.Facebook.1
                    @Override // android.os.Parcelable.Creator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Facebook createFromParcel(Parcel parcel) {
                        return new Facebook(parcel);
                    }

                    @Override // android.os.Parcelable.Creator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Facebook[] newArray(int i) {
                        return new Facebook[i];
                    }
                };

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private String f2710a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private String f2711b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private String f2712c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private String f2713d;

                public Facebook() {
                }

                protected Facebook(Parcel parcel) {
                    this.f2710a = parcel.readString();
                    this.f2711b = parcel.readString();
                    this.f2712c = parcel.readString();
                    this.f2713d = parcel.readString();
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(this.f2710a);
                    parcel.writeString(this.f2711b);
                    parcel.writeString(this.f2712c);
                    parcel.writeString(this.f2713d);
                }
            }

            public NotificationsEntity() {
            }

            NotificationsEntity(Parcel parcel) {
                this.deal_id = parcel.readString();
                this.banner = parcel.readString();
                this.title1 = parcel.readString();
                this.icon1 = parcel.readString();
                this.action1 = (ActionEntity) parcel.readParcelable(ActionEntity.class.getClassLoader());
                this.message1 = parcel.readString();
                this.title2 = parcel.readString();
                this.icon2 = parcel.readString();
                this.action2 = (ActionEntity) parcel.readParcelable(ActionEntity.class.getClassLoader());
                this.md5 = parcel.readString();
                this.on_label = parcel.readString();
                this.cancel_label = parcel.readString();
                this.open_app = parcel.readString();
                this.open_after_interval = parcel.readString();
                this.apk_download = parcel.createTypedArrayList(APK_DOWNLOAD.CREATOR);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public ActionEntity getAction1() {
                return this.action1;
            }

            public ActionEntity getAction2() {
                return this.action2;
            }

            public List<APK_DOWNLOAD> getApk_download() {
                return this.apk_download;
            }

            public String getBanner() {
                return this.banner;
            }

            public String getCancel_label() {
                return this.cancel_label;
            }

            public String getDeal_id() {
                return this.deal_id;
            }

            public String getIcon1() {
                return this.icon1;
            }

            public String getIcon2() {
                return this.icon2;
            }

            public String getMd5() {
                return this.md5;
            }

            public String getMessage1() {
                return this.message1;
            }

            public String getOn_label() {
                return this.on_label;
            }

            public String getOpen_after_interval() {
                return this.open_after_interval;
            }

            public String getOpen_app() {
                return this.open_app;
            }

            public String getTitle1() {
                return this.title1;
            }

            public String getTitle2() {
                return this.title2;
            }

            public void setAction1(ActionEntity actionEntity) {
                this.action1 = actionEntity;
            }

            public void setAction2(ActionEntity actionEntity) {
                this.action2 = actionEntity;
            }

            public void setApk_download(List<APK_DOWNLOAD> list) {
                this.apk_download = list;
            }

            public void setBanner(String str) {
                this.banner = str;
            }

            public void setCancel_label(String str) {
                this.cancel_label = str;
            }

            public void setDeal_id(String str) {
                this.deal_id = str;
            }

            public void setIcon1(String str) {
                this.icon1 = str;
            }

            public void setIcon2(String str) {
                this.icon2 = str;
            }

            public void setMd5(String str) {
                this.md5 = str;
            }

            public void setMessage1(String str) {
                this.message1 = str;
            }

            public void setOn_label(String str) {
                this.on_label = str;
            }

            public void setOpen_after_interval(String str) {
                this.open_after_interval = str;
            }

            public void setOpen_app(String str) {
                this.open_app = str;
            }

            public void setTitle1(String str) {
                this.title1 = str;
            }

            public void setTitle2(String str) {
                this.title2 = str;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(this.deal_id);
                parcel.writeString(this.banner);
                parcel.writeString(this.title1);
                parcel.writeString(this.icon1);
                parcel.writeParcelable(this.action1, 0);
                parcel.writeString(this.message1);
                parcel.writeString(this.title2);
                parcel.writeString(this.icon2);
                parcel.writeParcelable(this.action2, 0);
                parcel.writeString(this.md5);
                parcel.writeString(this.on_label);
                parcel.writeString(this.cancel_label);
                parcel.writeString(this.open_app);
                parcel.writeString(this.open_after_interval);
                parcel.writeTypedList(this.apk_download);
            }
        }

        public ResponseEntity() {
        }

        ResponseEntity(Parcel parcel) {
            this.notification_validity = parcel.readString();
            this.deal_type = parcel.readString();
            this.notification_id = parcel.readString();
            this.notification_type = parcel.readString();
            this.banner = parcel.readString();
            this.item_url = parcel.readString();
            this.item_length = parcel.readString();
            this.is_youtube = parcel.readString();
            this.mode = parcel.readString();
            this.notifications = parcel.createTypedArrayList(NotificationsEntity.CREATOR);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getBanner() {
            return this.banner;
        }

        public String getDeal_type() {
            return this.deal_type;
        }

        public String getIs_youtube() {
            return this.is_youtube;
        }

        public String getItem_length() {
            return this.item_length;
        }

        public String getItem_url() {
            return this.item_url;
        }

        public String getMode() {
            return this.mode;
        }

        public String getNotification_id() {
            return this.notification_id;
        }

        public String getNotification_type() {
            return this.notification_type;
        }

        public String getNotification_validity() {
            return this.notification_validity;
        }

        public List<NotificationsEntity> getNotifications() {
            return this.notifications;
        }

        public void setBanner(String str) {
            this.banner = str;
        }

        public void setDeal_type(String str) {
            this.deal_type = str;
        }

        public void setIs_youtube(String str) {
            this.is_youtube = str;
        }

        public void setItem_length(String str) {
            this.item_length = str;
        }

        public void setItem_url(String str) {
            this.item_url = str;
        }

        public void setMode(String str) {
            this.mode = str;
        }

        public void setNotification_id(String str) {
            this.notification_id = str;
        }

        public void setNotification_type(String str) {
            this.notification_type = str;
        }

        public void setNotification_validity(String str) {
            this.notification_validity = str;
        }

        public void setNotifications(List<NotificationsEntity> list) {
            this.notifications = list;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.notification_validity);
            parcel.writeString(this.deal_type);
            parcel.writeString(this.notification_id);
            parcel.writeString(this.notification_type);
            parcel.writeString(this.banner);
            parcel.writeString(this.item_url);
            parcel.writeString(this.item_length);
            parcel.writeString(this.is_youtube);
            parcel.writeString(this.mode);
            parcel.writeTypedList(this.notifications);
        }
    }

    public AbstractNotification() {
    }

    AbstractNotification(Parcel parcel) {
        this.response = (ResponseEntity) parcel.readParcelable(ResponseEntity.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ResponseEntity getResponse() {
        return this.response;
    }

    public void setResponse(ResponseEntity responseEntity) {
        this.response = responseEntity;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.response, 0);
    }
}
