package com.google.android.gms.common.images;

/* JADX INFO: loaded from: classes.dex */
public final class Size {
    private final int zzov;
    private final int zzow;

    public Size(int i, int i2) {
        this.zzov = i;
        this.zzow = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int iIndexOf = str.indexOf(42);
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(120);
        }
        if (iIndexOf < 0) {
            throw zzcw(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (NumberFormatException e2) {
            throw zzcw(str);
        }
    }

    private static NumberFormatException zzcw(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzov == size.zzov && this.zzow == size.zzow;
    }

    public int getHeight() {
        return this.zzow;
    }

    public int getWidth() {
        return this.zzov;
    }

    public int hashCode() {
        return this.zzow ^ ((this.zzov << 16) | (this.zzov >>> 16));
    }

    public String toString() {
        return this.zzov + "x" + this.zzow;
    }
}
