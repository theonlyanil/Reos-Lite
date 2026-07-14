package com.a.a.d.c;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class o implements com.a.a.d.b<InputStream> {
    @Override // com.a.a.d.b
    public String a() {
        return "";
    }

    @Override // com.a.a.d.b
    public boolean a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArrB = com.a.a.j.a.a().b();
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArrB);
                    if (i == -1) {
                        com.a.a.j.a.a().a(bArrB);
                        return true;
                    }
                    outputStream.write(bArrB, 0, i);
                } catch (IOException e2) {
                    if (Log.isLoggable("StreamEncoder", 3)) {
                        Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e2);
                    }
                    com.a.a.j.a.a().a(bArrB);
                    return false;
                }
            } catch (Throwable th) {
                com.a.a.j.a.a().a(bArrB);
                throw th;
            }
            com.a.a.j.a.a().a(bArrB);
            throw th;
        }
    }
}
