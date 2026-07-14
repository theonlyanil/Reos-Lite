package com.facebook.b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3825a = x.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f3826b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UUID f3827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f3828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f3829c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap f3830d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Uri f3831e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f3832f;
        private boolean g;

        private a(UUID uuid, Bitmap bitmap, Uri uri) {
            this.f3827a = uuid;
            this.f3830d = bitmap;
            this.f3831e = uri;
            if (uri != null) {
                String scheme = uri.getScheme();
                if ("content".equalsIgnoreCase(scheme)) {
                    this.f3832f = true;
                    this.g = (uri.getAuthority() == null || uri.getAuthority().startsWith("media")) ? false : true;
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    this.g = true;
                } else if (!ad.b(uri)) {
                    throw new com.facebook.k("Unsupported scheme for media Uri : " + scheme);
                }
            } else {
                if (bitmap == null) {
                    throw new com.facebook.k("Cannot share media without a bitmap or Uri set");
                }
                this.g = true;
            }
            this.f3829c = !this.g ? null : UUID.randomUUID().toString();
            this.f3828b = !this.g ? this.f3831e.toString() : com.facebook.i.a(com.facebook.m.i(), uuid, this.f3829c);
        }

        public String a() {
            return this.f3828b;
        }
    }

    private x() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a a(UUID uuid, Bitmap bitmap) {
        ae.a(uuid, "callId");
        ae.a(bitmap, "attachmentBitmap");
        return new a(uuid, bitmap, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a a(UUID uuid, Uri uri) {
        ae.a(uuid, "callId");
        ae.a(uri, "attachmentUri");
        return new a(uuid, null, uri);
    }

    static synchronized File a() {
        if (f3826b == null) {
            f3826b = new File(com.facebook.m.f().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
        }
        return f3826b;
    }

    public static File a(UUID uuid, String str) throws FileNotFoundException {
        if (ad.a(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return a(uuid, str, false);
        } catch (IOException e2) {
            throw new FileNotFoundException();
        }
    }

    static File a(UUID uuid, String str, boolean z) throws IOException {
        File fileA = a(uuid, z);
        if (fileA == null) {
            return null;
        }
        try {
            return new File(fileA, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    static File a(UUID uuid, boolean z) {
        if (f3826b == null) {
            return null;
        }
        File file = new File(f3826b, uuid.toString());
        if (!z || file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    private static void a(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            ad.a(fileOutputStream);
        }
    }

    private static void a(Uri uri, boolean z, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            ad.a(!z ? new FileInputStream(uri.getPath()) : com.facebook.m.f().getContentResolver().openInputStream(uri), (OutputStream) fileOutputStream);
            ad.a(fileOutputStream);
        } catch (Throwable th) {
            ad.a(fileOutputStream);
            throw th;
        }
    }

    public static void a(Collection<a> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        if (f3826b == null) {
            c();
        }
        b();
        ArrayList arrayList = new ArrayList();
        try {
            for (a aVar : collection) {
                if (aVar.g) {
                    File fileA = a(aVar.f3827a, aVar.f3829c, true);
                    arrayList.add(fileA);
                    if (aVar.f3830d != null) {
                        a(aVar.f3830d, fileA);
                    } else if (aVar.f3831e != null) {
                        a(aVar.f3831e, aVar.f3832f, fileA);
                    }
                }
            }
        } catch (IOException e2) {
            Log.e(f3825a, "Got unexpected exception:" + e2);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((File) it.next()).delete();
                } catch (Exception e3) {
                }
            }
            throw new com.facebook.k(e2);
        }
    }

    public static void a(UUID uuid) {
        File fileA = a(uuid, false);
        if (fileA != null) {
            ad.a(fileA);
        }
    }

    static File b() {
        File fileA = a();
        fileA.mkdirs();
        return fileA;
    }

    public static void c() {
        ad.a(a());
    }
}
