package d.a;

import d.ad;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<ad> f6217a = new LinkedHashSet();

    public synchronized void a(ad adVar) {
        this.f6217a.add(adVar);
    }

    public synchronized void b(ad adVar) {
        this.f6217a.remove(adVar);
    }

    public synchronized boolean c(ad adVar) {
        return this.f6217a.contains(adVar);
    }
}
