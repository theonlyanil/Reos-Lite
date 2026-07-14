package com.android.library.deviceData.a;

import com.android.library.userprofile.util.Constants;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    QUALCOMM(Constants.QUALCOMM_CLASS_NAME),
    MEDIATEK(Constants.MTK_TELEPHONY_MANAGER_EX_CLASS_NAME),
    SPREADTRUM(Constants.SPRD_OPERATORUTILS_CLASS_NAME),
    NONE("");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f2608e;

    a(String str) {
        this.f2608e = "";
        this.f2608e = str;
    }

    public String a() {
        return this.f2608e;
    }
}
