package baitap.buoi3.util;

import java.text.Normalizer;
import java.util.Locale;

public final class VnText {
    private VnText(){}
    public static String normalize(String s){
        String lower = s.toLowerCase(Locale.ROOT);
        String temp = Normalizer.normalize(lower, Normalizer.Form.NFD);
        return temp.replaceAll("\\p{M}", "");
    }
}
