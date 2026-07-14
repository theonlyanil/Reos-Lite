package d.a.b;

import d.x;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f6170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6172c;

    public q(x xVar, int i, String str) {
        this.f6170a = xVar;
        this.f6171b = i;
        this.f6172c = str;
    }

    public static q a(String str) throws IOException {
        x xVar;
        String strSubstring;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                xVar = x.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                xVar = x.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            xVar = x.HTTP_1_0;
            i = 4;
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i2 = Integer.parseInt(str.substring(i, i + 3));
            if (str.length() <= i + 3) {
                strSubstring = "";
            } else {
                if (str.charAt(i + 3) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i + 4);
            }
            return new q(xVar, i2, strSubstring);
        } catch (NumberFormatException e2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6170a == x.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ').append(this.f6171b);
        if (this.f6172c != null) {
            sb.append(' ').append(this.f6172c);
        }
        return sb.toString();
    }
}
