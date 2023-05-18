package com.exprogs.numerictotext;

import java.util.HashMap;

public class Constants {
    public static final String SPACE = " ";
    public static final String ZERO = "ноль";
    public static final HashMap<Integer, String> VALUE = new HashMap<>();

    static {
        VALUE.put(1, "один");
        VALUE.put(2, "два");
        VALUE.put(3, "три");
        VALUE.put(4, "четыре");
        VALUE.put(5, "пять");
        VALUE.put(6, "шесть");
        VALUE.put(7, "семь");
        VALUE.put(8, "восемь");
        VALUE.put(9, "девять");
    }

    public static final HashMap<Integer, String> VALUE_MOD = new HashMap<>();

    static {
        VALUE_MOD.put(1, "одна");
        VALUE_MOD.put(2, "две");
        VALUE_MOD.put(3, "три");
        VALUE_MOD.put(4, "четыре");
        VALUE_MOD.put(5, "пять");
        VALUE_MOD.put(6, "шесть");
        VALUE_MOD.put(7, "семь");
        VALUE_MOD.put(8, "восемь");
        VALUE_MOD.put(9, "девять");
    }

    public static final HashMap<Integer, String> VALUE_UNIT_DOUBLE = new HashMap<>();

    static {
        VALUE_UNIT_DOUBLE.put(0, "десять");
        VALUE_UNIT_DOUBLE.put(1, "одиннадцать");
        VALUE_UNIT_DOUBLE.put(2, "двенадцать");
        VALUE_UNIT_DOUBLE.put(3, "тринадцать");
        VALUE_UNIT_DOUBLE.put(4, "четырнадцать");
        VALUE_UNIT_DOUBLE.put(5, "пятнадцать");
        VALUE_UNIT_DOUBLE.put(6, "шестнадцать");
        VALUE_UNIT_DOUBLE.put(7, "семнадцать");
        VALUE_UNIT_DOUBLE.put(8, "восемнадцать");
        VALUE_UNIT_DOUBLE.put(9, "девятнадцать");
    }

    public static final HashMap<Integer, String> VALUE_DOUBLE = new HashMap<>();

    static {
        VALUE_DOUBLE.put(2, "двадцать");
        VALUE_DOUBLE.put(3, "тридцать");
        VALUE_DOUBLE.put(4, "сорок");
        VALUE_DOUBLE.put(5, "пятьдесят");
        VALUE_DOUBLE.put(6, "шестьдесят");
        VALUE_DOUBLE.put(7, "семьдесят");
        VALUE_DOUBLE.put(8, "восемьдесят");
        VALUE_DOUBLE.put(9, "девяносто");
    }

    public static final HashMap<Integer, String> HUNDRED = new HashMap<>();

    static {
        HUNDRED.put(1, "сто");
        HUNDRED.put(2, "двести");
        HUNDRED.put(3, "триста");
        HUNDRED.put(4, "четыреста");
        HUNDRED.put(5, "пятьсот");
        HUNDRED.put(6, "шестьсот");
        HUNDRED.put(7, "семьсот");
        HUNDRED.put(8, "восемьсот");
        HUNDRED.put(9, "девятьсот");
    }

    private static final HashMap<Integer, String> SUFFIX = new HashMap<>();

    static {
        SUFFIX.put(1, "тысяч");
        SUFFIX.put(2, "миллион");
        SUFFIX.put(3, "миллиард");
        SUFFIX.put(4, "триллион");
        SUFFIX.put(5, "квадриллион");
        SUFFIX.put(6, "квинтиллион");
        SUFFIX.put(7, "секстиллион");
    }

    public static final HashMap<Integer, String> SUFFIX_ONE = new HashMap<>();

    static {
        SUFFIX.forEach((key, value) -> {
            if (key == 1)
                SUFFIX_ONE.put(key, value + "а");
            else
                SUFFIX_ONE.put(key, value);
        });
    }

    public static final HashMap<Integer, String> SUFFIX_TWO_FOUR = new HashMap<>();

    static {
        SUFFIX.forEach((key, value) -> {
            if (key == 1)
                SUFFIX_TWO_FOUR.put(key, value + "и");
            else
                SUFFIX_TWO_FOUR.put(key, value + "а");
        });
    }

    public static final HashMap<Integer, String> SUFFIX_FIVE_TO_NINE = new HashMap<>();

    static {
        SUFFIX.forEach((key, value) -> {
            if (key == 1)
                SUFFIX_FIVE_TO_NINE.put(key, value);
            else
                SUFFIX_FIVE_TO_NINE.put(key, value + "ов");
        });
    }
}
