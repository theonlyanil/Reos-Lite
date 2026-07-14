package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.library.userprofile.util.Constants;
import com.facebook.b.ad;
import com.facebook.b.ae;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GraphRequest {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3516b;
    private static volatile String q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AccessToken f3518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s f3519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3520f;
    private JSONObject g;
    private String h;
    private String i;
    private boolean j;
    private Bundle k;
    private b l;
    private String m;
    private Object n;
    private String o;
    private boolean p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3515a = GraphRequest.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Pattern f3517c = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new Parcelable.Creator<ParcelableResourceWithMimeType>() { // from class: com.facebook.GraphRequest.ParcelableResourceWithMimeType.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
                return new ParcelableResourceWithMimeType(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ParcelableResourceWithMimeType[] newArray(int i) {
                return new ParcelableResourceWithMimeType[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RESOURCE f3529b;

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.f3528a = parcel.readString();
            this.f3529b = (RESOURCE) parcel.readParcelable(m.f().getClassLoader());
        }

        public String a() {
            return this.f3528a;
        }

        public RESOURCE b() {
            return this.f3529b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3528a);
            parcel.writeParcelable(this.f3529b, i);
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GraphRequest f3530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f3531b;

        public a(GraphRequest graphRequest, Object obj) {
            this.f3530a = graphRequest;
            this.f3531b = obj;
        }

        public GraphRequest a() {
            return this.f3530a;
        }

        public Object b() {
            return this.f3531b;
        }
    }

    public interface b {
        void a(r rVar);
    }

    public interface c {
        void a(JSONObject jSONObject, r rVar);
    }

    private interface d {
        void a(String str, String str2) throws IOException;
    }

    public interface e extends b {
        void a(long j, long j2);
    }

    private static class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OutputStream f3532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.facebook.b.v f3533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3534c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f3535d;

        public f(OutputStream outputStream, com.facebook.b.v vVar, boolean z) {
            this.f3535d = false;
            this.f3532a = outputStream;
            this.f3533b = vVar;
            this.f3535d = z;
        }

        private RuntimeException b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public void a() throws IOException {
            if (this.f3535d) {
                this.f3532a.write("&".getBytes());
            } else {
                b("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            }
        }

        public void a(String str, Bitmap bitmap) throws IOException {
            a(str, str, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.f3532a);
            b("", new Object[0]);
            a();
            if (this.f3533b != null) {
                this.f3533b.a("    " + str, (Object) "<Image>");
            }
        }

        public void a(String str, Uri uri, String str2) throws IOException {
            int iA;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            a(str, str, str2);
            if (this.f3532a instanceof y) {
                ((y) this.f3532a).a(ad.e(uri));
                iA = 0;
            } else {
                iA = ad.a(m.f().getContentResolver().openInputStream(uri), this.f3532a) + 0;
            }
            b("", new Object[0]);
            a();
            if (this.f3533b != null) {
                this.f3533b.a("    " + str, (Object) String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(iA)));
            }
        }

        public void a(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) throws IOException {
            int iA;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            a(str, str, str2);
            if (this.f3532a instanceof y) {
                ((y) this.f3532a).a(parcelFileDescriptor.getStatSize());
                iA = 0;
            } else {
                iA = ad.a((InputStream) new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.f3532a) + 0;
            }
            b("", new Object[0]);
            a();
            if (this.f3533b != null) {
                this.f3533b.a("    " + str, (Object) String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(iA)));
            }
        }

        public void a(String str, Object obj, GraphRequest graphRequest) throws IOException {
            if (this.f3532a instanceof ab) {
                ((ab) this.f3532a).a(graphRequest);
            }
            if (GraphRequest.e(obj)) {
                a(str, GraphRequest.f(obj));
                return;
            }
            if (obj instanceof Bitmap) {
                a(str, (Bitmap) obj);
                return;
            }
            if (obj instanceof byte[]) {
                a(str, (byte[]) obj);
                return;
            }
            if (obj instanceof Uri) {
                a(str, (Uri) obj, (String) null);
                return;
            }
            if (obj instanceof ParcelFileDescriptor) {
                a(str, (ParcelFileDescriptor) obj, (String) null);
                return;
            }
            if (!(obj instanceof ParcelableResourceWithMimeType)) {
                throw b();
            }
            ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
            Parcelable parcelableB = parcelableResourceWithMimeType.b();
            String strA = parcelableResourceWithMimeType.a();
            if (parcelableB instanceof ParcelFileDescriptor) {
                a(str, (ParcelFileDescriptor) parcelableB, strA);
            } else {
                if (!(parcelableB instanceof Uri)) {
                    throw b();
                }
                a(str, (Uri) parcelableB, strA);
            }
        }

        @Override // com.facebook.GraphRequest.d
        public void a(String str, String str2) throws IOException {
            a(str, (String) null, (String) null);
            b("%s", str2);
            a();
            if (this.f3533b != null) {
                this.f3533b.a("    " + str, (Object) str2);
            }
        }

        public void a(String str, String str2, String str3) throws IOException {
            if (this.f3535d) {
                this.f3532a.write(String.format("%s=", str).getBytes());
                return;
            }
            a("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                a("; filename=\"%s\"", str2);
            }
            b("", new Object[0]);
            if (str3 != null) {
                b("%s: %s", "Content-Type", str3);
            }
            b("", new Object[0]);
        }

        public void a(String str, JSONArray jSONArray, Collection<GraphRequest> collection) throws JSONException, IOException {
            if (!(this.f3532a instanceof ab)) {
                a(str, jSONArray.toString());
                return;
            }
            ab abVar = (ab) this.f3532a;
            a(str, (String) null, (String) null);
            a("[", new Object[0]);
            int i = 0;
            for (GraphRequest graphRequest : collection) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                abVar.a(graphRequest);
                if (i > 0) {
                    a(",%s", jSONObject.toString());
                } else {
                    a("%s", jSONObject.toString());
                }
                i++;
            }
            a("]", new Object[0]);
            if (this.f3533b != null) {
                this.f3533b.a("    " + str, (Object) jSONArray.toString());
            }
        }

        public void a(String str, byte[] bArr) throws IOException {
            a(str, str, "content/unknown");
            this.f3532a.write(bArr);
            b("", new Object[0]);
            a();
            if (this.f3533b != null) {
                this.f3533b.a("    " + str, (Object) String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(bArr.length)));
            }
        }

        public void a(String str, Object... objArr) throws IOException {
            if (this.f3535d) {
                this.f3532a.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
                return;
            }
            if (this.f3534c) {
                this.f3532a.write("--".getBytes());
                this.f3532a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                this.f3532a.write("\r\n".getBytes());
                this.f3534c = false;
            }
            this.f3532a.write(String.format(str, objArr).getBytes());
        }

        public void b(String str, Object... objArr) throws IOException {
            a(str, objArr);
            if (this.f3535d) {
                return;
            }
            a("\r\n", new Object[0]);
        }
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, s sVar, b bVar) {
        this(accessToken, str, bundle, sVar, bVar, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, s sVar, b bVar, String str2) {
        this.j = true;
        this.p = false;
        this.f3518d = accessToken;
        this.f3520f = str;
        this.o = str2;
        a(bVar);
        a(sVar);
        if (bundle != null) {
            this.k = new Bundle(bundle);
        } else {
            this.k = new Bundle();
        }
        if (this.o == null) {
            this.o = com.facebook.b.ab.d();
        }
    }

    public static GraphRequest a(AccessToken accessToken, final c cVar) {
        return new GraphRequest(accessToken, "me", null, null, new b() { // from class: com.facebook.GraphRequest.1
            @Override // com.facebook.GraphRequest.b
            public void a(r rVar) {
                if (cVar != null) {
                    cVar.a(rVar.b(), rVar);
                }
            }
        });
    }

    public static GraphRequest a(AccessToken accessToken, String str, b bVar) {
        return new GraphRequest(accessToken, str, null, null, bVar);
    }

    public static GraphRequest a(AccessToken accessToken, String str, JSONObject jSONObject, b bVar) {
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, s.POST, bVar);
        graphRequest.a(jSONObject);
        return graphRequest;
    }

    public static r a(GraphRequest graphRequest) {
        List<r> listA = a(graphRequest);
        if (listA == null || listA.size() != 1) {
            throw new k("invalid state: expected a single response");
        }
        return listA.get(0);
    }

    private String a(String str) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.k.keySet()) {
            Object obj = this.k.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (e(obj)) {
                builderBuildUpon.appendQueryParameter(str2, f(obj).toString());
            } else if (this.f3519e == s.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
            }
        }
        return builderBuildUpon.toString();
    }

    public static HttpURLConnection a(q qVar) {
        d(qVar);
        try {
            HttpURLConnection httpURLConnectionA = null;
            try {
                httpURLConnectionA = a(qVar.size() == 1 ? new URL(qVar.get(0).l()) : new URL(com.facebook.b.ab.b()));
                a(qVar, httpURLConnectionA);
                return httpURLConnectionA;
            } catch (IOException | JSONException e2) {
                ad.a(httpURLConnectionA);
                throw new k("could not construct request body", e2);
            }
        } catch (MalformedURLException e3) {
            throw new k("could not construct URL for request", e3);
        }
    }

    private static HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", p());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    public static List<r> a(HttpURLConnection httpURLConnection, q qVar) {
        List<r> listA = r.a(httpURLConnection, qVar);
        ad.a(httpURLConnection);
        int size = qVar.size();
        if (size != listA.size()) {
            throw new k(String.format(Locale.US, "Received %d responses while expecting %d", Integer.valueOf(listA.size()), Integer.valueOf(size)));
        }
        a(qVar, listA);
        com.facebook.b.a().d();
        return listA;
    }

    public static List<r> a(Collection<GraphRequest> collection) {
        return b(new q(collection));
    }

    public static List<r> a(GraphRequest... graphRequestArr) {
        ae.a(graphRequestArr, "requests");
        return a((Collection<GraphRequest>) Arrays.asList(graphRequestArr));
    }

    private static void a(Bundle bundle, f fVar, GraphRequest graphRequest) throws IOException {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (e(obj)) {
                fVar.a(str, obj, graphRequest);
            }
        }
    }

    private static void a(f fVar, Collection<GraphRequest> collection, Map<String, a> map) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        Iterator<GraphRequest> it = collection.iterator();
        while (it.hasNext()) {
            it.next().a(jSONArray, map);
        }
        fVar.a("batch", jSONArray, collection);
    }

    private static void a(q qVar, com.facebook.b.v vVar, int i, URL url, OutputStream outputStream, boolean z) throws JSONException, IOException {
        f fVar = new f(outputStream, vVar, z);
        if (i != 1) {
            String strG = g(qVar);
            if (ad.a(strG)) {
                throw new k("App ID was not specified at the request or Settings.");
            }
            fVar.a("batch_app_id", strG);
            HashMap map = new HashMap();
            a(fVar, qVar, map);
            if (vVar != null) {
                vVar.c("  Attachments:\n");
            }
            a(map, fVar);
            return;
        }
        GraphRequest graphRequestA = qVar.get(0);
        HashMap map2 = new HashMap();
        for (String str : graphRequestA.k.keySet()) {
            Object obj = graphRequestA.k.get(str);
            if (d(obj)) {
                map2.put(str, new a(graphRequestA, obj));
            }
        }
        if (vVar != null) {
            vVar.c("  Parameters:\n");
        }
        a(graphRequestA.k, fVar, graphRequestA);
        if (vVar != null) {
            vVar.c("  Attachments:\n");
        }
        a(map2, fVar);
        if (graphRequestA.g != null) {
            a(graphRequestA.g, url.getPath(), fVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00c4  */
    static final void a(q qVar, HttpURLConnection httpURLConnection) throws Throwable {
        OutputStream bufferedOutputStream;
        OutputStream zVar;
        com.facebook.b.v vVar = new com.facebook.b.v(u.REQUESTS, "Request");
        int size = qVar.size();
        boolean zF = f(qVar);
        s sVar = size == 1 ? qVar.get(0).f3519e : s.POST;
        httpURLConnection.setRequestMethod(sVar.name());
        a(httpURLConnection, zF);
        URL url = httpURLConnection.getURL();
        vVar.c("Request:\n");
        vVar.a("Id", (Object) qVar.b());
        vVar.a("URL", url);
        vVar.a("Method", (Object) httpURLConnection.getRequestMethod());
        vVar.a("User-Agent", (Object) httpURLConnection.getRequestProperty("User-Agent"));
        vVar.a("Content-Type", (Object) httpURLConnection.getRequestProperty("Content-Type"));
        httpURLConnection.setConnectTimeout(qVar.a());
        httpURLConnection.setReadTimeout(qVar.a());
        if (!(sVar == s.POST)) {
            vVar.a();
            return;
        }
        httpURLConnection.setDoOutput(true);
        try {
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            if (zF) {
                try {
                    bufferedOutputStream = new GZIPOutputStream(bufferedOutputStream);
                } catch (Throwable th) {
                    th = th;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            }
            if (e(qVar)) {
                y yVar = new y(qVar.c());
                a(qVar, null, size, url, yVar, zF);
                zVar = new z(bufferedOutputStream, qVar, yVar.b(), yVar.a());
            } else {
                zVar = bufferedOutputStream;
            }
            try {
                a(qVar, vVar, size, url, zVar, zF);
                if (zVar != null) {
                    zVar.close();
                }
                vVar.a();
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = zVar;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    static void a(final q qVar, List<r> list) {
        int size = qVar.size();
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            GraphRequest graphRequestA = qVar.get(i);
            if (graphRequestA.l != null) {
                arrayList.add(new Pair(graphRequestA.l, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            Runnable runnable = new Runnable() { // from class: com.facebook.GraphRequest.3
                @Override // java.lang.Runnable
                public void run() {
                    for (Pair pair : arrayList) {
                        ((b) pair.first).a((r) pair.second);
                    }
                    Iterator<q.a> it = qVar.e().iterator();
                    while (it.hasNext()) {
                        it.next().a(qVar);
                    }
                }
            };
            Handler handlerC = qVar.c();
            if (handlerC == null) {
                runnable.run();
            } else {
                handlerC.post(runnable);
            }
        }
    }

    private static void a(String str, Object obj, d dVar, boolean z) throws IOException {
        Class<?> cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    a(String.format("%s[%s]", str, next), jSONObject.opt(next), dVar, z);
                }
                return;
            }
            if (jSONObject.has("id")) {
                a(str, jSONObject.optString("id"), dVar, z);
                return;
            } else if (jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
                a(str, jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL), dVar, z);
                return;
            } else {
                if (jSONObject.has("fbsdk:create_object")) {
                    a(str, jSONObject.toString(), dVar, z);
                    return;
                }
                return;
            }
        }
        if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                a(String.format(Locale.ROOT, "%s[%d]", str, Integer.valueOf(i)), jSONArray.opt(i), dVar, z);
            }
            return;
        }
        if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            dVar.a(str, obj.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            dVar.a(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj));
        }
    }

    private static void a(HttpURLConnection httpURLConnection, boolean z) {
        if (!z) {
            httpURLConnection.setRequestProperty("Content-Type", o());
        } else {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        }
    }

    private static void a(Map<String, a> map, f fVar) throws IOException {
        for (String str : map.keySet()) {
            a aVar = map.get(str);
            if (d(aVar.b())) {
                fVar.a(str, aVar.b(), aVar.a());
            }
        }
    }

    private void a(JSONArray jSONArray, Map<String, a> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        if (this.h != null) {
            jSONObject.put("name", this.h);
            jSONObject.put("omit_response_on_success", this.j);
        }
        if (this.i != null) {
            jSONObject.put("depends_on", this.i);
        }
        String strK = k();
        jSONObject.put("relative_url", strK);
        jSONObject.put("method", this.f3519e);
        if (this.f3518d != null) {
            com.facebook.b.v.a(this.f3518d.b());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.k.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.k.get(it.next());
            if (d(obj)) {
                String str = String.format(Locale.ROOT, "%s%d", "file", Integer.valueOf(map.size()));
                arrayList.add(str);
                map.put(str, new a(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.g != null) {
            final ArrayList arrayList2 = new ArrayList();
            a(this.g, strK, new d() { // from class: com.facebook.GraphRequest.4
                @Override // com.facebook.GraphRequest.d
                public void a(String str2, String str3) throws IOException {
                    arrayList2.add(String.format(Locale.US, "%s=%s", str2, URLEncoder.encode(str3, "UTF-8")));
                }
            });
            jSONObject.put(Constants.SMS_COLUMN_BODY, TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    private static void a(JSONObject jSONObject, String str, d dVar) throws IOException {
        boolean z;
        if (b(str)) {
            int iIndexOf = str.indexOf(":");
            int iIndexOf2 = str.indexOf("?");
            z = iIndexOf > 3 && (iIndexOf2 == -1 || iIndexOf < iIndexOf2);
        } else {
            z = false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            a(next, jSONObject.opt(next), dVar, z && next.equalsIgnoreCase("image"));
        }
    }

    public static p b(Collection<GraphRequest> collection) {
        return c(new q(collection));
    }

    public static p b(GraphRequest... graphRequestArr) {
        ae.a(graphRequestArr, "requests");
        return b((Collection<GraphRequest>) Arrays.asList(graphRequestArr));
    }

    public static List<r> b(q qVar) {
        List<r> listA;
        HttpURLConnection httpURLConnectionA = null;
        ae.c(qVar, "requests");
        try {
            httpURLConnectionA = a(qVar);
            listA = a(httpURLConnectionA, qVar);
        } catch (Exception e2) {
            listA = r.a(qVar.d(), (HttpURLConnection) null, new k(e2));
            a(qVar, listA);
        } finally {
            ad.a(httpURLConnectionA);
        }
        return listA;
    }

    static final boolean b(GraphRequest graphRequest) {
        String strD = graphRequest.d();
        if (ad.a(strD)) {
            return true;
        }
        if (strD.startsWith("v")) {
            strD = strD.substring(1);
        }
        String[] strArrSplit = strD.split("\\.");
        return (strArrSplit.length >= 2 && Integer.parseInt(strArrSplit[0]) > 2) || (Integer.parseInt(strArrSplit[0]) >= 2 && Integer.parseInt(strArrSplit[1]) >= 4);
    }

    private static boolean b(String str) {
        Matcher matcher = f3517c.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        return str.startsWith("me/") || str.startsWith("/me/");
    }

    public static p c(q qVar) {
        ae.c(qVar, "requests");
        p pVar = new p(qVar);
        pVar.executeOnExecutor(m.d(), new Void[0]);
        return pVar;
    }

    static final void d(q qVar) {
        for (GraphRequest graphRequest : qVar) {
            if (s.GET.equals(graphRequest.c()) && b(graphRequest)) {
                Bundle bundleE = graphRequest.e();
                if (!bundleE.containsKey("fields") || ad.a(bundleE.getString("fields"))) {
                    com.facebook.b.v.a(u.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", graphRequest.b());
                }
            }
        }
    }

    private static boolean d(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    private static boolean e(q qVar) {
        Iterator<q.a> it = qVar.e().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof q.b) {
                return true;
            }
        }
        Iterator<GraphRequest> it2 = qVar.iterator();
        while (it2.hasNext()) {
            if (it2.next().g() instanceof e) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    private static boolean f(q qVar) {
        for (GraphRequest graphRequest : qVar) {
            Iterator<String> it = graphRequest.k.keySet().iterator();
            while (it.hasNext()) {
                if (d(graphRequest.k.get(it.next()))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String g(q qVar) {
        String strH;
        if (!ad.a(qVar.f())) {
            return qVar.f();
        }
        Iterator<GraphRequest> it = qVar.iterator();
        while (it.hasNext()) {
            AccessToken accessToken = it.next().f3518d;
            if (accessToken != null && (strH = accessToken.h()) != null) {
                return strH;
            }
        }
        return !ad.a(f3516b) ? f3516b : m.i();
    }

    private void m() {
        if (this.f3518d != null) {
            if (!this.k.containsKey("access_token")) {
                String strB = this.f3518d.b();
                com.facebook.b.v.a(strB);
                this.k.putString("access_token", strB);
            }
        } else if (!this.p && !this.k.containsKey("access_token")) {
            String strI = m.i();
            String strK = m.k();
            if (ad.a(strI) || ad.a(strK)) {
                Log.d(f3515a, "Warning: Request without access token missing application ID or client token.");
            } else {
                this.k.putString("access_token", strI + "|" + strK);
            }
        }
        this.k.putString("sdk", "android");
        this.k.putString("format", "json");
        if (m.a(u.GRAPH_API_DEBUG_INFO)) {
            this.k.putString("debug", "info");
        } else if (m.a(u.GRAPH_API_DEBUG_WARNING)) {
            this.k.putString("debug", "warning");
        }
    }

    private String n() {
        return f3517c.matcher(this.f3520f).matches() ? this.f3520f : String.format("%s/%s", this.o, this.f3520f);
    }

    private static String o() {
        return String.format("multipart/form-data; boundary=%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    }

    private static String p() {
        if (q == null) {
            q = String.format("%s.%s", "FBAndroidSDK", "4.15.0");
            String strA = com.facebook.b.t.a();
            if (!ad.a(strA)) {
                q = String.format(Locale.ROOT, "%s/%s", q, strA);
            }
        }
        return q;
    }

    public final JSONObject a() {
        return this.g;
    }

    public final void a(Bundle bundle) {
        this.k = bundle;
    }

    public final void a(final b bVar) {
        if (m.a(u.GRAPH_API_DEBUG_INFO) || m.a(u.GRAPH_API_DEBUG_WARNING)) {
            this.l = new b() { // from class: com.facebook.GraphRequest.2
                @Override // com.facebook.GraphRequest.b
                public void a(r rVar) {
                    JSONObject jSONObjectB = rVar.b();
                    JSONObject jSONObjectOptJSONObject = jSONObjectB != null ? jSONObjectB.optJSONObject("__debug__") : null;
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONArray("messages") : null;
                    if (jSONArrayOptJSONArray != null) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                            String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("message") : null;
                            String strOptString2 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString(Constants.SMS_COLUMN_TYPE) : null;
                            String strOptString3 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("link") : null;
                            if (strOptString != null && strOptString2 != null) {
                                u uVar = u.GRAPH_API_DEBUG_INFO;
                                if (strOptString2.equals("warning")) {
                                    uVar = u.GRAPH_API_DEBUG_WARNING;
                                }
                                if (!ad.a(strOptString3)) {
                                    strOptString = strOptString + " Link: " + strOptString3;
                                }
                                com.facebook.b.v.a(uVar, GraphRequest.f3515a, strOptString);
                            }
                        }
                    }
                    if (bVar != null) {
                        bVar.a(rVar);
                    }
                }
            };
        } else {
            this.l = bVar;
        }
    }

    public final void a(s sVar) {
        if (this.m != null && sVar != s.GET) {
            throw new k("Can't change HTTP method on request with overridden URL.");
        }
        if (sVar == null) {
            sVar = s.GET;
        }
        this.f3519e = sVar;
    }

    public final void a(Object obj) {
        this.n = obj;
    }

    public final void a(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public final void a(boolean z) {
        this.p = z;
    }

    public final String b() {
        return this.f3520f;
    }

    public final s c() {
        return this.f3519e;
    }

    public final String d() {
        return this.o;
    }

    public final Bundle e() {
        return this.k;
    }

    public final AccessToken f() {
        return this.f3518d;
    }

    public final b g() {
        return this.l;
    }

    public final Object h() {
        return this.n;
    }

    public final r i() {
        return a(this);
    }

    public final p j() {
        return b(this);
    }

    final String k() {
        if (this.m != null) {
            throw new k("Can't override URL for a batch request");
        }
        String str = String.format("%s/%s", com.facebook.b.ab.b(), n());
        m();
        Uri uri = Uri.parse(a(str));
        return String.format("%s?%s", uri.getPath(), uri.getQuery());
    }

    final String l() {
        if (this.m != null) {
            return this.m.toString();
        }
        String str = String.format("%s/%s", (c() == s.POST && this.f3520f != null && this.f3520f.endsWith("/videos")) ? com.facebook.b.ab.c() : com.facebook.b.ab.b(), n());
        m();
        return a(str);
    }

    public String toString() {
        return "{Request:  accessToken: " + (this.f3518d == null ? "null" : this.f3518d) + ", graphPath: " + this.f3520f + ", graphObject: " + this.g + ", httpMethod: " + this.f3519e + ", parameters: " + this.k + "}";
    }
}
