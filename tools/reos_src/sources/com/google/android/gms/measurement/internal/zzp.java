package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.location.places.Place;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes.dex */
public class zzp extends zzw {

    interface zza {
        void zza(int i, Throwable th, byte[] bArr);
    }

    private static class zzb implements Runnable {
        private final int zzAk;
        private final zza zzaTv;
        private final Throwable zzaTw;
        private final byte[] zzaTx;

        private zzb(zza zzaVar, int i, Throwable th, byte[] bArr) {
            this.zzaTv = zzaVar;
            this.zzAk = i;
            this.zzaTw = th;
            this.zzaTx = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.zzaTv.zza(this.zzAk, this.zzaTw, this.zzaTx);
        }
    }

    private class zzc implements Runnable {
        private final byte[] zzaTy;
        private final zza zzaTz;
        private final URL zzyR;

        public zzc(URL url, byte[] bArr, zza zzaVar) {
            this.zzyR = url;
            this.zzaTy = bArr;
            this.zzaTz = zzaVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Throwable th;
            HttpURLConnection httpURLConnectionZzc;
            OutputStream outputStream;
            int i;
            Throwable th2 = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            zzp.this.zzAR();
            int responseCode = 0;
            try {
                byte[] bArrZzg = zzp.this.zzAU().zzg(this.zzaTy);
                httpURLConnectionZzc = zzp.this.zzc(this.zzyR);
                try {
                    httpURLConnectionZzc.setDoOutput(true);
                    httpURLConnectionZzc.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnectionZzc.setFixedLengthStreamingMode(bArrZzg.length);
                    httpURLConnectionZzc.connect();
                    outputStream = httpURLConnectionZzc.getOutputStream();
                    try {
                        outputStream.write(bArrZzg);
                        outputStream.close();
                        OutputStream outputStream2 = null;
                        responseCode = httpURLConnectionZzc.getResponseCode();
                        byte[] bArrZzc = zzp.this.zzc(httpURLConnectionZzc);
                        if (0 != 0) {
                            try {
                                outputStream2.close();
                            } catch (IOException e2) {
                                zzp.this.zzzz().zzBl().zzj("Error closing HTTP compressed POST connection output stream", e2);
                            }
                        }
                        if (httpURLConnectionZzc != null) {
                            httpURLConnectionZzc.disconnect();
                        }
                        zzp.this.zzAV().zzg(new zzb(this.zzaTz, responseCode, th2, bArrZzc));
                    } catch (IOException e3) {
                        e = e3;
                        i = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                                zzp.this.zzzz().zzBl().zzj("Error closing HTTP compressed POST connection output stream", e4);
                            }
                        }
                        if (httpURLConnectionZzc != null) {
                            httpURLConnectionZzc.disconnect();
                        }
                        zzp.this.zzAV().zzg(new zzb(this.zzaTz, i, e, objArr5 == true ? 1 : 0));
                    } catch (Throwable th3) {
                        th = th3;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                                zzp.this.zzzz().zzBl().zzj("Error closing HTTP compressed POST connection output stream", e5);
                            }
                        }
                        if (httpURLConnectionZzc != null) {
                            httpURLConnectionZzc.disconnect();
                        }
                        zzp.this.zzAV().zzg(new zzb(this.zzaTz, responseCode, objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0));
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    i = responseCode;
                    outputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = null;
                }
            } catch (IOException e7) {
                e = e7;
                i = 0;
                outputStream = null;
                httpURLConnectionZzc = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnectionZzc = null;
                outputStream = null;
            }
        }
    }

    public zzp(zzt zztVar) {
        super(zztVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] zzc(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[Place.TYPE_SUBLOCALITY_LEVEL_2];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ void zzAR() {
        super.zzAR();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ com.google.android.gms.measurement.internal.zzc zzAX() {
        return super.zzAX();
    }

    public void zza(URL url, byte[] bArr, zza zzaVar) {
        zziS();
        zzje();
        com.google.android.gms.common.internal.zzx.zzy(url);
        com.google.android.gms.common.internal.zzx.zzy(bArr);
        com.google.android.gms.common.internal.zzx.zzy(zzaVar);
        zzAV().zzh(new zzc(url, bArr, zzaVar));
    }

    protected HttpURLConnection zzc(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout((int) zzAX().zzAB());
        httpURLConnection.setReadTimeout((int) zzAX().zzAC());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ void zziS() {
        super.zziS();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    @Override // com.google.android.gms.measurement.internal.zzw
    protected void zzir() {
    }

    public boolean zzlk() {
        NetworkInfo activeNetworkInfo;
        zzje();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e2) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.google.android.gms.measurement.internal.zzv
    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
