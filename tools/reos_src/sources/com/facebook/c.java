package com.facebook;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true);

    private final boolean j;

    c(boolean z) {
        this.j = z;
    }

    boolean a() {
        return this.j;
    }
}
