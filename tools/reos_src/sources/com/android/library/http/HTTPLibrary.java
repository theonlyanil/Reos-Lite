package com.android.library.http;

import android.app.ProgressDialog;
import android.content.Context;
import com.android.apps.config.util.CLog;
import com.android.library.http.d.g;
import com.android.library.http.models.AbstractFileUploadDownload;
import com.google.a.l;
import com.google.a.o;
import d.aa;
import d.ac;
import d.w;
import f.b.e;
import f.b.f;
import f.b.i;
import f.b.j;
import f.b.k;
import f.b.n;
import f.b.p;
import f.b.q;
import f.b.u;
import f.b.v;
import f.m;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HTTPLibrary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.android.library.http.a f2647a = new com.android.library.http.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f2648b = null;

    public interface HTTPLibraryNetworkAPIService {
        @f
        @u
        f.b<ac> downloadFile(@v String str);

        @f
        @u
        f.b<ac> downloadFile(@v String str, @i(a = "cUserAgent") String str2);

        @f
        f.b<l> getData(@v String str);

        @f
        f.b<l> getData(@v String str, @i(a = "cUserAgent") String str2);

        @n
        f.b<l> postData(@v String str, @f.b.a o oVar);

        @j(a = {"enc:true"})
        @n(a = "events")
        f.b<l> postEvents(@f.b.a o oVar);

        @n
        @e
        f.b<l> postGCM(@v String str, @f.b.d Map<String, String> map);

        @n
        @k
        f.b<l> uploadFile(@v String str, @q Map<String, aa> map, @p d.v.b bVar);
    }

    public interface a {
        void a(int i, AbstractFileUploadDownload abstractFileUploadDownload);

        void a(int i, String str, int i2);

        void b(int i, String str, int i2);

        void c(int i, String str, int i2);
    }

    public interface b {
        void onError(int i, f.l<l> lVar);

        void onFailure(Throwable th);

        void onSuccess(int i, f.l<l> lVar);
    }

    public enum c {
        GET,
        POST,
        ANALYTICS,
        UPLOAD,
        DOWNLOAD
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AbstractFileUploadDownload f2675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f2676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2677c;

        @Override // java.lang.Runnable
        public void run() {
            this.f2676b.a(this.f2677c, this.f2675a);
        }
    }

    private static w a(Context context, int i, c cVar, boolean z) {
        w wVarA = null;
        if (cVar == c.ANALYTICS) {
            try {
                return new w.a().b(i, TimeUnit.SECONDS).a(i, TimeUnit.SECONDS).a(new com.android.library.http.b.a()).a();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        if (cVar != c.GET) {
            try {
                return new w.a().b(i, TimeUnit.SECONDS).a(i, TimeUnit.SECONDS).a();
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
        try {
            wVarA = z ? new w.a().b(i, TimeUnit.SECONDS).a(i, TimeUnit.SECONDS).a(com.android.library.http.b.b.a(context)).a() : new w.a().b(i, TimeUnit.SECONDS).a(i, TimeUnit.SECONDS).a();
            return wVarA;
        } catch (Exception e4) {
            e4.printStackTrace();
            return wVarA;
        }
    }

    public static w a(Context context, String str, int i, c cVar, boolean z) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
        return com.android.library.http.b.b.a(context, i, new w(), cVar, z);
    }

    public static <T> T a(Context context, String str, Class<T> cls, int i) {
        m mVarA = null;
        if (g.e(str)) {
            mVarA = new m.a().a(str).a(f.a.a.a.a()).a(a(context, i, c.POST, false)).a();
        } else {
            if (!g.f(str)) {
                return null;
            }
            try {
                mVarA = new m.a().a(str).a(f.a.a.a.a()).a(a(context, str, i, c.POST, false)).a();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (KeyManagementException e3) {
                e3.printStackTrace();
            } catch (KeyStoreException e4) {
                e4.printStackTrace();
            } catch (NoSuchAlgorithmException e5) {
                e5.printStackTrace();
            } catch (UnrecoverableKeyException e6) {
                e6.printStackTrace();
            } catch (CertificateException e7) {
                e7.printStackTrace();
            }
        }
        return (T) mVarA.a(cls);
    }

    public static <T> T a(Context context, String str, Class<T> cls, int i, JSONObject jSONObject) {
        m mVarA = null;
        if (g.e(str)) {
            mVarA = new m.a().a(str).a(f.a.a.a.a()).a(a(context, i, c.ANALYTICS, false)).a();
        } else {
            if (!g.f(str)) {
                return null;
            }
            try {
                mVarA = new m.a().a(str).a(f.a.a.a.a()).a(a(context, str, i, c.ANALYTICS, false)).a();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (KeyManagementException e3) {
                e3.printStackTrace();
            } catch (KeyStoreException e4) {
                e4.printStackTrace();
            } catch (NoSuchAlgorithmException e5) {
                e5.printStackTrace();
            } catch (UnrecoverableKeyException e6) {
                e6.printStackTrace();
            } catch (CertificateException e7) {
                e7.printStackTrace();
            }
        }
        return (T) mVarA.a(cls);
    }

    public static <T> T a(Context context, String str, Class<T> cls, int i, boolean z) {
        m mVarA = null;
        if (g.e(str)) {
            mVarA = new m.a().a(str).a(f.a.a.a.a()).a(a(context, i, c.GET, z)).a();
        } else {
            if (!g.f(str)) {
                return null;
            }
            try {
                mVarA = new m.a().a(str).a(f.a.a.a.a()).a(a(context, str, i, c.GET, z)).a();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (KeyManagementException e3) {
                e3.printStackTrace();
            } catch (KeyStoreException e4) {
                e4.printStackTrace();
            } catch (NoSuchAlgorithmException e5) {
                e5.printStackTrace();
            } catch (UnrecoverableKeyException e6) {
                e6.printStackTrace();
            } catch (CertificateException e7) {
                e7.printStackTrace();
            }
        }
        return (T) mVarA.a(cls);
    }

    public static final <T> T a(l lVar, Class<T> cls) {
        String strA = new com.google.a.f().a(lVar);
        com.google.a.g gVar = new com.google.a.g();
        gVar.a();
        return (T) gVar.c().a(strA, (Class) cls);
    }

    private static void a(Context context, final b bVar, final int i, String str, String str2, JSONObject jSONObject, final ProgressDialog progressDialog, int i2) {
        CLog.b("HTTPLibrary", " *** POST URL *** " + str);
        if (!g.c(str)) {
            CLog.d("HTTPLibraryError", "The Base URL cannot be empty and it should always end with slash ('/')");
            return;
        }
        if (!g.d(str2)) {
            CLog.d("HTTPLibraryError", "The Append URL can be a empty String but should not be 'null' and it should not start with slash ('/')");
            return;
        }
        String strA = g.a(str);
        String strB = g.b(str2);
        HTTPLibraryNetworkAPIService hTTPLibraryNetworkAPIService = (HTTPLibraryNetworkAPIService) a(context, strA, HTTPLibraryNetworkAPIService.class, i2);
        if (hTTPLibraryNetworkAPIService == null) {
            CLog.d("HTTPLibraryError", "The Base URL should always starts with HTTP or HTTPS URL");
            return;
        }
        f.b<l> bVarPostData = hTTPLibraryNetworkAPIService.postData(strB, com.android.library.http.d.d.a(com.android.library.http.d.d.a(jSONObject, context)));
        b(progressDialog);
        bVarPostData.a(new f.d<l>() { // from class: com.android.library.http.HTTPLibrary.4
            @Override // f.d
            public void a(f.b<l> bVar2, f.l<l> lVar) {
                HTTPLibrary.c(progressDialog);
                if (lVar.d()) {
                    CLog.b("HTTPLibrary", "Success Response");
                    bVar.onSuccess(i, lVar);
                } else {
                    CLog.b("HTTPLibrary", "Error Response");
                    bVar.onError(i, lVar);
                }
            }

            @Override // f.d
            public void a(f.b<l> bVar2, Throwable th) {
                CLog.b("HTTPLibrary", "Failure Response");
                CLog.b("HTTPLibrary", "exception is " + th);
                HTTPLibrary.c(progressDialog);
                bVar.onFailure(th);
            }
        });
    }

    private static void a(Context context, final b bVar, final int i, String str, String str2, JSONObject jSONObject, final ProgressDialog progressDialog, int i2, String str3, boolean z) {
        CLog.b("HTTPLibrary", " *** POST URL *** " + str);
        if (g.c(str)) {
            if (!g.d(str2)) {
                CLog.d("HTTPLibraryError", "The Append URL can be a empty String but should not be 'null' and it should not start with slash ('/')");
                return;
            }
            String strA = g.a(str);
            String strB = g.b(str2);
            HTTPLibraryNetworkAPIService hTTPLibraryNetworkAPIService = (HTTPLibraryNetworkAPIService) a(context, strA, HTTPLibraryNetworkAPIService.class, i2, z);
            if (hTTPLibraryNetworkAPIService == null) {
                CLog.d("HTTPLibraryError", "The Base URL should always starts with HTTP or HTTPS URL");
                return;
            }
            f.b<l> data = str3 == null ? hTTPLibraryNetworkAPIService.getData(strB) : hTTPLibraryNetworkAPIService.getData(strB, str3);
            b(progressDialog);
            data.a(new f.d<l>() { // from class: com.android.library.http.HTTPLibrary.2
                @Override // f.d
                public void a(f.b<l> bVar2, f.l<l> lVar) {
                    HTTPLibrary.c(progressDialog);
                    if (lVar.d()) {
                        CLog.b("HTTPLibrary", "Success Response");
                        bVar.onSuccess(i, lVar);
                    } else {
                        CLog.b("HTTPLibrary", "Error Response");
                        bVar.onError(i, lVar);
                    }
                }

                @Override // f.d
                public void a(f.b<l> bVar2, Throwable th) {
                    CLog.b("HTTPLibrary", "Failure Response");
                    CLog.b("HTTPLibrary", "exception is " + th);
                    HTTPLibrary.c(progressDialog);
                    bVar.onFailure(th);
                }
            });
        }
    }

    public static void a(Context context, ArrayList<String> arrayList, String str, JSONObject jSONObject, int i, int i2, com.android.library.http.a.a.EnumC0048a enumC0048a) {
        if (com.android.library.http.d.c.a(context, enumC0048a)) {
            b(context, 4444, arrayList, str, jSONObject, null, i, i2, 0, false, enumC0048a);
        }
    }

    private static void b(ProgressDialog progressDialog) {
        if (progressDialog == null) {
            return;
        }
        progressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final int i, final ArrayList<String> arrayList, String str, final JSONObject jSONObject, final ProgressDialog progressDialog, final int i2, final int i3, final int i4, final boolean z, final com.android.library.http.a.a.EnumC0048a enumC0048a) {
        if (!g.c(str)) {
            CLog.d("HTTPLibraryError", "The Base URL cannot be empty and it should always end with slash ('/')");
            return;
        }
        final String strA = g.a(str);
        HTTPLibraryNetworkAPIService hTTPLibraryNetworkAPIService = (HTTPLibraryNetworkAPIService) a(context, strA, HTTPLibraryNetworkAPIService.class, i3, jSONObject);
        if (hTTPLibraryNetworkAPIService == null) {
            CLog.d("HTTPLibraryError", "The Base URL should always starts with HTTP or HTTPS URL");
            return;
        }
        CLog.b("HTTPLibrary", " *** ANALYTICS JSON POST *** " + com.android.library.http.d.d.a(jSONObject, context).toString());
        CLog.b("HTTPLibrary", " *** ANALYTICS URL POST *** " + str);
        if (z && i4 == 0) {
            com.android.library.http.d.d.b(context, jSONObject);
        }
        CLog.b("HTTPLibrary", "Final JSONObject with Encrypted String : " + jSONObject.toString());
        o oVarA = com.android.library.http.d.d.a(com.android.library.http.d.d.a(jSONObject, context));
        CLog.b("HTTPLibrary", "Final Analytics json with encrypted stirng: " + oVarA.toString());
        f.b<l> bVarPostEvents = hTTPLibraryNetworkAPIService.postEvents(oVarA);
        b(progressDialog);
        bVarPostEvents.a(new f.d<l>() { // from class: com.android.library.http.HTTPLibrary.5
            @Override // f.d
            public void a(f.b<l> bVar, f.l<l> lVar) {
                HTTPLibrary.c(progressDialog);
                if (!lVar.d()) {
                    CLog.b("HTTPLibraryError", " ERROR " + lVar.c());
                    return;
                }
                CLog.b("HTTPLibrary", "!!! ~ EVENT DATA POST SUCCESSFUL ~ !!!");
                CLog.b("HTTPLibrary", "!!! ~ EVENT POST RESPONSE ~ !!!" + lVar.e().toString());
                if (i != 4444) {
                    return;
                }
                CLog.b("HTTPLibrary", "!!! ~ EVENT POST JSON OFFLINE DATA ~ !!!" + com.android.library.http.d.d.a(jSONObject, context).toString());
                CLog.b("HTTPLibrary", "!!! ~ EVENT POST RESPONSE OFFLINE DATA ~ !!!" + lVar.e().toString());
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= arrayList.size()) {
                        CLog.b("HTTPLibrary", "!!! ~ REMOVE CURSOR INDEX FROM DB ~ !!!**** ID =" + arrayList + " **** FROM DATABASE ");
                        com.android.library.http.d.e.b("com.android.library.httplibrary.events.LAST_EVENT_DATA_POSTED", System.currentTimeMillis(), context);
                        return;
                    } else {
                        com.android.library.http.a.a.a(context).a((String) arrayList.get(i6), enumC0048a);
                        i5 = i6 + 1;
                    }
                }
            }

            @Override // f.d
            public void a(f.b<l> bVar, Throwable th) {
                CLog.b("HTTPLibrary", th.getMessage());
                if (i == 3333) {
                    if (i4 + 1 < i2) {
                        CLog.b("HTTPLibrary", " ### RETRY POST EVENTS " + (i4 + 1) + " st TIME OUT OF " + i2 + " ENTRIES ###");
                        HTTPLibrary.b(context, i, null, strA, jSONObject, progressDialog, i2, i3, i4 + 1, z, enumC0048a);
                    } else {
                        HTTPLibrary.c(progressDialog);
                        CLog.b("HTTPLibrary", "### INSERTING VALUES INTO DB AFTER 2 RETRY POLICY ###");
                        com.android.library.http.d.e.b("com.android.library.httplibrary.events.LAST_EVENT_DATA_POSTED", System.currentTimeMillis(), context);
                        if (z) {
                            CLog.b("HTTPLibrary", "Inserting json to db " + jSONObject.toString());
                            com.android.library.http.a.a.a(context).a(strA, jSONObject.toString(), enumC0048a);
                        }
                        if (com.android.library.http.d.c.a(context, HTTPLibraryAlarmSchedulingService.class)) {
                            CLog.b("HTTPLibrary", " ### ALARM IS NOT CREATED. ALREADY EXISTS ### ");
                        } else {
                            CLog.b("HTTPLibrary", " ### ALARM IS CREATED ### ");
                            HTTPLibrary.b(context, com.android.library.http.a.a.EnumC0048a.NORMAL);
                        }
                    }
                }
                HTTPLibrary.c(progressDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, com.android.library.http.a.a.EnumC0048a enumC0048a) {
        if (com.android.library.http.d.c.a(context, HTTPLibraryAlarmSchedulingService.class)) {
            return;
        }
        f2647a.a(context, enumC0048a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(ProgressDialog progressDialog) {
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        try {
            progressDialog.dismiss();
        } catch (IllegalArgumentException e2) {
            CLog.b("HTTPLibraryError", "Random Behaviour exception handled");
        }
    }

    public static void get(Context context, b bVar, int i, String str, String str2, ProgressDialog progressDialog) {
        get(context, bVar, i, str, str2, progressDialog, 10, (String) null);
    }

    public static void get(Context context, b bVar, int i, String str, String str2, ProgressDialog progressDialog, int i2) {
        a(context, bVar, i, str, str2, null, progressDialog, i2, null, false);
    }

    public static void get(Context context, b bVar, int i, String str, String str2, ProgressDialog progressDialog, int i2, String str3) {
        a(context, bVar, i, str, str2, null, progressDialog, i2, str3, false);
    }

    public static void get(Context context, b bVar, int i, String str, String str2, ProgressDialog progressDialog, int i2, String str3, boolean z) {
        a(context, bVar, i, str, str2, null, progressDialog, i2, str3, z);
    }

    public static void get(Context context, b bVar, int i, String str, String str2, ProgressDialog progressDialog, int i2, boolean z) {
        a(context, bVar, i, str, str2, null, progressDialog, i2, null, z);
    }

    public static void get(Context context, b bVar, int i, String str, String str2, ProgressDialog progressDialog, String str3) {
        get(context, bVar, i, str, str2, progressDialog, 10, str3);
    }

    public static void get(Context context, b bVar, int i, String str, String str2, ProgressDialog progressDialog, String str3, boolean z) {
        get(context, bVar, i, str, str2, progressDialog, 10, str3, z);
    }

    public static void get(Context context, b bVar, int i, String str, String str2, ProgressDialog progressDialog, boolean z) {
        get(context, bVar, i, str, str2, progressDialog, 10, null, z);
    }

    public static void post(Context context, b bVar, int i, String str, String str2, JSONObject jSONObject, ProgressDialog progressDialog) {
        post(context, bVar, i, str, str2, jSONObject, progressDialog, 10);
    }

    public static void post(Context context, b bVar, int i, String str, String str2, JSONObject jSONObject, ProgressDialog progressDialog, int i2) {
        a(context, bVar, i, str, str2, jSONObject, progressDialog, i2);
    }

    public static void postAnalyticsEvents(Context context, String str, JSONObject jSONObject, int i, int i2) {
        b(context, 3333, null, str, jSONObject, null, i, i2, 0, true, com.android.library.http.a.a.EnumC0048a.NORMAL);
    }

    public static void postAnalyticsEventsOnBatch(Context context, String str, JSONObject jSONObject, int i, int i2) {
        String strA = g.a(str);
        com.android.library.http.d.e.b("com.android.library.httplibrary.events.LAST_EVENT_BATCH_DATA_POSTED", System.currentTimeMillis(), context);
        com.android.library.http.d.d.b(context, jSONObject);
        CLog.b("HTTPLibrary", "Encrypted json before inserting into db for batch" + jSONObject.toString());
        com.android.library.http.a.a.a(context).a(strA, jSONObject.toString(), com.android.library.http.a.a.EnumC0048a.BATCH);
        b(context, com.android.library.http.a.a.EnumC0048a.BATCH);
    }

    public static void postGCM(Context context, final b bVar, final int i, String str, String str2, HashMap<String, String> map, int i2) {
        if (!g.c(str)) {
            CLog.d("HTTPLibraryError", "The Base URL cannot be empty and it should always end with slash ('/')");
            return;
        }
        if (!g.d(str2)) {
            CLog.d("HTTPLibraryError", "The Append URL can be a empty String but should not be 'null' and it should not start with slash ('/')");
            return;
        }
        String strA = g.a(str);
        String strB = g.b(str2);
        HTTPLibraryNetworkAPIService hTTPLibraryNetworkAPIService = (HTTPLibraryNetworkAPIService) a(context, strA, HTTPLibraryNetworkAPIService.class, i2, false);
        if (hTTPLibraryNetworkAPIService != null) {
            hTTPLibraryNetworkAPIService.postGCM(strB, map).a(new f.d<l>() { // from class: com.android.library.http.HTTPLibrary.1
                @Override // f.d
                public void a(f.b<l> bVar2, f.l<l> lVar) {
                    if (lVar.d()) {
                        bVar.onSuccess(i, lVar);
                    } else {
                        bVar.onError(i, lVar);
                    }
                }

                @Override // f.d
                public void a(f.b<l> bVar2, Throwable th) {
                    bVar.onFailure(th);
                }
            });
        } else {
            CLog.d("HTTPLibraryError", "The Base URL should always starts with HTTP or HTTPS URL");
        }
    }

    public static void uploadFile(Context context, final a aVar, final int i, final String str, final String str2, final String str3, final File file, final int i2, final String str4, final String str5) {
        if (com.android.library.http.d.c.a(context)) {
            com.android.library.http.c.b.a().execute(new Runnable() { // from class: com.android.library.http.HTTPLibrary.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.android.library.http.d.b bVar = new com.android.library.http.d.b(aVar, i, str + str2, i2);
                        bVar.a("user_id", str4);
                        bVar.a("extension", str5);
                        bVar.a(str3, file);
                        bVar.a();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            aVar.c(i, "No Internet connection", 601);
        }
    }
}
