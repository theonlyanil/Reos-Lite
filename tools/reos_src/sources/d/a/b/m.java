package d.a.b;

import d.s;
import d.z;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static String a(s sVar) {
        String strH = sVar.h();
        String strK = sVar.k();
        return strK != null ? strH + '?' + strK : strH;
    }

    static String a(z zVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(zVar.b());
        sb.append(' ');
        if (b(zVar, type)) {
            sb.append(zVar.a());
        } else {
            sb.append(a(zVar.a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(z zVar, Proxy.Type type) {
        return !zVar.g() && type == Proxy.Type.HTTP;
    }
}
