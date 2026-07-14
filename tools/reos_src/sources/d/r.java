package d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f6350a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f6351a = new ArrayList(20);

        private void d(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        a a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            return str.startsWith(":") ? b("", str.substring(1)) : b("", str);
        }

        public a a(String str, String str2) {
            d(str, str2);
            return b(str, str2);
        }

        public r a() {
            return new r(this);
        }

        public a b(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f6351a.size()) {
                    return this;
                }
                if (str.equalsIgnoreCase(this.f6351a.get(i2))) {
                    this.f6351a.remove(i2);
                    this.f6351a.remove(i2);
                    i2 -= 2;
                }
                i = i2 + 2;
            }
        }

        a b(String str, String str2) {
            this.f6351a.add(str);
            this.f6351a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            d(str, str2);
            b(str);
            b(str, str2);
            return this;
        }
    }

    private r(a aVar) {
        this.f6350a = (String[]) aVar.f6351a.toArray(new String[aVar.f6351a.size()]);
    }

    private r(String[] strArr) {
        this.f6350a = strArr;
    }

    public static r a(String... strArr) {
        if (strArr == null || strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new r(strArr2);
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public int a() {
        return this.f6350a.length / 2;
    }

    public String a(int i) {
        return this.f6350a[i * 2];
    }

    public String a(String str) {
        return a(this.f6350a, str);
    }

    public a b() {
        a aVar = new a();
        Collections.addAll(aVar.f6351a, this.f6350a);
        return aVar;
    }

    public String b(int i) {
        return this.f6350a[(i * 2) + 1];
    }

    public Date b(String str) {
        String strA = a(str);
        if (strA != null) {
            return d.a.b.f.a(strA);
        }
        return null;
    }

    public List<String> c(String str) {
        int iA = a();
        ArrayList arrayList = null;
        for (int i = 0; i < iA; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iA = a();
        for (int i = 0; i < iA; i++) {
            sb.append(a(i)).append(": ").append(b(i)).append("\n");
        }
        return sb.toString();
    }
}
