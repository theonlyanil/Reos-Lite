package e;

import com.flurry.android.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f6444a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f6445b = a(new byte[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final byte[] f6446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient int f6447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    transient String f6448e;

    f(byte[] bArr) {
        this.f6446c = bArr;
    }

    public static f a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        return new f(bArr);
    }

    public static f a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(v.f6494a));
        fVar.f6448e = str;
        return fVar;
    }

    public static f a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new f((byte[]) bArr.clone());
    }

    public static f b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrA = b.a(str);
        if (bArrA != null) {
            return new f(bArrA);
        }
        return null;
    }

    private f c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f6446c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        f fVarA = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = f.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, fVarA.f6446c);
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        } catch (NoSuchFieldException e3) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f6446c.length);
        objectOutputStream.write(this.f6446c);
    }

    public byte a(int i) {
        return this.f6446c[i];
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int iF = f();
        int iF2 = fVar.f();
        int iMin = Math.min(iF, iF2);
        for (int i = 0; i < iMin; i++) {
            int iA = a(i) & Constants.UNKNOWN;
            int iA2 = fVar.a(i) & Constants.UNKNOWN;
            if (iA != iA2) {
                return iA < iA2 ? -1 : 1;
            }
        }
        if (iF == iF2) {
            return 0;
        }
        return iF >= iF2 ? 1 : -1;
    }

    public String a() {
        String str = this.f6448e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f6446c, v.f6494a);
        this.f6448e = str2;
        return str2;
    }

    void a(c cVar) {
        cVar.c(this.f6446c, 0, this.f6446c.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i <= this.f6446c.length - i3 && i2 <= bArr.length - i3 && v.a(this.f6446c, i, bArr, i2, i3);
    }

    public String b() {
        return b.a(this.f6446c);
    }

    public f c() {
        return c("MD5");
    }

    public String d() {
        char[] cArr = new char[this.f6446c.length * 2];
        int i = 0;
        for (byte b2 : this.f6446c) {
            int i2 = i + 1;
            cArr[i] = f6444a[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f6444a[b2 & 15];
        }
        return new String(cArr);
    }

    public f e() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f6446c.length) {
                return this;
            }
            byte b2 = this.f6446c[i2];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr = (byte[]) this.f6446c.clone();
                bArr[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                    byte b3 = bArr[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr[i3] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr);
            }
            i = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof f) && ((f) obj).f() == this.f6446c.length && ((f) obj).a(0, this.f6446c, 0, this.f6446c.length);
    }

    public int f() {
        return this.f6446c.length;
    }

    public byte[] g() {
        return (byte[]) this.f6446c.clone();
    }

    public int hashCode() {
        int i = this.f6447d;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.f6446c);
        this.f6447d = iHashCode;
        return iHashCode;
    }

    public String toString() {
        if (this.f6446c.length == 0) {
            return "ByteString[size=0]";
        }
        return this.f6446c.length <= 16 ? String.format("ByteString[size=%s data=%s]", Integer.valueOf(this.f6446c.length), d()) : String.format("ByteString[size=%s md5=%s]", Integer.valueOf(this.f6446c.length), c().d());
    }
}
