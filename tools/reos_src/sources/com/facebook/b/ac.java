package com.facebook.b;

import android.net.Uri;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f3651a = ac.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3652b = f3651a + "_Redirect";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile n f3653c;

    ac() {
    }

    static Uri a(Uri uri) throws Throwable {
        InputStreamReader inputStreamReader;
        Throwable th;
        Uri uri2 = null;
        boolean z = false;
        if (uri != null) {
            String string = uri.toString();
            try {
                n nVarA = a();
                String string2 = string;
                InputStreamReader inputStreamReader2 = null;
                while (true) {
                    try {
                        InputStream inputStreamA = nVarA.a(string2, f3652b);
                        if (inputStreamA == null) {
                            break;
                        }
                        inputStreamReader = new InputStreamReader(inputStreamA);
                        try {
                            char[] cArr = new char[128];
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                int i = inputStreamReader.read(cArr, 0, cArr.length);
                                if (i <= 0) {
                                    break;
                                }
                                sb.append(cArr, 0, i);
                            }
                            ad.a(inputStreamReader);
                            string2 = sb.toString();
                            inputStreamReader2 = inputStreamReader;
                            z = true;
                        } catch (IOException e2) {
                        } catch (Throwable th2) {
                            th = th2;
                            ad.a(inputStreamReader);
                            throw th;
                        }
                    } catch (IOException e3) {
                        inputStreamReader = inputStreamReader2;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = inputStreamReader2;
                    }
                    ad.a(inputStreamReader);
                }
                if (z) {
                    uri2 = Uri.parse(string2);
                    ad.a(inputStreamReader2);
                } else {
                    ad.a(inputStreamReader2);
                }
            } catch (IOException e4) {
                inputStreamReader = null;
            } catch (Throwable th4) {
                inputStreamReader = null;
                th = th4;
            }
        }
        return uri2;
    }

    static synchronized n a() throws IOException {
        if (f3653c == null) {
            f3653c = new n(f3651a, new n.d());
        }
        return f3653c;
    }

    static void a(Uri uri, Uri uri2) throws Throwable {
        OutputStream outputStream;
        Throwable th;
        if (uri == null || uri2 == null) {
            return;
        }
        try {
            try {
                OutputStream outputStreamB = a().b(uri.toString(), f3652b);
                try {
                    outputStreamB.write(uri2.toString().getBytes());
                    ad.a(outputStreamB);
                } catch (Throwable th2) {
                    outputStream = outputStreamB;
                    th = th2;
                    ad.a(outputStream);
                    throw th;
                }
            } catch (IOException e2) {
                ad.a((Closeable) null);
            }
        } catch (Throwable th3) {
            outputStream = null;
            th = th3;
        }
    }
}
