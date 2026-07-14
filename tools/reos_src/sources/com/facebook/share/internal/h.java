package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.b.ad;
import com.facebook.b.ae;
import com.facebook.m;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f4072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f4073b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4074a;

        private a() {
            this.f4074a = false;
        }

        public void a(ShareLinkContent shareLinkContent) {
            h.b(shareLinkContent, this);
        }

        public void a(ShareMedia shareMedia) {
            h.a(shareMedia, this);
        }

        public void a(ShareMediaContent shareMediaContent) {
            h.b(shareMediaContent, this);
        }

        public void a(ShareOpenGraphAction shareOpenGraphAction) {
            h.b(shareOpenGraphAction, this);
        }

        public void a(ShareOpenGraphContent shareOpenGraphContent) {
            this.f4074a = true;
            h.b(shareOpenGraphContent, this);
        }

        public void a(ShareOpenGraphObject shareOpenGraphObject) {
            h.b(shareOpenGraphObject, this);
        }

        public void a(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
            h.b(shareOpenGraphValueContainer, this, z);
        }

        public void a(SharePhoto sharePhoto) {
            h.d(sharePhoto, this);
        }

        public void a(SharePhotoContent sharePhotoContent) {
            h.b(sharePhotoContent, this);
        }

        public void a(ShareVideo shareVideo) {
            h.b(shareVideo, this);
        }

        public void a(ShareVideoContent shareVideoContent) {
            h.b(shareVideoContent, this);
        }

        public boolean a() {
            return this.f4074a;
        }
    }

    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.facebook.share.internal.h.a
        public void a(ShareMediaContent shareMediaContent) {
            throw new com.facebook.k("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.h.a
        public void a(SharePhoto sharePhoto) {
            h.e(sharePhoto, this);
        }

        @Override // com.facebook.share.internal.h.a
        public void a(SharePhotoContent sharePhotoContent) {
            throw new com.facebook.k("Cannot share SharePhotoContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.h.a
        public void a(ShareVideoContent shareVideoContent) {
            throw new com.facebook.k("Cannot share ShareVideoContent via web sharing dialogs");
        }
    }

    private static a a() {
        if (f4073b == null) {
            f4073b = new a();
        }
        return f4073b;
    }

    public static void a(ShareContent shareContent) {
        a(shareContent, a());
    }

    private static void a(ShareContent shareContent, a aVar) throws com.facebook.k {
        if (shareContent == null) {
            throw new com.facebook.k("Must provide non-null content to share");
        }
        if (shareContent instanceof ShareLinkContent) {
            aVar.a((ShareLinkContent) shareContent);
            return;
        }
        if (shareContent instanceof SharePhotoContent) {
            aVar.a((SharePhotoContent) shareContent);
            return;
        }
        if (shareContent instanceof ShareVideoContent) {
            aVar.a((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            aVar.a((ShareOpenGraphContent) shareContent);
        } else if (shareContent instanceof ShareMediaContent) {
            aVar.a((ShareMediaContent) shareContent);
        }
    }

    public static void a(ShareMedia shareMedia, a aVar) {
        if (shareMedia instanceof SharePhoto) {
            aVar.a((SharePhoto) shareMedia);
        } else {
            if (!(shareMedia instanceof ShareVideo)) {
                throw new com.facebook.k(String.format(Locale.ROOT, "Invalid media type: %s", shareMedia.getClass().getSimpleName()));
            }
            aVar.a((ShareVideo) shareMedia);
        }
    }

    private static void a(Object obj, a aVar) {
        if (obj instanceof ShareOpenGraphObject) {
            aVar.a((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            aVar.a((SharePhoto) obj);
        }
    }

    private static void a(String str, boolean z) {
        if (z) {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length < 2) {
                throw new com.facebook.k("Open Graph keys must be namespaced: %s", str);
            }
            for (String str2 : strArrSplit) {
                if (str2.isEmpty()) {
                    throw new com.facebook.k("Invalid key found in Open Graph dictionary: %s", str);
                }
            }
        }
    }

    private static a b() {
        if (f4072a == null) {
            f4072a = new b();
        }
        return f4072a;
    }

    public static void b(ShareContent shareContent) {
        a(shareContent, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareLinkContent shareLinkContent, a aVar) {
        Uri uriC = shareLinkContent.c();
        if (uriC != null && !ad.b(uriC)) {
            throw new com.facebook.k("Image Url must be an http:// or https:// url");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareMediaContent shareMediaContent, a aVar) {
        List<ShareMedia> listA = shareMediaContent.a();
        if (listA == null || listA.isEmpty()) {
            throw new com.facebook.k("Must specify at least one medium in ShareMediaContent.");
        }
        if (listA.size() > 6) {
            throw new com.facebook.k(String.format(Locale.ROOT, "Cannot add more than %d media.", 6));
        }
        Iterator<ShareMedia> it = listA.iterator();
        while (it.hasNext()) {
            aVar.a(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareOpenGraphAction shareOpenGraphAction, a aVar) {
        if (shareOpenGraphAction == null) {
            throw new com.facebook.k("Must specify a non-null ShareOpenGraphAction");
        }
        if (ad.a(shareOpenGraphAction.a())) {
            throw new com.facebook.k("ShareOpenGraphAction must have a non-empty actionType");
        }
        aVar.a(shareOpenGraphAction, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareOpenGraphContent shareOpenGraphContent, a aVar) {
        aVar.a(shareOpenGraphContent.a());
        String strB = shareOpenGraphContent.b();
        if (ad.a(strB)) {
            throw new com.facebook.k("Must specify a previewPropertyName.");
        }
        if (shareOpenGraphContent.a().a(strB) == null) {
            throw new com.facebook.k("Property \"" + strB + "\" was not found on the action. The name of the preview property must match the name of an action property.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareOpenGraphObject shareOpenGraphObject, a aVar) {
        if (shareOpenGraphObject == null) {
            throw new com.facebook.k("Cannot share a null ShareOpenGraphObject");
        }
        aVar.a(shareOpenGraphObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareOpenGraphValueContainer shareOpenGraphValueContainer, a aVar, boolean z) {
        for (String str : shareOpenGraphValueContainer.c()) {
            a(str, z);
            Object objA = shareOpenGraphValueContainer.a(str);
            if (objA instanceof List) {
                for (Object obj : (List) objA) {
                    if (obj == null) {
                        throw new com.facebook.k("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                    a(obj, aVar);
                }
            } else {
                a(objA, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(SharePhotoContent sharePhotoContent, a aVar) {
        List<SharePhoto> listA = sharePhotoContent.a();
        if (listA == null || listA.isEmpty()) {
            throw new com.facebook.k("Must specify at least one Photo in SharePhotoContent.");
        }
        if (listA.size() > 6) {
            throw new com.facebook.k(String.format(Locale.ROOT, "Cannot add more than %d photos.", 6));
        }
        Iterator<SharePhoto> it = listA.iterator();
        while (it.hasNext()) {
            aVar.a(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareVideo shareVideo, a aVar) {
        if (shareVideo == null) {
            throw new com.facebook.k("Cannot share a null ShareVideo");
        }
        Uri uriC = shareVideo.c();
        if (uriC == null) {
            throw new com.facebook.k("ShareVideo does not have a LocalUrl specified");
        }
        if (!ad.c(uriC) && !ad.d(uriC)) {
            throw new com.facebook.k("ShareVideo must reference a video that is on the device");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ShareVideoContent shareVideoContent, a aVar) {
        aVar.a(shareVideoContent.d());
        SharePhoto sharePhotoC = shareVideoContent.c();
        if (sharePhotoC != null) {
            aVar.a(sharePhotoC);
        }
    }

    public static void c(ShareContent shareContent) {
        a(shareContent, b());
    }

    private static void c(SharePhoto sharePhoto, a aVar) {
        if (sharePhoto == null) {
            throw new com.facebook.k("Cannot share a null SharePhoto");
        }
        Bitmap bitmapC = sharePhoto.c();
        Uri uriD = sharePhoto.d();
        if (bitmapC == null) {
            if (uriD == null) {
                throw new com.facebook.k("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            if (ad.b(uriD) && !aVar.a()) {
                throw new com.facebook.k("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(SharePhoto sharePhoto, a aVar) {
        c(sharePhoto, aVar);
        if (sharePhoto.c() == null && ad.b(sharePhoto.d())) {
            return;
        }
        ae.d(m.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(SharePhoto sharePhoto, a aVar) {
        if (sharePhoto == null) {
            throw new com.facebook.k("Cannot share a null SharePhoto");
        }
        Uri uriD = sharePhoto.d();
        if (uriD == null || !ad.b(uriD)) {
            throw new com.facebook.k("SharePhoto must have a non-null imageUrl set to the Uri of an image on the web");
        }
    }
}
