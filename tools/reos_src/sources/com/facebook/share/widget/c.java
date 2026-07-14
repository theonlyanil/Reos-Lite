package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.android.library.userprofile.util.Constants;
import com.facebook.b.ad;
import com.facebook.b.f;
import com.facebook.b.i;
import com.facebook.b.j;
import com.facebook.b.o;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.h;
import com.facebook.share.internal.k;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends j<ShareContent, com.facebook.share.a.C0072a> implements com.facebook.share.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f4135b = f.b.Share.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4137d;

    private class a extends j<ShareContent, com.facebook.share.a.C0072a>.a {
        private a() {
            super();
        }

        @Override // com.facebook.b.j.a
        public com.facebook.b.a a(ShareContent shareContent) {
            Bundle bundleA;
            c.this.a(c.this.b(), shareContent, b.FEED);
            com.facebook.b.a aVarD = c.this.d();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                h.c(shareLinkContent);
                bundleA = k.b(shareLinkContent);
            } else {
                bundleA = k.a((ShareFeedContent) shareContent);
            }
            i.a(aVarD, "feed", bundleA);
            return aVarD;
        }

        @Override // com.facebook.b.j.a
        public Object a() {
            return b.FEED;
        }

        @Override // com.facebook.b.j.a
        public boolean a(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }
    }

    public enum b {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    /* JADX INFO: renamed from: com.facebook.share.widget.c$c, reason: collision with other inner class name */
    private class C0074c extends j<ShareContent, com.facebook.share.a.C0072a>.a {
        private C0074c() {
            super();
        }

        @Override // com.facebook.b.j.a
        public com.facebook.b.a a(final ShareContent shareContent) {
            c.this.a(c.this.b(), shareContent, b.NATIVE);
            h.b(shareContent);
            final com.facebook.b.a aVarD = c.this.d();
            final boolean zE = c.this.e();
            i.a(aVarD, new i.a() { // from class: com.facebook.share.widget.c.c.1
                @Override // com.facebook.b.i.a
                public Bundle a() {
                    return com.facebook.share.internal.c.a(aVarD.c(), shareContent, zE);
                }

                @Override // com.facebook.b.i.a
                public Bundle b() {
                    return com.facebook.share.internal.a.a(aVarD.c(), shareContent, zE);
                }
            }, c.f(shareContent.getClass()));
            return aVarD;
        }

        @Override // com.facebook.b.j.a
        public Object a() {
            return b.NATIVE;
        }

        @Override // com.facebook.b.j.a
        public boolean a(ShareContent shareContent, boolean z) {
            boolean zA;
            if (shareContent == null) {
                return false;
            }
            if (z) {
                zA = true;
            } else {
                zA = shareContent.l() != null ? i.a(com.facebook.share.internal.i.HASHTAG) : true;
                if ((shareContent instanceof ShareLinkContent) && !ad.a(((ShareLinkContent) shareContent).d())) {
                    zA &= i.a(com.facebook.share.internal.i.LINK_SHARE_QUOTES);
                }
            }
            return zA && c.d(shareContent.getClass());
        }
    }

    private class d extends j<ShareContent, com.facebook.share.a.C0072a>.a {
        private d() {
            super();
        }

        private String b(ShareContent shareContent) {
            if (shareContent instanceof ShareLinkContent) {
                return "share";
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return "share_open_graph";
            }
            return null;
        }

        @Override // com.facebook.b.j.a
        public com.facebook.b.a a(ShareContent shareContent) {
            c.this.a(c.this.b(), shareContent, b.WEB);
            com.facebook.b.a aVarD = c.this.d();
            h.c(shareContent);
            i.a(aVarD, b(shareContent), shareContent instanceof ShareLinkContent ? k.a((ShareLinkContent) shareContent) : k.a((ShareOpenGraphContent) shareContent));
            return aVarD;
        }

        @Override // com.facebook.b.j.a
        public Object a() {
            return b.WEB;
        }

        @Override // com.facebook.b.j.a
        public boolean a(ShareContent shareContent, boolean z) {
            return shareContent != null && c.e(shareContent.getClass());
        }
    }

    c(Activity activity, int i) {
        super(activity, i);
        this.f4136c = false;
        this.f4137d = true;
        com.facebook.share.internal.j.a(i);
    }

    c(Fragment fragment, int i) {
        this(new o(fragment), i);
    }

    c(android.support.v4.app.Fragment fragment, int i) {
        this(new o(fragment), i);
    }

    private c(o oVar, int i) {
        super(oVar, i);
        this.f4136c = false;
        this.f4137d = true;
        com.facebook.share.internal.j.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ShareContent shareContent, b bVar) {
        String str;
        String str2;
        if (this.f4137d) {
            bVar = b.AUTOMATIC;
        }
        switch (bVar) {
            case AUTOMATIC:
                str = "automatic";
                break;
            case WEB:
                str = "web";
                break;
            case NATIVE:
                str = "native";
                break;
            default:
                str = "unknown";
                break;
        }
        com.facebook.b.h hVarF = f(shareContent.getClass());
        if (hVarF == com.facebook.share.internal.i.SHARE_DIALOG) {
            str2 = Constants.SMS_COLUMN_STATUS;
        } else if (hVarF == com.facebook.share.internal.i.PHOTOS) {
            str2 = "photo";
        } else if (hVarF == com.facebook.share.internal.i.VIDEO) {
            str2 = "video";
        } else {
            str2 = hVarF == com.facebook.share.internal.d.OG_ACTION_DIALOG ? "open_graph" : "unknown";
        }
        com.facebook.a.f fVarA = com.facebook.a.f.a(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str);
        bundle.putString("fb_share_dialog_content_type", str2);
        fVarA.a("fb_share_dialog_show", (Double) null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Class<? extends ShareContent> cls) {
        com.facebook.b.h hVarF = f(cls);
        return hVarF != null && i.a(hVarF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(Class<? extends ShareContent> cls) {
        return ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.facebook.b.h f(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.i.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.i.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.i.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.d.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.i.MULTIMEDIA;
        }
        return null;
    }

    @Override // com.facebook.b.j
    protected List<j<ShareContent, com.facebook.share.a.C0072a>.a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0074c());
        arrayList.add(new a());
        arrayList.add(new d());
        return arrayList;
    }

    @Override // com.facebook.b.j
    protected com.facebook.b.a d() {
        return new com.facebook.b.a(a());
    }

    public boolean e() {
        return this.f4136c;
    }
}
