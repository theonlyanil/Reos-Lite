package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public class jy extends MessageDigest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CRC32 f4540a;

    public jy() {
        super("CRC");
        this.f4540a = new CRC32();
    }

    public byte[] a() {
        return engineDigest();
    }

    public int b() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }

    @Override // java.security.MessageDigestSpi
    protected byte[] engineDigest() {
        long value = this.f4540a.getValue();
        return new byte[]{(byte) (((-16777216) & value) >> 24), (byte) ((16711680 & value) >> 16), (byte) ((65280 & value) >> 8), (byte) ((value & 255) >> 0)};
    }

    @Override // java.security.MessageDigestSpi
    protected void engineReset() {
        this.f4540a.reset();
    }

    @Override // java.security.MessageDigestSpi
    protected void engineUpdate(byte b2) {
        this.f4540a.update(b2);
    }

    @Override // java.security.MessageDigestSpi
    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.f4540a.update(bArr, i, i2);
    }
}
