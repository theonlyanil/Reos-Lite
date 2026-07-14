package d;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6371a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f6372b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f6375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f6376f;

    private u(String str, String str2, String str3, String str4) {
        this.f6373c = str;
        this.f6374d = str2;
        this.f6375e = str3;
        this.f6376f = str4;
    }

    public static u a(String str) {
        Matcher matcher = f6371a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f6372b.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                String strGroup2 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
                str2 = strGroup2;
            }
        }
        return new u(str, lowerCase, lowerCase2, str2);
    }

    public String a() {
        return this.f6374d;
    }

    public Charset a(Charset charset) {
        return this.f6376f != null ? Charset.forName(this.f6376f) : charset;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).f6373c.equals(this.f6373c);
    }

    public int hashCode() {
        return this.f6373c.hashCode();
    }

    public String toString() {
        return this.f6373c;
    }
}
