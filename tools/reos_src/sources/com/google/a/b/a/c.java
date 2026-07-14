package com.google.a.b.a;

import com.google.a.u;
import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class c extends x<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f5090a = new y() { // from class: com.google.a.b.a.c.1
        @Override // com.google.a.y
        public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f5091b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DateFormat f5092c = DateFormat.getDateTimeInstance(2, 2);

    private synchronized Date a(String str) {
        Date dateA;
        try {
            dateA = this.f5092c.parse(str);
        } catch (ParseException e2) {
            try {
                dateA = this.f5091b.parse(str);
            } catch (ParseException e3) {
                try {
                    dateA = com.google.a.b.a.a.a.a(str, new ParsePosition(0));
                } catch (ParseException e4) {
                    throw new u(str, e4);
                }
            }
        }
        return dateA;
    }

    @Override // com.google.a.x
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date b(com.google.a.d.a aVar) throws IOException {
        if (aVar.f() != com.google.a.d.b.NULL) {
            return a(aVar.h());
        }
        aVar.j();
        return null;
    }

    @Override // com.google.a.x
    public synchronized void a(com.google.a.d.c cVar, Date date) throws IOException {
        try {
            if (date == null) {
                cVar.f();
            } else {
                cVar.b(this.f5091b.format(date));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
