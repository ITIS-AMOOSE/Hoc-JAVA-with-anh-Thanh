package baitap.buoi3.util;

import java.text.NumberFormat;
import java.util.Locale;

public final class Formatters {
    private Formatters(){}
    public static String vnd(long v){
        return NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(v);
    }
}
