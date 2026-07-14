package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import com.android.library.userprofile.util.Constants;
import com.facebook.b.ad;
import com.facebook.b.x;
import com.facebook.b.y;
import com.facebook.l;
import com.facebook.m;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static Pair<String, String> a(String str) {
        String strSubstring = null;
        int iIndexOf = str.indexOf(58);
        if (iIndexOf != -1 && str.length() > iIndexOf + 1) {
            strSubstring = str.substring(0, iIndexOf);
            str = str.substring(iIndexOf + 1);
        }
        return new Pair<>(strSubstring, str);
    }

    private static com.facebook.b.a a(int i, int i2, Intent intent) {
        UUID uuidB = y.b(intent);
        if (uuidB == null) {
            return null;
        }
        return com.facebook.b.a.a(uuidB, i);
    }

    public static g a(final com.facebook.h<com.facebook.share.a.C0072a> hVar) {
        return new g(hVar) { // from class: com.facebook.share.internal.j.1
            @Override // com.facebook.share.internal.g
            public void a(com.facebook.b.a aVar) {
                j.b((com.facebook.h<com.facebook.share.a.C0072a>) hVar);
            }

            @Override // com.facebook.share.internal.g
            public void a(com.facebook.b.a aVar, Bundle bundle) {
                if (bundle != null) {
                    String strA = j.a(bundle);
                    if (strA == null || "post".equalsIgnoreCase(strA)) {
                        j.a((com.facebook.h<com.facebook.share.a.C0072a>) hVar, j.b(bundle));
                    } else if ("cancel".equalsIgnoreCase(strA)) {
                        j.b((com.facebook.h<com.facebook.share.a.C0072a>) hVar);
                    } else {
                        j.a((com.facebook.h<com.facebook.share.a.C0072a>) hVar, new com.facebook.k("UnknownError"));
                    }
                }
            }

            @Override // com.facebook.share.internal.g
            public void a(com.facebook.b.a aVar, com.facebook.k kVar) {
                j.a((com.facebook.h<com.facebook.share.a.C0072a>) hVar, kVar);
            }
        };
    }

    public static String a(Bundle bundle) {
        return bundle.containsKey("completionGesture") ? bundle.getString("completionGesture") : bundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
    }

    public static String a(ShareVideoContent shareVideoContent, UUID uuid) {
        if (shareVideoContent == null || shareVideoContent.d() == null) {
            return null;
        }
        x.a aVarA = x.a(uuid, shareVideoContent.d().c());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(aVarA);
        x.a(arrayList);
        return aVarA.a();
    }

    public static List<Bundle> a(ShareMediaContent shareMediaContent, final UUID uuid) {
        List<ShareMedia> listA;
        if (shareMediaContent == null || (listA = shareMediaContent.a()) == null) {
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        List<Bundle> listA2 = ad.a((List) listA, (ad.d) new ad.d<ShareMedia, Bundle>() { // from class: com.facebook.share.internal.j.5
            @Override // com.facebook.b.ad.d
            public Bundle a(ShareMedia shareMedia) {
                x.a aVarB = j.b(uuid, shareMedia);
                arrayList.add(aVarB);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.SMS_COLUMN_TYPE, shareMedia.b().name());
                bundle.putString("uri", aVarB.a());
                return bundle;
            }
        });
        x.a(arrayList);
        return listA2;
    }

    public static List<String> a(SharePhotoContent sharePhotoContent, final UUID uuid) {
        List<SharePhoto> listA;
        if (sharePhotoContent == null || (listA = sharePhotoContent.a()) == null) {
            return null;
        }
        List listA2 = ad.a((List) listA, (ad.d) new ad.d<SharePhoto, x.a>() { // from class: com.facebook.share.internal.j.3
            @Override // com.facebook.b.ad.d
            public x.a a(SharePhoto sharePhoto) {
                return j.b(uuid, sharePhoto);
            }
        });
        List<String> listA3 = ad.a(listA2, (ad.d) new ad.d<x.a, String>() { // from class: com.facebook.share.internal.j.4
            @Override // com.facebook.b.ad.d
            public String a(x.a aVar) {
                return aVar.a();
            }
        });
        x.a(listA2);
        return listA3;
    }

    public static JSONArray a(JSONArray jSONArray, boolean z) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return jSONArray2;
            }
            Object objA = jSONArray.get(i2);
            if (objA instanceof JSONArray) {
                objA = a((JSONArray) objA, z);
            } else if (objA instanceof JSONObject) {
                objA = a((JSONObject) objA, z);
            }
            jSONArray2.put(objA);
            i = i2 + 1;
        }
    }

    public static JSONObject a(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        return e.a(shareOpenGraphContent.a(), new e.a() { // from class: com.facebook.share.internal.j.7
            @Override // com.facebook.share.internal.e.a
            public JSONObject a(SharePhoto sharePhoto) {
                Uri uriD = sharePhoto.d();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, uriD.toString());
                    return jSONObject;
                } catch (JSONException e2) {
                    throw new com.facebook.k("Unable to attach images", e2);
                }
            }
        });
    }

    public static JSONObject a(final UUID uuid, ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        ShareOpenGraphAction shareOpenGraphActionA = shareOpenGraphContent.a();
        final ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectA = e.a(shareOpenGraphActionA, new e.a() { // from class: com.facebook.share.internal.j.6
            @Override // com.facebook.share.internal.e.a
            public JSONObject a(SharePhoto sharePhoto) {
                x.a aVarB = j.b(uuid, sharePhoto);
                if (aVarB == null) {
                    return null;
                }
                arrayList.add(aVarB);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, aVarB.a());
                    if (!sharePhoto.e()) {
                        return jSONObject;
                    }
                    jSONObject.put("user_generated", true);
                    return jSONObject;
                } catch (JSONException e2) {
                    throw new com.facebook.k("Unable to attach images", e2);
                }
            }
        });
        x.a(arrayList);
        if (shareOpenGraphContent.j() != null && ad.a(jSONObjectA.optString("place"))) {
            jSONObjectA.put("place", shareOpenGraphContent.j());
        }
        if (shareOpenGraphContent.i() != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("tags");
            Set<String> hashSet = jSONArrayOptJSONArray == null ? new HashSet() : ad.b(jSONArrayOptJSONArray);
            Iterator<String> it = shareOpenGraphContent.i().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
            jSONObjectA.put("tags", new ArrayList(hashSet));
        }
        return jSONObjectA;
    }

    public static JSONObject a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArrayNames = jSONObject.names();
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String string = jSONArrayNames.getString(i);
                Object obj = jSONObject.get(string);
                Object objA = obj instanceof JSONObject ? a((JSONObject) obj, true) : obj instanceof JSONArray ? a((JSONArray) obj, true) : obj;
                Pair<String, String> pairA = a(string);
                String str = (String) pairA.first;
                String str2 = (String) pairA.second;
                if (z) {
                    if (str != null && str.equals("fbsdk")) {
                        jSONObject2.put(string, objA);
                    } else if (str == null || str.equals("og")) {
                        jSONObject2.put(str2, objA);
                    } else {
                        jSONObject3.put(str2, objA);
                    }
                } else if (str == null || !str.equals("fb")) {
                    jSONObject2.put(str2, objA);
                } else {
                    jSONObject2.put(string, objA);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException e2) {
            throw new com.facebook.k("Failed to create json object from share content");
        }
    }

    public static void a(final int i) {
        com.facebook.b.f.a(i, new com.facebook.b.f.a() { // from class: com.facebook.share.internal.j.2
            @Override // com.facebook.b.f.a
            public boolean a(int i2, Intent intent) {
                return j.a(i, i2, intent, j.a((com.facebook.h<com.facebook.share.a.C0072a>) null));
            }
        });
    }

    static void a(com.facebook.h<com.facebook.share.a.C0072a> hVar, com.facebook.k kVar) {
        a("error", kVar.getMessage());
        if (hVar != null) {
            hVar.a(kVar);
        }
    }

    static void a(com.facebook.h<com.facebook.share.a.C0072a> hVar, String str) {
        a("succeeded", (String) null);
        if (hVar != null) {
            hVar.a(new com.facebook.share.a.C0072a(str));
        }
    }

    private static void a(String str, String str2) {
        com.facebook.a.f fVarA = com.facebook.a.f.a(m.f());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_outcome", str);
        if (str2 != null) {
            bundle.putString("error_message", str2);
        }
        fVarA.a("fb_share_dialog_result", (Double) null, bundle);
    }

    public static boolean a(int i, int i2, Intent intent, g gVar) {
        com.facebook.b.a aVarA = a(i, i2, intent);
        if (aVarA == null) {
            return false;
        }
        x.a(aVarA.c());
        if (gVar == null) {
            return true;
        }
        com.facebook.k kVarA = y.a(y.g(intent));
        if (kVarA == null) {
            gVar.a(aVarA, y.e(intent));
            return true;
        }
        if (kVarA instanceof l) {
            gVar.a(aVarA);
            return true;
        }
        gVar.a(aVarA, kVarA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x.a b(UUID uuid, ShareMedia shareMedia) {
        Uri uriC;
        Bitmap bitmapC;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            bitmapC = sharePhoto.c();
            uriC = sharePhoto.d();
        } else if (shareMedia instanceof ShareVideo) {
            uriC = ((ShareVideo) shareMedia).c();
            bitmapC = null;
        } else {
            uriC = null;
            bitmapC = null;
        }
        if (bitmapC != null) {
            return x.a(uuid, bitmapC);
        }
        if (uriC != null) {
            return x.a(uuid, uriC);
        }
        return null;
    }

    public static String b(Bundle bundle) {
        if (bundle.containsKey("postId")) {
            return bundle.getString("postId");
        }
        return bundle.containsKey("com.facebook.platform.extra.POST_ID") ? bundle.getString("com.facebook.platform.extra.POST_ID") : bundle.getString("post_id");
    }

    static void b(com.facebook.h<com.facebook.share.a.C0072a> hVar) {
        a("cancelled", (String) null);
        if (hVar != null) {
            hVar.a();
        }
    }
}
