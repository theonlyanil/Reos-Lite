package com.google.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class a implements k<Date>, t<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f5081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f5082b;

    a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    a(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f5081a = dateFormat;
        this.f5082b = dateFormat2;
    }

    private Date a(l lVar) {
        Date dateA;
        synchronized (this.f5082b) {
            try {
                dateA = this.f5082b.parse(lVar.b());
            } catch (ParseException e2) {
                try {
                    dateA = this.f5081a.parse(lVar.b());
                } catch (ParseException e3) {
                    try {
                        dateA = com.google.a.b.a.a.a.a(lVar.b(), new ParsePosition(0));
                    } catch (ParseException e4) {
                        throw new u(lVar.b(), e4);
                    }
                }
            }
        }
        return dateA;
    }

    @Override // com.google.a.t
    public l a(Date date, Type type, s sVar) {
        r rVar;
        synchronized (this.f5082b) {
            rVar = new r(this.f5081a.format(date));
        }
        return rVar;
    }

    @Override // com.google.a.k
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date b(l lVar, Type type, j jVar) throws p {
        if (!(lVar instanceof r)) {
            throw new p("The date should be a string value");
        }
        Date dateA = a(lVar);
        if (type == Date.class) {
            return dateA;
        }
        if (type == Timestamp.class) {
            return new Timestamp(dateA.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(dateA.getTime());
        }
        throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a.class.getSimpleName());
        sb.append('(').append(this.f5082b.getClass().getSimpleName()).append(')');
        return sb.toString();
    }
}
