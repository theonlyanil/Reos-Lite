package com.google.a.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f5086a = TimeZone.getTimeZone("UTC");

    private static int a(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static int a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i4 = 0;
        if (i < i2) {
            i3 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -iDigit;
        } else {
            i3 = i;
        }
        while (i3 < i2) {
            int i5 = i3 + 1;
            int iDigit2 = Character.digit(str.charAt(i3), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - iDigit2;
            i3 = i5;
        }
        return -i4;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x0221  */
    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
        Exception exc;
        String str2;
        String message;
        int i;
        int i2;
        int i3;
        int i4;
        int length;
        TimeZone timeZone;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int iA = a(str, index, i5);
            int i6 = a(str, i5, '-') ? i5 + 1 : i5;
            int i7 = i6 + 2;
            int iA2 = a(str, i6, i7);
            int i8 = a(str, i7, '-') ? i7 + 1 : i7;
            int i9 = i8 + 2;
            int iA3 = a(str, i8, i9);
            boolean zA = a(str, i9, 'T');
            if (!zA && str.length() <= i9) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iA, iA2 - 1, iA3);
                parsePosition.setIndex(i9);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i10 = i9 + 1;
                int i11 = i10 + 2;
                int iA4 = a(str, i10, i11);
                int i12 = a(str, i11, ':') ? i11 + 1 : i11;
                i9 = i12 + 2;
                int iA5 = a(str, i12, i9);
                if (a(str, i9, ':')) {
                    i9++;
                }
                if (str.length() <= i9 || (cCharAt = str.charAt(i9)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i3 = iA5;
                    i4 = iA4;
                    i = 0;
                    i2 = 0;
                } else {
                    int i13 = i9 + 2;
                    int iA6 = a(str, i9, i13);
                    if (iA6 > 59 && iA6 < 63) {
                        iA6 = 59;
                    }
                    if (a(str, i13, '.')) {
                        int i14 = i13 + 1;
                        int iA7 = a(str, i14 + 1);
                        int iMin = Math.min(iA7, i14 + 3);
                        int iA8 = a(str, i14, iMin);
                        switch (iMin - i14) {
                            case 1:
                                iA8 *= 100;
                                break;
                            case 2:
                                iA8 *= 10;
                                break;
                        }
                        i4 = iA4;
                        i2 = iA6;
                        i9 = iA7;
                        i3 = iA5;
                        i = iA8;
                    } else {
                        i4 = iA4;
                        i2 = iA6;
                        i9 = i13;
                        i3 = iA5;
                        i = 0;
                    }
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            if (str.length() <= i9) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i9);
            if (cCharAt2 == 'Z') {
                timeZone = f5086a;
                length = i9 + 1;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i9);
                if (strSubstring.length() < 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i9 + strSubstring.length();
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = f5086a;
                } else {
                    String str3 = "GMT" + strSubstring;
                    timeZone = TimeZone.getTimeZone(str3);
                    String id = timeZone.getID();
                    if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone.getID());
                    }
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, iA);
            gregorianCalendar2.set(2, iA2 - 1);
            gregorianCalendar2.set(5, iA3);
            gregorianCalendar2.set(11, i4);
            gregorianCalendar2.set(12, i3);
            gregorianCalendar2.set(13, i2);
            gregorianCalendar2.set(14, i);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (NumberFormatException e2) {
            exc = e2;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + "'";
            }
            message = exc.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + exc.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(exc);
            throw parseException;
        } catch (IllegalArgumentException e3) {
            exc = e3;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + "'";
            }
            message = exc.getMessage();
            if (message != null) {
                message = "(" + exc.getClass().getName() + ")";
            } else {
                message = "(" + exc.getClass().getName() + ")";
            }
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(exc);
            throw parseException2;
        } catch (IndexOutOfBoundsException e4) {
            exc = e4;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + "'";
            }
            message = exc.getMessage();
            if (message != null) {
                message = "(" + exc.getClass().getName() + ")";
            } else {
                message = "(" + exc.getClass().getName() + ")";
            }
            ParseException parseException3 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException3.initCause(exc);
            throw parseException3;
        }
    }

    private static boolean a(String str, int i, char c2) {
        return i < str.length() && str.charAt(i) == c2;
    }
}
