package com.google.a;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    public l a(com.google.a.d.a aVar) throws m, u {
        boolean zP = aVar.p();
        aVar.a(true);
        try {
            try {
                try {
                    l lVarA = com.google.a.b.j.a(aVar);
                    aVar.a(zP);
                    return lVarA;
                } catch (OutOfMemoryError e2) {
                    throw new p("Failed parsing JSON source: " + aVar + " to Json", e2);
                }
            } catch (StackOverflowError e3) {
                throw new p("Failed parsing JSON source: " + aVar + " to Json", e3);
            }
        } catch (Throwable th) {
            aVar.a(zP);
            throw th;
        }
    }

    public l a(Reader reader) throws m, u {
        try {
            com.google.a.d.a aVar = new com.google.a.d.a(reader);
            l lVarA = a(aVar);
            if (lVarA.j() || aVar.f() == com.google.a.d.b.END_DOCUMENT) {
                return lVarA;
            }
            throw new u("Did not consume the entire document.");
        } catch (com.google.a.d.d e2) {
            throw new u(e2);
        } catch (IOException e3) {
            throw new m(e3);
        } catch (NumberFormatException e4) {
            throw new u(e4);
        }
    }

    public l a(String str) throws u {
        return a(new StringReader(str));
    }
}
