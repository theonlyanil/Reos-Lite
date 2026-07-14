package com.google.a.b.a;

import com.google.a.u;
import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class k extends x<Time> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f5124a = new y() { // from class: com.google.a.b.a.k.1
        @Override // com.google.a.y
        public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new k();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f5125b = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.a.x
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Time b(com.google.a.d.a aVar) throws IOException {
        Time time;
        if (aVar.f() == com.google.a.d.b.NULL) {
            aVar.j();
            time = null;
        } else {
            try {
                time = new Time(this.f5125b.parse(aVar.h()).getTime());
            } catch (ParseException e2) {
                throw new u(e2);
            }
        }
        return time;
    }

    @Override // com.google.a.x
    public synchronized void a(com.google.a.d.c cVar, Time time) throws IOException {
        cVar.b(time == null ? null : this.f5125b.format((Date) time));
    }
}
