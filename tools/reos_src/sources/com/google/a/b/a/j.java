package com.google.a.b.a;

import com.google.a.u;
import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class j extends x<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f5122a = new y() { // from class: com.google.a.b.a.j.1
        @Override // com.google.a.y
        public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new j();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f5123b = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.a.x
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Date b(com.google.a.d.a aVar) throws IOException {
        Date date;
        if (aVar.f() == com.google.a.d.b.NULL) {
            aVar.j();
            date = null;
        } else {
            try {
                date = new Date(this.f5123b.parse(aVar.h()).getTime());
            } catch (ParseException e2) {
                throw new u(e2);
            }
        }
        return date;
    }

    @Override // com.google.a.x
    public synchronized void a(com.google.a.d.c cVar, Date date) throws IOException {
        cVar.b(date == null ? null : this.f5123b.format((java.util.Date) date));
    }
}
