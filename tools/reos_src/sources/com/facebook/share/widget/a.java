package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import com.facebook.b.f;
import com.facebook.b.i;
import com.facebook.b.j;
import com.facebook.b.o;
import com.facebook.share.internal.h;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends j<ShareContent, com.facebook.share.a.C0072a> implements com.facebook.share.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f4124b = f.b.Message.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4125c;

    /* JADX INFO: renamed from: com.facebook.share.widget.a$a, reason: collision with other inner class name */
    private class C0073a extends j<ShareContent, com.facebook.share.a.C0072a>.a {
        private C0073a() {
            super();
        }

        @Override // com.facebook.b.j.a
        public com.facebook.b.a a(final ShareContent shareContent) {
            h.a(shareContent);
            final com.facebook.b.a aVarD = a.this.d();
            final boolean zE = a.this.e();
            a.this.b();
            i.a(aVarD, new i.a() { // from class: com.facebook.share.widget.a.a.1
                @Override // com.facebook.b.i.a
                public Bundle a() {
                    return com.facebook.share.internal.c.a(aVarD.c(), shareContent, zE);
                }

                @Override // com.facebook.b.i.a
                public Bundle b() {
                    return com.facebook.share.internal.a.a(aVarD.c(), shareContent, zE);
                }
            }, a.c(shareContent.getClass()));
            return aVarD;
        }

        @Override // com.facebook.b.j.a
        public boolean a(ShareContent shareContent, boolean z) {
            return shareContent != null && a.a((Class<? extends ShareContent>) shareContent.getClass());
        }
    }

    a(Activity activity, int i) {
        super(activity, i);
        this.f4125c = false;
        com.facebook.share.internal.j.a(i);
    }

    a(Fragment fragment, int i) {
        this(new o(fragment), i);
    }

    a(android.support.v4.app.Fragment fragment, int i) {
        this(new o(fragment), i);
    }

    private a(o oVar, int i) {
        super(oVar, i);
        this.f4125c = false;
        com.facebook.share.internal.j.a(i);
    }

    public static boolean a(Class<? extends ShareContent> cls) {
        com.facebook.b.h hVarC = c(cls);
        return hVarC != null && i.a(hVarC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.facebook.b.h c(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.b.MESSAGE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.b.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.b.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.f.OG_MESSAGE_DIALOG;
        }
        return null;
    }

    @Override // com.facebook.b.j
    protected List<j<ShareContent, com.facebook.share.a.C0072a>.a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0073a());
        return arrayList;
    }

    @Override // com.facebook.b.j
    protected com.facebook.b.a d() {
        return new com.facebook.b.a(a());
    }

    public boolean e() {
        return this.f4125c;
    }
}
