package com.google.a.b.a;

import com.google.a.n;
import com.google.a.o;
import com.google.a.r;
import com.google.a.u;
import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x<Class> f5129a = new x<Class>() { // from class: com.google.a.b.a.m.31
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Class b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Class cls) throws IOException {
            if (cls != null) {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }
            cVar.f();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f5130b = a(Class.class, f5129a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x<BitSet> f5131c = new x<BitSet>() { // from class: com.google.a.b.a.m.32
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BitSet b(com.google.a.d.a aVar) throws IOException {
            boolean zI;
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            BitSet bitSet = new BitSet();
            aVar.a();
            com.google.a.d.b bVarF = aVar.f();
            int i2 = 0;
            while (bVarF != com.google.a.d.b.END_ARRAY) {
                switch (bVarF) {
                    case NUMBER:
                        zI = aVar.m() != 0;
                        break;
                    case BOOLEAN:
                        zI = aVar.i();
                        break;
                    case STRING:
                        String strH = aVar.h();
                        try {
                            zI = Integer.parseInt(strH) != 0;
                        } catch (NumberFormatException e2) {
                            throw new u("Error: Expecting: bitset number value (1, 0), Found: " + strH);
                        }
                        break;
                    default:
                        throw new u("Invalid bitset value type: " + bVarF);
                }
                if (zI) {
                    bitSet.set(i2);
                }
                i2++;
                bVarF = aVar.f();
            }
            aVar.b();
            return bitSet;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                cVar.f();
                return;
            }
            cVar.b();
            for (int i2 = 0; i2 < bitSet.length(); i2++) {
                cVar.a(bitSet.get(i2) ? 1 : 0);
            }
            cVar.c();
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f5132d = a(BitSet.class, f5131c);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x<Boolean> f5133e = new x<Boolean>() { // from class: com.google.a.b.a.m.33
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return aVar.f() == com.google.a.d.b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.h())) : Boolean.valueOf(aVar.i());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Boolean bool) throws IOException {
            if (bool == null) {
                cVar.f();
            } else {
                cVar.a(bool.booleanValue());
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x<Boolean> f5134f = new x<Boolean>() { // from class: com.google.a.b.a.m.34
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return Boolean.valueOf(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Boolean bool) throws IOException {
            cVar.b(bool == null ? "null" : bool.toString());
        }
    };
    public static final y g = a(Boolean.TYPE, Boolean.class, f5133e);
    public static final x<Number> h = new x<Number>() { // from class: com.google.a.b.a.m.35
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.m());
            } catch (NumberFormatException e2) {
                throw new u(e2);
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final y i = a(Byte.TYPE, Byte.class, h);
    public static final x<Number> j = new x<Number>() { // from class: com.google.a.b.a.m.2
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.m());
            } catch (NumberFormatException e2) {
                throw new u(e2);
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final y k = a(Short.TYPE, Short.class, j);
    public static final x<Number> l = new x<Number>() { // from class: com.google.a.b.a.m.3
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Integer.valueOf(aVar.m());
            } catch (NumberFormatException e2) {
                throw new u(e2);
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final y m = a(Integer.TYPE, Integer.class, l);
    public static final x<AtomicInteger> n = new x<AtomicInteger>() { // from class: com.google.a.b.a.m.1
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(com.google.a.d.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.m());
            } catch (NumberFormatException e2) {
                throw new u(e2);
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.a(atomicInteger.get());
        }
    }.a();
    public static final y o = a(AtomicInteger.class, n);
    public static final x<AtomicBoolean> p = new x<AtomicBoolean>() { // from class: com.google.a.b.a.m.12
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(com.google.a.d.a aVar) throws IOException {
            return new AtomicBoolean(aVar.i());
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.a(atomicBoolean.get());
        }
    }.a();
    public static final y q = a(AtomicBoolean.class, p);
    public static final x<AtomicIntegerArray> r = new x<AtomicIntegerArray>() { // from class: com.google.a.b.a.m.23
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(com.google.a.d.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.e()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.m()));
                } catch (NumberFormatException e2) {
                    throw new u(e2);
                }
            }
            aVar.b();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.b();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.a(atomicIntegerArray.get(i2));
            }
            cVar.c();
        }
    }.a();
    public static final y s = a(AtomicIntegerArray.class, r);
    public static final x<Number> t = new x<Number>() { // from class: com.google.a.b.a.m.4
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Long.valueOf(aVar.l());
            } catch (NumberFormatException e2) {
                throw new u(e2);
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final x<Number> u = new x<Number>() { // from class: com.google.a.b.a.m.5
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return Float.valueOf((float) aVar.k());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final x<Number> v = new x<Number>() { // from class: com.google.a.b.a.m.6
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return Double.valueOf(aVar.k());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final x<Number> w = new x<Number>() { // from class: com.google.a.b.a.m.7
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.a.d.a aVar) throws IOException {
            com.google.a.d.b bVarF = aVar.f();
            switch (bVarF) {
                case NUMBER:
                    return new com.google.a.b.f(aVar.h());
                case BOOLEAN:
                case STRING:
                default:
                    throw new u("Expecting number, got: " + bVarF);
                case NULL:
                    aVar.j();
                    return null;
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final y x = a(Number.class, w);
    public static final x<Character> y = new x<Character>() { // from class: com.google.a.b.a.m.8
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            if (strH.length() != 1) {
                throw new u("Expecting character, got: " + strH);
            }
            return Character.valueOf(strH.charAt(0));
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Character ch) throws IOException {
            cVar.b(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final y z = a(Character.TYPE, Character.class, y);
    public static final x<String> A = new x<String>() { // from class: com.google.a.b.a.m.9
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String b(com.google.a.d.a aVar) throws IOException {
            com.google.a.d.b bVarF = aVar.f();
            if (bVarF != com.google.a.d.b.NULL) {
                return bVarF == com.google.a.d.b.BOOLEAN ? Boolean.toString(aVar.i()) : aVar.h();
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, String str) throws IOException {
            cVar.b(str);
        }
    };
    public static final x<BigDecimal> B = new x<BigDecimal>() { // from class: com.google.a.b.a.m.10
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigDecimal(aVar.h());
            } catch (NumberFormatException e2) {
                throw new u(e2);
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.a(bigDecimal);
        }
    };
    public static final x<BigInteger> C = new x<BigInteger>() { // from class: com.google.a.b.a.m.11
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigInteger(aVar.h());
            } catch (NumberFormatException e2) {
                throw new u(e2);
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, BigInteger bigInteger) throws IOException {
            cVar.a(bigInteger);
        }
    };
    public static final y D = a(String.class, A);
    public static final x<StringBuilder> E = new x<StringBuilder>() { // from class: com.google.a.b.a.m.13
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return new StringBuilder(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, StringBuilder sb) throws IOException {
            cVar.b(sb == null ? null : sb.toString());
        }
    };
    public static final y F = a(StringBuilder.class, E);
    public static final x<StringBuffer> G = new x<StringBuffer>() { // from class: com.google.a.b.a.m.14
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return new StringBuffer(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.b(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final y H = a(StringBuffer.class, G);
    public static final x<URL> I = new x<URL>() { // from class: com.google.a.b.a.m.15
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URL b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            if ("null".equals(strH)) {
                return null;
            }
            return new URL(strH);
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, URL url) throws IOException {
            cVar.b(url == null ? null : url.toExternalForm());
        }
    };
    public static final y J = a(URL.class, I);
    public static final x<URI> K = new x<URI>() { // from class: com.google.a.b.a.m.16
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URI b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                String strH = aVar.h();
                if ("null".equals(strH)) {
                    return null;
                }
                return new URI(strH);
            } catch (URISyntaxException e2) {
                throw new com.google.a.m(e2);
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, URI uri) throws IOException {
            cVar.b(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final y L = a(URI.class, K);
    public static final x<InetAddress> M = new x<InetAddress>() { // from class: com.google.a.b.a.m.17
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InetAddress b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return InetAddress.getByName(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, InetAddress inetAddress) throws IOException {
            cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final y N = b(InetAddress.class, M);
    public static final x<UUID> O = new x<UUID>() { // from class: com.google.a.b.a.m.18
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UUID b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return UUID.fromString(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, UUID uuid) throws IOException {
            cVar.b(uuid == null ? null : uuid.toString());
        }
    };
    public static final y P = a(UUID.class, O);
    public static final x<Currency> Q = new x<Currency>() { // from class: com.google.a.b.a.m.30
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Currency b(com.google.a.d.a aVar) throws IOException {
            return Currency.getInstance(aVar.h());
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Currency currency) throws IOException {
            cVar.b(currency.getCurrencyCode());
        }
    }.a();
    public static final y R = a(Currency.class, Q);
    public static final y S = new y() { // from class: com.google.a.b.a.m.19
        @Override // com.google.a.y
        public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            final x<T> xVarA = fVar.a((Class) Date.class);
            return (x<T>) new x<Timestamp>() { // from class: com.google.a.b.a.m.19.1
                @Override // com.google.a.x
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Timestamp b(com.google.a.d.a aVar2) throws IOException {
                    Date date = (Date) xVarA.b(aVar2);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.a.x
                public void a(com.google.a.d.c cVar, Timestamp timestamp) throws IOException {
                    xVarA.a(cVar, timestamp);
                }
            };
        }
    };
    public static final x<Calendar> T = new x<Calendar>() { // from class: com.google.a.b.a.m.20
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar b(com.google.a.d.a aVar) throws IOException {
            int i2 = 0;
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            aVar.c();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.f() != com.google.a.d.b.END_OBJECT) {
                String strG = aVar.g();
                int iM = aVar.m();
                if ("year".equals(strG)) {
                    i7 = iM;
                } else if ("month".equals(strG)) {
                    i6 = iM;
                } else if ("dayOfMonth".equals(strG)) {
                    i5 = iM;
                } else if ("hourOfDay".equals(strG)) {
                    i4 = iM;
                } else if ("minute".equals(strG)) {
                    i3 = iM;
                } else if ("second".equals(strG)) {
                    i2 = iM;
                }
            }
            aVar.d();
            return new GregorianCalendar(i7, i6, i5, i4, i3, i2);
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.f();
                return;
            }
            cVar.d();
            cVar.a("year");
            cVar.a(calendar.get(1));
            cVar.a("month");
            cVar.a(calendar.get(2));
            cVar.a("dayOfMonth");
            cVar.a(calendar.get(5));
            cVar.a("hourOfDay");
            cVar.a(calendar.get(11));
            cVar.a("minute");
            cVar.a(calendar.get(12));
            cVar.a("second");
            cVar.a(calendar.get(13));
            cVar.e();
        }
    };
    public static final y U = b(Calendar.class, GregorianCalendar.class, T);
    public static final x<Locale> V = new x<Locale>() { // from class: com.google.a.b.a.m.21
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Locale b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Locale locale) throws IOException {
            cVar.b(locale == null ? null : locale.toString());
        }
    };
    public static final y W = a(Locale.class, V);
    public static final x<com.google.a.l> X = new x<com.google.a.l>() { // from class: com.google.a.b.a.m.22
        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.a.l b(com.google.a.d.a aVar) throws IOException {
            switch (AnonymousClass29.f5149a[aVar.f().ordinal()]) {
                case 1:
                    return new r(new com.google.a.b.f(aVar.h()));
                case 2:
                    return new r(Boolean.valueOf(aVar.i()));
                case 3:
                    return new r(aVar.h());
                case 4:
                    aVar.j();
                    return n.f5272a;
                case 5:
                    com.google.a.i iVar = new com.google.a.i();
                    aVar.a();
                    while (aVar.e()) {
                        iVar.a(b(aVar));
                    }
                    aVar.b();
                    return iVar;
                case 6:
                    o oVar = new o();
                    aVar.c();
                    while (aVar.e()) {
                        oVar.a(aVar.g(), b(aVar));
                    }
                    aVar.d();
                    return oVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, com.google.a.l lVar) throws IOException {
            if (lVar == null || lVar.j()) {
                cVar.f();
                return;
            }
            if (lVar.i()) {
                r rVarM = lVar.m();
                if (rVarM.p()) {
                    cVar.a(rVarM.a());
                    return;
                } else if (rVarM.o()) {
                    cVar.a(rVarM.f());
                    return;
                } else {
                    cVar.b(rVarM.b());
                    return;
                }
            }
            if (lVar.g()) {
                cVar.b();
                Iterator<com.google.a.l> it = lVar.l().iterator();
                while (it.hasNext()) {
                    a(cVar, it.next());
                }
                cVar.c();
                return;
            }
            if (!lVar.h()) {
                throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
            }
            cVar.d();
            for (Map.Entry<String, com.google.a.l> entry : lVar.k().o()) {
                cVar.a(entry.getKey());
                a(cVar, entry.getValue());
            }
            cVar.e();
        }
    };
    public static final y Y = b(com.google.a.l.class, X);
    public static final y Z = new y() { // from class: com.google.a.b.a.m.24
        @Override // com.google.a.y
        public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new a(rawType);
        }
    };

    private static final class a<T extends Enum<T>> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, T> f5150a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<T, String> f5151b = new HashMap();

        public a(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    com.google.a.a.c cVar = (com.google.a.a.c) cls.getField(strName).getAnnotation(com.google.a.a.c.class);
                    if (cVar != null) {
                        strName = cVar.a();
                        String[] strArrB = cVar.b();
                        for (String str : strArrB) {
                            this.f5150a.put(str, t);
                        }
                    }
                    String str2 = strName;
                    this.f5150a.put(str2, t);
                    this.f5151b.put(t, str2);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError("Missing field in " + cls.getName(), e2);
            }
        }

        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public T b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return this.f5150a.get(aVar.h());
            }
            aVar.j();
            return null;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, T t) throws IOException {
            cVar.b(t == null ? null : this.f5151b.get(t));
        }
    }

    public static <TT> y a(final Class<TT> cls, final x<TT> xVar) {
        return new y() { // from class: com.google.a.b.a.m.25
            @Override // com.google.a.y
            public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
                if (aVar.getRawType() == cls) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + xVar + "]";
            }
        };
    }

    public static <TT> y a(final Class<TT> cls, final Class<TT> cls2, final x<? super TT> xVar) {
        return new y() { // from class: com.google.a.b.a.m.26
            @Override // com.google.a.y
            public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + xVar + "]";
            }
        };
    }

    public static <T1> y b(final Class<T1> cls, final x<T1> xVar) {
        return new y() { // from class: com.google.a.b.a.m.28
            @Override // com.google.a.y
            public <T2> x<T2> a(com.google.a.f fVar, com.google.a.c.a<T2> aVar) {
                final Class<? super T2> rawType = aVar.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return (x<T2>) new x<T1>() { // from class: com.google.a.b.a.m.28.1
                        @Override // com.google.a.x
                        public void a(com.google.a.d.c cVar, T1 t1) throws IOException {
                            xVar.a(cVar, t1);
                        }

                        @Override // com.google.a.x
                        public T1 b(com.google.a.d.a aVar2) throws IOException {
                            T1 t1 = (T1) xVar.b(aVar2);
                            if (t1 == null || rawType.isInstance(t1)) {
                                return t1;
                            }
                            throw new u("Expected a " + rawType.getName() + " but was " + t1.getClass().getName());
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + xVar + "]";
            }
        };
    }

    public static <TT> y b(final Class<TT> cls, final Class<? extends TT> cls2, final x<? super TT> xVar) {
        return new y() { // from class: com.google.a.b.a.m.27
            @Override // com.google.a.y
            public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + xVar + "]";
            }
        };
    }
}
