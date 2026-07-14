package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ii extends ks<ij> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f4302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4303b = ii.class.getSimpleName();

    public ii() {
        a(30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ik ikVar, ij ijVar) {
        kg.a(3, f4303b, ijVar.m() + " report sent successfully to : " + ijVar.i());
        im.a().a(ikVar);
        c(ijVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ik ikVar, ij ijVar, kn<?, ?> knVar) {
        String strB = null;
        List<String> listB = knVar.b("Location");
        if (listB != null && listB.size() > 0) {
            strB = ma.b(listB.get(0), ijVar.s());
        }
        boolean zA = im.a().a(ikVar, strB);
        if (zA) {
            kg.a(3, f4303b, "Received redirect url. Retrying: " + strB);
        } else {
            kg.a(3, f4303b, "Received redirect url. Retrying: false");
        }
        if (!zA) {
            c(ijVar);
            return;
        }
        ijVar.c(strB);
        knVar.a(strB);
        knVar.c("Location");
        jq.a().a(this, knVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ik ikVar, ij ijVar, String str) {
        boolean zB = im.a().b(ikVar, str);
        kg.a(3, f4303b, "Failed report retrying: " + zB);
        if (zB) {
            d(ijVar);
        } else {
            c(ijVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ik ikVar, ij ijVar) {
        im.a().b(ikVar);
        c(ijVar);
    }

    @Override // com.flurry.sdk.ks
    protected jz<List<ij>> a() {
        return new jz<>(js.a().c().getFileStreamPath(".yflurryanpulsecallbackreporter"), ".yflurryanpulsecallbackreporter", 2, new le<List<ij>>() { // from class: com.flurry.sdk.ii.1
            @Override // com.flurry.sdk.le
            public lb<List<ij>> a(int i) {
                return new la(new ij.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.ks
    public void a(final ij ijVar) {
        kg.a(3, f4303b, "Sending next pulse report to " + ijVar.i() + " at: " + ijVar.t());
        long jD = je.a().d();
        if (jD == 0) {
            jD = f4302a;
        }
        long jG = je.a().g();
        if (jG == 0) {
            jG = System.currentTimeMillis() - jD;
        }
        final ik ikVar = new ik(ijVar, jD, jG, ijVar.r());
        kn knVar = new kn();
        knVar.a(ijVar.t());
        knVar.d(100000);
        if (ijVar.f().equals(iq.POST)) {
            knVar.a((lb) new kx());
            if (ijVar.l() != null) {
                knVar.a(ijVar.l().getBytes());
            }
            knVar.a(kp.a.kPost);
        } else {
            knVar.a(kp.a.kGet);
        }
        knVar.a(ijVar.j() * 1000);
        knVar.b(ijVar.k() * 1000);
        knVar.c(true);
        knVar.a(true);
        knVar.c((ijVar.j() + ijVar.k()) * 1000);
        Map<String, String> mapH = ijVar.h();
        if (mapH != null) {
            for (String str : ijVar.h().keySet()) {
                knVar.a(str, mapH.get(str));
            }
        }
        knVar.b(false);
        knVar.a((kn.a) new kn.a<byte[], String>() { // from class: com.flurry.sdk.ii.2
            @Override // com.flurry.sdk.kn.a
            public void a(kn<byte[], String> knVar2, String str2) {
                kg.a(3, ii.f4303b, "Pulse report to " + ijVar.i() + " for " + ijVar.m() + ", HTTP status code is: " + knVar2.h());
                int iH = knVar2.h();
                ikVar.a((int) knVar2.c());
                ikVar.f4321e = iH;
                if (!knVar2.f()) {
                    Exception excJ = knVar2.j();
                    if (!knVar2.d()) {
                        kg.a(3, ii.f4303b, "Error occured when trying to connect to: " + ijVar.i() + ". Exception: " + excJ.getMessage());
                        ii.this.a(ikVar, ijVar, str2);
                        return;
                    } else {
                        if (knVar2.i()) {
                            kg.a(3, ii.f4303b, "Timeout occured when trying to connect to: " + ijVar.i() + ". Exception: " + knVar2.j().getMessage());
                        } else {
                            kg.a(3, ii.f4303b, "Manually managed http request timeout occured for: " + ijVar.i());
                        }
                        ii.this.b(ikVar, ijVar);
                        return;
                    }
                }
                if (iH >= 200 && iH < 300) {
                    ii.this.a(ikVar, ijVar);
                } else if (iH >= 300 && iH < 400) {
                    ii.this.a(ikVar, ijVar, (kn<?, ?>) knVar2);
                } else {
                    kg.a(3, ii.f4303b, ijVar.m() + " report failed sending to : " + ijVar.i());
                    ii.this.a(ikVar, ijVar, str2);
                }
            }
        });
        jq.a().a(this, knVar);
    }

    @Override // com.flurry.sdk.ks
    protected synchronized void a(List<ij> list) {
        im.a().d();
    }

    @Override // com.flurry.sdk.ks
    protected synchronized void b(List<ij> list) {
        List<in> listE = im.a().e();
        if (listE != null && listE.size() != 0) {
            kg.a(3, f4303b, "Restoring " + listE.size() + " from report queue.");
            Iterator<in> it = listE.iterator();
            while (it.hasNext()) {
                im.a().b(it.next());
            }
            Iterator<in> it2 = im.a().c().iterator();
            while (it2.hasNext()) {
                for (ij ijVar : it2.next().d()) {
                    if (!ijVar.n()) {
                        kg.a(3, f4303b, "Callback for " + ijVar.m() + " to " + ijVar.i() + " not completed.  Adding to reporter queue.");
                        list.add(ijVar);
                    }
                }
            }
        }
    }
}
