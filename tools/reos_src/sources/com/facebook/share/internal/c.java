package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.b.ad;
import com.facebook.b.ae;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static Bundle a(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        ad.a(bundle, "LINK", shareContent.h());
        ad.a(bundle, "PLACE", shareContent.j());
        ad.a(bundle, "REF", shareContent.k());
        bundle.putBoolean("DATA_FAILURES_FATAL", z);
        List<String> listI = shareContent.i();
        if (!ad.a(listI)) {
            bundle.putStringArrayList("FRIENDS", new ArrayList<>(listI));
        }
        ShareHashtag shareHashtagL = shareContent.l();
        if (shareHashtagL != null) {
            ad.a(bundle, "HASHTAG", shareHashtagL.a());
        }
        return bundle;
    }

    private static Bundle a(ShareLinkContent shareLinkContent, boolean z) {
        Bundle bundleA = a((ShareContent) shareLinkContent, z);
        ad.a(bundleA, "TITLE", shareLinkContent.b());
        ad.a(bundleA, "DESCRIPTION", shareLinkContent.a());
        ad.a(bundleA, "IMAGE", shareLinkContent.c());
        ad.a(bundleA, "QUOTE", shareLinkContent.d());
        return bundleA;
    }

    private static Bundle a(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z) {
        Bundle bundleA = a(shareMediaContent, z);
        bundleA.putParcelableArrayList("MEDIA", new ArrayList<>(list));
        return bundleA;
    }

    private static Bundle a(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle bundleA = a(shareOpenGraphContent, z);
        ad.a(bundleA, "PREVIEW_PROPERTY_NAME", (String) j.a(shareOpenGraphContent.b()).second);
        ad.a(bundleA, "ACTION_TYPE", shareOpenGraphContent.a().a());
        ad.a(bundleA, "ACTION", jSONObject.toString());
        return bundleA;
    }

    private static Bundle a(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle bundleA = a(sharePhotoContent, z);
        bundleA.putStringArrayList("PHOTOS", new ArrayList<>(list));
        return bundleA;
    }

    private static Bundle a(ShareVideoContent shareVideoContent, String str, boolean z) {
        Bundle bundleA = a(shareVideoContent, z);
        ad.a(bundleA, "TITLE", shareVideoContent.b());
        ad.a(bundleA, "DESCRIPTION", shareVideoContent.a());
        ad.a(bundleA, "VIDEO", str);
        return bundleA;
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
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return a(shareVideoContent, j.a(shareVideoContent, uuid), z);
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return a(shareOpenGraphContent, j.a(j.a(uuid, shareOpenGraphContent), false), z);
            } catch (JSONException e2) {
                throw new com.facebook.k("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e2.getMessage());
            }
        }
        if (!(shareContent instanceof ShareMediaContent)) {
            return null;
        }
        ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
        return a(shareMediaContent, j.a(shareMediaContent, uuid), z);
    }
}
