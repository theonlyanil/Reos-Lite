package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.b.ad;
import com.facebook.b.ae;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static Bundle a(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        ad.a(bundle, "com.facebook.platform.extra.LINK", shareContent.h());
        ad.a(bundle, "com.facebook.platform.extra.PLACE", shareContent.j());
        ad.a(bundle, "com.facebook.platform.extra.REF", shareContent.k());
        bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z);
        List<String> listI = shareContent.i();
        if (!ad.a(listI)) {
            bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList<>(listI));
        }
        return bundle;
    }

    private static Bundle a(ShareLinkContent shareLinkContent, boolean z) {
        Bundle bundleA = a((ShareContent) shareLinkContent, z);
        ad.a(bundleA, "com.facebook.platform.extra.TITLE", shareLinkContent.b());
        ad.a(bundleA, "com.facebook.platform.extra.DESCRIPTION", shareLinkContent.a());
        ad.a(bundleA, "com.facebook.platform.extra.IMAGE", shareLinkContent.c());
        return bundleA;
    }

    private static Bundle a(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle bundleA = a(shareOpenGraphContent, z);
        ad.a(bundleA, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", shareOpenGraphContent.b());
        ad.a(bundleA, "com.facebook.platform.extra.ACTION_TYPE", shareOpenGraphContent.a().a());
        ad.a(bundleA, "com.facebook.platform.extra.ACTION", jSONObject.toString());
        return bundleA;
    }

    private static Bundle a(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle bundleA = a(sharePhotoContent, z);
        bundleA.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList<>(list));
        return bundleA;
    }

    private static Bundle a(ShareVideoContent shareVideoContent, boolean z) {
        return null;
    }

    public static Bundle a(UUID uuid, ShareContent shareContent, boolean z) {
        ae.a(shareContent, "shareContent");
        ae.a(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return a((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return a(sharePhotoContent, j.a(sharePhotoContent, uuid), z);
        }
        if (shareContent instanceof ShareVideoContent) {
            return a((ShareVideoContent) shareContent, z);
        }
        if (!(shareContent instanceof ShareOpenGraphContent)) {
            return null;
        }
        ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
        try {
            return a(shareOpenGraphContent, j.a(uuid, shareOpenGraphContent), z);
        } catch (JSONException e2) {
            throw new com.facebook.k("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e2.getMessage());
        }
    }
}
