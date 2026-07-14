package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzc {
    public static CharSequence zza(String str, List<AutocompletePredictionEntity.SubstringEntity> list, CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        for (AutocompletePredictionEntity.SubstringEntity substringEntity : list) {
            spannableString.setSpan(CharacterStyle.wrap(characterStyle), substringEntity.getOffset(), substringEntity.getLength() + substringEntity.getOffset(), 0);
        }
        return spannableString;
    }
}
