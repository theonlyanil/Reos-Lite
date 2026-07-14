package com.google.android.gms.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public abstract class UrlTileProvider implements TileProvider {
    private final int zzov;
    private final int zzow;

    public UrlTileProvider(int i, int i2) {
        this.zzov = i;
        this.zzow = i2;
    }

    private static long zza(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    private static byte[] zzl(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zza(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return NO_TILE;
        }
        try {
            return new Tile(this.zzov, this.zzow, zzl(tileUrl.openStream()));
        } catch (IOException e2) {
            return null;
        }
    }

    public abstract URL getTileUrl(int i, int i2, int i3);
}
