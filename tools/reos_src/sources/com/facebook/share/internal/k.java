package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.b.ad;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k {
    public static Bundle a(ShareFeedContent shareFeedContent) {
        Bundle bundle = new Bundle();
        ad.a(bundle, "to", shareFeedContent.a());
        ad.a(bundle, "link", shareFeedContent.b());
        ad.a(bundle, "picture", shareFeedContent.f());
        ad.a(bundle, "source", shareFeedContent.g());
        ad.a(bundle, "name", shareFeedContent.c());
        ad.a(bundle, "caption", shareFeedContent.d());
        ad.a(bundle, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, shareFeedContent.e());
        return bundle;
    }

    public static Bundle a(ShareContent shareContent) {
        Bundle bundle = new Bundle();
        ShareHashtag shareHashtagL = shareContent.l();
        if (shareHashtagL != null) {
            ad.a(bundle, "hashtag", shareHashtagL.a());
        }
        return bundle;
    }

    public static Bundle a(ShareLinkContent shareLinkContent) {
        Bundle bundleA = a((ShareContent) shareLinkContent);
        ad.a(bundleA, "href", shareLinkContent.h());
        ad.a(bundleA, "quote", shareLinkContent.d());
        return bundleA;
    }

    public static Bundle a(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle bundleA = a((ShareContent) shareOpenGraphContent);
        ad.a(bundleA, "action_type", shareOpenGraphContent.a().a());
        try {
            JSONObject jSONObjectA = j.a(j.a(shareOpenGraphContent), false);
            if (jSONObjectA != null) {
                ad.a(bundleA, "action_properties", jSONObjectA.toString());
            }
            return bundleA;
        } catch (JSONException e2) {
            throw new com.facebook.k("Unable to serialize the ShareOpenGraphContent to JSON", e2);
        }
    }

    public static Bundle b(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        ad.a(bundle, "name", shareLinkContent.b());
        ad.a(bundle, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, shareLinkContent.a());
        ad.a(bundle, "link", ad.a(shareLinkContent.h()));
        ad.a(bundle, "picture", ad.a(shareLinkContent.c()));
        ad.a(bundle, "quote", shareLinkContent.d());
        if (shareLinkContent.l() != null) {
            ad.a(bundle, "hashtag", shareLinkContent.l().a());
        }
        return bundle;
    }
}
